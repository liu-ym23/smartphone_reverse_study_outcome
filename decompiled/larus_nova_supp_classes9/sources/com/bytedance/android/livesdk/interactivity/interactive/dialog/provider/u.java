package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ VsMsgBoardBottomTipSectionProvider a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ ValueAnimator c;

    public u(VsMsgBoardBottomTipSectionProvider r1, boolean r2, ValueAnimator r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        View r0 = this.a.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.b == false) goto L16;
        if (r0 == null) goto L8;
        UtilityKotlinExtentionsKt.z(r0, true);
    L8:
        View r1 = this.a.c;
        if (r1 == null) goto L13;
        ViewGroup r2 = UtilityKotlinExtentionsKt.p(r1);
        if (r2 == null) goto L13;
        UtilityKotlinExtentionsKt.z(r2, true);
    L13:
        View r3 = this.a.c;
        if (r3 == null) goto L30;
        r3.setAlpha(r4.getAnimatedFraction());
        return;
    L30:
        return;
    L16:
        if (r0 == null) goto L19;
        r0.setAlpha(1 - r4.getAnimatedFraction());
    L19:
        if (this.c.getAnimatedFraction() < 1.0f) goto L32;
        View r5 = this.a.c;
        if (r5 == null) goto L23;
        UtilityKotlinExtentionsKt.z(r5, false);
    L23:
        View r6 = this.a.c;
        if (r6 == null) goto L33;
        ViewGroup r7 = UtilityKotlinExtentionsKt.p(r6);
        if (r7 == null) goto L34;
        UtilityKotlinExtentionsKt.z(r7, false);
        return;
    L34:
        return;
    L33:
        return;
    }
}
