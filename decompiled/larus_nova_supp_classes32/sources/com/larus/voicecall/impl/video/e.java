package com.larus.voicecall.impl.video;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewConfiguration;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e {
    public final View a;
    public final float b;
    public final float c;
    public float d;
    public float e;
    public f f;
    public g g;
    public d h;
    public boolean i;
    public boolean j;
    public boolean k;
    public float l;
    public float m;
    public final int n;
    public float o;
    public float p;

    public static final class a {
    }

    static {
    }

    public final int a() {
        int r0 = m0.a;
        return m0.b(this.a.getContext());
    }

    public e(View r4) {
        float r0 = i5.j0();
        i5.j0();
        Intrinsics.checkNotNullParameter(r4, "targetView");
        this.a = r4;
        this.b = r0;
        this.c = 0.2625f;
        this.d = -1.0f;
        this.e = -1.0f;
        this.j = true;
        this.l = -1.0f;
        this.m = -1.0f;
        this.n = ViewConfiguration.get(r4.getContext()).getScaledTouchSlop();
        int r1 = m0.a;
        this.p = m0.a(r4.getContext());
        FLogger.a.d("DragFloatingEffect", "screen width = " + a() + ", screen height = " + m0.a(r4.getContext()));
    }

    public final void b(boolean r13) {
        float r0 = this.a.getWidth() * this.a.getScaleX();
        float r1 = this.a.getHeight() * this.a.getScaleY();
        float r2 = this.a.getX();
        float r3 = this.a.getY();
        float r5 = (r0 / 2) + r2;
        if (r5 > (a() / 2)) goto L5;
        boolean r6 = true;
    L7:
        if (r5 > 0.0f) goto L9;
    L10:
        if (r13 == false) goto L12;
        boolean r7 = true;
    L13:
        FLogger.a.i("chenyang-ani", "canEnterMaskMode=" + r7 + " completeShow=" + r13);
        if (r6 == false) goto L18;
        if (r7 == false) goto L17;
        float r14 = this.c * r0;
    L21:
        float r15 = r14 - r0;
    L22:
        float r4 = this.o;
        if (r3 < r4) goto L29;
        float r8 = r3 + r1;
        float r9 = this.p;
        if (r8 <= r9) goto L28;
        r4 = r9 - r1;
        goto L29
    L28:
        r4 = r3;
    L29:
        f r10 = this.f;
        if (r10 == null) goto L32;
        r10.f5(r15, r4);
    L32:
        if (r7 == false) goto L40;
        if (this.k == true) goto L45;
        this.k = true;
        g r11 = this.g;
        if (r11 == null) goto L45;
        r11.a();
    L45:
        float r16 = (r15 - r2) + this.a.getTranslationX();
        float r12 = (r4 - r3) + this.a.getTranslationY();
        View r17 = this.a;
        float r18 = r17.getTranslationX();
        TimeInterpolator r19 = c.a;
        Intrinsics.checkNotNullParameter(r17, "view");
        ObjectAnimator r110 = ObjectAnimator.ofFloat(r17, "translationX", new float[]{r18, r16});
        r110.setDuration(100);
        r110.setInterpolator(r19);
        View r20 = this.a;
        float r21 = r20.getTranslationY();
        Intrinsics.checkNotNullParameter(r20, "view");
        ObjectAnimator r22 = ObjectAnimator.ofFloat(r20, "translationY", new float[]{r21, r12});
        r22.setDuration(100);
        r22.setInterpolator(r19);
        AnimatorSet r23 = new AnimatorSet();
        r23.play(r110).with(r22);
        r23.start();
        return;
    L40:
        if (this.k == false) goto L45;
        this.k = false;
        g r24 = this.g;
        if (r24 == null) goto L45;
        r24.b();
        goto L45
    L17:
        r15 = this.b;
        goto L22
    L18:
        if (r7 == false) goto L20;
        r14 = a();
        r0 = r0 * this.c;
        goto L21
    L20:
        r14 = a() - r0;
        r0 = this.b;
    L12:
        r7 = false;
        goto L13
    L9:
        if (r5 < a()) goto L12;
    L5:
        r6 = false;
        goto L7
    }
}
