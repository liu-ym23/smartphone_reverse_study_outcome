package com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread.MMCoroutines;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmRecordingEndWindowRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.hardware.e;
import com.ss.android.lark.officesdk.minutes.service.recording.hardware.f;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import iub.k;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware.MmHardwareCallRecordingStartDelegate", f = "MmHardwareCallRecordingStartDelegate.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {342, 144, 148}, m = "startCallRecording", n = {AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "externalAudioSource", "context", "shouldRetryWhenForeground", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "startResult", "shouldRetryWhenForeground"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "I$0"})
final class MmHardwareCallRecordingStartDelegate$startCallRecording$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmHardwareCallRecordingStartDelegate this$0;

    public MmHardwareCallRecordingStartDelegate$startCallRecording$1(MmHardwareCallRecordingStartDelegate r1, Continuation<? super MmHardwareCallRecordingStartDelegate$startCallRecording$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r23) {
        this.result = r23;
        this.label |= Integer.MIN_VALUE;
        MmHardwareCallRecordingStartDelegate r1 = this.this$0;
        r1.getClass();
        int r3 = this.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r3 - Integer.MIN_VALUE;
        MmHardwareCallRecordingStartDelegate$startCallRecording$1 r2 = this;
    L6:
        Object r4 = r2.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        String r10 = null;
        if (r5 != 0) goto L9;
        ResultKt.throwOnFailure(r4);
        r1.c.I();
        throw null;
    L9:
        if (r5 == 1) goto L16;
        if (r5 == 2) goto L15;
        if (r5 != 3) goto L14;
        ResultKt.throwOnFailure(r4);
    L58:
        return new f.a(MmRecordingError.InternalError.INSTANCE.getErrorCode(), "hardware local capture ready timeout");
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r6 = r2.I$0;
        f r7 = (f) r2.L$1;
        e r8 = (e) r2.L$0;
        ResultKt.throwOnFailure(r4);
    L36:
        if (((Boolean) r4).booleanValue() == true) goto L48;
        ((f.b) r7).getClass();
        e r11 = e.a(r8, null, null, 223);
        lvb.a.b(r1.d, "[startCallRecording] local capture ready timeout, rollbackSession=" + r11);
        r2.L$0 = null;
        r2.L$1 = null;
        r2.label = 3;
        String r12 = r11.f;
        if ((!StringsKt.isBlank(r12)) == false) goto L40;
        r10 = r12;
    L40:
        if (r10 != null) goto L42;
        Object r13 = new com.ss.android.lark.officesdk.minutes.service.recording.hardware.a.b("recordingId is empty");
    L45:
        if (r13 != r9) goto L58;
        return r9;
    L42:
        ((MmHardwareOfflineRecordingForegroundRetryController) r1.f.getValue()).b(r10);
        lvb.a.e(r1.d, "[stopCallRecording] rollback OfficeSDK recording, recordingId=".concat(r10));
        j r14 = new j(IntrinsicsKt.intercepted(r2), 1);
        r14.C();
        r1.a.J2(r10, EndRecordingReason.HARDWARE_STOP_RECORD, new a(r1, r14));
        r13 = r14.B();
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L45;
        DebugProbesKt.probeCoroutineSuspended(r2);
        goto L45
    L48:
        if (r6 == 0) goto L54;
        MmHardwareOfflineRecordingForegroundRetryController r15 = (MmHardwareOfflineRecordingForegroundRetryController) r1.f.getValue();
        ((f.b) r7).getClass();
        r15.getClass();
        Intrinsics.checkNotNullParameter(null, "recordingId");
        if (StringsKt.isBlank(null) == false) goto L52;
        lvb.a.h(r15.d, "[register] ignored blank recordingId");
        goto L54
    L52:
        CoroutineScope r16 = r15.c;
        Lazy r17 = MMCoroutines.a;
        BuildersKt.launch$default(r16, Dispatchers.getMain().getImmediate(), null, new MmHardwareOfflineRecordingForegroundRetryController$register$1(r15, null, null), 2, null);
    L54:
        return r7;
    L16:
        int r18 = r2.I$0;
        k r19 = (k) r2.L$2;
        sub.b r20 = (sub.b) r2.L$1;
        e r110 = (e) r2.L$0;
        ResultKt.throwOnFailure(r4);
        f r111 = (f) r4;
        if ((r111 instanceof f.b) == false) goto L57;
        f.b r112 = (f.b) r111;
        r112.getClass();
        MmRecordingSessionManager r21 = r1.c.A();
        r21.getClass();
        Intrinsics.checkNotNullParameter(null, "sessionId");
        MmRecordingSession r22 = r21.m(null);
        if (r22 != null) goto L22;
        lvb.a.b(r1.d, "[observeOfficeRecordingEnd] session not found, recordingId=".concat(null));
    L31:
        r112.getClass();
        r2.L$0 = r110;
        r2.L$1 = r111;
        r2.L$2 = null;
        r2.I$0 = r18;
        r2.label = 2;
        r4 = r1.a(null, r2);
        if (r4 == r9) goto L59;
        r6 = r18;
        r8 = r110;
        r7 = r111;
        goto L36
    L59:
        return r9;
    L22:
        MmRecordingRepo r24 = r22.f();
        if (r24 == null) goto L27;
        MmRecordingEndWindowRepo r25 = r24.u();
        if (r25 == null) goto L27;
        d1<Object> r26 = r25.e();
    L28:
        if (r26 != null) goto L30;
        lvb.a.b(r1.d, "[observeOfficeRecordingEnd] repoEventFlow is null, recordingId=".concat(null));
        goto L31
    L30:
        BuildersKt.launch$default(r1.c.B(), Dispatchers.getIO(), null, new MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1(r26, r1, null, r22, null), 2, null);
    L27:
        r26 = null;
        goto L28
    L57:
        return r111;
    L5:
        r2 = new MmHardwareCallRecordingStartDelegate$startCallRecording$1(r1, this);
        goto L6
    }
}
