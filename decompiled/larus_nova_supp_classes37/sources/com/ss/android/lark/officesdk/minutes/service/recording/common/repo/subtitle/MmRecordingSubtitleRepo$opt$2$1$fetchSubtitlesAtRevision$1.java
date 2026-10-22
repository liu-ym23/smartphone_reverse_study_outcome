package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.event.SubtitleSource;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingPullSubtitlesResponse;
import com.ss.android.lark.pb.minutes.v1.RecordingSubtitleData;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo$opt$2$1$fetchSubtitlesAtRevision$1", f = "MmRecordingSubtitleRepo.kt", i = {}, l = {506}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingSubtitleRepo$opt$2$1$fetchSubtitlesAtRevision$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $count;
    final /* synthetic */ boolean $forceFromServer;
    final /* synthetic */ boolean $isForward;
    final /* synthetic */ String $meetingId;
    final /* synthetic */ long $requestLanguageRevision;
    final /* synthetic */ SubtitleSource $source;
    final /* synthetic */ Long $targetSeqId;
    final /* synthetic */ String $translateLanguage;
    int label;
    final /* synthetic */ MmRecordingSubtitleRepo this$0;
    final /* synthetic */ MmRecordingSubtitleRepo$opt$2.AnonymousClass1 this$1;

    public MmRecordingSubtitleRepo$opt$2$1$fetchSubtitlesAtRevision$1(String r1, String r2, MmRecordingSubtitleRepo r3, SubtitleSource r4, Long r5, boolean r6, long r7, MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r9, long r10, boolean r12, Continuation<? super MmRecordingSubtitleRepo$opt$2$1$fetchSubtitlesAtRevision$1> r13) {
        this.$meetingId = r1;
        this.$translateLanguage = r2;
        this.this$0 = r3;
        this.$source = r4;
        this.$targetSeqId = r5;
        this.$isForward = r6;
        this.$requestLanguageRevision = r7;
        this.this$1 = r9;
        this.$count = r10;
        this.$forceFromServer = r12;
        super(2, r13);
    }

    public final Continuation<Unit> create(Object r17, Continuation<?> r18) {
        return new MmRecordingSubtitleRepo$opt$2$1$fetchSubtitlesAtRevision$1(this.$meetingId, this.$translateLanguage, this.this$0, this.$source, this.$targetSeqId, this.$isForward, this.$requestLanguageRevision, this.this$1, this.$count, this.$forceFromServer, r18);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r22) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r22);
        Object r1 = ((Result) r22).unbox-impl();
    L16:
        MmRecordingSubtitleRepo r2 = this.this$0;
        Long r3 = this.$targetSeqId;
        MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r11 = this.this$1;
        boolean r4 = this.$isForward;
        String r15 = this.$translateLanguage;
        long r12 = this.$requestLanguageRevision;
        SubtitleSource r5 = this.$source;
        if (Result.isSuccess-impl(r1) == false) goto L27;
        MinutesRecordingPullSubtitlesResponse r6 = (MinutesRecordingPullSubtitlesResponse) r1;
        String r7 = r2.m;
        StringBuilder r8 = new StringBuilder("[fetchSubtitles] success, targetSeqId=");
        r8.append(r3);
        r8.append(",  size=");
        List<RecordingSubtitleData> r9 = r6.subtitles;
        if (r9 == null) goto L21;
        Integer r13 = Boxing.boxInt(r9.size());
    L22:
        r8.append(r13);
        r8.append(", currentList: ");
        List<RecordingSubtitleData> r14 = r6.subtitles;
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r17 = r14.iterator();
    L24:
        if (r17.hasNext() == false) goto L26;
        RecordingSubtitleData r18 = (RecordingSubtitleData) r17.next();
        StringBuilder r19 = new StringBuilder();
        r19.append(r18.seg_id);
        r19.append("_isFinal:");
        r19.append(r18.is_seg_final);
        r16.add(r19.toString());
        r17 = r17;
        goto L24
    L26:
        r8.append(r16);
        r8.append(", hasMore=");
        r8.append(r6.has_more);
        lvb.a.e(r7, r8.toString());
        MmRecordingSubtitleRepo r20 = r11.s;
        r20.j(new MmRecordingSubtitleRepo$opt$2$1$handleFetchSubtitlesResponse$1(r11, r12, r20, r15, r5, r6, r3, r4, null));
        goto L27
    L21:
        r13 = null;
    L27:
        MmRecordingSubtitleRepo r21 = this.this$0;
        Throwable r23 = Result.exceptionOrNull-impl(r1);
        if (r23 == null) goto L31;
        lvb.a.b(r21.m, "[fetchSubtitles] failed, error=" + r23);
    L31:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r22);
        if (StringsKt.isBlank(this.$meetingId) == false) goto L11;
    L32:
        lvb.a.b(this.this$0.m, "[fetchSubtitles] failed, meetingId=" + this.$meetingId + ", translateLanguage=" + this.$translateLanguage + ", source=" + this.$source);
        return Unit.INSTANCE;
    L11:
        if (StringsKt.isBlank(this.$translateLanguage) == true) goto L32;
        lvb.a.e(this.this$0.m, "[fetchSubtitles] meetingId=" + this.$meetingId + ", targetSeqId=" + this.$targetSeqId + ", isForward=" + this.$isForward + ", lang=" + this.$translateLanguage + ", source=" + this.$source + ", revision=" + this.$requestLanguageRevision);
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.a r24 = this.this$1.e;
        String r25 = this.$meetingId;
        String r26 = this.$translateLanguage;
        Long r27 = this.$targetSeqId;
        boolean r28 = this.$isForward;
        long r29 = this.$count;
        boolean r30 = this.$forceFromServer;
        this.label = 1;
        r1 = r24.g(r25, r26, r27, r28, r29, r30, this);
        if (r1 != r10) goto L16;
        return r10;
    }
}
