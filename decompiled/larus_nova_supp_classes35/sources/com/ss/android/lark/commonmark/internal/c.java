package com.ss.android.lark.commonmark.internal;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends y7b.a {
    public final v7b.b a;

    public static class a extends y7b.b {
        public a() {
        }

        @Override // y7b.e
        public final d a(y7b.g r5, h.a r6) {
            int r7 = ((h) r5).f;
            if (c.i(r5, r7) == false) goto L17;
            h r8 = (h) r5;
            int r0 = (r8.d + r8.h) + 1;
            CharSequence r9 = r8.a.a;
            int r10 = r7 + 1;
            if (r10 >= r9.length()) goto L12;
            char r11 = r9.charAt(r10);
            if (r11 != '\t') goto L9;
        L11:
            boolean r12 = true;
        L13:
            if (r12 == false) goto L15;
            r0 = r0 + 1;
        L15:
            d r13 = new d(new y7b.d[]{new c()});
            r13.c = r0;
            return r13;
        L9:
            if (r11 == ' ') goto L11;
        L12:
            r12 = false;
            goto L13
        L17:
            return null;
        }
    }

    public c() {
        this.a = new v7b.b();
    }

    @Override // y7b.d
    public final v7b.a a() {
        return this.a;
    }

    @Override // y7b.d
    public final y7b.c h(y7b.g r6) {
        int r0 = ((h) r6).f;
        if (i(r6, r0) == false) goto L15;
        h r7 = (h) r6;
        int r1 = r7.d + r7.h;
        boolean r2 = true;
        int r3 = r1 + 1;
        CharSequence r8 = r7.a.a;
        int r4 = r0 + 1;
        if (r4 >= r8.length()) goto L10;
        char r9 = r8.charAt(r4);
        if (r9 != '\t') goto L9;
    L11:
        if (r2 == false) goto L14;
        r3 = r3 + 1;
    L14:
        return new b(-1, r3, false);
    L9:
        if (r9 == ' ') goto L11;
    L10:
        r2 = false;
        goto L11
    L15:
        return null;
    }

    public static boolean i(y7b.g r2, int r3) {
        CharSequence r0 = ((h) r2).a.a;
        if (((h) r2).h < 4) goto L5;
    L9:
        return false;
    L5:
        if (r3 >= r0.length()) goto L9;
        if (r0.charAt(r3) != '>') goto L9;
        return true;
    }
}
