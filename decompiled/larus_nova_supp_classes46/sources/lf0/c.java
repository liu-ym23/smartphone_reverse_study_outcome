package lf0;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.live.liveinteract.interact.audience.ui.InteractAudienceAlertWindow;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ InteractAudienceAlertWindow a;

    public c(InteractAudienceAlertWindow r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L14;
        float r4 = ((Float) r3).floatValue();
        this.a.setAlpha(r4);
        this.a.setScaleX(r4);
        this.a.setScaleY(r4);
        if (r4 != 0.0f) goto L15;
        ViewParent r5 = this.a.getParent();
        if ((r5 instanceof ViewGroup) == true) goto L9;
        r5 = null;
    L9:
        ViewGroup r6 = (ViewGroup) r5;
        if (r6 == null) goto L16;
        r6.removeView(this.a);
        return;
    L16:
        return;
    L15:
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
