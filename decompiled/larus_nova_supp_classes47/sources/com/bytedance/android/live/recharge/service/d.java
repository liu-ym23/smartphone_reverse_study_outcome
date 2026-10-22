package com.bytedance.android.live.recharge.service;

import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.scope.o;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements o {
    public final String a;
    public final CompositeDisposable b;
    public String c;
    public final a d;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Predicate {
        public final /* synthetic */ d a;

        public b(d r1) {
            this.a = r1;
        }

        public final boolean test(Object r2) {
            Intrinsics.checkNotNullParameter((UserEvent) r2, "it");
            if (this.a.a().isLogin() == true) goto L5;
        L7:
            return false;
        L5:
            if ((!Intrinsics.areEqual(this.a.a().getCurrentUserId(), this.a.c)) == false) goto L7;
            return true;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ d a;

        public c(d r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            UserEvent r3 = (UserEvent) r2;
            d r4 = this.a;
            r4.c = r4.a().getCurrentUserId();
            ((IRechargeService) com.bytedance.android.live.revenue.core.util.f.a(IRechargeService.class)).rechargeCenter().sync("user_change");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.recharge.service.d$d, reason: collision with other inner class name */
    public static final class RunnableC0075d implements Runnable {
        public final /* synthetic */ d a;

        public RunnableC0075d(d r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d r0 = this.a;     // Catch: Throwable -> L4
            r0.getClass();     // Catch: Throwable -> L4
            vh6.c.b(com.bytedance.android.livesdk.revenue.service.message.b.class).aj(r0.a, r0.d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final com.bytedance.android.livesdk.revenue.service.user.a a() {
        return vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class);
    }

    public final void onStart() {
        ReadOnlyProperty r0 = com.bytedance.android.live.recharge.utils.j.n;
        KProperty[] r1 = com.bytedance.android.live.recharge.utils.j.a;
        if (((Boolean) r0.getValue(null, r1[12])).booleanValue() == true) goto L6;
        RxUtilKt.c(a().m().filter(new b(this)).subscribe(new c(this)), this.b);
    L6:
        if (((com.bytedance.android.live.recharge.utils.b) com.bytedance.android.live.recharge.utils.j.m.getValue(null, r1[11])).b() == false) goto L9;
        i0.c().postDelayed(new RunnableC0075d(this), 10000);
        return;
    }

    public final void onStop() {
        this.b.clear();
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.message.b.class).bf(this.a);
    }

    public d() {
        this.a = MessageType.LIVE_DIAMOND_SCORE_MESSAGE.getWsMethod();
        ((IRechargeService) com.bytedance.android.live.revenue.core.util.f.a(IRechargeService.class)).rechargeCenter();
        this.b = new CompositeDisposable();
        this.c = a().getCurrentUserId();
        this.d = new a();
    }
}
