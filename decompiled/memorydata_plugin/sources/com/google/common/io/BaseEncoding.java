package com.google.common.io;

import com.google.common.base.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseEncoding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final BaseEncoding f4731a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final BaseEncoding f4732b = null;
    private static final BaseEncoding c = null;
    private static final BaseEncoding d = null;
    private static final BaseEncoding e = null;

    public static final class DecodingException extends IOException {
        DecodingException(String r1) {
            super(r1);
        }

        DecodingException(Throwable r1) {
            super(r1);
        }
    }

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f4733a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f4734b;
        final int c;
        final int d;
        private final String e;
        private final char[] f;
        private final byte[] g;
        private final boolean[] h;
        private final boolean i;

        a(String r3, char[] r4) {
            this(r3, r4, a(r4), false);
        }

        private a(String r4, char[] r5, byte[] r6, boolean r7) {
            this.e = (String) ZeusTransformUtils.preCheckCast(n.a(r4), String.class, "com.obric.memorydata.plugin");
            this.f = (char[]) ZeusTransformUtils.preCheckCast(n.a(r5), char[].class, "com.obric.memorydata.plugin");
            int r8 = com.google.common.math.c.a(r5.length, RoundingMode.UNNECESSARY);     // Catch: ArithmeticException -> L10
            this.f4734b = r8;     // Catch: ArithmeticException -> L10
            int r0 = Integer.numberOfTrailingZeros(r8);
            int r1 = 1 << (3 - r0);
            this.c = r1;
            this.d = r8 >> r0;
            this.f4733a = r5.length - 1;
            this.g = r6;
            boolean[] r9 = new boolean[r1];
            int r10 = 0;
        L6:
            if (r10 >= this.d) goto L8;
            r9[com.google.common.math.c.a(r10 * 8, this.f4734b, RoundingMode.CEILING)] = true;
            r10 = r10 + 1;
            goto L6
        L8:
            this.h = r9;
            this.i = r7;
            return;
        L10:
            e = move-exception;
            throw new IllegalArgumentException("Illegal alphabet length " + r5.length, e);
        }

        private static byte[] a(char[] r9) {
            byte[] r1 = new byte[128];
            Arrays.fill(r1, (byte) -1);
            int r4 = 0;
        L4:
            if (r4 >= r9.length) goto L14;
            char r5 = r9[r4];
            boolean r6 = true;
            if (r5 >= 128) goto L8;
            boolean r7 = true;
        L9:
            n.a(r7, "Non-ASCII character: %s", r5);
            if (r1[r5] == (-1)) goto L13;
            r6 = false;
        L13:
            n.a(r6, "Duplicate character: %s", r5);
            r1[r5] = (byte) r4;
            r4 = r4 + 1;
            goto L4
        L8:
            r7 = false;
            goto L9
        L14:
            return r1;
        }

        static /* synthetic */ char[] a(a r0) {
            return r0.f;
        }

        char a(int r1) {
            return this.f[r1];
        }

        public boolean a(char r2) {
            byte[] r1 = this.g;
            if (r2 < r1.length) goto L5;
        L7:
            return false;
        L5:
            if (r1[r2] == (-1)) goto L7;
            return true;
        }

        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, a.class) == false) goto L10;
            a r5 = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.memorydata.plugin");
            if (this.i == r5.i) goto L7;
            return false;
        L7:
            if (Arrays.equals(this.f, r5.f) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            int r0 = Arrays.hashCode(this.f);
            if (this.i == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public String toString() {
            return this.e;
        }
    }

    static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final char[] f4735a;

        private b(a r5) {
            super(r5, null);
            this.f4735a = new char[512];
            int r1 = 0;
            if (a.a(r5).length != 16) goto L5;
            boolean r0 = true;
        L6:
            n.a(r0);
        L8:
            if (r1 >= 256) goto L10;
            this.f4735a[r1] = r5.a(r1 >>> 4);
            this.f4735a[r1 | 256] = r5.a(r1 & 15);
            r1 = r1 + 1;
            goto L8
        L10:
            return;
        L5:
            r0 = false;
            goto L6
        }

        b(String r2, String r3) {
            this(new a(r2, r3.toCharArray()));
        }
    }

    static final class c extends d {
        private c(a r1, Character r2) {
            super(r1, r2);
            if (a.a(r1).length != 64) goto L5;
            boolean r0 = true;
        L6:
            n.a(r0);
            return;
        L5:
            r0 = false;
            goto L6
        }

        c(String r2, String r3, Character r4) {
            this(new a(r2, r3.toCharArray()), r4);
        }
    }

    static class d extends BaseEncoding {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final a f4736b;
        final Character c;

        d(a r4, Character r5) {
            this.f4736b = (a) ZeusTransformUtils.preCheckCast(n.a(r4), a.class, "com.obric.memorydata.plugin");
            if (r5 != null) goto L5;
        L8:
            boolean r6 = true;
        L9:
            n.a(r6, "Padding character %s was already in alphabet", r5);
            this.c = r5;
            return;
        L5:
            if (r4.a(r5.charValue()) == false) goto L8;
            r6 = false;
            goto L9
        }

        d(String r2, String r3, Character r4) {
            this(new a(r2, r3.toCharArray()), r4);
        }

        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, d.class) == false) goto L10;
            d r5 = (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.memorydata.plugin");
            if (this.f4736b.equals(r5.f4736b) == true) goto L7;
            return false;
        L7:
            if (Objects.equals(this.c, r5.c) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            int r0 = this.f4736b.hashCode();
            return Objects.hashCode(this.c) ^ r0;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("BaseEncoding.");
            r0.append(this.f4736b);
            if ((8 % this.f4736b.f4734b) == 0) goto L9;
            if (this.c != null) goto L7;
            r0.append(".omitPadding()");
            goto L9
        L7:
            r0.append(".withPadChar('").append(this.c).append("')");
        L9:
            return r0.toString();
        }
    }

    static {
        f4731a = new c("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
        f4732b = new c("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
        c = new d("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
        d = new d("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
        e = new b("base16()", "0123456789ABCDEF");
    }

    BaseEncoding() {
    }
}
