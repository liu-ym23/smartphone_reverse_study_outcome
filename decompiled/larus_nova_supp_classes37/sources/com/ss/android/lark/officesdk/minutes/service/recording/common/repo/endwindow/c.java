package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public final String a;
    public final boolean b;
    public final MmRecordingUILaunchMode c;
    public final MmEndWindowMetaInfo d;
    public final MmEndWindowAISummary e;
    public final ArrayList<MmEndWindowAvatar> f;
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.b g;
    public final MmEndWindowHitPointContext h;
    public final boolean i;
    public final MmEndWindowSubtitle j;

    public c() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (((((((((((((r0 + r1) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31;
        if (this.i == true) goto L11;
        r2 = 1237;
    L11:
        return ((r3 + r2) * 31) + this.j.hashCode();
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmRecordingEndWindowEntity(sessionId=" + this.a + ", useRecordingApi=" + this.b + ", uiLaunchMode=" + this.c + ", metaInfo=" + this.d + ", aiSummary=" + this.e + ", avatarList=" + this.f + ", speakerSnapshot=" + this.g + ", mmHitPointContext=" + this.h + ", isFromHardware=" + this.i + ", subtitle=" + this.j + ')';
    }

    public /* synthetic */ c(int r35) {
        this("", false, MmRecordingUILaunchMode.UNKNOWN, new MmEndWindowMetaInfo(null, 0, 0, false, 0, null, 0, null, null, null, null, null, null, null, null, 0, 65535, null), new MmEndWindowAISummary(false, null, null, 7, null), new ArrayList(), new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.b(0), new MmEndWindowHitPointContext(null, 1, null), false, new MmEndWindowSubtitle(false, null, null, 7, null));
    }

    public static c a(c r11, String r12, MmEndWindowMetaInfo r13, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.b r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        r12 = r11.a;
    L5:
        String r1 = r12;
        if ((r15 & 2) == 0) goto L8;
        boolean r2 = r11.b;
    L10:
        if ((r15 & 4) == 0) goto L12;
        MmRecordingUILaunchMode r16 = r11.c;
    L14:
        if ((r15 & 8) == 0) goto L16;
        r13 = r11.d;
    L16:
        MmEndWindowMetaInfo r4 = r13;
        if ((r15 & 16) == 0) goto L19;
        MmEndWindowAISummary r5 = r11.e;
    L21:
        if ((r15 & 32) == 0) goto L23;
        ArrayList<MmEndWindowAvatar> r6 = r11.f;
    L25:
        if ((r15 & 64) == 0) goto L27;
        r14 = r11.g;
    L27:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.b r7 = r14;
        if ((r15 & 128) == 0) goto L30;
        MmEndWindowHitPointContext r8 = r11.h;
    L32:
        if ((r15 & 256) == 0) goto L34;
        boolean r9 = r11.i;
    L36:
        if ((r15 & 512) == 0) goto L38;
        MmEndWindowSubtitle r10 = r11.j;
    L39:
        r11.getClass();
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        Intrinsics.checkNotNullParameter(r16, "uiLaunchMode");
        Intrinsics.checkNotNullParameter(r4, "metaInfo");
        Intrinsics.checkNotNullParameter(r5, "aiSummary");
        Intrinsics.checkNotNullParameter(r6, "avatarList");
        Intrinsics.checkNotNullParameter(r7, "speakerSnapshot");
        Intrinsics.checkNotNullParameter(r8, "mmHitPointContext");
        Intrinsics.checkNotNullParameter(r10, "subtitle");
        return new c(r1, r2, r16, r4, r5, r6, r7, r8, r9, r10);
    L38:
        r10 = null;
        goto L39
    L34:
        r9 = false;
        goto L36
    L30:
        r8 = null;
        goto L32
    L23:
        r6 = null;
        goto L25
    L19:
        r5 = null;
        goto L21
    L12:
        r16 = null;
        goto L14
    L8:
        r2 = false;
        goto L10
    }

    public c(String r2, boolean r3, MmRecordingUILaunchMode r4, MmEndWindowMetaInfo r5, MmEndWindowAISummary r6, ArrayList<MmEndWindowAvatar> r7, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.b r8, MmEndWindowHitPointContext r9, boolean r10, MmEndWindowSubtitle r11) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        Intrinsics.checkNotNullParameter(r4, "uiLaunchMode");
        Intrinsics.checkNotNullParameter(r5, "metaInfo");
        Intrinsics.checkNotNullParameter(r6, "aiSummary");
        Intrinsics.checkNotNullParameter(r7, "avatarList");
        Intrinsics.checkNotNullParameter(r8, "speakerSnapshot");
        Intrinsics.checkNotNullParameter(r9, "mmHitPointContext");
        Intrinsics.checkNotNullParameter(r11, "subtitle");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
    }
}
