package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.rareshopcombo;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ValueAnimator a;
    public final /* synthetic */ GiftRareShopComboHeatHelper b;
    public final /* synthetic */ Ref.FloatRef c;

    public c(ValueAnimator r1, GiftRareShopComboHeatHelper r2, Ref.FloatRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r7) {
        Intrinsics.checkNotNullParameter(r7, "it");
        Ref.FloatRef r0 = this.c;
        Object r8 = r7.getAnimatedValue();
        if (r8 == null) goto L13;
        r0.element = ((Float) r8).floatValue();
        if (this.b.e <= 4000) goto L14;
        float r9 = this.a.getDuration() * this.c.element;
        GiftRareShopComboHeatHelper r1 = this.b;
        if (r9 >= (r1.e - 4000)) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual((Boolean) r1.d.getValue(), Boolean.FALSE) == false) goto L16;
        this.b.d.setValue(Boolean.TRUE);
        return;
    L16:
        return;
    L14:
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
