package com.bytedance.crash.event;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.config.NpthBuildConfig;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.monitor.EventMonitor;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploaderUrl;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class EventDeliverer {
    private static final int MAX_VALUE = 100;
    private static AtomicInteger cacheCount;
    private static ConcurrentHashMap<EventMonitor, ConcurrentLinkedQueue<EventReportData>> caches;
    private static volatile boolean isWorking;
    private static ConcurrentHashMap<EventMonitor, ConcurrentLinkedQueue<EventReportData>> queues;
    private static CopyOnWriteArrayList<EventDeliverer> sEventList;
    private static AtomicInteger totalCount;
    private ConcurrentLinkedQueue<EventReportData> cache;
    private EventConfig config;
    private ConcurrentLinkedQueue<EventReportData> queue;

    private static class UploadManager implements Runnable {
        private static UploadManager manager;
        private volatile boolean isStarted;

        static {
            manager = new UploadManager();
        }

        private UploadManager() {
        }

        static /* synthetic */ void access$000(UploadManager r0) {
            r0.start();
        }

        public static UploadManager getInstance() {
            return manager;
        }

        private void start() {
            if (this.isStarted == false) goto L5;
            return;
        L5:
            this.isStarted = true;
            EventDeliverer.access$102(true);
            DefaultWorkThread.removeCallbacks(this);
            DefaultWorkThread.postDelayed(this, 30000);
        }

        private void uploadEvent() {
            JSONArray r1 = new JSONArray();     // Catch: Throwable -> L28
            int r2 = Process.myPid();     // Catch: Throwable -> L28
            long r3 = System.currentTimeMillis();     // Catch: Throwable -> L28
            Iterator r5 = EventDeliverer.access$400().keySet().iterator();     // Catch: Throwable -> L28
            int r6 = 0;
            boolean r8 = false;
            String r9 = "0";
        L7:
            if (r5.hasNext() == false) goto L25;
            EventMonitor r10 = (EventMonitor) ZeusTransformUtils.preCheckCast(r5.next(), EventMonitor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
            ConcurrentLinkedQueue r13 = (ConcurrentLinkedQueue) ZeusTransformUtils.preCheckCast(EventDeliverer.access$400().get(r10), ConcurrentLinkedQueue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
            if (r13 == null) goto L7;
            JSONArray r14 = new JSONArray();     // Catch: Throwable -> L28
        L13:
            if (r13.isEmpty() == true) goto L18;
            Iterator r16 = r5;
            r14.put(((EventReportData) ZeusTransformUtils.preCheckCast(r13.poll(), EventReportData.class, "com.obric.memorydata.plugin")).toJsonObject());     // Catch: Throwable -> L28
            EventDeliverer.access$200().decrementAndGet();     // Catch: Throwable -> L28
            r6 = r6 + 1;     // Catch: Throwable -> L28
            if (r6 > 100) goto L16;
            r5 = r16;
            goto L13
        L16:
            r8 = true;
        L20:
            if (r14.length() != 0) goto L22;
        L21:
            r5 = r16;
            goto L7
        L22:
            JSONObject r7 = new JSONObject();     // Catch: Throwable -> L28
            r9 = r10.getDeviceId("0");     // Catch: Throwable -> L28
            r7.put("data", r14);     // Catch: Throwable -> L28
            JSONObject r11 = Header.createEventHeader(r10, r3, CrashType.ENSURE, r2).getJson();     // Catch: Throwable -> L28
            r11.put("from", "npth");     // Catch: Throwable -> L28
            r7.put("header", r11);     // Catch: Throwable -> L28
            r1.put(r7);     // Catch: Throwable -> L28
            if (r8 == false) goto L21;
        L18:
            r16 = r5;
        L25:
            if (JSONUtils.isEmpty(r1) == true) goto L42;
            String r0 = NetConfig.getEventUploadUrl();     // Catch: Throwable -> L28
            HashMap r4 = new HashMap();     // Catch: Throwable -> L28
            r4.put("device_id", r9);     // Catch: Throwable -> L28
            r4.put("os", LocationInfoConst.SYSTEM);     // Catch: Throwable -> L28
            r4.put("sdk_version", NpthBuildConfig.VERSION_NAME);     // Catch: Throwable -> L28
            r4.put("from", "npth");     // Catch: Throwable -> L28
            String r12 = UploaderUrl.appendParamsToURL(r0, r4);     // Catch: Throwable -> L28
            JSONObject r15 = new JSONObject();     // Catch: Throwable -> L28
            r15.put(Constants.KEY_LIST, r1);     // Catch: Throwable -> L28
            CrashUploader.uploadEvent(r12, r15);     // Catch: Throwable -> L28
            return;
        L42:
            return;
        L28:
            th = move-exception;
            NpthLog.w(th);
        }

        @Override // java.lang.Runnable
        public void run() {
            uploadEvent();
            if (EventDeliverer.access$200().get() <= 0) goto L5;
        L8:
            DefaultWorkThread.postDelayed(this, 30000);
            boolean r2 = true;
        L9:
            EventDeliverer.access$102(r2);
            return;
        L5:
            if (EventDeliverer.access$300().get() > 0) goto L8;
            r2 = false;
            goto L9
        }

        public void work() {
            start();
            if (EventDeliverer.access$100() == true) goto L6;
            DefaultWorkThread.removeCallbacks(this);
            DefaultWorkThread.postDelayed(this, 30000);
            EventDeliverer.access$102(true);
            return;
        }
    }

    static {
        queues = new ConcurrentHashMap();
        caches = new ConcurrentHashMap();
        sEventList = new CopyOnWriteArrayList();
        totalCount = new AtomicInteger(0);
        cacheCount = new AtomicInteger(0);
        isWorking = false;
    }

    public EventDeliverer(EventMonitor r3) {
        ConcurrentLinkedQueue<EventReportData> r0 = new ConcurrentLinkedQueue();
        this.queue = r0;
        queues.put(r3, r0);
        this.cache = new ConcurrentLinkedQueue();
        caches.put(r3, this.queue);
        sEventList.add(this);
        UploadManager.access$000(UploadManager.getInstance());
    }

    static /* synthetic */ boolean access$100() {
        return isWorking;
    }

    static /* synthetic */ boolean access$102(boolean r0) {
        isWorking = r0;
        return r0;
    }

    static /* synthetic */ AtomicInteger access$200() {
        return totalCount;
    }

    static /* synthetic */ AtomicInteger access$300() {
        return cacheCount;
    }

    static /* synthetic */ ConcurrentHashMap access$400() {
        return queues;
    }

    public static void clean() {
        sEventList.clear();     // Catch: Throwable -> L8
        caches.clear();     // Catch: Throwable -> L8
        Iterator<EventDeliverer> r0 = sEventList.iterator();     // Catch: Throwable -> L8
    L4:
        if (r0.hasNext() == false) goto L13;
        EventDeliverer r1 = (EventDeliverer) ZeusTransformUtils.preCheckCast(r0.next(), EventDeliverer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        r1.queue.clear();     // Catch: Throwable -> L8
        r1.cache.clear();     // Catch: Throwable -> L8
    L13:
        return;
    }

    private void work() {
        if (isWorking == true) goto L6;
        UploadManager.access$000(UploadManager.getInstance());
        return;
    }

    public void reportEvent(String r10, int r11, JSONObject r12, JSONObject r13) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return;
    L6:
        if (this.config == null) goto L8;
    L10:
        EventConfig r0 = this.config;
        if (r0 != null) goto L13;
    L15:
        EventReportData r1 = new EventReportData(Thread.currentThread().getName(), System.currentTimeMillis(), r10, r11, r12, r13);
        if (this.config != null) goto L18;
        this.cache.add(r1);
        AtomicInteger r14 = cacheCount;
    L19:
        r14.addAndGet(1);
        work();
        return;
    L18:
        this.queue.add(r1);
        r14 = totalCount;
        goto L19
    L13:
        if (r0.isSampled(r10) == true) goto L15;
        return;
    L8:
        if (cacheCount.get() <= 100) goto L10;
    }

    public void updateConfig(EventConfig r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.cache.isEmpty() == true) goto L9;
        EventReportData r0 = (EventReportData) ZeusTransformUtils.preCheckCast(this.cache.poll(), EventReportData.class, "com.obric.memorydata.plugin");
        cacheCount.decrementAndGet();
        if (r4.isSampled(r0.getServiceName()) == false) goto L5;
        this.queue.add(r0);
        totalCount.addAndGet(1);
        goto L5
    L9:
        work();
        this.config = r4;
    }
}
