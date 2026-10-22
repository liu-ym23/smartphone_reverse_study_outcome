package com.larksuite.framework.utils;

import com.larus.audio.call.dora.CommandStatus;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class j {
    public static final ConcurrentMap<d, j> f = null;
    public static final ConcurrentMap<C0056j, String> g = null;
    public final String a;
    public final TimeZone b;
    public final Locale c;
    public transient g[] d;
    public transient int e;

    public static class a implements g {
        public final char a;

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            return 1;
        }

        public a(char r1) {
            this.a = r1;
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r1, Calendar r2) throws IOException {
            StringBuilder r3 = (StringBuilder) r1;
            r3.append(this.a);
        }
    }

    public static class b implements e {
        public final e a;

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            return this.a.estimateLength();
        }

        public b(e r1) {
            this.a = r1;
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r4, Calendar r5) throws IOException {
            int r0 = 7;
            int r6 = r5.get(7);
            e r1 = this.a;
            if (r6 == 1) goto L6;
            r0 = r6 - 1;
        L6:
            r1.appendTo(r4, r0);
        }

        @Override // com.larksuite.framework.utils.j.e
        public final void appendTo(Appendable r2, int r3) throws IOException {
            this.a.appendTo(r2, r3);
        }
    }

    public static class c implements g {
        public static final c b = null;
        public static final c c = null;
        public static final c d = null;
        public final int a;

        static {
            b = new c(3);
            c = new c(5);
            d = new c(6);
        }

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            return this.a;
        }

        public c(int r1) {
            this.a = r1;
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r4, Calendar r5) throws IOException {
            int r0 = r5.get(15) + r5.get(16);
            if (r0 != 0) goto L6;
            ((StringBuilder) r4).append("Z");
            return;
        L6:
            if (r0 >= 0) goto L8;
            ((StringBuilder) r4).append('-');
            r0 = -r0;
        L9:
            int r6 = r0 / 3600000;
            j.a(r4, r6);
            int r1 = this.a;
            if (r1 >= 5) goto L13;
            return;
        L13:
            if (r1 != 6) goto L15;
            ((StringBuilder) r4).append(':');
        L15:
            j.a(r4, (r0 / 60000) - (r6 * 60));
            return;
        L8:
            ((StringBuilder) r4).append('+');
            goto L9
        }
    }

    public static class d {
        public final Object[] a;
        public int b;

        public final int hashCode() {
            if (this.b != 0) goto L12;
            Object[] r0 = this.a;
            int r1 = r0.length;
            int r2 = 0;
            int r3 = 0;
        L5:
            if (r2 >= r1) goto L10;
            Object r4 = r0[r2];
            if (r4 == null) goto L9;
            r3 = (r3 * 7) + r4.hashCode();
        L9:
            r2 = r2 + 1;
            goto L5
        L10:
            this.b = r3;
        L12:
            return this.b;
        }

        public d(Object... r1) {
            this.a = r1;
        }

        public final boolean equals(Object r2) {
            return Arrays.equals(this.a, ((d) r2).a);
        }
    }

    public interface e extends g {
        void appendTo(Appendable r1, int r2) throws IOException;
    }

    public static class f implements e {
        public final int a;
        public final int b;

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            return this.b;
        }

        public f(int r2, int r3) {
            if (r3 < 3) goto L7;
            this.a = r2;
            this.b = r3;
            return;
        L7:
            throw new IllegalArgumentException();
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r2, Calendar r3) throws IOException {
            appendTo(r2, r3.get(this.a));
        }

        @Override // com.larksuite.framework.utils.j.e
        public final void appendTo(Appendable r2, int r3) throws IOException {
            j.b(r2, r3, this.b);
        }
    }

    public interface g {
        void appendTo(Appendable r1, Calendar r2) throws IOException;

        int estimateLength();
    }

    public static class h implements g {
        public final String a;

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            return this.a.length();
        }

        public h(String r1) {
            this.a = r1;
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r1, Calendar r2) throws IOException {
            StringBuilder r3 = (StringBuilder) r1;
            r3.append(this.a);
        }
    }

    public static class i implements g {
        public final int a;
        public final String[] b;

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            int r0 = this.b.length;
            int r1 = 0;
        L3:
            r0 = r0 - 1;
            if (r0 < 0) goto L8;
            int r2 = this.b[r0].length();
            if (r2 <= r1) goto L3;
            r1 = r2;
            goto L3
        L8:
            return r1;
        }

        public i(int r1, String[] r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r3, Calendar r4) throws IOException {
            StringBuilder r5 = (StringBuilder) r3;
            r5.append(this.b[r4.get(this.a)]);
        }
    }

    /* JADX INFO: renamed from: com.larksuite.framework.utils.j$j, reason: collision with other inner class name */
    public static class C0056j {
        public final TimeZone a;
        public final int b;
        public final Locale c;

        public final int hashCode() {
            return (((this.b * 31) + this.c.hashCode()) * 31) + this.a.hashCode();
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0056j) == false) goto L16;
            C0056j r6 = (C0056j) r5;
            if (this.a.equals(r6.a) == true) goto L10;
        L14:
            return false;
        L10:
            if (this.b != r6.b) goto L14;
            if (this.c.equals(r6.c) == false) goto L14;
            return true;
        L16:
            return false;
        }

        public C0056j(TimeZone r1, boolean r2, int r3, Locale r4) {
            this.a = r1;
            if (r2 == false) goto L5;
            this.b = Integer.MIN_VALUE | r3;
        L6:
            this.c = r4;
            return;
        L5:
            this.b = r3;
            goto L6
        }
    }

    public static class k implements g {
        public final Locale a;
        public final int b;
        public final String c;
        public final String d;

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            return Math.max(this.c.length(), this.d.length());
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r4, Calendar r5) throws IOException {
            TimeZone r0 = r5.getTimeZone();
            if (r5.get(16) != 0) goto L5;
            StringBuilder r6 = (StringBuilder) r4;
            r6.append(j.c(r0, false, this.b, this.a));
            return;
        L5:
            StringBuilder r7 = (StringBuilder) r4;
            r7.append(j.c(r0, true, this.b, this.a));
        }

        public k(TimeZone r2, Locale r3, int r4) {
            this.a = r3;
            this.b = r4;
            this.c = j.c(r2, false, r4, r3);
            this.d = j.c(r2, true, r4, r3);
        }
    }

    public static class l implements g {
        public static final l b = null;
        public static final l c = null;
        public final boolean a;

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            return 5;
        }

        static {
            b = new l(true);
            c = new l(false);
        }

        public l(boolean r1) {
            this.a = r1;
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r4, Calendar r5) throws IOException {
            int r0 = r5.get(15) + r5.get(16);
            if (r0 >= 0) goto L5;
            ((StringBuilder) r4).append('-');
            r0 = -r0;
        L6:
            int r6 = r0 / 3600000;
            j.a(r4, r6);
            if (this.a == false) goto L9;
            ((StringBuilder) r4).append(':');
        L9:
            j.a(r4, (r0 / 60000) - (r6 * 60));
            return;
        L5:
            ((StringBuilder) r4).append('+');
            goto L6
        }
    }

    public static class m implements e {
        public final e a;

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            return this.a.estimateLength();
        }

        public m(e r1) {
            this.a = r1;
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r3, Calendar r4) throws IOException {
            int r1 = r4.get(10);
            if (r1 != 0) goto L5;
            r1 = r4.getLeastMaximum(10) + 1;
        L5:
            this.a.appendTo(r3, r1);
        }

        @Override // com.larksuite.framework.utils.j.e
        public final void appendTo(Appendable r2, int r3) throws IOException {
            this.a.appendTo(r2, r3);
        }
    }

    public static class n implements e {
        public final e a;

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            return this.a.estimateLength();
        }

        public n(e r1) {
            this.a = r1;
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r3, Calendar r4) throws IOException {
            int r1 = r4.get(11);
            if (r1 != 0) goto L5;
            r1 = r4.getMaximum(11) + 1;
        L5:
            this.a.appendTo(r3, r1);
        }

        @Override // com.larksuite.framework.utils.j.e
        public final void appendTo(Appendable r2, int r3) throws IOException {
            this.a.appendTo(r2, r3);
        }
    }

    public static class o implements e {
        public static final o a = null;

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            return 2;
        }

        static {
            a = new o();
        }

        public o() {
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r2, Calendar r3) throws IOException {
            j.a(r2, r3.get(2) + 1);
        }

        @Override // com.larksuite.framework.utils.j.e
        public final void appendTo(Appendable r1, int r2) throws IOException {
            j.a(r1, r2);
        }
    }

    public static class p implements e {
        public final int a;

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            return 2;
        }

        public p(int r1) {
            this.a = r1;
        }

        @Override // com.larksuite.framework.utils.j.e
        public final void appendTo(Appendable r2, int r3) throws IOException {
            if (r3 >= 100) goto L5;
            j.a(r2, r3);
            return;
        L5:
            j.b(r2, r3, 2);
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r2, Calendar r3) throws IOException {
            appendTo(r2, r3.get(this.a));
        }
    }

    public static class q implements e {
        public static final q a = null;

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            return 2;
        }

        static {
            a = new q();
        }

        public q() {
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r2, Calendar r3) throws IOException {
            j.a(r2, r3.get(1) % 100);
        }

        @Override // com.larksuite.framework.utils.j.e
        public final void appendTo(Appendable r1, int r2) throws IOException {
            j.a(r1, r2);
        }
    }

    public static class r implements e {
        public static final r a = null;

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            return 2;
        }

        static {
            a = new r();
        }

        public r() {
        }

        @Override // com.larksuite.framework.utils.j.e
        public final void appendTo(Appendable r2, int r3) throws IOException {
            if (r3 >= 10) goto L5;
            StringBuilder r4 = (StringBuilder) r2;
            r4.append((char) (r3 + 48));
            return;
        L5:
            j.a(r2, r3);
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r2, Calendar r3) throws IOException {
            appendTo(r2, r3.get(2) + 1);
        }
    }

    public static class s implements e {
        public final int a;

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            return 4;
        }

        public s(int r1) {
            this.a = r1;
        }

        @Override // com.larksuite.framework.utils.j.e
        public final void appendTo(Appendable r2, int r3) throws IOException {
            if (r3 >= 10) goto L6;
            StringBuilder r4 = (StringBuilder) r2;
            r4.append((char) (r3 + 48));
            return;
        L6:
            if (r3 >= 100) goto L8;
            j.a(r2, r3);
            return;
        L8:
            j.b(r2, r3, 1);
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r2, Calendar r3) throws IOException {
            appendTo(r2, r3.get(this.a));
        }
    }

    public static class t implements e {
        public final e a;

        @Override // com.larksuite.framework.utils.j.g
        public final int estimateLength() {
            return this.a.estimateLength();
        }

        public t(e r1) {
            this.a = r1;
        }

        @Override // com.larksuite.framework.utils.j.g
        public final void appendTo(Appendable r1, Calendar r2) throws IOException {
            throw new UnsupportedOperationException("getWeekYear not support");
        }

        @Override // com.larksuite.framework.utils.j.e
        public final void appendTo(Appendable r2, int r3) throws IOException {
            this.a.appendTo(r2, r3);
        }
    }

    static {
        f = new ConcurrentHashMap(7);
        g = new ConcurrentHashMap(7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v38 */
    /* JADX WARN: Type inference failed for: r7v9, types: [com.larksuite.framework.utils.j$e] */
    public final void d() {
        DateFormatSymbols r1 = new DateFormatSymbols(this.c);
        ArrayList r2 = new ArrayList();
        String[] r3 = r1.getEras();
        String[] r4 = r1.getMonths();
        String[] r5 = r1.getShortMonths();
        String[] r6 = r1.getWeekdays();
        String[] r7 = r1.getShortWeekdays();
        String[] r8 = r1.getAmPmStrings();
        int r9 = this.a.length();
        int[] r10 = new int[1];
        char r11 = 0;
        int r12 = 0;
    L3:
        if (r12 >= r9) goto L123;
        r10[r11] = r12;
        String r13 = this.a;
        StringBuilder r14 = new StringBuilder();
        int r15 = r10[r11];
        int r16 = r13.length();
        char r17 = r13.charAt(r15);
        String[] r19 = r6;
        if (r17 < 'A') goto L9;
        if (r17 > 'Z') goto L9;
    L11:
        r14.append(r17);
    L12:
        int r20 = r15 + 1;
        if (r20 >= r16) goto L41;
        if (r13.charAt(r20) != r17) goto L41;
        r14.append(r17);
        r15 = r20;
    L41:
        String[] r110 = r7;
    L42:
        r10[0] = r15;
        String r21 = r14.toString();
        int r22 = r10[0];
        int r111 = r21.length();
        if (r111 == 0) goto L123;
        char r112 = r21.charAt(0);
        if (r112 == 'y') goto L112;
        if (r112 == 'z') goto L107;
        switch(r112) {
            case 39: goto L76;
            case 75: goto L75;
            case 77: goto L67;
            case 83: goto L65;
            case 97: goto L64;
            case 100: goto L63;
            case 104: goto L61;
            case 107: goto L60;
            case 109: goto L59;
            case 115: goto L58;
            case 117: goto L57;
            case 119: goto L56;
            default: goto L52;
        };
    L56:
        g r23 = e(3, r111);
    L110:
        ?? r24 = r23;
    L122:
        r2.add(r24);
        r12 = r22 + 1;
        r6 = r19;
        r7 = r110;
        r11 = 0;
        goto L3
    L57:
        r23 = new b(e(7, r111));
        goto L110
    L58:
        r23 = e(13, r111);
        goto L110
    L59:
        r23 = e(12, r111);
        goto L110
    L60:
        r23 = new n(e(11, r111));
        goto L110
    L61:
        g r25 = new m(e(10, r111));
    L62:
        r23 = r25;
        goto L110
    L63:
        r23 = e(5, r111);
        goto L110
    L64:
        r23 = new i(9, r8);
        goto L110
    L65:
        r23 = e(14, r111);
        goto L110
    L75:
        r23 = e(10, r111);
        goto L110
    L76:
        String r26 = r21.substring(1);
        if (r26.length() != 1) goto L79;
        r23 = new a(r26.charAt(0));
        goto L110
    L79:
        r23 = new h(r26);
        goto L110
    L52:
        switch(r112) {
            case 68: goto L88;
            case 69: goto L84;
            case 70: goto L82;
            case 71: goto L81;
            case 72: goto L80;
            default: goto L53;
        };
    L53:
        switch(r112) {
            case 87: goto L105;
            case 88: goto L97;
            case 89: goto L112;
            case 90: goto L90;
            default: goto L55;
        };
    L105:
        r23 = e(4, r111);
        goto L110
    L90:
        if (r111 != 1) goto L93;
        r25 = l.c;
        goto L62
    L93:
        if (r111 != 2) goto L95;
        r25 = c.d;
        goto L62
    L95:
        r25 = l.b;
        goto L62
    L97:
        if (r111 == 1) goto L104;
        if (r111 == 2) goto L103;
        if (r111 != 3) goto L101;
        r23 = c.d;
        goto L110
    L101:
        c r27 = c.b;
        throw new IllegalArgumentException("invalid number of X");
    L103:
        r23 = c.c;
        goto L110
    L104:
        r23 = c.b;
        goto L110
    L55:
        throw new IllegalArgumentException("Illegal pattern component: ".concat(r21));
    L80:
        r25 = e(11, r111);
        goto L62
    L81:
        r25 = new i(0, r3);
        goto L62
    L82:
        r23 = e(8, r111);
        goto L110
    L88:
        r23 = e(6, r111);
        goto L110
    L84:
        if (r111 >= 4) goto L86;
        String[] r29 = r110;
    L87:
        r23 = new i(7, r29);
        goto L110
    L86:
        r29 = r19;
        goto L87
    L67:
        if (r111 < 4) goto L70;
        r23 = new i(2, r4);
        goto L110
    L70:
        if (r111 != 3) goto L72;
        r23 = new i(2, r5);
        goto L110
    L72:
        if (r111 != 2) goto L74;
        r23 = o.a;
        goto L110
    L74:
        r23 = r.a;
        goto L110
    L107:
        if (r111 < 4) goto L109;
        r23 = new k(this.b, this.c, 1);
        goto L110
    L109:
        r23 = new k(this.b, this.c, 0);
    L112:
        if (r111 != 2) goto L115;
        r24 = q.a;
    L120:
        if (r112 != 'Y') goto L122;
        r24 = new t(r24);
        goto L122
    L115:
        if (r111 >= 4) goto L117;
        int r30 = 1;
        r111 = 4;
    L118:
        r24 = e(r30, r111);
        goto L120
    L117:
        r30 = 1;
    L9:
        if (r17 < 'a') goto L17;
        if (r17 <= 'z') goto L11;
    L17:
        char r31 = '\'';
        r14.append('\'');
        boolean r113 = false;
    L18:
        if (r15 >= r16) goto L41;
        char r32 = r13.charAt(r15);
        if (r32 != r31) goto L29;
        int r33 = r15 + 1;
        r110 = r7;
        if (r33 >= r16) goto L27;
        if (r13.charAt(r33) != '\'') goto L27;
        r14.append(r32);
        r15 = r33;
    L28:
        int r34 = 1;
    L40:
        r15 = r15 + r34;
        r7 = r110;
        r31 = '\'';
    L27:
        r113 = !r113;
        goto L28
    L29:
        r110 = r7;
        if (r113 == true) goto L39;
        if (r32 < 'A') goto L35;
        if (r32 > 'Z') goto L35;
    L38:
        r15 = r15 - 1;
    L35:
        if (r32 < 'a') goto L39;
        if (r32 <= 'z') goto L38;
    L39:
        r14.append(r32);
        r34 = 1;
    L123:
        g[] r35 = (g[]) r2.toArray(new g[0]);
        this.d = r35;
        int r36 = r35.length;
        int r114 = 0;
    L124:
        r36 = r36 - 1;
        if (r36 < 0) goto L127;
        r114 = r114 + this.d[r36].estimateLength();
        goto L124
    L127:
        this.e = r114;
    }

    public final int hashCode() {
        return this.a.hashCode() + ((this.b.hashCode() + (this.c.hashCode() * 13)) * 13);
    }

    public final String toString() {
        return "FastDatePrinter[" + this.a + "," + this.c + "," + this.b.getID() + "]";
    }

    public final boolean equals(Object r4) {
        if ((r4 instanceof j) == true) goto L5;
        return false;
    L5:
        j r5 = (j) r4;
        if (this.a.equals(r5.a) == true) goto L8;
        return false;
    L8:
        if (this.b.equals(r5.b) == true) goto L10;
        return false;
    L10:
        if (this.c.equals(r5.c) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public static void a(Appendable r1, int r2) throws IOException {
        StringBuilder r3 = (StringBuilder) r1;
        r3.append((char) ((r2 / 10) + 48));
        r3.append((char) ((r2 % 10) + 48));
    }

    public static e e(int r1, int r2) {
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L9;
        return new f(r1, r2);
    L9:
        return new p(r1);
    L11:
        return new s(r1);
    }

    public j(String r1, TimeZone r2, Locale r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public static void b(Appendable r9, int r10, int r11) throws IOException {
        if (r10 < 10000) goto L5;
        char[] r0 = new char[10];
        int r1 = 0;
    L29:
        if (r10 == 0) goto L31;
        r0[r1] = (char) ((r10 % 10) + 48);
        r10 = r10 / 10;
        r1 = r1 + 1;
    L31:
        if (r1 >= r11) goto L33;
        ((StringBuilder) r9).append('0');
        r11 = r11 - 1;
    L33:
        r1 = r1 - 1;
        if (r1 < 0) goto L42;
        ((StringBuilder) r9).append(r0[r1]);
        goto L33
    L42:
        return;
    L5:
        if (r10 >= 1000) goto L11;
        if (r10 >= 100) goto L10;
        if (r10 >= 10) goto L9;
        int r6 = 1;
    L12:
        int r12 = r11 - r6;
    L13:
        if (r12 <= 0) goto L15;
        ((StringBuilder) r9).append('0');
        r12 = r12 - 1;
        goto L13
    L15:
        if (r6 == 1) goto L27;
        if (r6 == 2) goto L24;
        if (r6 == 3) goto L21;
        if (r6 != 4) goto L41;
        ((StringBuilder) r9).append((char) ((r10 / CommandStatus.DORA_TRACE) + 48));
        r10 = r10 % CommandStatus.DORA_TRACE;
        goto L21
    L41:
        return;
    L21:
        if (r10 < 100) goto L23;
        ((StringBuilder) r9).append((char) ((r10 / 100) + 48));
        r10 = r10 % 100;
        goto L24
    L23:
        ((StringBuilder) r9).append('0');
    L24:
        if (r10 < 10) goto L26;
        ((StringBuilder) r9).append((char) ((r10 / 10) + 48));
        r10 = r10 % 10;
        goto L27
    L26:
        ((StringBuilder) r9).append('0');
    L27:
        ((StringBuilder) r9).append((char) (r10 + 48));
        return;
    L9:
        r6 = 2;
        goto L12
    L10:
        r6 = 3;
        goto L12
    L11:
        r6 = 4;
        goto L12
    }

    public static String c(TimeZone r3, boolean r4, int r5, Locale r6) {
        C0056j r0 = new C0056j(r3, r4, r5, r6);
        ConcurrentHashMap r1 = (ConcurrentHashMap) g;
        String r2 = (String) r1.get(r0);
        if (r2 != null) goto L8;
        String r7 = r3.getDisplayName(r4, r5, r6);
        String r8 = (String) r1.putIfAbsent(r0, r7);
        if (r8 != null) goto L7;
        return r7;
    L7:
        return r8;
    L8:
        return r2;
    }
}
