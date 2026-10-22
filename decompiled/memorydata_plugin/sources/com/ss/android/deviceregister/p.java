package com.ss.android.deviceregister;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.ss.android.deviceregister.a.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class p implements k {
    private static final Object c = null;
    private static String d = null;
    private static volatile boolean f = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.ss.android.deviceregister.b.d f15223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f15224b;
    private boolean e;

    static {
        c = new Object();
    }

    public p() {
        this.e = false;
    }

    @Override // com.ss.android.deviceregister.k
    public String a() {
        com.ss.android.deviceregister.b.d r2 = this.f15223a;
        if (r2 == null) goto L5;
        String r3 = r2.g();
    L7:
        if (Logger.debug() == false) goto L9;
        Logger.d("OldImpl", "getDeviceId() called,return value : " + r3);
    L9:
        return r3;
    L5:
        r3 = "";
        goto L7
    }

    @Override // com.ss.android.deviceregister.k
    public String a(Context r2) {
        return u.c((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.deviceregister.k
    public void a(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (this.f15223a == null) goto L5;
        Object r2 = g.a(r5);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, d.class) == false) goto L9;
        ((d) ZeusTransformUtils.preCheckCast(r2, d.class, "com.obric.memorydata.plugin")).a(r5, r4);
    L9:
        com.ss.android.deviceregister.a.b.a(r5).edit().remove("device_token").commit();
        return;
    L5:
        r2 = new d(r5, f.i());
        goto L7
    }

    @Override // com.ss.android.deviceregister.k
    public void a(Context r1, boolean r2, boolean r3, boolean r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        o.a(r5);
        com.ss.android.deviceregister.a.f.a(r5);
        this.f15223a = new com.ss.android.deviceregister.b.d(r5, r3);
        com.ss.android.deviceregister.b.a.a(this.f15224b);
        u.a(this.f15223a);
    }

    @Override // com.ss.android.deviceregister.k
    public void a(Bundle r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.size() <= 0) goto L9;
        com.ss.android.deviceregister.b.e.a(r1);
        return;
    }

    @Override // com.ss.android.deviceregister.k
    public void a(com.ss.android.deviceregister.a.i r2) {
        com.ss.android.deviceregister.b.e.a((com.ss.android.deviceregister.a.i) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.deviceregister.a.i.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.deviceregister.k
    public void a(f.a r2) {
        com.ss.android.deviceregister.b.e.a((f.a) ZeusTransformUtils.wrapperContextForParams(r2, f.a.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.deviceregister.k
    public void a(String r1) {
        u.a(r1);
    }

    @Override // com.ss.android.deviceregister.k
    public void a(Map<String, String> r8, Context r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L21;
        if (this.f15223a == null) goto L21;
        String r12 = h();
        if (r12 == null) goto L10;
        r10.put("openudid", r12);
    L10:
        String r13 = i();
        if (r13 == null) goto L13;
        r10.put("clientudid", r13);
    L13:
        String r14 = g();
        if (r14 == null) goto L16;
        r10.put("install_id", r14);
    L16:
        String r7 = a();
        if (r7 == null) goto L33;
        r10.put("device_id", r7);
        return;
    L33:
        return;
    L21:
        if (this.f15223a != null) goto L34;
        if (r11 == null) goto L35;
        SharedPreferences r15 = r11.getSharedPreferences(com.ss.android.deviceregister.a.b.a(), 0);
        String r5 = r15.getString("device_id", "");
        if (TextUtils.isEmpty(r5) == true) goto L26;
        r10.put("device_id", r5);
    L26:
        String r16 = r15.getString("install_id", "");
        if (TextUtils.isEmpty(r16) == true) goto L29;
        r10.put("install_id", r16);
    L29:
        String r17 = r11.getSharedPreferences(com.ss.android.deviceregister.a.b.c(), 0).getString("openudid", null);
        if (TextUtils.isEmpty(r17) == true) goto L36;
        r10.put("openudid", r17);
        return;
    L36:
        return;
    L35:
        return;
    }

    @Override // com.ss.android.deviceregister.k
    public void a(boolean r1) {
        this.f15224b = r1;
    }

    @Override // com.ss.android.deviceregister.k
    public void a(boolean r3, long r4, q r6) {
        q r7 = (q) ZeusTransformUtils.wrapperContextForParams(r6, q.class, "com.obric.memorydata.plugin");
        f = r3;
        com.ss.android.deviceregister.b.d r2 = this.f15223a;
        if (r2 != null) goto L5;
        return;
    L5:
        r2.a(r3, r4, r7);
    }

    @Override // com.ss.android.deviceregister.k
    public boolean a(Context r2, JSONObject r3, boolean r4) {
        return u.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4);
    }

    @Override // com.ss.android.deviceregister.k
    public String b() {
        if (TextUtils.isEmpty(d) == false) goto L15;
        Object r1 = c;
        monitor-enter(r1);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (TextUtils.isEmpty(d) == false) goto L9;
        d = UUID.randomUUID().toString();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L11
    L15:
        return d;
    }

    @Override // com.ss.android.deviceregister.k
    public void b(Context r2, String r3) {
        u.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3);
    }

    @Override // com.ss.android.deviceregister.k
    public void b(boolean r1) {
        com.ss.android.deviceregister.a.b.a(r1);
    }

    @Override // com.ss.android.deviceregister.k
    public boolean b(Context r2) {
        return g.b((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.deviceregister.k
    public void c() {
        com.ss.android.deviceregister.b.d r1 = this.f15223a;
        if (r1 == null) goto L8;
        r1.f();
        if (Logger.debug() == false) goto L9;
        Logger.d("OldImpl", "updateDeviceInfo call  device_register");
        return;
    L9:
        return;
    }

    @Override // com.ss.android.deviceregister.k
    public void c(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.f15223a.e();
        com.ss.android.deviceregister.b.c.b(r4);
    }

    @Override // com.ss.android.deviceregister.k
    public void c(boolean r1) {
        u.a(r1);
    }

    @Override // com.ss.android.deviceregister.k
    public void d(boolean r1) {
        f = r1;
    }

    @Override // com.ss.android.deviceregister.k
    public boolean d() {
        return this.e;
    }

    @Override // com.ss.android.deviceregister.k
    public int e() {
        return u.b();
    }

    @Override // com.ss.android.deviceregister.k
    public boolean e(boolean r2) {
        f = r2;
        com.ss.android.deviceregister.b.d r1 = this.f15223a;
        if (r1 != null) goto L6;
        return false;
    L6:
        d = null;
        r1.a(r2);
        return true;
    }

    @Override // com.ss.android.deviceregister.k
    public boolean f() {
        return f;
    }

    public String g() {
        com.ss.android.deviceregister.b.d r2 = this.f15223a;
        if (r2 == null) goto L7;
        String r3 = r2.h();
        if (Logger.debug() == false) goto L9;
        Logger.d("OldImpl", "getInstallId() called,return value : " + r3);
        return r3;
    L9:
        return r3;
    L7:
        return "";
    }

    public String h() {
        com.ss.android.deviceregister.b.d r2 = this.f15223a;
        if (r2 == null) goto L5;
        String r3 = r2.i();
    L7:
        if (Logger.debug() == false) goto L9;
        Logger.d("OldImpl", "getOpenUdId() called,return value : " + r3);
    L9:
        return r3;
    L5:
        r3 = "";
        goto L7
    }

    public String i() {
        com.ss.android.deviceregister.b.d r2 = this.f15223a;
        if (r2 == null) goto L5;
        String r3 = r2.k();
    L7:
        if (Logger.debug() == false) goto L9;
        Logger.d("OldImpl", "getClientUDID() called,return value : " + r3);
    L9:
        return r3;
    L5:
        r3 = "";
        goto L7
    }
}
