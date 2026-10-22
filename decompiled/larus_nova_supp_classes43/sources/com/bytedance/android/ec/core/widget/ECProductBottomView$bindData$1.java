package com.bytedance.android.ec.core.widget;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/widget/price/a;", "it", "", "invoke", "(Lcom/bytedance/android/ec/core/widget/price/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ECProductBottomView$bindData$1 extends Lambda implements Function1<com.bytedance.android.ec.core.widget.price.a, Unit> {
    final /* synthetic */ com.bytedance.android.ec.model.response.u $data;

    public ECProductBottomView$bindData$1(com.bytedance.android.ec.model.response.u r1) {
        this.$data = r1;
        super(1);
    }

    public final void invoke(com.bytedance.android.ec.core.widget.price.a r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        r10.d = Long.valueOf(this.$data.b());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.ec.core.widget.price.a) r1);
        return Unit.INSTANCE;
    }
}
