package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class i {
    public final String a;
    public final String b;
    public final MmParticipantType c;
    public final MmSubtitleSpeakerType d;
    public final String e;
    public String f;
    public String g;

    public static final class a {
    }

    static {
    }

    public i() {
        this(null, null, null, null, null, 127);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        return (((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
    }

    public final String toString() {
        return "MmSubtitleSpeaker(userId='" + this.a + "', speakerType=" + this.d + ')';
    }

    public /* synthetic */ i(String r11, String r12, MmParticipantType r13, MmSubtitleSpeakerType r14, String r15, int r16) {
        if ((r16 & 1) == 0) goto L5;
        String r3 = "";
    L7:
        if ((r16 & 2) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r16 & 4) == 0) goto L13;
        MmParticipantType r5 = MmParticipantType.UNKNOWN;
    L15:
        if ((r16 & 8) == 0) goto L17;
        MmSubtitleSpeakerType r6 = MmSubtitleSpeakerType.UNKNOWN;
    L19:
        if ((r16 & 16) == 0) goto L21;
        String r7 = "unknown";
    L23:
        if ((r16 & 32) == 0) goto L25;
        String r8 = "";
    L27:
        if ((r16 & 64) == 0) goto L29;
        String r9 = "";
    L30:
        this(r3, r4, r5, r6, r7, r8, r9);
        return;
    L29:
        r9 = null;
        goto L30
    L25:
        r8 = null;
        goto L27
    L21:
        r7 = r15;
        goto L23
    L17:
        r6 = r14;
        goto L19
    L13:
        r5 = r13;
        goto L15
    L9:
        r4 = r12;
        goto L11
    L5:
        r3 = r11;
        goto L7
    }

    public static i a(i r10, MmParticipantType r11, MmSubtitleSpeakerType r12, String r13, String r14, int r15) {
        String r1 = null;
        if ((r15 & 1) == 0) goto L5;
        String r3 = r10.a;
    L7:
        if ((r15 & 2) == 0) goto L9;
        String r4 = r10.b;
    L11:
        if ((r15 & 4) == 0) goto L13;
        r11 = r10.c;
    L13:
        MmParticipantType r5 = r11;
        if ((r15 & 8) == 0) goto L16;
        r12 = r10.d;
    L16:
        MmSubtitleSpeakerType r6 = r12;
        if ((r15 & 16) == 0) goto L19;
        r1 = r10.e;
    L19:
        String r7 = r1;
        if ((r15 & 32) == 0) goto L22;
        r13 = r10.f;
    L22:
        String r8 = r13;
        if ((r15 & 64) == 0) goto L25;
        r14 = r10.g;
    L25:
        String r9 = r14;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r4, "deviceId");
        Intrinsics.checkNotNullParameter(r5, "participantType");
        Intrinsics.checkNotNullParameter(r6, "speakerType");
        Intrinsics.checkNotNullParameter(r7, "identifyMethod");
        Intrinsics.checkNotNullParameter(r8, AppbrandHostConstants.Schema_Meta.NAME);
        Intrinsics.checkNotNullParameter(r9, "avatarKey");
        return new i(r3, r4, r5, r6, r7, r8, r9);
    L9:
        r4 = null;
        goto L11
    L5:
        r3 = null;
        goto L7
    }

    public i(String r2, String r3, MmParticipantType r4, MmSubtitleSpeakerType r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "deviceId");
        Intrinsics.checkNotNullParameter(r4, "participantType");
        Intrinsics.checkNotNullParameter(r5, "speakerType");
        Intrinsics.checkNotNullParameter(r6, "identifyMethod");
        Intrinsics.checkNotNullParameter(r7, AppbrandHostConstants.Schema_Meta.NAME);
        Intrinsics.checkNotNullParameter(r8, "avatarKey");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
