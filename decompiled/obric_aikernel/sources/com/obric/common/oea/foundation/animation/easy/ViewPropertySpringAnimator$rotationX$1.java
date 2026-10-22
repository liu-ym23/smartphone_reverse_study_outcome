package com.obric.common.oea.foundation.animation.easy;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "T", "Lcom/obric/common/oea/foundation/animation/easy/a;", "", "invoke", "(Lcom/obric/common/oea/foundation/animation/easy/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ViewPropertySpringAnimator$rotationX$1 extends Lambda implements Function1<a, Unit> {
    public static final ViewPropertySpringAnimator$rotationX$1 INSTANCE = null;

    static {
        INSTANCE = new ViewPropertySpringAnimator$rotationX$1();
    }

    ViewPropertySpringAnimator$rotationX$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(a r10) {
        invoke2(r10);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(a r10) {
        Intrinsics.checkNotNullParameter(r10, "$receiver");
    }
}
