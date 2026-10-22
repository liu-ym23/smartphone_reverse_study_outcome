package com.larus.dora.impl.onboarding;

import com.bytedance.dora.device.DoraDevice;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel$doraLinkCallback$1$onDoraLinkStateChanged$1", f = "DoraOnboardingDialogViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraOnboardingDialogViewModel$doraLinkCallback$1$onDoraLinkStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $device;
    final /* synthetic */ int $state;
    int label;
    final /* synthetic */ DoraOnboardingDialogViewModel this$0;

    public DoraOnboardingDialogViewModel$doraLinkCallback$1$onDoraLinkStateChanged$1(int r1, DoraDevice r2, DoraOnboardingDialogViewModel r3, Continuation<? super DoraOnboardingDialogViewModel$doraLinkCallback$1$onDoraLinkStateChanged$1> r4) {
        this.$state = r1;
        this.$device = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraOnboardingDialogViewModel$doraLinkCallback$1$onDoraLinkStateChanged$1(this.$state, this.$device, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r4);
        g49.d.d("DoraOnboardingDialogViewModel", "onDoraLinkStateChanged: state=" + this.$state + ", sn=" + this.$device.sn);
        if (this.$state != 2) goto L19;
        q0 r5 = (q0) DoraOnboardingDialogViewModel.access$get_uiStateFlow$p(this.this$0).getValue();
        String r2 = null;
        if ((r5 instanceof q0.d) == false) goto L10;
        DoraDevice r6 = ((q0.d) r5).a;
    L13:
        if (r6 == null) goto L16;
        r2 = r6.sn;
    L16:
        if (Intrinsics.areEqual(r2, this.$device.sn) == false) goto L19;
        g49.d.d("DoraOnboardingDialogViewModel", "onDoraLinkStateChanged: OnboardingUiState.DeviceConnected");
        DoraOnboardingDialogViewModel.access$get_uiStateFlow$p(this.this$0).setValue(new q0.b(this.$device));
        goto L19
    L10:
        if ((r5 instanceof q0.c) == false) goto L12;
        r6 = ((q0.c) r5).a;
        goto L13
    L12:
        r6 = null;
    L19:
        return Unit.INSTANCE;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
