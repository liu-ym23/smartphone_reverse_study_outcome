package com.larus.dora.obric.onboarding;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingUiStateBaseFragment$refreshObricWearState$1$1$1", f = "ObricDoraGOnboardingUiStateBaseFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricDoraGOnboardingUiStateBaseFragment$refreshObricWearState$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $wearState;
    int label;
    final /* synthetic */ ObricDoraGOnboardingUiStateBaseFragment this$0;

    public ObricDoraGOnboardingUiStateBaseFragment$refreshObricWearState$1$1$1(ObricDoraGOnboardingUiStateBaseFragment r1, Integer r2, Continuation<? super ObricDoraGOnboardingUiStateBaseFragment$refreshObricWearState$1$1$1> r3) {
        this.this$0 = r1;
        this.$wearState = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricDoraGOnboardingUiStateBaseFragment$refreshObricWearState$1$1$1(this.this$0, this.$wearState, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r4);
        ObricDoraGOnboardingUiStateBaseFragment r5 = this.this$0;
        Integer r0 = this.$wearState;
        if (r0 != null) goto L8;
    L10:
        boolean r1 = false;
    L11:
        KProperty<Object>[] r2 = ObricDoraGOnboardingUiStateBaseFragment.y;
        r5.ma0(r1, true);
        return Unit.INSTANCE;
    L8:
        if (r0.intValue() != 1) goto L10;
        r1 = true;
        goto L11
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
