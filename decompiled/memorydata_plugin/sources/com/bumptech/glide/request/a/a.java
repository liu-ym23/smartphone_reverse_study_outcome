package com.bumptech.glide.request.a;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.util.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T> implements e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f956b;
    private com.bumptech.glide.request.d c;

    public a() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public a(int r3, int r4) {
        if (k.a(r3, r4) == false) goto L7;
        this.f955a = r3;
        this.f956b = r4;
        return;
    L7:
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + r3 + " and height: " + r4);
    }

    @Override // com.bumptech.glide.request.a.e
    public final void a(d r3) {
        ((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin")).a(this.f955a, this.f956b);
    }

    @Override // com.bumptech.glide.request.a.e
    public final void a(com.bumptech.glide.request.d r3) {
        this.c = (com.bumptech.glide.request.d) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.d.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bumptech.glide.request.a.e
    public final com.bumptech.glide.request.d b() {
        return this.c;
    }

    @Override // com.bumptech.glide.request.a.e
    public void b(Drawable r1) {
    }

    @Override // com.bumptech.glide.request.a.e
    public final void b(d r2) {
        d r1 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bumptech.glide.request.a.e
    public void c(Drawable r1) {
    }

    @Override // com.bumptech.glide.manager.k
    public void e() {
    }

    @Override // com.bumptech.glide.manager.k
    public void f() {
    }

    @Override // com.bumptech.glide.manager.k
    public void g() {
    }
}
