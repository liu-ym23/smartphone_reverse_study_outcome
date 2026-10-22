package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import com.larksuite.framework.utils.s;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g {
    static {
    }

    public static String a(String r5, String r6, e r7) {
        Intrinsics.checkNotNullParameter(r5, "userId");
        Intrinsics.checkNotNullParameter(r6, "meetingId");
        Intrinsics.checkNotNullParameter(r7, "localStorage");
        String r2 = r7.s(r6);
        if ((!StringsKt.isBlank(r2)) == false) goto L5;
        return r2;
    L5:
        String r3 = r7.t(r6);
        String r4 = r7.s(r3);
        if (StringsKt.isBlank(r4) == false) goto L8;
        Intrinsics.checkNotNullParameter(r5, "userId");
        Intrinsics.checkNotNullParameter(r6, "meetingId");
        Intrinsics.checkNotNullParameter(r3, "sourceSessionKey");
        r4 = StringsKt.take(s.c("minutes_recording_history_trace:" + r5 + ':' + r6 + ':' + r3), 16);
    L8:
        r7.D(r6, r4);
        return r4;
    }
}
