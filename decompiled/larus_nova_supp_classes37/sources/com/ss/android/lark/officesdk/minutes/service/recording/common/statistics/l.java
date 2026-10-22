package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.TerminateReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class l {
    public static final Set<String> i = null;
    public final MmRecordingSession a;
    public final i b;
    public final String c;
    public final long d;
    public final AtomicInteger e;
    public volatile com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c f;
    public long g;
    public boolean h;

    public static final class a {

        /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.l$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0050a {
            public static final /* synthetic */ int[] a = null;
            public static final /* synthetic */ int[] b = null;

            static {
                int[] r0 = new int[EndRecordingReason.values().length];
                r0[EndRecordingReason.DOUBAO_CLICK_STOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L71
            L148:
                r0[EndRecordingReason.DOUBAO_USER_LOGOUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L72
            L162:
                r0[EndRecordingReason.RECORDING_PAGE_CLICK_STOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L73
            L174:
                r0[EndRecordingReason.MM_MEETING_END.ordinal()] = 4;     // Catch: NoSuchFieldError -> L74
            L178:
                r0[EndRecordingReason.MEETING_PUSH_TERMINATED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L75
            L188:
                r0[EndRecordingReason.ON_RECORD_STOP.ordinal()] = 6;     // Catch: NoSuchFieldError -> L76
            L204:
                r0[EndRecordingReason.SHOW_FLOAT_WINDOW_DISMISS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L77
            L130:
                r0[EndRecordingReason.MAX_LIMIT_TIME.ordinal()] = 8;     // Catch: NoSuchFieldError -> L78
            L150:
                r0[EndRecordingReason.RECORD_FINISH_AUDIO_SAVE_CONTINUE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L79
            L152:
                r0[EndRecordingReason.HARDWARE_STOP_RECORD.ordinal()] = 10;     // Catch: NoSuchFieldError -> L80
            L164:
                r0[EndRecordingReason.HISTORY_RECORDING.ordinal()] = 11;     // Catch: NoSuchFieldError -> L81
            L192:
                r0[EndRecordingReason.INTERRUPT_RECORD.ordinal()] = 12;     // Catch: NoSuchFieldError -> L82
            L210:
                r0[EndRecordingReason.SWITCH_TO_FEISHU_RECORDING.ordinal()] = 13;     // Catch: NoSuchFieldError -> L83
            L118:
                r0[EndRecordingReason.RTC_AUDIO_RECORD_DATA_FAILURE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L84
            L128:
                r0[EndRecordingReason.AUDIO_RECORD_DATA_FAILURE.ordinal()] = 15;     // Catch: NoSuchFieldError -> L85
            L156:
                r0[EndRecordingReason.NO_SPACE.ordinal()] = 16;     // Catch: NoSuchFieldError -> L86
            L172:
                r0[EndRecordingReason.SHOW_FLOAT_WINDOW_FAILED.ordinal()] = 17;     // Catch: NoSuchFieldError -> L87
            L176:
                r0[EndRecordingReason.HARDWARE_DISCONNECT.ordinal()] = 18;     // Catch: NoSuchFieldError -> L88
            L190:
                r0[EndRecordingReason.HARDWARE_MEETING_CONFLICT.ordinal()] = 19;     // Catch: NoSuchFieldError -> L89
            L122:
                r0[EndRecordingReason.HARDWARE_FLOAT_CONFLICT.ordinal()] = 20;     // Catch: NoSuchFieldError -> L90
            L138:
                r0[EndRecordingReason.HARDWARE_CALL_INTERRUPTION_TIMEOUT.ordinal()] = 21;     // Catch: NoSuchFieldError -> L91
            L140:
                r0[EndRecordingReason.HARDWARE_CALL_INTERRUPTION_IDLE_TIMEOUT.ordinal()] = 22;     // Catch: NoSuchFieldError -> L92
            L154:
                r0[EndRecordingReason.HARDWARE_INPUT_UNAVAILABLE_TIMEOUT.ordinal()] = 23;     // Catch: NoSuchFieldError -> L93
            L180:
                r0[EndRecordingReason.HARDWARE_SPEAKER_SWITCHED_IDLE.ordinal()] = 24;     // Catch: NoSuchFieldError -> L94
            L200:
                r0[EndRecordingReason.GET_OR_CREATE_FINISHED_TOKEN_FAILED.ordinal()] = 25;     // Catch: NoSuchFieldError -> L95
            L202:
                r0[EndRecordingReason.RTC_PSDA_CHECK_FAILED.ordinal()] = 26;     // Catch: NoSuchFieldError -> L96
            L120:
                r0[EndRecordingReason.OTHERS.ordinal()] = 27;     // Catch: NoSuchFieldError -> L97
            L142:
                r0[EndRecordingReason.HARDWARE_RESTARTED_BY_GESTURE.ordinal()] = 28;     // Catch: NoSuchFieldError -> L98
            L49:
                a = r0;
                int[] r1 = new int[TerminateReason.values().length];
                r1[TerminateReason.UPLOAD_COMPLETED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L99
            L186:
                r1[TerminateReason.REACH_MAX_DURATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L100
            L198:
                r1[TerminateReason.UPLOAD_COMPLETED_SERVER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L101
            L208:
                r1[TerminateReason.MEETING_ID_EMPTY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L102
            L126:
                r1[TerminateReason.MINUTES_TOKEN_EMPTY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L103
            L136:
                r1[TerminateReason.RTC_INIT_FAILED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L104
            L146:
                r1[TerminateReason.DIR_CREATE_FAILED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L105
            L160:
                r1[TerminateReason.ALREADY_RECORDING.ordinal()] = 8;     // Catch: NoSuchFieldError -> L106
            L168:
                r1[TerminateReason.MEETING_CREATED_FAILED.ordinal()] = 9;     // Catch: NoSuchFieldError -> L107
            L184:
                r1[TerminateReason.NON_RECORDING_TYPE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L108
            L196:
                r1[TerminateReason.OBJECT_DELETED.ordinal()] = 11;     // Catch: NoSuchFieldError -> L109
            L206:
                r1[TerminateReason.NOT_LOGGED_IN.ordinal()] = 12;     // Catch: NoSuchFieldError -> L110
            L124:
                r1[TerminateReason.UNAUTHORIZED.ordinal()] = 13;     // Catch: NoSuchFieldError -> L111
            L134:
                r1[TerminateReason.TENANT_KEY_DELETED.ordinal()] = 14;     // Catch: NoSuchFieldError -> L112
            L144:
                r1[TerminateReason.SAVE_ARTIFACT_DISABLED.ordinal()] = 15;     // Catch: NoSuchFieldError -> L113
            L158:
                r1[TerminateReason.HARDWARE_DISCONNECTED.ordinal()] = 16;     // Catch: NoSuchFieldError -> L114
            L166:
                r1[TerminateReason.PRIORITY_REPLACED.ordinal()] = 17;     // Catch: NoSuchFieldError -> L115
            L182:
                r1[TerminateReason.HARDWARE_STOPPED.ordinal()] = 18;     // Catch: NoSuchFieldError -> L116
            L194:
                r1[TerminateReason.OTHERS.ordinal()] = 19;     // Catch: NoSuchFieldError -> L117
            L69:
                b = r1;
            }
        }

        public static String a(TerminateReason r1) {
            Intrinsics.checkNotNullParameter(r1, "reason");
            switch(C0050a.b[r1.ordinal()]) {
                case 1: goto L22;
                case 2: goto L22;
                case 3: goto L22;
                case 4: goto L21;
                case 5: goto L20;
                case 6: goto L19;
                case 7: goto L18;
                case 8: goto L17;
                case 9: goto L16;
                case 10: goto L15;
                case 11: goto L14;
                case 12: goto L13;
                case 13: goto L12;
                case 14: goto L11;
                case 15: goto L10;
                case 16: goto L9;
                case 17: goto L8;
                case 18: goto L7;
                case 19: goto L6;
                default: goto L5;
            };
        L6:
            return "OtherError";
        L7:
            return "HardwareStopped";
        L8:
            return "PriorityReplaced";
        L9:
            return "HardwareDisconnected";
        L10:
            return "SaveArtifactDisabled";
        L11:
            return "TenantKeyDeleted";
        L12:
            return "Unauthorized";
        L13:
            return "NotLoggedIn";
        L14:
            return "ObjectDeleted";
        L15:
            return "NonRecordingType";
        L16:
            return "MeetingCreateFailed";
        L17:
            return "AlreadyRecording";
        L18:
            return "DirectoryCreateFailed";
        L19:
            return "RtcInitFailed";
        L20:
            return "MinutesTokenEmpty";
        L21:
            return "MeetingIdEmpty";
        L22:
            return "NormalEnd";
        L5:
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
        i = SetsKt.setOf(new String[]{"rtc", "audio", "upload"});
    }

    public final String c() {
        return h(this.f);
    }

    public final boolean e() {
        RecordingSessionType r0 = this.a.a;
        Intrinsics.checkNotNullParameter(r0, "sessionType");
        if (r0 != RecordingSessionType.PRE_MEETING_NATIVE_RECORDING) goto L5;
        return true;
    L5:
        return false;
    }

    public static String a(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a r2) {
        String r1 = null;
        if ((r2 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.k) == false) goto L5;
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.k r3 = (com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.k) r2;
    L6:
        if (r3 == null) goto L31;
        EndRecordingReason r4 = r3.a;
        if (r4 == null) goto L31;
        Intrinsics.checkNotNullParameter(r4, "reason");
        switch(a.C0050a.a[r4.ordinal()]) {
            case 1: goto L29;
            case 2: goto L29;
            case 3: goto L29;
            case 4: goto L29;
            case 5: goto L29;
            case 6: goto L29;
            case 7: goto L29;
            case 8: goto L29;
            case 9: goto L29;
            case 10: goto L29;
            case 11: goto L29;
            case 12: goto L28;
            case 13: goto L28;
            case 14: goto L27;
            case 15: goto L26;
            case 16: goto L25;
            case 17: goto L24;
            case 18: goto L23;
            case 19: goto L22;
            case 20: goto L21;
            case 21: goto L20;
            case 22: goto L19;
            case 23: goto L18;
            case 24: goto L17;
            case 25: goto L16;
            case 26: goto L15;
            case 27: goto L14;
            case 28: goto L13;
            default: goto L12;
        };
    L13:
        String r5 = "HardwareRestartedByGesture";
    L30:
        r1 = r5;
        goto L31
    L14:
        r5 = "OtherError";
        goto L30
    L15:
        r5 = "RtcPsdaCheckFailed";
        goto L30
    L16:
        r5 = "GetOrCreateFinishedTokenFailed";
        goto L30
    L17:
        r5 = "HardwareSpeakerSwitchedIdle";
        goto L30
    L18:
        r5 = "HardwareInputUnavailableTimeout";
        goto L30
    L19:
        r5 = "HardwareCallInterruptionIdleTimeout";
        goto L30
    L20:
        r5 = "HardwareCallInterruptionTimeout";
        goto L30
    L21:
        r5 = "HardwareFloatConflict";
        goto L30
    L22:
        r5 = "HardwareMeetingConflict";
        goto L30
    L23:
        r5 = "HardwareDisconnected";
        goto L30
    L24:
        r5 = "ShowFloatWindowFailed";
        goto L30
    L25:
        r5 = "NoSpace";
        goto L30
    L26:
        r5 = "AudioRecordDataFailure";
        goto L30
    L27:
        r5 = "RtcAudioRecordDataFailure";
        goto L30
    L28:
        r5 = "RecordingInterrupted";
        goto L30
    L29:
        r5 = "NormalEnd";
        goto L30
    L12:
        throw new NoWhenBranchMatchedException();
    L31:
        if (r1 != null) goto L34;
        return "";
    L34:
        return r1;
    L5:
        r3 = null;
        goto L6
    }

    public static String b(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a r1) {
        if ((r1 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n) == false) goto L6;
        return a.a(((com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n) r1).a);
    L6:
        if ((r1 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.d) == true) goto L11;
        return "";
    L11:
        return a.a(((com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.d) r1).a);
    }

    public static String f(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a r1) {
        Intrinsics.checkNotNullParameter(r1, "event");
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.C0036a.a) == false) goto L6;
        return "LocalRecordingPrepared";
    L6:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.b.a) == false) goto L9;
        return "LocalRecordingStarted";
    L9:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.l.a) == false) goto L12;
        return "StartCreateMeeting";
    L12:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.c.a) == false) goto L15;
        return "MeetingBound";
    L15:
        if ((r1 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.d) == false) goto L18;
        return "MeetingCreateFailed";
    L18:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.e.a) == false) goto L21;
        return "MeetingCreated";
    L21:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.j.a) == false) goto L24;
        return "RecordingStarted";
    L24:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.h.a) == false) goto L27;
        return "RecordingPaused";
    L27:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.i.a) == false) goto L30;
        return "RecordingResumed";
    L30:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.f.a) == false) goto L33;
        return "RecordingInterrupted";
    L33:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.g.a) == false) goto L36;
        return "RecordingInterruptResumed";
    L36:
        if ((r1 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.k) == false) goto L39;
        return "RecordingStopped";
    L39:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.m.a) == false) goto L42;
        return "StartUploading";
    L42:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.o.a) == false) goto L45;
        return "UploadFinished";
    L45:
        if ((r1 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n) == false) goto L49;
        return "TerminateSession";
    L49:
        throw new NoWhenBranchMatchedException();
    }

    public static com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c g(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r1) {
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.j.c) == false) goto L5;
    L10:
        return null;
    L5:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.e.c) == true) goto L10;
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.f.c) == true) goto L10;
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.g.c) == true) goto L10;
        return r1;
    }

    public static String h(com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r1) {
        Intrinsics.checkNotNullParameter(r1, "state");
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.C0037c.c) == false) goto L6;
        return "Init";
    L6:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.j.c) == false) goto L9;
        return "PreparingLocalRecording";
    L9:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.e.c) == false) goto L12;
        return "LocalRecording";
    L12:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.f.c) == false) goto L15;
        return "MeetingBinding";
    L15:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.g.c) == false) goto L18;
        return "MeetingBound";
    L18:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.l.c) == false) goto L21;
        return "RecordingCreated";
    L21:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.k.c) == false) goto L24;
        return "Recording";
    L24:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.h.c) == false) goto L27;
        return "Paused";
    L27:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.d.c) == false) goto L30;
        return "Interrupted";
    L30:
        if ((r1 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.b) == false) goto L33;
        return "EndRecording";
    L33:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.i.c) == false) goto L36;
        return "PostProcessing";
    L36:
        if (Intrinsics.areEqual(r1, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.n.c) == false) goto L39;
        return "Uploaded";
    L39:
        if ((r1 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.m) == false) goto L43;
        return "Terminated";
    L43:
        throw new NoWhenBranchMatchedException();
    }

    public final void d(String r4) {
        if (this.h == false) goto L5;
        return;
    L5:
        this.h = true;
        lvb.a.e(this.c, "[skipDiagnosis] sessionType=" + this.a.a + ", traceId=" + this.a.c + ", reason=" + r4);
    }

    public l(MmRecordingSession r5, i r6) {
        Intrinsics.checkNotNullParameter(r5, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r6, "diagnosisTracker");
        this.a = r5;
        this.b = r6;
        String r7 = "MmRecordingSessionDiagnosisReporter_" + r5.hashCode();
        this.c = r7;
        long r0 = System.currentTimeMillis();
        this.d = r0;
        this.e = new AtomicInteger(0);
        this.f = com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.C0037c.c;
        this.g = r0;
        lvb.a.e(r7, "[init] sessionType=" + r5.a + ", traceId=" + r5.c + ", skipLifecycleDiagnosis=" + e());
    }

    public static void i(l r35, String r36, Integer r37, String r38, Integer r39, Integer r40, String r41, Integer r42, String r43, int r44) {
        if ((r44 & 4) == 0) goto L5;
        Integer r4 = null;
    L7:
        if ((r44 & 8) == 0) goto L9;
        String r6 = "";
    L11:
        if ((r44 & 16) == 0) goto L13;
        String r8 = "";
    L15:
        if ((r44 & 32) == 0) goto L17;
        Integer r9 = null;
    L19:
        if ((r44 & 64) == 0) goto L21;
        Integer r12 = null;
    L23:
        if ((r44 & 128) == 0) goto L25;
        String r13 = "";
    L27:
        if ((r44 & 512) == 0) goto L29;
        String r15 = r35.c();
    L31:
        if ((r44 & 1024) == 0) goto L33;
        Integer r18 = null;
    L35:
        if ((r44 & 2048) == 0) goto L37;
        String r1 = "";
    L38:
        r35.getClass();
        Intrinsics.checkNotNullParameter(r36, "exceptionStage");
        Intrinsics.checkNotNullParameter("error", "severity");
        Intrinsics.checkNotNullParameter(r6, "errorMsg");
        Intrinsics.checkNotNullParameter(r8, "requestPath");
        Intrinsics.checkNotNullParameter(r13, "logId");
        Integer r310 = r12;
        Intrinsics.checkNotNullParameter(r15, "state");
        Integer r311 = r9;
        Intrinsics.checkNotNullParameter(r1, "responseName");
        if (r35.e() == false) goto L44;
        if (i.contains(r36) == true) goto L44;
        r35.d("exception");
        return;
    L44:
        i r5 = r35.b;
        MmRecordingSession r0 = r35.a;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r0, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r36, "exceptionStage");
        Intrinsics.checkNotNullParameter("error", "severity");
        Intrinsics.checkNotNullParameter(r6, "errorMsg");
        Intrinsics.checkNotNullParameter(r8, "requestPath");
        Intrinsics.checkNotNullParameter(r13, "logId");
        Intrinsics.checkNotNullParameter(r15, "state");
        Intrinsics.checkNotNullParameter(r1, "responseName");
        List<String> r7 = i.b;
        MmRecordingCommonParam r20 = r0.j();
        String r10 = r0.c;
        MmRecordingSource r11 = r0.j().getSource();
        if (r11 != null) goto L50;
        iub.k r14 = r0.f;
        if (r14 == null) goto L49;
        r11 = r14.a;
        goto L50
    L49:
        MmRecordingSource r28 = null;
    L51:
        MmRecordingCommonParam r16 = MmRecordingCommonParam.copy$default(r20, null, null, false, null, null, null, r10, r28, null, null, null, 1855, null);
        iub.k r2 = r0.f;
        if (r2 == null) goto L56;
        MmRecordingSource r3 = r2.a;
        if (r3 == null) goto L56;
        String r17 = r3.getValue();
    L57:
        if (r17 != null) goto L59;
        r17 = "";
    L59:
        String r21 = r1;
        r5.b(i.a.a(r16, r17, r36, "error", r4, r6, r8, r311, r310, r13, null, null, null, r15, r18, r21, null, 399360));
        return;
    L56:
        r17 = null;
    L50:
        r28 = r11;
        goto L51
    L37:
        r1 = r43;
        goto L38
    L33:
        r18 = r42;
        goto L35
    L29:
        r15 = r41;
        goto L31
    L25:
        r13 = null;
        goto L27
    L21:
        r12 = r40;
        goto L23
    L17:
        r9 = r39;
        goto L19
    L13:
        r8 = null;
        goto L15
    L9:
        r6 = r38;
        goto L11
    L5:
        r4 = r37;
        goto L7
    }
}
