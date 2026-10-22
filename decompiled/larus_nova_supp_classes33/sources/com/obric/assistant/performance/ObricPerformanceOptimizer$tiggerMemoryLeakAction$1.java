package com.obric.assistant.performance;

import android.os.Process;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.t1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.performance.ObricPerformanceOptimizer$tiggerMemoryLeakAction$1", f = "ObricPerformanceOptimizer.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
final class ObricPerformanceOptimizer$tiggerMemoryLeakAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $jvmMemoryLeak;
    final /* synthetic */ JvmMemoryinfo $jvmMemoryinfo;
    final /* synthetic */ boolean $pssMemoryLeak;
    final /* synthetic */ PssMemoryinfo $pssMemoryinfo;
    int label;

    public ObricPerformanceOptimizer$tiggerMemoryLeakAction$1(boolean r1, boolean r2, JvmMemoryinfo r3, PssMemoryinfo r4, Continuation<? super ObricPerformanceOptimizer$tiggerMemoryLeakAction$1> r5) {
        this.$jvmMemoryLeak = r1;
        this.$pssMemoryLeak = r2;
        this.$jvmMemoryinfo = r3;
        this.$pssMemoryinfo = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ObricPerformanceOptimizer$tiggerMemoryLeakAction$1(this.$jvmMemoryLeak, this.$pssMemoryLeak, this.$jvmMemoryinfo, this.$pssMemoryinfo, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L23:
        boolean r12 = h.a;
        h.c = System.currentTimeMillis();
        t1.a.o(h.c);
        if (h.b != MemoryLeakOptimizationAction.KILL_PROCESS) goto L27;
        FLogger.a.i("ObricPerformanceMonitor", "doMemoryLeakAction: kill self process, pid=" + Process.myPid());
        Process.killProcess(Process.myPid());
    L27:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        boolean r13 = h.a;
        boolean r14 = this.$jvmMemoryLeak;
        boolean r2 = this.$pssMemoryLeak;
        JvmMemoryinfo r4 = this.$jvmMemoryinfo;
        PssMemoryinfo r5 = this.$pssMemoryinfo;
        if (r14 == true) goto L11;
        if (r2 == true) goto L11;
    L20:
        this.label = 1;
        if (DelayKt.delay(1000, this) != r0) goto L23;
        return r0;
    L11:
        if (r14 == false) goto L14;
        if (r2 == false) goto L14;
        String r6 = "both_leak";
    L19:
        FLogger.a.i("ObricPerformanceMonitor", "reportMemoryLeak, jvmMemoryLeak=" + r14 + ", pssMemoryLeak=" + r2 + ", jvmMemoryinfo=" + r4 + ", pssMemoryinfo=" + r5);
        JSONObject r15 = new JSONObject();
        r15.put(WindowEvent.Params.REASON, r6);
        r15.put("leak_action", h.b.toString());
        r15.put("pss_leak_threshold", r5.getPssLeakThreshold());
        r15.put("pss_total_memory", r5.getTotalPss());
        r15.put("jvm_leak_threshold", r4.getJvmLeakThreshold());
        r15.put("jvm_max_memory", r4.getJvmMaxMemory());
        r15.put("jvm_used_memory", r4.getJvmUsedMemory());
        r15.put("jvm_total_memory", r4.getJvmTotalMemory());
        o.a.reportEvent("obric_performance_memory_leak", r15);
    L14:
        if (r2 == false) goto L16;
        r6 = "pss_memory_leak";
        goto L19
    L16:
        if (r14 == false) goto L18;
        r6 = "jvm_memory_leak";
        goto L19
    L18:
        r6 = "unknown";
        goto L19
    }
}
