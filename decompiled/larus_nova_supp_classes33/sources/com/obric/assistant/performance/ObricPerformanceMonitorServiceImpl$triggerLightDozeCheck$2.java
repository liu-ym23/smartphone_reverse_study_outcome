package com.obric.assistant.performance;

import com.larus.utils.logger.FLogger;
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
@DebugMetadata(c = "com.obric.assistant.performance.ObricPerformanceMonitorServiceImpl$triggerLightDozeCheck$2", f = "ObricPerformanceMonitorServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricPerformanceMonitorServiceImpl$triggerLightDozeCheck$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricPerformanceMonitorServiceImpl this$0;

    public ObricPerformanceMonitorServiceImpl$triggerLightDozeCheck$2(ObricPerformanceMonitorServiceImpl r1, Continuation<? super ObricPerformanceMonitorServiceImpl$triggerLightDozeCheck$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricPerformanceMonitorServiceImpl$triggerLightDozeCheck$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r5);
        ObricPerformanceMonitorServiceImpl r6 = this.this$0;     // Catch: Exception -> L19
        r6.getClass();     // Catch: Exception -> L19
        r6.f = ObricPerformanceMonitorServiceImpl.e();     // Catch: Exception -> L19
        if (c.b() == true) goto L13;
        Lazy r7 = ObricSettingsChangeMonitor.a;     // Catch: Exception -> L19
        if (ObricSettingsChangeMonitor.b == false) goto L15;
        if (ObricSettingsChangeMonitor.c != SettingsChangeMonitorTiming.TIMING_LIGHT_DOZE) goto L15;
        FLogger.a.i("ObricPerformanceMonitor", "onLightDozeEnter: begin check settings version change");     // Catch: Exception -> L19
        ObricSettingsChangeMonitor.b();     // Catch: Exception -> L19
    L15:
        if (this.this$0.f != DozeMode.DOZE_LIGHT) goto L17;
        FLogger.a.i("ObricPerformanceMonitor", "trigger gc becuase light doze mode, dozeMode = " + this.this$0.f);     // Catch: Exception -> L19
        System.gc();     // Catch: Exception -> L19
    L22:
        return Unit.INSTANCE;
    L17:
        FLogger.a.i("ObricPerformanceMonitor", "do not trigger gc, dozeMode = " + this.this$0.f);     // Catch: Exception -> L19
        goto L22
    L13:
        FLogger.a.i("ObricPerformanceMonitor", "assistant active, skip light doze settings check");     // Catch: Exception -> L19
    L19:
        e = move-exception;
        FLogger.a.e("ObricPerformanceMonitor", "triggerDeepDozeCheck, e=" + e);
        goto L22
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
