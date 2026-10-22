package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 0, 0, 1, 1, 1, 2}, l = {760, 761, 765}, m = "endInterruptedSessionLocked", n = {AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "reason", "restoreLegacyRecording", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "reason", "restoreLegacyRecording", "endResult"}, s = {"L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0", "L$0"})
final class HardwareRecordingManager$endInterruptedSessionLocked$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$endInterruptedSessionLocked$1(d r1, Continuation<? super HardwareRecordingManager$endInterruptedSessionLocked$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.l(null, null, false, this);
    }
}
