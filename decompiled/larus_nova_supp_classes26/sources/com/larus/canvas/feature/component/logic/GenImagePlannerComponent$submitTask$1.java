package com.larus.canvas.feature.component.logic;

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
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImagePlannerComponent$submitTask$1", f = "GenImagePlannerComponent.kt", i = {0}, l = {1970}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
public final class GenImagePlannerComponent$submitTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $taskId;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ GenImagePlannerComponent this$0;

    public GenImagePlannerComponent$submitTask$1(GenImagePlannerComponent r1, String r2, Continuation<? super GenImagePlannerComponent$submitTask$1> r3) {
        this.this$0 = r1;
        this.$taskId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new GenImagePlannerComponent$submitTask$1(this.this$0, this.$taskId, r4);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        String r2 = (String) this.L$2;
        GenImagePlannerComponent r3 = (GenImagePlannerComponent) this.L$1;
        kotlinx.coroutines.sync.a r4 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r6);
    L18:
        int r7 = GenImagePlannerComponent.W;     // Catch: Throwable -> L15
        r3.d4().addLast(r2);     // Catch: Throwable -> L15
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r4.unlock(null);
        this.this$0.K.trySend-JP2dKIU(this.$taskId);
        return Unit.INSTANCE;
    L15:
        th = move-exception;
        r4.unlock(null);
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        GenImagePlannerComponent r9 = this.this$0;
        int r5 = GenImagePlannerComponent.W;
        kotlinx.coroutines.sync.a r10 = (kotlinx.coroutines.sync.a) r9.M.getValue();
        r3 = this.this$0;
        String r11 = this.$taskId;
        this.L$0 = r10;
        this.L$1 = r3;
        this.L$2 = r11;
        this.label = 1;
        if (r10.a(null, this) != r0) goto L11;
        return r0;
    L11:
        r4 = r10;
        r2 = r11;
        goto L18
    }
}
