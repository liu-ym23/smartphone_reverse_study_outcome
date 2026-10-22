package com.bytedance.android.live.matchroom;

import android.animation.ValueAnimator;
import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ float a;
    public final /* synthetic */ float b;
    public final /* synthetic */ float c;
    public final /* synthetic */ float d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ View f;

    public i(float r1, float r2, float r3, float r4, View r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = true;
        this.f = r5;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        Intrinsics.checkNotNullParameter(r5, "animator");
        float r0 = this.a;
        float r1 = this.b - r0;
        Object r2 = r5.getAnimatedValue();
        if (r2 == null) goto L29;
        float r3 = r0 + (r1 * ((Float) r2).floatValue());
        float r4 = this.c;
        float r6 = this.d - r4;
        Object r7 = r5.getAnimatedValue();
        if (r7 == null) goto L27;
        float r8 = r4 + (r6 * ((Float) r7).floatValue());
        if (Float.isNaN(r3) == false) goto L9;
        return;
    L9:
        if (Float.isInfinite(r3) == false) goto L11;
        return;
    L11:
        if (Float.isNaN(r8) == false) goto L13;
        return;
    L13:
        if (Float.isInfinite(r8) == true) goto L33;
        boolean r9 = MatchRoomLandScapeAnimUtil.a;
        WeakReference<d> r10 = MatchRoomLandScapeAnimUtil.l;
        if (r10 == null) goto L24;
        d r11 = r10.get();
        if (r11 == null) goto L24;
        if (this.e == true) goto L22;
        r11 = null;
    L22:
        if (r11 == null) goto L24;
        r11.c(r3, r8);
        return;
    L24:
        this.f.setScaleX(r3);
        this.f.setScaleY(r8);
        Unit r12 = Unit.INSTANCE;
        return;
    L33:
        return;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L29:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
