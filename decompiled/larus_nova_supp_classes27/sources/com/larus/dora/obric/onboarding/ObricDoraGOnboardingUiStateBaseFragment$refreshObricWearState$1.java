package com.larus.dora.obric.onboarding;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingUiStateBaseFragment$refreshObricWearState$1", f = "ObricDoraGOnboardingUiStateBaseFragment.kt", i = {}, l = {869, 874}, m = "invokeSuspend", n = {}, s = {})
final class ObricDoraGOnboardingUiStateBaseFragment$refreshObricWearState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    final /* synthetic */ ObricDoraGOnboardingUiStateBaseFragment this$0;

    public ObricDoraGOnboardingUiStateBaseFragment$refreshObricWearState$1(ObricDoraGOnboardingUiStateBaseFragment r1, Continuation<? super ObricDoraGOnboardingUiStateBaseFragment$refreshObricWearState$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricDoraGOnboardingUiStateBaseFragment$refreshObricWearState$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0080 -> B:24:0x0083). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        int r2 = this.I$1;
        int r5 = this.I$0;
        ObricDoraGOnboardingUiStateBaseFragment r6 = (ObricDoraGOnboardingUiStateBaseFragment) this.L$0;
        ResultKt.throwOnFailure(r10);
        ObricDoraGOnboardingUiStateBaseFragment$refreshObricWearState$1 r11 = this;
    L24:
        r2 = r2 + 1;
    L11:
        if (r2 >= r5) goto L26;
        Integer r7 = ArraysKt.getOrNull(kj4.a.g().C(), 0);
        if (r7 != null) goto L15;
    L21:
        r11.L$0 = r6;
        r11.I$0 = r5;
        r11.I$1 = r2;
        r11.label = 2;
        if (DelayKt.delay(200, r11) != r0) goto L24;
        return r0;
    L15:
        if (r7.intValue() < 0) goto L21;
        g49.d.d("ObricDoraGOnboardingUiStateBaseFragment", "obric take buds wear state: " + r7);
        MainCoroutineDispatcher r3 = Dispatchers.getMain();
        ObricDoraGOnboardingUiStateBaseFragment$refreshObricWearState$1$1$1 r4 = new ObricDoraGOnboardingUiStateBaseFragment$refreshObricWearState$1$1$1(r6, r7, null);
        r11.L$0 = null;
        r11.label = 1;
        if (BuildersKt.withContext(r3, r4, r11) != r0) goto L20;
        return r0;
    L20:
        return Unit.INSTANCE;
    L26:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
        goto L20
    L10:
        ResultKt.throwOnFailure(r10);
        r6 = this.this$0;
        r2 = 0;
        r5 = 2;
        r11 = this;
        goto L11
    }
}
