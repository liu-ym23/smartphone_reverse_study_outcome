package com.bytedance.android.livesdk.interactivity.publicscreen.preview;

import android.graphics.Matrix;
import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class a implements ba2.b<ba2.e> {
    public final ba2.e a;
    public f b;
    public boolean c;
    public float d;
    public final RectF e;
    public final RectF f;
    public final RectF g;
    public final Matrix h;
    public final Matrix i;
    public final float[] j;

    public final void a() {
        this.h.mapRect(this.g, this.f);
        f r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.c == false) goto L9;
        r0.a();
        return;
    }

    public final void c() {
        RectF r0 = this.e;
        RectF r1 = this.f;
        if (r1.width() <= r0.width()) goto L5;
    L8:
        this.d = Math.max(r1.width() / r0.width(), r1.height() / r0.height());
        return;
    L5:
        if (r1.height() > r0.height()) goto L8;
        this.d = Math.max(r0.width() / r1.width(), r0.height() / r1.height());
    }

    public a(ba2.e r2) {
        this.b = null;
        this.c = false;
        this.d = 0.0f;
        this.e = new RectF();
        this.f = new RectF();
        this.g = new RectF();
        this.h = new Matrix();
        this.i = new Matrix();
        this.j = new float[9];
        this.a = r2;
        Intrinsics.checkNotNullParameter(this, "listener");
        r2.a.add(this);
    }

    public final void b(boolean r3) {
        this.c = r3;
        if (r3 == true) goto L9;
        ZoomableControllerImp r4 = (ZoomableControllerImp) this;
        r4.j();
        if (r4.t.computeScrollOffset() == false) goto L7;
        r4.t.forceFinished(true);
    L7:
        r4.o.reset();
        r4.n.reset();
        r4.h.reset();
        r4.a();
        return;
    }
}
