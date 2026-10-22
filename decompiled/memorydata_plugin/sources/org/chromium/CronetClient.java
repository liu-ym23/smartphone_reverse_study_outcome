package org.chromium;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.common.utility.io.FileUtils;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.frameworks.baselib.network.e.a;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.cronet.TTAppStateManager;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetThreadConfig;
import com.bytedance.frameworks.baselib.network.http.cronet.b;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.TTDispatchResult;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.f;
import com.bytedance.frameworks.baselib.network.http.util.c;
import com.bytedance.frameworks.baselib.network.http.util.g;
import com.bytedance.retrofit2.mime.TTRequestCompressManager;
import com.ttnet.org.chromium.base.Logger;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.ExperimentalCronetEngine;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTAppSecurityManager;
import com.ttnet.org.chromium.net.TTNetVersion;
import com.ttnet.org.chromium.net.TTSamplingSettingProvider;
import com.ttnet.org.chromium.net.TTThreadConfigInfoProvider;
import com.ttnet.org.chromium.net.impl.CronetUrlRequest;
import com.ttnet.org.chromium.net.impl.CronetUrlRequestMapping;
import com.ttnet.org.chromium.net.impl.URLDispatch;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.UnknownFormatConversionException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class CronetClient implements ICronetClient {
    private static final String BORINGSSL_LIBRARY_NAME = "ttboringssl";
    private static final String CRYPTO_LIBRARY_NAME = "ttcrypto";
    private static final int INVALID_THREAD_PRIORITY = 20;
    private static final String KEY_CRASH_DETECT_INTERVAL_MS = "crash_detect_interval_ms";
    private static final String KEY_CRASH_LIMIT_TIMES = "crash_limit_times";
    private static final String KEY_TTNET_CRASH_TIMES = "ttnet_crash_times";
    private static final int MAX_THREAD_STACK_SIZE = 5242880;
    private static final int MIN_THREAD_STACK_SIZE = 51200;
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
    private static ICronetClient.ICronetThreadStackOptFailureCheckerProvider sCronetThreadStackOptFailureCheckerProvider = null;
    private static volatile int sNetworkThreadPriority = 20;
    private int mCrashDetectTimerInterval;
    private int mCrashLimitTimes;
    private int mTTNetCrashTimes;

    static {
    }

    public CronetClient() {
        this.mCrashLimitTimes = 0;
        this.mCrashDetectTimerInterval = 5000;
    }

    private TTAppInfoProvider.AppInfo convertToCronetAppInfo(b r2) {
        TTAppInfoProvider.AppInfo r1 = new TTAppInfoProvider.AppInfo();
        r1.setAbSdkVersion(r2.f2404a);
        r1.setHostFirst(r2.f2405b);
        r1.setHostSecond(r2.c);
        r1.setHostThird(r2.d);
        r1.setDomainHttpDns(r2.e);
        r1.setDomainBoe(r2.f);
        r1.setDomainBoeHttps(r2.g);
        r1.setInitRegion(r2.h);
        return r1;
    }

    private static TTSamplingSettingProvider.TTSlaSamplingSetting convertToCronetSlaSamplingSetting(a.c r5) {
        if (r5 != null) goto L18;
        return null;
    L18:
        a.b r1 = r5.c();     // Catch: Exception -> L15
        if (r1 == null) goto L8;
        TTSamplingSettingProvider.TTSlaSamplingRule r2 = new TTSamplingSettingProvider.TTSlaSamplingRule();     // Catch: Exception -> L15
        r2.mEnableBaseApiAll = r1.a();     // Catch: Exception -> L15
        r2.mEnableApiAllUpload = r1.b();     // Catch: Exception -> L15
        r2.mUrlRegexBlackList = r1.c();     // Catch: Exception -> L15
        r2.mPathEqualWhiteList = r1.d();     // Catch: Exception -> L15
        r2.mPathPrefixWhiteList = r1.f();     // Catch: Exception -> L15
        r2.mPathContainWhiteList = r1.e();     // Catch: Exception -> L15
        r2.mPathRegexWhiteList = r1.g();     // Catch: Exception -> L15
        r2.mHostPatternWhiteList = r1.i();     // Catch: Exception -> L15
        r2.mUrlRegexWhiteList = r1.h();     // Catch: Exception -> L15
    L9:
        a.C0122a r3 = r5.d();     // Catch: Exception -> L15
        if (r3 == null) goto L12;
        TTSamplingSettingProvider.TTEventLogSamplingRule r4 = new TTSamplingSettingProvider.TTEventLogSamplingRule();     // Catch: Exception -> L15
        r4.mEventLogTypeWhiteList = r3.a();     // Catch: Exception -> L15
    L13:
        TTSamplingSettingProvider.TTSlaSamplingSetting r6 = new TTSamplingSettingProvider.TTSlaSamplingSetting();     // Catch: Exception -> L15
        r6.mHostAid = r5.a();     // Catch: Exception -> L15
        r6.mSdkAid = r5.b();     // Catch: Exception -> L15
        r6.mSlaSamplingRule = r2;     // Catch: Exception -> L15
        r6.mEventLogSamplingRule = r4;     // Catch: Exception -> L15
        return r6;
    L12:
        r4 = null;
        goto L13
    L8:
        r2 = null;
    L15:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private void detectCronetColdStartCrash(Context r9, ExperimentalCronetEngine.Builder r10) {
        final Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        SharedPreferences r11 = r6.getSharedPreferences(SP_SS_APP_CONFIG, 0);
        int r1 = r11.getInt(KEY_CRASH_LIMIT_TIMES, 0);
        this.mCrashLimitTimes = r1;
        if (r1 > 0) goto L8;
        int r12 = r11.getInt(KEY_TTNET_CRASH_TIMES, 0);
        this.mTTNetCrashTimes = r12;
        if (r12 <= 0) goto L28;
        SharedPreferences.Editor r8 = r11.edit();
        r8.putInt(KEY_TTNET_CRASH_TIMES, 0);
        r8.apply();
        return;
    L28:
        return;
    L8:
        this.mTTNetCrashTimes = r11.getInt(KEY_TTNET_CRASH_TIMES, 0);
        int r0 = r11.getInt(KEY_CRASH_DETECT_INTERVAL_MS, 5000);
        this.mCrashDetectTimerInterval = r0;
        if (r0 > 0) goto L12;
        this.mCrashDetectTimerInterval = 5000;
    L12:
        if (Logger.debug() == false) goto L15;
        Logger.d(TAG, "processname is " + g.d(r6) + " count is " + this.mTTNetCrashTimes + " limit is " + this.mCrashLimitTimes + " interval is " + this.mCrashDetectTimerInterval);
    L15:
        if (this.mTTNetCrashTimes < this.mCrashLimitTimes) goto L21;
        if (Logger.debug() == false) goto L19;
        Logger.d(TAG, "processname is " + g.d(r6) + "set secure mode true");
    L19:
        r10.enableTncSecureMode(true);
    L21:
        if (g.b(r6) == true) goto L23;
        return;
    L23:
        final SharedPreferences.Editor r7 = r11.edit();
        int r13 = this.mTTNetCrashTimes + 1;
        this.mTTNetCrashTimes = r13;
        r7.putInt(KEY_TTNET_CRASH_TIMES, r13);
        r7.commit();
        if (Logger.debug() == false) goto L26;
        Logger.d(TAG, "processname is " + g.d(r6) + " save count " + this.mTTNetCrashTimes);
    L26:
        com.bytedance.frameworks.baselib.network.asynctask.b r14 = com.bytedance.frameworks.baselib.network.asynctask.b.a(NetworkAsyncTaskType.NETWORK);
        final long r2 = this.mCrashDetectTimerInterval;
        final long r4 = 0;
        r14.a(new AnonymousClass1(this, r2, r4, r6, r7));
    }

    private static long getALogFuncAddr() {
        return ((Long) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.utils.a.a(ZeusTransformUtils.forName(TTNET_ALOG_CLASS, "com.obric.memorydata.plugin").newInstance()).call("getALogFuncAddr").a(), Long.class, "com.obric.memorydata.plugin")).longValue();
    }

    private static int getAppSecurityLevel() {
        return ((Integer) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.utils.a.a(ZeusTransformUtils.forName(TTNET_INIT_CLASS, "com.obric.memorydata.plugin").newInstance()).call("getAppSecurityLevel").a(), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L5:
        return 0;
    }

    public static CronetEngine getCronetEngine() {
        Objects.requireNonNull(sCronetEngine, "Cronet engine is null.");
        return sCronetEngine;
    }

    private static String getDomainConfigByRegion() {
        String r1 = CronetAppProviderManager.inst().getCarrierRegion();
        String r2 = CronetAppProviderManager.inst().getSysRegion();
        String r3 = CronetAppProviderManager.inst().getRegion();
        if (TextUtils.isEmpty(r1) == false) goto L10;
        if (TextUtils.isEmpty(r2) == true) goto L8;
        r1 = r2;
        goto L10
    L8:
        r1 = r3;
    L10:
        if (TextUtils.isEmpty(r1) == false) goto L15;
        return null;
    L15:
        return (String) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.utils.a.a(ZeusTransformUtils.forName(TTNET_INIT_CLASS, "com.obric.memorydata.plugin").newInstance()).call("getGetDomainConfigByRegion", new Class[]{String.class}, new Object[]{r1}).a(), String.class, "com.obric.memorydata.plugin");
    L14:
        return null;
    }

    private static boolean getListenAppStateIndependently() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.utils.a.a(ZeusTransformUtils.forName(TTNET_INIT_CLASS, "com.obric.memorydata.plugin").newInstance()).call("getListenAppStateIndependently").a(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        return false;
    }

    private static long getMaxHttpDiskCacheSize() {
        return ((Long) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.utils.a.a(ZeusTransformUtils.forName(TTNET_INIT_CLASS, "com.obric.memorydata.plugin").newInstance()).call("getMaxHttpDiskCacheSize").a(), Long.class, "com.obric.memorydata.plugin")).longValue();
    L5:
        return 67108864;
    }

    private String getProxyConfig(String r5) {
        String r0 = "";
        if (TextUtils.isEmpty(r5) == true) goto L34;
        BufferedReader r4 = null;
        File r1 = new File(r5 + TTNET_CONFIG_FILE);     // Catch: Throwable -> L21
        if (r1.exists() == false) goto L16;
        BufferedReader r6 = new BufferedReader(new FileReader(r1));     // Catch: Throwable -> L21
        StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L14
    L9:
        String r2 = r6.readLine();     // Catch: Throwable -> L14
        if (r2 == null) goto L12;
        r7.append(r2);     // Catch: Throwable -> L14
        goto L9
    L12:
        r0 = new JSONObject(r7.toString()).optString("ttnet_proxy", "");     // Catch: Throwable -> L14
        r4 = r6;
    L14:
        Throwable th = th;
    L42:
        th.printStackTrace();     // Catch: Throwable -> L27
        if (r6 == null) goto L34;
        r6.close();     // Catch: IOException -> L19
    L35:
    L27:
        th = move-exception;
        if (r6 != null) goto L40;
    L33:
        throw th;
    L40:
        r6.close();     // Catch: IOException -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L16:
        if (r4 == null) goto L34;
        r4.close();     // Catch: IOException -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
    L21:
        th = move-exception;
        r6 = null;
        th = th;
    L34:
        return r0;
    }

    private static JSONObject getSlaSamplingSetting() {
        return (JSONObject) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.utils.a.a(ZeusTransformUtils.forName(TTNET_INIT_CLASS, "com.obric.memorydata.plugin").newInstance()).call("getSlaSamplingSetting").a(), JSONObject.class, "com.obric.memorydata.plugin");
    L5:
        return null;
    }

    private static TTNetThreadConfig.a getThreadConfigCallbackImpl() {
        return (TTNetThreadConfig.a) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.utils.a.a(ZeusTransformUtils.forName(TTNET_INIT_CLASS, "com.obric.memorydata.plugin").newInstance()).call("getThreadConfigCallbackImpl").a(), TTNetThreadConfig.a.class, "com.obric.memorydata.plugin");
    L5:
        return null;
    }

    private static ArrayList<TTNetThreadConfig> getThreadConfigInfoList() {
        return (ArrayList) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.utils.a.a(ZeusTransformUtils.forName(TTNET_INIT_CLASS, "com.obric.memorydata.plugin").newInstance()).call("getThreadConfigInfoList").a(), ArrayList.class, "com.obric.memorydata.plugin");
    L5:
        return null;
    }

    public static void setNetworkThreadPriority(int r0) {
        sNetworkThreadPriority = r0;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void addClientOpaqueData(String[] r9, byte[] r10, byte[] r11, long r12, long r14) {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (CronetDependManager.inst().loggerDebug() == false) goto L6;
        CronetDependManager.inst().loggerD(TAG, "addClientOpaqueData start");     // Catch: Throwable -> L9
    L6:
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L14;
        ((ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin")).addClientOpaqueData(r9, r10, r11, r12, r14);     // Catch: Throwable -> L9
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void bindBigCore(TTNetThreadConfig.ThreadType r3) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L7;
        ((ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin")).bindBigCore(r3.ordinal());
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void bindLittleCore(TTNetThreadConfig.ThreadType r3) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L7;
        ((ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin")).bindLittleCore(r3.ordinal());
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
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L14;
        ((ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin")).clearClientOpaqueData();     // Catch: Throwable -> L9
        return;
    }

    TTThreadConfigInfoProvider.Callback convertToCronetThreadConfigCallback(TTNetThreadConfig.a r3) {
        final TTNetThreadConfig.a r4 = (TTNetThreadConfig.a) ZeusTransformUtils.wrapperContextForParams(r3, TTNetThreadConfig.a.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass2(this, r4);
    }

    ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> convertToCronetThreadConfigInfoList(ArrayList<TTNetThreadConfig> r9, boolean r10) {
        if (r9 != null) goto L40;
    L39:
        return null;
    L40:
    L37:
        e = move-exception;
        e.printStackTrace();
        goto L39
    L5:
        if (r9.isEmpty() == true) goto L39;
        ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r0 = new ArrayList();     // Catch: Exception -> L37
        EnumSet r1 = EnumSet.noneOf(TTNetThreadConfig.ThreadType.class);     // Catch: Exception -> L37
        Iterator<TTNetThreadConfig> r11 = r9.iterator();     // Catch: Exception -> L37
    L8:
        if (r11.hasNext() == false) goto L36;
        TTNetThreadConfig r2 = (TTNetThreadConfig) ZeusTransformUtils.preCheckCast(r11.next(), TTNetThreadConfig.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L37
        boolean r5 = true;
        if (r2.f2402b >= (-20)) goto L13;
    L15:
        boolean r3 = false;
    L16:
        if (r10 == true) goto L18;
    L22:
        r5 = false;
    L23:
        if (r3 == true) goto L27;
        if (r5 == false) goto L8;
    L27:
        if (r1.contains(r2.f2401a) == true) goto L8;
        TTThreadConfigInfoProvider.ThreadConfigInfo r4 = new TTThreadConfigInfoProvider.ThreadConfigInfo();     // Catch: Exception -> L37
        r4.setThreadType(TTThreadConfigInfoProvider.ThreadType.values()[r2.f2401a.ordinal()]);     // Catch: Exception -> L37
        if (r3 == false) goto L32;
        r4.setThreadPriority(r2.f2402b);     // Catch: Exception -> L37
    L32:
        if (r5 == false) goto L34;
        r4.setThreadStackSize(r2.c);     // Catch: Exception -> L37
    L34:
        r0.add(r4);     // Catch: Exception -> L37
        r1.add(r2.f2401a);     // Catch: Exception -> L37
        goto L8
    L18:
        if (r2.c < MIN_THREAD_STACK_SIZE) goto L22;
        if (r2.c > MAX_THREAD_STACK_SIZE) goto L22;
    L13:
        if (r2.f2402b > 19) goto L15;
        r3 = true;
        goto L16
    L36:
        return r0;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void enableTTBizHttpDns(boolean r8, String r9, String r10, String r11, boolean r12, String r13) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L7;
        ((ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin")).enableTTBizHttpDns(r8, r9, r10, r11, r12, r13);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getCronetInternalErrorCode(HttpURLConnection r3) {
        if (ZeusTransformUtils.instanceOf(r3, CronetHttpURLConnection.class) == true) goto L6;
        return 0;
    L6:
        return ((CronetHttpURLConnection) ZeusTransformUtils.preCheckCast(r3, CronetHttpURLConnection.class, "com.obric.memorydata.plugin")).getCronetInternalErrorCode();
    L11:
        return 0;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public String getCronetVersion() {
        return TTNetVersion.VERSION;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getEffectiveConnectionType() {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L7;
        return ((ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin")).getEffectiveConnectionType();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getEffectiveHttpRttMs() {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L7;
        return ((ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin")).getEffectiveHttpRtt();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getEffectiveRxThroughputKbps() {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L7;
        return ((ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin")).getEffectiveRxThroughput();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getEffectiveTransportRttMs() {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L7;
        return ((ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin")).getEffectiveTransportRtt();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public Map<String, f> getGroupRttEstimates() {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L14;
        ExperimentalCronetEngine r0 = (ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin");
        HashMap r1 = new HashMap();
        Iterator<Map.Entry<String, int[]>> r2 = r0.getGroupRttEstimates().entrySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L12;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((int[]) ZeusTransformUtils.preCheckCast(r3.getValue(), int[].class, "com.obric.memorydata.plugin")).length != 2) goto L11;
        f r4 = new f();
        r4.f2418a = ((int[]) ZeusTransformUtils.preCheckCast(r3.getValue(), int[].class, "com.obric.memorydata.plugin"))[0];
        r4.f2419b = ((int[]) ZeusTransformUtils.preCheckCast(r3.getValue(), int[].class, "com.obric.memorydata.plugin"))[1];
        r4.c = -1;
        r1.put((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin"), r4);
        goto L6
    L11:
        throw new UnknownFormatConversionException("getGroupRttEstimates returns wrong format");
    L12:
        return r1;
    L14:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void getMappingRequestState(final String r3) {
        CronetUrlRequest r0 = CronetUrlRequestMapping.GetRequest(r3);     // Catch: Throwable -> L6
        if (r0 == null) goto L11;
        r0.getStatus(new AnonymousClass5(this, r3));     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public f getNetworkQuality() {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L7;
        ExperimentalCronetEngine r2 = (ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin");
        f r0 = new f();
        r0.f2418a = r2.getTransportRttMs();
        r0.f2419b = r2.getHttpRttMs();
        r0.c = r2.getDownstreamThroughputKbps();
        return r0;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getNetworkQualityLevel() {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L7;
        return ((ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin")).getNetworkQualityLevel();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public com.bytedance.frameworks.baselib.network.http.cronet.impl.g getPacketLossRateMetrics(int r4) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L7;
        com.bytedance.frameworks.baselib.network.http.cronet.impl.g r3 = new com.bytedance.frameworks.baselib.network.http.cronet.impl.g();
        ExperimentalCronetEngine r0 = (ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin");
        r3.f2420a = r4;
        r3.f2421b = r0.getUpstreamPacketLossRate(r4);
        r3.c = r0.getUpstreamPacketLossRateVariance(r4);
        r3.d = r0.getDownstreamPacketLossRate(r4);
        r3.e = r0.getDownstreamPacketLossRateVariance(r4);
        return r3;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public boolean isCronetHttpURLConnection(HttpURLConnection r1) {
        return ZeusTransformUtils.instanceOf(r1, CronetHttpURLConnection.class);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void notifyStoreRegionUpdated(String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L7;
        ((ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin")).updateStoreRegionFromServer(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void notifyTNCConfigUpdated(String r8, String r9, String r10, String r11, String r12, String r13) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L7;
        ((ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin")).notifyTNCConfigUpdated(r8, r9, r10, r11, r12, r13);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public HttpURLConnection openConnection(Context r13, String r14, boolean r15, String r16, com.bytedance.frameworks.baselib.network.http.b r17, ICronetAppProvider r18) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
        ICronetAppProvider r11 = (ICronetAppProvider) ZeusTransformUtils.wrapperContextForParams(r18, ICronetAppProvider.class, "com.obric.memorydata.plugin");
    L8:
        th = move-exception;
        if (ZeusTransformUtils.instanceOf(th, MalformedURLException.class) == false) goto L12;
        throw th;
    L12:
        if (ZeusTransformUtils.instanceOf(th, UnsupportedOperationException.class) == false) goto L20;
        if (th.getMessage() == null) goto L20;
        if (th.getMessage().contains("Unexpected protocol") == false) goto L20;
        throw new IOException("MalformedURLException", th);
    L20:
        throw new IOException(th);
    L4:
        if (TTNetInitMetrics.c().f2272b != TTNetInitMetrics.CronetInitMode.NONE) goto L6;
        TTNetInitMetrics r1 = TTNetInitMetrics.c();     // Catch: Throwable -> L8
        r1.f2272b = TTNetInitMetrics.CronetInitMode.LAZY_INIT;     // Catch: Throwable -> L8
    L6:
        tryCreateCronetEngine(r4, false, false, false, r15, r16, false, r11);     // Catch: Throwable -> L8
        CronetHttpURLConnection r2 = (CronetHttpURLConnection) ZeusTransformUtils.preCheckCast(sCronetEngine.openConnection(new URL(r14), Proxy.NO_PROXY, r17.f2362a), CronetHttpURLConnection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        r2.setRequestFinishedListener(new TTCronetRequestFinishedInfoListener(r17));     // Catch: Throwable -> L8
        return r2;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void preconnectUrl(String r3, Map<String, String> r4) {
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L7;
        ((ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin")).preconnectUrl(r3, 1, r2);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void removeClientOpaqueData(String r3) {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (CronetDependManager.inst().loggerDebug() == false) goto L6;
        CronetDependManager.inst().loggerD(TAG, "removeClientOpaqueData start");     // Catch: Throwable -> L9
    L6:
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L14;
        ((ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin")).removeClientOpaqueData(r3);     // Catch: Throwable -> L9
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void reportNetDiagnosisUserLog(String r3) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L7;
        ((ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin")).reportNetDiagnosisUserLog(r3);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void resetCoreBind(TTNetThreadConfig.ThreadType r3) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L7;
        ((ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin")).resetCoreBind(r3.ordinal());
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void runInBackGround(boolean r3) {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (CronetDependManager.inst().loggerDebug() == false) goto L6;
        CronetDependManager.inst().loggerD(TAG, "runInBackGround start");     // Catch: Throwable -> L9
    L6:
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L14;
        ((ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin")).runInBackGround(r3);     // Catch: Throwable -> L9
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setAlogFuncAddr(long r3) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L7;
        ((ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin")).setAlogFuncAddr(r3);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setAppStartUpState(int r3) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L7;
        ((ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin")).setAppStartUpState(r3);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setBestHostWithRouteSelectionName(String r3, String r4) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L7;
        ((ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin")).setRouteSelectionBestHost(r3, r4);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setCookieInitCompleted() {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L7;
        ((ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin")).setCookieInitCompleted();
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setCronetBootFailureCheckerProvider(ICronetClient.ICronetBootFailureCheckerProvider r2) {
        sCronetBootFailureCheckerProvider = (ICronetClient.ICronetBootFailureCheckerProvider) ZeusTransformUtils.wrapperContextForParams(r2, ICronetClient.ICronetBootFailureCheckerProvider.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setCronetThreadStackOptFailureCheckerProvider(ICronetClient.ICronetThreadStackOptFailureCheckerProvider r2) {
        sCronetThreadStackOptFailureCheckerProvider = (ICronetClient.ICronetThreadStackOptFailureCheckerProvider) ZeusTransformUtils.wrapperContextForParams(r2, ICronetClient.ICronetThreadStackOptFailureCheckerProvider.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setHostResolverRules(String r3) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L7;
        ((ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin")).setHostResolverRules(r3);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setHttpDnsForTesting(boolean r1, boolean r2, boolean r3) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setProxy(String r3) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L7;
        ((ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin")).setProxy(r3);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setSlaSamplingSetting(JSONObject r3) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L13;
        if (sAppID > 0) goto L7;
        sAppID = Integer.parseInt(CronetAppProviderManager.inst().getAppId());
    L7:
        TTSamplingSettingProvider.TTSlaSamplingSetting r2 = convertToCronetSlaSamplingSetting(com.bytedance.frameworks.baselib.network.e.b.a(r3, sAppID));
        if (r2 != null) goto L10;
        return;
    L10:
        ((ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin")).addSamplingSetting(r2);
        return;
    L13:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setZstdFuncAddr(long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L7;
        ((ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin")).setZstdFuncAddr(r19, r21, r23, r25, r27, r29, r31, r33);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void startThrottle(String[] r3, int r4, long r5) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L7;
        ((ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin")).startThrottle(r3, r4, r5);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void stopThrottle(String[] r3, int r4) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L7;
        ((ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin")).stopThrottle(r3, r4);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void triggerGetDomain(boolean r3) {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (CronetDependManager.inst().loggerDebug() == false) goto L6;
        CronetDependManager.inst().loggerD(TAG, "triggerGetDomain start");     // Catch: Throwable -> L9
    L6:
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L14;
        ((ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin")).triggerGetDomain(r3);     // Catch: Throwable -> L9
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void tryCreateCronetEngine(Context r17, boolean r18, boolean r19, boolean r20, boolean r21, String r22, boolean r23, ICronetAppProvider r24) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.memorydata.plugin");
        ICronetAppProvider r3 = (ICronetAppProvider) ZeusTransformUtils.wrapperContextForParams(r24, ICronetAppProvider.class, "com.obric.memorydata.plugin");
        if (sCronetEngine == null) goto L5;
        return;
    L5:
        monitor-enter(CronetClient.class);
    L172:
        th = move-exception;
        throw th;
    L7:
        if (sCronetEngine != null) goto L169;
        Log.w(TAG, "CronetClient tryCreateCronetEngine");     // Catch: Throwable -> L172
        TTNetInitMetrics.c().n = System.currentTimeMillis();     // Catch: Throwable -> L172
        TTNetInitMetrics.c().o = System.nanoTime();     // Catch: Throwable -> L172
        if (r23 == true) goto L17;
        ICronetClient.ICronetBootFailureCheckerProvider r0 = sCronetBootFailureCheckerProvider;     // Catch: Throwable -> L172
        if (r0 == null) goto L17;
        if (r0.isCronetBootFailureExpected() == true) goto L17;
        Log.w(TAG, "isCronetBootFailureExpected return false.");     // Catch: Throwable -> L172
        throw new IllegalArgumentException("isCronetBootFailureExpected return false.");     // Catch: Throwable -> L172
    L17:
        TTNetInitMetrics.c().p = System.nanoTime();     // Catch: Throwable -> L172
        ICronetClient.ICronetThreadStackOptFailureCheckerProvider r1 = sCronetThreadStackOptFailureCheckerProvider;     // Catch: Throwable -> L172
        if (r1 != null) goto L20;
    L22:
        boolean r7 = false;
    L23:
        TTNetInitMetrics.c().q = System.nanoTime();     // Catch: Throwable -> L172
        TTNetInitMetrics.c().r = System.nanoTime();     // Catch: Throwable -> L172
        boolean r8 = CronetAppProviderManager.inst().getOptInit();     // Catch: Throwable -> L172
        if (r8 == false) goto L26;
        b r10 = r3.getAppInfoSubset();     // Catch: Throwable -> L172
    L27:
        TTNetInitMetrics.c().s = System.nanoTime();     // Catch: Throwable -> L172
        TTNetInitMetrics.c().t = TTNetInitMetrics.c().s;     // Catch: Throwable -> L172
        ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r11 = convertToCronetThreadConfigInfoList(getThreadConfigInfoList(), r7);     // Catch: Throwable -> L172
        TTNetInitMetrics.c().u = System.nanoTime();     // Catch: Throwable -> L172
        TTNetInitMetrics.c().v = TTNetInitMetrics.c().u;     // Catch: Throwable -> L172
        TTThreadConfigInfoProvider.Callback r12 = convertToCronetThreadConfigCallback(getThreadConfigCallbackImpl());     // Catch: Throwable -> L172
        TTNetInitMetrics.c().w = System.nanoTime();     // Catch: Throwable -> L172
        TTNetInitMetrics.c().x = TTNetInitMetrics.c().w;     // Catch: Throwable -> L172
        sAppID = Integer.parseInt(r3.getAppId());     // Catch: Exception -> L176 Throwable -> L172
    L29:
        TTSamplingSettingProvider.TTSlaSamplingSetting r13 = convertToCronetSlaSamplingSetting(com.bytedance.frameworks.baselib.network.e.b.a(getSlaSamplingSetting(), sAppID));     // Catch: Throwable -> L172
        TTNetInitMetrics.c().y = System.nanoTime();     // Catch: Throwable -> L172
        TTNetInitMetrics.c().z = TTNetInitMetrics.c().y;     // Catch: Throwable -> L172
        ExperimentalCronetEngine.Builder r14 = new ExperimentalCronetEngine.Builder(r2, r8).enableQuic(r18).enableHttp2(r19).enableSdch(r20).enableHttpDns(r21).listenAppStateIndependently(getListenAppStateIndependently()).enableNetworkQualityEstimator(true);     // Catch: Throwable -> L172
        if (CronetDependManager.inst().loggerDebug() == false) goto L32;
        r14.enableVerboseLog();     // Catch: Throwable -> L172
    L32:
        b r15 = r10;
        boolean r25 = r7;
        r14.setTTNetInitStart(Math.min(TTNetInitMetrics.c().f, TTNetInitMetrics.c().o));     // Catch: Throwable -> L172
        detectCronetColdStartCrash(r2, r14);     // Catch: Throwable -> L172
        String r6 = "";
        r6 = r2.getCacheDir().getPath() + "/";     // Catch: Throwable -> L43
        r14.setStoragePath(r6 + TTNET_CACHE_DIR);     // Catch: Throwable -> L41
        r14.enableHttpCache(3, getMaxHttpDiskCacheSize());     // Catch: Throwable -> L39
        r6 = r6;
    L46:
        if (sNetworkThreadPriority >= (-20)) goto L48;
    L50:
        int r4 = getAppSecurityLevel();     // Catch: Throwable -> L172
        if (r4 <= 0) goto L54;
        r14.setAppSecurityLevel(r4);     // Catch: Throwable -> L172
    L54:
        if (CronetAppProviderManager.inst().isEnableBrotli() == false) goto L56;
        boolean r5 = true;
        r14.enableBrotli(true);     // Catch: Throwable -> L172
    L58:
        if (CronetAppProviderManager.inst().isEnableQuic() == false) goto L61;
        r14.enableQuic(r5);     // Catch: Throwable -> L172
    L61:
        if (CronetAppProviderManager.inst().isEnableHttp2() == false) goto L63;
        r14.enableHttp2(r5);     // Catch: Throwable -> L172
    L63:
        TTAppSecurityManager.getInstance().setSystemApiSandbox(CronetSystemApiSandbox.inst());     // Catch: Throwable -> L172
        r14.setAppInfoProvider(CronetAppInfoProvider.inst(r2));     // Catch: Throwable -> L172
        r14.setEventListener(CronetEventListener.inst());     // Catch: Throwable -> L172
        r14.setIsMainProcess(g.b(r2));     // Catch: Throwable -> L172
        r14.setProcessName(g.d(r2));     // Catch: Throwable -> L172
        if (g.b(r2) == false) goto L66;
        r14.setAppMonitorProvider(CronetAppMonitorProvider.inst());     // Catch: Throwable -> L172
        CronetEventListener.inst().setIsMainProcess(true);     // Catch: Throwable -> L172
    L66:
        if (r8 == false) goto L68;
        r14.setTTAppInfoColdStartSubset(convertToCronetAppInfo(r15));     // Catch: Throwable -> L172
    L68:
        r14.setOptInit(r8);     // Catch: Throwable -> L172
        r14.setOptNqeInit(r3.getOptNqeDefault(), r3.getOptNqePersist());     // Catch: Throwable -> L172
        r14.setThreadConfigInfoList(r11);     // Catch: Throwable -> L172
        r14.setThreadConfigCallbackImpl(r12);     // Catch: Throwable -> L172
        r14.setLazyInitIPC(r3.getLazyInitCronetIPC());     // Catch: Throwable -> L172
        if (TextUtils.isEmpty(r22) == true) goto L71;
        r14.setUserAgent(r22 + " cronet/" + TTNetVersion.VERSION);     // Catch: Throwable -> L172
    L71:
        String r9 = getDomainConfigByRegion();     // Catch: Throwable -> L172
        if (TextUtils.isEmpty(r9) == false) goto L75;
        r9 = CronetAppProviderManager.inst().getGetDomainDefaultJSON();     // Catch: Throwable -> L172
    L75:
        if (TextUtils.isEmpty(r9) == true) goto L77;
        r14.setGetDomainDefaultJSON(r9);     // Catch: Throwable -> L172
    L77:
        ArrayList<byte[]> r16 = CronetAppProviderManager.inst().getOpaqueData();     // Catch: Throwable -> L172
        if (r16 != null) goto L80;
    L82:
        Map<String[], Pair<byte[], byte[]>> r26 = CronetAppProviderManager.inst().getClientOpaqueData();     // Catch: Throwable -> L172
        if (r26 != null) goto L85;
    L87:
        Map<String, Pair<Integer, Integer>> r27 = CronetAppProviderManager.inst().getQuicHint();     // Catch: Throwable -> L172
        if (r27 == null) goto L96;
        if (r27.isEmpty() == true) goto L96;
        Iterator<Map.Entry<String, Pair<Integer, Integer>>> r28 = r27.entrySet().iterator();     // Catch: Throwable -> L172
    L93:
        if (r28.hasNext() == false) goto L96;
        Map.Entry r29 = (Map.Entry) ZeusTransformUtils.preCheckCast(r28.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L172
        r14.addQuicHint((String) ZeusTransformUtils.preCheckCast(r29.getKey(), String.class, "com.obric.memorydata.plugin"), ((Integer) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r29.getValue(), Pair.class, "com.obric.memorydata.plugin")).first, Integer.class, "com.obric.memorydata.plugin")).intValue(), ((Integer) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r29.getValue(), Pair.class, "com.obric.memorydata.plugin")).second, Integer.class, "com.obric.memorydata.plugin")).intValue());     // Catch: Throwable -> L172
    L96:
        if (CronetAppProviderManager.inst().needCustomLoadLibrary() == false) goto L98;
        r14.setLibraryLoader(new AnonymousClass3(this));     // Catch: Throwable -> L172
    L98:
        String r30 = CronetAppProviderManager.inst().getCronetSoPath();     // Catch: Throwable -> L172
        if (TextUtils.isEmpty(r30) == true) goto L103;
        String r31 = r30.substring(r30.lastIndexOf(File.separator) + 1);     // Catch: Throwable -> L172
        String r32 = r2.getCacheDir().getAbsolutePath();     // Catch: Throwable -> L172
        if (FileUtils.a(r30, r32, r31) == false) goto L103;
        r14.setCronetSoPath(r32 + File.separator + r31);     // Catch: Throwable -> L172
    L103:
        boolean r33 = CronetAppProviderManager.inst().isBOEProxyEnabled();     // Catch: Throwable -> L172
        if (r33 == false) goto L106;
        r14.enableBoeProxy(true);     // Catch: Throwable -> L172
    L106:
        if (r33 == true) goto L118;
        String r34 = c.a(r2, TTNET_CONFIG_FILE);     // Catch: Throwable -> L172
        if (TextUtils.isEmpty(r34) == true) goto L118;
        JSONObject r35 = new JSONObject(r34);     // Catch: Throwable -> L116
        String r36 = r35.optString("ttnet_proxy", "");     // Catch: Throwable -> L116
        if (TextUtils.isEmpty(r36) == true) goto L112;
        r14.setProxyConfig(r36);     // Catch: Throwable -> L116
    L112:
        r33 = r35.optBoolean("boe_proxy_enabled", false);     // Catch: Throwable -> L116
        if (r33 == false) goto L118;
        r14.enableBoeProxy(true);     // Catch: Throwable -> L116
    L116:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L172
    L118:
        if (r33 == true) goto L122;
        r33 = c.b(r2);     // Catch: Throwable -> L172
        if (r33 == false) goto L122;
        r14.enableBoeProxy(true);     // Catch: Throwable -> L172
    L122:
        if (r33 == false) goto L129;
        String r37 = CronetAppProviderManager.inst().getBypassBOEJSON();     // Catch: Throwable -> L172
        if (TextUtils.isEmpty(r37) == true) goto L126;
        r14.setBypassBOEJSON(r37);     // Catch: Throwable -> L172
    L126:
        String r38 = getProxyConfig(r6);     // Catch: Throwable -> L172
        if (TextUtils.isEmpty(r38) == true) goto L129;
        Log.e(TAG, "set proxy config: " + r38);     // Catch: Throwable -> L172
        r14.setProxyConfig(r38);     // Catch: Throwable -> L172
    L129:
        String r39 = CronetAppProviderManager.inst().getStoreIdcRuleJSON();     // Catch: Throwable -> L172
        if (TextUtils.isEmpty(r39) == true) goto L183;
        r14.setStoreIdcRuleJSON(r39);     // Catch: Throwable -> L172
    L183:
        long r40 = getALogFuncAddr();     // Catch: Exception -> L136 Throwable -> L172
        if (r40 == 0) goto L140;
        Log.e(TAG, "set alog address: " + r40);     // Catch: Exception -> L136 Throwable -> L172
        r14.setALogFuncAddr(r40);     // Catch: Exception -> L136 Throwable -> L172
    L140:
        if (Build.VERSION.SDK_INT < 18) goto L192;
    L145:
        if (r13 == null) goto L147;
        r14.setSlaSamplingSetting(r13);     // Catch: Throwable -> L172
    L147:
        ICronetClient.ICronetThreadStackOptFailureCheckerProvider r41 = sCronetThreadStackOptFailureCheckerProvider;     // Catch: Throwable -> L172
        if (r41 != null) goto L150;
        String r42 = null;
    L151:
        r14.setStackInfo(r25, r42);     // Catch: Throwable -> L172
        TTNetInitMetrics.c().A = System.nanoTime();     // Catch: Throwable -> L172
        TTNetInitMetrics.c().B = TTNetInitMetrics.c().A;     // Catch: Throwable -> L172
        sCronetEngine = r14.build();     // Catch: Throwable -> L172
        TTNetInitMetrics.c().C = System.nanoTime();     // Catch: Throwable -> L172
        if (CronetDependManager.inst().loggerDebug() == false) goto L154;
        Logger.setLogLevel(2);     // Catch: Throwable -> L172
    L156:
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L169;
        ExperimentalCronetEngine r43 = (ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L172
        long r44 = getALogFuncAddr();     // Catch: Throwable -> L167
        if (r44 == 0) goto L161;
        Log.e(TAG, "ensure setting alog address: " + r44);     // Catch: Throwable -> L167
        r43.setAlogFuncAddr(r44);     // Catch: Throwable -> L167
    L161:
        int r45 = TTAppStateManager.a();     // Catch: Throwable -> L167
        if (r45 < 0) goto L165;
        if (r45 > 2) goto L165;
        r43.setAppStartUpState(r45);     // Catch: Throwable -> L167
    L165:
        TTNetInitMetrics.c().a(r2, r43.getOpaqueFuncAddress());     // Catch: Throwable -> L167
    L167:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L172
        goto L169
    L154:
        Logger.setLogLevel(4);     // Catch: Throwable -> L172
        goto L156
    L150:
        r42 = r41.getThreadStackInitReason();     // Catch: Throwable -> L172
        goto L151
    L192:
        System.loadLibrary(CRYPTO_LIBRARY_NAME);     // Catch: Throwable -> L143
        System.loadLibrary(BORINGSSL_LIBRARY_NAME);     // Catch: Throwable -> L143
    L143:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L172
    L136:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L172
        goto L140
    L85:
        if (r26.isEmpty() == true) goto L87;
        r14.setClientOpaqueData(r26);     // Catch: Throwable -> L172
        goto L87
    L80:
        if (r16.isEmpty() == true) goto L82;
        r14.setOpaqueData(r16);     // Catch: Throwable -> L172
        goto L82
    L56:
        r5 = true;
        goto L58
    L48:
        if (sNetworkThreadPriority > 19) goto L50;
        r14.setThreadPriority(sNetworkThreadPriority);     // Catch: Throwable -> L172
    L39:
        th = th;
        r6 = r6;
    L44:
        Log.w(TAG, "ExperimentalCronetEngine.Builder enable HTTP Cache failed.");     // Catch: Throwable -> L172
        th.printStackTrace();     // Catch: Throwable -> L172
        r14.enableHttpCache(0, 0);     // Catch: Throwable -> L172
    L41:
        th = th;
    L43:
        th = th;
        goto L44
    L26:
        r10 = null;
        goto L27
    L20:
        if (r1.isCronetThreadStackOptFailureExpected() == false) goto L22;
        r7 = true;
    L169:
        TTRequestCompressManager.setCompressDataCallback(new AnonymousClass4(this));     // Catch: Throwable -> L172
        TTNetInitMetrics.c().F = System.nanoTime();     // Catch: Throwable -> L172
        monitor-exit(CronetClient.class);     // Catch: Throwable -> L172
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void tryStartNetDetect(String[] r3, int r4, int r5) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L7;
        ((ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin")).tryStartNetDetect(r3, r4, r5);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void ttDnsResolve(String r3, int r4, String r5, Map<String, String> r6) {
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L7;
        ((ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin")).ttDnsResolve(r3, r4, r5, r2);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public TTDispatchResult ttUrlDispatch(String r10, int r11, boolean r12) {
        if (ZeusTransformUtils.instanceOf(sCronetEngine, ExperimentalCronetEngine.class) == false) goto L11;
        Map<String, String> r9 = ((ExperimentalCronetEngine) ZeusTransformUtils.preCheckCast(sCronetEngine, ExperimentalCronetEngine.class, "com.obric.memorydata.plugin")).ttUrlDispatch(r10, r11, r12);
        String r4 = (String) ZeusTransformUtils.preCheckCast(r9.get(URLDispatch.KEY_FINAL_URL), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r4) == true) goto L9;
        new URL(r4).toURI();
        return new TTDispatchResult(r10, r4, (String) ZeusTransformUtils.preCheckCast(r9.get(URLDispatch.KEY_EPOCH), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r9.get(URLDispatch.KEY_ETAG), String.class, "com.obric.memorydata.plugin"), TTDispatchResult.DispatchState.SUCCESS, (String) ZeusTransformUtils.preCheckCast(r9.get(URLDispatch.KEY_TTNET_ORIGIN_HOST), String.class, "com.obric.memorydata.plugin"));
    L9:
        throw new UnknownFormatConversionException("ttUrlDispatch returns wrong format");
    L11:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }
}
