package com.larus.dora.impl.onboarding.othersmart;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment$nextWithSharedElement$1$1$1", f = "DoraExternalOnboardingBaseFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraExternalOnboardingBaseFragment$nextWithSharedElement$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ View $sharedElementView;
    final /* synthetic */ String $transitionName;
    int label;
    final /* synthetic */ DoraExternalOnboardingBaseFragment this$0;

    public DoraExternalOnboardingBaseFragment$nextWithSharedElement$1$1$1(DoraExternalOnboardingBaseFragment r1, View r2, String r3, Fragment r4, Continuation<? super DoraExternalOnboardingBaseFragment$nextWithSharedElement$1$1$1> r5) {
        this.this$0 = r1;
        this.$sharedElementView = r2;
        this.$transitionName = r3;
        this.$fragment = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DoraExternalOnboardingBaseFragment$nextWithSharedElement$1$1$1(this.this$0, this.$sharedElementView, this.$transitionName, this.$fragment, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Integer> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        return Boxing.boxInt(INVOKEVIRTUAL_com_larus_dora_impl_onboarding_othersmart_DoraExternalOnboardingBaseFragment$nextWithSharedElement$1$1$1_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(this.this$0.getParentFragmentManager().beginTransaction().setReorderingAllowed(true).addSharedElement(this.$sharedElementView, this.$transitionName), 2131373275, this.$fragment).commitAllowingStateLoss());
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_larus_dora_impl_onboarding_othersmart_DoraExternalOnboardingBaseFragment$nextWithSharedElement$1$1$1_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(FragmentTransaction r2, int r3, Fragment r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r3) == false) goto L6;
        return r2;
    L6:
        return r2.replace(r3, r4);
    }
}
