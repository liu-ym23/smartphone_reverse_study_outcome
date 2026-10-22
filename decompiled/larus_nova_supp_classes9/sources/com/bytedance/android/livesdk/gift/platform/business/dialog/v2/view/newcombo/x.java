package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ GiftComboView a;

    public x(GiftComboView r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        GiftComboView r0 = this.a;
        Object r1 = r4.getAnimatedValue();
        if (r1 == null) goto L16;
        r0.x = ((Float) r1).floatValue();
        Drawable r2 = s1.m(2131248738);
        Drawable r3 = s1.m(2131250693);
        if (r3 == null) goto L11;
        Object r5 = r4.getAnimatedValue();
        if (r5 == null) goto L10;
        r3.setAlpha((int) (((Float) r5).floatValue() * 255));
        goto L11
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L11:
        Drawable[] r6 = {r2, r3};
        View r7 = this.a.a;
        if (r7 == null) goto L17;
        r7.setBackground(new LayerDrawable(r6));
        return;
    L17:
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
