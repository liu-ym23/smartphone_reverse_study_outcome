package com.obric.common.oea.style.scene.qsanim.pulldown;

import android.view.View;
import com.obric.common.oea.style.scene.qsanim.a.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "child", "Landroid/view/View;", "vc", "Lcom/obric/common/oea/style/scene/qsanim/pulldown/QSAnimConfig;", "invoke"}, k = 3, mv = {1, 4, 3})
final class AbstractQSPullDownAnimHelper$stretchChildViews$1 extends Lambda implements Function3<String, View, b, Unit> {
    final /* synthetic */ float $dragDistance;
    final /* synthetic */ AbstractQSPullDownAnimHelper this$0;

    AbstractQSPullDownAnimHelper$stretchChildViews$1(AbstractQSPullDownAnimHelper r1, float r2) {
        this.this$0 = r1;
        this.$dragDistance = r2;
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Unit invoke(String r3, View r4, b r5) {
        invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"), (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r2, View r3, b r4) {
        Intrinsics.checkNotNullParameter(r2, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(r3, "child");
        Intrinsics.checkNotNullParameter(r4, "vc");
        r3.setTranslationY(r3.getTranslationY() + (((((Number) ZeusTransformUtils.preCheckCast(d.f7832a.a(r3, this.this$0.a()).getSecond(), Number.class, "com.obric.memorydata.plugin")).floatValue() + (r3.getHeight() / 2.0f)) * this.$dragDistance) * 5.0E-5f));
    }
}
