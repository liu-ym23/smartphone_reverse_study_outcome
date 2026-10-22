package com.bytedance.ai.applet.moa;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.moa.MoaGrantingManager$startExecution$1", f = "MoaGrantingManager.kt", i = {}, l = {413}, m = "invokeSuspend", n = {}, s = {})
final class MoaGrantingManager$startExecution$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ h $execution;
    int label;

    public MoaGrantingManager$startExecution$1(h r1, Continuation<? super MoaGrantingManager$startExecution$1> r10) {
        this.$execution = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new MoaGrantingManager$startExecution$1(this.$execution, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L13 CancellationException -> L17
    L19:
    L16:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
        k r11 = k.a;     // Catch: Throwable -> L13 CancellationException -> L17
        h r12 = this.$execution;     // Catch: Throwable -> L13 CancellationException -> L17
        this.label = 1;     // Catch: Throwable -> L13 CancellationException -> L17
        if (k.a(r11, r12, this) != r0) goto L19;
        return r0;
    L17:
        e = move-exception;
        throw e;
    L13:
        th = move-exception;
        com.bytedance.ai.utils.g.a.e("MoaGrantingManager", "operateMoaGranting failed for " + this.$execution.getContext().b.b, th);
        k r13 = k.a;
        h r14 = this.$execution;
        r13.getClass();
        k.m(r14);
        goto L16
    }
}
