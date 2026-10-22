package com.ss.android.socialbase.downloader.db;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorTeaListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadDBInitInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DownloadDiskReporter {
    private static final String EVENT_NAME_DOWNLOAD_DB_INIT = "download_ttnet_db_init";
    private static final String EVENT_NAME_DOWNLOAD_DISK = "download_ttnet_disk";
    private static final String KEY_LAST_REPORT_TEA_TIME = "key_last_report_tea_time";
    private static final String MONITOR_SCENE_UNKNOWN = "UNKNOWN";
    private static final String TAG = "DownloadDiskReporter";
    private static IDownloadMonitorTeaListener sMonitorTeaListener;

    public DownloadDiskReporter() {
    }

    private static boolean checkInterval() {
        int r4 = DownloadSetting.obtainGlobal().optInt("report_biz_disk_size_interval_d");
        if (r4 > 0) goto L18;
        return true;
    L18:
        SharedPreferences r6 = DownloadComponentManager.getAppContext().getSharedPreferences(DownloadConstants.SP_DOWNLOAD_CACHE, 0);     // Catch: Throwable -> L15
        long r11 = r6.getLong(KEY_LAST_REPORT_TEA_TIME, 0);     // Catch: Throwable -> L15
        if (r11 > 0) goto L8;
    L13:
        r6.edit().putLong(KEY_LAST_REPORT_TEA_TIME, System.currentTimeMillis()).apply();     // Catch: Throwable -> L15
    L17:
        return true;
    L8:
        if ((System.currentTimeMillis() - r11) >= (((long) r4) * DownloadConstants.DAY)) goto L13;
        if (Logger.debug() == false) goto L12;
        Logger.globalDebug(TAG, "checkEnabled", "LastReportTime:" + r11);     // Catch: Throwable -> L15
    L12:
        return false;
    L15:
        th = move-exception;
        Logger.globalError(TAG, "checkEnabled", "Error:" + th);
        goto L17
    }

    private static String getBizSizeSql() {
        return "SELECT monitorScene,SUM(curBytes) AS sumBytesAlias FROM downloader GROUP BY monitorScene";
    }

    private static JSONObject getBizSizeData(SQLiteDatabase r8) {
        JSONObject r0 = new JSONObject();
        Cursor r3 = null;
        r3 = r8.rawQuery(getBizSizeSql(), null);     // Catch: Throwable -> L12
        int r9 = r3.getColumnIndex(DBDefinition.MONITOR_SCENE);     // Catch: Throwable -> L12
        int r4 = r3.getColumnIndex(SqlDownloadHelper.SUM_BYTES_ALIAS);     // Catch: Throwable -> L12
    L5:
        if (r3.moveToNext() == false) goto L11;
        String r5 = r3.getString(r9);     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r5) == false) goto L9;
        r5 = MONITOR_SCENE_UNKNOWN;
    L9:
        r0.put(r5, r3.getLong(r4));     // Catch: Throwable -> L12
        goto L5
    L11:
        DownloadUtils.safeClose(new Cursor[]{r3});
    L15:
        return r0;
    L12:
        th = move-exception;
        Logger.globalError(TAG, "getBizSizeData", "Error:" + th);     // Catch: Throwable -> L16
        DownloadUtils.safeClose(new Cursor[]{r3});
    L16:
        th = move-exception;
        DownloadUtils.safeClose(new Cursor[]{r3});
        throw th;
    }

    private static JSONObject getDbInitData(DownloadDBInitInfo r4) {
        JSONObject r0 = new JSONObject();
        r0.put("db_init_duration", r4.initDuration);     // Catch: Throwable -> L5
        r0.put("db_init_cpu_duration", r4.initCpuDuration);     // Catch: Throwable -> L5
        r0.put("db_init_memory_cache_count", r4.memoryCacheCount);     // Catch: Throwable -> L5
        r0.put("db_init_disk_cache_count", r4.diskCacheCount);     // Catch: Throwable -> L5
    L7:
        return r0;
    L5:
        th = move-exception;
        Logger.globalError(TAG, "getDbInitData", "Error:" + th);
        goto L7
    }

    public static void reportDbInfo(DownloadDBInitInfo r5) {
        if (sMonitorTeaListener != null) goto L5;
        return;
    L5:
        if (DownloadSetting.obtainGlobal().optInt("enable_report_db_init") <= 0) goto L21;
        JSONObject r6 = getDbInitData(r5);     // Catch: Throwable -> L14
        if (Logger.debug() == false) goto L11;
        Logger.globalDebug(TAG, "report", "DBInit Data:" + r6);     // Catch: Throwable -> L14
    L11:
        if (r6.length() <= 0) goto L20;
        sMonitorTeaListener.monitorEvent(EVENT_NAME_DOWNLOAD_DB_INIT, r6);     // Catch: Throwable -> L14
        return;
    L20:
        return;
    L14:
        th = move-exception;
        Logger.globalError(TAG, "report", "Error:" + th);
        return;
    }

    public static void reportDiskInfo(SQLiteDatabase r4) {
        if (sMonitorTeaListener != null) goto L6;
        return;
    L6:
        if (DownloadSetting.obtainGlobal().optInt("enable_report_biz_disk_size") <= 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
        return;
    L11:
        if (checkInterval() == false) goto L29;
        if (r0 == false) goto L27;
        JSONObject r5 = getBizSizeData(r4);
        if (Logger.debug() == false) goto L24;
        Logger.globalDebug(TAG, "report", "BizSize Data:" + r5);
    L24:
    L21:
        th = move-exception;
        Logger.globalError(TAG, "report", "Error:" + th);
        return;
    L18:
        if (r5.length() <= 0) goto L28;
        sMonitorTeaListener.monitorEvent(EVENT_NAME_DOWNLOAD_DISK, r5);     // Catch: Throwable -> L21
        return;
    L28:
        return;
    L27:
        return;
    L29:
        return;
    L8:
        r0 = false;
        goto L9
    }

    public static void setDownloadMonitorTeaListener(IDownloadMonitorTeaListener r0) {
        if (r0 != null) goto L4;
        return;
    L4:
        sMonitorTeaListener = r0;
    }
}
