package com.larus.dora.impl.onboarding.g.v2;

import com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingUiStateBaseFragment;
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
@DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.DoraGOnboardingFragmentUiStateV2Kt$gotoDone$1$1", f = "DoraGOnboardingFragmentUiStateV2.kt", i = {}, l = {714}, m = "invokeSuspend", n = {}, s = {})
final class DoraGOnboardingFragmentUiStateV2Kt$gotoDone$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraGOnboardingUiStateBaseFragment $this_apply;
    int label;

    public DoraGOnboardingFragmentUiStateV2Kt$gotoDone$1$1(DoraGOnboardingUiStateBaseFragment r1, Continuation<? super DoraGOnboardingFragmentUiStateV2Kt$gotoDone$1$1> r2) {
        this.$this_apply = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraGOnboardingFragmentUiStateV2Kt$gotoDone$1$1(this.$this_apply, r3);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        DoraGOnboardingUiStateBaseFragment r5 = this.$this_apply;
        f r2 = r5.ma0();
        if (r2 == null) goto L17;
        f r3 = r2.c();
        if (r3 == null) goto L17;
        r3.b();
        r5.pa0(r3);
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        this.label = 1;
        if (DelayKt.delay(660, this) != r0) goto L11;
        return r0;
    }
}
