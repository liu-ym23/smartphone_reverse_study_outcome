package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingPushSubtitleStatusData;
import com.ss.android.lark.pb.videochat.UpdateLiveRecordingSettingResponse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[UpdateLiveRecordingSettingResponse.Status.values().length];
            r0[UpdateLiveRecordingSettingResponse.Status.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[UpdateLiveRecordingSettingResponse.Status.FAIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L29:
            r0[UpdateLiveRecordingSettingResponse.Status.LIMIT_REACHED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L23:
            r0[UpdateLiveRecordingSettingResponse.Status.RECORDING_DEGRADED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L8:
            a = r0;
            int[] r1 = new int[MinutesRecordingPushSubtitleStatusData.Status.values().length];
            r1[MinutesRecordingPushSubtitleStatusData.Status.SUBTITLE_TRANSLATION_CHANGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L25:
            r1[MinutesRecordingPushSubtitleStatusData.Status.SIMULTANEOUS_SPOKEN_LANGUAGE_NOT_SUPPORT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L11:
            b = r1;
        }
    }

    public static final boolean b(MmRecordingSource r1) {
        if (r1 != MmRecordingSource.FEISHU) goto L5;
    L10:
        return true;
    L5:
        if (r1 == MmRecordingSource.FEISHU_HARDWARE_RECORDER) goto L10;
        if (r1 == MmRecordingSource.FEISHU_HARDWARE_D1204) goto L10;
        return false;
    }

    public static final SubtitleFailedQuotaDecision a(MmRecordingSource r0, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c r1, boolean r2, boolean r3) {
        if (r2 == false) goto L4;
        if (r3 == false) goto L9;
        return SubtitleFailedQuotaDecision.CLEAR;
    L9:
        if (r0 != MmRecordingSource.FEISHU) goto L11;
        if (r1 != null) goto L16;
        return SubtitleFailedQuotaDecision.SEND_FAILED;
    L16:
        if (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.f.a(r1.a) == false) goto L19;
        return SubtitleFailedQuotaDecision.CLEAR;
    L19:
        if (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.f.b(r1) == false) goto L22;
        return SubtitleFailedQuotaDecision.SEND_FAILED;
    L22:
        return SubtitleFailedQuotaDecision.PEND;
    L11:
        return SubtitleFailedQuotaDecision.SEND_FAILED;
    L4:
        return SubtitleFailedQuotaDecision.CLEAR;
    }
}
