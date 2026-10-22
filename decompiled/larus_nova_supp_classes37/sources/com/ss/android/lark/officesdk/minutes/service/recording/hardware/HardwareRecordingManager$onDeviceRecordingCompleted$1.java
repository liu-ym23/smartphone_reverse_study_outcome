package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 0, 0, 1, 2, 2, 3}, l = {882, 263, 893, 286}, m = "onDeviceRecordingCompleted", n = {"hardwareDeviceId", "validationFailure", "$this$withLock_u24default$iv", "sessionSnapshot", "sessionSnapshot", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$0", "L$0", "L$1", "L$0"})
final class HardwareRecordingManager$onDeviceRecordingCompleted$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$onDeviceRecordingCompleted$1(d r1, Continuation<? super HardwareRecordingManager$onDeviceRecordingCompleted$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r11) {
        this.result = r11;
        this.label |= Integer.MIN_VALUE;
        d r12 = this.this$0;
        r12.getClass();
        int r5 = this.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r5 - Integer.MIN_VALUE;
        HardwareRecordingManager$onDeviceRecordingCompleted$1 r0 = this;
    L6:
        Object r6 = r0.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r0.label;
        if (r7 != 0) goto L9;
        ResultKt.throwOnFailure(r6);
        Ref.ObjectRef r13 = new Ref.ObjectRef();
        r0.L$0 = null;
        r0.L$1 = r13;
        r0.L$2 = null;
        r0.label = 1;
        throw null;
    L9:
        if (r7 != 1) goto L11;
        kotlinx.coroutines.sync.a r1 = (kotlinx.coroutines.sync.a) r0.L$2;
        Ref.ObjectRef r2 = (Ref.ObjectRef) r0.L$1;
        nvb.a r4 = (nvb.a) r0.L$0;
        ResultKt.throwOnFailure(r6);
        e r14 = r12.a;     // Catch: Throwable -> L71
        if (r14 != null) goto L58;
        r2.element = new a.b("no active hardware recording");     // Catch: Throwable -> L71
    L62:
        r14 = null;
    L63:
        r1.unlock(null);
        a r3 = (a) r2.element;
        if (r3 != null) goto L83;
        if (r14 == null) goto L68;
        r0.L$0 = r14;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 2;
        throw null;
    L68:
        return new a.b("no active hardware recording");
    L83:
        return r3;
    L58:
        if (r4 == null) goto L63;
        if (Intrinsics.areEqual(r14.b, r4.a) == true) goto L63;
        r2.element = new a.b("hardwareDeviceId mismatch, active=" + r14.b + ", completed=" + r4.a);     // Catch: Throwable -> L71
    L71:
        th = move-exception;
        r1.unlock(null);
        throw th;
    L11:
        if (r7 == 2) goto L47;
        if (r7 != 3) goto L14;
        kotlinx.coroutines.sync.a r8 = (kotlinx.coroutines.sync.a) r0.L$1;
        e r9 = (e) r0.L$0;
        ResultKt.throwOnFailure(r6);
        e r15 = r12.a;     // Catch: Throwable -> L43
        if (r15 != null) goto L28;
        a r10 = new a.b("no active hardware recording after interruption decision");     // Catch: Throwable -> L43
    L26:
        kotlinx.coroutines.sync.a r16 = r8;
    L42:
        r16.unlock(null);
        return r10;
    L28:
        if (Intrinsics.areEqual(r15.a, r9.a) == true) goto L30;
        r10 = new a.b("active session changed, expected=" + r9.a + ", actual=" + r15.a);     // Catch: Throwable -> L43
        goto L26
    L30:
        HardwareRecordingSessionState r17 = r15.e;     // Catch: Throwable -> L43
        if (r17 == HardwareRecordingSessionState.WAITING_CALL_RECOVERY) goto L41;
        if (r17 == HardwareRecordingSessionState.WAITING_INPUT_RECOVERY) goto L41;
        lvb.a.e(null, "[onDeviceRecordingCompleted] session=" + r15);     // Catch: Throwable -> L38
        throw null;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        th = th;
    L44:
        r16 = r8;
    L45:
        r16.unlock(null);
        throw th;
    L41:
        r10 = new a.b("ignore completed callback while waiting interruption recovery, session=" + r15);     // Catch: Throwable -> L43
    L43:
        th = th;
        goto L44
    L14:
        if (r7 != 4) goto L21;
        r16 = (kotlinx.coroutines.sync.a) r0.L$0;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L18
        r10 = (a) r6;     // Catch: Throwable -> L18
    L18:
        th = th;
        goto L45
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L47:
        e r18 = (e) r0.L$0;
        ResultKt.throwOnFailure(r6);
        if (((Boolean) r6).booleanValue() == false) goto L51;
        lvb.a.e(null, "[onDeviceRecordingCompleted] deferred for interruption decision, session=" + r18);
        throw null;
    L51:
        r0.L$0 = r18;
        r0.L$1 = null;
        r0.label = 3;
        throw null;
    L5:
        r0 = new HardwareRecordingManager$onDeviceRecordingCompleted$1(r12, this);
        goto L6
    }
}
