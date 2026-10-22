package com.bumptech.glide.manager;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class r implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<com.bumptech.glide.request.a.e<?>> f950a;

    public r() {
        this.f950a = Collections.newSetFromMap(new WeakHashMap());
    }

    public List<com.bumptech.glide.request.a.e<?>> a() {
        return com.bumptech.glide.util.k.a(this.f950a);
    }

    public void a(com.bumptech.glide.request.a.e<?> r3) {
        com.bumptech.glide.request.a.e<?> r4 = (com.bumptech.glide.request.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.a.e.class, "com.obric.memorydata.plugin");
        this.f950a.add(r4);
    }

    public void b() {
        this.f950a.clear();
    }

    public void b(com.bumptech.glide.request.a.e<?> r3) {
        com.bumptech.glide.request.a.e r4 = (com.bumptech.glide.request.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.a.e.class, "com.obric.memorydata.plugin");
        this.f950a.remove(r4);
    }

    @Override // com.bumptech.glide.manager.k
    public void e() {
        Iterator r3 = com.bumptech.glide.util.k.a(this.f950a).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((com.bumptech.glide.request.a.e) ZeusTransformUtils.preCheckCast(r3.next(), com.bumptech.glide.request.a.e.class, "com.obric.memorydata.plugin")).e();
        goto L4
    }

    @Override // com.bumptech.glide.manager.k
    public void f() {
        Iterator r3 = com.bumptech.glide.util.k.a(this.f950a).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((com.bumptech.glide.request.a.e) ZeusTransformUtils.preCheckCast(r3.next(), com.bumptech.glide.request.a.e.class, "com.obric.memorydata.plugin")).f();
        goto L4
    }

    @Override // com.bumptech.glide.manager.k
    public void g() {
        Iterator r3 = com.bumptech.glide.util.k.a(this.f950a).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((com.bumptech.glide.request.a.e) ZeusTransformUtils.preCheckCast(r3.next(), com.bumptech.glide.request.a.e.class, "com.obric.memorydata.plugin")).g();
        goto L4
    }
}
