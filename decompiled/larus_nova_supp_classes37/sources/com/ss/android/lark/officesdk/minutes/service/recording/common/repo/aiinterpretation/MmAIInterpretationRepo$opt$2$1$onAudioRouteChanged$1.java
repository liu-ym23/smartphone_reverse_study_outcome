package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.MmAIInterpretationRepo$opt$2$1$onAudioRouteChanged$1", f = "MmAIInterpretationRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmAIInterpretationRepo$opt$2$1$onAudioRouteChanged$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmAIInterpretationRepo this$0;

    public MmAIInterpretationRepo$opt$2$1$onAudioRouteChanged$1(MmAIInterpretationRepo r1, Continuation<? super MmAIInterpretationRepo$opt$2$1$onAudioRouteChanged$1> r2) {
        this.this$0 = r1;
        super(1, r2);
    }

    public final Continuation<Unit> create(Continuation<?> r3) {
        return new MmAIInterpretationRepo$opt$2$1$onAudioRouteChanged$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L27;
        ResultKt.throwOnFailure(r13);
        b r14 = this.this$0.k;
        r14.getClass();
        long r0 = System.currentTimeMillis();
        boolean r2 = r14.b.a();
        boolean r3 = r14.c();
        boolean r5 = true;
        if (r14.e == true) goto L7;
    L10:
        boolean r4 = false;
    L11:
        long r7 = r14.m;
        if (r7 > 0) goto L14;
    L16:
        boolean r1 = false;
    L17:
        lvb.a.e("MmAIInterpretationAudioController", "[onAudioRouteChanged] aiEnabled=" + r14.e + ", lastHasHeadset=" + r14.k + ", hasHeadset=" + r2 + ", forceHeadset=" + r3 + ", shouldPrompt=" + r4 + ", suppressPrompt=" + r1);
        r14.k = Boolean.valueOf(r2);
        if (r14.e == false) goto L25;
        if (r4 == false) goto L22;
        if (r1 == true) goto L22;
    L23:
        r14.b(r5, HeadsetPromptSource.AUDIO_ROUTE_CHANGED);
    L22:
        r5 = false;
    L25:
        return Unit.INSTANCE;
    L14:
        if ((r0 - r7) >= 1500) goto L16;
        r1 = true;
        goto L17
    L7:
        if (Intrinsics.areEqual(r14.k, Boolean.TRUE) == false) goto L10;
        if (r2 == true) goto L10;
        r4 = true;
        goto L11
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
