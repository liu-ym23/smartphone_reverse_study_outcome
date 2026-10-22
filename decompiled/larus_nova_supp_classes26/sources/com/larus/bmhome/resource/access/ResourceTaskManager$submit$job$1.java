package com.larus.bmhome.resource.access;

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
@DebugMetadata(c = "com.larus.bmhome.resource.access.ResourceTaskManager$submit$job$1", f = "ResourceTaskManager.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {})
final class ResourceTaskManager$submit$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ x0.a $submitResult;
    int label;

    public ResourceTaskManager$submit$job$1(x0.a r1, Continuation<? super ResourceTaskManager$submit$job$1> r2) {
        this.$submitResult = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ResourceTaskManager$submit$job$1(this.$submitResult, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L15
    L13:
        x0 r5 = x0.a;
        x0.a();
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r4);
        ResourceAccessPipeline r6 = ResourceAccessPipeline.a;     // Catch: Throwable -> L15
        f r2 = this.$submitResult.a;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        if (r6.a(r2, this) != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        x0 r3 = x0.a;
        x0.a();
        throw th;
    }
}
