package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g {
    public final String a;
    public final int b;
    public final List<c> c;
    public final List<c> d;
    public final Map<String, List<String>> e;
    public final Map<String, List<String>> f;
    public final c g;
    public final c h;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
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
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        c r1 = this.g;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        c r5 = this.h;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmStandaloneAIInterpretationUpdateResult(channel=" + this.a + ", status=" + this.b + ", supportSpokenLanguages=" + this.c + ", supportTargetLanguages=" + this.d + ", spokenToTargetLanguageTypes=" + this.e + ", targetToSpokenLanguageTypes=" + this.f + ", selectedSpokenLanguage=" + this.g + ", highlightLanguage=" + this.h + ')';
    }

    public final boolean a() {
        int r0 = this.b;
        if (r0 != 1) goto L5;
        return true;
    L5:
        if (r0 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(String r2, int r3, List<c> r4, List<c> r5, Map<String, ? extends List<String>> r6, Map<String, ? extends List<String>> r7, c r8, c r9) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        Intrinsics.checkNotNullParameter(r4, "supportSpokenLanguages");
        Intrinsics.checkNotNullParameter(r5, "supportTargetLanguages");
        Intrinsics.checkNotNullParameter(r6, "spokenToTargetLanguageTypes");
        Intrinsics.checkNotNullParameter(r7, "targetToSpokenLanguageTypes");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
