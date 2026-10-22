package com.obric.common.oea.style.scene.qsanim.pulldown;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "child", "Landroid/view/View;", "<anonymous parameter 2>", "Lcom/obric/common/oea/style/scene/qsanim/pulldown/QSAnimConfig;", "invoke"}, k = 3, mv = {1, 4, 3})
final class AbstractQSPullDownAnimHelper$makeChildEnterAnim$1$1 extends Lambda implements Function3<String, View, b, Unit> {
    final /* synthetic */ AnimatorSet $this_apply;

    AbstractQSPullDownAnimHelper$makeChildEnterAnim$1$1(AnimatorSet r1) {
        this.$this_apply = r1;
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Unit invoke(String r3, View r4, b r5) {
        invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"), (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r7, View r8, b r9) {
        Intrinsics.checkNotNullParameter(r7, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(r8, "child");
        Intrinsics.checkNotNullParameter(r9, "<anonymous parameter 2>");
        AnimatorSet r6 = this.$this_apply;
        AnimatorSet r10 = new AnimatorSet();
        r10.playTogether(new Animator[]{(Animator) ZeusTransformUtils.preCheckCast(ObjectAnimator.ofFloat(r8, "alpha", new float[]{1.0f}), Animator.class, "com.obric.memorydata.plugin"), (Animator) ZeusTransformUtils.preCheckCast(ObjectAnimator.ofFloat(r8, "scaleX", new float[]{1.0f}), Animator.class, "com.obric.memorydata.plugin"), (Animator) ZeusTransformUtils.preCheckCast(ObjectAnimator.ofFloat(r8, "scaleY", new float[]{1.0f}), Animator.class, "com.obric.memorydata.plugin")});
        Unit r11 = Unit.INSTANCE;
        r6.play((Animator) ZeusTransformUtils.preCheckCast(r10, Animator.class, "com.obric.memorydata.plugin"));
    }
}
