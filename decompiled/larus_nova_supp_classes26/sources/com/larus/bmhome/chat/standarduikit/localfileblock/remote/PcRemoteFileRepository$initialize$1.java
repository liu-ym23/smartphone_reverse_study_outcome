package com.larus.bmhome.chat.standarduikit.localfileblock.remote;

import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.localfileblock.remote.PcRemoteFileRepository$initialize$1", f = "PcRemoteFileRepository.kt", i = {0}, l = {312}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
public final class PcRemoteFileRepository$initialize$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;

    public PcRemoteFileRepository$initialize$1(Continuation<? super PcRemoteFileRepository$initialize$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new PcRemoteFileRepository$initialize$1(r2);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        kotlinx.coroutines.sync.a r2 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r5);
    L18:
        PcRemoteFileRepository r6 = PcRemoteFileRepository.a;     // Catch: Throwable -> L15
        PcRemoteFileRepository.k((File) PcRemoteFileRepository.i.getValue(), "cold_start");     // Catch: Throwable -> L15
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r2.unlock(null);
        return Unit.INSTANCE;
    L15:
        th = move-exception;
        r2.unlock(null);
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        kotlinx.coroutines.sync.a r8 = PcRemoteFileRepository.c;
        this.L$0 = r8;
        this.label = 1;
        if (r8.a(null, this) != r0) goto L11;
        return r0;
    L11:
        r2 = r8;
        goto L18
    }
}
