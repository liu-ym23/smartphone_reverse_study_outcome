package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingPriorityScene;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 1, 2}, l = {592, 593, 596}, m = "finishStartedRecordingSession", n = {AppbrandHostConstants.SCHEMA_INSPECT.SESSION, AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "stopResult"}, s = {"L$0", "L$0", "L$0"})
final class HardwareRecordingManager$finishStartedRecordingSession$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$finishStartedRecordingSession$1(d r1, Continuation<? super HardwareRecordingManager$finishStartedRecordingSession$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        d r9 = this.this$0;
        r9.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        HardwareRecordingManager$finishStartedRecordingSession$1 r0 = this;
    L6:
        Object r2 = r0.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r0.label;
        if (r4 == 0) goto L18;
        if (r4 == 1) goto L17;
        if (r4 != 2) goto L11;
        e r10 = (e) r0.L$0;
        ResultKt.throwOnFailure(r2);
        a r5 = (a) r2;
        RecordingPriorityScene r6 = RecordingPriorityScene.D3200_RECORDING;
        String r11 = r10.a;
        throw null;
    L11:
        if (r4 != 3) goto L14;
        a r7 = (a) r0.L$0;
        ResultKt.throwOnFailure(r2);
        return r7;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        e r12 = (e) r0.L$0;
        ResultKt.throwOnFailure(r2);
    L22:
        r0.L$0 = r12;
        r0.label = 2;
        throw null;
    L18:
        ResultKt.throwOnFailure(r2);
        r0.L$0 = null;
        r0.label = 1;
        if (r9.q(null, "finishStartedRecordingSession", r0) == r3) goto L24;
        r12 = null;
        goto L22
    L24:
        return r3;
    L5:
        r0 = new HardwareRecordingManager$finishStartedRecordingSession$1(r9, this);
        goto L6
    }
}
