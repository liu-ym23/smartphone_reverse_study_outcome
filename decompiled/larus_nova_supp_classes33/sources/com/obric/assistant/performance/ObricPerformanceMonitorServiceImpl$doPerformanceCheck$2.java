package com.obric.assistant.performance;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.ObricPerformanceMonitorConfig;
import com.obric.assistant.ObricPerformanceOptimizationConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.performance.ObricPerformanceMonitorServiceImpl$doPerformanceCheck$2", f = "ObricPerformanceMonitorServiceImpl.kt", i = {}, l = {211}, m = "invokeSuspend", n = {}, s = {})
final class ObricPerformanceMonitorServiceImpl$doPerformanceCheck$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $jvmLeak;
    final /* synthetic */ JvmMemoryinfo $jvmMemory;
    final /* synthetic */ boolean $pssLeak;
    final /* synthetic */ PssMemoryinfo $pssMemory;
    int label;
    final /* synthetic */ ObricPerformanceMonitorServiceImpl this$0;

    public ObricPerformanceMonitorServiceImpl$doPerformanceCheck$2(ObricPerformanceMonitorServiceImpl r1, boolean r2, boolean r3, JvmMemoryinfo r4, PssMemoryinfo r5, Continuation<? super ObricPerformanceMonitorServiceImpl$doPerformanceCheck$2> r6) {
        this.this$0 = r1;
        this.$jvmLeak = r2;
        this.$pssLeak = r3;
        this.$jvmMemory = r4;
        this.$pssMemory = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ObricPerformanceMonitorServiceImpl$doPerformanceCheck$2(this.this$0, this.$jvmLeak, this.$pssLeak, this.$jvmMemory, this.$pssMemory, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L9;
        if (r2 != 1) goto L8;
        ResultKt.throwOnFailure(r17);     // Catch: Exception -> L28
    L20:
        if (c.b() == false) goto L23;
        FLogger.a.i("ObricPerformanceMonitor", "assistant active, skip performance optimization");     // Catch: Exception -> L28
        return Unit.INSTANCE;
    L23:
        boolean r1 = h.a;     // Catch: Exception -> L28
        boolean r6 = this.$jvmLeak;     // Catch: Exception -> L28
        boolean r7 = this.$pssLeak;     // Catch: Exception -> L28
        JvmMemoryinfo r8 = this.$jvmMemory;     // Catch: Exception -> L28
        PssMemoryinfo r9 = this.$pssMemory;     // Catch: Exception -> L28
        Intrinsics.checkNotNullParameter(r8, "jvmMemoryinfo");     // Catch: Exception -> L28
        Intrinsics.checkNotNullParameter(r9, "pssMemoryinfo");     // Catch: Exception -> L28
        if (h.a == true) goto L26;
        FLogger.a.i("ObricPerformanceMonitor", "tiggerMemoryLeakAction: optimizer not enabled");     // Catch: Exception -> L28
    L31:
        return Unit.INSTANCE;
    L26:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ObricPerformanceOptimizer$tiggerMemoryLeakAction$1(r6, r7, r8, r9, null), 3, null);     // Catch: Exception -> L28
        goto L31
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r17);
        ObricPerformanceMonitorConfig r3 = this.this$0.g;     // Catch: Exception -> L28
        if (r3 == null) goto L15;
        ObricPerformanceOptimizationConfig r4 = r3.getPerformanceOptimizationConfig();     // Catch: Exception -> L28
        if (r4 == null) goto L15;
        long r5 = r4.getMemoryLeakOptimizationDelayInSeconds() * 1000;     // Catch: Exception -> L28
    L16:
        this.label = 1;     // Catch: Exception -> L28
        if (DelayKt.delay(r5, this) != r0) goto L20;
        return r0;
    L15:
        r5 = 0;
    L28:
        e = move-exception;
        FLogger.a.e("ObricPerformanceMonitor", "doPerformanceCheck, e=" + e);
        goto L31
    }
}
