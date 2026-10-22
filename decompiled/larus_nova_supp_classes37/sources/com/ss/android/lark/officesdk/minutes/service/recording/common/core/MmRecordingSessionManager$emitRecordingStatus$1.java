package com.ss.android.lark.officesdk.minutes.service.recording.common.core;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager", f = "MmRecordingSessionManager.kt", i = {0, 0, 0}, l = {474, 475}, m = "emitRecordingStatus", n = {AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "sessionState", "stateData"}, s = {"L$0", "L$1", "L$2"})
public final class MmRecordingSessionManager$emitRecordingStatus$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingSessionManager this$0;

    public MmRecordingSessionManager$emitRecordingStatus$1(MmRecordingSessionManager r1, Continuation<? super MmRecordingSessionManager$emitRecordingStatus$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        MmRecordingSessionManager r3 = this.this$0;
        int r0 = MmRecordingSessionManager.I;
        return r3.l(null, null, null, this);
    }
}
