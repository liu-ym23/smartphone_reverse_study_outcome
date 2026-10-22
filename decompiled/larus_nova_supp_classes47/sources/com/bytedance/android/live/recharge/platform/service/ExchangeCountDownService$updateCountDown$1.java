package com.bytedance.android.live.recharge.platform.service;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.common.s0;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
final class ExchangeCountDownService$updateCountDown$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $leftTime;
    final /* synthetic */ int $totalTime;
    final /* synthetic */ k this$0;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ExchangeCountDownService$updateCountDown$1 a;

        public a(ExchangeCountDownService$updateCountDown$1 r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            k r0 = this.a.this$0;
            r0.b = (int) (((Long) r6).longValue() / ((long) WebcastRedirectException.UNKNOWN));
            k r7 = this.a.this$0;
            r7.f(r7.b);
        }
    }

    public ExchangeCountDownService$updateCountDown$1(k r1, int r2, int r3) {
        this.this$0 = r1;
        this.$leftTime = r2;
        this.$totalTime = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m283invoke() {
        int r0 = this.$leftTime;
        if (r0 != 0) goto L5;
        return;
    L5:
        if (this.$totalTime == 0) goto L9;
        u0 r1 = u0.f;
        RxUtilKt.c(s0.a(u0.a.a(r0), new u0(WebcastRedirectException.UNKNOWN)).subscribe(new a(this)), this.this$0.a);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m283invoke();
        return Unit.INSTANCE;
    }
}
