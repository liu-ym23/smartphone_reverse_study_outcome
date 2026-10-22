package com.ctc.wstx.io;

/* JADX INFO: loaded from: classes2.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f3545a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f3546b = null;
    protected boolean H;
    protected char[] I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    protected int f3547J;
    protected int K;
    protected long L;
    protected int M;
    protected int N;

    static {
        byte[] r1 = new byte[256];
        f3545a = r1;
        r1[95] = 1;
        int r2 = 0;
        int r4 = 0;
    L4:
        if (r4 > 25) goto L6;
        byte[] r5 = f3545a;
        r5[r4 + 65] = 1;
        r5[r4 + 97] = 1;
        r4 = r4 + 1;
        goto L4
    L6:
        int r6 = 192;
    L7:
        if (r6 >= 256) goto L9;
        f3545a[r6] = 1;
        r6 = r6 + 1;
        goto L7
    L9:
        byte[] r0 = f3545a;
        r0[215(0xd7, float:3.01E-43)] = 0;
        r0[247(0xf7, float:3.46E-43)] = 0;
        r0[45] = -1;
        r0[46] = -1;
        r0[183(0xb7, float:2.56E-43)] = -1;
        int r3 = 48;
        int r8 = 48;
    L11:
        if (r8 > 57) goto L13;
        f3545a[r8] = -1;
        r8 = r8 + 1;
        goto L11
    L13:
        f3546b = new byte[128];
    L14:
        if (r2 > 25) goto L16;
        byte[] r7 = f3546b;
        r7[r2 + 65] = 1;
        r7[r2 + 97] = 1;
        r2 = r2 + 1;
    L16:
        if (r3 > 57) goto L18;
        f3546b[r3] = 1;
        r3 = r3 + 1;
        goto L16
    L18:
        byte[] r9 = f3546b;
        r9[10] = 1;
        r9[13] = 1;
        r9[32] = 1;
        r9[45] = 1;
        r9[39] = 1;
        r9[40] = 1;
        r9[41] = 1;
        r9[43] = 1;
        r9[44] = 1;
        r9[46] = 1;
        r9[47] = 1;
        r9[58] = 1;
        r9[61] = 1;
        r9[63] = 1;
        r9[59] = 1;
        r9[33] = 1;
        r9[42] = 1;
        r9[35] = 1;
        r9[64] = 1;
        r9[36] = 1;
        r9[95] = 1;
        r9[37] = 1;
    }

    public u() {
        this.H = false;
        this.f3547J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 1;
        this.N = 0;
    }

    public static final int a(String r11, boolean r12, boolean r13) {
        int r0 = r11.length();
        int r2 = 1;
        if (r0 >= 1) goto L5;
        return -1;
    L5:
        char r4 = r11.charAt(0);
        if (r4 > 'z') goto L15;
        if (r4 >= 'a') goto L22;
        if (r4 >= 'A') goto L12;
        if (r4 != ':') goto L11;
        if (r12 == false) goto L22;
    L11:
        return 0;
    L12:
        if (r4 <= 'Z') goto L22;
        if (r4 == '_') goto L22;
        return 0;
    L22:
        if (r2 >= r0) goto L52;
        char r3 = r11.charAt(r2);
        if (r3 > 'z') goto L44;
        if (r3 >= 'a') goto L50;
        if (r3 > 'Z') goto L42;
        if (r3 >= 'A') goto L50;
        if (r3 < '0') goto L35;
        if (r3 <= '9') goto L50;
    L35:
        if (r3 == '.') goto L50;
        if (r3 == '-') goto L50;
        if (r3 != ':') goto L51;
        if (r12 == false) goto L50;
    L51:
        return r2;
    L42:
        if (r3 != '_') goto L51;
    L50:
        r2 = r2 + 1;
        goto L22
    L44:
        if (r13 == false) goto L49;
        if (com.ctc.wstx.util.p.d(r3) == false) goto L51;
    L49:
        if (com.ctc.wstx.util.p.b(r3) == false) goto L51;
    L52:
        return -1;
    L15:
        if (r13 == false) goto L20;
        if (com.ctc.wstx.util.p.c(r4) == true) goto L22;
        return 0;
    L20:
        if (com.ctc.wstx.util.p.a(r4) == true) goto L22;
        return 0;
    }

    public static final boolean a(char r2, boolean r3, boolean r4) {
        if (r2 <= 'z') goto L5;
        if (r4 == false) goto L24;
        return com.ctc.wstx.util.p.c(r2);
    L24:
        return com.ctc.wstx.util.p.a(r2);
    L5:
        if (r2 < 'a') goto L8;
        return true;
    L8:
        if (r2 >= 'A') goto L15;
        if (r2 != ':') goto L13;
        if (r3 == true) goto L13;
        return true;
    L13:
        return false;
    L15:
        if (r2 > 'Z') goto L17;
        return true;
    L17:
        if (r2 != '_') goto L20;
        return true;
    L20:
        return false;
    }

    public static final int b(String r4, boolean r5, boolean r6) {
        int r0 = r4.length();
        int r1 = 1;
    L3:
        if (r1 >= r0) goto L38;
        char r2 = r4.charAt(r1);
        if (r2 <= 'z') goto L7;
        if (r6 == false) goto L35;
        if (com.ctc.wstx.util.p.d(r2) == true) goto L36;
    L37:
        return r1;
    L36:
        r1 = r1 + 1;
        goto L3
    L35:
        if (com.ctc.wstx.util.p.b(r2) == false) goto L37;
    L7:
        if (r2 >= 'a') goto L36;
        if (r2 > 'Z') goto L28;
        if (r2 >= 'A') goto L36;
        if (r2 < '0') goto L19;
        if (r2 <= '9') goto L36;
    L19:
        if (r2 == '.') goto L36;
        if (r2 == '-') goto L36;
        if (r2 != ':') goto L37;
        if (r5 == true) goto L37;
    L28:
        if (r2 != '_') goto L37;
    L38:
        return -1;
    }

    public static final boolean b(char r2, boolean r3, boolean r4) {
        if (r2 <= 'z') goto L5;
        if (r4 == false) goto L34;
        return com.ctc.wstx.util.p.d(r2);
    L34:
        return com.ctc.wstx.util.p.b(r2);
    L5:
        if (r2 < 'a') goto L8;
        return true;
    L8:
        if (r2 > 'Z') goto L27;
        if (r2 < 'A') goto L13;
        return true;
    L13:
        if (r2 < '0') goto L17;
        if (r2 > '9') goto L17;
        return true;
    L17:
        if (r2 != '.') goto L19;
        return true;
    L19:
        if (r2 != '-') goto L21;
        return true;
    L21:
        if (r2 != ':') goto L25;
        if (r3 == true) goto L25;
        return true;
    L25:
        return false;
    L27:
        if (r2 != '_') goto L30;
        return true;
    L30:
        return false;
    }

    public static final boolean c(char r1) {
        if (r1 > ' ') goto L5;
        return true;
    L5:
        return false;
    }

    public static String d(char r4) {
        if (Character.isISOControl(r4) == false) goto L8;
        StringBuilder r0 = new StringBuilder();
        String r2 = "(CTRL-CHAR, code ";
    L5:
        StringBuilder r5 = r0.append(r2).append(r4);
    L7:
        return r5.append(")").toString();
    L8:
        r2 = "' (code ";
        if (r4 <= 255) goto L11;
        r5 = new StringBuilder().append("'").append(r4).append("' (code ").append(r4).append(" / 0x").append(Integer.toHexString(r4));
        goto L7
    L11:
        r0 = new StringBuilder().append("'").append(r4);
        goto L5
    }

    public void a(u r3) {
        this.I = r3.I;
        this.f3547J = r3.f3547J;
        this.K = r3.K;
        this.L = r3.L;
        this.M = r3.M;
        this.N = r3.N;
    }

    public final boolean a(char r3) {
        if (r3 > 'z') goto L18;
        if (r3 < 'a') goto L8;
        return true;
    L8:
        if (r3 >= 'A') goto L11;
        return false;
    L11:
        if (r3 > 'Z') goto L13;
        return true;
    L13:
        if (r3 != '_') goto L16;
        return true;
    L16:
        return false;
    L18:
        if (this.H == false) goto L21;
        return com.ctc.wstx.util.p.c(r3);
    L21:
        return com.ctc.wstx.util.p.a(r3);
    }

    public final boolean b(char r3) {
        if (r3 > 'z') goto L29;
        if (r3 < 'a') goto L8;
        return true;
    L8:
        if (r3 > 'Z') goto L24;
        if (r3 < 'A') goto L13;
        return true;
    L13:
        if (r3 < '0') goto L17;
        if (r3 > '9') goto L17;
        return true;
    L17:
        if (r3 != '.') goto L19;
        return true;
    L19:
        if (r3 != '-') goto L22;
        return true;
    L22:
        return false;
    L24:
        if (r3 != '_') goto L27;
        return true;
    L27:
        return false;
    L29:
        if (this.H == false) goto L32;
        return com.ctc.wstx.util.p.d(r3);
    L32:
        return com.ctc.wstx.util.p.b(r3);
    }
}
