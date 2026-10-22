package com.larus.dora.obric.device_v2;

import android.content.Context;
import com.larus.dora.impl.onboarding.o0;
import com.larus.dora.impl.onboarding.q0;
import com.larus.dora.obric.utils.DoraObricToastUtils;
import java.lang.ref.WeakReference;
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
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_v2.ObricDoraGOnboardingDialogFragmentV2$handleAction$1", f = "ObricDoraGOnboardingDialogFragmentV2.kt", i = {}, l = {328}, m = "invokeSuspend", n = {}, s = {})
public final class ObricDoraGOnboardingDialogFragmentV2$handleAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ o0 $action;
    int label;
    final /* synthetic */ ObricDoraGOnboardingDialogFragmentV2 this$0;

    public ObricDoraGOnboardingDialogFragmentV2$handleAction$1(ObricDoraGOnboardingDialogFragmentV2 r1, o0 r2, Continuation<? super ObricDoraGOnboardingDialogFragmentV2$handleAction$1> r3) {
        this.this$0 = r1;
        this.$action = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricDoraGOnboardingDialogFragmentV2$handleAction$1(this.this$0, this.$action, r4);
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
    L12:
        if ((((q0) r5) instanceof q0.a) == true) goto L17;
        Context r6 = this.this$0.getContext();
        if (r6 == null) goto L17;
        o0 r2 = this.$action;
        WeakReference<com.obric.oui.toast.f> r3 = DoraObricToastUtils.a;
        String r4 = ((o0.d) r2).a;
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r4, "text");
        t19.s.a.getClass();
        t19.s.c(r6, r4);
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        ObricDoraGOnboardingDialogFragmentV2 r7 = this.this$0;
        int r8 = ObricDoraGOnboardingDialogFragmentV2.D;
        i1<q0> r9 = r7.X90().getUiStateFlow();
        ObricDoraGOnboardingDialogFragmentV2$handleAction$1$terminalState$1 r10 = new ObricDoraGOnboardingDialogFragmentV2$handleAction$1$terminalState$1(null);
        this.label = 1;
        r5 = kotlinx.coroutines.flow.e.t(r9, r10, this);
        if (r5 != r0) goto L12;
        return r0;
    }
}
