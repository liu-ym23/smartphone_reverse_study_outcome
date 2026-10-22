package com.lynx.component.svg.parser;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float[] f9766b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float[] f9767c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9768a;

    static {
        f9766b = new float[]{1.0f, 10.0f, 100.0f, 1000.0f, 10000.0f, 100000.0f, 1000000.0f, 1.0E7f, 1.0E8f, 1.0E9f, 1.0E10f, 1.0E11f, 1.0E12f, 1.0E13f, 1.0E14f, 1.0E15f, 1.0E16f, 1.0E17f, 1.0E18f, 1.0E19f, 1.0E20f, 1.0E21f, 1.0E22f, 1.0E23f, 1.0E24f, 1.0E25f, 1.0E26f, 1.0E27f, 1.0E28f, 1.0E29f, 1.0E30f, 1.0E31f, 1.0E32f, 1.0E33f, 1.0E34f, 1.0E35f, 1.0E36f, 1.0E37f, 1.0E38f};
        f9767c = new float[]{1.0f, 0.1f, 0.01f, 0.001f, 1.0E-4f, 1.0E-5f, 1.0E-6f, 1.0E-7f, 1.0E-8f, 1.0E-9f, 1.0E-10f, 1.0E-11f, 1.0E-12f, 1.0E-13f, 1.0E-14f, 1.0E-15f, 1.0E-16f, 1.0E-17f, 1.0E-18f, 1.0E-19f, 1.0E-20f, 1.0E-21f, 1.0E-22f, 1.0E-23f, 1.0E-24f, 1.0E-25f, 1.0E-26f, 1.0E-27f, 1.0E-28f, 1.0E-29f, 1.0E-30f, 1.0E-31f, 1.0E-32f, 1.0E-33f, 1.0E-34f, 1.0E-35f, 1.0E-36f, 1.0E-37f, 1.0E-38f};
    }

    public final float a(int r23, int r24, String r25) {
        this.f9768a = r23;
        if (r23 < r24) goto L5;
        return Float.NaN;
    L5:
        char r5 = r25.charAt(r23);
        if (r5 == '+') goto L10;
        if (r5 == '-') goto L9;
        boolean r10 = false;
    L12:
        int r11 = this.f9768a;
        long r17 = 0;
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
        boolean r15 = false;
        int r16 = 0;
    L13:
        int r18 = this.f9768a;
        if (r18 >= r24) goto L42;
        char r19 = r25.charAt(r18);
        if (r19 != '0') goto L21;
        if (r12 != 0) goto L19;
        r14 = r14 + 1;
    L41:
        this.f9768a++;
        goto L13
    L19:
        r13 = r13 + 1;
        goto L41
    L21:
        if (r19 < '1') goto L37;
        if (r19 > '9') goto L37;
        int r110 = r12 + r13;
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
        r17 = (r17 * 10) + ((long) (r19 - '0'));
        r12 = r110 + 1;
        if (r17 >= 0) goto L41;
        return Float.NaN;
    L32:
        return Float.NaN;
    L37:
        if (r19 != '.') goto L42;
        if (r15 == true) goto L42;
        r16 = this.f9768a - r11;
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
        int r20 = this.f9768a;
        if (r20 >= r24) goto L89;
        char r21 = r25.charAt(r20);
        if (r21 != 'E') goto L57;
    L58:
        int r22 = this.f9768a + 1;
        this.f9768a = r22;
        if (r22 != r24) goto L61;
        return Float.NaN;
    L61:
        char r26 = r25.charAt(r22);
        if (r26 != '+') goto L64;
        boolean r27 = false;
    L71:
        this.f9768a++;
    L68:
        boolean r28 = false;
    L72:
        if (r28 == true) goto L89;
        int r29 = this.f9768a;
        int r30 = 0;
    L74:
        int r111 = this.f9768a;
        if (r111 >= r24) goto L84;
        char r112 = r25.charAt(r111);
        if (r112 < '0') goto L84;
        if (r112 > '9') goto L84;
        if (r30 > 922337203685477580L) goto L81;
        r30 = (r30 * 10) + (r112 - '0');
        this.f9768a++;
        goto L74
    L81:
        return Float.NaN;
    L84:
        if (this.f9768a != r29) goto L86;
        return Float.NaN;
    L86:
        if (r27 == false) goto L88;
        r13 = r13 - r30;
        goto L89
    L88:
        r13 = r13 + r30;
        goto L89
    L64:
        if (r26 == '-') goto L69;
        switch(r26) {
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
        this.f9768a--;
        r28 = true;
        r27 = false;
        goto L72
    L67:
        r27 = false;
        goto L68
    L69:
        r27 = true;
        goto L71
    L57:
        if (r21 == 'e') goto L58;
    L89:
        int r113 = r12 + r13;
        if (r113 <= 39) goto L92;
    L107:
        return Float.NaN;
    L92:
        if (r113 < (-44)) goto L107;
        long r114 = r17;
        float r31 = r114;
        if (r114 == 0) goto L104;
        if (r13 <= 0) goto L99;
        float r32 = f9766b[r13];
    L98:
        r31 = r31 * r32;
        goto L104
    L99:
        if (r13 >= 0) goto L104;
        if (r13 >= (-38)) goto L103;
        r31 = (float) (((double) r31) * 1.0E-20d);
        r13 = r13 + 20;
    L103:
        r32 = f9767c[-r13];
    L104:
        if (r10 == true) goto L106;
        return r31;
    L106:
        return -r31;
    L44:
        if (this.f9768a != (r16 + 1)) goto L46;
        return Float.NaN;
    L9:
        r10 = true;
    L11:
        this.f9768a++;
        goto L12
    L10:
        r10 = false;
        goto L11
    }
}
