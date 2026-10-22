package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmEndWindowAvatar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h {
    public final long a;
    public final boolean b;
    public final long c;
    public final long d;
    public final String e;
    public String f;
    public final i g;
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c h;
    public final String i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public boolean n;
    public boolean o;

    public h() {
        this(0, false, 0, 0, null, null, null, null, null, false, false, false, false, 32767);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof h) == true) goto L8;
        return false;
    L8:
        h r9 = (h) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
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
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (this.k == r9.k) goto L42;
        return false;
    L42:
        if (this.l == r9.l) goto L45;
        return false;
    L45:
        if (this.m == r9.m) goto L48;
        return false;
    L48:
        if (this.n == r9.n) goto L51;
        return false;
    L51:
        if (this.o == r9.o) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        int r3 = 1231;
        if (this.b == false) goto L5;
        int r2 = 1231;
    L6:
        long r5 = this.c;
        int r4 = (((r1 + r2) * 31) + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        long r6 = this.d;
        int r7 = (((((((r4 + ((int) (r6 ^ (r6 >>> 32)))) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r8 = this.h;
        if (r8 != null) goto L9;
        int r9 = 0;
    L10:
        int r10 = (((r7 + r9) * 31) + this.i.hashCode()) * 31;
        if (this.j == false) goto L13;
        int r11 = 1231;
    L14:
        int r12 = (r10 + r11) * 31;
        if (this.k == false) goto L17;
        int r13 = 1231;
    L18:
        int r14 = (r12 + r13) * 31;
        if (this.l == false) goto L21;
        int r15 = 1231;
    L22:
        int r16 = (r14 + r15) * 31;
        if (this.m == false) goto L25;
        int r17 = 1231;
    L26:
        int r18 = (r16 + r17) * 31;
        if (this.n == false) goto L29;
        int r19 = 1231;
    L30:
        int r20 = (r18 + r19) * 31;
        if (this.o == true) goto L35;
        r3 = 1237;
    L35:
        return r20 + r3;
    L29:
        r19 = 1237;
        goto L30
    L25:
        r17 = 1237;
        goto L26
    L21:
        r15 = 1237;
        goto L22
    L17:
        r13 = 1237;
        goto L18
    L13:
        r11 = 1237;
        goto L14
    L9:
        r9 = r8.hashCode();
        goto L10
    L5:
        r2 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmSubtitleItem(segId=" + this.a + ", isFinal=" + this.b + ", relativeTimeMs=" + this.c + ", absoluteTimeMs=" + this.d + ", sourceContent=" + this.e + ", targetContent=" + this.f + ", speaker=" + this.g + ", markedSpeaker=" + this.h + ", clusterId=" + this.i + ", canEditSpeaker=" + this.j + ", isSpeakerMarkingEnabled=" + this.k + ", needMerge=" + this.l + ", showBilingual=" + this.m + ", isDuplicate=" + this.n + ", hasCheckDuplicate=" + this.o + ')';
    }

    public final c b() {
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r0 = this.h;
        boolean r1 = false;
        if (r0 == null) goto L65;
        i r3 = this.g;
        Intrinsics.checkNotNullParameter(r3, "original");
        String r4 = r0.a;
        if (r4.length() != 0) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == false) goto L10;
        r4 = r3.a;
    L10:
        String r6 = r4;
        boolean r7 = r0.f.isLarkUser();
        String r8 = r3.b;
        if (r7 == false) goto L13;
        MmParticipantType r9 = MmParticipantType.LARK_USER;
    L14:
        MmParticipantType r10 = r9;
        if (r7 == false) goto L17;
        MmSubtitleSpeakerType r11 = MmSubtitleSpeakerType.VOICE_PRINT_SPEAKER;
    L18:
        MmSubtitleSpeakerType r12 = r11;
        String r13 = r0.b;
        if (r13.length() != 0) goto L21;
        boolean r14 = true;
    L22:
        if (r14 == false) goto L24;
        String r15 = r3.f;
    L25:
        b r16 = null;
        if (r7 == false) goto L40;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.d r2 = r0.e;
        if (r2 == null) goto L49;
        String r17 = r2.a;
        if (r17 == null) goto L49;
        if (r17.length() <= 0) goto L34;
        boolean r18 = true;
    L35:
        if (r18 == true) goto L38;
        r17 = null;
    L38:
        if (r17 == null) goto L49;
        b r19 = new b.C0046b(r17, r6);
    L50:
        if (r19 == null) goto L52;
        b r110 = r19;
    L80:
        return new c(r6, r8, r10, r12, r15, r110);
    L52:
        if (r6.length() <= 0) goto L54;
        r1 = true;
    L54:
        if (r1 == false) goto L56;
        String r20 = r6;
    L57:
        if (r20 == null) goto L59;
        r16 = new b.e(r20);
    L59:
        if (r16 != null) goto L62;
        r16 = b.c.a;
    L62:
        r110 = r16;
        goto L80
    L56:
        r20 = null;
        goto L57
    L34:
        r18 = false;
    L49:
        r19 = null;
        goto L50
    L40:
        String r21 = r0.d;
        if (r21.length() <= 0) goto L43;
        boolean r22 = true;
    L44:
        if (r22 == true) goto L47;
        r21 = null;
    L47:
        if (r21 == null) goto L49;
        r19 = new b.d(r21);
        goto L50
    L43:
        r22 = false;
        goto L44
    L24:
        r15 = r13;
        goto L25
    L21:
        r14 = false;
        goto L22
    L17:
        r11 = r3.d;
        goto L18
    L13:
        r9 = MmParticipantType.UNKNOWN;
        goto L14
    L7:
        r5 = false;
        goto L8
    L65:
        int r23 = c.g;
        i r24 = this.g;
        Intrinsics.checkNotNullParameter(r24, MmEndWindowAvatar.TYPE_SPEAKER);
        String r25 = r24.a;
        String r26 = r24.b;
        MmParticipantType r27 = r24.c;
        MmSubtitleSpeakerType r28 = r24.d;
        String r29 = r24.f;
        if (r24.g.length() <= 0) goto L68;
        boolean r30 = true;
    L69:
        if (r30 == false) goto L72;
        b r31 = new b.C0046b(r24.g, r24.a);
    L76:
        b r111 = r31;
    L79:
        return new c(r25, r26, r27, r28, r29, r111);
    L72:
        if (r24.a.length() <= 0) goto L74;
        r1 = true;
    L74:
        if (r1 == false) goto L77;
        r31 = new b.e(r24.a);
        goto L76
    L77:
        r111 = b.c.a;
        goto L79
    L68:
        r30 = false;
        goto L69
    }

    public final MmDisplaySpeakerEditBackgroundStyle c() {
        if (this.k == true) goto L6;
        return MmDisplaySpeakerEditBackgroundStyle.NONE;
    L6:
        if (this.j == true) goto L13;
        if (this.h != null) goto L24;
        if (this.g.d.isLarkUser() == false) goto L13;
    L24:
        return MmDisplaySpeakerEditBackgroundStyle.DISABLE_MARKED;
    L13:
        if (this.j == true) goto L16;
        return MmDisplaySpeakerEditBackgroundStyle.DISABLE_UNMARKED;
    L16:
        if (this.h == null) goto L19;
        return MmDisplaySpeakerEditBackgroundStyle.EDITABLE_MARKED;
    L19:
        if (this.g.d.isLarkUser() == false) goto L22;
        return MmDisplaySpeakerEditBackgroundStyle.EDITABLE_MARKED;
    L22:
        return MmDisplaySpeakerEditBackgroundStyle.EDITABLE_UNMARKED;
    }

    public static h a(h r26, String r27, String r28, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r29, boolean r30, boolean r31, int r32) {
        long r3 = 0;
        if ((r32 & 1) == 0) goto L5;
        long r8 = r26.a;
    L7:
        if ((r32 & 2) == 0) goto L9;
        boolean r10 = r26.b;
    L11:
        if ((r32 & 4) == 0) goto L13;
        long r11 = r26.c;
    L15:
        if ((r32 & 8) == 0) goto L17;
        r3 = r26.d;
    L17:
        long r13 = r3;
        if ((r32 & 16) == 0) goto L20;
        String r15 = r26.e;
    L22:
        if ((r32 & 32) == 0) goto L24;
        String r2 = r26.f;
    L25:
        String r4 = null;
        if ((r32 & 64) == 0) goto L28;
        i r5 = r26.g;
    L30:
        if ((r32 & 128) == 0) goto L32;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r18 = r26.h;
    L34:
        if ((r32 & 256) == 0) goto L37;
        r4 = r26.i;
    L37:
        if ((r32 & 512) == 0) goto L39;
        boolean r20 = r26.j;
    L41:
        if ((r32 & 1024) == 0) goto L43;
        boolean r21 = r26.k;
    L45:
        if ((r32 & 2048) == 0) goto L47;
        boolean r22 = r26.l;
    L49:
        if ((r32 & 4096) == 0) goto L51;
        boolean r23 = r26.m;
    L53:
        if ((r32 & 8192) == 0) goto L55;
        boolean r24 = r26.n;
    L57:
        if ((r32 & 16384) == 0) goto L59;
        boolean r25 = r26.o;
    L60:
        r26.getClass();
        Intrinsics.checkNotNullParameter(r15, "sourceContent");
        Intrinsics.checkNotNullParameter(r2, "targetContent");
        Intrinsics.checkNotNullParameter(r5, MmEndWindowAvatar.TYPE_SPEAKER);
        Intrinsics.checkNotNullParameter(r4, "clusterId");
        return new h(r8, r10, r11, r13, r15, r2, r5, r18, r4, r20, r21, r22, r23, r24, r25);
    L59:
        r25 = false;
        goto L60
    L55:
        r24 = false;
        goto L57
    L51:
        r23 = r31;
        goto L53
    L47:
        r22 = false;
        goto L49
    L43:
        r21 = false;
        goto L45
    L39:
        r20 = r30;
        goto L41
    L32:
        r18 = r29;
        goto L34
    L28:
        r5 = null;
        goto L30
    L24:
        r2 = r28;
        goto L25
    L20:
        r15 = r27;
        goto L22
    L13:
        r11 = 0;
        goto L15
    L9:
        r10 = false;
        goto L11
    L5:
        r8 = 0;
        goto L7
    }

    public /* synthetic */ h(long r24, boolean r26, long r27, long r29, String r31, String r32, i r33, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r34, String r35, boolean r36, boolean r37, boolean r38, boolean r39, int r40) {
        if ((r40 & 1) == 0) goto L5;
        long r5 = 0;
    L7:
        if ((r40 & 2) == 0) goto L9;
        boolean r7 = false;
    L11:
        if ((r40 & 4) == 0) goto L13;
        long r8 = 0;
    L15:
        if ((r40 & 8) == 0) goto L17;
        long r10 = 0;
    L19:
        if ((r40 & 16) == 0) goto L21;
        String r12 = "";
    L23:
        if ((r40 & 32) == 0) goto L25;
        String r13 = "";
    L27:
        if ((r40 & 64) == 0) goto L29;
        i r14 = new i(null, null, null, null, null, 127);
    L31:
        if ((r40 & 128) == 0) goto L33;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r15 = null;
    L35:
        if ((r40 & 256) == 0) goto L37;
        String r16 = "";
    L39:
        if ((r40 & 512) == 0) goto L41;
        boolean r17 = false;
    L43:
        if ((r40 & 1024) == 0) goto L45;
        boolean r18 = false;
    L47:
        if ((r40 & 2048) == 0) goto L49;
        boolean r19 = false;
    L51:
        if ((r40 & 4096) == 0) goto L53;
        boolean r20 = false;
    L54:
        this(r5, r7, r8, r10, r12, r13, r14, r15, r16, r17, r18, r19, r20, false, false);
        return;
    L53:
        r20 = r39;
        goto L54
    L49:
        r19 = r38;
        goto L51
    L45:
        r18 = r37;
        goto L47
    L41:
        r17 = r36;
        goto L43
    L37:
        r16 = r35;
        goto L39
    L33:
        r15 = r34;
        goto L35
    L29:
        r14 = r33;
        goto L31
    L25:
        r13 = r32;
        goto L27
    L21:
        r12 = r31;
        goto L23
    L17:
        r10 = r29;
        goto L19
    L13:
        r8 = r27;
        goto L15
    L9:
        r7 = r26;
        goto L11
    L5:
        r5 = r24;
        goto L7
    }

    public h(long r8, boolean r10, long r11, long r13, String r15, String r16, i r17, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r18, String r19, boolean r20, boolean r21, boolean r22, boolean r23, boolean r24, boolean r25) {
        Intrinsics.checkNotNullParameter(r15, "sourceContent");
        Intrinsics.checkNotNullParameter(r16, "targetContent");
        Intrinsics.checkNotNullParameter(r17, MmEndWindowAvatar.TYPE_SPEAKER);
        Intrinsics.checkNotNullParameter(r19, "clusterId");
        this.a = r8;
        this.b = r10;
        this.c = r11;
        this.d = r13;
        this.e = r15;
        this.f = r16;
        this.g = r17;
        this.h = r18;
        this.i = r19;
        this.j = r20;
        this.k = r21;
        this.l = r22;
        this.m = r23;
        this.n = r24;
        this.o = r25;
    }
}
