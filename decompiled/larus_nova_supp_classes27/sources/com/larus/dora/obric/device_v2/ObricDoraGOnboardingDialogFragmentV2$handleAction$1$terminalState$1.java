package com.larus.dora.obric.device_v2;

import com.larus.dora.impl.onboarding.q0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/dora/impl/onboarding/OnboardingUiState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_v2.ObricDoraGOnboardingDialogFragmentV2$handleAction$1$terminalState$1", f = "ObricDoraGOnboardingDialogFragmentV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricDoraGOnboardingDialogFragmentV2$handleAction$1$terminalState$1 extends SuspendLambda implements Function2<q0, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public ObricDoraGOnboardingDialogFragmentV2$handleAction$1$terminalState$1(Continuation<? super ObricDoraGOnboardingDialogFragmentV2$handleAction$1$terminalState$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        ObricDoraGOnboardingDialogFragmentV2$handleAction$1$terminalState$1 r0 = new ObricDoraGOnboardingDialogFragmentV2$handleAction$1$terminalState$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public final Object invoke(q0 r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((q0) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        return Boxing.boxBoolean(!(((q0) this.L$0) instanceof q0.c));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
