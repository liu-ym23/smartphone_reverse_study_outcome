package com.obric.common.oea.style.scene.qsanim.morph;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "value", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ViewMorphAnimHelperEx$doScaleAnimation$heightAnimator$1 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ View $this_doScaleAnimation;

    public ViewMorphAnimHelperEx$doScaleAnimation$heightAnimator$1(View r5) {
        this.$this_doScaleAnimation = r5;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Float r5) {
        invoke(r5.floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float r5) {
        View r10 = this.$this_doScaleAnimation;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        r11.height = MathKt.roundToInt(r5);
        Unit r12 = Unit.INSTANCE;
        r10.setLayoutParams(r11);
    }
}
