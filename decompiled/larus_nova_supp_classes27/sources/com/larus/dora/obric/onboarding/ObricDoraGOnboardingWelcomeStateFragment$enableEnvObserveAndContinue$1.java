package com.larus.dora.obric.onboarding;

import android.content.Context;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingWelcomeStateFragment$enableEnvObserveAndContinue$1", f = "ObricDoraGOnboardingWelcomeStateFragment.kt", i = {}, l = {912}, m = "invokeSuspend", n = {}, s = {})
final class ObricDoraGOnboardingWelcomeStateFragment$enableEnvObserveAndContinue$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $mac;
    int label;
    final /* synthetic */ ObricDoraGOnboardingWelcomeStateFragment this$0;

    public ObricDoraGOnboardingWelcomeStateFragment$enableEnvObserveAndContinue$1(ObricDoraGOnboardingWelcomeStateFragment r1, String r2, Continuation<? super ObricDoraGOnboardingWelcomeStateFragment$enableEnvObserveAndContinue$1> r3) {
        this.this$0 = r1;
        this.$mac = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricDoraGOnboardingWelcomeStateFragment$enableEnvObserveAndContinue$1(this.this$0, this.$mac, r4);
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
    L12:
        if (((Boolean) r7).booleanValue() == false) goto L23;
        ObricDoraGOnboardingWelcomeStateFragment r8 = this.this$0;
        int r2 = ObricDoraGOnboardingWelcomeStateFragment.y1;
        if (r8.Pa0() == false) goto L22;
        ObricDoraGOnboardingWelcomeStateFragment r9 = this.this$0;
        Bundle r3 = r9.getArguments();
        if (r3 != null) goto L18;
    L20:
        boolean r4 = false;
    L21:
        ObricDoraGOnboardingWelcomeStateFragment.Ga0(r9, null, r4, this.$mac, 1);
    L25:
        return Unit.INSTANCE;
    L18:
        if (r3.getBoolean("obric_open_env_observe_after_auth") != true) goto L20;
        r4 = true;
        goto L21
    L22:
        this.this$0.ra0();
        goto L25
    L23:
        t19.s r10 = t19.s.a;
        Context r5 = this.this$0.getContext();
        String r6 = this.this$0.getString(2131903992);
        r10.getClass();
        t19.s.c(r5, r6);
        goto L25
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CoroutineDispatcher r11 = Dispatchers.getIO();
        ObricDoraGOnboardingWelcomeStateFragment$enableEnvObserveAndContinue$1$success$1 r12 = new ObricDoraGOnboardingWelcomeStateFragment$enableEnvObserveAndContinue$1$success$1(this.$mac, this.this$0, null);
        this.label = 1;
        r7 = BuildersKt.withContext(r11, r12, this);
        if (r7 != r0) goto L12;
        return r0;
    }
}
