package com.bumptech.glide.manager;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final b.a f914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f915b;

    d(Context r3, b.a r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        b.a r6 = (b.a) ZeusTransformUtils.wrapperContextForParams(r4, b.a.class, "com.obric.memorydata.plugin");
        this.f915b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.f914a = r6;
    }

    private void a() {
        q.a(this.f915b).a(this.f914a);
    }

    private void b() {
        q.a(this.f915b).b(this.f914a);
    }

    @Override // com.bumptech.glide.manager.k
    public void e() {
        a();
    }

    @Override // com.bumptech.glide.manager.k
    public void f() {
        b();
    }

    @Override // com.bumptech.glide.manager.k
    public void g() {
    }
}
