package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmAudioSaveType;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.MmAIInterpretationRepo$opt$2$1$onAudioSaveChanged$1", f = "MmAIInterpretationRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmAIInterpretationRepo$opt$2$1$onAudioSaveChanged$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ MmAudioSaveType $audioSaveType;
    int label;
    final /* synthetic */ MmAIInterpretationRepo this$0;

    public MmAIInterpretationRepo$opt$2$1$onAudioSaveChanged$1(MmAIInterpretationRepo r1, MmAudioSaveType r2, Continuation<? super MmAIInterpretationRepo$opt$2$1$onAudioSaveChanged$1> r3) {
        this.this$0 = r1;
        this.$audioSaveType = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new MmAIInterpretationRepo$opt$2$1$onAudioSaveChanged$1(this.this$0, this.$audioSaveType, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r7);
        lvb.a.e(this.this$0.n, "[onAudioSaveChanged] audioSaveType=" + this.$audioSaveType);
        MmAIInterpretationRepo r8 = this.this$0;
        MmAudioSaveType r0 = this.$audioSaveType;
        r8.o = r0;
        b r9 = r8.k;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r0, "currentAudioSaveType");
        int r2 = c.a;
        boolean r3 = r9.e;
        boolean r4 = r9.c();
        MmAudioSaveType r5 = r9.f;
        Intrinsics.checkNotNullParameter(r5, "previousAudioSaveType");
        Intrinsics.checkNotNullParameter(r0, "currentAudioSaveType");
        if (r3 == false) goto L12;
        if (r4 == false) goto L12;
        if (r5 != MmAudioSaveType.NOT_SAVE) goto L12;
        if (r0 != MmAudioSaveType.SAVE) goto L12;
        boolean r1 = true;
    L13:
        lvb.a.e("MmAIInterpretationAudioController", "[onAudioSaveChanged] previousAudioSaveType=" + r9.f + ", currentAudioSaveType=" + r0 + ", aiEnabled=" + r9.e + ", allowHeadsetPrompt=" + r1);
        r9.f = r0;
        if (r9.e == false) goto L17;
        r9.b(r1, HeadsetPromptSource.AUDIO_SAVE_CHANGED);
    L17:
        return Unit.INSTANCE;
    L12:
        r1 = false;
        goto L13
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
