package net.zetetic.database.sqlcipher;

import android.database.CursorWindow;
import android.database.sqlite.SQLiteBindOrColumnIndexOutOfRangeException;
import android.database.sqlite.SQLiteException;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import android.util.Log;
import android.util.LruCache;
import android.util.Printer;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import net.zetetic.database.DatabaseUtils;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes6.dex */
public final class SQLiteConnection implements CancellationSignal.OnCancelListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean DEBUG = false;
    private static final byte[] EMPTY_BYTE_ARRAY = null;
    private static final String[] EMPTY_STRING_ARRAY = null;
    private static final String TAG = "SQLiteConnection";
    private int mCancellationSignalAttachCount;
    private final CloseGuard mCloseGuard;
    private final SQLiteDatabaseConfiguration mConfiguration;
    private final int mConnectionId;
    private long mConnectionPtr;
    private final boolean mIsPrimaryConnection;
    private final boolean mIsReadOnlyConnection;
    private boolean mOnlyAllowReadOnlyOperations;
    private final SQLiteConnectionPool mPool;
    private final PreparedStatementCache mPreparedStatementCache;
    private PreparedStatement mPreparedStatementPool;
    private final OperationLog mRecentOperations;

    /* JADX INFO: renamed from: net.zetetic.database.sqlcipher.SQLiteConnection$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class Operation {
        private static final int MAX_TRACE_METHOD_NAME_LEN = 256;
        public ArrayList<Object> mBindArgs;
        public int mCookie;
        public long mEndTime;
        public Exception mException;
        public boolean mFinished;
        public String mKind;
        public String mSql;
        public long mStartTime;
        public long mStartWallTime;

        private Operation() {
        }

        /* synthetic */ Operation(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ String access$600(Operation r0) {
            return r0.getFormattedStartTime();
        }

        private String getFormattedStartTime() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(this.mStartWallTime));
        }

        private String getStatus() {
            if (this.mFinished == true) goto L7;
            return "running";
        L7:
            if (this.mException == null) goto L9;
            return "failed";
        L9:
            return "succeeded";
        }

        private String getTraceMethodName() {
            String r2 = this.mKind + " " + this.mSql;
            if (r2.length() > 256) goto L5;
            return r2;
        L5:
            return r2.substring(0, 256);
        }

        public void describe(StringBuilder r7, boolean r8) {
            r7.append(this.mKind);
            if (this.mFinished == false) goto L5;
            StringBuilder r0 = r7.append(" took ").append(this.mEndTime - this.mStartTime);
            String r1 = "ms";
        L6:
            r0.append(r1);
            r7.append(" - ").append(getStatus());
            if (this.mSql == null) goto L9;
            r7.append(", sql=\"").append(SQLiteConnection.access$300(this.mSql)).append("\"");
        L9:
            if (r8 == false) goto L32;
            ArrayList<Object> r9 = this.mBindArgs;
            if (r9 == null) goto L32;
            if (r9.size() == 0) goto L32;
            r7.append(", bindArgs=[");
            int r10 = this.mBindArgs.size();
            int r2 = 0;
        L15:
            if (r2 >= r10) goto L30;
            Object r3 = this.mBindArgs.get(r2);
            if (r2 == 0) goto L19;
            r7.append(", ");
        L19:
            if (r3 != null) goto L23;
            String r4 = "null";
        L21:
            r7.append(r4);
        L29:
            r2 = r2 + 1;
            goto L15
        L23:
            if ((r3 instanceof byte[]) == false) goto L26;
            r4 = "<byte[]>";
            goto L21
        L26:
            if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L28;
            r7.append("\"").append((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin")).append("\"");
            goto L29
        L28:
            r7.append(r3);
            goto L29
        L30:
            r7.append("]");
        L32:
            if (this.mException == null) goto L39;
            r7.append(", exception=\"").append(this.mException.getMessage()).append("\"");
            return;
        L39:
            return;
        L5:
            r0 = r7.append(" started ").append(System.currentTimeMillis() - this.mStartWallTime);
            r1 = "ms ago";
            goto L6
        }
    }

    private static final class OperationLog {
        private static final int COOKIE_GENERATION_SHIFT = 8;
        private static final int COOKIE_INDEX_MASK = 255;
        private static final int MAX_RECENT_OPERATIONS = 20;
        private int mGeneration;
        private int mIndex;
        private final Operation[] mOperations;

        private OperationLog() {
            this.mOperations = new Operation[20];
        }

        /* synthetic */ OperationLog(AnonymousClass1 r1) {
            this();
        }

        private boolean endOperationDeferLogLocked(int r3) {
            Operation r2 = getOperationLocked(r3);
            if (r2 == null) goto L5;
            r2.mEndTime = SystemClock.uptimeMillis();
            r2.mFinished = true;
        L5:
            return false;
        }

        private Operation getOperationLocked(int r2) {
            Operation[] r1 = this.mOperations;
            Operation r3 = r1[r2 & 255];
            if (r3.mCookie == r2) goto L7;
            return null;
        L7:
            return r3;
        }

        private void logOperationLocked(int r2, String r3) {
            Operation r1 = getOperationLocked(r2);
            StringBuilder r4 = new StringBuilder();
            r1.describe(r4, false);
            if (r3 == null) goto L5;
            r4.append(", ").append(r3);
        L5:
            Log.d(SQLiteConnection.TAG, r4.toString());
        }

        private int newOperationCookieLocked(int r3) {
            int r0 = this.mGeneration;
            this.mGeneration = r0 + 1;
            return (r0 << 8) | r3;
        }

        public int beginOperation(String r8, String r9, Object[] r10) {
            Operation[] r0 = this.mOperations;
            monitor-enter(r0);
            int r1 = (this.mIndex + 1) % 20;     // Catch: Throwable -> L28
            Operation r2 = this.mOperations[r1];     // Catch: Throwable -> L28
            AnonymousClass1 r3 = null;
            int r4 = 0;
            if (r2 != null) goto L7;
            r2 = new Operation(r3);     // Catch: Throwable -> L28
            this.mOperations[r1] = r2;     // Catch: Throwable -> L28
        L10:
            r2.mStartWallTime = System.currentTimeMillis();     // Catch: Throwable -> L28
            r2.mStartTime = SystemClock.uptimeMillis();     // Catch: Throwable -> L28
            r2.mKind = r8;     // Catch: Throwable -> L28
            r2.mSql = r9;     // Catch: Throwable -> L28
            if (r10 != null) goto L13;
        L25:
            r2.mCookie = newOperationCookieLocked(r1);     // Catch: Throwable -> L28
            this.mIndex = r1;     // Catch: Throwable -> L28
            int r7 = r2.mCookie;     // Catch: Throwable -> L28
            monitor-exit(r0);     // Catch: Throwable -> L28
            return r7;
        L13:
            if (r2.mBindArgs != null) goto L15;
            r2.mBindArgs = new ArrayList();     // Catch: Throwable -> L28
        L17:
            if (r4 >= r10.length) goto L25;
            Object r11 = r10[r4];     // Catch: Throwable -> L28
            if (r11 != null) goto L21;
        L23:
            r2.mBindArgs.add(r11);     // Catch: Throwable -> L28
        L24:
            r4 = r4 + 1;     // Catch: Throwable -> L28
            goto L17
        L21:
            if ((r11 instanceof byte[]) == false) goto L23;
            r2.mBindArgs.add(SQLiteConnection.access$500());     // Catch: Throwable -> L28
            goto L24
        L15:
            r2.mBindArgs.clear();     // Catch: Throwable -> L28
            goto L17
        L7:
            r2.mFinished = false;     // Catch: Throwable -> L28
            r2.mException = null;     // Catch: Throwable -> L28
            if (r2.mBindArgs == null) goto L10;
            r2.mBindArgs.clear();     // Catch: Throwable -> L28
        L28:
            th = move-exception;
            throw th;
        }

        public String describeCurrentOperation() {
            Operation[] r0 = this.mOperations;
            monitor-enter(r0);
            Operation r3 = this.mOperations[this.mIndex];     // Catch: Throwable -> L14
            if (r3 == null) goto L12;
            if (r3.mFinished == true) goto L12;
            StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L14
            r3.describe(r1, false);     // Catch: Throwable -> L14
            String r4 = r1.toString();     // Catch: Throwable -> L14
            monitor-exit(r0);     // Catch: Throwable -> L14
            return r4;
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L14
            return null;
        L14:
            th = move-exception;
            throw th;
        }

        public void dump(Printer r8, boolean r9) {
            Printer r10 = (Printer) ZeusTransformUtils.wrapperContextForParams(r8, Printer.class, "com.obric.memorydata.plugin");
            Operation[] r0 = this.mOperations;
            monitor-enter(r0);
            r10.println("  Most recently executed operations:");     // Catch: Throwable -> L19
            int r1 = this.mIndex;     // Catch: Throwable -> L19
            Operation r2 = this.mOperations[r1];     // Catch: Throwable -> L19
            if (r2 == null) goto L16;
            int r3 = 0;
        L7:
            StringBuilder r4 = new StringBuilder();     // Catch: Throwable -> L19
            r4.append("    ").append(r3).append(": [");     // Catch: Throwable -> L19
            r4.append(Operation.access$600(r2));     // Catch: Throwable -> L19
            r4.append("] ");     // Catch: Throwable -> L19
            r2.describe(r4, r9);     // Catch: Throwable -> L19
            r10.println(r4.toString());     // Catch: Throwable -> L19
            if (r1 <= 0) goto L10;
            r1 = r1 - 1;     // Catch: Throwable -> L19
        L11:
            r3 = r3 + 1;     // Catch: Throwable -> L19
            r2 = this.mOperations[r1];     // Catch: Throwable -> L19
            if (r2 == null) goto L17;
            if (r3 < 20) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L19
            return;
        L10:
            r1 = 19;
            goto L11
        L16:
            r10.println("    <none>");     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            throw th;
        }

        public void endOperation(int r3) {
            Operation[] r0 = this.mOperations;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (endOperationDeferLogLocked(r3) == false) goto L7;
            logOperationLocked(r3, null);     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
        }

        public boolean endOperationDeferLog(int r2) {
            Operation[] r0 = this.mOperations;
            monitor-enter(r0);
            boolean r1 = endOperationDeferLogLocked(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void failOperation(int r2, Exception r3) {
            Operation[] r0 = this.mOperations;
            monitor-enter(r0);
            Operation r1 = getOperationLocked(r2);     // Catch: Throwable -> L9
            if (r1 == null) goto L7;
            r1.mException = r3;     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public void logOperation(int r2, String r3) {
            Operation[] r0 = this.mOperations;
            monitor-enter(r0);
            logOperationLocked(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private static final class PreparedStatement {
        public boolean mInCache;
        public boolean mInUse;
        public int mNumParameters;
        public PreparedStatement mPoolNext;
        public boolean mReadOnly;
        public String mSql;
        public long mStatementPtr;
        public int mType;

        private PreparedStatement() {
        }

        /* synthetic */ PreparedStatement(AnonymousClass1 r1) {
            this();
        }
    }

    private final class PreparedStatementCache extends LruCache<String, PreparedStatement> {
        final /* synthetic */ SQLiteConnection this$0;

        public PreparedStatementCache(SQLiteConnection r1, int r2) {
            this.this$0 = r1;
            super(r2);
        }

        public void dump(Printer r8) {
            Printer r9 = (Printer) ZeusTransformUtils.wrapperContextForParams(r8, Printer.class, "com.obric.memorydata.plugin");
            r9.println("  Prepared statement cache:");
            Map<String, PreparedStatement> r7 = snapshot();
            if (r7.isEmpty() == true) goto L11;
            int r0 = 0;
            Iterator<Map.Entry<String, PreparedStatement>> r10 = r7.entrySet().iterator();
        L6:
            if (r10.hasNext() == false) goto L16;
            Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            PreparedStatement r3 = (PreparedStatement) ZeusTransformUtils.preCheckCast(r2.getValue(), PreparedStatement.class, "com.obric.memorydata.plugin");
            if (r3.mInCache == false) goto L10;
            r9.println("    " + r0 + ": statementPtr=0x" + Long.toHexString(r3.mStatementPtr) + ", numParameters=" + r3.mNumParameters + ", type=" + r3.mType + ", readOnly=" + r3.mReadOnly + ", sql=\"" + SQLiteConnection.access$300((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin")) + "\"");
        L10:
            r0 = r0 + 1;
            goto L6
        L16:
            return;
        L11:
            r9.println("    <none>");
        }

        @Override // android.util.LruCache
        public /* synthetic */ void entryRemoved(boolean r3, String r4, PreparedStatement r5, PreparedStatement r6) {
            entryRemoved2(r3, (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"), (PreparedStatement) ZeusTransformUtils.preCheckCast(r5, PreparedStatement.class, "com.obric.memorydata.plugin"), (PreparedStatement) ZeusTransformUtils.preCheckCast(r6, PreparedStatement.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: entryRemoved, reason: avoid collision after fix types in other method */
        public void entryRemoved2(boolean r1, String r2, PreparedStatement r3, PreparedStatement r4) {
            r3.mInCache = false;
            if (r3.mInUse == true) goto L6;
            SQLiteConnection.access$200(this.this$0, r3);
            return;
        }
    }

    static {
        EMPTY_STRING_ARRAY = new String[0];
        EMPTY_BYTE_ARRAY = new byte[0];
    }

    private SQLiteConnection(SQLiteConnectionPool r4, SQLiteDatabaseConfiguration r5, int r6, boolean r7) {
        CloseGuard r0 = CloseGuard.get();
        this.mCloseGuard = r0;
        this.mRecentOperations = new OperationLog(null);
        this.mPool = r4;
        SQLiteDatabaseConfiguration r8 = new SQLiteDatabaseConfiguration(r5);
        this.mConfiguration = r8;
        this.mConnectionId = r6;
        this.mIsPrimaryConnection = r7;
        boolean r9 = true;
        if ((r5.openFlags & 1) != 0) goto L6;
        r9 = false;
    L6:
        this.mIsReadOnlyConnection = r9;
        this.mPreparedStatementCache = new PreparedStatementCache(this, r8.maxSqlCacheSize);
        r0.open(IslandSession.REOPEN_VALUE_CLOSE);
    }

    static /* synthetic */ void access$200(SQLiteConnection r0, PreparedStatement r1) {
        r0.finalizePreparedStatement(r1);
    }

    static /* synthetic */ String access$300(String r0) {
        return trimSqlForDisplay(r0);
    }

    static /* synthetic */ byte[] access$500() {
        return EMPTY_BYTE_ARRAY;
    }

    private PreparedStatement acquirePreparedStatement(String r14) {
        PreparedStatement r0 = (PreparedStatement) ZeusTransformUtils.preCheckCast(this.mPreparedStatementCache.get(r14), PreparedStatement.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        boolean r2 = false;
    L9:
        long r3 = nativePrepareStatement(this.mConnectionPtr, r14);
        int r9 = nativeGetParameterCount(this.mConnectionPtr, r3);     // Catch: RuntimeException -> L17
        int r12 = DatabaseUtils.a(r14);     // Catch: RuntimeException -> L17
        r0 = obtainPreparedStatement(r14, r3, r9, r12, nativeIsReadOnly(this.mConnectionPtr, r3));     // Catch: RuntimeException -> L17
        if (r2 == false) goto L13;
    L15:
        r0.mInUse = true;
        return r0;
    L13:
        if (isCacheable(r12) == false) goto L15;
        this.mPreparedStatementCache.put(r14, r0);     // Catch: RuntimeException -> L17
        r0.mInCache = true;     // Catch: RuntimeException -> L17
    L17:
        e = move-exception;
        if (r0 != null) goto L20;
    L21:
        nativeFinalizeStatement(this.mConnectionPtr, r3);
    L22:
        throw e;
    L20:
        if (r0.mInCache == true) goto L22;
    L5:
        if (r0.mInUse == true) goto L7;
        return r0;
    L7:
        r2 = true;
        goto L9
    }

    private void applyBlockGuardPolicy(PreparedStatement r1) {
    }

    private void attachCancellationSignal(CancellationSignal r5) {
        if (r5 == null) goto L7;
        r5.throwIfCanceled();
        int r0 = this.mCancellationSignalAttachCount + 1;
        this.mCancellationSignalAttachCount = r0;
        if (r0 != 1) goto L8;
        nativeResetCancel(this.mConnectionPtr, true);
        r5.setOnCancelListener(this);
        return;
    L8:
        return;
    }

    private void bindArguments(PreparedStatement r13, Object[] r14) {
        int r0 = 0;
        if (r14 == null) goto L5;
        int r1 = r14.length;
    L7:
        if (r1 != r13.mNumParameters) goto L36;
        if (r1 != 0) goto L10;
        return;
    L10:
        long r10 = r13.mStatementPtr;
    L11:
        if (r0 >= r1) goto L34;
        Object r15 = r14[r0];
        int r2 = DatabaseUtils.a(r15);
        if (r2 != 0) goto L15;
        nativeBindNull(this.mConnectionPtr, r10, r0 + 1);
    L33:
        r0 = r0 + 1;
        goto L11
    L15:
        if (r2 != 1) goto L17;
        long r4 = this.mConnectionPtr;
        int r7 = r0 + 1;
        long r8 = ((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.memorydata.plugin")).longValue();
    L31:
        nativeBindLong(r4, r10, r7, r8);
        goto L33
    L17:
        if (r2 != 2) goto L19;
        nativeBindDouble(this.mConnectionPtr, r10, r0 + 1, ((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.memorydata.plugin")).doubleValue());
        goto L33
    L19:
        if (r2 != 4) goto L21;
        nativeBindBlob(this.mConnectionPtr, r10, r0 + 1, (byte[]) ZeusTransformUtils.preCheckCast(r15, byte[].class, "com.obric.memorydata.plugin"));
        goto L33
    L21:
        if (ZeusTransformUtils.instanceOf(r15, Boolean.class) == false) goto L27;
        r4 = this.mConnectionPtr;
        r7 = r0 + 1;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L25;
        long r3 = 1;
    L26:
        r8 = r3;
        goto L31
    L25:
        r3 = 0;
        goto L26
    L27:
        nativeBindString(this.mConnectionPtr, r10, r0 + 1, r15.toString());
        goto L33
    L34:
        return;
    L36:
        throw new SQLiteBindOrColumnIndexOutOfRangeException("Expected " + r13.mNumParameters + " bind arguments but " + r1 + " were provided.");
    L5:
        r1 = 0;
        goto L7
    }

    private static String canonicalizeSyncMode(String r1) {
        if (r1.equals("0") == false) goto L7;
        return "OFF";
    L7:
        if (r1.equals("1") == false) goto L11;
        return "NORMAL";
    L11:
        if (r1.equals("2") == false) goto L14;
        return "FULL";
    L14:
        return r1;
    }

    private void detachCancellationSignal(CancellationSignal r2) {
        if (r2 == null) goto L7;
        int r0 = this.mCancellationSignalAttachCount - 1;
        this.mCancellationSignalAttachCount = r0;
        if (r0 != 0) goto L8;
        r2.setOnCancelListener(null);
        nativeResetCancel(this.mConnectionPtr, false);
        return;
    L8:
        return;
    }

    private void dispose(boolean r5) {
        CloseGuard r0 = this.mCloseGuard;
        if (r0 == null) goto L8;
        if (r5 == false) goto L6;
        r0.warnIfOpen();
    L6:
        this.mCloseGuard.close();
    L8:
        if (this.mConnectionPtr == 0) goto L15;
        int r6 = this.mRecentOperations.beginOperation(IslandSession.REOPEN_VALUE_CLOSE, null, null);
        this.mPreparedStatementCache.evictAll();     // Catch: Throwable -> L12
        nativeClose(this.mConnectionPtr);     // Catch: Throwable -> L12
        this.mConnectionPtr = 0;     // Catch: Throwable -> L12
        this.mRecentOperations.endOperation(r6);
        return;
    L12:
        th = move-exception;
        this.mRecentOperations.endOperation(r6);
        throw th;
    }

    private void finalizePreparedStatement(PreparedStatement r5) {
        nativeFinalizeStatement(this.mConnectionPtr, r5.mStatementPtr);
        recyclePreparedStatement(r5);
    }

    private SQLiteDebug.DbStats getMainDbStatsUnsafe(int r13, long r14, long r16) {
        String r1 = this.mConfiguration.path;
        if (this.mIsPrimaryConnection == true) goto L6;
        r1 = r1 + " (" + this.mConnectionId + ")";
    L6:
        return new SQLiteDebug.DbStats(r1, r14, r16, r13, this.mPreparedStatementCache.hitCount(), this.mPreparedStatementCache.missCount(), this.mPreparedStatementCache.size());
    }

    public static boolean hasCodec() {
        return nativeHasCodec();
    }

    private static boolean isCacheable(int r2) {
        if (r2 == 2) goto L8;
        if (r2 == 1) goto L8;
        return false;
    L8:
        return true;
    }

    private static native void nativeBindBlob(long r0, long r2, int r4, byte[] r5);

    private static native void nativeBindDouble(long r0, long r2, int r4, double r5);

    private static native void nativeBindLong(long r0, long r2, int r4, long r5);

    private static native void nativeBindNull(long r0, long r2, int r4);

    private static native void nativeBindString(long r0, long r2, int r4, String r5);

    private static native void nativeCancel(long r0);

    private static native void nativeClose(long r0);

    private static native void nativeExecute(long r0, long r2);

    private static native int nativeExecuteForBlobFileDescriptor(long r0, long r2);

    private static native int nativeExecuteForChangedRowCount(long r0, long r2);

    private static native long nativeExecuteForCursorWindow(long r0, long r2, CursorWindow r4, int r5, int r6, boolean r7);

    private static native long nativeExecuteForLastInsertedRowId(long r0, long r2);

    private static native long nativeExecuteForLong(long r0, long r2);

    private static native String nativeExecuteForString(long r0, long r2);

    private static native void nativeExecuteRaw(long r0, long r2);

    private static native void nativeFinalizeStatement(long r0, long r2);

    private static native int nativeGetColumnCount(long r0, long r2);

    private static native String nativeGetColumnName(long r0, long r2, int r4);

    private static native int nativeGetDbLookaside(long r0);

    private static native int nativeGetParameterCount(long r0, long r2);

    private static native boolean nativeHasCodec();

    private static native boolean nativeIsReadOnly(long r0, long r2);

    private static native int nativeKey(long r0, byte[] r2);

    private static native long nativeOpen(String r0, int r1, String r2, boolean r3, boolean r4);

    private static native long nativePrepareStatement(long r0, String r2);

    private static native int nativeReKey(long r0, byte[] r2);

    private static native void nativeRegisterCustomFunction(long r0, SQLiteCustomFunction r2);

    private static native void nativeRegisterLocalizedCollators(long r0, String r2);

    private static native void nativeResetCancel(long r0, boolean r2);

    private static native void nativeResetStatementAndClearBindings(long r0, long r2);

    private PreparedStatement obtainPreparedStatement(String r4, long r5, int r7, int r8, boolean r9) {
        PreparedStatement r0 = this.mPreparedStatementPool;
        AnonymousClass1 r1 = null;
        if (r0 == null) goto L5;
        this.mPreparedStatementPool = r0.mPoolNext;
        r0.mPoolNext = null;
        r0.mInCache = false;
    L6:
        r0.mSql = r4;
        r0.mStatementPtr = r5;
        r0.mNumParameters = r7;
        r0.mType = r8;
        r0.mReadOnly = r9;
        return r0;
    L5:
        r0 = new PreparedStatement(r1);
        goto L6
    }

    static SQLiteConnection open(SQLiteConnectionPool r1, SQLiteDatabaseConfiguration r2, int r3, boolean r4) {
        SQLiteConnection r0 = new SQLiteConnection(r1, r2, r3, r4);
        r0.open();     // Catch: SQLiteException -> L5
        return r0;
    L5:
        e = move-exception;
        r0.dispose(false);
        throw e;
    }

    private void open() {
        this.mConnectionPtr = nativeOpen(this.mConfiguration.path, this.mConfiguration.openFlags, this.mConfiguration.label, SQLiteDebug.DEBUG_SQL_STATEMENTS, SQLiteDebug.DEBUG_SQL_TIME);
        if (this.mConfiguration.databaseHook == null) goto L5;
        this.mConfiguration.databaseHook.preKey(this);
    L5:
        int r1 = 0;
        if (this.mConfiguration.password == null) goto L11;
        if (this.mConfiguration.password.length <= 0) goto L11;
        Log.i(TAG, String.format("Database keying operation returned:%s", new Object[]{Integer.valueOf(nativeKey(this.mConnectionPtr, this.mConfiguration.password))}));
    L11:
        if (this.mConfiguration.databaseHook == null) goto L14;
        this.mConfiguration.databaseHook.postKey(this);
    L14:
        if (this.mConfiguration.password != null) goto L16;
    L18:
        setPageSize();
        setForeignKeyModeFromConfiguration();
        setJournalSizeLimit();
        setAutoCheckpointInterval();
        setWalModeFromConfiguration();
        if (nativeHasCodec() == true) goto L21;
        setLocaleFromConfiguration();
    L21:
        int r0 = this.mConfiguration.customFunctions.size();
    L22:
        if (r1 >= r0) goto L24;
        nativeRegisterCustomFunction(this.mConnectionPtr, (SQLiteCustomFunction) ZeusTransformUtils.preCheckCast(this.mConfiguration.customFunctions.get(r1), SQLiteCustomFunction.class, "com.obric.memorydata.plugin"));
        r1 = r1 + 1;
        goto L22
    L24:
        return;
    L16:
        if (this.mConfiguration.password.length <= 0) goto L18;
        executeForLong("SELECT COUNT(*) FROM sqlite_schema;", null, null);
        goto L18
    }

    private void recyclePreparedStatement(PreparedStatement r2) {
        r2.mSql = null;
        r2.mPoolNext = this.mPreparedStatementPool;
        this.mPreparedStatementPool = r2;
    }

    private void releasePreparedStatement(PreparedStatement r5) {
        r5.mInUse = false;
        if (r5.mInCache == true) goto L9;
        finalizePreparedStatement(r5);
        return;
    L9:
        nativeResetStatementAndClearBindings(this.mConnectionPtr, r5.mStatementPtr);     // Catch: SQLiteException -> L6
        return;
    L6:
        this.mPreparedStatementCache.remove(r5.mSql);
    }

    private void setAutoCheckpointInterval() {
        if (this.mConfiguration.isInMemoryDb() == false) goto L5;
        return;
    L5:
        if (this.mIsReadOnlyConnection == true) goto L11;
        long r0 = SQLiteGlobal.getWALAutoCheckpoint();
        if (executeForLong("PRAGMA wal_autocheckpoint", null, null) == r0) goto L12;
        executeForLong("PRAGMA wal_autocheckpoint=" + r0, null, null);
        return;
    L12:
        return;
    }

    private void setForeignKeyModeFromConfiguration() {
        if (this.mIsReadOnlyConnection == false) goto L5;
        return;
    L5:
        if (this.mConfiguration.foreignKeyConstraintsEnabled == false) goto L7;
        long r0 = 1;
    L9:
        if (executeForLong("PRAGMA foreign_keys", null, null) == r0) goto L13;
        execute("PRAGMA foreign_keys=" + r0, null, null);
        return;
    L13:
        return;
    L7:
        r0 = 0;
        goto L9
    }

    private void setJournalMode(String r5) {
        String r0 = executeForString("PRAGMA journal_mode", null, null);
        if (r0.equalsIgnoreCase(r5) == true) goto L12;
        if (executeForString("PRAGMA journal_mode=" + r5, null, null).equalsIgnoreCase(r5) == false) goto L7;
        return;
    L7:
        Log.w(TAG, "Could not change the database journal mode of '" + this.mConfiguration.label + "' from '" + r0 + "' to '" + r5 + "' because the database is locked.  This usually means that there are other open connections to the database which prevents the database from enabling or disabling write-ahead logging mode.  Proceeding without changing the journal mode.");
        return;
    }

    private void setJournalSizeLimit() {
        if (this.mConfiguration.isInMemoryDb() == false) goto L5;
        return;
    L5:
        if (this.mIsReadOnlyConnection == true) goto L11;
        long r0 = SQLiteGlobal.getJournalSizeLimit();
        if (executeForLong("PRAGMA journal_size_limit", null, null) == r0) goto L12;
        executeForLong("PRAGMA journal_size_limit=" + r0, null, null);
        return;
    L12:
        return;
    }

    private void setLocaleFromConfiguration() {
        if ((this.mConfiguration.openFlags & 16) == 0) goto L5;
        return;
    L5:
        String r0 = this.mConfiguration.locale.toString();
        nativeRegisterLocalizedCollators(this.mConnectionPtr, r0);
        if (this.mIsReadOnlyConnection == false) goto L25;
        return;
    L25:
        execute("CREATE TABLE IF NOT EXISTS android_metadata (locale TEXT)", null, null);     // Catch: RuntimeException -> L20
        String r1 = executeForString("SELECT locale FROM android_metadata UNION SELECT NULL ORDER BY locale DESC LIMIT 1", null, null);     // Catch: RuntimeException -> L20
        if (r1 != null) goto L11;
    L13:
        execute("BEGIN", null, null);     // Catch: RuntimeException -> L20
        execute("DELETE FROM android_metadata", null, null);     // Catch: Throwable -> L17
        execute("INSERT INTO android_metadata (locale) VALUES(?)", new Object[]{r0}, null);     // Catch: Throwable -> L17
        execute("REINDEX LOCALIZED", null, null);     // Catch: Throwable -> L17
        execute("COMMIT", null, null);     // Catch: RuntimeException -> L20
        return;
    L17:
        th = move-exception;
        execute("ROLLBACK", null, null);     // Catch: RuntimeException -> L20
        throw th;     // Catch: RuntimeException -> L20
    L11:
        if (r1.equals(r0) == false) goto L13;
        return;
    L20:
        e = move-exception;
        throw new SQLiteException("Failed to change locale for db '" + this.mConfiguration.label + "' to '" + r0 + "'.", e);
    }

    private void setPageSize() {
        if (this.mConfiguration.isInMemoryDb() == false) goto L5;
        return;
    L5:
        if (this.mIsReadOnlyConnection == false) goto L7;
        return;
    L7:
        if (SQLiteDatabase.hasCodec() == true) goto L14;
        long r0 = SQLiteGlobal.getDefaultPageSize();
        if (executeForLong("PRAGMA page_size", null, null) == r0) goto L15;
        execute("PRAGMA page_size=" + r0, null, null);
        return;
    L15:
        return;
    }

    private void setSyncMode(String r4) {
        if (canonicalizeSyncMode(executeForString("PRAGMA synchronous", null, null)).equalsIgnoreCase(canonicalizeSyncMode(r4)) == true) goto L6;
        execute("PRAGMA synchronous=" + r4, null, null);
        return;
    }

    private void setWalModeFromConfiguration() {
        if (this.mConfiguration.isInMemoryDb() == false) goto L5;
        return;
    L5:
        if (this.mIsReadOnlyConnection == false) goto L7;
        return;
    L7:
        if ((this.mConfiguration.openFlags & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) == 0) goto L9;
        setJournalMode("WAL");
        String r0 = SQLiteGlobal.getWALSyncMode();
    L10:
        setSyncMode(r0);
        return;
    L9:
        setJournalMode(SQLiteGlobal.getDefaultJournalMode());
        r0 = SQLiteGlobal.getDefaultSyncMode();
        goto L10
    }

    private void throwIfStatementForbidden(PreparedStatement r1) {
        if (this.mOnlyAllowReadOnlyOperations == true) goto L5;
        return;
    L5:
        if (r1.mReadOnly == false) goto L8;
        return;
    L8:
        throw new SQLiteException("Cannot execute this statement because it might modify the database but the connection is read-only.");
    }

    private static String trimSqlForDisplay(String r2) {
        return r2.replaceAll("[\\s]*\\n+[\\s]*", " ");
    }

    void changePassword(byte[] r4) {
        int r3 = nativeReKey(this.mConnectionPtr, r4);
        Log.i(TAG, String.format("Database rekey operation returned:%s", new Object[]{Integer.valueOf(r3)}));
        if (r3 != 0) goto L6;
        return;
    L6:
        throw new SQLiteException(String.format("Failed to rekey database, result code:%s", new Object[]{Integer.valueOf(r3)}));
    }

    void close() {
        dispose(false);
    }

    void collectDbStats(ArrayList<SQLiteDebug.DbStats> r26) {
        int r2 = nativeGetDbLookaside(this.mConnectionPtr);
        long r3 = executeForLong("PRAGMA page_count;", null, null);     // Catch: SQLiteException -> L6
        long r5 = executeForLong("PRAGMA page_size;", null, null);     // Catch: SQLiteException -> L30
    L8:
        r26.add(getMainDbStatsUnsafe(r2, r3, r5));
        CursorWindow r14 = new CursorWindow("collectDbStats");
        executeForCursorWindow("PRAGMA database_list;", null, r14, 0, 0, false, null);     // Catch: Throwable -> L23 SQLiteException -> L29
        int r4 = 1;
    L10:
        if (r4 >= r14.getNumRows()) goto L26;
        String r6 = r14.getString(r4, 1);     // Catch: Throwable -> L23 SQLiteException -> L29
        String r7 = r14.getString(r4, 2);     // Catch: Throwable -> L23 SQLiteException -> L29
        long r8 = executeForLong("PRAGMA " + r6 + ".page_count;", null, null);     // Catch: SQLiteException -> L16 Throwable -> L23
        long r17 = r8;
        long r19 = executeForLong("PRAGMA " + r6 + ".page_size;", null, null);     // Catch: SQLiteException -> L28 Throwable -> L23
    L18:
        String r9 = "  (attached) " + r6;     // Catch: Throwable -> L23 SQLiteException -> L29
        if (r7.isEmpty() == true) goto L21;
        r9 = r9 + ": " + r7;     // Catch: Throwable -> L23 SQLiteException -> L29
    L21:
        r26.add(new SQLiteDebug.DbStats(r9, r17, r19, 0, 0, 0, 0));     // Catch: Throwable -> L23 SQLiteException -> L29
        r4 = r4 + 1;
    L17:
        r17 = r8;
        r19 = 0;
    L16:
        r8 = 0;
        goto L17
    L23:
        th = move-exception;
        r14.close();
        throw th;
    L26:
        r14.close();
        return;
    L7:
        r5 = 0;
    L6:
        r3 = 0;
        goto L7
    }

    void collectDbStatsUnsafe(ArrayList<SQLiteDebug.DbStats> r7) {
        r7.add(getMainDbStatsUnsafe(0, 0, 0));
    }

    String describeCurrentOperationUnsafe() {
        return this.mRecentOperations.describeCurrentOperation();
    }

    public void dump(Printer r3, boolean r4) {
        dumpUnsafe((Printer) ZeusTransformUtils.wrapperContextForParams(r3, Printer.class, "com.obric.memorydata.plugin"), r4);
    }

    void dumpUnsafe(Printer r4, boolean r5) {
        Printer r6 = (Printer) ZeusTransformUtils.wrapperContextForParams(r4, Printer.class, "com.obric.memorydata.plugin");
        r6.println("Connection #" + this.mConnectionId + ParameterizedMessage.ERROR_MSG_SEPARATOR);
        if (r5 == false) goto L5;
        r6.println("  connectionPtr: 0x" + Long.toHexString(this.mConnectionPtr));
    L5:
        r6.println("  isPrimaryConnection: " + this.mIsPrimaryConnection);
        r6.println("  onlyAllowReadOnlyOperations: " + this.mOnlyAllowReadOnlyOperations);
        this.mRecentOperations.dump(r6, r5);
        if (r5 == false) goto L9;
        this.mPreparedStatementCache.dump(r6);
        return;
    }

    public void enableLocalizedCollators() {
        if (nativeHasCodec() == false) goto L6;
        setLocaleFromConfiguration();
        return;
    }

    public void execute(String r6, Object[] r7, CancellationSignal r8) {
        if (r6 == null) goto L25;
        int r0 = this.mRecentOperations.beginOperation("execute", r6, r7);
        PreparedStatement r9 = acquirePreparedStatement(r6);     // Catch: Throwable -> L17 RuntimeException -> L19
        throwIfStatementForbidden(r9);     // Catch: Throwable -> L14
        bindArguments(r9, r7);     // Catch: Throwable -> L14
        applyBlockGuardPolicy(r9);     // Catch: Throwable -> L14
        attachCancellationSignal(r8);     // Catch: Throwable -> L14
        nativeExecute(this.mConnectionPtr, r9.mStatementPtr);     // Catch: Throwable -> L11
        detachCancellationSignal(r8);     // Catch: Throwable -> L14
        releasePreparedStatement(r9);     // Catch: Throwable -> L17 RuntimeException -> L19
        this.mRecentOperations.endOperation(r0);
        return;
    L11:
        th = move-exception;
        detachCancellationSignal(r8);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        releasePreparedStatement(r9);     // Catch: Throwable -> L17 RuntimeException -> L19
        throw th;     // Catch: Throwable -> L17 RuntimeException -> L19
    L17:
        th = move-exception;
        this.mRecentOperations.endOperation(r0);
        throw th;
    L19:
        e = move-exception;
        this.mRecentOperations.failOperation(r0, e);     // Catch: Throwable -> L17
        throw e;     // Catch: Throwable -> L17
    L25:
        throw new IllegalArgumentException("sql must not be null.");
    }

    public ParcelFileDescriptor executeForBlobFileDescriptor(String r6, Object[] r7, CancellationSignal r8) {
        if (r6 == null) goto L29;
        int r0 = this.mRecentOperations.beginOperation("executeForBlobFileDescriptor", r6, r7);
        PreparedStatement r9 = acquirePreparedStatement(r6);     // Catch: Throwable -> L21 RuntimeException -> L23
        throwIfStatementForbidden(r9);     // Catch: Throwable -> L18
        bindArguments(r9, r7);     // Catch: Throwable -> L18
        applyBlockGuardPolicy(r9);     // Catch: Throwable -> L18
        attachCancellationSignal(r8);     // Catch: Throwable -> L18
        int r10 = nativeExecuteForBlobFileDescriptor(this.mConnectionPtr, r9.mStatementPtr);     // Catch: Throwable -> L15
        if (r10 < 0) goto L10;
        ParcelFileDescriptor r11 = ParcelFileDescriptor.adoptFd(r10);     // Catch: Throwable -> L15
    L11:
        detachCancellationSignal(r8);     // Catch: Throwable -> L18
        releasePreparedStatement(r9);     // Catch: Throwable -> L21 RuntimeException -> L23
        this.mRecentOperations.endOperation(r0);
        return r11;
    L10:
        r11 = null;
    L15:
        th = move-exception;
        detachCancellationSignal(r8);     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        releasePreparedStatement(r9);     // Catch: Throwable -> L21 RuntimeException -> L23
        throw th;     // Catch: Throwable -> L21 RuntimeException -> L23
    L21:
        th = move-exception;
        this.mRecentOperations.endOperation(r0);
        throw th;
    L23:
        e = move-exception;
        this.mRecentOperations.failOperation(r0, e);     // Catch: Throwable -> L21
        throw e;     // Catch: Throwable -> L21
    L29:
        throw new IllegalArgumentException("sql must not be null.");
    }

    public int executeForChangedRowCount(String r8, Object[] r9, CancellationSignal r10) {
        if (r8 == null) goto L30;
        int r2 = this.mRecentOperations.beginOperation("executeForChangedRowCount", r8, r9);
        PreparedStatement r11 = acquirePreparedStatement(r8);     // Catch: Throwable -> L20 RuntimeException -> L22
        throwIfStatementForbidden(r11);     // Catch: Throwable -> L17
        bindArguments(r11, r9);     // Catch: Throwable -> L17
        applyBlockGuardPolicy(r11);     // Catch: Throwable -> L17
        attachCancellationSignal(r10);     // Catch: Throwable -> L17
        int r1 = nativeExecuteForChangedRowCount(this.mConnectionPtr, r11.mStatementPtr);     // Catch: Throwable -> L14
        detachCancellationSignal(r10);     // Catch: Throwable -> L17
        releasePreparedStatement(r11);     // Catch: Throwable -> L20 RuntimeException -> L22
        if (this.mRecentOperations.endOperationDeferLog(r2) == false) goto L13;
        this.mRecentOperations.logOperation(r2, "changedRows=" + r1);
    L13:
        return r1;
    L14:
        th = move-exception;
        detachCancellationSignal(r10);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        releasePreparedStatement(r11);     // Catch: Throwable -> L20 RuntimeException -> L22
        throw th;     // Catch: Throwable -> L20 RuntimeException -> L22
    L22:
        e = move-exception;
        this.mRecentOperations.failOperation(r2, e);     // Catch: Throwable -> L20
        throw e;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        if (this.mRecentOperations.endOperationDeferLog(r2) == false) goto L28;
        this.mRecentOperations.logOperation(r2, "changedRows=0");
    L28:
        throw th;
    L30:
        throw new IllegalArgumentException("sql must not be null.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [net.zetetic.database.sqlcipher.SQLiteConnection$OperationLog] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [net.zetetic.database.sqlcipher.SQLiteConnection$OperationLog] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.String] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public int executeForCursorWindow(String r23, Object[] r24, CursorWindow r25, int r26, int r27, boolean r28, CancellationSignal r29) {
        Object[] r2 = r24;
        String r14 = ", filledRows=";
        String r15 = ", actualPos=";
        String r9 = "', startPos=";
        String r8 = "window='";
        if (r23 == null) goto L67;
        if (r25 == null) goto L65;
        r25.acquireReference();
        OperationLog r3 = this.mRecentOperations;     // Catch: Throwable -> L61
        int r7 = r3.beginOperation("executeForCursorWindow", r23, r2);     // Catch: Throwable -> L61
        PreparedStatement r6 = acquirePreparedStatement(r23);     // Catch: Throwable -> L49 RuntimeException -> L51
        throwIfStatementForbidden(r6);     // Catch: Throwable -> L43
        bindArguments(r6, r2);     // Catch: Throwable -> L43
        applyBlockGuardPolicy(r6);     // Catch: Throwable -> L43
        attachCancellationSignal(r29);     // Catch: Throwable -> L43
        PreparedStatement r13 = r6;
        int r16 = r7;
        r15 = "window='";
        long r4 = nativeExecuteForCursorWindow(this.mConnectionPtr, r6.mStatementPtr, r25, r26, r27, r28);     // Catch: Throwable -> L34
        int r5 = (int) (r4 >> 32);
        int r10 = (int) r4;
        int r11 = r25.getNumRows();     // Catch: Throwable -> L31
        r25.setStartPosition(r5);     // Catch: Throwable -> L29
        detachCancellationSignal(r29);     // Catch: Throwable -> L27
        releasePreparedStatement(r13);     // Catch: Throwable -> L23 RuntimeException -> L25
    L19:
        if (this.mRecentOperations.endOperationDeferLog(r16) == false) goto L21;
        this.mRecentOperations.logOperation(r16, r15 + r25 + "', startPos=" + r26 + ", actualPos=" + r5 + ", filledRows=" + r11 + ", countedRows=" + r10);     // Catch: Throwable -> L61
    L21:
        r25.releaseReference();
        return r10;
    L25:
        e = e;
    L53:
        this.mRecentOperations.failOperation(r16, e);     // Catch: Throwable -> L55
        throw e;     // Catch: Throwable -> L55
    L23:
        th = th;
        int r12 = r26;
        r9 = "', startPos=";
        r8 = ", countedRows=";
        ?? r17 = ", filledRows=";
        String r18 = ", actualPos=";
        ?? r19 = r10;
        ?? r20 = r11;
        ?? r110 = r16;
    L58:
        if (this.mRecentOperations.endOperationDeferLog(r110) == false) goto L60;
        this.mRecentOperations.logOperation(r110, r15 + r25 + r9 + r12 + r18 + r5 + r17 + r20 + r8 + r19);     // Catch: Throwable -> L61
    L60:
        throw th;     // Catch: Throwable -> L61
    L27:
        th = th;
    L80:
        releasePreparedStatement(r13);     // Catch: RuntimeException -> L47 Throwable -> L55
        throw th;     // Catch: RuntimeException -> L47 Throwable -> L55
    L47:
        e = e;
    L29:
        th = th;
    L33:
        r16 = r16;
    L74:
        detachCancellationSignal(r29);     // Catch: Throwable -> L41
        throw th;     // Catch: Throwable -> L41
    L41:
        th = th;
    L31:
        th = th;
    L34:
        th = th;
        int r111 = r16;
    L38:
        r16 = r111;
    L36:
        th = th;
        r13 = r6;
        r111 = r7;
    L43:
        th = th;
        r13 = r6;
        r16 = r7;
        goto L80
    L55:
        th = th;
        r5 = -1;
        r19 = r2;
        r20 = r3;
        r17 = r7;
        r110 = r14;
    L51:
        e = e;
        r16 = r7;
    L49:
        th = th;
        r12 = r26;
        r18 = ", actualPos=";
        r15 = "window='";
        r8 = ", countedRows=";
        r110 = r7;
        r17 = ", filledRows=";
        r19 = -1;
        r20 = -1;
        r5 = -1;
    L61:
        th = move-exception;
        r25.releaseReference();
        throw th;
    L65:
        throw new IllegalArgumentException("window must not be null.");
    L67:
        throw new IllegalArgumentException("sql must not be null.");
    }

    public long executeForLastInsertedRowId(String r6, Object[] r7, CancellationSignal r8) {
        if (r6 == null) goto L25;
        int r0 = this.mRecentOperations.beginOperation("executeForLastInsertedRowId", r6, r7);
        PreparedStatement r9 = acquirePreparedStatement(r6);     // Catch: Throwable -> L17 RuntimeException -> L19
        throwIfStatementForbidden(r9);     // Catch: Throwable -> L14
        bindArguments(r9, r7);     // Catch: Throwable -> L14
        applyBlockGuardPolicy(r9);     // Catch: Throwable -> L14
        attachCancellationSignal(r8);     // Catch: Throwable -> L14
        long r1 = nativeExecuteForLastInsertedRowId(this.mConnectionPtr, r9.mStatementPtr);     // Catch: Throwable -> L11
        detachCancellationSignal(r8);     // Catch: Throwable -> L14
        releasePreparedStatement(r9);     // Catch: Throwable -> L17 RuntimeException -> L19
        this.mRecentOperations.endOperation(r0);
        return r1;
    L11:
        th = move-exception;
        detachCancellationSignal(r8);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        releasePreparedStatement(r9);     // Catch: Throwable -> L17 RuntimeException -> L19
        throw th;     // Catch: Throwable -> L17 RuntimeException -> L19
    L17:
        th = move-exception;
        this.mRecentOperations.endOperation(r0);
        throw th;
    L19:
        e = move-exception;
        this.mRecentOperations.failOperation(r0, e);     // Catch: Throwable -> L17
        throw e;     // Catch: Throwable -> L17
    L25:
        throw new IllegalArgumentException("sql must not be null.");
    }

    public long executeForLong(String r6, Object[] r7, CancellationSignal r8) {
        if (r6 == null) goto L25;
        int r0 = this.mRecentOperations.beginOperation("executeForLong", r6, r7);
        PreparedStatement r9 = acquirePreparedStatement(r6);     // Catch: Throwable -> L17 RuntimeException -> L19
        throwIfStatementForbidden(r9);     // Catch: Throwable -> L14
        bindArguments(r9, r7);     // Catch: Throwable -> L14
        applyBlockGuardPolicy(r9);     // Catch: Throwable -> L14
        attachCancellationSignal(r8);     // Catch: Throwable -> L14
        long r1 = nativeExecuteForLong(this.mConnectionPtr, r9.mStatementPtr);     // Catch: Throwable -> L11
        detachCancellationSignal(r8);     // Catch: Throwable -> L14
        releasePreparedStatement(r9);     // Catch: Throwable -> L17 RuntimeException -> L19
        this.mRecentOperations.endOperation(r0);
        return r1;
    L11:
        th = move-exception;
        detachCancellationSignal(r8);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        releasePreparedStatement(r9);     // Catch: Throwable -> L17 RuntimeException -> L19
        throw th;     // Catch: Throwable -> L17 RuntimeException -> L19
    L17:
        th = move-exception;
        this.mRecentOperations.endOperation(r0);
        throw th;
    L19:
        e = move-exception;
        this.mRecentOperations.failOperation(r0, e);     // Catch: Throwable -> L17
        throw e;     // Catch: Throwable -> L17
    L25:
        throw new IllegalArgumentException("sql must not be null.");
    }

    public String executeForString(String r6, Object[] r7, CancellationSignal r8) {
        if (r6 == null) goto L25;
        int r0 = this.mRecentOperations.beginOperation("executeForString", r6, r7);
        PreparedStatement r9 = acquirePreparedStatement(r6);     // Catch: Throwable -> L17 RuntimeException -> L19
        throwIfStatementForbidden(r9);     // Catch: Throwable -> L14
        bindArguments(r9, r7);     // Catch: Throwable -> L14
        applyBlockGuardPolicy(r9);     // Catch: Throwable -> L14
        attachCancellationSignal(r8);     // Catch: Throwable -> L14
        String r10 = nativeExecuteForString(this.mConnectionPtr, r9.mStatementPtr);     // Catch: Throwable -> L11
        detachCancellationSignal(r8);     // Catch: Throwable -> L14
        releasePreparedStatement(r9);     // Catch: Throwable -> L17 RuntimeException -> L19
        this.mRecentOperations.endOperation(r0);
        return r10;
    L11:
        th = move-exception;
        detachCancellationSignal(r8);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        releasePreparedStatement(r9);     // Catch: Throwable -> L17 RuntimeException -> L19
        throw th;     // Catch: Throwable -> L17 RuntimeException -> L19
    L17:
        th = move-exception;
        this.mRecentOperations.endOperation(r0);
        throw th;
    L19:
        e = move-exception;
        this.mRecentOperations.failOperation(r0, e);     // Catch: Throwable -> L17
        throw e;     // Catch: Throwable -> L17
    L25:
        throw new IllegalArgumentException("sql must not be null.");
    }

    public void executeRaw(String r7, Object[] r8, CancellationSignal r9) {
        if (r7 == null) goto L30;
        int r1 = this.mRecentOperations.beginOperation("executeRaw", r7, r8);
        PreparedStatement r10 = acquirePreparedStatement(r7);     // Catch: Throwable -> L20 RuntimeException -> L22
        throwIfStatementForbidden(r10);     // Catch: Throwable -> L17
        bindArguments(r10, r8);     // Catch: Throwable -> L17
        applyBlockGuardPolicy(r10);     // Catch: Throwable -> L17
        attachCancellationSignal(r9);     // Catch: Throwable -> L17
        nativeExecuteRaw(this.mConnectionPtr, r10.mStatementPtr);     // Catch: Throwable -> L14
        detachCancellationSignal(r9);     // Catch: Throwable -> L17
        releasePreparedStatement(r10);     // Catch: Throwable -> L20 RuntimeException -> L22
        if (this.mRecentOperations.endOperationDeferLog(r1) == false) goto L35;
        this.mRecentOperations.logOperation(r1, "");
        return;
    L35:
        return;
    L14:
        th = move-exception;
        detachCancellationSignal(r9);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        releasePreparedStatement(r10);     // Catch: Throwable -> L20 RuntimeException -> L22
        throw th;     // Catch: Throwable -> L20 RuntimeException -> L22
    L20:
        th = move-exception;
        if (this.mRecentOperations.endOperationDeferLog(r1) == false) goto L28;
        this.mRecentOperations.logOperation(r1, "");
    L28:
        throw th;
    L22:
        e = move-exception;
        this.mRecentOperations.failOperation(r1, e);     // Catch: Throwable -> L20
        throw e;     // Catch: Throwable -> L20
    L30:
        throw new IllegalArgumentException("sql must not be null.");
    }

    public void finalize() {
        SQLiteConnectionPool r0 = this.mPool;     // Catch: Throwable -> L10
        if (r0 != null) goto L5;
    L7:
        dispose(true);     // Catch: Throwable -> L10
        super.finalize();
        return;
    L5:
        if (this.mConnectionPtr == 0) goto L7;
        r0.onConnectionLeaked();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        super.finalize();
        throw th;
    }

    public int getConnectionId() {
        return this.mConnectionId;
    }

    boolean isPreparedStatementInCache(String r1) {
        if (this.mPreparedStatementCache.get(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPrimaryConnection() {
        return this.mIsPrimaryConnection;
    }

    @Override // android.os.CancellationSignal.OnCancelListener
    public void onCancel() {
        nativeCancel(this.mConnectionPtr);
    }

    public void prepare(String r9, SQLiteStatementInfo r10) {
        if (r9 == null) goto L27;
        int r0 = this.mRecentOperations.beginOperation(LBSLightLocationTraceLogger.PREPARE, r9, null);
        PreparedStatement r11 = acquirePreparedStatement(r9);     // Catch: Throwable -> L19 RuntimeException -> L21
        if (r10 != null) goto L30;
    L16:
        releasePreparedStatement(r11);     // Catch: Throwable -> L19 RuntimeException -> L21
        this.mRecentOperations.endOperation(r0);
        return;
    L30:
        r10.numParameters = r11.mNumParameters;     // Catch: Throwable -> L13
        r10.readOnly = r11.mReadOnly;     // Catch: Throwable -> L13
        int r1 = nativeGetColumnCount(this.mConnectionPtr, r11.mStatementPtr);     // Catch: Throwable -> L13
        if (r1 != 0) goto L9;
        r10.columnNames = EMPTY_STRING_ARRAY;     // Catch: Throwable -> L13
        goto L16
    L9:
        r10.columnNames = new String[r1];     // Catch: Throwable -> L13
        int r2 = 0;
    L10:
        if (r2 >= r1) goto L16;
        r10.columnNames[r2] = nativeGetColumnName(this.mConnectionPtr, r11.mStatementPtr, r2);     // Catch: Throwable -> L13
        r2 = r2 + 1;
    L13:
        th = move-exception;
        releasePreparedStatement(r11);     // Catch: Throwable -> L19 RuntimeException -> L21
        throw th;     // Catch: Throwable -> L19 RuntimeException -> L21
    L21:
        e = move-exception;
        this.mRecentOperations.failOperation(r0, e);     // Catch: Throwable -> L19
        throw e;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        this.mRecentOperations.endOperation(r0);
        throw th;
    L27:
        throw new IllegalArgumentException("sql must not be null.");
    }

    void reconfigure(SQLiteDatabaseConfiguration r7) {
        boolean r0 = false;
        this.mOnlyAllowReadOnlyOperations = false;
        int r1 = r7.customFunctions.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        SQLiteCustomFunction r3 = (SQLiteCustomFunction) ZeusTransformUtils.preCheckCast(r7.customFunctions.get(r2), SQLiteCustomFunction.class, "com.obric.memorydata.plugin");
        if (this.mConfiguration.customFunctions.contains(r3) == true) goto L7;
        nativeRegisterCustomFunction(this.mConnectionPtr, r3);
    L7:
        r2 = r2 + 1;
        goto L3
    L9:
        if (r7.foreignKeyConstraintsEnabled == this.mConfiguration.foreignKeyConstraintsEnabled) goto L11;
        boolean r4 = true;
    L13:
        if (((r7.openFlags ^ this.mConfiguration.openFlags) & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) == 0) goto L15;
        r0 = true;
    L15:
        boolean r5 = !r7.locale.equals(this.mConfiguration.locale);
        this.mConfiguration.updateParametersFrom(r7);
        if (r4 == false) goto L18;
        setForeignKeyModeFromConfiguration();
    L18:
        if (r0 == false) goto L20;
        setWalModeFromConfiguration();
    L20:
        if (r5 == false) goto L26;
        setLocaleFromConfiguration();
        return;
    L26:
        return;
    L11:
        r4 = false;
        goto L13
    }

    void setOnlyAllowReadOnlyOperations(boolean r1) {
        this.mOnlyAllowReadOnlyOperations = r1;
    }

    public String toString() {
        return "SQLiteConnection: " + this.mConfiguration.path + " (" + this.mConnectionId + ")";
    }
}
