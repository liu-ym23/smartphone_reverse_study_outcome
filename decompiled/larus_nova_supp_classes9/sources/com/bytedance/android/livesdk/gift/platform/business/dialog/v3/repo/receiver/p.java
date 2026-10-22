package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import com.bytedance.android.live.utils.LiveEmptyObserverKt;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ GiftReceiverRepoService a;

    public p(GiftReceiverRepoService r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Boolean r3 = (Boolean) r2;
        GiftReceiverRepoService r4 = this.a;
        if (GiftReceiverRepoService.q == false) goto L5;
        r4.getClass();
        boolean r5 = GiftReceiverRepoService.r;
    L6:
        if (r5 == false) goto L9;
        int r6 = com.bytedance.revenue.platform.api.core.rx.q.a;
        final Function0<Unit> r7 = new GiftReceiverRepoService$initTicketUpdateObservable$disposable$1$1(this);
        Single r8 = Single.fromCallable(new o(r7));
        int r0 = com.bytedance.revenue.platform.api.core.rx.p.a;
        r8.subscribeOn(Schedulers.io()).subscribe(new LiveEmptyObserverKt());
        return;
    L9:
        return;
    L5:
        r5 = r4.f;
        goto L6
    }
}
