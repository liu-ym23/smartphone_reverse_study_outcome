package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ LandscapeQuickShotObserveWidget a;

    public m(LandscapeQuickShotObserveWidget r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        View r0 = ((Widget) this.a).contentView;
        if (r0 == null) goto L6;
        r0.setAlpha(1 - r4.getAnimatedFraction());
    L6:
        if (r4.getAnimatedFraction() != 1.0f) goto L9;
        LandscapeQuickShotObserveWidget r5 = this.a;
        int r1 = LandscapeQuickShotObserveWidget.o;
        r5.xq();
        return;
    }
}
