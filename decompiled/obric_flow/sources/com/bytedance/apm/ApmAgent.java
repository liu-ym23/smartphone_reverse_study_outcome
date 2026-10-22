package com.bytedance.apm;

import android.content.Context;
import android.os.BatteryManager;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.pia.core.bridge.methods.r;
import com.bytedance.salamander.anniex.b0;
import com.lynx.tasm.p;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.MappedByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.internal.ws.RealWebSocket;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ApmAgent {
    private static final long CHECK_DISK_INTERVAL_MS = 3600000;
    private static final long CHILD_PROC_MAP_FILE_SIZE = 262144;
    public static boolean FAST_MODE = false;
    private static final String KEY_DEBUG_UUID = "_debug_uuid";
    private static final String KEY_SELF_DEBUG_MESSAGE = "_debug_self";
    private static final long MAIN_PROC_MAP_FILE_SIZE = 2097152;
    private static final long MAX_LOGS_SIZE = 1073741824;
    public static final String MSG_TIP_NOTHING_TO_DO_PLEASE_NOT_USE = "nothing to do, implementation code has been removed in version 5+";
    private static final long REMAINING_ROM_THRESHOLD = 1073741824;
    public static final String TAG_DEPRECATED = "Deprecated";
    private static final int WEED_OUT_FILE_NUM = 60;
    static AtomicLong atomicLong = null;
    public static boolean sDeepCopy = false;
    private static long sLastCheckDiskTime = -1;
    private static MappedByteBuffer sMappedByteBuffer;
    private static File sProcessLogsFolder;

    static {
        atomicLong = new AtomicLong(0);
    }

    public ApmAgent() {
    }

    public static /* synthetic */ JSONObject access$000(JSONObject r5, boolean r10) {
        return optDeepCopyJson(r5, r10);
    }

    public static void activeUploadAlog(String r10, long r11, long r12, String r13, v5.b r14, v5.a r15) {
        if (com.bytedance.apm.internal.b.f3886a.f3882b == false) goto L5;
        z6.b.f23409a.e(new com.bytedance.apm.internal.a(r11, r10, r12, r13));
        return;
    L5:
        if (r15 == null) goto L9;
        com.bytedance.ies.bullet.base.utils.b.o(false, 9, null, null);
        r15.a();
        return;
    }

    public static void addBatteryDataListener(i r5) {
        w5.f r10 = w5.e.f22734a;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r10.g != null) goto L8;
        r10.g = new ArrayList();
    L8:
        r10.g.add(r5);
    }

    @Deprecated
    public static void addBlockFilter(@NonNull Map<String, String> r5) {
    }

    private static void addDebugMessage(JSONObject r10) {
        if (r10 != null) goto L7;
        return;
    L7:
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L6
        r5.put(KEY_DEBUG_UUID, j.b() + "_" + atomicLong.getAndAdd(1));     // Catch: Exception -> L6
        r10.put(KEY_SELF_DEBUG_MESSAGE, r5);     // Catch: Exception -> L6
        return;
    }

    @Deprecated
    public static void addFpsFilter(@NonNull Map<String, String> r5) {
    }

    public static void addPerfTag(@NonNull String r5, @NonNull String r10) {
        ((ConcurrentHashMap) s6.c.w().f21829c).put(r5, r10);
        ((ConcurrentHashMap) q7.a.k().f21489c).put(r5, r10);
    }

    public static void configSceneMinDuration(HashMap<String, Long> r5) {
        w5.g.f22735a.f22738j.putAll(r5);
    }

    public static void feedbackReport(long r10, long r11, boolean r12) {
        z6.b.f23409a.d(new h(r10, r11, r12));
    }

    private static JSONObject getCapacity() {
        JSONObject r5 = new JSONObject();
        boolean r10 = j.f3887a;     // Catch: JSONException -> L7
        BatteryManager r11 = kt.a.f19479a;     // Catch: JSONException -> L7
        r5.put("battery_percent", -1);     // Catch: JSONException -> L7
        JSONObject r12 = a6.b.f112a.f();     // Catch: JSONException -> L7
        if (r12.length() != 0) goto L9;
        r5.put("more", "no-more-info");     // Catch: JSONException -> L7
    L13:
    L12:
        return r5;
    L9:
        r5.put("more", r12);     // Catch: JSONException -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    private static JSONObject getExtraLog(JSONObject r5) {
        if (r5 != null) goto L5;
        r5 = new JSONObject();
    L5:
        if (r5.isNull("timestamp") == true) goto L11;
    L10:
        return r5;
    L11:
        r5.put("timestamp", System.currentTimeMillis());     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    private static JSONObject getGalvanicNow() {
        JSONObject r5 = new JSONObject();
        boolean r10 = j.f3887a;     // Catch: JSONException -> L5
        r5.put("battery_current", kt.a.a(null));     // Catch: JSONException -> L5
        r5.put("scene", ActivityLifeObserver.getInstance().getTopActivityClassName());     // Catch: JSONException -> L5
    L7:
        return r5;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static boolean getLogTypeSwitch(String r5) {
        ApmDelegate r10 = com.bytedance.apm.internal.b.f3886a;
        return false;
    }

    private static JSONObject getMemInfo(t6.b r5) throws JSONException {
        JSONObject r10 = new JSONObject();
        r10.put("javaTotalMemory", r5.f22104a);
        r10.put("javaFreeMemory", r5.f22105b);
        r10.put("javaUsedMemory", r5.f22106c);
        r10.put("pssDalvik", 0);
        r10.put("pssNative", 0);
        r10.put("pssTotal", 0);
        r10.put("graphics", 0);
        r10.put("vmSize", r5.d);
        return r10;
    }

    @Deprecated
    public static boolean getMetricsSwitch(String r5) {
        ApmDelegate r10 = com.bytedance.apm.internal.b.f3886a;
        return false;
    }

    public static boolean getServiceSwitch(String r5) {
        ApmDelegate r10 = com.bytedance.apm.internal.b.f3886a;
        return false;
    }

    public static boolean isConfigReady() {
        return com.bytedance.apm.internal.b.f3886a.f3881a;
    }

    public static void monitorApiError(long r13, long r15, String r17, String r18, String r19, int r20, JSONObject r21) {
        JSONObject r10 = optShallowCopyJson(r21);
        z6.b.f23409a.d(new c(r13, r15, r17, r18, r19, r20, r10, 1));
        boolean r5 = j.f3887a;
    }

    public static void monitorCommonLog(String r5, JSONObject r10) {
        monitorCommonLog(r5, r10, false);
    }

    @Deprecated
    public static void monitorDirectOnTimer(String r5, String r10, float r11) {
        z6.b.f23409a.d(new g(r5, r10, r11));
        boolean r12 = j.f3887a;
    }

    @Deprecated
    public static void monitorDuration(String r10, JSONObject r11, JSONObject r12) {
        b0 r5 = h7.a.f17285a;
        JSONObject r13 = preProcessExtJson2(r12);
        addDebugMessage(r13);
        if (sDeepCopy == false) goto L15;
        JSONObject r14 = null;
        if (r11 != null) goto L7;
    L6:
        r11 = r14;
        goto L15
    L7:
        Iterator<String> r15 = r11.keys();
        if (r15 == null) goto L6;
        r14 = new JSONObject();     // Catch: Exception -> L17
    L12:
        if (r15.hasNext() == false) goto L6;
        String r16 = r15.next();     // Catch: Exception -> L17
        r14.put(r16, r11.opt(r16));     // Catch: Exception -> L17
    L15:
        h7.a.b(new j7.a(r10, 0, r11, null, null, r13));
        boolean r17 = j.f3887a;
    }

    public static void monitorEvent(String r10, JSONObject r11, JSONObject r12, JSONObject r13) {
        b0 r5 = h7.a.f17285a;
        JSONObject r14 = preProcessExtJson2(r13);
        addDebugMessage(r14);
        h7.a.b(new j7.a(r10, 0, null, optDeepCopyJson(r11, true), optDeepCopyJson(r12, true), r14));
        boolean r15 = j.f3887a;
    }

    public static void monitorExceptionLog(String r5, JSONObject r10) {
        JSONObject r11 = preProcessExtJson2(r10);
        z6.b.f23409a.d(new ab.b(4, r5, r11));
        boolean r12 = j.f3887a;
    }

    @Deprecated
    public static void monitorImageSample(String r5, int r10, String r11, long r12, JSONObject r13) {
    }

    public static void monitorPageLoad(JSONObject r5, JSONObject r10) {
        monitorPerformance("page_load", "page_load", r5, r10, null);     // Catch: Exception -> L5
        return;
    }

    public static void monitorPerformance(String r5, JSONObject r10, JSONObject r11, JSONObject r12) {
        monitorPerformance(r5, "", r10, r11, r12);
    }

    public static void monitorSLA(long r13, long r15, String r17, String r18, String r19, int r20, JSONObject r21) {
        JSONObject r10 = optShallowCopyJson(r21);
        z6.b.f23409a.d(new c(r13, r15, r17, r18, r19, r20, r10, 0));
        boolean r5 = j.f3887a;
    }

    @Deprecated
    public static void monitorStatusAndDuration(String r10, int r11, JSONObject r12, JSONObject r13) {
        b0 r5 = h7.a.f17285a;
        JSONObject r14 = optShallowCopyJson(r13);
        addDebugMessage(r14);
        h7.a.b(new j7.a(r10, r11, optDeepCopyJson(r12, true), null, null, optDeepCopyJson(r14, false)));
        boolean r15 = j.f3887a;
    }

    public static void monitorStatusAndEvent(String r10, int r11, JSONObject r12, JSONObject r13, JSONObject r14) {
        b0 r5 = h7.a.f17285a;
        JSONObject r15 = optShallowCopyJson(r14);
        addDebugMessage(r15);
        z6.b.f23409a.d(new b(r10, r11, r12, r13, r15));
        boolean r16 = j.f3887a;
    }

    public static void monitorStatusRate(String r10, int r11, JSONObject r12) {
        b0 r5 = h7.a.f17285a;
        JSONObject r13 = preProcessExtJson2(r12);
        addDebugMessage(r13);
        h7.a.b(new j7.a(r10, r11, null, null, null, r13));
        boolean r14 = j.f3887a;
    }

    public static void monitorUIAction(String r5, String r10, JSONObject r11) {
        monitorUIAction(r5, r10, r11, null);
    }

    private static void notifyNotSampled(String r5, JSONObject r10) {
        if (j.f3887a == false) goto L8;
        if (r10 != null) goto L6;
        r10 = new JSONObject();
    L6:
        l6.a.a(r5, r10);
        return;
    }

    private static JSONObject optDeepCopyJson(JSONObject r5, boolean r10) {
        if (FAST_MODE == true) goto L8;
        if (r5 != null) goto L12;
        return null;
    L12:
        return new JSONObject(r5.toString());
    L17:
        return r5;
    L8:
        if (r10 == true) goto L10;
        return r5;
    L10:
        return ug.a.k(r5);
    }

    private static JSONObject optShallowCopyJson(JSONObject r5) {
        if (FAST_MODE == false) goto L6;
        return ug.a.k(r5);
    L6:
        return preProcessExtJson2(r5);
    }

    private static JSONObject preProcessExtJson(JSONObject r5) {
        JSONObject r10 = null;
        if (r5 != null) goto L19;
    L12:
        if (r10 != null) goto L15;
        r10 = new JSONObject();     // Catch: Exception -> L18
    L15:
        if (r10.isNull("timestamp") == false) goto L17;
        r10.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L18
    L18:
        return r5;
    L17:
        return r10;
    L19:
        Iterator<String> r11 = r5.keys();     // Catch: Exception -> L18
        if (r11 == null) goto L12;
        r10 = new JSONObject();     // Catch: Exception -> L18
    L10:
        if (r11.hasNext() == false) goto L12;
        String r12 = r11.next();     // Catch: Exception -> L18
        r10.put(r12, r5.opt(r12));     // Catch: Exception -> L18
        goto L10
    }

    private static JSONObject preProcessExtJson2(JSONObject r5) {
        if (r5 != null) goto L6;
        r5 = new JSONObject();     // Catch: Exception -> L9
    L8:
        return r5;
    L6:
        if (r5.isNull("timestamp") == false) goto L8;
        r5.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L9
        goto L8
    }

    public static void removePerfTag(@NonNull String r5, @Nullable String r10) {
        ((ConcurrentHashMap) s6.c.w().f21829c).remove(r5, r10);
        ((ConcurrentHashMap) q7.a.k().f21489c).remove(r5, r10);
    }

    private static void reportFeedbackInfo() {
        s6.d.f21830a.getClass();     // Catch: JSONException -> L30
        boolean r5 = j.f3887a;     // Catch: JSONException -> L30
        JSONObject r10 = new JSONObject();     // Catch: JSONException -> L30
        JSONObject r11 = s6.c.w().x(true);     // Catch: JSONException -> L30
        r11.put("crash_section", j.c(System.currentTimeMillis()));     // Catch: JSONException -> L30
        r11.put("crash_type", "feedback");     // Catch: JSONException -> L30
        JSONObject r12 = jg.k.m().k();     // Catch: JSONException -> L30
        io.reactivex.internal.functions.d r13 = ym.k.f23303a;     // Catch: JSONException -> L30
        if (r13 != null) goto L48;
    L7:
        JSONArray r14 = null;
    L8:
        r12.put("activity_track", r14);     // Catch: JSONException -> L30
        if (s6.b.f21825b == null) goto L11;
    L21:
        s6.b.f21825b.getClass();     // Catch: JSONException -> L30
        JSONObject r15 = new JSONObject();     // Catch: JSONException -> L30
        o7.b r16 = (o7.b) r7.a.a(o7.b.class);     // Catch: JSONException -> L24
        r15.put("process_usage", r16.f20414a);     // Catch: JSONException -> L24
        r15.put("stat_speed", r16.f20415b);     // Catch: JSONException -> L24
    L25:
        r12.put("cpu_info", r15);     // Catch: JSONException -> L30
        boolean r17 = j.f3887a;     // Catch: JSONException -> L30
        t6.b r18 = new t6.b();     // Catch: JSONException -> L30
        long r19 = Runtime.getRuntime().totalMemory();     // Catch: Exception -> L39
        long r20 = Runtime.getRuntime().freeMemory();     // Catch: Exception -> L39
        r18.f22104a = r19;     // Catch: Exception -> L39
        r18.f22105b = r20;     // Catch: Exception -> L39
        r18.f22106c = r19 - r20;     // Catch: Exception -> L39
        Process.myPid();     // Catch: Exception -> L39
        r18.d = com.bytedance.apm.util.a.n() * RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;     // Catch: Exception -> L39
    L27:
        r12.put("memory_info", getMemInfo(r18));     // Catch: JSONException -> L30
        r12.put("temperature", s6.d.f21830a.f18208a);     // Catch: JSONException -> L30
        String r21 = MethodCollector.getInstance().getEvilMethod(0, SystemClock.uptimeMillis());     // Catch: JSONException -> L30
        if (TextUtils.isEmpty(r21) == true) goto L32;
        r12.put("evil_method", r21);     // Catch: JSONException -> L30
        r11.put("with_evil_method", "true");     // Catch: JSONException -> L30
    L32:
        jg.k r22 = jg.k.m();     // Catch: JSONException -> L30
        SystemClock.uptimeMillis();     // Catch: JSONException -> L30
        r22.getClass();     // Catch: JSONException -> L30
        if (TextUtils.isEmpty(null) == false) goto L36;
        r12.put("battery", getCapacity());     // Catch: JSONException -> L30
        r12.put("battery_current", getGalvanicNow());     // Catch: JSONException -> L30
        r10.put("custom", r12);     // Catch: JSONException -> L30
        r10.put("filters", r11);     // Catch: JSONException -> L30
        r10.put("stack", "at feedback.*(a.java:-1)");     // Catch: JSONException -> L30
        r10.put("event_type", "serious_lag");     // Catch: JSONException -> L30
        j6.c r23 = new j6.c("serious_block_monitor", r10);     // Catch: JSONException -> L30
        r23.f18255c = true;     // Catch: JSONException -> L30
        i6.a.i().b(r23);     // Catch: JSONException -> L30
        return;
    L36:
        throw null;
    L24:
        r15 = new JSONObject();     // Catch: JSONException -> L30
        goto L25
    L11:
        monitor-enter(s6.b.class);     // Catch: JSONException -> L30
    L15:
        th = move-exception;
        throw th;     // Catch: JSONException -> L30
    L13:
        if (s6.b.f21825b != null) goto L17;
        s6.b.f21825b = new s6.b(0);     // Catch: Throwable -> L15
    L17:
        monitor-exit(s6.b.class);     // Catch: Throwable -> L15
    L48:
        r14 = (JSONArray) r13.call();     // Catch: Throwable -> L40
    L30:
        e = move-exception;
        e.printStackTrace();
    }

    public static void reportLegacyMonitorLog(Context r5, long r10, long r11, boolean r12) {
    }

    public static int reportThreadCount(String r5) {
        return s6.f.m(r5, true);
    L5:
        return 0;
    }

    @Deprecated
    public static void setReportMode(e6.b r5) {
        ApmDelegate r10 = com.bytedance.apm.internal.b.f3886a;
    }

    public static void startBatteryCollect(String r5) {
        boolean r10 = j.f3887a;
    }

    public static void startCollectCurrent(String r5) {
        boolean r10 = j.f3887a;
    }

    public static void startCpuMonitor(String r5) {
        boolean r10 = j.f3887a;
    }

    public static void startScene(String r5) {
        ((CopyOnWriteArraySet) s6.c.w().f21828b).add(r5);
        ((CopyOnWriteArraySet) q7.a.k().f21488b).add(r5);
    }

    public static void startTrafficStats(String r5) {
        String r10 = v6.g.f22531u;
        v6.g r11 = v6.f.f22530a;
        monitor-enter(r11);
        int r12 = 1;
        z6.b.f23409a.d(new lm.g(r11, r5, r12, false));     // Catch: Throwable -> L7
        monitor-exit(r11);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void stopBatteryCollect(String r5) {
        boolean r10 = j.f3887a;
    }

    public static void stopCollectCurrent(String r5) {
        boolean r10 = j.f3887a;
    }

    public static void stopCpuMonitor(String r5) {
        boolean r10 = j.f3887a;
    }

    public static void stopScene(String r5) {
        ((CopyOnWriteArraySet) s6.c.w().f21828b).remove(r5);
        ((CopyOnWriteArraySet) q7.a.k().f21488b).remove(r5);
    }

    public static void stopTrafficStats(String r5) {
        String r10 = v6.g.f22531u;
        v6.g r11 = v6.f.f22530a;
        monitor-enter(r11);
        z6.b.f23409a.d(new s8.h(3, r11, r5));     // Catch: Throwable -> L7
        monitor-exit(r11);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void storeLogBypass(String r10, String r11) {
        monitor-enter(ApmAgent.class);     // Catch: Throwable -> L9
        j.a();     // Catch: Throwable -> L6
        long r5 = Thread.currentThread().getId();     // Catch: Throwable -> L6
        long r12 = System.currentTimeMillis();     // Catch: Throwable -> L6
        Date r13 = new Date(System.currentTimeMillis());     // Catch: Throwable -> L6
        String r14 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(r13);     // Catch: Throwable -> L6
        StringBuffer r15 = new StringBuffer();     // Catch: Throwable -> L6
        r15.append(r10);     // Catch: Throwable -> L6
        r15.append("#");     // Catch: Throwable -> L6
        r15.append(r5);     // Catch: Throwable -> L6
        r15.append("#");     // Catch: Throwable -> L6
        r15.append(r12);     // Catch: Throwable -> L6
        r15.append("#");     // Catch: Throwable -> L6
        r15.append(r14);     // Catch: Throwable -> L6
        r15.append("\n");     // Catch: Throwable -> L6
        r15.append(r11);     // Catch: Throwable -> L6
        r15.append("\n");     // Catch: Throwable -> L6
        r15.toString().getBytes("UTF-8");     // Catch: Throwable -> L6
        throw null;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    }

    public static void trafficStats(long r15, String r17, String r18, @Nullable String r19, @Nullable JSONObject r20, @Nullable JSONObject r21) {
        v6.c r10 = v6.b.f22516a;
        if (r10.f22517a == false) goto L35;
        z6.b.f23409a.d(new s5.a(1, r15, r18, r17));
        String r5 = "";
        if (r10.f22518b == false) goto L21;
        if (r15 <= r10.f22525m) goto L21;
        Long r11 = Long.valueOf(r15);
        if (r19 != null) goto L12;
        String r12 = "";
    L13:
        if (r20 != null) goto L15;
        String r13 = "";
    L16:
        if (r21 != null) goto L18;
        String r14 = "";
    L19:
        String.format("trafficBytes: %d, sourceId: %s, business: %s, scene: %s, extraStatus: %s, extraLog: %s", new Object[]{r11, r17, r18, r12, r13, r14});
        goto L21
    L18:
        r14 = r21.toString();
        goto L19
    L15:
        r13 = r20.toString();
        goto L16
    L12:
        r12 = r19;
    L21:
        if (j.f3887a == false) goto L33;
        Long r16 = Long.valueOf(r15);
        if (r19 != null) goto L25;
        String r110 = "";
    L26:
        if (r20 != null) goto L28;
        String r111 = "";
    L29:
        if (r21 == null) goto L32;
        r5 = r21.toString();
    L32:
        Log.d("BizTrafficStats", String.format("trafficBytes: %d, sourceId: %s, business: %s, scene: %s, extraStatus: %s, extraLog: %s", new Object[]{r16, r17, r18, r110, r111, r5}));
        goto L33
    L28:
        r111 = r20.toString();
        goto L29
    L25:
        r110 = r19;
    L33:
        r10.f22522j += r15;
        return;
    }

    public static void uploadMappingFile(String r10, oj.d r11) {
        JSONObject r5 = j.f3888b;
        String r12 = r5.optString(WsConstants.KEY_APP_ID);
        String r13 = r5.optString("update_version_code");
        String r14 = r5.optString(LynxMonitorService.KEY_CHANNEL);
        String r15 = r5.optString("release_build");
        String r16 = r5.optString(WsConstants.KEY_DEVICE_ID);
        if (TextUtils.isEmpty(r12) == false) goto L5;
    L13:
        if (r11 == null) goto L16;
        r11.onFail();
        return;
    L16:
        return;
    L5:
        if (TextUtils.isEmpty(r13) == true) goto L13;
        if (TextUtils.isEmpty(r14) == true) goto L13;
        if (TextUtils.isEmpty(r15) == true) goto L13;
        z6.b.f23409a.e(new r(r12, r13, r14, r15, r10, r16));
    }

    private static void uploadMappingFileInternal(String r10, String r11, String r12, String r13, String r14, String r15, oj.d r16) {
        ArrayList r5 = f6.a.f16880b;
        if (wn.f.j(r5) == false) goto L12;
        if (r16 == null) goto L14;
        r16.onFail();
        return;
    L14:
        return;
    L12:
        p.i(new URL((String) r5.get(0)).getHost());     // Catch: MalformedURLException -> L9
        z6.b.f23409a.e(new r(r11, r12, r13, r14, r10, r15));     // Catch: MalformedURLException -> L9
        return;
    L9:
        if (r16 == null) goto L15;
        r16.onFail();
        return;
    }

    private static void weedOutOldestLogFiles() {
        if (j.d() == true) goto L6;
        return;
    L6:
        if (sProcessLogsFolder.exists() == true) goto L8;
        return;
    L8:
        File[] r5 = sProcessLogsFolder.listFiles();
        Arrays.sort(r5, new ca.d(3));
        int r10 = 60;
        if (r5.length > 60) goto L12;
        r10 = r5.length;
    L12:
        int r11 = 0;
    L13:
        if (r11 >= r10) goto L15;
        r5[r11].delete();
        r11 = r11 + 1;
        goto L13
    }

    public static void monitorCommonLog(String r5, JSONObject r10, boolean r11) {
        b0 r12 = h7.a.f17285a;
        JSONObject r13 = preProcessExtJson2(r10);
        addDebugMessage(r13);
        z6.b.f23409a.d(new d(0, r5, r13));
        boolean r14 = j.f3887a;
    }

    public static void monitorPerformance(String r10, String r11, JSONObject r12, JSONObject r13, JSONObject r14) {
        if (sDeepCopy == false) goto L6;
        JSONObject r15 = preProcessExtJson(r14);     // Catch: Exception -> L9
    L5:
        JSONObject r5 = r15;
        z6.b.f23409a.d(new f(r10, r11, r12, r13, r5, 0));     // Catch: Exception -> L9
        boolean r16 = j.f3887a;     // Catch: Exception -> L9
        return;
    L6:
        r15 = preProcessExtJson2(r14);     // Catch: Exception -> L9
    }

    public static void monitorUIAction(String r10, String r11, JSONObject r12, JSONObject r13) {
        if (sDeepCopy == false) goto L6;
        JSONObject r14 = preProcessExtJson(r13);     // Catch: Exception -> L9
    L5:
        JSONObject r5 = r14;
        z6.b.f23409a.d(new e(0, r10, r11, r12, r5));     // Catch: Exception -> L9
        boolean r15 = j.f3887a;     // Catch: Exception -> L9
        return;
    L6:
        r14 = preProcessExtJson2(r13);     // Catch: Exception -> L9
    }

    public static void monitorApiError(long r13, long r15, String r17, String r18, String r19, int r20, JSONObject r21, vj.a r22, Throwable r23) {
        JSONObject r10 = optShallowCopyJson(r21);
        HashMap r5 = f7.a.f16881a;
        if (r10 == null) goto L6;
        if (r23 == null) goto L6;
        r10.put("substatus", f7.a.b(r23));     // Catch: Throwable -> L8
    L6:
        f7.a.c(r22, r10);
        z6.b.f23409a.d(new c(r13, r15, r17, r18, r19, r20, r10, 3));
        boolean r11 = j.f3887a;
    }

    public static void monitorSLA(long r13, long r15, String r17, String r18, String r19, int r20, JSONObject r21, vj.a r22) {
        JSONObject r10 = optShallowCopyJson(r21);
        f7.a.c(r22, r10);
        z6.b.f23409a.d(new c(r13, r15, r17, r18, r19, r20, r10, 2));
        boolean r5 = j.f3887a;
    }

    public static void activeUploadAlog(String r10, long r11, long r12, String r13, v5.b r14) {
        activeUploadAlog(r10, r11, r12, r13, r14, null);
    }

    public static void activeUploadAlog(long r10, long r11, String r12, v5.b r13) {
        activeUploadAlog("", r10, r11, r12, r13);
    }

    public static void monitorEvent(e6.c r5) {
    }

    public static void startTrafficStats(String r5, boolean r10) {
        String r11 = v6.g.f22531u;
        v6.g r12 = v6.f.f22530a;
        monitor-enter(r12);
        z6.b.f23409a.d(new lm.g(r12, r5, 1, r10));     // Catch: Throwable -> L7
        monitor-exit(r12);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void uploadMappingFile(String r10, String r11, String r12, String r13, String r14, oj.d r15, String r16) {
        if (TextUtils.isEmpty(r11) == false) goto L5;
    L15:
        if (r15 == null) goto L18;
        r15.onFail();
        return;
    L18:
        return;
    L5:
        if (TextUtils.isEmpty(r12) == true) goto L15;
        if (TextUtils.isEmpty(r13) == true) goto L15;
        if (TextUtils.isEmpty(r14) == true) goto L15;
        if (TextUtils.isEmpty(r16) == true) goto L15;
        p.i(r16);
        z6.b.f23409a.e(new f(r11, r12, r13, r14, r10, 6));
    }

    @Deprecated
    public static void monitorDuration(String r5, JSONObject r10, JSONObject r11, long r12) {
        b0 r13 = h7.a.f17285a;
        if (r11 != null) goto L10;
    L8:
        JSONObject r14 = optShallowCopyJson(r11);
        addDebugMessage(r14);
        z6.b.f23409a.d(new com.bytedance.android.anniex.scene.core.i(r5, r10, r14, 2));
        boolean r15 = j.f3887a;
        return;
    L10:
        r11.put("timestamp", r12);     // Catch: JSONException -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public static void uploadMappingFile(String r10, String r11, String r12, String r13, String r14, oj.d r15, String r16, String r17) {
        if (TextUtils.isEmpty(r11) == false) goto L5;
    L17:
        if (r15 == null) goto L20;
        r15.onFail();
        return;
    L20:
        return;
    L5:
        if (TextUtils.isEmpty(r12) == true) goto L17;
        if (TextUtils.isEmpty(r13) == true) goto L17;
        if (TextUtils.isEmpty(r14) == true) goto L17;
        if (TextUtils.isEmpty(r17) == true) goto L17;
        if (TextUtils.isEmpty(r16) == true) goto L17;
        p.i(r16);
        z6.b.f23409a.e(new r(r11, r12, r13, r14, r10, r17));
    }

    public static void uploadMappingFile(String r10, String r11, String r12, String r13, String r14, oj.d r15) {
        if (TextUtils.isEmpty(r11) == false) goto L5;
    L13:
        if (r15 == null) goto L16;
        r15.onFail();
        return;
    L16:
        return;
    L5:
        if (TextUtils.isEmpty(r12) == true) goto L13;
        if (TextUtils.isEmpty(r13) == true) goto L13;
        if (TextUtils.isEmpty(r14) == true) goto L13;
        uploadMappingFileInternal(r10, r11, r12, r13, r14, null, r15);
    }

    public static void uploadMappingFile(String r5, String r10, String r11, String r12, String r13, String r14, oj.d r15) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L15:
        if (r15 == null) goto L18;
        r15.onFail();
        return;
    L18:
        return;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L15;
        if (TextUtils.isEmpty(r12) == true) goto L15;
        if (TextUtils.isEmpty(r13) == true) goto L15;
        if (TextUtils.isEmpty(r14) == true) goto L15;
        uploadMappingFileInternal(r5, r10, r11, r12, r13, r14, r15);
    }
}
