package com.larus.dora.impl.onboarding;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
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
@DebugMetadata(c = "com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment$next$1", f = "DoraOnboardingBaseFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraOnboardingBaseFragment$next$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Fragment $fragment;
    int label;
    final /* synthetic */ DoraOnboardingBaseFragment this$0;

    public DoraOnboardingBaseFragment$next$1(DoraOnboardingBaseFragment r1, Fragment r2, Continuation<? super DoraOnboardingBaseFragment$next$1> r3) {
        this.this$0 = r1;
        this.$fragment = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraOnboardingBaseFragment$next$1(this.this$0, this.$fragment, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r3);
        INVOKEVIRTUAL_com_larus_dora_impl_onboarding_DoraOnboardingBaseFragment$next$1_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(this.this$0.getParentFragmentManager().beginTransaction().setCustomAnimations(2130772368, 2130772369), 2131373275, this.$fragment).commitAllowingStateLoss();     // Catch: Exception -> L7
    L10:
        return Unit.INSTANCE;
    L7:
        e = move-exception;
        g49.d.e("DoraOnboardingBaseFragment", "navigate to next fragment failed: " + e.getMessage());
        goto L10
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_larus_dora_impl_onboarding_DoraOnboardingBaseFragment$next$1_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(FragmentTransaction r2, int r3, Fragment r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r3) == false) goto L6;
        return r2;
    L6:
        return r2.replace(r3, r4);
    }
}
