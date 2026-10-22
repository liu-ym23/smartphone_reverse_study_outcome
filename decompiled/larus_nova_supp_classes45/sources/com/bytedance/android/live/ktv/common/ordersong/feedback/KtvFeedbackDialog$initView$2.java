package com.bytedance.android.live.ktv.common.ordersong.feedback;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0015\u0010\u0007\u001a\u00110\b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0015\u0010\n\u001a\u00110\u000b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f¢\u0006\u0002\b\r"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "select", "p2", "", "issue", "p3", "", "index", "invoke"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvFeedbackDialog$initView$2 extends FunctionReferenceImpl implements Function3<Boolean, String, Integer, Unit> {
    public KtvFeedbackDialog$initView$2(KtvFeedbackDialog r8) {
        super(3, r8, KtvFeedbackDialog.class, "onSubItemSelected", "onSubItemSelected(ZLjava/lang/String;I)V", 0);
    }

    public final void invoke(boolean r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "p2");
        KtvFeedbackDialog r4 = (KtvFeedbackDialog) ((CallableReference) this).receiver;
        if (r1 == false) goto L5;
        r4.m = r2;
    L6:
        r4.Z90();
        return;
    L5:
        r4.m = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke(((Boolean) r1).booleanValue(), (String) r2, ((Number) r3).intValue());
        return Unit.INSTANCE;
    }
}
