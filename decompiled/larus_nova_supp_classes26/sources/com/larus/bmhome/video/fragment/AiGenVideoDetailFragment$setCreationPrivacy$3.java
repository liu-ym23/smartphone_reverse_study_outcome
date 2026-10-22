package com.larus.bmhome.video.fragment;

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
@DebugMetadata(c = "com.larus.bmhome.video.fragment.AiGenVideoDetailFragment$setCreationPrivacy$3", f = "AiGenVideoDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AiGenVideoDetailFragment$setCreationPrivacy$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $previousStatus;
    int label;
    final /* synthetic */ AiGenVideoDetailFragment this$0;

    public AiGenVideoDetailFragment$setCreationPrivacy$3(AiGenVideoDetailFragment r1, int r2, Continuation<? super AiGenVideoDetailFragment$setCreationPrivacy$3> r3) {
        this.this$0 = r1;
        this.$previousStatus = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AiGenVideoDetailFragment$setCreationPrivacy$3(this.this$0, this.$previousStatus, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        AiGenVideoDetailFragment r4 = this.this$0;
        int r0 = this.$previousStatus;
        int r1 = AiGenVideoDetailFragment.U;
        r4.pa0(r0);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
