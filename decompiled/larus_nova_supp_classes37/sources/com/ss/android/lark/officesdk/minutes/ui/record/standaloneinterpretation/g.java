package com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.l;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MMRecordingState;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g implements l {
    public final long a;
    public final int b;
    public final MMRecordingState c;
    public final List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> d;
    public final List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> e;
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c f;
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c g;
    public final Map<String, MmStandaloneAIInterpretationLanguageDisabledReason> h;
    public final Map<String, MmStandaloneAIInterpretationLanguageDisabledReason> i;
    public final boolean j;
    public final MmStandaloneAIInterpretationLanguageSide k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final boolean q;

    public g() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof g) == true) goto L8;
        return false;
    L8:
        g r9 = (g) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
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
        if (this.o == r9.o) goto L54;
        return false;
    L54:
        if (this.p == r9.p) goto L57;
        return false;
    L57:
        if (this.q == r9.q) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r2 = this.f;
        int r3 = 0;
        if (r2 != null) goto L5;
        int r4 = 0;
    L6:
        int r5 = (r1 + r4) * 31;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r6 = this.g;
        if (r6 == null) goto L10;
        r3 = r6.hashCode();
    L10:
        int r7 = (((((r5 + r3) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31;
        int r8 = 1231;
        if (this.j == false) goto L13;
        int r9 = 1231;
    L14:
        int r10 = (((r7 + r9) * 31) + this.k.hashCode()) * 31;
        if (this.l == false) goto L17;
        int r11 = 1231;
    L18:
        int r12 = (r10 + r11) * 31;
        if (this.m == false) goto L21;
        int r13 = 1231;
    L22:
        int r14 = (r12 + r13) * 31;
        if (this.n == false) goto L25;
        int r15 = 1231;
    L26:
        int r16 = (r14 + r15) * 31;
        if (this.o == false) goto L29;
        int r17 = 1231;
    L30:
        int r18 = (r16 + r17) * 31;
        if (this.p == false) goto L33;
        int r19 = 1231;
    L34:
        int r20 = (r18 + r19) * 31;
        if (this.q == true) goto L39;
        r8 = 1237;
    L39:
        return r20 + r8;
    L33:
        r19 = 1237;
        goto L34
    L29:
        r17 = 1237;
        goto L30
    L25:
        r15 = 1237;
        goto L26
    L21:
        r13 = 1237;
        goto L22
    L17:
        r11 = 1237;
        goto L18
    L13:
        r9 = 1237;
        goto L14
    L5:
        r4 = r2.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmStandaloneAIInterpretationVMState(duration=" + this.a + ", audioVolume=" + this.b + ", recordingState=" + this.c + ", supportSpokenLanguages=" + this.d + ", supportTargetLanguages=" + this.e + ", selectedSpokenLanguage=" + this.f + ", selectedLanguage=" + this.g + ", disabledSpokenLanguageReasons=" + this.h + ", disabledTargetLanguageReasons=" + this.i + ", isHeaderLanguageLoading=" + this.j + ", languagePanelSide=" + this.k + ", isBilingual=" + this.l + ", languageSettingSyncing=" + this.m + ", isPlaybackMuted=" + this.n + ", saveArtifactType=" + this.o + ", saveArtifactReady=" + this.p + ", saveArtifactSyncing=" + this.q + ')';
    }

    public /* synthetic */ g(int r20) {
        this(0, 0, MMRecordingState.INIT, CollectionsKt.emptyList(), CollectionsKt.emptyList(), null, null, MapsKt.emptyMap(), MapsKt.emptyMap(), true, MmStandaloneAIInterpretationLanguageSide.TARGET, false, false, true, false, false, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(long r10, int r12, MMRecordingState r13, List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r14, List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r15, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r16, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r17, Map<String, ? extends MmStandaloneAIInterpretationLanguageDisabledReason> r18, Map<String, ? extends MmStandaloneAIInterpretationLanguageDisabledReason> r19, boolean r20, MmStandaloneAIInterpretationLanguageSide r21, boolean r22, boolean r23, boolean r24, boolean r25, boolean r26, boolean r27) {
        Intrinsics.checkNotNullParameter(r13, "recordingState");
        Intrinsics.checkNotNullParameter(r14, "supportSpokenLanguages");
        Intrinsics.checkNotNullParameter(r15, "supportTargetLanguages");
        Intrinsics.checkNotNullParameter(r18, "disabledSpokenLanguageReasons");
        Intrinsics.checkNotNullParameter(r19, "disabledTargetLanguageReasons");
        Intrinsics.checkNotNullParameter(r21, "languagePanelSide");
        this.a = r10;
        this.b = r12;
        this.c = r13;
        this.d = r14;
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
        this.p = r26;
        this.q = r27;
    }

    public static g a(g r17, long r18, int r20, MMRecordingState r21, List r22, List r23, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r24, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r25, Map r26, Map r27, boolean r28, MmStandaloneAIInterpretationLanguageSide r29, boolean r30, boolean r31, boolean r32, boolean r33, boolean r34, boolean r35, int r36) {
        if ((r36 & 1) == 0) goto L5;
        long r2 = r17.a;
    L7:
        if ((r36 & 2) == 0) goto L9;
        int r4 = r17.b;
    L11:
        if ((r36 & 4) == 0) goto L13;
        MMRecordingState r5 = r17.c;
    L15:
        if ((r36 & 8) == 0) goto L17;
        List r6 = r17.d;
    L19:
        if ((r36 & 16) == 0) goto L21;
        List r7 = r17.e;
    L23:
        if ((r36 & 32) == 0) goto L25;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r8 = r17.f;
    L27:
        if ((r36 & 64) == 0) goto L29;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c r9 = r17.g;
    L31:
        if ((r36 & 128) == 0) goto L33;
        Map r10 = r17.h;
    L35:
        if ((r36 & 256) == 0) goto L37;
        Map r11 = r17.i;
    L39:
        if ((r36 & 512) == 0) goto L41;
        boolean r12 = r17.j;
    L43:
        if ((r36 & 1024) == 0) goto L45;
        MmStandaloneAIInterpretationLanguageSide r13 = r17.k;
    L47:
        if ((r36 & 2048) == 0) goto L49;
        boolean r14 = r17.l;
    L51:
        if ((r36 & 4096) == 0) goto L53;
        boolean r15 = r17.m;
    L54:
        boolean r37 = r15;
        if ((r36 & 8192) == 0) goto L57;
        boolean r16 = r17.n;
    L58:
        boolean r38 = r16;
        if ((r36 & 16384) == 0) goto L61;
        boolean r19 = r17.o;
    L62:
        boolean r39 = r19;
        if ((r36 & 32768) == 0) goto L65;
        boolean r110 = r17.p;
    L67:
        if ((r36 & 65536) == 0) goto L69;
        boolean r1 = r17.q;
    L70:
        r17.getClass();
        Intrinsics.checkNotNullParameter(r5, "recordingState");
        Intrinsics.checkNotNullParameter(r6, "supportSpokenLanguages");
        Intrinsics.checkNotNullParameter(r7, "supportTargetLanguages");
        Intrinsics.checkNotNullParameter(r10, "disabledSpokenLanguageReasons");
        Intrinsics.checkNotNullParameter(r11, "disabledTargetLanguageReasons");
        Intrinsics.checkNotNullParameter(r13, "languagePanelSide");
        return new g(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r37, r38, r39, r110, r1);
    L69:
        r1 = r35;
        goto L70
    L65:
        r110 = r34;
        goto L67
    L61:
        r19 = r33;
        goto L62
    L57:
        r16 = r32;
        goto L58
    L53:
        r15 = r31;
        goto L54
    L49:
        r14 = r30;
        goto L51
    L45:
        r13 = r29;
        goto L47
    L41:
        r12 = r28;
        goto L43
    L37:
        r11 = r27;
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
        r5 = r21;
        goto L15
    L9:
        r4 = r20;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }
}
