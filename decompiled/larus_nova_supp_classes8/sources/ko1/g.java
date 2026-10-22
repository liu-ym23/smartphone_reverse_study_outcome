package ko1;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import jc1.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g extends l {
    public float a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public boolean h;
    public int i;
    public int j;
    public int k;
    public int l;
    public float m;
    public float n;
    public float o;
    public float p;
    public boolean q;
    public float r;
    public float s;
    public final View t;
    public final ViewGroup u;
    public final com.bytedance.android.live.platformplayer.layout.c v;

    public final boolean onSingleTapConfirmed(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        return true;
    }

    public final void a(float r2) {
        this.t.setTranslationX(r2);
        com.bytedance.android.live.platformplayer.layout.c r0 = this.v;
        if (r0 == null) goto L6;
        r0.setTranslationX(r2);
        return;
    }

    public final void b(float r2) {
        this.t.setTranslationY(r2);
        com.bytedance.android.live.platformplayer.layout.c r0 = this.v;
        if (r0 == null) goto L6;
        r0.setTranslationY(r2);
        return;
    }

    public final void c(float r5) {
        float r0 = 0;
        if (r5 >= r0) goto L7;
        if (Math.abs(this.b + r5) >= this.m) goto L7;
    L10:
        float r1 = this.b + r5;
        this.b = r1;
        a(r1);
        return;
    L7:
        if (r5 > r0) goto L9;
    L11:
        if (r5 >= r0) goto L15;
        float r2 = Math.abs(this.b + r5);
        float r3 = this.m;
        if (r2 <= r3) goto L15;
        this.b = -r3;
        a(-r3);
        return;
    L15:
        if (r5 <= r0) goto L22;
        float r4 = this.b + r5;
        float r6 = this.o;
        if (r4 <= r6) goto L23;
        this.b = r6;
        a(r6);
        return;
    L23:
        return;
    L22:
        return;
    L9:
        if ((this.b + r5) >= this.o) goto L11;
        goto L10
    }

    public final void d(float r5) {
        float r0 = 0;
        if (r5 >= r0) goto L7;
        if (Math.abs(this.c + r5) >= this.n) goto L7;
    L10:
        float r1 = this.c + r5;
        this.c = r1;
        b(r1);
        return;
    L7:
        if (r5 > r0) goto L9;
    L11:
        if (r5 >= r0) goto L15;
        float r2 = Math.abs(this.c + r5);
        float r3 = this.n;
        if (r2 <= r3) goto L15;
        this.c = -r3;
        b(-r3);
        return;
    L15:
        if (r5 <= r0) goto L22;
        float r4 = this.c + r5;
        float r6 = this.p;
        if (r4 <= r6) goto L23;
        this.c = r6;
        b(r6);
        return;
    L23:
        return;
    L22:
        return;
    L9:
        if ((this.c + r5) >= this.p) goto L11;
        goto L10
    }

    public final boolean onDown(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        if (this.h == true) goto L5;
        this.h = true;
        this.m = this.t.getLeft();
        this.n = this.t.getTop();
        this.o = this.u.getWidth() - this.t.getRight();
        this.p = this.u.getHeight() - this.t.getBottom();
        this.i = this.t.getWidth();
        int r5 = this.t.getHeight();
        this.j = r5;
        int r1 = this.i;
        this.f = r1;
        this.g = r5;
        this.d = r1;
        this.e = r5;
        this.k = this.u.getWidth();
        this.l = this.u.getHeight();
    L5:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onSingleTapUp(MotionEvent r9) {
        Intrinsics.checkNotNullParameter(r9, "e");
        float r2 = 0.0f;
        if (this.d <= this.k) goto L5;
        float r0 = 0.0f;
    L7:
        if (this.e > this.l) goto L10;
        r2 = this.t.getTop() - ((this.e - this.j) / 2);
    L10:
        float r1 = this.d;
        int r4 = this.k;
        if (r1 <= r4) goto L13;
        float r3 = r4;
    L14:
        float r5 = this.e;
        int r6 = this.l;
        if (r5 <= r6) goto L17;
        float r7 = r6;
    L19:
        if (new RectF(r0, r2, r3, r7).contains(r9.getX(), r9.getY()) == false) goto L22;
        this.t.performClick();
    L22:
        return super/*android.view.GestureDetector.SimpleOnGestureListener*/.onSingleTapUp(r9);
    L17:
        r7 = this.u.getHeight() - ((this.u.getHeight() - this.t.getBottom()) - ((this.e - this.j) / 2));
        goto L19
    L13:
        r3 = this.u.getWidth() - ((this.u.getWidth() - this.t.getRight()) - ((this.d - this.i) / 2));
        goto L14
    L5:
        r0 = this.t.getLeft() - ((this.d - this.i) / 2);
        goto L7
    }

    public g(View r2, ViewGroup r3, com.bytedance.android.live.platformplayer.layout.c r4) {
        Intrinsics.checkNotNullParameter(r2, "targetView");
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        this.t = r2;
        this.u = r3;
        this.v = r4;
        this.a = 1.0f;
        this.r = 1.0f;
        this.s = 1.0f;
    }

    public final boolean onScroll(MotionEvent r3, MotionEvent r4, float r5, float r6) {
        Intrinsics.checkNotNullParameter(r4, "e2");
        float r7 = -r5;
        float r8 = -r6;
        if (this.q == true) goto L9;
        if (this.a > 1) goto L9;
        c(r7);
        d(r8);
    L15:
        return super.onScroll(r3, r4, r7, r8);
    L9:
        if (this.d <= this.k) goto L12;
        c(r7);
    L12:
        if (this.e <= this.l) goto L15;
        d(r8);
        goto L15
    }
}
