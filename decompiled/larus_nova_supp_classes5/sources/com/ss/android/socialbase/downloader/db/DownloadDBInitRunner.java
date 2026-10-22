package com.ss.android.socialbase.downloader.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Debug;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.depend.IDownloadDBListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadDBInitInfo;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DownloadDBInitRunner {
    private static final int NO_LIMIT = -1;
    private static final String TAG = "DownloadDBInitRunner";
    private List<DownloadInfo> mAutoResumeList;
    private SqlCacheLoadCompleteCallback mCallback;
    private ISqlCacheLoadCompleteCallbackAidl mCallbackAidl;
    private SparseArray<DownloadInfo> mCopyDownloadInfoMap;
    private SQLiteDatabase mDatabase;
    private DownloadDBInitInfo mDbInfo;
    private Set<Integer> mLruMemoryCacheId;
    private List<String> mMimeTypes;
    private int mSingleLoadCountLimit;
    private long mSingleLoadSleepTimeMs;
    private Set<Integer> mUnreadDBSet;

    private void loadLruUnreadDBData() {
        String r0 = buildQuery(DBDefinition.ID, -1);
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "loadLruUnreadDBData", "Run sql:" + r0);
    L5:
        handleUnreadDBIdData(r0);
    }

    private void loadNormalData() {
        String r0 = buildQuery("*", SqlDownloadCache.DOWNLOAD_CACHE_LRU_CAPACITY_MAX);
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "loadNormalData", "Run sql:" + r0);
    L5:
        handleDownloadInfoData(r0);
    }

    public void start() {
        if (Logger.alog() == false) goto L18;
        Logger.globalDebug(TAG, "start", "Run Start");
    L18:
        startImpl();     // Catch: Throwable -> L12
        callbackDownloadInfo(true);
        onInitEnd(this.mDbInfo);
        if (Logger.alog() == false) goto L10;
        Logger.globalDebug(TAG, "start", "Run End");
    L10:
        DownloadBackgroundCleaner.startBackgroundCleaner();
        return;
    L12:
        th = move-exception;
        callbackDownloadInfo(true);
        onInitEnd(this.mDbInfo);
        if (Logger.alog() == false) goto L16;
        Logger.globalDebug(TAG, "start", "Run End");
    L16:
        DownloadBackgroundCleaner.startBackgroundCleaner();
        throw th;
    }

    private void startImpl() {
        loadNormalData();
        loadLruUnreadDBData();
    }

    private void callbackDownloadInfo(boolean r8) {
        SqlCacheLoadCompleteCallback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.callback(r8);
    L6:
        if (this.mCallbackAidl == null) goto L12;
        HashMap r1 = DownloadHelper.sparseArrayToHashMap(this.mCopyDownloadInfoMap);
        Map<Integer, DownloadInfo> r3 = DownloadHelper.listConvertToMap(this.mAutoResumeList);
        this.mCallbackAidl.callback(r1, DownloadHelper.setConvertToList(this.mUnreadDBSet), r3, r8);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Logger.globalError(TAG, "callbackDownloadInfo", "Error:" + th);
    L12:
        this.mCopyDownloadInfoMap.clear();
        if (r8 == false) goto L19;
        if (Logger.debug() == false) goto L30;
        Logger.globalDebug(TAG, "callbackDownloadInfo", "Finish");
        return;
    L30:
        return;
    L19:
        if (this.mSingleLoadSleepTimeMs > 0) goto L21;
        return;
    L21:
        if (Logger.debug() == false) goto L26;
        Logger.globalDebug(TAG, "callbackDownloadInfo", "Sleep:" + this.mSingleLoadSleepTimeMs);
    L26:
        Thread.sleep(this.mSingleLoadSleepTimeMs);     // Catch: Throwable -> L25
        return;
    }

    private void handleDownloadInfoData(String r12) {
        Cursor r5 = null;
        r5 = this.mDatabase.rawQuery(r12, null);     // Catch: Throwable -> L56
        if (Logger.alog() == false) goto L6;
        Logger.globalDebug(TAG, "handleDownloadInfoData", "Run sql:" + r12);     // Catch: Throwable -> L56
    L6:
        SqlDownloadHelper.loadDownloadInfoIndex(r5);     // Catch: Throwable -> L56
        DownloadInfo.setOptimizeMonitorLoad(true);     // Catch: Throwable -> L56
        Map<String, DownloadHelper.SceneLruLimitInfo> r13 = DownloadHelper.getDbInitSceneLruLimitMap();     // Catch: Throwable -> L56
    L7:
        int r2 = 0;
    L9:
        if (r5.moveToNext() == false) goto L54;
        if (r13 == null) goto L11;
        DownloadInfo r6 = new DownloadInfo();     // Catch: Throwable -> L56
        boolean r7 = SqlDownloadHelper.parseMonitorScene(r5, r6);     // Catch: Throwable -> L56
        String r8 = r6.getMonitorScene();     // Catch: Throwable -> L56
        if (TextUtils.isEmpty(r8) == true) goto L20;
        DownloadHelper.SceneLruLimitInfo r9 = r13.get(r8);     // Catch: Throwable -> L56
        if (r9 == null) goto L20;
        int r10 = r9.curCount;     // Catch: Throwable -> L56
        if (r10 > r9.limit) goto L9;
        r9.curCount = r10 + 1;     // Catch: Throwable -> L56
    L20:
        SqlDownloadHelper.parsePartialDownloadInfo(r5, r6, r7);     // Catch: Throwable -> L56
    L21:
        SqlDownloadHelper.parseAllRemainingDownloadInfo(r5, r6);     // Catch: Throwable -> L56
        if (r6.isCanResumeFromBreakPointStatus() == false) goto L25;
        r6.setDBInitStatus(r6.getStatus());     // Catch: Throwable -> L56
        r6.setStatus(-5);     // Catch: Throwable -> L56
    L25:
        if (r6.getStatus() == (-3)) goto L32;
        if (r6.getStatus() == 11) goto L32;
        if (r6.isFileDataValidOptimize() == true) goto L32;
        r6.reset();     // Catch: Throwable -> L56
    L34:
        this.mLruMemoryCacheId.add(Integer.valueOf(r6.getId()));     // Catch: Throwable -> L56
        if (this.mAutoResumeList == null) goto L49;
        List<String> r11 = this.mMimeTypes;     // Catch: Throwable -> L56
        if (r11 == null) goto L49;
        if (r11.isEmpty() == true) goto L49;
        if (this.mMimeTypes.contains(r6.getMimeType()) == false) goto L49;
        if (DownloadSetting.obtain(r6).optInt("enable_notification_ui") < 2) goto L45;
    L48:
        this.mAutoResumeList.add(r6);     // Catch: Throwable -> L56
        goto L49
    L45:
        if (r6.getRealStatus() != (-2)) goto L48;
        if (r6.isPauseReserveOnWifi() == true) goto L48;
    L49:
        this.mCopyDownloadInfoMap.put(r6.getId(), r6);     // Catch: Throwable -> L56
        int r14 = this.mSingleLoadCountLimit;     // Catch: Throwable -> L56
        if (r14 <= 0) goto L9;
        r2 = r2 + 1;     // Catch: Throwable -> L56
        if (r2 < r14) goto L9;
        callbackDownloadInfo(false);     // Catch: Throwable -> L56
    L32:
        if (r6.getStatus() != 11) goto L34;
        r6.setStatus(-5);     // Catch: Throwable -> L56
        goto L34
    L11:
        r6 = SqlDownloadHelper.parsePartialDownloadInfo(r5);     // Catch: Throwable -> L56
        goto L21
    L54:
        this.mDbInfo.memoryCacheCount = this.mCopyDownloadInfoMap.size();     // Catch: Throwable -> L56
        DownloadUtils.safeClose(new Cursor[]{r5});
        return;
    L56:
        th = move-exception;
        Logger.globalError(TAG, "handleDownloadInfoData", "Error:" + th);     // Catch: Throwable -> L60
        DownloadUtils.safeClose(new Cursor[]{r5});
        return;
    L60:
        th = move-exception;
        DownloadUtils.safeClose(new Cursor[]{r5});
        throw th;
    }

    private void handleUnreadDBIdData(String r8) {
        Cursor r2 = null;
        r2 = this.mDatabase.rawQuery(r8, null);     // Catch: Throwable -> L11
    L5:
        if (r2.moveToNext() == false) goto L9;
        int r9 = SqlDownloadHelper.parseDownloadId(r2);     // Catch: Throwable -> L11
        if (this.mLruMemoryCacheId.contains(Integer.valueOf(r9)) == true) goto L5;
        this.mUnreadDBSet.add(Integer.valueOf(r9));     // Catch: Throwable -> L11
        goto L5
    L9:
        this.mDbInfo.diskCacheCount = this.mUnreadDBSet.size() + this.mLruMemoryCacheId.size();     // Catch: Throwable -> L11
        DownloadUtils.safeClose(new Cursor[]{r2});
        return;
    L11:
        th = move-exception;
        Logger.globalError(TAG, "handleUnreadDBIdData", "Error:" + th);     // Catch: Throwable -> L15
        DownloadUtils.safeClose(new Cursor[]{r2});
        return;
    L15:
        th = move-exception;
        DownloadUtils.safeClose(new Cursor[]{r2});
        throw th;
    }

    public static void onInitEnd(DownloadDBInitInfo r4) {
        r4.initDuration = System.currentTimeMillis() - r4.initDuration;
        r4.initCpuDuration = (Debug.threadCpuTimeNanos() - r4.initCpuDuration) / 1000000;
        if (Logger.alog() == false) goto L5;
        Logger.globalDebug(TAG, "onInitEnd", "DBInfo:" + r4);
    L5:
        DownloadMonitorHelper.monitorDownloadDB(r4);
        IDownloadDBListener r0 = DownloadComponentManager.getDownloadDBListener();
        if (r0 == null) goto L8;
        r0.onInitFinish(r4);
    L8:
        DownloadDiskReporter.reportDbInfo(r4);
        SqlDownloadHelper.tryCreateDBIndex();
    }

    private String buildQuery(String r4, int r5) {
        StringBuilder r0 = new StringBuilder("SELECT " + r4 + " FROM downloader");
        buildQueryString(r0, DBDefinition.MONITOR_SCENE, DownloadHelper.getDbInitSceneSet());
        buildQueryString(r0, DBDefinition.MIME_TYPE, DownloadHelper.getSkipDbInitExpectMimeTypeSet());
        if (r5 <= 0) goto L6;
        r0.append(" LIMIT ");
        r0.append(r5);
    L6:
        return r0.toString();
    }

    private void buildQueryString(StringBuilder r4, String r5, Set<String> r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.isEmpty() == false) goto L7;
        return;
    L7:
        if (r4.indexOf(" WHERE ") >= 0) goto L9;
        r4.append(" WHERE " + r5 + " IN (");
    L10:
        Iterator<String> r7 = r6.iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        String r8 = r7.next();
        r4.append("\"");
        r4.append(r8);
        r4.append("\",");
        goto L12
    L14:
        r4.deleteCharAt(r4.length() - 1);
        r4.append(")");
        return;
    L9:
        r4.append(" OR " + r5 + " IN (");
        goto L10
    }

    public DownloadDBInitRunner(SQLiteDatabase r2, DownloadDBInitInfo r3, SparseArray<DownloadInfo> r4, Set<Integer> r5, List<DownloadInfo> r6, List<String> r7, SqlCacheLoadCompleteCallback r8, ISqlCacheLoadCompleteCallbackAidl r9, int r10, long r11) {
        this.mLruMemoryCacheId = new HashSet();
        this.mDatabase = r2;
        this.mDbInfo = r3;
        this.mCopyDownloadInfoMap = r4;
        this.mUnreadDBSet = r5;
        this.mAutoResumeList = r6;
        this.mMimeTypes = r7;
        this.mCallback = r8;
        this.mCallbackAidl = r9;
        this.mSingleLoadCountLimit = r10;
        this.mSingleLoadSleepTimeMs = r11;
    }
}
