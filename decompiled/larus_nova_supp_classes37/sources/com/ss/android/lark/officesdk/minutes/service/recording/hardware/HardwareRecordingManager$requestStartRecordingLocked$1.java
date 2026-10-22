package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {184, 198, 210}, m = "requestStartRecordingLocked", n = {"request", "hardwareDeviceId", "restoreLegacyRecordingOnFailure", "request", "adapter", "sceneInstanceId", "initialPlaybackState", "restoreLegacyRecordingOnFailure", "timestampSeconds"}, s = {"L$0", "L$1", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "J$0"})
final class HardwareRecordingManager$requestStartRecordingLocked$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$requestStartRecordingLocked$1(d r1, Continuation<? super HardwareRecordingManager$requestStartRecordingLocked$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m(null, false, this);
    }
}
