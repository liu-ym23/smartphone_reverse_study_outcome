package com.bytedance.ai.core.manager;

import com.bytedance.ai.model.AppletRuntime;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/model/AppletRuntime;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.core.manager.WorkerRuntimeManager$runAppletWorker$2$1$awaitResult$1", f = "WorkerRuntimeManager.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
public final class WorkerRuntimeManager$runAppletWorker$2$1$awaitResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AppletRuntime>, Object> {
    final /* synthetic */ CompletableDeferred<AppletRuntime> $existingDeferred;
    int label;

    public WorkerRuntimeManager$runAppletWorker$2$1$awaitResult$1(CompletableDeferred<AppletRuntime> r1, Continuation<? super WorkerRuntimeManager$runAppletWorker$2$1$awaitResult$1> r10) {
        this.$existingDeferred = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new WorkerRuntimeManager$runAppletWorker$2$1$awaitResult$1(this.$existingDeferred, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super AppletRuntime> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        CompletableDeferred<AppletRuntime> r11 = this.$existingDeferred;
        this.label = 1;
        r10 = r11.await(this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
