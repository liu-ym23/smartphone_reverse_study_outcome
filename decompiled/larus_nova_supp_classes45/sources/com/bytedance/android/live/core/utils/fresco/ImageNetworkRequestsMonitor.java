package com.bytedance.android.live.core.utils.fresco;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import androidx.collection.ArrayMap;
import com.bytedance.android.live.base.BaseServices;
import com.bytedance.android.live.base.service.IUserId;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.Logger;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import j40.m0;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class ImageNetworkRequestsMonitor extends BaseRequestListener {
    public static final String KEY_IMAGE_LOAD = "load_time";
    private static final String NETWORK_FETCH_PRODUCER = "NetworkFetchProducer";
    private static final Cert NETWORK_TOKEN = null;
    public static final String SERVICE_IMAGE_LOAD = "hotsoon_image_load";
    public static final String SERVICE_IMAGE_LOAD_ERROR_RATE = "hotsoon_image_load_error_rate";
    public static final String SERVICE_LOG_IMAGE_ERROR = "image_error";
    public static final int STATUS_ERROR = 1;
    public static final int STATUS_SUCCESS = 0;
    public static final String TYPE_LOG_IMAGE_LOAD = "hotsoon_image_load_log";
    public static final String TYPE_LOG_IMAGE_LOAD_DURATION = "hotsoon_image_load_duration";
    private static ExecutorService sExecutor;
    private int requestCount;
    private long startLoadTime;
    private final Map<String, List<String>> sucProducers;

    public static /* synthetic */ void a(Throwable r0, ImageRequest r1, wm0.b r2) {
        lambda$onRequestFailure$0(r0, r1, r2);
    }

    public static /* synthetic */ Thread b(Runnable r0) {
        return lambda$ensureExecutor$2(r0);
    }

    public static /* synthetic */ void c(Uri r0, wm0.b r1, long r2) {
        lambda$onRequestSuccess$1(r0, r1, r2);
    }

    static {
        NETWORK_TOKEN = TokenCert.with("bpea-live_imagenetworkrequestmonitor_get_network_type");
        sExecutor = null;
    }

    private void ensureExecutor() {
        if (sExecutor == null) goto L5;
        return;
    L5:
        monitor-enter(ImageNetworkRequestsMonitor.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sExecutor != null) goto L9;
        sExecutor = PThreadExecutorsUtils.newFixedThreadPool(1, new k());     // Catch: Throwable -> L11
    L9:
        monitor-exit(ImageNetworkRequestsMonitor.class);     // Catch: Throwable -> L11
    }

    public ImageNetworkRequestsMonitor() {
        this.sucProducers = new ArrayMap();
        this.startLoadTime = -1;
    }

    private static /* synthetic */ Thread lambda$ensureExecutor$2(Runnable r2) {
        return new PthreadThreadV2(r2, "image-net-requests-monitor");
    }

    public void monitor(ImageRequestBuilder r2) {
        this.requestCount++;
        r2.setRequestListener(this);
    }

    public void onRequestCancellation(String r2) {
        super.onRequestCancellation(r2);
        this.sucProducers.remove(r2);
    }

    private static void lambda$onRequestFailure$0(Throwable r8, ImageRequest r9, wm0.b r11) {
        Context r2 = s1.getContext();
        if (NetworkUtils.f(r2) == true) goto L5;
        return;
    L5:
        JSONObject r3 = new JSONObject();
        r3.put("errorDesc", r8.toString());     // Catch: Exception -> L11
        r3.put(LiveSlardarConstants.EXTRA_KEY_URL, r9.getSourceUri());     // Catch: Exception -> L11
        IUserId r4 = (IUserId) BaseServices.as(IUserId.class);     // Catch: Exception -> L11
        if (r4 == null) goto L9;
        r3.put("userId", r4.get());     // Catch: Exception -> L11
    L9:
        r3.put("networkType", NetworkUtils.a(r2, NETWORK_TOKEN));     // Catch: Exception -> L11
        r11.monitorCommonLog("hotsoon_image_load_log", "image_error", r3);     // Catch: Exception -> L11
    L13:
        r11.monitorStatusRate(SERVICE_IMAGE_LOAD_ERROR_RATE, 1, r3);
        String r12 = r9.getSourceUri().toString();
        String r13 = r8.toString();
        boolean r14 = !m0.a.getValue().mEnable;
        HashMap r5 = new HashMap();
        r5.put(LiveSlardarConstants.EXTRA_KEY_URL, r12);
        r5.put(LiveSlardarConstants.EXTRA_KEY_ERROR_MSG, r13);
        r5.put("load_duration", -1);
        r5.put("cache_key_with_host", Boolean.valueOf(r14));
        wm0.b r15 = om0.c.j();
        if (r15 == null) goto L34;
        JSONObject r1 = new JSONObject();
        r1.put("duration", 0);     // Catch: JSONException -> L19
    L21:
        r15.monitorStatusAndDuration("ttlive_image_load_status_all", 1, r1, new JSONObject(r5));
        JSONObject r6 = new JSONObject();
        r6.put("duration", 0);     // Catch: JSONException -> L24
    L26:
        r15.monitorStatusAndDuration("ttlive_image_load_status_error", 1, r6, new JSONObject(r5));
        ALogger.e("LiveImageMonitor", "ImageLoadFail, url=" + r12 + ", msg=" + r13);
        return;
    L24:
        e = move-exception;
        e.printStackTrace();
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L21
    L34:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    private static void lambda$onRequestSuccess$1(Uri r6, wm0.b r7, long r8) {
        JSONObject r1 = new JSONObject();
        r1.put(LiveSlardarConstants.EXTRA_KEY_URL, r6);     // Catch: JSONException -> L5
    L6:
        r7.monitorStatusRate(SERVICE_IMAGE_LOAD_ERROR_RATE, 0, r1);
        if (r8 <= 0) goto L15;
        JSONObject r2 = new JSONObject();
        r2.put("duration", r8);     // Catch: JSONException -> L11
        r2.put(LiveSlardarConstants.EXTRA_KEY_URL, r6);     // Catch: JSONException -> L11
    L12:
        r7.monitorCommonLog("hotsoon_image_load_duration", SERVICE_IMAGE_LOAD, r2);
        r7.monitorDirectOnTimer(SERVICE_IMAGE_LOAD, KEY_IMAGE_LOAD, r8);
        if (Logger.debug() == false) goto L15;
        Logger.d("image_monitor", "no cache = " + r6 + " duration = " + r8);
    L15:
        String r9 = r6.toString();
        boolean r11 = !m0.a.getValue().mEnable;
        HashMap r3 = new HashMap();
        r3.put(LiveSlardarConstants.EXTRA_KEY_URL, r9);
        r3.put("load_duration", Long.valueOf(r8));
        r3.put("cache_key_with_host", Boolean.valueOf(r11));
        ALogger.i("LiveImageMonitor", "ImageLoadSuccess, url=" + r9);
        wm0.b r12 = om0.c.j();
        if (r12 == null) goto L31;
        JSONObject r13 = new JSONObject();
        r13.put("duration", r8);     // Catch: JSONException -> L21
    L23:
        r12.monitorStatusAndDuration("ttlive_image_load_status_all", 0, r13, new JSONObject(r3));
        return;
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    }

    public void onProducerFinishWithSuccess(String r1, String r2, Map<String, String> r3) {
        super.onProducerFinishWithSuccess(r1, r2, r3);
        List<String> r4 = this.sucProducers.get(r1);
        if (r4 == null) goto L6;
        r4.add(r2);
        return;
    }

    public void onRequestSuccess(ImageRequest r6, String r7, boolean r8) {
        super.onRequestSuccess(r6, r7, r8);
        List<String> r9 = this.sucProducers.remove(r7);
        if (r9 != null) goto L5;
        return;
    L5:
        if (r9.contains(NETWORK_FETCH_PRODUCER) == false) goto L15;
        final Uri r11 = r6.getSourceUri();
        final long r2 = -1;
        if (this.startLoadTime <= 0) goto L9;
        long r12 = SystemClock.elapsedRealtime() - this.startLoadTime;
        this.startLoadTime = -1;
        r2 = r12;
    L9:
        ensureExecutor();
        final wm0.b r13 = om0.c.j();
        if (r13 != null) goto L12;
        return;
    L12:
        sExecutor.submit(new j(r11, r13, r2));
        return;
    }

    public void onRequestFailure(final ImageRequest r2, String r3, final Throwable r4, boolean r5) {
        super.onRequestFailure(r2, r3, r4, r5);
        this.sucProducers.remove(r3);
        int r6 = this.requestCount - 1;
        this.requestCount = r6;
        if (r6 != 0) goto L9;
        ensureExecutor();
        final wm0.b r7 = om0.c.j();
        if (r7 != null) goto L7;
        return;
    L7:
        sExecutor.submit(new i(r4, r2, r7));
        return;
    }

    public void onRequestStart(ImageRequest r2, Object r3, String r4, boolean r5) {
        super.onRequestStart(r2, r3, r4, r5);
        this.sucProducers.put(r4, new LinkedList());
        if (this.startLoadTime != (-1)) goto L6;
        this.startLoadTime = SystemClock.elapsedRealtime();
        return;
    }
}
