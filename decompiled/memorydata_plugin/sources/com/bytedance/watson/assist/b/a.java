package com.bytedance.watson.assist.b;

import android.content.Context;
import com.bytedance.watson.assist.a.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f3365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f3366b;
    private com.bytedance.watson.assist.b.b.a c;
    private com.bytedance.watson.assist.b.d.a d;
    private com.bytedance.watson.assist.b.c.b e;
    private com.bytedance.watson.assist.b.a.a f;
    private com.bytedance.watson.assist.a.a g;

    static {
    }

    private a(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), com.bytedance.watson.assist.a.a.f3357a);
    }

    private a(Context r3, com.bytedance.watson.assist.a.a r4) {
        this.f3366b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        com.bytedance.watson.assist.a.a r5 = com.bytedance.watson.assist.a.a.f3357a;
    L6:
        this.g = r5;
        this.c = new com.bytedance.watson.assist.b.b.a(this.f3366b, this);
        this.d = new com.bytedance.watson.assist.b.d.a(this.f3366b, this);
        this.e = new com.bytedance.watson.assist.b.c.b(this.f3366b, this);
        this.f = new com.bytedance.watson.assist.b.a.a(this);
        com.bytedance.watson.assist.d.b.b("new assist obj:" + this + " config : " + r4);
        return;
    L5:
        r5 = r4;
        goto L6
    }

    public static a a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (f3365a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f3365a != null) goto L9;
        f3365a = new a(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f3365a;
    }

    @Override // com.bytedance.watson.assist.a.c
    public com.bytedance.watson.assist.a.a a() {
        return this.g;
    }

    @Override // com.bytedance.watson.assist.a.c
    public boolean a(float r1) {
        return this.f.a(r1);
    }

    @Override // com.bytedance.watson.assist.a.c
    public c b() {
        com.bytedance.watson.assist.d.b.a("start, obj:" + this);
        this.c.a();
        this.d.a();
        this.e.a();
        return this;
    }

    @Override // com.bytedance.watson.assist.a.c
    public void c() {
        com.bytedance.watson.assist.d.b.a("end, obj:" + this);
        this.c.b();
        this.d.b();
        this.e.b();
    }

    @Override // com.bytedance.watson.assist.a.c
    public int d() {
        return this.c.d();
    }

    @Override // com.bytedance.watson.assist.a.c
    public int e() {
        return this.c.e();
    }

    @Override // com.bytedance.watson.assist.a.c
    public float f() {
        return this.c.f();
    }

    @Override // com.bytedance.watson.assist.a.c
    public void g() {
        this.e.d();
    }

    @Override // com.bytedance.watson.assist.a.c
    public c.b h() {
        return this.e.f();
    }

    @Override // com.bytedance.watson.assist.a.c
    public boolean i() {
        return this.f.a();
    }

    @Override // com.bytedance.watson.assist.a.c
    public c.a j() {
        c.a r0 = new c.a();
        r0.f3361a = k();
        r0.f3362b = m();
        r0.c = e();
        r0.d = n();
        r0.e = d();
        r0.f = f();
        r0.g = l();
        return r0;
    }

    public String k() {
        return com.bytedance.watson.assist.d.a.c();
    }

    public List<List<Integer>> l() {
        return this.e.e();
    }

    public boolean m() {
        return this.c.c();
    }

    public int n() {
        return this.d.c();
    }
}
