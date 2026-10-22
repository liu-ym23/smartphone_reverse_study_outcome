package com.larus.chat.gallery.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class o {
    public final String a;
    public final String b;
    public final PreviewMediaType c;
    public final String d;
    public final int e;
    public final int f;
    public final long g;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof o) == true) goto L8;
        return false;
    L8:
        o r9 = (o) r8;
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
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String r1 = this.d;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (((((r0 + r2) * 31) + this.e) * 31) + this.f) * 31;
        long r4 = this.g;
        return r3 + ((int) (r4 ^ (r4 >>> 32)));
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "PreviewMediaItem(itemKey=" + this.a + ", uri=" + this.b + ", type=" + this.c + ", thumbnailUri=" + this.d + ", width=" + this.e + ", height=" + this.f + ", durationMs=" + this.g + ')';
    }

    public final PreviewMediaType getType() {
        return this.c;
    }

    public o(String r2, String r3, PreviewMediaType r4, String r5, int r6, int r7, long r8) {
        Intrinsics.checkNotNullParameter(r2, "itemKey");
        Intrinsics.checkNotNullParameter(r3, "uri");
        Intrinsics.checkNotNullParameter(r4, "type");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }

    public static o a(o r9, String r10, String r11, String r12, int r13, int r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        r10 = r9.a;
    L5:
        String r1 = r10;
        if ((r15 & 2) == 0) goto L8;
        r11 = r9.b;
    L8:
        String r2 = r11;
        if ((r15 & 4) == 0) goto L11;
        PreviewMediaType r16 = r9.c;
    L12:
        PreviewMediaType r3 = r16;
        if ((r15 & 8) == 0) goto L15;
        r12 = r9.d;
    L15:
        String r4 = r12;
        if ((r15 & 16) == 0) goto L18;
        r13 = r9.e;
    L18:
        int r5 = r13;
        if ((r15 & 32) == 0) goto L21;
        r14 = r9.f;
    L21:
        int r6 = r14;
        if ((r15 & 64) == 0) goto L24;
        long r17 = r9.g;
    L25:
        Intrinsics.checkNotNullParameter(r1, "itemKey");
        Intrinsics.checkNotNullParameter(r2, "uri");
        Intrinsics.checkNotNullParameter(r3, "type");
        return new o(r1, r2, r3, r4, r5, r6, r17);
    L24:
        r17 = 0;
        goto L25
    L11:
        r16 = null;
        goto L12
    }

    public /* synthetic */ o(String r11, String r12, PreviewMediaType r13, String r14, int r15, int r16, long r17, int r19) {
        if ((r19 & 8) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r19 & 16) == 0) goto L9;
        int r6 = 0;
    L11:
        if ((r19 & 32) == 0) goto L13;
        int r7 = 0;
    L15:
        if ((r19 & 64) == 0) goto L17;
        long r8 = 0;
    L18:
        this(r11, r12, r13, r5, r6, r7, r8);
        return;
    L17:
        r8 = r17;
        goto L18
    L13:
        r7 = r16;
        goto L15
    L9:
        r6 = r15;
        goto L11
    L5:
        r5 = r14;
        goto L7
    }
}
