package w0b;

import android.animation.ValueAnimator;
import com.ss.android.lark.chameleonv2.debug.ui.LoadingView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ LoadingView a;

    public b(LoadingView r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        Object r4 = r3.getAnimatedValue();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Float");
        float r5 = ((Float) r4).floatValue();
        LoadingView r0 = this.a;
        r0.e = r0.b * r5;
        r0.invalidate();
    }
}
