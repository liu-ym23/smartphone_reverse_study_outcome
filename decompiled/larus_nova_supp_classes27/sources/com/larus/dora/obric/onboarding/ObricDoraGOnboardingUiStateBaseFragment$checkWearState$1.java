package com.larus.dora.obric.onboarding;

import androidx.fragment.app.FragmentActivity;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
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
@DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingUiStateBaseFragment$checkWearState$1", f = "ObricDoraGOnboardingUiStateBaseFragment.kt", i = {}, l = {590}, m = "invokeSuspend", n = {}, s = {})
public final class ObricDoraGOnboardingUiStateBaseFragment$checkWearState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isNeedDelay;
    int label;
    final /* synthetic */ ObricDoraGOnboardingUiStateBaseFragment this$0;

    public ObricDoraGOnboardingUiStateBaseFragment$checkWearState$1(boolean r1, ObricDoraGOnboardingUiStateBaseFragment r2, Continuation<? super ObricDoraGOnboardingUiStateBaseFragment$checkWearState$1> r3) {
        this.$isNeedDelay = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricDoraGOnboardingUiStateBaseFragment$checkWearState$1(this.$isNeedDelay, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L14:
        if ((this.this$0.pa0() instanceof r) == true) goto L37;
        if ((this.this$0.pa0() instanceof s) == true) goto L37;
        final ObricDoraGOnboardingUiStateBaseFragment r6 = this.this$0;
        if (r6.isAdded() == false) goto L35;
        if (r6.isResumed() == false) goto L35;
        if (r6.u != null) goto L35;
        FragmentActivity r2 = r6.getActivity();
        if (r2 == null) goto L35;
        com.obric.oui.dialog.v2.alert.g r3 = new com.obric.oui.dialog.v2.alert.g(r2);
        r3.w = false;
        String r4 = r6.getString(2131902825);
        r3.j = false;
        r3.h = r4;
        r3.i = r6.getString(2131902796);
        com.obric.oui.dialog.v2.alert.g.c(r3);
        r3.e(r6.getString(2131910890), new h0(r6));
        r3.g(r6.getString(2131902809), new i0(r6), ButtonStyleController.TextColorType.Negative);
        com.obric.oui.dialog.v2.alert.c r7 = r3.a();
        if (DialogLancet.shouldBlockDialogShow(r7) == false) goto L39;
        DialogLancet.handleBlockedDialogShow(r7);
    L33:
        r6.u = r7;
        goto L35
    L39:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L38
    L32:
        DialogLancet.beforeDialogShow(r7);
        r7.show();
        DialogLancet.afterDialogShow(r7);
    L35:
        return Unit.INSTANCE;
    L37:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        if (this.$isNeedDelay == false) goto L14;
        this.label = 1;
        if (DelayKt.delay(2000, this) != r0) goto L14;
        return r0;
    }
}
