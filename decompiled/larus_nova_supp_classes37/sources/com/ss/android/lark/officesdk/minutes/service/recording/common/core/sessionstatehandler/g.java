package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RecordingSessionType.values().length];
            r0[RecordingSessionType.SOFTWARE_RECORDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[RecordingSessionType.HISTORY_RECORDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[RecordingSessionType.PRE_MEETING_NATIVE_RECORDING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[RecordingSessionType.STANDALONE_AI_INTERPRETATION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[RecordingSessionType.HARDWARE_RECORDING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[RecordingSessionType.HARDWARE_LIVE_RECORDING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    static {
    }
}
