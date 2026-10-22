package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.rareshopcombo;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ GiftRareShopComboView a;
    public final /* synthetic */ Drawable b;
    public final /* synthetic */ Drawable c;

    public k(GiftRareShopComboView r1, Drawable r2, Drawable r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        GiftRareShopComboView r0 = this.a;
        Object r1 = r4.getAnimatedValue();
        if (r1 == null) goto L16;
        r0.G = ((Float) r1).floatValue();
        Drawable r2 = this.b;
        if (r2 == null) goto L11;
        Object r5 = r4.getAnimatedValue();
        if (r5 == null) goto L10;
        r2.setAlpha((int) (((Float) r5).floatValue() * 255));
        goto L11
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L11:
        Drawable[] r6 = {this.c, this.b};
        View r3 = this.a.a;
        if (r3 == null) goto L17;
        r3.setBackground(new LayerDrawable(r6));
        return;
    L17:
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
