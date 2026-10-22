package com.obric.oui.orecyclerview.widget;

import com.obric.oui.orecyclerview.widget.RecyclerView.v;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class q<T, VH extends RecyclerView.v> extends RecyclerView.Adapter<VH> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.a<T> f14227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final d<T> f14228b;

    public q(i.e<T> r5) {
        d.a<T> r0 = new AnonymousClass1(this);
        this.f14227a = r0;
        d<T> r1 = new d(new b(this), new c.a(r5).a());
        this.f14228b = r1;
        r1.a(r0);
    }

    public List<T> a() {
        return this.f14228b.a();
    }

    public void a(List<T> r3, Runnable r4) {
        List<T> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        this.f14228b.a(r5, r6);
    }

    public void a(List<T> r2, List<T> r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public T b(int r1) {
        return this.f14228b.a().get(r1);
    }

    public void b(List<T> r3) {
        List<T> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.f14228b.a(r4);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int d() {
        return this.f14228b.a().size();
    }
}
