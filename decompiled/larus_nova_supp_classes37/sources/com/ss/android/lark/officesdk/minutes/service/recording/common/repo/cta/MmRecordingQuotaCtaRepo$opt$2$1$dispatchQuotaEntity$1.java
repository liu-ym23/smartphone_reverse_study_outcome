package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmRecordingQuotaCtaRepo$opt$2$1", f = "MmRecordingQuotaCtaRepo.kt", i = {0, 0}, l = {108, 111}, m = "dispatchQuotaEntity", n = {"previousAsrQuotaBlocked", "currentAsrQuotaBlocked"}, s = {"L$0", "Z$0"})
final class MmRecordingQuotaCtaRepo$opt$2$1$dispatchQuotaEntity$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingQuotaCtaRepo$opt$2.AnonymousClass1 this$0;

    public MmRecordingQuotaCtaRepo$opt$2$1$dispatchQuotaEntity$1(MmRecordingQuotaCtaRepo$opt$2.AnonymousClass1 r1, Continuation<? super MmRecordingQuotaCtaRepo$opt$2$1$dispatchQuotaEntity$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return MmRecordingQuotaCtaRepo$opt$2.AnonymousClass1.T0(this.this$0, null, this);
    }
}
