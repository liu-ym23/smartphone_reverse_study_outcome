package com.larus.dora.impl.onboarding.othersmart;

import com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment;
import com.larus.dora.impl.onboarding.DoraOnboardingDevice;
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
@DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.DoraExternalSmartOnboardingWakeupFragment$gotoNextStep$1", f = "DoraExternalSmartOnboardingWakeupFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraExternalSmartOnboardingWakeupFragment$gotoNextStep$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraOnboardingDevice $device;
    int label;
    final /* synthetic */ DoraExternalSmartOnboardingWakeupFragment this$0;

    public DoraExternalSmartOnboardingWakeupFragment$gotoNextStep$1(DoraOnboardingDevice r1, DoraExternalSmartOnboardingWakeupFragment r2, Continuation<? super DoraExternalSmartOnboardingWakeupFragment$gotoNextStep$1> r3) {
        this.$device = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraExternalSmartOnboardingWakeupFragment$gotoNextStep$1(this.$device, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r2);
        if (com.larus.dora.impl.onboarding.x.a(this.$device) == false) goto L9;
        this.this$0.getClass();
        if (DoraOnboardingBaseFragment.Y90() == true) goto L9;
        this.this$0.ea0();
    L11:
        return Unit.INSTANCE;
    L9:
        this.this$0.Z90(new DoraExternalSmartOnboardingRadioFragment());
        goto L11
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
