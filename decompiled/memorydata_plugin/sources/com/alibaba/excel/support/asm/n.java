package com.alibaba.excel.support.asm;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    q f322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f323b;
    private int[] c;
    private int[] d;
    private int[] e;
    private short f;
    private short g;
    private int h;
    private int[] i;

    n(q r1) {
        this.f322a = r1;
    }

    private int a(int r3) {
        int[] r2 = this.d;
        if (r2 == null) goto L12;
        if (r3 >= r2.length) goto L12;
        int r1 = r2[r3];
        if (r1 != 0) goto L13;
        int r4 = r3 | 16777216;
        r2[r3] = r4;
        return r4;
    L13:
        return r1;
    L12:
        return r3 | 16777216;
    }

    private int a(z r9, int r10) {
        if (r10 != 4194310) goto L5;
    L6:
        int r1 = 0;
    L8:
        if (r1 >= this.h) goto L24;
        int r2 = this.i[r1];
        int r3 = (-67108864) & r2;
        int r4 = 62914560 & r2;
        int r6 = r2 & 1048575;
        if (r4 != 16777216) goto L14;
        int r5 = this.f323b[r6];
    L12:
        r2 = r5 + r3;
    L16:
        if (r10 == r2) goto L18;
        r1 = r1 + 1;
        goto L8
    L18:
        if (r10 != 4194310) goto L22;
        String r11 = r9.c();
    L21:
        return 8388608 | r9.g(r11);
    L22:
        r11 = r9.getType(r10 & 1048575).e;
        goto L21
    L14:
        if (r4 != 20971520) goto L16;
        int[] r7 = this.c;
        r5 = r7[r7.length - r6];
    L24:
        return r10;
    L5:
        if (((-4194304) & r10) != 12582912) goto L24;
        goto L6
    }

    static int a(z r3, Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, Integer.class) == false) goto L7;
        return 4194304 | ((Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.memorydata.plugin")).intValue();
    L7:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L11;
        return a(r3, aa.a((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin")).d(), 0);
    L11:
        return r3.a("", ((q) ZeusTransformUtils.preCheckCast(r4, q.class, "com.obric.memorydata.plugin")).c) | 12582912;
    }

    static int a(z r0, String r1) {
        return r0.g(r1) | 8388608;
    }

    private static int a(z r16, String r17, int r18) {
        char r2 = r17.charAt(r18);
        int r3 = 4194306;
        if (r2 != 'F') goto L5;
        return 4194306;
    L5:
        if (r2 == 'L') goto L51;
        if (r2 != 'S') goto L9;
    L49:
        return 4194305;
    L9:
        if (r2 != 'V') goto L11;
        return 0;
    L11:
        if (r2 == 'I') goto L49;
        if (r2 != 'J') goto L15;
        return 4194308;
    L15:
        if (r2 == 'Z') goto L49;
        if (r2 == '[') goto L22;
        switch(r2) {
            case 66: goto L49;
            case 67: goto L49;
            case 68: goto L21;
            default: goto L20;
        };
    L21:
        return 4194307;
    L20:
        throw new IllegalArgumentException("Invalid descriptor: " + r17.substring(r18));
    L22:
        int r4 = r18 + 1;
    L24:
        if (r17.charAt(r4) != '[') goto L26;
        r4 = r4 + 1;
        goto L24
    L26:
        char r14 = r17.charAt(r4);
        if (r14 == 'F') goto L45;
        if (r14 == 'L') goto L43;
        if (r14 == 'S') goto L42;
        if (r14 == 'Z') goto L41;
        if (r14 == 'I') goto L40;
        if (r14 == 'J') goto L39;
        switch(r14) {
            case 66: goto L38;
            case 67: goto L37;
            case 68: goto L36;
            default: goto L35;
        };
    L36:
        r3 = 4194307;
        goto L45
    L37:
        r3 = 4194315;
        goto L45
    L38:
        r3 = 4194314;
        goto L45
    L35:
        throw new IllegalArgumentException("Invalid descriptor fragment: " + r17.substring(r4));
    L39:
        r3 = 4194308;
        goto L45
    L40:
        r3 = 4194305;
        goto L45
    L41:
        r3 = 4194313;
        goto L45
    L42:
        r3 = 4194316;
        goto L45
    L43:
        r3 = r16.g(r17.substring(r4 + 1, r17.length() - 1)) | 8388608;
    L45:
        return ((r4 - r18) << 26) | r3;
    L51:
        return r16.g(r17.substring(r18 + 1, r17.length() - 1)) | 8388608;
    }

    private void a(int r5, int r6) {
        if (this.d != null) goto L5;
        this.d = new int[10];
    L5:
        int r0 = this.d.length;
        if (r5 < r0) goto L8;
        int[] r1 = new int[Math.max(r5 + 1, r0 * 2)];
        System.arraycopy(this.d, 0, r1, 0, r0);
        this.d = r1;
    L8:
        this.d[r5] = r6;
    }

    static void a(z r7, int r8, d r9) {
        int r0 = ((-67108864) & r8) >> 26;
        if (r0 != 0) goto L14;
        int r1 = r8 & 1048575;
        int r10 = r8 & 62914560;
        if (r10 == 4194304) goto L13;
        if (r10 != 8388608) goto L8;
        d r11 = r9.a(7);
        String r12 = r7.getType(r1).e;
    L42:
        int r13 = r7.a(r12).f339a;
    L43:
        r11.b(r13);
        return;
    L8:
        if (r10 != 12582912) goto L11;
        r11 = r9.a(8);
        r13 = (int) r7.getType(r1).f;
        goto L43
    L11:
        throw new AssertionError();
    L13:
        r9.a(r1);
        return;
    L14:
        StringBuilder r5 = new StringBuilder(32);
    L15:
        int r6 = r0 - 1;
        if (r0 <= 0) goto L19;
        r5.append('[');
        r0 = r6;
        goto L15
    L19:
        if ((r8 & 62914560) != 8388608) goto L21;
        r5.append('L').append(r7.getType(r8 & 1048575).e).append(';');
    L41:
        r11 = r9.a(7);
        r12 = r5.toString();
        goto L42
    L21:
        int r14 = r8 & 1048575;
        if (r14 != 1) goto L24;
        char r15 = 'I';
    L40:
        r5.append(r15);
        goto L41
    L24:
        if (r14 != 2) goto L26;
        r15 = 'F';
        goto L40
    L26:
        if (r14 != 3) goto L28;
        r15 = 'D';
        goto L40
    L28:
        if (r14 == 4) goto L36;
        switch(r14) {
            case 9: goto L35;
            case 10: goto L34;
            case 11: goto L33;
            case 12: goto L32;
            default: goto L31;
        };
    L32:
        r15 = 'S';
        goto L40
    L33:
        r15 = 'C';
        goto L40
    L34:
        r15 = 'B';
        goto L40
    L35:
        r15 = 'Z';
        goto L40
    L31:
        throw new AssertionError();
    L36:
        r15 = 'J';
        goto L40
    }

    private void a(String r5) {
        char r0 = r5.charAt(0);
        if (r0 != '(') goto L6;
        c((aa.f(r5) >> 2) - 1);
        return;
    L6:
        if (r0 != 'J') goto L8;
    L11:
        c(2);
        return;
    L8:
        if (r0 == 'D') goto L11;
        c(1);
    }

    private static boolean a(z r11, int r12, int[] r13, int r14) {
        int r0 = r13[r14];
        if (r0 != r12) goto L6;
        return false;
    L6:
        if ((67108863 & r12) != 4194309) goto L11;
        if (r0 != 4194309) goto L9;
        return false;
    L9:
        r12 = 4194309;
    L11:
        if (r0 != 0) goto L14;
        r13[r14] = r12;
        return true;
    L14:
        int r5 = r0 & (-67108864);
        int r6 = 4194304;
        if (r5 == 0) goto L17;
    L27:
        if (r12 != 4194309) goto L30;
        return false;
    L30:
        if ((r12 & (-4194304)) == ((-4194304) & r0)) goto L32;
        int r3 = r12 & (-67108864);
        if (r3 == 0) goto L39;
    L40:
        if (r3 != 0) goto L42;
    L44:
        if (r5 != 0) goto L46;
    L48:
        int r15 = Math.min(r3, r5);
    L35:
        r6 = (r15 | 8388608) | r11.g("java/lang/Object");
    L49:
        if (r6 == r0) goto L52;
        r13[r14] = r6;
        return true;
    L52:
        return false;
    L46:
        if ((r0 & 62914560) == 8388608) goto L48;
        r5 = r5 - 67108864;
        goto L48
    L42:
        if ((r12 & 62914560) == 8388608) goto L44;
        r3 = r3 - 67108864;
        goto L44
    L39:
        if ((r12 & 62914560) != 8388608) goto L49;
    L32:
        if ((r0 & 62914560) != 8388608) goto L34;
        r6 = ((r12 & (-67108864)) | 8388608) | r11.a(r12 & 1048575, 1048575 & r0);
        goto L49
    L34:
        r15 = (r12 & (-67108864)) - 67108864;
        goto L35
    L17:
        if ((r0 & 62914560) == 8388608) goto L27;
        if (r0 != 4194309) goto L49;
        if ((r12 & (-67108864)) == 0) goto L23;
    L26:
        r6 = r12;
        goto L49
    L23:
        if ((r12 & 62914560) == 8388608) goto L26;
        r12 = 4194304;
        goto L26
    }

    private int b() {
        short r0 = this.g;
        if (r0 <= 0) goto L6;
        int[] r1 = this.e;
        short r2 = (short) (r0 - 1);
        this.g = r2;
        return r1[r2];
    L6:
        short r3 = (short) (this.f - 1);
        this.f = r3;
        return (-r3) | 20971520;
    }

    private int b(int r9, int r10) {
        int r0 = (-67108864) & r9;
        int r1 = 62914560 & r9;
        if (r1 != 16777216) goto L12;
        int r2 = r0 + this.f323b[r9 & 1048575];
        if ((r9 & 1048576) == 0) goto L10;
        if (r2 == 4194308) goto L21;
        if (r2 != 4194307) goto L10;
        return 4194304;
    L21:
        return 4194304;
    L10:
        return r2;
    L12:
        if (r1 != 20971520) goto L20;
        int r3 = r0 + this.c[r10 - (r9 & 1048575)];
        if ((r9 & 1048576) == 0) goto L19;
        if (r3 == 4194308) goto L23;
        if (r3 != 4194307) goto L19;
        return 4194304;
    L23:
        return 4194304;
    L19:
        return r3;
    L20:
        return r9;
    }

    private void b(int r5) {
        if (this.e != null) goto L5;
        this.e = new int[10];
    L5:
        int r0 = this.e.length;
        short r1 = this.g;
        if (r1 < r0) goto L8;
        int[] r2 = new int[Math.max(r1 + 1, r0 * 2)];
        System.arraycopy(this.e, 0, r2, 0, r0);
        this.e = r2;
    L8:
        int[] r3 = this.e;
        short r4 = this.g;
        short r6 = (short) (r4 + 1);
        this.g = r6;
        r3[r4] = r5;
        short r7 = (short) (this.f + r6);
        if (r7 <= this.f322a.f) goto L12;
        this.f322a.f = r7;
        return;
    }

    private void b(z r4, String r5) {
        int r0 = 0;
        if (r5.charAt(0) != '(') goto L5;
        r0 = aa.e(r5);
    L5:
        int r6 = a(r4, r5, r0);
        if (r6 == 0) goto L13;
        b(r6);
        if (r6 != 4194308) goto L10;
    L11:
        b(4194304);
        return;
    L10:
        if (r6 == 4194307) goto L11;
        return;
    }

    private void c(int r3) {
        short r0 = this.g;
        if (r0 < r3) goto L5;
        short r4 = (short) (r0 - r3);
    L6:
        this.g = r4;
        return;
    L5:
        this.f = (short) (this.f - (r3 - r0));
        r4 = 0;
        goto L6
    }

    private void d(int r5) {
        if (this.i != null) goto L5;
        this.i = new int[2];
    L5:
        int r0 = this.i.length;
        int r1 = this.h;
        if (r1 < r0) goto L8;
        int[] r2 = new int[Math.max(r1 + 1, r0 * 2)];
        System.arraycopy(this.i, 0, r2, 0, r0);
        this.i = r2;
    L8:
        int[] r3 = this.i;
        int r4 = this.h;
        this.h = r4 + 1;
        r3[r4] = r5;
    }

    final int a() {
        return this.c.length;
    }

    void a(int r17, int r18, y r19, z r20) {
        switch(r17) {
            case 0: goto L124;
            case 1: goto L121;
            case 2: goto L120;
            case 3: goto L120;
            case 4: goto L120;
            case 5: goto L120;
            case 6: goto L120;
            case 7: goto L120;
            case 8: goto L120;
            case 9: goto L118;
            case 10: goto L118;
            case 11: goto L117;
            case 12: goto L117;
            case 13: goto L117;
            case 14: goto L116;
            case 15: goto L116;
            case 16: goto L120;
            case 17: goto L120;
            case 18: goto L106;
            default: goto L4;
        };
    L4:
        switch(r17) {
            case 21: goto L120;
            case 22: goto L118;
            case 23: goto L117;
            case 24: goto L116;
            case 25: goto L105;
            default: goto L6;
        };
    L105:
        int r1 = a(r18);
    L122:
        b(r1);
        return;
    L6:
        switch(r17) {
            case 46: goto L104;
            case 47: goto L103;
            case 48: goto L102;
            case 49: goto L101;
            case 50: goto L97;
            case 51: goto L104;
            case 52: goto L104;
            case 53: goto L104;
            case 54: goto L87;
            case 55: goto L76;
            case 56: goto L87;
            case 57: goto L76;
            case 58: goto L87;
            default: goto L8;
        };
    L76:
        c(1);
        a(r18, b());
        a(r18 + 1, 4194304);
        if (r18 <= 0) goto L135;
        int r2 = r18 - 1;
        int r3 = a(r2);
        if (r3 == 4194308) goto L86;
        if (r3 == 4194307) goto L86;
        int r4 = r3 & 62914560;
        if (r4 == 16777216) goto L85;
        if (r4 == 20971520) goto L85;
        return;
    L85:
        a(r2, r3 | 1048576);
        return;
    L86:
        a(r2, 4194304);
        return;
    L135:
        return;
    L87:
        a(r18, b());
        if (r18 <= 0) goto L139;
        r2 = r18 - 1;
        r3 = a(r2);
        if (r3 == 4194308) goto L86;
        if (r3 == 4194307) goto L86;
        int r5 = r3 & 62914560;
        if (r5 == 16777216) goto L85;
        if (r5 == 20971520) goto L85;
        return;
    L139:
        return;
    L97:
        c(1);
        r1 = b();
        if (r1 == 4194309) goto L122;
        r1 = r1 - 67108864;
        goto L122
    L8:
        switch(r17) {
            case 79: goto L75;
            case 80: goto L74;
            case 81: goto L75;
            case 82: goto L74;
            case 83: goto L75;
            case 84: goto L75;
            case 85: goto L75;
            case 86: goto L75;
            case 87: goto L73;
            case 88: goto L72;
            case 89: goto L71;
            case 90: goto L68;
            case 91: goto L65;
            case 92: goto L64;
            case 93: goto L63;
            case 94: goto L62;
            case 95: goto L61;
            case 96: goto L104;
            case 97: goto L59;
            case 98: goto L102;
            case 99: goto L57;
            case 100: goto L104;
            case 101: goto L59;
            case 102: goto L102;
            case 103: goto L57;
            case 104: goto L104;
            case 105: goto L59;
            case 106: goto L102;
            case 107: goto L57;
            case 108: goto L104;
            case 109: goto L59;
            case 110: goto L102;
            case 111: goto L57;
            case 112: goto L104;
            case 113: goto L59;
            case 114: goto L102;
            case 115: goto L57;
            case 116: goto L125;
            case 117: goto L125;
            case 118: goto L125;
            case 119: goto L125;
            case 120: goto L104;
            case 121: goto L56;
            case 122: goto L104;
            case 123: goto L56;
            case 124: goto L104;
            case 125: goto L56;
            case 126: goto L104;
            case 127: goto L59;
            case 128: goto L104;
            case 129: goto L59;
            case 130: goto L104;
            case 131: goto L59;
            case 132: goto L55;
            case 133: goto L54;
            case 134: goto L53;
            case 135: goto L52;
            case 136: goto L104;
            case 137: goto L102;
            case 138: goto L101;
            case 139: goto L50;
            case 140: goto L54;
            case 141: goto L52;
            case 142: goto L104;
            case 143: goto L103;
            case 144: goto L102;
            case 145: goto L125;
            case 146: goto L125;
            case 147: goto L125;
            case 148: goto L48;
            case 149: goto L104;
            case 150: goto L104;
            case 151: goto L48;
            case 152: goto L48;
            case 153: goto L73;
            case 154: goto L73;
            case 155: goto L73;
            case 156: goto L73;
            case 157: goto L73;
            case 158: goto L73;
            case 159: goto L72;
            case 160: goto L72;
            case 161: goto L72;
            case 162: goto L72;
            case 163: goto L72;
            case 164: goto L72;
            case 165: goto L72;
            case 166: goto L72;
            case 167: goto L125;
            case 168: goto L47;
            case 169: goto L47;
            case 170: goto L73;
            case 171: goto L73;
            case 172: goto L73;
            case 173: goto L72;
            case 174: goto L73;
            case 175: goto L72;
            case 176: goto L73;
            case 177: goto L125;
            case 178: goto L44;
            case 179: goto L43;
            case 180: goto L42;
            case 181: goto L41;
            case 182: goto L34;
            case 183: goto L34;
            case 184: goto L34;
            case 185: goto L34;
            case 186: goto L33;
            case 187: goto L32;
            case 188: goto L20;
            case 189: goto L16;
            case 190: goto L50;
            case 191: goto L73;
            case 192: goto L13;
            case 193: goto L50;
            case 194: goto L73;
            case 195: goto L73;
            default: goto L9;
        };
    L9:
        switch(r17) {
            case 197: goto L12;
            case 198: goto L73;
            case 199: goto L73;
            default: goto L11;
        };
    L12:
        c(r18);
        goto L44
    L11:
        throw new IllegalArgumentException();
    L13:
        String r6 = r19.e;
        b();
        if (r6.charAt(0) == '[') goto L45;
    L115:
        r1 = r20.g(r6) | 8388608;
    L45:
        b(r20, r6);
        return;
    L16:
        String r7 = r19.e;
        b();
        if (r7.charAt(0) != '[') goto L19;
        r6 = '[' + r7;
        goto L45
    L19:
        r1 = r20.g(r7) | 75497472;
        goto L122
    L20:
        b();
        switch(r18) {
            case 4: goto L31;
            case 5: goto L30;
            case 6: goto L29;
            case 7: goto L28;
            case 8: goto L27;
            case 9: goto L26;
            case 10: goto L25;
            case 11: goto L24;
            default: goto L23;
        };
    L24:
        r1 = 71303172;
        goto L122
    L25:
        r1 = 71303169;
        goto L122
    L26:
        r1 = 71303180;
        goto L122
    L27:
        r1 = 71303178;
        goto L122
    L28:
        r1 = 71303171;
        goto L122
    L29:
        r1 = 71303170;
        goto L122
    L30:
        r1 = 71303179;
        goto L122
    L31:
        r1 = 71303177;
        goto L122
    L23:
        throw new IllegalArgumentException();
    L32:
        r1 = 12582912 | r20.a(r19.e, r18);
        goto L122
    L33:
        a(r19.e);
        goto L44
    L34:
        a(r19.e);
        if (r17 == 184) goto L44;
        int r8 = b();
        if (r17 != 183) goto L44;
        if (r19.d.charAt(0) != '<') goto L44;
        d(r8);
        goto L44
    L41:
        a(r19.e);
        b();
        return;
    L42:
        c(1);
        goto L44
    L43:
        a(r19.e);
        return;
    L44:
        r6 = r19.e;
        goto L45
    L48:
        c(4);
        goto L120
    L50:
        c(1);
        goto L120
    L52:
        c(1);
        goto L116
    L53:
        c(1);
        goto L117
    L54:
        c(1);
        goto L118
    L55:
        a(r18, 4194305);
        return;
    L56:
        c(3);
        goto L118
    L57:
        c(4);
        goto L116
    L59:
        c(4);
        goto L118
    L61:
        int r9 = b();
        int r10 = b();
        b(r9);
        b(r10);
        return;
    L62:
        r1 = b();
        int r11 = b();
        int r12 = b();
        int r13 = b();
        b(r11);
        b(r1);
        b(r13);
    L67:
        b(r12);
    L70:
        b(r11);
        goto L122
    L63:
        r1 = b();
        r11 = b();
        r12 = b();
        b(r11);
    L66:
        b(r1);
        goto L67
    L64:
        r1 = b();
        r11 = b();
        b(r11);
    L69:
        b(r1);
        goto L70
    L65:
        r1 = b();
        r11 = b();
        r12 = b();
        goto L66
    L68:
        r1 = b();
        r11 = b();
        goto L69
    L71:
        r1 = b();
        b(r1);
        goto L122
    L72:
        c(2);
        return;
    L73:
        c(1);
        return;
    L74:
        c(4);
        return;
    L75:
        c(3);
        return;
    L125:
        return;
    L47:
        throw new IllegalArgumentException("JSR/RET are not supported with computeFrames option");
    L103:
        c(2);
    L101:
        c(2);
    L102:
        c(2);
    L104:
        c(2);
        goto L120
    L106:
        int r14 = r19.f340b;
        switch(r14) {
            case 3: goto L120;
            case 4: goto L117;
            case 5: goto L118;
            case 6: goto L116;
            case 7: goto L114;
            case 8: goto L113;
            default: goto L108;
        };
    L108:
        switch(r14) {
            case 15: goto L112;
            case 16: goto L111;
            case 17: goto L44;
            default: goto L110;
        };
    L111:
        r6 = "java/lang/invoke/MethodType";
        goto L115
    L112:
        r6 = "java/lang/invoke/MethodHandle";
        goto L115
    L110:
        throw new AssertionError();
    L113:
        r6 = "java/lang/String";
        goto L115
    L114:
        r6 = "java/lang/Class";
    L116:
        b(4194307);
    L119:
        b(4194304);
        return;
    L117:
        b(4194306);
        return;
    L118:
        b(4194308);
    L120:
        b(4194305);
        return;
    L121:
        r1 = 4194309;
        goto L122
    }

    final void a(n r2) {
        this.f323b = r2.f323b;
        this.c = r2.c;
        this.f = 0;
        this.d = r2.d;
        this.e = r2.e;
        this.g = r2.g;
        this.h = r2.h;
        this.i = r2.i;
    }

    final void a(s r13) {
        int[] r0 = this.f323b;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L3:
        int r7 = 2;
        if (r2 >= r0.length) goto L14;
        int r5 = r0[r2];
        if (r5 == 4194308) goto L10;
        if (r5 == 4194307) goto L10;
        r7 = 1;
    L10:
        r2 = r2 + r7;
        r4 = r4 + 1;
        if (r5 == 4194304) goto L3;
        r3 = r3 + r4;
        r4 = 0;
        goto L3
    L14:
        int[] r6 = this.c;
        int r8 = 0;
        int r9 = 0;
    L16:
        if (r8 >= r6.length) goto L24;
        int r10 = r6[r8];
        if (r10 == 4194308) goto L22;
        if (r10 == 4194307) goto L22;
        int r11 = 1;
    L23:
        r8 = r8 + r11;
        r9 = r9 + 1;
    L22:
        r11 = 2;
        goto L23
    L24:
        int r12 = r13.a(this.f322a.c, r3, r9);
        int r14 = 0;
    L25:
        int r15 = r3 - 1;
        if (r3 <= 0) goto L34;
        int r16 = r0[r14];
        if (r16 == 4194308) goto L32;
        if (r16 == 4194307) goto L32;
        int r17 = 1;
    L33:
        r14 = r14 + r17;
        r13.e(r12, r16);
        r3 = r15;
        r12 = r12 + 1;
    L32:
        r17 = 2;
    L34:
        int r18 = r9 - 1;
        if (r9 <= 0) goto L43;
        int r19 = r6[r1];
        if (r19 == 4194308) goto L41;
        if (r19 == 4194307) goto L41;
        int r20 = 1;
    L42:
        r1 = r1 + r20;
        r13.e(r12, r19);
        r9 = r18;
        r12 = r12 + 1;
    L41:
        r20 = 2;
        goto L42
    L43:
        r13.f();
    }

    final void a(z r8, int r9, String r10, int r11) {
        int[] r0 = new int[r11];
        this.f323b = r0;
        this.c = new int[0];
        int r3 = 1;
        if ((r9 & 8) == 0) goto L5;
        r3 = 0;
    L9:
        aa[] r12 = aa.c(r10);
        int r13 = r12.length;
        int r1 = 0;
    L11:
        if (r1 >= r13) goto L20;
        int r4 = a(r8, r12[r1].d(), 0);
        int[] r5 = this.f323b;
        int r6 = r3 + 1;
        r5[r3] = r4;
        if (r4 != 4194308) goto L15;
    L18:
        r3 = r6 + 1;
        r5[r6] = 4194304;
    L19:
        r1 = r1 + 1;
        goto L11
    L15:
        if (r4 == 4194307) goto L18;
        r3 = r6;
    L20:
        if (r3 >= r11) goto L22;
        this.f323b[r3] = 4194304;
        r3 = r3 + 1;
        goto L20
    L22:
        return;
    L5:
        if ((r9 & 262144) != 0) goto L7;
        r0[0] = 8388608 | r8.g(r8.c());
        goto L9
    L7:
        r0[0] = 4194310;
        goto L9
    }

    final void a(z r8, int r9, Object[] r10, int r11, Object[] r12) {
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= r9) goto L13;
        int r5 = r2 + 1;
        this.f323b[r2] = a(r8, r10[r1]);
        if (r10[r1] != v.e) goto L8;
    L11:
        this.f323b[r5] = 4194304;
        r2 = r5 + 1;
    L12:
        r1 = r1 + 1;
        goto L4
    L8:
        if (r10[r1] == v.d) goto L11;
        r2 = r5;
    L13:
        int[] r13 = this.f323b;
        if (r2 >= r13.length) goto L16;
        r13[r2] = 4194304;
        r2 = r2 + 1;
        goto L13
    L16:
        int r14 = 0;
        int r15 = 0;
    L17:
        if (r14 >= r11) goto L24;
        if (r12[r14] != v.e) goto L21;
    L22:
        r15 = r15 + 1;
    L23:
        r14 = r14 + 1;
        goto L17
    L21:
        if (r12[r14] != v.d) goto L23;
    L24:
        this.c = new int[r15 + r11];
        int r16 = 0;
        int r17 = 0;
    L25:
        if (r16 >= r11) goto L34;
        int r3 = r17 + 1;
        this.c[r17] = a(r8, r12[r16]);
        if (r12[r16] != v.e) goto L29;
    L32:
        this.c[r3] = 4194304;
        r17 = r3 + 1;
    L33:
        r16 = r16 + 1;
        goto L25
    L29:
        if (r12[r16] == v.d) goto L32;
        r17 = r3;
        goto L33
    L34:
        this.g = 0;
        this.h = 0;
    }

    final boolean a(z r9, n r10, int r11) {
        int r0 = this.f323b.length;
        int r1 = this.c.length;
        int r3 = 0;
        boolean r4 = true;
        if (r10.f323b != null) goto L5;
        r10.f323b = new int[r0];
        boolean r2 = true;
    L6:
        int r5 = 0;
    L7:
        if (r5 >= r0) goto L21;
        int[] r6 = this.d;
        if (r6 != null) goto L11;
    L16:
        int r7 = this.f323b[r5];
    L18:
        if (this.i == null) goto L20;
        r7 = a(r9, r7);
    L20:
        r2 = r2 | a(r9, r7, r10.f323b, r5);
        r5 = r5 + 1;
        goto L7
    L11:
        if (r5 >= r6.length) goto L16;
        int r8 = r6[r5];
        if (r8 != 0) goto L15;
        r7 = this.f323b[r5];
        goto L18
    L15:
        r7 = b(r8, r1);
        goto L18
    L21:
        if (r11 <= 0) goto L31;
        int r12 = 0;
    L23:
        if (r12 >= r0) goto L26;
        r2 = r2 | a(r9, this.f323b[r12], r10.f323b, r12);
        r12 = r12 + 1;
        goto L23
    L26:
        if (r10.c != null) goto L28;
        r10.c = new int[1];
    L30:
        return a(r9, r11, r10.c, 0) | r4;
    L28:
        r4 = r2;
        goto L30
    L31:
        int r13 = this.c.length + this.f;
        if (r10.c != null) goto L34;
        r10.c = new int[this.g + r13];
    L35:
        int r14 = 0;
    L36:
        if (r14 >= r13) goto L42;
        int r15 = this.c[r14];
        if (this.i == null) goto L40;
        r15 = a(r9, r15);
    L40:
        r4 = r4 | a(r9, r15, r10.c, r14);
        r14 = r14 + 1;
    L42:
        if (r3 >= this.g) goto L47;
        int r16 = b(this.e[r3], r1);
        if (this.i == null) goto L46;
        r16 = a(r9, r16);
    L46:
        r4 = r4 | a(r9, r16, r10.c, r13 + r3);
        r3 = r3 + 1;
        goto L42
    L47:
        return r4;
    L34:
        r4 = r2;
        goto L35
    L5:
        r2 = false;
        goto L6
    }
}
