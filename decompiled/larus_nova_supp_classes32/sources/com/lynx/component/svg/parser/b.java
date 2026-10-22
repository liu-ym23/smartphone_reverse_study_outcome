package com.lynx.component.svg.parser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public static final float[] b = null;
    public static final float[] c = null;
    public int a;

    public b() {
    }

    static {
        b = new float[]{1.0f, 10.0f, 100.0f, 1000.0f, 10000.0f, 100000.0f, 1000000.0f, 1.0E7f, 1.0E8f, 1.0E9f, 1.0E10f, 1.0E11f, 1.0E12f, 1.0E13f, 1.0E14f, 1.0E15f, 1.0E16f, 1.0E17f, 1.0E18f, 1.0E19f, 1.0E20f, 1.0E21f, 1.0E22f, 1.0E23f, 1.0E24f, 1.0E25f, 1.0E26f, 1.0E27f, 1.0E28f, 1.0E29f, 1.0E30f, 1.0E31f, 1.0E32f, 1.0E33f, 1.0E34f, 1.0E35f, 1.0E36f, 1.0E37f, 1.0E38f};
        c = new float[]{1.0f, 0.1f, 0.01f, 0.001f, 1.0E-4f, 1.0E-5f, 1.0E-6f, 1.0E-7f, 1.0E-8f, 1.0E-9f, 1.0E-10f, 1.0E-11f, 1.0E-12f, 1.0E-13f, 1.0E-14f, 1.0E-15f, 1.0E-16f, 1.0E-17f, 1.0E-18f, 1.0E-19f, 1.0E-20f, 1.0E-21f, 1.0E-22f, 1.0E-23f, 1.0E-24f, 1.0E-25f, 1.0E-26f, 1.0E-27f, 1.0E-28f, 1.0E-29f, 1.0E-30f, 1.0E-31f, 1.0E-32f, 1.0E-33f, 1.0E-34f, 1.0E-35f, 1.0E-36f, 1.0E-37f, 1.0E-38f};
    }

    public final float a(String r23, int r24, int r25) {
        this.a = r24;
        if (r24 < r25) goto L5;
        return Float.NaN;
    L5:
        char r2 = r23.charAt(r24);
        if (r2 == '+') goto L10;
        if (r2 == '-') goto L9;
        boolean r3 = false;
    L12:
        int r9 = this.a;
        long r17 = 0;
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
        boolean r15 = false;
        int r16 = 0;
    L13:
        int r8 = this.a;
        if (r8 >= r25) goto L42;
        char r10 = r23.charAt(r8);
        if (r10 != '0') goto L21;
        if (r12 != 0) goto L19;
        r14 = r14 + 1;
    L41:
        this.a++;
        goto L13
    L19:
        r13 = r13 + 1;
        goto L41
    L21:
        if (r10 < '1') goto L37;
        if (r10 > '9') goto L37;
        int r18 = r12 + r13;
    L25:
        if (r13 <= 0) goto L31;
        if (r17 > 922337203685477580L) goto L28;
        r17 = r17 * 10;
        r13 = r13 - 1;
        goto L25
    L28:
        return Float.NaN;
    L31:
        if (r17 > 922337203685477580L) goto L32;
        r17 = (r17 * 10) + ((long) (r10 - '0'));
        r12 = r18 + 1;
        if (r17 >= 0) goto L41;
        return Float.NaN;
    L32:
        return Float.NaN;
    L37:
        if (r10 != '.') goto L42;
        if (r15 == true) goto L42;
        r16 = this.a - r9;
        r15 = true;
    L42:
        if (r15 == true) goto L44;
    L46:
        if (r12 != 0) goto L50;
        if (r14 != 0) goto L49;
        return Float.NaN;
    L49:
        r12 = 1;
    L50:
        if (r15 == false) goto L52;
        r13 = (r16 - r14) - r12;
    L52:
        int r6 = this.a;
        if (r6 >= r25) goto L89;
        char r7 = r23.charAt(r6);
        if (r7 != 'E') goto L57;
    L58:
        int r11 = this.a + 1;
        this.a = r11;
        if (r11 != r25) goto L61;
        return Float.NaN;
    L61:
        char r19 = r23.charAt(r11);
        if (r19 != '+') goto L64;
        boolean r20 = false;
    L70:
        this.a++;
    L71:
        boolean r21 = false;
    L72:
        if (r21 == true) goto L89;
        int r22 = this.a;
        int r26 = 0;
    L74:
        int r110 = this.a;
        if (r110 >= r25) goto L84;
        char r111 = r23.charAt(r110);
        if (r111 < '0') goto L84;
        if (r111 > '9') goto L84;
        if (r26 > 922337203685477580L) goto L81;
        r26 = (r26 * 10) + (r111 - '0');
        this.a++;
        goto L74
    L81:
        return Float.NaN;
    L84:
        if (this.a != r22) goto L86;
        return Float.NaN;
    L86:
        if (r20 == false) goto L88;
        r13 = r13 - r26;
        goto L89
    L88:
        r13 = r13 + r26;
        goto L89
    L64:
        if (r19 == '-') goto L68;
        switch(r19) {
            case 48: goto L67;
            case 49: goto L67;
            case 50: goto L67;
            case 51: goto L67;
            case 52: goto L67;
            case 53: goto L67;
            case 54: goto L67;
            case 55: goto L67;
            case 56: goto L67;
            case 57: goto L67;
            default: goto L66;
        };
    L66:
        this.a--;
        r20 = false;
        r21 = true;
        goto L72
    L67:
        r20 = false;
        goto L71
    L68:
        r20 = true;
        goto L70
    L57:
        if (r7 == 'e') goto L58;
    L89:
        int r112 = r12 + r13;
        if (r112 <= 39) goto L92;
    L107:
        return Float.NaN;
    L92:
        if (r112 < (-44)) goto L107;
        long r113 = r17;
        float r1 = r113;
        if (r113 == 0) goto L104;
        if (r13 <= 0) goto L99;
        float r4 = b[r13];
    L98:
        r1 = r1 * r4;
        goto L104
    L99:
        if (r13 >= 0) goto L104;
        if (r13 >= (-38)) goto L103;
        r1 = (float) (((double) r1) * 1.0E-20d);
        r13 = r13 + 20;
    L103:
        r4 = c[-r13];
    L104:
        if (r3 == true) goto L106;
        return r1;
    L106:
        return -r1;
    L44:
        if (this.a != (r16 + 1)) goto L46;
        return Float.NaN;
    L9:
        r3 = true;
    L11:
        this.a++;
        goto L12
    L10:
        r3 = false;
        goto L11
    }
}
