package com.ss.android.socialbase.downloader.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.cleaner.Cleaner;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.depend.IMainThreadMonitor;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadDBInitInfo;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class SqlDownloadCache extends ISqlDownloadCacheAidl.Stub implements ISqlDownloadCache, DatabaseErrorHandler {
    private static final int DEFAULT_MAIN_THREAD_DB_OP_MAX_TIME_MS = 4000;
    public static final int DOWNLOAD_CACHE_LRU_CAPACITY_DEFAULT = 300;
    public static final int DOWNLOAD_CACHE_LRU_CAPACITY_MAX = 0;
    public static final int DOWNLOAD_CACHE_LRU_CAPACITY_MIN = 100;
    private static final String TAG = "SqlDownloadCache";
    private static volatile SQLiteDatabase database;
    public static volatile HashMap<String, Integer> lruHotCacheKeysMap;
    private static final boolean mEnableRemoveDownloadSPInfo = false;
    private static boolean mExternalDownload;
    private static Set<Integer> mExternalDownloadIdSets;
    private static final int mainThreadDbOPMaxTime = 0;
    private static boolean sEnableMainThreadDBOptimize;
    private static final int sMainThreadDbOptimizeErrorRowCount = 0;
    private static final long sMainThreadDbOptimizeErrorTime = 0;
    private volatile boolean cacheSynced;
    ISqlCacheLoadCompleteCallbackAidl callback;
    private TableStatements downloadTableStatements;
    private boolean isCheckCacheEnable;
    private volatile boolean mDownloadDBOptimize;
    private TableStatements segmentTableStatements;
    private int singleLoadCountLimit;
    private long singleLoadSleepTimeMs;

    public SqlDownloadCache() {
        this(false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearMemoryCacheData(double r1) {
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean ensureDownloadCacheSyncSuccess() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfosByFilters(String r1, String r2) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void initImmediately() {
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo onDownloadTaskStart(int r1) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfo(DownloadInfo r1) {
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfoFromOtherCache(int r1) {
    }

    private synchronized void clearDataInSubThread() {
        monitor-enter(this);
        safeBeginTransaction();     // Catch: Throwable -> L7
        database.delete(DBDefinition.DOWNLOAD_TABLE_NAME, null, null);     // Catch: Throwable -> L7
        database.setTransactionSuccessful();     // Catch: Throwable -> L7
    L5:
        safeEndTransaction();     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    L7:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L12
        Logger.globalError(TAG, "clearDataInSubThread", "Error:" + th);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        safeEndTransaction();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    }

    private void deleteChunkTable() {
        if (database != null) goto L10;
        return;
    L10:
        database.execSQL(DBDefinition.DROP_CHUNK_TABLE);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        Logger.globalError(TAG, "deleteChunkTable", "Error:" + th);
    }

    private void ensureDataBaseInit() {
        if (database == null) goto L5;
        return;
    L5:
        monitor-enter(SqlDownloadCache.class);
    L23:
        th = move-exception;
        throw th;
    L7:
        if (database == null) goto L27;
    L21:
        monitor-exit(SqlDownloadCache.class);     // Catch: Throwable -> L23
        return;
    L27:
    L19:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L23
        Logger.globalError(TAG, "ensureDataBaseInit", "Error:" + th);     // Catch: Throwable -> L23
        goto L21
    L9:
        if (DownloadComponentManager.getAppContext() != null) goto L14;
        Logger.globalError(TAG, "ensureDataBaseInit", "Context is null");     // Catch: Throwable -> L19
        monitor-exit(SqlDownloadCache.class);     // Catch: Throwable -> L23
        return;
    L14:
        if (DownloadUtils.isMultiProcessDBMode() == false) goto L16;
        dbInitDataBase();     // Catch: Throwable -> L19
    L17:
        this.downloadTableStatements = new TableStatements(database, DBDefinition.DOWNLOAD_TABLE_NAME, DBDefinition.DOWNLOAD_ALL_COLUMNS, DBDefinition.DOWNLOAD_PK_COLUMNS);     // Catch: Throwable -> L19
        this.segmentTableStatements = new TableStatements(database, DBDefinition.SEGMENT_TABLE_NAME, DBDefinition.SEGMENT_ALL_COLUMNS, DBDefinition.SEGMENT_PK_COLUMNS);     // Catch: Throwable -> L19
        goto L21
    L16:
        database = DownloadDBHelper.getInstance(this).updateWriteAheadLoggingMode().getWritableDatabase();     // Catch: Throwable -> L19
        goto L17
    }

    private List<Integer> getAllDownloadIdsImpl() {
        ensureDataBaseInit();
        ArrayList r1 = new ArrayList();
        if (database == null) goto L20;
        Cursor r2 = null;
        r2 = database.rawQuery(String.format("SELECT %s FROM %s", new Object[]{DBDefinition.ID, DBDefinition.DOWNLOAD_TABLE_NAME}), null);     // Catch: Throwable -> L14
        int r0 = r2.getColumnIndex(DBDefinition.ID);     // Catch: Throwable -> L14
        if (r0 >= 0) goto L10;
        DownloadUtils.safeClose(new Cursor[]{r2});
        return r1;
    L10:
        if (r2.moveToNext() == false) goto L13;
        r1.add(Integer.valueOf(r2.getInt(r0)));     // Catch: Throwable -> L14
        goto L10
    L13:
        DownloadUtils.safeClose(new Cursor[]{r2});
    L14:
        th = move-exception;
        Logger.globalError(TAG, "getAllDownloadIdsImpl", "Error:" + th);     // Catch: Throwable -> L17
        DownloadUtils.safeClose(new Cursor[]{r2});
    L17:
        th = move-exception;
        DownloadUtils.safeClose(new Cursor[]{r2});
        throw th;
    L20:
        return r1;
    }

    private static void getHotCacheKeys() {
        if (lruHotCacheKeysMap == null) goto L5;
        return;
    L5:
        lruHotCacheKeysMap = DownloadHelper.jsonObjectToHashMap(DownloadSetting.getGlobalSettings().optJSONObject("lru_preload_hot_cache_keys"));
    }

    private long getMainThreadDBTimeout() {
        if (sEnableMainThreadDBOptimize == false) goto L26;
        long r0 = sMainThreadDbOptimizeErrorTime;
        if (r0 <= 0) goto L26;
        IMainThreadMonitor r4 = SqlDownloadHelper.getMainThreadMonitor();
        if (r4 != null) goto L12;
        int r1 = mainThreadDbOPMaxTime;
    L11:
        return r1;
    L12:
        long r5 = r4.getLooperMessageStartTime();
        if (r5 > 0) goto L15;
        r1 = mainThreadDbOPMaxTime;
        goto L11
    L15:
        long r2 = (System.nanoTime() / 1000000) - r5;
        if (r2 <= r0) goto L21;
        sEnableMainThreadDBOptimize = false;
        int r3 = sMainThreadDbOptimizeErrorRowCount;
        if (r3 <= 0) goto L20;
        DownloadMonitorHelper.monitorDBOptAnr(new Throwable("MessageExecuteTime Error:" + r2), r3);
    L20:
        r1 = mainThreadDbOPMaxTime;
        goto L11
    L21:
        int r6 = mainThreadDbOPMaxTime;
        long r7 = ((long) r6) - r2;
        if (r7 > r6) goto L24;
        return r7;
    L24:
        return r6;
    L26:
        r1 = mainThreadDbOPMaxTime;
        goto L11
    }

    private void safeBeginTransaction() {
        database.beginTransaction();
    }

    private void safeEndTransaction() {
    L8:
        th = move-exception;
        th.printStackTrace();
        Logger.globalError(TAG, "safeEndTransaction", "Error:" + th);
        return;
    L3:
        if (database != null) goto L5;
        return;
    L5:
        if (database.inTransaction() == false) goto L14;
        database.endTransaction();     // Catch: Throwable -> L8
        return;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearData() {
        DownloadComponentManager.submitDBTask(new 18(this));
    }

    public List<Integer> getAllDownloadIds() {
        return (List) runImpl(new 24(this), new 25(this));
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getAllDownloadInfo() {
        return (List) runImpl(new 12(this), new 13(this));
    }

    static {
        DOWNLOAD_CACHE_LRU_CAPACITY_MAX = getLRUCapacityMax();
        lruHotCacheKeysMap = null;
        mainThreadDbOPMaxTime = getMainThreadDbOPMaxTime();
        mEnableRemoveDownloadSPInfo = isRemoveDownloadSPInfo();
        mExternalDownload = DownloadFileUtils.isExternalDownloadEnabled();
        mExternalDownloadIdSets = new CopyOnWriteArraySet();
        sEnableMainThreadDBOptimize = getMainThreadDbOptimize();
        sMainThreadDbOptimizeErrorTime = getMainThreadDbOptimizeErrorTime();
        sMainThreadDbOptimizeErrorRowCount = getMainThreadDbOptimizeErrorStackRowCount();
    }

    private boolean dbInitDataBase() {
        String r0 = DownloadUtils.getCurProcessName(DownloadComponentManager.getAppContext());
        if (TextUtils.isEmpty(r0) == false) goto L7;
        Logger.globalError(TAG, "dbInitDataBase", "ProcessName is null");
        return false;
    L7:
        if (r0.contains(":") == false) goto L20;
        String[] r1 = r0.split(":");
        if (r1 != null) goto L11;
    L18:
        Logger.globalError(TAG, "dbInitDataBase", "Error process name:".concat(r0));
        return false;
    L11:
        if (r1.length != 2) goto L18;
        String r2 = r1[1];
        if (TextUtils.isEmpty(r2) == false) goto L17;
        Logger.globalError(TAG, "dbInitDataBase", "TargetProcess empty");
        return false;
    L17:
        String r3 = DBDefinition.DATABASE_SUBPROCESS_PREFIX_NAME + r2 + DBDefinition.DATABASE_SUBPROCESS_SUFFIX_NAME;
    L21:
        database = DownloadDBHelper.getInstance(r3, this).updateWriteAheadLoggingMode().getWritableDatabase();
        if (Logger.debug() == false) goto L24;
        Logger.globalDebug(TAG, "dbInitDataBase", "DB name:" + r3);
    L24:
        return true;
    L20:
        r3 = DBDefinition.DATABASE_NAME;
        goto L21
    }

    private List<DownloadInfo> getAllDownloadInfoImpl() {
        ensureDataBaseInit();
        ArrayList r0 = new ArrayList();
        if (database == null) goto L17;
        Cursor r1 = null;
        r1 = database.rawQuery(String.format("SELECT * FROM %s", new Object[]{DBDefinition.DOWNLOAD_TABLE_NAME}), null);     // Catch: Throwable -> L11
    L7:
        if (r1.moveToNext() == false) goto L10;
        r0.add(DownloadHelper.parseDownloadInfo(r1));     // Catch: Throwable -> L11
        goto L7
    L10:
        DownloadUtils.safeClose(new Cursor[]{r1});
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        Logger.globalError(TAG, "getAllDownloadInfoImpl", "Error:" + th);     // Catch: Throwable -> L14
        DownloadUtils.safeClose(new Cursor[]{r1});
    L14:
        th = move-exception;
        DownloadUtils.safeClose(new Cursor[]{r1});
        throw th;
    L17:
        return r0;
    }

    private static int getLRUCapacityMax() {
        int r0 = DownloadSetting.getGlobalSettings().optInt("lru_download_info_capacity_max", 300);
        if (r0 >= 100) goto L5;
        return 300;
    L5:
        return r0;
    }

    private static int getMainThreadDbOPMaxTime() {
        int r0 = DownloadSetting.obtainGlobal().optInt("main_thread_db_op_max_time_ms");
        if (r0 >= 0) goto L6;
        return r0;
    L6:
        if (DownloadComponentManager.isEnableLruCache() == false) goto L9;
        return DEFAULT_MAIN_THREAD_DB_OP_MAX_TIME_MS;
    L9:
        return r0;
    }

    private static boolean getMainThreadDbOptimize() {
        if (DownloadSetting.obtainGlobal().optInt("main_thread_db_optimize") <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static int getMainThreadDbOptimizeErrorStackRowCount() {
        return DownloadSetting.obtainGlobal().optInt("main_thread_db_optimize_error_row_count");
    }

    private static long getMainThreadDbOptimizeErrorTime() {
        return DownloadSetting.obtainGlobal().optLong("main_thread_db_optimize_error_time_ms");
    }

    private List<String> getMimeTypes() {
        IDownloadLaunchHandler r0 = DownloadComponentManager.getDownloadLaunchHandler();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getResumeMimeTypes();
    }

    private static boolean isRemoveDownloadSPInfo() {
        if (DownloadSetting.obtainGlobal().optInt("enable_remove_download_sp_info") <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void resetNewBatchInit() {
        this.singleLoadCountLimit = Integer.MAX_VALUE;
    }

    public static /* synthetic */ SQLiteDatabase access$100() {
        return database;
    }

    public static /* synthetic */ Set access$1000() {
        return mExternalDownloadIdSets;
    }

    public static /* synthetic */ void access$800() {
        getHotCacheKeys();
    }

    public static /* synthetic */ boolean access$900() {
        return mExternalDownload;
    }

    public SQLiteDatabase getDatabase() {
        return database;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean isDownloadCacheSyncSuccess() {
        return this.cacheSynced;
    }

    public SqlDownloadCache(boolean r3) {
        this.isCheckCacheEnable = false;
        this.mDownloadDBOptimize = false;
        this.callback = null;
        if (r3 == true) goto L5;
        return;
    L5:
        this.cacheSynced = false;
        init(false);
    }

    public static /* synthetic */ void access$000(SqlDownloadCache r0) {
        r0.ensureDataBaseInit();
    }

    public static /* synthetic */ boolean access$1400(String r0) {
        return isHoldDownloadInfo(r0);
    }

    public static /* synthetic */ void access$1600(SqlDownloadCache r0) {
        r0.deleteChunkTable();
    }

    public static /* synthetic */ List access$2400(SqlDownloadCache r0) {
        return r0.getAllDownloadInfoImpl();
    }

    public static /* synthetic */ TableStatements access$2500(SqlDownloadCache r0) {
        return r0.downloadTableStatements;
    }

    public static /* synthetic */ int access$300(SqlDownloadCache r0) {
        return r0.singleLoadCountLimit;
    }

    public static /* synthetic */ void access$3100(SqlDownloadCache r0) {
        r0.clearDataInSubThread();
    }

    public static /* synthetic */ List access$3500(SqlDownloadCache r0) {
        return r0.getAllDownloadIdsImpl();
    }

    public static /* synthetic */ long access$400(SqlDownloadCache r2) {
        return r2.singleLoadSleepTimeMs;
    }

    public static /* synthetic */ boolean access$600(SqlDownloadCache r0) {
        return r0.mDownloadDBOptimize;
    }

    private void addDownloadInfo(final DownloadInfo r2) {
        DownloadComponentManager.submitDBTask(new AnonymousClass14(this, r2));
    }

    private void checkAndReportToMonitor(DownloadInfo r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        int r0 = r4.getStatusAtDbInit();
        if (r0 >= 1) goto L7;
        return;
    L7:
        if (r0 > 11) goto L11;
        DownloadMonitorHelper.monitorSendWithGlobalSdkMonitor(DownloadComponentManager.getDownloadMonitorListener(), null, r4, null, -5);
        return;
    }

    public static boolean checkCacheLifeTimeAndRemove(DownloadInfo r7) {
        if (r7 != null) goto L6;
        return false;
    L6:
        if (r7.getCacheLifeTimeMax() > 0) goto L8;
        return false;
    L8:
        if (r7.getDownloadStartTimeStamp() > 0) goto L10;
        return false;
    L10:
        if ((r7.getDownloadStartTimeStamp() + (r7.getCacheLifeTimeMax() * 1000)) >= System.currentTimeMillis()) goto L15;
        DownloadUtils.deleteAllDownloadFiles(r7, true);
        return true;
    L15:
        return false;
    }

    private void clearAntiHijackDirIfNeeded(List<DownloadInfo> r3) {
        if (r3 != null) goto L18;
        return;
    L18:
        Iterator<DownloadInfo> r4 = r3.iterator();     // Catch: Throwable -> L15
    L5:
        if (r4.hasNext() == false) goto L26;
        DownloadInfo r0 = r4.next();     // Catch: Throwable -> L15
        if (r0 == null) goto L5;
        if (r0.isSavePathRedirected() == false) goto L13;
        DownloadUtils.clearAntiHijackDir(r0);     // Catch: Throwable -> L15
    L13:
        handleDBRelatedData(r0.getId(), r0.getSavePath());     // Catch: Throwable -> L15
        goto L5
    L26:
        return;
    L15:
        th = move-exception;
        Logger.globalError(TAG, "clearAntiHijackDirIfNeeded", "Error:" + th);
    }

    private DownloadInfo getDownloadInfoImpl(int r10) {
        ensureDataBaseInit();
        if (database != null) goto L26;
    L21:
        return null;
    L26:
        Cursor r4 = database.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", new Object[]{DBDefinition.DOWNLOAD_TABLE_NAME, DBDefinition.ID}), new String[]{Integer.toString(r10)});     // Catch: Throwable -> L14
    L12:
        th = th;
    L24:
        th.printStackTrace();     // Catch: Throwable -> L18
        Logger.taskError(TAG, r10, "getDownloadInfoImpl", "Error:" + th);     // Catch: Throwable -> L18
        DownloadUtils.safeClose(new Cursor[]{r4});
    L18:
        th = move-exception;
        DownloadUtils.safeClose(new Cursor[]{r4});
        throw th;
    L7:
        if (r4.moveToNext() == false) goto L11;
        DownloadInfo r11 = DownloadHelper.parseDownloadInfo(r4);     // Catch: Throwable -> L12
        DownloadUtils.safeClose(new Cursor[]{r4});
        return r11;
    L11:
        DownloadUtils.safeClose(new Cursor[]{r4});
    L14:
        th = th;
        r4 = null;
        goto L24
    }

    private List<DownloadInfo> getDownloadInfoListImpl(String r9) {
        ensureDataBaseInit();
        ArrayList r0 = new ArrayList();
        if (database == null) goto L17;
        Cursor r3 = null;
        r3 = database.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", new Object[]{DBDefinition.DOWNLOAD_TABLE_NAME, "url"}), new String[]{r9});     // Catch: Throwable -> L11
    L7:
        if (r3.moveToNext() == false) goto L10;
        r0.add(DownloadHelper.parseDownloadInfo(r3));     // Catch: Throwable -> L11
        goto L7
    L10:
        DownloadUtils.safeClose(new Cursor[]{r3});
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        Logger.globalError(TAG, "getDownloadInfoListImpl", "Error:" + th);     // Catch: Throwable -> L14
        DownloadUtils.safeClose(new Cursor[]{r3});
    L14:
        th = move-exception;
        DownloadUtils.safeClose(new Cursor[]{r3});
        throw th;
    L17:
        return r0;
    }

    private List<DownloadInfo> getDownloadInfosByFileExtensionImpl(String r10) {
        ensureDataBaseInit();
        ArrayList r1 = new ArrayList();
        if (database == null) goto L17;
        Cursor r4 = null;
        r4 = database.rawQuery(String.format("SELECT * FROM %s WHERE %s LIKE ?", new Object[]{DBDefinition.DOWNLOAD_TABLE_NAME, DBDefinition.NAME}), new String[]{"%" + r10});     // Catch: Throwable -> L11
    L7:
        if (r4.moveToNext() == false) goto L10;
        r1.add(DownloadHelper.parseDownloadInfo(r4));     // Catch: Throwable -> L11
        goto L7
    L10:
        DownloadUtils.safeClose(new Cursor[]{r4});
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        Logger.globalError(TAG, "getDownloadInfosByFileExtensionImpl", "Error:" + th);     // Catch: Throwable -> L14
        DownloadUtils.safeClose(new Cursor[]{r4});
    L14:
        th = move-exception;
        DownloadUtils.safeClose(new Cursor[]{r4});
        throw th;
    L17:
        return r1;
    }

    private List<DownloadInfo> getDownloadInfosByMonitorSceneImpl(List<String> r9) {
        Cursor r0 = null;
        if (r9 != null) goto L5;
    L27:
        return null;
    L5:
        if (r9.isEmpty() == true) goto L27;
        ensureDataBaseInit();
        if (database != null) goto L10;
        return null;
    L10:
        ArrayList r1 = new ArrayList();
        StringBuilder r4 = new StringBuilder(String.format("SELECT * FROM %s WHERE %s IN (", new Object[]{DBDefinition.DOWNLOAD_TABLE_NAME, DBDefinition.MONITOR_SCENE}));     // Catch: Throwable -> L20
        int r5 = r9.size();     // Catch: Throwable -> L20
        int r6 = 0;
    L12:
        if (r6 >= r5) goto L14;
        r4.append("?,");     // Catch: Throwable -> L20
        r6 = r6 + 1;     // Catch: Throwable -> L20
        goto L12
    L14:
        r4.deleteCharAt(r4.length() - 1);     // Catch: Throwable -> L20
        r4.append(")");     // Catch: Throwable -> L20
        String[] r7 = new String[r9.size()];     // Catch: Throwable -> L20
        r9.toArray(r7);     // Catch: Throwable -> L20
        r0 = database.rawQuery(r4.toString(), r7);     // Catch: Throwable -> L20
    L15:
        if (r0.moveToNext() == false) goto L19;
        r1.add(DownloadHelper.parseDownloadInfo(r0));     // Catch: Throwable -> L20
        goto L15
    L19:
        DownloadUtils.safeClose(new Cursor[]{r0});
    L23:
        return r1;
    L20:
        th = move-exception;
        Logger.globalError(TAG, "getDownloadInfosByMonitorSceneImpl", "Error:" + th);     // Catch: Throwable -> L24
        DownloadUtils.safeClose(new Cursor[]{r0});
    L24:
        th = move-exception;
        DownloadUtils.safeClose(new Cursor[]{r0});
        throw th;
    }

    private List<DownloadInfo> getDownloadInfosBySavePathImpl(String r9) {
        ensureDataBaseInit();
        ArrayList r0 = new ArrayList();
        if (database == null) goto L17;
        Cursor r3 = null;
        r3 = database.rawQuery(String.format("SELECT * FROM %s WHERE %s LIKE ?", new Object[]{DBDefinition.DOWNLOAD_TABLE_NAME, DBDefinition.SAVE_PATH}), new String[]{r9});     // Catch: Throwable -> L11
    L7:
        if (r3.moveToNext() == false) goto L10;
        r0.add(DownloadHelper.parseDownloadInfo(r3));     // Catch: Throwable -> L11
        goto L7
    L10:
        DownloadUtils.safeClose(new Cursor[]{r3});
    L11:
        th = move-exception;
        Logger.globalError(TAG, "getDownloadInfosBySaveInfoImpl", "Error:" + th);     // Catch: Throwable -> L14
        DownloadUtils.safeClose(new Cursor[]{r3});
    L14:
        th = move-exception;
        DownloadUtils.safeClose(new Cursor[]{r3});
        throw th;
    L17:
        return r0;
    }

    private Map<String, Pair<Integer, Long>> getInstalledTimeStampBySavePathImpl(String r14) {
        ensureDataBaseInit();
        HashMap r4 = new HashMap();
        if (database == null) goto L39;
        Cursor r5 = null;
        Cursor r15 = database.rawQuery(String.format("SELECT %s, %s, %s, %s FROM %s WHERE %s LIKE ?", new Object[]{DBDefinition.ID, DBDefinition.SAVE_PATH, DBDefinition.NAME, DBDefinition.INSTALLED_TIMESTAMP, DBDefinition.DOWNLOAD_TABLE_NAME, DBDefinition.SAVE_PATH}), new String[]{r14});     // Catch: Throwable -> L33
        int r2 = r15.getColumnIndex(DBDefinition.ID);     // Catch: Throwable -> L31
        if (r2 != (-1)) goto L11;
        DownloadUtils.safeClose(new Cursor[]{r15});
        return null;
    L11:
        int r3 = r15.getColumnIndex(DBDefinition.SAVE_PATH);     // Catch: Throwable -> L31
        if (r3 != (-1)) goto L15;
        DownloadUtils.safeClose(new Cursor[]{r15});
        return null;
    L15:
        int r1 = r15.getColumnIndex(DBDefinition.NAME);     // Catch: Throwable -> L31
        if (r1 != (-1)) goto L19;
        DownloadUtils.safeClose(new Cursor[]{r15});
        return null;
    L19:
        int r0 = r15.getColumnIndex(DBDefinition.INSTALLED_TIMESTAMP);     // Catch: Throwable -> L31
        if (r0 != (-1)) goto L24;
        DownloadUtils.safeClose(new Cursor[]{r15});
        return null;
    L24:
        if (r15.moveToNext() == false) goto L30;
        String r6 = new DownloadFile(r15.getString(r3), r15.getString(r1)).getAbsolutePath();     // Catch: Throwable -> L31
        if (TextUtils.isEmpty(r6) == true) goto L24;
        r4.put(r6, new Pair(Integer.valueOf(r15.getInt(r2)), Long.valueOf(r15.getLong(r0))));     // Catch: Throwable -> L31
        goto L24
    L30:
        DownloadUtils.safeClose(new Cursor[]{r15});
    L31:
        th = th;
        r5 = r15;
    L44:
        Logger.globalError(TAG, "getDownloadInfosBySaveInfoImpl", "Error:" + th);     // Catch: Throwable -> L36
        DownloadUtils.safeClose(new Cursor[]{r5});
    L36:
        th = move-exception;
        DownloadUtils.safeClose(new Cursor[]{r5});
        throw th;
    L33:
        th = th;
    L39:
        return r4;
    }

    private List<DownloadInfo> getSuccessedDownloadInfosWithMimeTypeImpl(String r10) {
        ensureDataBaseInit();
        ArrayList r0 = new ArrayList();
        if (database == null) goto L17;
        Cursor r3 = null;
        r3 = database.rawQuery(String.format("SELECT * FROM %s WHERE %s = ? AND %s = ?", new Object[]{DBDefinition.DOWNLOAD_TABLE_NAME, DBDefinition.MIME_TYPE, "status"}), new String[]{r10, String.valueOf(-3)});     // Catch: Throwable -> L11
    L7:
        if (r3.moveToNext() == false) goto L10;
        r0.add(DownloadHelper.parseDownloadInfo(r3));     // Catch: Throwable -> L11
        goto L7
    L10:
        DownloadUtils.safeClose(new Cursor[]{r3});
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        Logger.globalError(TAG, "getSuccessedDownloadInfosWithMimeTypeImpl", "Error:" + th);     // Catch: Throwable -> L14
        DownloadUtils.safeClose(new Cursor[]{r3});
    L14:
        th = move-exception;
        DownloadUtils.safeClose(new Cursor[]{r3});
        throw th;
    L17:
        return r0;
    }

    private List<DownloadInfo> getUnCompletedDownloadInfosWithMimeTypeImpl(String r11) {
        ensureDataBaseInit();
        ArrayList r0 = new ArrayList();
        if (database == null) goto L17;
        Cursor r3 = null;
        r3 = database.rawQuery(String.format("SELECT * FROM %s WHERE %s = ? AND %s IN (?,?,?,?,?)", new Object[]{DBDefinition.DOWNLOAD_TABLE_NAME, DBDefinition.MIME_TYPE, "status"}), new String[]{r11, String.valueOf(-1), String.valueOf(-2), String.valueOf(-7), String.valueOf(-4), String.valueOf(-5)});     // Catch: Throwable -> L11
    L7:
        if (r3.moveToNext() == false) goto L10;
        r0.add(DownloadHelper.parseDownloadInfo(r3));     // Catch: Throwable -> L11
        goto L7
    L10:
        DownloadUtils.safeClose(new Cursor[]{r3});
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        Logger.globalError(TAG, "getUnCompletedDownloadInfosWithMimeTypeImpl", "Error:" + th);     // Catch: Throwable -> L14
        DownloadUtils.safeClose(new Cursor[]{r3});
    L14:
        th = move-exception;
        DownloadUtils.safeClose(new Cursor[]{r3});
        throw th;
    L17:
        return r0;
    }

    private static boolean isHoldDownloadInfo(String r4) {
        if (lruHotCacheKeysMap != null) goto L5;
    L17:
        return false;
    L5:
        if (lruHotCacheKeysMap.isEmpty() == true) goto L17;
        if (r4 == null) goto L17;
        Iterator<Map.Entry<String, Integer>> r0 = lruHotCacheKeysMap.entrySet().iterator();
    L10:
        if (r0.hasNext() == false) goto L17;
        String r2 = r0.next().getKey();
        if (r2 == null) goto L10;
        if (r4.indexOf(r2) == (-1)) goto L10;
        return true;
    }

    private <T> T runDefault(Fallback<T> r1) {
        if (r1 != null) goto L4;
        return null;
    L4:
        return (T) r1.getDefaultValue();
    }

    private synchronized void updateDownloadInfoForCurrentThread(DownloadInfo r6) {
        monitor-enter(this);
        if (r6 != null) goto L26;
        monitor-exit(this);
        return;
    L26:
    L16:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        Logger.taskError(TAG, r6.getId(), "updateDownloadInfoForCurrentThread", "Error:" + th);     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);
        return;
    L20:
        th = move-exception;
        throw th;
    L8:
        if (cacheExist(r6.getId()) == true) goto L10;
        addDownloadInfo(r6);     // Catch: Throwable -> L16
    L25:
        goto L18
    L10:
        TableStatements r1 = this.downloadTableStatements;     // Catch: Throwable -> L16
        if (r1 != null) goto L14;
        monitor-exit(this);
        return;
    L14:
        updateDownloadInfoInner(r6, r1.getUpdateStatement());     // Catch: Throwable -> L16
        goto L25
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskIntercept(int r4) {
        ContentValues r0 = new ContentValues();
        r0.put("status", -7);
        update(r4, r0);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPrepare(int r4) {
        ContentValues r0 = new ContentValues();
        r0.put("status", 1);
        update(r4, r0);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskRetry(int r4) {
        ContentValues r0 = new ContentValues();
        r0.put("status", 5);
        r0.put(DBDefinition.FIRST_DOWNLOAD, 0);
        update(r4, r0);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean cacheExist(int r5) {
        if (getDownloadInfo(r5) == null) goto L12;
        return true;
    L12:
        return false;
    L7:
        th = move-exception;
        th.printStackTrace();
        Logger.taskError(TAG, r5, "cacheExist", "Error:" + th);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo getDownloadInfo(final int r2) {
        return (DownloadInfo) runImpl(new AnonymousClass2(this, r2), null);
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfoList(String r2) {
        return (List) runImpl(new 3(this, r2), new 4(this));
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfosByFileExtension(String r2) {
        return (List) runImpl(new 10(this, r2), new 11(this));
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfosByMonitorScene(List<String> r2) {
        return (List) runImpl(new 19(this, r2), new 20(this));
    }

    public List<DownloadInfo> getDownloadInfosBySavePath(String r2) {
        return (List) runImpl(new 22(this, r2), new 23(this));
    }

    public Map<String, Pair<Integer, Long>> getInstalledTimeStampBySavePath(String r2) {
        return (Map) runImpl(new 26(this, r2), new 27(this));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public Map<Long, Segment> getSegmentMap(int r12) {
        ensureDataBaseInit();
        if (database != null) goto L32;
    L29:
        return null;
    L32:
        Cursor r3 = database.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", new Object[]{DBDefinition.SEGMENT_TABLE_NAME, DBDefinition.ID}), new String[]{Integer.toString(r12)});     // Catch: Throwable -> L22
    L20:
        th = th;
    L34:
        th.printStackTrace();     // Catch: Throwable -> L26
        Logger.taskError(TAG, r12, "getSegmentMap", "Error:" + th);     // Catch: Throwable -> L26
        DownloadUtils.safeClose(new Cursor[]{r3});
    L26:
        th = move-exception;
        DownloadUtils.safeClose(new Cursor[]{r3});
        throw th;
    L7:
        if (r3.moveToNext() == false) goto L19;
        int r4 = r3.getColumnIndex(DBDefinition.SEGMENT_INFO);     // Catch: Throwable -> L20
        if (r4 < 0) goto L11;
        String r5 = r3.getString(r4);     // Catch: Throwable -> L20
    L12:
        HashMap r6 = new HashMap();     // Catch: Throwable -> L20
        JSONArray r7 = new JSONArray(r5);     // Catch: Throwable -> L20
        int r8 = 0;
    L13:
        if (r8 >= r7.length()) goto L17;
        Segment r9 = new Segment(r7.getJSONObject(r8));     // Catch: Throwable -> L20
        r6.put(Long.valueOf(r9.getStartOffset()), r9);     // Catch: Throwable -> L20
        r8 = r8 + 1;
        goto L13
    L17:
        DownloadUtils.safeClose(new Cursor[]{r3});
        return r6;
    L11:
        r5 = null;
        goto L12
    L19:
        DownloadUtils.safeClose(new Cursor[]{r3});
    L22:
        th = th;
        r3 = null;
        goto L34
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public ArrayList<Segment> getSegments(int r2) {
        Map<Long, Segment> r3 = getSegmentMap(r2);
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r3.isEmpty() == false) goto L8;
        return null;
    L8:
        return new ArrayList(r3.values());
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r2) {
        return (List) runImpl(new 6(this, r2), new 7(this));
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r2) {
        return (List) runImpl(new 8(this, r2), new 9(this));
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void init(boolean r13) {
        if (r13 == false) goto L4;
        init(new SparseArray(), new HashSet(), new ArrayList(), getMimeTypes(), null);
        return;
    L4:
        init(new SparseArray(), null, null, null, null);
    }

    @Override // android.database.DatabaseErrorHandler
    public void onCorruption(SQLiteDatabase r5) {
        if (DownloadSetting.obtainGlobal().optInt("fix_download_sqlite_malformed") > 0) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L16;
        Logger.globalDebug(TAG, "onCorruption", "Run");
    L16:
    L13:
        th = move-exception;
        Logger.globalError(TAG, "onCorruption", "Error:" + th);
        return;
    L9:
        if (r5.isOpen() == false) goto L11;
        r5.close();     // Catch: Throwable -> L13
    L11:
        SQLiteDatabase.deleteDatabase(new PolarisFileWrapper(r5.getPath()));     // Catch: Throwable -> L13
        SqlDownloadHelper.resetDBIndexState();     // Catch: Throwable -> L13
        DownloadMonitorHelper.monitorSqliteMalformed();     // Catch: Throwable -> L13
        database = null;     // Catch: Throwable -> L13
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadInfo(int r2) {
        DownloadComponentManager.submitDBTask(new 16(this, r2));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadTaskData(int r2) {
        DownloadComponentManager.submitDBTask(new 17(this, r2));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeSegments(int r4) {
        ensureDataBaseInit();
        if (database != null) goto L14;
        return;
    L14:
    L10:
        th = move-exception;
        th.printStackTrace();
        Logger.taskError(TAG, r4, "removeSegments", "Error:" + th);
        return;
    L6:
        if (this.mDownloadDBOptimize == false) goto L8;
        deleteInner(r4, DBDefinition.SEGMENT_TABLE_NAME);     // Catch: Throwable -> L10
    L13:
        return;
    L8:
        deleteInner(r4, this.segmentTableStatements.getDeleteStatement());     // Catch: Throwable -> L10
        goto L13
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl, com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache
    public void setInitCallback(ISqlCacheLoadCompleteCallbackAidl r1) {
        this.callback = r1;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateDownloadInfo(final DownloadInfo r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        DownloadComponentManager.submitDBTask(new AnonymousClass15(this, r2));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public /* bridge */ /* synthetic */ List getSegments(int r1) {
        return getSegments(r1);
    }

    public static /* synthetic */ void access$1300(SqlDownloadCache r0, DownloadInfo r1) {
        r0.checkAndReportToMonitor(r1);
    }

    public static /* synthetic */ void access$1500(SqlDownloadCache r0, List r1) {
        r0.clearAntiHijackDirIfNeeded(r1);
    }

    public static /* synthetic */ DownloadInfo access$1800(SqlDownloadCache r0, int r1) {
        return r0.getDownloadInfoImpl(r1);
    }

    public static /* synthetic */ List access$1900(SqlDownloadCache r0, String r1) {
        return r0.getDownloadInfoListImpl(r1);
    }

    public static /* synthetic */ boolean access$202(SqlDownloadCache r0, boolean r1) {
        r0.cacheSynced = r1;
        return r1;
    }

    public static /* synthetic */ List access$2100(SqlDownloadCache r0, String r1) {
        return r0.getSuccessedDownloadInfosWithMimeTypeImpl(r1);
    }

    public static /* synthetic */ List access$2200(SqlDownloadCache r0, String r1) {
        return r0.getUnCompletedDownloadInfosWithMimeTypeImpl(r1);
    }

    public static /* synthetic */ List access$2300(SqlDownloadCache r0, String r1) {
        return r0.getDownloadInfosByFileExtensionImpl(r1);
    }

    public static /* synthetic */ void access$2700(SqlDownloadCache r0, DownloadInfo r1) {
        r0.updateDownloadInfoForCurrentThread(r1);
    }

    public static /* synthetic */ int access$302(SqlDownloadCache r0, int r1) {
        r0.singleLoadCountLimit = r1;
        return r1;
    }

    public static /* synthetic */ List access$3200(SqlDownloadCache r0, List r1) {
        return r0.getDownloadInfosByMonitorSceneImpl(r1);
    }

    public static /* synthetic */ List access$3400(SqlDownloadCache r0, String r1) {
        return r0.getDownloadInfosBySavePathImpl(r1);
    }

    public static /* synthetic */ Map access$3600(SqlDownloadCache r0, String r1) {
        return r0.getInstalledTimeStampBySavePathImpl(r1);
    }

    public static /* synthetic */ long access$402(SqlDownloadCache r0, long r1) {
        r0.singleLoadSleepTimeMs = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$502(SqlDownloadCache r0, boolean r1) {
        r0.isCheckCacheEnable = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$602(SqlDownloadCache r0, boolean r1) {
        r0.mDownloadDBOptimize = r1;
        return r1;
    }

    private void clearDBSuccessedDownloadInfoImpl(String r9, String r10) {
        safeBeginTransaction();     // Catch: Throwable -> L5
        database.delete(DBDefinition.DOWNLOAD_TABLE_NAME, String.format("%s LIKE ? AND %s LIKE ? AND %s = ?", new Object[]{DBDefinition.SAVE_PATH, DBDefinition.NAME, "status"}), new String[]{r9, r10, String.valueOf(-3)});     // Catch: Throwable -> L5
        database.setTransactionSuccessful();     // Catch: Throwable -> L5
    L7:
        safeEndTransaction();
        return;
    L5:
        th = move-exception;
        Logger.globalError(TAG, "clearDBSuccessedDownloadInfoImpl", "Error:" + th);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        safeEndTransaction();
        throw th;
    }

    private void deleteInner(int r6, String r7) {
        safeBeginTransaction();     // Catch: Throwable -> L5
        database.delete(r7, "_id = ?", new String[]{String.valueOf(r6)});     // Catch: Throwable -> L5
        database.setTransactionSuccessful();     // Catch: Throwable -> L5
    L4:
        safeEndTransaction();
        return;
    L5:
        th = move-exception;
        Logger.globalError(TAG, "deleteInner", "Error:" + th);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        safeEndTransaction();
        throw th;
    }

    private void handleDBRelatedData(int r4, String r5) {
        if (mEnableRemoveDownloadSPInfo == false) goto L6;
        DownloadComponentManager.getAppContext().getSharedPreferences(DownloadConstants.SP_DOWNLOAD_INFO, 0).edit().remove(Integer.toString(r4)).apply();
    L6:
        if (mExternalDownload == true) goto L8;
        return;
    L8:
        if (mExternalDownloadIdSets.contains(Integer.valueOf(r4)) == false) goto L25;
        mExternalDownloadIdSets.remove(Integer.valueOf(r4));
    L19:
        th = move-exception;
        th.printStackTrace();
        Logger.taskError(TAG, r4, "handleRelatedData", "Error:" + th);
        return;
    L11:
        if (TextUtils.isEmpty(r5) == false) goto L16;
        DownloadInfo r0 = getDownloadInfo(r4);     // Catch: Throwable -> L19
        if (r0 == null) goto L16;
        r5 = r0.getSavePath();     // Catch: Throwable -> L19
    L16:
        if (TextUtils.isEmpty(r5) == true) goto L26;
        DownloadFileUtils.deleteUri(UriProtector.parse(r5));     // Catch: Throwable -> L19
        return;
    L26:
        return;
    }

    private void insertDownloadInfoInner(DownloadInfo r5, SQLiteStatement r6) {
        if (r5 == null) goto L23;
        if (r6 == null) goto L26;
        monitor-enter(r6);     // Catch: Throwable -> L17
        r5.bindValue(r6);     // Catch: Throwable -> L14
        r6.executeInsert();     // Catch: Throwable -> L14
        monitor-exit(r6);     // Catch: Throwable -> L14
    L9:
        if (mExternalDownload == true) goto L11;
        return;
    L11:
        if (DownloadFileUtils.isMediaUri(r5.getSavePath()) == false) goto L25;
        mExternalDownloadIdSets.add(Integer.valueOf(r5.getId()));     // Catch: Throwable -> L17
        return;
    L25:
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.printStackTrace();
        Logger.taskError(TAG, r5.getId(), "insertDownloadInfoInner", "Error:" + th);
        return;
    L26:
        return;
    }

    private void loadCacheFromDB(List<DownloadInfo> r11, SparseArray<DownloadInfo> r12) {
        int r0 = r12.size();
        if (r0 >= 0) goto L5;
        return;
    L5:
        if (database == null) goto L40;
        SQLiteDatabase r1 = database;
        monitor-enter(r1);
        safeBeginTransaction();     // Catch: Throwable -> L22
        if (r11.isEmpty() == true) goto L16;
        String[] r2 = new String[r11.size()];     // Catch: Throwable -> L22
        int r5 = 0;
    L13:
        if (r5 >= r11.size()) goto L15;
        r2[r5] = String.valueOf(r11.get(r5).getId());     // Catch: Throwable -> L22
        r5 = r5 + 1;     // Catch: Throwable -> L22
        goto L13
    L15:
        database.delete(DBDefinition.DOWNLOAD_TABLE_NAME, "CAST(_id AS TEXT) IN (" + new String(new char[r11.size() - 1]).replace("\u0000", "?,") + "?)", r2);     // Catch: Throwable -> L22
    L16:
        int r13 = 0;
    L17:
        if (r13 >= r0) goto L19;
        int r3 = r12.keyAt(r13);     // Catch: Throwable -> L22
        DownloadInfo r6 = r12.get(r3);     // Catch: Throwable -> L22
        database.delete(DBDefinition.DOWNLOAD_TABLE_NAME, "_id = ?", new String[]{String.valueOf(r3)});     // Catch: Throwable -> L22
        database.insert(DBDefinition.DOWNLOAD_TABLE_NAME, null, DownloadHelper.toContentValues(r6));     // Catch: Throwable -> L22
        r13 = r13 + 1;     // Catch: Throwable -> L22
        goto L17
    L19:
        database.setTransactionSuccessful();     // Catch: Throwable -> L22
    L20:
        safeEndTransaction();     // Catch: Throwable -> L30
        monitor-exit(r1);     // Catch: Throwable -> L30
        return;
    L22:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L27
        Logger.globalError(TAG, "loadCacheFromDB", "Error:" + th);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        safeEndTransaction();     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }

    private <T> T runImpl(Callable<T> r8, Fallback<T> r9) {
        if (mainThreadDbOPMaxTime > 0) goto L5;
    L22:
        return r8.call();
    L18:
        th = move-exception;
        th.printStackTrace();
        Logger.globalError(TAG, "runImpl", "Call Error: " + th);
    L21:
        return (T) runDefault(r9);
    L5:
        if (DownloadUtils.isMainThread() == false) goto L22;
        long r3 = getMainThreadDBTimeout();
        if (r3 > 0) goto L24;
        Logger.globalError(TAG, "runImpl", "Timeout:" + r3);
        return (T) runDefault(r9);
    L24:
        return DownloadComponentManager.getDBThreadExecutorService().submit(r8).get(r3, TimeUnit.MILLISECONDS);
    L14:
        th = move-exception;
        th.printStackTrace();
        Logger.globalError(TAG, "runImpl", "Get Error: " + th);
        goto L21
    }

    private void update(int r2, ContentValues r3) {
        DownloadComponentManager.submitDBTask(new 21(this, r2, r3));
    }

    private void updateDownloadInfoInner(DownloadInfo r5, SQLiteStatement r6) {
        if (r5 == null) goto L19;
        if (r6 == null) goto L21;
        monitor-enter(r6);     // Catch: Throwable -> L12
        r5.bindValue(r6);     // Catch: Throwable -> L9
        r6.bindLong(r5.getBindValueCount() + 1, r5.getId());     // Catch: Throwable -> L9
        r6.execute();     // Catch: Throwable -> L9
        monitor-exit(r6);     // Catch: Throwable -> L9
    L20:
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.printStackTrace();
        Logger.taskError(TAG, r5.getId(), "updateDownloadInfoInner", "Error:" + th);
        return;
    L21:
        return;
    }

    private void updateInner(int r9, ContentValues r10) {
        int r2 = 10;
    L17:
    L14:
        th = move-exception;
        th.printStackTrace();
        Logger.taskError(TAG, r9, "updateInner", "Error2:" + th);
        return;
    L4:
        if (database.isDbLockedByCurrentThread() == false) goto L12;
        r2 = r2 - 1;
        if (r2 < 0) goto L12;
        Thread.sleep(5);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        Logger.taskError(TAG, r9, "updateInner", "Error:" + th);     // Catch: Throwable -> L14
    L12:
        database.update(DBDefinition.DOWNLOAD_TABLE_NAME, r10, "_id = ? ", new String[]{String.valueOf(r9)});     // Catch: Throwable -> L14
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCancel(int r4, long r5) {
        ContentValues r0 = new ContentValues();
        r0.put("status", -4);
        r0.put(DBDefinition.CUR_BYTES, Long.valueOf(r5));
        update(r4, r0);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCompleted(int r4, long r5) {
        ContentValues r0 = new ContentValues();
        r0.put("status", -3);
        r0.put(DBDefinition.CUR_BYTES, Long.valueOf(r5));
        r0.put(DBDefinition.FIRST_DOWNLOAD, 0);
        r0.put(DBDefinition.FIRST_SUCCESS, 0);
        update(r4, r0);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskError(int r5, long r6) {
        ContentValues r0 = new ContentValues();
        r0.put("status", -1);
        r0.put(DBDefinition.CUR_BYTES, Long.valueOf(r6));
        if (r6 <= 0) goto L5;
        r0.put(DBDefinition.FIRST_DOWNLOAD, 0);
    L5:
        update(r5, r0);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPause(int r4, long r5) {
        ContentValues r0 = new ContentValues();
        r0.put("status", -2);
        r0.put(DBDefinition.CUR_BYTES, Long.valueOf(r5));
        update(r4, r0);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskProgress(int r4, long r5) {
        ContentValues r0 = new ContentValues();
        r0.put("status", 4);
        r0.put(DBDefinition.CUR_BYTES, Long.valueOf(r5));
        update(r4, r0);
        return null;
    }

    public void clearDBSuccessedDownloadInfo(String r2, String r3) {
        DownloadComponentManager.submitDBTask(new 5(this, r2, r3));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateSegments(int r7, Map<Long, Segment> r8) {
        ensureDataBaseInit();
        if (database != null) goto L5;
        return false;
    L5:
        JSONArray r0 = new JSONArray();
        Iterator<Map.Entry<Long, Segment>> r9 = r8.entrySet().iterator();     // Catch: Throwable -> L13
    L8:
        if (r9.hasNext() == false) goto L15;
        Map.Entry<Long, Segment> r2 = r9.next();     // Catch: Throwable -> L13
        if (r2.getValue() == null) goto L8;
        r0.put(r2.getValue().toJson());     // Catch: Throwable -> L13
    L15:
        SQLiteStatement r10 = this.segmentTableStatements.getInsertOrReplaceStatement();
        if (r10 != null) goto L19;
        Logger.taskError(TAG, r7, "updateSegments", "UpdateSegments statement is null");
        return false;
    L19:
        monitor-enter(r10);
        r10.clearBindings();     // Catch: Throwable -> L23
        r10.bindLong(1, r7);     // Catch: Throwable -> L23
        r10.bindString(2, r0.toString());     // Catch: Throwable -> L23
        r10.execute();     // Catch: Throwable -> L23
        monitor-exit(r10);     // Catch: Throwable -> L23
        return false;
    L23:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        th.printStackTrace();
        Logger.taskError(TAG, r7, "updateSegments", "Error:" + th);
        goto L15
    }

    private void deleteInner(int r5, SQLiteStatement r6) {
        if (r6 != null) goto L15;
        return;
    L15:
        monitor-enter(r6);     // Catch: Throwable -> L12
        r6.bindLong(1, r5);     // Catch: Throwable -> L9
        r6.execute();     // Catch: Throwable -> L9
        monitor-exit(r6);     // Catch: Throwable -> L9
    L18:
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.printStackTrace();
        Logger.taskError(TAG, r5, "deleteInner", "Error:" + th);
    }

    public static /* synthetic */ void access$1700(SqlDownloadCache r0, List r1, SparseArray r2) {
        r0.loadCacheFromDB(r1, r2);
    }

    public static /* synthetic */ void access$2000(SqlDownloadCache r0, String r1, String r2) {
        r0.clearDBSuccessedDownloadInfoImpl(r1, r2);
    }

    public static /* synthetic */ void access$2600(SqlDownloadCache r0, DownloadInfo r1, SQLiteStatement r2) {
        r0.insertDownloadInfoInner(r1, r2);
    }

    public static /* synthetic */ void access$2800(SqlDownloadCache r0, int r1, String r2) {
        r0.deleteInner(r1, r2);
    }

    public static /* synthetic */ void access$2900(SqlDownloadCache r0, int r1, SQLiteStatement r2) {
        r0.deleteInner(r1, r2);
    }

    public static /* synthetic */ void access$3000(SqlDownloadCache r0, int r1, String r2) {
        r0.handleDBRelatedData(r1, r2);
    }

    public static /* synthetic */ void access$3300(SqlDownloadCache r0, int r1, ContentValues r2) {
        r0.updateInner(r1, r2);
    }

    private boolean checkAndRemoveDownloadInfo(DownloadInfo r11, boolean r12, long r13, boolean r15) {
        if (this.isCheckCacheEnable == true) goto L5;
    L14:
        if (r12 == false) goto L23;
        if (DownloadFileUtils.isAtLeastAndroidQ() == false) goto L23;
        if (DownloadFileUtils.isMediaUri(r11.getSavePath()) == true) goto L23;
        if (DownloadFileUtils.isFilePathInExternalPublicDir(r11.getSavePath()) == false) goto L23;
        return true;
    L23:
        if (r13 > 0) goto L25;
    L32:
        return false;
    L25:
        if (r11.getStatus() == (-3)) goto L32;
        if ((r11.getLastDownloadTime() + (r13 * 1000)) >= System.currentTimeMillis()) goto L32;
        if (r15 == false) goto L30;
        return true;
    L30:
        DownloadUtils.deleteAllDownloadFiles(r11, false);
        return true;
    L5:
        if (r11.getCacheLifeTimeMax() <= 0) goto L14;
        if (r11.getDownloadStartTimeStamp() <= 0) goto L14;
        if ((r11.getDownloadStartTimeStamp() + (r11.getCacheLifeTimeMax() * 1000)) >= System.currentTimeMillis()) goto L14;
        if (r15 == false) goto L12;
        return true;
    L12:
        DownloadUtils.deleteAllDownloadFiles(r11, true);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskConnected(int r4, long r5, String r7, String r8) {
        ContentValues r0 = new ContentValues();
        r0.put("status", 3);
        r0.put(DBDefinition.TOTAL_BYTES, Long.valueOf(r5));
        r0.put(DBDefinition.ETAG, r7);
        if (TextUtils.isEmpty(r8) == true) goto L5;
        r0.put(DBDefinition.NAME, r8);
    L5:
        update(r4, r0);
        return null;
    }

    public void onInitFinish(SparseArray<DownloadInfo> r5, Set<Integer> r6, List<DownloadInfo> r7, boolean r8) {
        if (Logger.debug() == false) goto L14;
        Logger.globalDebug(TAG, "onInitFinish", "Run onInitFinish:" + this.callback);
    L14:
        HashMap r9 = DownloadHelper.sparseArrayToHashMap(r5);     // Catch: Throwable -> L9
        Map<Integer, DownloadInfo> r10 = DownloadHelper.listConvertToMap(r7);     // Catch: Throwable -> L9
        List<Integer> r11 = DownloadHelper.setConvertToList(r6);     // Catch: Throwable -> L9
        ISqlCacheLoadCompleteCallbackAidl r0 = this.callback;     // Catch: Throwable -> L9
        if (r0 == null) goto L16;
        r0.callback(r9, r11, r10, r8);     // Catch: Throwable -> L9
        return;
    L16:
        return;
    L9:
        th = move-exception;
        if (Logger.debug() == false) goto L17;
        Logger.globalDebug(TAG, "onInitFinish", "Error:" + th);
        return;
    }

    public static /* synthetic */ boolean access$1100(SqlDownloadCache r0, DownloadInfo r1, boolean r2, long r3, boolean r5) {
        return r0.checkAndRemoveDownloadInfo(r1, r2, r3, r5);
    }

    private boolean handleSuccess(DownloadInfo r8, boolean r9, boolean r10, Cleaner r11, boolean r12) {
        if (r8.getStatus() == (-3)) goto L5;
        return r10;
    L5:
        boolean r0 = DownloadUtils.isFileExist(r8.getSavePath(), r8.getName());
        if (r8.getInstalledTimeStamp() > 0) goto L8;
    L14:
        boolean r1 = false;
    L15:
        if (r0 == false) goto L22;
        if (r1 == false) goto L21;
        if (r12 == false) goto L20;
        r11.forceUpdateCleanDownloadId(r8, true);
        return r10;
    L20:
        DownloadUtils.deleteAllDownloadFiles(r8);
    L21:
        return r10;
    L22:
        if (r9 == false) goto L24;
        return true;
    L24:
        if (r1 == true) goto L26;
        r8.erase();
    L26:
        return r10;
    L8:
        if (DownloadDirUtils.isSavePathSecurity(r8.getSavePath()) == false) goto L10;
    L13:
        r1 = true;
        goto L15
    L10:
        if (mExternalDownload == false) goto L14;
        if (DownloadFileUtils.isMediaUri(r8.getSavePath()) == false) goto L14;
        goto L13
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache
    public void init(final SparseArray<DownloadInfo> r9, final Set<Integer> r10, final List<DownloadInfo> r11, final List<String> r12, final SqlCacheLoadCompleteCallback r13) {
        Runnable r7 = new AnonymousClass1(this, r9, r13, r10, r11, r12);     // Catch: Throwable -> L6
        ExecutorService r14 = DownloadComponentManager.getDBThreadExecutorService();     // Catch: Throwable -> L6
        if (r14 == null) goto L11;
        r14.execute(r7);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
        Logger.globalError(TAG, "init", "Error2:" + th);
    }

    public static /* synthetic */ boolean access$1200(SqlDownloadCache r0, DownloadInfo r1, boolean r2, boolean r3, Cleaner r4, boolean r5) {
        return r0.handleSuccess(r1, r2, r3, r4, r5);
    }

    private void callbackDownloadInfo(boolean r7, List<DownloadInfo> r8, SparseArray<DownloadInfo> r9, SparseArray<DownloadInfo> r10, Set<Integer> r11, List<DownloadInfo> r12, SqlCacheLoadCompleteCallback r13) {
        if (Logger.alog() == false) goto L5;
        Logger.globalDebug(TAG, "callbackDownloadInfo", "Run");
    L5:
        clearAntiHijackDirIfNeeded(r8);
        loadCacheFromDB(r8, r9);
        if (Logger.debug() == false) goto L8;
        Logger.globalDebug(TAG, "callbackDownloadInfo", "Run Callback:" + r13);
    L8:
        if (r13 == null) goto L10;
        r13.callback(r7);
    L10:
        onInitFinish(r10, r11, r12, r7);
        r9.clear();
        r8.clear();
        r10.clear();
        if (r7 == false) goto L21;
        return;
    L21:
    L18:
        th = move-exception;
        th.printStackTrace();
        Logger.globalError(TAG, "newInit", "Sleep:" + th);
        return;
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.globalDebug(TAG, "newInit", "Sleep:" + this.singleLoadSleepTimeMs);     // Catch: Throwable -> L18
    L16:
        Thread.sleep(this.singleLoadSleepTimeMs);     // Catch: Throwable -> L18
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 13751. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    private void newBatchInit(com.ss.android.socialbase.downloader.model.DownloadDBInitInfo r40, android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadInfo> r41, java.util.Set<java.lang.Integer> r42, java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> r43, java.util.List<java.lang.String> r44, com.ss.android.socialbase.downloader.db.SqlCacheLoadCompleteCallback r45, com.ss.android.socialbase.downloader.cleaner.Cleaner r46) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0014: CONST_STR (r8v0 ?? I:java.lang.String) = "SqlDownloadCache" A[DECLARE_VAR] (LINE:117440532) in method: com.ss.android.socialbase.downloader.db.SqlDownloadCache.newBatchInit(com.ss.android.socialbase.downloader.model.DownloadDBInitInfo, android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadInfo>, java.util.Set<java.lang.Integer>, java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo>, java.util.List<java.lang.String>, com.ss.android.socialbase.downloader.db.SqlCacheLoadCompleteCallback, com.ss.android.socialbase.downloader.cleaner.Cleaner):void, file: /private/tmp/nixiang/classes5.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 1375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.db.SqlDownloadCache.newBatchInit(com.ss.android.socialbase.downloader.model.DownloadDBInitInfo, android.util.SparseArray, java.util.Set, java.util.List, java.util.List, com.ss.android.socialbase.downloader.db.SqlCacheLoadCompleteCallback, com.ss.android.socialbase.downloader.cleaner.Cleaner):void");
    }

    public static /* synthetic */ void access$700(SqlDownloadCache r0, DownloadDBInitInfo r1, SparseArray r2, Set r3, List r4, List r5, SqlCacheLoadCompleteCallback r6, Cleaner r7) {
        r0.newBatchInit(r1, r2, r3, r4, r5, r6, r7);
    }
}
