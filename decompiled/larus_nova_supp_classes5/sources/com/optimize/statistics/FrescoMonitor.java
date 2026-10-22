package com.optimize.statistics;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bytedance.framwork.core.monitor.MonitorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.request.ImageRequest;
import com.optimize.statistics.sampling.IFrescoMonitorSamplingDecider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class FrescoMonitor {
    private static final String TAG = "FrescoMonitor";
    static boolean isReportDebug;
    private static Context sContext;
    private static String sCurrentActivity;
    private static String sCurrentScene;
    private static boolean sEnableAllSourceUriReport;
    private static boolean sEnableMonitorLog;
    private static List<ImageExceedLimitTraceListener> sExceedTheLimitTraceListeners;
    private static volatile IMonitorHook sMonitorHook;
    static final List<IMonitorHookV2> sMonitorHookV2s = null;
    static final CopyOnWriteArrayList<IMonitorHookV2> sNewMonitorHookV2s = null;
    private static boolean sReportHitCacheEnabled;
    private static boolean sReportImageMonitorDataEnabled;
    private static volatile IFrescoMonitorSamplingDecider sSamplingDecider;
    private static List<ImageSensibleTraceListener> sSensibleTraceListeners;
    private static List<ImageTraceListener> sTraceListeners;
    private static List<ImageWasteShowListener> sWasteShowListeners;

    public FrescoMonitor() {
    }

    static {
        sTraceListeners = new ArrayList();
        sExceedTheLimitTraceListeners = new ArrayList();
        sSensibleTraceListeners = new ArrayList();
        sWasteShowListeners = new ArrayList();
        sMonitorHookV2s = new ArrayList();
        sNewMonitorHookV2s = new CopyOnWriteArrayList();
        sReportHitCacheEnabled = false;
        sReportImageMonitorDataEnabled = false;
        sEnableMonitorLog = true;
        sEnableAllSourceUriReport = false;
        sCurrentScene = null;
        sCurrentActivity = null;
    }

    public static boolean isReportImageWaste() {
        Iterator<ImageWasteShowListener> r0 = sWasteShowListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        ImageWasteShowListener r1 = r0.next();
        if (r1 == null) goto L4;
        if (r1.isReportImageWaste() == false) goto L4;
        return true;
    L11:
        return false;
    }

    public static Context getContext() {
        return sContext;
    }

    public static String getCurrentActivity() {
        return sCurrentActivity;
    }

    public static String getCurrentScene() {
        return sCurrentScene;
    }

    public static IMonitorHook getMonitorHook() {
        return sMonitorHook;
    }

    public static IFrescoMonitorSamplingDecider getSamplingDecider() {
        return sSamplingDecider;
    }

    public static boolean isEnableMonitorLog() {
        return sEnableMonitorLog;
    }

    public static boolean isNeedReportAllSourceUriType() {
        return sEnableAllSourceUriReport;
    }

    public static boolean isReportHitCacheEnabled() {
        return sReportHitCacheEnabled;
    }

    public static boolean isReportImageMonitorDataEnabled() {
        return sReportImageMonitorDataEnabled;
    }

    public static void addImageExceedTheLimitTraceListener(ImageExceedLimitTraceListener r1) {
        sExceedTheLimitTraceListeners.add(r1);
    }

    public static void addImageSensibleTraceListener(ImageSensibleTraceListener r1) {
        sSensibleTraceListeners.add(r1);
    }

    public static void addImageTraceListener(ImageTraceListener r1) {
        sTraceListeners.add(r1);
    }

    public static void addImageWasteShowListener(ImageWasteShowListener r1) {
        sWasteShowListeners.add(r1);
    }

    public static void addMonitorHookV2(IMonitorHookV2 r1) {
        if (FrescoCacheMonitorUtil.isOptListenerAnr() == false) goto L5;
        sNewMonitorHookV2s.add(r1);
        return;
    L5:
        List<IMonitorHookV2> r0 = sMonitorHookV2s;
        monitor-enter(r0);
        r0.add(r1);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static boolean getLogTypeSwitch(String r1) {
        if (FrescoCacheMonitorUtil.isOptMonitorSampleDebug() == false) goto L7;
        boolean r2 = !isReportDebug;
        isReportDebug = r2;
        return r2;
    L7:
        return MonitorUtils.getLogTypeSwitch(r1);
    }

    public static boolean isNetworkAvailable(Context r2) {
        ConnectivityManager r3 = (ConnectivityManager) r2.getSystemService("connectivity");     // Catch: Exception -> L11
        if (r3 == null) goto L14;
        NetworkInfo r4 = r3.getActiveNetworkInfo();     // Catch: Exception -> L11
        if (r4 == null) goto L15;
        if (r4.isAvailable() == false) goto L16;
        return true;
    L16:
        return false;
    L15:
        return false;
    L14:
        return false;
    L17:
        return false;
    }

    public static void onExceedLimitCallback(JSONObject r2) {
        Iterator<ImageExceedLimitTraceListener> r0 = sExceedTheLimitTraceListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        ImageExceedLimitTraceListener r1 = r0.next();
        if (r1 == null) goto L4;
        r1.onExceedLimitCallback(r2);
        goto L4
    }

    public static void onSensibleCallback(JSONObject r2) {
        Iterator<ImageSensibleTraceListener> r0 = sSensibleTraceListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        ImageSensibleTraceListener r1 = r0.next();
        if (r1 == null) goto L4;
        r1.onSensibleCallback(r2);
        goto L4
    }

    public static void removeMonitorHookV2(IMonitorHookV2 r1) {
        if (FrescoCacheMonitorUtil.isOptListenerAnr() == false) goto L5;
        sNewMonitorHookV2s.remove(r1);
        return;
    L5:
        List<IMonitorHookV2> r0 = sMonitorHookV2s;
        monitor-enter(r0);
        r0.remove(r1);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static void setContext(Context r0) {
        sContext = r0;
    }

    public static void setCurrentActivity(String r0) {
        sCurrentActivity = r0;
    }

    public static void setCurrentScene(String r0) {
        sCurrentScene = r0;
    }

    public static void setCustomExceedLimit(ExceedTheLimitBitmapMonitor.CustomExceedLimit r0) {
        ExceedTheLimitBitmapMonitor.setCustomExceedLimit(r0);
    }

    public static void setEnableAllSourceUriReport(boolean r0) {
        sEnableAllSourceUriReport = r0;
    }

    public static void setEnableMonitorLog(boolean r0) {
        sEnableMonitorLog = r0;
    }

    public static void setExceedTheLimitBitmapMonitorEnabled(boolean r0) {
        ExceedTheLimitBitmapMonitor.setExceedTheLimitBitmapMonitorEnabled(r0);
    }

    public static void setImageTraceListener(ImageTraceListener r0) {
        addImageTraceListener(r0);
    }

    public static void setMonitorHook(IMonitorHook r0) {
        sMonitorHook = r0;
    }

    public static void setReportHitCacheEnabled(boolean r0) {
        sReportHitCacheEnabled = r0;
    }

    public static void setReportImageMonitorDataEnabled(boolean r0) {
        sReportImageMonitorDataEnabled = r0;
    }

    public static void setSamplingDecider(IFrescoMonitorSamplingDecider r1) {
        sSamplingDecider = r1;
        if (r1 != null) goto L5;
        String r2 = "null";
    L6:
        FLog.d(TAG, "setSamplingDecider, decider is ".concat(r2));
        return;
    L5:
        r2 = "non-null";
        goto L6
    }

    public static void onImageShowCallback(boolean r2, JSONObject r3) {
        Iterator<ImageWasteShowListener> r0 = sWasteShowListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        ImageWasteShowListener r1 = r0.next();
        if (r1 == null) goto L4;
        r1.onImageShowCallback(r2, r3);
        goto L4
    }

    public static void setExceedTheLimitBitmapMonitorLimit(long r0, int r2, long r3) {
        ExceedTheLimitBitmapMonitor.setBitmapMonitorLimit(r0, r2, r3);
    }

    public static void onImageLoaded(boolean r3, String r4, JSONObject r5, boolean[] r6) {
        if (r3 == true) goto L12;
        Context r0 = sContext;
        if (r0 == null) goto L9;
        if (isNetworkAvailable(r0) == true) goto L9;
        return;
    L9:
        if (getLogTypeSwitch("image_monitor_error_v2") == false) goto L12;
        MonitorUtils.monitorCommonLog("image_monitor_error_v2", r5);
    L12:
        if (FrescoCacheMonitorUtil.isOptMonitorSample() == false) goto L26;
        if (r6 != null) goto L15;
        return;
    L15:
        int r1 = 0;
    L17:
        if (r1 >= sTraceListeners.size()) goto L32;
        if (r1 >= r6.length) goto L43;
        ImageTraceListener r2 = (ImageTraceListener) ListProtector.get(sTraceListeners, r1);
        if (r2 == null) goto L25;
        if (r6[r1] == false) goto L25;
        r2.onImageLoaded(r3, r4, r5);
    L25:
        r1 = r1 + 1;
        goto L17
    L43:
        return;
    L32:
        return;
    L26:
        Iterator<ImageTraceListener> r7 = sTraceListeners.iterator();
    L28:
        if (r7.hasNext() == false) goto L44;
        ImageTraceListener r8 = r7.next();
        if (r8 == null) goto L28;
        r8.onImageLoaded(r3, r4, r5);
        goto L28
    }

    public static boolean[] sampleImageTraceListeners(ImageRequest r9, Object r10, String r11, boolean r12) {
        int r0 = sTraceListeners.size();
        if (r0 != 0) goto L5;
        return null;
    L5:
        boolean[] r2 = new boolean[r0];
        int r4 = 0;
        boolean r5 = false;
    L6:
        if (r4 >= r0) goto L25;
        ImageTraceSampler r6 = (ImageTraceListener) ListProtector.get(sTraceListeners, r4);
        if (r6 != null) goto L11;
        r2[r4] = false;
    L18:
        if (r5 == false) goto L20;
    L23:
        r5 = true;
    L24:
        r4 = r4 + 1;
        goto L6
    L20:
        if (r2[r4] == true) goto L23;
        r5 = false;
        goto L24
    L11:
        if ((r6 instanceof ImageTraceSampler) == false) goto L17;
        Boolean r7 = r6.shouldSampleImageLoaded(r9, r10, r11);
        if (r7 != null) goto L15;
        boolean r8 = r12;
    L16:
        r2[r4] = r8;
        goto L18
    L15:
        r8 = r7.booleanValue();
        goto L16
    L17:
        r2[r4] = true;
        goto L18
    L25:
        if (r5 == true) goto L27;
        return null;
    L27:
        return r2;
    }

    public static void imageNetCallBack(long r11, long r13, String r15, HttpRequestInfo r16, Throwable r17, JSONObject r18) {
        Iterator<ImageTraceListener> r0 = sTraceListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        ImageTraceListener r2 = r0.next();
        if (r2 == null) goto L4;
        r2.imageNetCallBack(r11, r13, r15, r16, r17, r18);
        goto L4
    }
}
