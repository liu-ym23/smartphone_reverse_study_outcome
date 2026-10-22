package com.ss.android.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class e implements WeakHandler.IHandler {
    private static e c;
    private static volatile boolean m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.bytedance.sdk.account.a.e f15726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected com.bytedance.sdk.account.a.d f15727b;
    private volatile boolean d;
    private volatile boolean e;
    private volatile String f;
    private a g;
    private Context h;
    private Handler i;
    private volatile int j;
    private com.bytedance.sdk.account.a.b.b k;
    private volatile boolean l;
    private volatile boolean n;
    private volatile boolean o;
    private volatile boolean p;
    private volatile JSONObject q;
    private AuthTokenMultiProcessSharedProvider.b r;

    static /* synthetic */ a a(e r0) {
        return r0.g;
    }

    public static e a() {
        return c;
    }

    public static String a(Object r3) {
        String r4 = r3.toString();
        if (TextUtils.isEmpty(r4) == false) goto L7;
        return "";
    L7:
        if (r4.length() > 10) goto L9;
        return r4;
    L9:
        return r4.substring(0, 9) + "***" + r4.substring(r4.length() - 5);
    }

    static /* synthetic */ JSONObject a(e r0, JSONObject r1) {
        r0.q = r1;
        return r1;
    }

    private void a(com.bytedance.sdk.account.a.a.a<com.bytedance.sdk.account.a.a.c> r3) {
        com.bytedance.sdk.account.a.e r2 = this.f15726a;
        if (r2 == null) goto L6;
        r2.a("sdk_expired_logout", null, r3);
        return;
    }

    private void a(String r1, com.bytedance.sdk.account.a.b.b r2) {
        com.bytedance.sdk.account.d.b.a(this.h, r1, r2).c();
    }

    static /* synthetic */ boolean a(e r0, boolean r1) {
        r0.d = r1;
        return r1;
    }

    static /* synthetic */ Handler b(e r0) {
        return r0.i;
    }

    private void b(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        if (c() == false) goto L9;
        Toast.makeText(this.h, r2, 1).show();
        return;
    }

    static /* synthetic */ boolean b(e r0, boolean r1) {
        r0.l = r1;
        return r1;
    }

    private boolean c() {
        a.InterfaceC0837a r0 = this.g.c();
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.a();
    }

    static /* synthetic */ boolean c(e r0) {
        return r0.l;
    }

    static /* synthetic */ boolean c(e r0, boolean r1) {
        r0.o = r1;
        return r1;
    }

    static /* synthetic */ AuthTokenMultiProcessSharedProvider.b d(e r0) {
        return r0.r;
    }

    private void d() {
        if (m == true) goto L5;
        return;
    L5:
        StringBuilder r0 = new StringBuilder();
        boolean r1 = c();
        com.bytedance.sdk.account.a.d r2 = this.f15727b;
        if (r2 == null) goto L19;
        if (r2.a() == false) goto L19;
        if (this.n == true) goto L16;
        String r3 = this.h.getString(ZeusTransformUtils.mapRes(R.string.invoke_api_error, TypedValues.Custom.S_STRING, "invoke_api_error"));
        if (r1 == true) goto L14;
        d.a("token_beat_not_poll", r3, null);
    L14:
        r0.append(r3);
        goto L19
    L16:
        if (this.o == false) goto L19;
        com.bytedance.sdk.account.b.a().b(true, null, null);
    L19:
        if (this.o == true) goto L25;
        String r4 = this.h.getString(ZeusTransformUtils.mapRes(R.string.config_api_error, TypedValues.Custom.S_STRING, "config_api_error"));
        if (r1 == true) goto L23;
        d.a("token_beat_not_config", r4, this.q);
    L23:
        r0.append(r4);
        com.bytedance.sdk.account.b.a().b(false, "token beat request error", null);
    L25:
        if (this.p == true) goto L30;
        String r5 = this.h.getString(ZeusTransformUtils.mapRes(R.string.sdk_version_params_error, TypedValues.Custom.S_STRING, "sdk_version_params_error"));
        if (r1 == true) goto L29;
        d.a("sdk-version-not-add", r5, null);
    L29:
        r0.append(r5);
        com.bytedance.sdk.account.b.a().a(false, r5, null);
    L31:
        b(r0.toString());
        return;
    L30:
        com.bytedance.sdk.account.b.a().a(true, null, null);
        goto L31
    }

    static /* synthetic */ JSONObject e(e r0) {
        return r0.q;
    }

    public void a(String r2) {
        this.f = r2;
        com.ss.android.c.a("TokenFactory", "setToken token " + a(r2) + "    " + Log.getStackTraceString(new Exception()));
    }

    void a(String r3, List<b> r4, boolean r5, boolean r6, com.bytedance.sdk.account.a.a.a<com.bytedance.sdk.account.a.a.c> r7) {
        d.a(r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), r6);
        if (m == true) goto L5;
        return;
    L5:
        com.bytedance.sdk.account.a.d r8 = this.f15727b;
        if (r8 != null) goto L8;
        return;
    L8:
        if (r8.a() == false) goto L15;
        b();
        com.bytedance.sdk.account.a.d r9 = this.f15727b;
        if (r9 == null) goto L12;
        r9.a(r5);
    L12:
        a(r7);
        return;
    }

    void a(Collection<String> r3) {
        Collection<String> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        a r2 = this.g;
        if (r2 == null) goto L6;
        r2.a(r4);
        return;
    }

    public void a(boolean r5, boolean r6) {
        if (m == true) goto L6;
        return;
    L6:
        if (this.d == true) goto L21;
        this.d = true;
        this.n = true;
        if (NetworkUtils.b(this.h) == true) goto L12;
        this.j++;
        this.i.sendEmptyMessageDelayed(1000, Math.min(((long) this.j) * 10000, this.g.b()));
    L10:
        this.d = false;
        return;
    L12:
        com.bytedance.sdk.account.a.d r0 = this.f15727b;
        if (r0 != null) goto L15;
    L20:
        this.i.sendEmptyMessageDelayed(1000, this.g.b());
        goto L10
    L15:
        if (r0.a() == false) goto L20;
        this.j = 0;
        final String r7 = b(r5, r6);
        if (TextUtils.isEmpty(r7) == true) goto L22;
        com.bytedance.sdk.account.a.b.b r8 = new AnonymousClass1(this, r7);
        this.k = r8;
        a(r7, r8);
        return;
    L22:
        return;
    }

    String b(boolean r3, boolean r4) {
        com.bytedance.sdk.account.utils.e r0 = new com.bytedance.sdk.account.utils.e(this.g.a() + "/passport/token/beat/v2/");
        if (r3 == false) goto L5;
        String r5 = "boot";
    L6:
        if (r4 == false) goto L8;
        r5 = "wap_login";
    L8:
        r0.a(MemoryInfoSectionEditActivity.KIND_SCENE, r5);
        if (this.l == false) goto L11;
        String r2 = "true";
    L12:
        r0.a("first_beat", r2);
        return r0.toString();
    L11:
        r2 = "false";
        goto L12
    L5:
        r5 = "polling";
        goto L6
    }

    void b() {
        a("");
        this.e = false;
        AuthTokenMultiProcessSharedProvider.b r2 = this.r;
        if (r2 == null) goto L6;
        r2.a().a("X-Tt-Token", "").a();
        return;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r3) {
        if (r3.what != 1000) goto L6;
        this.i.removeMessages(1000);
        a(false, false);
        return;
    L6:
        if (r3.what != 2000) goto L10;
        d();
        return;
    }
}
