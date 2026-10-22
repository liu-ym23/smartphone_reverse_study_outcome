package com.larus.bmhome.chat.standarduikit.localfileblock.remote;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g {
    public final String a;
    public final int b;
    public final String c;
    public final String d;
    public final String e;

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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31;
        String r1 = this.d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.e;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "PcRemoteFileRequest(sourceDeviceId=" + this.a + ", sourceAppId=" + this.b + ", filePath=" + this.c + ", fileName=" + this.d + ", fileType=" + this.e + ')';
    }

    public final void b() {
        if (StringsKt.isBlank(this.a) == true) goto L10;
        if (this.b <= 0) goto L10;
        if (StringsKt.isBlank(this.c) == true) goto L10;
        return;
    L10:
        throw new PcRemoteFileException(PcRemoteFileError.INVALID_REQUEST, null, 2, null);
    }

    public static boolean a(String r5) {
        int r0 = r5.length();
        if (1 <= r0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L45;
        int r2 = 0;
    L11:
        if (r2 >= r5.length()) goto L39;
        char r3 = r5.charAt(r2);
        if ('a' <= r3) goto L15;
    L17:
        boolean r4 = false;
    L18:
        if (r4 == false) goto L20;
    L35:
        boolean r6 = true;
    L36:
        if (r6 == false) goto L37;
        r2 = r2 + 1;
        goto L11
    L37:
        boolean r7 = false;
    L40:
        if (r7 == false) goto L46;
        return true;
    L46:
        return false;
    L20:
        if ('A' <= r3) goto L22;
    L24:
        boolean r8 = false;
    L25:
        if (r8 == true) goto L35;
        if ('0' <= r3) goto L29;
    L31:
        boolean r9 = false;
    L32:
        if (r9 == true) goto L35;
        r6 = false;
        goto L36
    L29:
        if (r3 >= ':') goto L31;
        r9 = true;
        goto L32
    L22:
        if (r3 >= '[') goto L24;
        r8 = true;
        goto L25
    L15:
        if (r3 >= '{') goto L17;
        r4 = true;
        goto L18
    L39:
        r7 = true;
        goto L40
    L45:
        return false;
    L5:
        if (r0 >= 21) goto L7;
        r1 = true;
        goto L8
    }

    public g(String r2, int r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "sourceDeviceId");
        Intrinsics.checkNotNullParameter(r4, "filePath");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
