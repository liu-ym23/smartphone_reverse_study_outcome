package z08;

import android.animation.ValueAnimator;
import com.larksuite.component.universe_design.progress.UDProgress;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ UDProgress a;

    public a(UDProgress r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        UDProgress r0 = this.a;
        Object r4 = r3.getAnimatedValue();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Int");
        r0.setProgress(((Integer) r4).intValue());
    }
}
