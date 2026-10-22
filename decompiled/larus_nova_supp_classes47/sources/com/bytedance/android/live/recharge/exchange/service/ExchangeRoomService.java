package com.bytedance.android.live.recharge.exchange.service;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.revenue.toolbar.RevToolbarButton;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.kmp.core.KmpEnv;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ExchangeRoomService implements com.bytedance.android.scope.o, yz0.m {
    public final CompositeDisposable a;
    public final int b;
    public kw0.a c;
    public final yz0.k d;
    public final n01.a e;
    public final com.bytedance.android.livesdk.revenue.service.toolbar.f f;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ExchangeRoomService a;

        public a(ExchangeRoomService r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Boolean r2 = (Boolean) r1;
            ExchangeRoomService.a(this.a);
        }
    }

    public final void onStart() {
    }

    @Override // yz0.m
    public final void onViewReady() {
    }

    @Override // yz0.m
    public final void onWidgetLoaded() {
    }

    @Override // yz0.m
    public final void x() {
    }

    public final zr2.c c() {
        return vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).b9(this.d.getDataCenter());
    }

    public final void d() {
        KmpEnv r0 = KmpEnv.a;
        if (KmpEnv.c() == true) goto L9;
        if (KmpEnv.b() == true) goto L9;
        if (com.bytedance.android.live.incentive.exchange.j.a() == true) goto L9;
        return;
    L9:
        if (va0.a.a == true) goto L12;
        ((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().syncExchangeInfo();
    L12:
        if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class).gm() == true) goto L16;
        zv0.f r1 = ((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter();
        RxUtilKt.c(RxUtilKt.n(r1.observeExchangeInfo().startWith(r1.getExchangeInfo()).compose(RxUtil.rxSchedulerHelper()), new ExchangeRoomService$onRoomReadyWithFlavor$1(this)), this.a);
        RxUtilKt.c(this.d.Z2().subscribe(new a(this)), this.a);
        return;
    }

    @Override // yz0.m
    public final void i() {
        kjc.c r0 = new kjc.c();
        if (2 != kjc.a.a()) goto L6;
        kjc.b r1 = r0.a;
        d();
        r1.a = Unit.INSTANCE;
        r0.b = true;
    L6:
        if (3 != kjc.a.a()) goto L8;
        kjc.b r2 = r0.a;
        d();
        r2.a = Unit.INSTANCE;
        r0.b = true;
    L8:
        com.bytedance.android.livesdk.paas.a.a(r0, new ExchangeRoomService$onRoomReady$$inlined$call$lambda$1(this));
        if (r0.b == true) goto L11;
        kjc.b r3 = r0.a;
        r3.a = Unit.INSTANCE;
    L11:
        Object r4 = r0.a.a;
    }

    public final void onStop() {
        this.a.clear();
    }

    public static final void a(ExchangeRoomService r2) {
        r2.getClass();
        s r0 = null;
        if (com.bytedance.android.live.recharge.util.d.d(null) == false) goto L18;
        zr2.a r1 = r2.f.eh();
        if (r1 == null) goto L7;
        r0 = r1.findContainButtonById(r2.b);
    L7:
        if (r0 != null) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L19;
        IRoom r4 = r2.d.getRoom();
        if (r2.e.i3() == false) goto L14;
    L16:
        r2.c().d(RevToolbarButton.CashExchange);
        return;
    L14:
        if (r4.isMediaRoom() == true) goto L16;
        ((zv0.j) com.bytedance.android.live.recharge.core.f.k(RechargeServices.b()).p1(zv0.j.class)).load();
        r2.c().b(RevToolbarButton.CashExchange);
        return;
    L19:
        return;
    L9:
        r3 = false;
        goto L10
    }

    public ExchangeRoomService(yz0.k r2, n01.a r3, com.bytedance.android.livesdk.revenue.service.toolbar.f r4) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        Intrinsics.checkNotNullParameter(r3, "vsService");
        Intrinsics.checkNotNullParameter(r4, "revToolbarRoomService");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.a = new CompositeDisposable();
        this.b = 25;
    }
}
