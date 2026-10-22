package com.bytedance.android.live.incentive.exchange;

import com.bytedance.android.live.base.exception.ApiServerException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/incentive/exchange/f;", "p1", "", "invoke", "(Lcom/bytedance/android/live/incentive/exchange/f;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class IncomeExchangeResultAdapter$2 extends FunctionReferenceImpl implements Function1<f, Unit> {
    public IncomeExchangeResultAdapter$2(g r8) {
        super(1, r8, g.class, "onResult", "onResult(Lcom/bytedance/android/live/incentive/exchange/IncomeExchangeResult;)V", 0);
    }

    public final void invoke(f r6) {
        Intrinsics.checkNotNullParameter(r6, "p1");
        ((g) ((CallableReference) this).receiver).getClass();
        int r0 = r6.b;
        boolean r1 = false;
        if (r0 != 0) goto L5;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L9;
        throw null;
    L9:
        if (r0 != 2) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == true) goto L20;
        if (r0 != 1) goto L15;
        r1 = true;
    L15:
        if (r1 == false) goto L18;
        int r2 = r6.e;
        new ApiServerException(r2).setErrorMsg(r6.f);
        throw null;
    L18:
        new IllegalArgumentException("unknown income exchange result " + r6.b);
        throw null;
    L20:
        throw null;
    L11:
        r4 = false;
        goto L12
    L5:
        r3 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((f) r1);
        return Unit.INSTANCE;
    }
}
