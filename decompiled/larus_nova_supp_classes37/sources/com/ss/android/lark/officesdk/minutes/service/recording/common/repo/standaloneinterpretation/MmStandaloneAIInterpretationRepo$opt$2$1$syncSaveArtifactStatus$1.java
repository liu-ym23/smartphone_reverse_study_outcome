package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRepo$opt$2$1", f = "MmStandaloneAIInterpretationRepo.kt", i = {0, 1, 1, 1, 2, 2, 2, 2}, l = {271, 280, 294}, m = "syncSaveArtifactStatus", n = {"saveArtifactType", "recordingId", "saveArtifactType", "previousSaveArtifact", "recordingId", "commonSyncResult", "quotaDenyType", "saveArtifactType"}, s = {"Z$0", "L$0", "Z$0", "Z$1", "L$0", "L$1", "L$2", "Z$0"})
public final class MmStandaloneAIInterpretationRepo$opt$2$1$syncSaveArtifactStatus$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmStandaloneAIInterpretationRepo$opt$2.AnonymousClass1 this$0;

    public MmStandaloneAIInterpretationRepo$opt$2$1$syncSaveArtifactStatus$1(MmStandaloneAIInterpretationRepo$opt$2.AnonymousClass1 r1, Continuation<? super MmStandaloneAIInterpretationRepo$opt$2$1$syncSaveArtifactStatus$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.z0(false, this);
    }
}
