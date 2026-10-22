package com.larus.ugc.perf.impl;

import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ugc.perf.impl.BasePerfMonitor$cleanUpExpiredTrackers$1", f = "BasePerfMonitor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BasePerfMonitor$cleanUpExpiredTrackers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public BasePerfMonitor$cleanUpExpiredTrackers$1(Continuation<? super BasePerfMonitor$cleanUpExpiredTrackers$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new BasePerfMonitor$cleanUpExpiredTrackers$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r7);
        ConcurrentHashMap<String, g> r8 = c.b;
        if (r8.size() < 50) goto L7;
        Iterator<Map.Entry<String, g>> r9 = r8.entrySet().iterator();
    L10:
        if (r9.hasNext() == false) goto L17;
        Map.Entry<String, g> r0 = r9.next();
        String r1 = r0.getKey();
        long r2 = r0.getValue().a();
        if (r2 <= 0) goto L15;
        if (r2 <= 600000) goto L10;
    L15:
        c.a.getClass();
        c.e(r1);
        goto L10
    L17:
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
