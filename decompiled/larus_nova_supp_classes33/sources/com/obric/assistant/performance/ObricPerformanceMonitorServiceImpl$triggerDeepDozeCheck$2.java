package com.obric.assistant.performance;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.ObricMemoryMonitorConfig;
import com.obric.assistant.ObricPerformanceMonitorConfig;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.performance.ObricPerformanceMonitorServiceImpl$triggerDeepDozeCheck$2", f = "ObricPerformanceMonitorServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricPerformanceMonitorServiceImpl$triggerDeepDozeCheck$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricPerformanceMonitorServiceImpl this$0;

    public ObricPerformanceMonitorServiceImpl$triggerDeepDozeCheck$2(ObricPerformanceMonitorServiceImpl r1, Continuation<? super ObricPerformanceMonitorServiceImpl$triggerDeepDozeCheck$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricPerformanceMonitorServiceImpl$triggerDeepDozeCheck$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L34;
        ResultKt.throwOnFailure(r12);
        ObricPerformanceMonitorServiceImpl r13 = this.this$0;     // Catch: Exception -> L29
        r13.getClass();     // Catch: Exception -> L29
        r13.f = ObricPerformanceMonitorServiceImpl.e();     // Catch: Exception -> L29
        if (c.b() == true) goto L13;
        Lazy r14 = ObricSettingsChangeMonitor.a;     // Catch: Exception -> L29
        if (ObricSettingsChangeMonitor.b == true) goto L10;
    L14:
        long r3 = System.currentTimeMillis();     // Catch: Exception -> L29
        boolean r15 = h.a;     // Catch: Exception -> L29
        long r5 = h.c;     // Catch: Exception -> L29
        ObricPerformanceMonitorConfig r16 = this.this$0.g;     // Catch: Exception -> L29
        if (r16 == null) goto L19;
        ObricMemoryMonitorConfig r17 = r16.getMemoryMonitorConfig();     // Catch: Exception -> L29
        if (r17 == null) goto L19;
        long r7 = r17.getKillTimeThresholdMinutes() * 60000;     // Catch: Exception -> L29
    L20:
        FLogger r18 = FLogger.a;     // Catch: Exception -> L29
        r18.i("ObricPerformanceMonitor", "tryStartPerformanceCheck, currentTime = " + r3 + ", lastOptTime = " + r5 + ", timeIntervalInMillis = " + r7 + ", dozeMode = " + this.this$0.f);     // Catch: Exception -> L29
        if ((r3 - r5) >= r7) goto L25;
        if (r3 < r5) goto L25;
    L27:
        r18.i("ObricPerformanceMonitor", "do not trigger performance check, dozeMode = " + this.this$0.f);     // Catch: Exception -> L29
    L32:
        return Unit.INSTANCE;
    L25:
        if (this.this$0.f != DozeMode.DOZE_DEEP) goto L27;
        r18.i("ObricPerformanceMonitor", "trigger performance check");     // Catch: Exception -> L29
        ObricPerformanceMonitorServiceImpl.b(this.this$0);     // Catch: Exception -> L29
    L19:
        r7 = 0;
        goto L20
    L10:
        if (ObricSettingsChangeMonitor.c != SettingsChangeMonitorTiming.TIMING_DEEP_DOZE) goto L14;
        FLogger.a.i("ObricPerformanceMonitor", "onDeepDozeEnter: begin check settings version change");     // Catch: Exception -> L29
        ObricSettingsChangeMonitor.b();     // Catch: Exception -> L29
        goto L14
    L13:
        FLogger.a.i("ObricPerformanceMonitor", "assistant active, skip deep doze settings check");     // Catch: Exception -> L29
    L29:
        e = move-exception;
        FLogger.a.e("ObricPerformanceMonitor", "triggerDeepDozeCheck, e=" + e);
        goto L32
    L34:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
