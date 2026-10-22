package com.ctc.wstx.util;

import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final char[] f3712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String[] f3713b;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String[] f3714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        char[] f3715b;
        int c;

        public a(TreeSet<String> r3) {
            int r0 = r3.size();
            String[] r1 = new String[r0];
            this.f3714a = r1;
            r3.toArray(r1);
            if (r0 >= 2) goto L8;
            if (r0 == 0) goto L7;
            this.f3715b = null;
            return;
        L7:
            throw new IllegalArgumentException();
        L8:
            int r2 = r0 * 6;
            if (r2 >= 256) goto L11;
            r2 = 256;
        L11:
            this.f3715b = new char[r2];
        }

        private void a(int r17, int r18, int r19) {
            if (this.c < this.f3715b.length) goto L5;
            a(1);
        L5:
            char[] r3 = this.f3715b;
            int r4 = this.c;
            int r6 = r4 + 1;
            this.c = r6;
            int r7 = 0;
            r3[r4] = 0;
            int r8 = r6 + 1;
            String[] r5 = this.f3714a;
            if (r5[r18].length() == r17) goto L8;
            int r9 = r18;
        L12:
            int r10 = r7;
        L13:
            if (r9 >= r19) goto L23;
            char r11 = r5[r9].charAt(r17);
            int r12 = r9 + 1;
        L15:
            if (r12 >= r19) goto L20;
            if (r5[r12].charAt(r17) != r11) goto L20;
            r12 = r12 + 1;
        L20:
            if ((this.c + 2) <= this.f3715b.length) goto L22;
            a(2);
        L22:
            char[] r13 = this.f3715b;
            int r14 = this.c;
            int r15 = r14 + 1;
            this.c = r15;
            r13[r14] = r11;
            this.c = r15 + 1;
            r13[r15] = (char) (r12 - r9);
            r7 = r7 + 1;
            r9 = r12;
            goto L13
        L23:
            this.f3715b[r8 - 2] = (char) r7;
            if (r10 == 0) goto L26;
            r8 = r8 + 2;
            int r2 = r18 + 1;
        L27:
            int r16 = this.c;
            int r1 = r17 + 1;
        L28:
            if (r8 >= r16) goto L34;
            char[] r20 = this.f3715b;
            char r21 = r20[r8];
            if (r21 != 1) goto L32;
            r20[r8] = (char) (r2 + 57344);
        L33:
            r2 = r2 + r21;
            r8 = r8 + 2;
            goto L28
        L32:
            r20[r8] = (char) this.c;
            a(r1, r2, r2 + r21);
            goto L33
        L34:
            return;
        L26:
            r2 = r18;
            goto L27
        L8:
            if ((this.c + 2) <= this.f3715b.length) goto L10;
            a(2);
        L10:
            char[] r22 = this.f3715b;
            int r110 = this.c;
            int r111 = r110 + 1;
            this.c = r111;
            r22[r110] = 0;
            this.c = r111 + 1;
            r22[r111] = (char) (r18 + 57344);
            r9 = r18 + 1;
            r7 = 1;
            goto L12
        }

        private char[] a(int r6) {
            char[] r0 = this.f3715b;
            int r1 = r0.length;
            if (r1 >= 4096) goto L5;
            int r2 = r1;
        L6:
            int r3 = r2 + r1;
            int r4 = this.c;
            if (r3 >= (r4 + r6)) goto L9;
            r3 = (r4 + r6) + 64;
        L9:
            char[] r7 = new char[r3];
            this.f3715b = r7;
            System.arraycopy(r0, 0, r7, 0, r1);
            return this.f3715b;
        L5:
            r2 = r1 >> 1;
            goto L6
        }

        public o a() {
            char[] r1 = null;
            if (this.f3715b == null) goto L10;
            a(0, 0, this.f3714a.length);
            int r0 = this.c;
            if (r0 <= 57344) goto L8;
            return null;
        L8:
            r1 = new char[r0];
            System.arraycopy(this.f3715b, 0, r1, 0, r0);
        L10:
            return new o(this.f3714a, r1);
        }
    }

    o(String[] r1, char[] r2) {
        this.f3713b = r1;
        this.f3712a = r2;
    }

    public static o a(TreeSet<String> r2) {
        if (r2.size() <= 8192) goto L7;
        return null;
    L7:
        return new a(r2).a();
    }

    private String b(char[] r5, int r6, int r7) {
        int r0 = 0;
        String r4 = this.f3713b[0];
        int r8 = r7 - r6;
        if (r4.length() == r8) goto L5;
        return null;
    L5:
        if (r0 >= r8) goto L10;
        if (r4.charAt(r0) != r5[r6 + r0]) goto L8;
        r0 = r0 + 1;
        goto L5
    L8:
        return null;
    L10:
        return r4;
    }

    public int a() {
        return this.f3713b.length;
    }

    public String a(String r14) {
        char[] r0 = this.f3712a;
        if (r0 != null) goto L8;
        String r13 = this.f3713b[0];
        if (r13.equals(r14) == true) goto L7;
        return null;
    L7:
        return r13;
    L8:
        int r3 = r14.length();
        int r4 = 0;
        char r5 = 0;
    L10:
        if (r4 == r3) goto L12;
        int r7 = r5 + 1;
        char r6 = r0[r5];
        int r8 = r4 + 1;
        char r9 = r14.charAt(r4);
        if (r6 < 7) goto L19;
        int r10 = r6 - 1;
        int r11 = 0;
    L33:
        if (r11 > r10) goto L51;
        int r12 = (r11 + r10) >> 1;
        int r15 = (r12 << 1) + r7;
        int r16 = r0[r15] - r9;
        if (r16 > 0) goto L36;
        if (r16 >= 0) goto L39;
        r11 = r12 + 1;
        goto L33
    L39:
        char r17 = r0[r15 + 1];
    L21:
        r5 = r17;
        if (r5 >= 57344) goto L41;
        r4 = r8;
        goto L10
    L41:
        String r18 = this.f3713b[r5 - 57344];
        if (r18.length() == r14.length()) goto L44;
        return null;
    L44:
        if (r8 >= r3) goto L49;
        if (r18.charAt(r8) != r14.charAt(r8)) goto L47;
        r8 = r8 + 1;
        goto L44
    L47:
        return null;
    L49:
        return r18;
    L36:
        r10 = r12 - 1;
        goto L33
    L51:
        return null;
    L19:
        if (r0[r7] != r9) goto L23;
        r17 = r0[r7 + 1];
        goto L21
    L23:
        if (r0[r7 + 2] != r9) goto L25;
        r17 = r0[r7 + 3];
        goto L21
    L25:
        int r19 = (r6 << 1) + r7;
        int r20 = r7 + 4;
    L26:
        if (r20 >= r19) goto L31;
        if (r0[r20] == r9) goto L29;
        r20 = r20 + 2;
        goto L26
    L29:
        r17 = r0[r20 + 1];
        goto L21
    L31:
        return null;
    L12:
        if (r0[r5 + 1] == 0) goto L14;
        return null;
    L14:
        return this.f3713b[r0[r5 + 2] - 57344];
    }

    public String a(char[] r13, int r14, int r15) {
        char[] r0 = this.f3712a;
        if (r0 == null) goto L5;
        int r2 = r14;
        char r3 = 0;
    L8:
        if (r2 == r15) goto L10;
        int r6 = r3 + 1;
        char r4 = r0[r3];
        int r7 = r2 + 1;
        char r5 = r13[r2];
        if (r4 < 7) goto L17;
        int r8 = r4 - 1;
        int r9 = 0;
    L31:
        if (r9 > r8) goto L50;
        int r10 = (r9 + r8) >> 1;
        int r11 = (r10 << 1) + r6;
        int r12 = r0[r11] - r5;
        if (r12 > 0) goto L34;
        if (r12 >= 0) goto L37;
        r9 = r10 + 1;
        goto L31
    L37:
        char r16 = r0[r11 + 1];
    L19:
        r3 = r16;
        if (r3 >= 57344) goto L39;
        r2 = r7;
        goto L8
    L39:
        String r17 = this.f3713b[r3 - 57344];
        if (r17.length() == (r15 - r14)) goto L42;
        return null;
    L42:
        int r18 = r7 - r14;
    L43:
        if (r7 >= r15) goto L48;
        if (r17.charAt(r18) != r13[r7]) goto L46;
        r18 = r18 + 1;
        r7 = r7 + 1;
        goto L43
    L46:
        return null;
    L48:
        return r17;
    L34:
        r8 = r10 - 1;
        goto L31
    L50:
        return null;
    L17:
        if (r0[r6] != r5) goto L21;
        r16 = r0[r6 + 1];
        goto L19
    L21:
        if (r0[r6 + 2] != r5) goto L23;
        r16 = r0[r6 + 3];
        goto L19
    L23:
        int r19 = (r4 << 1) + r6;
        int r20 = r6 + 4;
    L24:
        if (r20 >= r19) goto L29;
        if (r0[r20] == r5) goto L27;
        r20 = r20 + 2;
        goto L24
    L27:
        r16 = r0[r20 + 1];
        goto L19
    L29:
        return null;
    L10:
        if (r0[r3 + 1] == 0) goto L12;
        return null;
    L12:
        return this.f3713b[r0[r3 + 2] - 57344];
    L5:
        return b(r13, r14, r15);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder((this.f3713b.length << 3) + 16);
        int r1 = this.f3713b.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        if (r2 <= 0) goto L6;
        r0.append(", ");
    L6:
        r0.append(this.f3713b[r2]);
        r2 = r2 + 1;
        goto L3
    L8:
        return r0.toString();
    }
}
