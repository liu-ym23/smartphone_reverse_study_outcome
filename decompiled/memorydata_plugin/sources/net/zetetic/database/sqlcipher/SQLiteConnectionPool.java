package net.zetetic.database.sqlcipher;

import android.os.CancellationSignal;
import android.os.OperationCanceledException;
import android.os.SystemClock;
import android.util.Log;
import android.util.Printer;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes6.dex */
public final class SQLiteConnectionPool implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CONNECTION_FLAG_INTERACTIVE = 4;
    public static final int CONNECTION_FLAG_PRIMARY_CONNECTION_AFFINITY = 2;
    public static final int CONNECTION_FLAG_READ_ONLY = 1;
    private static final long CONNECTION_POOL_BUSY_MILLIS = 30000;
    private static final String TAG = "SQLiteConnectionPool";
    private final WeakHashMap<SQLiteConnection, AcquiredConnectionStatus> mAcquiredConnections;
    private final ArrayList<SQLiteConnection> mAvailableNonPrimaryConnections;
    private SQLiteConnection mAvailablePrimaryConnection;
    private final CloseGuard mCloseGuard;
    private final SQLiteDatabaseConfiguration mConfiguration;
    private final AtomicBoolean mConnectionLeaked;
    private ConnectionWaiter mConnectionWaiterPool;
    private ConnectionWaiter mConnectionWaiterQueue;
    private boolean mIsOpen;
    private final Object mLock;
    private int mMaxConnectionPoolSize;
    private int mNextConnectionId;

    static final enum AcquiredConnectionStatus extends Enum<AcquiredConnectionStatus> {
        private static final /* synthetic */ AcquiredConnectionStatus[] $VALUES = null;
        public static final AcquiredConnectionStatus DISCARD = null;
        public static final AcquiredConnectionStatus NORMAL = null;
        public static final AcquiredConnectionStatus RECONFIGURE = null;

        private static /* synthetic */ AcquiredConnectionStatus[] $values() {
            return new AcquiredConnectionStatus[]{NORMAL, RECONFIGURE, DISCARD};
        }

        static {
            NORMAL = new AcquiredConnectionStatus("NORMAL", 0);
            RECONFIGURE = new AcquiredConnectionStatus("RECONFIGURE", 1);
            DISCARD = new AcquiredConnectionStatus("DISCARD", 2);
            $VALUES = $values();
        }

        private AcquiredConnectionStatus(String r1, int r2) {
            super(r1, r2);
        }

        public static AcquiredConnectionStatus valueOf(String r2) {
            return (AcquiredConnectionStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(AcquiredConnectionStatus.class, r2), AcquiredConnectionStatus.class, "com.obric.memorydata.plugin");
        }

        public static AcquiredConnectionStatus[] values() {
            return (AcquiredConnectionStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AcquiredConnectionStatus[].class, "com.obric.memorydata.plugin");
        }
    }

    private static final class ConnectionWaiter {
        public SQLiteConnection mAssignedConnection;
        public int mConnectionFlags;
        public RuntimeException mException;
        public ConnectionWaiter mNext;
        public int mNonce;
        public int mPriority;
        public String mSql;
        public long mStartTime;
        public Thread mThread;
        public boolean mWantPrimaryConnection;

        private ConnectionWaiter() {
        }

        /* synthetic */ ConnectionWaiter(AnonymousClass1 r1) {
            this();
        }
    }

    static {
    }

    private SQLiteConnectionPool(SQLiteDatabaseConfiguration r2) {
        this.mCloseGuard = CloseGuard.get();
        this.mLock = new Object();
        this.mConnectionLeaked = new AtomicBoolean();
        this.mAvailableNonPrimaryConnections = new ArrayList();
        this.mAcquiredConnections = new WeakHashMap();
        this.mConfiguration = new SQLiteDatabaseConfiguration(r2);
        setMaxConnectionPoolSizeLocked();
    }

    static /* synthetic */ Object access$000(SQLiteConnectionPool r0) {
        return r0.mLock;
    }

    static /* synthetic */ void access$100(SQLiteConnectionPool r0, ConnectionWaiter r1) {
        r0.cancelConnectionWaiterLocked(r1);
    }

    private void cancelConnectionWaiterLocked(ConnectionWaiter r4) {
        if (r4.mAssignedConnection == null) goto L5;
        return;
    L5:
        if (r4.mException != null) goto L19;
        ConnectionWaiter r0 = null;
        ConnectionWaiter r1 = this.mConnectionWaiterQueue;
    L8:
        ConnectionWaiter r2 = r1;
        ConnectionWaiter r3 = r0;
        r0 = r2;
        if (r0 == r4) goto L11;
        r1 = r0.mNext;
        goto L8
    L11:
        ConnectionWaiter r5 = r4.mNext;
        if (r3 == null) goto L14;
        r3.mNext = r5;
    L15:
        r4.mException = new OperationCanceledException();
        LockSupport.unpark(r4.mThread);
        wakeConnectionWaitersLocked();
        return;
    L14:
        this.mConnectionWaiterQueue = r5;
        goto L15
    }

    private void closeAvailableConnectionsAndLogExceptionsLocked() {
        closeAvailableNonPrimaryConnectionsAndLogExceptionsLocked();
        SQLiteConnection r0 = this.mAvailablePrimaryConnection;
        if (r0 == null) goto L6;
        closeConnectionAndLogExceptionsLocked(r0);
        this.mAvailablePrimaryConnection = null;
        return;
    }

    private void closeAvailableNonPrimaryConnectionsAndLogExceptionsLocked() {
        int r0 = this.mAvailableNonPrimaryConnections.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        closeConnectionAndLogExceptionsLocked((SQLiteConnection) ZeusTransformUtils.preCheckCast(this.mAvailableNonPrimaryConnections.get(r1), SQLiteConnection.class, "com.obric.memorydata.plugin"));
        r1 = r1 + 1;
        goto L3
    L5:
        this.mAvailableNonPrimaryConnections.clear();
    }

    private void closeConnectionAndLogExceptionsLocked(SQLiteConnection r3) {
        r3.close();     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "Failed to close connection, its fate is now in the hands of the merciful GC: " + r3, e);
    }

    private void closeExcessConnectionsAndLogExceptionsLocked() {
        int r0 = this.mAvailableNonPrimaryConnections.size();
    L3:
        int r1 = r0 - 1;
        if (r0 <= (this.mMaxConnectionPoolSize - 1)) goto L6;
        closeConnectionAndLogExceptionsLocked((SQLiteConnection) ZeusTransformUtils.preCheckCast(this.mAvailableNonPrimaryConnections.remove(r1), SQLiteConnection.class, "com.obric.memorydata.plugin"));
        r0 = r1;
        goto L3
    }

    private void discardAcquiredConnectionsLocked() {
        markAcquiredConnectionsLocked(AcquiredConnectionStatus.DISCARD);
    }

    private void dispose(boolean r5) {
        CloseGuard r0 = this.mCloseGuard;
        if (r0 == null) goto L7;
        if (r5 == false) goto L6;
        r0.warnIfOpen();
    L6:
        this.mCloseGuard.close();
    L7:
        if (r5 == true) goto L19;
        Object r6 = this.mLock;
        monitor-enter(r6);
        throwIfClosedLocked();     // Catch: Throwable -> L16
        this.mIsOpen = false;     // Catch: Throwable -> L16
        closeAvailableConnectionsAndLogExceptionsLocked();     // Catch: Throwable -> L16
        int r1 = this.mAcquiredConnections.size();     // Catch: Throwable -> L16
        if (r1 == 0) goto L13;
        Log.i(TAG, "The connection pool for " + this.mConfiguration.label + " has been closed but there are still " + r1 + " connections in use.  They will be closed as they are released back to the pool.");     // Catch: Throwable -> L16
    L13:
        wakeConnectionWaitersLocked();     // Catch: Throwable -> L16
        monitor-exit(r6);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private void finishAcquireConnectionLocked(SQLiteConnection r4, int r5) {
        if ((r5 & 1) == 0) goto L5;
        boolean r0 = true;
    L11:
        r4.setOnlyAllowReadOnlyOperations(r0);     // Catch: RuntimeException -> L8
        this.mAcquiredConnections.put(r4, AcquiredConnectionStatus.NORMAL);     // Catch: RuntimeException -> L8
        return;
    L8:
        e = move-exception;
        Log.e(TAG, "Failed to prepare acquired connection for session, closing it: " + r4 + ", connectionFlags=" + r5);
        closeConnectionAndLogExceptionsLocked(r4);
        throw e;
    L5:
        r0 = false;
        goto L11
    }

    private static int getPriority(int r0) {
        if ((r0 & 4) == 0) goto L5;
        return 1;
    L5:
        return 0;
    }

    private boolean isSessionBlockingImportantConnectionWaitersLocked(boolean r2, int r3) {
        ConnectionWaiter r1 = this.mConnectionWaiterQueue;
        if (r1 == null) goto L17;
        int r4 = getPriority(r3);
    L6:
        if (r4 > r1.mPriority) goto L25;
        if (r2 == true) goto L15;
        if (r1.mWantPrimaryConnection == false) goto L24;
        r1 = r1.mNext;
        if (r1 != null) goto L6;
        return false;
    L24:
        return true;
    L15:
        return true;
    L25:
        return false;
    L17:
        return false;
    }

    private void logConnectionPoolBusyLocked(long r6, int r8) {
        Thread r0 = Thread.currentThread();
        StringBuilder r1 = new StringBuilder();
        r1.append("The connection pool for database '").append(this.mConfiguration.label);
        r1.append("' has been unable to grant a connection to thread ");
        r1.append(r0.getId()).append(" (").append(r0.getName()).append(") ");
        r1.append("with flags 0x").append(Integer.toHexString(r8));
        r1.append(" for ").append(r6 * 0.001f).append(" seconds.\n");
        ArrayList r7 = new ArrayList();
        int r2 = 0;
        if (this.mAcquiredConnections.isEmpty() == true) goto L11;
        Iterator<SQLiteConnection> r9 = this.mAcquiredConnections.keySet().iterator();
        int r3 = 0;
    L6:
        if (r9.hasNext() == false) goto L12;
        String r4 = ((SQLiteConnection) ZeusTransformUtils.preCheckCast(r9.next(), SQLiteConnection.class, "com.obric.memorydata.plugin")).describeCurrentOperationUnsafe();
        if (r4 != null) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        r7.add(r4);
        r2 = r2 + 1;
    L12:
        int r10 = this.mAvailableNonPrimaryConnections.size();
        if (this.mAvailablePrimaryConnection == null) goto L15;
        r10 = r10 + 1;
    L15:
        r1.append("Connections: ").append(r2).append(" active, ");
        r1.append(r3).append(" idle, ");
        r1.append(r10).append(" available.\n");
        if (r7.isEmpty() == true) goto L21;
        r1.append("\nRequests in progress:\n");
        Iterator r5 = r7.iterator();
    L19:
        if (r5.hasNext() == false) goto L21;
        r1.append("  ").append((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin")).append("\n");
    L21:
        Log.w(TAG, r1.toString());
        return;
    L11:
        r3 = 0;
        goto L12
    }

    private void markAcquiredConnectionsLocked(AcquiredConnectionStatus r8) {
        if (this.mAcquiredConnections.isEmpty() == true) goto L15;
        ArrayList r0 = new ArrayList(this.mAcquiredConnections.size());
        Iterator<Map.Entry<SQLiteConnection, AcquiredConnectionStatus>> r1 = this.mAcquiredConnections.entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L12;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        AcquiredConnectionStatus r4 = (AcquiredConnectionStatus) ZeusTransformUtils.preCheckCast(r2.getValue(), AcquiredConnectionStatus.class, "com.obric.memorydata.plugin");
        if (r8 == r4) goto L6;
        if (r4 == AcquiredConnectionStatus.DISCARD) goto L6;
        r0.add((SQLiteConnection) ZeusTransformUtils.preCheckCast(r2.getKey(), SQLiteConnection.class, "com.obric.memorydata.plugin"));
        goto L6
    L12:
        int r3 = r0.size();
        int r5 = 0;
    L13:
        if (r5 >= r3) goto L24;
        this.mAcquiredConnections.put((SQLiteConnection) ZeusTransformUtils.preCheckCast(r0.get(r5), SQLiteConnection.class, "com.obric.memorydata.plugin"), r8);
        r5 = r5 + 1;
        goto L13
    L24:
        return;
    }

    private ConnectionWaiter obtainConnectionWaiterLocked(Thread r4, long r5, int r7, boolean r8, String r9, int r10) {
        ConnectionWaiter r0 = this.mConnectionWaiterPool;
        AnonymousClass1 r1 = null;
        if (r0 == null) goto L5;
        this.mConnectionWaiterPool = r0.mNext;
        r0.mNext = null;
    L6:
        r0.mThread = r4;
        r0.mStartTime = r5;
        r0.mPriority = r7;
        r0.mWantPrimaryConnection = r8;
        r0.mSql = r9;
        r0.mConnectionFlags = r10;
        return r0;
    L5:
        r0 = new ConnectionWaiter(r1);
        goto L6
    }

    public static SQLiteConnectionPool open(SQLiteDatabaseConfiguration r1) {
        if (r1 == null) goto L6;
        SQLiteConnectionPool r0 = new SQLiteConnectionPool(r1);
        r0.open();
        return r0;
    L6:
        throw new IllegalArgumentException("configuration must not be null.");
    }

    private void open() {
        this.mAvailablePrimaryConnection = openConnectionLocked(this.mConfiguration, true);
        this.mIsOpen = true;
        this.mCloseGuard.open(IslandSession.REOPEN_VALUE_CLOSE);
    }

    private SQLiteConnection openConnectionLocked(SQLiteDatabaseConfiguration r3, boolean r4) {
        int r0 = this.mNextConnectionId;
        this.mNextConnectionId = r0 + 1;
        return SQLiteConnection.open(this, r3, r0, r4);
    }

    private void reconfigureAllConnectionsLocked() {
        SQLiteConnection r0 = this.mAvailablePrimaryConnection;
        if (r0 != null) goto L20;
    L8:
        int r1 = this.mAvailableNonPrimaryConnections.size();
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L16;
        SQLiteConnection r3 = (SQLiteConnection) ZeusTransformUtils.preCheckCast(this.mAvailableNonPrimaryConnections.get(r2), SQLiteConnection.class, "com.obric.memorydata.plugin");
        r3.reconfigure(this.mConfiguration);     // Catch: RuntimeException -> L13
    L15:
        r2 = r2 + 1;
    L13:
        e = move-exception;
        Log.e(TAG, "Failed to reconfigure available non-primary connection, closing it: " + r3, e);
        closeConnectionAndLogExceptionsLocked(r3);
        this.mAvailableNonPrimaryConnections.remove(r2);
        r1 = r1 - 1;
        r2 = r2 - 1;
        goto L15
    L16:
        markAcquiredConnectionsLocked(AcquiredConnectionStatus.RECONFIGURE);
        return;
    L20:
        r0.reconfigure(this.mConfiguration);     // Catch: RuntimeException -> L6
    L6:
        e = move-exception;
        Log.e(TAG, "Failed to reconfigure available primary connection, closing it: " + this.mAvailablePrimaryConnection, e);
        closeConnectionAndLogExceptionsLocked(this.mAvailablePrimaryConnection);
        this.mAvailablePrimaryConnection = null;
        goto L8
    }

    private boolean recycleConnectionLocked(SQLiteConnection r3, AcquiredConnectionStatus r4) {
        if (r4 != AcquiredConnectionStatus.RECONFIGURE) goto L9;
        r3.reconfigure(this.mConfiguration);     // Catch: RuntimeException -> L6
    L6:
        e = move-exception;
        Log.e(TAG, "Failed to reconfigure released connection, closing it: " + r3, e);
        r4 = AcquiredConnectionStatus.DISCARD;
    L9:
        if (r4 != AcquiredConnectionStatus.DISCARD) goto L12;
        closeConnectionAndLogExceptionsLocked(r3);
        return false;
    L12:
        return true;
    }

    private void recycleConnectionWaiterLocked(ConnectionWaiter r2) {
        r2.mNext = this.mConnectionWaiterPool;
        r2.mThread = null;
        r2.mSql = null;
        r2.mAssignedConnection = null;
        r2.mException = null;
        r2.mNonce++;
        this.mConnectionWaiterPool = r2;
    }

    private void setMaxConnectionPoolSizeLocked() {
        if ((this.mConfiguration.openFlags & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) == 0) goto L5;
        int r0 = SQLiteGlobal.getWALConnectionPoolSize();
    L6:
        this.mMaxConnectionPoolSize = r0;
        return;
    L5:
        r0 = 1;
        goto L6
    }

    private void throwIfClosedLocked() {
        if (this.mIsOpen == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cannot perform this operation because the connection pool has been closed.");
    }

    private SQLiteConnection tryAcquireNonPrimaryConnectionLocked(String r8, int r9) {
        int r0 = this.mAvailableNonPrimaryConnections.size();
        if (r0 <= 1) goto L12;
        if (r8 == null) goto L12;
        int r4 = 0;
    L6:
        if (r4 >= r0) goto L12;
        SQLiteConnection r5 = (SQLiteConnection) ZeusTransformUtils.preCheckCast(this.mAvailableNonPrimaryConnections.get(r4), SQLiteConnection.class, "com.obric.memorydata.plugin");
        if (r5.isPreparedStatementInCache(r8) == true) goto L9;
        r4 = r4 + 1;
        goto L6
    L9:
        this.mAvailableNonPrimaryConnections.remove(r4);
        finishAcquireConnectionLocked(r5, r9);
        return r5;
    L12:
        if (r0 <= 0) goto L16;
        SQLiteConnection r10 = (SQLiteConnection) ZeusTransformUtils.preCheckCast(this.mAvailableNonPrimaryConnections.remove(r0 - 1), SQLiteConnection.class, "com.obric.memorydata.plugin");
    L14:
        finishAcquireConnectionLocked(r10, r9);
        return r10;
    L16:
        int r11 = this.mAcquiredConnections.size();
        if (this.mAvailablePrimaryConnection == null) goto L20;
        r11 = r11 + 1;
    L20:
        if (r11 < this.mMaxConnectionPoolSize) goto L23;
        return null;
    L23:
        r10 = openConnectionLocked(this.mConfiguration, false);
        goto L14
    }

    private SQLiteConnection tryAcquirePrimaryConnectionLocked(int r6) {
        SQLiteConnection r0 = this.mAvailablePrimaryConnection;
        if (r0 == null) goto L7;
        this.mAvailablePrimaryConnection = null;
    L5:
        finishAcquireConnectionLocked(r0, r6);
        return r0;
    L7:
        Iterator<SQLiteConnection> r1 = this.mAcquiredConnections.keySet().iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        if (((SQLiteConnection) ZeusTransformUtils.preCheckCast(r1.next(), SQLiteConnection.class, "com.obric.memorydata.plugin")).isPrimaryConnection() == false) goto L9;
        return null;
    L13:
        r0 = openConnectionLocked(this.mConfiguration, true);
        goto L5
    }

    private SQLiteConnection waitForConnection(String r19, int r20, CancellationSignal r21) {
        if ((r20 & 2) == 0) goto L5;
        boolean r6 = true;
    L6:
        Object r13 = this.mLock;
        monitor-enter(r13);
        throwIfClosedLocked();     // Catch: Throwable -> L70
        if (r21 == null) goto L12;
        r21.throwIfCanceled();     // Catch: Throwable -> L70
    L12:
        if (r6 == true) goto L14;
        SQLiteConnection r1 = tryAcquireNonPrimaryConnectionLocked(r19, r20);     // Catch: Throwable -> L70
    L15:
        if (r1 != null) goto L17;
        r1 = tryAcquirePrimaryConnectionLocked(r20);     // Catch: Throwable -> L70
    L17:
        if (r1 == null) goto L20;
        monitor-exit(r13);     // Catch: Throwable -> L70
        return r1;
    L20:
        int r15 = getPriority(r20);     // Catch: Throwable -> L70
        final ConnectionWaiter r2 = obtainConnectionWaiterLocked(Thread.currentThread(), SystemClock.uptimeMillis(), r15, r6, r19, r20);     // Catch: Throwable -> L70
        ConnectionWaiter r3 = this.mConnectionWaiterQueue;     // Catch: Throwable -> L70
        ConnectionWaiter r4 = null;
    L21:
        if (r3 == null) goto L26;
        if (r15 > r3.mPriority) goto L24;
        r4 = r3;
        r3 = r3.mNext;     // Catch: Throwable -> L70
        goto L21
    L24:
        r2.mNext = r3;     // Catch: Throwable -> L70
    L26:
        if (r4 == null) goto L28;
        r4.mNext = r2;     // Catch: Throwable -> L70
    L29:
        final int r5 = r2.mNonce;     // Catch: Throwable -> L70
        monitor-exit(r13);     // Catch: Throwable -> L70
        if (r21 == null) goto L76;
        r21.setOnCancelListener(new AnonymousClass1(this, r2, r5));
    L76:
        long r7 = r2.mStartTime + CONNECTION_POOL_BUSY_MILLIS;     // Catch: Throwable -> L66
        long r8 = 30000;
    L35:
        if (this.mConnectionLeaked.compareAndSet(true, false) == false) goto L44;
        Object r9 = this.mLock;     // Catch: Throwable -> L66
        monitor-enter(r9);     // Catch: Throwable -> L66
        wakeConnectionWaitersLocked();     // Catch: Throwable -> L41
        monitor-exit(r9);     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;     // Catch: Throwable -> L66
    L44:
        LockSupport.parkNanos(this, r8 * TimeUtils.NANOSECONDS_PER_MILLISECOND);     // Catch: Throwable -> L66
        Thread.interrupted();     // Catch: Throwable -> L66
        Object r10 = this.mLock;     // Catch: Throwable -> L66
        monitor-enter(r10);     // Catch: Throwable -> L66
        throwIfClosedLocked();     // Catch: Throwable -> L63
        SQLiteConnection r11 = r2.mAssignedConnection;     // Catch: Throwable -> L63
        RuntimeException r12 = r2.mException;     // Catch: Throwable -> L63
        if (r11 != null) goto L56;
        if (r12 != null) goto L56;
        long r14 = SystemClock.uptimeMillis();     // Catch: Throwable -> L63
        if (r14 >= r7) goto L53;
        long r16 = r14 - r7;     // Catch: Throwable -> L63
    L54:
        monitor-exit(r10);     // Catch: Throwable -> L63
        r8 = r16;
        goto L35
    L53:
        logConnectionPoolBusyLocked(r14 - r2.mStartTime, r20);     // Catch: Throwable -> L63
        r7 = r14 + CONNECTION_POOL_BUSY_MILLIS;     // Catch: Throwable -> L63
        r16 = 30000;
    L56:
        recycleConnectionWaiterLocked(r2);     // Catch: Throwable -> L63
        if (r11 == null) goto L62;
        monitor-exit(r10);     // Catch: Throwable -> L63
        if (r21 == null) goto L61;
        r21.setOnCancelListener(null);
    L61:
        return r11;
    L62:
        throw r12;     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        throw th;     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        if (r21 == null) goto L69;
        r21.setOnCancelListener(null);
    L69:
        throw th;
    L28:
        this.mConnectionWaiterQueue = r2;     // Catch: Throwable -> L70
        goto L29
    L14:
        r1 = null;
    L70:
        th = move-exception;
        throw th;
    L5:
        r6 = false;
        goto L6
    }

    private void wakeConnectionWaitersLocked() {
        ConnectionWaiter r0 = this.mConnectionWaiterQueue;
        boolean r3 = false;
        boolean r5 = false;
        ConnectionWaiter r4 = null;
    L3:
        if (r0 == null) goto L36;
        boolean r7 = true;
        if (this.mIsOpen == true) goto L37;
    L28:
        ConnectionWaiter r6 = r0.mNext;
        if (r7 == false) goto L34;
        if (r4 == null) goto L32;
        r4.mNext = r6;
    L33:
        r0.mNext = null;
        LockSupport.unpark(r0.mThread);
    L35:
        r0 = r6;
        goto L3
    L32:
        this.mConnectionWaiterQueue = r6;
        goto L33
    L34:
        r4 = r0;
        goto L35
    L37:
        if (r0.mWantPrimaryConnection == true) goto L13;
        if (r3 == true) goto L13;
        SQLiteConnection r8 = tryAcquireNonPrimaryConnectionLocked(r0.mSql, r0.mConnectionFlags);     // Catch: RuntimeException -> L26
        if (r8 != null) goto L14;
        r3 = true;
    L14:
        if (r8 != null) goto L19;
        if (r5 == true) goto L19;
        r8 = tryAcquirePrimaryConnectionLocked(r0.mConnectionFlags);     // Catch: RuntimeException -> L26
        if (r8 != null) goto L19;
        r5 = true;
    L19:
        if (r8 == null) goto L22;
        r0.mAssignedConnection = r8;     // Catch: RuntimeException -> L26
        goto L28
    L22:
        if (r3 == false) goto L25;
        if (r5 == false) goto L25;
        return;
    L25:
        r7 = false;
    L13:
        r8 = null;
    L26:
        e = move-exception;
        r0.mException = e;
        goto L28
    }

    public SQLiteConnection acquireConnection(String r1, int r2, CancellationSignal r3) {
        return waitForConnection(r1, r2, r3);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        dispose(false);
    }

    public void collectDbStats(ArrayList<SQLiteDebug.DbStats> r6) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SQLiteConnection r1 = this.mAvailablePrimaryConnection;     // Catch: Throwable -> L17
        if (r1 == null) goto L7;
        r1.collectDbStats(r6);     // Catch: Throwable -> L17
    L7:
        Iterator<SQLiteConnection> r2 = this.mAvailableNonPrimaryConnections.iterator();     // Catch: Throwable -> L17
    L9:
        if (r2.hasNext() == false) goto L11;
        ((SQLiteConnection) ZeusTransformUtils.preCheckCast(r2.next(), SQLiteConnection.class, "com.obric.memorydata.plugin")).collectDbStats(r6);     // Catch: Throwable -> L17
        goto L9
    L11:
        Iterator<SQLiteConnection> r5 = this.mAcquiredConnections.keySet().iterator();     // Catch: Throwable -> L17
    L13:
        if (r5.hasNext() == false) goto L15;
        ((SQLiteConnection) ZeusTransformUtils.preCheckCast(r5.next(), SQLiteConnection.class, "com.obric.memorydata.plugin")).collectDbStatsUnsafe(r6);     // Catch: Throwable -> L17
        goto L13
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public void dump(Printer r8, boolean r9) {
        Printer r10 = (Printer) ZeusTransformUtils.wrapperContextForParams(r8, Printer.class, "com.obric.memorydata.plugin");
        Object r0 = this.mLock;
        monitor-enter(r0);
        r10.println("Connection pool for " + this.mConfiguration.path + ParameterizedMessage.ERROR_MSG_SEPARATOR);     // Catch: Throwable -> L29
        r10.println("  Open: " + this.mIsOpen);     // Catch: Throwable -> L29
        r10.println("  Max connections: " + this.mMaxConnectionPoolSize);     // Catch: Throwable -> L29
        r10.println("  Available primary connection:");     // Catch: Throwable -> L29
        SQLiteConnection r1 = this.mAvailablePrimaryConnection;     // Catch: Throwable -> L29
        if (r1 == null) goto L7;
        r1.dump(r10, r9);     // Catch: Throwable -> L29
    L8:
        r10.println("  Available non-primary connections:");     // Catch: Throwable -> L29
        int r2 = 0;
        if (this.mAvailableNonPrimaryConnections.isEmpty() == true) goto L13;
        int r3 = this.mAvailableNonPrimaryConnections.size();     // Catch: Throwable -> L29
        int r4 = 0;
    L11:
        if (r4 >= r3) goto L14;
        ((SQLiteConnection) ZeusTransformUtils.preCheckCast(this.mAvailableNonPrimaryConnections.get(r4), SQLiteConnection.class, "com.obric.memorydata.plugin")).dump(r10, r9);     // Catch: Throwable -> L29
        r4 = r4 + 1;     // Catch: Throwable -> L29
    L14:
        r10.println("  Acquired connections:");     // Catch: Throwable -> L29
        if (this.mAcquiredConnections.isEmpty() == true) goto L20;
        Iterator<Map.Entry<SQLiteConnection, AcquiredConnectionStatus>> r5 = this.mAcquiredConnections.entrySet().iterator();     // Catch: Throwable -> L29
    L18:
        if (r5.hasNext() == false) goto L21;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        ((SQLiteConnection) ZeusTransformUtils.preCheckCast(r6.getKey(), SQLiteConnection.class, "com.obric.memorydata.plugin")).dumpUnsafe(r10, r9);     // Catch: Throwable -> L29
        r10.println("  Status: " + r6.getValue());     // Catch: Throwable -> L29
    L21:
        r10.println("  Connection waiters:");     // Catch: Throwable -> L29
        if (this.mConnectionWaiterQueue == null) goto L26;
        long r7 = SystemClock.uptimeMillis();     // Catch: Throwable -> L29
        ConnectionWaiter r11 = this.mConnectionWaiterQueue;     // Catch: Throwable -> L29
    L24:
        if (r11 == null) goto L27;
        r10.println(r2 + ": waited for " + ((r7 - r11.mStartTime) * 0.001f) + " ms - thread=" + r11.mThread + ", priority=" + r11.mPriority + ", sql='" + r11.mSql + "'");     // Catch: Throwable -> L29
        r11 = r11.mNext;     // Catch: Throwable -> L29
        r2 = r2 + 1;     // Catch: Throwable -> L29
    L27:
        monitor-exit(r0);     // Catch: Throwable -> L29
        return;
    L26:
        r10.println("<none>");     // Catch: Throwable -> L29
        goto L27
    L20:
        r10.println("<none>");     // Catch: Throwable -> L29
        goto L21
    L13:
        r10.println("<none>");     // Catch: Throwable -> L29
        goto L14
    L7:
        r10.println("<none>");     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    }

    public void enableLocalizedCollators() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mAcquiredConnections.isEmpty() == false) goto L12;
        SQLiteConnection r2 = this.mAvailablePrimaryConnection;     // Catch: Throwable -> L13
        if (r2 == null) goto L12;
        r2.enableLocalizedCollators();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L12:
        throw new IllegalStateException("Cannot enable localized collators while database is in use");     // Catch: Throwable -> L13
    }

    public void finalize() {
        dispose(true);     // Catch: Throwable -> L6
        super.finalize();
        return;
    L6:
        th = move-exception;
        super.finalize();
        throw th;
    }

    void onConnectionLeaked() {
        Log.w(TAG, "A SQLiteConnection object for database '" + this.mConfiguration.label + "' was leaked!  Please fix your application to end transactions in progress properly and to close the database when it is no longer needed.");
        this.mConnectionLeaked.set(true);
    }

    public void reconfigure(SQLiteDatabaseConfiguration r7) {
        if (r7 == null) goto L40;
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfClosedLocked();     // Catch: Throwable -> L36
        boolean r2 = false;
        if (((r7.openFlags ^ this.mConfiguration.openFlags) & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) == 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L16;
        if (this.mAcquiredConnections.isEmpty() == false) goto L14;
        closeAvailableNonPrimaryConnectionsAndLogExceptionsLocked();     // Catch: Throwable -> L36
        goto L16
    L14:
        throw new IllegalStateException("Write Ahead Logging (WAL) mode cannot be enabled or disabled while there are transactions in progress.  Finish all transactions and release all active database connections first.");     // Catch: Throwable -> L36
    L16:
        if (r7.foreignKeyConstraintsEnabled == this.mConfiguration.foreignKeyConstraintsEnabled) goto L18;
        r2 = true;
    L18:
        if (r2 == false) goto L25;
        if (this.mAcquiredConnections.isEmpty() == true) goto L25;
        throw new IllegalStateException("Foreign Key Constraints cannot be enabled or disabled while there are transactions in progress.  Finish all transactions and release all active database connections first.");     // Catch: Throwable -> L36
    L25:
        if ((!Arrays.equals(r7.password, this.mConfiguration.password)) == false) goto L28;
        this.mAvailablePrimaryConnection.changePassword(r7.password);     // Catch: Throwable -> L36
        this.mConfiguration.updateParametersFrom(r7);     // Catch: Throwable -> L36
        closeAvailableNonPrimaryConnectionsAndLogExceptionsLocked();     // Catch: Throwable -> L36
        reconfigureAllConnectionsLocked();     // Catch: Throwable -> L36
    L28:
        if (this.mConfiguration.openFlags == r7.openFlags) goto L32;
        if (r1 == false) goto L31;
        closeAvailableConnectionsAndLogExceptionsLocked();     // Catch: Throwable -> L36
    L31:
        SQLiteConnection r3 = openConnectionLocked(r7, true);     // Catch: Throwable -> L36
        closeAvailableConnectionsAndLogExceptionsLocked();     // Catch: Throwable -> L36
        discardAcquiredConnectionsLocked();     // Catch: Throwable -> L36
        this.mAvailablePrimaryConnection = r3;     // Catch: Throwable -> L36
        this.mConfiguration.updateParametersFrom(r7);     // Catch: Throwable -> L36
        setMaxConnectionPoolSizeLocked();     // Catch: Throwable -> L36
    L33:
        wakeConnectionWaitersLocked();     // Catch: Throwable -> L36
        monitor-exit(r0);     // Catch: Throwable -> L36
        return;
    L32:
        this.mConfiguration.updateParametersFrom(r7);     // Catch: Throwable -> L36
        setMaxConnectionPoolSizeLocked();     // Catch: Throwable -> L36
        closeExcessConnectionsAndLogExceptionsLocked();     // Catch: Throwable -> L36
        reconfigureAllConnectionsLocked();     // Catch: Throwable -> L36
        goto L33
    L8:
        r1 = false;
    L36:
        th = move-exception;
        throw th;
    L40:
        throw new IllegalArgumentException("configuration must not be null.");
    }

    public void releaseConnection(SQLiteConnection r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        AcquiredConnectionStatus r1 = (AcquiredConnectionStatus) ZeusTransformUtils.preCheckCast(this.mAcquiredConnections.remove(r5), AcquiredConnectionStatus.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L24;
        if (this.mIsOpen == true) goto L10;
    L8:
        closeConnectionAndLogExceptionsLocked(r5);     // Catch: Throwable -> L25
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L25
        return;
    L10:
        if (r5.isPrimaryConnection() == false) goto L16;
        if (recycleConnectionLocked(r5, r1) == false) goto L14;
        this.mAvailablePrimaryConnection = r5;     // Catch: Throwable -> L25
    L14:
        wakeConnectionWaitersLocked();     // Catch: Throwable -> L25
        goto L21
    L16:
        if (this.mAvailableNonPrimaryConnections.size() >= (this.mMaxConnectionPoolSize - 1)) goto L8;
        if (recycleConnectionLocked(r5, r1) == false) goto L14;
        this.mAvailableNonPrimaryConnections.add(r5);     // Catch: Throwable -> L25
        goto L14
    L24:
        throw new IllegalStateException("Cannot perform this operation because the specified connection was not acquired from this pool or has already been released.");     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    public boolean shouldYieldConnection(SQLiteConnection r3, int r4) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mAcquiredConnections.containsKey(r3) == false) goto L15;
        if (this.mIsOpen == false) goto L9;
        boolean r2 = isSessionBlockingImportantConnectionWaitersLocked(r3.isPrimaryConnection(), r4);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return r2;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return false;
    L15:
        throw new IllegalStateException("Cannot perform this operation because the specified connection was not acquired from this pool or has already been released.");     // Catch: Throwable -> L16
    }

    public String toString() {
        return "SQLiteConnectionPool: " + this.mConfiguration.path;
    }
}
