package y81;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h0 extends AnimatorListenerAdapter {
    public final /* synthetic */ d0 a;

    public h0(d0 r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        ViewGroup r4 = this.a.l;
        if (r4 == null) goto L6;
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        r0.width = (int) UtilityKotlinExtentionsKt.h(52);
        r4.setLayoutParams(r0);
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        ViewGroup r5 = this.a.l;
        if (r5 == null) goto L5;
        r5.setVisibility(0);
    L5:
        this.a.j();
        this.a.m();
        d0.v(this.a.m, 0.0f);
        d0 r6 = this.a;
        d0.k(r6, r6.l, ColorProtector.parseColor("#26000000"), ColorProtector.parseColor("#26000000"));
    }
}
