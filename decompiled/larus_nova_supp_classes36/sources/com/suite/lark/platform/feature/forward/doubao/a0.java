package com.suite.lark.platform.feature.forward.doubao;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a0 implements View.OnTouchListener {
    public final /* synthetic */ ForwardDoubaoActivity a;

    public a0(ForwardDoubaoActivity r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r10, MotionEvent r11) {
        if (this.a.b == false) goto L5;
        return false;
    L5:
        int r12 = r11.getActionMasked();
        View r1 = null;
        if (r12 != 0) goto L8;
        ForwardDoubaoActivity r13 = this.a;
        Intrinsics.checkNotNull(r11);
        r13.getClass();
        if (r11.getY() > r13.m) goto L93;
        View r5 = r13.l;
        if (r5 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r5 = null;
    L80:
        Integer r6 = Integer.valueOf(r5.getWidth());
        if (r6.intValue() <= 0) goto L83;
        boolean r7 = true;
    L84:
        if (r7 == true) goto L87;
        r6 = null;
    L87:
        if (r6 == null) goto L93;
        int r8 = r6.intValue();
        int r14 = r13.n;
        float r9 = r14;
        float r15 = r8 - r14;
        float r16 = r11.getX();
        if (r9 > r16) goto L93;
        if (r16 > r15) goto L93;
        boolean r17 = true;
    L94:
        if (r17 == true) goto L97;
        this.a.f = false;
        return true;
    L97:
        ForwardDoubaoActivity r18 = this.a;
        r18.f = true;
        VelocityTracker r19 = r18.c;
        if (r19 == null) goto L100;
        r19.recycle();
    L100:
        this.a.c = VelocityTracker.obtain();
        VelocityTracker r110 = this.a.c;
        if (r110 == null) goto L103;
        r110.addMovement(r11);
    L103:
        this.a.d = r11.getRawY();
        ForwardDoubaoActivity r111 = this.a;
        View r112 = r111.l;
        if (r112 != null) goto L106;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r112 = null;
    L106:
        r111.e = r112.getTranslationY();
        ForwardDoubaoActivity r113 = this.a;
        r113.g = false;
        View r114 = r113.l;
        if (r114 != null) goto L109;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r114 = null;
    L109:
        r114.animate().cancel();
        View r115 = this.a.k;
        if (r115 != null) goto L112;
        Intrinsics.throwUninitializedPropertyAccessException("bgMask");
    L113:
        r1.animate().cancel();
    L114:
        return true;
    L112:
        r1 = r115;
        goto L113
    L83:
        r7 = false;
    L93:
        r17 = false;
        goto L94
    L8:
        if (r12 != 1) goto L10;
        ForwardDoubaoActivity r116 = this.a;
        if (r116.f == true) goto L41;
        return true;
    L41:
        VelocityTracker r117 = r116.c;
        if (r117 == null) goto L44;
        r117.addMovement(r11);
    L44:
        VelocityTracker r118 = this.a.c;
        if (r118 == null) goto L47;
        r118.computeCurrentVelocity(AudioViewModel.ASR_SESSION_IDLE);
    L47:
        VelocityTracker r119 = this.a.c;
        if (r119 == null) goto L50;
        float r120 = r119.getYVelocity();
    L51:
        VelocityTracker r3 = this.a.c;
        if (r3 == null) goto L54;
        r3.recycle();
    L54:
        ForwardDoubaoActivity r4 = this.a;
        r4.c = null;
        View r20 = r4.l;
        if (r20 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r20 = null;
    L57:
        float r21 = r20.getTranslationY();
        float r121 = r11.getRawY();
        ForwardDoubaoActivity r22 = this.a;
        if ((r121 - r22.d) < r22.i) goto L60;
        boolean r122 = true;
    L62:
        if (r22.g == false) goto L69;
        if (r122 == false) goto L69;
        if (r21 <= (r22.j * 0.33f)) goto L67;
    L68:
        boolean r123 = true;
    L70:
        if (r123 == false) goto L72;
        r22.finish();
    L73:
        ForwardDoubaoActivity r124 = this.a;
        r124.f = false;
        r124.g = false;
        goto L114
    L72:
        ForwardDoubaoActivity.A1(r22, 0.0f, 1.0f, null, 12);
        goto L73
    L67:
        if (r120 > 1500.0f) goto L68;
    L69:
        r123 = false;
        goto L70
    L60:
        r122 = false;
        goto L62
    L50:
        r120 = 0.0f;
        goto L51
    L10:
        if (r12 != 2) goto L12;
        ForwardDoubaoActivity r125 = this.a;
        if (r125.f == true) goto L21;
        return true;
    L21:
        VelocityTracker r126 = r125.c;
        if (r126 == null) goto L24;
        r126.addMovement(r11);
    L24:
        float r127 = r11.getRawY();
        ForwardDoubaoActivity r128 = this.a;
        float r129 = r127 - r128.d;
        if (r128.g == false) goto L27;
    L30:
        float r130 = RangesKt.coerceIn(r128.e + r129, 0.0f, r128.j);
        View r131 = this.a.l;
        if (r131 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r131 = null;
    L33:
        r131.setTranslationY(r130);
        float r132 = RangesKt.coerceIn(r130 / this.a.j, 0.0f, 1.0f);
        View r133 = this.a.k;
        if (r133 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("bgMask");
    L37:
        r1.setAlpha(1.0f - r132);
        goto L114
    L36:
        r1 = r133;
        goto L37
    L27:
        if (r129 > r128.h) goto L29;
        return true;
    L29:
        r128.g = true;
        goto L30
    L12:
        if (r12 != 3) goto L116;
        VelocityTracker r134 = this.a.c;
        if (r134 == null) goto L17;
        r134.recycle();
    L17:
        ForwardDoubaoActivity r135 = this.a;
        r135.c = null;
        r135.f = false;
        r135.g = false;
        ForwardDoubaoActivity.A1(r135, 0.0f, 1.0f, null, 12);
        goto L114
    L116:
        return false;
    }
}
