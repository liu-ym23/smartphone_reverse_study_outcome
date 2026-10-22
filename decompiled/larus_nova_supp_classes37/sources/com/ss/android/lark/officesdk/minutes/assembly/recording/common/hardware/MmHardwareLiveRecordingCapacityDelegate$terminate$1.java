package com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import com.ss.android.lark.picker.base.view.ItemViewType;
import iub.j;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware.MmHardwareLiveRecordingCapacityDelegate", f = "MmHardwareLiveRecordingCapacityDelegate.kt", i = {}, l = {62}, m = "terminate-0E7RQCE", n = {}, s = {})
final class MmHardwareLiveRecordingCapacityDelegate$terminate$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmHardwareLiveRecordingCapacityDelegate this$0;

    public MmHardwareLiveRecordingCapacityDelegate$terminate$1(MmHardwareLiveRecordingCapacityDelegate r1, Continuation<? super MmHardwareLiveRecordingCapacityDelegate$terminate$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object r6) {
        this.result = r6;
        this.label |= Integer.MIN_VALUE;
        final MmHardwareLiveRecordingCapacityDelegate r7 = this.this$0;
        r7.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        MmHardwareLiveRecordingCapacityDelegate$terminate$1 r0 = this;
    L6:
        Object r2 = r0.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r0.label;
        if (r4 == 0) goto L12;
        if (r4 != 1) goto L11;
        ResultKt.throwOnFailure(r2);
        Object r8 = ((Result) r2).unbox-impl();
    L16:
        if (Result.isSuccess-impl(r8) == false) goto L18;
        j r9 = (j) r8;
        r8 = Unit.INSTANCE;
    L18:
        r3 = Result.constructor-impl(r8);
    L20:
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L23;
        return r3;
    L23:
        return Result.box-impl(r3);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r2);
        final String r5 = null;
        final Object[] r10 = 0 == true ? 1 : 0;
        Function1<iub.a<j, ? super MmRecordingError>, Unit> r11 = new MmHardwareLiveRecordingCapacityDelegate$terminate$2(r7, r5, r10);
        r0.label = 1;
        r8 = r7.a(null, r11, r0);
        if (r8 != r3) goto L16;
    L5:
        r0 = new MmHardwareLiveRecordingCapacityDelegate$terminate$1(r7, this);
        goto L6
    }
}
