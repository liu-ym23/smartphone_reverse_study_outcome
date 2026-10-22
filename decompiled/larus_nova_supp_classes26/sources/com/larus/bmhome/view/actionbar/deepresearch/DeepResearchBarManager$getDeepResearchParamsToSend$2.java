package com.larus.bmhome.view.actionbar.deepresearch;

import com.larus.bmhome.instruction.g;
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
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.deepresearch.DeepResearchBarManager$getDeepResearchParamsToSend$2", f = "DeepResearchBarManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DeepResearchBarManager$getDeepResearchParamsToSend$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public DeepResearchBarManager$getDeepResearchParamsToSend$2(Continuation<? super DeepResearchBarManager$getDeepResearchParamsToSend$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DeepResearchBarManager$getDeepResearchParamsToSend$2(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r3);
        g r4 = b.d;
        boolean r0 = false;
        if (r4 != null) goto L7;
    L9:
        if (r0 == false) goto L14;
        g r5 = b.d;
        if (r5 == null) goto L14;
        r5.ck();
    L14:
        return Unit.INSTANCE;
    L7:
        if (r4.Q1() != 21) goto L9;
        r0 = true;
        goto L9
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
