package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.GiftListEdgeTransparentView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ GiftMVIPanelView a;

    public h0(GiftMVIPanelView r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        Object r7 = r6.getAnimatedValue();
        ViewGroup r1 = null;
        if ((r7 instanceof Float) == true) goto L5;
        r7 = null;
    L5:
        Float r8 = (Float) r7;
        if (r8 == null) goto L8;
        float r9 = r8.floatValue();
    L9:
        ViewGroup r2 = this.a.t();
        if ((r2 instanceof GiftListEdgeTransparentView) == false) goto L13;
        r1 = r2;
    L13:
        GiftListEdgeTransparentView r3 = (GiftListEdgeTransparentView) r1;
        if (r3 == null) goto L17;
        int[] r4 = {-1, 0};
        float[] r5 = {1.0f, 1.0f};
        Intrinsics.checkNotNullParameter(r4, "gradientColors");
        Intrinsics.checkNotNullParameter(r5, "gradientPosition");
        r3.e = r4;
        r3.f = r5;
        float r10 = s1.f(58.0f) + r9;
        r3.g = 0.0f;
        r3.h = r10;
        r3.invalidate();
        r3.a();
        r3.invalidate();
        return;
    L17:
        return;
    L8:
        r9 = 0.0f;
        goto L9
    }
}
