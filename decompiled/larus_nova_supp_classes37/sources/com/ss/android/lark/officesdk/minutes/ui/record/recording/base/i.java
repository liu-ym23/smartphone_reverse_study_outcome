package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.l;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmAudioSaveType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingUITab;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class i implements l {
    public final String A;
    public final Boolean B;
    public final String a;
    public final String b;
    public final long c;
    public final MMRecordingState d;
    public final boolean e;
    public final String f;
    public final String g;
    public final long h;
    public final int i;
    public final boolean j;
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h k;
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h l;
    public final List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h> m;
    public final List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h> n;
    public final boolean o;
    public final boolean p;
    public final MmRecordingUITab q;
    public final MmAudioSaveType r;
    public final boolean s;
    public final boolean t;
    public final boolean u;
    public final boolean v;
    public final List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g> w;
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g x;
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g y;
    public final boolean z;

    public i() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof i) == true) goto L8;
        return false;
    L8:
        i r9 = (i) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r9.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r9.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r9.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r9.n) == true) goto L51;
        return false;
    L51:
        if (this.o == r9.o) goto L54;
        return false;
    L54:
        if (this.p == r9.p) goto L57;
        return false;
    L57:
        if (this.q == r9.q) goto L60;
        return false;
    L60:
        if (this.r == r9.r) goto L63;
        return false;
    L63:
        if (this.s == r9.s) goto L66;
        return false;
    L66:
        if (this.t == r9.t) goto L69;
        return false;
    L69:
        if (this.u == r9.u) goto L72;
        return false;
    L72:
        if (this.v == r9.v) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.w, r9.w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.x, r9.x) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.y, r9.y) == true) goto L84;
        return false;
    L84:
        if (this.z == r9.z) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.A, r9.A) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.B, r9.B) == true) goto L92;
        return false;
    L92:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        long r1 = this.c;
        int r2 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.d.hashCode()) * 31;
        int r3 = 1231;
        if (this.e == false) goto L5;
        int r4 = 1231;
    L6:
        int r5 = (((((r2 + r4) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        long r6 = this.h;
        int r7 = (((r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31) + this.i) * 31;
        if (this.j == false) goto L9;
        int r8 = 1231;
    L10:
        int r9 = (((((((((r7 + r8) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31;
        if (this.o == false) goto L13;
        int r10 = 1231;
    L14:
        int r11 = (r9 + r10) * 31;
        if (this.p == false) goto L17;
        int r12 = 1231;
    L18:
        int r13 = (((((r11 + r12) * 31) + this.q.hashCode()) * 31) + this.r.hashCode()) * 31;
        if (this.s == false) goto L21;
        int r14 = 1231;
    L22:
        int r15 = (r13 + r14) * 31;
        if (this.t == false) goto L25;
        int r16 = 1231;
    L26:
        int r17 = (r15 + r16) * 31;
        if (this.u == false) goto L29;
        int r18 = 1231;
    L30:
        int r19 = (r17 + r18) * 31;
        if (this.v == false) goto L33;
        int r20 = 1231;
    L34:
        int r21 = (((r19 + r20) * 31) + this.w.hashCode()) * 31;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r22 = this.x;
        int r23 = 0;
        if (r22 != null) goto L37;
        int r24 = 0;
    L38:
        int r25 = (r21 + r24) * 31;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r26 = this.y;
        if (r26 != null) goto L41;
        int r27 = 0;
    L42:
        int r28 = (r25 + r27) * 31;
        if (this.z == true) goto L46;
        r3 = 1237;
    L46:
        int r29 = (r28 + r3) * 31;
        String r30 = this.A;
        if (r30 != null) goto L49;
        int r31 = 0;
    L50:
        int r32 = (r29 + r31) * 31;
        Boolean r33 = this.B;
        if (r33 == null) goto L55;
        r23 = r33.hashCode();
    L55:
        return r32 + r23;
    L49:
        r31 = r30.hashCode();
        goto L50
    L41:
        r27 = r26.hashCode();
        goto L42
    L37:
        r24 = r22.hashCode();
        goto L38
    L33:
        r20 = 1237;
        goto L34
    L29:
        r18 = 1237;
        goto L30
    L25:
        r16 = 1237;
        goto L26
    L21:
        r14 = 1237;
        goto L22
    L17:
        r12 = 1237;
        goto L18
    L13:
        r10 = 1237;
        goto L14
    L9:
        r8 = 1237;
        goto L10
    L5:
        r4 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmRecordingVMState(minutesToken=" + this.a + ", meetingId=" + this.b + ", meetingStartTime=" + this.c + ", recordingState=" + this.d + ", pauseResumeVisible=" + this.e + ", title=" + this.f + ", mmPOIAddress=" + this.g + ", duration=" + this.h + ", audioVolume=" + this.i + ", showAudioSaveEntry=" + this.j + ", currSpokenLanguage=" + this.k + ", currTranslateLanguage=" + this.l + ", spokenLanguageList=" + this.m + ", translateLanguageList=" + this.n + ", isBilingual=" + this.o + ", isSubtitleSettingsDegraded=" + this.p + ", currentTab=" + this.q + ", audioSaveType=" + this.r + ", needShowAudioSaveBoarding=" + this.s + ", needShowAINoteTooltip=" + this.t + ", showAIInterpretationEntry=" + this.u + ", aiInterpretationOn=" + this.v + ", aiInterpretationLanguages=" + this.w + ", selectedAIInterpretationLanguage=" + this.x + ", activeAIInterpretationLanguage=" + this.y + ", aiInterpretationLoading=" + this.z + ", aiInterpretationErrorMessage=" + this.A + ", hasUnviewedSummary=" + this.B + ')';
    }

    public /* synthetic */ i(int r32) {
        this("", "", 0, MMRecordingState.INIT, true, "", "", 0, 0, false, new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h(0), new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h(0), CollectionsKt.emptyList(), CollectionsKt.emptyList(), false, false, MmRecordingUITab.SUBTITLE, MmAudioSaveType.SAVE, false, false, false, false, CollectionsKt.emptyList(), null, null, false, null, null);
    }

    public i(String r15, String r16, long r17, MMRecordingState r19, boolean r20, String r21, String r22, long r23, int r25, boolean r26, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h r27, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h r28, List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h> r29, List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h> r30, boolean r31, boolean r32, MmRecordingUITab r33, MmAudioSaveType r34, boolean r35, boolean r36, boolean r37, boolean r38, List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g> r39, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r40, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r41, boolean r42, String r43, Boolean r44) {
        Intrinsics.checkNotNullParameter(r15, "minutesToken");
        Intrinsics.checkNotNullParameter(r16, "meetingId");
        Intrinsics.checkNotNullParameter(r19, "recordingState");
        Intrinsics.checkNotNullParameter(r21, "title");
        Intrinsics.checkNotNullParameter(r22, "mmPOIAddress");
        Intrinsics.checkNotNullParameter(r27, "currSpokenLanguage");
        Intrinsics.checkNotNullParameter(r28, "currTranslateLanguage");
        Intrinsics.checkNotNullParameter(r29, "spokenLanguageList");
        Intrinsics.checkNotNullParameter(r30, "translateLanguageList");
        Intrinsics.checkNotNullParameter(r33, "currentTab");
        Intrinsics.checkNotNullParameter(r34, "audioSaveType");
        Intrinsics.checkNotNullParameter(r39, "aiInterpretationLanguages");
        this.a = r15;
        this.b = r16;
        this.c = r17;
        this.d = r19;
        this.e = r20;
        this.f = r21;
        this.g = r22;
        this.h = r23;
        this.i = r25;
        this.j = r26;
        this.k = r27;
        this.l = r28;
        this.m = r29;
        this.n = r30;
        this.o = r31;
        this.p = r32;
        this.q = r33;
        this.r = r34;
        this.s = r35;
        this.t = r36;
        this.u = r37;
        this.v = r38;
        this.w = r39;
        this.x = r40;
        this.y = r41;
        this.z = r42;
        this.A = r43;
        this.B = r44;
    }

    public static i a(i r17, String r18, String r19, long r20, MMRecordingState r22, boolean r23, String r24, String r25, long r26, int r28, boolean r29, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h r30, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h r31, List r32, List r33, boolean r34, boolean r35, MmRecordingUITab r36, MmAudioSaveType r37, boolean r38, boolean r39, boolean r40, boolean r41, List r42, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r43, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r44, boolean r45, String r46, Boolean r47, int r48) {
        if ((r48 & 1) == 0) goto L5;
        String r2 = r17.a;
    L7:
        if ((r48 & 2) == 0) goto L9;
        String r3 = r17.b;
    L11:
        if ((r48 & 4) == 0) goto L13;
        long r4 = r17.c;
    L15:
        if ((r48 & 8) == 0) goto L17;
        MMRecordingState r6 = r17.d;
    L19:
        if ((r48 & 16) == 0) goto L21;
        boolean r7 = r17.e;
    L23:
        if ((r48 & 32) == 0) goto L25;
        String r8 = r17.f;
    L27:
        if ((r48 & 64) == 0) goto L29;
        String r9 = r17.g;
    L31:
        if ((r48 & 128) == 0) goto L33;
        long r10 = r17.h;
    L35:
        if ((r48 & 256) == 0) goto L37;
        int r12 = r17.i;
    L39:
        if ((r48 & 512) == 0) goto L41;
        boolean r13 = r17.j;
    L43:
        if ((r48 & 1024) == 0) goto L45;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h r14 = r17.k;
    L47:
        if ((r48 & 2048) == 0) goto L49;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h r15 = r17.l;
    L50:
        boolean r210 = r13;
        if ((r48 & 4096) == 0) goto L53;
        List r16 = r17.m;
    L54:
        int r211 = r12;
        if ((r48 & 8192) == 0) goto L57;
        List r110 = r17.n;
    L58:
        long r27 = r10;
        if ((r48 & 16384) == 0) goto L61;
        boolean r11 = r17.o;
    L63:
        if ((32768 & r48) == 0) goto L65;
        boolean r111 = r17.p;
    L66:
        boolean r310 = r111;
        if ((r48 & 65536) == 0) goto L69;
        MmRecordingUITab r112 = r17.q;
    L70:
        boolean r311 = r11;
        if ((r48 & 131072) == 0) goto L73;
        MmAudioSaveType r113 = r17.r;
    L74:
        boolean r212 = r7;
        if ((r48 & 262144) == 0) goto L77;
        boolean r21 = r17.s;
    L78:
        boolean r312 = r21;
        if ((r48 & 524288) == 0) goto L81;
        boolean r49 = r17.t;
    L82:
        boolean r313 = r49;
        if ((r48 & 1048576) == 0) goto L85;
        boolean r50 = r17.u;
    L86:
        boolean r410 = r50;
        if ((r48 & 2097152) == 0) goto L89;
        boolean r51 = r17.v;
    L90:
        boolean r411 = r51;
        if ((r48 & 4194304) == 0) goto L93;
        List r52 = r17.w;
    L94:
        long r213 = r4;
        if ((r48 & 8388608) == 0) goto L97;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r5 = r17.x;
    L99:
        if ((16777216 & r48) == 0) goto L101;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r53 = r17.y;
    L102:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r412 = r53;
        if ((r48 & 33554432) == 0) goto L105;
        boolean r54 = r17.z;
    L106:
        boolean r413 = r54;
        if ((r48 & 67108864) == 0) goto L109;
        String r55 = r17.A;
    L111:
        if ((r48 & 134217728) == 0) goto L113;
        Boolean r1 = r17.B;
    L114:
        r17.getClass();
        Intrinsics.checkNotNullParameter(r2, "minutesToken");
        Intrinsics.checkNotNullParameter(r3, "meetingId");
        Intrinsics.checkNotNullParameter(r6, "recordingState");
        Intrinsics.checkNotNullParameter(r8, "title");
        Intrinsics.checkNotNullParameter(r9, "mmPOIAddress");
        Intrinsics.checkNotNullParameter(r14, "currSpokenLanguage");
        Intrinsics.checkNotNullParameter(r15, "currTranslateLanguage");
        Intrinsics.checkNotNullParameter(r16, "spokenLanguageList");
        Intrinsics.checkNotNullParameter(r110, "translateLanguageList");
        Intrinsics.checkNotNullParameter(r112, "currentTab");
        Intrinsics.checkNotNullParameter(r113, "audioSaveType");
        Intrinsics.checkNotNullParameter(r52, "aiInterpretationLanguages");
        return new i(r2, r3, r213, r6, r212, r8, r9, r27, r211, r210, r14, r15, r16, r110, r311, r310, r112, r113, r312, r313, r410, r411, r52, r5, r412, r413, r55, r1);
    L113:
        r1 = r47;
        goto L114
    L109:
        r55 = r46;
        goto L111
    L105:
        r54 = r45;
        goto L106
    L101:
        r53 = r44;
        goto L102
    L97:
        r5 = r43;
        goto L99
    L93:
        r52 = r42;
        goto L94
    L89:
        r51 = r41;
        goto L90
    L85:
        r50 = r40;
        goto L86
    L81:
        r49 = r39;
        goto L82
    L77:
        r21 = r38;
        goto L78
    L73:
        r113 = r37;
        goto L74
    L69:
        r112 = r36;
        goto L70
    L65:
        r111 = r35;
        goto L66
    L61:
        r11 = r34;
        goto L63
    L57:
        r110 = r33;
        goto L58
    L53:
        r16 = r32;
        goto L54
    L49:
        r15 = r31;
        goto L50
    L45:
        r14 = r30;
        goto L47
    L41:
        r13 = r29;
        goto L43
    L37:
        r12 = r28;
        goto L39
    L33:
        r10 = r26;
        goto L35
    L29:
        r9 = r25;
        goto L31
    L25:
        r8 = r24;
        goto L27
    L21:
        r7 = r23;
        goto L23
    L17:
        r6 = r22;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }
}
