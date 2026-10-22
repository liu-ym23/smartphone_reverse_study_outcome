package com.bytedance.sdk.account.c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.sdk.account.a.a.b;
import com.bytedance.sdk.account.utils.NetworkUtils;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f<R extends com.bytedance.sdk.account.a.a.b> implements com.bytedance.sdk.account.a.c.a, com.bytedance.sdk.account.a.c.c {
    private static com.bytedance.sdk.account.a.c.b h;
    private static g i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f3113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected com.bytedance.sdk.account.b.a f3114b;
    protected com.bytedance.sdk.account.a.a.a c;
    private String d;
    private com.bytedance.sdk.account.b.b e;
    private com.bytedance.sdk.account.a.c.d f;
    private boolean g;

    private static class a extends com.bytedance.sdk.account.utils.a implements com.bytedance.sdk.account.a.c.d {
        private com.bytedance.sdk.account.a.c.c d;

        private a(com.bytedance.sdk.account.a.c.c r3) {
            this.d = (com.bytedance.sdk.account.a.c.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.sdk.account.a.c.c.class, "com.obric.memorydata.plugin");
        }

        /* synthetic */ a(com.bytedance.sdk.account.a.c.c r2, AnonymousClass1 r3) {
            this((com.bytedance.sdk.account.a.c.c) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.sdk.account.a.c.c.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.bytedance.sdk.account.network.dispatcher.c, java.lang.Runnable
        public void run() {
            this.d.b();
        }
    }

    static {
        h = new AnonymousClass2();
        i = new AnonymousClass3();
    }

    public f(Context r3, com.bytedance.sdk.account.b.a r4, com.bytedance.sdk.account.a.a.a r5) {
        this.f3113a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.d = r4.f3099a;
        this.f3114b = r4;
        this.c = r5;
        if (r5 == null) goto L5;
        r5.a(this);
    L5:
        this.e = new com.bytedance.sdk.account.b.b(r4);
    }

    private final com.ss.android.g a(String r6, Map<String, String> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        com.bytedance.sdk.account.utils.e r0 = new com.bytedance.sdk.account.utils.e(r6);
        if (r8 == null) goto L12;
        Iterator r9 = r8.entrySet().iterator();
    L6:
        if (r9.hasNext() == false) goto L12;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r2.getKey(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L6;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r2.getValue(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L6;
        r0.a((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin"));
    L12:
        ArrayList r10 = new ArrayList();
        if (com.ss.android.account.d.a().d() == false) goto L15;
        r0.a("multi_login", "1");
        a(r10);
    L15:
        a(r6, r10);
        r0.a("account_sdk_source", "app");
        r0.a("passport-sdk-version", 18);
        String r11 = r0.toString();
        this.e.d = r11;
        return NetworkUtils.a(Integer.MAX_VALUE, r11, r10);
    }

    private final com.ss.android.g a(String r9, Map<String, String> r10, String r11, String r12) {
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        HashMap r4 = new HashMap();
        com.bytedance.sdk.account.utils.e r0 = new com.bytedance.sdk.account.utils.e(r9);
        if (r13 == null) goto L12;
        Iterator r14 = r13.entrySet().iterator();
    L6:
        if (r14.hasNext() == false) goto L12;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r2.getKey(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L6;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r2.getValue(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L6;
        r4.put(r2.getKey(), r2.getValue());
    L12:
        r4.put("account_sdk_source", "app");
        ArrayList r7 = new ArrayList();
        if (com.ss.android.account.d.a().d() == false) goto L15;
        r4.put("multi_login", "1");
        a(r7);
    L15:
        a(r9, r7);
        r0.a("passport-sdk-version", 18);
        String r3 = r0.toString();
        this.e.d = r3;
        return NetworkUtils.a(Integer.MAX_VALUE, r3, r4, r11, r12, r7);
    }

    private JSONObject a(JSONObject r4) {
        JSONObject r3 = null;
        if (r4 != null) goto L5;
    L23:
        return r3;
    L5:
        if (r4.has("data") == false) goto L23;
        Object r5 = r4.opt("data");     // Catch: Exception -> L21
        if (r5 != null) goto L12;
        return null;
    L12:
        if (ZeusTransformUtils.instanceOf(r5, JSONObject.class) == false) goto L15;
        r3 = (JSONObject) ZeusTransformUtils.preCheckCast(r5, JSONObject.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L21
    L24:
        goto L23
    L15:
        if (ZeusTransformUtils.instanceOf(r5, JSONArray.class) == false) goto L24;
        JSONArray r6 = (JSONArray) ZeusTransformUtils.preCheckCast(r5, JSONArray.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L21
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L21
        r1.put("data", r6);     // Catch: Exception -> L19
        r3 = r1;
    L19:
        e = e;
        r3 = r1;
    L22:
        e.printStackTrace();
    L21:
        e = e;
        goto L22
    }

    private static void a(h r1) {
        i.a(r1);
    }

    private void a(com.ss.android.g r4) {
        if (r4 == null) goto L31;
        List<com.ss.android.f> r5 = r4.a();     // Catch: Exception -> L19
        if (r5 == null) goto L32;
        Iterator<com.ss.android.f> r6 = r5.iterator();     // Catch: Exception -> L19
    L6:
        if (r6.hasNext() == false) goto L33;
        com.ss.android.f r0 = (com.ss.android.f) ZeusTransformUtils.preCheckCast(r6.next(), com.ss.android.f.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L19
        if ("x-tt-multi-sids".equalsIgnoreCase(r0.a()) == false) goto L14;
        String r1 = r0.b();     // Catch: Exception -> L19
        if (TextUtils.isEmpty(r1) == true) goto L14;
        a(r1);     // Catch: Exception -> L19
    L14:
        if ("x-tt-logid".equalsIgnoreCase(r0.a()) == false) goto L6;
        String r2 = r0.b();     // Catch: Exception -> L19
        if (TextUtils.isEmpty(r2) == true) goto L6;
        this.e.f = r2;     // Catch: Exception -> L19
        goto L6
    L33:
        return;
    L32:
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    private void a(String r1) {
        Context r0 = this.f3113a;
        if (r0 == null) goto L6;
        e.a(r0).a(r1);
        return;
    }

    private void a(String r3, JSONObject r4, JSONObject r5) {
        if ("error".equals(r3) == false) goto L5;
    L6:
        if (r5 == null) goto L16;
        String r6 = "error_code";
        if (r5.has("error_code") == false) goto L10;
    L9:
        com.bytedance.sdk.account.b.b r0 = this.e;
        r0.f3104b = r5.optInt(r6, r0.f3104b);
    L13:
        com.bytedance.sdk.account.b.b r7 = this.e;
        r7.c = r5.optString("description");
        com.bytedance.sdk.account.b.b r8 = this.e;
        r8.e = r8.c;
        a(r5, r4);
        return;
    L10:
        r6 = "code";
        if (r5.has("code") == false) goto L13;
    L16:
        return;
    L5:
        if (CommonConsts.LOG_REPORT_TYPE_EXCEPTION.equals(r3) == true) goto L6;
    }

    private boolean a(JSONObject r2, JSONObject r3, String r4) {
        if ("success".equals(r4) == true) goto L6;
        a(r4, r2, r3);
        return false;
    L6:
        if (r3 == null) goto L10;
        b(r2, r3);
        return true;
    L10:
        return true;
    }

    private final com.ss.android.g b(String r7, Map<String, String> r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        HashMap r0 = new HashMap();
        com.bytedance.sdk.account.utils.e r2 = new com.bytedance.sdk.account.utils.e(r7);
        if (r9 == null) goto L12;
        Iterator r10 = r9.entrySet().iterator();
    L6:
        if (r10.hasNext() == false) goto L12;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r3.getKey(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L6;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r3.getValue(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L6;
        r0.put(r3.getKey(), r3.getValue());
    L12:
        r0.put("account_sdk_source", "app");
        ArrayList r11 = new ArrayList();
        if (com.ss.android.account.d.a().d() == false) goto L15;
        r0.put("multi_login", "1");
        a(r11);
    L15:
        a(r7, r11);
        r2.a("passport-sdk-version", 18);
        String r12 = r2.toString();
        this.e.d = r12;
        return NetworkUtils.a(Integer.MAX_VALUE, r12, r0, r11);
    }

    private void b(R r2) {
        a(new h(this.c, r2));
    }

    private void c(com.bytedance.sdk.account.a.a.b r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (this.e.f3104b >= 0) goto L11;
        r4.d = -1005;
        r4.e = this.e.f3104b;
        if (ZeusTransformUtils.instanceOf(r4, com.bytedance.sdk.account.a.a.d.class) == false) goto L18;
        T r1 = ((com.bytedance.sdk.account.a.a.d) ZeusTransformUtils.preCheckCast(r4, com.bytedance.sdk.account.a.a.d.class, "com.obric.memorydata.plugin")).j;
        if (r1 == 0) goto L18;
        r1.f3119a = -1005;
        r1.f3120b = this.e.f3104b;
    L18:
        if (this.e.f3104b != 0) goto L20;
        return;
    L20:
        if (TextUtils.isEmpty(r4.g) == true) goto L22;
        return;
    L22:
        if (this.e.e == null) goto L24;
        String r3 = this.e.e;
    L25:
        r4.g = r3;
        return;
    L24:
        r3 = "";
        goto L25
    L11:
        if (this.e.f3104b <= 0) goto L18;
        r4.e = this.e.f3104b;
        if (ZeusTransformUtils.instanceOf(r4, com.bytedance.sdk.account.a.a.d.class) == false) goto L18;
        T r0 = ((com.bytedance.sdk.account.a.a.d) ZeusTransformUtils.preCheckCast(r4, com.bytedance.sdk.account.a.a.d.class, "com.obric.memorydata.plugin")).j;
        if (r0 == 0) goto L18;
        r0.f3120b = this.e.f3104b;
        goto L18
    }

    private void e() {
        final com.bytedance.sdk.account.a.a.b r0 = d();
        if (r0 == null) goto L20;
        com.bytedance.sdk.account.b.b r1 = this.e;
        if (r1 == null) goto L8;
        r0.c = r1.d;
        r0.f3095a = this.e.f;
    L8:
        if (TextUtils.isEmpty(r0.c) == false) goto L10;
        r0.c = this.d;
    L10:
        a(r0);
        com.ss.android.account.a.a r2 = com.ss.android.account.c.a().b();
        if (this.e.f3104b != 1104) goto L13;
    L14:
        if (r2 != null) goto L16;
    L18:
        b(r0);
        return;
    L16:
        if (r2.a() == true) goto L18;
        r2.a(this.e.f3104b, new AnonymousClass1(this, r0));
        return;
    L13:
        if (this.e.f3104b != 1105) goto L18;
    }

    private boolean f() {
        Context r0 = this.f3113a;
        if (r0 != null) goto L8;
        this.e.f3104b = -24;
        com.bytedance.sdk.account.b.b r6 = this.e;
        String r1 = "context_is_null";
    L5:
        r6.e = r1;
        return false;
    L8:
        if (NetworkUtils.b(r0) != NetworkUtils.NetworkType.NONE) goto L10;
        this.e.f3104b = -12;
        r6 = this.e;
        r1 = "no net work";
        goto L5
    L10:
        com.ss.android.g r2 = null;
        if ("get".equals(this.f3114b.f3100b) == false) goto L14;
        r2 = a(this.d, this.f3114b.c);
    L19:
        a(r2);
        if (r2 != null) goto L22;
    L32:
        this.e.f3104b = -25;
        r6 = this.e;
        r1 = "response null";
        goto L5
    L22:
        if (com.bytedance.common.utility.h.a(r2.b()) == true) goto L32;
        JSONObject r3 = new JSONObject(r2.b());
        JSONObject r4 = a(r3);
        String r5 = r3.optString("message");
        if (TextUtils.isEmpty(r5) == false) goto L27;
        if (r4 != null) goto L30;
        return false;
    L30:
        return a(r4, a(r4), r4.optString("message"));
    L27:
        return a(r3, r4, r5);
    L14:
        if (CozeCloudExt.API_KEY_HTTP_POST_METHOD.equals(this.f3114b.f3100b) == false) goto L17;
        r2 = b(this.d, this.f3114b.c);
        goto L19
    L17:
        if ("post_file".equals(this.f3114b.f3100b) == false) goto L19;
        r2 = a(this.d, this.f3114b.c, this.f3114b.d, this.f3114b.e);
        goto L19
    }

    @Override // com.bytedance.sdk.account.a.c.a
    public void a() {
        this.c = null;
    }

    public abstract void a(R r1);

    public void a(String r2, List<com.ss.android.f> r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        String r4 = com.bytedance.sdk.account.utils.f.a(r2, "passport_csrf_token");     // Catch: Exception -> L7
        if (TextUtils.isEmpty(r4) == true) goto L12;
        r1.add(new com.ss.android.f("x-tt-passport-csrf-token", r4));     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public void a(List<com.ss.android.f> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        String r0 = null;
        Context r2 = this.f3113a;     // Catch: Exception -> L10
        if (r2 == null) goto L7;
        r0 = e.a(r2).b();     // Catch: Exception -> L10
    L7:
        if (TextUtils.isEmpty(r0) == true) goto L15;
        r4.add(new com.ss.android.f("x-tt-multi-sids", r0));     // Catch: Exception -> L10
        return;
    L15:
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    public abstract void a(JSONObject r1, JSONObject r2);

    public abstract R b(boolean r1, com.bytedance.sdk.account.b.b r2);

    @Override // com.bytedance.sdk.account.a.c.c
    public void b() {
        e();
    }

    public abstract void b(JSONObject r1, JSONObject r2);

    public final void c() {
        this.f = h.a(this);
    }

    public R d() {
        this.g = false;
        this.g = f();     // Catch: Throwable -> L5
    L7:
        R r0 = (R) b(this.g, this.e);
        c(r0);
        return r0;
    L5:
        th = move-exception;
        th.printStackTrace();
        com.bytedance.sdk.account.b.b r1 = this.e;
        r1.f3104b = com.bytedance.sdk.account.utils.d.a(this.f3113a, th);
        com.bytedance.sdk.account.f.a.a(this.f3114b.f3099a, th, this.e.f3104b);
        com.bytedance.sdk.account.b.b r2 = this.e;
        r2.e = th.getMessage();
        goto L7
    }
}
