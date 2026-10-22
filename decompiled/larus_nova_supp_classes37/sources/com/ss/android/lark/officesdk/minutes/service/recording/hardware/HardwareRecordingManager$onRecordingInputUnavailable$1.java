package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 0, 0}, l = {882, 383}, m = "onRecordingInputUnavailable", n = {"hardwareDeviceId", "reason", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2"})
final class HardwareRecordingManager$onRecordingInputUnavailable$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$onRecordingInputUnavailable$1(d r1, Continuation<? super HardwareRecordingManager$onRecordingInputUnavailable$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r6) {
        this.result = r6;
        this.label |= Integer.MIN_VALUE;
        d r7 = this.this$0;
        r7.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        HardwareRecordingManager$onRecordingInputUnavailable$1 r0 = this;
    L6:
        Object r2 = r0.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L33;
        if (r3 != 1) goto L10;
        kotlinx.coroutines.sync.a r4 = (kotlinx.coroutines.sync.a) r0.L$2;
        HardwareRecordingInputUnavailableReason r5 = (HardwareRecordingInputUnavailableReason) r0.L$1;
        nvb.a r8 = (nvb.a) r0.L$0;
        ResultKt.throwOnFailure(r2);
    L30:
        th = move-exception;
        r4.unlock(null);
        throw th;
    L17:
        if (r5 == HardwareRecordingInputUnavailableReason.BLUETOOTH_DISCONNECTED) goto L29;
        e r9 = r7.a;     // Catch: Throwable -> L30
        if (r9 == null) goto L21;
        String r10 = r9.b;     // Catch: Throwable -> L30
    L22:
        boolean r11 = Intrinsics.areEqual(r10, r8.a);     // Catch: Throwable -> L30
        r4.unlock(null);
        if (r11 == false) goto L26;
        lvb.a.e(null, "[onRecordingInputUnavailable] device=" + r8 + ", reason=" + r5);
        throw null;
    L26:
        return Unit.INSTANCE;
    L21:
        r10 = null;
        goto L22
    L29:
        throw null;     // Catch: Throwable -> L30
    L10:
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r2);
        goto L26
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L33:
        ResultKt.throwOnFailure(r2);
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 1;
        throw null;
    L5:
        r0 = new HardwareRecordingManager$onRecordingInputUnavailable$1(r7, this);
        goto L6
    }
}
