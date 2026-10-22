package com.bytedance.android.live.recharge.exchange.service;

import com.bytedance.android.live.recharge.exchange.view.ExchangeConfirmDefaultView;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements ExchangeConfirmDefaultView.a {
    public final /* synthetic */ Ref.BooleanRef a;

    public c(Ref.BooleanRef r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.recharge.exchange.view.ExchangeConfirmDefaultView.a
    public final void a(boolean r5) {
        lw0.a.c.setValue(null, lw0.a.a[1], Boolean.FALSE);
        this.a.element = r5;
        xs2.b.a().post(new cx0.a(Boolean.valueOf(r5)));
    }
}
