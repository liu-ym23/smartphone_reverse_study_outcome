package com.ss.android.lark.officesdk.minutes.service.recording.common.core;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingStartRequest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[RecordingSessionType.values().length];
            r0[RecordingSessionType.HISTORY_RECORDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[RecordingSessionType.STANDALONE_AI_INTERPRETATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L6:
            a = r0;
            int[] r1 = new int[MmRecordingSource.values().length];
            r1[MmRecordingSource.FEISHU_DOUBAO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L29:
            r1[MmRecordingSource.DOUBAO_GLASSES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L23:
            r1[MmRecordingSource.DOUBAO_EARBUDS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L25:
            r1[MmRecordingSource.DOUBAO_STANDALONE_AI_INTERPRETATION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L11:
            b = r1;
        }
    }

    public static final MinutesRecordingStartRequest.ExtraType a(MmRecordingSource r1) {
        if (r1 != null) goto L4;
        int r2 = -1;
    L6:
        if (r2 == 1) goto L18;
        if (r2 == 2) goto L22;
        if (r2 == 3) goto L21;
        if (r2 == 4) goto L20;
        return MinutesRecordingStartRequest.ExtraType.UNKNOWN;
    L20:
        return MinutesRecordingStartRequest.ExtraType.UNKNOWN;
    L21:
        return MinutesRecordingStartRequest.ExtraType.DOUBAO_EARBUDS;
    L22:
        return MinutesRecordingStartRequest.ExtraType.DOUBAO_GLASSES;
    L18:
        return MinutesRecordingStartRequest.ExtraType.DOUBAO_IN_LARK;
    L4:
        r2 = a.b[r1.ordinal()];
        goto L6
    }
}
