package com.obric.assistant.performance;

import android.os.Build;
import android.os.Debug;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.performance.ObricMemoryReportServiceImpl$loopReportMemoryInfo$1", f = "ObricMemoryReportServiceImpl.kt", i = {0}, l = {150}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class ObricMemoryReportServiceImpl$loopReportMemoryInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $intervalMs;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ObricMemoryReportServiceImpl this$0;

    public ObricMemoryReportServiceImpl$loopReportMemoryInfo$1(long r1, ObricMemoryReportServiceImpl r3, Continuation<? super ObricMemoryReportServiceImpl$loopReportMemoryInfo$1> r4) {
        this.$intervalMs = r1;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        ObricMemoryReportServiceImpl$loopReportMemoryInfo$1 r0 = new ObricMemoryReportServiceImpl$loopReportMemoryInfo$1(this.$intervalMs, this.this$0, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x003e -> B:21:0x0041). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L9;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L80
        ObricMemoryReportServiceImpl$loopReportMemoryInfo$1 r13 = this;
    L21:
        Debug.MemoryInfo r3 = new Debug.MemoryInfo();     // Catch: Exception -> L80
        Debug.getMemoryInfo(r3);     // Catch: Exception -> L80
        Map<String, String> r4 = r3.getMemoryStats();     // Catch: Exception -> L80
        ObricMemoryReportServiceImpl r5 = r13.this$0;     // Catch: Exception -> L80
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L80
        ObricMemoryReportServiceImpl r7 = r13.this$0;     // Catch: Exception -> L80
        String r9 = r4.get("summary.java-heap");     // Catch: Exception -> L80
        if (r9 == null) goto L26;
        Integer r10 = StringsKt.toIntOrNull(r9);     // Catch: Exception -> L80
        if (r10 == null) goto L26;
        int r11 = r10.intValue();     // Catch: Exception -> L80
    L27:
        r6.put("java_heap", r11);     // Catch: Exception -> L80
        String r14 = r4.get("summary.native-heap");     // Catch: Exception -> L80
        if (r14 == null) goto L32;
        Integer r15 = StringsKt.toIntOrNull(r14);     // Catch: Exception -> L80
        if (r15 == null) goto L32;
        int r16 = r15.intValue();     // Catch: Exception -> L80
    L33:
        r6.put("native_heap", r16);     // Catch: Exception -> L80
        String r17 = r4.get("summary.code");     // Catch: Exception -> L80
        if (r17 == null) goto L38;
        Integer r18 = StringsKt.toIntOrNull(r17);     // Catch: Exception -> L80
        if (r18 == null) goto L38;
        int r19 = r18.intValue();     // Catch: Exception -> L80
    L39:
        r6.put("code", r19);     // Catch: Exception -> L80
        String r20 = r4.get("summary.stack");     // Catch: Exception -> L80
        if (r20 == null) goto L44;
        Integer r21 = StringsKt.toIntOrNull(r20);     // Catch: Exception -> L80
        if (r21 == null) goto L44;
        int r22 = r21.intValue();     // Catch: Exception -> L80
    L45:
        r6.put("stack", r22);     // Catch: Exception -> L80
        String r23 = r4.get("summary.graphics");     // Catch: Exception -> L80
        if (r23 == null) goto L50;
        Integer r24 = StringsKt.toIntOrNull(r23);     // Catch: Exception -> L80
        if (r24 == null) goto L50;
        int r25 = r24.intValue();     // Catch: Exception -> L80
    L51:
        r6.put("graphics", r25);     // Catch: Exception -> L80
        String r26 = r4.get("summary.private-other");     // Catch: Exception -> L80
        if (r26 == null) goto L56;
        Integer r27 = StringsKt.toIntOrNull(r26);     // Catch: Exception -> L80
        if (r27 == null) goto L56;
        int r28 = r27.intValue();     // Catch: Exception -> L80
    L57:
        r6.put("private_other", r28);     // Catch: Exception -> L80
        String r29 = r4.get("summary.system");     // Catch: Exception -> L80
        if (r29 == null) goto L62;
        Integer r30 = StringsKt.toIntOrNull(r29);     // Catch: Exception -> L80
        if (r30 == null) goto L62;
        int r31 = r30.intValue();     // Catch: Exception -> L80
    L63:
        r6.put("system", r31);     // Catch: Exception -> L80
        String r32 = r4.get("summary.total-pss");     // Catch: Exception -> L80
        if (r32 == null) goto L68;
        Integer r33 = StringsKt.toIntOrNull(r32);     // Catch: Exception -> L80
        if (r33 == null) goto L68;
        int r34 = r33.intValue();     // Catch: Exception -> L80
    L69:
        r6.put("total_pss", r34);     // Catch: Exception -> L80
        String r8 = r4.get("summary.total-swap");     // Catch: Exception -> L80
        if (r8 == null) goto L74;
        Integer r35 = StringsKt.toIntOrNull(r8);     // Catch: Exception -> L80
        if (r35 == null) goto L74;
        int r36 = r35.intValue();     // Catch: Exception -> L80
    L75:
        r6.put("total_swap", r36);     // Catch: Exception -> L80
        if (r7.h == false) goto L78;
        r6.put("scene", "background_uptime_5min");     // Catch: Exception -> L80
        r7.h = false;     // Catch: Exception -> L80
    L78:
        Unit r37 = Unit.INSTANCE;     // Catch: Exception -> L80
        ObricMemoryReportServiceImpl.b(r5, "obric_memory_stats_info", r6);     // Catch: Exception -> L80
    L17:
        if (CoroutineScopeKt.isActive(r2) == false) goto L83;
        long r38 = r13.$intervalMs;     // Catch: Exception -> L80
        r13.L$0 = r2;     // Catch: Exception -> L80
        r13.label = 1;     // Catch: Exception -> L80
        if (DelayKt.delay(r38, r13) != r0) goto L21;
        return r0;
    L83:
        return Unit.INSTANCE;
    L74:
        r36 = 0;
    L68:
        r34 = 0;
    L62:
        r31 = 0;
    L56:
        r28 = 0;
    L50:
        r25 = 0;
    L44:
        r22 = 0;
    L38:
        r19 = 0;
    L32:
        r16 = 0;
    L26:
        r11 = 0;
        goto L27
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r12);
        CoroutineScope r110 = (CoroutineScope) this.L$0;
        if (Build.VERSION.SDK_INT < 23) goto L14;
        r2 = r110;
        r13 = this;
        goto L17
    L14:
        return Unit.INSTANCE;
    L80:
        e = move-exception;
        FLogger.a.e("ObricMemoryReportService", "loopReportMemoryInfo error: " + e);
        goto L83
    }
}
