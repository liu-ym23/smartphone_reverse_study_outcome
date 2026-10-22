package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRepo$opt$2$1$setPlaybackMuted$2", f = "MmStandaloneAIInterpretationRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmStandaloneAIInterpretationRepo$opt$2$1$setPlaybackMuted$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $muted;
    int label;
    final /* synthetic */ MmStandaloneAIInterpretationRepo$opt$2.AnonymousClass1 this$0;
    final /* synthetic */ MmStandaloneAIInterpretationRepo this$1;

    public MmStandaloneAIInterpretationRepo$opt$2$1$setPlaybackMuted$2(MmStandaloneAIInterpretationRepo$opt$2.AnonymousClass1 r1, MmStandaloneAIInterpretationRepo r2, boolean r3, Continuation<? super MmStandaloneAIInterpretationRepo$opt$2$1$setPlaybackMuted$2> r4) {
        this.this$0 = r1;
        this.this$1 = r2;
        this.$muted = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new MmStandaloneAIInterpretationRepo$opt$2$1$setPlaybackMuted$2(this.this$0, this.this$1, this.$muted, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r8);
        b r9 = (b) this.this$0.m();
        MmStandaloneAIInterpretationRepo r0 = this.this$1;
        MmStandaloneAIInterpretationRepo.Companion r1 = MmStandaloneAIInterpretationRepo.t;
        e r2 = r0.u();
        boolean r3 = this.$muted;
        boolean r4 = r9.a;
        r2.k = r3;
        r2.j = null;
        r2.b.invoke(Boolean.valueOf(r3));
        boolean r5 = true;
        if (r4 == true) goto L7;
    L9:
        boolean r6 = false;
    L10:
        boolean r7 = r2.b(r4);
        if (r6 == true) goto L15;
        if (r7 == true) goto L15;
        r5 = false;
    L15:
        boolean r10 = r2.i;
        lvb.a.e(this.this$1.l, "[setPlaybackMuted] userMuted=" + this.$muted + ", actualMuted=" + r3 + ", changeToOrigin=" + r10 + ", enabled=" + r9.a + ", rtcInitialized=" + this.this$1.u().f + ", appliedToRtc=" + r5);
        return Unit.INSTANCE;
    L7:
        if (r2.f == false) goto L9;
        r2.c.invoke(Boolean.valueOf(r3));
        r6 = true;
        goto L10
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
