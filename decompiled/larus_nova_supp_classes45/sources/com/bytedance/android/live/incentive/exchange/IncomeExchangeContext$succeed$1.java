package com.bytedance.android.live.incentive.exchange;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lua0/a;", "", "invoke", "(Lua0/a;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class IncomeExchangeContext$succeed$1 extends Lambda implements Function1<ua0.a, Unit> {
    final /* synthetic */ long $addedDiamonds;
    final /* synthetic */ e this$0;

    public IncomeExchangeContext$succeed$1(e r1, long r2) {
        this.this$0 = r1;
        this.$addedDiamonds = r2;
        super(1);
    }

    public final void invoke(ua0.a r4) {
        Intrinsics.checkNotNullParameter(r4, "$receiver");
        r4.a.put("added_diamonds", Long.valueOf(this.$addedDiamonds));
        r4.a.put("scene", 2);
        Map<String, Object> r0 = r4.a;
        this.this$0.getClass();
        r0.put("exchange_scene", 3);
        Map<String, Object> r5 = r4.a;
        this.this$0.getClass();
        r5.put("is_lack_diamond_dialog", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((ua0.a) r1);
        return Unit.INSTANCE;
    }
}
