package com.bytedance.android.livesdk.chatroom.ui.framework;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.chatroom.ui.framework.NewAudienceInteractionFragment$startLoadInteractionFragment$3", f = "NewAudienceInteractionFragment.kt", i = {}, l = {263}, m = "invokeSuspend", n = {}, s = {})
final class NewAudienceInteractionFragment$startLoadInteractionFragment$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ NewAudienceInteractionFragment this$0;

    public NewAudienceInteractionFragment$startLoadInteractionFragment$3(NewAudienceInteractionFragment r1, Continuation r2) {
        this.this$0 = r1;
        super(1, r2);
    }

    public final Continuation<Unit> create(Continuation<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "completion");
        return new NewAudienceInteractionFragment$startLoadInteractionFragment$3(this.this$0, r3);
    }

    public final Object invoke(Object r2) {
        return create((Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        NewAudienceInteractionFragment r5 = this.this$0;
        this.label = 1;
        if (NewAudienceInteractionFragment.S90(r5, this) != r0) goto L12;
        return r0;
    }
}
