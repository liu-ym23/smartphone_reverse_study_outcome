package com.obric.oui.animation.a;

import android.os.Looper;
import android.util.AndroidRuntimeException;

/* JADX INFO: loaded from: classes5.dex */
public final class d extends b<d> {
    private e w;
    private float x;
    private boolean y;

    public <K> d(K r1, c<K> r2) {
        super(r1, r2);
        this.w = null;
        this.x = Float.MAX_VALUE;
        this.y = false;
    }

    private void h() {
        e r0 = this.w;
        if (r0 == null) goto L14;
        double r1 = r0.a();
        if (r1 > this.u) goto L12;
        if (r1 < this.v) goto L10;
        return;
    L10:
        throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
    L12:
        throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
    L14:
        throw new UnsupportedOperationException("Incomplete com.obric.oui.animation.engine.SpringAnimation: Either final position or a spring force needs to be set.");
    }

    public d a(e r1) {
        this.w = r1;
        return this;
    }

    @Override // com.obric.oui.animation.a.b
    public void a() {
        h();
        this.w.a(d());
        super.a();
    }

    @Override // com.obric.oui.animation.a.b
    boolean a(float r1, float r2) {
        return this.w.a(r1, r2);
    }

    @Override // com.obric.oui.animation.a.b
    boolean b(long r21) {
        if (this.y == false) goto L10;
        float r1 = this.x;
        if (r1 == Float.MAX_VALUE) goto L7;
        this.w.c(r1);
        this.x = Float.MAX_VALUE;
    L7:
        this.p = this.w.a();
        this.o = 0.0f;
        this.y = false;
        return true;
    L10:
        if (this.x == Float.MAX_VALUE) goto L12;
        this.w.a();
        long r18 = r21 / 2;
        b.a r2 = this.w.a(this.p, this.o, r18);
        this.w.c(this.x);
        this.x = Float.MAX_VALUE;
        e r13 = this.w;
        double r14 = r2.f13294a;
        double r16 = r2.f13295b;
    L13:
        b.a r3 = r13.a(r14, r16, r18);
        this.p = r3.f13294a;
        this.o = r3.f13295b;
        this.p = Math.max(this.p, this.v);
        this.p = Math.min(this.p, this.u);
        if (a(this.p, this.o) == false) goto L17;
        this.p = this.w.a();
        this.o = 0.0f;
        return true;
    L17:
        return false;
    L12:
        r13 = this.w;
        r14 = this.p;
        r16 = this.o;
        r18 = r21;
        goto L13
    }

    public e e() {
        return this.w;
    }

    public void f() {
        if (g() == false) goto L13;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L11;
        if (this.t == false) goto L14;
        this.y = true;
        return;
    L14:
        return;
    L11:
        throw new AndroidRuntimeException("Animations may only be started on the main thread");
    L13:
        throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
    }

    public boolean g() {
        if (this.w.f13298b <= 0.0d) goto L5;
        return true;
    L5:
        return false;
    }
}
