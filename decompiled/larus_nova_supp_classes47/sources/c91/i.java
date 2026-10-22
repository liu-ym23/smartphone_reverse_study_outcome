package c91;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ a a;

    public i(a r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        Object r7 = r6.getAnimatedValue();
        if (r7 == null) goto L7;
        float r8 = ((Float) r7).floatValue();
        this.a.f.setClipBounds(new Rect(-((int) r8), 0, this.a.f.getWidth(), this.a.f.getHeight()));
        this.a.f.requestLayout();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
