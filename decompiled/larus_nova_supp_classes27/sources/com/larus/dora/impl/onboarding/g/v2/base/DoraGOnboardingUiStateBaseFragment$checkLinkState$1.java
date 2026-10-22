package com.larus.dora.impl.onboarding.g.v2.base;

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
@DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingUiStateBaseFragment$checkLinkState$1", f = "DoraGOnboardingUiStateBaseFragment.kt", i = {}, l = {469}, m = "invokeSuspend", n = {}, s = {})
public final class DoraGOnboardingUiStateBaseFragment$checkLinkState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoraGOnboardingUiStateBaseFragment this$0;

    public DoraGOnboardingUiStateBaseFragment$checkLinkState$1(DoraGOnboardingUiStateBaseFragment r1, Continuation<? super DoraGOnboardingUiStateBaseFragment$checkLinkState$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraGOnboardingUiStateBaseFragment$checkLinkState$1(this.this$0, r3);
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
        DoraGOnboardingUiStateBaseFragment r2 = this.this$0;
        String r3 = r2.fa0(2131902793);
        String r4 = this.this$0.fa0(2131902805);
        String r5 = this.this$0.fa0(2131902809);
        final DoraGOnboardingUiStateBaseFragment r9 = this.this$0;
        r2.ha0("device_disconnected", r3, r4, r5, new m(r9));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        this.label = 1;
        if (DelayKt.delay(600, this) != r0) goto L11;
        return r0;
    }
}
