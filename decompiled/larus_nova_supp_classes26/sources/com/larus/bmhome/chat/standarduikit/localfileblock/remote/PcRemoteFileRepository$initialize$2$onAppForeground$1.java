package com.larus.bmhome.chat.standarduikit.localfileblock.remote;

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
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.localfileblock.remote.PcRemoteFileRepository$initialize$2$onAppForeground$1", f = "PcRemoteFileRepository.kt", i = {1}, l = {85, 312}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
public final class PcRemoteFileRepository$initialize$2$onAppForeground$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;

    public PcRemoteFileRepository$initialize$2$onAppForeground$1(Continuation<? super PcRemoteFileRepository$initialize$2$onAppForeground$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new PcRemoteFileRepository$initialize$2$onAppForeground$1(r2);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        kotlinx.coroutines.sync.a r2 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r6);
    L23:
        PcRemoteFileRepository.c();     // Catch: Throwable -> L20
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L20
        r2.unlock(null);
        return Unit.INSTANCE;
    L20:
        th = move-exception;
        r2.unlock(null);
        throw th;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
    L13:
        kotlinx.coroutines.sync.a r8 = PcRemoteFileRepository.c;
        this.L$0 = r8;
        this.label = 2;
        if (r8.a(null, this) != r0) goto L16;
        return r0;
    L16:
        r2 = r8;
        goto L23
    L10:
        ResultKt.throwOnFailure(r6);
        PcRemoteFileRepository r9 = PcRemoteFileRepository.a;
        this.label = 1;
        if (PcRemoteFileRepository.d(this) != r0) goto L13;
        return r0;
    }
}
