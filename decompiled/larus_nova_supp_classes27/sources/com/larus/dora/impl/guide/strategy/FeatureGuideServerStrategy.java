package com.larus.dora.impl.guide.strategy;

import com.larus.dora.impl.util.b0;
import java.util.Calendar;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class FeatureGuideServerStrategy {
    public final Function1<Continuation<? super Result<Boolean>>, Object> a;
    public final String b;
    public final boolean c;
    public final String d;

    public final Object a(Continuation<? super Boolean> r13) {
        if ((r13 instanceof FeatureGuideServerStrategy$isConditionMet$1) == false) goto L7;
        FeatureGuideServerStrategy$isConditionMet$1 r1 = (FeatureGuideServerStrategy$isConditionMet$1) r13;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r14 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        boolean r5 = false;
        if (r4 == 0) goto L15;
        if (r4 != 1) goto L14;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L45
    L39:
        Object r15 = ((Result) r14).unbox-impl();     // Catch: Throwable -> L45
        Throwable r6 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L45
        if (r6 == null) goto L43;
        g49.d.c(this.b, "FeatureGuideServerStrategy remote failed: " + r6.getMessage(), r6);     // Catch: Throwable -> L45
        r15 = Boxing.boxBoolean(false);     // Catch: Throwable -> L45
    L43:
        r5 = ((Boolean) r15).booleanValue();     // Catch: Throwable -> L45
    L48:
        if (this.c == false) goto L55;
        if (r5 == false) goto L55;
        b0.a.getClass();     // Catch: Exception -> L52
        b0.j().storeLong(this.d, System.currentTimeMillis());     // Catch: Exception -> L52
    L52:
        e = move-exception;
        g49.d.c(this.b, "FeatureGuideServerStrategy store keva failed: " + e.getMessage(), e);
    L55:
        return Boxing.boxBoolean(r5);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r14);
        g49.d.d(this.b, "FeatureGuideServerStrategy.isConditionMet() start");
        if (this.c == false) goto L36;
        long r7 = -1;
        b0.a.getClass();     // Catch: Exception -> L20
        r7 = b0.j().getLong(this.d, -1);     // Catch: Exception -> L20
    L22:
        long r8 = System.currentTimeMillis();
        if (r7 > 0) goto L25;
    L32:
        boolean r16 = false;
    L33:
        if (r16 == false) goto L36;
        g49.d.d(this.b, "FeatureGuideServerStrategy skipped due to daily limit: key=" + this.d);
        return Boxing.boxBoolean(false);
    L25:
        if (r8 <= 0) goto L32;
        Calendar r17 = Calendar.getInstance();
        r17.setTimeInMillis(r7);
        Calendar r9 = Calendar.getInstance();
        r9.setTimeInMillis(r8);
        if (r17.get(1) != r9.get(1)) goto L32;
        if (r17.get(6) != r9.get(6)) goto L32;
        r16 = true;
    L20:
        e = move-exception;
        g49.d.c(this.b, "FeatureGuideServerStrategy read keva failed: " + e.getMessage(), e);
    L36:
        Function1<Continuation<? super Result<Boolean>>, Object> r18 = this.a;     // Catch: Throwable -> L45
        r1.label = 1;     // Catch: Throwable -> L45
        r14 = r18.invoke(r1);     // Catch: Throwable -> L45
        if (r14 != r3) goto L39;
        return r3;
    L45:
        th = move-exception;
        g49.d.c(this.b, "FeatureGuideServerStrategy exception: " + th.getMessage(), th);
    L7:
        r1 = new FeatureGuideServerStrategy$isConditionMet$1(this, r13);
        goto L8
    }

    public FeatureGuideServerStrategy(Function1<? super Continuation<? super Result<Boolean>>, ? extends Object> r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "remoteChecker");
        Intrinsics.checkNotNullParameter(r3, "tag");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = "dora_guide_server_limit_".concat(r3);
    }
}
