package com.ss.android.lark.commonmark.internal;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j extends y7b.a {
    public final v7b.i a;
    public final w7b.g b;

    public static class a extends y7b.b {
        public a() {
        }

        @Override // y7b.e
        public final d a(y7b.g r14, h.a r15) {
            h r16 = (h) r14;
            if (r16.h < 4) goto L5;
            return null;
        L5:
            w7b.f r0 = r16.a;
            int r17 = r16.f;
            if (r0.a.charAt(r17) != '#') goto L45;
            w7b.f r1 = r0.a(r17, r0.a.length());
            ArrayList r6 = new ArrayList();
            r6.add(r1);
            x7b.e r2 = new x7b.e(r6);
            int r7 = r2.f('#');
            if (r7 != 0) goto L10;
        L41:
            j r3 = null;
        L42:
            if (r3 == null) goto L45;
            d r18 = new d(new y7b.d[]{r3});
            r18.b = r0.a.length();
            return r18;
        L10:
            if (r7 > 6) goto L41;
            if (r2.d() == true) goto L15;
            r3 = new j(r7, new w7b.g());
            goto L42
        L15:
            char r8 = r2.j();
            if (r8 == ' ') goto L19;
            if (r8 != '\t') goto L41;
        L19:
            r2.m();
            x7b.d r9 = r2.k();
            x7b.d r10 = r9;
        L20:
            boolean r11 = true;
        L22:
            if (r2.d() == false) goto L37;
            char r12 = r2.j();
            if (r12 == '\t') goto L36;
            if (r12 == ' ') goto L36;
            if (r12 != '#') goto L27;
            if (r11 == true) goto L29;
            r2.g();
            r10 = r2.k();
            goto L22
        L29:
            r2.f('#');
            int r13 = r2.m();
            if (r2.d() == false) goto L32;
            r10 = r2.k();
        L32:
            if (r13 > 0) goto L20;
        L34:
            r11 = false;
            goto L22
        L27:
            r2.g();
            r10 = r2.k();
        L36:
            r2.g();
            goto L20
        L37:
            w7b.g r4 = r2.c(r9, r10);
            if (r4.a().isEmpty() == false) goto L40;
            r3 = new j(r7, new w7b.g());
            goto L42
        L40:
            r3 = new j(r7, r4);
        L45:
            CharSequence r5 = r0.a;
            char r19 = r5.charAt(r17);
            if (r19 != '-') goto L48;
        L62:
            int r110 = r17 + 1;
            int r20 = r5.length();
        L63:
            if (r110 >= r20) goto L69;
            if (r5.charAt(r110) != '-') goto L66;
            r110 = r110 + 1;
            goto L63
        L66:
            r20 = r110;
        L69:
            if (a8b.b.c(r5, r20, r5.length()) < r5.length()) goto L71;
            boolean r111 = true;
        L72:
            if (r111 == false) goto L74;
            int r112 = 2;
        L75:
            if (r112 <= 0) goto L84;
            y7b.d r113 = r15.a;
            if ((r113 instanceof r) == false) goto L79;
            List<w7b.f> r114 = ((r) r113).b.b;
            w7b.g r21 = new w7b.g();
            ((ArrayList) r21.a).addAll(r114);
        L81:
            if (((ArrayList) r21.a).isEmpty() == true) goto L84;
            d r115 = new d(new y7b.d[]{new j(r112, r21)});
            r115.b = r0.a.length();
            r115.d = true;
            return r115;
        L79:
            r21 = new w7b.g();
        L84:
            return null;
        L74:
            r112 = 0;
            goto L75
        L71:
            r111 = false;
            goto L72
        L48:
            if (r19 != '=') goto L74;
            int r22 = r17 + 1;
            int r23 = r5.length();
        L51:
            if (r22 >= r23) goto L57;
            if (r5.charAt(r22) != '=') goto L54;
            r22 = r22 + 1;
            goto L51
        L54:
            r23 = r22;
        L57:
            if (a8b.b.c(r5, r23, r5.length()) < r5.length()) goto L59;
            boolean r24 = true;
        L60:
            if (r24 == false) goto L62;
            r112 = 1;
            goto L75
        L59:
            r24 = false;
            goto L60
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

    @Override // y7b.a, y7b.d
    public final void d(n r3) {
        r3.e(this.b, this.a);
    }

    public j(int r2, w7b.g r3) {
        v7b.i r0 = new v7b.i();
        this.a = r0;
        r0.j = r2;
        this.b = r3;
    }
}
