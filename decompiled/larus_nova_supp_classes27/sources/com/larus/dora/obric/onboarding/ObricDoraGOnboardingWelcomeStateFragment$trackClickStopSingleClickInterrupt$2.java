package com.larus.dora.obric.onboarding;

import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingWelcomeStateFragment$trackClickStopSingleClickInterrupt$2", f = "ObricDoraGOnboardingWelcomeStateFragment.kt", i = {}, l = {493}, m = "invokeSuspend", n = {}, s = {})
final class ObricDoraGOnboardingWelcomeStateFragment$trackClickStopSingleClickInterrupt$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public ObricDoraGOnboardingWelcomeStateFragment$trackClickStopSingleClickInterrupt$2(Continuation<? super ObricDoraGOnboardingWelcomeStateFragment$trackClickStopSingleClickInterrupt$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new ObricDoraGOnboardingWelcomeStateFragment$trackClickStopSingleClickInterrupt$2(r2);
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
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        wc9.e r5 = (wc9.e) r4;
        if (r5 == null) goto L14;
        String r6 = r5.a;
    L15:
        if (r6 != null) goto L17;
    L20:
        if (r2 == false) goto L23;
        g49.d.e("ObricDoraGOnboardingWelcomeStateFragment", "trackClickStopSingleClickInterrupt failed, conversationId=" + r6);
        return Unit.INSTANCE;
    L23:
        b2.b(r6);
        return Unit.INSTANCE;
    L17:
        if (r6.length() == 0) goto L20;
        r2 = false;
        goto L20
    L14:
        r6 = null;
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        IConversationRepoService r7 = zh8.a.b;
        this.label = 1;
        r4 = r7.f(this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
