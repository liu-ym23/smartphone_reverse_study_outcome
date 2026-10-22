package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.frameworks.core.sdkmonitor.BuildConfig;
import com.bytedance.framwork.core.sdklib.apm6.LogReportController;
import com.bytedance.framwork.core.sdklib.apm6.j;
import com.bytedance.rpc.internal.RpcUtils;
import com.bytedance.services.apm.api.IHttpService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes2.dex */
public class SDKMonitor implements com.bytedance.framwork.core.sdklib.a.b {
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
    private c mIGetExtendParams;
    private volatile boolean mIsEncrypt;
    private volatile long mLastFetchSettingTime;
    private boolean mOversea;
    private volatile int mReportCount;
    private volatile int mReportInterval;
    private volatile int mReportSLA;

    public interface a {
        void a(boolean r1);
    }

    public interface b {
        String a();
    }

    public interface c {
        Map<String, String> getCommonParams();

        String getSessionId();
    }

    static {
        atomicLong = new AtomicLong(0);
    }

    public SDKMonitor(String r3) {
        this.mLastFetchSettingTime = 0;
        this.mConfigUrls = new LinkedList();
        this.mIsEncrypt = true;
        this.mAid = r3;
        this.mConfigExit = false;
        this.mCacheData = new com.bytedance.framwork.core.sdkmonitor.b();
    }

    static /* synthetic */ void access$000(SDKMonitor r2, Context r3, JSONObject r4, c r5) {
        r2.initMonitor((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ boolean access$100(SDKMonitor r0) {
        return r0.mConfigExit;
    }

    static /* synthetic */ boolean access$102(SDKMonitor r0, boolean r1) {
        r0.mConfigExit = r1;
        return r1;
    }

    static /* synthetic */ com.bytedance.framwork.core.sdkmonitor.b access$200(SDKMonitor r0) {
        return r0.mCacheData;
    }

    static /* synthetic */ Map access$300(SDKMonitor r0) {
        return r0.mCommonParams;
    }

    static /* synthetic */ List access$400(SDKMonitor r0) {
        return r0.mConfigUrls;
    }

    static /* synthetic */ StringBuilder access$500(SDKMonitor r0, String r1) {
        return r0.addConfigParamsToURL(r1);
    }

    static /* synthetic */ long access$600(SDKMonitor r2) {
        return r2.lastCalculateTimestamp;
    }

    static /* synthetic */ IHttpService access$700(SDKMonitor r0) {
        return r0.getHttpService();
    }

    static /* synthetic */ boolean access$800(SDKMonitor r0) {
        return r0.mIsEncrypt;
    }

    static /* synthetic */ void access$900(SDKMonitor r0, JSONObject r1, int r2) {
        r0.updateToSP(r1, r2);
    }

    private StringBuilder addConfigParamsToURL(String r5) {
        StringBuilder r0 = new StringBuilder(r5);
        if (TextUtils.isDigitsOnly(r5) == false) goto L5;
    L21:
        return r0;
    L5:
        if (this.mCommonParams == null) goto L21;
        if (r5.contains("?") == true) goto L10;
        r0.append("?");
    L10:
        appendUrlParam(r0, "sdk_version", String.valueOf(400));
        HashMap r6 = new HashMap(this.mCommonParams);
        if (TextUtils.isEmpty(hostAid) == true) goto L14;
        r6.put("host_aid", hostAid);
    L14:
        if (r6.size() <= 0) goto L21;
        Iterator r7 = r6.entrySet().iterator();
    L17:
        if (r7.hasNext() == false) goto L21;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r1.getKey() == null) goto L17;
        appendUrlParam(r0, String.valueOf(r1.getKey()), String.valueOf(r1.getValue()));
        goto L17
    }

    private void addDebugMessage(JSONObject r6) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L4
        r0.put("aid", this.mAid);     // Catch: Exception -> L4
        com.bytedance.framwork.core.sdklib.b.a.a(r0);     // Catch: Exception -> L4
        r0.put("process_name", com.bytedance.framwork.core.sdklib.b.d.a(this.mContext));     // Catch: Exception -> L4
        r0.put(KEY_DEBUG_UUID, sid + "_" + atomicLong.getAndAdd(1));     // Catch: Exception -> L4
        r6.put(KEY_SELF_DEBUG_MESSAGE, r0);     // Catch: Exception -> L4
        return;
    }

    private StringBuilder addParamsToURL(String r5) {
        StringBuilder r0 = new StringBuilder(r5);
        if (TextUtils.isDigitsOnly(r5) == false) goto L5;
    L20:
        return r0;
    L5:
        if (this.mCommonParams == null) goto L20;
        if (r5.contains("?") == true) goto L10;
        r0.append("?");
    L10:
        appendUrlParam(r0, "sdk_version", String.valueOf(400));
        Map<String, String> r6 = this.mCommonParams;
        if (r6 == null) goto L20;
        if (r6.size() <= 0) goto L20;
        Iterator<Map.Entry<String, String>> r7 = r6.entrySet().iterator();
    L16:
        if (r7.hasNext() == false) goto L20;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r1.getKey() == null) goto L16;
        appendUrlParam(r0, String.valueOf(r1.getKey()), String.valueOf(r1.getValue()));
        goto L16
    }

    private StringBuilder appendUrlParam(StringBuilder r2, String r3, String r4) {
        if (r2.charAt(r2.length() - 1) == '?') goto L5;
        r2.append("&");
    L5:
        r2.append(encode(r3, RpcUtils.CHARSET_UTF8)).append('=').append(encode(r4, RpcUtils.CHARSET_UTF8));
        return r2;
    }

    private void combineJson(JSONObject r4, JSONObject r5) {
        if (r4 == null) goto L19;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.length() <= 0) goto L21;
        Iterator<String> r3 = r5.keys();     // Catch: JSONException -> L12
    L9:
        if (r3.hasNext() == false) goto L22;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L12
        r4.put(r0, r5.get(r0));     // Catch: JSONException -> L12
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

    private static String encode(String r0, String r1) {
        if (r1 != null) goto L10;
        r1 = RpcUtils.CHARSET_UTF8;
    L10:
        return URLEncoder.encode(r0, r1);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    private IHttpService getHttpService() {
        if (this.mHttpService != null) goto L6;
        this.mHttpService = (IHttpService) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IHttpService.class), IHttpService.class, "com.obric.memorydata.plugin");
    L6:
        if (this.mHttpService != null) goto L8;
        monitor-enter(this);
        IHttpService r0 = hostHttpService;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L13:
        th = move-exception;
        throw th;
    L8:
        return this.mHttpService;
    }

    private String getSessionId() {
        c r0 = this.mIGetExtendParams;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getSessionId();
    }

    private SharedPreferences getSp() {
        return this.mContext.getSharedPreferences("monitor_config" + this.mAid + e.a(this.mContext), 0);
    }

    private void initConfig() {
        SharedPreferences r0 = getSp();
        String r1 = r0.getString("monitor_net_config", null);
        this.mLastFetchSettingTime = r0.getLong("monitor_configure_refresh_time", 0);
        this.lastCalculateTimestamp = r0.getLong("monitor_last_calculate_timestamp", 0);
        if (r0.getInt("monitor_config_update", 0) != 1) goto L5;
        boolean r2 = true;
    L6:
        com.bytedance.framwork.core.sdklib.a.a.a().a(this);
        if (TextUtils.isEmpty(r1) == false) goto L16;
    L14:
        updateConfigFromNet(false);
        return;
    L16:
        this.mConfigExit = true;     // Catch: Exception -> L13
        JSONObject r3 = new JSONObject(r1);     // Catch: Exception -> L13
        if (r2 == true) goto L11;
        r3.remove("report_host_new");     // Catch: Exception -> L13
    L11:
        updateConfig(r3);     // Catch: Exception -> L13
    L13:
        Log.e("monitor_config", "config error");
        goto L14
    L5:
        r2 = false;
        goto L6
    }

    private void initMonitor(Context r20, JSONObject r21, c r22) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r20, Context.class, "com.obric.memorydata.plugin");
        c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r22, c.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L32;
        if (r21 == null) goto L33;
        this.mHasInit = true;
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.mHeaderInfo = r21;
        r21.put("aid", this.mAid);     // Catch: Exception -> L29
        this.mHeaderInfo.put("os", LocationInfoConst.SYSTEM);     // Catch: Exception -> L29
        this.mHeaderInfo.put("device_platform", "android");     // Catch: Exception -> L29
        this.mHeaderInfo.put("os_version", Build.VERSION.RELEASE);     // Catch: Exception -> L29
        this.mHeaderInfo.put("os_api", Build.VERSION.SDK_INT);     // Catch: Exception -> L29
        this.mHeaderInfo.put("device_model", Build.MODEL);     // Catch: Exception -> L29
        this.mHeaderInfo.put("device_brand", Build.BRAND);     // Catch: Exception -> L29
        this.mHeaderInfo.put("device_manufacturer", Build.MANUFACTURER);     // Catch: Exception -> L29
        this.mHeaderInfo.put("sdkmonitor_version", BuildConfig.VERSION_NAME);     // Catch: Exception -> L29
        this.mHeaderInfo.put("monitor_from", "sdk");     // Catch: Exception -> L29
        if (TextUtils.isEmpty(this.mHeaderInfo.optString("package_name")) == false) goto L10;
        this.mHeaderInfo.put("package_name", r2.getPackageName());     // Catch: Exception -> L29
    L10:
        PackageInfo r1 = null;
        if (TextUtils.isEmpty(this.mHeaderInfo.optString("version_name")) == false) goto L14;
        r1 = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0);     // Catch: Exception -> L29
        this.mHeaderInfo.put("version_name", r1.versionName);     // Catch: Exception -> L29
    L14:
        if (TextUtils.isEmpty(this.mHeaderInfo.optString("version_code")) == false) goto L18;
        if (r1 != null) goto L17;
        r1 = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0);     // Catch: Exception -> L29
    L17:
        this.mHeaderInfo.put("version_code", r1.versionCode);     // Catch: Exception -> L29
    L18:
        this.mIGetExtendParams = r3;     // Catch: Exception -> L29
        if (r3 != null) goto L21;
        this.mIGetExtendParams = new AnonymousClass6(this);     // Catch: Exception -> L29
    L21:
        Map<String, String> r4 = this.mIGetExtendParams.getCommonParams();     // Catch: Exception -> L29
        this.mCommonParams = r4;     // Catch: Exception -> L29
        if (r4 != null) goto L24;
        this.mCommonParams = new HashMap();     // Catch: Exception -> L29
    L24:
        this.mOversea = TextUtils.equals((CharSequence) ZeusTransformUtils.preCheckCast(this.mCommonParams.get("oversea"), CharSequence.class, "com.obric.memorydata.plugin"), "1");     // Catch: Exception -> L29
        this.mCommonParams.put("aid", this.mAid);     // Catch: Exception -> L29
        this.mCommonParams.put("device_id", this.mHeaderInfo.optString("device_id"));     // Catch: Exception -> L29
        this.mCommonParams.put("device_platform", "android");     // Catch: Exception -> L29
        this.mCommonParams.put("package_name", this.mHeaderInfo.optString("package_name"));     // Catch: Exception -> L29
        this.mCommonParams.put("channel", this.mHeaderInfo.optString("channel"));     // Catch: Exception -> L29
        this.mCommonParams.put("app_version", this.mHeaderInfo.optString("app_version"));     // Catch: Exception -> L29
        this.mCommonParams.put("sdkmonitor_version", BuildConfig.VERSION_NAME);     // Catch: Exception -> L29
        this.mCommonParams.put("minor_version", "1");     // Catch: Exception -> L29
        if (j.d() == false) goto L27;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "initSDK:" + this.mAid + " " + this.mCommonParams);     // Catch: Exception -> L29
    L27:
        j.a(r2);     // Catch: Exception -> L29
        j.a(this.mCommonParams);     // Catch: Exception -> L29
        j.a(this.mAid, com.bytedance.framwork.core.sdklib.b.b.a(this.mHeaderInfo));     // Catch: Exception -> L29
        this.mHttpService = (IHttpService) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IHttpService.class), IHttpService.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L29
        initConfig();     // Catch: Exception -> L29
        return;
    L34:
        return;
    L33:
        return;
    }

    private boolean isMatch(String r5, List<String> r6, List<Pattern> r7) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return false;
    L6:
        if (com.bytedance.framwork.core.sdklib.b.c.a(r4) == true) goto L23;
        Iterator r9 = r4.iterator();
    L9:
        if (r9.hasNext() == false) goto L23;
        if (r5.contains((String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L9;
        return true;
    L23:
        String r10 = new URI(r5).getPath();     // Catch: Throwable -> L22
        if (com.bytedance.framwork.core.sdklib.b.c.a(r8) == true) goto L21;
        Iterator r11 = r8.iterator();     // Catch: Throwable -> L22
    L17:
        if (r11.hasNext() == false) goto L21;
        if (((Pattern) ZeusTransformUtils.preCheckCast(r11.next(), Pattern.class, "com.obric.memorydata.plugin")).matcher(r10).matches() == false) goto L17;
        return true;
    L21:
        return false;
    }

    private boolean isMatchAllowURI(String r3) {
        return isMatch(r3, this.mAllowReportList, this.mAllowReportPatterns);
    }

    private boolean isMatchBlackURI(String r3) {
        return isMatch(r3, this.mBlockReportList, this.mBlockReportPatterns);
    }

    private boolean needUpdateConfigFromNet() {
        if (((System.currentTimeMillis() - this.mLastFetchSettingTime) / 1000) <= this.mFetchSettingInterval) goto L5;
        return true;
    L5:
        return false;
    }

    private JSONObject packLog(String r4, long r5, long r7, String r9, String r10, String r11, int r12) {
        if (TextUtils.isEmpty(r4) == false) goto L22;
        return null;
    L22:
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L21
        r0.put("log_type", r4);     // Catch: Exception -> L21
        r0.put("duration", r5);     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r9) == true) goto L9;
        r0.put("uri", Uri.parse(r9));     // Catch: Exception -> L21
    L9:
        if (r7 <= 0) goto L11;
        r0.put("timestamp", r7);     // Catch: Exception -> L21
    L11:
        r0.put("status", r12);     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r10) == true) goto L16;
        r0.put("ip", r10);     // Catch: Exception -> L21
    L16:
        if (TextUtils.isEmpty(r11) == true) goto L18;
        r0.put("trace_code", r11);     // Catch: Exception -> L21
    L19:
        r0.put(Constants.KEY_NET_TYPE, getNetWorkType());     // Catch: Exception -> L21
        return r0;
    L18:
        r0.put("trace_code", "");     // Catch: Exception -> L21
    L21:
        return null;
    }

    static void setHostAid(String r0) {
        hostAid = r0;
    }

    static void setHttpService(IHttpService r2) {
        IHttpService r3 = (IHttpService) ZeusTransformUtils.wrapperContextForParams(r2, IHttpService.class, "com.obric.memorydata.plugin");
        monitor-enter(SDKMonitor.class);
        hostHttpService = r3;     // Catch: Throwable -> L7
        monitor-exit(SDKMonitor.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void updateToSP(JSONObject r8, int r9) {
        if (r8 != null) goto L5;
    L15:
        if (r9 != 1) goto L24;
        SharedPreferences.Editor r7 = getSp().edit();
        r7.putLong("monitor_configure_refresh_time", System.currentTimeMillis());
        r7.putInt("monitor_config_update", 1);
        r7.apply();
        if (j.d() == false) goto L25;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "updateToSP:code:1");
        return;
    L25:
        return;
    L24:
        return;
    L5:
        if (r8.length() <= 0) goto L15;
        updateConfig(r8);     // Catch: Throwable -> L13
        SharedPreferences.Editor r10 = getSp().edit();     // Catch: Throwable -> L13
        long r5 = System.currentTimeMillis();     // Catch: Throwable -> L13
        r10.putLong("monitor_configure_refresh_time", r5);     // Catch: Throwable -> L13
        r10.putInt("monitor_config_update", 1);     // Catch: Throwable -> L13
        r10.putLong("monitor_last_calculate_timestamp", r5);     // Catch: Throwable -> L13
        r10.putString("monitor_net_config", r8.toString());     // Catch: Throwable -> L13
        r10.apply();     // Catch: Throwable -> L13
        if (this.mConfigExit == true) goto L10;
        this.mConfigExit = true;     // Catch: Throwable -> L13
        this.mCacheData.a(this);     // Catch: Throwable -> L13
    L10:
        if (j.d() == false) goto L22;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "updateToSP");     // Catch: Throwable -> L13
        return;
    L22:
        return;
    L13:
        th = move-exception;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "updateToSP", th);
    }

    public void flushBuffer() {
    }

    public void flushBuffer(a r2) {
        a r1 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
    }

    public void flushReport() {
        com.bytedance.framwork.core.sdklib.a.a.a().a(new AnonymousClass11(this));
    }

    public void flushReport(a r3) {
        final a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        com.bytedance.framwork.core.sdklib.a.a.a().a(new AnonymousClass2(this, r4));
    }

    public boolean getLogTypeSwitch(String r3) {
        if (this.mAllowLogType != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (this.mAllowLogType.opt(r3) == null) goto L12;
        return true;
    L12:
        return false;
    }

    public int getNetWorkType() {
        return NetworkUtils.e(this.mContext).getValue();
    }

    public boolean getServiceSwitch(String r3) {
        if (this.mAllowService != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (this.mAllowService.opt(r3) == null) goto L12;
        return true;
    L12:
        return false;
    }

    void handleApiError(long r12, long r14, String r16, String r17, String r18, int r19, JSONObject r20) {
        if (this.mDisableReportApiError != 1) goto L5;
        return;
    L5:
        if (isMatchBlackURI(r16) == true) goto L16;
        JSONObject r0 = packLog("api_error", r12, r14, r16, r17, r18, r19);
        combineJson(r0, r20);
        if (r0 != null) goto L10;
        return;
    L10:
        if (r0.length() <= 0) goto L15;
        addDebugMessage(r0);
        com.bytedance.framwork.core.sdklib.apm6.g.a().a(Long.parseLong(this.mAid), r0);
        return;
    L15:
        return;
    }

    void handleNetSLA(long r13, long r15, String r17, String r18, String r19, int r20, JSONObject r21) {
        if (isMatchBlackURI(r17) == false) goto L5;
        return;
    L5:
        if (f.a(this.mContext) == false) goto L20;
        JSONObject r0 = packLog("api_all", r13, r15, r17, r18, r19, r20);
        combineJson(r0, r21);
        if (r0 == null) goto L12;
        if (isMatchAllowURI(r17) == false) goto L12;
    L16:
        r0.put("hit_rules", 1);     // Catch: JSONException -> L15
        addDebugMessage(r0);     // Catch: JSONException -> L15
        com.bytedance.framwork.core.sdklib.apm6.g.a().a(Long.parseLong(this.mAid), r0);     // Catch: JSONException -> L15
        return;
    L21:
        return;
    L12:
        if (this.mReportSLA != 0) goto L16;
        return;
    }

    public boolean init(Context r3, JSONObject r4, b r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        final b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L7;
        return init(r6, r4, new AnonymousClass1(this));
    L7:
        return init(r6, r4, new AnonymousClass4(this, r7));
    }

    public boolean init(Context r5, final JSONObject r6, c r7) {
        final Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        final c r9 = (c) ZeusTransformUtils.wrapperContextForParams(r7, c.class, "com.obric.memorydata.plugin");
        if (this.mHasInit == false) goto L5;
        return true;
    L5:
        this.mHasInit = true;
        sid = System.currentTimeMillis();
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a(com.bytedance.framwork.core.sdklib.apm6.safety.b.a());
        com.bytedance.framwork.core.sdklib.a.a.a().a(new AnonymousClass5(this, r8, r6, r9), 5000);
        return true;
    }

    public boolean isHasInit() {
        return this.mHasInit;
    }

    public void monitorApiError(final long r14, final long r16, final String r18, final String r19, final String r20, final int r21, final JSONObject r22) {
        if (this.mConfigExit == true) goto L6;
        this.mCacheData.a(new com.bytedance.framwork.core.sdkmonitor.a("api_all", r14, r16, r18, r19, r20, r21, r22));     // Catch: Throwable -> L8
    L9:
        return;
    L6:
        com.bytedance.framwork.core.sdklib.a.a.a().a(new AnonymousClass9(this, r14, r16, r18, r19, r20, r21, r22));     // Catch: Throwable -> L8
    }

    public void monitorCommonLog(String r4, JSONObject r5) {
        if (this.mConfigExit == true) goto L5;
        this.mCacheData.a(new com.bytedance.framwork.core.sdkmonitor.c(r4, r5, System.currentTimeMillis()));     // Catch: Throwable -> L7
    L8:
        return;
    L5:
        monitorCommonLogAsync(r4, r5, System.currentTimeMillis());     // Catch: Throwable -> L7
    }

    void monitorCommonLogAsync(final String r9, final JSONObject r10, final long r11) {
        com.bytedance.framwork.core.sdklib.a.a.a().a(new AnonymousClass3(this, r9, r10, r11));
    }

    void monitorCommonLogInternal(String r4, JSONObject r5, long r6) {
        r5.put("log_type", r4);     // Catch: Throwable -> L13
        r5.put(Constants.KEY_NET_TYPE, getNetWorkType());     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(getSessionId()) == true) goto L7;
        r5.put("session_id", getSessionId());     // Catch: Throwable -> L13
    L7:
        if (r5.isNull("timestamp") == false) goto L10;
        r5.put("timestamp", r6);     // Catch: Throwable -> L13
    L10:
        if (getLogTypeSwitch(r4) == false) goto L16;
        addDebugMessage(r5);     // Catch: Throwable -> L13
        com.bytedance.framwork.core.sdklib.apm6.g.a().a(Long.parseLong(this.mAid), r5);     // Catch: Throwable -> L13
        return;
    L16:
        return;
    }

    public void monitorDuration(String r2, JSONObject r3, JSONObject r4) {
        monitorStatusAndDuration(r2, 0, r3, r4);
    }

    public void monitorEvent(String r12, JSONObject r13, JSONObject r14, JSONObject r15) {
        if (this.mConfigExit == true) goto L5;
        this.mCacheData.a(new h(r12, 0, null, r13, r14, r15, System.currentTimeMillis()));     // Catch: Throwable -> L7
    L8:
        return;
    L5:
        monitorServiceAsync(r12, 0, null, r13, r14, r15, System.currentTimeMillis());     // Catch: Throwable -> L7
    }

    public void monitorSLA(final long r14, final long r16, final String r18, final String r19, final String r20, final int r21, final JSONObject r22) {
        if (this.mConfigExit == true) goto L6;
        this.mCacheData.a(new com.bytedance.framwork.core.sdkmonitor.a("api_all", r14, r16, r18, r19, r20, r21, r22));     // Catch: Throwable -> L8
    L9:
        return;
    L6:
        com.bytedance.framwork.core.sdklib.a.a.a().a(new AnonymousClass8(this, r14, r16, r18, r19, r20, r21, r22));     // Catch: Throwable -> L8
    }

    void monitorService(String r4, int r5, JSONObject r6, JSONObject r7, JSONObject r8, JSONObject r9, long r10) {
        if (r9 == null) goto L21;
    L5:
        r9.put("log_type", "service_monitor");     // Catch: Throwable -> L20
        r9.put("service", r4);     // Catch: Throwable -> L20
        r9.put("status", r5);     // Catch: Throwable -> L20
        r9.put(Constants.KEY_NET_TYPE, getNetWorkType());     // Catch: Throwable -> L20
        r9.put(EventBody.KEY_VALUE, r6);     // Catch: Throwable -> L20
        if (r7 == null) goto L8;
        r9.put(EventBody.KEY_CATEGORY, r7);     // Catch: Throwable -> L20
    L8:
        if (r8 == null) goto L11;
        r9.put(EventBody.KEY_METRIC, r8);     // Catch: Throwable -> L20
    L11:
        if (r9.isNull("timestamp") == false) goto L14;
        r9.put("timestamp", r10);     // Catch: Throwable -> L20
    L14:
        if (TextUtils.isEmpty(getSessionId()) == true) goto L17;
        r9.put("session_id", getSessionId());     // Catch: Throwable -> L20
    L17:
        if (getServiceSwitch(r4) == false) goto L23;
        addDebugMessage(r9);     // Catch: Throwable -> L20
        com.bytedance.framwork.core.sdklib.apm6.g.a().a(Long.parseLong(this.mAid), r9);     // Catch: Throwable -> L20
        return;
    L24:
        return;
    L23:
        return;
    L21:
        r9 = new JSONObject();     // Catch: Throwable -> L20
        goto L5
    }

    void monitorServiceAsync(final String r13, final int r14, final JSONObject r15, final JSONObject r16, final JSONObject r17, final JSONObject r18, final long r19) {
        com.bytedance.framwork.core.sdklib.a.a.a().a(new AnonymousClass10(this, r13, r14, r15, r16, r17, r18, r19));
    }

    public void monitorStatusAndDuration(String r12, int r13, JSONObject r14, JSONObject r15) {
        if (this.mConfigExit == true) goto L5;
        this.mCacheData.a(new h(r12, r13, r14, null, null, r15, System.currentTimeMillis()));     // Catch: Throwable -> L7
    L8:
        return;
    L5:
        monitorServiceAsync(r12, r13, r14, null, null, r15, System.currentTimeMillis());     // Catch: Throwable -> L7
    }

    public void monitorStatusAndEvent(String r12, int r13, JSONObject r14, JSONObject r15, JSONObject r16) {
        if (this.mConfigExit == true) goto L6;
        this.mCacheData.a(new h(r12, r13, null, r14, r15, r16, System.currentTimeMillis()));     // Catch: Throwable -> L8
    L9:
        return;
    L6:
        monitorServiceAsync(r12, r13, null, r14, r15, r16, System.currentTimeMillis());     // Catch: Throwable -> L8
    }

    public void monitorStatusRate(String r2, int r3, JSONObject r4) {
        monitorStatusAndDuration(r2, r3, null, r4);
    }

    @Override // com.bytedance.framwork.core.sdklib.a.b
    public void onTimeEvent(long r3) {
        if (this.mFetchSettingInterval > 0) goto L5;
        return;
    L5:
        updateConfigFromNet(false);
    }

    public JSONObject reportJsonHeaderInfo() {
        return this.mHeaderInfo;
    }

    void resetConfigUrls(List<String> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if (com.bytedance.framwork.core.sdklib.b.c.a(r4) == true) goto L9;
        this.mConfigUrls.clear();
        this.mConfigUrls.addAll(r4);
        return;
    }

    void resetReportUrls(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if (com.bytedance.framwork.core.sdklib.b.c.a(r4) == true) goto L9;
        LogReportController.getInstance().setReportUrlList(this.mAid, r4);
        return;
    }

    synchronized void updateConfig(JSONObject r9) {
        monitor-enter(this);
        if (r9 != null) goto L64;
        monitor-exit(this);
        return;
    L64:
        JSONObject r0 = JsonUtils.optJSONObject(r9, d.f2646a, d.d);     // Catch: Throwable -> L60
        if (r0 == null) goto L49;
        JSONObject r2 = r0.optJSONObject(d.f);     // Catch: Throwable -> L60
        if (r2 == null) goto L12;
        this.mFetchSettingInterval = r2.optLong(d.g, 1200);     // Catch: Throwable -> L60
    L12:
        if (this.mFetchSettingInterval >= 600) goto L14;
        this.mFetchSettingInterval = 600;     // Catch: Throwable -> L60
    L14:
        JSONObject r1 = r0.optJSONObject(d.h);     // Catch: Throwable -> L60
        if (r1 == null) goto L49;
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L60
        JSONArray r4 = r1.optJSONArray("hosts");     // Catch: Exception -> L63 Throwable -> L60
        if (r4 == null) goto L37;
        if (r4.length() <= 0) goto L37;
        int r5 = r4.length();     // Catch: Exception -> L63 Throwable -> L60
        int r6 = 0;
    L22:
        if (r6 >= r5) goto L37;
        String r7 = r4.getString(r6);     // Catch: Exception -> L63 Throwable -> L60
        if (this.mOversea == false) goto L31;
        if (r7.contains(".snssdk.") == true) goto L29;
        if (r7.contains(".toutiao.") == false) goto L31;
    L29:
        r3.clear();     // Catch: Exception -> L63 Throwable -> L60
    L31:
        if (TextUtils.isEmpty(r7) == true) goto L35;
        if (r7.indexOf(46) <= 0) goto L35;
        r3.add(r7);     // Catch: Exception -> L63 Throwable -> L60
    L35:
        r6 = r6 + 1;
    L37:
        if (r3.isEmpty() == true) goto L39;
        LogReportController.getInstance().setReportUrlList(this.mAid, r3);     // Catch: Throwable -> L60
    L39:
        int r8 = 60;
        this.mReportInterval = r1.optInt("uploading_interval", 60);     // Catch: Throwable -> L60
        if (this.mReportInterval < 0) goto L43;
        r8 = this.mReportInterval;     // Catch: Throwable -> L60
    L43:
        this.mReportInterval = r8;     // Catch: Throwable -> L60
        com.bytedance.framwork.core.sdklib.apm6.d.a().a(this.mReportInterval * 1000);     // Catch: Throwable -> L60
        int r10 = 100;
        this.mReportCount = r1.optInt("once_max_count", 100);     // Catch: Throwable -> L60
        if (this.mReportCount < 0) goto L47;
        r10 = this.mReportCount;     // Catch: Throwable -> L60
    L47:
        this.mReportCount = r10;     // Catch: Throwable -> L60
        this.mIsEncrypt = r1.optBoolean("enable_encrypt", true);     // Catch: Throwable -> L60
        LogReportController.getInstance().setEncrypt(this.mAid, this.mIsEncrypt);     // Catch: Throwable -> L60
    L49:
        if (r9.length() > 0) goto L52;
        monitor-exit(this);
        return;
    L52:
        JSONObject r11 = r9.optJSONObject(d.f2647b);     // Catch: Throwable -> L60
        if (r11 == null) goto L55;
        this.mAllowService = r11.optJSONObject("allow_service_name");     // Catch: Throwable -> L60
        this.mAllowLogType = r11.optJSONObject(SlardarSettingsConstants.KEY_ALLOW_LOG_TYPE);     // Catch: Throwable -> L60
    L55:
        JSONObject r12 = JsonUtils.optJSONObject(r9, d.c, d.e);     // Catch: Throwable -> L60
        if (r12 == null) goto L58;
        this.mDisableReportApiError = r12.optInt("enable_api_error_upload", 0);     // Catch: Throwable -> L60
        this.mReportSLA = r12.optInt("enable_api_all_upload", 0);     // Catch: Throwable -> L60
        this.mBlockReportList = com.bytedance.framwork.core.sdklib.b.c.a(r12, "api_block_list");     // Catch: Throwable -> L60
        this.mBlockReportPatterns = com.bytedance.framwork.core.sdklib.b.c.b(r12, "api_block_list");     // Catch: Throwable -> L60
        this.mAllowReportList = com.bytedance.framwork.core.sdklib.b.c.c(r12, "api_allow_list");     // Catch: Throwable -> L60
        this.mAllowReportPatterns = com.bytedance.framwork.core.sdklib.b.c.d(r12, "api_allow_list");     // Catch: Throwable -> L60
    L58:
        monitor-exit(this);
        return;
    L60:
        th = move-exception;
        throw th;
    }

    void updateConfigFromNet(boolean r5) {
        if (this.mFetchSettingInterval >= 600) goto L6;
        this.mFetchSettingInterval = 600;
    L6:
        if (j.d() == false) goto L16;
        StringBuilder r1 = new StringBuilder().append("updateConfigFromNet:");
        if (r5 == true) goto L12;
        if (needUpdateConfigFromNet() == true) goto L12;
    L14:
        boolean r2 = false;
    L15:
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", r1.append(r2).toString());
    L12:
        if (f.a(this.mContext) == false) goto L14;
        r2 = true;
    L16:
        if (r5 == true) goto L20;
        if (needUpdateConfigFromNet() == true) goto L20;
        return;
    L20:
        if (f.a(this.mContext) == true) goto L22;
        return;
    L22:
        monitor-enter(SDKMonitor.class);
        this.mLastFetchSettingTime = System.currentTimeMillis();     // Catch: Throwable -> L27
        monitor-exit(SDKMonitor.class);     // Catch: Throwable -> L27
        com.bytedance.framwork.core.sdklib.a.a.a().a(new AnonymousClass7(this));     // Catch: Throwable -> L31
        return;
    L38:
        return;
    L27:
        th = move-exception;
        throw th;
    }
}
