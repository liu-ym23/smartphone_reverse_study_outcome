package com.larus.dora.impl.file;

import com.bytedance.dora.file.DoraInterruptLogFileReason;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.file.DoraFileStreamingSink$sink$consumer$1$onIncomplete$1", f = "DoraFileStreamingSink.kt", i = {}, l = {208}, m = "invokeSuspend", n = {}, s = {})
final class DoraFileStreamingSink$sink$consumer$1$onIncomplete$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ v $remoteStreamer;
    final /* synthetic */ DoraFileFetchTask $task;
    int label;

    public DoraFileStreamingSink$sink$consumer$1$onIncomplete$1(v r1, DoraFileFetchTask r2, Continuation<? super DoraFileStreamingSink$sink$consumer$1$onIncomplete$1> r3) {
        this.$remoteStreamer = r1;
        this.$task = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraFileStreamingSink$sink$consumer$1$onIncomplete$1(this.$remoteStreamer, this.$task, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L10;
        ResultKt.throwOnFailure(r5);     // Catch: Exception -> L7
    L21:
    L20:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r5);
        v r6 = this.$remoteStreamer;     // Catch: Exception -> L7
        String r2 = this.$task.getFileName();     // Catch: Exception -> L7
        if (r2 != null) goto L15;
        r2 = "";
    L15:
        DoraInterruptLogFileReason r3 = DoraInterruptLogFileReason.FETCH_RETRY_FOR_SEQ_GAP;     // Catch: Exception -> L7
        this.label = 1;     // Catch: Exception -> L7
        if (r6.a(r2, r3, this) != r0) goto L21;
        return r0;
    L7:
        e = move-exception;
        g49.d.c("DoraFileStreamingSink", "interrupt failed", e);
        goto L20
    }
}
