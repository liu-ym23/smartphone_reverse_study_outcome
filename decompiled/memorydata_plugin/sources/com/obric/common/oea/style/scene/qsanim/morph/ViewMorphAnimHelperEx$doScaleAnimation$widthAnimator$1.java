package com.obric.common.oea.style.scene.qsanim.morph;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", EventBody.KEY_VALUE, "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ViewMorphAnimHelperEx$doScaleAnimation$widthAnimator$1 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ View $this_doScaleAnimation;

    ViewMorphAnimHelperEx$doScaleAnimation$widthAnimator$1(View r1) {
        this.$this_doScaleAnimation = r1;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Float r3) {
        invoke(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float r2) {
        View r1 = this.$this_doScaleAnimation;
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        r0.width = MathKt.roundToInt(r2);
        Unit r3 = Unit.INSTANCE;
        r1.setLayoutParams(r0);
    }
}
