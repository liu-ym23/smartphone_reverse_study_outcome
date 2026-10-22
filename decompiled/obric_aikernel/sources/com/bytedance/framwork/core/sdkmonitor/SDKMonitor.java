package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.framwork.core.sdklib.apm6.LogReportController;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.slardar.config.IConfigManager;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SDKMonitor implements k3.b {
    private static final int BIT_API_ALL_SAMPLE = 1;
    private static final String KEY_DEBUG_UUID = "_debug_uuid";
    private static final String KEY_SELF_DEBUG_MESSAGE = "_debug_self";
    private static final int SDK_VERSION = 400;
    static AtomicLong atomicLong;
    private static volatile String hostAid;
    private static volatile IHttpService hostHttpService;
    private static long sid;
    private long lastCalculateTimestamp;
    private String mAid;
    private volatile JSONObject mAllowLogType;
    private volatile List<String> mAllowReportList;
    private volatile List<Pattern> mAllowReportPatterns;
    private volatile JSONObject mAllowService;
    private volatile List<String> mBlockReportList;
    private volatile List<Pattern> mBlockReportPatterns;
    private com.bytedance.framwork.core.sdkmonitor.b mCacheData;
    private Map<String, String> mCommonParams;
    private volatile boolean mConfigExit;
    private List<String> mConfigUrls;
    private Context mContext;
    private volatile int mDisableReportApiError;
    private volatile long mFetchSettingInterval;
    private volatile boolean mHasInit;
    private JSONObject mHeaderInfo;
    private volatile IHttpService mHttpService;
    private o mIGetExtendParams;
    private volatile boolean mIsEncrypt;
    private volatile long mLastFetchSettingTime;
    private boolean mOversea;
    private volatile int mReportCount;
    private volatile int mReportInterval;
    private volatile int mReportSLA;

    class a implements Runnable {
        a(SDKMonitor r10) {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.framwork.core.sdklib.apm6.d.c().b();
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ m f1956c;

        b(SDKMonitor r10, m r11) {
            this.f1956c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.framwork.core.sdklib.apm6.d.c().b();     // Catch: Throwable -> L6
            this.f1956c.a(false);
            return;
        L6:
            th = move-exception;
            this.f1956c.a(false);
            throw th;
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f1957c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ JSONObject f1958g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f1959h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ SDKMonitor f1960i;

        c(SDKMonitor r10, String r11, JSONObject r12, long r13) {
            this.f1960i = r10;
            this.f1957c = r11;
            this.f1958g = r12;
            this.f1959h = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1960i.monitorCommonLogInternal(this.f1957c, this.f1958g, this.f1959h);
        }
    }

    class d implements o {
        d(SDKMonitor r10) {
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.o
        public Map<String, String> getCommonParams() {
            return null;
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.o
        public String getSessionId() {
            return null;
        }
    }

    class e implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f1961a;

        e(SDKMonitor r10, n r11) {
            this.f1961a = r11;
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.o
        public Map<String, String> getCommonParams() {
            return null;
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.o
        public String getSessionId() {
            return this.f1961a.getSessionId();
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f1962c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ JSONObject f1963g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ o f1964h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ SDKMonitor f1965i;

        f(SDKMonitor r10, Context r11, JSONObject r12, o r13) {
            this.f1965i = r10;
            this.f1962c = r11;
            this.f1963g = r12;
            this.f1964h = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            SDKMonitor.access$000(this.f1965i, this.f1962c, this.f1963g, this.f1964h);
            if (SDKMonitor.access$100(this.f1965i) == false) goto L6;
            SDKMonitor.access$200(this.f1965i).h(this.f1965i);
            return;
        }
    }

    class g implements o {
        g(SDKMonitor r10) {
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.o
        public Map<String, String> getCommonParams() {
            return null;
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.o
        public String getSessionId() {
            return null;
        }
    }

    class h implements u4.a {
        h(SDKMonitor r10) {
        }

        @Override // u4.a
        public void onReady() {
        }

        @Override // u4.a
        public void onRefresh(JSONObject r10, boolean r11) {
            int r12 = JsonUtils.optJSONObject(r10, com.bytedance.framwork.core.sdkmonitor.d.f2009a, com.bytedance.framwork.core.sdkmonitor.d.f2012d, com.bytedance.framwork.core.sdkmonitor.d.f2016h).optInt(com.bytedance.framwork.core.sdkmonitor.d.f2017i, 2);
            com.bytedance.framwork.core.sdklib.apm6.h.b().f(r12);
        }
    }

    class i implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SDKMonitor f1966c;

        i(SDKMonitor r10) {
            this.f1966c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
        L30:
            th = move-exception;
            if (SDKMonitor.access$100(this.f1966c) == true) goto L34;
            SDKMonitor.access$102(this.f1966c, true);
            SDKMonitor.access$200(this.f1966c).h(this.f1966c);
        L34:
            th.printStackTrace();
            return;
        L3:
            if (SDKMonitor.access$300(this.f1966c) == null) goto L42;
            Iterator r10 = SDKMonitor.access$400(this.f1966c).iterator();     // Catch: Throwable -> L30
        L6:
            if (r10.hasNext() == false) goto L43;
            StringBuilder r11 = SDKMonitor.access$500(this.f1966c, (String) r10.next());     // Catch: Throwable -> L30
            if ((System.currentTimeMillis() - SDKMonitor.access$600(this.f1966c)) < 604800000) goto L12;
            r11.append("&encrypt=close");     // Catch: Throwable -> L30
            r11.append("&last_calculate_timestamp=" + SDKMonitor.access$600(this.f1966c));     // Catch: Throwable -> L30
            String r12 = "&force_refresh=1";
        L11:
            r11.append(r12);     // Catch: Throwable -> L30
            String r13 = r11.toString();     // Catch: Throwable -> L30
            if (com.bytedance.framwork.core.sdklib.apm6.j.f() == false) goto L38;
            j3.c.a("APM-SDK", "url:" + r13);     // Catch: Throwable -> L30
        L38:
        L27:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L30
            goto L6
        L18:
            if (SDKMonitor.access$700(this.f1966c) == null) goto L20;
            byte[] r14 = SDKMonitor.access$700(this.f1966c).doGet(r13, null).b();     // Catch: Throwable -> L27
        L21:
            if (r14 == null) goto L44;
            JSONObject r15 = new JSONObject(new String(r14));     // Catch: Throwable -> L27
            if (com.bytedance.framwork.core.sdklib.apm6.j.f() == false) goto L25;
            j3.c.a("APM-SDK", "resultJSON:" + r15);     // Catch: Throwable -> L27
        L25:
            SDKMonitor.access$900(this.f1966c, r15.optJSONObject("data"), r15.optInt("code", -1));     // Catch: Throwable -> L27
        L45:
            return;
        L44:
            return;
        L20:
            r14 = com.bytedance.framwork.core.sdkmonitor.f.c(r13, null, SDKMonitor.access$800(this.f1966c));     // Catch: Throwable -> L27
            goto L21
        L12:
            r11.append("&encrypt=close");     // Catch: Throwable -> L30
            r12 = "&last_calculate_timestamp=" + SDKMonitor.access$600(this.f1966c);     // Catch: Throwable -> L30
            goto L11
        L43:
            return;
        }
    }

    class j implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f1967c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f1968g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f1969h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f1970i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f1971j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f1972k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ JSONObject f1973l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ SDKMonitor f1974m;

        j(SDKMonitor r10, long r11, long r12, String r13, String r14, String r15, int r16, JSONObject r17) {
            this.f1974m = r10;
            this.f1967c = r11;
            this.f1968g = r12;
            this.f1969h = r13;
            this.f1970i = r14;
            this.f1971j = r15;
            this.f1972k = r16;
            this.f1973l = r17;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1974m.handleNetSLA(this.f1967c, this.f1968g, this.f1969h, this.f1970i, this.f1971j, this.f1972k, this.f1973l);
        }
    }

    class k implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f1975c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f1976g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f1977h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f1978i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f1979j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f1980k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ JSONObject f1981l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ SDKMonitor f1982m;

        k(SDKMonitor r10, long r11, long r12, String r13, String r14, String r15, int r16, JSONObject r17) {
            this.f1982m = r10;
            this.f1975c = r11;
            this.f1976g = r12;
            this.f1977h = r13;
            this.f1978i = r14;
            this.f1979j = r15;
            this.f1980k = r16;
            this.f1981l = r17;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1982m.handleApiError(this.f1975c, this.f1976g, this.f1977h, this.f1978i, this.f1979j, this.f1980k, this.f1981l);
        }
    }

    class l implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f1983c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f1984g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ JSONObject f1985h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ JSONObject f1986i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ JSONObject f1987j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ JSONObject f1988k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ long f1989l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ SDKMonitor f1990m;

        l(SDKMonitor r10, String r11, int r12, JSONObject r13, JSONObject r14, JSONObject r15, JSONObject r16, long r17) {
            this.f1990m = r10;
            this.f1983c = r11;
            this.f1984g = r12;
            this.f1985h = r13;
            this.f1986i = r14;
            this.f1987j = r15;
            this.f1988k = r16;
            this.f1989l = r17;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1990m.monitorService(this.f1983c, this.f1984g, this.f1985h, this.f1986i, this.f1987j, this.f1988k, this.f1989l);
        }
    }

    public interface m {
        void a(boolean r10);
    }

    public interface n {
        String getSessionId();
    }

    public interface o {
        Map<String, String> getCommonParams();

        String getSessionId();
    }

    static {
        atomicLong = new AtomicLong(0);
    }

    protected SDKMonitor(String r10) {
        this.mLastFetchSettingTime = 0;
        this.mConfigUrls = new LinkedList();
        this.mIsEncrypt = true;
        this.mAid = r10;
        this.mConfigExit = false;
        this.mCacheData = new com.bytedance.framwork.core.sdkmonitor.b();
    }

    static /* synthetic */ void access$000(SDKMonitor r10, Context r11, JSONObject r12, o r13) {
        r10.initMonitor(r11, r12, r13);
    }

    static /* synthetic */ boolean access$100(SDKMonitor r10) {
        return r10.mConfigExit;
    }

    static /* synthetic */ boolean access$102(SDKMonitor r10, boolean r11) {
        r10.mConfigExit = r11;
        return r11;
    }

    static /* synthetic */ com.bytedance.framwork.core.sdkmonitor.b access$200(SDKMonitor r10) {
        return r10.mCacheData;
    }

    static /* synthetic */ Map access$300(SDKMonitor r10) {
        return r10.mCommonParams;
    }

    static /* synthetic */ List access$400(SDKMonitor r10) {
        return r10.mConfigUrls;
    }

    static /* synthetic */ StringBuilder access$500(SDKMonitor r10, String r11) {
        return r10.addConfigParamsToURL(r11);
    }

    static /* synthetic */ long access$600(SDKMonitor r10) {
        return r10.lastCalculateTimestamp;
    }

    static /* synthetic */ IHttpService access$700(SDKMonitor r10) {
        return r10.getHttpService();
    }

    static /* synthetic */ boolean access$800(SDKMonitor r10) {
        return r10.mIsEncrypt;
    }

    static /* synthetic */ void access$900(SDKMonitor r10, JSONObject r11, int r12) {
        r10.updateToSP(r11, r12);
    }

    private StringBuilder addConfigParamsToURL(String r10) {
        StringBuilder r11 = new StringBuilder(r10);
        if (TextUtils.isDigitsOnly(r10) == false) goto L5;
    L21:
        return r11;
    L5:
        if (this.mCommonParams == null) goto L21;
        if (r10.contains("?") == true) goto L10;
        r11.append("?");
    L10:
        appendUrlParam(r11, "sdk_version", String.valueOf(400));
        HashMap r12 = new HashMap(this.mCommonParams);
        if (TextUtils.isEmpty(hostAid) == true) goto L14;
        r12.put("host_aid", hostAid);
    L14:
        if (r12.size() <= 0) goto L21;
        Iterator r13 = r12.entrySet().iterator();
    L17:
        if (r13.hasNext() == false) goto L21;
        Map.Entry r14 = (Map.Entry) r13.next();
        if (r14.getKey() == null) goto L17;
        appendUrlParam(r11, String.valueOf(r14.getKey()), String.valueOf(r14.getValue()));
        goto L17
    }

    private void addDebugMessage(JSONObject r10) {
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L4
        r11.put("aid", this.mAid);     // Catch: Exception -> L4
        l3.a.a(r11);     // Catch: Exception -> L4
        r11.put("process_name", l3.d.a(this.mContext));     // Catch: Exception -> L4
        r11.put(KEY_DEBUG_UUID, sid + "_" + atomicLong.getAndAdd(1));     // Catch: Exception -> L4
        r10.put(KEY_SELF_DEBUG_MESSAGE, r11);     // Catch: Exception -> L4
        return;
    }

    private StringBuilder addParamsToURL(String r10) {
        StringBuilder r11 = new StringBuilder(r10);
        if (TextUtils.isDigitsOnly(r10) == false) goto L5;
    L20:
        return r11;
    L5:
        if (this.mCommonParams == null) goto L20;
        if (r10.contains("?") == true) goto L10;
        r11.append("?");
    L10:
        appendUrlParam(r11, "sdk_version", String.valueOf(400));
        Map<String, String> r12 = this.mCommonParams;
        if (r12 == null) goto L20;
        if (r12.size() <= 0) goto L20;
        Iterator<Map.Entry<String, String>> r13 = r12.entrySet().iterator();
    L16:
        if (r13.hasNext() == false) goto L20;
        Map.Entry<String, String> r14 = r13.next();
        if (r14.getKey() == null) goto L16;
        appendUrlParam(r11, String.valueOf(r14.getKey()), String.valueOf(r14.getValue()));
        goto L16
    }

    private StringBuilder appendUrlParam(@NonNull StringBuilder r10, String r11, String r12) {
        if (r10.charAt(r10.length() - 1) == '?') goto L5;
        r10.append("&");
    L5:
        r10.append(encode(r11, "UTF-8"));
        r10.append('=');
        r10.append(encode(r12, "UTF-8"));
        return r10;
    }

    private void combineJson(JSONObject r10, JSONObject r11) {
        if (r10 == null) goto L19;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.length() <= 0) goto L21;
        Iterator<String> r12 = r11.keys();     // Catch: JSONException -> L12
    L9:
        if (r12.hasNext() == false) goto L22;
        String r13 = r12.next();     // Catch: JSONException -> L12
        r10.put(r13, r11.get(r13));     // Catch: JSONException -> L12
        goto L9
    L22:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    L21:
        return;
    }

    private static String encode(String r10, String r11) {
        if (r11 != null) goto L10;
        r11 = "UTF-8";
    L10:
        return URLEncoder.encode(r10, r11);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    private IHttpService getHttpService() {
        if (this.mHttpService != null) goto L6;
        this.mHttpService = (IHttpService) c4.d.a(IHttpService.class);
    L6:
        if (this.mHttpService != null) goto L8;
        monitor-enter(this);
        IHttpService r10 = hostHttpService;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r10;
    L13:
        th = move-exception;
        throw th;
    L8:
        return this.mHttpService;
    }

    private String getSessionId() {
        o r10 = this.mIGetExtendParams;
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.getSessionId();
    }

    private SharedPreferences getSp() {
        Context r10 = this.mContext;
        if (r10 == null) goto L6;
        String r11 = com.bytedance.framwork.core.sdkmonitor.e.a(r10);
        return this.mContext.getSharedPreferences("monitor_config" + this.mAid + r11, 0);
    L6:
        return null;
    }

    private void initConfig() {
        SharedPreferences r10 = getSp();
        String r11 = r10.getString("monitor_net_config", null);
        this.mLastFetchSettingTime = r10.getLong("monitor_configure_refresh_time", 0);
        this.lastCalculateTimestamp = r10.getLong("monitor_last_calculate_timestamp", 0);
        if (r10.getInt("monitor_config_update", 0) != 1) goto L5;
        boolean r12 = true;
    L6:
        k3.a.e().d(this);
        if (TextUtils.isEmpty(r11) == false) goto L19;
    L14:
        IConfigManager r13 = (IConfigManager) c4.d.a(IConfigManager.class);
        if (r13 == null) goto L17;
        r13.registerConfigListener(new h(this));
    L17:
        updateConfigFromNet(false);
        com.bytedance.framwork.core.sdklib.apm6.downgrade.a.a().b(com.bytedance.framwork.core.sdklib.apm6.j.c());
        return;
    L19:
        this.mConfigExit = true;     // Catch: Exception -> L13
        JSONObject r14 = new JSONObject(r11);     // Catch: Exception -> L13
        if (r12 == true) goto L11;
        r14.remove("report_host_new");     // Catch: Exception -> L13
    L11:
        updateConfig(r14);     // Catch: Exception -> L13
    L13:
        Log.e("monitor_config", "config error");
        goto L14
    L5:
        r12 = false;
        goto L6
    }

    private void initMonitor(Context r21, JSONObject r22, o r23) {
        if (r21 == null) goto L32;
        if (r22 == null) goto L33;
        this.mHasInit = true;
        this.mContext = r21.getApplicationContext();
        this.mHeaderInfo = r22;
        r22.put("aid", this.mAid);     // Catch: Exception -> L29
        this.mHeaderInfo.put("os", "Android");     // Catch: Exception -> L29
        this.mHeaderInfo.put("device_platform", "android");     // Catch: Exception -> L29
        this.mHeaderInfo.put("os_version", Build.VERSION.RELEASE);     // Catch: Exception -> L29
        this.mHeaderInfo.put("os_api", Build.VERSION.SDK_INT);     // Catch: Exception -> L29
        this.mHeaderInfo.put("device_model", Build.MODEL);     // Catch: Exception -> L29
        this.mHeaderInfo.put("device_brand", Build.BRAND);     // Catch: Exception -> L29
        this.mHeaderInfo.put("device_manufacturer", Build.MANUFACTURER);     // Catch: Exception -> L29
        this.mHeaderInfo.put("sdkmonitor_version", "2.0.41");     // Catch: Exception -> L29
        this.mHeaderInfo.put("monitor_from", "sdk");     // Catch: Exception -> L29
        if (TextUtils.isEmpty(this.mHeaderInfo.optString("package_name")) == false) goto L10;
        this.mHeaderInfo.put("package_name", r21.getPackageName());     // Catch: Exception -> L29
    L10:
        PackageInfo r10 = null;
        if (TextUtils.isEmpty(this.mHeaderInfo.optString("version_name")) == false) goto L14;
        r10 = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0);     // Catch: Exception -> L29
        this.mHeaderInfo.put("version_name", r10.versionName);     // Catch: Exception -> L29
    L14:
        if (TextUtils.isEmpty(this.mHeaderInfo.optString("version_code")) == false) goto L18;
        if (r10 != null) goto L17;
        r10 = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0);     // Catch: Exception -> L29
    L17:
        this.mHeaderInfo.put("version_code", r10.versionCode);     // Catch: Exception -> L29
    L18:
        this.mIGetExtendParams = r23;     // Catch: Exception -> L29
        if (r23 != null) goto L21;
        this.mIGetExtendParams = new g(this);     // Catch: Exception -> L29
    L21:
        Map<String, String> r11 = this.mIGetExtendParams.getCommonParams();     // Catch: Exception -> L29
        this.mCommonParams = r11;     // Catch: Exception -> L29
        if (r11 != null) goto L24;
        this.mCommonParams = new HashMap();     // Catch: Exception -> L29
    L24:
        this.mOversea = TextUtils.equals(this.mCommonParams.get("oversea"), NetConst.ENCRYPT_VERISON_CODE);     // Catch: Exception -> L29
        this.mCommonParams.put("aid", this.mAid);     // Catch: Exception -> L29
        this.mCommonParams.put("device_id", this.mHeaderInfo.optString("device_id"));     // Catch: Exception -> L29
        this.mCommonParams.put("device_platform", "android");     // Catch: Exception -> L29
        this.mCommonParams.put("os", "Android");     // Catch: Exception -> L29
        this.mCommonParams.put("package_name", this.mHeaderInfo.optString("package_name"));     // Catch: Exception -> L29
        this.mCommonParams.put("channel", this.mHeaderInfo.optString("channel"));     // Catch: Exception -> L29
        this.mCommonParams.put("app_version", this.mHeaderInfo.optString("app_version"));     // Catch: Exception -> L29
        this.mCommonParams.put("sdkmonitor_version", "2.0.41");     // Catch: Exception -> L29
        this.mCommonParams.put("minor_version", NetConst.ENCRYPT_VERISON_CODE);     // Catch: Exception -> L29
        this.mCommonParams.put("host_aid", this.mHeaderInfo.optString("host_aid"));     // Catch: Exception -> L29
        if (com.bytedance.framwork.core.sdklib.apm6.j.f() == false) goto L27;
        j3.c.a("APM-SDK", "initSDK:" + this.mAid + " " + this.mCommonParams);     // Catch: Exception -> L29
    L27:
        com.bytedance.framwork.core.sdklib.apm6.j.i(r21);     // Catch: Exception -> L29
        com.bytedance.framwork.core.sdklib.apm6.j.h(this.mCommonParams);     // Catch: Exception -> L29
        com.bytedance.framwork.core.sdklib.apm6.j.j(this.mAid, l3.b.a(this.mHeaderInfo));     // Catch: Exception -> L29
        this.mHttpService = (IHttpService) c4.d.a(IHttpService.class);     // Catch: Exception -> L29
        initConfig();     // Catch: Exception -> L29
        return;
    L34:
        return;
    L33:
        return;
    }

    private boolean isMatch(String r10, List<String> r11, List<Pattern> r12) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return false;
    L6:
        if (l3.c.a(r11) == true) goto L23;
        Iterator<String> r13 = r11.iterator();
    L9:
        if (r13.hasNext() == false) goto L23;
        if (r10.contains(r13.next()) == false) goto L9;
        return true;
    L23:
        String r14 = new URI(r10).getPath();     // Catch: Throwable -> L22
        if (l3.c.a(r12) == true) goto L21;
        Iterator<Pattern> r15 = r12.iterator();     // Catch: Throwable -> L22
    L17:
        if (r15.hasNext() == false) goto L21;
        if (r15.next().matcher(r14).matches() == false) goto L17;
        return true;
    L21:
        return false;
    }

    private boolean isMatchAllowURI(String r10) {
        return isMatch(r10, this.mAllowReportList, this.mAllowReportPatterns);
    }

    private boolean isMatchBlackURI(String r10) {
        return isMatch(r10, this.mBlockReportList, this.mBlockReportPatterns);
    }

    private boolean needUpdateConfigFromNet() {
        if (((System.currentTimeMillis() - this.mLastFetchSettingTime) / 1000) <= this.mFetchSettingInterval) goto L5;
        return true;
    L5:
        return false;
    }

    private JSONObject packLog(String r10, long r11, long r12, String r13, String r14, String r15, int r16) {
        if (TextUtils.isEmpty(r10) == false) goto L22;
        return null;
    L22:
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L21
        r17.put("log_type", r10);     // Catch: Exception -> L21
        r17.put("duration", r11);     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r13) == true) goto L9;
        r17.put("uri", Uri.parse(r13));     // Catch: Exception -> L21
    L9:
        if (r12 <= 0) goto L11;
        r17.put("timestamp", r12);     // Catch: Exception -> L21
    L11:
        r17.put("status", r16);     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r14) == true) goto L16;
        r17.put("ip", r14);     // Catch: Exception -> L21
    L16:
        if (TextUtils.isEmpty(r15) == true) goto L18;
        r17.put("trace_code", r15);     // Catch: Exception -> L21
    L19:
        r17.put(Constants.KEY_NET_TYPE, getNetWorkType());     // Catch: Exception -> L21
        return r17;
    L18:
        r17.put("trace_code", "");     // Catch: Exception -> L21
    L21:
        return null;
    }

    static void setHostAid(String r10) {
        hostAid = r10;
    }

    static void setHttpService(IHttpService r10) {
        monitor-enter(SDKMonitor.class);
        hostHttpService = r10;     // Catch: Throwable -> L7
        monitor-exit(SDKMonitor.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void updateToSP(JSONObject r10, int r11) {
        if (r10 != null) goto L5;
    L15:
        if (r11 != 1) goto L24;
        SharedPreferences.Editor r12 = getSp().edit();
        r12.putLong("monitor_configure_refresh_time", System.currentTimeMillis());
        r12.putInt("monitor_config_update", 1);
        r12.apply();
        if (com.bytedance.framwork.core.sdklib.apm6.j.f() == false) goto L25;
        j3.c.a("APM-SDK", "updateToSP:code:1");
        return;
    L25:
        return;
    L24:
        return;
    L5:
        if (r10.length() <= 0) goto L15;
        updateConfig(r10);     // Catch: Throwable -> L13
        SharedPreferences.Editor r13 = getSp().edit();     // Catch: Throwable -> L13
        long r14 = System.currentTimeMillis();     // Catch: Throwable -> L13
        r13.putLong("monitor_configure_refresh_time", r14);     // Catch: Throwable -> L13
        r13.putInt("monitor_config_update", 1);     // Catch: Throwable -> L13
        r13.putLong("monitor_last_calculate_timestamp", r14);     // Catch: Throwable -> L13
        r13.putString("monitor_net_config", r10.toString());     // Catch: Throwable -> L13
        r13.apply();     // Catch: Throwable -> L13
        if (this.mConfigExit == true) goto L10;
        this.mConfigExit = true;     // Catch: Throwable -> L13
        this.mCacheData.h(this);     // Catch: Throwable -> L13
    L10:
        if (com.bytedance.framwork.core.sdklib.apm6.j.f() == false) goto L22;
        j3.c.a("APM-SDK", "updateToSP");     // Catch: Throwable -> L13
        return;
    L22:
        return;
    L13:
        th = move-exception;
        j3.c.c("APM-SDK", "updateToSP", th);
    }

    public void flushBuffer() {
    }

    public void flushBuffer(m r10) {
    }

    public void flushReport() {
        k3.a.e().f(new a(this));
    }

    public void flushReport(m r10) {
        k3.a.e().f(new b(this, r10));
    }

    public boolean getLogTypeSwitch(String r10) {
        if (this.mAllowLogType != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L8;
        return false;
    L8:
        if (this.mAllowLogType.opt(r10) == null) goto L12;
        return true;
    L12:
        return false;
    }

    public int getNetWorkType() {
        return NetworkUtils.e(this.mContext).getValue();
    }

    public boolean getServiceSwitch(String r10) {
        if (this.mAllowService != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L8;
        return false;
    L8:
        if (this.mAllowService.opt(r10) == null) goto L12;
        return true;
    L12:
        return false;
    }

    void handleApiError(long r12, long r14, String r16, String r17, String r18, int r19, JSONObject r20) {
        if (this.mDisableReportApiError != 1) goto L5;
        return;
    L5:
        if (isMatchBlackURI(r16) == true) goto L16;
        JSONObject r10 = packLog("api_error", r12, r14, r16, r17, r18, r19);
        combineJson(r10, r20);
        if (r10 != null) goto L10;
        return;
    L10:
        if (r10.length() <= 0) goto L15;
        addDebugMessage(r10);
        com.bytedance.framwork.core.sdklib.apm6.g.b().c(Long.parseLong(this.mAid), r10);
        return;
    L15:
        return;
    }

    void handleNetSLA(long r13, long r15, String r17, String r18, String r19, int r20, JSONObject r21) {
        if (isMatchBlackURI(r17) == false) goto L5;
        return;
    L5:
        if (com.bytedance.framwork.core.sdkmonitor.f.d(this.mContext) == false) goto L20;
        JSONObject r10 = packLog("api_all", r13, r15, r17, r18, r19, r20);
        combineJson(r10, r21);
        if (r10 == null) goto L12;
        if (isMatchAllowURI(r17) == false) goto L12;
    L16:
        r10.put("hit_rules", 1);     // Catch: JSONException -> L15
        addDebugMessage(r10);     // Catch: JSONException -> L15
        com.bytedance.framwork.core.sdklib.apm6.g.b().c(Long.parseLong(this.mAid), r10);     // Catch: JSONException -> L15
        return;
    L21:
        return;
    L12:
        if (this.mReportSLA != 0) goto L16;
        return;
    }

    public boolean init(@NonNull Context r10, @NonNull JSONObject r11, @NonNull n r12) {
        if (r12 != null) goto L6;
        return init(r10, r11, new d(this));
    L6:
        return init(r10, r11, new e(this, r12));
    }

    public boolean init(@NonNull Context r10, @NonNull JSONObject r11, @NonNull o r12) {
        if (this.mHasInit == false) goto L5;
        return true;
    L5:
        this.mHasInit = true;
        sid = System.currentTimeMillis();
        j3.c.e(j3.b.a());
        k3.a.e().g(new f(this, r10, r11, r12), 5000);
        return true;
    }

    protected boolean isHasInit() {
        return this.mHasInit;
    }

    public void monitorApiError(long r14, long r16, String r18, String r19, String r20, int r21, JSONObject r22) {
        if (this.mConfigExit == true) goto L6;
        this.mCacheData.k(new com.bytedance.framwork.core.sdkmonitor.a("api_all", r14, r16, r18, r19, r20, r21, r22));     // Catch: Throwable -> L8
    L9:
        return;
    L6:
        k3.a.e().f(new k(this, r14, r16, r18, r19, r20, r21, r22));     // Catch: Throwable -> L8
    }

    public void monitorCommonLog(String r10, JSONObject r11) {
        if (this.mConfigExit == true) goto L5;
        this.mCacheData.l(new com.bytedance.framwork.core.sdkmonitor.c(r10, r11, System.currentTimeMillis()));     // Catch: Throwable -> L7
    L8:
        return;
    L5:
        monitorCommonLogAsync(r10, r11, System.currentTimeMillis());     // Catch: Throwable -> L7
    }

    void monitorCommonLogAsync(String r10, JSONObject r11, long r12) {
        k3.a.e().f(new c(this, r10, r11, r12));
    }

    void monitorCommonLogInternal(String r10, JSONObject r11, long r12) {
        r11.put("log_type", r10);     // Catch: Throwable -> L13
        r11.put(Constants.KEY_NET_TYPE, getNetWorkType());     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(getSessionId()) == true) goto L7;
        r11.put("session_id", getSessionId());     // Catch: Throwable -> L13
    L7:
        if (r11.isNull("timestamp") == false) goto L10;
        r11.put("timestamp", r12);     // Catch: Throwable -> L13
    L10:
        if (getLogTypeSwitch(r10) == false) goto L16;
        addDebugMessage(r11);     // Catch: Throwable -> L13
        com.bytedance.framwork.core.sdklib.apm6.g.b().c(Long.parseLong(this.mAid), r11);     // Catch: Throwable -> L13
        return;
    L16:
        return;
    }

    public void monitorDuration(String r10, JSONObject r11, JSONObject r12) {
        monitorStatusAndDuration(r10, 0, r11, r12);
    }

    public void monitorEvent(String r12, JSONObject r13, JSONObject r14, JSONObject r15) {
        if (this.mConfigExit == true) goto L5;
        this.mCacheData.m(new com.bytedance.framwork.core.sdkmonitor.h(r12, 0, null, r13, r14, r15, System.currentTimeMillis()));     // Catch: Throwable -> L7
    L8:
        return;
    L5:
        monitorServiceAsync(r12, 0, null, r13, r14, r15, System.currentTimeMillis());     // Catch: Throwable -> L7
    }

    public void monitorSLA(long r14, long r16, String r18, String r19, String r20, int r21, JSONObject r22) {
        if (this.mConfigExit == true) goto L6;
        this.mCacheData.k(new com.bytedance.framwork.core.sdkmonitor.a("api_all", r14, r16, r18, r19, r20, r21, r22));     // Catch: Throwable -> L8
    L9:
        return;
    L6:
        k3.a.e().f(new j(this, r14, r16, r18, r19, r20, r21, r22));     // Catch: Throwable -> L8
    }

    void monitorService(String r10, int r11, JSONObject r12, JSONObject r13, JSONObject r14, JSONObject r15, long r16) {
        if (r15 == null) goto L21;
    L5:
        r15.put("log_type", "service_monitor");     // Catch: Throwable -> L20
        r15.put("service", r10);     // Catch: Throwable -> L20
        r15.put("status", r11);     // Catch: Throwable -> L20
        r15.put(Constants.KEY_NET_TYPE, getNetWorkType());     // Catch: Throwable -> L20
        r15.put(EventBody.KEY_VALUE, r12);     // Catch: Throwable -> L20
        if (r13 == null) goto L8;
        r15.put(EventBody.KEY_CATEGORY, r13);     // Catch: Throwable -> L20
    L8:
        if (r14 == null) goto L11;
        r15.put(EventBody.KEY_METRIC, r14);     // Catch: Throwable -> L20
    L11:
        if (r15.isNull("timestamp") == false) goto L14;
        r15.put("timestamp", r16);     // Catch: Throwable -> L20
    L14:
        if (TextUtils.isEmpty(getSessionId()) == true) goto L17;
        r15.put("session_id", getSessionId());     // Catch: Throwable -> L20
    L17:
        if (getServiceSwitch(r10) == false) goto L23;
        addDebugMessage(r15);     // Catch: Throwable -> L20
        com.bytedance.framwork.core.sdklib.apm6.g.b().c(Long.parseLong(this.mAid), r15);     // Catch: Throwable -> L20
        return;
    L24:
        return;
    L23:
        return;
    L21:
        r15 = new JSONObject();     // Catch: Throwable -> L20
        goto L5
    }

    void monitorServiceAsync(String r13, int r14, JSONObject r15, JSONObject r16, JSONObject r17, JSONObject r18, long r19) {
        k3.a.e().f(new l(this, r13, r14, r15, r16, r17, r18, r19));
    }

    public void monitorStatusAndDuration(String r12, int r13, JSONObject r14, JSONObject r15) {
        if (this.mConfigExit == true) goto L5;
        this.mCacheData.m(new com.bytedance.framwork.core.sdkmonitor.h(r12, r13, r14, null, null, r15, System.currentTimeMillis()));     // Catch: Throwable -> L7
    L8:
        return;
    L5:
        monitorServiceAsync(r12, r13, r14, null, null, r15, System.currentTimeMillis());     // Catch: Throwable -> L7
    }

    public void monitorStatusAndEvent(String r12, int r13, JSONObject r14, JSONObject r15, JSONObject r16) {
        if (this.mConfigExit == true) goto L6;
        this.mCacheData.m(new com.bytedance.framwork.core.sdkmonitor.h(r12, r13, null, r14, r15, r16, System.currentTimeMillis()));     // Catch: Throwable -> L8
    L9:
        return;
    L6:
        monitorServiceAsync(r12, r13, null, r14, r15, r16, System.currentTimeMillis());     // Catch: Throwable -> L8
    }

    public void monitorStatusRate(String r10, int r11, JSONObject r12) {
        monitorStatusAndDuration(r10, r11, null, r12);
    }

    @Override // k3.b
    public void onTimeEvent(long r10) {
        if (this.mFetchSettingInterval > 0) goto L5;
        return;
    L5:
        updateConfigFromNet(false);
    }

    public JSONObject reportJsonHeaderInfo() {
        return this.mHeaderInfo;
    }

    void resetConfigUrls(List<String> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (l3.c.a(r10) == true) goto L8;
        this.mConfigUrls.clear();
        this.mConfigUrls.addAll(r10);
        return;
    }

    void resetReportUrls(List<String> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (l3.c.a(r10) == true) goto L8;
        LogReportController.getInstance().setReportUrlList(this.mAid, r10);
        return;
    }

    synchronized void updateConfig(JSONObject r10) {
        monitor-enter(this);
        if (r10 != null) goto L66;
        monitor-exit(this);
        return;
    L66:
        JSONObject r11 = JsonUtils.optJSONObject(r10, com.bytedance.framwork.core.sdkmonitor.d.f2009a, com.bytedance.framwork.core.sdkmonitor.d.f2012d);     // Catch: Throwable -> L60
        if (r11 == null) goto L49;
        JSONObject r12 = r11.optJSONObject(com.bytedance.framwork.core.sdkmonitor.d.f2014f);     // Catch: Throwable -> L60
        if (r12 == null) goto L12;
        this.mFetchSettingInterval = r12.optLong(com.bytedance.framwork.core.sdkmonitor.d.f2015g, 1200);     // Catch: Throwable -> L60
    L12:
        if (this.mFetchSettingInterval >= 600) goto L14;
        this.mFetchSettingInterval = 600;     // Catch: Throwable -> L60
    L14:
        JSONObject r13 = r11.optJSONObject(com.bytedance.framwork.core.sdkmonitor.d.f2016h);     // Catch: Throwable -> L60
        if (r13 == null) goto L49;
        ArrayList r14 = new ArrayList();     // Catch: Throwable -> L60
        JSONArray r15 = r13.optJSONArray("hosts");     // Catch: Exception -> L63 Throwable -> L60
        if (r15 == null) goto L37;
        if (r15.length() <= 0) goto L37;
        int r16 = r15.length();     // Catch: Exception -> L63 Throwable -> L60
        int r17 = 0;
    L22:
        if (r17 >= r16) goto L37;
        String r18 = r15.getString(r17);     // Catch: Exception -> L63 Throwable -> L60
        if (this.mOversea == false) goto L31;
        if (r18.contains(".snssdk.") == true) goto L29;
        if (r18.contains(".toutiao.") == false) goto L31;
    L29:
        r14.clear();     // Catch: Exception -> L63 Throwable -> L60
    L31:
        if (TextUtils.isEmpty(r18) == true) goto L35;
        if (r18.indexOf(46) <= 0) goto L35;
        r14.add(r18);     // Catch: Exception -> L63 Throwable -> L60
    L35:
        r17 = r17 + 1;
    L37:
        if (r14.isEmpty() == true) goto L39;
        LogReportController.getInstance().setReportUrlList(this.mAid, r14);     // Catch: Throwable -> L60
    L39:
        int r19 = 60;
        this.mReportInterval = r13.optInt("uploading_interval", 60);     // Catch: Throwable -> L60
        if (this.mReportInterval < 0) goto L43;
        r19 = this.mReportInterval;     // Catch: Throwable -> L60
    L43:
        this.mReportInterval = r19;     // Catch: Throwable -> L60
        com.bytedance.framwork.core.sdklib.apm6.d.c().i(this.mReportInterval * 1000);     // Catch: Throwable -> L60
        int r20 = 100;
        this.mReportCount = r13.optInt("once_max_count", 100);     // Catch: Throwable -> L60
        if (this.mReportCount < 0) goto L47;
        r20 = this.mReportCount;     // Catch: Throwable -> L60
    L47:
        this.mReportCount = r20;     // Catch: Throwable -> L60
        this.mIsEncrypt = r13.optBoolean("enable_encrypt", true);     // Catch: Throwable -> L60
        LogReportController.getInstance().setEncrypt(this.mAid, this.mIsEncrypt);     // Catch: Throwable -> L60
    L49:
        if (r10.length() > 0) goto L52;
        monitor-exit(this);
        return;
    L52:
        JSONObject r21 = r10.optJSONObject(com.bytedance.framwork.core.sdkmonitor.d.f2010b);     // Catch: Throwable -> L60
        if (r21 == null) goto L55;
        this.mAllowService = r21.optJSONObject("allow_service_name");     // Catch: Throwable -> L60
        this.mAllowLogType = r21.optJSONObject(SlardarSettingsConstants.KEY_ALLOW_LOG_TYPE);     // Catch: Throwable -> L60
    L55:
        JSONObject r22 = JsonUtils.optJSONObject(r10, com.bytedance.framwork.core.sdkmonitor.d.f2011c, com.bytedance.framwork.core.sdkmonitor.d.f2013e);     // Catch: Throwable -> L60
        if (r22 == null) goto L58;
        this.mDisableReportApiError = r22.optInt("enable_api_error_upload", 0);     // Catch: Throwable -> L60
        this.mReportSLA = r22.optInt("enable_api_all_upload", 0);     // Catch: Throwable -> L60
        this.mBlockReportList = l3.c.b(r22, "api_block_list");     // Catch: Throwable -> L60
        this.mBlockReportPatterns = l3.c.e(r22, "api_block_list");     // Catch: Throwable -> L60
        this.mAllowReportList = l3.c.c(r22, "api_allow_list");     // Catch: Throwable -> L60
        this.mAllowReportPatterns = l3.c.d(r22, "api_allow_list");     // Catch: Throwable -> L60
    L58:
        monitor-exit(this);
        return;
    L60:
        th = move-exception;
        throw th;
    }

    void updateConfigFromNet(boolean r10) {
        if (this.mFetchSettingInterval >= 600) goto L6;
        this.mFetchSettingInterval = 600;
    L6:
        if (com.bytedance.framwork.core.sdklib.apm6.j.f() == false) goto L16;
        StringBuilder r11 = new StringBuilder();
        r11.append("updateConfigFromNet:");
        if (r10 == true) goto L12;
        if (needUpdateConfigFromNet() == true) goto L12;
    L14:
        boolean r12 = false;
    L15:
        r11.append(r12);
        j3.c.a("APM-SDK", r11.toString());
    L12:
        if (com.bytedance.framwork.core.sdkmonitor.f.d(this.mContext) == false) goto L14;
        r12 = true;
    L16:
        if (r10 == true) goto L20;
        if (needUpdateConfigFromNet() == true) goto L20;
        return;
    L20:
        if (com.bytedance.framwork.core.sdkmonitor.f.d(this.mContext) == true) goto L22;
        return;
    L22:
        monitor-enter(SDKMonitor.class);
        this.mLastFetchSettingTime = System.currentTimeMillis();     // Catch: Throwable -> L27
        monitor-exit(SDKMonitor.class);     // Catch: Throwable -> L27
        k3.a.e().f(new i(this));     // Catch: Throwable -> L31
        return;
    L38:
        return;
    L27:
        th = move-exception;
        throw th;
    }
}
