package ynb;

import android.animation.ValueAnimator;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ImageView a;

    public b(ImageView r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r4, "animator");
        float r5 = r4.getAnimatedFraction();
        ImageView r0 = this.a;
        int r2 = 0;
        if (r5 >= 0.5f) goto L5;
        boolean r6 = true;
    L6:
        if (r6 == true) goto L9;
        r2 = 8;
    L9:
        r0.setVisibility(r2);
        return;
    L5:
        r6 = false;
        goto L6
    }
}
