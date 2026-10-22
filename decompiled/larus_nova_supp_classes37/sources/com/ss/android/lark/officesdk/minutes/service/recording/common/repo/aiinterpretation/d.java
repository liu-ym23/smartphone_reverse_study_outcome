package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public final boolean a;
    public final List<g> b;
    public final g c;
    public final g d;
    public final boolean e;
    public final boolean f;
    public final String g;

    public d() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
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
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((r0 * 31) + this.b.hashCode()) * 31;
        g r3 = this.c;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r2 + r5) * 31;
        g r7 = this.d;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        if (this.e == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (r9 + r10) * 31;
        if (this.f == true) goto L22;
        r1 = 1237;
    L22:
        int r12 = (r11 + r1) * 31;
        String r13 = this.g;
        if (r13 == null) goto L27;
        r4 = r13.hashCode();
    L27:
        return r12 + r4;
    L17:
        r10 = 1237;
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmAIInterpretationEntity(enabled=" + this.a + ", supportLanguages=" + this.b + ", selectedLanguage=" + this.c + ", activeLanguage=" + this.d + ", loading=" + this.e + ", showEntry=" + this.f + ", errorMessage=" + this.g + ')';
    }

    public /* synthetic */ d(int r9) {
        this(false, CollectionsKt.emptyList(), null, null, false, false, null);
    }

    public d(boolean r2, List<g> r3, g r4, g r5, boolean r6, boolean r7, String r8) {
        Intrinsics.checkNotNullParameter(r3, "supportLanguages");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }

    public static d a(d r8, boolean r9, List r10, g r11, g r12, boolean r13, boolean r14, String r15, int r16) {
        if ((r16 & 1) == 0) goto L5;
        boolean r1 = r8.a;
    L7:
        if ((r16 & 2) == 0) goto L9;
        List r2 = r8.b;
    L11:
        if ((r16 & 4) == 0) goto L13;
        g r3 = r8.c;
    L15:
        if ((r16 & 8) == 0) goto L17;
        g r4 = r8.d;
    L19:
        if ((r16 & 16) == 0) goto L21;
        boolean r5 = r8.e;
    L23:
        if ((r16 & 32) == 0) goto L25;
        boolean r6 = r8.f;
    L27:
        if ((r16 & 64) == 0) goto L29;
        String r7 = r8.g;
    L30:
        r8.getClass();
        Intrinsics.checkNotNullParameter(r2, "supportLanguages");
        return new d(r1, r2, r3, r4, r5, r6, r7);
    L29:
        r7 = r15;
        goto L30
    L25:
        r6 = r14;
        goto L27
    L21:
        r5 = r13;
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
