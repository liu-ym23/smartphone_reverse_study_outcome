package com.ss.android.lark.commonmark.internal;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import v7b.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class p extends y7b.a {
    public final v7b.p a;
    public boolean b;
    public int c;

    public static class a extends y7b.b {
        public a() {
        }

        @Override // y7b.e
        public final d a(y7b.g r17, h.a r18) {
            y7b.d r0 = r18.a;
            h r1 = (h) r17;
            int r2 = r1.h;
            if (r2 < 4) goto L5;
            return null;
        L5:
            int r5 = r1.f;
            int r6 = r1.d + r2;
            if ((r0 instanceof r) == false) goto L8;
            List<w7b.f> r3 = ((r) r0).b.b;
            w7b.g r7 = new w7b.g();
            ((ArrayList) r7.a).addAll(r3);
        L9:
            boolean r4 = !((ArrayList) r7.a).isEmpty();
            CharSequence r8 = r1.a.a;
            char r9 = r8.charAt(r5);
            if (r9 != '*') goto L12;
        L37:
            int r10 = r5 + 1;
            if (r10 >= r8.length()) goto L43;
            char r13 = r8.charAt(r10);
            if (r13 == '\t') goto L43;
            if (r13 == ' ') goto L43;
            boolean r14 = false;
        L44:
            if (r14 == false) goto L46;
            v7b.c r15 = new v7b.c();
            r15.j = String.valueOf(r9);
            c r11 = new c(r15, r10);
        L47:
            if (r11 == null) goto L66;
            v7b.p r12 = r11.a;
            int r16 = r11.b;
            int r19 = r6 + (r16 - r5);
            int r20 = r8.length();
            int r110 = r19;
        L50:
            if (r16 >= r20) goto L58;
            char r111 = r8.charAt(r16);
            if (r111 != '\t') goto L54;
            r110 = r110 + (4 - (r110 % 4));
        L56:
            r16 = r16 + 1;
            goto L50
        L54:
            if (r111 != ' ') goto L57;
            r110 = r110 + 1;
            goto L56
        L57:
            boolean r21 = true;
        L59:
            if (r4 == true) goto L61;
        L67:
            if (r21 == true) goto L69;
        L70:
            r110 = r19 + 1;
        L71:
            b r22 = new b(r12, r110);
        L72:
            if (r22 != null) goto L74;
            return null;
        L74:
            int r23 = r22.b;
            q r24 = new q(r1.h, r23 - r1.d, r22.c);
            if ((r0 instanceof p) == false) goto L91;
            v7b.p r25 = (v7b.p) r0.a();
            v7b.p r26 = r22.a;
            if ((r25 instanceof v7b.c) == false) goto L82;
            if ((r26 instanceof v7b.c) == false) goto L82;
            boolean r27 = Objects.equals(((v7b.c) r25).j, ((v7b.c) r26).j);
        L87:
            if (r27 == false) goto L91;
            d r28 = new d(new y7b.d[]{r24});
            r28.c = r23;
            return r28;
        L82:
            if ((r25 instanceof u) == true) goto L84;
        L86:
            r27 = false;
            goto L87
        L84:
            if ((r26 instanceof u) == false) goto L86;
            r27 = Objects.equals(((u) r25).j, ((u) r26).j);
        L91:
            v7b.p r29 = r22.a;
            p r30 = new p(r29);
            r29.getClass();
            d r31 = new d(new y7b.d[]{r30, r24});
            r31.c = r23;
            return r31;
        L69:
            if ((r110 - r19) <= 4) goto L71;
        L61:
            if ((r12 instanceof u) == true) goto L63;
        L65:
            if (r21 == true) goto L67;
        L63:
            if (((u) r12).k.intValue() == 1) goto L65;
        L58:
            r21 = false;
        L66:
            r22 = null;
        L46:
            r11 = null;
        L43:
            r14 = true;
            goto L44
        L12:
            if (r9 == '+') goto L37;
            if (r9 == '-') goto L37;
            int r32 = r8.length();
            int r112 = r5;
            int r113 = 0;
        L16:
            if (r112 >= r32) goto L46;
            char r114 = r8.charAt(r112);
            if (r114 == ')') goto L27;
            if (r114 == '.') goto L27;
            switch(r114) {
                case 48: goto L23;
                case 49: goto L23;
                case 50: goto L23;
                case 51: goto L23;
                case 52: goto L23;
                case 53: goto L23;
                case 54: goto L23;
                case 55: goto L23;
                case 56: goto L23;
                case 57: goto L23;
                default: goto L46;
            };
        L23:
            r113 = r113 + 1;
            if (r113 > 9) goto L46;
            r112 = r112 + 1;
        L27:
            if (r113 < 1) goto L46;
            int r33 = r112 + 1;
            if (r33 >= r8.length()) goto L34;
            char r115 = r8.charAt(r33);
            if (r115 == '\t') goto L34;
            if (r115 == ' ') goto L34;
            boolean r116 = false;
        L35:
            if (r116 == false) goto L46;
            String r117 = r8.subSequence(r5, r112).toString();
            u r118 = new u();
            r118.k = Integer.valueOf(CastIntegerProtector.parseInt(r117));
            r118.j = String.valueOf(r114);
            r11 = new c(r118, r33);
        L34:
            r116 = true;
            goto L35
        L8:
            r7 = new w7b.g();
            goto L9
        }
    }

    public static class b {
        public final v7b.p a;
        public final int b;
        public final Integer c;

        public b(v7b.p r1, int r2) {
            this.a = r1;
            this.b = r2;
            if ((r1 instanceof u) == false) goto L5;
            Integer r3 = ((u) r1).k;
        L6:
            this.c = r3;
            return;
        L5:
            r3 = null;
            goto L6
        }
    }

    public static class c {
        public final v7b.p a;
        public final int b;

        public c(v7b.p r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // y7b.a, y7b.d
    public final boolean isContainer() {
        return true;
    }

    @Override // y7b.d
    public final v7b.a a() {
        return this.a;
    }

    public p(v7b.p r1) {
        this.a = r1;
    }

    @Override // y7b.a, y7b.d
    public final boolean g(v7b.a r3) {
        if ((r3 instanceof v7b.q) == true) goto L5;
        return false;
    L5:
        if (this.b == true) goto L7;
    L9:
        return true;
    L7:
        if (this.c != 1) goto L9;
        this.a.getClass();
        this.b = false;
        goto L9
    }

    @Override // y7b.d
    public final y7b.c h(y7b.g r3) {
        h r4 = (h) r3;
        if (r4.i == false) goto L6;
        this.b = true;
        this.c = 0;
    L9:
        return y7b.c.a(r4.c);
    L6:
        if (this.b == false) goto L9;
        this.c++;
        goto L9
    }
}
