package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.segment.Segment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class LruDownloadCache extends DownloadCache {
    static final String TAG = "LruDownloadCache";
    private final List<DownloadInfo> autoResumeList;
    private final LinkedHashMap<Integer, DownloadInfo> lruDownloadInfoMap;
    private final SparseArray<Map<Long, Segment>> lruSegmentListMap;
    private final Set<Integer> mUnreadDBSet;
    private ISqlDownloadCache sqlDownloadCache;

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean ensureDownloadCacheSyncSuccess() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void init(boolean r1) {
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean isDownloadCacheSyncSuccess() {
        return false;
    }

    private void clearLruDownloadInfoMap() {
        LinkedHashMap<Integer, DownloadInfo> r0 = this.lruDownloadInfoMap;
        monitor-enter(r0);
        this.lruDownloadInfoMap.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void clearLruSegmentListMap() {
        SparseArray<Map<Long, Segment>> r0 = this.lruSegmentListMap;
        monitor-enter(r0);
        this.lruSegmentListMap.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void clearUnreadMap() {
        this.mUnreadDBSet.clear();
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearData() {
        visitDownloadMemoryInfo();
        clearLruDownloadInfoMap();
        clearUnreadMap();
        clearLruSegmentListMap();
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getAllDownloadInfo() {
        visitDownloadMemoryInfo();
        return this.sqlDownloadCache.getAllDownloadInfo();
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache
    public List<String> getMimeTypes() {
        IDownloadLaunchHandler r0 = DownloadComponentManager.getDownloadLaunchHandler();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getResumeMimeTypes();
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache
    public List<DownloadInfo> getAutoResumeList() {
        return this.autoResumeList;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache
    public Set<Integer> getUnreadDBSet() {
        return this.mUnreadDBSet;
    }

    public LruDownloadCache(ISqlDownloadCache r5) {
        super(r5);
        this.lruSegmentListMap = new SparseArray();
        this.mUnreadDBSet = new CopyOnWriteArraySet();
        this.autoResumeList = new ArrayList();
        this.lruDownloadInfoMap = new 1(this, 0, 0.75f, true);
        this.sqlDownloadCache = r5;
    }

    private void addToUnreadMap(Integer r2) {
        this.mUnreadDBSet.add(r2);
    }

    private DownloadInfo getFromLruDownloadInfoMap(Integer r3) {
        LinkedHashMap<Integer, DownloadInfo> r0 = this.lruDownloadInfoMap;
        monitor-enter(r0);
        DownloadInfo r4 = this.lruDownloadInfoMap.get(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    private Map<Long, Segment> getFromLruSegmentListMap(Integer r3) {
        SparseArray<Map<Long, Segment>> r0 = this.lruSegmentListMap;
        monitor-enter(r0);
        Map<Long, Segment> r4 = this.lruSegmentListMap.get(r3.intValue());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isExistInUnreadMap(Integer r2) {
        if (r2.intValue() != 0) goto L7;
        return false;
    L7:
        return this.mUnreadDBSet.contains(r2);
    }

    private void removeFromLruDownloadInfoMap(Integer r3) {
        LinkedHashMap<Integer, DownloadInfo> r0 = this.lruDownloadInfoMap;
        monitor-enter(r0);
        this.lruDownloadInfoMap.remove(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void removeFromLruSegmentListMap(Integer r3) {
        SparseArray<Map<Long, Segment>> r0 = this.lruSegmentListMap;
        monitor-enter(r0);
        this.lruSegmentListMap.remove(r3.intValue());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void removeFromUnreadMap(Integer r2) {
        if (r2.intValue() != 0) goto L5;
        return;
    L5:
        this.mUnreadDBSet.remove(r2);
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskIntercept(int r2) {
        DownloadInfo r3 = getDownloadInfo(r2);
        if (r3 == null) goto L5;
        r3.setStatus(-7);
    L5:
        return r3;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPrepare(int r2) {
        DownloadInfo r3 = getDownloadInfo(r2);
        if (r3 == null) goto L5;
        r3.setStatus(1);
    L5:
        return r3;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskRetry(int r2) {
        DownloadInfo r3 = getDownloadInfo(r2);
        if (r3 == null) goto L5;
        r3.setStatus(5);
        r3.setFirstDownload(false);
    L5:
        return r3;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache
    public void addToDownloadCacheInfoMap(DownloadInfo r2) {
        addToLruDownloadInfoMap(Integer.valueOf(r2.getId()), r2);
        removeFromUnreadMap(Integer.valueOf(r2.getId()));
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean cacheExist(int r1) {
        if (getDownloadInfo(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearMemoryCacheData(double r5) {
        visitDownloadMemoryInfo();
        if (r5 > 0.0d) goto L5;
        return;
    L5:
        if (r5 > 1.0d) goto L36;
        LinkedHashMap<Integer, DownloadInfo> r1 = this.lruDownloadInfoMap;
        monitor-enter(r1);
        int r6 = (int) (((double) this.lruDownloadInfoMap.size()) * r5);     // Catch: Throwable -> L26
        if (Logger.debug() == false) goto L12;
        Logger.globalDebug(TAG, "clearMemoryCacheData", "Before LruDownloadInfoMap Size:" + this.lruDownloadInfoMap.size() + " ClearSize:" + r6);     // Catch: Throwable -> L26
    L12:
        Iterator<Map.Entry<Integer, DownloadInfo>> r7 = this.lruDownloadInfoMap.entrySet().iterator();     // Catch: Throwable -> L26
        int r0 = 0;
    L14:
        if (r7.hasNext() == false) goto L22;
        if (r0 >= r6) goto L22;
        if (DownloadComponentManager.getDownloadEngine().isDownloading(r7.next().getKey().intValue()) == true) goto L20;
        r7.remove();     // Catch: Throwable -> L26
    L20:
        r0 = r0 + 1;     // Catch: Throwable -> L26
    L22:
        if (Logger.debug() == false) goto L24;
        Logger.globalDebug(TAG, "clearMemoryCacheData", "End LruDownloadInfoMap Size:" + this.lruDownloadInfoMap.size());     // Catch: Throwable -> L26
    L24:
        monitor-exit(r1);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo getDownloadInfo(int r3) {
        visitDownloadMemoryInfo();
        DownloadInfo r0 = null;
        r0 = getFromLruDownloadInfoMap(Integer.valueOf(r3));     // Catch: Exception -> L12
        if (r0 == null) goto L6;
    L14:
        return r0;
    L6:
        if (isExistInUnreadMap(Integer.valueOf(r3)) == false) goto L14;
        r0 = this.sqlDownloadCache.getDownloadInfo(r3);     // Catch: Exception -> L12
        if (r0 == null) goto L10;
        addToLruDownloadInfoMap(Integer.valueOf(r3), r0);     // Catch: Exception -> L12
    L10:
        removeFromUnreadMap(Integer.valueOf(r3));     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfoList(String r2) {
        visitDownloadMemoryInfo();
        return this.sqlDownloadCache.getDownloadInfoList(r2);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfosByFileExtension(String r2) {
        visitDownloadMemoryInfo();
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return null;
    L7:
        return this.sqlDownloadCache.getDownloadInfosByFileExtension(r2);
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfosByMonitorScene(List<String> r2) {
        visitDownloadMemoryInfo();
        return this.sqlDownloadCache.getDownloadInfosByMonitorScene(r2);
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public Map<Long, Segment> getSegmentMap(int r2) {
        Map<Long, Segment> r0 = getFromLruSegmentListMap(Integer.valueOf(r2));
        if (r0 != null) goto L9;
        r0 = this.sqlDownloadCache.getSegmentMap(r2);
        if (r0 != null) goto L8;
        return null;
    L8:
        addToLruSegmentListMap(r2, r0);
    L9:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<Segment> getSegments(int r2) {
        Map<Long, Segment> r3 = getSegmentMap(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return new ArrayList(r3.values());
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r2) {
        visitDownloadMemoryInfo();
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return null;
    L7:
        return this.sqlDownloadCache.getSuccessedDownloadInfosWithMimeType(r2);
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r2) {
        visitDownloadMemoryInfo();
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return null;
    L7:
        return this.sqlDownloadCache.getUnCompletedDownloadInfosWithMimeType(r2);
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo onDownloadTaskStart(int r2) {
        DownloadInfo r3 = getDownloadInfo(r2);
        if (r3 == null) goto L5;
        r3.setStatus(2);
    L5:
        return r3;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadInfo(int r2) {
        visitDownloadMemoryInfo();
        removeFromLruDownloadInfoMap(Integer.valueOf(r2));
        removeFromUnreadMap(Integer.valueOf(r2));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadTaskData(int r1) {
        removeDownloadInfo(r1);
        removeSegments(r1);
        removeFromUnreadMap(Integer.valueOf(r1));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeSegments(int r1) {
        removeFromLruSegmentListMap(Integer.valueOf(r1));
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfo(DownloadInfo r1) {
        updateDownloadInfo(r1);
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateDownloadInfo(DownloadInfo r3) {
        visitDownloadMemoryInfo();
        boolean r0 = true;
        if (r3 != null) goto L6;
        return true;
    L6:
        if (getDownloadInfo(r3.getId()) != null) goto L9;
        r0 = false;
    L9:
        addToLruDownloadInfoMap(Integer.valueOf(r3.getId()), r3);
        removeFromUnreadMap(Integer.valueOf(r3.getId()));
        return r0;
    }

    public static /* synthetic */ void access$000(LruDownloadCache r0, Integer r1) {
        r0.addToUnreadMap(r1);
    }

    private void addToLruDownloadInfoMap(Integer r3, DownloadInfo r4) {
        if (r3.intValue() != 0) goto L5;
        return;
    L5:
        LinkedHashMap<Integer, DownloadInfo> r0 = this.lruDownloadInfoMap;
        monitor-enter(r0);
        this.lruDownloadInfoMap.put(r3, r4);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void addToLruSegmentListMap(int r3, Map<Long, Segment> r4) {
        if (r3 != 0) goto L4;
        return;
    L4:
        SparseArray<Map<Long, Segment>> r0 = this.lruSegmentListMap;
        monitor-enter(r0);
        this.lruSegmentListMap.put(r3, r4);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCancel(int r2, long r3) {
        DownloadInfo r4 = getDownloadInfo(r2);
        if (r4 == null) goto L5;
        r4.setCurBytes(r3, false);
        r4.setStatus(-4);
    L5:
        return r4;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
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

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskError(int r2, long r3) {
        DownloadInfo r4 = getDownloadInfo(r2);
        if (r4 == null) goto L5;
        r4.setCurBytes(r3, false);
        r4.setStatus(-1);
        r4.setFirstDownload(false);
    L5:
        return r4;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPause(int r2, long r3) {
        DownloadInfo r4 = getDownloadInfo(r2);
        if (r4 == null) goto L5;
        r4.setCurBytes(r3, false);
        r4.setStatus(-2);
    L5:
        return r4;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
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

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfosByFilters(String r2, String r3) {
        visitDownloadMemoryInfo();
        return getDownloadInfosByFilters(this.sqlDownloadCache.getAllDownloadInfo(), r2, r3);
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateSegments(int r1, Map<Long, Segment> r2) {
        addToLruSegmentListMap(r1, r2);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
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
