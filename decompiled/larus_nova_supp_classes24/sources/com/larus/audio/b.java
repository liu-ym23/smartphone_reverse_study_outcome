package com.larus.audio;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public final String a;
    public final String b;
    public final long c;
    public final String d;
    public final boolean e;
    public final String f;
    public final c g;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == true) goto L8;
        return false;
    L8:
        b r9 = (b) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        long r1 = this.c;
        int r2 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.d.hashCode()) * 31;
        if (this.e == false) goto L5;
        int r3 = 1231;
    L6:
        int r4 = (r2 + r3) * 31;
        String r5 = this.f;
        int r6 = 0;
        if (r5 != null) goto L9;
        int r7 = 0;
    L10:
        int r8 = (r4 + r7) * 31;
        c r9 = this.g;
        if (r9 == null) goto L15;
        r6 = r9.hashCode();
    L15:
        return r8 + r6;
    L9:
        r7 = r5.hashCode();
        goto L10
    L5:
        r3 = 1237;
        goto L6
    }

    public final String toString() {
        return "AsrSuccessResult(taskId=" + this.a + ", messageContent=" + this.b + ", audioDuration=" + this.c + ", vid=" + this.d + ", alterToVoiceSend=" + this.e + ", path=" + this.f + ", extra=" + this.g + ')';
    }

    public static b a(b r9, boolean r10) {
        String r1 = r9.a;
        String r2 = r9.b;
        long r3 = r9.c;
        String r5 = r9.d;
        String r7 = r9.f;
        c r8 = r9.g;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r1, "taskId");
        Intrinsics.checkNotNullParameter(r2, "messageContent");
        Intrinsics.checkNotNullParameter(r5, "vid");
        return new b(r1, r2, r3, r5, r10, r7, r8);
    }

    public b(String r2, String r3, long r4, String r6, boolean r7, String r8, c r9) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "messageContent");
        Intrinsics.checkNotNullParameter(r6, "vid");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
    }

    public /* synthetic */ b(String r10, String r11, long r12, String r14, String r15, c r16, int r17) {
        if ((r17 & 64) == 0) goto L5;
        c r8 = null;
    L6:
        this(r10, r11, r12, r14, false, r15, r8);
        return;
    L5:
        r8 = r16;
        goto L6
    }
}
