package com.bytedance.ttnet.config;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.connectionclass.ConnectionQuality;
import com.bytedance.frameworks.baselib.network.http.exception.NotAllowApiHttpException;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.o;
import com.bytedance.frameworks.baselib.network.http.util.i;
import com.bytedance.frameworks.baselib.network.http.util.k;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.tnc.TNCManager;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.InetAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AppConfig implements WeakHandler.IHandler, com.bytedance.frameworks.baselib.network.connectionclass.a.b, com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a, com.bytedance.frameworks.baselib.network.http.cronet.impl.h.b, com.bytedance.frameworks.baselib.network.http.cronet.impl.h.d, com.bytedance.frameworks.baselib.network.http.f.e, com.bytedance.frameworks.baselib.network.http.f.g, com.bytedance.frameworks.baselib.network.http.f.i, com.bytedance.frameworks.baselib.network.http.f.j, com.bytedance.frameworks.core.encrypt.a.InterfaceC0132a, com.bytedance.ttnet.c.b {
    static final int CONTINUOUS_FAILURES_TO_CLOSE_CRONET = 5;
    static final int CRONET_TRY_REBOOT_HOURS = 1;
    private static final int INVALID_VALUE = Integer.MIN_VALUE;
    static final String KEY_ADD_DEVICE_FINGERPRINT_OPEN = "add_device_fingerprint_open";
    static final String KEY_ADD_SS_QUERIES_HEADER_OPEN = "add_ss_queries_header_open";
    static final String KEY_ADD_SS_QUERIES_OPEN = "add_ss_queries_open";
    static final String KEY_ADD_SS_QUERIES_PLAINTEXT_OPEN = "add_ss_queries_plaintext_open";
    static final String KEY_API_HTTP_HOST_LIST = "api_http_host_list";
    static final String KEY_CDN_SAMPLE_BAND_WIDTH_ENABLED = "cdn_sample_band_width_enabled";
    static final String KEY_CHROMIUM_BOOT_FAILURES = "chromium_boot_failures";
    static final String KEY_CHROMIUM_BOOT_FAILURES_TIMESTAMP = "chromium_boot_failures_timestamp";
    static final String KEY_COLLECT_RECENT_PAGE_INFO_ENABLE = "collect_recent_page_info_enable";
    static final String KEY_COMMON_PARAMS_CONFIG = "add_common_params";
    static final String KEY_CONCURRENT_REQUEST_CONFIG = "concurrent_request_config";
    static final String KEY_CRASH_DETECT_INTERVAL_MS = "crash_detect_interval_ms";
    static final String KEY_CRASH_LIMIT_TIMES = "crash_limit_times";
    static final String KEY_CRONET_SO_PATH = "cronet_so_path";
    static final String KEY_CRONET_VERSION = "cronet_version";
    static final String KEY_DESTROY_DELTA_MILLIS = "destroy_delta_millis";
    static final String KEY_DETECT_NATIVE_PAGE = "detect_native_page";
    static final String KEY_DETECT_OPEN = "detect_open";
    static final String KEY_DISABLE_FRAMED_TRANSPORT = "disable_framed_transport";
    static final String KEY_DISABLE_ROTATION_HOST_RETRY = "disable_rotating_host_path_retry";
    static final String KEY_DYNAMIC_ADJUST_THREADPOOL_SIZE_OPEN = "dynamic_adjust_threadpool_size_open";
    static final String KEY_ENCRYPT_SWITCH = "android_log_encrypt_switch";
    static final String KEY_HTTP_DNS_ENABLED = "http_dns_enabled";
    static final String KEY_HTTP_SHOW_HIJACK = "http_show_hijack";
    static final String KEY_HTTP_VERIFY_SIGN = "http_verify_sign";
    static final String KEY_IMAGE_TTNET_ENABLED = "image_ttnet_enabled";
    static final String KEY_OK_HTTP3_OPEN = "ok_http3_open";
    static final String KEY_OK_HTTP_OPEN = "ok_http_open";
    static final String KEY_PP_FORCE_USE_SHARED_STREAM = "pp_force_use_shared_stream";
    static final String KEY_PRIVATE_PROTOCOL_ENABLED = "private_protocol_enabled";
    static final String KEY_SAMPLE_BAND_WIDTH_ENABLED = "sample_band_width_enabled";
    static final String KEY_SHARE_COOKIE_HOST_LIST = "share_cookie_host_list";
    static final String KEY_TNC_HOST_ARRAYS = "send_tnc_host_arrays";
    static final String KEY_TNC_SUMMARY = "tnc_summary";
    static final String KEY_TNC_UPDATE_INTERVAL = "tnc_update_interval";
    static final String KEY_USE_HTTP_DNS = "use_http_dns";
    static final String KEY_USE_HTTP_DNS_REFETCH_ON_EXPIRE = "use_http_dns_refetch_on_expire";
    static final int MSG_CONFIG_ERROR = 102;
    static final int MSG_CONFIG_OK = 101;
    static final int MSG_TNC_COLDSTART_DELAY = 104;
    static final int MSG_TNC_POLLING = 103;
    static final String SP_SS_APP_CONFIG = "ss_app_config";
    private static final String SYNC_MAIN_PROCESS_CONFIG_ACTION = "com.bytedance.ttnet.config.appconfig.SYNC_MAIN_PROCESS_CONFIG";
    static final String TAG = "AppConfig";
    private static String mFrontierUrls = "";
    private static AppConfig mInstance = null;
    private static ArrayList<String> sBlockModelList = null;
    static boolean sCronetUnsupportedModel = false;
    static boolean sDisableFallbackReasonBoot = false;
    static boolean sEnableFallbackReasonBootFix = true;
    static boolean sForceNotUseCronet = false;
    private static boolean sForceNotUseCronetHttpDns = false;
    private static String sPackageName = null;
    private static boolean sTestDeviceFingerPrint = false;
    private static boolean sTestSsQueries = false;
    private static int sUseHttpDns = -1;
    private static int sUseHttpDnsRefetchOnExpire = -1;
    private JSONObject mABTest;
    private int mAddDeviceFingerprintOpen;
    private int mAddSsQueriesHeaderOpen;
    private int mAddSsQueriesOpen;
    private int mAddSsQueriesPlaintextOpen;
    private List<String> mApiHttpHostList;
    private int mCdnSampleBandWidthEnabled;
    private volatile int mChromiumBootFailures;
    private long mChromiumBootFailuresTimestamp;
    private int mCollectRecentPageInfoEnable;
    private AtomicBoolean mConfigUpdating;
    private final Context mContext;
    private String mCronetSoPath;
    private int mCronetVersion;
    private int mDetectNativePage;
    private int mDetectOpen;
    private int mDynamicAdjustThreadPoolSizeOpen;
    private volatile int mEncryptSwitch;
    private volatile boolean mEncryptSwitchFromSP;
    final WeakHandler mHandler;
    private int mHttpDnsEnabled;
    private int mImageTtnetEnabled;
    private final boolean mIsMainProcess;
    private AtomicLong mLastRefreshTime;
    private volatile boolean mLocalLoaded;
    private final Object mLock;
    private int mOkHttp3Open;
    private int mOkHttpOpen;
    private AtomicBoolean mPreloadBootFailureInfo;
    private int mSampleBandWidthEnabled;
    private List<String> mShareCookieHostList;
    private String mTncEtag;
    private final List<String> mTncHostArrays;
    private String mTncSummary;
    private final AtomicInteger mTncUpdateInterval;

    static final class a extends PluginBroadcastReceiver {
        a() {
        }

        public void onReceive(Context r3, Intent r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L5;
            return;
        L5:
            if (AppConfig.SYNC_MAIN_PROCESS_CONFIG_ACTION.equals(r4.getAction()) == false) goto L9;
            final String r6 = "SyncMainProcessConfig";
            new AnonymousClass1(this, r6).a();
            return;
        }
    }

    static {
        ArrayList<String> r0 = new ArrayList();
        sBlockModelList = r0;
        sCronetUnsupportedModel = false;
        r0.add("MI PAD 2");
        sBlockModelList.add("YT3-X90L");
        sBlockModelList.add("YT3-X90F");
        sBlockModelList.add("GT-810");
        sForceNotUseCronetHttpDns = false;
        sTestSsQueries = false;
        sTestDeviceFingerPrint = false;
    }

    private AppConfig(Context r6, boolean r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        this.mLastRefreshTime = new AtomicLong(0);
        this.mConfigUpdating = new AtomicBoolean(false);
        this.mLock = new Object();
        this.mLocalLoaded = false;
        this.mOkHttpOpen = 0;
        this.mOkHttp3Open = 0;
        this.mChromiumBootFailures = -1;
        this.mChromiumBootFailuresTimestamp = 0;
        this.mPreloadBootFailureInfo = new AtomicBoolean(false);
        this.mHttpDnsEnabled = 0;
        this.mDetectOpen = 0;
        this.mDetectNativePage = 1;
        this.mCollectRecentPageInfoEnable = 1;
        this.mAddSsQueriesOpen = 0;
        this.mAddSsQueriesHeaderOpen = 0;
        this.mAddSsQueriesPlaintextOpen = 1;
        this.mImageTtnetEnabled = 1;
        this.mSampleBandWidthEnabled = 1;
        this.mCdnSampleBandWidthEnabled = 1;
        this.mAddDeviceFingerprintOpen = 1;
        this.mDynamicAdjustThreadPoolSizeOpen = 1;
        this.mCronetSoPath = "";
        this.mShareCookieHostList = new CopyOnWriteArrayList();
        this.mCronetVersion = 0;
        this.mApiHttpHostList = new CopyOnWriteArrayList();
        this.mTncEtag = "";
        this.mTncUpdateInterval = new AtomicInteger(10800);
        this.mTncHostArrays = new CopyOnWriteArrayList();
        this.mHandler = new WeakHandler(Looper.getMainLooper(), this);
        this.mContext = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");
        this.mIsMainProcess = r7;
    }

    static /* synthetic */ Context access$000(AppConfig r0) {
        return r0.mContext;
    }

    static /* synthetic */ String access$100() {
        return sPackageName;
    }

    private void getEncryptSwitchFromSP() {
        if (this.mEncryptSwitchFromSP == false) goto L5;
        return;
    L5:
        this.mEncryptSwitch = this.mContext.getSharedPreferences(SP_SS_APP_CONFIG, 0).getInt(KEY_ENCRYPT_SWITCH, 0);
        this.mEncryptSwitchFromSP = true;
    }

    public static List<String> getFrontierUrls() {
        if (TextUtils.isEmpty(mFrontierUrls) == false) goto L12;
        return null;
    L12:
        JSONArray r0 = new JSONArray(mFrontierUrls);     // Catch: Exception -> L11
        ArrayList r2 = new ArrayList();     // Catch: Exception -> L11
        int r3 = 0;
    L7:
        if (r3 >= r0.length()) goto L10;
        r2.add(r0.getString(r3));     // Catch: Exception -> L11
        r3 = r3 + 1;
        goto L7
    L10:
        return r2;
    L11:
        return null;
    }

    @Deprecated
    public static boolean getHttpVerifySign() {
        return true;
    }

    @Deprecated
    public static boolean getHttpsRetryHttp() {
        return false;
    }

    @Deprecated
    public static boolean getHttpsShowHijack() {
        return true;
    }

    @Deprecated
    public static boolean getHttpsToHttp() {
        return false;
    }

    public static AppConfig getInstance(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        monitor-enter(AppConfig.class);
    L27:
        th = move-exception;
        throw th;
    L5:
        if (mInstance != null) goto L24;
        boolean r1 = com.bytedance.frameworks.baselib.network.http.util.g.b(r7);     // Catch: Throwable -> L27
        mInstance = new AppConfig((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r1);     // Catch: Throwable -> L27
        if (sBlockModelList.contains(Build.MODEL) == false) goto L9;
        sCronetUnsupportedModel = true;     // Catch: Throwable -> L27
    L9:
        sPackageName = r7.getPackageName();     // Catch: Throwable -> L27
        if (r1 == false) goto L15;
        com.bytedance.frameworks.core.encrypt.a.a(mInstance);     // Catch: Throwable -> L27
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a(mInstance);     // Catch: Throwable -> L27
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a(mInstance);     // Catch: Throwable -> L27
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a(mInstance);     // Catch: Throwable -> L27
        com.bytedance.ttnet.c.a(mInstance);     // Catch: Throwable -> L27
        com.bytedance.frameworks.baselib.network.connectionclass.a.a().a(mInstance);     // Catch: Throwable -> L27
        com.bytedance.frameworks.baselib.network.http.f.a(mInstance);     // Catch: Throwable -> L27
        com.bytedance.frameworks.baselib.network.http.f.a(mInstance);     // Catch: Throwable -> L27
        if (com.bytedance.frameworks.baselib.network.http.f.f() != null) goto L23;
        com.bytedance.frameworks.baselib.network.http.f.j r2 = mInstance;     // Catch: Throwable -> L27
    L14:
        com.bytedance.frameworks.baselib.network.http.f.a(r2);     // Catch: Throwable -> L27
    L23:
        TTNetInitMetrics r3 = TTNetInitMetrics.c();     // Catch: Throwable -> L27
        r3.l = System.nanoTime();     // Catch: Throwable -> L27
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a(e.a(r7));     // Catch: Throwable -> L27
        TTNetInitMetrics r4 = TTNetInitMetrics.c();     // Catch: Throwable -> L27
        r4.m = System.nanoTime();     // Catch: Throwable -> L27
        com.bytedance.frameworks.baselib.network.http.f.a(mInstance);     // Catch: Throwable -> L27
        c.a(r7);     // Catch: Throwable -> L27
        goto L24
    L15:
        IntentFilter r5 = new IntentFilter();     // Catch: Throwable -> L27
        r5.addAction(SYNC_MAIN_PROCESS_CONFIG_ACTION);     // Catch: Throwable -> L27
        com.bytedance.ttnet.utils.d.a(r7, new a(), r5);     // Catch: Throwable -> L18
    L20:
        h r8 = h.a();     // Catch: Throwable -> L27
        com.bytedance.frameworks.core.encrypt.a.a(r8);     // Catch: Throwable -> L27
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a(r8);     // Catch: Throwable -> L27
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a(r8);     // Catch: Throwable -> L27
        com.bytedance.ttnet.c.a(r8);     // Catch: Throwable -> L27
        if (com.bytedance.frameworks.baselib.network.http.f.f() != null) goto L23;
        r2 = r8;
        goto L14
    L18:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L27
    L24:
        AppConfig r9 = mInstance;     // Catch: Throwable -> L27
        monitor-exit(AppConfig.class);     // Catch: Throwable -> L27
        return r9;
    }

    public static String getSsAppConfigFileName() {
        return SP_SS_APP_CONFIG;
    }

    public static boolean isCronetUnsupportedABI() {
        if (b.c() == false) goto L29;
        return isCronetUnsupportedABIv2();
    L29:
    L26:
        th = move-exception;
        th.printStackTrace();
    L28:
        return false;
    L8:
        if (Build.VERSION.SDK_INT >= 21) goto L10;
        String r1 = Build.CPU_ABI;     // Catch: Throwable -> L26
    L12:
        if (TextUtils.isEmpty(r1) == false) goto L15;
        return false;
    L15:
        if ("x86".equalsIgnoreCase(r1) == true) goto L20;
        if ("x86_64".equalsIgnoreCase(r1) == false) goto L28;
    L20:
        if (com.bytedance.ttnet.a.a.a() == false) goto L23;
        Logger.d(TAG, "x86 support");     // Catch: Throwable -> L26
        return false;
    L23:
        Logger.w(TAG, "Cronet unsupported CPU arch: " + r1);     // Catch: Throwable -> L26
        o.a(2);     // Catch: Throwable -> L26
        return true;
    L10:
        r1 = Build.SUPPORTED_ABIS[0];     // Catch: Throwable -> L26
        goto L12
    }

    private static boolean isCronetUnsupportedABIv2() {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        String[] r0 = Build.SUPPORTED_ABIS;
        int r4 = r0.length;
        int r5 = 0;
    L10:
        if (r5 >= r4) goto L15;
        if (r0[r5].contains("arm") == true) goto L13;
        r5 = r5 + 1;
    L13:
        boolean r1 = true;
    L17:
        if (r1 == false) goto L22;
        if (o.e() != 2) goto L27;
        o.a(-1);
    L27:
        if (Logger.debug() == false) goto L30;
        Logger.d(TAG, "use isCronetUnsupportedABIv2, result is " + (!r1));
    L30:
        return !r1;
    L22:
        if (com.bytedance.ttnet.a.a.a() == false) goto L25;
        Logger.d(TAG, "x86 support");
        return false;
    L25:
        o.a(2);
    L15:
        r1 = false;
        goto L17
    L5:
        if (Build.CPU_ABI.contains("arm") == true) goto L13;
        if (Build.CPU_ABI2.contains("arm") == false) goto L15;
        goto L15
    }

    private boolean isDidEmpty() {
        if (getConfigServers() != null) goto L5;
    L26:
        return true;
    L5:
        if (getConfigServers().length < 1) goto L26;
        String r6 = getConfigServers()[0];
        if (TextUtils.isEmpty(r6) == false) goto L10;
        return true;
    L10:
        String r7 = ReportConsts.HTTPS + r6 + "/get_domains/v5/";
        String r4 = com.bytedance.frameworks.baselib.network.http.f.a(r7, true, null);
        if (r7.equals(r4) == false) goto L13;
        return true;
    L13:
        LinkedHashMap r8 = new LinkedHashMap();
        k.b(r4, r8);     // Catch: Exception -> L27
        if (r8.containsKey("device_id") == true) goto L17;
        return true;
    L17:
        List r9 = (List) ZeusTransformUtils.preCheckCast(r8.get("device_id"), List.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L27
        if (r9 != null) goto L20;
        return true;
    L20:
        Iterator r10 = r9.iterator();     // Catch: Exception -> L27
    L22:
        if (r10.hasNext() == false) goto L26;
        if (((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin")).equals("0") == true) goto L22;
        return false;
    }

    private void mergeShareCookieHosts() {
        String r0 = TTNetInit.getTTNetDepend().e();
        if (com.bytedance.common.utility.h.a(r0) == false) goto L5;
        return;
    L5:
        if (com.bytedance.ttnet.utils.d.a(r0, this.mShareCookieHostList) == true) goto L9;
        this.mShareCookieHostList.add(r0);
        return;
    }

    private void reportShareCookieLog(JSONObject r3, String r4) {
        if (r3 != null) goto L8;
        return;
    L8:
        r3.put("return", r4);     // Catch: JSONException -> L7
        r3.put("CurrentShareCookieHostList", this.mShareCookieHostList.toString());     // Catch: JSONException -> L7
    L5:
        TTNetInit.getTTNetDepend().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "handleResponse", "shareCookieHostList", r3);
    }

    public static void setTestFingerPrint(boolean r0) {
        sTestDeviceFingerPrint = r0;
    }

    public static void setTestQuery(boolean r0) {
        sTestSsQueries = r0;
    }

    private void tryRefreshConfigInternal(TNCManager.TNCUpdateSource r3, boolean r4) {
        if (this.mIsMainProcess == false) goto L6;
        doRefresh(r3, r4);
        return;
    L6:
        if (this.mLastRefreshTime.get() > 0) goto L13;
        final String r5 = "LoadDomainConfig4Other-Thread";
        new AnonymousClass1(this, r5).a();     // Catch: Throwable -> L9
        return;
    L14:
        return;
    }

    public boolean cdnShouldSampling(String r3) {
        if (com.bytedance.common.utility.h.a(r3) == false) goto L6;
        return false;
    L6:
        if (this.mCdnSampleBandWidthEnabled > 0) goto L21;
        return false;
    L21:
        URI r2 = i.a(r3);     // Catch: Throwable -> L18
        if (r2 != null) goto L11;
        return false;
    L11:
        String r4 = r2.getHost();     // Catch: Throwable -> L18
        if (com.bytedance.common.utility.h.a(r4) == false) goto L14;
        return false;
    L14:
        if (r4.endsWith(com.bytedance.ttnet.b.b()) == false) goto L20;
        return true;
    L20:
        return false;
    L18:
        th = move-exception;
        th.printStackTrace();
        goto L20
    }

    public boolean doRefresh(final TNCManager.TNCUpdateSource r5, final boolean r6) {
        if (Logger.debug() == false) goto L6;
        Logger.d("TNCManager", "doRefresh: updating state " + this.mConfigUpdating.get());
    L6:
        if (this.mConfigUpdating.compareAndSet(false, true) == false) goto L8;
    L13:
        final String r1 = "AppConfigThread";
        new AnonymousClass2(this, r1, r5, r6).a();
        return true;
    L8:
        if (r5 == TNCManager.TNCUpdateSource.TTCRONETFAILED) goto L13;
        if (Logger.debug() == false) goto L12;
        Logger.d("TNCManager", "doRefresh, already running " + r5);
    L12:
        return false;
    }

    @Deprecated
    public void enableNewCronetBootFallback(boolean r1) {
    }

    public String filterUrl(String r3) {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L7;
        return filterUrlOnUIThread(r3);
    L7:
        return filterUrl(r3, null);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.f.e
    @Deprecated
    public String filterUrl(String r1, com.bytedance.frameworks.baselib.network.http.c r2) {
        if (com.bytedance.common.utility.h.a(r1) == false) goto L14;
        return r1;
    L14:
    L10:
        th = move-exception;
        th.printStackTrace();
    L12:
        return r1;
    L6:
        if (this.mIsMainProcess == false) goto L8;
        tryLoadLocalConfig();     // Catch: Throwable -> L10
    L13:
        goto L12
    L8:
        tryLoadDomainConfig4OtherProcess();     // Catch: Throwable -> L10
        goto L13
    }

    @Deprecated
    public String filterUrlOnUIThread(String r1) {
        if (com.bytedance.common.utility.h.a(r1) == false) goto L10;
        return r1;
    L10:
        return TNCManager.c().a(r1);
    L7:
        th = move-exception;
        th.printStackTrace();
        return r1;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.h.d
    public JSONObject getABTest() {
        return this.mABTest;
    }

    public String[] getConfigServers() {
        String[] r1 = TTNetInit.getTTNetDepend().b();
        if (r1 == null) goto L7;
        if (r1.length <= 0) goto L7;
        return r1;
    L7:
        return new String[0];
    }

    public String getCronetSoPath() {
        return this.mCronetSoPath;
    }

    public synchronized int getCronetVersion() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mLocalLoaded == false) goto L8;
        int r0 = this.mCronetVersion;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    L8:
        int r1 = this.mContext.getSharedPreferences(SP_SS_APP_CONFIG, 0).getInt(KEY_CRONET_VERSION, 0);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    }

    public boolean getEncryptSwitch() {
        getEncryptSwitchFromSP();
        if (this.mEncryptSwitch != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.f.j
    public List<String> getShareCookie(CookieManager r5, com.bytedance.frameworks.baselib.network.http.impl.b r6, URI r7) {
        if (r7 == null) goto L34;
        if (r5 != null) goto L7;
        if (r6 == null) goto L34;
    L7:
        String r1 = TTNetInit.getTTNetDepend().e();
        if (com.bytedance.common.utility.h.a(r1) == false) goto L35;
        return null;
    L35:
        String r2 = r7.getHost();     // Catch: Exception -> L12
    L14:
        if (com.bytedance.common.utility.h.a(r2) == true) goto L34;
        if (com.bytedance.ttnet.utils.d.a(r2, this.mShareCookieHostList) == false) goto L34;
        ArrayList r4 = new ArrayList();
        if (r5 == null) goto L25;
        String r8 = r5.getCookie(r7.getScheme() + "://" + r1);
        if (com.bytedance.common.utility.h.a(r8) == true) goto L25;
        r4.add(r8);
        return r4;
    L25:
        if (com.bytedance.common.utility.d.a(r4) == false) goto L33;
        if (r6 == null) goto L33;
        String r9 = r6.a(URI.create(r7.getScheme() + "://" + r1));     // Catch: Throwable -> L31
        if (com.bytedance.common.utility.h.a(r9) == true) goto L33;
        r4.add(r9);     // Catch: Throwable -> L31
        r4.add("x-tt-cookie-backup-source=1");     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        th.printStackTrace();
    L33:
        return r4;
    L12:
        r2 = null;
    L34:
        return null;
    }

    public List<String> getShareCookieHostList() {
        ArrayList r0 = new ArrayList();
        Iterator<String> r4 = this.mShareCookieHostList.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r1) == true) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.f.j
    public List<String> getShareCookieHostList(String r2) {
        if (com.bytedance.ttnet.utils.d.a(r2, this.mShareCookieHostList) == true) goto L5;
        return null;
    L5:
        return this.mShareCookieHostList;
    }

    public List<String> getTncHostArrays() {
        return this.mTncHostArrays;
    }

    public String getTncRules() {
        return this.mTncSummary;
    }

    public void handleConfigUpdate(String r1) {
    }

    public void handleConfigUpdate(String r8, Object r9) {
        if (d.a(r9) == true) goto L22;
        return;
    L22:
        boolean r10 = handleResponse(r9, TNCManager.TNCUpdateSource.TTCRONET, System.currentTimeMillis(), false);     // Catch: Exception -> L7
    L9:
        int r0 = 102;
        if (r10 == false) goto L20;
        r0 = 101;
    L20:
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L14
        r11.put("from", "cronet");     // Catch: Throwable -> L14
        TTNetInit.getTTNetDepend().a(this.mContext, r11);     // Catch: Throwable -> L14
    L24:
        handleConfigUpdate(r8);     // Catch: Throwable -> L19
    L17:
        this.mHandler.sendEmptyMessage(r0);
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
    L7:
        e = move-exception;
        e.printStackTrace();
        r10 = false;
        goto L9
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r5) {
        switch(r5.what) {
            case 101: goto L17;
            case 102: goto L15;
            case 103: goto L10;
            case 104: goto L6;
            default: goto L24;
        };
    L17:
        this.mLastRefreshTime.set(System.currentTimeMillis());
        if (Logger.debug() == false) goto L21;
        String r6 = "doRefresh, succ";
    L20:
        Logger.d("TNCManager", r6);
    L21:
        this.mConfigUpdating.set(false);
        return;
    L24:
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("TNCManager", "did is empty, delay request tnc");
    L8:
        TNCManager.TNCUpdateSource r7 = TNCManager.TNCUpdateSource.TTSERVER;
    L13:
        tryRefreshConfig(r7);
        return;
    L10:
        if (Logger.debug() == false) goto L12;
        Logger.d("TNCManager", "do tnc polling");
    L12:
        r7 = TNCManager.TNCUpdateSource.TTPOLL;
        goto L13
    L15:
        if (Logger.debug() == false) goto L21;
        r6 = "doRefresh, error";
        goto L20
    }

    public boolean handleResponse(Object r41, TNCManager.TNCUpdateSource r42, long r43, boolean r45) {
        JSONObject r9 = new JSONObject();
        if (ZeusTransformUtils.instanceOf(r41, String.class) == false) goto L11;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r41, String.class, "com.obric.memorydata.plugin");
        if (com.bytedance.common.utility.h.a(r0) == false) goto L9;
        String r1 = "empty response.";
    L7:
        reportShareCookieLog(r9, r1);
        return false;
    L9:
        JSONObject r5 = new JSONObject(r0);
    L17:
        if (r5 != null) goto L19;
        r1 = "object is null.";
        goto L7
    L19:
        this.mTncSummary = r5.optString("summary");
        JSONObject r11 = r5.getJSONObject("data");
        sUseHttpDns = r11.optInt(KEY_USE_HTTP_DNS, -1);
        sUseHttpDnsRefetchOnExpire = r11.optInt(KEY_COLLECT_RECENT_PAGE_INFO_ENABLE, -1);
        int r6 = r11.optInt(KEY_OK_HTTP_OPEN, 0);
        int r7 = r11.optInt(KEY_OK_HTTP3_OPEN, 0);
        int r8 = r11.optInt(KEY_CRONET_VERSION, 0);
        int r10 = r11.optInt(KEY_HTTP_DNS_ENABLED, 0);
        int r12 = r11.optInt(KEY_DETECT_OPEN, 0);
        int r13 = r11.optInt(KEY_DETECT_NATIVE_PAGE, 1);
        int r14 = r11.optInt(KEY_COLLECT_RECENT_PAGE_INFO_ENABLE, 1);
        int r2 = r11.optInt(KEY_ADD_SS_QUERIES_OPEN, 0);
        int r15 = r11.optInt(KEY_ADD_SS_QUERIES_HEADER_OPEN, 0);
        int r4 = r11.optInt(KEY_ADD_SS_QUERIES_PLAINTEXT_OPEN, 1);
        int r16 = r11.optInt(KEY_ADD_DEVICE_FINGERPRINT_OPEN, 1);
        int r3 = r11.optInt(KEY_IMAGE_TTNET_ENABLED, 1);
        int r17 = r11.optInt(KEY_SAMPLE_BAND_WIDTH_ENABLED, 1);
        int r18 = r11.optInt(KEY_CDN_SAMPLE_BAND_WIDTH_ENABLED, 1);
        int r19 = r11.optInt(KEY_DYNAMIC_ADJUST_THREADPOOL_SIZE_OPEN, 1);
        int r20 = r11.optInt(KEY_HTTP_SHOW_HIJACK, 1);
        int r21 = r11.optInt(KEY_HTTP_VERIFY_SIGN, 1);
        int r22 = r11.optInt(KEY_TNC_UPDATE_INTERVAL, -1);
        if (r22 <= 0) goto L22;
        this.mTncUpdateInterval.set(r22);
    L22:
        int r23 = r11.optInt(KEY_PRIVATE_PROTOCOL_ENABLED, 1);
        if (r23 < 1) goto L25;
        boolean r24 = true;
    L26:
        com.bytedance.frameworks.baselib.network.http.f.e(r24);
        int r110 = r11.optInt(KEY_DESTROY_DELTA_MILLIS, 100);
        if (r110 < 0) goto L29;
        com.bytedance.frameworks.baselib.network.http.f.a(r110);
    L29:
        int r111 = r11.optInt(KEY_DISABLE_ROTATION_HOST_RETRY, -1);
        if (r111 < 1) goto L32;
        boolean r25 = true;
    L33:
        com.bytedance.frameworks.baselib.network.http.f.d(r25);
        JSONArray r26 = r11.optJSONArray(KEY_TNC_HOST_ARRAYS);
        if (r26 == null) goto L44;
        this.mTncHostArrays.clear();
        int r27 = 0;
    L37:
        if (r27 >= r26.length()) goto L43;
        if (TextUtils.isEmpty(r26.optString(r27)) == true) goto L42;
        this.mTncHostArrays.add(r26.optString(r27));
    L42:
        r27 = r27 + 1;
        r16 = r16;
        goto L37
    L43:
        int r29 = r16;
    L45:
        int r28 = r11.optInt(KEY_CRASH_LIMIT_TIMES, 0);
        int r30 = r11.optInt(KEY_CRASH_DETECT_INTERVAL_MS, 5000);
        monitor-enter(this);
        this.mOkHttpOpen = r6;     // Catch: Throwable -> L151
        this.mOkHttp3Open = r7;     // Catch: Throwable -> L151
        this.mCronetVersion = r8;     // Catch: Throwable -> L151
        this.mHttpDnsEnabled = r10;     // Catch: Throwable -> L151
        this.mDetectOpen = r12;     // Catch: Throwable -> L151
        this.mDetectNativePage = r13;     // Catch: Throwable -> L151
        this.mCollectRecentPageInfoEnable = r14;     // Catch: Throwable -> L151
        this.mAddSsQueriesOpen = r2;     // Catch: Throwable -> L151
        this.mAddSsQueriesHeaderOpen = r15;     // Catch: Throwable -> L151
        this.mAddSsQueriesPlaintextOpen = r4;     // Catch: Throwable -> L151
        int r112 = r29;
        this.mAddDeviceFingerprintOpen = r112;     // Catch: Throwable -> L151
        this.mDynamicAdjustThreadPoolSizeOpen = r19;     // Catch: Throwable -> L151
        this.mImageTtnetEnabled = r3;     // Catch: Throwable -> L151
        this.mSampleBandWidthEnabled = r17;     // Catch: Throwable -> L151
        this.mCdnSampleBandWidthEnabled = r18;     // Catch: Throwable -> L151
        monitor-exit(this);     // Catch: Throwable -> L151
        if (r19 <= 0) goto L51;
        boolean r31 = true;
    L52:
        com.bytedance.frameworks.baselib.network.dispatcher.e.a(r31);
        if (r11.optInt("enable_req_ticket", 1) <= 0) goto L55;
        boolean r32 = true;
    L56:
        com.bytedance.ttnet.utils.c.a(r32);
        com.bytedance.ttnet.utils.a.C0168a r33 = com.bytedance.ttnet.utils.a.a(r11);
        if (this.mAddSsQueriesOpen <= 0) goto L59;
    L60:
        com.bytedance.ttnet.retrofit.b.a(true);
    L61:
        com.bytedance.frameworks.baselib.network.http.parser.d.a(r11);
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a(r11, null);
        String r34 = r11.optString(WsConstants.KEY_FRONTIER_URLS, "");
        String r35 = r11.optString(KEY_SHARE_COOKIE_HOST_LIST, "");
        TTNetInit.getTTNetDepend().a(r35);
        String r36 = r11.optString(KEY_API_HTTP_HOST_LIST, "");
        String r37 = r11.optString(KEY_CONCURRENT_REQUEST_CONFIG, "");
        com.bytedance.frameworks.baselib.network.http.cronet.impl.e.a().a(r37);
        String r38 = r11.optString(KEY_COMMON_PARAMS_CONFIG, "");
        com.bytedance.frameworks.baselib.network.http.a.a r39 = com.bytedance.frameworks.baselib.network.http.a.b.a().b();
        if (r39 == null) goto L64;
        r39.a(r38);
    L64:
        String r40 = r11.optString("L0_params", "");
        com.bytedance.frameworks.baselib.network.c.d.a().b(r40);
        int r113 = r11.optInt("query_filter_enabled", Integer.MIN_VALUE);
        String r44 = d.a(r41, r11, new String[]{"data", "query_filter_actions"});
        if (r113 == Integer.MIN_VALUE) goto L71;
        com.bytedance.frameworks.baselib.network.c.d r46 = com.bytedance.frameworks.baselib.network.c.d.a();
        if (r113 <= 0) goto L69;
        boolean r47 = true;
    L70:
        r46.a(r47);
        com.bytedance.frameworks.baselib.network.c.d.a().a(r44);
        goto L71
    L69:
        r47 = false;
    L71:
        this.mEncryptSwitch = r11.optInt("disable_encrypt_switch", 0);
        this.mCronetSoPath = r11.optString(KEY_CRONET_SO_PATH, "");
        if (this.mEncryptSwitch != 2) goto L74;
        int r114 = 0;
        SharedPreferences.Editor r48 = this.mContext.getSharedPreferences("app_log_encrypt_switch_count", 0).edit();
        r48.putInt("app_log_encrypt_faild_count", 0);
        com.bytedance.common.utility.c.a.a(r48);
    L75:
        int r49 = r11.optInt(KEY_DISABLE_FRAMED_TRANSPORT, r114);
        if (r49 > 0) goto L158;
    L81:
        int r50 = r11.optInt(KEY_PP_FORCE_USE_SHARED_STREAM, r114);
        if (r50 < 1) goto L84;
        boolean r210 = true;
    L85:
        com.bytedance.frameworks.baselib.network.http.f.f(r210);
        monitor-enter(this);
        SharedPreferences r115 = this.mContext.getSharedPreferences(SP_SS_APP_CONFIG, 0);     // Catch: Throwable -> L148
        String r51 = r115.getString(KEY_SHARE_COOKIE_HOST_LIST, "");     // Catch: Throwable -> L148
        SharedPreferences.Editor r116 = r115.edit();     // Catch: Throwable -> L148
        r116.putString("ttnet_response_verify", r33.f3329b);     // Catch: Throwable -> L148
        r116.putInt("ttnet_response_verify_enabled", r33.f3328a);     // Catch: Throwable -> L148
        com.bytedance.frameworks.baselib.network.http.parser.d.a(r116);     // Catch: Throwable -> L148
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a(r116);     // Catch: Throwable -> L148
        r116.putInt(KEY_OK_HTTP_OPEN, r6);     // Catch: Throwable -> L148
        r116.putInt(KEY_OK_HTTP3_OPEN, r7);     // Catch: Throwable -> L148
        r116.putInt(KEY_CRONET_VERSION, r8);     // Catch: Throwable -> L148
        r116.putInt(KEY_HTTP_DNS_ENABLED, r10);     // Catch: Throwable -> L148
        r116.putInt(KEY_DETECT_OPEN, r12);     // Catch: Throwable -> L148
        r116.putInt(KEY_DETECT_NATIVE_PAGE, r13);     // Catch: Throwable -> L148
        r116.putInt(KEY_COLLECT_RECENT_PAGE_INFO_ENABLE, r14);     // Catch: Throwable -> L148
        r116.putInt(KEY_ADD_SS_QUERIES_OPEN, r2);     // Catch: Throwable -> L148
        r116.putInt(KEY_ADD_SS_QUERIES_HEADER_OPEN, r15);     // Catch: Throwable -> L148
        r116.putInt(KEY_ADD_SS_QUERIES_PLAINTEXT_OPEN, r4);     // Catch: Throwable -> L148
        r116.putInt(KEY_ADD_DEVICE_FINGERPRINT_OPEN, r112);     // Catch: Throwable -> L148
        r116.putInt(KEY_DYNAMIC_ADJUST_THREADPOOL_SIZE_OPEN, r19);     // Catch: Throwable -> L148
        r116.putInt(KEY_IMAGE_TTNET_ENABLED, r3);     // Catch: Throwable -> L148
        r116.putInt(KEY_USE_HTTP_DNS, sUseHttpDns);     // Catch: Throwable -> L148
        r116.putInt(KEY_USE_HTTP_DNS_REFETCH_ON_EXPIRE, sUseHttpDnsRefetchOnExpire);     // Catch: Throwable -> L148
        r116.putInt(KEY_HTTP_SHOW_HIJACK, r20);     // Catch: Throwable -> L148
        r116.putInt(KEY_HTTP_VERIFY_SIGN, r21);     // Catch: Throwable -> L148
        r116.putInt(KEY_CRASH_LIMIT_TIMES, r28);     // Catch: Throwable -> L148
        r116.putInt(KEY_CRASH_DETECT_INTERVAL_MS, r30);     // Catch: Throwable -> L148
        r116.putString(WsConstants.KEY_FRONTIER_URLS, r34);     // Catch: Throwable -> L148
        r116.putString(KEY_CRONET_SO_PATH, this.mCronetSoPath);     // Catch: Throwable -> L148
        r116.putString(KEY_SHARE_COOKIE_HOST_LIST, r35);     // Catch: Throwable -> L148
        r9.put("oldShareCookieHosts", r51);     // Catch: Throwable -> L148
        r9.put("newShareCookieHosts", r35);     // Catch: Throwable -> L148
        if (TextUtils.isEmpty(r35) == true) goto L90;
        this.mShareCookieHostList.clear();     // Catch: Throwable -> L148
        com.bytedance.ttnet.utils.d.b(r35, this.mShareCookieHostList);     // Catch: Throwable -> L148
    L90:
        mergeShareCookieHosts();     // Catch: Throwable -> L148
        r116.putString(KEY_API_HTTP_HOST_LIST, r36);     // Catch: Throwable -> L148
        r116.putString(KEY_CONCURRENT_REQUEST_CONFIG, r37);     // Catch: Throwable -> L148
        r116.putString(KEY_COMMON_PARAMS_CONFIG, r38);     // Catch: Throwable -> L148
        r116.putString("query_filter_actions", r44);     // Catch: Throwable -> L148
        r116.putString("L0_params", r40);     // Catch: Throwable -> L148
        int r117 = r113;
        r116.putInt("query_filter_enabled", r117);     // Catch: Throwable -> L148
        String[] r52 = r36.split(",");     // Catch: Throwable -> L148
        int r118 = r52.length;     // Catch: Throwable -> L148
        int r119 = 0;
    L91:
        if (r119 >= r118) goto L99;
        int r120 = r118;
        String r121 = r52[r119];     // Catch: Throwable -> L148
        if (com.bytedance.common.utility.h.a(r121) == true) goto L97;
        String[] r122 = r52;
        if (com.bytedance.ttnet.utils.d.a(r121, this.mApiHttpHostList) == true) goto L98;
        this.mApiHttpHostList.add(r121.trim());     // Catch: Throwable -> L148
    L98:
        r119 = r119 + 1;     // Catch: Throwable -> L148
        r118 = r120;
        r52 = r122;
        goto L91
    L97:
        r122 = r52;
        goto L98
    L99:
        r116.putInt(KEY_ENCRYPT_SWITCH, this.mEncryptSwitch);     // Catch: Throwable -> L148
        r116.putInt(KEY_IMAGE_TTNET_ENABLED, this.mImageTtnetEnabled);     // Catch: Throwable -> L148
        r116.putInt(KEY_SAMPLE_BAND_WIDTH_ENABLED, this.mSampleBandWidthEnabled);     // Catch: Throwable -> L148
        r116.putInt(KEY_CDN_SAMPLE_BAND_WIDTH_ENABLED, this.mCdnSampleBandWidthEnabled);     // Catch: Throwable -> L148
        r116.putInt(KEY_DISABLE_FRAMED_TRANSPORT, r49);     // Catch: Throwable -> L148
        r116.putInt(KEY_TNC_UPDATE_INTERVAL, this.mTncUpdateInterval.get());     // Catch: Throwable -> L148
        int r123 = r23;
        r116.putInt(KEY_PRIVATE_PROTOCOL_ENABLED, r123);     // Catch: Throwable -> L148
        r116.putInt(KEY_DESTROY_DELTA_MILLIS, r110);     // Catch: Throwable -> L148
        r116.putInt(KEY_DISABLE_ROTATION_HOST_RETRY, r111);     // Catch: Throwable -> L148
        r116.putInt(KEY_PP_FORCE_USE_SHARED_STREAM, r50);     // Catch: Throwable -> L148
        StringBuilder r53 = new StringBuilder();     // Catch: Throwable -> L148
        int r54 = 0;
    L101:
        if (r54 >= this.mTncHostArrays.size()) goto L106;
        int r124 = r123;
        int r310 = r117;
        r53.append((String) ZeusTransformUtils.preCheckCast(this.mTncHostArrays.get(r54), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L148
        if (r54 == this.mTncHostArrays.size()) goto L105;
        r53.append(',');     // Catch: Throwable -> L148
    L105:
        r54 = r54 + 1;     // Catch: Throwable -> L148
        r123 = r124;
        r117 = r310;
        goto L101
    L106:
        int r311 = r117;
        int r125 = r123;
        String r55 = r53.toString();     // Catch: Throwable -> L148
        if (TextUtils.isEmpty(r55) == true) goto L110;
        r116.putString(KEY_TNC_HOST_ARRAYS, r55);     // Catch: Throwable -> L148
    L110:
        if (TextUtils.isEmpty(this.mTncSummary) == true) goto L112;
        r116.putString(KEY_TNC_SUMMARY, this.mTncSummary);     // Catch: Throwable -> L148
    L112:
        com.bytedance.common.utility.c.a.a(r116);     // Catch: Throwable -> L148
        LinkedHashMap r56 = new LinkedHashMap();     // Catch: Throwable -> L123
        if (com.bytedance.common.utility.h.a(r34) == false) goto L116;
    L118:
        r56.put(KEY_HTTP_DNS_ENABLED, Integer.valueOf(r10));     // Catch: Throwable -> L123
        r56.put(KEY_ADD_SS_QUERIES_OPEN, Integer.valueOf(r2));     // Catch: Throwable -> L123
        r56.put(KEY_ADD_SS_QUERIES_HEADER_OPEN, Integer.valueOf(r15));     // Catch: Throwable -> L123
        r56.put(KEY_ADD_SS_QUERIES_PLAINTEXT_OPEN, Integer.valueOf(r4));     // Catch: Throwable -> L123
        r56.put(KEY_SHARE_COOKIE_HOST_LIST, r35);     // Catch: Throwable -> L123
        r56.put(KEY_DISABLE_FRAMED_TRANSPORT, Integer.valueOf(r49));     // Catch: Throwable -> L123
        r56.put("query_filter_actions", r44);     // Catch: Throwable -> L123
        r56.put("L0_params", r40);     // Catch: Throwable -> L123
        r56.put("query_filter_enabled", Integer.valueOf(r311));     // Catch: Throwable -> L123
        r56.put(KEY_PRIVATE_PROTOCOL_ENABLED, Integer.valueOf(r125));     // Catch: Throwable -> L123
        r56.put(KEY_DISABLE_ROTATION_HOST_RETRY, Integer.valueOf(r111));     // Catch: Throwable -> L123
        r56.put(KEY_PP_FORCE_USE_SHARED_STREAM, Integer.valueOf(r50));     // Catch: Throwable -> L123
        TTNetInit.getTTNetDepend().a(this.mContext, r56);     // Catch: Throwable -> L123
        Intent r57 = new Intent(SYNC_MAIN_PROCESS_CONFIG_ACTION);     // Catch: Throwable -> L123
        if (TextUtils.isEmpty(sPackageName) == true) goto L121;
        r57.setPackage(sPackageName);     // Catch: Throwable -> L123
    L121:
        this.mContext.sendBroadcast(r57);     // Catch: Throwable -> L123
    L125:
        monitor-exit(this);     // Catch: Throwable -> L148
        if (com.bytedance.common.utility.h.a(r35) == true) goto L130;
        g.a().a(r51, r35);
    L130:
        if (c.a() == null) goto L132;
        JSONObject r58 = r11;
        c.a().a(r58);
    L134:
        if (TNCManager.c().e() != null) goto L136;
        boolean r59 = true;
    L146:
        reportShareCookieLog(r9, "return true");
        return r59;
    L136:
        if (d.b() == true) goto L138;
    L142:
        JSONObject r126 = r58;
        r59 = true;
        TNCManager.c().e().a(r126, r42, this.mTncEtag, "", r43);
    L143:
        if (r45 == false) goto L146;
        com.bytedance.frameworks.baselib.network.http.d.b.a().b();
        goto L146
    L138:
        if (ZeusTransformUtils.instanceOf(r41, d.b.class) == false) goto L142;
        if (b.b() == false) goto L142;
        TNCManager.c().e().a(r41, r42, this.mTncEtag, "", r43);
        r59 = true;
        goto L143
    L132:
        r58 = r11;
        goto L134
    L116:
        if (r34.equals(mFrontierUrls) == true) goto L118;
        mFrontierUrls = r34;     // Catch: Throwable -> L123
        r56.put(WsConstants.KEY_FRONTIER_URLS, r34);     // Catch: Throwable -> L123
    L123:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L148
    L148:
        th = move-exception;
        throw th;
    L84:
        r210 = false;
        goto L85
    L158:
        com.bytedance.frameworks.baselib.network.http.ok3.impl.e.a(r49);     // Catch: Throwable -> L79
    L79:
        th = move-exception;
        th.printStackTrace();
        goto L81
    L74:
        r114 = 0;
        goto L75
    L59:
        if (this.mAddSsQueriesHeaderOpen <= 0) goto L61;
    L55:
        r32 = false;
        goto L56
    L51:
        r31 = false;
    L151:
        th = move-exception;
        throw th;
    L44:
        r29 = r16;
        goto L45
    L32:
        r25 = false;
        goto L33
    L25:
        r24 = false;
        goto L26
    L11:
        if (ZeusTransformUtils.instanceOf(r41, JSONObject.class) == false) goto L14;
        r5 = (JSONObject) ZeusTransformUtils.preCheckCast(r41, JSONObject.class, "com.obric.memorydata.plugin");
        goto L17
    L14:
        if (ZeusTransformUtils.instanceOf(r41, d.b.class) == false) goto L16;
        r5 = ((d.b) ZeusTransformUtils.preCheckCast(r41, d.b.class, "com.obric.memorydata.plugin")).b();
        goto L17
    L16:
        r5 = null;
        goto L17
    }

    @Override // com.bytedance.ttnet.c.b
    public boolean isChromiumOpen() {
        if (sEnableFallbackReasonBootFix == false) goto L8;
        if (this.mPreloadBootFailureInfo.compareAndSet(false, true) == false) goto L8;
        preloadCronetBootFailureInfo();
    L8:
        if (sForceNotUseCronet == false) goto L12;
        o.a(0);
        return false;
    L12:
        if (sCronetUnsupportedModel == false) goto L16;
        o.a(8);
        return false;
    L16:
        if (isCronetUnsupportedABI() == false) goto L19;
        return false;
    L19:
        if (sDisableFallbackReasonBoot == true) goto L25;
        if (this.mChromiumBootFailures <= 5) goto L25;
        o.a(3);
        Logger.e(TAG, "After five consecutive crashes of cronet, you must reinstall app to enable cronet, or wait until several hours");
        return false;
    L25:
        if (TTNetInit.getTTNetDepend().a() == true) goto L28;
        o.a(6);
        return false;
    L28:
        return true;
    }

    public boolean isCollectRecentPageInfoEnable() {
        if (this.mCollectRecentPageInfoEnable <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a
    public boolean isCronetBootFailureExpected() {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "isCronetBootFailureExpected...");
    L5:
        boolean r3 = false;
        SharedPreferences r0 = this.mContext.getSharedPreferences(SP_SS_APP_CONFIG, 0);
        if (sEnableFallbackReasonBootFix == true) goto L16;
        if (this.mChromiumBootFailures >= 0) goto L10;
        this.mChromiumBootFailures = r0.getInt(KEY_CHROMIUM_BOOT_FAILURES, 0);
    L10:
        this.mChromiumBootFailuresTimestamp = r0.getLong(KEY_CHROMIUM_BOOT_FAILURES_TIMESTAMP, 0);
        if (this.mChromiumBootFailures <= 5) goto L16;
        if ((System.currentTimeMillis() - this.mChromiumBootFailuresTimestamp) <= TimeUnit.HOURS.toMillis(1)) goto L16;
        this.mChromiumBootFailures = 5;
    L16:
        if (isChromiumOpen() == false) goto L24;
        SharedPreferences.Editor r1 = r0.edit();
        r3 = true;
        r1.putInt(KEY_CHROMIUM_BOOT_FAILURES, this.mChromiumBootFailures + 1);
        r1.putLong(KEY_CHROMIUM_BOOT_FAILURES_TIMESTAMP, System.currentTimeMillis());
        if (Logger.debug() == false) goto L20;
        Logger.d(TAG, "KEY_CHROMIUM_BOOT_FAILURES inc...");
    L20:
        com.bytedance.common.utility.c.a.a(r1);
        final LinkedHashMap r2 = new LinkedHashMap();
        r2.put(KEY_CHROMIUM_BOOT_FAILURES, Integer.valueOf(this.mChromiumBootFailures + 1));
        if (TTNetInit.getCronetProvider().getOptInit() == false) goto L23;
        final String r4 = "SaveMapToProvider-Thread";
        new AnonymousClass4(this, r4, r2).a();
        goto L24
    L23:
        TTNetInit.getTTNetDepend().a(this.mContext, r2);
    L24:
        return r3;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.h.b
    public boolean isCronetHttpDnsOpen() {
        if (sForceNotUseCronetHttpDns == false) goto L6;
        return false;
    L6:
        if (this.mHttpDnsEnabled <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean isDetectNativePage() {
        if (this.mDetectNativePage <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isDetectOpen() {
        if (this.mDetectOpen <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isDeviceFingerPrintOpen() {
        if (sTestDeviceFingerPrint == false) goto L6;
        return true;
    L6:
        if (this.mAddDeviceFingerprintOpen > 0) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean isImageTtnetEnabled() {
        if (this.mImageTtnetEnabled <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isNeedHttpDnsRefetchOnExpire() {
        if (sUseHttpDnsRefetchOnExpire <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isOkHttp3Open() {
        if (Logger.debug() == false) goto L6;
        return true;
    L6:
        if (this.mOkHttp3Open > 0) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean isOkHttpOpen() {
        if (this.mOkHttpOpen <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.frameworks.core.encrypt.a.InterfaceC0132a
    public boolean isSsQueriesHeaderOpen() {
        if (sTestSsQueries == false) goto L6;
        return false;
    L6:
        if (this.mAddSsQueriesHeaderOpen <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.frameworks.core.encrypt.a.InterfaceC0132a
    public boolean isSsQueriesOpen() {
        if (sTestSsQueries == false) goto L6;
        return true;
    L6:
        if (this.mAddSsQueriesOpen > 0) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.bytedance.frameworks.core.encrypt.a.InterfaceC0132a
    public boolean isSsQueriesPlaintextOpen() {
        if (sTestSsQueries == false) goto L6;
        return true;
    L6:
        if (this.mAddSsQueriesPlaintextOpen > 0) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.f.e
    public void monitorApiHttp(String r4, String r5, boolean r6) {
        if (this.mApiHttpHostList.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<String> r3 = this.mApiHttpHostList.iterator();
    L7:
        if (r3.hasNext() == false) goto L29;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
        if (com.bytedance.common.utility.h.a(r0) == true) goto L7;
        if (r4.endsWith(r0) == false) goto L7;
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L20
        r7.put("url", r4 + r5);     // Catch: Throwable -> L20
        r7.put("replace", r6);     // Catch: Throwable -> L20
        TTNetInit.monitorLogSend("api_http", r7);     // Catch: Throwable -> L20
    L14:
        if (TTNetInit.apiHttpInterceptEnabled() == false) goto L19;
        if (r6 == false) goto L18;
        return;
    L18:
        throw new NotAllowApiHttpException("Api http request is not allowed to be executed");
    L19:
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.connectionclass.a.b
    public void onBandwidthStateChange(ConnectionQuality r2) {
        if (Logger.debug() == false) goto L7;
        if (r2 == null) goto L8;
        Logger.d(TAG, "onBandwidthStateChange bandwidthState = " + r2);
        return;
    L8:
        return;
    }

    public void preloadCronetBootFailureInfo() {
        SharedPreferences r0 = this.mContext.getSharedPreferences(SP_SS_APP_CONFIG, 0);
        if (this.mChromiumBootFailures >= 0) goto L6;
        this.mChromiumBootFailures = r0.getInt(KEY_CHROMIUM_BOOT_FAILURES, 0);
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, "mChromiumBootFailures is " + this.mChromiumBootFailures);
    L8:
        this.mChromiumBootFailuresTimestamp = r0.getLong(KEY_CHROMIUM_BOOT_FAILURES_TIMESTAMP, 0);
        if (this.mChromiumBootFailures > 5) goto L11;
        return;
    L11:
        if ((System.currentTimeMillis() - this.mChromiumBootFailuresTimestamp) <= TimeUnit.HOURS.toMillis(1)) goto L15;
        this.mChromiumBootFailures = 5;
        return;
    }

    public void resetCronetBootSucceed() {
    L11:
        th = move-exception;
        th.printStackTrace();
        return;
    L4:
        if (Logger.debug() == false) goto L7;
        Logger.d(TAG, "KEY_CHROMIUM_BOOT_FAILURES set 0");     // Catch: Throwable -> L11
    L7:
        if (this.mChromiumBootFailures != 0) goto L9;
        return;
    L9:
        this.mChromiumBootFailures = 0;     // Catch: Throwable -> L11
        SharedPreferences.Editor r2 = this.mContext.getSharedPreferences(SP_SS_APP_CONFIG, 0).edit();     // Catch: Throwable -> L11
        r2.putInt(KEY_CHROMIUM_BOOT_FAILURES, 0);     // Catch: Throwable -> L11
        com.bytedance.common.utility.c.a.a(r2);     // Catch: Throwable -> L11
        LinkedHashMap r3 = new LinkedHashMap();     // Catch: Throwable -> L11
        r3.put(KEY_CHROMIUM_BOOT_FAILURES, 0);     // Catch: Throwable -> L11
        TTNetInit.getTTNetDepend().a(this.mContext, r3);     // Catch: Throwable -> L11
    }

    @Deprecated
    public List<InetAddress> resolveInetAddresses(String r2) {
        if (com.bytedance.common.utility.h.a(r2) == false) goto L5;
        return null;
    L5:
        if (this.mIsMainProcess == true) goto L8;
        return null;
    L8:
        return resolveInetAddressesFromHttpDns(r2);
    }

    @Deprecated
    public List<InetAddress> resolveInetAddressesFromHttpDns(String r1) {
        return null;
    }

    @Deprecated
    public void setCronetTryRebootHours(int r1) {
    }

    public void setDisableFallbackReasonBoot(boolean r1) {
        sDisableFallbackReasonBoot = r1;
    }

    public void setEnableFallbackReasonBootFix(boolean r1) {
        sEnableFallbackReasonBootFix = r1;
    }

    public void setEncryptSwitch(int r2) {
        if (this.mEncryptSwitch == r2) goto L6;
        this.mEncryptSwitch = r2;
        return;
    }

    public void setForceNotUseCronet(boolean r1) {
        sForceNotUseCronet = r1;
    }

    public void setForceNotUseCronetHttpDns(boolean r1) {
        sForceNotUseCronetHttpDns = r1;
    }

    @Deprecated
    public void setForceSwitch(boolean r1) {
    }

    @Deprecated
    public void setForceUseCronet(boolean r1) {
    }

    @Deprecated
    public void setForceUseCronetOn4X(boolean r1) {
    }

    public void setShareCookieHostList(ArrayList<String> r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.isEmpty() == true) goto L22;
        Iterator<String> r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L23;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");
        if (com.bytedance.common.utility.h.a(r0) == true) goto L8;
        if (com.bytedance.ttnet.utils.d.a(r0, this.mShareCookieHostList) == true) goto L8;
        String r1 = r0.trim();
        this.mShareCookieHostList.add(r1);
        goto L8
    L23:
        return;
    }

    public void setTncABTest(String r2) {
        this.mABTest = com.bytedance.frameworks.baselib.network.http.b.a(r2);
        TNCManager.c().e().a(r2);
    }

    public void setTncEtag(String r1) {
        this.mTncEtag = r1;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.f.i
    public boolean shouldSampling(String r3) {
        if (com.bytedance.common.utility.h.a(r3) == false) goto L6;
        return false;
    L6:
        if (this.mSampleBandWidthEnabled > 0) goto L21;
        return false;
    L21:
        URI r2 = i.a(r3);     // Catch: Throwable -> L18
        if (r2 != null) goto L11;
        return false;
    L11:
        String r4 = r2.getHost();     // Catch: Throwable -> L18
        if (com.bytedance.common.utility.h.a(r4) == false) goto L14;
        return false;
    L14:
        if (r4.endsWith(com.bytedance.ttnet.b.a()) == false) goto L20;
        return true;
    L20:
        return false;
    L18:
        th = move-exception;
        th.printStackTrace();
        goto L20
    }

    public String tryDnsMapping(String r1, String[] r2) {
        return r1;
    }

    synchronized void tryLoadDomainConfig4OtherProcess() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if ((System.currentTimeMillis() - this.mLastRefreshTime.get()) <= (((long) this.mTncUpdateInterval.get()) * 1000)) goto L15;
        this.mLastRefreshTime.set(System.currentTimeMillis());     // Catch: Throwable -> L17
        int r0 = TTNetInit.getTTNetDepend().a(this.mContext, KEY_DISABLE_FRAMED_TRANSPORT, 0);     // Catch: Exception -> L20 Throwable -> L17
        if (r0 <= 0) goto L13;
        com.bytedance.frameworks.baselib.network.http.ok3.impl.e.a(r0);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Exception -> L20 Throwable -> L17
    L13:
        if (TNCManager.c().e() == null) goto L15;
        TNCManager.c().e().b(this.mLastRefreshTime.get());     // Catch: Exception -> L20 Throwable -> L17
    L15:
        monitor-exit(this);
    }

    public void tryLoadLocalConfig() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L73:
        th = move-exception;
        throw th;
    L5:
        if (this.mLocalLoaded == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L73
        return;
    L8:
        boolean r1 = true;
        this.mLocalLoaded = true;     // Catch: Throwable -> L73
        monitor-exit(r0);     // Catch: Throwable -> L73
        SharedPreferences r2 = this.mContext.getSharedPreferences(SP_SS_APP_CONFIG, 0);
        this.mOkHttpOpen = r2.getInt(KEY_OK_HTTP_OPEN, 0);
        this.mOkHttp3Open = r2.getInt(KEY_OK_HTTP3_OPEN, 0);
        this.mCronetVersion = r2.getInt(KEY_CRONET_VERSION, 0);
        this.mHttpDnsEnabled = r2.getInt(KEY_HTTP_DNS_ENABLED, 0);
        this.mDetectOpen = r2.getInt(KEY_DETECT_OPEN, 0);
        this.mDetectNativePage = r2.getInt(KEY_DETECT_NATIVE_PAGE, 1);
        this.mCollectRecentPageInfoEnable = r2.getInt(KEY_COLLECT_RECENT_PAGE_INFO_ENABLE, 1);
        this.mAddSsQueriesOpen = r2.getInt(KEY_ADD_SS_QUERIES_OPEN, 0);
        this.mAddSsQueriesHeaderOpen = r2.getInt(KEY_ADD_SS_QUERIES_HEADER_OPEN, 0);
        this.mAddSsQueriesPlaintextOpen = r2.getInt(KEY_ADD_SS_QUERIES_PLAINTEXT_OPEN, 1);
        this.mAddDeviceFingerprintOpen = r2.getInt(KEY_ADD_DEVICE_FINGERPRINT_OPEN, 1);
        this.mDynamicAdjustThreadPoolSizeOpen = r2.getInt(KEY_DYNAMIC_ADJUST_THREADPOOL_SIZE_OPEN, 1);
        if (this.mChromiumBootFailures >= 0) goto L14;
        this.mChromiumBootFailures = r2.getInt(KEY_CHROMIUM_BOOT_FAILURES, 0);
    L14:
        if (this.mDynamicAdjustThreadPoolSizeOpen <= 0) goto L16;
        boolean r3 = true;
    L17:
        com.bytedance.frameworks.baselib.network.dispatcher.e.a(r3);
        this.mImageTtnetEnabled = r2.getInt(KEY_IMAGE_TTNET_ENABLED, 1);
        this.mSampleBandWidthEnabled = r2.getInt(KEY_SAMPLE_BAND_WIDTH_ENABLED, 1);
        this.mCdnSampleBandWidthEnabled = r2.getInt(KEY_CDN_SAMPLE_BAND_WIDTH_ENABLED, 1);
        sUseHttpDns = r2.getInt(KEY_USE_HTTP_DNS, -1);
        sUseHttpDnsRefetchOnExpire = r2.getInt(KEY_USE_HTTP_DNS_REFETCH_ON_EXPIRE, -1);
        com.bytedance.frameworks.baselib.network.http.parser.d.a(r2);
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a(null, r2);
        com.bytedance.ttnet.utils.a.a(r2);
        if (this.mAddSsQueriesOpen <= 0) goto L20;
    L21:
        com.bytedance.ttnet.retrofit.b.a(true);
    L22:
        mFrontierUrls = r2.getString(WsConstants.KEY_FRONTIER_URLS, "");
        this.mCronetSoPath = r2.getString(KEY_CRONET_SO_PATH, "");
        String r4 = r2.getString(KEY_API_HTTP_HOST_LIST, "");
        if (com.bytedance.common.utility.h.a(r4) == true) goto L30;
        String[] r5 = r4.split(",");
        int r6 = r5.length;
        int r7 = 0;
    L25:
        if (r7 >= r6) goto L30;
        String r8 = r5[r7];
        if (com.bytedance.common.utility.h.a(r8) == true) goto L29;
        this.mApiHttpHostList.add(r8.trim());
    L29:
        r7 = r7 + 1;
    L30:
        com.bytedance.frameworks.baselib.network.http.cronet.impl.e.a().a(r2.getString(KEY_CONCURRENT_REQUEST_CONFIG, ""));
        String r9 = r2.getString(KEY_COMMON_PARAMS_CONFIG, "");
        com.bytedance.frameworks.baselib.network.http.a.a r10 = com.bytedance.frameworks.baselib.network.http.a.b.a().b();
        if (r10 == null) goto L33;
        r10.a(r9);
    L33:
        com.bytedance.frameworks.baselib.network.c.d.a().b(r2.getString("L0_params", ""));
        int r11 = r2.getInt("query_filter_enabled", Integer.MIN_VALUE);
        String r12 = r2.getString("query_filter_actions", "");
        if (r11 == Integer.MIN_VALUE) goto L40;
        com.bytedance.frameworks.baselib.network.c.d r13 = com.bytedance.frameworks.baselib.network.c.d.a();
        if (r11 <= 0) goto L38;
        boolean r14 = true;
    L39:
        r13.a(r14);
        com.bytedance.frameworks.baselib.network.c.d.a().a(r12);
        goto L40
    L38:
        r14 = false;
    L40:
        String r15 = r2.getString(KEY_SHARE_COOKIE_HOST_LIST, "");
        com.bytedance.ttnet.utils.d.b(r15, this.mShareCookieHostList);
        mergeShareCookieHosts();
        if (r2.getInt(KEY_PRIVATE_PROTOCOL_ENABLED, 1) < 1) goto L43;
        boolean r16 = true;
    L44:
        com.bytedance.frameworks.baselib.network.http.f.e(r16);
        int r17 = r2.getInt(KEY_DESTROY_DELTA_MILLIS, 100);
        if (r17 < 0) goto L48;
        com.bytedance.frameworks.baselib.network.http.f.a(r17);
    L48:
        if (r2.getInt(KEY_DISABLE_ROTATION_HOST_RETRY, -1) >= 1) goto L51;
        r1 = false;
    L51:
        com.bytedance.frameworks.baselib.network.http.f.d(r1);
        this.mTncUpdateInterval.set(r2.getInt(KEY_TNC_UPDATE_INTERVAL, 10800));
        String r18 = r2.getString(KEY_TNC_HOST_ARRAYS, "");
        if (TextUtils.isEmpty(r18) == true) goto L54;
        String[] r19 = r18.split(",");
        this.mTncHostArrays.clear();
        this.mTncHostArrays.addAll(Arrays.asList(r19));
    L54:
        this.mTncSummary = r2.getString(KEY_TNC_SUMMARY, "");
        if (TNCManager.c().e() == null) goto L57;
        TNCManager.c().e().a(this.mLastRefreshTime.get());
    L57:
        int r20 = r2.getInt(KEY_DISABLE_FRAMED_TRANSPORT, 0);
        if (r20 <= 0) goto L64;
        com.bytedance.frameworks.baselib.network.http.ok3.impl.e.a(r20);     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        th.printStackTrace();
    L64:
        if (this.mIsMainProcess == false) goto L84;
        final LinkedHashMap r21 = new LinkedHashMap();     // Catch: Throwable -> L70
        if (com.bytedance.common.utility.h.a(mFrontierUrls) == true) goto L68;
        r21.put(WsConstants.KEY_FRONTIER_URLS, mFrontierUrls);     // Catch: Throwable -> L70
    L68:
        r21.put(KEY_HTTP_DNS_ENABLED, Integer.valueOf(this.mHttpDnsEnabled));     // Catch: Throwable -> L70
        r21.put(KEY_ADD_SS_QUERIES_OPEN, Integer.valueOf(this.mAddSsQueriesOpen));     // Catch: Throwable -> L70
        r21.put(KEY_ADD_SS_QUERIES_HEADER_OPEN, Integer.valueOf(this.mAddSsQueriesHeaderOpen));     // Catch: Throwable -> L70
        r21.put(KEY_ADD_SS_QUERIES_PLAINTEXT_OPEN, Integer.valueOf(this.mAddSsQueriesPlaintextOpen));     // Catch: Throwable -> L70
        r21.put(KEY_CHROMIUM_BOOT_FAILURES, Integer.valueOf(this.mChromiumBootFailures));     // Catch: Throwable -> L70
        r21.put(KEY_SHARE_COOKIE_HOST_LIST, r15);     // Catch: Throwable -> L70
        r21.put(KEY_DISABLE_FRAMED_TRANSPORT, Integer.valueOf(r20));     // Catch: Throwable -> L70
        final String r22 = "SaveMapToProvider-Thread";
        new AnonymousClass3(this, r22, r21).a();     // Catch: Throwable -> L70
        return;
    L70:
        th = move-exception;
        th.printStackTrace();
        return;
    L84:
        return;
    L43:
        r16 = false;
        goto L44
    L20:
        if (this.mAddSsQueriesHeaderOpen <= 0) goto L22;
    L16:
        r3 = false;
        goto L17
    }

    public void tryRefreshConfig(TNCManager.TNCUpdateSource r2) {
        tryRefreshConfig(r2, false);
    }

    public void tryRefreshConfig(TNCManager.TNCUpdateSource r1, boolean r2) {
        tryRefreshConfigInternal(r1, r2);
    }

    void updateConfig(TNCManager.TNCUpdateSource r6, boolean r7) {
        if (Logger.debug() == false) goto L6;
        Logger.d("TNCManager", "doRefresh, actual request");
    L6:
        if (NetworkUtils.b(this.mContext) == true) goto L8;
        return;
    L8:
        tryLoadLocalConfig();
        if (isChromiumOpen() == true) goto L11;
    L14:
        if (r7 == true) goto L16;
    L22:
        int r8 = 102;
        if (TNCManager.c().a(this.mContext, true, r6, this.mTncSummary) == false) goto L25;
    L24:
        r8 = 101;
    L28:
        this.mHandler.sendEmptyMessage(r8);
        this.mHandler.removeMessages(103);
        this.mHandler.sendEmptyMessageDelayed(103, ((long) this.mTncUpdateInterval.get()) * 1000);
        return;
    L25:
        Logger.d(TAG, "tnc reqeust through okhttp failed, fallback to HttpUrlConnection");
        if (TNCManager.c().a(this.mContext, false, TNCManager.TNCUpdateSource.PORTRETRY, this.mTncSummary) == false) goto L28;
    L16:
        if (isDidEmpty() == false) goto L22;
        if (Logger.debug() == false) goto L20;
        Logger.d("TNCManager", "did is empty, delay 5s send tnc again");
    L20:
        this.mHandler.sendEmptyMessageDelayed(104, 5000);
        this.mConfigUpdating.set(false);
        return;
    L11:
        if (r6 == TNCManager.TNCUpdateSource.TTCRONETFAILED) goto L14;
        this.mConfigUpdating.set(false);
    }
}
