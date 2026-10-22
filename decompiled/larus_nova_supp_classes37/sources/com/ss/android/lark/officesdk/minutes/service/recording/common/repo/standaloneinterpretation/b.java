package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public final boolean a;
    public final List<c> b;
    public final List<c> c;
    public final Map<String, List<String>> d;
    public final Map<String, List<String>> e;
    public final c f;
    public final c g;
    public final c h;
    public final c i;
    public final String j;

    public b() {
        this(0);
    }

    public static b a(boolean r12, List r13, List r14, Map r15, Map r16, c r17, c r18, c r19, c r20, String r21) {
        Intrinsics.checkNotNullParameter(r13, "supportSpokenLanguages");
        Intrinsics.checkNotNullParameter(r14, "supportTargetLanguages");
        Intrinsics.checkNotNullParameter(r15, "spokenToTargetLanguageTypes");
        Intrinsics.checkNotNullParameter(r16, "targetToSpokenLanguageTypes");
        return new b(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
    }

    public static /* synthetic */ b b(b r11, c r12, String r13, int r14) {
        if ((r14 & 1) == 0) goto L5;
        boolean r1 = r11.a;
    L7:
        if ((r14 & 2) == 0) goto L9;
        List<c> r0 = r11.b;
    L11:
        if ((r14 & 4) == 0) goto L13;
        List<c> r3 = r11.c;
    L15:
        if ((r14 & 8) == 0) goto L17;
        Map<String, List<String>> r4 = r11.d;
    L19:
        if ((r14 & 16) == 0) goto L21;
        Map<String, List<String>> r5 = r11.e;
    L23:
        if ((r14 & 32) == 0) goto L25;
        c r6 = r11.f;
    L27:
        if ((r14 & 64) == 0) goto L29;
        r12 = r11.g;
    L29:
        c r7 = r12;
        if ((r14 & 128) == 0) goto L32;
        c r8 = r11.h;
    L34:
        if ((r14 & 256) == 0) goto L36;
        c r9 = r11.i;
    L38:
        if ((r14 & 512) == 0) goto L40;
        r13 = r11.j;
    L40:
        r11.getClass();
        return a(r1, r0, r3, r4, r5, r6, r7, r8, r9, r13);
    L36:
        r9 = null;
        goto L38
    L32:
        r8 = null;
        goto L34
    L25:
        r6 = null;
        goto L27
    L21:
        r5 = null;
        goto L23
    L17:
        r4 = null;
        goto L19
    L13:
        r3 = null;
        goto L15
    L9:
        r0 = null;
        goto L11
    L5:
        r1 = false;
        goto L7
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
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
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((((((((r0 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        c r2 = this.f;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r1 + r4) * 31;
        c r6 = this.g;
        if (r6 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (r5 + r7) * 31;
        c r9 = this.h;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (r8 + r10) * 31;
        c r12 = this.i;
        if (r12 != null) goto L21;
        int r13 = 0;
    L22:
        int r14 = (r11 + r13) * 31;
        String r15 = this.j;
        if (r15 == null) goto L27;
        r3 = r15.hashCode();
    L27:
        return r14 + r3;
    L21:
        r13 = r12.hashCode();
        goto L22
    L17:
        r10 = r9.hashCode();
        goto L18
    L13:
        r7 = r6.hashCode();
        goto L14
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmStandaloneAIInterpretationEntity(enabled=" + this.a + ", supportSpokenLanguages=" + this.b + ", supportTargetLanguages=" + this.c + ", spokenToTargetLanguageTypes=" + this.d + ", targetToSpokenLanguageTypes=" + this.e + ", selectedSpokenLanguage=" + this.f + ", selectedLanguage=" + this.g + ", highlightLanguage=" + this.h + ", activeLanguage=" + this.i + ", errorMessage=" + this.j + ')';
    }

    public /* synthetic */ b(int r12) {
        this(false, CollectionsKt.emptyList(), CollectionsKt.emptyList(), MapsKt.emptyMap(), MapsKt.emptyMap(), null, null, null, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(boolean r2, List<c> r3, List<c> r4, Map<String, ? extends List<String>> r5, Map<String, ? extends List<String>> r6, c r7, c r8, c r9, c r10, String r11) {
        Intrinsics.checkNotNullParameter(r3, "supportSpokenLanguages");
        Intrinsics.checkNotNullParameter(r4, "supportTargetLanguages");
        Intrinsics.checkNotNullParameter(r5, "spokenToTargetLanguageTypes");
        Intrinsics.checkNotNullParameter(r6, "targetToSpokenLanguageTypes");
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
