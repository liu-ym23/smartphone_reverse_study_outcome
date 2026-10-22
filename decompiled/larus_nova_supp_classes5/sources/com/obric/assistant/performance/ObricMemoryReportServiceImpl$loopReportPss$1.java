package com.obric.assistant.performance;

import android.os.Debug;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.performance.ObricMemoryReportServiceImpl$loopReportPss$1", f = "ObricMemoryReportServiceImpl.kt", i = {0}, l = {128}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class ObricMemoryReportServiceImpl$loopReportPss$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $intervalMs;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ObricMemoryReportServiceImpl this$0;

    public ObricMemoryReportServiceImpl$loopReportPss$1(long r1, ObricMemoryReportServiceImpl r3, Continuation<? super ObricMemoryReportServiceImpl$loopReportPss$1> r4) {
        this.$intervalMs = r1;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        ObricMemoryReportServiceImpl$loopReportPss$1 r0 = new ObricMemoryReportServiceImpl$loopReportPss$1(this.$intervalMs, this.this$0, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0035 -> B:16:0x0038). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L9;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L21
        ObricMemoryReportServiceImpl$loopReportPss$1 r12 = this;
    L16:
        long r3 = Debug.getPss();     // Catch: Exception -> L21
        ObricMemoryReportServiceImpl r5 = r12.this$0;     // Catch: Exception -> L21
        JSONObject r7 = new JSONObject();     // Catch: Exception -> L21
        ObricMemoryReportServiceImpl r8 = r12.this$0;     // Catch: Exception -> L21
        r7.put("total_pss", r3);     // Catch: Exception -> L21
        if (r8.g == false) goto L19;
        r7.put("scene", "background_uptime_5min");     // Catch: Exception -> L21
        r8.g = false;     // Catch: Exception -> L21
    L19:
        Unit r4 = Unit.INSTANCE;     // Catch: Exception -> L21
        ObricMemoryReportServiceImpl.b(r5, "obric_memory_total_pss", r7);     // Catch: Exception -> L21
    L12:
        if (CoroutineScopeKt.isActive(r2) == false) goto L24;
        long r6 = r12.$intervalMs;     // Catch: Exception -> L21
        r12.L$0 = r2;     // Catch: Exception -> L21
        r12.label = 1;     // Catch: Exception -> L21
        if (DelayKt.delay(r6, r12) != r0) goto L16;
        return r0;
    L24:
        return Unit.INSTANCE;
    L21:
        e = move-exception;
        FLogger.a.e("ObricMemoryReportService", "loopReportPss error: " + e);
        goto L24
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r11);
        r2 = (CoroutineScope) this.L$0;
        r12 = this;
        goto L12
    }
}
