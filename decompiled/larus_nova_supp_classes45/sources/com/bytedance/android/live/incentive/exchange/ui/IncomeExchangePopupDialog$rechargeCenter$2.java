package com.bytedance.android.live.incentive.exchange.ui;

import com.bytedance.android.live.recharge.IRechargeService;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zv0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lzv0/f;", "kotlin.jvm.PlatformType", "invoke", "()Lzv0/f;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class IncomeExchangePopupDialog$rechargeCenter$2 extends Lambda implements Function0<f> {
    public static final IncomeExchangePopupDialog$rechargeCenter$2 INSTANCE = null;

    static {
        INSTANCE = new IncomeExchangePopupDialog$rechargeCenter$2();
    }

    public IncomeExchangePopupDialog$rechargeCenter$2() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final f m999invoke() {
        IRechargeService r0 = k.f(IRechargeService.class);
        Intrinsics.checkNotNull(r0);
        return r0.rechargeCenter();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m999invoke();
    }
}
