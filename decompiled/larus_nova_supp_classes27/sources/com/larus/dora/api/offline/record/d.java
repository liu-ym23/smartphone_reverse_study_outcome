package com.larus.dora.api.offline.record;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d {
    public static final d i = null;
    public final boolean a;
    public final int b;
    public final int c;
    public final int d;
    public final String e;
    public final String f;
    public final boolean g;
    public final String h;

    public static final class a {
    }

    public d() {
        this(false, 0, 0, 0, null, null, false, null, 255);
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
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((((((((((r0 * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        if (this.g == true) goto L10;
        r1 = 1237;
    L10:
        int r3 = (r2 + r1) * 31;
        String r4 = this.h;
        if (r4 != null) goto L13;
        int r5 = 0;
    L15:
        return r3 + r5;
    L13:
        r5 = r4.hashCode();
        goto L15
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "DoraOfflineRecordTransferProgress(syncing=" + this.a + ", totalCount=" + this.b + ", completedCount=" + this.c + ", progress=" + this.d + ", currentVuiId=" + this.e + ", localFilePath=" + this.f + ", hasError=" + this.g + ", errorMessage=" + this.h + ')';
    }

    static {
        i = new d(false, 0, 0, 0, null, null, false, null, 255);
    }

    public d(boolean r4, int r5, int r6, int r7, String r8, String r9, boolean r10, String r11, int r12) {
        if ((r12 & 1) == 0) goto L6;
        r4 = false;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r5 = 0;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r6 = 0;
    L12:
        if ((r12 & 8) == 0) goto L15;
        r7 = 0;
    L15:
        if ((r12 & 16) == 0) goto L18;
        r8 = "";
    L18:
        if ((r12 & 32) == 0) goto L21;
        r9 = "";
    L21:
        if ((r12 & 64) == 0) goto L24;
        r10 = false;
    L24:
        if ((r12 & 128) == 0) goto L26;
        r11 = null;
    L26:
        Intrinsics.checkNotNullParameter(r8, "currentVuiId");
        Intrinsics.checkNotNullParameter(r9, "localFilePath");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
    }
}
