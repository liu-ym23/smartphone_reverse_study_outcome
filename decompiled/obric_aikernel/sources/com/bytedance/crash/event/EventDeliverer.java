package com.bytedance.crash.event;

import android.os.Process;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.util.constant.NetConst;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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

        static /* synthetic */ void access$000(UploadManager r10) {
            r10.start();
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
            DefaultWorkThread.postDelayed(this, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
        }

        private void uploadEvent() {
            JSONArray r14 = new JSONArray();     // Catch: Throwable -> L25
            int r10 = Process.myPid();     // Catch: Throwable -> L25
            long r11 = System.currentTimeMillis();     // Catch: Throwable -> L25
            Iterator r12 = EventDeliverer.access$400().keySet().iterator();     // Catch: Throwable -> L25
            int r13 = 0;
            boolean r15 = false;
            String r16 = NetConst.NOT_ENCRYPT_VERISON_CODE;
        L6:
            if (r12.hasNext() == false) goto L22;
            EventMonitor r17 = (EventMonitor) r12.next();     // Catch: Throwable -> L25
            ConcurrentLinkedQueue r18 = (ConcurrentLinkedQueue) EventDeliverer.access$400().get(r17);     // Catch: Throwable -> L25
            if (r18 == null) goto L6;
            JSONArray r19 = new JSONArray();     // Catch: Throwable -> L25
        L12:
            if (r18.isEmpty() == true) goto L17;
            r19.put(((EventReportData) r18.poll()).toJsonObject());     // Catch: Throwable -> L25
            EventDeliverer.access$200().decrementAndGet();     // Catch: Throwable -> L25
            r13 = r13 + 1;     // Catch: Throwable -> L25
            if (r13 <= 100) goto L12;
            r15 = true;
        L17:
            if (r19.length() == 0) goto L6;
            JSONObject r20 = new JSONObject();     // Catch: Throwable -> L25
            String r110 = r17.getDeviceId(NetConst.NOT_ENCRYPT_VERISON_CODE);     // Catch: Throwable -> L25
            r20.put("data", r19);     // Catch: Throwable -> L25
            JSONObject r21 = Header.createEventHeader(r17, r11, CrashType.ENSURE, r10).getJson();     // Catch: Throwable -> L25
            r21.put("from", "npth");     // Catch: Throwable -> L25
            r20.put("header", r21);     // Catch: Throwable -> L25
            r14.put(r20);     // Catch: Throwable -> L25
            r16 = r110;
            if (r15 == false) goto L6;
        L22:
            if (JSONUtils.isEmpty(r14) == true) goto L43;
            String r22 = NetConfig.getEventUploadUrl();     // Catch: Throwable -> L25
            HashMap r23 = new HashMap();     // Catch: Throwable -> L25
            r23.put("device_id", r16);     // Catch: Throwable -> L25
            r23.put("os", "Android");     // Catch: Throwable -> L25
            r23.put("sdk_version", NpthBuildConfig.VERSION_NAME);     // Catch: Throwable -> L25
            r23.put("from", "npth");     // Catch: Throwable -> L25
            String r24 = UploaderUrl.appendParamsToURL(r22, r23);     // Catch: Throwable -> L25
            JSONObject r25 = new JSONObject();     // Catch: Throwable -> L25
            r25.put(Constants.KEY_LIST, r14);     // Catch: Throwable -> L25
            CrashUploader.uploadEvent(r24, r25);     // Catch: Throwable -> L25
            return;
        L43:
            return;
        L25:
            th = move-exception;
            NpthLog.w(th);
        }

        @Override // java.lang.Runnable
        public void run() {
            uploadEvent();
            if (EventDeliverer.access$200().get() <= 0) goto L5;
        L8:
            DefaultWorkThread.postDelayed(this, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
            boolean r10 = true;
        L9:
            EventDeliverer.access$102(r10);
            return;
        L5:
            if (EventDeliverer.access$300().get() > 0) goto L8;
            r10 = false;
            goto L9
        }

        public void work() {
            start();
            if (EventDeliverer.access$100() == true) goto L6;
            DefaultWorkThread.removeCallbacks(this);
            DefaultWorkThread.postDelayed(this, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
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

    public EventDeliverer(EventMonitor r10) {
        ConcurrentLinkedQueue<EventReportData> r11 = new ConcurrentLinkedQueue();
        this.queue = r11;
        queues.put(r10, r11);
        this.cache = new ConcurrentLinkedQueue();
        caches.put(r10, this.queue);
        sEventList.add(this);
        UploadManager.access$000(UploadManager.getInstance());
    }

    static /* synthetic */ boolean access$100() {
        return isWorking;
    }

    static /* synthetic */ boolean access$102(boolean r10) {
        isWorking = r10;
        return r10;
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
        Iterator<EventDeliverer> r10 = sEventList.iterator();     // Catch: Throwable -> L8
    L4:
        if (r10.hasNext() == false) goto L13;
        EventDeliverer r11 = r10.next();     // Catch: Throwable -> L8
        r11.queue.clear();     // Catch: Throwable -> L8
        r11.cache.clear();     // Catch: Throwable -> L8
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
        EventConfig r14 = this.config;
        if (r14 != null) goto L13;
    L15:
        EventReportData r15 = new EventReportData(Thread.currentThread().getName(), System.currentTimeMillis(), r10, r11, r12, r13);
        if (this.config != null) goto L18;
        this.cache.add(r15);
        AtomicInteger r16 = cacheCount;
    L19:
        r16.addAndGet(1);
        work();
        return;
    L18:
        this.queue.add(r15);
        r16 = totalCount;
        goto L19
    L13:
        if (r14.isSampled(r10) == true) goto L15;
        return;
    L8:
        if (cacheCount.get() <= 100) goto L10;
    }

    public void updateConfig(EventConfig r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.cache.isEmpty() == true) goto L9;
        EventReportData r11 = this.cache.poll();
        cacheCount.decrementAndGet();
        if (r10.isSampled(r11.getServiceName()) == false) goto L5;
        this.queue.add(r11);
        totalCount.addAndGet(1);
        goto L5
    L9:
        work();
        this.config = r10;
    }
}
