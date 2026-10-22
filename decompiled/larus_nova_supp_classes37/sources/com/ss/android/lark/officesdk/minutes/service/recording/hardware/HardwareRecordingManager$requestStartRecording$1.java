package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 0, 1}, l = {882, 115}, m = "requestStartRecording", n = {"request", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0"})
final class HardwareRecordingManager$requestStartRecording$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$requestStartRecording$1(d r1, Continuation<? super HardwareRecordingManager$requestStartRecording$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r9) {
        this.result = r9;
        this.label |= Integer.MIN_VALUE;
        d r10 = this.this$0;
        r10.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        HardwareRecordingManager$requestStartRecording$1 r0 = this;
    L6:
        Object r2 = r0.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r0.label;
        if (r4 != 0) goto L9;
        ResultKt.throwOnFailure(r2);
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 1;
        throw null;
    L9:
        if (r4 == 1) goto L18;
        if (r4 != 2) goto L17;
        kotlinx.coroutines.sync.a r11 = (kotlinx.coroutines.sync.a) r0.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L14
    L23:
        r3 = (h) r2;     // Catch: Throwable -> L14
        r11.unlock(null);
    L25:
        return r3;
    L14:
        Throwable th = th;
        kotlinx.coroutines.sync.a r5 = r11;
    L29:
        r5.unlock(null);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r5 = (kotlinx.coroutines.sync.a) r0.L$1;
        g r7 = (g) r0.L$0;
        ResultKt.throwOnFailure(r2);
        r0.L$0 = r5;     // Catch: Throwable -> L27
        r0.L$1 = null;     // Catch: Throwable -> L27
        r0.label = 2;     // Catch: Throwable -> L27
        r2 = r10.m(r7, true, r0);     // Catch: Throwable -> L27
        if (r2 == r3) goto L25;
        r11 = r5;
    L27:
        th = move-exception;
        th = th;
        goto L29
    L5:
        r0 = new HardwareRecordingManager$requestStartRecording$1(r10, this);
        goto L6
    }
}
