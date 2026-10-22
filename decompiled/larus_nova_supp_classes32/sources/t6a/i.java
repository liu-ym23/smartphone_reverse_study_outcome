package t6a;

import android.graphics.Rect;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i extends Animation implements f {
    public final LynxUI a;
    public final View b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final Rect o;
    public float p;
    public float q;
    public float r;
    public float s;
    public int t;
    public int u;
    public int v;
    public int w;

    @Override // android.view.animation.Animation
    public final boolean willChangeBounds() {
        return true;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r24, Transformation r25) {
        this.a.updateLayout(Math.round(this.p + (this.r * r24)), Math.round(this.q + (this.s * r24)), Math.round(this.t + (this.v * r24)), Math.round(this.u + (this.w * r24)), this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o);
    }

    @Override // t6a.f
    public final void a(int r1, int r2, int r3, int r4) {
        b(r1, r2, r3, r4);
    }

    public final void b(int r3, int r4, int r5, int r6) {
        this.p = this.a.getOriginLeft() - this.a.getTranslationX();
        this.q = this.a.getOriginTop() - this.a.getTranslationY();
        this.t = this.a.getWidth();
        int r0 = this.a.getHeight();
        this.u = r0;
        this.r = r3 - this.p;
        this.s = r4 - this.q;
        this.v = r5 - this.t;
        this.w = r6 - r0;
    }

    public i(LynxUI r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, int r21, int r22, Rect r23) {
        this.a = r6;
        this.b = r6.getView();
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.h = r16;
        this.i = r17;
        this.j = r18;
        this.k = r19;
        this.l = r20;
        this.m = r21;
        this.n = r22;
        this.o = r23;
        b(r7, r8, r9, r10);
    }
}
