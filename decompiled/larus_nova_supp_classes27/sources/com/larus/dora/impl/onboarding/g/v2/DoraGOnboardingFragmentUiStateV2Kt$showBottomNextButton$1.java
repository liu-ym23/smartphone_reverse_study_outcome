package com.larus.dora.impl.onboarding.g.v2;

import com.larus.dora.impl.databinding.LarusDoraGOnboardingFragmentV2Binding;
import com.larus.utils.j0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.DoraGOnboardingFragmentUiStateV2Kt$showBottomNextButton$1", f = "DoraGOnboardingFragmentUiStateV2.kt", i = {}, l = {722}, m = "invokeSuspend", n = {}, s = {})
public final class DoraGOnboardingFragmentUiStateV2Kt$showBottomNextButton$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LarusDoraGOnboardingFragmentV2Binding $binding;
    int label;

    public DoraGOnboardingFragmentUiStateV2Kt$showBottomNextButton$1(LarusDoraGOnboardingFragmentV2Binding r1, Continuation<? super DoraGOnboardingFragmentUiStateV2Kt$showBottomNextButton$1> r2) {
        this.$binding = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraGOnboardingFragmentUiStateV2Kt$showBottomNextButton$1(this.$binding, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        LarusDoraGOnboardingFragmentV2Binding r7 = this.$binding;
        if (r7 == null) goto L15;
        int r2 = j0.a;
        String r3 = j0.d(2131902818);
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r3, "topText");
        DoraGOnboardingFragmentUiStateV2Kt.b(r7, r3, true);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        this.label = 1;
        if (DelayKt.delay(4000, this) != r0) goto L11;
        return r0;
    }
}
