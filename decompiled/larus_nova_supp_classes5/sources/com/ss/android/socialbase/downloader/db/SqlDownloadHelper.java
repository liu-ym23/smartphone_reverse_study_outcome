package com.ss.android.socialbase.downloader.db;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.depend.IMainThreadMonitor;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class SqlDownloadHelper {
    private static int APP_VERSION_CODE_INDEX = -1;
    private static int AUXILIARY_JSONOBJECT_STRING_INDEX = -1;
    private static int BACKUP_URLS_STR_INDEX = -1;
    private static int BACKUP_URL_RETRY_COUNT_INDEX = -1;
    private static int BACK_CUR_BYTES_INDEX = -1;
    private static int CACHE_LIFE_TIME_MAX_INDEX = -1;
    private static int CDN_URLS_STR_INDEX = -1;
    private static int CHUNK_COUNT_INDEX = -1;
    public static final String COUNT_ALIAS = "countAlias";
    private static int CUR_BYTES_INDEX = -1;
    private static int CUR_RETRY_TIME_INDEX = -1;
    private static int DEFAULT_HTTP_SERVICE_BACKUP_INDEX = -1;
    private static int DOWNLOAD_FINISH_TIMESTAMP_INDEX = -1;
    private static int DOWNLOAD_START_TIMESTAMP_INDEX = -1;
    private static int DOWNLOAD_TIME_INDEX = -1;
    private static int ETAG_INDEX = -1;
    private static int EXTRA_INDEX = -1;
    private static int FIRST_DOWNLOAD_INDEX = -1;
    private static int FIRST_SUCCESS_INDEX = -1;
    private static int FORCE_INDEX = -1;
    private static int HAS_DO_INSTALLATION_INDEX = -1;
    private static int ICON_URL_INDEX = -1;
    private static int ID_INDEX = -1;
    private static int INDEPENDENT_PROCESS_INDEX = -1;
    private static int INSTALLED_TIMESTAMP_INDEX = -1;
    private static final String KEY_CHECK_DB_INDEX_CREATE_TIME = "key_check_db_index_create_time";
    private static final String KEY_DB_INDEX_CREATE = "key_db_index_create";
    private static int MD5_INDEX = -1;
    private static int MIME_TYPE_INDEX = -1;
    private static int MONITOR_SCENE_INDEX = -1;
    private static int NAME_INDEX = -1;
    private static int NEED_HTTPS_TO_HTTP_RETRY_INDEX = -1;
    private static int NOTIFICATION_ENABLE_INDEX = -1;
    private static int NOTIFICATION_VISIBILITY_INDEX = -1;
    private static int ONLY_WIFI_INDEX = -1;
    private static int PACKAGE_NAME_INDEX = -1;
    private static int PCDN_URLS_STR_INDEX = -1;
    private static int REAL_BACK_DOWNLOAD_TIME_INDEX = -1;
    private static int REAL_DOWNLOAD_TIME_INDEX = -1;
    private static int RETRY_COUNT_INDEX = -1;
    private static int SAVE_PATH_INDEX = -1;
    private static int STATUS_INDEX = -1;
    public static final String SUM_BYTES_ALIAS = "sumBytesAlias";
    private static final String TAG = "SqlDownloadHelper";
    private static int TEMP_PATH_INDEX = -1;
    private static int TITLE_INDEX = -1;
    private static int TOTAL_BYTES_INDEX = -1;
    private static int URL_INDEX = -1;
    private static boolean isLoadIndex;
    private static IMainThreadMonitor sMainThreadMonitor;

    public SqlDownloadHelper() {
    }

    private static SQLiteDatabase getDataBase() {
        IDownloadCache r0 = DownloadComponentManager.getDownloadCache();
        if ((r0 instanceof DefaultDownloadCache) == true) goto L5;
        return null;
    L5:
        ISqlDownloadCache r1 = ((DefaultDownloadCache) r0).getSqlDownloadCache();
        if (r1 != null) goto L8;
    L10:
        SQLiteDatabase r2 = ((SqlDownloadCache) r1).getDatabase();
        if (r2 != null) goto L13;
        return null;
    L13:
        return r2;
    L8:
        if ((r1 instanceof SqlDownloadCache) == true) goto L10;
        return null;
    }

    public static void resetDBIndexState() {
        if (DownloadSetting.obtainGlobal().optInt("create_sqlite_download_id_index_min_data_count") > 0) goto L5;
        return;
    L5:
        if (DownloadSetting.obtainGlobal().optInt("check_create_sqlite_download_id_index_interval_d") <= 0) goto L15;
        DownloadComponentManager.getAppContext().getSharedPreferences(DownloadConstants.SP_DOWNLOAD_CACHE, 0).edit().remove(KEY_DB_INDEX_CREATE).remove(KEY_CHECK_DB_INDEX_CREATE_TIME).apply();     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Logger.globalError(TAG, "resetDBIndexState", "Error:" + th);
        return;
    }

    public static void tryCreateDBIndex() {
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "tryCreateDBIndex", "Run");
    L5:
        int r0 = DownloadSetting.obtainGlobal().optInt("check_create_sqlite_download_id_index_interval_d");
        if (r0 > 0) goto L8;
        return;
    L8:
        int r3 = DownloadSetting.obtainGlobal().optInt("create_sqlite_download_id_index_min_data_count");
        if (r3 > 0) goto L25;
        return;
    L25:
    L22:
        th = move-exception;
        Logger.globalError(TAG, "tryCreateDBIndex", "Error:" + th);
        return;
    L12:
        if (checkInterval(r0) == true) goto L14;
        return;
    L14:
        SQLiteDatabase r1 = getDataBase();     // Catch: Throwable -> L22
        if (r1 != null) goto L17;
        return;
    L17:
        if (checkRowCount(r1, r3) == false) goto L27;
        createDBIndexImpl(r1);     // Catch: Throwable -> L22
        return;
    }

    public static IMainThreadMonitor getMainThreadMonitor() {
        return sMainThreadMonitor;
    }

    private static boolean checkInterval(int r11) {
        SharedPreferences r0 = DownloadComponentManager.getAppContext().getSharedPreferences(DownloadConstants.SP_DOWNLOAD_CACHE, 0);
        if (r0.getBoolean(KEY_DB_INDEX_CREATE, false) == true) goto L5;
        long r5 = r0.getLong(KEY_CHECK_DB_INDEX_CREATE_TIME, 0);
        if ((System.currentTimeMillis() - r5) < (((long) r11) * DownloadConstants.DAY)) goto L11;
        r0.edit().putLong(KEY_CHECK_DB_INDEX_CREATE_TIME, System.currentTimeMillis()).apply();
        return true;
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.globalDebug(TAG, "checkInterval", "Not exceeding the detection period");
    L13:
        return false;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.globalDebug(TAG, "checkInterval", "The index has already been created");
    L7:
        return false;
    }

    private static void createDBIndexImpl(SQLiteDatabase r5) {
        if (Logger.debug() == false) goto L14;
        Logger.globalDebug(TAG, "createDBIndexImpl", "Run");
    L14:
        r5.beginTransaction();     // Catch: Throwable -> L7
        r5.execSQL("CREATE INDEX IF NOT EXISTS idx_id ON downloader (_id)");     // Catch: Throwable -> L7
    L6:
        r5.endTransaction();
        return;
    L7:
        th = move-exception;
        Logger.globalError(TAG, "createDBIndexImpl", "Error:" + th);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        r5.endTransaction();
        throw th;
    }

    public static boolean loadDownloadInfoIndex(Cursor r2) {
        if (isLoadIndex == false) goto L11;
        return true;
    L11:
        ID_INDEX = r2.getColumnIndex(DBDefinition.ID);     // Catch: Exception -> L8
        NAME_INDEX = r2.getColumnIndex(DBDefinition.NAME);     // Catch: Exception -> L8
        TITLE_INDEX = r2.getColumnIndex(DBDefinition.TITLE);     // Catch: Exception -> L8
        URL_INDEX = r2.getColumnIndex("url");     // Catch: Exception -> L8
        SAVE_PATH_INDEX = r2.getColumnIndex(DBDefinition.SAVE_PATH);     // Catch: Exception -> L8
        TEMP_PATH_INDEX = r2.getColumnIndex(DBDefinition.TEMP_PATH);     // Catch: Exception -> L8
        STATUS_INDEX = r2.getColumnIndex("status");     // Catch: Exception -> L8
        CUR_BYTES_INDEX = r2.getColumnIndex(DBDefinition.CUR_BYTES);     // Catch: Exception -> L8
        FORCE_INDEX = r2.getColumnIndex(DBDefinition.FORCE);     // Catch: Exception -> L8
        MIME_TYPE_INDEX = r2.getColumnIndex(DBDefinition.MIME_TYPE);     // Catch: Exception -> L8
        CACHE_LIFE_TIME_MAX_INDEX = r2.getColumnIndex(DBDefinition.CACHE_LIFE_TIME_MAX);     // Catch: Exception -> L8
        AUXILIARY_JSONOBJECT_STRING_INDEX = r2.getColumnIndex(DBDefinition.AUXILIARY_JSONOBJECT_STRING);     // Catch: Exception -> L8
        DOWNLOAD_START_TIMESTAMP_INDEX = r2.getColumnIndex(DBDefinition.DOWNLOAD_START_TIMESTAMP);     // Catch: Exception -> L8
        MONITOR_SCENE_INDEX = r2.getColumnIndex(DBDefinition.MONITOR_SCENE);     // Catch: Exception -> L8
        CHUNK_COUNT_INDEX = r2.getColumnIndex(DBDefinition.CHUNK_COUNT);     // Catch: Exception -> L8
        BACK_CUR_BYTES_INDEX = r2.getColumnIndex(DBDefinition.BACK_CUR_BYTES);     // Catch: Exception -> L8
        TOTAL_BYTES_INDEX = r2.getColumnIndex(DBDefinition.TOTAL_BYTES);     // Catch: Exception -> L8
        ETAG_INDEX = r2.getColumnIndex(DBDefinition.ETAG);     // Catch: Exception -> L8
        ONLY_WIFI_INDEX = r2.getColumnIndex(DBDefinition.ONLY_WIFI);     // Catch: Exception -> L8
        RETRY_COUNT_INDEX = r2.getColumnIndex(DBDefinition.RETRY_COUNT);     // Catch: Exception -> L8
        EXTRA_INDEX = r2.getColumnIndex(DBDefinition.EXTRA);     // Catch: Exception -> L8
        NOTIFICATION_ENABLE_INDEX = r2.getColumnIndex(DBDefinition.NOTIFICATION_ENABLE);     // Catch: Exception -> L8
        NOTIFICATION_VISIBILITY_INDEX = r2.getColumnIndex(DBDefinition.NOTIFICATION_VISIBILITY);     // Catch: Exception -> L8
        FIRST_DOWNLOAD_INDEX = r2.getColumnIndex(DBDefinition.FIRST_DOWNLOAD);     // Catch: Exception -> L8
        FIRST_SUCCESS_INDEX = r2.getColumnIndex(DBDefinition.FIRST_SUCCESS);     // Catch: Exception -> L8
        NEED_HTTPS_TO_HTTP_RETRY_INDEX = r2.getColumnIndex(DBDefinition.NEED_HTTPS_TO_HTTP_RETRY);     // Catch: Exception -> L8
        DOWNLOAD_TIME_INDEX = r2.getColumnIndex(DBDefinition.DOWNLOAD_TIME);     // Catch: Exception -> L8
        PACKAGE_NAME_INDEX = r2.getColumnIndex(DBDefinition.PACKAGE_NAME);     // Catch: Exception -> L8
        MD5_INDEX = r2.getColumnIndex(DBDefinition.MD5);     // Catch: Exception -> L8
        CUR_RETRY_TIME_INDEX = r2.getColumnIndex(DBDefinition.CUR_RETRY_TIME);     // Catch: Exception -> L8
        DEFAULT_HTTP_SERVICE_BACKUP_INDEX = r2.getColumnIndex(DBDefinition.DEFAULT_HTTP_SERVICE_BACKUP);     // Catch: Exception -> L8
        BACKUP_URLS_STR_INDEX = r2.getColumnIndex(DBDefinition.BACKUP_URLS_STR);     // Catch: Exception -> L8
        BACKUP_URL_RETRY_COUNT_INDEX = r2.getColumnIndex(DBDefinition.BACKUP_URL_RETRY_COUNT);     // Catch: Exception -> L8
        REAL_DOWNLOAD_TIME_INDEX = r2.getColumnIndex(DBDefinition.REAL_DOWNLOAD_TIME);     // Catch: Exception -> L8
        REAL_BACK_DOWNLOAD_TIME_INDEX = r2.getColumnIndex(DBDefinition.REAL_BACK_DOWNLOAD_TIME);     // Catch: Exception -> L8
        INDEPENDENT_PROCESS_INDEX = r2.getColumnIndex(DBDefinition.INDEPENDENT_PROCESS);     // Catch: Exception -> L8
        ICON_URL_INDEX = r2.getColumnIndex(DBDefinition.ICON_URL);     // Catch: Exception -> L8
        APP_VERSION_CODE_INDEX = r2.getColumnIndex(DBDefinition.APP_VERSION_CODE);     // Catch: Exception -> L8
        DOWNLOAD_FINISH_TIMESTAMP_INDEX = r2.getColumnIndex(DBDefinition.DOWNLOAD_FINISH_TIMESTAMP);     // Catch: Exception -> L8
        INSTALLED_TIMESTAMP_INDEX = r2.getColumnIndex(DBDefinition.INSTALLED_TIMESTAMP);     // Catch: Exception -> L8
        HAS_DO_INSTALLATION_INDEX = r2.getColumnIndex(DBDefinition.HAS_DO_INSTALLATION);     // Catch: Exception -> L8
        PCDN_URLS_STR_INDEX = r2.getColumnIndex(DBDefinition.PCDN_URLS_STR);     // Catch: Exception -> L8
        CDN_URLS_STR_INDEX = r2.getColumnIndex(DBDefinition.CDN_URLS_STR);     // Catch: Exception -> L8
        isLoadIndex = true;
        return true;
    L8:
        e = move-exception;
        DownloadMonitorHelper.monitorDownloadOtherError(e);
        Logger.globalError(TAG, "loadDownloadInfoIndex", "Error:" + e);
        return false;
    }

    public static int parseDownloadId(Cursor r1) {
        return r1.getInt(ID_INDEX);
    }

    public static DownloadInfo parsePartialDownloadInfo(Cursor r2) {
        DownloadInfo r0 = new DownloadInfo();
        parsePartialDownloadInfo(r2, r0, parseMonitorScene(r2, r0));
        return r0;
    }

    public static void setMainThreadMonitor(IMainThreadMonitor r0) {
        sMainThreadMonitor = r0;
    }

    private static boolean checkRowCount(SQLiteDatabase r7, int r8) {
        Cursor r5 = null;
        r5 = r7.rawQuery("SELECT COUNT(*) FROM downloader", null);     // Catch: Throwable -> L9
        if (r5.moveToFirst() == false) goto L7;
        int r9 = r5.getInt(0);     // Catch: Throwable -> L9
    L8:
        DownloadUtils.safeClose(new Cursor[]{r5});
    L12:
        if (r9 < r8) goto L14;
        DownloadComponentManager.getAppContext().getSharedPreferences(DownloadConstants.SP_DOWNLOAD_CACHE, 0).edit().putBoolean(KEY_DB_INDEX_CREATE, true).apply();
        return true;
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.globalDebug(TAG, "checkRowCount", "RowCount:" + r9 + " createIndexMinDataCount:" + r8);
    L16:
        return false;
    L7:
        r9 = 0;
    L9:
        th = move-exception;
        Logger.globalError(TAG, "checkRowCount", "Error:" + th);     // Catch: Throwable -> L19
        DownloadUtils.safeClose(new Cursor[]{r5});
        r9 = 0;
    L19:
        th = move-exception;
        DownloadUtils.safeClose(new Cursor[]{r5});
        throw th;
    }

    public static void parseAllRemainingDownloadInfo(Cursor r5, DownloadInfo r6) {
        r6.setChunkCount(r5.getInt(CHUNK_COUNT_INDEX));     // Catch: Exception -> L35
        r6.setBackCurBytes(r5.getLong(BACK_CUR_BYTES_INDEX));     // Catch: Exception -> L35
        r6.setTotalBytes(r5.getLong(TOTAL_BYTES_INDEX));     // Catch: Exception -> L35
        r6.seteTag(r5.getString(ETAG_INDEX));     // Catch: Exception -> L35
        boolean r1 = false;
        if (r5.getInt(ONLY_WIFI_INDEX) == 0) goto L5;
        boolean r0 = true;
    L6:
        r6.setOnlyWifi(r0);     // Catch: Exception -> L35
        r6.setRetryCount(r5.getInt(RETRY_COUNT_INDEX));     // Catch: Exception -> L35
        r6.setExtra(r5.getString(EXTRA_INDEX));     // Catch: Exception -> L35
        if (r5.getInt(NOTIFICATION_ENABLE_INDEX) == 0) goto L9;
        boolean r2 = true;
    L10:
        r6.setShowNotification(r2);     // Catch: Exception -> L35
        r6.setNotificationVisibility(r5.getInt(NOTIFICATION_VISIBILITY_INDEX));     // Catch: Exception -> L35
        if (r5.getInt(FIRST_DOWNLOAD_INDEX) != 1) goto L13;
        boolean r3 = true;
    L14:
        r6.setFirstDownload(r3);     // Catch: Exception -> L35
        if (r5.getInt(FIRST_SUCCESS_INDEX) != 1) goto L17;
        boolean r4 = true;
    L18:
        r6.setFirstSuccess(r4);     // Catch: Exception -> L35
        if (r5.getInt(NEED_HTTPS_TO_HTTP_RETRY_INDEX) != 1) goto L21;
        boolean r7 = true;
    L22:
        r6.setNeedHttpsToHttpRetry(r7);     // Catch: Exception -> L35
        r6.setDownloadTime(r5.getLong(DOWNLOAD_TIME_INDEX));     // Catch: Exception -> L35
        r6.setPackageName(r5.getString(PACKAGE_NAME_INDEX));     // Catch: Exception -> L35
        r6.setMd5(r5.getString(MD5_INDEX));     // Catch: Exception -> L35
        r6.setCurRetryTime(r5.getInt(CUR_RETRY_TIME_INDEX));     // Catch: Exception -> L35
        if (r5.getInt(DEFAULT_HTTP_SERVICE_BACKUP_INDEX) != 1) goto L25;
        boolean r8 = true;
    L26:
        r6.setNeedDefaultHttpServiceBackUp(r8);     // Catch: Exception -> L35
        r6.setBackUpUrlsStr(r5.getString(BACKUP_URLS_STR_INDEX));     // Catch: Exception -> L35
        r6.setBackUpUrlRetryCount(r5.getInt(BACKUP_URL_RETRY_COUNT_INDEX));     // Catch: Exception -> L35
        r6.setRealDownloadTime(r5.getLong(REAL_DOWNLOAD_TIME_INDEX));     // Catch: Exception -> L35
        r6.setRealBackDownloadTime(r5.getLong(REAL_BACK_DOWNLOAD_TIME_INDEX));     // Catch: Exception -> L35
        if (r5.getInt(INDEPENDENT_PROCESS_INDEX) != 1) goto L29;
        boolean r9 = true;
    L30:
        r6.setNeedIndependentProcess(r9);     // Catch: Exception -> L35
        r6.setIconUrl(r5.getString(ICON_URL_INDEX));     // Catch: Exception -> L35
        r6.setAppVersionCode(r5.getInt(APP_VERSION_CODE_INDEX));     // Catch: Exception -> L35
        r6.setDownloadFinishTimeStamp(r5.getLong(DOWNLOAD_FINISH_TIMESTAMP_INDEX));     // Catch: Exception -> L35
        r6.setInstalledTimeStamp(r5.getLong(INSTALLED_TIMESTAMP_INDEX));     // Catch: Exception -> L35
        if (r5.getInt(HAS_DO_INSTALLATION_INDEX) != 1) goto L33;
        r1 = true;
    L33:
        r6.setHasDoInstallation(r1);     // Catch: Exception -> L35
        r6.setPcdnUrlsStr(r5.getString(PCDN_URLS_STR_INDEX));     // Catch: Exception -> L35
        r6.setCdnUrlsStr(r5.getString(CDN_URLS_STR_INDEX));     // Catch: Exception -> L35
        return;
    L29:
        r9 = false;
        goto L30
    L25:
        r8 = false;
        goto L26
    L21:
        r7 = false;
        goto L22
    L17:
        r4 = false;
        goto L18
    L13:
        r3 = false;
        goto L14
    L9:
        r2 = false;
        goto L10
    L5:
        r0 = false;
    L35:
        e = move-exception;
        DownloadMonitorHelper.monitorDownloadOtherError(e);
        Logger.globalError(TAG, "parseAllRemainingDownloadInfo", "Error:" + e);
    }

    public static boolean parseMonitorScene(Cursor r2, DownloadInfo r3) {
        String r0 = r2.getString(MONITOR_SCENE_INDEX);
        if (TextUtils.isEmpty(r0) == true) goto L6;
        r3.setMonitorScene(r0);
        return false;
    L6:
        String r4 = r2.getString(AUXILIARY_JSONOBJECT_STRING_INDEX);
        if (TextUtils.isEmpty(r4) == false) goto L9;
        return true;
    L9:
        r3.setDbJsonDataString(r4);
        r3.unsafeEnsureDBJsonData();
        r3.setMonitorScene(r3.getDBJsonString("monitor_scene"));
        return true;
    }

    public static DownloadInfo parsePartialDownloadInfo(Cursor r2, DownloadInfo r3, boolean r4) {
        r3.setId(r2.getInt(ID_INDEX));     // Catch: Exception -> L10
        r3.setName(r2.getString(NAME_INDEX));     // Catch: Exception -> L10
        r3.setTitle(r2.getString(TITLE_INDEX));     // Catch: Exception -> L10
        r3.setUrl(r2.getString(URL_INDEX));     // Catch: Exception -> L10
        r3.setSavePath(r2.getString(SAVE_PATH_INDEX));     // Catch: Exception -> L10
        r3.setTempPath(r2.getString(TEMP_PATH_INDEX));     // Catch: Exception -> L10
        r3.setStatus(r2.getInt(STATUS_INDEX));     // Catch: Exception -> L10
        r3.setCurBytes(r2.getLong(CUR_BYTES_INDEX));     // Catch: Exception -> L10
        if (r2.getInt(FORCE_INDEX) == 0) goto L5;
        boolean r0 = true;
    L6:
        r3.setForce(r0);     // Catch: Exception -> L10
        r3.setMimeType(r2.getString(MIME_TYPE_INDEX));     // Catch: Exception -> L10
        r3.setCacheLifeTimeMax(r2.getLong(CACHE_LIFE_TIME_MAX_INDEX));     // Catch: Exception -> L10
        r3.setDownloadStartTimeStamp(r2.getLong(DOWNLOAD_START_TIMESTAMP_INDEX));     // Catch: Exception -> L10
        if (r4 == true) goto L12;
        r3.setDbJsonDataString(r2.getString(AUXILIARY_JSONOBJECT_STRING_INDEX));     // Catch: Exception -> L10
    L12:
        return r3;
    L5:
        r0 = false;
    L10:
        e = move-exception;
        DownloadMonitorHelper.monitorDownloadOtherError(e);
        Logger.globalError(TAG, "parsePartialDownloadInfo", "Error:" + e);
        goto L12
    }
}
