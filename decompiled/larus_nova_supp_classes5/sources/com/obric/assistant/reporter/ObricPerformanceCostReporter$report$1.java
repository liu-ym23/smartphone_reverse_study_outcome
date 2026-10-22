package com.obric.assistant.reporter;

import android.os.SystemClock;
import com.bytedance.apm.ApmAgent;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.reporter.ObricPerformanceCostReporter$report$1", f = "ObricPerformanceCostReporter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricPerformanceCostReporter$report$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $costMs;
    final /* synthetic */ Map<String, String> $extra;
    final /* synthetic */ String $scene;
    final /* synthetic */ String $stage;
    final /* synthetic */ boolean $success;
    private /* synthetic */ Object L$0;
    int label;

    public ObricPerformanceCostReporter$report$1(String r1, String r2, long r3, Map<String, String> r5, boolean r6, Continuation<? super ObricPerformanceCostReporter$report$1> r7) {
        this.$scene = r1;
        this.$stage = r2;
        this.$costMs = r3;
        this.$extra = r5;
        this.$success = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        ObricPerformanceCostReporter$report$1 r8 = new ObricPerformanceCostReporter$report$1(this.$scene, this.$stage, this.$costMs, this.$extra, this.$success, r11);
        r8.L$0 = r10;
        return r8;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L30;
        ResultKt.throwOnFailure(r18);
        CoroutineScope r0 = (CoroutineScope) this.L$0;
        long r2 = SystemClock.elapsedRealtime();
        long r6 = r2 / 1000;
        long r3 = RangesKt.coerceAtLeast(r2 - e.b, 0) / 1000;
        FLogger.a.i("ObricPerformanceCostReporter", "report performance cost, scene=" + this.$scene + ", stage=" + this.$stage + ", costMs=" + this.$costMs + ", deviceUptimeS=" + r6 + ", processUptimeS=" + r3);
        Map<String, String> r1 = this.$extra;
        boolean r4 = this.$success;
        String r12 = this.$stage;
        String r13 = this.$scene;
        long r14 = this.$costMs;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L22
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L22
        if (r4 == false) goto L8;
        int r5 = 1;
    L9:
        r8.put("success", r5);     // Catch: Throwable -> L22
        r8.put("stage", r12);     // Catch: Throwable -> L22
        r8.put("scene", r13);     // Catch: Throwable -> L22
        CoroutineScope r7 = e.a;     // Catch: Throwable -> L22
        Iterator r9 = ((Map) e.c.getValue()).entrySet().iterator();     // Catch: Throwable -> L22
    L11:
        if (r9.hasNext() == false) goto L13;
        Map.Entry r10 = (Map.Entry) r9.next();     // Catch: Throwable -> L22
        r8.put((String) r10.getKey(), (String) r10.getValue());     // Catch: Throwable -> L22
        goto L11
    L13:
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L22
        r11.put("cost_ms", RangesKt.coerceAtLeast(r14, 0));     // Catch: Throwable -> L22
        r11.put("device_uptime_s", r6);     // Catch: Throwable -> L22
        r11.put("process_uptime_s", r3);     // Catch: Throwable -> L22
        if (r1 == null) goto L19;
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L22
        Iterator<Map.Entry<String, String>> r17 = r1.entrySet().iterator();     // Catch: Throwable -> L22
    L17:
        if (r17.hasNext() == false) goto L20;
        Map.Entry<String, String> r19 = r17.next();     // Catch: Throwable -> L22
        r15.put(r19.getKey(), r19.getValue());     // Catch: Throwable -> L22
    L20:
        ApmAgent.monitorEvent("obric_performance_cost", r8, r11, r15);     // Catch: Throwable -> L22
        Object r20 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        String r21 = this.$scene;
        String r22 = this.$stage;
        long r23 = this.$costMs;
        boolean r24 = this.$success;
        Throwable r25 = Result.exceptionOrNull-impl(r20);
        if (r25 == null) goto L28;
        FLogger.a.w("ObricPerformanceCostReporter", "report performance cost failed, scene=" + r21 + ", stage=" + r22 + ", costMs=" + r23 + ", success=" + r24, r25);
    L28:
        return Unit.INSTANCE;
    L19:
        r15 = null;
        goto L20
    L8:
        r5 = 0;
    L22:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L30:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
