package com.obric.memorydata.sdk.intent;

import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.app.AppEntity;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.sdk.intent.InAppSearchIntentExecutor$doAction$result$1", f = "InAppSearchIntentExecutor.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
final class InAppSearchIntentExecutor$doAction$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super IntentResult<AppEntity[]>>, Object> {
    final /* synthetic */ CompletableDeferred<IntentResult<AppEntity[]>> $completionDeferred;
    int label;

    public InAppSearchIntentExecutor$doAction$result$1(CompletableDeferred<IntentResult<AppEntity[]>> r1, Continuation<? super InAppSearchIntentExecutor$doAction$result$1> r2) {
        this.$completionDeferred = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new InAppSearchIntentExecutor$doAction$result$1(this.$completionDeferred, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super IntentResult<AppEntity[]>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        CompletableDeferred<IntentResult<AppEntity[]>> r5 = this.$completionDeferred;
        this.label = 1;
        r4 = r5.await(this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
