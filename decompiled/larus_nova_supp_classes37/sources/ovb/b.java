package ovb;

import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public final String a;
    public final long b;
    public final String c;
    public final String d;
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.a e;
    public final MmRecordingCommonParam f;
    public final String g;
    public final boolean h;

    public b() {
        this(null, 255);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == true) goto L8;
        return false;
    L8:
        b r9 = (b) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        int r2 = (((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.a r3 = this.e;
        if (r3 != null) goto L5;
        int r4 = 0;
    L6:
        int r5 = (((((r2 + r4) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        if (this.h == false) goto L9;
        int r6 = 1231;
    L11:
        return r5 + r6;
    L9:
        r6 = 1237;
        goto L11
    L5:
        r4 = r3.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmRecordingData(meetingId=" + this.a + ", meetingStartTime=" + this.b + ", recordingId=" + this.c + ", minutesToken=" + this.d + ", mmRtcConfigData=" + this.e + ", trackerCommonParams=" + this.f + ", sessionKey=" + this.g + ", meetingIdBound=" + this.h + ')';
    }

    public /* synthetic */ b(MmRecordingCommonParam r25, int r26) {
        if ((r26 & 1) == 0) goto L5;
        String r4 = "";
    L7:
        if ((r26 & 4) == 0) goto L9;
        String r7 = "";
    L11:
        if ((r26 & 8) == 0) goto L13;
        String r8 = "";
    L15:
        if ((r26 & 32) == 0) goto L17;
        MmRecordingCommonParam r10 = new MmRecordingCommonParam(null, null, false, null, null, null, null, null, null, null, null, 2047, null);
    L19:
        if ((r26 & 64) == 0) goto L21;
        String r11 = "";
    L22:
        this(r4, 0, r7, r8, null, r10, r11, false);
        return;
    L21:
        r11 = null;
        goto L22
    L17:
        r10 = r25;
        goto L19
    L13:
        r8 = null;
        goto L15
    L9:
        r7 = null;
        goto L11
    L5:
        r4 = null;
        goto L7
    }

    public b(String r2, long r3, String r5, String r6, com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.a r7, MmRecordingCommonParam r8, String r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r2, "meetingId");
        Intrinsics.checkNotNullParameter(r5, "recordingId");
        Intrinsics.checkNotNullParameter(r6, "minutesToken");
        Intrinsics.checkNotNullParameter(r8, "trackerCommonParams");
        Intrinsics.checkNotNullParameter(r9, "sessionKey");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
    }

    public static b a(b r10, String r11, long r12, String r14, String r15, MmRecordingCommonParam r16, String r17, boolean r18, int r19) {
        if ((r19 & 1) == 0) goto L5;
        String r2 = r10.a;
    L7:
        if ((r19 & 2) == 0) goto L9;
        long r3 = r10.b;
    L11:
        if ((r19 & 4) == 0) goto L13;
        String r5 = r10.c;
    L15:
        if ((r19 & 8) == 0) goto L17;
        String r6 = r10.d;
    L19:
        if ((r19 & 16) == 0) goto L21;
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.a r7 = r10.e;
    L23:
        if ((r19 & 32) == 0) goto L25;
        MmRecordingCommonParam r8 = r10.f;
    L27:
        if ((r19 & 64) == 0) goto L29;
        String r9 = r10.g;
    L31:
        if ((r19 & 128) == 0) goto L33;
        boolean r1 = r10.h;
    L34:
        r10.getClass();
        Intrinsics.checkNotNullParameter(r2, "meetingId");
        Intrinsics.checkNotNullParameter(r5, "recordingId");
        Intrinsics.checkNotNullParameter(r6, "minutesToken");
        Intrinsics.checkNotNullParameter(r8, "trackerCommonParams");
        Intrinsics.checkNotNullParameter(r9, "sessionKey");
        return new b(r2, r3, r5, r6, r7, r8, r9, r1);
    L33:
        r1 = r18;
        goto L34
    L29:
        r9 = r17;
        goto L31
    L25:
        r8 = r16;
        goto L27
    L21:
        r7 = null;
        goto L23
    L17:
        r6 = r15;
        goto L19
    L13:
        r5 = r14;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }
}
