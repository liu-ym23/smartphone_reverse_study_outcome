package com.bytedance.android.live.recharge.exchange.service;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.recharge.exchange.repo.ExchangeStatusRepository;
import com.bytedance.android.live.recharge.platform.business.IExchangeStatusService;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ExchangeStatusService implements com.bytedance.android.scope.o, IExchangeStatusService {
    public final CompositeDisposable a;
    public final Lazy b;

    public final ExchangeStatusRepository a() {
        return (ExchangeStatusRepository) this.b.getValue();
    }

    public final void onStart() {
        RxUtilKt.c(((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).O3(hw0.d.a), this.a);
        RxUtilKt.c(((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).B0("auto_exchange_switch_changed").observeOn(AndroidSchedulers.mainThread()).subscribe(new o(this)), this.a);
    }

    public final void onStop() {
        this.a.clear();
        a().release();
    }

    public ExchangeStatusService() {
        this.a = new CompositeDisposable();
        this.b = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, ExchangeStatusService$mExchangeStatusRepo$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.recharge.platform.business.IExchangeStatusService
    public final int getAutoExchangeStatus() {
        return a().curVal();
    }

    @Override // com.bytedance.android.live.recharge.platform.business.IExchangeStatusService
    public final boolean isExchangeStatusUnsync() {
        return a().isAlreadySync();
    }

    @Override // com.bytedance.android.live.recharge.platform.business.IExchangeStatusService
    public final Observable<Integer> fetchExchangeStatus(int r4) {
        ExchangeStatusRepository r0 = a();
        if ((!r0.isAlreadySync()) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L8;
        return null;
    L8:
        return a().fetchExchangeStatus(r4);
    }

    @Override // com.bytedance.android.live.recharge.platform.business.IExchangeStatusService
    public final void syncExchangeStatus(int r2, boolean r3) {
        a().syncExchangeStatus(r2, r3);
    }
}
