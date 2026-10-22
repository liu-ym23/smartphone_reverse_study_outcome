package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.view.View;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ LandscapeQuickShotLayerWidget a;
    public final /* synthetic */ Bitmap b;

    public e(LandscapeQuickShotLayerWidget r1, Bitmap r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        if ((!Intrinsics.areEqual(this.b, this.a.e)) == false) goto L5;
        return;
    L5:
        View r0 = ((Widget) this.a).contentView;
        if (r0 == null) goto L9;
        r0.setAlpha(1 - r4.getAnimatedFraction());
    L9:
        if (r4.getAnimatedFraction() != 1.0f) goto L12;
        this.a.xq();
        return;
    }
}
