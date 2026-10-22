package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRepo", f = "MmStandaloneAIInterpretationRepo.kt", i = {0, 0}, l = {472}, m = "sendSwitchTargetLanguageRequest", n = {"language", "enabled"}, s = {"L$0", "Z$0"})
public final class MmStandaloneAIInterpretationRepo$sendSwitchTargetLanguageRequest$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmStandaloneAIInterpretationRepo this$0;

    public MmStandaloneAIInterpretationRepo$sendSwitchTargetLanguageRequest$1(MmStandaloneAIInterpretationRepo r1, Continuation<? super MmStandaloneAIInterpretationRepo$sendSwitchTargetLanguageRequest$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        MmStandaloneAIInterpretationRepo r4 = this.this$0;
        MmStandaloneAIInterpretationRepo.Companion r0 = MmStandaloneAIInterpretationRepo.t;
        return r4.v(null, false, null, this);
    }
}
