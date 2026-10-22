package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 3, 3, 3, 3, 4, 4, 4, 4}, l = {882, 623, 628, 632, 633}, m = "suspendForInterruption", n = {"targetState", "interruptionReason", "$this$withLock_u24default$iv", "targetState", "interruptionReason", "$this$withLock_u24default$iv", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "$this$withLock_u24default$iv", "targetState", "interruptionReason", "$this$withLock_u24default$iv", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "targetState", "interruptionReason", "$this$withLock_u24default$iv", AppbrandHostConstants.SCHEMA_INSPECT.SESSION}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
final class HardwareRecordingManager$suspendForInterruption$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$suspendForInterruption$1(d r1, Continuation<? super HardwareRecordingManager$suspendForInterruption$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r17) {
        this.result = r17;
        this.label |= Integer.MIN_VALUE;
        d r0 = this.this$0;
        r0.getClass();
        int r7 = this.label;
        if ((r7 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r7 - Integer.MIN_VALUE;
        HardwareRecordingManager$suspendForInterruption$1 r2 = this;
    L6:
        Object r8 = r2.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = r2.label;
        if (r10 != 0) goto L77;
        ResultKt.throwOnFailure(r8);
        r2.L$0 = null;
        r2.L$1 = null;
        r2.L$2 = null;
        r2.label = 1;
        throw null;
    L77:
        if (r10 != 1) goto L11;
        kotlinx.coroutines.sync.a r3 = (kotlinx.coroutines.sync.a) r2.L$2;
        HardwareRecordingInterruptionReason r4 = (HardwareRecordingInterruptionReason) r2.L$1;
        HardwareRecordingSessionState r5 = (HardwareRecordingSessionState) r2.L$0;
        ResultKt.throwOnFailure(r8);
        e r1 = r0.a;     // Catch: Throwable -> L71
        if (r1 != null) goto L66;
    L63:
        r3.unlock(null);
        return null;
    L66:
        if (r1.e == HardwareRecordingSessionState.RECORDING) goto L69;
        lvb.a.e(null, "[suspendForInterruption] ignore non-recording session=" + r1);     // Catch: Throwable -> L71
        throw null;     // Catch: Throwable -> L71
    L69:
        r2.L$0 = r5;     // Catch: Throwable -> L71
        r2.L$1 = r4;     // Catch: Throwable -> L71
        r2.L$2 = r3;     // Catch: Throwable -> L71
        r2.L$3 = r1;     // Catch: Throwable -> L71
        r2.label = 2;     // Catch: Throwable -> L71
        throw null;     // Catch: Throwable -> L71
    L11:
        if (r10 != 2) goto L13;
        e r11 = (e) r2.L$3;
        kotlinx.coroutines.sync.a r12 = (kotlinx.coroutines.sync.a) r2.L$2;
        HardwareRecordingInterruptionReason r14 = (HardwareRecordingInterruptionReason) r2.L$1;
        HardwareRecordingSessionState r15 = (HardwareRecordingSessionState) r2.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L36
        a r13 = (a) r8;     // Catch: Throwable -> L36
        if (Intrinsics.areEqual(r13, a.c.a) == false) goto L31;
    L40:
        r2.L$0 = r15;     // Catch: Throwable -> L36
        r2.L$1 = r14;     // Catch: Throwable -> L36
        r2.L$2 = r12;     // Catch: Throwable -> L36
        r2.L$3 = r11;     // Catch: Throwable -> L36
        r2.label = 4;     // Catch: Throwable -> L36
        r8 = r0.n(r11, "suspendForInterruption", r2);     // Catch: Throwable -> L36
        if (r8 == r9) goto L80;
        e r6 = r11;
        kotlinx.coroutines.sync.a r16 = r12;
        HardwareRecordingInterruptionReason r18 = r14;
        HardwareRecordingSessionState r19 = r15;
    L44:
        b r20 = (b) r8;     // Catch: Throwable -> L71
        if (r20 == null) goto L50;
        r2.L$0 = r19;     // Catch: Throwable -> L71
        r2.L$1 = r18;     // Catch: Throwable -> L71
        r2.L$2 = r16;     // Catch: Throwable -> L71
        r2.L$3 = r6;     // Catch: Throwable -> L71
        r2.label = 5;     // Catch: Throwable -> L71
        r8 = r20.pauseRecord();     // Catch: Throwable -> L71
        if (r8 == r9) goto L79;
    L49:
        cvb.a r21 = (cvb.a) r8;     // Catch: Throwable -> L71
    L52:
        if ((r21 instanceof cvb.a.C0133a) == true) goto L58;
        if (r21 != null) goto L57;
        lvb.a.h(null, "[suspendForInterruption] missing hardware adapter, continue waiting, session=" + r6);     // Catch: Throwable -> L71
        throw null;     // Catch: Throwable -> L71
    L57:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L71
    L58:
        lvb.a.h(null, "[suspendForInterruption] pause hardware failed, continue waiting, session=" + r6 + ", result=" + r21);     // Catch: Throwable -> L71
        throw null;     // Catch: Throwable -> L71
    L79:
        return r9;
    L50:
        r21 = null;
        goto L52
    L80:
        return r9;
    L31:
        if ((r13 instanceof a.b) == true) goto L40;
        if ((r13 instanceof a.C0052a) == false) goto L39;
        lvb.a.b(null, "[suspendForInterruption] pause OfficeSDK failed, session=" + r11 + ", result=" + r13);     // Catch: Throwable -> L36
        throw null;     // Catch: Throwable -> L36
    L39:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L36
    L36:
        th = th;
    L73:
        r12.unlock(null);
        throw th;
    L13:
        if (r10 == 3) goto L24;
        if (r10 == 4) goto L21;
        if (r10 != 5) goto L20;
        r6 = (e) r2.L$3;
        kotlinx.coroutines.sync.a r22 = (kotlinx.coroutines.sync.a) r2.L$2;
        HardwareRecordingInterruptionReason r23 = (HardwareRecordingInterruptionReason) r2.L$1;
        HardwareRecordingSessionState r24 = (HardwareRecordingSessionState) r2.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L71
        goto L49
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        r6 = (e) r2.L$3;
        r16 = (kotlinx.coroutines.sync.a) r2.L$2;
        r18 = (HardwareRecordingInterruptionReason) r2.L$1;
        r19 = (HardwareRecordingSessionState) r2.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L71
        goto L44
    L24:
        r3 = (kotlinx.coroutines.sync.a) r2.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L71
    L71:
        th = th;
        r12 = "[suspendForInterruption] pause OfficeSDK failed, session=";
        goto L73
    L5:
        r2 = new HardwareRecordingManager$suspendForInterruption$1(r0, this);
        goto L6
    }
}
