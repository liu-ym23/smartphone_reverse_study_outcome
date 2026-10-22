package com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware.MmHardwareCallRecordingStartDelegate", f = "MmHardwareCallRecordingStartDelegate.kt", i = {}, l = {212}, m = "awaitLocalCaptureReady", n = {}, s = {})
public final class MmHardwareCallRecordingStartDelegate$awaitLocalCaptureReady$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmHardwareCallRecordingStartDelegate this$0;

    public MmHardwareCallRecordingStartDelegate$awaitLocalCaptureReady$1(MmHardwareCallRecordingStartDelegate r1, Continuation<? super MmHardwareCallRecordingStartDelegate$awaitLocalCaptureReady$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        MmHardwareCallRecordingStartDelegate r3 = this.this$0;
        int r0 = MmHardwareCallRecordingStartDelegate.g;
        return r3.a(null, this);
    }
}
