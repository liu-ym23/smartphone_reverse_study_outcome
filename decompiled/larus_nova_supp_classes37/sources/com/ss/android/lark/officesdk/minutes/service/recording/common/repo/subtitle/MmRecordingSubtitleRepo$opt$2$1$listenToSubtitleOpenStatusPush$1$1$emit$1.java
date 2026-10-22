package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1$1", f = "MmRecordingSubtitleRepo.kt", i = {2, 2, 3, 3}, l = {793, 794, 797, 798, 808, 809}, m = "emit", n = {"response", "source", "response", "source"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1.AnonymousClass1<T> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1$1$emit$1(MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1.AnonymousClass1<? super T> r1, Continuation<? super MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1$1$emit$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, (Continuation<? super Unit>) this);
    }
}
