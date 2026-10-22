package com.larus.dora.impl.file;

import com.larus.dora.impl.file.record.DoraFileRecorder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.file.DoraFileStreamingSink$sink$firstFrameTimeoutJob$1", f = "DoraFileStreamingSink.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
public final class DoraFileStreamingSink$sink$firstFrameTimeoutJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CompletableDeferred<h> $deferred;
    final /* synthetic */ DoraFileFetchTask $task;
    final /* synthetic */ i $taskStore;
    int label;

    public DoraFileStreamingSink$sink$firstFrameTimeoutJob$1(DoraFileFetchTask r1, i r2, CompletableDeferred<h> r3, Continuation<? super DoraFileStreamingSink$sink$firstFrameTimeoutJob$1> r4) {
        this.$task = r1;
        this.$taskStore = r2;
        this.$deferred = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraFileStreamingSink$sink$firstFrameTimeoutJob$1(this.$task, this.$taskStore, this.$deferred, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r24) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r24);
    L11:
        DoraFileFetchTask r3 = DoraFileFetchTask.copy$default(this.$task, null, null, null, null, null, DoraFileTaskStatus.FAILED, null, null, null, null, null, null, null, null, null, null, null, 131039, null);
        this.$taskStore.d(r3);
        DoraFileRecorder.a(r3);
        this.$deferred.complete(new h(r3, DoraFileStreamingSinkReason.FIRST_FRAME_TIMEOUT));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r24);
        this.label = 1;
        if (DelayKt.delay(3000, this) != r1) goto L11;
        return r1;
    }
}
