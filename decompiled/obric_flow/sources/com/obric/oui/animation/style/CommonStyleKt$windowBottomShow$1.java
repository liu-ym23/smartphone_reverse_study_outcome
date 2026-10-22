package com.obric.oui.animation.style;

import com.obric.oui.animation.easy.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/obric/oui/animation/easy/a;", "", "invoke", "(Lcom/obric/oui/animation/easy/a;)V", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class CommonStyleKt$windowBottomShow$1 extends Lambda implements Function1<a, Unit> {
    final /* synthetic */ Ref.IntRef $initOffset;

    public CommonStyleKt$windowBottomShow$1(Ref.IntRef r5) {
        this.$initOffset = r5;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(a r5) {
        invoke2(r5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(a r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$translationY");
        r5.e = true;
        r5.g = 1.0f;
        r5.f11937h = true;
        r5.f11939j = 480.0f;
        float r10 = this.$initOffset.element;
        r5.f11935b = true;
        r5.f11936c = r10;
    }
}
