package com.larus.basic.experience.downgrade.impl.strategy;

import com.larus.platform.model.downgrade.DelayDowngradeStrategyConfig;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class DelayDowngradeStrategy<T> implements c<T> {
    public final DelayDowngradeStrategyConfig a;
    public final int b;
    public final int c;

    public static final class a {
    }

    static {
    }

    public final Map<String, List<String>> a() {
        return this.a.getBodyMatchers();
    }

    public final Map<String, List<String>> b() {
        return this.a.getQueryMatchers();
    }

    public final Map<String, List<String>> f() {
        return this.a.getExtraMatchers();
    }

    public final int d() {
        return this.b;
    }

    public final int g() {
        return this.c;
    }

    public DelayDowngradeStrategy(DelayDowngradeStrategyConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.a = r2;
        this.b = 90;
        this.c = -1;
    }

    public final Pair c(b r1, com.larus.network.http.a r2) {
        return TuplesKt.to(r1, r2);
    }

    public final Object e(b<T> r20, Continuation<? super b<T>> r21) {
        b<T> r1 = r20;
        if ((r21 instanceof DelayDowngradeStrategy$preProcess$1) == false) goto L7;
        DelayDowngradeStrategy$preProcess$1 r3 = (DelayDowngradeStrategy$preProcess$1) r21;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        r1 = (b) r3.L$0;
        ResultKt.throwOnFailure(r2);
        String r7 = "DelayDowngradeStrategy";
    L30:
        FLogger.a.i(r7, "preProcess delay done, path = " + r1.a);
    L32:
        return r1;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        Pair r8 = c.a.a(this, r1, true);
        boolean r9 = ((Boolean) r8.component1()).booleanValue();
        String r10 = (String) r8.component2();
        FLogger r11 = FLogger.a;
        r11.i("DelayDowngradeStrategy", "preProcess, path = " + r1.a + ", matched = " + r9 + ", reason = " + r10);
        if (r9 == true) goto L17;
        return r1;
    L17:
        long r13 = 0;
        long r12 = RangesKt.coerceAtLeast(this.a.getBaseDelayMs(), 0);
        r7 = "DelayDowngradeStrategy";
        long r14 = RangesKt.coerceAtLeast(this.a.getJitterMs(), 0);
        if (r14 <= 0) goto L21;
        r13 = Random.Default.nextLong(r14);
    L21:
        long r15 = r12 + r13;
        Map r16 = r1.h;
        if (r16 == null) goto L26;
        String r0 = (String) r16.put("delay", String.valueOf(r15));
    L26:
        if (r15 <= 0) goto L31;
        r11.i(r7, "preProcess, path = " + r1.a + ", delay = " + r15 + "ms (base=" + r12 + ", jitter=" + r13 + '/' + r14 + ')');
        r3.L$0 = r1;
        r3.label = 1;
        if (DelayKt.delay(r15, r3) != r5) goto L30;
        return r5;
    L31:
        r11.i(r7, "preProcess, path = " + r1.a + ", delay skipped");
    L7:
        r3 = new DelayDowngradeStrategy$preProcess$1(this, r21);
        goto L8
    }
}
