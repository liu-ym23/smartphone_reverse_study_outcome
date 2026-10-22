package com.larus.dora.impl.onboarding.g.v2.config;

import com.larus.utils.j0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.config.DoraGOnboardingWiFiSettingsFragment$onLinkState$1", f = "DoraGOnboardingWiFiSettingsFragment.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
public final class DoraGOnboardingWiFiSettingsFragment$onLinkState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoraGOnboardingWiFiSettingsFragment this$0;

    public DoraGOnboardingWiFiSettingsFragment$onLinkState$1(DoraGOnboardingWiFiSettingsFragment r1, Continuation<? super DoraGOnboardingWiFiSettingsFragment$onLinkState$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraGOnboardingWiFiSettingsFragment$onLinkState$1(this.this$0, r3);
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
        DoraGOnboardingWiFiSettingsFragment r2 = this.this$0;
        int r9 = j0.a;
        String r3 = j0.d(2131902792);
        String r4 = j0.d(2131902790);
        String r5 = j0.d(2131902791);
        final DoraGOnboardingWiFiSettingsFragment r10 = this.this$0;
        Function0<Unit> r6 = new h(r10);
        int r11 = DoraGOnboardingWiFiSettingsFragment.u;
        r2.ha0("device_disconnected", r3, r4, r5, r6);
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
