package com.bytedance.android.live.incentive.exchange;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lua0/a;", "", "invoke", "(Lua0/a;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class IncomeExchangeContext$cancel$1 extends Lambda implements Function1<ua0.a, Unit> {
    final /* synthetic */ String $reason;

    public IncomeExchangeContext$cancel$1(String r1) {
        this.$reason = r1;
        super(1);
    }

    public final void invoke(ua0.a r3) {
        Intrinsics.checkNotNullParameter(r3, "$receiver");
        r3.a.put("cancel_reason", this.$reason);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((ua0.a) r1);
        return Unit.INSTANCE;
    }
}
