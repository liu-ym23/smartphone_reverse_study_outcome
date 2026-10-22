package com.larus.dora.impl.onboarding.othersmart.streamlined;

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
@DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.streamlined.DoraHStreamlinedOnboardingViewModel$voiceCallback$1$onVoiceWakeUp$1", f = "DoraHStreamlinedOnboardingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraHStreamlinedOnboardingViewModel$voiceCallback$1$onVoiceWakeUp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $query;
    int label;
    final /* synthetic */ DoraHStreamlinedOnboardingViewModel this$0;

    public DoraHStreamlinedOnboardingViewModel$voiceCallback$1$onVoiceWakeUp$1(int r1, DoraHStreamlinedOnboardingViewModel r2, Continuation<? super DoraHStreamlinedOnboardingViewModel$voiceCallback$1$onVoiceWakeUp$1> r3) {
        this.$query = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraHStreamlinedOnboardingViewModel$voiceCallback$1$onVoiceWakeUp$1(this.$query, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L23;
        ResultKt.throwOnFailure(r4);
        int r5 = this.$query;
        if (r5 == 1) goto L15;
        if (r5 == 2) goto L12;
        if (r5 == 3) goto L15;
    L21:
        return Unit.INSTANCE;
    L12:
        if (DoraHStreamlinedOnboardingViewModel.access$getActiveRoundToken$p(this.this$0) != null) goto L21;
        DoraHStreamlinedOnboardingViewModel.prepareVoiceQuery$default(this.this$0, null, 1, null);
    L15:
        if (DoraHStreamlinedOnboardingViewModel.access$getActiveRoundToken$p(this.this$0) != null) goto L17;
        DoraHStreamlinedOnboardingViewModel.prepareVoiceQuery$default(this.this$0, null, 1, null);
    L17:
        DoraHStreamlinedOnboardingViewModel.access$submitActiveVoiceQuery(this.this$0, null);
        Long r6 = DoraHStreamlinedOnboardingViewModel.access$requireActiveRoundToken(this.this$0, "onVoiceWakeUp_submit");
        if (r6 == null) goto L21;
        DoraHStreamlinedOnboardingViewModel.access$ensureReplyLoadingTimeout(this.this$0, r6.longValue());
        goto L21
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
