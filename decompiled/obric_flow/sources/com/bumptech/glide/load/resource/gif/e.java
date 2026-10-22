package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public final class e implements n0.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bumptech.glide.request.d f1657c;
    public final Handler d;
    public final int e;
    public final long f;
    public Bitmap g;

    public e(Handler r5, int r10, long r11) {
        if (q0.i.g(Integer.MIN_VALUE, Integer.MIN_VALUE) == false) goto L7;
        this.f1655a = Integer.MIN_VALUE;
        this.f1656b = Integer.MIN_VALUE;
        this.d = r5;
        this.e = r10;
        this.f = r11;
        return;
    L7:
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: -2147483648 and height: -2147483648");
    }

    @Override // n0.d
    public final void a(com.bumptech.glide.request.d r5) {
    }

    @Override // n0.d
    public final void b(Object r5) {
        this.g = (Bitmap) r5;
        Handler r10 = this.d;
        r10.sendMessageAtTime(r10.obtainMessage(1, this), this.f);
    }

    @Override // n0.d
    public final void c(com.bumptech.glide.request.d r5) {
        int r10 = this.f1656b;
        r5.l(this.f1655a, r10);
    }

    @Override // n0.d
    public final void d(Drawable r5) {
    }

    @Override // n0.d
    public final com.bumptech.glide.request.b e() {
        return this.f1657c;
    }

    @Override // n0.d
    public final void f(Drawable r5) {
        this.g = null;
    }

    @Override // n0.d
    public final void g(com.bumptech.glide.request.d r5) {
        this.f1657c = r5;
    }

    @Override // n0.d
    public final void h(Drawable r5) {
    }

    @Override // k0.d
    public final void i() {
    }

    @Override // k0.d
    public final void onDestroy() {
    }

    @Override // k0.d
    public final void onStart() {
    }
}
