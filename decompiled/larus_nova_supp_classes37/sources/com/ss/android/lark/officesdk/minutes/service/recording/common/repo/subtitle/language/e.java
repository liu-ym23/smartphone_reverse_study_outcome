package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public final MmAutoTranslationStatus a;
    public final String b;
    public final MmAutoTranslationStage c;
    public final long d;
    public final long e;
    public final String f;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof e) == true) goto L8;
        return false;
    L8:
        e r9 = (e) r8;
        if (this.a == r9.a) goto L12;
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
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        long r1 = this.d;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.e;
        return ((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.f.hashCode();
    }

    public final String toString() {
        return "MmAutoTranslationState(status=" + this.a + ", targetLanguage=" + this.b + ", stage=" + this.c + ", operationId=" + this.d + ", manualRevision=" + this.e + ", reason=" + this.f + ')';
    }

    public e(MmAutoTranslationStatus r2, String r3, MmAutoTranslationStage r4, long r5, long r7, String r9) {
        Intrinsics.checkNotNullParameter(r2, "status");
        Intrinsics.checkNotNullParameter(r3, "targetLanguage");
        Intrinsics.checkNotNullParameter(r4, "stage");
        Intrinsics.checkNotNullParameter(r9, "reason");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r9;
    }

    public static e a(e r9, MmAutoTranslationStatus r10, String r11, MmAutoTranslationStage r12, long r13, long r15, String r17, int r18) {
        if ((r18 & 1) == 0) goto L5;
        MmAutoTranslationStatus r1 = r9.a;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r2 = r9.b;
    L11:
        if ((r18 & 4) == 0) goto L13;
        MmAutoTranslationStage r3 = r9.c;
    L15:
        if ((r18 & 8) == 0) goto L17;
        long r4 = r9.d;
    L19:
        if ((r18 & 16) == 0) goto L21;
        long r6 = r9.e;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r8 = r9.f;
    L26:
        r9.getClass();
        Intrinsics.checkNotNullParameter(r1, "status");
        Intrinsics.checkNotNullParameter(r2, "targetLanguage");
        Intrinsics.checkNotNullParameter(r3, "stage");
        Intrinsics.checkNotNullParameter(r8, "reason");
        return new e(r1, r2, r3, r4, r6, r8);
    L25:
        r8 = r17;
        goto L26
    L21:
        r6 = r15;
        goto L23
    L17:
        r4 = r13;
        goto L19
    L13:
        r3 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }
}
