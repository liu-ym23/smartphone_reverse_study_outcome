package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public static final b a(boolean r1, String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "recordingId");
        Intrinsics.checkNotNullParameter(r3, "minutesToken");
        Intrinsics.checkNotNullParameter(r4, "readyRecordingId");
        Intrinsics.checkNotNullParameter(r5, "readyMinutesToken");
        if (r1 == false) goto L6;
        return new b(r4, MmLocationIdentityType.RECORDING_ID);
    L6:
        if (r3.length() != 0) goto L8;
        boolean r6 = true;
    L9:
        if (r6 == false) goto L12;
        r3 = r5;
    L12:
        return new b(r3, MmLocationIdentityType.MINUTES_TOKEN);
    L8:
        r6 = false;
        goto L9
    }
}
