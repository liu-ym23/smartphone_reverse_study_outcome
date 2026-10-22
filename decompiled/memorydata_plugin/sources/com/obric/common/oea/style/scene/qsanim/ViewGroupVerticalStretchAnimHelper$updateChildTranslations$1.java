package com.obric.common.oea.style.scene.qsanim;

import android.view.View;
import android.view.ViewGroup;
import com.obric.common.oea.style.scene.qsanim.a.d;
import com.obric.common.oea.style.scene.qsanim.pulldown.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "childId", "", "child", "Landroid/view/View;", "<anonymous parameter 2>", "Lcom/obric/common/oea/style/scene/qsanim/pulldown/QSAnimConfig;", "invoke"}, k = 3, mv = {1, 4, 3})
final class ViewGroupVerticalStretchAnimHelper$updateChildTranslations$1 extends Lambda implements Function3<String, View, b, Unit> {
    final /* synthetic */ float $dy;
    final /* synthetic */ ViewGroup $viewGroup;
    final /* synthetic */ a this$0;

    ViewGroupVerticalStretchAnimHelper$updateChildTranslations$1(a r1, ViewGroup r2, float r3) {
        this.this$0 = r1;
        this.$viewGroup = r2;
        this.$dy = r3;
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Unit invoke(String r3, View r4, b r5) {
        invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"), (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r4, View r5, b r6) {
        Intrinsics.checkNotNullParameter(r4, "childId");
        Intrinsics.checkNotNullParameter(r5, "child");
        Intrinsics.checkNotNullParameter(r6, "<anonymous parameter 2>");
        float r0 = 0.0f;
        if (a.a(this.this$0).isEmpty() == false) goto L7;
        Float r7 = (Float) ZeusTransformUtils.preCheckCast(a.b(this.this$0).get(r4), Float.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L9;
    L10:
        float r8 = 0.0f;
    L11:
        float r9 = ((Number) ZeusTransformUtils.preCheckCast(d.f7832a.a(r5, this.$viewGroup).getSecond(), Number.class, "com.obric.memorydata.plugin")).floatValue() + (r5.getHeight() / 2.0f);
        if (this.$dy < a.d(this.this$0)) goto L15;
        r0 = ((this.$dy - a.d(this.this$0)) * r9) * a.e(this.this$0);
    L15:
        r5.setTranslationY(r8 + r0);
        return;
    L9:
        r8 = r7.floatValue();
        goto L11
    L7:
        r7 = (Float) ZeusTransformUtils.preCheckCast(a.a(this.this$0).get(r4), Float.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L10;
        goto L9
    }
}
