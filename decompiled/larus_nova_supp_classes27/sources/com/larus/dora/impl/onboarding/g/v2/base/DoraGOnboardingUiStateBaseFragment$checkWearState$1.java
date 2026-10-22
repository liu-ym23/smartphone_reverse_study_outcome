package com.larus.dora.impl.onboarding.g.v2.base;

import com.larus.dora.impl.onboarding.g.v2.t;
import com.larus.dora.impl.onboarding.g.v2.v;
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
@DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingUiStateBaseFragment$checkWearState$1", f = "DoraGOnboardingUiStateBaseFragment.kt", i = {}, l = {444}, m = "invokeSuspend", n = {}, s = {})
public final class DoraGOnboardingUiStateBaseFragment$checkWearState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isNeedDelay;
    int label;
    final /* synthetic */ DoraGOnboardingUiStateBaseFragment this$0;

    public DoraGOnboardingUiStateBaseFragment$checkWearState$1(boolean r1, DoraGOnboardingUiStateBaseFragment r2, Continuation<? super DoraGOnboardingUiStateBaseFragment$checkWearState$1> r3) {
        this.$isNeedDelay = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraGOnboardingUiStateBaseFragment$checkWearState$1(this.$isNeedDelay, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L14:
        if ((this.this$0.ma0() instanceof v) == true) goto L23;
        if ((this.this$0.ma0() instanceof t) == true) goto L23;
        if ((this.this$0.ma0() instanceof com.larus.dora.impl.onboarding.g.v2.i) == true) goto L23;
        DoraGOnboardingUiStateBaseFragment r2 = this.this$0;
        String r3 = r2.fa0(2131902825);
        String r4 = this.this$0.fa0(2131902796);
        String r5 = this.this$0.fa0(2131902809);
        final DoraGOnboardingUiStateBaseFragment r8 = this.this$0;
        r2.ha0("device_wearing_incorrectly", r3, r4, r5, new n(r8));
        return Unit.INSTANCE;
    L23:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        if (this.$isNeedDelay == false) goto L14;
        this.label = 1;
        if (DelayKt.delay(2000, this) != r0) goto L14;
        return r0;
    }
}
