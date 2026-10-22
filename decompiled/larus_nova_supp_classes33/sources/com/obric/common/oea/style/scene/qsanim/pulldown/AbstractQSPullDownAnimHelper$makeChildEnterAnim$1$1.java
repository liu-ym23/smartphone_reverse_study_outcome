package com.obric.common.oea.style.scene.qsanim.pulldown;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "<anonymous parameter 0>", "Landroid/view/View;", "child", "Lcom/obric/common/oea/style/scene/qsanim/pulldown/b;", "<anonymous parameter 2>", "", "invoke", "(Ljava/lang/String;Landroid/view/View;Lcom/obric/common/oea/style/scene/qsanim/pulldown/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class AbstractQSPullDownAnimHelper$makeChildEnterAnim$1$1 extends Lambda implements Function3<String, View, b, Unit> {
    final /* synthetic */ AnimatorSet $this_apply;

    public AbstractQSPullDownAnimHelper$makeChildEnterAnim$1$1(AnimatorSet r1) {
        this.$this_apply = r1;
        super(3);
    }

    public final void invoke(String r7, View r8, b r9) {
        Intrinsics.checkNotNullParameter(r7, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(r8, "child");
        Intrinsics.checkNotNullParameter(r9, "<anonymous parameter 2>");
        AnimatorSet r10 = this.$this_apply;
        AnimatorSet r11 = new AnimatorSet();
        r11.playTogether(new Animator[]{ObjectAnimator.ofFloat(r8, "alpha", new float[]{1.0f}), ObjectAnimator.ofFloat(r8, "scaleX", new float[]{1.0f}), ObjectAnimator.ofFloat(r8, "scaleY", new float[]{1.0f})});
        Unit r12 = Unit.INSTANCE;
        r10.play(r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((String) r1, (View) r2, (b) r3);
        return Unit.INSTANCE;
    }
}
