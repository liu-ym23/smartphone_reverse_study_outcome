package com.obric.cae.cloud.ttnet;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.h;
import com.bytedance.frameworks.baselib.network.http.f;
import com.bytedance.ttnet.TTNetInit;
import com.obric.cae.userAware.utils.MatrixDidUtils;
import com.ss.android.common.applog.AppLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6940a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f6941b = null;

    public class a implements f.l<com.bytedance.ttnet.b.b> {
        public a() {
        }

        @Override // com.bytedance.frameworks.baselib.network.http.f.l
        public final void a(long r12, long r14, String r16, String r17, com.bytedance.frameworks.baselib.network.http.b r18) {
            com.bytedance.ttnet.b.b r0 = (com.bytedance.ttnet.b.b) ZeusTransformUtils.preCheckCast(r18, com.bytedance.ttnet.b.b.class, "com.obric.memorydata.plugin");
            String[] r1 = new String[1];     // Catch: Throwable -> L8
            JSONObject r10 = new JSONObject();     // Catch: Throwable -> L8
            if (h.a(r1[0]) == false) goto L6;
            r1[0] = r0.w;     // Catch: Throwable -> L8
        L6:
            c.a(r0, r10);     // Catch: Throwable -> L8
            com.bytedance.apm.a.a(r12, r14, r16, r1[0], r17, 200, r10);     // Catch: Throwable -> L8
            return;
        }

        @Override // com.bytedance.frameworks.baselib.network.http.f.l
        public final void a(long r16, long r18, String r20, String r21, com.bytedance.frameworks.baselib.network.http.b r22, Throwable r23) {
            com.bytedance.ttnet.b.b r1 = (com.bytedance.ttnet.b.b) ZeusTransformUtils.preCheckCast(r22, com.bytedance.ttnet.b.b.class, "com.obric.memorydata.plugin");
            String[] r3 = new String[1];     // Catch: Throwable -> L24
            int r13 = com.obric.cae.cloud.ttnet.b.a(r23, r3);     // Catch: Throwable -> L24
            JSONObject r14 = new JSONObject();     // Catch: Throwable -> L24
            if (r23 == null) goto L20;
            if (h.a(r23.getClass().getName()) == true) goto L20;
            r14.put("ex_name", r23.getClass().getName());     // Catch: Throwable -> L24
            if (r13 != 1) goto L12;
            if (ApmDelegate.a().a("ex_message_open") == false) goto L12;
        L13:
            String r0 = com.bytedance.ttnet.utils.d.a(r23);     // Catch: Throwable -> L24
            if (h.a(r0) == true) goto L16;
            r14.put("ex_message", r0);     // Catch: Throwable -> L24
        L16:
            String r2 = com.bytedance.ttnet.c.a();     // Catch: Throwable -> L24
            if (h.a(r2) == true) goto L20;
            r14.put("cronet_init_ex_message", r2);     // Catch: Throwable -> L24
        L12:
            if (ApmDelegate.a().a("debug_ex_message_open") == true) goto L13;
        L20:
            if (h.a(r3[0]) == false) goto L22;
            r3[0] = r1.w;     // Catch: Throwable -> L24
        L22:
            c.a(r1, r14);     // Catch: Throwable -> L24
            com.bytedance.apm.a.b(r16, r18, r20, r3[0], r21, r13, r14);     // Catch: Throwable -> L24
            com.bytedance.apm.a.a(r16, r18, r20, r3[0], r21, r13, r14);     // Catch: Throwable -> L24
            return;
        }
    }

    public class b implements f.d<com.bytedance.ttnet.b.b> {
        public b() {
        }

        @Override // com.bytedance.frameworks.baselib.network.http.f.d
        public final String a(String r1, boolean r2) {
            return AppLog.a(r1, r2);
        }

        @Override // com.bytedance.frameworks.baselib.network.http.f.d
        public final String a(String r1, boolean r2, Object... r3) {
            return r1;
        }

        @Override // com.bytedance.frameworks.baselib.network.http.f.d
        public final Map<String, String> a(int r3) {
            com.obric.cae.log.a.c("InitTTNetHelper", "getCommonParamsByLevel ");
            HashMap r2 = new HashMap();
            r2.put("did", MatrixDidUtils.getDid());
            r2.put("aid", String.valueOf(941134));
            r2.put("os", "android");
            r2.put("channel", "local_test");
            r2.put("abis", "armv8");
            r2.put("version", "10.0.0");
            if (r3 != 0) goto L5;
            r2.put("mac", "2141:12331");
            r2.put("install-id", "444444");
        L5:
            return r2;
        }

        @Override // com.bytedance.frameworks.baselib.network.http.f.d
        public final void a() {
        }
    }

    static {
        f6940a = new a();
        f6941b = new b();
    }

    public static void a(Context r9, Application r10) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Application r3 = (Application) ZeusTransformUtils.wrapperContextForParams(r10, Application.class, "com.obric.memorydata.plugin");
        Log.i("InitTTNetHelper", "initTTNet");
        com.bytedance.ttnet.config.f.b();     // Catch: Throwable -> L5
        CronetDependencyAdapter.inject();     // Catch: Throwable -> L5
        TTNetInit.setTTNetDepend(new d(r2));     // Catch: Throwable -> L5
        TTNetInit.setCronetDepend(new CronetDependencyAdapter());     // Catch: Throwable -> L5
        TTNetInit.tryInitTTNet(r2, r3, f6941b, f6940a, null, false, new boolean[]{false});     // Catch: Throwable -> L5
        TTNetInit.preInitCronetKernel();     // Catch: Throwable -> L5
        Log.d("InitTTNetHelper", "initTTNet OK");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Log.e("InitTTNetHelper", "initTTNet error ", th);
        th.printStackTrace();
    }

    public static void a(com.bytedance.ttnet.b.b r3, JSONObject r4) {
        if (r3 == null) goto L16;
        r4.put("cronet_plugin_install", TTNetInit.getTTNetDepend().a());     // Catch: JSONException -> L11
        r4.put("appLevelRequestStart", r3.e);     // Catch: JSONException -> L11
        r4.put("beforeAllInterceptors", r3.f);     // Catch: JSONException -> L11
        r4.put("requestStart", r3.g);     // Catch: JSONException -> L11
        r4.put("responseBack", r3.h);     // Catch: JSONException -> L11
        r4.put("completeReadResponse", r3.i);     // Catch: JSONException -> L11
        r4.put("requestEnd", r3.j);     // Catch: JSONException -> L11
        r4.put("recycleCount", r3.C);     // Catch: JSONException -> L11
        if (r3.G != 0) goto L6;
        r4.put("timing_dns", r3.n);     // Catch: JSONException -> L11
        r4.put("timing_connect", r3.o);     // Catch: JSONException -> L11
        r4.put("timing_ssl", r3.p);     // Catch: JSONException -> L11
        r4.put("timing_send", r3.q);     // Catch: JSONException -> L11
        r4.put("timing_waiting", r3.s);     // Catch: JSONException -> L11
        r4.put("timing_receive", r3.t);     // Catch: JSONException -> L11
        r4.put("timing_total", r3.u);     // Catch: JSONException -> L11
        r4.put("timing_isSocketReused", r3.D);     // Catch: JSONException -> L11
        r4.put("timing_totalSendBytes", r3.x);     // Catch: JSONException -> L11
        r4.put("timing_totalReceivedBytes", r3.y);     // Catch: JSONException -> L11
        r4.put("timing_remoteIP", r3.w);     // Catch: JSONException -> L11
        r4.put("request_log", r3.f2361J);     // Catch: JSONException -> L11
    L6:
        JSONObject r0 = r3.K;     // Catch: JSONException -> L11
        if (r0 == null) goto L9;
        r4.put("req_info", r0);     // Catch: JSONException -> L11
    L9:
        r4.put("streaming", r3.L);     // Catch: JSONException -> L11
        return;
    L11:
        e = move-exception;
        Logger.w("InitTTNetHelper", "[packageRequestParamters] json op error. ", e);
        return;
    }
}
