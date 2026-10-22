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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.localfileblock.remote.PcRemoteFileRepository$prepareFile$candidate$1", f = "PcRemoteFileRepository.kt", i = {}, l = {121}, m = "invokeSuspend", n = {}, s = {})
public final class PcRemoteFileRepository$prepareFile$candidate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    final /* synthetic */ PcRemoteFileRepository.b $key;
    final /* synthetic */ g $request;
    int label;

    public PcRemoteFileRepository$prepareFile$candidate$1(PcRemoteFileRepository.b r1, g r2, Continuation<? super PcRemoteFileRepository$prepareFile$candidate$1> r3) {
        this.$key = r1;
        this.$request = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new PcRemoteFileRepository$prepareFile$candidate$1(this.$key, this.$request, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super File> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        PcRemoteFileRepository r6 = PcRemoteFileRepository.a;
        PcRemoteFileRepository.b r2 = this.$key;
        g r3 = this.$request;
        this.label = 1;
        r5 = PcRemoteFileRepository.b(r6, r2, r3, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
