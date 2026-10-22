package com.obric.oui.dialog.base;

import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/oui/animation/easy/ViewPropertySpringAnimator;", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class AbstractDialogModal$performEnterAnimation$1$3 extends Lambda implements Function1<com.obric.oui.animation.easy.b<View>, Unit> {
    final /* synthetic */ AbstractDialogModal this$0;

    AbstractDialogModal$performEnterAnimation$1$3(AbstractDialogModal r1) {
        this.this$0 = r1;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(com.obric.oui.animation.easy.b<View> r3) {
        invoke2((com.obric.oui.animation.easy.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.easy.b.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.obric.oui.animation.easy.b<View> r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        this.this$0.d();
    }
}
