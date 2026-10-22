package com.ss.android.socialbase.downloader.model;

import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.aa;
import com.ss.android.socialbase.downloader.depend.ah;
import com.ss.android.socialbase.downloader.depend.j;
import com.ss.android.socialbase.downloader.depend.l;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.depend.r;
import com.ss.android.socialbase.downloader.depend.t;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.downloader.IDownloadStartCallback;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.service.k;
import com.ss.android.socialbase.downloader.service.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class DownloadTask {
    private static final String TAG = "DownloadTask";
    private boolean autoRemoveCallback;
    private boolean autoSetHashCodeForSameTask;
    private j cdnListener;
    private n depend;
    private r diskSpaceHandler;
    private final List<l> downloadCompleteHandlers;
    private DownloadInfo downloadInfo;
    private DownloadInfo.a downloadInfoBuilder;
    private t fileUriProvider;
    private x forbiddenHandler;
    private int hashCodeForSameTask;
    private y interceptor;
    private int mPriority;
    private final Map<Integer, IDownloadListener> mainThreadListeners;
    private IDownloadMonitorDepend monitorDepend;
    private boolean needDelayForCacheSync;
    private ah notificationClickCallback;
    private aa notificationEventListener;
    private final Map<Integer, IDownloadListener> notificationListeners;
    private final Map<Integer, ListenerType> singleListenerHashCodeMap;
    private final Map<ListenerType, IDownloadListener> singleListenerMap;
    private final Map<Integer, IDownloadListener> subThreadListeners;
    private d threadInfo;
    private e timingInfo;

    public DownloadTask() {
        this.singleListenerMap = new ConcurrentHashMap();
        this.singleListenerHashCodeMap = new ConcurrentHashMap();
        this.needDelayForCacheSync = false;
        this.downloadCompleteHandlers = new CopyOnWriteArrayList();
        this.autoRemoveCallback = false;
        this.timingInfo = new e();
        this.threadInfo = new d();
        this.autoSetHashCodeForSameTask = true;
        this.mPriority = 0;
        this.downloadInfoBuilder = new DownloadInfo.a();
        this.mainThreadListeners = new ConcurrentHashMap();
        this.subThreadListeners = new ConcurrentHashMap();
        this.notificationListeners = new ConcurrentHashMap();
    }

    public DownloadTask(DownloadInfo r1) {
        this();
        this.downloadInfo = r1;
    }

    private void addAll(Map<Integer, IDownloadListener> r3, Map<Integer, IDownloadListener> r4) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L10;
        if (r5 == null) goto L12;
        Iterator r6 = r2.entrySet().iterator();
    L8:
        if (r6.hasNext() == false) goto L13;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r5.put(r7.getKey(), r7.getValue());
        goto L8
    L13:
        return;
    L12:
        return;
    }

    private void addListenerToDownloadingSameTask(ListenerType r6) {
        Map<Integer, IDownloadListener> r0 = getDownloadListeners(r6);
        if (r0 != null) goto L6;
        com.ss.android.socialbase.downloader.e.a.b(TAG, getDownloadId(), "addListenerToDownloadingSameTask", "ListenerType is null");
        return;
    L6:
        Iterator<IDownloadListener> r1 = r0.values().iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        IDownloadListener r2 = (IDownloadListener) ZeusTransformUtils.preCheckCast(r1.next(), IDownloadListener.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L8;
        ((com.ss.android.socialbase.downloader.service.t) ZeusTransformUtils.preCheckCast(k.a(com.ss.android.socialbase.downloader.service.t.class), com.ss.android.socialbase.downloader.service.t.class, "com.obric.memorydata.plugin")).b(getDownloadId(), r2, r6, false);
        goto L8
    }

    private void copyListeners(Map<Integer, IDownloadListener> r3, Map<Integer, IDownloadListener> r4) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        r2.clear();
        Iterator r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r7.getValue() == null) goto L4;
        r2.put(r7.getKey(), r7.getValue());
        goto L4
    }

    private int downloadImpl() {
        long r0 = System.currentTimeMillis();
        this.downloadInfo = this.downloadInfoBuilder.c();
        this.timingInfo.f15571a = r0;
        e r1 = this.timingInfo;
        r1.f15572b = System.currentTimeMillis();
        com.ss.android.socialbase.downloader.service.t r2 = (com.ss.android.socialbase.downloader.service.t) ZeusTransformUtils.preCheckCast(k.a(com.ss.android.socialbase.downloader.service.t.class), com.ss.android.socialbase.downloader.service.t.class, "com.obric.memorydata.plugin");
        if (r2.h(this.downloadInfo.getId()) != null) goto L5;
        ((o) ZeusTransformUtils.preCheckCast(k.a(o.class), o.class, "com.obric.memorydata.plugin")).a(this, null, 0);
    L5:
        r2.a(this);
        DownloadInfo r5 = this.downloadInfo;
        if (r5 != null) goto L9;
        return 0;
    L9:
        return r5.getId();
    }

    private void removeAll(Map<Integer, IDownloadListener> r3, Map<Integer, IDownloadListener> r4) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L10;
        if (r5 == null) goto L12;
        Iterator r6 = r5.entrySet().iterator();
    L8:
        if (r6.hasNext() == false) goto L13;
        r2.remove(((Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getKey());
        goto L8
    L13:
        return;
    L12:
        return;
    }

    private int[] setToInt(Set<Integer> r5) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return null;
    L5:
        if (r4.isEmpty() == true) goto L15;
        Object[] r6 = r4.toArray();
        int[] r7 = new int[r6.length];
        int r1 = 0;
    L9:
        if (r1 >= r6.length) goto L11;
        r7[r1] = ((Integer) ZeusTransformUtils.preCheckCast(r6[r1], Integer.class, "com.obric.memorydata.plugin")).intValue();
        r1 = r1 + 1;
        goto L9
    L11:
        return r7;
    L15:
        return null;
    }

    public DownloadTask accessHttpHeaderKeys(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.downloadInfoBuilder.d(r4);
        return this;
    }

    public DownloadTask addDownloadCompleteHandler(l r3) {
        l r4 = (l) ZeusTransformUtils.wrapperContextForParams(r3, l.class, "com.obric.memorydata.plugin");
        List<l> r0 = this.downloadCompleteHandlers;
        monitor-enter(r0);
        if (r4 != null) goto L16;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return this;
    L16:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (this.downloadCompleteHandlers.contains(r4) == true) goto L11;
        this.downloadCompleteHandlers.add(r4);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return this;
    }

    public void addDownloadListener(int r3, IDownloadListener r4, ListenerType r5, boolean r6) {
        IDownloadListener r7 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        return;
    L5:
        if (r6 == false) goto L16;
        Map<ListenerType, IDownloadListener> r8 = this.singleListenerMap;
        if (r8 == null) goto L16;
        r8.put(r5, r7);
        Map<Integer, ListenerType> r9 = this.singleListenerHashCodeMap;
        monitor-enter(r9);
        this.singleListenerHashCodeMap.put(Integer.valueOf(r3), r5);     // Catch: Throwable -> L13
        monitor-exit(r9);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L16:
        Map<Integer, IDownloadListener> r2 = getDownloadListeners(r5);
        if (r2 != null) goto L19;
        return;
    L19:
        monitor-enter(r2);
        r2.put(Integer.valueOf(r3), r7);     // Catch: Throwable -> L23
        monitor-exit(r2);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public void addListenerToDownloadingSameTask() {
        DownloadInfo r0 = this.downloadInfo;
        if (r0 != null) goto L5;
    L10:
        addListenerToDownloadingSameTask(ListenerType.MAIN);
        addListenerToDownloadingSameTask(ListenerType.SUB);
        ((o) ZeusTransformUtils.preCheckCast(k.a(o.class), o.class, "com.obric.memorydata.plugin")).a(this.monitorDepend, this.downloadInfo, new BaseException(1003, "has another same task, add Listener to old task"), 0);
        return;
    L5:
        if (com.ss.android.socialbase.downloader.e.a.a(r0) == false) goto L8;
        com.ss.android.socialbase.downloader.e.a.a(TAG, this.downloadInfo, "addListenerToDownloadingSameTask", "Same task just tryDownloading, so add listener in last task instead of tryDownload");
    L8:
        if (this.downloadInfo.isAddListenerToSameTask() == true) goto L10;
        this.downloadInfo.setAddListenerToSameTask(true);
        goto L10
    }

    public DownloadTask addListenerToSameTask(boolean r2) {
        this.downloadInfoBuilder.m(r2);
        return this;
    }

    public DownloadTask addTTNetCommonParam(boolean r2) {
        this.downloadInfoBuilder.s(r2);
        return this;
    }

    public void asyncDownload(IDownloadStartCallback r4) {
        final IDownloadStartCallback r5 = (IDownloadStartCallback) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadStartCallback.class, "com.obric.memorydata.plugin");
        ((com.ss.android.socialbase.downloader.service.l) ZeusTransformUtils.preCheckCast(k.a(com.ss.android.socialbase.downloader.service.l.class), com.ss.android.socialbase.downloader.service.l.class, "com.obric.memorydata.plugin")).a(new AnonymousClass1(this, r5));
    }

    public synchronized int autoCalAndGetHashCodeForSameTask() {
        monitor-enter(this);
        IDownloadListener r0 = getSingleDownloadListener(ListenerType.MAIN);     // Catch: Throwable -> L11
        if (r0 != null) goto L6;
        r0 = getSingleDownloadListener(ListenerType.SUB);     // Catch: Throwable -> L11
    L6:
        if (r0 == null) goto L8;
        this.hashCodeForSameTask = r0.hashCode();     // Catch: Throwable -> L11
    L8:
        int r1 = this.hashCodeForSameTask;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    public DownloadTask autoRemoveCallback(boolean r1) {
        this.autoRemoveCallback = r1;
        return this;
    }

    public DownloadTask autoResumed(boolean r2) {
        this.downloadInfoBuilder.g(r2);
        return this;
    }

    public DownloadTask autoSetHashCodeForSameTask(boolean r1) {
        this.autoSetHashCodeForSameTask = r1;
        return this;
    }

    public DownloadTask backUpUrlRetryCount(int r2) {
        this.downloadInfoBuilder.c(r2);
        return this;
    }

    public DownloadTask backUpUrls(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.downloadInfoBuilder.e(r4);
        return this;
    }

    public DownloadInfo buildDownloadInfo() {
        return this.downloadInfoBuilder.c();
    }

    public boolean canShowNotification() {
        DownloadInfo r0 = this.downloadInfo;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.canShowNotification();
    }

    public DownloadTask cdnListener(j r3) {
        this.cdnListener = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
        return this;
    }

    public DownloadTask cdnUrls(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.downloadInfoBuilder.b(r4);
        return this;
    }

    public void copyInterfaceFromNewTask(DownloadTask r4) {
        this.singleListenerMap.clear();
        this.singleListenerMap.putAll(r4.singleListenerMap);
        Map<Integer, IDownloadListener> r0 = this.mainThreadListeners;
        monitor-enter(r0);
        this.mainThreadListeners.clear();     // Catch: Throwable -> L28
        addAll(r4.mainThreadListeners, this.mainThreadListeners);     // Catch: Throwable -> L28
        monitor-exit(r0);     // Catch: Throwable -> L28
        Map<Integer, IDownloadListener> r1 = this.subThreadListeners;
        monitor-enter(r1);
        this.subThreadListeners.clear();     // Catch: Throwable -> L25
        addAll(r4.subThreadListeners, this.subThreadListeners);     // Catch: Throwable -> L25
        monitor-exit(r1);     // Catch: Throwable -> L25
        Map<Integer, IDownloadListener> r2 = this.notificationListeners;
        monitor-enter(r2);
        this.notificationListeners.clear();     // Catch: Throwable -> L22
        addAll(r4.notificationListeners, this.notificationListeners);     // Catch: Throwable -> L22
        monitor-exit(r2);     // Catch: Throwable -> L22
        this.notificationEventListener = r4.notificationEventListener;
        this.interceptor = r4.interceptor;
        this.depend = r4.depend;
        this.monitorDepend = r4.monitorDepend;
        this.forbiddenHandler = r4.forbiddenHandler;
        this.diskSpaceHandler = r4.diskSpaceHandler;
        this.notificationClickCallback = r4.notificationClickCallback;
        this.fileUriProvider = r4.fileUriProvider;
        List<l> r3 = this.downloadCompleteHandlers;
        monitor-enter(r3);
        this.downloadCompleteHandlers.clear();     // Catch: Throwable -> L19
        this.downloadCompleteHandlers.addAll(r4.downloadCompleteHandlers);     // Catch: Throwable -> L19
        monitor-exit(r3);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    L22:
        th = move-exception;
        throw th;
    L25:
        th = move-exception;
        throw th;
    L28:
        th = move-exception;
        throw th;
    }

    public void copyListenerFromPendingTask(DownloadTask r5) {
        Iterator<Map.Entry<ListenerType, IDownloadListener>> r0 = r5.singleListenerMap.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L48;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L4;
        if (this.singleListenerMap.containsKey(r1.getKey()) == true) goto L4;
        Map<ListenerType, IDownloadListener> r2 = this.singleListenerMap;
        Object r3 = r1.getKey();
        r2.put((ListenerType) r3, (IDownloadListener) r1.getValue());
        goto L4
    L48:
    L41:
        th = move-exception;
        th.printStackTrace();
        return;
    L12:
        if (r5.mainThreadListeners.size() == 0) goto L22;
        Map<Integer, IDownloadListener> r4 = this.mainThreadListeners;     // Catch: Throwable -> L41
        monitor-enter(r4);     // Catch: Throwable -> L41
        removeAll(this.mainThreadListeners, r5.mainThreadListeners);     // Catch: Throwable -> L18
        addAll(r5.mainThreadListeners, this.mainThreadListeners);     // Catch: Throwable -> L18
        monitor-exit(r4);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L22:
        if (r5.subThreadListeners.size() == 0) goto L32;
        Map<Integer, IDownloadListener> r6 = this.subThreadListeners;     // Catch: Throwable -> L41
        monitor-enter(r6);     // Catch: Throwable -> L41
        removeAll(this.subThreadListeners, r5.subThreadListeners);     // Catch: Throwable -> L28
        addAll(r5.subThreadListeners, this.subThreadListeners);     // Catch: Throwable -> L28
        monitor-exit(r6);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L32:
        if (r5.notificationListeners.size() == 0) goto L57;
        Map<Integer, IDownloadListener> r7 = this.notificationListeners;     // Catch: Throwable -> L41
        monitor-enter(r7);     // Catch: Throwable -> L41
        removeAll(this.notificationListeners, r5.notificationListeners);     // Catch: Throwable -> L38
        addAll(r5.notificationListeners, this.notificationListeners);     // Catch: Throwable -> L38
        monitor-exit(r7);     // Catch: Throwable -> L38
    L58:
        return;
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    }

    public DownloadTask deleteCacheIfCheckFailed(boolean r2) {
        this.downloadInfoBuilder.r(r2);
        return this;
    }

    public DownloadTask depend(n r3) {
        this.depend = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.memorydata.plugin");
        return this;
    }

    public DownloadTask diskSpaceHandler(r r3) {
        this.diskSpaceHandler = (r) ZeusTransformUtils.wrapperContextForParams(r3, r.class, "com.obric.memorydata.plugin");
        return this;
    }

    public DownloadTask distinctDirectory(boolean r2) {
        this.downloadInfoBuilder.t(r2);
        return this;
    }

    public int download() {
        if (com.ss.android.socialbase.downloader.g.a.c().b("fix_anr_remove_report_idle_status") <= 0) goto L5;
        long r0 = System.currentTimeMillis();
        this.downloadInfo = this.downloadInfoBuilder.c();
        this.timingInfo.f15571a = r0;
        e r1 = this.timingInfo;
        r1.f15572b = System.currentTimeMillis();
        int r2 = this.downloadInfo.getId();
        ((com.ss.android.socialbase.downloader.service.t) ZeusTransformUtils.preCheckCast(k.a(com.ss.android.socialbase.downloader.service.t.class), com.ss.android.socialbase.downloader.service.t.class, "com.obric.memorydata.plugin")).a(this);
        return r2;
    L5:
        return downloadImpl();
    }

    public DownloadTask downloadSetting(JSONObject r2) {
        this.downloadInfoBuilder.a(r2);
        return this;
    }

    public DownloadTask endOffset(long r2) {
        this.downloadInfoBuilder.d(r2);
        return this;
    }

    public DownloadTask enqueueType(EnqueueType r2) {
        this.downloadInfoBuilder.a(r2);
        return this;
    }

    public DownloadTask executorGroup(int r2) {
        this.downloadInfoBuilder.f(r2);
        return this;
    }

    public DownloadTask expectFileLength(long r2) {
        this.downloadInfoBuilder.a(r2);
        return this;
    }

    public DownloadTask expiredHttpCheck(boolean r2) {
        this.downloadInfoBuilder.q(r2);
        return this;
    }

    public DownloadTask expiredRedownload(boolean r2) {
        this.downloadInfoBuilder.p(r2);
        return this;
    }

    public DownloadTask extra(String r2) {
        this.downloadInfoBuilder.g(r2);
        return this;
    }

    public DownloadTask extraHeaders(List<HttpHeader> r3) {
        List<HttpHeader> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.downloadInfoBuilder.c(r4);
        return this;
    }

    public DownloadTask extraMonitorStatus(int[] r2) {
        this.downloadInfoBuilder.b(r2);
        return this;
    }

    public DownloadTask fastDownload() {
        this.downloadInfoBuilder.a();
        return this;
    }

    public DownloadTask fileUriProvider(t r3) {
        this.fileUriProvider = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        return this;
    }

    public DownloadTask forbiddenHandler(x r3) {
        this.forbiddenHandler = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
        return this;
    }

    public DownloadTask force(boolean r2) {
        this.downloadInfoBuilder.c(r2);
        return this;
    }

    public j getCdnListener() {
        return this.cdnListener;
    }

    public n getDepend() {
        return this.depend;
    }

    public r getDiskSpaceHandler() {
        return this.diskSpaceHandler;
    }

    public l getDownloadCompleteHandlerByIndex(int r3) {
        List<l> r0 = this.downloadCompleteHandlers;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (r3 >= this.downloadCompleteHandlers.size()) goto L9;
        l r2 = (l) ZeusTransformUtils.preCheckCast(this.downloadCompleteHandlers.get(r3), l.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return null;
    }

    public List<l> getDownloadCompleteHandlers() {
        return this.downloadCompleteHandlers;
    }

    public int getDownloadId() {
        DownloadInfo r0 = this.downloadInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getId();
    }

    public DownloadInfo getDownloadInfo() {
        return this.downloadInfo;
    }

    public IDownloadListener getDownloadListenerByHashCode(ListenerType r3, int r4) {
        if (r3 != ListenerType.MAIN) goto L8;
        Map<Integer, IDownloadListener> r2 = this.mainThreadListeners;
    L6:
        return (IDownloadListener) ZeusTransformUtils.preCheckCast(r2.get(Integer.valueOf(r4)), IDownloadListener.class, "com.obric.memorydata.plugin");
    L8:
        if (r3 != ListenerType.SUB) goto L11;
        r2 = this.subThreadListeners;
        goto L6
    L11:
        if (r3 != ListenerType.NOTIFICATION) goto L13;
        r2 = this.notificationListeners;
        goto L6
    L13:
        return null;
    }

    public int[] getDownloadListenerHashCodeLists(ListenerType r2) {
        if (r2 != ListenerType.MAIN) goto L8;
        Map<Integer, IDownloadListener> r3 = this.mainThreadListeners;
    L6:
        return setToInt(r3.keySet());
    L8:
        if (r2 != ListenerType.SUB) goto L11;
        r3 = this.subThreadListeners;
        goto L6
    L11:
        if (r2 != ListenerType.NOTIFICATION) goto L13;
        r3 = this.notificationListeners;
        goto L6
    L13:
        return null;
    }

    public Map<Integer, IDownloadListener> getDownloadListeners(ListenerType r2) {
        if (r2 != ListenerType.MAIN) goto L7;
        return this.mainThreadListeners;
    L7:
        if (r2 != ListenerType.SUB) goto L11;
        return this.subThreadListeners;
    L11:
        if (r2 == ListenerType.NOTIFICATION) goto L13;
        return null;
    L13:
        return this.notificationListeners;
    }

    public t getFileUriProvider() {
        return this.fileUriProvider;
    }

    public x getForbiddenHandler() {
        return this.forbiddenHandler;
    }

    public int getHashCodeForSameTask() {
        return this.hashCodeForSameTask;
    }

    public y getInterceptor() {
        return this.interceptor;
    }

    public IDownloadMonitorDepend getMonitorDepend() {
        return this.monitorDepend;
    }

    public ah getNotificationClickCallback() {
        return this.notificationClickCallback;
    }

    public aa getNotificationEventListener() {
        return this.notificationEventListener;
    }

    public IDownloadListener getSingleDownloadListener(ListenerType r2) {
        return (IDownloadListener) ZeusTransformUtils.preCheckCast(this.singleListenerMap.get(r2), IDownloadListener.class, "com.obric.memorydata.plugin");
    }

    public int getTaskPriority() {
        return this.mPriority;
    }

    public d getThreadInfo() {
        return this.threadInfo;
    }

    public e getTimingInfo() {
        return this.timingInfo;
    }

    public DownloadTask handleRequest() {
        this.downloadInfoBuilder.b();
        return this;
    }

    public DownloadTask hashCodeForSameTask(int r1) {
        this.hashCodeForSameTask = r1;
        return this;
    }

    @Deprecated
    public DownloadTask headConnectionAvailable(boolean r1) {
        return this;
    }

    public DownloadTask iconUrl(String r2) {
        this.downloadInfoBuilder.l(r2);
        return this;
    }

    public DownloadTask ignoreDataVerify(boolean r2) {
        this.downloadInfoBuilder.l(r2);
        return this;
    }

    public DownloadTask ignoreInterceptor(boolean r2) {
        this.downloadInfoBuilder.a(r2);
        return this;
    }

    public DownloadTask interceptor(y r3) {
        this.interceptor = (y) ZeusTransformUtils.wrapperContextForParams(r3, y.class, "com.obric.memorydata.plugin");
        return this;
    }

    public boolean isAutoSetHashCodeForSameTask() {
        return this.autoSetHashCodeForSameTask;
    }

    public boolean isNeedDelayForCacheSync() {
        return this.needDelayForCacheSync;
    }

    public DownloadTask isOpenLimitSpeed(boolean r2) {
        this.downloadInfoBuilder.o(r2);
        return this;
    }

    public DownloadTask mainThreadListener(IDownloadListener r3) {
        IDownloadListener r4 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadListener.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        return this;
    L6:
        return mainThreadListenerWithHashCode(r4.hashCode(), r4);
    }

    public DownloadTask mainThreadListenerWithHashCode(int r4, IDownloadListener r5) {
        IDownloadListener r6 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r5, IDownloadListener.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L19;
        Map<Integer, IDownloadListener> r0 = this.mainThreadListeners;
        monitor-enter(r0);
        this.mainThreadListeners.put(Integer.valueOf(r4), r6);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        this.singleListenerMap.put(ListenerType.MAIN, r6);
        Map<Integer, ListenerType> r7 = this.singleListenerHashCodeMap;
        monitor-enter(r7);
        this.singleListenerHashCodeMap.put(Integer.valueOf(r4), ListenerType.MAIN);     // Catch: Throwable -> L13
        monitor-exit(r7);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        throw th;
    L19:
        return this;
    }

    public DownloadTask maxBytes(int r2) {
        this.downloadInfoBuilder.a(r2);
        return this;
    }

    public DownloadTask maxProgressCount(int r2) {
        this.downloadInfoBuilder.d(r2);
        return this;
    }

    public DownloadTask md5(String r2) {
        this.downloadInfoBuilder.j(r2);
        return this;
    }

    public DownloadTask mimeType(String r2) {
        this.downloadInfoBuilder.h(r2);
        return this;
    }

    public DownloadTask minProgressTimeMsInterval(int r2) {
        this.downloadInfoBuilder.e(r2);
        return this;
    }

    public DownloadTask monitorDepend(IDownloadMonitorDepend r3) {
        this.monitorDepend = (IDownloadMonitorDepend) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadMonitorDepend.class, "com.obric.memorydata.plugin");
        return this;
    }

    public DownloadTask monitorScene(String r2) {
        this.downloadInfoBuilder.k(r2);
        return this;
    }

    public DownloadTask name(String r2) {
        this.downloadInfoBuilder.b(r2);
        return this;
    }

    @Deprecated
    public DownloadTask needChunkDowngradeRetry(boolean r1) {
        return this;
    }

    public DownloadTask needCurrentProcess(boolean r2) {
        this.downloadInfoBuilder.k(r2);
        return this;
    }

    public DownloadTask needDefaultHttpServiceBackUp(boolean r2) {
        this.downloadInfoBuilder.i(r2);
        return this;
    }

    public DownloadTask needHttpsToHttpRetry(boolean r2) {
        this.downloadInfoBuilder.e(r2);
        return this;
    }

    public DownloadTask needIndependentProcess(boolean r2) {
        this.downloadInfoBuilder.j(r2);
        return this;
    }

    public DownloadTask needPostProgress(boolean r2) {
        this.downloadInfoBuilder.d(r2);
        return this;
    }

    @Deprecated
    public DownloadTask needRetryDelay(boolean r1) {
        return this;
    }

    @Deprecated
    public DownloadTask needReuseChunkRunnable(boolean r1) {
        return this;
    }

    @Deprecated
    public DownloadTask needReuseFirstConnection(boolean r1) {
        return this;
    }

    public DownloadTask needSDKMonitor(boolean r2) {
        this.downloadInfoBuilder.n(r2);
        return this;
    }

    @Deprecated
    public DownloadTask newSaveTempFileEnable(boolean r1) {
        return this;
    }

    public DownloadTask notificationClickCallback(ah r3) {
        this.notificationClickCallback = (ah) ZeusTransformUtils.wrapperContextForParams(r3, ah.class, "com.obric.memorydata.plugin");
        return this;
    }

    public DownloadTask notificationEventListener(aa r3) {
        this.notificationEventListener = (aa) ZeusTransformUtils.wrapperContextForParams(r3, aa.class, "com.obric.memorydata.plugin");
        return this;
    }

    public DownloadTask notificationListener(IDownloadListener r3) {
        IDownloadListener r4 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadListener.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        return this;
    L6:
        return notificationListenerWithHashCode(r4.hashCode(), r4);
    }

    public DownloadTask notificationListenerWithHashCode(int r4, IDownloadListener r5) {
        IDownloadListener r6 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r5, IDownloadListener.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L19;
        Map<Integer, IDownloadListener> r0 = this.notificationListeners;
        monitor-enter(r0);
        this.notificationListeners.put(Integer.valueOf(r4), r6);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        this.singleListenerMap.put(ListenerType.NOTIFICATION, r6);
        Map<Integer, ListenerType> r7 = this.singleListenerHashCodeMap;
        monitor-enter(r7);
        this.singleListenerHashCodeMap.put(Integer.valueOf(r4), ListenerType.NOTIFICATION);     // Catch: Throwable -> L13
        monitor-exit(r7);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        throw th;
    L19:
        return this;
    }

    public DownloadTask onlyWifi(boolean r2) {
        this.downloadInfoBuilder.b(r2);
        return this;
    }

    public DownloadTask outIp(String[] r2) {
        this.downloadInfoBuilder.a(r2);
        return this;
    }

    public DownloadTask outSize(int[] r2) {
        this.downloadInfoBuilder.a(r2);
        return this;
    }

    public DownloadTask packageName(String r2) {
        this.downloadInfoBuilder.i(r2);
        return this;
    }

    public DownloadTask pcdnUrls(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.downloadInfoBuilder.a(r4);
        return this;
    }

    public void removeCallback(ListenerType r5, IDownloadListener r6) {
        IDownloadListener r7 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r6, IDownloadListener.class, "com.obric.memorydata.plugin");
        if (this.autoRemoveCallback == true) goto L5;
        return;
    L5:
        if (r5 != ListenerType.NONE) goto L8;
        return;
    L8:
        if (com.ss.android.socialbase.downloader.e.a.a(this.downloadInfo) == false) goto L11;
        com.ss.android.socialbase.downloader.e.a.a(TAG, this.downloadInfo, "removeCallback", "ListenerType:" + r5 + " listener:" + r7);
    L11:
        if (r7 != null) goto L13;
        int r1 = 0;
    L14:
        removeDownloadListener(r1, r7, r5, false);
        return;
    L13:
        r1 = r7.hashCode();
        goto L14
    }

    public void removeDownloadListener(int r3, IDownloadListener r4, ListenerType r5, boolean r6) {
        IDownloadListener r7 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.memorydata.plugin");
        Map<Integer, IDownloadListener> r0 = getDownloadListeners(r5);
        if (r0 != null) goto L9;
        if (r6 == true) goto L6;
        return;
    L6:
        if (this.singleListenerMap.containsKey(r5) == false) goto L44;
        this.singleListenerMap.remove(r5);
        return;
    L44:
        return;
    L9:
        monitor-enter(r0);
        if (r6 == true) goto L12;
        r0.remove(Integer.valueOf(r3));     // Catch: Throwable -> L34
        Map<Integer, ListenerType> r8 = this.singleListenerHashCodeMap;     // Catch: Throwable -> L34
        monitor-enter(r8);     // Catch: Throwable -> L34
        ListenerType r9 = (ListenerType) ZeusTransformUtils.preCheckCast(this.singleListenerHashCodeMap.get(Integer.valueOf(r3)), ListenerType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        if (r9 != null) goto L26;
    L28:
        monitor-exit(r8);     // Catch: Throwable -> L31
    L29:
        monitor-exit(r0);     // Catch: Throwable -> L34
        return;
    L26:
        if (this.singleListenerMap.containsKey(r9) == false) goto L28;
        this.singleListenerMap.remove(r9);     // Catch: Throwable -> L31
        this.singleListenerHashCodeMap.remove(Integer.valueOf(r3));     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L12:
        if (this.singleListenerMap.containsKey(r5) == false) goto L14;
        r7 = (IDownloadListener) ZeusTransformUtils.preCheckCast(this.singleListenerMap.get(r5), IDownloadListener.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        this.singleListenerMap.remove(r5);     // Catch: Throwable -> L34
    L14:
        if (r7 == null) goto L29;
        Iterator<Map.Entry<Integer, IDownloadListener>> r2 = r0.entrySet().iterator();     // Catch: Throwable -> L34
    L17:
        if (r2.hasNext() == false) goto L29;
        if (((Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue() != r7) goto L17;
        r2.remove();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    }

    public DownloadTask retryCount(int r2) {
        this.downloadInfoBuilder.b(r2);
        return this;
    }

    @Deprecated
    public DownloadTask retryDelayTimeArray(String r1) {
        return this;
    }

    @Deprecated
    public DownloadTask retryDelayTimeCalculator(com.ss.android.socialbase.downloader.downloader.r r3) {
        com.ss.android.socialbase.downloader.downloader.r r4 = (com.ss.android.socialbase.downloader.downloader.r) ZeusTransformUtils.wrapperContextForParams(r3, com.ss.android.socialbase.downloader.downloader.r.class, "com.obric.memorydata.plugin");
        return this;
    }

    public DownloadTask savePath(String r2) {
        this.downloadInfoBuilder.e(r2);
        return this;
    }

    public DownloadTask setAutoInstall(boolean r2) {
        this.downloadInfoBuilder.u(r2);
        return this;
    }

    public DownloadTask setCacheLifeTimeMax(long r2) {
        this.downloadInfoBuilder.f(r2);
        return this;
    }

    public DownloadTask setDownloadCompleteHandlers(List<l> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
    L10:
        return this;
    L5:
        if (r5.isEmpty() == true) goto L10;
        Iterator r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        addDownloadCompleteHandler((l) ZeusTransformUtils.preCheckCast(r6.next(), l.class, "com.obric.memorydata.plugin"));
        goto L8
    }

    public void setDownloadListeners(Map<Integer, IDownloadListener> r3, ListenerType r4) {
        Map<Integer, IDownloadListener> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L38;
        return;
    L38:
    L35:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (r4 != ListenerType.MAIN) goto L16;
        Map<Integer, IDownloadListener> r6 = this.mainThreadListeners;     // Catch: Throwable -> L35
        monitor-enter(r6);     // Catch: Throwable -> L35
        copyListeners(this.mainThreadListeners, r5);     // Catch: Throwable -> L12
        monitor-exit(r6);     // Catch: Throwable -> L12
    L45:
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L16:
        if (r4 != ListenerType.SUB) goto L26;
        Map<Integer, IDownloadListener> r7 = this.subThreadListeners;     // Catch: Throwable -> L35
        monitor-enter(r7);     // Catch: Throwable -> L35
        copyListeners(this.subThreadListeners, r5);     // Catch: Throwable -> L22
        monitor-exit(r7);     // Catch: Throwable -> L22
    L46:
        return;
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L26:
        if (r4 != ListenerType.NOTIFICATION) goto L47;
        Map<Integer, IDownloadListener> r8 = this.notificationListeners;     // Catch: Throwable -> L35
        monitor-enter(r8);     // Catch: Throwable -> L35
        copyListeners(this.notificationListeners, r5);     // Catch: Throwable -> L32
        monitor-exit(r8);     // Catch: Throwable -> L32
    L48:
        return;
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    }

    public void setNeedDelayForCacheSync(boolean r1) {
        this.needDelayForCacheSync = r1;
    }

    public void setNotificationEventListener(aa r3) {
        this.notificationEventListener = (aa) ZeusTransformUtils.wrapperContextForParams(r3, aa.class, "com.obric.memorydata.plugin");
    }

    public DownloadTask setTaskPriority(int r1) {
        this.mPriority = r1;
        return this;
    }

    public DownloadTask showNotification(boolean r2) {
        this.downloadInfoBuilder.f(r2);
        return this;
    }

    public DownloadTask showNotificationForAutoResumed(boolean r2) {
        this.downloadInfoBuilder.h(r2);
        return this;
    }

    public DownloadTask startOffset(long r2) {
        this.downloadInfoBuilder.c(r2);
        return this;
    }

    public DownloadTask subThreadListener(IDownloadListener r3) {
        IDownloadListener r4 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadListener.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        return this;
    L6:
        return subThreadListenerWithHashCode(r4.hashCode(), r4);
    }

    public DownloadTask subThreadListenerWithHashCode(int r4, IDownloadListener r5) {
        IDownloadListener r6 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r5, IDownloadListener.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L19;
        Map<Integer, IDownloadListener> r0 = this.subThreadListeners;
        monitor-enter(r0);
        this.subThreadListeners.put(Integer.valueOf(r4), r6);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        this.singleListenerMap.put(ListenerType.SUB, r6);
        Map<Integer, ListenerType> r7 = this.singleListenerHashCodeMap;
        monitor-enter(r7);
        this.singleListenerHashCodeMap.put(Integer.valueOf(r4), ListenerType.SUB);     // Catch: Throwable -> L13
        monitor-exit(r7);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        throw th;
    L19:
        return this;
    }

    public DownloadTask taskKey(String r2) {
        this.downloadInfoBuilder.a(r2);
        return this;
    }

    public DownloadTask tempPath(String r2) {
        this.downloadInfoBuilder.f(r2);
        return this;
    }

    public DownloadTask throttleNetSpeed(long r2) {
        this.downloadInfoBuilder.b(r2);
        return this;
    }

    public DownloadTask throttleSmoothness(int r2) {
        this.downloadInfoBuilder.g(r2);
        return this;
    }

    public DownloadTask title(String r2) {
        this.downloadInfoBuilder.c(r2);
        return this;
    }

    public DownloadTask ttnetProtectTimeout(long r2) {
        this.downloadInfoBuilder.e(r2);
        return this;
    }

    public DownloadTask url(String r2) {
        this.downloadInfoBuilder.d(r2);
        return this;
    }
}
