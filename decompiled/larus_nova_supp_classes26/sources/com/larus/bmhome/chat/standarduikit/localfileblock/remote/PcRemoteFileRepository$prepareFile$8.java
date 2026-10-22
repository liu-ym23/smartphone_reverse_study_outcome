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
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.localfileblock.remote.PcRemoteFileRepository$prepareFile$8", f = "PcRemoteFileRepository.kt", i = {0}, l = {312}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
final class PcRemoteFileRepository$prepareFile$8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $directory;
    Object L$0;
    Object L$1;
    int label;

    public PcRemoteFileRepository$prepareFile$8(File r1, Continuation<? super PcRemoteFileRepository$prepareFile$8> r2) {
        this.$directory = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new PcRemoteFileRepository$prepareFile$8(this.$directory, r3);
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
        File r2 = (File) this.L$1;
        kotlinx.coroutines.sync.a r3 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r5);
    L18:
        PcRemoteFileRepository r6 = PcRemoteFileRepository.a;     // Catch: Throwable -> L15
        PcRemoteFileRepository.k(r2, "download_failed");     // Catch: Throwable -> L15
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r3.unlock(null);
        return Unit.INSTANCE;
    L15:
        th = move-exception;
        r3.unlock(null);
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        r3 = PcRemoteFileRepository.c;
        File r8 = this.$directory;
        this.L$0 = r3;
        this.L$1 = r8;
        this.label = 1;
        if (r3.a(null, this) != r0) goto L11;
        return r0;
    L11:
        r2 = r8;
        goto L18
    }
}
