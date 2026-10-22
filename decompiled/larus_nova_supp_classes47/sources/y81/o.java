package y81;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.widget.TextSwitcher;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o extends AnimatorListenerAdapter {
    public final /* synthetic */ l a;

    public o(l r1) {
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
        Integer r6 = this.a.P;
        if (r6 != null) goto L9;
    L13:
        Integer r7 = this.a.P;
        if (r7 != null) goto L17;
    L21:
        l r8 = this.a;
        r8.r(r8.m, 0.0f);
        l r9 = this.a;
        l.k(r9, r9.l, ColorProtector.parseColor("#26000000"), ColorProtector.parseColor("#26000000"));
        return;
    L17:
        if (r7.intValue() != 4) goto L21;
        TextSwitcher r10 = this.a.H;
        if (r10 == null) goto L21;
        r10.setCurrentText(s1.B(2131916253));
        goto L21
    L9:
        if (r6.intValue() != 1) goto L13;
        TextSwitcher r12 = this.a.H;
        if (r12 == null) goto L21;
        r12.setCurrentText(s1.B(2131916257));
        goto L21
    }
}
