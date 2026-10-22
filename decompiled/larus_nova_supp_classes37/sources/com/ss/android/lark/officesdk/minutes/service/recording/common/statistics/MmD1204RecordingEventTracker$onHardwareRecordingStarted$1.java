package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.MmD1204RecordingEventTracker", f = "MmD1204RecordingEventTracker.kt", i = {0, 0, 0, 0, 0}, l = {417}, m = "onHardwareRecordingStarted", n = {"hardwareUniqueId", "sessionId", "hardwareDeviceId", "recordSource", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
final class MmD1204RecordingEventTracker$onHardwareRecordingStarted$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmD1204RecordingEventTracker this$0;

    public MmD1204RecordingEventTracker$onHardwareRecordingStarted$1(MmD1204RecordingEventTracker r1, Continuation<? super MmD1204RecordingEventTracker$onHardwareRecordingStarted$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r22) {
        this.result = r22;
        this.label |= Integer.MIN_VALUE;
        MmD1204RecordingEventTracker r0 = this.this$0;
        r0.getClass();
        int r4 = this.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r4 - Integer.MIN_VALUE;
        MmD1204RecordingEventTracker$onHardwareRecordingStarted$1 r2 = this;
    L6:
        Object r5 = r2.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r2.label;
        if (r6 == 0) goto L78;
        boolean r7 = true;
        if (r6 != 1) goto L77;
        kotlinx.coroutines.sync.a r8 = (kotlinx.coroutines.sync.a) r2.L$4;
        HardwareRecordSource r9 = (HardwareRecordSource) r2.L$3;
        String r12 = (String) r2.L$2;
        String r11 = (String) r2.L$1;
        String r3 = (String) r2.L$0;
        ResultKt.throwOnFailure(r5);
    L73:
        th = move-exception;
        r8.unlock(null);
        throw th;
    L13:
        if (StringsKt.isBlank(r3) == false) goto L15;
    L69:
        lvb.a.h("MmD1204RecordingEventTracker", "[onHardwareRecordingStarted] skip: recording_identity_missing");     // Catch: Throwable -> L73
    L70:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L73
        r8.unlock(null);
        return Unit.INSTANCE;
    L15:
        if (StringsKt.isBlank(r11) == true) goto L69;
        if (StringsKt.isBlank(r12) == true) goto L69;
        if (r9 != null) goto L21;
        r0.c.c(r3);     // Catch: Throwable -> L73
        lvb.a.e("MmD1204RecordingEventTracker", "[onHardwareRecordingStarted] skip: recording_source_missing");     // Catch: Throwable -> L73
        goto L70
    L21:
        b r10 = r0.c.a(r3);     // Catch: Throwable -> L73
        if (r10 != null) goto L24;
        r10 = new b(r3, 1022);     // Catch: Throwable -> L73
    L24:
        b r13 = r10;
        MmRecordingCommonParam r14 = r0.a.N().b(r11);     // Catch: Throwable -> L73
        if (r14 == null) goto L28;
        String r15 = r14.getRecordingTraceId();     // Catch: Throwable -> L73
    L29:
        String r16 = "";
        if (r15 != null) goto L33;
        r15 = "";
    L33:
        if (StringsKt.isBlank(r15) == false) goto L40;
        MmRecordingSessionManager r17 = r0.a.A();     // Catch: Throwable -> L73
        r17.getClass();     // Catch: Throwable -> L73
        Intrinsics.checkNotNullParameter(r11, "sessionId");     // Catch: Throwable -> L73
        MmRecordingSession r18 = r17.m(r11);     // Catch: Throwable -> L73
        if (r18 == null) goto L37;
        r15 = r18.c;     // Catch: Throwable -> L73
    L38:
        if (r15 != null) goto L40;
        String r19 = "";
    L41:
        String r110 = r9.getTrackValue();     // Catch: Throwable -> L73
        if (r14 == null) goto L44;
        String r111 = r14.getUserId();     // Catch: Throwable -> L73
    L45:
        if (r111 != null) goto L48;
        r111 = "";
    L48:
        if (StringsKt.isBlank(r111) == false) goto L50;
        r111 = r0.a.getCurrentUserId();     // Catch: Throwable -> L73
    L50:
        if (r14 == null) goto L52;
        String r20 = r14.getTenantId();     // Catch: Throwable -> L73
    L53:
        if (r20 == null) goto L57;
        r16 = r20;
    L57:
        if (StringsKt.isBlank(r16) == false) goto L59;
        String r21 = r0.a.getTenantId();     // Catch: Throwable -> L73
    L60:
        b r23 = b.a(r13, r11, r12, r110, r19, r111, r21, true, null, false, 769);     // Catch: Throwable -> L73
        r0.c.b(r23);     // Catch: Throwable -> L73
        StringBuilder r24 = new StringBuilder("[onHardwareRecordingStarted] candidate saved, keyHash=");     // Catch: Throwable -> L73
        r24.append(r3.hashCode());     // Catch: Throwable -> L73
        r24.append(", source=");     // Catch: Throwable -> L73
        r24.append(r9.getTrackValue());     // Catch: Throwable -> L73
        r24.append(", onlineReady=");     // Catch: Throwable -> L73
        if ((!StringsKt.isBlank(r23.b)) == true) goto L63;
    L67:
        r7 = false;
    L68:
        r24.append(r7);     // Catch: Throwable -> L73
        lvb.a.e("MmD1204RecordingEventTracker", r24.toString());     // Catch: Throwable -> L73
        r0.e(r23);     // Catch: Throwable -> L73
        goto L70
    L63:
        if ((!StringsKt.isBlank(r23.i)) == false) goto L67;
        if (r23.j == false) goto L67;
    L59:
        r21 = r16;
        goto L60
    L52:
        r20 = null;
        goto L53
    L44:
        r111 = null;
        goto L45
    L37:
        r15 = null;
    L40:
        r19 = r15;
        goto L41
    L28:
        r15 = null;
        goto L29
    L77:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L78:
        ResultKt.throwOnFailure(r5);
        int r25 = MmD1204RecordingEventTracker.b.a;
        throw null;
    L5:
        r2 = new MmD1204RecordingEventTracker$onHardwareRecordingStarted$1(r0, this);
        goto L6
    }
}
