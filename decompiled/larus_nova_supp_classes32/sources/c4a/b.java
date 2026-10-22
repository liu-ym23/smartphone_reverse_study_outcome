package c4a;

import android.app.Activity;
import android.media.AudioManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public static final String a(AudioManager r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r3 = r2.getMode();
        if (r3 != 0) goto L5;
        return "MODE_NORMAL";
    L5:
        if (r3 != 1) goto L7;
        return "MODE_RINGTONE";
    L7:
        if (r3 != 2) goto L9;
        return "MODE_IN_CALL";
    L9:
        if (r3 != 3) goto L11;
        return "MODE_IN_COMMUNICATION";
    L11:
        if (r3 != 4) goto L19;
        return "MODE_CALL_SCREENING";
    L19:
        return "UNKNOWN_MODE (" + r3 + ')';
    }

    public static final String b(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r3 = r2.getVolumeControlStream();
        if (r3 != 0) goto L5;
        return "STREAM_VOICE_CALL";
    L5:
        if (r3 != 1) goto L7;
        return "STREAM_SYSTEM";
    L7:
        if (r3 != 2) goto L9;
        return "STREAM_RING";
    L9:
        if (r3 != 3) goto L11;
        return "STREAM_MUSIC";
    L11:
        if (r3 != 4) goto L13;
        return "STREAM_ALARM";
    L13:
        if (r3 != 5) goto L15;
        return "STREAM_NOTIFICATION";
    L15:
        if (r3 != 8) goto L17;
        return "STREAM_DTMF";
    L17:
        if (r3 != 10) goto L28;
        return "STREAM_ACCESSIBILITY";
    L28:
        return "UNKNOWN_STREAM (" + r3 + ')';
    }
}
