package i9;

import android.os.Looper;
import android.util.AndroidRuntimeException;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends b<d> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private e f9433t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f9434u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f9435v;

    public <K> d(K r10, c<K> r11) {
        super(r10, r11);
        this.f9433t = null;
        this.f9434u = Float.MAX_VALUE;
        this.f9435v = false;
    }

    private void w() {
        e r10 = this.f9433t;
        if (r10 == null) goto L14;
        double r11 = r10.a();
        if (r11 > this.f9425g) goto L12;
        if (r11 < this.f9426h) goto L10;
        return;
    L10:
        throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
    L12:
        throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
    L14:
        throw new UnsupportedOperationException("Incomplete com.obric.oui.animation.engine.SpringAnimation: Either final position or a spring force needs to be set.");
    }

    @Override // i9.b
    public void q() {
        w();
        this.f9433t.g(f());
        super.q();
    }

    @Override // i9.b
    boolean s(long r21) {
        if (this.f9435v == false) goto L10;
        float r10 = this.f9434u;
        if (r10 == Float.MAX_VALUE) goto L7;
        this.f9433t.e(r10);
        this.f9434u = Float.MAX_VALUE;
    L7:
        this.f9420b = this.f9433t.a();
        this.f9419a = 0.0f;
        this.f9435v = false;
        return true;
    L10:
        if (this.f9434u == Float.MAX_VALUE) goto L12;
        this.f9433t.a();
        long r18 = r21 / 2;
        b.o r11 = this.f9433t.h(this.f9420b, this.f9419a, r18);
        this.f9433t.e(this.f9434u);
        this.f9434u = Float.MAX_VALUE;
        e r13 = this.f9433t;
        double r14 = r11.f9431a;
        double r16 = r11.f9432b;
    L13:
        b.o r12 = r13.h(r14, r16, r18);
        this.f9420b = r12.f9431a;
        this.f9419a = r12.f9432b;
        float r15 = Math.max(this.f9420b, this.f9426h);
        this.f9420b = r15;
        float r17 = Math.min(r15, this.f9425g);
        this.f9420b = r17;
        if (v(r17, this.f9419a) == false) goto L17;
        this.f9420b = this.f9433t.a();
        this.f9419a = 0.0f;
        return true;
    L17:
        return false;
    L12:
        r13 = this.f9433t;
        r14 = this.f9420b;
        r16 = this.f9419a;
        r18 = r21;
        goto L13
    }

    public boolean t() {
        if (this.f9433t.f9437b <= 0.0d) goto L5;
        return true;
    L5:
        return false;
    }

    public e u() {
        return this.f9433t;
    }

    boolean v(float r10, float r11) {
        return this.f9433t.c(r10, r11);
    }

    public d x(e r10) {
        this.f9433t = r10;
        return this;
    }

    public void y() {
        if (t() == false) goto L13;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L11;
        if (this.f9424f == false) goto L14;
        this.f9435v = true;
        return;
    L14:
        return;
    L11:
        throw new AndroidRuntimeException("Animations may only be started on the main thread");
    L13:
        throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
    }
}
