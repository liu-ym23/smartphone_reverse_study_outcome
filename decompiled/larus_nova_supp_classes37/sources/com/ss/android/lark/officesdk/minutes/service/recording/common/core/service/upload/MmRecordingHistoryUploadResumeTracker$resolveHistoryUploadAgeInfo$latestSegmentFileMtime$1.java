package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingHistoryUploadResumeTracker$resolveHistoryUploadAgeInfo$latestSegmentFileMtime$1", f = "MmRecordingHistoryUploadResumeTracker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingHistoryUploadResumeTracker$resolveHistoryUploadAgeInfo$latestSegmentFileMtime$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    final /* synthetic */ List<File> $segmentFiles;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public MmRecordingHistoryUploadResumeTracker$resolveHistoryUploadAgeInfo$latestSegmentFileMtime$1(List<? extends File> r1, Continuation<? super MmRecordingHistoryUploadResumeTracker$resolveHistoryUploadAgeInfo$latestSegmentFileMtime$1> r2) {
        this.$segmentFiles = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmRecordingHistoryUploadResumeTracker$resolveHistoryUploadAgeInfo$latestSegmentFileMtime$1(this.$segmentFiles, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Long> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        List<File> r3 = this.$segmentFiles;
        Intrinsics.checkNotNullParameter(r3, "segmentFiles");
        return (Long) SequencesKt.maxOrNull(SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(r3), MmRecordingHistoryUploadResumeTrackerKt$resolveLatestSegmentFileMtime$1.INSTANCE), MmRecordingHistoryUploadResumeTrackerKt$resolveLatestSegmentFileMtime$2.INSTANCE));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
