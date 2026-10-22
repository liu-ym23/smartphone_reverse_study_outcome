package com.larus.dora.impl.onboarding.lite;

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
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingViewModel$doraVoiceCallback$1$onVUIPlayState$1", f = "DoraLiteOnboardingViewModel.kt", i = {0, 0, 0, 1, 1, 1}, l = {216, 228}, m = "invokeSuspend", n = {"$this$update$iv", "prevValue$iv", "it", "$this$update$iv", "prevValue$iv", "it"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
public final class DoraLiteOnboardingViewModel$doraVoiceCallback$1$onVUIPlayState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ DoraLiteOnboardingViewModel this$0;

    public DoraLiteOnboardingViewModel$doraVoiceCallback$1$onVUIPlayState$1(DoraLiteOnboardingViewModel r1, Continuation<? super DoraLiteOnboardingViewModel$doraVoiceCallback$1$onVUIPlayState$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraLiteOnboardingViewModel$doraVoiceCallback$1$onVUIPlayState$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0069 -> B:27:0x0091). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x006b -> B:27:0x0091). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0070 -> B:27:0x0091). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0083 -> B:24:0x0086). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        Object r2 = (y0) this.L$2;
        Object r5 = this.L$1;
        z0 r6 = (z0) this.L$0;
        ResultKt.throwOnFailure(r11);
        DoraLiteOnboardingViewModel$doraVoiceCallback$1$onVUIPlayState$1 r12 = this;
    L24:
        g49.d.d("DoraOnboardingViewModel", "onVUIPlayState: change UiState QueryTopicReenter -> QueryAnswering");
        if ((r2 instanceof y0.e) == false) goto L28;
        r2 = y0.a.b;
    L28:
        if (r6.compareAndSet(r5, r2) == true) goto L30;
    L11:
        r5 = r6.getValue();
        r2 = (y0) r5;
        if ((r2 instanceof y0.d) == false) goto L20;
        g49.d.d("DoraOnboardingViewModel", "onVUIPlayState: change UiState QueryTopic(start delay) -> QueryAnswering");
        r12.L$0 = r6;
        r12.L$1 = r5;
        r12.L$2 = r2;
        r12.label = 1;
        if (DelayKt.delay(3000, r12) != r0) goto L16;
        return r0;
    L16:
        g49.d.d("DoraOnboardingViewModel", "onVUIPlayState: change UiState QueryTopic -> QueryAnswering");
        if ((r2 instanceof y0.d) == false) goto L28;
        r2 = y0.a.b;
        goto L28
    L20:
        if ((r2 instanceof y0.e) == false) goto L28;
        g49.d.d("DoraOnboardingViewModel", "onVUIPlayState: change UiState QueryTopicReenter(start delay) -> QueryAnswering");
        r12.L$0 = r6;
        r12.L$1 = r5;
        r12.L$2 = r2;
        r12.label = 2;
        if (DelayKt.delay(3000, r12) != r0) goto L24;
        return r0;
    L30:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r2 = (y0) this.L$2;
        r5 = this.L$1;
        r6 = (z0) this.L$0;
        ResultKt.throwOnFailure(r11);
        r12 = this;
        goto L16
    L10:
        ResultKt.throwOnFailure(r11);
        r6 = DoraLiteOnboardingViewModel.access$get_wakeupQueryUiStateFlow$p(this.this$0);
        r12 = this;
        goto L11
    }
}
