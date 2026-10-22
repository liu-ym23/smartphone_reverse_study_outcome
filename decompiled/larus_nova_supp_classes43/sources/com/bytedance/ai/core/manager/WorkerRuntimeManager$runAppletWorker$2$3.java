package com.bytedance.ai.core.manager;

import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.utils.g;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.core.manager.WorkerRuntimeManager$runAppletWorker$2$3", f = "WorkerRuntimeManager.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {})
public final class WorkerRuntimeManager$runAppletWorker$2$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appletId;
    final /* synthetic */ CompletableDeferred<AppletRuntime> $deferred;
    int label;
    final /* synthetic */ WorkerRuntimeManager this$0;

    public WorkerRuntimeManager$runAppletWorker$2$3(WorkerRuntimeManager r1, String r10, CompletableDeferred<AppletRuntime> r11, Continuation<? super WorkerRuntimeManager$runAppletWorker$2$3> r12) {
        this.this$0 = r1;
        this.$appletId = r10;
        this.$deferred = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new WorkerRuntimeManager$runAppletWorker$2$3(this.this$0, this.$appletId, this.$deferred, r11);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        this.this$0.d.remove(this.$appletId, this.$deferred);
        g.a.i("WorkerRuntimeManager", "runApplet " + this.$appletId + ": deferred cleaned up after delay");
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        this.label = 1;
        if (DelayKt.delay(1000, this) != r0) goto L11;
        return r0;
    }
}
