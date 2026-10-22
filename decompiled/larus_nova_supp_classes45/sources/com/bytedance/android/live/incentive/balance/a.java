package com.bytedance.android.live.incentive.balance;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.scope.o;
import com.bytedance.live.kmp.core.KmpEnv;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import yz0.k;
import yz0.m;
import zg1.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements o, m {
    public Disposable a;
    public final k b;

    /* JADX INFO: renamed from: com.bytedance.android.live.incentive.balance.a$a, reason: collision with other inner class name */
    public static final class C0198a<T, R> implements Function {
        public static final C0198a a = null;

        static {
            a = new C0198a();
        }

        public C0198a() {
        }

        public final Object apply(Object r2) {
            f0 r3 = (f0) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return Boolean.valueOf(r3.b);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L6;
            a.a(this.a, UpdateReason.OpenGiftPanel);
            return;
        }
    }

    public final void onViewReady() {
    }

    public final void onWidgetLoaded() {
    }

    public final void x() {
    }

    public final void i() {
        update(UpdateReason.EnterRoom);
    }

    public final void onStart() {
        this.a = RxUtilKt.b(this.b.getDataCenter(), "cmd_gift_dialog_switch", false).map(C0198a.a).distinctUntilChanged().subscribe(new b(this));
    }

    public final void onStop() {
        this.a.dispose();
    }

    public a(k r2) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        this.b = r2;
        this.a = Disposables.disposed();
    }

    private final void update(UpdateReason r4) {
        KmpEnv r0 = KmpEnv.a;
        if (KmpEnv.c() == true) goto L5;
    L6:
        qa0.a r1 = qa0.c.b.getService(com.bytedance.android.live.incentive.exchange.c.class);
        Intrinsics.checkNotNull(r1);
        ((com.bytedance.android.live.incentive.exchange.c) r1).i(new e(r4));
        return;
    L5:
        if (((com.bytedance.android.live.incentive.exchange.k) com.bytedance.android.live.incentive.exchange.b.e.getValue(null, com.bytedance.android.live.incentive.exchange.b.a[3])).a() == false) goto L6;
    }

    public static final /* synthetic */ void a(a r0, UpdateReason r1) {
        r0.update(r1);
    }
}
