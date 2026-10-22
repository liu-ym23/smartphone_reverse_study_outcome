package net.zetetic.database.sqlcipher;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import net.zetetic.database.DatabaseErrorHandler;

/* JADX INFO: loaded from: classes6.dex */
public abstract class SQLiteOpenHelper implements SupportSQLiteOpenHelper {
    private static final boolean DEBUG_STRICT_READONLY = false;
    private static final String TAG = "SQLiteOpenHelper";
    private final Context mContext;
    private SQLiteDatabase mDatabase;
    private final SQLiteDatabaseHook mDatabaseHook;
    private boolean mEnableWriteAheadLogging;
    private final DatabaseErrorHandler mErrorHandler;
    private final SQLiteDatabase.CursorFactory mFactory;
    private boolean mIsInitializing;
    private final int mMinimumSupportedVersion;
    private final String mName;
    private final int mNewVersion;
    private byte[] mPassword;

    static {
    }

    public SQLiteOpenHelper(Context r13, String r14, String r15, SQLiteDatabase.CursorFactory r16, int r17, int r18, DatabaseErrorHandler r19, SQLiteDatabaseHook r20, boolean r21) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
        SQLiteDatabase.CursorFactory r6 = (SQLiteDatabase.CursorFactory) ZeusTransformUtils.wrapperContextForParams(r16, SQLiteDatabase.CursorFactory.class, "com.obric.memorydata.plugin");
        DatabaseErrorHandler r9 = (DatabaseErrorHandler) ZeusTransformUtils.wrapperContextForParams(r19, DatabaseErrorHandler.class, "com.obric.memorydata.plugin");
        SQLiteDatabaseHook r10 = (SQLiteDatabaseHook) ZeusTransformUtils.wrapperContextForParams(r20, SQLiteDatabaseHook.class, "com.obric.memorydata.plugin");
        this(r3, r14, getBytes(r15), r6, r17, r18, r9, r10, r21);
    }

    public SQLiteOpenHelper(Context r9, String r10, SQLiteDatabase.CursorFactory r11, int r12) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin"), r10, (SQLiteDatabase.CursorFactory) ZeusTransformUtils.wrapperContextForParams(r11, SQLiteDatabase.CursorFactory.class, "com.obric.memorydata.plugin"), r12, null);
    }

    public SQLiteOpenHelper(Context r13, String r14, SQLiteDatabase.CursorFactory r15, int r16, int r17, DatabaseErrorHandler r18) {
        byte[] r5 = new byte[0];
        this((Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin"), r14, r5, (SQLiteDatabase.CursorFactory) ZeusTransformUtils.wrapperContextForParams(r15, SQLiteDatabase.CursorFactory.class, "com.obric.memorydata.plugin"), r16, r17, (DatabaseErrorHandler) ZeusTransformUtils.wrapperContextForParams(r18, DatabaseErrorHandler.class, "com.obric.memorydata.plugin"), null, false);
    }

    public SQLiteOpenHelper(Context r10, String r11, SQLiteDatabase.CursorFactory r12, int r13, DatabaseErrorHandler r14) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin"), r11, (SQLiteDatabase.CursorFactory) ZeusTransformUtils.wrapperContextForParams(r12, SQLiteDatabase.CursorFactory.class, "com.obric.memorydata.plugin"), r13, 0, (DatabaseErrorHandler) ZeusTransformUtils.wrapperContextForParams(r14, DatabaseErrorHandler.class, "com.obric.memorydata.plugin"));
    }

    public SQLiteOpenHelper(Context r3, String r4, byte[] r5, SQLiteDatabase.CursorFactory r6, int r7, int r8, DatabaseErrorHandler r9, SQLiteDatabaseHook r10, boolean r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        SQLiteDatabase.CursorFactory r13 = (SQLiteDatabase.CursorFactory) ZeusTransformUtils.wrapperContextForParams(r6, SQLiteDatabase.CursorFactory.class, "com.obric.memorydata.plugin");
        DatabaseErrorHandler r14 = (DatabaseErrorHandler) ZeusTransformUtils.wrapperContextForParams(r9, DatabaseErrorHandler.class, "com.obric.memorydata.plugin");
        SQLiteDatabaseHook r15 = (SQLiteDatabaseHook) ZeusTransformUtils.wrapperContextForParams(r10, SQLiteDatabaseHook.class, "com.obric.memorydata.plugin");
        if (r7 < 1) goto L7;
        this.mContext = ZeusTransformUtils.wrapperContext(r12, "com.obric.memorydata.plugin");
        this.mName = r4;
        this.mPassword = r5;
        this.mFactory = r13;
        this.mNewVersion = r7;
        this.mErrorHandler = r14;
        this.mDatabaseHook = r15;
        this.mEnableWriteAheadLogging = r11;
        this.mMinimumSupportedVersion = Math.max(0, r8);
        return;
    L7:
        throw new IllegalArgumentException("Version must be >= 1, was " + r7);
    }

    private static byte[] getBytes(String r1) {
        if (r1 == null) goto L9;
        if (r1.length() == 0) goto L9;
        CharBuffer r2 = CharBuffer.wrap(r1);
        ByteBuffer r3 = Charset.forName(RpcUtils.CHARSET_UTF8).encode(r2);
        byte[] r0 = new byte[r3.limit()];
        r3.get(r0);
        return r0;
    L9:
        return new byte[0];
    }

    private SQLiteDatabase getDatabaseLocked(boolean r11) {
        SQLiteDatabase r0 = this.mDatabase;
        if (r0 == null) goto L13;
        if (r0.isOpen() == true) goto L7;
        this.mDatabase = null;
        goto L13
    L7:
        if (r11 == false) goto L11;
        if (this.mDatabase.isReadOnly() == true) goto L13;
    L11:
        return this.mDatabase;
    L13:
        if (this.mIsInitializing == true) goto L89;
        SQLiteDatabase r1 = this.mDatabase;
        this.mIsInitializing = true;     // Catch: Throwable -> L81
        if (r1 == null) goto L21;
        if (r11 == true) goto L19;
    L39:
        onConfigure(r1);     // Catch: Throwable -> L81
        int r2 = r1.getVersion();     // Catch: Throwable -> L81
        if (r2 != this.mNewVersion) goto L42;
    L71:
        onOpen(r1);     // Catch: Throwable -> L81
        if (r1.isReadOnly() == false) goto L74;
        Log.w(TAG, "Opened " + this.mName + " in read-only mode");     // Catch: Throwable -> L81
    L74:
        this.mDatabase = r1;     // Catch: Throwable -> L81
        this.mIsInitializing = false;
        if (r1 == null) goto L79;
        if (r1 == r1) goto L79;
        r1.close();
    L79:
        return r1;
    L42:
        if (r1.isReadOnly() == true) goto L70;
        if (r2 > 0) goto L45;
    L57:
        r1.beginTransaction();     // Catch: Throwable -> L81
        if (r2 != 0) goto L60;
        onCreate(r1);     // Catch: Throwable -> L66
    L64:
        r1.setVersion(this.mNewVersion);     // Catch: Throwable -> L66
        r1.setTransactionSuccessful();     // Catch: Throwable -> L66
        r1.endTransaction();     // Catch: Throwable -> L81
        goto L71
    L60:
        int r12 = this.mNewVersion;     // Catch: Throwable -> L66
        if (r2 <= r12) goto L63;
        onDowngrade(r1, r2, r12);     // Catch: Throwable -> L66
        goto L64
    L63:
        onUpgrade(r1, r2, r12);     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        r1.endTransaction();     // Catch: Throwable -> L81
        throw th;     // Catch: Throwable -> L81
    L45:
        if (r2 >= this.mMinimumSupportedVersion) goto L57;
        File r3 = new File(r1.getPath());     // Catch: Throwable -> L81
        onBeforeDelete(r1);     // Catch: Throwable -> L81
        r1.close();     // Catch: Throwable -> L81
        if (SQLiteDatabase.deleteDatabase(r3) == false) goto L56;
        this.mIsInitializing = false;     // Catch: Throwable -> L81
        SQLiteDatabase r13 = getDatabaseLocked(r11);     // Catch: Throwable -> L81
        this.mIsInitializing = false;
        if (r1 != null) goto L52;
    L54:
        return r13;
    L52:
        if (r1 == this.mDatabase) goto L54;
        r1.close();
        goto L54
    L56:
        throw new IllegalStateException("Unable to delete obsolete database " + this.mName + " with version " + r2);     // Catch: Throwable -> L81
    L70:
        throw new SQLiteException("Can't upgrade read-only database from version " + r1.getVersion() + " to " + this.mNewVersion + ": " + this.mName);     // Catch: Throwable -> L81
    L19:
        if (r1.isReadOnly() == false) goto L39;
        r1.reopenReadWrite();     // Catch: Throwable -> L81
        goto L39
    L21:
        String r4 = this.mName;     // Catch: Throwable -> L81
        if (r4 != null) goto L93;
        r1 = SQLiteDatabase.create(null);     // Catch: Throwable -> L81
        goto L39
    L93:
    L36:
        e = move-exception;
        if (r11 == true) goto L80;
        Log.e(TAG, "Couldn't open " + this.mName + " for writing (will try read-only):", e);     // Catch: Throwable -> L81
        r1 = SQLiteDatabase.openDatabase(this.mContext.getDatabasePath(this.mName).getPath(), this.mPassword, this.mFactory, 1, this.mErrorHandler, this.mDatabaseHook);     // Catch: Throwable -> L81
        goto L39
    L80:
        throw e;     // Catch: Throwable -> L81
    L26:
        if (r4.startsWith("file:") == true) goto L28;
        r4 = this.mContext.getDatabasePath(r4).getPath();     // Catch: SQLiteException -> L36 Throwable -> L81
    L28:
        String r5 = r4;
        File r6 = new File(new File(r5).getParent());     // Catch: SQLiteException -> L36 Throwable -> L81
        if (r6.exists() == true) goto L31;
        r6.mkdirs();     // Catch: SQLiteException -> L36 Throwable -> L81
    L31:
        int r7 = SQLiteDatabase.CREATE_IF_NECESSARY;
        if (this.mEnableWriteAheadLogging == false) goto L34;
        r7 = 805306368;
    L34:
        r1 = SQLiteDatabase.openDatabase(r5, this.mPassword, this.mFactory, r7, this.mErrorHandler, this.mDatabaseHook);     // Catch: SQLiteException -> L36 Throwable -> L81
    L81:
        th = move-exception;
        this.mIsInitializing = false;
        if (r1 != null) goto L85;
    L87:
        throw th;
    L85:
        if (r1 == this.mDatabase) goto L87;
        r1.close();
        goto L87
    L89:
        throw new IllegalStateException("getDatabase called recursively");
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsInitializing == true) goto L13;
        SQLiteDatabase r0 = this.mDatabase;     // Catch: Throwable -> L14
        if (r0 != null) goto L8;
    L10:
        monitor-exit(this);
        return;
    L8:
        if (r0.isOpen() == false) goto L10;
        this.mDatabase.close();     // Catch: Throwable -> L14
        this.mDatabase = null;     // Catch: Throwable -> L14
        goto L10
    L13:
        throw new IllegalStateException("Closed during initialization");     // Catch: Throwable -> L14
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.mName;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public /* bridge */ /* synthetic */ SupportSQLiteDatabase getReadableDatabase() {
        return getReadableDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SQLiteDatabase getReadableDatabase() {
        monitor-enter(this);
        SQLiteDatabase r0 = getDatabaseLocked(false);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public /* bridge */ /* synthetic */ SupportSQLiteDatabase getWritableDatabase() {
        return getWritableDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        monitor-enter(this);
        SQLiteDatabase r0 = getDatabaseLocked(true);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public void onBeforeDelete(SQLiteDatabase r1) {
    }

    public void onConfigure(SQLiteDatabase r1) {
    }

    public abstract void onCreate(SQLiteDatabase r1);

    public void onDowngrade(SQLiteDatabase r2, int r3, int r4) {
        throw new SQLiteException("Can't downgrade database from version " + r3 + " to " + r4);
    }

    public void onOpen(SQLiteDatabase r1) {
    }

    public abstract void onUpgrade(SQLiteDatabase r1, int r2, int r3);

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean r2) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.mEnableWriteAheadLogging == r2) goto L15;
        SQLiteDatabase r0 = this.mDatabase;     // Catch: Throwable -> L17
        if (r0 != null) goto L8;
    L14:
        this.mEnableWriteAheadLogging = r2;     // Catch: Throwable -> L17
        goto L15
    L8:
        if (r0.isOpen() == false) goto L14;
        if (this.mDatabase.isReadOnly() == true) goto L14;
        if (r2 == false) goto L13;
        this.mDatabase.enableWriteAheadLogging();     // Catch: Throwable -> L17
        goto L14
    L13:
        this.mDatabase.disableWriteAheadLogging();     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);     // Catch: Throwable -> L17
    }
}
