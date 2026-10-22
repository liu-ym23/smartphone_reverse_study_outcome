package com.bytedance.android.livesdk.coupon.customview;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class UgCouponGoodsNewDialog$initGoods3$1$5 extends FunctionReferenceImpl implements Function1<View, Unit> {
    public UgCouponGoodsNewDialog$initGoods3$1$5(UgCouponGoodsNewDialog r8) {
        super(1, r8, UgCouponGoodsNewDialog.class, "callOnConfirm", "callOnConfirm(Landroid/view/View;)V", 0);
    }

    public final void invoke(View r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        UgCouponGoodsNewDialog.a((UgCouponGoodsNewDialog) ((CallableReference) this).receiver);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((View) r1);
        return Unit.INSTANCE;
    }
}
