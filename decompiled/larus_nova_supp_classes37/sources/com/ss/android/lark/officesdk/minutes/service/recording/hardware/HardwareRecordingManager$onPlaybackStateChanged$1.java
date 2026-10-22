package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 0, 0}, l = {882, 364}, m = "onPlaybackStateChanged", n = {"hardwareDeviceId", "state", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2"})
final class HardwareRecordingManager$onPlaybackStateChanged$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$onPlaybackStateChanged$1(d r1, Continuation<? super HardwareRecordingManager$onPlaybackStateChanged$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r5) {
        this.result = r5;
        this.label |= Integer.MIN_VALUE;
        d r6 = this.this$0;
        r6.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        HardwareRecordingManager$onPlaybackStateChanged$1 r0 = this;
    L6:
        Object r7 = r0.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L20;
        if (r2 != 1) goto L10;
        kotlinx.coroutines.sync.a r3 = (kotlinx.coroutines.sync.a) r0.L$2;
        HardwarePlaybackState r4 = (HardwarePlaybackState) r0.L$1;
        nvb.a r8 = (nvb.a) r0.L$0;
        ResultKt.throwOnFailure(r7);
        throw null;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r3.unlock(null);
        throw th;
    L10:
        if (r2 != 2) goto L14;
        ResultKt.throwOnFailure(r7);
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r7);
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 1;
        throw null;
    L5:
        r0 = new HardwareRecordingManager$onPlaybackStateChanged$1(r6, this);
        goto L6
    }
}
