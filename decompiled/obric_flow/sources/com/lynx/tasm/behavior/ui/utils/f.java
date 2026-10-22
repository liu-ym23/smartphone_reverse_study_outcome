package com.lynx.tasm.behavior.ui.utils;

import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.u0;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f10746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f10747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f10748c;
    public final Rect d;
    public final an.j e;
    public final LynxContext f;

    public f(LynxContext r5) {
        this.f10748c = new Rect();
        this.d = new Rect();
        this.e = null;
        this.f = r5;
        this.e = a();
        float[] r10 = new float[4];
        this.f10747b = r10;
        Arrays.fill(r10, 0.0f);
        u0 r11 = r5.K;
        if (r11 == null) goto L5;
        boolean r12 = r11.f10975m;
    L6:
        if (r12 == false) goto L9;
        this.f10746a = new l(3.0f);
        return;
    L9:
        this.f10746a = new l(0.0f);
        return;
    L5:
        r12 = false;
        goto L6
    }

    public abstract an.j a();

    public void b(int r5, float r10) {
        this.f10746a.b(r10, r5);
    }

    public boolean c(float r5, float r10, float r11, float r12) {
        float[] r13 = this.f10747b;
        boolean r14 = false;
        if (com.lynx.tasm.utils.a.k(r13[0], r5) == true) goto L6;
        r13[0] = r5;
        r14 = true;
    L6:
        if (com.lynx.tasm.utils.a.k(r13[1], r10) == true) goto L9;
        r13[1] = r10;
        r14 = true;
    L9:
        if (com.lynx.tasm.utils.a.k(r13[2], r11) == true) goto L12;
        r13[2] = r11;
        r14 = true;
    L12:
        if (com.lynx.tasm.utils.a.k(r13[3], r12) == true) goto L15;
        r13[3] = r12;
        return true;
    L15:
        return r14;
    }

    public final RectF d() {
        l r5 = this.f10746a;
        float r10 = r5.a(1);
        float r11 = r5.a(3);
        float r12 = r5.a(0);
        float r13 = r5.a(2);
        Rect r14 = getBounds();
        float r15 = r12 + r13;
        if (r15 > r14.width()) goto L5;
    L7:
        float r16 = r10 + r11;
        if (r16 <= r14.height()) goto L13;
        if (r14.height() < 1) goto L13;
        float r17 = r14.height() / r16;
        r10 = r10 * r17;
        r11 = r11 * r17;
    L13:
        return new RectF(r12, r10, r13, r11);
    L5:
        if (r14.width() < 1) goto L7;
        float r18 = r14.width() / r15;
        r12 = r12 * r18;
        r13 = r13 * r18;
        goto L7
    }

    public final void e() {
        Rect r5 = getBounds();
        int r10 = r5.left;
        int r11 = r5.top;
        int r12 = r5.right;
        int r13 = r5.bottom;
        Rect r14 = this.f10748c;
        r14.set(r10, r11, r12, r13);
        RectF r15 = d();
        int r16 = (int) (r14.left + r15.left);
        r14.left = r16;
        int r17 = (int) (r14.top + r15.top);
        r14.top = r17;
        int r18 = (int) (r14.right - r15.right);
        r14.right = r18;
        int r19 = (int) (r14.bottom - r15.bottom);
        r14.bottom = r19;
        Rect r20 = this.d;
        r20.set(r16, r17, r18, r19);
        float r21 = r20.top;
        float[] r22 = this.f10747b;
        r20.top = (int) (r21 + r22[0]);
        r20.right = (int) (r20.right - r22[1]);
        r20.bottom = (int) (r20.bottom - r22[2]);
        r20.left = (int) (r20.left + r22[3]);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r5) {
        super.onBoundsChange(r5);
        Iterator r10 = this.e.f344a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((an.c) r10.next()).a(r5.width(), r5.height());
        goto L4
    L6:
        e();
    }
}
