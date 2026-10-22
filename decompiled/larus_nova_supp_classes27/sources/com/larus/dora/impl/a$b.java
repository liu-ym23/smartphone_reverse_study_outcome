package com.larus.dora.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a$b {
    public static final /* synthetic */ int c = 0;
    public final long a;
    public final long b;

    public static final class a {
        public static a$b a(byte[] r11) {
            Intrinsics.checkNotNullParameter(r11, "payload");
            if (r11.length >= 12) goto L5;
            return null;
        L5:
            if (r11[0] == 82) goto L7;
            return null;
        L7:
            if (((r11[2] & 255) | ((r11[3] & 255) << 8)) == r11.length) goto L10;
            return null;
        L10:
            return new a$b((r11[4] & 255) | ((r11[5] & 255) << 8), ((((((long) r11[9]) & 255) << 8) | (((long) r11[8]) & 255)) | ((((long) r11[10]) & 255) << 16)) | ((((long) r11[11]) & 255) << 24));
        }
    }

    static {
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a$b) == true) goto L8;
        return false;
    L8:
        a$b r9 = (a$b) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        return r1 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public final String toString() {
        return "EtpFrameHeader(requestId=" + this.a + ", functionId=" + this.b + ')';
    }

    public a$b(long r1, long r3) {
        this.a = r1;
        this.b = r3;
    }
}
