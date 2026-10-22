package com.larus.dora.obric.onboarding;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingUiStateBaseFragment$showCallSkipGuideDialog$1", f = "ObricDoraGOnboardingUiStateBaseFragment.kt", i = {}, l = {666}, m = "invokeSuspend", n = {}, s = {})
final class ObricDoraGOnboardingUiStateBaseFragment$showCallSkipGuideDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricDoraGOnboardingUiStateBaseFragment this$0;

    public ObricDoraGOnboardingUiStateBaseFragment$showCallSkipGuideDialog$1(ObricDoraGOnboardingUiStateBaseFragment r1, Continuation<? super ObricDoraGOnboardingUiStateBaseFragment$showCallSkipGuideDialog$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricDoraGOnboardingUiStateBaseFragment$showCallSkipGuideDialog$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        ObricDoraGOnboardingUiStateBaseFragment r2 = this.this$0;
        String r3 = r2.fa0(2131902785);
        String r4 = this.this$0.fa0(2131902782);
        String r5 = this.this$0.fa0(2131902783);
        final ObricDoraGOnboardingUiStateBaseFragment r9 = this.this$0;
        r2.ia0("device_phone_call", r3, r4, r5, new l0(r9));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        this.label = 1;
        if (DelayKt.delay(300, this) != r0) goto L11;
        return r0;
    }
}
