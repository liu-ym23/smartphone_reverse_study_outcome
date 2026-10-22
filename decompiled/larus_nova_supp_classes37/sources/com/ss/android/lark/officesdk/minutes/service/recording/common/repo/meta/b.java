package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta;

import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public final String a;
    public final String b;
    public final String c;
    public final long d;
    public final MmRecordingUITab e;
    public final MmRecordingWindowMode f;

    public b() {
        this(0);
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
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        long r1 = this.d;
        return ((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public final String toString() {
        return "MmRecordingMetaEntity(meetingId=" + this.a + ", minutesToken=" + this.b + ", topic=" + this.c + ", meetingStartTime=" + this.d + ", currentTab=" + this.e + ", windowMode=" + this.f + ')';
    }

    public /* synthetic */ b(int r9) {
        this("", "", UIHelper.getString(2131892868), 0, MmRecordingUITab.SUBTITLE, MmRecordingWindowMode.FULL_SCREEN_ACTIVITY);
    }

    public b(String r2, String r3, String r4, long r5, MmRecordingUITab r7, MmRecordingWindowMode r8) {
        Intrinsics.checkNotNullParameter(r2, "meetingId");
        Intrinsics.checkNotNullParameter(r3, "minutesToken");
        Intrinsics.checkNotNullParameter(r4, "topic");
        Intrinsics.checkNotNullParameter(r7, "currentTab");
        Intrinsics.checkNotNullParameter(r8, "windowMode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r8;
    }

    public static b a(b r8, String r9, String r10, String r11, long r12, MmRecordingUITab r14, MmRecordingWindowMode r15, int r16) {
        if ((r16 & 1) == 0) goto L5;
        String r1 = r8.a;
    L7:
        if ((r16 & 2) == 0) goto L9;
        String r2 = r8.b;
    L11:
        if ((r16 & 4) == 0) goto L13;
        String r3 = r8.c;
    L15:
        if ((r16 & 8) == 0) goto L17;
        long r4 = r8.d;
    L19:
        if ((r16 & 16) == 0) goto L21;
        MmRecordingUITab r6 = r8.e;
    L23:
        if ((r16 & 32) == 0) goto L25;
        MmRecordingWindowMode r7 = r8.f;
    L26:
        r8.getClass();
        Intrinsics.checkNotNullParameter(r1, "meetingId");
        Intrinsics.checkNotNullParameter(r2, "minutesToken");
        Intrinsics.checkNotNullParameter(r3, "topic");
        Intrinsics.checkNotNullParameter(r6, "currentTab");
        Intrinsics.checkNotNullParameter(r7, "windowMode");
        return new b(r1, r2, r3, r4, r6, r7);
    L25:
        r7 = r15;
        goto L26
    L21:
        r6 = r14;
        goto L23
    L17:
        r4 = r12;
        goto L19
    L13:
        r3 = r11;
        goto L15
    L9:
        r2 = r10;
        goto L11
    L5:
        r1 = r9;
        goto L7
    }
}
