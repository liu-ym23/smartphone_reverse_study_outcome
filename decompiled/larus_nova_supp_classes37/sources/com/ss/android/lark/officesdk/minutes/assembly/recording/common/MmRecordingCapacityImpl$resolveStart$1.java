package com.ss.android.lark.officesdk.minutes.assembly.recording.common;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.assembly.recording.common.MmRecordingCapacityImpl", f = "MmRecordingCapacityImpl.kt", i = {}, l = {1272}, m = "resolveStart-BWLJW6A", n = {}, s = {})
final class MmRecordingCapacityImpl$resolveStart$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingCapacityImpl this$0;

    public MmRecordingCapacityImpl$resolveStart$1(MmRecordingCapacityImpl r1, Continuation<? super MmRecordingCapacityImpl$resolveStart$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r6) {
        this.result = r6;
        this.label |= Integer.MIN_VALUE;
        MmRecordingCapacityImpl r7 = this.this$0;
        r7.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        MmRecordingCapacityImpl$resolveStart$1 r0 = this;
    L6:
        Object r2 = r0.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r0.label;
        if (r4 == 0) goto L12;
        if (r4 != 1) goto L11;
        ResultKt.throwOnFailure(r2);
        Object r8 = ((Result) r2).unbox-impl();
    L15:
        r3 = r8;
    L17:
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        return r3;
    L20:
        return Result.box-impl(r3);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r2);
        r7.g();
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.orchestrator.b r9 = r7.i().v();
        r0.label = 1;
        r8 = r9.b(null, null, r0);
        if (r8 != r3) goto L15;
    L5:
        r0 = new MmRecordingCapacityImpl$resolveStart$1(r7, this);
        goto L6
    }
}
