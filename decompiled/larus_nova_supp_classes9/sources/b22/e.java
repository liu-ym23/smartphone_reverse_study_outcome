package b22;

import android.animation.ValueAnimator;
import android.widget.ImageView;
import com.bytedance.android.livesdk.gift.vs.panel.view.VSGiftListWidgetNew;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ VSGiftListWidgetNew a;

    public e(VSGiftListWidgetNew r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L9;
        float r4 = ((Float) r3).floatValue();
        ImageView r0 = this.a.f;
        if (r0 == null) goto L10;
        r0.setAlpha(r4);
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
