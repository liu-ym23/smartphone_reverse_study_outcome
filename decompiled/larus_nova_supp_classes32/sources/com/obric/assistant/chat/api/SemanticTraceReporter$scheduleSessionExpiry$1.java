package com.obric.assistant.chat.api;

import com.obric.aivoice.core.data.NameKeys;
import java.util.LinkedHashMap;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.chat.api.SemanticTraceReporter$scheduleSessionExpiry$1", f = "SemanticTraceReporter.kt", i = {}, l = {468}, m = "invokeSuspend", n = {}, s = {})
final class SemanticTraceReporter$scheduleSessionExpiry$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $traceKey;
    int label;

    public SemanticTraceReporter$scheduleSessionExpiry$1(String r1, Continuation<? super SemanticTraceReporter$scheduleSessionExpiry$1> r2) {
        this.$traceKey = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new SemanticTraceReporter$scheduleSessionExpiry$1(this.$traceKey, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r4 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        long r2 = System.currentTimeMillis();
        Object r11 = f.b;
        String r5 = this.$traceKey;
        monitor-enter(r11);
        f.a r6 = (f.a) ((LinkedHashMap) f.f).get(r5);     // Catch: Throwable -> L29
        if (r6 != null) goto L16;
    L26:
        monitor-exit(r11);
        return Unit.INSTANCE;
    L16:
        if (r6.l == false) goto L18;
    L20:
        r4 = false;
    L21:
        if (r4 == true) goto L24;
        r6 = null;
    L24:
        if (r6 == null) goto L26;
        CoroutineScope r3 = f.a;     // Catch: Throwable -> L29
        f.m(r6, r2);     // Catch: Throwable -> L29
        goto L26
    L18:
        if ((r2 - r6.d) < 1800000) goto L20;
    L29:
        th = move-exception;
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        this.label = 1;
        if (DelayKt.delay(1800000, this) != r0) goto L11;
        return r0;
    }
}
