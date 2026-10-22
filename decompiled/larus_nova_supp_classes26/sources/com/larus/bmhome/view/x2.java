package com.larus.bmhome.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.utils.CubicBezierInterpolator;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class x2 {
    public final View a;
    public final View b;
    public final String c;
    public boolean d;
    public boolean e;
    public boolean f;
    public Boolean g;
    public Boolean h;
    public boolean i;
    public Function0<Unit> j;
    public final AnimatorSet k;

    public final boolean a() {
        Boolean r0 = this.g;
        if (r0 == null) goto L6;
        return r0.booleanValue();
    L6:
        if (this.d == true) goto L8;
    L10:
        return false;
    L8:
        if (this.f == false) goto L10;
        return true;
    }

    public final void b(Boolean r17) {
        boolean r1 = this.e;
        if (r17 == null) goto L5;
        this.e = r17.booleanValue();
    L5:
        int r3 = 8;
        if (this.i == true) goto L17;
        this.a.setVisibility(8);
        View r2 = this.b;
        if (a() == true) goto L10;
    L12:
        boolean r4 = false;
    L13:
        if (r4 == false) goto L15;
        r3 = 0;
    L15:
        r2.setVisibility(r3);
        return;
    L10:
        if (nda.d.a().ja(this.b) == true) goto L12;
        r4 = true;
        goto L13
    L17:
        if (r1 == false) goto L19;
    L21:
        boolean r5 = false;
    L22:
        if (r1 == true) goto L24;
    L26:
        boolean r6 = false;
    L28:
        if (r5 == true) goto L30;
    L36:
        if (r6 == false) goto L53;
        if (this.d == false) goto L53;
        FLogger.a.d(this.c, "performMenuOrBreakBtnVisible, isLoadingOrStreaming: true -> false, isVisible = " + this.d + ", isMenuActionVisible = " + this.f);
        if (a() == false) goto L42;
        ValueAnimator r7 = ObjectAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r7.setDuration(120);
        r7.setInterpolator(new CubicBezierInterpolator(0.0f, 0.0f, 0.58f));
        r7.addUpdateListener(new w2(this));
        Intrinsics.checkNotNull(r7);
        d2a.g.b(r7, null, new l2(this), null, 13);
        ValueAnimator r8 = ObjectAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r8.setDuration(100);
        r8.setInterpolator(new CubicBezierInterpolator(0.42f, 0.0f, 1.0f));
        r8.addUpdateListener(new m2(this));
        Intrinsics.checkNotNull(r8);
        d2a.g.b(r8, new p2(this), null, null, 14);
        AnimatorSet r9 = this.k;
        r9.cancel();
        r9.playSequentially(new Animator[]{r7, r8});
        r9.start();
        return;
    L42:
        View r10 = this.a;
        if (this.d == true) goto L45;
    L47:
        boolean r11 = false;
    L48:
        if (r11 == false) goto L50;
        int r12 = 0;
    L51:
        r10.setVisibility(r12);
        return;
    L50:
        r12 = 8;
        goto L51
    L45:
        if (this.e == false) goto L47;
        r11 = true;
    L53:
        if (this.k.isRunning() == true) goto L83;
        View r13 = this.a;
        Boolean r14 = this.h;
        if (r14 == null) goto L58;
        boolean r15 = r14.booleanValue();
    L63:
        if (r15 == false) goto L65;
        int r16 = 0;
    L66:
        r13.setVisibility(r16);
        View r18 = this.b;
        Boolean r19 = this.g;
        if (r19 == null) goto L70;
        boolean r20 = r19.booleanValue();
    L75:
        if (r20 == false) goto L77;
        int r21 = 0;
    L78:
        r18.setVisibility(r21);
        return;
    L77:
        r21 = 8;
        goto L78
    L70:
        if (a() == true) goto L72;
    L74:
        r20 = false;
        goto L75
    L72:
        if (this.e == true) goto L74;
        r20 = true;
        goto L75
    L65:
        r16 = 8;
        goto L66
    L58:
        if (this.d == true) goto L60;
    L62:
        r15 = false;
        goto L63
    L60:
        if (this.e == false) goto L62;
        r15 = true;
        goto L63
    L83:
        return;
    L30:
        if (this.d == false) goto L36;
        FLogger.a.d(this.c, "performMenuOrBreakBtnVisible, isLoadingOrStreaming: false -> true, isVisible = " + this.d + ", isMenuActionVisible = " + this.f);
        if (a() == false) goto L34;
        ValueAnimator r22 = ObjectAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r22.setDuration(100);
        r22.setInterpolator(new CubicBezierInterpolator(0.0f, 0.0f, 0.58f));
        r22.addUpdateListener(new o2(this));
        Intrinsics.checkNotNull(r22);
        d2a.g.b(r22, null, new q2(this), null, 13);
        ValueAnimator r23 = ObjectAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r23.setDuration(120);
        r23.setInterpolator(new CubicBezierInterpolator(0.42f, 0.0f, 1.0f));
        r23.addUpdateListener(new r2(this));
        Intrinsics.checkNotNull(r23);
        d2a.g.b(r23, new s2(this), null, null, 14);
        AnimatorSet r24 = this.k;
        r24.cancel();
        r24.playSequentially(new Animator[]{r22, r23});
        r24.start();
    L35:
        this.j.invoke();
        return;
    L34:
        ValueAnimator r25 = ObjectAnimator.ofInt(new int[]{0, i5.c0()});
        r25.setDuration(100);
        r25.setInterpolator(new CubicBezierInterpolator(0.0f, 0.0f, 0.58f));
        r25.addUpdateListener(new t2(this));
        Intrinsics.checkNotNull(r25);
        d2a.g.b(r25, new u2(this), null, null, 14);
        ValueAnimator r26 = ObjectAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r26.setDuration(120);
        r26.setInterpolator(new CubicBezierInterpolator(0.42f, 0.0f, 1.0f));
        r26.addUpdateListener(new v2(this));
        AnimatorSet r27 = this.k;
        r27.cancel();
        r27.playSequentially(new Animator[]{r25, r26});
        r27.start();
        goto L35
    L24:
        if (this.e == true) goto L26;
        r6 = true;
        goto L28
    L19:
        if (this.e == false) goto L21;
        r5 = true;
        goto L22
    }

    public x2(AppCompatImageView r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "breakAction");
        Intrinsics.checkNotNullParameter(r3, "menuEntranceAction");
        this.a = r2;
        this.b = r3;
        this.c = "MenuAndBreakActionController";
        this.j = new k2();
        this.k = new AnimatorSet();
    }
}
