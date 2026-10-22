package com.larus.canvas.feature.component.logic.exit;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.exit.CanvasExitAnchorManager$notifyCanvasAnchorEvent$1", f = "CanvasExitAnchorManager.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
public final class CanvasExitAnchorManager$notifyCanvasAnchorEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isGenerating;
    final /* synthetic */ String $msgId;
    final /* synthetic */ String $taskId;
    int label;

    public CanvasExitAnchorManager$notifyCanvasAnchorEvent$1(String r1, String r2, boolean r3, Continuation<? super CanvasExitAnchorManager$notifyCanvasAnchorEvent$1> r4) {
        this.$taskId = r1;
        this.$msgId = r2;
        this.$isGenerating = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CanvasExitAnchorManager$notifyCanvasAnchorEvent$1(this.$taskId, this.$msgId, this.$isGenerating, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        MutableSharedFlow r8 = (MutableSharedFlow) CanvasExitAnchorManager.a.getValue();
        ny8.a r2 = new ny8.a(this.$taskId, this.$msgId, this.$isGenerating);
        this.label = 1;
        if (r8.emit(r2, this) != r0) goto L12;
        return r0;
    }
}
