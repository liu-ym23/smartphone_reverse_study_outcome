package com.obric.common.oea.style.scene.qsanim.morph;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "value", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ViewMorphAnimHelperEx$doScaleAnimation$xAnimator$1 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ Integer $layoutGravity;
    final /* synthetic */ View $this_doScaleAnimation;

    public ViewMorphAnimHelperEx$doScaleAnimation$xAnimator$1(View r1, Integer r2) {
        this.$this_doScaleAnimation = r1;
        this.$layoutGravity = r2;
        super(1);
    }

    public final void invoke(float r3) {
        Integer r0 = this.$layoutGravity;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.intValue() != 16) goto L9;
        this.$this_doScaleAnimation.setX(r3);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Number) r1).floatValue());
        return Unit.INSTANCE;
    }
}
