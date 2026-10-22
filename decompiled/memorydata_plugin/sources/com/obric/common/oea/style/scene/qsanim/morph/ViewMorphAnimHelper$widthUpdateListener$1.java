package com.obric.common.oea.style.scene.qsanim.morph;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "anim", "Lcom/obric/common/oea/foundation/animation/engine/DynamicAnimation;", EventBody.KEY_VALUE, "", "velocity", "invoke"}, k = 3, mv = {1, 4, 3})
final class ViewMorphAnimHelper$widthUpdateListener$1 extends Lambda implements Function3<com.obric.common.oea.foundation.animation.c.b<?>, Float, Float, Unit> {
    final /* synthetic */ a this$0;

    ViewMorphAnimHelper$widthUpdateListener$1(a r1) {
        this.this$0 = r1;
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Unit invoke(com.obric.common.oea.foundation.animation.c.b<?> r3, Float r4, Float r5) {
        invoke((com.obric.common.oea.foundation.animation.c.b) ZeusTransformUtils.preCheckCast(r3, com.obric.common.oea.foundation.animation.c.b.class, "com.obric.memorydata.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(com.obric.common.oea.foundation.animation.c.b<?> r2, float r3, float r4) {
        Intrinsics.checkNotNullParameter(r2, "anim");
        if (this.this$0.f() != 0.0f) goto L5;
    L7:
        View r5 = this.this$0.e();
        ViewGroup.LayoutParams r1 = this.this$0.e().getLayoutParams();
        r1.width = (int) r3;
        Unit r6 = Unit.INSTANCE;
        r5.setLayoutParams(r1);
        return;
    L5:
        if (this.this$0.e().getX() >= a.a(this.this$0)) goto L7;
        this.this$0.e().setX(a.a(this.this$0) - (r3 - this.this$0.a()));
        goto L7
    }
}
