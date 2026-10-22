package com.larus.dora.impl.imu;

import g49.d;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.imu.DoraImuDataManager$reportCachedLowFreqEvents$1", f = "DoraImuDataManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraImuDataManager$reportCachedLowFreqEvents$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public DoraImuDataManager$reportCachedLowFreqEvents$1(Continuation<? super DoraImuDataManager$reportCachedLowFreqEvents$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraImuDataManager$reportCachedLowFreqEvents$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r6);
        Iterator r7 = CollectionsKt.listOf(new String[]{"sedentary_event", "long_head_down_event", "fall_event", "wearing_event"}).iterator();     // Catch: Exception -> L19
    L6:
        if (r7.hasNext() == false) goto L22;
        String r1 = (String) r7.next();     // Catch: Exception -> L19
        DoraImuDataManager.a.getClass();     // Catch: Exception -> L19
        DoraImuDataManager.a r2 = DoraImuDataManager.j(r1);     // Catch: Exception -> L19
        if (r2 == null) goto L6;
        d.d("DoraImuDataManager", "Report cached low frequency event: " + r2);     // Catch: Exception -> L19
        ConcurrentHashMap<String, ConcurrentLinkedQueue<DoraImuDataManager.a>> r3 = DoraImuDataManager.k;     // Catch: Exception -> L19
        ConcurrentLinkedQueue<DoraImuDataManager.a> r4 = r3.get(r1);     // Catch: Exception -> L19
        if (r4 != null) goto L17;
        r4 = new ConcurrentLinkedQueue();     // Catch: Exception -> L19
        ConcurrentLinkedQueue<DoraImuDataManager.a> r5 = r3.putIfAbsent(r1, r4);     // Catch: Exception -> L19
        if (r5 == null) goto L17;
        r4 = r5;
    L17:
        r4.offer(r2);     // Catch: Exception -> L19
        DoraImuDataManager.k(r1);     // Catch: Exception -> L19
    L22:
        return Unit.INSTANCE;
    L19:
        e = move-exception;
        d.c("DoraImuDataManager", "Report cached low frequency events exception", e);
        goto L22
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
