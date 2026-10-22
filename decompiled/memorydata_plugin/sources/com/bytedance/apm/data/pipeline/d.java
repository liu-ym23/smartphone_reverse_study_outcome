package com.bytedance.apm.data.pipeline;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.apm.util.k;
import com.bytedance.apm.util.n;
import com.bytedance.crash.service.INetworkCallback;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends com.bytedance.apm.data.a<com.bytedance.apm.data.a.a> {
    private static long q = 30000;
    private static boolean r = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1294b;
    private boolean c;
    private volatile int d;
    private volatile List<String> e;
    private List<Pattern> f;
    private List<String> g;
    private List<Pattern> h;
    private List<String> i;
    private List<String> j;
    private List<String> k;
    private boolean l;
    private boolean m;
    private double n;
    private boolean o;
    private c p;

    /* JADX INFO: renamed from: com.bytedance.apm.data.pipeline.d$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f1295a = null;

        static {
            f1295a = new d(null);
        }

        static /* synthetic */ d a() {
            return f1295a;
        }
    }

    static {
    }

    private d() {
        this.c = true;
        this.l = true;
        this.m = false;
    }

    /* synthetic */ d(AnonymousClass1 r1) {
        this();
    }

    public static void a(long r0) {
        q = r0;
    }

    private void a(List<String> r6, JSONObject r7, String r8) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L32;
        if (r7 == null) goto L33;
    L20:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        if (TextUtils.isEmpty(r8) == true) goto L34;
        String r9 = r7.optString(r8);     // Catch: JSONException -> L17 Exception -> L20
        if (TextUtils.isEmpty(r9) == true) goto L35;
        JSONObject r1 = new JSONObject(r9);     // Catch: JSONException -> L17 Exception -> L20
        JSONObject r10 = new JSONObject();     // Catch: JSONException -> L17 Exception -> L20
        Iterator<String> r2 = r1.keys();     // Catch: JSONException -> L17 Exception -> L20
    L11:
        if (r2.hasNext() == false) goto L15;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L17 Exception -> L20
        if (r5.contains(r3) == false) goto L11;
        r10.put(r3, r1.opt(r3));     // Catch: JSONException -> L17 Exception -> L20
        goto L11
    L15:
        r7.put(r8, r10.toString());     // Catch: JSONException -> L17 Exception -> L20
    L36:
        return;
    L35:
        return;
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L20
        return;
    L34:
        return;
    L33:
        return;
    }

    private void a(JSONObject r5, String r6) {
        if (r5 == null) goto L32;
    L27:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        if (TextUtils.equals(r6, "api_all") == false) goto L9;
        String r7 = "api_all_v2";
    L7:
        r5.put("net_log_type", r7);     // Catch: Exception -> L27
    L13:
        if (c() == false) goto L19;
        if (e() == false) goto L19;
        String r8 = "01";
    L17:
        r5.put("inject_tracelog", r8);     // Catch: Exception -> L27
    L23:
        double r0 = this.n;     // Catch: Exception -> L27
        if (r0 == 0.0d) goto L33;
        r5.put("enable_base_api_all", r0);     // Catch: Exception -> L27
        return;
    L33:
        return;
    L19:
        if (d() != 1) goto L23;
        if (e() == false) goto L23;
        r8 = "02";
        goto L17
    L9:
        if (TextUtils.equals(r6, "api_error") == false) goto L13;
        r7 = "api_error_v2";
        goto L7
    }

    public static void a(boolean r0) {
        r = r0;
    }

    private boolean a(String r2) {
        return n.a(r2, this.g, this.h);
    }

    private boolean a(String r4, String r5, JSONObject r6) {
        if (TextUtils.equals(r4, "api_all") == false) goto L12;
        if (c() == false) goto L8;
        b(r5, r6);
        return true;
    L8:
        if (b(r5) == true) goto L17;
        return b(r5, r6);
    L17:
        return false;
    L12:
        if (TextUtils.equals(r4, "api_error") == false) goto L17;
        if (this.d != 1) goto L17;
        return true;
    }

    private boolean a(String r4, JSONObject r5) {
        if (c(r4) == false) goto L5;
    L16:
        return false;
    L5:
        if (k.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L10;
        if (this.o == false) goto L16;
    L10:
        if (a(r5) == true) goto L12;
        return true;
    L12:
        if (this.m == true) goto L17;
        return false;
    L17:
        return true;
    }

    private boolean a(JSONObject r2) {
        if (r2 != null) goto L12;
        return false;
    L12:
        String r1 = r2.optString("cronet_internal_error_code");     // Catch: Exception -> L11
        if ("11".equals(r2.optString("cronet_error_code")) == false) goto L14;
        if ("-999".equals(r1) == false) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L16:
        return false;
    }

    public static d b() {
        return a.a();
    }

    private void b(JSONObject r3) {
        a(this.j, r3, "requestHeader");
        a(this.k, r3, "responseHeader");
    }

    private boolean b(String r2) {
        return n.a(r2, this.e, this.f);
    }

    private boolean b(String r5, JSONObject r6) {
        if (c() == false) goto L5;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == false) goto L13;
        int r7 = 1;
    L14:
        boolean r0 = com.bytedance.apm.j.c.b("smart_traffic");
        if (r0 == false) goto L24;
        r7 = r7 | 4;
    L24:
        r6.put("hit_rules", r7);     // Catch: JSONException -> L23
    L18:
        if (r4 == true) goto L26;
        if (r0 == false) goto L22;
        return true;
    L22:
        return false;
    L26:
        return true;
    L13:
        r7 = 0;
        goto L14
    L5:
        if (this.f1294b != 0) goto L10;
        if (a(r5) == true) goto L10;
        r4 = false;
        goto L11
    }

    private boolean c(String r1) {
        return n.a(r1, this.i);
    }

    private void d(com.bytedance.apm.data.a.a r8) {
        String r0 = r8.d;
        String r3 = r8.f1279a;
        boolean r1 = !r8.h.isNull("hit_rules");
        if (r1 == false) goto L5;
    L7:
        JSONObject r4 = r8.a();
        JsonUtils.a(r4, r8.h);
        if (r4 != null) goto L11;
        return;
    L11:
        if (r1 == false) goto L13;
    L16:
        boolean r6 = true;
    L18:
        if (this.l == false) goto L20;
        a(r4, r8.f1279a);
    L20:
        b(r4);
        if (this.p != null) goto L23;
    L27:
        a(r3, r3, r4, r6, true);
        return;
    L23:
        if ("api_all".equals(r3) == false) goto L27;
        if (r8.h.optBoolean("download", false) == true) goto L27;
        this.p.a(r0, r8.h);
        goto L27
    L13:
        if (a(r3, r0, r4) == true) goto L16;
        r6 = false;
        goto L18
    L5:
        if (a(r0, r8.h) == true) goto L7;
    }

    public static boolean f() {
        if (r == true) goto L6;
        return false;
    L6:
        if (com.bytedance.apm.b.w() != 0) goto L9;
        return false;
    L9:
        if ((System.currentTimeMillis() - com.bytedance.apm.b.w()) <= q) goto L11;
        return false;
    L11:
        return true;
    }

    public void a(c r3) {
        this.p = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
    }

    public boolean a(com.bytedance.apm.data.a.a r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (TextUtils.isEmpty(r1.d) == true) goto L6;
        return true;
    }

    public void b(com.bytedance.apm.data.a.a r1) {
        if (a() == true) goto L5;
        boolean r0 = true;
    L6:
        r1.a(r0);     // Catch: JSONException -> L11
        if (f() == false) goto L9;
        r1.e();     // Catch: JSONException -> L11
    L9:
        r1.a(INetworkCallback.TYPE_TTNET);     // Catch: JSONException -> L11
        return;
    L5:
        r0 = false;
    }

    @Override // com.bytedance.apm.data.a
    public /* synthetic */ boolean b(com.bytedance.apm.data.b r3) {
        return a((com.bytedance.apm.data.a.a) ZeusTransformUtils.preCheckCast((com.bytedance.apm.data.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.apm.data.b.class, "com.obric.memorydata.plugin"), com.bytedance.apm.data.a.a.class, "com.obric.memorydata.plugin"));
    }

    public void c(com.bytedance.apm.data.a.a r1) {
        d(r1);
    }

    @Override // com.bytedance.apm.data.a
    public /* synthetic */ void c(com.bytedance.apm.data.b r3) {
        b((com.bytedance.apm.data.a.a) ZeusTransformUtils.preCheckCast((com.bytedance.apm.data.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.apm.data.b.class, "com.obric.memorydata.plugin"), com.bytedance.apm.data.a.a.class, "com.obric.memorydata.plugin"));
    }

    public boolean c() {
        if (this.l == true) goto L5;
    L7:
        return false;
    L5:
        if (this.n == 0.0d) goto L7;
        return true;
    }

    public int d() {
        return this.f1294b;
    }

    @Override // com.bytedance.apm.data.a
    public /* synthetic */ void d(com.bytedance.apm.data.b r3) {
        c((com.bytedance.apm.data.a.a) ZeusTransformUtils.preCheckCast((com.bytedance.apm.data.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.apm.data.b.class, "com.obric.memorydata.plugin"), com.bytedance.apm.data.a.a.class, "com.obric.memorydata.plugin"));
    }

    public boolean e() {
        return this.c;
    }

    @Override // com.bytedance.apm.data.a, com.bytedance.services.slardar.config.a
    public void onRefresh(JSONObject r4, boolean r5) {
        JSONObject r6 = n.a(r4, "network_image_modules");
        if (r6 == null) goto L14;
        JSONObject r7 = n.a(r6, "network");
        if (r7 == null) goto L10;
        this.e = n.b(r7, "api_block_list");
        this.f = n.d(r7, "api_block_list");
        this.g = n.c(r7, "api_allow_list");
        this.h = n.e(r7, "api_allow_list");
        boolean r1 = false;
        this.f1294b = r7.optInt("enable_api_all_upload", 0);
        this.c = r7.optBoolean("enable_trace_log", true);
        this.d = r7.optInt("enable_api_error_upload", 1);
        if (r7.optInt("enable_cancel_error_report") != 1) goto L9;
        r1 = true;
    L9:
        this.m = r1;
        this.j = n.c(r7, "request_allow_header");
        this.k = n.c(r7, "response_allow_header");
        this.n = r7.optDouble("enable_base_api_all", 0.0d);
    L10:
        JSONObject r8 = n.a(r6, "image");
        if (r8 == null) goto L15;
        this.i = n.c(r8, "image_allow_list");
        return;
    L15:
        return;
    }
}
