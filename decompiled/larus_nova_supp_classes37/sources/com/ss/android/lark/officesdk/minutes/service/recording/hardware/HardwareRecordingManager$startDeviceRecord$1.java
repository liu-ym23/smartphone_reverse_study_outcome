package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 3, 4, 5, 5, 5, 6, 6}, l = {513, 518, 522, 533, 543, 554, 562}, m = "startDeviceRecord", n = {"adapter", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "initialPlaybackState", "restoreLegacyRecordingOnFailure", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "initialPlaybackState", "recordingSession", "isMuted", "initialPlaybackState", "recordingSession", "recordingSession", "recordingSession", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "result", "restoreLegacyRecordingOnFailure", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "result"}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$0", "L$0", "L$0", "L$1", "Z$0", "L$0", "L$1"})
final class HardwareRecordingManager$startDeviceRecord$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$startDeviceRecord$1(d r1, Continuation<? super HardwareRecordingManager$startDeviceRecord$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.o(null, this);
    }
}
