package com.obric.common.oea.style.scene.qsanim.pulldown;

import android.view.View;
import com.obric.common.oea.style.scene.qsanim.a.c;
import com.obric.common.oea.style.scene.qsanim.a.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "child", "Landroid/view/View;", "<anonymous parameter 2>", "Lcom/obric/common/oea/style/scene/qsanim/pulldown/QSAnimConfig;", "invoke"}, k = 3, mv = {1, 4, 3})
final class AbstractQSPullDownAnimHelper$playOpenAnim$1 extends Lambda implements Function3<String, View, b, Unit> {
    final /* synthetic */ AbstractQSPullDownAnimHelper this$0;

    AbstractQSPullDownAnimHelper$playOpenAnim$1(AbstractQSPullDownAnimHelper r1) {
        this.this$0 = r1;
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Unit invoke(String r3, View r4, b r5) {
        invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"), (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r12, final View r13, b r14) {
        Intrinsics.checkNotNullParameter(r12, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(r13, "child");
        Intrinsics.checkNotNullParameter(r14, "<anonymous parameter 2>");
        float r6 = c.f7829a.a((((Number) ZeusTransformUtils.preCheckCast(d.f7832a.a(r13, this.this$0.a()).getSecond(), Number.class, "com.obric.memorydata.plugin")).intValue() * 2.0E-4f) + 0.2f);
        c.a r15 = new c.a(r13.getTranslationY());
        c.a(c.f7829a, r15, c.f7829a.a(), 0.0f, 0.9f, r6, (com.obric.common.oea.foundation.animation.c.b.c) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r13), com.obric.common.oea.foundation.animation.c.b.c.class, "com.obric.memorydata.plugin"), null, 32, null);
        AbstractQSPullDownAnimHelper.a(this.this$0).put(c.f7829a.a(r13, "CHILD_TRANS_Y_PROPERTY"), r15);
    }
}
