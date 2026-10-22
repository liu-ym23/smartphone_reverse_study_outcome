package y81;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t extends AnimatorListenerAdapter {
    public final /* synthetic */ l a;

    public t(l r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        l r5 = this.a;
        l.k(r5, r5.l, ColorProtector.parseColor("#26000000"), ColorProtector.parseColor("#26000000"));
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        l r5 = this.a;
        l.k(r5, r5.l, ColorProtector.parseColor("#26000000"), ColorProtector.parseColor("#80000000"));
    }
}
