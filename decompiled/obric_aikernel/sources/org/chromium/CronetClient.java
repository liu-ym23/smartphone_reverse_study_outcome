package org.chromium;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.common.utility.io.FileUtils;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.cronet.TTAppStateManager;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetThreadConfig;
import com.bytedance.frameworks.baselib.network.http.cronet.a;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.TTDispatchResult;
import com.bytedance.frameworks.baselib.network.http.util.g;
import com.bytedance.retrofit2.mime.TTRequestCompressManager;
import com.bytedance.ttnet.TTALog;
import com.bytedance.ttnet.TTNetInit;
import com.ttnet.org.chromium.base.Logger;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.ExperimentalCronetEngine;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTAppSecurityManager;
import com.ttnet.org.chromium.net.TTNetVersion;
import com.ttnet.org.chromium.net.TTSamplingSettingProvider;
import com.ttnet.org.chromium.net.TTThreadConfigInfoProvider;
import com.ttnet.org.chromium.net.impl.CronetUrlRequest;
import com.ttnet.org.chromium.net.impl.CronetUrlRequestMapping;
import com.ttnet.org.chromium.net.impl.URLDispatch;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import e3.b;
import e3.c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UnknownFormatConversionException;
import java.util.concurrent.Executor;
import org.json.JSONObject;
import r2.h;

/* JADX INFO: loaded from: classes3.dex */
public class CronetClient implements ICronetClient {
    private static final String BORINGSSL_LIBRARY_NAME = "ttboringssl";
    private static final String CRYPTO_LIBRARY_NAME = "ttcrypto";
    private static final int INVALID_THREAD_PRIORITY = 20;
    private static final String KEY_CRASH_DETECT_INTERVAL_MS = "crash_detect_interval_ms";
    private static final String KEY_CRASH_LIMIT_TIMES = "crash_limit_times";
    private static final String KEY_REQUEST_LOG = "request_log";
    private static final String KEY_TTNET_CRASH_TIMES = "ttnet_crash_times";
    private static final String SP_SS_APP_CONFIG = "ss_app_config";
    public static final String TAG = "CronetClient";
    private static final String TTNET_ALOG_CLASS = "com.bytedance.ttnet.TTALog";
    private static final String TTNET_BOE_FLAG = "ttnet_boe.flag";
    private static final String TTNET_CACHE_DIR = "ttnet_storage/";
    private static final String TTNET_CONFIG_FILE = "ttnet_config.json";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private static int sAppID = 0;
    private static ICronetClient.ICronetBootFailureCheckerProvider sCronetBootFailureCheckerProvider = null;
    private static volatile CronetEngine sCronetEngine = null;
    private static volatile int sNetworkThreadPriority = 20;
    private static volatile RequestFinishedInfo.Listener sRequestFinishedInfoListener;
    private int mCrashDetectTimerInterval;
    private int mCrashLimitTimes;
    private int mTTNetCrashTimes;

    static {
    }

    public CronetClient() {
        this.mCrashLimitTimes = 0;
        this.mCrashDetectTimerInterval = 5000;
    }

    static /* synthetic */ long access$000(long r10, long r11) {
        return getCostTime(r10, r11);
    }

    private TTAppInfoProvider.AppInfo convertToCronetAppInfo(a r10) {
        TTAppInfoProvider.AppInfo r11 = new TTAppInfoProvider.AppInfo();
        r11.setAbSdkVersion(r10.f1610a);
        r11.setHostFirst(r10.f1611b);
        r11.setHostSecond(r10.f1612c);
        r11.setHostThird(r10.f1613d);
        r11.setDomainHttpDns(r10.f1614e);
        r11.setDomainBoe(r10.f1615f);
        r11.setDomainBoeHttps(r10.f1616g);
        r11.setInitRegion(r10.f1617h);
        return r11;
    }

    private static TTSamplingSettingProvider.TTSlaSamplingSetting convertToCronetSlaSamplingSetting(b r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        TTSamplingSettingProvider.TTSlaSamplingRule r11 = new TTSamplingSettingProvider.TTSlaSamplingRule();
        e3.a r12 = r10.c();
        r11.mEnableBaseApiAll = r12.b();
        r11.mEnableApiAllUpload = r12.a();
        r11.mUrlRegexBlackList = r12.h();
        r11.mPathEqualWhiteList = r12.e();
        r11.mPathPrefixWhiteList = r12.f();
        r11.mPathContainWhiteList = r12.d();
        r11.mPathRegexWhiteList = r12.g();
        r11.mHostPatternWhiteList = r12.c();
        r11.mUrlRegexWhiteList = r12.i();
        TTSamplingSettingProvider.TTSlaSamplingSetting r13 = new TTSamplingSettingProvider.TTSlaSamplingSetting();
        r13.mHostAid = r10.a();
        r13.mSdkAid = r10.b();
        r13.mSlaSamplingRule = r11;
        return r13;
    }

    private void detectCronetColdStartCrash(final Context r11, ExperimentalCronetEngine.Builder r12) {
        SharedPreferences r10 = r11.getSharedPreferences(SP_SS_APP_CONFIG, 0);
        int r13 = r10.getInt(KEY_CRASH_LIMIT_TIMES, 0);
        this.mCrashLimitTimes = r13;
        if (r13 > 0) goto L8;
        int r14 = r10.getInt(KEY_TTNET_CRASH_TIMES, 0);
        this.mTTNetCrashTimes = r14;
        if (r14 <= 0) goto L28;
        SharedPreferences.Editor r15 = r10.edit();
        r15.putInt(KEY_TTNET_CRASH_TIMES, 0);
        r15.apply();
        return;
    L28:
        return;
    L8:
        this.mTTNetCrashTimes = r10.getInt(KEY_TTNET_CRASH_TIMES, 0);
        int r16 = r10.getInt(KEY_CRASH_DETECT_INTERVAL_MS, 5000);
        this.mCrashDetectTimerInterval = r16;
        if (r16 > 0) goto L12;
        this.mCrashDetectTimerInterval = 5000;
    L12:
        if (Logger.debug() == false) goto L15;
        Logger.d(TAG, "processname is " + g.a(r11) + " count is " + this.mTTNetCrashTimes + " limit is " + this.mCrashLimitTimes + " interval is " + this.mCrashDetectTimerInterval);
    L15:
        if (this.mTTNetCrashTimes < this.mCrashLimitTimes) goto L21;
        if (Logger.debug() == false) goto L19;
        Logger.d(TAG, "processname is " + g.a(r11) + "set secure mode true");
    L19:
        r12.enableTncSecureMode(true);
    L21:
        if (g.h(r11) == true) goto L23;
        return;
    L23:
        final SharedPreferences.Editor r17 = r10.edit();
        int r18 = this.mTTNetCrashTimes + 1;
        this.mTTNetCrashTimes = r18;
        r17.putInt(KEY_TTNET_CRASH_TIMES, r18);
        r17.commit();
        if (Logger.debug() == false) goto L26;
        Logger.d(TAG, "processname is " + g.a(r11) + " save count " + this.mTTNetCrashTimes);
    L26:
        j2.b r19 = j2.b.d(NetworkAsyncTaskType.NETWORK);
        final long r20 = this.mCrashDetectTimerInterval;
        final long r21 = 0;
        r19.e(new AnonymousClass1(this, r20, r21, r11, r17));
    }

    private static long getALogFuncAddr() {
        return ((Long) Reflect.on(TTALog.class.newInstance()).call("getALogFuncAddr").get()).longValue();
    }

    private static int getAppSecurityLevel() {
        String r10 = TTNetInit.DOMAIN_HTTPDNS_KEY;     // Catch: Exception -> L4
        return ((Integer) Reflect.on(TTNetInit.class.newInstance()).call("getAppSecurityLevel").get()).intValue();
    L4:
        return 0;
    }

    private static long getCostTime(long r10, long r11) {
        if (r11 != (-1)) goto L5;
    L11:
        return -1;
    L5:
        if (r10 == (-1)) goto L11;
        if (r11 > r10) goto L11;
        return r10 - r11;
    }

    public static CronetEngine getCronetEngine() {
        Objects.requireNonNull(sCronetEngine, "Cronet engine is null.");
        return sCronetEngine;
    }

    private static String getDomainConfigByRegion() {
        String r10 = CronetAppProviderManager.inst().getCarrierRegion();
        String r11 = CronetAppProviderManager.inst().getSysRegion();
        String r12 = CronetAppProviderManager.inst().getRegion();
        if (TextUtils.isEmpty(r10) == false) goto L10;
        if (TextUtils.isEmpty(r11) == true) goto L8;
        r10 = r11;
        goto L10
    L8:
        r10 = r12;
    L10:
        if (TextUtils.isEmpty(r10) == false) goto L15;
        return null;
    L15:
        String r13 = TTNetInit.DOMAIN_HTTPDNS_KEY;     // Catch: Exception -> L14
        return (String) Reflect.on(TTNetInit.class.newInstance()).call("getGetDomainConfigByRegion", new Class[]{String.class}, new Object[]{r10}).get();
    L14:
        return null;
    }

    private static boolean getListenAppStateIndependently() {
        String r10 = TTNetInit.DOMAIN_HTTPDNS_KEY;     // Catch: Exception -> L4
        return ((Boolean) Reflect.on(TTNetInit.class.newInstance()).call("getListenAppStateIndependently").get()).booleanValue();
    L4:
        return false;
    }

    private static long getMaxHttpDiskCacheSize() {
        String r10 = TTNetInit.DOMAIN_HTTPDNS_KEY;     // Catch: Exception -> L4
        return ((Long) Reflect.on(TTNetInit.class.newInstance()).call("getMaxHttpDiskCacheSize").get()).longValue();
    L4:
        return 67108864;
    }

    private String getProxyConfig(String r10) {
        String r11 = "";
        if (TextUtils.isEmpty(r10) == true) goto L34;
        BufferedReader r12 = null;
        File r13 = new File(r10 + TTNET_CONFIG_FILE);     // Catch: Throwable -> L21
        if (r13.exists() == false) goto L16;
        BufferedReader r14 = new BufferedReader(new FileReader(r13));     // Catch: Throwable -> L21
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L14
    L9:
        String r16 = r14.readLine();     // Catch: Throwable -> L14
        if (r16 == null) goto L12;
        r15.append(r16);     // Catch: Throwable -> L14
        goto L9
    L12:
        r11 = new JSONObject(r15.toString()).optString("ttnet_proxy", "");     // Catch: Throwable -> L14
        r12 = r14;
    L14:
        Throwable th = th;
    L42:
        th.printStackTrace();     // Catch: Throwable -> L27
        if (r14 == null) goto L34;
        r14.close();     // Catch: IOException -> L19
    L37:
    L27:
        th = move-exception;
        if (r14 != null) goto L40;
    L33:
        throw th;
    L40:
        r14.close();     // Catch: IOException -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L16:
        if (r12 == null) goto L34;
        r12.close();     // Catch: IOException -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
    L21:
        th = move-exception;
        r14 = null;
        th = th;
    L34:
        return r11;
    }

    private static JSONObject getSlaSamplingSetting() {
        String r10 = TTNetInit.DOMAIN_HTTPDNS_KEY;     // Catch: Exception -> L4
        return (JSONObject) Reflect.on(TTNetInit.class.newInstance()).call("getSlaSamplingSetting").get();
    L4:
        return null;
    }

    private static TTNetThreadConfig.a getThreadConfigCallbackImpl() {
        String r10 = TTNetInit.DOMAIN_HTTPDNS_KEY;     // Catch: Exception -> L4
        return (TTNetThreadConfig.a) Reflect.on(TTNetInit.class.newInstance()).call("getThreadConfigCallbackImpl").get();
    L4:
        return null;
    }

    private static ArrayList<TTNetThreadConfig> getThreadConfigInfoList() {
        String r10 = TTNetInit.DOMAIN_HTTPDNS_KEY;     // Catch: Exception -> L4
        return (ArrayList) Reflect.on(TTNetInit.class.newInstance()).call("getThreadConfigInfoList").get();
    L4:
        return null;
    }

    private static long getTime(Date r10) {
        if (r10 != null) goto L6;
        return -1;
    L6:
        return r10.getTime();
    }

    private static long getValue(Long r10) {
        if (r10 != null) goto L6;
        return -1;
    L6:
        return r10.longValue();
    }

    public static void setAppStartUpState(int r10) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setAppStartUpState(r10);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static void setNetworkThreadPriority(int r10) {
        sNetworkThreadPriority = r10;
    }

    private void tryCreateRequestFinishedInfoListener(final Executor r10) {
        if (sRequestFinishedInfoListener == null) goto L5;
        return;
    L5:
        monitor-enter(CronetClient.class);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (sRequestFinishedInfoListener == null) goto L10;
        monitor-exit(CronetClient.class);     // Catch: Throwable -> L13
        return;
    L10:
        sRequestFinishedInfoListener = new AnonymousClass5(this, r10);     // Catch: Throwable -> L13
        monitor-exit(CronetClient.class);     // Catch: Throwable -> L13
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void addClientOpaqueData(String[] r10, byte[] r11, byte[] r12, long r13, long r14) {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (CronetDependManager.inst().loggerDebug() == false) goto L6;
        CronetDependManager.inst().loggerD(TAG, "addClientOpaqueData start");     // Catch: Throwable -> L9
    L6:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L14;
        ((ExperimentalCronetEngine) sCronetEngine).addClientOpaqueData(r10, r11, r12, r13, r14);     // Catch: Throwable -> L9
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void bindBigCore(TTNetThreadConfig.ThreadType r10) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).bindBigCore(r10.ordinal());
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void bindLittleCore(TTNetThreadConfig.ThreadType r10) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).bindLittleCore(r10.ordinal());
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void clearClientOpaqueData() {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (CronetDependManager.inst().loggerDebug() == false) goto L6;
        CronetDependManager.inst().loggerD(TAG, "clearClientOpaqueData start");     // Catch: Throwable -> L9
    L6:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L14;
        ((ExperimentalCronetEngine) sCronetEngine).clearClientOpaqueData();     // Catch: Throwable -> L9
        return;
    }

    TTThreadConfigInfoProvider.Callback convertToCronetThreadConfigCallback(final TTNetThreadConfig.a r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new AnonymousClass2(this, r10);
    }

    ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> convertToCronetThreadConfigInfoList(ArrayList<TTNetThreadConfig> r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.isEmpty() == true) goto L31;
        ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r11 = new ArrayList();
        EnumSet r12 = EnumSet.noneOf(TTNetThreadConfig.ThreadType.class);
        Iterator<TTNetThreadConfig> r13 = r10.iterator();
    L8:
        if (r13.hasNext() == false) goto L21;
        TTNetThreadConfig r14 = r13.next();
        int r15 = r14.f1609b;
        if (r15 >= (-20)) goto L12;
    L14:
        boolean r16 = false;
    L15:
        if (r16 == false) goto L8;
        if (r12.contains(r14.f1608a) == true) goto L8;
        TTThreadConfigInfoProvider.ThreadConfigInfo r17 = new TTThreadConfigInfoProvider.ThreadConfigInfo();
        r17.setThreadType(TTThreadConfigInfoProvider.ThreadType.values()[r14.f1608a.ordinal()]);
        r17.setThreadPriority(r14.f1609b);
        r11.add(r17);
        r12.add(r14.f1608a);
        goto L8
    L12:
        if (r15 > 19) goto L14;
        r16 = true;
        goto L15
    L21:
        return r11;
    L31:
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void enableTTBizHttpDns(boolean r10, String r11, String r12, String r13, boolean r14, String r15) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).enableTTBizHttpDns(r10, r11, r12, r13, r14, r15);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getCronetInternalErrorCode(HttpURLConnection r10) {
        if ((r10 instanceof CronetHttpURLConnection) == true) goto L6;
        return 0;
    L6:
        return ((CronetHttpURLConnection) r10).getCronetInternalErrorCode();
    L11:
        return 0;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public String getCronetVersion() {
        return TTNetVersion.VERSION;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getEffectiveConnectionType() {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return ((ExperimentalCronetEngine) sCronetEngine).getEffectiveConnectionType();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getEffectiveHttpRttMs() {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return ((ExperimentalCronetEngine) sCronetEngine).getEffectiveHttpRtt();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getEffectiveRxThroughputKbps() {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return ((ExperimentalCronetEngine) sCronetEngine).getEffectiveRxThroughput();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getEffectiveTransportRttMs() {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return ((ExperimentalCronetEngine) sCronetEngine).getEffectiveTransportRtt();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public Map<String, r2.g> getGroupRttEstimates() {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L14;
        ExperimentalCronetEngine r10 = (ExperimentalCronetEngine) sCronetEngine;
        HashMap r11 = new HashMap();
        Iterator<Map.Entry<String, int[]>> r12 = r10.getGroupRttEstimates().entrySet().iterator();
    L6:
        if (r12.hasNext() == false) goto L12;
        Map.Entry<String, int[]> r13 = r12.next();
        if (r13.getValue().length != 2) goto L11;
        r2.g r14 = new r2.g();
        int r15 = r13.getValue()[0];
        int r16 = r13.getValue()[1];
        r11.put(r13.getKey(), r14);
        goto L6
    L11:
        throw new UnknownFormatConversionException("getGroupRttEstimates returns wrong format");
    L12:
        return r11;
    L14:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void getMappingRequestState(final String r10) {
        CronetUrlRequest r11 = CronetUrlRequestMapping.GetRequest(r10);     // Catch: Throwable -> L6
        if (r11 == null) goto L11;
        r11.getStatus(new AnonymousClass6(this, r10));     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public r2.g getNetworkQuality() {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ExperimentalCronetEngine r10 = (ExperimentalCronetEngine) sCronetEngine;
        r2.g r11 = new r2.g();
        r10.getTransportRttMs();
        r10.getHttpRttMs();
        r10.getDownstreamThroughputKbps();
        return r11;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getNetworkQualityLevel() {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return ((ExperimentalCronetEngine) sCronetEngine).getNetworkQualityLevel();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public h getPacketLossRateMetrics(int r10) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        h r11 = new h();
        ExperimentalCronetEngine r12 = (ExperimentalCronetEngine) sCronetEngine;
        r12.getUpstreamPacketLossRate(r10);
        r12.getUpstreamPacketLossRateVariance(r10);
        r12.getDownstreamPacketLossRate(r10);
        r12.getDownstreamPacketLossRateVariance(r10);
        return r11;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public Map<String, Object> getRequestMetricsMap(HttpURLConnection r10) {
        LinkedHashMap r11 = null;
        if (r10 != null) goto L6;
        return null;
    L6:
        if (isCronetHttpURLConnection(r10) == true) goto L22;
        return null;
    L22:
        CronetHttpURLConnection r12 = (CronetHttpURLConnection) r10;     // Catch: Throwable -> L17
        RequestFinishedInfo r13 = r12.getRequestFinishedInfo();     // Catch: Throwable -> L17
        LinkedHashMap r14 = new LinkedHashMap();     // Catch: Throwable -> L17
        if (r13 != null) goto L20;
    L13:
        r14.put("request_log", r12.getRequestLog());     // Catch: Throwable -> L15
        return r14;
    L15:
        th = th;
        r11 = r14;
    L18:
        th.printStackTrace();
        return r11;
    L20:
        if (r13.getMetrics() == null) goto L13;
        RequestFinishedInfo.Metrics r15 = r13.getMetrics();     // Catch: Throwable -> L15
        r14.put(ICronetClient.KEY_REMOTE_IP, r15.getPeerAddr() + ":" + r15.getPeerPort());     // Catch: Throwable -> L15
        r14.put(ICronetClient.KEY_DNS_TIME, Long.valueOf(getCostTime(getTime(r15.getDnsEnd()), getTime(r15.getDnsStart()))));     // Catch: Throwable -> L15
        r14.put(ICronetClient.KEY_CONNECT_TIME, Long.valueOf(getCostTime(getTime(r15.getConnectEnd()), getTime(r15.getConnectStart()))));     // Catch: Throwable -> L15
        r14.put(ICronetClient.KEY_SSL_TIME, Long.valueOf(getCostTime(getTime(r15.getSslEnd()), getTime(r15.getSslStart()))));     // Catch: Throwable -> L15
        r14.put(ICronetClient.KEY_SEND_TIME, Long.valueOf(getCostTime(getTime(r15.getSendingEnd()), getTime(r15.getSendingStart()))));     // Catch: Throwable -> L15
        r14.put(ICronetClient.KEY_PUSH_TIME, Long.valueOf(getCostTime(getTime(r15.getPushEnd()), getTime(r15.getPushStart()))));     // Catch: Throwable -> L15
        r14.put(ICronetClient.KEY_RECEIVE_TIME, Long.valueOf(getCostTime(getTime(r15.getRequestEnd()), getTime(r15.getResponseStart()))));     // Catch: Throwable -> L15
        r14.put(ICronetClient.KEY_SOCKET_REUSED, Boolean.valueOf(r15.getSocketReused()));     // Catch: Throwable -> L15
        r14.put(ICronetClient.KEY_TTFB, Long.valueOf(getValue(r15.getTtfbMs())));     // Catch: Throwable -> L15
        r14.put(ICronetClient.KEY_TOTAL_TIME, Long.valueOf(getValue(r15.getTotalTimeMs())));     // Catch: Throwable -> L15
        r14.put(ICronetClient.KEY_SEND_BYTE_COUNT, Long.valueOf(getValue(r15.getSentByteCount())));     // Catch: Throwable -> L15
        r14.put(ICronetClient.KEY_RECEIVED_BYTE_COUNT, Long.valueOf(getValue(r15.getReceivedByteCount())));     // Catch: Throwable -> L15
        r14.put(ICronetClient.KEY_RETRY_ATTEMPTS, Long.valueOf(getValue(r15.getRetryAttempts())));     // Catch: Throwable -> L15
        r14.put(ICronetClient.KEY_REQUEST_HEADERS, r15.getRequestHeaders());     // Catch: Throwable -> L15
        r14.put(ICronetClient.KEY_RESPONSE_HEADERS, r15.getResponseHeaders());     // Catch: Throwable -> L15
        r14.put(ICronetClient.KEY_REQUEST_START, Long.valueOf(getTime(r15.getRequestStart())));     // Catch: Throwable -> L15
        r14.put(ICronetClient.KEY_POST_TASK_START, Long.valueOf(getTime(r15.getPostTaskStartMs())));     // Catch: Throwable -> L15
        r14.put(ICronetClient.KEY_WAIT_CONTEXT, Long.valueOf(getCostTime(getTime(r15.getRequestStart()), getTime(r15.getPostTaskStartMs()))));     // Catch: Throwable -> L15
        r14.put(ICronetClient.KEY_UPPER_ADD_COOKIE_US, r15.getAddCookieCostUs());     // Catch: Throwable -> L15
        r14.put(ICronetClient.KEY_UPPER_SAVE_COOKIE_US, r15.getSaveCookieCostUs());     // Catch: Throwable -> L15
        r14.put(ICronetClient.KEY_REQ_COOKIE_SOURCE_TYPE, r15.getRequestCookieSource());     // Catch: Throwable -> L15
        r14.put(ICronetClient.KEY_PRE_SAMPLING_REPORTABLE, Boolean.valueOf(r15.getPreSamplingReportable()));     // Catch: Throwable -> L15
        r14.put(ICronetClient.KEY_BYPASS_API_REPORT, Boolean.valueOf(r15.getBypassApiReport()));     // Catch: Throwable -> L15
    L17:
        th = th;
        goto L18
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public boolean isCronetHttpURLConnection(HttpURLConnection r10) {
        return r10 instanceof CronetHttpURLConnection;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void notifyStoreRegionUpdated(String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).updateStoreRegionFromServer(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public boolean notifySwitchToMultiNetwork(boolean r10) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).notifySwitchToMultiNetwork(r10);
        return true;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void notifyTNCConfigUpdated(String r10, String r11, String r12, String r13, String r14, String r15) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).notifyTNCConfigUpdated(r10, r11, r12, r13, r14, r15);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public HttpURLConnection openConnection(Context r13, String r14, boolean r15, String r16, boolean r17, Executor r18, ICronetAppProvider r19) {
    L7:
        th = move-exception;
        if ((th instanceof MalformedURLException) == false) goto L11;
        throw th;
    L11:
        if ((th instanceof UnsupportedOperationException) == false) goto L19;
        if (th.getMessage() == null) goto L19;
        if (th.getMessage().contains("Unexpected protocol") == false) goto L19;
        throw new IOException("MalformedURLException", th);
    L19:
        throw new IOException(th);
    L3:
        if (TTNetInitMetrics.k().f1524a != TTNetInitMetrics.CronetInitMode.NONE) goto L5;
        TTNetInitMetrics r10 = TTNetInitMetrics.k();     // Catch: Throwable -> L7
        r10.f1524a = TTNetInitMetrics.CronetInitMode.LAZY_INIT;     // Catch: Throwable -> L7
    L5:
        tryCreateCronetEngine(r13, false, false, false, r15, r16, r18, false, r19);     // Catch: Throwable -> L7
        return (HttpURLConnection) sCronetEngine.openConnection(new URL(r14), Proxy.NO_PROXY, r17);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void preconnectUrl(String r10, Map<String, String> r11) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).preconnectUrl(r10, 1, r11);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void removeClientOpaqueData(String r10) {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (CronetDependManager.inst().loggerDebug() == false) goto L6;
        CronetDependManager.inst().loggerD(TAG, "removeClientOpaqueData start");     // Catch: Throwable -> L9
    L6:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L14;
        ((ExperimentalCronetEngine) sCronetEngine).removeClientOpaqueData(r10);     // Catch: Throwable -> L9
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void reportNetDiagnosisUserLog(String r10) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).reportNetDiagnosisUserLog(r10);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void resetCoreBind(TTNetThreadConfig.ThreadType r10) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).resetCoreBind(r10.ordinal());
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void runInBackGround(boolean r10) {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (CronetDependManager.inst().loggerDebug() == false) goto L6;
        CronetDependManager.inst().loggerD(TAG, "runInBackGround start");     // Catch: Throwable -> L9
    L6:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L14;
        ((ExperimentalCronetEngine) sCronetEngine).runInBackGround(r10);     // Catch: Throwable -> L9
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setAlogFuncAddr(long r10) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setAlogFuncAddr(r10);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setBestHostWithRouteSelectionName(String r10, String r11) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setRouteSelectionBestHost(r10, r11);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setCookieInitCompleted() {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setCookieInitCompleted();
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setCronetBootFailureCheckerProvider(ICronetClient.ICronetBootFailureCheckerProvider r10) {
        sCronetBootFailureCheckerProvider = r10;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setHostResolverRules(String r10) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setHostResolverRules(r10);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setHttpDnsForTesting(boolean r10, boolean r11, boolean r12) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setProxy(String r10) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setProxy(r10);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setSlaSamplingSetting(JSONObject r10) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L10;
        TTSamplingSettingProvider.TTSlaSamplingSetting r11 = convertToCronetSlaSamplingSetting(c.a(r10, sAppID));
        if (r11 != null) goto L7;
        return;
    L7:
        ((ExperimentalCronetEngine) sCronetEngine).addSamplingSetting(r11);
        return;
    L10:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setZstdFuncAddr(long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setZstdFuncAddr(r19, r21, r23, r25, r27, r29, r31, r33);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void startThrottle(String[] r10, int r11, long r12) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).startThrottle(r10, r11, r12);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void stopThrottle(String[] r10, int r11) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).stopThrottle(r10, r11);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void triggerGetDomain(boolean r10) {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (CronetDependManager.inst().loggerDebug() == false) goto L6;
        CronetDependManager.inst().loggerD(TAG, "triggerGetDomain start");     // Catch: Throwable -> L9
    L6:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L14;
        ((ExperimentalCronetEngine) sCronetEngine).triggerGetDomain(r10);     // Catch: Throwable -> L9
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void triggerSwitchingToCellular() {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).triggerWiFiToCellularByThirdParty();
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void tryCreateCronetEngine(Context r17, boolean r18, boolean r19, boolean r20, boolean r21, String r22, Executor r23, boolean r24, ICronetAppProvider r25) {
        if (sCronetEngine == null) goto L5;
        return;
    L5:
        monitor-enter(CronetClient.class);
    L155:
        th = move-exception;
        throw th;
    L7:
        if (sCronetEngine != null) goto L150;
        Log.w(TAG, "CronetClient tryCreateCronetEngine");     // Catch: Throwable -> L155
        TTNetInitMetrics.k().f1534k = System.currentTimeMillis();     // Catch: Throwable -> L155
        TTNetInitMetrics.k().f1535l = System.nanoTime();     // Catch: Throwable -> L155
        if (r24 == true) goto L17;
        ICronetClient.ICronetBootFailureCheckerProvider r10 = sCronetBootFailureCheckerProvider;     // Catch: Throwable -> L155
        if (r10 == null) goto L17;
        if (r10.isCronetBootFailureExpected() == true) goto L17;
        Log.w(TAG, "isCronetBootFailureExpected return false.");     // Catch: Throwable -> L155
        throw new IllegalArgumentException("isCronetBootFailureExpected return false.");     // Catch: Throwable -> L155
    L17:
        TTNetInitMetrics.k().f1536m = System.nanoTime();     // Catch: Throwable -> L155
        boolean r11 = CronetAppProviderManager.inst().getOptInit();     // Catch: Throwable -> L155
        a r12 = null;
        if (r11 == false) goto L20;
        r12 = r25.getAppInfoSubset();     // Catch: Throwable -> L155
    L20:
        a r13 = r12;
        TTNetInitMetrics.k().f1537n = System.nanoTime();     // Catch: Throwable -> L155
        TTNetInitMetrics.k().f1538o = TTNetInitMetrics.k().f1537n;     // Catch: Throwable -> L155
        ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r14 = convertToCronetThreadConfigInfoList(getThreadConfigInfoList());     // Catch: Throwable -> L155
        TTNetInitMetrics.k().f1539p = System.nanoTime();     // Catch: Throwable -> L155
        TTNetInitMetrics.k().f1540q = TTNetInitMetrics.k().f1539p;     // Catch: Throwable -> L155
        TTThreadConfigInfoProvider.Callback r15 = convertToCronetThreadConfigCallback(getThreadConfigCallbackImpl());     // Catch: Throwable -> L155
        TTNetInitMetrics.k().f1541r = System.nanoTime();     // Catch: Throwable -> L155
        TTNetInitMetrics.k().f1542s = TTNetInitMetrics.k().f1541r;     // Catch: Throwable -> L155
        sAppID = Integer.parseInt(r25.getAppId());     // Catch: Exception -> L159 Throwable -> L155
    L22:
        TTSamplingSettingProvider.TTSlaSamplingSetting r16 = convertToCronetSlaSamplingSetting(c.a(getSlaSamplingSetting(), sAppID));     // Catch: Throwable -> L155
        TTNetInitMetrics.k().f1543t = System.nanoTime();     // Catch: Throwable -> L155
        TTNetInitMetrics.k().f1544u = TTNetInitMetrics.k().f1543t;     // Catch: Throwable -> L155
        ExperimentalCronetEngine.Builder r110 = new ExperimentalCronetEngine.Builder(r17, r11).enableQuic(r18).enableHttp2(r19).enableSdch(r20).enableHttpDns(r21).listenAppStateIndependently(getListenAppStateIndependently()).enableNetworkQualityEstimator(true);     // Catch: Throwable -> L155
        if (CronetDependManager.inst().loggerDebug() == false) goto L25;
        r110.enableVerboseLog();     // Catch: Throwable -> L155
    L25:
        r110.setTTNetInitStart(Math.min(TTNetInitMetrics.k().f1528e, TTNetInitMetrics.k().f1535l));     // Catch: Throwable -> L155
        detectCronetColdStartCrash(r17, r110);     // Catch: Throwable -> L155
        String r111 = "";
        r111 = r17.getCacheDir().getPath() + "/";     // Catch: Throwable -> L28
        r110.setStoragePath(r111 + TTNET_CACHE_DIR);     // Catch: Throwable -> L28
        r110.enableHttpCache(3, getMaxHttpDiskCacheSize());     // Catch: Throwable -> L28
    L31:
        if (sNetworkThreadPriority >= (-20)) goto L33;
    L35:
        int r26 = getAppSecurityLevel();     // Catch: Throwable -> L155
        if (r26 <= 0) goto L39;
        r110.setAppSecurityLevel(r26);     // Catch: Throwable -> L155
    L39:
        if (CronetAppProviderManager.inst().isEnableBrotli() == false) goto L42;
        r110.enableBrotli(true);     // Catch: Throwable -> L155
    L42:
        if (CronetAppProviderManager.inst().isEnableQuic() == false) goto L45;
        r110.enableQuic(true);     // Catch: Throwable -> L155
    L45:
        if (CronetAppProviderManager.inst().isEnableHttp2() == false) goto L47;
        r110.enableHttp2(true);     // Catch: Throwable -> L155
    L47:
        TTAppSecurityManager.getInstance().setSystemApiSandbox(CronetSystemApiSandbox.inst());     // Catch: Throwable -> L155
        r110.setAppInfoProvider(CronetAppInfoProvider.inst(r17));     // Catch: Throwable -> L155
        r110.setEventListener(CronetEventListener.inst());     // Catch: Throwable -> L155
        r110.setIsMainProcess(g.h(r17));     // Catch: Throwable -> L155
        r110.setProcessName(g.a(r17));     // Catch: Throwable -> L155
        if (g.h(r17) == false) goto L50;
        r110.setAppMonitorProvider(CronetAppMonitorProvider.inst());     // Catch: Throwable -> L155
        CronetEventListener.inst().setIsMainProcess(true);     // Catch: Throwable -> L155
    L50:
        if (r11 == false) goto L52;
        r110.setTTAppInfoColdStartSubset(convertToCronetAppInfo(r13));     // Catch: Throwable -> L155
    L52:
        r110.setOptInit(r11);     // Catch: Throwable -> L155
        r110.setOptNqeInit(r25.getOptNqeDefault(), r25.getOptNqePersist());     // Catch: Throwable -> L155
        r110.setThreadConfigInfoList(r14);     // Catch: Throwable -> L155
        r110.setThreadConfigCallbackImpl(r15);     // Catch: Throwable -> L155
        r110.setLazyInitIPC(r25.getLazyInitCronetIPC());     // Catch: Throwable -> L155
        if (TextUtils.isEmpty(r22) == true) goto L55;
        r110.setUserAgent(r22 + " cronet/" + TTNetVersion.VERSION);     // Catch: Throwable -> L155
    L55:
        String r27 = getDomainConfigByRegion();     // Catch: Throwable -> L155
        if (TextUtils.isEmpty(r27) == false) goto L59;
        r27 = CronetAppProviderManager.inst().getGetDomainDefaultJSON();     // Catch: Throwable -> L155
    L59:
        if (TextUtils.isEmpty(r27) == true) goto L61;
        r110.setGetDomainDefaultJSON(r27);     // Catch: Throwable -> L155
    L61:
        ArrayList<byte[]> r28 = CronetAppProviderManager.inst().getOpaqueData();     // Catch: Throwable -> L155
        if (r28 != null) goto L64;
    L66:
        Map<String[], Pair<byte[], byte[]>> r29 = CronetAppProviderManager.inst().getClientOpaqueData();     // Catch: Throwable -> L155
        if (r29 != null) goto L69;
    L71:
        Map<String, Pair<Integer, Integer>> r30 = CronetAppProviderManager.inst().getQuicHint();     // Catch: Throwable -> L155
        if (r30 == null) goto L80;
        if (r30.isEmpty() == true) goto L80;
        Iterator<Map.Entry<String, Pair<Integer, Integer>>> r31 = r30.entrySet().iterator();     // Catch: Throwable -> L155
    L77:
        if (r31.hasNext() == false) goto L80;
        Map.Entry<String, Pair<Integer, Integer>> r32 = r31.next();     // Catch: Throwable -> L155
        r110.addQuicHint(r32.getKey(), ((Integer) r32.getValue().first).intValue(), ((Integer) r32.getValue().second).intValue());     // Catch: Throwable -> L155
    L80:
        if (CronetAppProviderManager.inst().needCustomLoadLibrary() == false) goto L82;
        r110.setLibraryLoader(new AnonymousClass3(this));     // Catch: Throwable -> L155
    L82:
        String r33 = CronetAppProviderManager.inst().getCronetSoPath();     // Catch: Throwable -> L155
        if (TextUtils.isEmpty(r33) == true) goto L87;
        String r34 = File.separator;     // Catch: Throwable -> L155
        String r35 = r33.substring(r33.lastIndexOf(r34) + 1);     // Catch: Throwable -> L155
        String r36 = r17.getCacheDir().getAbsolutePath();     // Catch: Throwable -> L155
        if (FileUtils.a(r33, r36, r35) == false) goto L87;
        r110.setCronetSoPath(r36 + r34 + r35);     // Catch: Throwable -> L155
    L87:
        boolean r37 = CronetAppProviderManager.inst().isBOEProxyEnabled();     // Catch: Throwable -> L155
        if (r37 == false) goto L90;
        r110.enableBoeProxy(true);     // Catch: Throwable -> L155
    L90:
        if (r37 == true) goto L102;
        String r38 = com.bytedance.frameworks.baselib.network.http.util.c.c(r17, TTNET_CONFIG_FILE);     // Catch: Throwable -> L155
        if (TextUtils.isEmpty(r38) == true) goto L102;
        JSONObject r39 = new JSONObject(r38);     // Catch: Throwable -> L100
        String r40 = r39.optString("ttnet_proxy", "");     // Catch: Throwable -> L100
        if (TextUtils.isEmpty(r40) == true) goto L96;
        r110.setProxyConfig(r40);     // Catch: Throwable -> L100
    L96:
        r37 = r39.optBoolean("boe_proxy_enabled", false);     // Catch: Throwable -> L100
        if (r37 == false) goto L102;
        r110.enableBoeProxy(true);     // Catch: Throwable -> L100
    L100:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L155
    L102:
        if (r37 == true) goto L106;
        r37 = com.bytedance.frameworks.baselib.network.http.util.c.e(r17);     // Catch: Throwable -> L155
        if (r37 == false) goto L106;
        r110.enableBoeProxy(true);     // Catch: Throwable -> L155
    L106:
        if (r37 == false) goto L113;
        String r41 = CronetAppProviderManager.inst().getBypassBOEJSON();     // Catch: Throwable -> L155
        if (TextUtils.isEmpty(r41) == true) goto L110;
        r110.setBypassBOEJSON(r41);     // Catch: Throwable -> L155
    L110:
        String r42 = getProxyConfig(r111);     // Catch: Throwable -> L155
        if (TextUtils.isEmpty(r42) == true) goto L113;
        Log.e(TAG, "set proxy config: " + r42);     // Catch: Throwable -> L155
        r110.setProxyConfig(r42);     // Catch: Throwable -> L155
    L113:
        String r43 = CronetAppProviderManager.inst().getStoreIdcRuleJSON();     // Catch: Throwable -> L155
        if (TextUtils.isEmpty(r43) == true) goto L166;
        r110.setStoreIdcRuleJSON(r43);     // Catch: Throwable -> L155
    L166:
        long r44 = getALogFuncAddr();     // Catch: Exception -> L120 Throwable -> L155
        if (r44 == 0) goto L124;
        Log.e(TAG, "set alog address: " + r44);     // Catch: Exception -> L120 Throwable -> L155
        r110.setALogFuncAddr(r44);     // Catch: Exception -> L120 Throwable -> L155
    L124:
        if (Build.VERSION.SDK_INT < 18) goto L168;
    L129:
        if (r16 == null) goto L131;
        r110.setSlaSamplingSetting(r16);     // Catch: Throwable -> L155
    L131:
        TTNetInitMetrics.k().f1545v = System.nanoTime();     // Catch: Throwable -> L155
        TTNetInitMetrics.k().f1546w = TTNetInitMetrics.k().f1545v;     // Catch: Throwable -> L155
        sCronetEngine = r110.build();     // Catch: Throwable -> L155
        TTNetInitMetrics.k().f1547x = System.nanoTime();     // Catch: Throwable -> L155
        if (CronetDependManager.inst().loggerDebug() == false) goto L134;
        Logger.setLogLevel(2);     // Catch: Throwable -> L155
    L136:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L150;
        ExperimentalCronetEngine r45 = (ExperimentalCronetEngine) sCronetEngine;     // Catch: Throwable -> L155
        long r46 = getALogFuncAddr();     // Catch: Throwable -> L147
        if (r46 == 0) goto L141;
        Log.e(TAG, "ensure setting alog address: " + r46);     // Catch: Throwable -> L147
        r45.setAlogFuncAddr(r46);     // Catch: Throwable -> L147
    L141:
        int r47 = TTAppStateManager.a();     // Catch: Throwable -> L147
        if (r47 < 0) goto L145;
        if (r47 > 2) goto L145;
        r45.setAppStartUpState(r47);     // Catch: Throwable -> L147
    L145:
        TTNetInitMetrics.k().i(r17, r45.getOpaqueFuncAddress());     // Catch: Throwable -> L147
    L147:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L155
        goto L150
    L134:
        Logger.setLogLevel(4);     // Catch: Throwable -> L155
        goto L136
    L168:
        System.loadLibrary(CRYPTO_LIBRARY_NAME);     // Catch: Throwable -> L127
        System.loadLibrary(BORINGSSL_LIBRARY_NAME);     // Catch: Throwable -> L127
    L127:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L155
    L120:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L155
        goto L124
    L69:
        if (r29.isEmpty() == true) goto L71;
        r110.setClientOpaqueData(r29);     // Catch: Throwable -> L155
        goto L71
    L64:
        if (r28.isEmpty() == true) goto L66;
        r110.setOpaqueData(r28);     // Catch: Throwable -> L155
        goto L66
    L33:
        if (sNetworkThreadPriority > 19) goto L35;
        r110.setThreadPriority(sNetworkThreadPriority);     // Catch: Throwable -> L155
    L28:
        th = move-exception;
        Log.w(TAG, "ExperimentalCronetEngine.Builder enable HTTP Cache failed.");     // Catch: Throwable -> L155
        th.printStackTrace();     // Catch: Throwable -> L155
        r110.enableHttpCache(0, 0);     // Catch: Throwable -> L155
    L150:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L152;
        ExperimentalCronetEngine r48 = (ExperimentalCronetEngine) sCronetEngine;     // Catch: Throwable -> L155
        tryCreateRequestFinishedInfoListener(r23);     // Catch: Throwable -> L155
        r48.addRequestFinishedListener(sRequestFinishedInfoListener);     // Catch: Throwable -> L155
    L152:
        TTRequestCompressManager.p(new AnonymousClass4(this));     // Catch: Throwable -> L155
        TTNetInitMetrics.k().A = System.nanoTime();     // Catch: Throwable -> L155
        monitor-exit(CronetClient.class);     // Catch: Throwable -> L155
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void tryStartNetDetect(String[] r10, int r11, int r12) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).tryStartNetDetect(r10, r11, r12);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void ttDnsResolve(String r10, int r11, String r12, Map<String, String> r13) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).ttDnsResolve(r10, r11, r12, r13);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public TTDispatchResult ttUrlDispatch(String r10, int r11, boolean r12) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L11;
        Map<String, String> r13 = ((ExperimentalCronetEngine) sCronetEngine).ttUrlDispatch(r10, r11, r12);
        String r14 = r13.get(URLDispatch.KEY_FINAL_URL);
        if (TextUtils.isEmpty(r14) == true) goto L9;
        new URL(r14).toURI();
        return new TTDispatchResult(r10, r14, r13.get(URLDispatch.KEY_EPOCH), r13.get(URLDispatch.KEY_ETAG), TTDispatchResult.DispatchState.SUCCESS, r13.get(URLDispatch.KEY_TTNET_ORIGIN_HOST));
    L9:
        throw new UnknownFormatConversionException("ttUrlDispatch returns wrong format");
    L11:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }
}
