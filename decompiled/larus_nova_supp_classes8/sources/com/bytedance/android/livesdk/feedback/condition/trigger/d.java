package com.bytedance.android.livesdk.feedback.condition.trigger;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.feedback.condition.trigger.base.TriggerId;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import zg1.m2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d extends fx1.d {
    public final TriggerId d;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            m2 r4 = (m2) r3;
            this.a.d("on action：加购", new Pair[0]);
            ALogger.d(this.a.a, "on action：加购");
            d r5 = this.a;
            r5.getClass();
            r5.e(fx1.c.f(2));
        }
    }

    public d() {
        this.d = TriggerId.PURCHASE;
    }

    @Override // fx1.c, fx1.e
    public final void a() {
        super.a();
        c(xs2.b.a().b(m2.class).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this)));
    }

    @Override // fx1.e
    public final TriggerId getId() {
        return this.d;
    }
}
