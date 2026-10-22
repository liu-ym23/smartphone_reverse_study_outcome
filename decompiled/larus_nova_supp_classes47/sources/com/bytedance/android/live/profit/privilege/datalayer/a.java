package com.bytedance.android.live.profit.privilege.datalayer;

import android.content.Context;
import com.bytedance.android.live.profit.privilege.model.danmu.PrivilegeBarrageResponse;
import com.bytedance.android.live.profit.privilege.model.danmu.SendPrivilegeBarrageArgs;
import com.bytedance.android.live.recharge.model.ExchangeType;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.SingleSubject;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements com.bytedance.android.scope.o {
    public final CompositeDisposable a;
    public final d b;

    public final void onStart() {
    }

    public final void onStop() {
        this.a.dispose();
    }

    public a(d r2) {
        Intrinsics.checkNotNullParameter(r2, "repository");
        this.b = r2;
        this.a = new CompositeDisposable();
    }

    public final Single<PrivilegeBarrageResponse> a(final SendPrivilegeBarrageArgs r15) {
        Intrinsics.checkNotNullParameter(r15, "args");
        final d r1 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r15, "args");
        long r2 = r15.getRequiredDiamonds();
        long r4 = r1.k.getAvailableDiamonds();
        yz0.g r0 = r1.j;
        Function0<Single<PrivilegeBarrageResponse>> r6 = new PrivilegeRepository$sendPrivilegeBarrage$1(r1, r15);
        Intrinsics.checkNotNullParameter(r0, "roomDataService");
        Intrinsics.checkNotNullParameter(r6, "performRequest");
        long r10 = r2 - r4;
        if (r10 <= 0) goto L9;
        com.bytedance.android.live.incentive.exchange.c r16 = qa0.c.b.getService(com.bytedance.android.live.incentive.exchange.c.class);
        Intrinsics.checkNotNull(r16);
        com.bytedance.android.live.incentive.exchange.c r17 = r16;
        if (r17.d(r10) == false) goto L7;
        jy0.b.d("PrivilegeRepository", "barrage request is intercepted, diamondDifference = " + r10);
        Context r8 = r0.getContext();
        SingleSubject r3 = SingleSubject.create();
        r17.g(new com.bytedance.android.live.incentive.exchange.l(r8, ExchangeType.EXCHANGE_TYPE_BARRAGE, r10, new yu0.a(r3), null));
        return r3.flatMap(new yu0.b(r6));
    L7:
        jy0.b.d("PrivilegeRepository", "diamond is not enough and request may fail, diamondDifference = " + r10);
        return (Single) r6.invoke();
    L9:
        return (Single) r6.invoke();
    }
}
