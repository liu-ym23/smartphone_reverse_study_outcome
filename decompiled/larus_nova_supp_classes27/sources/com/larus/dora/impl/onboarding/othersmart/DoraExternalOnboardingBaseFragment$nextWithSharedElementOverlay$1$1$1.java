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
@DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment$nextWithSharedElementOverlay$1$1$1", f = "DoraExternalOnboardingBaseFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraExternalOnboardingBaseFragment$nextWithSharedElementOverlay$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ String $fragmentTag;
    final /* synthetic */ View $sharedElementView;
    final /* synthetic */ String $transitionName;
    int label;
    final /* synthetic */ DoraExternalOnboardingBaseFragment this$0;

    public DoraExternalOnboardingBaseFragment$nextWithSharedElementOverlay$1$1$1(DoraExternalOnboardingBaseFragment r1, View r2, String r3, Fragment r4, String r5, Continuation<? super DoraExternalOnboardingBaseFragment$nextWithSharedElementOverlay$1$1$1> r6) {
        this.this$0 = r1;
        this.$sharedElementView = r2;
        this.$transitionName = r3;
        this.$fragment = r4;
        this.$fragmentTag = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new DoraExternalOnboardingBaseFragment$nextWithSharedElementOverlay$1$1$1(this.this$0, this.$sharedElementView, this.$transitionName, this.$fragment, this.$fragmentTag, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Integer> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        return Boxing.boxInt(INVOKEVIRTUAL_com_larus_dora_impl_onboarding_othersmart_DoraExternalOnboardingBaseFragment$nextWithSharedElementOverlay$1$1$1_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(this.this$0.getParentFragmentManager().beginTransaction().setReorderingAllowed(true).addSharedElement(this.$sharedElementView, this.$transitionName), 2131373275, this.$fragment, this.$fragmentTag).commitAllowingStateLoss());
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_larus_dora_impl_onboarding_othersmart_DoraExternalOnboardingBaseFragment$nextWithSharedElementOverlay$1$1$1_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r1, int r2, Fragment r3, String r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r4, r2) == false) goto L6;
        return r1;
    L6:
        return r1.add(r2, r3, r4);
    }
}
