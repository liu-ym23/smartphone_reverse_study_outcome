package com.larus.bmhome.chat;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d5 {
    public final String a;
    public final Uri b;
    public final boolean c;
    public Boolean d;
    public boolean e;
    public final boolean f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d5) == true) goto L8;
        return false;
    L8:
        d5 r6 = (d5) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Uri r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        int r7 = 1231;
        if (this.c == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.d;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        int r11 = (r9 + r1) * 31;
        if (this.e == false) goto L21;
        int r12 = 1231;
    L22:
        int r13 = (r11 + r12) * 31;
        if (this.f == true) goto L27;
        r7 = 1237;
    L27:
        return r13 + r7;
    L21:
        r12 = 1237;
        goto L22
    L13:
        r8 = 1237;
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "SendImgLoadResult(tosKey=" + this.a + ", uri=" + this.b + ", isLocalFile=" + this.c + ", result=" + this.d + ", isFromCache=" + this.e + ", isFromDrive=" + this.f + ')';
    }

    public final void setResult(Boolean r1) {
        this.d = r1;
    }

    public d5(String r2, Uri r3, boolean r4, boolean r5, int r6) {
        if ((r6 & 32) == 0) goto L5;
        r5 = false;
    L5:
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = null;
        this.e = false;
        this.f = r5;
    }
}
