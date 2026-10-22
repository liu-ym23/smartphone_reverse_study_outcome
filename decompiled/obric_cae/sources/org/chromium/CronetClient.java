package org.chromium;

import a7.h;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.ttnet.TTALog;
import com.bytedance.ttnet.TTNetInit;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.ttnet.org.chromium.base.Logger;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.ExperimentalCronetEngine;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.TTNetVersion;
import com.ttnet.org.chromium.net.impl.CronetUrlRequest;
import com.ttnet.org.chromium.net.impl.CronetUrlRequestMapping;
import com.ttnet.org.chromium.net.impl.URLDispatch;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CronetClient implements ICronetClient {
    private static final String BORINGSSL_LIBRARY_NAME = "ttboringssl";
    private static final String CRYPTO_LIBRARY_NAME = "ttcrypto";
    private static final int INVALID_THREAD_PRIORITY = 20;
    private static final String KEY_REQUEST_LOG = "request_log";
    public static final String TAG = "CronetClient";
    private static final String TTNET_ALOG_CLASS = "com.bytedance.ttnet.TTALog";
    private static final String TTNET_BOE_FLAG = "ttnet_boe.flag";
    private static final String TTNET_CACHE_DIR = "ttnet_storage/";
    private static final String TTNET_CONFIG_FILE = "ttnet_config.json";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private static ICronetClient.ICronetBootFailureChecker sCronetBootFailureChecker = null;
    private static volatile CronetEngine sCronetEngine = null;
    private static volatile int sNetworkThreadPriority = 20;
    private static volatile RequestFinishedInfo.Listener sRequestFinishedInfoListener;

    public CronetClient() {
    }

    public static /* synthetic */ long access$000(CronetClient r8, long r10, long r11) {
        return r8.getCostTime(r10, r11);
    }

    public static void addClientOpaqueData(Context r8, String[] r10, byte[] r11, byte[] r12) {
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (f.c(r8) == true) goto L6;
        return;
    L6:
        if (d.a().loggerDebug() == false) goto L9;
        d.a().loggerD(TAG, "addClientOpaqueData start");     // Catch: Throwable -> L12
    L9:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L17;
        ((ExperimentalCronetEngine) sCronetEngine).addClientOpaqueData(r10, r11, r12);     // Catch: Throwable -> L12
        return;
    }

    public static void clearClientOpaqueData(Context r8) {
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (f.c(r8) == true) goto L6;
        return;
    L6:
        if (d.a().loggerDebug() == false) goto L9;
        d.a().loggerD(TAG, "clearClientOpaqueData start");     // Catch: Throwable -> L12
    L9:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L17;
        ((ExperimentalCronetEngine) sCronetEngine).clearClientOpaqueData();     // Catch: Throwable -> L12
        return;
    }

    public static List<InetAddress> dnsLookup(String r8) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return ((ExperimentalCronetEngine) sCronetEngine).dnsLookup(r8);
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static void enableTTBizHttpDns(boolean r8, String r10, String r11, String r12, boolean r13, String r14) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).enableTTBizHttpDns(r8, r10, r11, r12, r13, r14);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    private static long getALogFuncAddr() {
        return ((Long) Reflect.on(TTALog.class.newInstance()).call("getALogFuncAddr").get()).longValue();
    }

    private long getCostTime(long r8, long r10) {
        if (r10 != (-1)) goto L5;
    L11:
        return -1;
    L5:
        if (r8 == (-1)) goto L11;
        if (r10 > r8) goto L11;
        return r8 - r10;
    }

    public static CronetEngine getCronetEngine() {
        if (sCronetEngine == null) goto L7;
        return sCronetEngine;
    L7:
        throw new NullPointerException("Cronet engine is null.");
    }

    private static String getDomainConfigByRegion() {
        String r8 = c.c().a("getCarrierRegion");
        String r10 = c.c().a("getSysRegion");
        String r11 = c.c().a("getRegion");
        if (TextUtils.isEmpty(r8) == false) goto L10;
        if (TextUtils.isEmpty(r10) == true) goto L8;
        r8 = r10;
        goto L10
    L8:
        r8 = r11;
    L10:
        if (TextUtils.isEmpty(r8) == false) goto L15;
        return null;
    L15:
        String r12 = TTNetInit.DOMAIN_HTTPDNS_KEY;     // Catch: Exception -> L14
        return (String) Reflect.on(TTNetInit.class.newInstance()).call("getGetDomainConfigByRegion", new Class[]{String.class}, new Object[]{r8}).get();
    L14:
        return null;
    }

    public static int getEffectiveConnectionType() {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return ((ExperimentalCronetEngine) sCronetEngine).getEffectiveConnectionType();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static Map<String, int[]> getGroupRTTEstimates() {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return ((ExperimentalCronetEngine) sCronetEngine).getGroupRttEstimates();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    private static boolean getListenAppStateIndependently() {
        String r8 = TTNetInit.DOMAIN_HTTPDNS_KEY;     // Catch: Exception -> L4
        return ((Boolean) Reflect.on(TTNetInit.class.newInstance()).call("getListenAppStateIndependently").get()).booleanValue();
    L4:
        return false;
    }

    public static void getMappingRequestState(final String r8) {
        CronetUrlRequest r10 = CronetUrlRequestMapping.GetRequest(r8);     // Catch: Throwable -> L6
        if (r10 == null) goto L11;
        r10.getStatus(new AnonymousClass2(r8));     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public static int[] getNetworkQuality() {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ExperimentalCronetEngine r8 = (ExperimentalCronetEngine) sCronetEngine;
        return new int[]{r8.getTransportRttMs(), r8.getHttpRttMs(), r8.getDownstreamThroughputKbps()};
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static h getPacketLossRateMetrics(int r8) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        h r10 = new h();
        ExperimentalCronetEngine r11 = (ExperimentalCronetEngine) sCronetEngine;
        r11.getUpstreamPacketLossRate(r8);
        r11.getUpstreamPacketLossRateVariance(r8);
        r11.getDownstreamPacketLossRate(r8);
        r11.getDownstreamPacketLossRateVariance(r8);
        return r10;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    private String getProxyConfig(String r8) {
        String r10 = "";
        if (TextUtils.isEmpty(r8) == true) goto L34;
        BufferedReader r11 = null;
        File r12 = new File(r8 + TTNET_CONFIG_FILE);     // Catch: Throwable -> L21
        if (r12.exists() == false) goto L16;
        BufferedReader r13 = new BufferedReader(new FileReader(r12));     // Catch: Throwable -> L21
        StringBuilder r14 = new StringBuilder();     // Catch: Throwable -> L14
    L9:
        String r15 = r13.readLine();     // Catch: Throwable -> L14
        if (r15 == null) goto L12;
        r14.append(r15);     // Catch: Throwable -> L14
        goto L9
    L12:
        r10 = new JSONObject(r14.toString()).optString("ttnet_proxy", "");     // Catch: Throwable -> L14
        r11 = r13;
    L14:
        Throwable th = th;
    L42:
        th.printStackTrace();     // Catch: Throwable -> L27
        if (r13 == null) goto L34;
        r13.close();     // Catch: IOException -> L19
    L37:
    L27:
        th = move-exception;
        if (r13 != null) goto L40;
    L33:
        throw th;
    L40:
        r13.close();     // Catch: IOException -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L16:
        if (r11 == null) goto L34;
        r11.close();     // Catch: IOException -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
    L21:
        th = move-exception;
        r13 = null;
        th = th;
    L34:
        return r10;
    }

    private long getTime(Date r8) {
        if (r8 != null) goto L6;
        return -1;
    L6:
        return r8.getTime();
    }

    private long getValue(Long r8) {
        if (r8 != null) goto L6;
        return -1;
    L6:
        return r8.longValue();
    }

    public static void notifyStoreRegionUpdated(String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).updateStoreRegionFromServer(r10, r11, r12, r13, r14, r15, r16, r17);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static boolean notifySwitchToMultiNetwork(boolean r8) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).notifySwitchToMultiNetwork(r8);
        return true;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static void notifyTNCConfigUpdated(String r8, String r10, String r11, String r12, String r13, String r14) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).notifyTNCConfigUpdated(r8, r10, r11, r12, r13, r14);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static void preconnectUrl(String r8) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).preconnectUrl(r8, 1);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static void removeClientOpaqueData(Context r8, String r10) {
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (f.c(r8) == true) goto L6;
        return;
    L6:
        if (d.a().loggerDebug() == false) goto L9;
        d.a().loggerD(TAG, "removeClientOpaqueData start");     // Catch: Throwable -> L12
    L9:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L17;
        ((ExperimentalCronetEngine) sCronetEngine).removeClientOpaqueData(r10);     // Catch: Throwable -> L12
        return;
    }

    public static void reportNetDiagnosisUserLog(String r8) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).reportNetDiagnosisUserLog(r8);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static void setAlogFuncAddr(long r8) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setAlogFuncAddr(r8);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static void setAppStartUpState(int r8) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setAppStartUpState(r8);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static void setHostResolverRules(String r8) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setHostResolverRules(r8);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static void setHttpDnsForTesting(boolean r8, boolean r10, boolean r11) {
    }

    public static void setNetworkThreadPriority(int r8) {
        sNetworkThreadPriority = r8;
    }

    public static void setProxy(String r8) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setProxy(r8);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static void triggerGetDomain(Context r8, boolean r10) {
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (f.c(r8) == true) goto L6;
        return;
    L6:
        if (d.a().loggerDebug() == false) goto L9;
        d.a().loggerD(TAG, "triggerGetDomain start");     // Catch: Throwable -> L12
    L9:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L17;
        ((ExperimentalCronetEngine) sCronetEngine).triggerGetDomain(r10);     // Catch: Throwable -> L12
        return;
    }

    public static void triggerSwitchingToCellular() {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).tiggerWiFiToCellularByThirdParty();
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    private void tryCreateCronetEngine(Context r8, boolean r10, boolean r11, boolean r12, boolean r13, String r14, Executor r15, boolean r16) {
        if (sCronetEngine == null) goto L5;
        return;
    L5:
        monitor-enter(CronetClient.class);
    L295:
        th = move-exception;
        throw th;
    L7:
        if (sCronetEngine != null) goto L290;
        if (r16 == true) goto L16;
        ICronetClient.ICronetBootFailureChecker r17 = sCronetBootFailureChecker;     // Catch: Throwable -> L295
        if (r17 == null) goto L16;
        if (r17.isCronetBootFailureExpected() == true) goto L16;
        Log.w(TAG, "isCronetBootFailureExpected return false.");     // Catch: Throwable -> L295
        throw new IllegalArgumentException("isCronetBootFailureExpected return false.");     // Catch: Throwable -> L295
    L16:
        Log.w(TAG, "CronetClient tryCreateCronetEngine");     // Catch: Throwable -> L295
        y6.b.b().f14018i = System.currentTimeMillis();     // Catch: Throwable -> L295
        ExperimentalCronetEngine.Builder r18 = new ExperimentalCronetEngine.Builder(r8).enableQuic(r10).enableHttp2(r11).enableSdch(r12).enableHttpDns(r13).listenAppStateIndependently(getListenAppStateIndependently()).enableHttpCache(0, 0).enableNetworkQualityEstimator(true);     // Catch: Throwable -> L295
        if (d.a().loggerDebug() == false) goto L20;
        r18.enableVerboseLog();     // Catch: Throwable -> L295
    L20:
        if (sNetworkThreadPriority >= (-20)) goto L22;
    L24:
        c r19 = c.c();     // Catch: Throwable -> L295
        r19.getClass();     // Catch: Throwable -> L295
        Object r20 = r19.f9796a;     // Catch: Throwable -> L30
        if (r20 == null) goto L32;
        boolean r21 = ((Boolean) com.ttnet.org.chromium.base.Reflect.on(r20).call("isEnableBrotli").get()).booleanValue();     // Catch: Throwable -> L30
    L33:
        if (r21 == false) goto L35;
        r18.enableBrotli(true);     // Catch: Throwable -> L295
    L35:
        c r22 = c.c();     // Catch: Throwable -> L295
        r22.getClass();     // Catch: Throwable -> L295
        Object r23 = r22.f9796a;     // Catch: Throwable -> L41
        if (r23 == null) goto L43;
        boolean r24 = ((Boolean) com.ttnet.org.chromium.base.Reflect.on(r23).call("isEnableQuic").get()).booleanValue();     // Catch: Throwable -> L41
    L44:
        if (r24 == false) goto L46;
        r18.enableQuic(true);     // Catch: Throwable -> L295
    L46:
        c r25 = c.c();     // Catch: Throwable -> L295
        r25.getClass();     // Catch: Throwable -> L295
        Object r26 = r25.f9796a;     // Catch: Throwable -> L52
        if (r26 == null) goto L54;
        boolean r27 = ((Boolean) com.ttnet.org.chromium.base.Reflect.on(r26).call("isEnableHttp2").get()).booleanValue();     // Catch: Throwable -> L52
    L55:
        if (r27 == false) goto L58;
        r18.enableHttp2(true);     // Catch: Throwable -> L295
    L58:
        if (a.f9791c == null) goto L60;
    L69:
        r18.setAppInfoProvider(a.f9791c);     // Catch: Throwable -> L295
        r18.setEventListener(e.a());     // Catch: Throwable -> L295
        if (f.c(r8) == false) goto L85;
        if (b.f9794a == null) goto L74;
    L83:
        r18.setAppMonitorProvider(b.f9794a);     // Catch: Throwable -> L295
        e.a().f9801a = true;     // Catch: Throwable -> L295
        goto L85
    L74:
        monitor-enter(b.class);     // Catch: Throwable -> L295
    L80:
        th = move-exception;
        throw th;     // Catch: Throwable -> L295
    L76:
        if (b.f9794a != null) goto L78;
        b.f9794a = new b();     // Catch: Throwable -> L80
    L78:
        monitor-exit(b.class);     // Catch: Throwable -> L80
    L85:
        if (TextUtils.isEmpty(r14) == true) goto L87;
        r18.setUserAgent(r14 + " cronet/TTNetVersion:8211f2a8 2021-11-16 QuicVersion:705d0b81 2021-08-12");     // Catch: Throwable -> L295
    L87:
        String r110 = getDomainConfigByRegion();     // Catch: Throwable -> L295
        String r28 = null;
        FileInputStream r29 = null;
        r28 = null;
        if (TextUtils.isEmpty(r110) == false) goto L99;
        c r111 = c.c();     // Catch: Throwable -> L295
        r111.getClass();     // Catch: Throwable -> L295
        Object r112 = r111.f9796a;     // Catch: Throwable -> L95
        if (r112 == null) goto L97;
        r110 = (String) com.ttnet.org.chromium.base.Reflect.on(r112).call("getGetDomainDefaultJSON").get();     // Catch: Throwable -> L95
    L97:
        r110 = null;
    L95:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L295
    L99:
        if (TextUtils.isEmpty(r110) == true) goto L101;
        r18.setGetDomainDefaultJSON(r110);     // Catch: Throwable -> L295
    L101:
        c r113 = c.c();     // Catch: Throwable -> L295
        r113.getClass();     // Catch: Throwable -> L295
        Object r114 = r113.f9796a;     // Catch: Throwable -> L107
        if (r114 == null) goto L109;
        ArrayList<byte[]> r115 = (ArrayList) com.ttnet.org.chromium.base.Reflect.on(r114).call("getOpaqueData").get();     // Catch: Throwable -> L107
    L110:
        if (r115 != null) goto L112;
    L114:
        c r116 = c.c();     // Catch: Throwable -> L295
        r116.getClass();     // Catch: Throwable -> L295
        Object r117 = r116.f9796a;     // Catch: Throwable -> L120
        if (r117 == null) goto L122;
        Map<String[], Pair<byte[], byte[]>> r118 = (Map) com.ttnet.org.chromium.base.Reflect.on(r117).call("getClientOpaqueData").get();     // Catch: Throwable -> L120
    L123:
        if (r118 != null) goto L125;
    L127:
        c r119 = c.c();     // Catch: Throwable -> L295
        r119.getClass();     // Catch: Throwable -> L295
        Object r120 = r119.f9796a;     // Catch: Throwable -> L133
        if (r120 == null) goto L135;
        Map r121 = (Map) com.ttnet.org.chromium.base.Reflect.on(r120).call("getQuicHint").get();     // Catch: Throwable -> L133
    L136:
        if (r121 != null) goto L138;
    L143:
        String r122 = "";
        r122 = r8.getCacheDir().getPath() + "/";     // Catch: Throwable -> L146
        r18.setStoragePath(r122 + TTNET_CACHE_DIR);     // Catch: Throwable -> L146
    L148:
        c r30 = c.c();     // Catch: Throwable -> L295
        r30.getClass();     // Catch: Throwable -> L295
        Object r31 = r30.f9796a;     // Catch: Throwable -> L154
        if (r31 == null) goto L156;
        boolean r32 = ((Boolean) com.ttnet.org.chromium.base.Reflect.on(r31).call("needCustomLoadLibrary").get()).booleanValue();     // Catch: Throwable -> L154
    L157:
        if (r32 == false) goto L159;
        r18.setLibraryLoader(new AnonymousClass1(this));     // Catch: Throwable -> L295
    L159:
        c r33 = c.c();     // Catch: Throwable -> L295
        r33.getClass();     // Catch: Throwable -> L295
        Object r34 = r33.f9796a;     // Catch: Throwable -> L165
        if (r34 == null) goto L167;
        String r35 = (String) com.ttnet.org.chromium.base.Reflect.on(r34).call("getCronetSoPath").get();     // Catch: Throwable -> L165
    L169:
        if (TextUtils.isEmpty(r35) == true) goto L211;
        String r36 = r35.substring(r35.lastIndexOf(File.separator) + 1);     // Catch: Throwable -> L295
        String r37 = r8.getCacheDir().getAbsolutePath();     // Catch: Throwable -> L295
        if (r5.f.b(r35) == false) goto L173;
    L208:
        boolean r38 = false;
    L209:
        if (r38 == false) goto L211;
        r18.setCronetSoPath(r37 + File.separator + r36);     // Catch: Throwable -> L295
        goto L211
    L173:
        if (r5.f.b(r37) == true) goto L208;
        if (r5.f.b(r36) == true) goto L208;
        FileInputStream r39 = new FileInputStream(r35);     // Catch: Throwable -> L188 Exception -> L190
    L346:
        r38 = t2.b.U(r39, r37, r36);     // Catch: Throwable -> L184 Exception -> L186
        r39.close();     // Catch: Exception -> L181 Throwable -> L295
    L181:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L295
        goto L209
    L186:
        e = e;
    L314:
        e.printStackTrace();     // Catch: Throwable -> L199
        if (r39 == null) goto L208;
        r39.close();     // Catch: Exception -> L196 Throwable -> L295
    L196:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L295
    L199:
        th = th;
        r29 = r39;
    L201:
        r39 = r29;
    L202:
        if (r39 != null) goto L338;
    L207:
        throw th;     // Catch: Throwable -> L295
    L338:
        r39.close();     // Catch: Exception -> L205 Throwable -> L295
    L205:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L295
    L184:
        th = th;
    L190:
        e = e;
        r39 = null;
    L188:
        th = th;
    L211:
        c r40 = c.c();     // Catch: Throwable -> L295
        r40.getClass();     // Catch: Throwable -> L295
        Object r41 = r40.f9796a;     // Catch: Throwable -> L217
        if (r41 == null) goto L219;
        boolean r42 = ((Boolean) com.ttnet.org.chromium.base.Reflect.on(r41).call("isBOEProxyEnabled").get()).booleanValue();     // Catch: Throwable -> L217
    L220:
        if (r42 == false) goto L222;
        r18.enableBoeProxy(true);     // Catch: Throwable -> L295
    L222:
        if (r42 == true) goto L234;
        String r43 = l7.a.a(r8);     // Catch: Throwable -> L295
        if (TextUtils.isEmpty(r43) == true) goto L234;
        JSONObject r44 = new JSONObject(r43);     // Catch: Throwable -> L232
        String r45 = r44.optString("ttnet_proxy", "");     // Catch: Throwable -> L232
        if (TextUtils.isEmpty(r45) == true) goto L228;
        r18.setProxyConfig(r45);     // Catch: Throwable -> L232
    L228:
        r42 = r44.optBoolean("boe_proxy_enabled", false);     // Catch: Throwable -> L232
        if (r42 == false) goto L234;
        r18.enableBoeProxy(true);     // Catch: Throwable -> L232
    L232:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L295
    L234:
        if (r42 == true) goto L238;
        r42 = l7.a.b(r8);     // Catch: Throwable -> L295
        if (r42 == false) goto L238;
        r18.enableBoeProxy(true);     // Catch: Throwable -> L295
    L238:
        if (r42 == false) goto L254;
        c r123 = c.c();     // Catch: Throwable -> L295
        r123.getClass();     // Catch: Throwable -> L295
        Object r124 = r123.f9796a;     // Catch: Throwable -> L245
        if (r124 == null) goto L247;
        String r125 = (String) com.ttnet.org.chromium.base.Reflect.on(r124).call("getBypassBOEJSON").get();     // Catch: Throwable -> L245
    L249:
        if (TextUtils.isEmpty(r125) == true) goto L251;
        r18.setBypassBOEJSON(r125);     // Catch: Throwable -> L295
    L251:
        String r126 = getProxyConfig(r122);     // Catch: Throwable -> L295
        if (TextUtils.isEmpty(r126) == true) goto L254;
        Log.e(TAG, "set proxy config: " + r126);     // Catch: Throwable -> L295
        r18.setProxyConfig(r126);     // Catch: Throwable -> L295
    L247:
        r125 = null;
    L245:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L295
    L254:
        c r127 = c.c();     // Catch: Throwable -> L295
        r127.getClass();     // Catch: Throwable -> L295
        Object r128 = r127.f9796a;     // Catch: Throwable -> L260
        if (r128 == null) goto L263;
        r28 = (String) com.ttnet.org.chromium.base.Reflect.on(r128).call("getStoreIdcRuleJSON").get();     // Catch: Throwable -> L260
        goto L263
    L263:
        if (TextUtils.isEmpty(r28) == true) goto L309;
        r18.setStoreIdcRuleJSON(r28);     // Catch: Throwable -> L295
    L309:
        long r129 = getALogFuncAddr();     // Catch: Exception -> L269 Throwable -> L295
        if (r129 == 0) goto L271;
        Log.e(TAG, "set alog address: " + r129);     // Catch: Exception -> L269 Throwable -> L295
        r18.setALogFuncAddr(r129);     // Catch: Exception -> L269 Throwable -> L295
    L271:
        long r130 = SystemClock.uptimeMillis();     // Catch: Throwable -> L295
        sCronetEngine = r18.build();     // Catch: Throwable -> L295
        y6.b.b().f14028s = SystemClock.uptimeMillis() - r130;     // Catch: Throwable -> L295
        if (d.a().loggerDebug() == false) goto L274;
        Logger.setLogLevel(2);     // Catch: Throwable -> L295
    L276:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L290;
        ExperimentalCronetEngine r46 = (ExperimentalCronetEngine) sCronetEngine;     // Catch: Throwable -> L295
        long r47 = getALogFuncAddr();     // Catch: Throwable -> L287
        if (r47 == 0) goto L281;
        Log.e(TAG, "ensure setting alog address: " + r47);     // Catch: Throwable -> L287
        r46.setAlogFuncAddr(r47);     // Catch: Throwable -> L287
    L281:
        int r48 = y6.a.f14000a.f14009a;     // Catch: Throwable -> L287
        if (r48 < 0) goto L285;
        if (r48 > 2) goto L285;
        r46.setAppStartUpState(r48);     // Catch: Throwable -> L287
    L285:
        y6.b.b().a(r8, r46.getOpaqueFuncAddress());     // Catch: Throwable -> L287
    L287:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L295
        goto L290
    L274:
        Logger.setLogLevel(4);     // Catch: Throwable -> L295
    L269:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L295
    L260:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L295
        goto L263
    L219:
        r42 = false;
    L217:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L295
    L167:
        r35 = null;
    L165:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L295
        goto L167
    L156:
        r32 = false;
    L154:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L295
        goto L156
    L146:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L295
        goto L148
    L138:
        if (r121.isEmpty() == true) goto L143;
        Iterator r131 = r121.entrySet().iterator();     // Catch: Throwable -> L295
    L141:
        if (r131.hasNext() == false) goto L143;
        Map.Entry r49 = (Map.Entry) r131.next();     // Catch: Throwable -> L295
        r18.addQuicHint((String) r49.getKey(), ((Integer) ((Pair) r49.getValue()).first).intValue(), ((Integer) ((Pair) r49.getValue()).second).intValue());     // Catch: Throwable -> L295
        goto L141
    L135:
        r121 = null;
    L133:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L295
        goto L135
    L125:
        if (r118.isEmpty() == true) goto L127;
        r18.setClientOpaqueData(r118);     // Catch: Throwable -> L295
        goto L127
    L122:
        r118 = null;
    L120:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L295
        goto L122
    L112:
        if (r115.isEmpty() == true) goto L114;
        r18.setOpaqueData(r115);     // Catch: Throwable -> L295
        goto L114
    L109:
        r115 = null;
    L107:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L295
        goto L109
    L60:
        monitor-enter(a.class);     // Catch: Throwable -> L295
    L66:
        th = move-exception;
        throw th;     // Catch: Throwable -> L295
    L62:
        if (a.f9791c != null) goto L64;
        a.f9791c = new a(r8);     // Catch: Throwable -> L66
    L64:
        monitor-exit(a.class);     // Catch: Throwable -> L66
    L54:
        r27 = false;
    L52:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L295
        goto L54
    L43:
        r24 = false;
    L41:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L295
        goto L43
    L32:
        r21 = false;
    L30:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L295
        goto L32
    L22:
        if (sNetworkThreadPriority > 19) goto L24;
        r18.setThreadPriority(sNetworkThreadPriority);     // Catch: Throwable -> L295
    L290:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L292;
        ExperimentalCronetEngine r50 = (ExperimentalCronetEngine) sCronetEngine;     // Catch: Throwable -> L295
        tryCreateRequestFinishedInfoListener(r15);     // Catch: Throwable -> L295
        r50.addRequestFinishedListener(sRequestFinishedInfoListener);     // Catch: Throwable -> L295
    L292:
        y6.b.b().f14019j = System.currentTimeMillis();     // Catch: Throwable -> L295
        monitor-exit(CronetClient.class);     // Catch: Throwable -> L295
    }

    private void tryCreateRequestFinishedInfoListener(final Executor r8) {
        if (sRequestFinishedInfoListener == null) goto L5;
        return;
    L5:
        monitor-enter(CronetClient.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sRequestFinishedInfoListener != null) goto L9;
        sRequestFinishedInfoListener = new AnonymousClass3(this, r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(CronetClient.class);     // Catch: Throwable -> L11
    }

    public static void tryStartNetDetect(String[] r8, int r10, int r11) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).tryStartNetDetect(r8, r10, r11);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static void ttDnsResolve(String r8, int r10, String r11) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).ttDnsResolve(r8, r10, r11);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static String[] ttUrlDispatch(String r8) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        Map<String, String> r10 = ((ExperimentalCronetEngine) sCronetEngine).ttUrlDispatch(r8);
        return new String[]{r10.get(URLDispatch.KEY_FINAL_URL), r10.get(URLDispatch.KEY_EPOCH), r10.get(URLDispatch.KEY_ETAG)};
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public String getCronetVersion() {
        return TTNetVersion.VERSION;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void getRequestMetrics(HttpURLConnection r8, Map<String, Object> r10) {
        if (r8 == null) goto L20;
        if (r10 != null) goto L6;
        return;
    L6:
        if ((r8 instanceof CronetHttpURLConnection) == true) goto L18;
        return;
    L18:
        CronetHttpURLConnection r11 = (CronetHttpURLConnection) r8;     // Catch: Throwable -> L15
        RequestFinishedInfo r12 = r11.getRequestFinishedInfo();     // Catch: Throwable -> L15
        if (r12 != null) goto L11;
    L13:
        r10.put(KEY_REQUEST_LOG, r11.getRequestLog());     // Catch: Throwable -> L15
        return;
    L11:
        if (r12.getMetrics() == null) goto L13;
        RequestFinishedInfo.Metrics r13 = r12.getMetrics();     // Catch: Throwable -> L15
        r10.put(ICronetClient.KEY_REMOTE_IP, r13.getPeerAddr() + BdimCategoryConstants.SEPARATOR_COLON + r13.getPeerPort());     // Catch: Throwable -> L15
        r10.put(ICronetClient.KEY_DNS_TIME, Long.valueOf(getCostTime(getTime(r13.getDnsEnd()), getTime(r13.getDnsStart()))));     // Catch: Throwable -> L15
        r10.put(ICronetClient.KEY_CONNECT_TIME, Long.valueOf(getCostTime(getTime(r13.getConnectEnd()), getTime(r13.getConnectStart()))));     // Catch: Throwable -> L15
        r10.put(ICronetClient.KEY_SSL_TIME, Long.valueOf(getCostTime(getTime(r13.getSslEnd()), getTime(r13.getSslStart()))));     // Catch: Throwable -> L15
        r10.put(ICronetClient.KEY_SEND_TIME, Long.valueOf(getCostTime(getTime(r13.getSendingEnd()), getTime(r13.getSendingStart()))));     // Catch: Throwable -> L15
        r10.put(ICronetClient.KEY_PUSH_TIME, Long.valueOf(getCostTime(getTime(r13.getPushEnd()), getTime(r13.getPushStart()))));     // Catch: Throwable -> L15
        r10.put(ICronetClient.KEY_RECEIVE_TIME, Long.valueOf(getCostTime(getTime(r13.getRequestEnd()), getTime(r13.getResponseStart()))));     // Catch: Throwable -> L15
        r10.put(ICronetClient.KEY_SOCKET_REUSED, Boolean.valueOf(r13.getSocketReused()));     // Catch: Throwable -> L15
        r10.put(ICronetClient.KEY_TTFB, Long.valueOf(getValue(r13.getTtfbMs())));     // Catch: Throwable -> L15
        r10.put(ICronetClient.KEY_TOTAL_TIME, Long.valueOf(getValue(r13.getTotalTimeMs())));     // Catch: Throwable -> L15
        r10.put(ICronetClient.KEY_SEND_BYTE_COUNT, Long.valueOf(getValue(r13.getSentByteCount())));     // Catch: Throwable -> L15
        r10.put(ICronetClient.KEY_RECEIVED_BYTE_COUNT, Long.valueOf(getValue(r13.getReceivedByteCount())));     // Catch: Throwable -> L15
        r10.put(ICronetClient.KEY_RETRY_ATTEMPTS, Long.valueOf(getValue(r13.getRetryAttempts())));     // Catch: Throwable -> L15
        r10.put(ICronetClient.KEY_REQUEST_HEADERS, r13.getRequestHeaders());     // Catch: Throwable -> L15
        r10.put(ICronetClient.KEY_RESPONSE_HEADERS, r13.getResponseHeaders());     // Catch: Throwable -> L15
        r10.put(ICronetClient.KEY_REQUEST_START, Long.valueOf(getTime(r13.getRequestStart())));     // Catch: Throwable -> L15
        r10.put(ICronetClient.KEY_POST_TASK_START, Long.valueOf(getTime(r13.getPostTaskStartMs())));     // Catch: Throwable -> L15
        r10.put(ICronetClient.KEY_WAIT_CONTEXT, Long.valueOf(getCostTime(getTime(r13.getRequestStart()), getTime(r13.getPostTaskStartMs()))));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public boolean isCronetHttpURLConnection(HttpURLConnection r8) {
        return r8 instanceof CronetHttpURLConnection;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public HttpURLConnection openConnection(Context r10, String r11, boolean r12, String r13, Executor r14) {
        tryCreateCronetEngine(r10, false, false, false, r12, r13, r14, false);     // Catch: Throwable -> L5
        return (HttpURLConnection) sCronetEngine.openConnection(new URL(r11));
    L5:
        th = move-exception;
        if ((th instanceof MalformedURLException) == false) goto L9;
        throw th;
    L9:
        if ((th instanceof UnsupportedOperationException) == false) goto L17;
        if (th.getMessage() == null) goto L17;
        if (th.getMessage().contains("Unexpected protocol") == false) goto L17;
        throw new IOException("MalformedURLException", th);
    L17:
        throw new IOException(th);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setCronetBootFailureChecker(ICronetClient.ICronetBootFailureChecker r8) {
        sCronetBootFailureChecker = r8;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setCronetEngine(Context r8, boolean r10, boolean r11, boolean r12, boolean r13, String r14, Executor r15, boolean r16) {
        tryCreateCronetEngine(r8, r10, r11, r12, r13, r14, r15, r16);
    }
}
