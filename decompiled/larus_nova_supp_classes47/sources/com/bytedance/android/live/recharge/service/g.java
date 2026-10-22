package com.bytedance.android.live.recharge.service;

import com.bytedance.android.live.ai.api.model.RechargeCacheConfig;
import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.deal.DealSetApiDataSource;
import com.bytedance.android.live.recharge.deal.Entrance;
import com.bytedance.android.live.recharge.deal.FetchFrom;
import com.bytedance.android.live.recharge.model.RechargePanelDynamicConfig;
import com.bytedance.android.live.recharge.panel.RechargeBizScene;
import com.bytedance.android.live.recharge.panel.aio.OneStepPayInfo;
import com.bytedance.android.live.recharge.r0;
import com.bytedance.android.live.revenue.common.s0;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.livesdkapi.depend.model.IPrePayCashierInfo;
import com.bytedance.android.scope.o;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import yz0.l;
import yz0.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g implements o, m {
    public final CompositeDisposable a;
    public final RechargeCacheConfig b;
    public boolean c;
    public final l d;

    public static final class a<T> implements Predicate {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final boolean test(Object r2) {
            UserEvent r3 = (UserEvent) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return r3.isLogin();
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r2) {
            UserEvent r3 = (UserEvent) r2;
            ((IRechargeService) com.bytedance.android.live.revenue.core.util.f.a(IRechargeService.class)).rechargeCenter().sync("user_change");
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ g a;

        public c(g r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            Long r12 = (Long) r10;
            g r13 = this.a;
            r13.getClass();
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L13
            String r1 = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId();     // Catch: Throwable -> L13
            HashMap r2 = (HashMap) r0.e.getValue(null, r0.a[3]);     // Catch: Throwable -> L13
            u0 r3 = u0.f;     // Catch: Throwable -> L13
            Long r4 = (Long) r2.get(r1);     // Catch: Throwable -> L13
            if (r4 != null) goto L6;
            r4 = 0L;     // Catch: Throwable -> L13
        L6:
            long r5 = s0.b(new u0(r4.longValue()));     // Catch: Throwable -> L13
            if (r5 >= 0) goto L9;
        L11:
            com.bytedance.android.live.recharge.platform.service.h r6 = com.bytedance.android.live.recharge.core.f.d(RechargeServices.b());     // Catch: Throwable -> L13
            com.bytedance.android.live.recharge.deal.m r7 = new com.bytedance.android.live.recharge.deal.m(0, Entrance.Recharge, FetchFrom.PreFetch);     // Catch: Throwable -> L13
            r6.getClass();     // Catch: Throwable -> L13
            Intrinsics.checkNotNullParameter(r7, "requestParams");     // Catch: Throwable -> L13
            Disposable r8 = DealSetApiDataSource.d(r7).map(new com.bytedance.android.live.recharge.platform.service.d(r6, r7)).map(com.bytedance.android.live.recharge.platform.service.e.a).subscribe(new i(r2, r1), j.a);     // Catch: Throwable -> L13
            RxUtilKt.c(r8, r13.a);     // Catch: Throwable -> L13
            Result.constructor-impl(r8);     // Catch: Throwable -> L13
            return;
        L9:
            if (r5 >= r13.b.getPreFetchGapDay()) goto L11;
            return;
        L13:
            th = move-exception;
            Result.Companion r9 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ g a;

        public d(g r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            com.bytedance.android.live.recharge.deal.i r9 = (com.bytedance.android.live.recharge.deal.i) r8;
            jy0.b.d("RechargeRoomService", "pre fetch deal set");
            if (r9.o() == 0) goto L10;
            IPrePayCashierInfo r10 = r9.n();
            if (r10 != null) goto L7;
            return;
        L7:
            if (r10.getCustomOneStepPay() != OneStepPayInfo.OneStepPayType.ONE_STEP.getType()) goto L12;
            com.bytedance.android.live.recharge.platform.service.h r12 = com.bytedance.android.live.recharge.core.f.d(RechargeServices.b());
            List r1 = CollectionsKt.listOf(0L);
            Map r4 = MapsKt.emptyMap();
            Map r5 = MapsKt.emptyMap();
            RechargeBizScene r6 = RechargeBizScene.SCENE_NORMAL;
            r12.getClass();
            RxUtilKt.c(com.bytedance.android.live.recharge.platform.service.h.E1(r1, "", "", r4, r5, r6).compose(RxUtil.rxSchedulerHelper()).subscribe(h.a), this.a.a);
            return;
        L12:
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r3) {
            jy0.b.b("RechargeRoomService", "pre fetch deal set failed!", (Throwable) r3);
        }
    }

    public final void onStart() {
    }

    @Override // yz0.m
    public final void onViewReady() {
    }

    @Override // yz0.m
    public final void x() {
    }

    @Override // yz0.m
    public final void i() {
        RxUtilKt.c(vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).m().filter(a.a).take(1).subscribe(b.a), this.a);
        if (this.b.getEnablePreFetch() == false) goto L6;
        RxUtilKt.c(RxUtilKt.h(Observable.timer(this.b.getPreFetchDelay(), TimeUnit.MILLISECONDS)).subscribe(new c(this)), this.a);
    L6:
        if (((com.bytedance.android.live.recharge.utils.b) com.bytedance.android.live.recharge.utils.j.m.getValue(null, com.bytedance.android.live.recharge.utils.j.a[11])).b() == false) goto L9;
        l r0 = this.d;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        Observable r1 = yz0.h.a.a(r0, com.bytedance.android.live.revenue.common.message.b.A, false, 6);
        final RechargeRoomService$initMessageManager$1 r2 = new RechargeRoomService$initMessageManager$1(this);
        RxUtilKt.c(r1.subscribe(new k(r2)), this.a);
        return;
    }

    public final void onStop() {
        this.a.clear();
        this.c = false;
    }

    @Override // yz0.m
    public final void onWidgetLoaded() {
        if (this.c == false) goto L5;
        return;
    L5:
        this.c = true;
        com.bytedance.android.live.recharge.deal.a r0 = com.bytedance.android.live.recharge.core.f.c(RechargeServices.b()).o0();
        RechargePanelDynamicConfig r1 = com.bytedance.android.live.recharge.model.g.a;
        if (r1.j1() == true) goto L8;
        return;
    L8:
        if (com.bytedance.android.live.recharge.deal.c.a(r0) == true) goto L18;
        int r2 = r1.e0();
        FetchFrom r3 = FetchFrom.PreFetch;
        if (r2 == r3.getValue()) goto L15;
        FetchFrom r4 = FetchFrom.RechargePanel;
        if (r2 != r4.getValue()) goto L15;
        r3 = r4;
    L15:
        RxUtilKt.c(com.bytedance.android.live.recharge.core.f.c(RechargeServices.b()).c(new com.bytedance.android.live.recharge.deal.m(0, Entrance.Recharge, r3)).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this), e.a), this.a);
        return;
    }

    public g(l r2) {
        Intrinsics.checkNotNullParameter(r2, "roomMessageService");
        this.d = r2;
        this.a = new CompositeDisposable();
        this.b = com.bytedance.android.live.recharge.utils.j.d();
    }
}
