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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.localfileblock.remote.PcRemoteFileRepository$cachedFile$2", f = "PcRemoteFileRepository.kt", i = {0, 1, 1}, l = {101, 312}, m = "invokeSuspend", n = {"key", "key", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0", "L$1"})
public final class PcRemoteFileRepository$cachedFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    final /* synthetic */ g $request;
    Object L$0;
    Object L$1;
    int label;

    public PcRemoteFileRepository$cachedFile$2(g r1, Continuation<? super PcRemoteFileRepository$cachedFile$2> r2) {
        this.$request = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new PcRemoteFileRepository$cachedFile$2(this.$request, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super File> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        kotlinx.coroutines.sync.a r2 = (kotlinx.coroutines.sync.a) this.L$1;
        PcRemoteFileRepository.b r3 = (PcRemoteFileRepository.b) this.L$0;
        ResultKt.throwOnFailure(r6);
    L24:
        PcRemoteFileRepository r7 = PcRemoteFileRepository.a;     // Catch: Throwable -> L21
        File r8 = PcRemoteFileRepository.e(r3);     // Catch: Throwable -> L21
        r2.unlock(null);
        PcRemoteFileRepository.l(r3);
        return r8;
    L21:
        th = move-exception;
        r2.unlock(null);
        throw th;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r3 = (PcRemoteFileRepository.b) this.L$0;
        ResultKt.throwOnFailure(r6);
    L14:
        kotlinx.coroutines.sync.a r9 = PcRemoteFileRepository.c;
        this.L$0 = r3;
        this.L$1 = r9;
        this.label = 2;
        if (r9.a(null, this) != r0) goto L17;
        return r0;
    L17:
        r2 = r9;
        goto L24
    L10:
        ResultKt.throwOnFailure(r6);
        this.$request.b();
        PcRemoteFileRepository.a.i();
        PcRemoteFileRepository.b r10 = PcRemoteFileRepository.g(this.$request);
        this.L$0 = r10;
        this.label = 1;
        if (PcRemoteFileRepository.d(this) != r0) goto L13;
        return r0;
    L13:
        r3 = r10;
        goto L14
    }
}
