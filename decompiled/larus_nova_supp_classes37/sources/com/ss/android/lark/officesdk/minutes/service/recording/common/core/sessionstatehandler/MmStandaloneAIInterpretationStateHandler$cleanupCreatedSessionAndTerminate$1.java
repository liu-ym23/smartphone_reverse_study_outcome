package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmStandaloneAIInterpretationStateHandler", f = "MmStandaloneAIInterpretationStateHandler.kt", i = {0, 1}, l = {377, 380}, m = "cleanupCreatedSessionAndTerminate", n = {"reason", "reason"}, s = {"L$0", "L$0"})
public final class MmStandaloneAIInterpretationStateHandler$cleanupCreatedSessionAndTerminate$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmStandaloneAIInterpretationStateHandler this$0;

    public MmStandaloneAIInterpretationStateHandler$cleanupCreatedSessionAndTerminate$1(MmStandaloneAIInterpretationStateHandler r1, Continuation<? super MmStandaloneAIInterpretationStateHandler$cleanupCreatedSessionAndTerminate$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        MmStandaloneAIInterpretationStateHandler r4 = this.this$0;
        MmStandaloneAIInterpretationStateHandler.a r0 = MmStandaloneAIInterpretationStateHandler.l;
        return r4.f(null, false, this);
    }
}
