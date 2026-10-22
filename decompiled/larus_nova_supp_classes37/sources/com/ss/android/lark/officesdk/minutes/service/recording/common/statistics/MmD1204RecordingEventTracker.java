package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.userscope.MinutesUCCImpl;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwarePlaybackState;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.y;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.sync.MutexImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmD1204RecordingEventTracker {
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a a;
    public final MutexImpl b;
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.a c;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int a = 0;

        static {
            int[] r0 = new int[HardwarePlaybackState.values().length];
            r0[HardwarePlaybackState.SYS_CALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            r0[HardwarePlaybackState.APP_CALL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L22:
            r0[HardwarePlaybackState.MEDIA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L16:
            r0[HardwarePlaybackState.IDLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L18:
            r0[HardwarePlaybackState.OTHER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static {
    }

    public MmD1204RecordingEventTracker(MinutesUCCImpl r2) {
        Intrinsics.checkNotNullParameter(r2, "userContext");
        this.a = r2;
        this.b = kotlinx.coroutines.sync.b.a();
        this.c = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.a(r2);
    }

    public static boolean f(JSONObject r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Statistics.sendEvent("vc_hardware_audio_feature_status", r3);     // Catch: Throwable -> L4
        Object r4 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L4
    L6:
        Throwable r1 = Result.exceptionOrNull-impl(r4);
        if (r1 == null) goto L9;
        lvb.a.b("MmD1204RecordingEventTracker", "[sendAudioFeatureStatus] failed, error=" + r1);
    L9:
        Boolean r2 = Boolean.FALSE;
        if (Result.isFailure-impl(r4) == false) goto L13;
        r4 = r2;
    L13:
        return ((Boolean) r4).booleanValue();
    L4:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public final void e(com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.b r23) {
        if (r23.h == false) goto L55;
        boolean r3 = true;
        boolean r4 = false;
        if ((!StringsKt.isBlank(r23.b)) == true) goto L7;
    L11:
        r3 = false;
    L12:
        if (r3 == false) goto L56;
        String r2 = r23.d;
        HardwareRecordSource[] r5 = HardwareRecordSource.values();
        int r6 = r5.length;
        int r7 = 0;
    L15:
        if (r7 >= r6) goto L20;
        HardwareRecordSource r8 = r5[r7];
        if (Intrinsics.areEqual(r8.getTrackValue(), r2) == true) goto L22;
        r7 = r7 + 1;
    L22:
        if (StringsKt.isBlank(r23.c) == true) goto L50;
        if (r8 == null) goto L50;
        String r9 = r23.b;
        String r10 = r23.a;
        String r11 = r23.c;
        String r12 = r23.i;
        if (StringsKt.isBlank(r9) == false) goto L28;
    L45:
        lvb.a.h("MmD1204RecordingEventTracker", "[trackAudioFeatureStatusOnline] skip: recording_identity_missing");
    L46:
        lvb.a.e("MmD1204RecordingEventTracker", "[reportOnlineIfReady] report finished, keyHash=" + r23.a.hashCode() + ", source=" + r8.getTrackValue() + ", reported=" + r4);
        if (r4 == false) goto L54;
        this.c.c(r23.a);
        return;
    L54:
        return;
    L28:
        if (StringsKt.isBlank(r10) == true) goto L45;
        if (StringsKt.isBlank(r12) == true) goto L45;
        MmRecordingCommonParam r13 = this.a.N().b(r9);
        if (r13 != null) goto L36;
        lvb.a.h("MmD1204RecordingEventTracker", "[trackAudioFeatureStatusOnline] skip: track_context_missing");
        goto L46
    L36:
        if (r13.isValid() == true) goto L39;
        lvb.a.h("MmD1204RecordingEventTracker", "[trackAudioFeatureStatusOnline] skip: track_context_invalid");
        goto L46
    L39:
        if (StringsKt.isBlank(r13.getToken()) == false) goto L41;
        lvb.a.h("MmD1204RecordingEventTracker", "[trackAudioFeatureStatusOnline] skip: legacy_recording_identity_missing");
        goto L46
    L41:
        JSONObject r14 = a(r10, r11, r8.getTrackValue(), "earphone");
        if (r14 == null) goto L46;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r15 = MmRecordingCommonParam.copy$default(r13, null, r10, true, null, null, null, null, MmRecordingSource.FEISHU_HARDWARE_D1204, null, null, null, 1913, null).asTrackerParams();
        r15.f(r14);
        JSONObject r16 = r15.a();
        lvb.a.e("MmD1204RecordingEventTracker", "[trackAudioFeatureStatusOnline] report, source=" + r8.getTrackValue() + ", hasRecordId=true, hasConferenceId=true, hasToken=true, vcRecordingIdEmpty=true");
        r4 = f(r16);
    L50:
        lvb.a.e("MmD1204RecordingEventTracker", "[reportOnlineIfReady] skip: recording_source_missing");
        return;
    L20:
        r8 = null;
        goto L22
    L56:
        return;
    L7:
        if ((!StringsKt.isBlank(r23.i)) == false) goto L11;
        if (r23.j == false) goto L11;
    }

    public final Object b(String r7, String r8, Continuation<? super Unit> r9) {
        if ((r9 instanceof MmD1204RecordingEventTracker$clear$1) == false) goto L7;
        MmD1204RecordingEventTracker$clear$1 r1 = (MmD1204RecordingEventTracker$clear$1) r9;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r10 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        kotlinx.coroutines.sync.a r11 = (kotlinx.coroutines.sync.a) r1.L$2;
        r8 = (String) r1.L$1;
        String r5 = (String) r1.L$0;
        ResultKt.throwOnFailure(r10);
        kotlinx.coroutines.sync.a r12 = r11;
        r7 = r5;
    L27:
        this.c.c(r7);     // Catch: Throwable -> L24
        lvb.a.e("MmD1204RecordingEventTracker", "[clear] keyHash=" + r7.hashCode() + ", reason=" + r8);     // Catch: Throwable -> L24
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L24
        r12.unlock(null);
        return Unit.INSTANCE;
    L24:
        th = move-exception;
        r12.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        if (StringsKt.isBlank(r7) == true) goto L17;
        r12 = this.b;
        r1.L$0 = r7;
        r1.L$1 = r8;
        r1.L$2 = r12;
        r1.label = 1;
        if (r12.a(null, r1) != r3) goto L27;
        return r3;
    L17:
        return Unit.INSTANCE;
    L7:
        r1 = new MmD1204RecordingEventTracker$clear$1(this, r9);
        goto L8
    }

    public final Object c(String r26, String r27, Continuation<? super Unit> r28) {
        if ((r28 instanceof MmD1204RecordingEventTracker$onOfflineUploadSucceeded$1) == false) goto L7;
        MmD1204RecordingEventTracker$onOfflineUploadSucceeded$1 r4 = (MmD1204RecordingEventTracker$onOfflineUploadSucceeded$1) r28;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r0 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        kotlinx.coroutines.sync.a r8 = (kotlinx.coroutines.sync.a) r4.L$2;
        String r9 = (String) r4.L$1;
        String r10 = (String) r4.L$0;
        ResultKt.throwOnFailure(r0);
    L74:
    L33:
        th = move-exception;
        r8.unlock(null);
        throw th;
    L20:
        if (StringsKt.isBlank(r10) == false) goto L22;
    L66:
        lvb.a.h("MmD1204RecordingEventTracker", "[onOfflineUploadSucceeded] skip: offline_identity_missing");     // Catch: Throwable -> L33
    L67:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L33
        r8.unlock(null);
        return Unit.INSTANCE;
    L22:
        if (StringsKt.isBlank(r9) == true) goto L66;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.b r14 = this.c.a(r10);     // Catch: Throwable -> L33
        if (r14 != null) goto L27;
        lvb.a.e("MmD1204RecordingEventTracker", "[onOfflineUploadSucceeded] skip: legacy_metadata_missing");     // Catch: Throwable -> L33
        goto L67
    L27:
        String r2 = r14.d;     // Catch: Throwable -> L33
        HardwareRecordSource[] r11 = HardwareRecordSource.values();     // Catch: Throwable -> L33
        int r12 = r11.length;     // Catch: Throwable -> L33
        int r13 = 0;
    L28:
        if (r13 >= r12) goto L35;
        HardwareRecordSource r15 = r11[r13];     // Catch: Throwable -> L33
        if (Intrinsics.areEqual(r15.getTrackValue(), r2) == true) goto L31;
        r13 = r13 + 1;     // Catch: Throwable -> L33
        goto L28
    L31:
        HardwareRecordSource r24 = r15;
    L37:
        if (r14.h == true) goto L39;
    L65:
        this.c.c(r10);     // Catch: Throwable -> L33
        lvb.a.e("MmD1204RecordingEventTracker", "[onOfflineUploadSucceeded] skip: recording_source_missing");     // Catch: Throwable -> L33
        goto L67
    L39:
        if (StringsKt.isBlank(r14.c) == true) goto L65;
        if (r24 == null) goto L65;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L44
        Object r16 = Result.constructor-impl(y.b(r9));     // Catch: Throwable -> L44
    L46:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L33
        if (r17 == null) goto L50;
        lvb.a.b("MmD1204RecordingEventTracker", "[onOfflineUploadSucceeded] skip: token_encrypt_failed, error=" + r17);     // Catch: Throwable -> L33
    L50:
        if (Result.isFailure-impl(r16) == false) goto L52;
        r16 = null;
    L52:
        String r18 = (String) r16;     // Catch: Throwable -> L33
        if (r18 != null) goto L55;
        r18 = "";
    L55:
        String r19 = r18;
        if (StringsKt.isBlank(r19) == true) goto L67;
        String r110 = r10;
        boolean r20 = g(new MmRecordingCommonParam(r19, r10, true, "FEISHU_HARDWARE_D1204", "", r14.f, r14.e, MmRecordingSource.FEISHU_HARDWARE_D1204, r14.g, null, null, 1536, null), r110, r14.c, r24.getTrackValue(), "earphone", true);     // Catch: Throwable -> L33
        StringBuilder r21 = new StringBuilder("[onOfflineUploadSucceeded] report finished, keyHash=");     // Catch: Throwable -> L33
        r21.append(r10.hashCode());     // Catch: Throwable -> L33
        r21.append(", source=");     // Catch: Throwable -> L33
        r21.append(r24.getTrackValue());     // Catch: Throwable -> L33
        r21.append(", reported=");     // Catch: Throwable -> L33
        if (r20 == false) goto L61;
        boolean r22 = true;
    L62:
        r21.append(r22);     // Catch: Throwable -> L33
        lvb.a.e("MmD1204RecordingEventTracker", r21.toString());     // Catch: Throwable -> L33
        if (r20 == false) goto L67;
        this.c.c(r10);     // Catch: Throwable -> L33
        goto L67
    L61:
        r22 = false;
        goto L62
    L44:
        th = move-exception;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L33
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L33
        goto L46
    L35:
        r24 = null;
        goto L37
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        kotlinx.coroutines.sync.a r25 = this.b;
        r4.L$0 = r26;
        r4.L$1 = r27;
        r4.L$2 = r25;
        r4.label = 1;
        if (r25.a(null, r4) != r6) goto L17;
        return r6;
    L17:
        r8 = r25;
        r10 = r26;
        r9 = r27;
    L7:
        r4 = new MmD1204RecordingEventTracker$onOfflineUploadSucceeded$1(this, r28);
        goto L8
    }

    public static JSONObject a(String r5, String r6, String r7, String r8) {
        if (StringsKt.isBlank(r6) == false) goto L7;
        lvb.a.h("MmD1204RecordingEventTracker", "[buildAudioFeatureStatusParams] skip: device_id_invalid");
        return null;
    L7:
        if (StringsKt.startsWith$default(r6, "anker_d1204_", false, 2, null) == true) goto L25;
        r6 = "anker_d1204_" + r6;
    L25:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        Object r9 = Result.constructor-impl(y.b(r6));     // Catch: Throwable -> L12
    L14:
        Throwable r1 = Result.exceptionOrNull-impl(r9);
        if (r1 == null) goto L18;
        lvb.a.b("MmD1204RecordingEventTracker", "[buildAudioFeatureStatusParams] skip: encrypt_failed, error=" + r1);
    L18:
        if (Result.isFailure-impl(r9) == false) goto L20;
        r9 = "";
    L20:
        String r10 = (String) r9;
        Intrinsics.checkNotNull(r10);
        if (StringsKt.isBlank(r10) == false) goto L23;
        return null;
    L23:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r2 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        r2.e("record_id", r5);
        r2.e("vc_recording_id", "");
        r2.e("hardware_device_id", r10);
        r2.e("hardware_device_type", "D1204");
        r2.e("record_device", r8);
        r2.e("recording_source", r7);
        return r2.a();
    L12:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public final Object d(String r19, String r20, String r21, String r22, Continuation<? super Unit> r23) {
        if ((r23 instanceof MmD1204RecordingEventTracker$onOnlineTokenReady$1) == false) goto L7;
        MmD1204RecordingEventTracker$onOnlineTokenReady$1 r3 = (MmD1204RecordingEventTracker$onOnlineTokenReady$1) r23;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r0 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        kotlinx.coroutines.sync.a r7 = (kotlinx.coroutines.sync.a) r3.L$4;
        String r8 = (String) r3.L$3;
        String r9 = (String) r3.L$2;
        String r10 = (String) r3.L$1;
        String r11 = (String) r3.L$0;
        ResultKt.throwOnFailure(r0);
        String r12 = r8;
        String r15 = r9;
    L39:
    L36:
        th = move-exception;
        r7.unlock(null);
        throw th;
    L20:
        if (StringsKt.isBlank(r11) == false) goto L22;
    L32:
        lvb.a.h("MmD1204RecordingEventTracker", "[onOnlineTokenReady] skip: online_identity_missing");     // Catch: Throwable -> L36
    L33:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L36
        r7.unlock(null);
        return Unit.INSTANCE;
    L22:
        if (StringsKt.isBlank(r10) == true) goto L32;
        if (StringsKt.isBlank(r15) == true) goto L32;
        if (StringsKt.isBlank(r12) == true) goto L32;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.b r2 = this.c.a(r11);     // Catch: Throwable -> L36
        if (r2 != null) goto L31;
        r2 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.b(r11, 1022);     // Catch: Throwable -> L36
    L31:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.b r13 = com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.b.a(r2, r10, null, null, null, null, null, false, r15, true, 253);     // Catch: Throwable -> L36
        this.c.b(r13);     // Catch: Throwable -> L36
        lvb.a.e("MmD1204RecordingEventTracker", "[onOnlineTokenReady] online signal saved, keyHash=" + r11.hashCode() + ", hardwareStarted=" + r13.h);     // Catch: Throwable -> L36
        e(r13);     // Catch: Throwable -> L36
        goto L33
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        kotlinx.coroutines.sync.a r14 = this.b;
        r3.L$0 = r19;
        r10 = r20;
        r3.L$1 = r10;
        r3.L$2 = r21;
        r12 = r22;
        r3.L$3 = r12;
        r3.L$4 = r14;
        r3.label = 1;
        if (r14.a(null, r3) != r5) goto L17;
        return r5;
    L17:
        r7 = r14;
        r11 = r19;
        r15 = r21;
    L7:
        r3 = new MmD1204RecordingEventTracker$onOnlineTokenReady$1(this, r23);
        goto L8
    }

    public static boolean g(MmRecordingCommonParam r3, String r4, String r5, String r6, String r7, boolean r8) {
        if (StringsKt.isBlank(r4) == false) goto L6;
        lvb.a.h("MmD1204RecordingEventTracker", "[trackAudioFeatureStatusOffline] skip: recording_identity_missing");
        return false;
    L6:
        JSONObject r9 = a(r4, r5, r6, r7);
        if (r9 != null) goto L9;
        return false;
    L9:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r10 = r3.asTrackerParams();
        r10.f(r9);
        JSONObject r11 = r10.a();
        lvb.a.e("MmD1204RecordingEventTracker", "[trackAudioFeatureStatusOffline] report, source=" + r6 + ", recordDevice=" + r7 + ", hasRecordId=true, hasToken=" + r8 + ", conferenceIdEmpty=true, vcRecordingIdEmpty=true");
        return f(r11);
    }
}
