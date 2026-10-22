package com.bytedance.android.live.incentive.exchange.strategy;

import com.bytedance.android.live.incentive.exchange.l;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface c {

    public static final class a {
        public final com.bytedance.android.live.incentive.balance.d a;

        public a(com.bytedance.android.live.incentive.balance.d r2, PublishSubject r3) {
            Intrinsics.checkNotNullParameter(r2, "balanceRepository");
            Intrinsics.checkNotNullParameter(r3, "incomeExchangeResult");
            this.a = r2;
        }
    }

    boolean a();

    void b(a r1);

    boolean d(long r1);

    boolean f();

    void g(l r1);
}
