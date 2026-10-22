package com.larus.suggest.impl.wcb.request;

import com.larus.suggest.impl.wcb.policy.a0;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class WcbRequestExecutionRunner {
    public final a a;

    public WcbRequestExecutionRunner(a r2) {
        Intrinsics.checkNotNullParameter(r2, "inputStateTracker");
        this.a = r2;
    }

    public final Deferred<e> b(f r16, long r17) {
        if (r16.f.b != WcbRequestTrigger.FOREGROUND) goto L5;
        this.a.c = true;
    L5:
        b r0 = b.a;
        Intrinsics.checkNotNullParameter(r16, "snapshot");
        b.a r7 = b.c(r16);
        Map<b.a, Deferred<e>> r8 = b.c;
        Deferred<e> r1 = (Deferred) ((LinkedHashMap) r8).get(r7);
        if (r1 == null) goto L8;
        FLogger.a.d("WcbLog", "[network] reuse inFlight scene=" + r7.d + " requestScene=" + r7.e + " exec=" + r16.e);
        return r1;
    L8:
        Deferred<e> r2 = BuildersKt.async$default(b.b, null, CoroutineStart.LAZY, new WcbNetworkRequester$request$task$1(r16, r17, r7, null), 1, null);
        r8.put(r7, r2);
        r2.start();
        return r2;
    }

    public final Object a(f r7, a0 r8, long r9, Function2<? super g, ? super Continuation<? super Unit>, ? extends Object> r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof WcbRequestExecutionRunner$run$1) == false) goto L7;
        WcbRequestExecutionRunner$run$1 r0 = (WcbRequestExecutionRunner$run$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r0.label) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r13);
    L48:
        return Unit.INSTANCE;
    L13:
        WcbRequestExecutionRunner r10 = (WcbRequestExecutionRunner) r0.L$1;
        Function2<? super g, ? super Continuation<? super Unit>, ? extends Object> r14 = (Function2) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L44:
        r10.getClass();
        g r15 = new g((e) r13, WcbTransportSource.NETWORK, true);
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 6;
        if (r14.invoke(r15, r0) != r2) goto L48;
        return r2;
    L14:
        Deferred<e> r16 = (Deferred) r0.L$1;
        r11 = (Function2) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L40:
        r0.L$0 = r11;
        r0.L$1 = this;
        r0.label = 5;
        r13 = r16.await(r0);
        if (r13 != r2) goto L43;
        return r2;
    L43:
        r10 = this;
        r14 = r11;
        goto L44
    L15:
        ResultKt.throwOnFailure(r13);
    L34:
        return Unit.INSTANCE;
    L16:
        r11 = (Function2) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L30:
        g r17 = new g((e) r13, WcbTransportSource.NETWORK, false);
        r0.L$0 = null;
        r0.label = 3;
        if (r11.invoke(r17, r0) != r2) goto L34;
        return r2;
    L17:
        ResultKt.throwOnFailure(r13);
    L24:
        return Unit.INSTANCE;
    L18:
        ResultKt.throwOnFailure(r13);
        if ((r8 instanceof a0.a) == false) goto L26;
        g r18 = new g(new e.c(((a0.a) r8).a), WcbTransportSource.CACHE, false);
        r0.label = 1;
        if (r11.invoke(r18, r0) != r2) goto L24;
        return r2;
    L26:
        if (Intrinsics.areEqual(r8, a0.c.a) == false) goto L36;
        Deferred<e> r19 = b(r7, r9);
        r0.L$0 = r11;
        r0.label = 2;
        r13 = r19.await(r0);
        if (r13 != r2) goto L30;
        return r2;
    L36:
        if ((r8 instanceof a0.b) == false) goto L50;
        r16 = b(r7, r9);
        g r20 = new g(new e.c(((a0.b) r8).a), WcbTransportSource.CACHE, false);
        r0.L$0 = r11;
        r0.L$1 = r16;
        r0.label = 4;
        if (r11.invoke(r20, r0) != r2) goto L40;
        return r2;
    L50:
        if ((r8 instanceof a0.d) == false) goto L54;
        return Unit.INSTANCE;
    L54:
        throw new NoWhenBranchMatchedException();
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r0 = new WcbRequestExecutionRunner$run$1(this, r12);
        goto L8
    }
}
