package com.bytedance.android.live.incentive.exchange.ui;

import com.bytedance.android.live.incentive.et.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mz0.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lmz0/o;", "it", "", "invoke", "(Lmz0/o;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class IncomeExchangePopupDialog$logExchangeSuccess$1 extends Lambda implements Function1<o, Unit> {
    final /* synthetic */ long $exchangedDiamond;

    public IncomeExchangePopupDialog$logExchangeSuccess$1(long r1) {
        this.$exchangedDiamond = r1;
        super(1);
    }

    public final void invoke(o r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        b.b(r3, "deal_diamond_num", String.valueOf(this.$exchangedDiamond));
        b.b(r3, "exchange_source", "exchange_popup");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((o) r1);
        return Unit.INSTANCE;
    }
}
