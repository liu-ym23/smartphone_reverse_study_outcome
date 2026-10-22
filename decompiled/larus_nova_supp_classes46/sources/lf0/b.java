package lf0;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.liveinteract.interact.audience.ui.InteractAudienceAlertWindow;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ InteractAudienceAlertWindow a;

    public b(InteractAudienceAlertWindow r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        ViewGroup.LayoutParams r0 = this.a.getLayoutParams();
        if (r0 == null) goto L11;
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L9;
        r1.rightMargin = ((Integer) r3).intValue();
        this.a.setLayoutParams(r1);
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }
}
