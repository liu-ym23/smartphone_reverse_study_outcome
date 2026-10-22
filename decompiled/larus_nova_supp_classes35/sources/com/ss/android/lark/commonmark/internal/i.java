package com.ss.android.lark.commonmark.internal;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i extends y7b.a {
    public final v7b.g a;
    public final char b;
    public final int c;
    public String d;
    public final StringBuilder e;

    public static class a extends y7b.b {
        public a() {
        }

        @Override // y7b.e
        public final d a(y7b.g r11, h.a r12) {
            h r13 = (h) r11;
            int r14 = r13.h;
            if (r14 < 4) goto L5;
            return null;
        L5:
            int r0 = r13.f;
            CharSequence r15 = r13.a.a;
            int r2 = r15.length();
            int r4 = r0;
            int r5 = 0;
            int r6 = 0;
        L7:
            if (r4 >= r2) goto L16;
            char r9 = r15.charAt(r4);
            if (r9 == '`') goto L13;
            if (r9 != '~') goto L16;
            r6 = r6 + 1;
        L14:
            r4 = r4 + 1;
            goto L7
        L13:
            r5 = r5 + 1;
        L16:
            if (r5 < 3) goto L29;
            if (r6 != 0) goto L29;
            int r3 = r0 + r5;
            int r7 = r15.length();
        L20:
            if (r3 >= r7) goto L25;
            if (r15.charAt(r3) == '`') goto L26;
            r3 = r3 + 1;
        L26:
            if (r3 != (-1)) goto L32;
            i r16 = new i('`', r5, r14);
        L33:
            if (r16 == null) goto L42;
            d r1 = new d(new y7b.d[]{r16});
            r1.b = r0 + r16.a.j.intValue();
            return r1;
        L42:
            return null;
        L32:
            r16 = null;
            goto L33
        L25:
            r3 = -1;
        L29:
            if (r6 < 3) goto L32;
            if (r5 != 0) goto L32;
            r16 = new i('~', r6, r14);
            goto L33
        }
    }

    @Override // y7b.a, y7b.d
    public final void c() {
        v7b.g r0 = this.a;
        r0.m = u7b.a.b(this.d.trim());
        v7b.g r1 = this.a;
        r1.n = this.e.toString();
    }

    @Override // y7b.d
    public final v7b.a a() {
        return this.a;
    }

    @Override // y7b.a, y7b.d
    public final void e(w7b.f r2) {
        if (this.d != null) goto L5;
        this.d = r2.a.toString();
        return;
    L5:
        this.e.append(r2.a);
        this.e.append('\n');
    }

    @Override // y7b.d
    public final y7b.c h(y7b.g r7) {
        h r8 = (h) r7;
        int r0 = r8.f;
        int r1 = r8.c;
        CharSequence r2 = r8.a.a;
        if (r8.h < 4) goto L5;
    L37:
        int r9 = this.a.l;
        int r3 = r2.length();
    L38:
        if (r9 <= 0) goto L44;
        if (r1 >= r3) goto L44;
        if (r2.charAt(r1) != ' ') goto L44;
        r1 = r1 + 1;
        r9 = r9 - 1;
    L44:
        return y7b.c.a(r1);
    L5:
        if (r0 >= r2.length()) goto L37;
        char r10 = this.b;
        int r4 = r2.length();
        int r5 = r0;
    L7:
        if (r5 >= r4) goto L12;
        if (r2.charAt(r5) != r10) goto L10;
        r5 = r5 + 1;
        goto L7
    L10:
        r4 = r5;
    L12:
        int r6 = r4 - r0;
        if (r6 >= this.c) goto L16;
    L33:
        boolean r11 = false;
    L34:
        if (r11 == false) goto L37;
        return new b(-1, -1, true);
    L16:
        if (a8b.b.c(r2, r0 + r6, r2.length()) != r2.length()) goto L33;
        v7b.g r12 = this.a;
        Integer r13 = Integer.valueOf(r6);
        if (r13 == null) goto L24;
        r12.getClass();
        if (r13.intValue() >= 3) goto L24;
        throw new IllegalArgumentException("closingFenceLength needs to be >= 3");
    L24:
        Integer r14 = r12.j;
        if (r14 == null) goto L32;
        if (r13 == null) goto L32;
        if (r13.intValue() >= r14.intValue()) goto L32;
        throw new IllegalArgumentException("fence lengths required to be: closingFenceLength >= openingFenceLength");
    L32:
        r12.k = r13;
        r11 = true;
        goto L34
    }

    public i(char r3, int r4, int r5) {
        v7b.g r0 = new v7b.g();
        this.a = r0;
        this.e = new StringBuilder();
        this.b = r3;
        this.c = r4;
        String.valueOf(r3);
        Integer r6 = Integer.valueOf(r4);
        if (r6 != null) goto L5;
    L9:
        Integer r7 = r0.k;
        if (r6 == null) goto L17;
        if (r7 == null) goto L17;
        if (r7.intValue() >= r6.intValue()) goto L17;
        throw new IllegalArgumentException("fence lengths required to be: closingFenceLength >= openingFenceLength");
    L17:
        r0.j = r6;
        r0.l = r5;
        return;
    L5:
        if (r6.intValue() >= 3) goto L9;
        throw new IllegalArgumentException("openingFenceLength needs to be >= 3");
    }
}
