package com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware.MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1$1", f = "MmHardwareCallRecordingStartDelegate.kt", i = {0}, l = {200}, m = "emit", n = {"endReason"}, s = {"L$0"})
final class MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1.a<Object> this$0;

    public MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1$1$emit$1(MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1.a<Object> r1, Continuation<? super MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1$1$emit$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
