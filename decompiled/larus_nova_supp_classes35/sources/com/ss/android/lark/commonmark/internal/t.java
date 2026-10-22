package com.ss.android.lark.commonmark.internal;

import v7b.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class t extends y7b.a {
    public final d0 a;

    public static class a extends y7b.b {
        public a() {
        }

        @Override // y7b.e
        public final d a(y7b.g r11, h.a r12) {
            h r13 = (h) r11;
            if (r13.h < 4) goto L5;
            return null;
        L5:
            int r14 = r13.f;
            CharSequence r0 = r13.a.a;
            int r2 = r0.length();
            int r4 = 0;
            int r5 = 0;
            int r6 = 0;
        L7:
            if (r14 >= r2) goto L24;
            char r8 = r0.charAt(r14);
            if (r8 == '\t') goto L22;
            if (r8 == ' ') goto L22;
            if (r8 != '*') goto L15;
            r6 = r6 + 1;
            goto L22
        L15:
            if (r8 != '-') goto L17;
            r4 = r4 + 1;
            goto L22
        L17:
            if (r8 != '_') goto L34;
            r5 = r5 + 1;
        L34:
            boolean r15 = false;
        L35:
            if (r15 == false) goto L38;
            d r16 = new d(new y7b.d[]{new t(String.valueOf(r0.subSequence(r13.c, r0.length())))});
            r16.b = r0.length();
            return r16;
        L38:
            return null;
        L22:
            r14 = r14 + 1;
            goto L7
        L24:
            if (r4 < 3) goto L27;
            if (r5 != 0) goto L27;
            if (r6 != 0) goto L27;
        L33:
            r15 = true;
        L27:
            if (r5 < 3) goto L30;
            if (r4 != 0) goto L30;
            if (r6 == 0) goto L33;
        L30:
            if (r6 < 3) goto L34;
            if (r4 != 0) goto L34;
            if (r5 != 0) goto L34;
            goto L33
        }
    }

    @Override // y7b.d
    public final y7b.c h(y7b.g r1) {
        return null;
    }

    @Override // y7b.d
    public final v7b.a a() {
        return this.a;
    }

    public t(String r1) {
        this.a = new d0();
    }
}
