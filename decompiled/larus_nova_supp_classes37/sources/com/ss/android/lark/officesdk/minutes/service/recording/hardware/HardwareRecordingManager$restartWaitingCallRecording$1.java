package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 0, 1, 1, 2}, l = {882, 151, 164}, m = "restartWaitingCallRecording", n = {"request", "$this$withLock_u24default$iv", "request", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0"})
final class HardwareRecordingManager$restartWaitingCallRecording$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$restartWaitingCallRecording$1(d r1, Continuation<? super HardwareRecordingManager$restartWaitingCallRecording$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r12) {
        this.result = r12;
        this.label |= Integer.MIN_VALUE;
        d r13 = this.this$0;
        r13.getClass();
        int r5 = this.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r5 - Integer.MIN_VALUE;
        HardwareRecordingManager$restartWaitingCallRecording$1 r0 = this;
    L6:
        Object r6 = r0.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r0.label;
        if (r8 == 0) goto L84;
        if (r8 != 1) goto L10;
        kotlinx.coroutines.sync.a r9 = (kotlinx.coroutines.sync.a) r0.L$1;
        g r1 = (g) r0.L$0;
        ResultKt.throwOnFailure(r6);
        e r14 = r13.a;     // Catch: Throwable -> L80
        String r10 = "";
        if (r14 != null) goto L47;
        String r2 = r1.c;     // Catch: Throwable -> L80
        if (r2 == null) goto L44;
        r10 = r2;
    L44:
        d.p(-1, "no active hardware recording to restart", r10);     // Catch: Throwable -> L80
        throw null;     // Catch: Throwable -> L80
    L47:
        if (r14.e == HardwareRecordingSessionState.WAITING_CALL_RECOVERY) goto L54;
        String r15 = "hardware recording is not waiting call recovery: " + r14.e;     // Catch: Throwable -> L80
        String r3 = r1.c;     // Catch: Throwable -> L80
        if (r3 == null) goto L52;
        r10 = r3;
    L52:
        d.p(-1, r15, r10);     // Catch: Throwable -> L80
        throw null;     // Catch: Throwable -> L80
    L54:
        nvb.a r4 = r1.a;     // Catch: Throwable -> L80
        if (r4 == null) goto L57;
        String r11 = r4.a;     // Catch: Throwable -> L80
    L59:
        if (Intrinsics.areEqual(r11, r14.b) == true) goto L71;
        StringBuilder r16 = new StringBuilder("hardware device mismatch, active=");     // Catch: Throwable -> L80
        r16.append(r14.b);     // Catch: Throwable -> L80
        r16.append(", request=");     // Catch: Throwable -> L80
        nvb.a r17 = r1.a;     // Catch: Throwable -> L80
        if (r17 == null) goto L63;
        String r18 = r17.a;     // Catch: Throwable -> L80
    L64:
        r16.append(r18);     // Catch: Throwable -> L80
        String r19 = r16.toString();     // Catch: Throwable -> L80
        String r20 = r1.c;     // Catch: Throwable -> L80
        if (r20 == null) goto L68;
        r10 = r20;
    L68:
        d.p(-1, r19, r10);     // Catch: Throwable -> L80
        throw null;     // Catch: Throwable -> L80
    L63:
        r18 = null;
        goto L64
    L71:
        if (r1.e == HardwarePlaybackState.SYS_CALL) goto L78;
        String r110 = "hardware playback is not SYS_CALL: " + r1.e;     // Catch: Throwable -> L80
        String r21 = r1.c;     // Catch: Throwable -> L80
        if (r21 == null) goto L76;
        r10 = r21;
    L76:
        d.p(-1, r110, r10);     // Catch: Throwable -> L80
        throw null;     // Catch: Throwable -> L80
    L78:
        lvb.a.e(null, "[restartWaitingCallRecording] end waiting session before restart, session=" + r14);     // Catch: Throwable -> L80
        throw null;     // Catch: Throwable -> L80
    L57:
        r11 = null;
    L80:
        th = move-exception;
        Throwable th = th;
        kotlinx.coroutines.sync.a r22 = r9;
    L82:
        r22.unlock(null);
        throw th;
    L10:
        if (r8 == 2) goto L19;
        if (r8 != 3) goto L18;
        kotlinx.coroutines.sync.a r111 = (kotlinx.coroutines.sync.a) r0.L$0;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L15
    L27:
        if ((((h) r6) instanceof h.a) == false) goto L31;
        r7 = (h) r6;     // Catch: Throwable -> L15
        r111.unlock(null);
    L30:
        return r7;
    L31:
        throw null;     // Catch: Throwable -> L15
    L15:
        th = th;
        r22 = r111;
        goto L82
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r22 = (kotlinx.coroutines.sync.a) r0.L$1;
        g r23 = (g) r0.L$0;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L34
        if ((((a) r6) instanceof a.C0052a) == true) goto L33;
        r0.L$0 = r22;     // Catch: Throwable -> L34
        r0.L$1 = null;     // Catch: Throwable -> L34
        r0.label = 3;     // Catch: Throwable -> L34
        r6 = r13.m(r23, false, r0);     // Catch: Throwable -> L34
        if (r6 == r7) goto L30;
        r111 = r22;
        goto L27
    L33:
        throw null;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        th = th;
        goto L82
    L84:
        ResultKt.throwOnFailure(r6);
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 1;
        throw null;
    L5:
        r0 = new HardwareRecordingManager$restartWaitingCallRecording$1(r13, this);
        goto L6
    }
}
