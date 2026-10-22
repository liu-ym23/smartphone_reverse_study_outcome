package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 0, 1, 1, 2, 2}, l = {882, 455, 455}, m = "onVcMicMuted", n = {"$this$withLock_u24default$iv", "isMuted", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "isMuted", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "isMuted"}, s = {"L$0", "Z$0", "L$0", "Z$0", "L$0", "Z$0"})
final class HardwareRecordingManager$onVcMicMuted$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$onVcMicMuted$1(d r1, Continuation<? super HardwareRecordingManager$onVcMicMuted$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(false, this);
    }
}
