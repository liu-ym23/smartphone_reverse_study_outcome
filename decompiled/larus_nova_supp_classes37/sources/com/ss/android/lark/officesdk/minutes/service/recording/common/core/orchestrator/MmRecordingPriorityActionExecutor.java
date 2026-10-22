package com.ss.android.lark.officesdk.minutes.service.recording.common.core.orchestrator;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingPriorityScene;
import com.ss.android.lark.officesdk.minutes.service.foundation.hardware.filesync.MmHardwareFileSyncSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.userscope.MinutesUCCImpl;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager;
import com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingStopReason;
import com.ss.android.lark.officesdk.minutes.service.recording.hardware.live.MmHardwareLiveRecordingSource;
import iub.j;
import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingPriorityActionExecutor {
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a a;
    public final String b;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RecordingPriorityScene.values().length];
            r0[RecordingPriorityScene.SOFTWARE_RECORDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L31:
            r0[RecordingPriorityScene.STANDALONE_AI_INTERPRETATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L47:
            r0[RecordingPriorityScene.MEDIA_RECORD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L35:
            r0[RecordingPriorityScene.D3200_RECORDING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L39:
            r0[RecordingPriorityScene.CALL_RECORD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L27:
            r0[RecordingPriorityScene.D3200_FILE_SYNC.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L41:
            r0[RecordingPriorityScene.D1204_CHARGING_CASE_RECORDING.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L43:
            r0[RecordingPriorityScene.D1204_CHARGING_CASE_FILE_SYNC.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L33:
            r0[RecordingPriorityScene.D1204_UPLOAD_WALLPAPER.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L37:
            r0[RecordingPriorityScene.VIDEO_CONFERENCE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L29:
            r0[RecordingPriorityScene.OTA.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L14:
            a = r0;
        }
    }

    public static final class b implements iub.a<j, MmRecordingError> {
        public final /* synthetic */ MmRecordingPriorityActionExecutor a;
        public final /* synthetic */ i<Result<Unit>> b;
        public final /* synthetic */ RecordingPriorityScene c;

        @Override // iub.a
        public final void a(MmRecordingError r5) {
            Intrinsics.checkNotNullParameter(r5, "error");
            MmRecordingPriorityActionExecutor.a(this.c, this.a, this.b, r5.getErrorCode(), r5.getErrorMsg());
        }

        @Override // iub.a
        public final void onSuccess(j r4) {
            j r5 = r4;
            Intrinsics.checkNotNullParameter(r5, "data");
            lvb.a.e(this.a.b, "[stopOfficeSdkRecording] success, recordingId=" + r5.a);
            if (this.b.isActive() == false) goto L6;
            i<Result<Unit>> r6 = this.b;
            Result.Companion r0 = Result.Companion;
            r6.resumeWith(Result.constructor-impl(Result.box-impl(Result.constructor-impl(Unit.INSTANCE))));
            return;
        }

        public b(MmRecordingPriorityActionExecutor r1, kotlinx.coroutines.j r2, RecordingPriorityScene r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public MmRecordingPriorityActionExecutor(MinutesUCCImpl r2) {
        Intrinsics.checkNotNullParameter(r2, "userContext");
        this.a = r2;
        this.b = "MmRecordingPriorityActionExecutor_" + hashCode();
    }

    public static Object c(String r2) {
        int r0 = MmRecordingError.InternalError.INSTANCE.getErrorCode();
        Result.Companion r1 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new MmRecordingError.PriorityActionFailed(r0, r2)));
    }

    public final Object d(Continuation<? super Result<Unit>> r5) {
        if ((r5 instanceof MmRecordingPriorityActionExecutor$interruptChargingCaseFileSync$1) == false) goto L7;
        MmRecordingPriorityActionExecutor$interruptChargingCaseFileSync$1 r0 = (MmRecordingPriorityActionExecutor$interruptChargingCaseFileSync$1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
        return ((Result) r6).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        dvb.a r7 = this.a.z();
        MmHardwareFileSyncSource r4 = MmHardwareFileSyncSource.D1204_CHARGING_CASE;
        r0.label = 1;
        Object r8 = r7.c();
        if (r8 != r2) goto L18;
        return r2;
    L18:
        return r8;
    L7:
        r0 = new MmRecordingPriorityActionExecutor$interruptChargingCaseFileSync$1(this, r5);
        goto L8
    }

    public final Object e(Continuation<? super Result<Unit>> r5) {
        if ((r5 instanceof MmRecordingPriorityActionExecutor$interruptChargingCaseRecordingSession$1) == false) goto L7;
        MmRecordingPriorityActionExecutor$interruptChargingCaseRecordingSession$1 r0 = (MmRecordingPriorityActionExecutor$interruptChargingCaseRecordingSession$1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
        return ((Result) r6).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        com.ss.android.lark.officesdk.minutes.service.recording.hardware.live.a r7 = this.a.w();
        MmHardwareLiveRecordingSource r4 = MmHardwareLiveRecordingSource.D1204_CHARGING_CASE;
        r0.label = 1;
        Object r8 = r7.c();
        if (r8 != r2) goto L18;
        return r2;
    L18:
        return r8;
    L7:
        r0 = new MmRecordingPriorityActionExecutor$interruptChargingCaseRecordingSession$1(this, r5);
        goto L8
    }

    public final Object g(Continuation<? super Result<Unit>> r5) {
        if ((r5 instanceof MmRecordingPriorityActionExecutor$stopHardwareRecording$1) == false) goto L7;
        MmRecordingPriorityActionExecutor$stopHardwareRecording$1 r0 = (MmRecordingPriorityActionExecutor$stopHardwareRecording$1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
    L17:
        com.ss.android.lark.officesdk.minutes.service.recording.hardware.a r7 = (com.ss.android.lark.officesdk.minutes.service.recording.hardware.a) r6;
        if (Intrinsics.areEqual(r7, com.ss.android.lark.officesdk.minutes.service.recording.hardware.a.c.a) == false) goto L21;
        Result.Companion r8 = Result.Companion;
        return Result.constructor-impl(Unit.INSTANCE);
    L21:
        if ((r7 instanceof com.ss.android.lark.officesdk.minutes.service.recording.hardware.a.b) == false) goto L24;
        return c("required hardware interrupt ignored: " + ((com.ss.android.lark.officesdk.minutes.service.recording.hardware.a.b) r7).a);
    L24:
        if ((r7 instanceof com.ss.android.lark.officesdk.minutes.service.recording.hardware.a.C0052a) == false) goto L28;
        com.ss.android.lark.officesdk.minutes.service.recording.hardware.a.C0052a r9 = (com.ss.android.lark.officesdk.minutes.service.recording.hardware.a.C0052a) r7;
        int r4 = r9.a;
        String r10 = r9.b;
        Result.Companion r11 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new MmRecordingError.PriorityActionFailed(r4, r10)));
    L28:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        com.ss.android.lark.officesdk.minutes.service.recording.hardware.i r12 = this.a.L();
        HardwareRecordingStopReason r13 = HardwareRecordingStopReason.INTERRUPTED_BY_HIGHER_PRIORITY;
        r0.label = 1;
        r6 = r12.e(r13, r0);
        if (r6 != r2) goto L17;
        return r2;
    L7:
        r0 = new MmRecordingPriorityActionExecutor$stopHardwareRecording$1(this, r5);
        goto L8
    }

    public final Object i(Continuation<? super Result<Unit>> r6) {
        if ((r6 instanceof MmRecordingPriorityActionExecutor$stopOfflineTransfer$1) == false) goto L7;
        MmRecordingPriorityActionExecutor$stopOfflineTransfer$1 r0 = (MmRecordingPriorityActionExecutor$stopOfflineTransfer$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 != 0) goto L11;
        ResultKt.throwOnFailure(r7);
        this.a.I().d();
        lvb.a.e(this.b, "[stopOfflineTransfer] rejected by config");
        return c("start recording while file sync is disabled by config");
    L11:
        if (r2 != 1) goto L22;
        boolean r3 = r0.Z$0;
        bvb.a r4 = (bvb.a) r0.L$0;
        ResultKt.throwOnFailure(r7);
        boolean r8 = ((Boolean) r7).booleanValue();
        lvb.a.e(this.b, "[stopOfflineTransfer] waitForResult=" + r3 + ", stopResult=" + r8);
        if (r3 == true) goto L16;
        Result.Companion r9 = Result.Companion;
        return Result.constructor-impl(Unit.INSTANCE);
    L16:
        if (r8 == false) goto L18;
        r4.c();
        Result.Companion r10 = Result.Companion;
        return Result.constructor-impl(Unit.INSTANCE);
    L18:
        return c("stop offline transfer failed");
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r0 = new MmRecordingPriorityActionExecutor$stopOfflineTransfer$1(this, r6);
        goto L8
    }

    public final Object f(RecordingPriorityScene r7, Continuation<? super Result<Unit>> r8) {
        if ((r8 instanceof MmRecordingPriorityActionExecutor$interruptHardwareRecordMeeting$1) == false) goto L7;
        MmRecordingPriorityActionExecutor$interruptHardwareRecordMeeting$1 r0 = (MmRecordingPriorityActionExecutor$interruptHardwareRecordMeeting$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L21:
        Result.Companion r10 = Result.Companion;
        return Result.constructor-impl(Unit.INSTANCE);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        gub.a r11 = (gub.a) this.a.u(gub.a.class);
        if (r11 == null) goto L17;
        lvb.a.e(this.b, "[interruptHardwareRecordMeeting] targetScene=" + r7);
        r0.label = 1;
        if (r11.S0() != r2) goto L21;
        return r2;
    L17:
        return c("hardware legacy runtime bridge is missing");
    L7:
        r0 = new MmRecordingPriorityActionExecutor$interruptHardwareRecordMeeting$1(this, r8);
        goto L8
    }

    public final Object h(RecordingPriorityScene r7, Continuation<? super Result<Unit>> r8) {
        if ((r8 instanceof MmRecordingPriorityActionExecutor$stopOfficeSdkRecording$1) == false) goto L7;
        MmRecordingPriorityActionExecutor$stopOfficeSdkRecording$1 r0 = (MmRecordingPriorityActionExecutor$stopOfficeSdkRecording$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r10 = (String) r0.L$2;
        MmRecordingSessionManager r11 = (MmRecordingSessionManager) r0.L$1;
        RecordingPriorityScene r12 = (RecordingPriorityScene) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L38:
        return ((Result) r9).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        MmRecordingSessionManager r13 = this.a.A();
        String r4 = r13.p;
        if (r4.length() <= 0) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == true) goto L21;
        r4 = null;
    L21:
        if (r4 != null) goto L24;
        Result.Companion r14 = Result.Companion;
        return Result.constructor-impl(Unit.INSTANCE);
    L24:
        r0.L$0 = r7;
        r0.L$1 = r13;
        r0.L$2 = r4;
        r0.label = 1;
        kotlinx.coroutines.j r6 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r0), 1);
        r6.C();
        r13.x(r4, EndRecordingReason.INTERRUPT_RECORD, new b(this, r6, r7));     // Catch: Exception -> L27 CancellationException -> L39
    L32:
        r9 = r6.B();
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L35;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L35:
        if (r9 != r2) goto L38;
        return r2;
    L39:
        e = move-exception;
        throw e;
    L27:
        e = move-exception;
        int r15 = MmRecordingError.InternalError.INSTANCE.getErrorCode();
        String r16 = e.getMessage();
        if (r16 != null) goto L31;
        r16 = "";
    L31:
        a(r7, this, r6, r15, r16);
        goto L32
    L17:
        r5 = false;
    L7:
        r0 = new MmRecordingPriorityActionExecutor$stopOfficeSdkRecording$1(this, r8);
        goto L8
    }

    public final Object b(RecordingPriorityScene r5, tub.d r6, Continuation<? super Result<Unit>> r7) {
        if ((r7 instanceof MmRecordingPriorityActionExecutor$execute$1) == false) goto L7;
        MmRecordingPriorityActionExecutor$execute$1 r0 = (MmRecordingPriorityActionExecutor$execute$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r0.label) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r8);
        return ((Result) r8).unbox-impl();
    L13:
        ResultKt.throwOnFailure(r8);
        return ((Result) r8).unbox-impl();
    L14:
        ResultKt.throwOnFailure(r8);
        return ((Result) r8).unbox-impl();
    L15:
        ResultKt.throwOnFailure(r8);
        return ((Result) r8).unbox-impl();
    L16:
        ResultKt.throwOnFailure(r8);
        return ((Result) r8).unbox-impl();
    L17:
        ResultKt.throwOnFailure(r8);
        return ((Result) r8).unbox-impl();
    L18:
        ResultKt.throwOnFailure(r8);
        lvb.a.e(this.b, "[execute] targetScene=" + r5 + ", instance=" + r6);
        switch(a.a[r6.a.ordinal()]) {
            case 1: goto L48;
            case 2: goto L48;
            case 3: goto L46;
            case 4: goto L42;
            case 5: goto L38;
            case 6: goto L32;
            case 7: goto L27;
            case 8: goto L23;
            case 9: goto L22;
            case 10: goto L22;
            case 11: goto L22;
            default: goto L21;
        };
    L22:
        Result.Companion r9 = Result.Companion;
        return Result.constructor-impl(Unit.INSTANCE);
    L23:
        r0.label = 6;
        Object r10 = d(r0);
        if (r10 != r2) goto L52;
        return r2;
    L52:
        return r10;
    L27:
        r0.label = 5;
        Object r11 = e(r0);
        if (r11 != r2) goto L53;
        return r2;
    L53:
        return r11;
    L38:
        r0.label = 3;
        Object r12 = g(r0);
        if (r12 != r2) goto L55;
        return r2;
    L55:
        return r12;
    L42:
        r0.label = 2;
        Object r13 = f(r5, r0);
        if (r13 != r2) goto L56;
        return r2;
    L56:
        return r13;
    L46:
        Result.Companion r14 = Result.Companion;
        return Result.constructor-impl(Unit.INSTANCE);
    L48:
        r0.label = 1;
        Object r15 = h(r5, r0);
        if (r15 != r2) goto L59;
        return r2;
    L59:
        return r15;
    L21:
        throw new NoWhenBranchMatchedException();
    L32:
        if (r5 != RecordingPriorityScene.CALL_RECORD) goto L37;
        r0.label = 4;
        Object r16 = i(r0);
        if (r16 != r2) goto L54;
        return r2;
    L54:
        return r16;
    L37:
        Result.Companion r17 = Result.Companion;
        return Result.constructor-impl(Unit.INSTANCE);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r0 = new MmRecordingPriorityActionExecutor$execute$1(this, r7);
        goto L8
    }

    public static final void a(RecordingPriorityScene r3, MmRecordingPriorityActionExecutor r4, i r5, int r6, String r7) {
        if (r3 != RecordingPriorityScene.CALL_RECORD) goto L5;
        boolean r0 = true;
    L6:
        lvb.a.b(r4.b, "[stopOfficeSdkRecording] failed, code=" + r6 + ", message=" + r7 + ", targetScene=" + r3 + ", continueCallRecording=" + r0);
        if (r5.isActive() == false) goto L13;
        if (r0 == false) goto L10;
        Result.Companion r8 = Result.Companion;
        Object r9 = Result.constructor-impl(Unit.INSTANCE);
    L11:
        r5.resumeWith(Result.constructor-impl(Result.box-impl(r9)));
        return;
    L10:
        Result.Companion r10 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(new MmRecordingError.PriorityActionFailed(r6, r7)));
        goto L11
    L13:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
