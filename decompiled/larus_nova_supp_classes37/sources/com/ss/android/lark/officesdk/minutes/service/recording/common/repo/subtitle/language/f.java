package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f {
    public final List<h> a;
    public final List<h> b;
    public final h c;
    public final h d;
    public final boolean e;
    public final boolean f;
    public final boolean g;

    public f() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
        if (this.g == r6.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        int r2 = 1231;
        if (this.e == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.f == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.g == true) goto L15;
        r2 = 1237;
    L15:
        return r5 + r2;
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmRecordingLanguageEntity(spokenLanguageList=" + this.a + ", translateLanguageList=" + this.b + ", currSpokenLanguage=" + this.c + ", currTranslateLanguage=" + this.d + ", isBilingual=" + this.e + ", isLanguageSettingsReady=" + this.f + ", isTranslateLanguageListReady=" + this.g + ')';
    }

    public /* synthetic */ f(int r9) {
        this(CollectionsKt.emptyList(), CollectionsKt.emptyList(), new h(0), new h(0), false, false, false);
    }

    public f(List<h> r2, List<h> r3, h r4, h r5, boolean r6, boolean r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r2, "spokenLanguageList");
        Intrinsics.checkNotNullParameter(r3, "translateLanguageList");
        Intrinsics.checkNotNullParameter(r4, "currSpokenLanguage");
        Intrinsics.checkNotNullParameter(r5, "currTranslateLanguage");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }

    public static f a(f r8, List r9, List r10, h r11, h r12, boolean r13, boolean r14, boolean r15, int r16) {
        if ((r16 & 1) == 0) goto L5;
        List r1 = r8.a;
    L7:
        if ((r16 & 2) == 0) goto L9;
        List r2 = r8.b;
    L11:
        if ((r16 & 4) == 0) goto L13;
        h r3 = r8.c;
    L15:
        if ((r16 & 8) == 0) goto L17;
        h r4 = r8.d;
    L19:
        if ((r16 & 16) == 0) goto L21;
        boolean r5 = r8.e;
    L23:
        if ((r16 & 32) == 0) goto L25;
        boolean r6 = r8.f;
    L27:
        if ((r16 & 64) == 0) goto L29;
        boolean r7 = r8.g;
    L30:
        r8.getClass();
        Intrinsics.checkNotNullParameter(r1, "spokenLanguageList");
        Intrinsics.checkNotNullParameter(r2, "translateLanguageList");
        Intrinsics.checkNotNullParameter(r3, "currSpokenLanguage");
        Intrinsics.checkNotNullParameter(r4, "currTranslateLanguage");
        return new f(r1, r2, r3, r4, r5, r6, r7);
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
