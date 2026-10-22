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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 0, 0, 0}, l = {882, 401}, m = "onRecordingInputStateChanged", n = {"hardwareDeviceId", "playbackState", "$this$withLock_u24default$iv", "earbudsConnected"}, s = {"L$0", "L$1", "L$2", "Z$0"})
final class HardwareRecordingManager$onRecordingInputStateChanged$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$onRecordingInputStateChanged$1(d r1, Continuation<? super HardwareRecordingManager$onRecordingInputStateChanged$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        d r8 = this.this$0;
        r8.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        HardwareRecordingManager$onRecordingInputStateChanged$1 r0 = this;
    L6:
        Object r2 = r0.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L30;
        if (r3 != 1) goto L10;
        boolean r4 = r0.Z$0;
        kotlinx.coroutines.sync.a r5 = (kotlinx.coroutines.sync.a) r0.L$2;
        HardwarePlaybackState r6 = (HardwarePlaybackState) r0.L$1;
        nvb.a r9 = (nvb.a) r0.L$0;
        ResultKt.throwOnFailure(r2);
        e r10 = r8.a;     // Catch: Throwable -> L27
        if (r10 == null) goto L19;
        String r11 = r10.b;     // Catch: Throwable -> L27
    L20:
        boolean r12 = Intrinsics.areEqual(r11, r9.a);     // Catch: Throwable -> L27
        r5.unlock(null);
        if (r12 == false) goto L24;
        lvb.a.e(null, "[onRecordingInputStateChanged] device=" + r9 + ", earbudsConnected=" + r4 + ", playbackState=" + r6);
        throw null;
    L24:
        return Unit.INSTANCE;
    L19:
        r11 = null;
    L27:
        th = move-exception;
        r5.unlock(null);
        throw th;
    L10:
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r2);
        goto L24
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L30:
        ResultKt.throwOnFailure(r2);
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.Z$0 = false;
        r0.label = 1;
        throw null;
    L5:
        r0 = new HardwareRecordingManager$onRecordingInputStateChanged$1(r8, this);
        goto L6
    }
}
