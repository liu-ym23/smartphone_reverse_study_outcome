package com.larus.common_ui.photoviewer;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import j19.m;
import k19.b;
import k19.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class a implements b<e> {
    public final e a;
    public m b;
    public boolean c;
    public boolean d;
    public boolean e;
    public float f;
    public float g;
    public float h;
    public final RectF i;
    public final RectF j;
    public final RectF k;
    public final Matrix l;
    public final Matrix m;
    public final float[] n;

    /* JADX INFO: renamed from: com.larus.common_ui.photoviewer.a$a, reason: collision with other inner class name */
    public interface InterfaceC0013a {
        void a(boolean r1);

        void b();
    }

    public final void d() {
        this.l.mapRect(this.k, this.j);
        m r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.c == false) goto L9;
        r0.a();
        return;
    }

    public final void i() {
        RectF r0 = this.i;
        RectF r1 = this.j;
        if (r1.width() <= r0.width()) goto L5;
    L8:
        this.h = Math.max(r1.width() / r0.width(), r1.height() / r0.height());
        return;
    L5:
        if (r1.height() > r0.height()) goto L8;
        this.h = Math.max(r0.width() / r1.width(), r0.height() / r1.height());
    }

    public a(e r2) {
        this.b = null;
        this.c = false;
        this.d = true;
        this.e = true;
        this.f = 1.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = new RectF();
        this.j = new RectF();
        this.k = new RectF();
        this.l = new Matrix();
        this.m = new Matrix();
        this.n = new float[9];
        this.a = r2;
        Intrinsics.checkNotNullParameter(this, "listener");
        r2.a.add(this);
    }

    public final PointF a(PointF r10) {
        float[] r6 = this.n;
        r6[0] = r10.x;
        r6[1] = r10.y;
        this.l.invert(this.m);
        this.m.mapPoints(r6, 0, r6, 0, 1);
        return new PointF(r6[0], r6[1]);
    }

    public final void f(boolean r3) {
        this.c = r3;
        if (r3 == true) goto L9;
        ZoomableControllerImp r4 = (ZoomableControllerImp) this;
        r4.w();
        if (r4.z.computeScrollOffset() == false) goto L7;
        r4.z.forceFinished(true);
    L7:
        r4.s.reset();
        r4.r.reset();
        r4.l.reset();
        r4.d();
        return;
    }

    public final void g(float r2) {
        if (r2 >= 1.0f) goto L5;
        return;
    L5:
        if (r2 < this.f) goto L10;
        this.g = r2;
        return;
    }

    public void h(RectF r2) {
        this.i.set(r2);
        i();
    }
}
