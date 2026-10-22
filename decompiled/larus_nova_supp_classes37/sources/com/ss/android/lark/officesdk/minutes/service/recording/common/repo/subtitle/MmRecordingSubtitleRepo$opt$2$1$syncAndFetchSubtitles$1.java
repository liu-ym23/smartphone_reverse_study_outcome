package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.event.SubtitleSource;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingSyncSubtitlesResponse;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo$opt$2$1$syncAndFetchSubtitles$1", f = "MmRecordingSubtitleRepo.kt", i = {0}, l = {622, 698}, m = "invokeSuspend", n = {"skipHistoryRefresh"}, s = {"L$0"})
final class MmRecordingSubtitleRepo$opt$2$1$syncAndFetchSubtitles$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $count;
    final /* synthetic */ boolean $forceSync;
    final /* synthetic */ boolean $isForward;
    final /* synthetic */ String $meetingId;
    final /* synthetic */ SubtitleSource $source;
    final /* synthetic */ Long $targetSeqId;
    final /* synthetic */ String $translateLanguage;
    Object L$0;
    int label;
    final /* synthetic */ MmRecordingSubtitleRepo this$0;
    final /* synthetic */ MmRecordingSubtitleRepo$opt$2.AnonymousClass1 this$1;

    public MmRecordingSubtitleRepo$opt$2$1$syncAndFetchSubtitles$1(String r1, MmRecordingSubtitleRepo r2, String r3, SubtitleSource r4, boolean r5, MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r6, Long r7, boolean r8, long r9, Continuation<? super MmRecordingSubtitleRepo$opt$2$1$syncAndFetchSubtitles$1> r11) {
        this.$meetingId = r1;
        this.this$0 = r2;
        this.$translateLanguage = r3;
        this.$source = r4;
        this.$forceSync = r5;
        this.this$1 = r6;
        this.$targetSeqId = r7;
        this.$isForward = r8;
        this.$count = r9;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        return new MmRecordingSubtitleRepo$opt$2$1$syncAndFetchSubtitles$1(this.$meetingId, this.this$0, this.$translateLanguage, this.$source, this.$forceSync, this.this$1, this.$targetSeqId, this.$isForward, this.$count, r14);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r15);
        Object r16 = ((Result) r15).unbox-impl();
    L24:
        MmRecordingSubtitleRepo r2 = this.this$0;
        if (Result.isSuccess-impl(r16) == false) goto L27;
        MinutesRecordingSyncSubtitlesResponse r3 = (MinutesRecordingSyncSubtitlesResponse) r16;
        lvb.a.e(r2.m, "[syncAndFetchSubtitles] sync success");
    L27:
        MmRecordingSubtitleRepo r4 = this.this$0;
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L31;
        lvb.a.b(r4.m, "[syncAndFetchSubtitles] sync failed, error=" + r17);
    L31:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Ref.BooleanRef r5 = (Ref.BooleanRef) this.L$0;
        ResultKt.throwOnFailure(r15);
    L17:
        long r12 = ((Number) r15).longValue();
        if (r5.element == false) goto L21;
        lvb.a.e(this.this$0.m, "[syncAndFetchSubtitles] skip Doubao history refresh, meetingId=" + this.$meetingId + ", language=" + this.$translateLanguage + ", source=" + this.$source);
        return Unit.INSTANCE;
    L21:
        lvb.a.e(this.this$0.m, "[syncAndFetchSubtitles] start sync, meetingId=" + this.$meetingId + ", force=" + this.$forceSync + ", source=" + this.$source);
        this.this$1.b1(this.$meetingId, this.$translateLanguage, this.$targetSeqId, this.$isForward, this.$count, this.$source, true, r12);
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.a r18 = this.this$1.e;
        String r6 = this.$meetingId;
        boolean r7 = this.$forceSync;
        String r8 = this.$translateLanguage;
        this.L$0 = null;
        this.label = 2;
        r16 = r18.h(r6, r7, r8, this);
        if (r16 != r0) goto L24;
        return r0;
    L10:
        ResultKt.throwOnFailure(r15);
        if (StringsKt.isBlank(this.$meetingId) == false) goto L14;
        lvb.a.b(this.this$0.m, "[syncAndFetchSubtitles] failed, meetingId is empty");
        return Unit.INSTANCE;
    L14:
        r5 = new Ref.BooleanRef();
        MmRecordingSubtitleRepo r19 = this.this$0;
        MmRecordingSubtitleRepo$opt$2$1$syncAndFetchSubtitles$1$requestLanguageRevision$1 r11 = new MmRecordingSubtitleRepo$opt$2$1$syncAndFetchSubtitles$1$requestLanguageRevision$1(r5, r19, this.this$1, this.$source, this.$translateLanguage, null);
        this.L$0 = r5;
        this.label = 1;
        r15 = r19.e.b(r11, this);
        if (r15 != r0) goto L17;
        return r0;
    }
}
