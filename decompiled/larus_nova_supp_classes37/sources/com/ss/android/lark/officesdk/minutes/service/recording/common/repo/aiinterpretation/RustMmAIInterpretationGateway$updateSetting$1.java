package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.RustMmAIInterpretationGateway", f = "RustMmAIInterpretationGateway.kt", i = {}, l = {135}, m = "updateSetting-yxL6bBk", n = {}, s = {})
public final class RustMmAIInterpretationGateway$updateSetting$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RustMmAIInterpretationGateway this$0;

    public RustMmAIInterpretationGateway$updateSetting$1(RustMmAIInterpretationGateway r1, Continuation<? super RustMmAIInterpretationGateway$updateSetting$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        Object r8 = this.this$0.a(null, null, false, null, this);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r8;
    L6:
        return Result.box-impl(r8);
    }
}
