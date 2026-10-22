package com.obric.common.oea.style.scene.qsanim;

import android.view.View;
import com.obric.common.oea.foundation.animation.c.e;
import com.obric.common.oea.style.scene.qsanim.a.c;
import com.obric.common.oea.style.scene.qsanim.pulldown.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "childId", "", "child", "Landroid/view/View;", "<anonymous parameter 2>", "Lcom/obric/common/oea/style/scene/qsanim/pulldown/QSAnimConfig;", "invoke"}, k = 3, mv = {1, 4, 3})
final class ViewGroupVerticalStretchAnimHelper$animateToInitialTranslations$1 extends Lambda implements Function3<String, View, b, Unit> {
    final /* synthetic */ a this$0;

    ViewGroupVerticalStretchAnimHelper$animateToInitialTranslations$1(a r1) {
        this.this$0 = r1;
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Unit invoke(String r3, View r4, b r5) {
        invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"), (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r13, View r14, b r15) {
        Intrinsics.checkNotNullParameter(r13, "childId");
        Intrinsics.checkNotNullParameter(r14, "child");
        Intrinsics.checkNotNullParameter(r15, "<anonymous parameter 2>");
        Float r16 = (Float) ZeusTransformUtils.preCheckCast(a.b(this.this$0).get(r13), Float.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L5;
        float r17 = r16.floatValue();
    L6:
        float r5 = r17;
        c r2 = c.f7829a;
        com.obric.common.oea.foundation.animation.c.b.d r18 = com.obric.common.oea.foundation.animation.c.b.f7696b;
        Intrinsics.checkNotNullExpressionValue(r18, "TRANSLATION_Y");
        e r19 = c.a(r2, r14, (com.obric.common.oea.foundation.animation.c.c) ZeusTransformUtils.preCheckCast(r18, com.obric.common.oea.foundation.animation.c.c.class, "com.obric.memorydata.plugin"), r5, 0.0f, 0.0f, null, null, 60, null);
        if (r19 == null) goto L10;
        a.c(this.this$0).put(r13, r19);
        return;
    L10:
        return;
    L5:
        r17 = 0.0f;
        goto L6
    }
}
