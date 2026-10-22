package com.larus.dora.impl.file;

import com.bytedance.dora.file.DoraInterruptLogFileReason;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.larus.dora.impl.file.DoraFileFetchManager$cancel$1", f = "DoraFileFetchManager.kt", i = {}, l = {297}, m = "invokeSuspend", n = {}, s = {})
final class DoraFileFetchManager$cancel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraFileFetchTask $task;
    final /* synthetic */ String $taskId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DoraFileFetchManager this$0;

    public DoraFileFetchManager$cancel$1(DoraFileFetchManager r1, DoraFileFetchTask r2, String r3, Continuation<? super DoraFileFetchManager$cancel$1> r4) {
        this.this$0 = r1;
        this.$task = r2;
        this.$taskId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        DoraFileFetchManager$cancel$1 r0 = new DoraFileFetchManager$cancel$1(this.this$0, this.$task, this.$taskId, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L18
    L16:
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        String r2 = this.$taskId;
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L24;
        g49.d.c("DoraFileFetchManager", "cancel: remote cancel failed for taskId=" + r2, r8);
    L24:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        g49.d.a("DoraFileFetchManager", "cancel: notify remote cancel");
        DoraFileFetchManager r10 = this.this$0;
        DoraFileFetchTask r3 = this.$task;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L18
        v r11 = r10.c;     // Catch: Throwable -> L18
        String r5 = r3.getFileName();     // Catch: Throwable -> L18
        if (r5 != null) goto L13;
        r5 = "";
    L13:
        DoraInterruptLogFileReason r12 = DoraInterruptLogFileReason.INTERRUPT_BY_BUSY_NOTIFY;     // Catch: Throwable -> L18
        this.label = 1;     // Catch: Throwable -> L18
        if (r11.a(r5, r12, this) != r0) goto L16;
        return r0;
    L18:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }
}
