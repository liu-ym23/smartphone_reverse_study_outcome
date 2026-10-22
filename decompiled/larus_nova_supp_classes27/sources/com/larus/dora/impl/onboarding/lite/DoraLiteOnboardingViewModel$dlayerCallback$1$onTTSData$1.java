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
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingViewModel$dlayerCallback$1$onTTSData$1", f = "DoraLiteOnboardingViewModel.kt", i = {}, l = {541}, m = "invokeSuspend", n = {}, s = {})
public final class DoraLiteOnboardingViewModel$dlayerCallback$1$onTTSData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $data;
    int label;
    final /* synthetic */ DoraLiteOnboardingViewModel$dlayerCallback$1 this$0;
    final /* synthetic */ DoraLiteOnboardingViewModel this$1;

    public DoraLiteOnboardingViewModel$dlayerCallback$1$onTTSData$1(DoraLiteOnboardingViewModel$dlayerCallback$1 r1, DoraLiteOnboardingViewModel r2, byte[] r3, Continuation<? super DoraLiteOnboardingViewModel$dlayerCallback$1$onTTSData$1> r4) {
        this.this$0 = r1;
        this.this$1 = r2;
        this.$data = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraLiteOnboardingViewModel$dlayerCallback$1$onTTSData$1(this.this$0, this.this$1, this.$data, r5);
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
    L14:
        DoraLiteOnboardingViewModel.access$getTtsDataCacheList$p(this.this$1).add(this.$data);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        if (this.this$0.a.compareAndSet(true, false) == false) goto L11;
        DoraLiteOnboardingViewModel.access$get_avatarUiStateFlow$p(this.this$1).tryEmit(AvatarUiState.SPEAKING);
    L11:
        MutableSharedFlow r5 = DoraLiteOnboardingViewModel.access$get_ttsDataSharedFlow$p(this.this$1);
        byte[] r2 = this.$data;
        this.label = 1;
        if (r5.emit(r2, this) != r0) goto L14;
        return r0;
    }
}
