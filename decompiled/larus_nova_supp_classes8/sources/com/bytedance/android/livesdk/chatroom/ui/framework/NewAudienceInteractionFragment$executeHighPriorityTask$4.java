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
@DebugMetadata(c = "com.bytedance.android.livesdk.chatroom.ui.framework.NewAudienceInteractionFragment$executeHighPriorityTask$4", f = "NewAudienceInteractionFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class NewAudienceInteractionFragment$executeHighPriorityTask$4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ NewAudienceInteractionFragment this$0;

    public NewAudienceInteractionFragment$executeHighPriorityTask$4(NewAudienceInteractionFragment r1, Continuation r2) {
        this.this$0 = r1;
        super(1, r2);
    }

    public final Continuation<Unit> create(Continuation<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "completion");
        return new NewAudienceInteractionFragment$executeHighPriorityTask$4(this.this$0, r3);
    }

    public final Object invoke(Object r2) {
        return create((Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        com.bytedance.android.live.core.tetris.widgets.d.g("start notifyRevenueInstanceLoadWidget");
        this.this$0.f.A();
        com.bytedance.android.live.core.tetris.widgets.d.g("end notifyRevenueInstanceLoadWidget");
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
