package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler;
import com.ss.android.socialbase.downloader.downloader.IDownloadMemoryInfoListener;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DownloadCache implements IDownloadCache {
    private static final String TAG = "DownloadCache";
    private boolean activeLoadDownloadCache;
    private final Map<Integer, DownloadInfo> downloadInfoMap;
    private final Map<Integer, Map<Long, Segment>> segmentListMap;

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean ensureDownloadCacheSyncSuccess() {
        return false;
    }

    public List<String> getMimeTypes() {
        return null;
    }

    public Set<Integer> getUnreadDBSet() {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void init(boolean r1) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void initImmediately() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean isDownloadCacheSyncSuccess() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfoFromOtherCache(int r1) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearData() {
        visitDownloadMemoryInfo();
        this.downloadInfoMap.clear();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getAllDownloadInfo() {
        visitDownloadMemoryInfo();
        if (this.downloadInfoMap.isEmpty() == false) goto L6;
        return null;
    L6:
        ArrayList r0 = new ArrayList();
        Iterator<DownloadInfo> r1 = this.downloadInfoMap.values().iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        r0.add(r1.next());
        goto L8
    L10:
        return r0;
    }

    public List<DownloadInfo> getAutoResumeList() {
        IDownloadLaunchHandler r0 = DownloadComponentManager.getDownloadLaunchHandler();
        if (r0 == null) goto L10;
        List r1 = r0.getResumeMimeTypes();
        if (r1 != null) goto L7;
    L9:
        ArrayList r2 = null;
    L11:
        SparseArray r3 = new SparseArray();
        Iterator<Map.Entry<Integer, DownloadInfo>> r4 = this.downloadInfoMap.entrySet().iterator();
    L13:
        if (r4.hasNext() == false) goto L20;
        Map.Entry<Integer, DownloadInfo> r5 = r4.next();
        if (r5.getKey().intValue() == 0) goto L13;
        if (r5.getValue() == null) goto L13;
        r3.put(r5.getKey().intValue(), r5.getValue());
        goto L13
    L20:
        if (r3.size() != 0) goto L22;
        return null;
    L22:
        int r6 = 0;
    L24:
        if (r6 >= r3.size()) goto L53;
        int r7 = r3.keyAt(r6);
        if (r7 == 0) goto L52;
        DownloadInfo r8 = (DownloadInfo) r3.get(r7);
        if (r8 == null) goto L52;
        int r9 = r8.getRealStatus();
        int r10 = r8.getStatusAtDbInit();
        if (r10 >= 1) goto L34;
    L36:
        if (r1 == null) goto L52;
        if (r2 == null) goto L52;
        if (r8.getMimeType() == null) goto L52;
        if (r1.contains(r8.getMimeType()) == false) goto L52;
        if (DownloadSetting.obtain(r8.getId()).optInt("enable_notification_ui") < 2) goto L47;
    L51:
        r8.setDownloadFromReserveWifi(false);
        r2.add(r8);
        goto L52
    L47:
        if (r9 != (-2)) goto L51;
        if (r8.isPauseReserveOnWifi() == true) goto L51;
    L34:
        if (r10 > 11) goto L36;
        DownloadMonitorHelper.monitorSendWithGlobalSdkMonitor(DownloadComponentManager.getDownloadMonitorListener(), null, r8, null, -5);
    L52:
        r6 = r6 + 1;
        goto L24
    L53:
        return r2;
    L7:
        if (r1.isEmpty() == true) goto L9;
        r2 = new ArrayList();
        goto L11
    L10:
        r1 = null;
        r2 = null;
        goto L11
    }

    public void visitDownloadMemoryInfo() {
        IDownloadMemoryInfoListener r0 = DownloadComponentManager.getDownloadMemoryInfoListener();
        if (r0 == null) goto L6;
        r0.onVisitMemoryInfo();
    L6:
        if (this.activeLoadDownloadCache == true) goto L8;
        return;
    L8:
        if (DownloadUtils.isMainThread() == true) goto L12;
        DownloadComponentManager.getDownloadCache().ensureDownloadCacheSyncSuccess();
        return;
    }

    public boolean isActiveLoadDownloadCache() {
        return this.activeLoadDownloadCache;
    }

    public DownloadCache(ISqlDownloadCache r3) {
        this.downloadInfoMap = new ConcurrentHashMap();
        this.segmentListMap = new ConcurrentHashMap();
        boolean r4 = false;
        this.activeLoadDownloadCache = false;
        if (DownloadSetting.getGlobalSettings().optInt("active_load_download_cache") <= 0) goto L5;
        r4 = true;
    L5:
        this.activeLoadDownloadCache = r4;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskIntercept(int r2) {
        DownloadInfo r3 = getDownloadInfo(r2);
        if (r3 == null) goto L5;
        r3.setStatus(-7);
    L5:
        return r3;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPrepare(int r2) {
        DownloadInfo r3 = getDownloadInfo(r2);
        if (r3 == null) goto L5;
        r3.setStatus(1);
    L5:
        return r3;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskRetry(int r2) {
        DownloadInfo r3 = getDownloadInfo(r2);
        if (r3 == null) goto L5;
        r3.setStatus(5);
        r3.setFirstDownload(false);
    L5:
        return r3;
    }

    public void addToDownloadCacheInfoMap(DownloadInfo r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        this.downloadInfoMap.put(Integer.valueOf(r3.getId()), r3);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean cacheExist(int r1) {
        if (getDownloadInfo(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearMemoryCacheData(double r6) {
        visitDownloadMemoryInfo();
        if (r6 > 0.0d) goto L5;
        return;
    L5:
        if (r6 > 1.0d) goto L30;
        int r7 = (int) (((double) this.downloadInfoMap.size()) * r6);
        if (Logger.debug() == false) goto L10;
        Logger.globalDebug(TAG, "clearMemoryCacheData", "Before DownloadInfoMap Size:" + this.downloadInfoMap.size() + " ClearSize:" + r7);
    L10:
        Iterator<Map.Entry<Integer, DownloadInfo>> r8 = this.downloadInfoMap.entrySet().iterator();
        int r2 = 0;
    L12:
        if (r8.hasNext() == false) goto L19;
        if (r2 >= r7) goto L19;
        if (DownloadComponentManager.getDownloadEngine().isDownloading(r8.next().getKey().intValue()) == true) goto L12;
        r8.remove();
        r2 = r2 + 1;
    L19:
        if (Logger.debug() == false) goto L29;
        Logger.globalDebug(TAG, "clearMemoryCacheData", "End DownloadInfoMap Size:" + this.downloadInfoMap.size());
        return;
    L29:
        return;
    }

    public void copyDownloadInfoMap(SparseArray<DownloadInfo> r4) {
        Iterator<Map.Entry<Integer, DownloadInfo>> r0 = this.downloadInfoMap.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Map.Entry<Integer, DownloadInfo> r1 = r0.next();
        if (r1.getKey().intValue() == 0) goto L4;
        if (r1.getValue() == null) goto L4;
        r4.put(r1.getKey().intValue(), r1.getValue());
        goto L4
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo getDownloadInfo(int r2) {
        visitDownloadMemoryInfo();
        return this.downloadInfoMap.get(Integer.valueOf(r2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfoList(String r5) {
        visitDownloadMemoryInfo();
        ArrayList r0 = new ArrayList();
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return r0;
    L5:
        Iterator<DownloadInfo> r1 = this.downloadInfoMap.values().iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        DownloadInfo r2 = r1.next();
        if (r5.equals(r2.getUrl()) == false) goto L7;
        r0.add(r2);
        goto L7
    L11:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfosByFileExtension(String r5) {
        visitDownloadMemoryInfo();
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        if (this.downloadInfoMap.isEmpty() == true) goto L29;
        ArrayList r0 = new ArrayList();
        Iterator<DownloadInfo> r1 = this.downloadInfoMap.values().iterator();
    L9:
        if (r1.hasNext() == false) goto L17;
        DownloadInfo r2 = r1.next();
        if (r2 == null) goto L9;
        if (TextUtils.isEmpty(r2.getName()) == true) goto L9;
        if (r2.getName().endsWith(r5) == false) goto L9;
        r0.add(r2);
        goto L9
    L17:
        return r0;
    L29:
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfosByMonitorScene(List<String> r5) {
        visitDownloadMemoryInfo();
        if (r5 != null) goto L5;
        return null;
    L5:
        if (r5.isEmpty() == false) goto L7;
        return null;
    L7:
        if (this.downloadInfoMap.isEmpty() == true) goto L32;
        ArrayList r0 = new ArrayList();
        HashSet r1 = new HashSet(r5);
        Iterator<DownloadInfo> r6 = this.downloadInfoMap.values().iterator();
    L11:
        if (r6.hasNext() == false) goto L19;
        DownloadInfo r2 = r6.next();
        if (r2 == null) goto L11;
        if (TextUtils.isEmpty(r2.getMonitorScene()) == true) goto L11;
        if (r1.contains(r2.getMonitorScene()) == false) goto L11;
        r0.add(r2);
        goto L11
    L19:
        return r0;
    L32:
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public Map<Long, Segment> getSegmentMap(int r2) {
        return this.segmentListMap.get(Integer.valueOf(r2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<Segment> getSegments(int r2) {
        Map<Long, Segment> r3 = this.segmentListMap.get(Integer.valueOf(r2));
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r3.isEmpty() == false) goto L8;
        return null;
    L8:
        return new ArrayList(r3.values());
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r6) {
        visitDownloadMemoryInfo();
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return null;
    L5:
        if (this.downloadInfoMap.isEmpty() == true) goto L29;
        ArrayList r0 = new ArrayList();
        Iterator<DownloadInfo> r1 = this.downloadInfoMap.values().iterator();
    L9:
        if (r1.hasNext() == false) goto L17;
        DownloadInfo r2 = r1.next();
        if (TextUtils.isEmpty(r2.getMimeType()) == true) goto L9;
        if (r2.getMimeType().equals(r6) == false) goto L9;
        if (r2.getStatus() != (-3)) goto L9;
        r0.add(r2);
        goto L9
    L17:
        return r0;
    L29:
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r5) {
        visitDownloadMemoryInfo();
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        if (this.downloadInfoMap.isEmpty() == true) goto L33;
        ArrayList r0 = new ArrayList();
        Iterator<DownloadInfo> r1 = this.downloadInfoMap.values().iterator();
    L9:
        if (r1.hasNext() == false) goto L19;
        DownloadInfo r2 = r1.next();
        if (r2 == null) goto L9;
        if (TextUtils.isEmpty(r2.getMimeType()) == true) goto L9;
        if (r2.getMimeType().equals(r5) == false) goto L9;
        if (DownloadStatus.isUnCompletedStatus(r2.getStatus()) == false) goto L9;
        r0.add(r2);
        goto L9
    L19:
        return r0;
    L33:
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo onDownloadTaskStart(int r2) {
        DownloadInfo r3 = getDownloadInfo(r2);
        if (r3 == null) goto L5;
        r3.setStatus(2);
    L5:
        return r3;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadInfo(int r2) {
        visitDownloadMemoryInfo();
        this.downloadInfoMap.remove(Integer.valueOf(r2));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadTaskData(int r1) {
        removeDownloadInfo(r1);
        removeSegments(r1);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeSegments(int r2) {
        this.segmentListMap.remove(Integer.valueOf(r2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfo(DownloadInfo r1) {
        updateDownloadInfo(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateDownloadInfo(DownloadInfo r4) {
        visitDownloadMemoryInfo();
        boolean r0 = true;
        if (r4 != null) goto L6;
        return true;
    L6:
        if (this.downloadInfoMap.get(Integer.valueOf(r4.getId())) != null) goto L9;
        r0 = false;
    L9:
        this.downloadInfoMap.put(Integer.valueOf(r4.getId()), r4);
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCancel(int r2, long r3) {
        DownloadInfo r4 = getDownloadInfo(r2);
        if (r4 == null) goto L5;
        r4.setCurBytes(r3, false);
        r4.setStatus(-4);
    L5:
        return r4;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCompleted(int r2, long r3) {
        DownloadInfo r4 = getDownloadInfo(r2);
        if (r4 == null) goto L5;
        r4.setCurBytes(r3, false);
        r4.setStatus(-3);
        r4.setFirstDownload(false);
        r4.setFirstSuccess(false);
    L5:
        return r4;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskError(int r2, long r3) {
        DownloadInfo r4 = getDownloadInfo(r2);
        if (r4 == null) goto L5;
        r4.setCurBytes(r3, false);
        r4.setStatus(-1);
        r4.setFirstDownload(false);
    L5:
        return r4;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPause(int r2, long r3) {
        DownloadInfo r4 = getDownloadInfo(r2);
        if (r4 == null) goto L5;
        r4.setCurBytes(r3, false);
        r4.setStatus(-2);
    L5:
        return r4;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskProgress(int r2, long r3) {
        DownloadInfo r4 = getDownloadInfo(r2);
        if (r4 == null) goto L13;
        r4.setCurBytes(r3, false);
        if (r4.getStatus() == (-3)) goto L13;
        if (r4.getStatus() == (-2)) goto L13;
        if (DownloadStatus.isFailedStatus(r4.getStatus()) == true) goto L13;
        if (r4.getStatus() == (-4)) goto L13;
        r4.setStatus(4);
    L13:
        return r4;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfosByFilters(String r2, String r3) {
        visitDownloadMemoryInfo();
        return getDownloadInfosByFilters(this.downloadInfoMap.values(), r2, r3);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateSegments(int r2, Map<Long, Segment> r3) {
        if (r3 == null) goto L6;
        this.segmentListMap.put(Integer.valueOf(r2), r3);
        return false;
    L6:
        return false;
    }

    private boolean checkFilter(DownloadInfo r3, String r4, String r5) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r4) == true) goto L14;
        if (TextUtils.isEmpty(r3.getMimeType()) == true) goto L14;
        if (r4.equals(r3.getMimeType()) == false) goto L14;
        return true;
    L14:
        if (TextUtils.isEmpty(r5) == false) goto L16;
    L26:
        return false;
    L16:
        if (TextUtils.isEmpty(r3.getUrl()) == true) goto L26;
        String r6 = UriProtector.parse(r3.getUrl()).getLastPathSegment();     // Catch: Throwable -> L19
    L22:
        if (TextUtils.isEmpty(r6) == false) goto L25;
        return false;
    L25:
        return r6.endsWith(r5);
    L19:
        th = move-exception;
        th.printStackTrace();
        r6 = null;
        goto L22
    }

    public List<DownloadInfo> getDownloadInfosByFilters(Collection<DownloadInfo> r4, String r5, String r6) {
        if (r4.isEmpty() == false) goto L6;
        return null;
    L6:
        ArrayList r0 = new ArrayList();
        Iterator<DownloadInfo> r7 = r4.iterator();
    L8:
        if (r7.hasNext() == false) goto L12;
        DownloadInfo r1 = r7.next();
        if (checkFilter(r1, r5, r6) == false) goto L8;
        r0.add(r1);
        goto L8
    L12:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskConnected(int r1, long r2, String r4, String r5) {
        DownloadInfo r3 = getDownloadInfo(r1);
        if (r3 == null) goto L10;
        r3.setTotalBytes(r2);
        r3.seteTag(r4);
        if (TextUtils.isEmpty(r3.getName()) == true) goto L7;
    L9:
        r3.setStatus(3);
        goto L10
    L7:
        if (TextUtils.isEmpty(r5) == true) goto L9;
        r3.setName(r5);
    L10:
        return r3;
    }
}
