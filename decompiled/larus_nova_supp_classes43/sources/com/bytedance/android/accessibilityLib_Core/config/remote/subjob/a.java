package com.bytedance.android.accessibilityLib_Core.config.remote.subjob;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof a) == false) goto L18;
        a r11 = (a) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L16;
        return false;
    L16:
        if (this.f == r11.f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.b;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.c;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.d;
        if (r18 == null) goto L17;
        int r19 = r18.hashCode();
    L18:
        int r20 = (r17 + r19) * 31;
        String r21 = this.e;
        if (r21 == null) goto L21;
        r1 = r21.hashCode();
    L21:
        int r22 = (r20 + r1) * 31;
        boolean r23 = this.f;
        ?? r24 = r23;
        if (r23 == false) goto L25;
        r24 = 1;
    L25:
        return r22 + r24;
    L17:
        r19 = 0;
        goto L18
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "DownloadParam(url='" + this.a + "', fileName='" + this.c + "', savepath = " + this.b + ", saveName='" + this.d + "', mimeType='" + this.e + "')";
    }

    public a(String r1, String r10) {
        this.a = r1;
        this.b = r10;
        this.c = "r_accessibility.txt";
        this.d = "r_accessibility.txt.zip";
        this.e = "application/zip";
        this.f = false;
    }
}
