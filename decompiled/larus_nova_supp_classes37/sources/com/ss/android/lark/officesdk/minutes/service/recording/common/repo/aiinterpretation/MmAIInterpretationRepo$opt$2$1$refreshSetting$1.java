package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.MmAIInterpretationRepo$opt$2$1", f = "MmAIInterpretationRepo.kt", i = {0, 0}, l = {32, ItemViewType.ITEM_VIEW_TYPE_WIKI_SPACE, ItemViewType.ITEM_VIEW_TYPE_COLD_AND_HOT}, m = "refreshSetting", n = {"meetingId", "breakoutRoomId"}, s = {"L$0", "L$1"})
public final class MmAIInterpretationRepo$opt$2$1$refreshSetting$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmAIInterpretationRepo$opt$2.AnonymousClass1 this$0;

    public MmAIInterpretationRepo$opt$2$1$refreshSetting$1(MmAIInterpretationRepo$opt$2.AnonymousClass1 r1, Continuation<? super MmAIInterpretationRepo$opt$2$1$refreshSetting$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.r0(null, null, this);
    }
}
