package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.event.SubtitleSource;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo$opt$2$1$loadForwardSubtitles$1", f = "MmRecordingSubtitleRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingSubtitleRepo$opt$2$1$loadForwardSubtitles$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ long $count;
    final /* synthetic */ String $meetingId;
    final /* synthetic */ long $targetSeqId;
    final /* synthetic */ String $translateLanguage;
    int label;
    final /* synthetic */ MmRecordingSubtitleRepo$opt$2.AnonymousClass1 this$0;
    final /* synthetic */ MmRecordingSubtitleRepo this$1;

    public MmRecordingSubtitleRepo$opt$2$1$loadForwardSubtitles$1(MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r1, MmRecordingSubtitleRepo r2, String r3, String r4, long r5, long r7, Continuation<? super MmRecordingSubtitleRepo$opt$2$1$loadForwardSubtitles$1> r9) {
        this.this$0 = r1;
        this.this$1 = r2;
        this.$meetingId = r3;
        this.$translateLanguage = r4;
        this.$targetSeqId = r5;
        this.$count = r7;
        super(1, r9);
    }

    public final Continuation<Unit> create(Continuation<?> r12) {
        return new MmRecordingSubtitleRepo$opt$2$1$loadForwardSubtitles$1(this.this$0, this.this$1, this.$meetingId, this.$translateLanguage, this.$targetSeqId, this.$count, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r12);
        if (((d) this.this$0.m()).c == true) goto L8;
        lvb.a.e(this.this$1.m, "[loadForwardSubtitles] no more data");
        return Unit.INSTANCE;
    L8:
        String r13 = this.this$1.m;
        StringBuilder r0 = new StringBuilder("[loadForwardSubtitles] meetingId=");
        r0.append(this.$meetingId);
        r0.append(", effectiveLanguage=");
        r0.append(this.$translateLanguage);
        r0.append(", targetSeqId=");
        r0.append(this.$targetSeqId);
        r0.append(", source=");
        SubtitleSource r9 = SubtitleSource.PULL_TO_REFRESH;
        r0.append(r9);
        lvb.a.e(r13, r0.toString());
        this.this$0.Q(this.$meetingId, this.$translateLanguage, Boxing.boxLong(this.$targetSeqId), true, this.$count, r9, false);
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
