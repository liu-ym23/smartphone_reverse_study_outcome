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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.MmAIInterpretationRepo$opt$2$1$onPlaybackVolumeChanged$1", f = "MmAIInterpretationRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmAIInterpretationRepo$opt$2$1$onPlaybackVolumeChanged$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmAIInterpretationRepo this$0;

    public MmAIInterpretationRepo$opt$2$1$onPlaybackVolumeChanged$1(MmAIInterpretationRepo r1, Continuation<? super MmAIInterpretationRepo$opt$2$1$onPlaybackVolumeChanged$1> r2) {
        this.this$0 = r1;
        super(1, r2);
    }

    public final Continuation<Unit> create(Continuation<?> r3) {
        return new MmAIInterpretationRepo$opt$2$1$onPlaybackVolumeChanged$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L23;
        ResultKt.throwOnFailure(r11);
        b r12 = this.this$0.k;
        r12.getClass();
        long r0 = System.currentTimeMillis();
        long r2 = r12.m;
        boolean r6 = false;
        if (r2 > 0) goto L7;
    L9:
        boolean r3 = false;
    L11:
        if ((r0 - r12.l) < 2000) goto L14;
        if (r3 == true) goto L14;
        r6 = true;
    L14:
        lvb.a.e("MmAIInterpretationAudioController", "[onPlaybackVolumeChanged] aiEnabled=" + r12.e + ", hasHeadset=" + r12.b.a() + ", allowPrompt=" + r6 + ", suppressPrompt=" + r3);
        if (r12.e == false) goto L21;
        if (r12.c() == false) goto L21;
        if (r6 == false) goto L21;
        r12.l = r0;
        r12.b(true, HeadsetPromptSource.PLAYBACK_VOLUME_CHANGED);
    L21:
        return Unit.INSTANCE;
    L7:
        if ((r0 - r2) >= 1500) goto L9;
        r3 = true;
        goto L11
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
