package com.obric.cae.cloud.ttnet;

import a9.c;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.Callback;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.TTNetInit;
import com.obric.cae.log.CommSenseLog;
import e9.d;
import l6.a;
import org.json.JSONException;
import org.json.JSONObject;
import t2.b;
import w6.e;

/* JADX INFO: loaded from: classes.dex */
public class InitTTNetHelper {
    private static final String ACROSS_SEND_API_BOE = "https://os-boe.bytedance.net/cloud/os/api/app/log";
    private static final int ALOG_MAX_DIR_SIZE = 20971520;
    private static final int ALOG_PER_FILE_SZIE = 2097152;
    private static final String TAG = "InitTTNetHelper";
    public static final String TOKEN_KEY = "X-Tt-Token";
    private static Context mContext = null;
    private static final String requestBoeURL = "https://os-boe.bytedance.net/cloud/os/api/app/log";
    private static final String requestURL = "https://os.oceancloudapi.com/cloud/os/api/app/log";
    private static final e.a<c> sApiProcessHook = null;
    private static e.f<c> sMonitorProcessHook;

    static {
        sMonitorProcessHook = new AnonymousClass1();
        sApiProcessHook = new AnonymousClass2();
    }

    public InitTTNetHelper() {
    }

    public static /* synthetic */ void access$000(c r8, JSONObject r10) {
        packageRequestParamters(r8, r10);
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    public static void httpPostCloud(String r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        ((DemoService) d.e(requestURL).create(DemoService.class)).postCall(r8).enqueue(new AnonymousClass3());
    }

    public static void httpPostCloudTest() {
        DemoService r8 = (DemoService) d.e(requestURL).create(DemoService.class);
        JSONObject r10 = new JSONObject("{\"business_type\":\"wifi\",\"optimize_item\":1,\"header\":{\"device_id\":0,\"os_version\":\"\",\"app_version\":\"\"},\"remote_device_info\":{\"remote_mac\":\"\",\"remote_cod\":0,\"remote_device_name\":\"\"},\"error_list\":[{\"unique_id\":\"qwe12313yyy\",\"module\":1,\"profile_type\":4,\"category\":2,\"error_code\":\"\",\"error_message\":\"\",\"error_count\":0,\"last_happened_time\":\"\",\"fixed\":0,\"solution\":\"\",\"uploaded\":0,\"uploaded_time\":\"\",\"issue_id\":0}]}");     // Catch: JSONException -> L8
        if (r10.has("business_type") == false) goto L6;
        String r11 = r10.getString("business_type");     // Catch: JSONException -> L8
        Log.d(TAG, "has business_type value=" + r11);     // Catch: JSONException -> L8
    L12:
    L10:
        r8.postCall(a.z0("{\"business_type\":\"wifi\",\"optimize_item\":1,\"header\":{\"device_id\":0,\"os_version\":\"\",\"app_version\":\"\"},\"remote_device_info\":{\"remote_mac\":\"\",\"remote_cod\":0,\"remote_device_name\":\"\"},\"error_list\":[{\"unique_id\":\"qwe12313yyy\",\"module\":1,\"profile_type\":4,\"category\":2,\"error_code\":\"\",\"error_message\":\"\",\"error_count\":0,\"last_happened_time\":\"\",\"fixed\":0,\"solution\":\"\",\"uploaded\":0,\"uploaded_time\":\"\",\"issue_id\":0}]}").f()).enqueue(new AnonymousClass4());
        return;
    L6:
        CommSenseLog.e(TAG, "Error:no valid data module");     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        CommSenseLog.e(TAG, "Error " + e.getMessage());
        goto L10
    }

    public static void initTTNet(Context r10, Application r11) {
        String r8 = TAG;
        Log.i(r8, "initTTNet");
        mContext = r10;     // Catch: Throwable -> L5
        b.G = false;     // Catch: Throwable -> L5
        CronetDependencyAdapter.inject();     // Catch: Throwable -> L5
        TTNetInit.setTTNetDepend(new TTNetDependencyAdapter(r10));     // Catch: Throwable -> L5
        TTNetInit.setCronetDepend(new CronetDependencyAdapter());     // Catch: Throwable -> L5
        TTNetInit.tryInitTTNet(r10, r11, sApiProcessHook, sMonitorProcessHook, null, false, new boolean[]{false});     // Catch: Throwable -> L5
        TTNetInit.preInitCronetKernel();     // Catch: Throwable -> L5
        Log.d(r8, "initTTNet OK");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Log.e(TAG, "initTTNet error ", th);
        th.printStackTrace();
    }

    private static void packageRequestParamters(c r8, JSONObject r10) {
        if (r8 == null) goto L18;
        if (r10 == null) goto L19;
        r10.put("cronet_plugin_install", TTNetInit.getTTNetDepend().isCronetPluginInstalled());     // Catch: JSONException -> L13
        r10.put("appLevelRequestStart", r8.f12992c);     // Catch: JSONException -> L13
        r10.put("beforeAllInterceptors", r8.f12993d);     // Catch: JSONException -> L13
        r10.put("requestStart", r8.f12994e);     // Catch: JSONException -> L13
        r10.put("responseBack", r8.f12995f);     // Catch: JSONException -> L13
        r10.put("completeReadResponse", r8.f12996g);     // Catch: JSONException -> L13
        r10.put("requestEnd", r8.f12997h);     // Catch: JSONException -> L13
        r10.put("recycleCount", r8.f12998i);     // Catch: JSONException -> L13
        if (r8.f13009t != 0) goto L8;
        r10.put("timing_dns", r8.f12999j);     // Catch: JSONException -> L13
        r10.put("timing_connect", r8.f13000k);     // Catch: JSONException -> L13
        r10.put("timing_ssl", r8.f13001l);     // Catch: JSONException -> L13
        r10.put("timing_send", r8.f13002m);     // Catch: JSONException -> L13
        r10.put("timing_waiting", r8.f13005p);     // Catch: JSONException -> L13
        r10.put("timing_receive", r8.f13003n);     // Catch: JSONException -> L13
        r10.put("timing_total", r8.f13006q);     // Catch: JSONException -> L13
        r10.put("timing_isSocketReused", r8.f13004o);     // Catch: JSONException -> L13
        r10.put("timing_totalSendBytes", r8.f13007r);     // Catch: JSONException -> L13
        r10.put("timing_totalReceivedBytes", r8.f13008s);     // Catch: JSONException -> L13
        r10.put("timing_remoteIP", r8.f12990a);     // Catch: JSONException -> L13
        r10.put("request_log", r8.f13012w);     // Catch: JSONException -> L13
    L8:
        JSONObject r11 = r8.f13013x;     // Catch: JSONException -> L13
        if (r11 == null) goto L11;
        r10.put("req_info", r11);     // Catch: JSONException -> L13
    L11:
        r10.put("streaming", r8.f13014y);     // Catch: JSONException -> L13
        return;
    L13:
        e = move-exception;
        Logger.w(TAG, "[packageRequestParamters] json op error. ", e);
        return;
    L19:
        return;
    }

    public static void httpPostCloud(String r8, Callback<TypedInput> r10) {
        if (r8 != null) goto L4;
        return;
    L4:
        ((DemoService) d.e(requestURL).create(DemoService.class)).postCall(a.z0(r8).f()).enqueue(r10);
    }
}
