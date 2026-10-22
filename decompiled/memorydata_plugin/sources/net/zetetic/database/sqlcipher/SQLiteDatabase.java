package net.zetetic.database.sqlcipher;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteException;
import android.os.CancellationSignal;
import android.os.Looper;
import android.text.TextUtils;
import android.util.EventLog;
import android.util.Log;
import android.util.Pair;
import android.util.Printer;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.rpc.internal.RpcUtils;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import net.zetetic.database.DatabaseErrorHandler;
import net.zetetic.database.DatabaseUtils;
import net.zetetic.database.DefaultDatabaseErrorHandler;

/* JADX INFO: loaded from: classes6.dex */
public final class SQLiteDatabase extends SQLiteClosable implements SupportSQLiteDatabase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CONFLICT_ABORT = 2;
    public static final int CONFLICT_FAIL = 3;
    public static final int CONFLICT_IGNORE = 4;
    public static final int CONFLICT_NONE = 0;
    public static final int CONFLICT_REPLACE = 5;
    public static final int CONFLICT_ROLLBACK = 1;
    private static final String[] CONFLICT_VALUES = null;
    public static final int CREATE_IF_NECESSARY = 268435456;
    public static final int ENABLE_WRITE_AHEAD_LOGGING = 536870912;
    private static final int EVENT_DB_CORRUPT = 75004;
    public static final int MAX_SQL_CACHE_SIZE = 100;
    public static final int NO_LOCALIZED_COLLATORS = 16;
    public static final int OPEN_READONLY = 1;
    public static final int OPEN_READWRITE = 0;
    private static final int OPEN_READ_MASK = 1;
    public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000;
    private static final String TAG = "SQLiteDatabase";
    private static WeakHashMap<SQLiteDatabase, Object> sActiveDatabases;
    private final CloseGuard mCloseGuardLocked;
    private final SQLiteDatabaseConfiguration mConfigurationLocked;
    private SQLiteConnectionPool mConnectionPoolLocked;
    private final CursorFactory mCursorFactory;
    private final DatabaseErrorHandler mErrorHandler;
    private boolean mHasAttachedDbsLocked;
    private final Object mLock;
    private final ThreadLocal<SQLiteSession> mThreadSession;

    public interface CursorFactory {
        Cursor newCursor(SQLiteDatabase r1, SQLiteCursorDriver r2, String r3, SQLiteQuery r4);
    }

    public interface CustomFunction {
        void callback(String[] r1);
    }

    static {
        sActiveDatabases = new WeakHashMap();
        CONFLICT_VALUES = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    }

    private SQLiteDatabase(String r3, byte[] r4, int r5, CursorFactory r6, DatabaseErrorHandler r7, SQLiteDatabaseHook r8) {
        CursorFactory r9 = (CursorFactory) ZeusTransformUtils.wrapperContextForParams(r6, CursorFactory.class, "com.obric.memorydata.plugin");
        DatabaseErrorHandler r10 = (DatabaseErrorHandler) ZeusTransformUtils.wrapperContextForParams(r7, DatabaseErrorHandler.class, "com.obric.memorydata.plugin");
        SQLiteDatabaseHook r11 = (SQLiteDatabaseHook) ZeusTransformUtils.wrapperContextForParams(r8, SQLiteDatabaseHook.class, "com.obric.memorydata.plugin");
        this.mThreadSession = new AnonymousClass1(this);
        this.mLock = new Object();
        this.mCloseGuardLocked = CloseGuard.get();
        this.mCursorFactory = r9;
        if (r10 != null) goto L6;
        r10 = new DefaultDatabaseErrorHandler();
    L6:
        this.mErrorHandler = r10;
        this.mConfigurationLocked = new SQLiteDatabaseConfiguration(r3, r5, r4, r11);
    }

    private void beginTransaction(SQLiteTransactionListener r4, boolean r5) {
        SQLiteTransactionListener r6 = (SQLiteTransactionListener) ZeusTransformUtils.wrapperContextForParams(r4, SQLiteTransactionListener.class, "com.obric.memorydata.plugin");
        acquireReference();
        SQLiteSession r0 = getThreadSession();     // Catch: Throwable -> L10
        if (r5 == false) goto L6;
        int r7 = 2;
    L7:
        r0.beginTransaction(r7, r6, getThreadDefaultConnectionFlags(false), null);     // Catch: Throwable -> L10
        releaseReference();
        return;
    L6:
        r7 = 1;
    L10:
        th = move-exception;
        releaseReference();
        throw th;
    }

    private void collectDbStats(ArrayList<SQLiteDebug.DbStats> r2) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SQLiteConnectionPool r1 = this.mConnectionPoolLocked;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.collectDbStats(r2);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static SQLiteDatabase create(CursorFactory r2) {
        return openDatabase(SQLiteDatabaseConfiguration.MEMORY_DB_PATH, (CursorFactory) ZeusTransformUtils.wrapperContextForParams(r2, CursorFactory.class, "com.obric.memorydata.plugin"), CREATE_IF_NECESSARY);
    }

    public static boolean deleteDatabase(File r5) {
        if (r5 == null) goto L12;
        int r1 = 0;
        boolean r0 = (((r5.delete() | false) | new File(r5.getPath() + "-journal").delete()) | new File(r5.getPath() + "-shm").delete()) | new File(r5.getPath() + "-wal").delete();
        File r2 = r5.getParentFile();
        if (r2 == null) goto L10;
        final String r6 = r5.getName() + "-mj";
        File[] r7 = r2.listFiles(new AnonymousClass4(r6));
        if (r7 == null) goto L10;
        int r3 = r7.length;
    L8:
        if (r1 >= r3) goto L10;
        r0 = r0 | r7[r1].delete();
        r1 = r1 + 1;
    L10:
        return r0;
    L12:
        throw new IllegalArgumentException("file must not be null");
    }

    private void dispose(boolean r4) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CloseGuard r1 = this.mCloseGuardLocked;     // Catch: Throwable -> L22
        if (r1 == null) goto L9;
        if (r4 == false) goto L8;
        r1.warnIfOpen();     // Catch: Throwable -> L22
    L8:
        this.mCloseGuardLocked.close();     // Catch: Throwable -> L22
    L9:
        SQLiteConnectionPool r2 = this.mConnectionPoolLocked;     // Catch: Throwable -> L22
        this.mConnectionPoolLocked = null;     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
        if (r4 == true) goto L21;
        WeakHashMap<SQLiteDatabase, Object> r5 = sActiveDatabases;
        monitor-enter(r5);
        sActiveDatabases.remove(this);     // Catch: Throwable -> L18
        monitor-exit(r5);     // Catch: Throwable -> L18
        if (r2 == null) goto L29;
        r2.close();
        return;
    L29:
        return;
    L18:
        th = move-exception;
        throw th;
    L21:
        return;
    L22:
        th = move-exception;
        throw th;
    }

    private void dump(Printer r3, boolean r4) {
        Printer r5 = (Printer) ZeusTransformUtils.wrapperContextForParams(r3, Printer.class, "com.obric.memorydata.plugin");
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mConnectionPoolLocked == null) goto L7;
        r5.println("");     // Catch: Throwable -> L9
        this.mConnectionPoolLocked.dump(r5, r4);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    static void dumpAll(Printer r4, boolean r5) {
        Printer r6 = (Printer) ZeusTransformUtils.wrapperContextForParams(r4, Printer.class, "com.obric.memorydata.plugin");
        Iterator<SQLiteDatabase> r0 = getActiveDatabases().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((SQLiteDatabase) ZeusTransformUtils.preCheckCast(r0.next(), SQLiteDatabase.class, "com.obric.memorydata.plugin")).dump(r6, r5);
        goto L4
    }

    private int executeSql(String r5, Object[] r6) {
        acquireReference();
    L25:
        th = move-exception;
        releaseReference();
        throw th;
    L4:
        if (DatabaseUtils.a(r5) != 3) goto L17;
        boolean r0 = false;
        Object r1 = this.mLock;     // Catch: Throwable -> L25
        monitor-enter(r1);     // Catch: Throwable -> L25
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L8:
        if (this.mHasAttachedDbsLocked == true) goto L10;
        this.mHasAttachedDbsLocked = true;     // Catch: Throwable -> L14
        r0 = true;
    L10:
        monitor-exit(r1);     // Catch: Throwable -> L14
        if (r0 == false) goto L17;
        disableWriteAheadLogging();     // Catch: Throwable -> L25
        goto L17
    L17:
        SQLiteStatement r2 = new SQLiteStatement(this, r5, r6);     // Catch: Throwable -> L25
        int r7 = r2.executeUpdateDelete();     // Catch: Throwable -> L22
        r2.close();     // Catch: Throwable -> L25
        releaseReference();
        return r7;
    L22:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    }

    public static String findEditTable(String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L16;
        int r0 = r3.indexOf(32);
        int r1 = r3.indexOf(44);
        if (r0 <= 0) goto L10;
        if (r0 < r1) goto L9;
        if (r1 >= 0) goto L10;
    L9:
        return r3.substring(0, r0);
    L10:
        if (r1 <= 0) goto L17;
        if (r1 < r0) goto L14;
        if (r0 < 0) goto L14;
        return r3;
    L14:
        return r3.substring(0, r1);
    L17:
        return r3;
    L16:
        throw new IllegalStateException("Invalid tables");
    }

    private static ArrayList<SQLiteDatabase> getActiveDatabases() {
        ArrayList<SQLiteDatabase> r0 = new ArrayList();
        WeakHashMap<SQLiteDatabase, Object> r1 = sActiveDatabases;
        monitor-enter(r1);
        r0.addAll(sActiveDatabases.keySet());     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    private static byte[] getBytes(String r1) {
        if (r1 == null) goto L9;
        if (r1.length() == 0) goto L9;
        return r1.getBytes(Charset.forName(RpcUtils.CHARSET_UTF8));
    L9:
        return new byte[0];
    }

    static ArrayList<SQLiteDebug.DbStats> getDbStats() {
        ArrayList<SQLiteDebug.DbStats> r0 = new ArrayList();
        Iterator<SQLiteDatabase> r1 = getActiveDatabases().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((SQLiteDatabase) ZeusTransformUtils.preCheckCast(r1.next(), SQLiteDatabase.class, "com.obric.memorydata.plugin")).collectDbStats(r0);
        goto L4
    L6:
        return r0;
    }

    public static boolean hasCodec() {
        return SQLiteConnection.hasCodec();
    }

    private static boolean isMainThread() {
        Looper r0 = Looper.myLooper();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0 != Looper.getMainLooper()) goto L7;
        return true;
    }

    private boolean isReadOnlyLocked() {
        if ((this.mConfigurationLocked.openFlags & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void open() {
        openInner();     // Catch: SQLiteException -> L4 SQLiteDatabaseCorruptException -> L6
    L13:
        return;
    L6:
        onCorruption();     // Catch: SQLiteException -> L4
        openInner();     // Catch: SQLiteException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "Failed to open database '" + getLabel() + "'.", e);
        close();
        throw e;
    }

    public static SQLiteDatabase openDatabase(String r8, String r9, CursorFactory r10, int r11, DatabaseErrorHandler r12, SQLiteDatabaseHook r13) {
        CursorFactory r4 = (CursorFactory) ZeusTransformUtils.wrapperContextForParams(r10, CursorFactory.class, "com.obric.memorydata.plugin");
        DatabaseErrorHandler r6 = (DatabaseErrorHandler) ZeusTransformUtils.wrapperContextForParams(r12, DatabaseErrorHandler.class, "com.obric.memorydata.plugin");
        SQLiteDatabaseHook r7 = (SQLiteDatabaseHook) ZeusTransformUtils.wrapperContextForParams(r13, SQLiteDatabaseHook.class, "com.obric.memorydata.plugin");
        return openDatabase(r8, getBytes(r9), r4, r11, r6, r7);
    }

    public static SQLiteDatabase openDatabase(String r8, String r9, CursorFactory r10, int r11, SQLiteDatabaseHook r12) {
        CursorFactory r4 = (CursorFactory) ZeusTransformUtils.wrapperContextForParams(r10, CursorFactory.class, "com.obric.memorydata.plugin");
        SQLiteDatabaseHook r7 = (SQLiteDatabaseHook) ZeusTransformUtils.wrapperContextForParams(r12, SQLiteDatabaseHook.class, "com.obric.memorydata.plugin");
        return openDatabase(r8, getBytes(r9), r4, r11, null, r7);
    }

    public static SQLiteDatabase openDatabase(String r2, CursorFactory r3, int r4) {
        return openDatabase(r2, (CursorFactory) ZeusTransformUtils.wrapperContextForParams(r3, CursorFactory.class, "com.obric.memorydata.plugin"), r4, null);
    }

    public static SQLiteDatabase openDatabase(String r8, CursorFactory r9, int r10, DatabaseErrorHandler r11) {
        byte[] r3 = new byte[0];
        return openDatabase(r8, r3, (CursorFactory) ZeusTransformUtils.wrapperContextForParams(r9, CursorFactory.class, "com.obric.memorydata.plugin"), r10, (DatabaseErrorHandler) ZeusTransformUtils.wrapperContextForParams(r11, DatabaseErrorHandler.class, "com.obric.memorydata.plugin"), null);
    }

    public static SQLiteDatabase openDatabase(String r9, byte[] r10, CursorFactory r11, int r12, DatabaseErrorHandler r13, SQLiteDatabaseHook r14) {
        SQLiteDatabase r15 = new SQLiteDatabase(r9, r10, r12, (CursorFactory) ZeusTransformUtils.wrapperContextForParams(r11, CursorFactory.class, "com.obric.memorydata.plugin"), (DatabaseErrorHandler) ZeusTransformUtils.wrapperContextForParams(r13, DatabaseErrorHandler.class, "com.obric.memorydata.plugin"), (SQLiteDatabaseHook) ZeusTransformUtils.wrapperContextForParams(r14, SQLiteDatabaseHook.class, "com.obric.memorydata.plugin"));
        r15.open();
        return r15;
    }

    public static SQLiteDatabase openDatabase(String r8, byte[] r9, CursorFactory r10, int r11, SQLiteDatabaseHook r12) {
        return openDatabase(r8, r9, (CursorFactory) ZeusTransformUtils.wrapperContextForParams(r10, CursorFactory.class, "com.obric.memorydata.plugin"), r11, null, (SQLiteDatabaseHook) ZeusTransformUtils.wrapperContextForParams(r12, SQLiteDatabaseHook.class, "com.obric.memorydata.plugin"));
    }

    private void openInner() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mConnectionPoolLocked = SQLiteConnectionPool.open(this.mConfigurationLocked);     // Catch: Throwable -> L16
        this.mCloseGuardLocked.open(IslandSession.REOPEN_VALUE_CLOSE);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        WeakHashMap<SQLiteDatabase, Object> r1 = sActiveDatabases;
        monitor-enter(r1);
        sActiveDatabases.put(this, null);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        throw th;
    }

    public static SQLiteDatabase openOrCreateDatabase(File r8, String r9, CursorFactory r10, DatabaseErrorHandler r11) {
        CursorFactory r4 = (CursorFactory) ZeusTransformUtils.wrapperContextForParams(r10, CursorFactory.class, "com.obric.memorydata.plugin");
        DatabaseErrorHandler r6 = (DatabaseErrorHandler) ZeusTransformUtils.wrapperContextForParams(r11, DatabaseErrorHandler.class, "com.obric.memorydata.plugin");
        return openDatabase(r8.getAbsolutePath(), r9, r4, CREATE_IF_NECESSARY, r6, null);
    }

    public static SQLiteDatabase openOrCreateDatabase(File r8, String r9, CursorFactory r10, DatabaseErrorHandler r11, SQLiteDatabaseHook r12) {
        CursorFactory r4 = (CursorFactory) ZeusTransformUtils.wrapperContextForParams(r10, CursorFactory.class, "com.obric.memorydata.plugin");
        DatabaseErrorHandler r6 = (DatabaseErrorHandler) ZeusTransformUtils.wrapperContextForParams(r11, DatabaseErrorHandler.class, "com.obric.memorydata.plugin");
        SQLiteDatabaseHook r7 = (SQLiteDatabaseHook) ZeusTransformUtils.wrapperContextForParams(r12, SQLiteDatabaseHook.class, "com.obric.memorydata.plugin");
        return openDatabase(r8.getAbsolutePath(), r9, r4, CREATE_IF_NECESSARY, r6, r7);
    }

    public static SQLiteDatabase openOrCreateDatabase(File r2, CursorFactory r3) {
        CursorFactory r4 = (CursorFactory) ZeusTransformUtils.wrapperContextForParams(r3, CursorFactory.class, "com.obric.memorydata.plugin");
        return openOrCreateDatabase(r2.getPath(), r4);
    }

    public static SQLiteDatabase openOrCreateDatabase(File r8, byte[] r9, CursorFactory r10, DatabaseErrorHandler r11) {
        CursorFactory r4 = (CursorFactory) ZeusTransformUtils.wrapperContextForParams(r10, CursorFactory.class, "com.obric.memorydata.plugin");
        DatabaseErrorHandler r6 = (DatabaseErrorHandler) ZeusTransformUtils.wrapperContextForParams(r11, DatabaseErrorHandler.class, "com.obric.memorydata.plugin");
        return openDatabase(r8.getAbsolutePath(), r9, r4, CREATE_IF_NECESSARY, r6, null);
    }

    public static SQLiteDatabase openOrCreateDatabase(File r8, byte[] r9, CursorFactory r10, DatabaseErrorHandler r11, SQLiteDatabaseHook r12) {
        CursorFactory r4 = (CursorFactory) ZeusTransformUtils.wrapperContextForParams(r10, CursorFactory.class, "com.obric.memorydata.plugin");
        DatabaseErrorHandler r6 = (DatabaseErrorHandler) ZeusTransformUtils.wrapperContextForParams(r11, DatabaseErrorHandler.class, "com.obric.memorydata.plugin");
        SQLiteDatabaseHook r7 = (SQLiteDatabaseHook) ZeusTransformUtils.wrapperContextForParams(r12, SQLiteDatabaseHook.class, "com.obric.memorydata.plugin");
        return openDatabase(r8.getAbsolutePath(), r9, r4, CREATE_IF_NECESSARY, r6, r7);
    }

    public static SQLiteDatabase openOrCreateDatabase(String r8, String r9, CursorFactory r10, DatabaseErrorHandler r11) {
        return openDatabase(r8, r9, (CursorFactory) ZeusTransformUtils.wrapperContextForParams(r10, CursorFactory.class, "com.obric.memorydata.plugin"), CREATE_IF_NECESSARY, (DatabaseErrorHandler) ZeusTransformUtils.wrapperContextForParams(r11, DatabaseErrorHandler.class, "com.obric.memorydata.plugin"), null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String r8, String r9, CursorFactory r10, DatabaseErrorHandler r11, SQLiteDatabaseHook r12) {
        return openDatabase(r8, r9, (CursorFactory) ZeusTransformUtils.wrapperContextForParams(r10, CursorFactory.class, "com.obric.memorydata.plugin"), CREATE_IF_NECESSARY, (DatabaseErrorHandler) ZeusTransformUtils.wrapperContextForParams(r11, DatabaseErrorHandler.class, "com.obric.memorydata.plugin"), (SQLiteDatabaseHook) ZeusTransformUtils.wrapperContextForParams(r12, SQLiteDatabaseHook.class, "com.obric.memorydata.plugin"));
    }

    public static SQLiteDatabase openOrCreateDatabase(String r2, CursorFactory r3) {
        return openDatabase(r2, (CursorFactory) ZeusTransformUtils.wrapperContextForParams(r3, CursorFactory.class, "com.obric.memorydata.plugin"), CREATE_IF_NECESSARY, null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String r2, CursorFactory r3, DatabaseErrorHandler r4) {
        return openDatabase(r2, (CursorFactory) ZeusTransformUtils.wrapperContextForParams(r3, CursorFactory.class, "com.obric.memorydata.plugin"), CREATE_IF_NECESSARY, (DatabaseErrorHandler) ZeusTransformUtils.wrapperContextForParams(r4, DatabaseErrorHandler.class, "com.obric.memorydata.plugin"));
    }

    public static SQLiteDatabase openOrCreateDatabase(String r8, byte[] r9, CursorFactory r10, DatabaseErrorHandler r11) {
        return openDatabase(r8, r9, (CursorFactory) ZeusTransformUtils.wrapperContextForParams(r10, CursorFactory.class, "com.obric.memorydata.plugin"), CREATE_IF_NECESSARY, (DatabaseErrorHandler) ZeusTransformUtils.wrapperContextForParams(r11, DatabaseErrorHandler.class, "com.obric.memorydata.plugin"), null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String r8, byte[] r9, CursorFactory r10, DatabaseErrorHandler r11, SQLiteDatabaseHook r12) {
        return openDatabase(r8, r9, (CursorFactory) ZeusTransformUtils.wrapperContextForParams(r10, CursorFactory.class, "com.obric.memorydata.plugin"), CREATE_IF_NECESSARY, (DatabaseErrorHandler) ZeusTransformUtils.wrapperContextForParams(r11, DatabaseErrorHandler.class, "com.obric.memorydata.plugin"), (SQLiteDatabaseHook) ZeusTransformUtils.wrapperContextForParams(r12, SQLiteDatabaseHook.class, "com.obric.memorydata.plugin"));
    }

    public static int releaseMemory() {
        return SQLiteGlobal.releaseMemory();
    }

    private void throwIfNotOpenLocked() {
        if (this.mConnectionPoolLocked == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("The database '" + this.mConfigurationLocked.label + "' is not open.");
    }

    private boolean yieldIfContendedHelper(boolean r3, long r4) {
        acquireReference();
        boolean r5 = getThreadSession().yieldTransaction(r4, r3, null);     // Catch: Throwable -> L6
        releaseReference();
        return r5;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public void addCustomFunction(String r3, int r4, CustomFunction r5) {
        SQLiteCustomFunction r0 = new SQLiteCustomFunction(r3, r4, (CustomFunction) ZeusTransformUtils.wrapperContextForParams(r5, CustomFunction.class, "com.obric.memorydata.plugin"));
        Object r6 = this.mLock;
        monitor-enter(r6);
        throwIfNotOpenLocked();     // Catch: Throwable -> L11
        this.mConfigurationLocked.customFunctions.add(r0);     // Catch: Throwable -> L11
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);     // Catch: RuntimeException -> L8 Throwable -> L11
        monitor-exit(r6);     // Catch: Throwable -> L11
        return;
    L8:
        e = move-exception;
        this.mConfigurationLocked.customFunctions.remove(r0);     // Catch: Throwable -> L11
        throw e;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransaction() {
        beginTransaction(null, true);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        beginTransaction(null, false);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListener(android.database.sqlite.SQLiteTransactionListener r3) {
        final android.database.sqlite.SQLiteTransactionListener r4 = (android.database.sqlite.SQLiteTransactionListener) ZeusTransformUtils.wrapperContextForParams(r3, android.database.sqlite.SQLiteTransactionListener.class, "com.obric.memorydata.plugin");
        beginTransaction(new AnonymousClass2(this, r4), true);
    }

    public void beginTransactionWithListener(SQLiteTransactionListener r3) {
        beginTransaction((SQLiteTransactionListener) ZeusTransformUtils.wrapperContextForParams(r3, SQLiteTransactionListener.class, "com.obric.memorydata.plugin"), true);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(android.database.sqlite.SQLiteTransactionListener r3) {
        final android.database.sqlite.SQLiteTransactionListener r4 = (android.database.sqlite.SQLiteTransactionListener) ZeusTransformUtils.wrapperContextForParams(r3, android.database.sqlite.SQLiteTransactionListener.class, "com.obric.memorydata.plugin");
        beginTransactionWithListenerNonExclusive(new AnonymousClass3(this, r4));
    }

    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener r3) {
        beginTransaction((SQLiteTransactionListener) ZeusTransformUtils.wrapperContextForParams(r3, SQLiteTransactionListener.class, "com.obric.memorydata.plugin"), false);
    }

    public void changePassword(String r1) {
        changePassword(getBytes(r1));
    }

    public void changePassword(byte[] r4) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfNotOpenLocked();     // Catch: Throwable -> L19
        if (isReadOnlyLocked() == true) goto L18;
        if (this.mConfigurationLocked.isInMemoryDb() == true) goto L16;
        byte[] r1 = this.mConfigurationLocked.password;     // Catch: Throwable -> L19
        this.mConfigurationLocked.password = r4;     // Catch: Throwable -> L19
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);     // Catch: RuntimeException -> L12 Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L12:
        e = move-exception;
        this.mConfigurationLocked.password = r1;     // Catch: Throwable -> L19
        throw e;     // Catch: Throwable -> L19
    L16:
        throw new IllegalStateException("Can't change password for in-memory databases.");     // Catch: Throwable -> L19
    L18:
        throw new IllegalStateException("Can't change password for readonly databases.");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public /* bridge */ /* synthetic */ SupportSQLiteStatement compileStatement(String r1) {
        return compileStatement(r1);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public SQLiteStatement compileStatement(String r3) {
        acquireReference();
        SQLiteStatement r0 = new SQLiteStatement(this, r3, null);     // Catch: Throwable -> L6
        releaseReference();
        return r0;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    SQLiteSession createSession() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfNotOpenLocked();     // Catch: Throwable -> L8
        SQLiteConnectionPool r1 = this.mConnectionPoolLocked;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return new SQLiteSession(r1);
    L8:
        th = move-exception;
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(String r4, String r5, Object[] r6) {
        String[] r0 = new String[r6.length];
        int r1 = 0;
    L4:
        if (r1 >= r6.length) goto L7;
        r0[r1] = r6[r1].toString();
        r1 = r1 + 1;
        goto L4
    L7:
        return delete(r4, r5, r0);
    }

    public int delete(String r4, String r5, String[] r6) {
        acquireReference();
        StringBuilder r7 = new StringBuilder().append("DELETE FROM ").append(r4);     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r5) == true) goto L6;
        String r8 = " WHERE " + r5;     // Catch: Throwable -> L15
    L7:
        SQLiteStatement r0 = new SQLiteStatement(this, r7.append(r8).toString(), r6);     // Catch: Throwable -> L15
        int r9 = r0.executeUpdateDelete();     // Catch: Throwable -> L12
        r0.close();     // Catch: Throwable -> L15
        releaseReference();
        return r9;
    L12:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L6:
        r8 = "";
    L15:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void disableWriteAheadLogging() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfNotOpenLocked();     // Catch: Throwable -> L15
        if ((this.mConfigurationLocked.openFlags & ENABLE_WRITE_AHEAD_LOGGING) != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L8:
        this.mConfigurationLocked.openFlags &= -536870913;     // Catch: Throwable -> L15
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);     // Catch: RuntimeException -> L12 Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L12:
        e = move-exception;
        SQLiteDatabaseConfiguration r5 = this.mConfigurationLocked;     // Catch: Throwable -> L15
        r5.openFlags = 536870912 | r5.openFlags;     // Catch: Throwable -> L15
        throw e;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public void enableLocalizedCollators() {
        this.mConnectionPoolLocked.enableLocalizedCollators();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean enableWriteAheadLogging() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfNotOpenLocked();     // Catch: Throwable -> L31
        if ((this.mConfigurationLocked.openFlags & ENABLE_WRITE_AHEAD_LOGGING) == 0) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L31
        return true;
    L9:
        if (isReadOnlyLocked() == false) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L31
        return false;
    L13:
        if (this.mConfigurationLocked.isInMemoryDb() == false) goto L18;
        Log.i(TAG, "can't enable WAL for memory databases.");     // Catch: Throwable -> L31
        monitor-exit(r0);     // Catch: Throwable -> L31
        return false;
    L18:
        if (this.mHasAttachedDbsLocked == true) goto L20;
        SQLiteDatabaseConfiguration r1 = this.mConfigurationLocked;     // Catch: Throwable -> L31
        r1.openFlags = 536870912 | r1.openFlags;     // Catch: Throwable -> L31
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);     // Catch: RuntimeException -> L28 Throwable -> L31
        monitor-exit(r0);     // Catch: Throwable -> L31
        return true;
    L28:
        e = move-exception;
        this.mConfigurationLocked.openFlags &= -536870913;     // Catch: Throwable -> L31
        throw e;     // Catch: Throwable -> L31
    L20:
        if (Log.isLoggable(TAG, 3) == false) goto L22;
        Log.d(TAG, "this database: " + this.mConfigurationLocked.label + " has attached databases. can't  enable WAL.");     // Catch: Throwable -> L31
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L31
        return false;
    L31:
        th = move-exception;
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void endTransaction() {
        acquireReference();
        getThreadSession().endTransaction(null);     // Catch: Throwable -> L6
        releaseReference();
        return;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String r2) {
        executeSql(r2, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String r1, Object[] r2) {
        if (r2 == null) goto L6;
        executeSql(r1, r2);
        return;
    L6:
        throw new IllegalArgumentException("Empty bindArgs");
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

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public List<Pair<String, String>> getAttachedDbs() {
        ArrayList r0 = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        Cursor r3 = null;
        if (this.mConnectionPoolLocked != null) goto L9;
        monitor-exit(r1);     // Catch: Throwable -> L31
        return null;
    L9:
        if (this.mHasAttachedDbsLocked == true) goto L13;
        r0.add(new Pair("main", this.mConfigurationLocked.path));     // Catch: Throwable -> L31
        monitor-exit(r1);     // Catch: Throwable -> L31
        return r0;
    L13:
        acquireReference();     // Catch: Throwable -> L31
        monitor-exit(r1);     // Catch: Throwable -> L31
        r3 = rawQuery("pragma database_list;", null);     // Catch: Throwable -> L24
    L17:
        if (r3.moveToNext() == false) goto L20;
        r0.add(new Pair(r3.getString(1), r3.getString(2)));     // Catch: Throwable -> L24
    L20:
        if (r3 == null) goto L22;
        r3.close();     // Catch: Throwable -> L28
    L22:
        releaseReference();
        return r0;
    L28:
        th = move-exception;
        releaseReference();
        throw th;
    L24:
        th = move-exception;
        if (r3 == null) goto L27;
        r3.close();     // Catch: Throwable -> L28
    L27:
        throw th;     // Catch: Throwable -> L28
    L31:
        th = move-exception;
        throw th;
    }

    String getLabel() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String r1 = this.mConfigurationLocked.label;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getMaximumSize() {
        return DatabaseUtils.a(this, "PRAGMA max_page_count;", null) * getPageSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getPageSize() {
        return DatabaseUtils.a(this, "PRAGMA page_size;", null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final String getPath() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String r1 = this.mConfigurationLocked.path;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public Map<String, String> getSyncedTables() {
        return new HashMap(0);
    }

    int getThreadDefaultConnectionFlags(boolean r1) {
        if (r1 == false) goto L4;
        int r0 = 1;
    L6:
        if (isMainThread() == true) goto L8;
        return r0;
    L8:
        return r0 | 4;
    L4:
        r0 = 2;
        goto L6
    }

    SQLiteSession getThreadSession() {
        return (SQLiteSession) ZeusTransformUtils.preCheckCast(this.mThreadSession.get(), SQLiteSession.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int getVersion() {
        return Long.valueOf(DatabaseUtils.a(this, "PRAGMA user_version;", null)).intValue();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean inTransaction() {
        acquireReference();
        boolean r0 = getThreadSession().hasTransaction();     // Catch: Throwable -> L6
        releaseReference();
        return r0;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long insert(String r2, int r3, ContentValues r4) {
        return insertWithOnConflict(r2, null, r4, r3);
    }

    public long insert(String r2, String r3, ContentValues r4) {
        return insertWithOnConflict(r2, r3, r4, 0);
    L5:
        e = move-exception;
        Log.e(TAG, "Error inserting", e);
        return -1;
    }

    public long insertOrThrow(String r2, String r3, ContentValues r4) {
        return insertWithOnConflict(r2, r3, r4, 0);
    }

    public long insertWithOnConflict(String r8, String r9, ContentValues r10, int r11) {
        acquireReference();
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L34
        r0.append("INSERT");     // Catch: Throwable -> L34
        r0.append(CONFLICT_VALUES[r11]);     // Catch: Throwable -> L34
        r0.append(" INTO ");     // Catch: Throwable -> L34
        r0.append(r8);     // Catch: Throwable -> L34
        r0.append('(');     // Catch: Throwable -> L34
        Object[] r12 = null;
        int r13 = 0;
        if (r10 != null) goto L6;
    L8:
        int r1 = 0;
    L10:
        if (r1 <= 0) goto L25;
        r12 = new Object[r1];     // Catch: Throwable -> L34
        Iterator<String> r14 = r10.keySet().iterator();     // Catch: Throwable -> L34
        int r3 = 0;
    L13:
        if (r14.hasNext() == false) goto L19;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        if (r3 <= 0) goto L17;
        String r5 = ",";
    L18:
        r0.append(r5);     // Catch: Throwable -> L34
        r0.append(r4);     // Catch: Throwable -> L34
        r12[r3] = r10.get(r4);     // Catch: Throwable -> L34
        r3 = r3 + 1;     // Catch: Throwable -> L34
        goto L13
    L17:
        r5 = "";
        goto L18
    L19:
        r0.append(')');     // Catch: Throwable -> L34
        r0.append(" VALUES (");     // Catch: Throwable -> L34
    L20:
        if (r13 >= r1) goto L26;
        if (r13 <= 0) goto L23;
        String r15 = ",?";
    L24:
        r0.append(r15);     // Catch: Throwable -> L34
        r13 = r13 + 1;     // Catch: Throwable -> L34
        goto L20
    L23:
        r15 = "?";
    L26:
        r0.append(')');     // Catch: Throwable -> L34
        SQLiteStatement r16 = new SQLiteStatement(this, r0.toString(), r12);     // Catch: Throwable -> L34
        long r17 = r16.executeInsert();     // Catch: Throwable -> L31
        r16.close();     // Catch: Throwable -> L34
        releaseReference();
        return r17;
    L31:
        th = move-exception;
        r16.close();     // Catch: Throwable -> L34
        throw th;     // Catch: Throwable -> L34
    L25:
        r0.append(r9 + ") VALUES (NULL");     // Catch: Throwable -> L34
        goto L26
    L6:
        if (r10.size() <= 0) goto L8;
        r1 = r10.size();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDatabaseIntegrityOk() {
        acquireReference();
        List<Pair<String, String>> r1 = getAttachedDbs();     // Catch: Throwable -> L8 SQLiteException -> L10
        if (r1 == null) goto L7;
    L11:
        int r3 = 0;
    L13:
        if (r3 >= r1.size()) goto L30;
        Pair r4 = (Pair) ZeusTransformUtils.preCheckCast(r1.get(r3), Pair.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        SQLiteStatement r5 = null;
        r5 = compileStatement("PRAGMA " + ((String) ZeusTransformUtils.preCheckCast(r4.first, String.class, "com.obric.memorydata.plugin")) + ".integrity_check(1);");     // Catch: Throwable -> L26
        String r6 = r5.simpleQueryForString();     // Catch: Throwable -> L26
        if (r6.equalsIgnoreCase("ok") == false) goto L18;
        if (r5 == null) goto L25;
        r5.close();     // Catch: Throwable -> L8
    L25:
        r3 = r3 + 1;     // Catch: Throwable -> L8
        goto L13
    L18:
        Log.e(TAG, "PRAGMA integrity_check on " + ((String) ZeusTransformUtils.preCheckCast(r4.second, String.class, "com.obric.memorydata.plugin")) + " returned: " + r6);     // Catch: Throwable -> L26
        if (r5 == null) goto L21;
        r5.close();     // Catch: Throwable -> L8
    L21:
        releaseReference();
        return false;
    L26:
        th = move-exception;
        if (r5 == null) goto L29;
        r5.close();     // Catch: Throwable -> L8
    L29:
        throw th;     // Catch: Throwable -> L8
    L30:
        releaseReference();
        return true;
    L7:
        throw new IllegalStateException("databaselist for: " + getPath() + " couldn't be retrieved. probably because the database is closed");     // Catch: Throwable -> L8 SQLiteException -> L10
    L10:
        r1 = new ArrayList();     // Catch: Throwable -> L8
        r1.add(new Pair("main", getPath()));     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDbLockedByCurrentThread() {
        acquireReference();
        boolean r0 = getThreadSession().hasConnection();     // Catch: Throwable -> L6
        releaseReference();
        return r0;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Deprecated
    public boolean isDbLockedByOtherThreads() {
        return false;
    }

    public boolean isInMemoryDatabase() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mConfigurationLocked.isInMemoryDb();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isOpen() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mConnectionPoolLocked == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isReadOnly() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = isReadOnlyLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isWriteAheadLoggingEnabled() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfNotOpenLocked();     // Catch: Throwable -> L10
        if ((this.mConfigurationLocked.openFlags & ENABLE_WRITE_AHEAD_LOGGING) == 0) goto L7;
        boolean r2 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = false;
    L10:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public void markTableSyncable(String r1, String r2) {
    }

    @Deprecated
    public void markTableSyncable(String r1, String r2, String r3) {
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean needUpgrade(int r1) {
        if (r1 <= getVersion()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // net.zetetic.database.sqlcipher.SQLiteClosable
    public void onAllReferencesReleased() {
        dispose(false);
    }

    void onCorruption() {
        EventLog.writeEvent(EVENT_DB_CORRUPT, getLabel());
        this.mErrorHandler.a(this);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(SupportSQLiteQuery r3) {
        return query((SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin"), null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(SupportSQLiteQuery r5, CancellationSignal r6) {
        SupportSQLiteQuery r7 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r5, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        acquireReference();
        String r1 = r7.getSql();     // Catch: Throwable -> L6
        SQLiteDirectCursorDriver r2 = new SQLiteDirectCursorDriver(this, r1, "", r6);     // Catch: Throwable -> L6
        SQLiteQuery r3 = new SQLiteQuery(this, r1, r6);     // Catch: Throwable -> L6
        r7.bindTo(r3);     // Catch: Throwable -> L6
        SQLiteCursor r8 = new SQLiteCursor(r2, "", r3);     // Catch: Throwable -> L6
        releaseReference();
        return r8;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String r2) {
        return rawQuery(r2, new Object[0]);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String r1, Object[] r2) {
        return rawQuery(r1, r2);
    }

    public Cursor query(String r11, String[] r12, String r13, String[] r14, String r15, String r16, String r17) {
        return query(false, r11, r12, r13, r14, r15, r16, r17, null);
    }

    public Cursor query(String r11, String[] r12, String r13, String[] r14, String r15, String r16, String r17, String r18) {
        return query(false, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public Cursor query(boolean r13, String r14, String[] r15, String r16, String[] r17, String r18, String r19, String r20, String r21) {
        return queryWithFactory(null, r13, r14, r15, r16, r17, r18, r19, r20, r21, null);
    }

    public Cursor query(boolean r13, String r14, String[] r15, String r16, String[] r17, String r18, String r19, String r20, String r21, CancellationSignal r22) {
        return queryWithFactory(null, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public Cursor queryWithFactory(CursorFactory r14, boolean r15, String r16, String[] r17, String r18, String[] r19, String r20, String r21, String r22, String r23) {
        return queryWithFactory((CursorFactory) ZeusTransformUtils.wrapperContextForParams(r14, CursorFactory.class, "com.obric.memorydata.plugin"), r15, r16, r17, r18, r19, r20, r21, r22, r23, null);
    }

    public Cursor queryWithFactory(CursorFactory r12, boolean r13, String r14, String[] r15, String r16, String[] r17, String r18, String r19, String r20, String r21, CancellationSignal r22) {
        CursorFactory r2 = (CursorFactory) ZeusTransformUtils.wrapperContextForParams(r12, CursorFactory.class, "com.obric.memorydata.plugin");
        acquireReference();
        Cursor r0 = rawQueryWithFactory(r2, SQLiteQueryBuilder.buildQueryString(r13, r14, r15, r16, r18, r19, r20, r21), r17, findEditTable(r14), r22);     // Catch: Throwable -> L6
        releaseReference();
        return r0;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public void rawExecSQL(String r2, Object... r3) {
        acquireReference();
        SQLiteStatement r0 = new SQLiteStatement(this, r2, r3);     // Catch: Throwable -> L11
        r0.executeRaw();     // Catch: Throwable -> L8
        r0.close();     // Catch: Throwable -> L11
        releaseReference();
        return;
    L8:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public Cursor rawQuery(String r3, Object... r4) {
        acquireReference();
        Cursor r5 = new SQLiteDirectCursorDriver(this, r3, null, null).query(this.mCursorFactory, r4);     // Catch: Throwable -> L6
        releaseReference();
        return r5;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public Cursor rawQuery(String r7, String[] r8) {
        return rawQueryWithFactory(null, r7, r8, null, null);
    }

    public Cursor rawQuery(String r7, String[] r8, CancellationSignal r9) {
        return rawQueryWithFactory(null, r7, r8, null, r9);
    }

    public Cursor rawQueryWithFactory(CursorFactory r7, String r8, String[] r9, String r10) {
        return rawQueryWithFactory((CursorFactory) ZeusTransformUtils.wrapperContextForParams(r7, CursorFactory.class, "com.obric.memorydata.plugin"), r8, r9, r10, null);
    }

    public Cursor rawQueryWithFactory(CursorFactory r3, String r4, String[] r5, String r6, CancellationSignal r7) {
        CursorFactory r8 = (CursorFactory) ZeusTransformUtils.wrapperContextForParams(r3, CursorFactory.class, "com.obric.memorydata.plugin");
        acquireReference();
        SQLiteDirectCursorDriver r0 = new SQLiteDirectCursorDriver(this, r4, r6, r7);     // Catch: Throwable -> L10
        if (r8 != null) goto L7;
        r8 = this.mCursorFactory;     // Catch: Throwable -> L10
    L7:
        Cursor r9 = r0.query(r8, r5);     // Catch: Throwable -> L10
        releaseReference();
        return r9;
    L10:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public void reopenReadWrite() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfNotOpenLocked();     // Catch: Throwable -> L15
        if (isReadOnlyLocked() == true) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L8:
        int r1 = this.mConfigurationLocked.openFlags;     // Catch: Throwable -> L15
        SQLiteDatabaseConfiguration r2 = this.mConfigurationLocked;     // Catch: Throwable -> L15
        r2.openFlags = (r2.openFlags & (-2)) | 0;     // Catch: Throwable -> L15
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);     // Catch: RuntimeException -> L12 Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L12:
        e = move-exception;
        this.mConfigurationLocked.openFlags = r1;     // Catch: Throwable -> L15
        throw e;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public long replace(String r2, String r3, ContentValues r4) {
        return insertWithOnConflict(r2, r3, r4, 5);
    L5:
        e = move-exception;
        Log.e(TAG, "Error inserting", e);
        return -1;
    }

    public long replaceOrThrow(String r2, String r3, ContentValues r4) {
        return insertWithOnConflict(r2, r3, r4, 5);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setForeignKeyConstraintsEnabled(boolean r4) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfNotOpenLocked();     // Catch: Throwable -> L19
        if (this.mConfigurationLocked.foreignKeyConstraintsEnabled != r4) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L8:
        this.mConfigurationLocked.foreignKeyConstraintsEnabled = r4;     // Catch: Throwable -> L19
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);     // Catch: RuntimeException -> L12 Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L12:
        e = move-exception;
        SQLiteDatabaseConfiguration r3 = this.mConfigurationLocked;     // Catch: Throwable -> L19
        if (r4 == true) goto L16;
        boolean r5 = true;
    L17:
        r3.foreignKeyConstraintsEnabled = r5;     // Catch: Throwable -> L19
        throw e;     // Catch: Throwable -> L19
    L16:
        r5 = false;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setLocale(Locale r4) {
        if (r4 == null) goto L16;
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfNotOpenLocked();     // Catch: Throwable -> L12
        Locale r1 = this.mConfigurationLocked.locale;     // Catch: Throwable -> L12
        this.mConfigurationLocked.locale = r4;     // Catch: Throwable -> L12
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);     // Catch: RuntimeException -> L9 Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L9:
        e = move-exception;
        this.mConfigurationLocked.locale = r1;     // Catch: Throwable -> L12
        throw e;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalArgumentException("locale must not be null.");
    }

    @Deprecated
    public void setLockingEnabled(boolean r1) {
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setMaxSqlCacheSize(int r4) {
        if (r4 > 100) goto L18;
        if (r4 < 0) goto L18;
        Object r0 = this.mLock;
        monitor-enter(r0);
        throwIfNotOpenLocked();     // Catch: Throwable -> L14
        int r1 = this.mConfigurationLocked.maxSqlCacheSize;     // Catch: Throwable -> L14
        this.mConfigurationLocked.maxSqlCacheSize = r4;     // Catch: Throwable -> L14
        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);     // Catch: RuntimeException -> L11 Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L11:
        e = move-exception;
        this.mConfigurationLocked.maxSqlCacheSize = r1;     // Catch: Throwable -> L14
        throw e;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    L18:
        throw new IllegalStateException("expected value between 0 and 100");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long setMaximumSize(long r7) {
        long r0 = getPageSize();
        long r2 = r7 / r0;
        if ((r7 % r0) == 0) goto L6;
        r2 = r2 + 1;
    L6:
        return DatabaseUtils.a(this, "PRAGMA max_page_count = " + r2, null) * r0;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long r3) {
        execSQL("PRAGMA page_size = " + r3);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
        acquireReference();
        getThreadSession().setTransactionSuccessful();     // Catch: Throwable -> L6
        releaseReference();
        return;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setVersion(int r3) {
        execSQL("PRAGMA user_version = " + r3);
    }

    public String toString() {
        return "SQLiteDatabase: " + getPath();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int update(String r8, int r9, ContentValues r10, String r11, Object[] r12) {
        String[] r5 = new String[r12.length];
        int r0 = 0;
    L4:
        if (r0 >= r12.length) goto L7;
        r5[r0] = r12[r0].toString();
        r0 = r0 + 1;
        goto L4
    L7:
        return updateWithOnConflict(r8, r10, r11, r5, r9);
    }

    public int update(String r7, ContentValues r8, String r9, String[] r10) {
        return updateWithOnConflict(r7, r8, r9, r10, 0);
    }

    public int updateWithOnConflict(String r8, ContentValues r9, String r10, String[] r11, int r12) {
        if (r9 == null) goto L37;
        if (r9.size() == 0) goto L37;
        acquireReference();
        StringBuilder r0 = new StringBuilder(120);     // Catch: Throwable -> L33
        r0.append("UPDATE ");     // Catch: Throwable -> L33
        r0.append(CONFLICT_VALUES[r12]);     // Catch: Throwable -> L33
        r0.append(r8);     // Catch: Throwable -> L33
        r0.append(" SET ");     // Catch: Throwable -> L33
        int r13 = r9.size();     // Catch: Throwable -> L33
        if (r11 != null) goto L9;
        int r14 = r13;
    L10:
        Object[] r1 = new Object[r14];     // Catch: Throwable -> L33
        int r2 = 0;
        Iterator<String> r3 = r9.keySet().iterator();     // Catch: Throwable -> L33
    L12:
        if (r3.hasNext() == false) goto L18;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        if (r2 <= 0) goto L16;
        String r5 = ",";
    L17:
        r0.append(r5);     // Catch: Throwable -> L33
        r0.append(r4);     // Catch: Throwable -> L33
        r1[r2] = r9.get(r4);     // Catch: Throwable -> L33
        r0.append("=?");     // Catch: Throwable -> L33
        r2 = r2 + 1;     // Catch: Throwable -> L33
        goto L12
    L16:
        r5 = "";
        goto L17
    L18:
        if (r11 == null) goto L23;
        int r15 = r13;
    L20:
        if (r15 >= r14) goto L23;
        r1[r15] = r11[r15 - r13];     // Catch: Throwable -> L33
        r15 = r15 + 1;     // Catch: Throwable -> L33
    L23:
        if (TextUtils.isEmpty(r10) == true) goto L25;
        r0.append(" WHERE ");     // Catch: Throwable -> L33
        r0.append(r10);     // Catch: Throwable -> L33
    L25:
        SQLiteStatement r16 = new SQLiteStatement(this, r0.toString(), r1);     // Catch: Throwable -> L33
        int r17 = r16.executeUpdateDelete();     // Catch: Throwable -> L30
        r16.close();     // Catch: Throwable -> L33
        releaseReference();
        return r17;
    L30:
        th = move-exception;
        r16.close();     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L9:
        r14 = r11.length + r13;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        releaseReference();
        throw th;
    L37:
        throw new IllegalArgumentException("Empty values");
    }

    public void validateSql(String r3, CancellationSignal r4) {
        getThreadSession().prepare(r3, getThreadDefaultConnectionFlags(true), r4, null);
    }

    @Deprecated
    public boolean yieldIfContended() {
        return yieldIfContendedHelper(false, -1);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely() {
        return yieldIfContendedHelper(true, -1);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely(long r2) {
        return yieldIfContendedHelper(true, r2);
    }
}
