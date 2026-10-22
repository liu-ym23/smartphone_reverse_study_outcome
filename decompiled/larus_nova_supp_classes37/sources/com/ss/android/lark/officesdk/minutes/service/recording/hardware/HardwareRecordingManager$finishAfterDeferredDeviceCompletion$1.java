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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 1}, l = {882, 609}, m = "finishAfterDeferredDeviceCompletion", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
final class HardwareRecordingManager$finishAfterDeferredDeviceCompletion$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$finishAfterDeferredDeviceCompletion$1(d r1, Continuation<? super HardwareRecordingManager$finishAfterDeferredDeviceCompletion$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r9) {
        this.result = r9;
        this.label |= Integer.MIN_VALUE;
        d r10 = this.this$0;
        r10.getClass();
        int r3 = this.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r3 - Integer.MIN_VALUE;
        HardwareRecordingManager$finishAfterDeferredDeviceCompletion$1 r0 = this;
    L6:
        Object r4 = r0.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r0.label;
        if (r5 == 0) goto L36;
        if (r5 != 1) goto L10;
        kotlinx.coroutines.sync.a r1 = (kotlinx.coroutines.sync.a) r0.L$0;
        ResultKt.throwOnFailure(r4);
        e r11 = r10.a;     // Catch: Throwable -> L30
        if (r11 != null) goto L27;
        kotlinx.coroutines.sync.a r12 = r1;
    L22:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L14
        r12.unlock(null);
        return Unit.INSTANCE;
    L14:
        th = move-exception;
        r1 = r12;
        th = th;
    L34:
        r1.unlock(null);
        throw th;
    L27:
        if (r11.e == HardwareRecordingSessionState.RECORDING) goto L32;
        lvb.a.e(null, "[finishAfterDeferredDeviceCompletion] ignore session=" + r11);     // Catch: Throwable -> L30
        throw null;     // Catch: Throwable -> L30
    L32:
        lvb.a.e(null, "[finishAfterDeferredDeviceCompletion] session=" + r11);     // Catch: Throwable -> L30
        throw null;     // Catch: Throwable -> L30
    L30:
        th = th;
        goto L34
    L10:
        if (r5 != 2) goto L17;
        r12 = (kotlinx.coroutines.sync.a) r0.L$0;
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L14
        goto L22
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L36:
        ResultKt.throwOnFailure(r4);
        r0.L$0 = null;
        r0.label = 1;
        throw null;
    L5:
        r0 = new HardwareRecordingManager$finishAfterDeferredDeviceCompletion$1(r10, this);
        goto L6
    }
}
