package com.obric.assistant.authenticationsession;

import com.airbnb.lottie.LottieAnimationView;
import com.larus.utils.e1;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.AuthenticationType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.authenticationsession.SessionAuthenticationStateView$changeToShow$1", f = "SessionAuthenticationStateView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SessionAuthenticationStateView$changeToShow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AuthenticationType $authType;
    final /* synthetic */ boolean $withFullAnimation;
    int label;
    final /* synthetic */ SessionAuthenticationStateView this$0;

    public SessionAuthenticationStateView$changeToShow$1(SessionAuthenticationStateView r1, boolean r2, AuthenticationType r3, Continuation<? super SessionAuthenticationStateView$changeToShow$1> r4) {
        this.this$0 = r1;
        this.$withFullAnimation = r2;
        this.$authType = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new SessionAuthenticationStateView$changeToShow$1(this.this$0, this.$withFullAnimation, this.$authType, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r3);
        e1.x(this.this$0);
        this.this$0.i(this.$withFullAnimation, false, false);
        LottieAnimationView r4 = SessionAuthenticationStateView.c(this.this$0);
        if (this.$authType != AuthenticationType.VoicePrint) goto L7;
        int r0 = 2131820634;
    L8:
        r4.setAnimation(r0);
        SessionAuthenticationStateView.c(this.this$0).cancelAnimation();
        if (this.$withFullAnimation == false) goto L12;
        this.this$0.k = true;
        SessionAuthenticationStateView.c(this.this$0).playAnimation();
    L12:
        return Unit.INSTANCE;
    L7:
        r0 = 2131820633;
        goto L8
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
