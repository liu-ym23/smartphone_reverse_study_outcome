package lr;

import android.util.Log;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f19706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f19707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19708c;
    public int[] d;
    public float[] e;
    public int f;
    public int[] g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String[] f19709h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f19710i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f19711j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean[] f19712k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f19713l;

    public final void a(float r5, int r10) {
        int r11 = this.f;
        int[] r12 = this.d;
        if (r11 < r12.length) goto L5;
        this.d = Arrays.copyOf(r12, r12.length * 2);
        float[] r13 = this.e;
        this.e = Arrays.copyOf(r13, r13.length * 2);
    L5:
        int[] r14 = this.d;
        int r15 = this.f;
        r14[r15] = r10;
        float[] r16 = this.e;
        this.f = r15 + 1;
        r16[r15] = r5;
    }

    public final void b(int r5, int r10) {
        int r11 = this.f19708c;
        int[] r12 = this.f19706a;
        if (r11 < r12.length) goto L5;
        this.f19706a = Arrays.copyOf(r12, r12.length * 2);
        int[] r13 = this.f19707b;
        this.f19707b = Arrays.copyOf(r13, r13.length * 2);
    L5:
        int[] r14 = this.f19706a;
        int r15 = this.f19708c;
        r14[r15] = r5;
        int[] r16 = this.f19707b;
        this.f19708c = r15 + 1;
        r16[r15] = r10;
    }

    public final void c(int r5, String r10) {
        int r11 = this.f19710i;
        int[] r12 = this.g;
        if (r11 < r12.length) goto L5;
        this.g = Arrays.copyOf(r12, r12.length * 2);
        String[] r13 = this.f19709h;
        this.f19709h = (String[]) Arrays.copyOf(r13, r13.length * 2);
    L5:
        int[] r14 = this.g;
        int r15 = this.f19710i;
        r14[r15] = r5;
        String[] r16 = this.f19709h;
        this.f19710i = r15 + 1;
        r16[r15] = r10;
    }

    public final void d(int r5, boolean r10) {
        int r11 = this.f19713l;
        int[] r12 = this.f19711j;
        if (r11 < r12.length) goto L5;
        this.f19711j = Arrays.copyOf(r12, r12.length * 2);
        boolean[] r13 = this.f19712k;
        this.f19712k = Arrays.copyOf(r13, r13.length * 2);
    L5:
        int[] r14 = this.f19711j;
        int r15 = this.f19713l;
        r14[r15] = r5;
        boolean[] r16 = this.f19712k;
        this.f19713l = r15 + 1;
        r16[r15] = r10;
    }

    public final void e(com.obric.oui.constraintlayout.widget.c r10) {
        int r5 = 0;
        int r11 = 0;
    L4:
        if (r11 >= this.f19708c) goto L101;
        int r12 = this.f19706a[r11];
        int r13 = this.f19707b[r11];
        if (r12 != 6) goto L8;
        r10.e.D = r13;
    L100:
        r11 = r11 + 1;
        goto L4
    L8:
        if (r12 != 7) goto L10;
        r10.e.E = r13;
        goto L100
    L10:
        if (r12 != 8) goto L12;
        r10.e.K = r13;
        goto L100
    L12:
        if (r12 != 27) goto L14;
        r10.e.F = r13;
        goto L100
    L14:
        if (r12 != 28) goto L16;
        r10.e.H = r13;
        goto L100
    L16:
        if (r12 != 41) goto L18;
        r10.e.W = r13;
        goto L100
    L18:
        if (r12 != 42) goto L20;
        r10.e.X = r13;
        goto L100
    L20:
        if (r12 != 61) goto L22;
        r10.e.A = r13;
        goto L100
    L22:
        if (r12 != 62) goto L24;
        r10.e.B = r13;
        goto L100
    L24:
        if (r12 != 72) goto L26;
        r10.e.g0 = r13;
        goto L100
    L26:
        if (r12 != 73) goto L28;
        r10.e.f19725h0 = r13;
        goto L100
    L28:
        if (r12 != 2) goto L30;
        r10.e.J = r13;
        goto L100
    L30:
        if (r12 != 31) goto L32;
        r10.e.L = r13;
        goto L100
    L32:
        if (r12 != 34) goto L34;
        r10.e.I = r13;
        goto L100
    L34:
        if (r12 != 38) goto L36;
        r10.f13062a = r13;
        goto L100
    L36:
        if (r12 != 64) goto L38;
        r10.d.f19751b = r13;
        goto L100
    L38:
        if (r12 != 66) goto L40;
        r10.d.f = r13;
        goto L100
    L40:
        if (r12 != 76) goto L42;
        r10.d.e = r13;
        goto L100
    L42:
        if (r12 != 78) goto L44;
        r10.f13064c.f19761c = r13;
        goto L100
    L44:
        if (r12 != 97) goto L46;
        r10.e.f19739p0 = r13;
        goto L100
    L46:
        if (r12 != 93) goto L48;
        r10.e.M = r13;
        goto L100
    L48:
        if (r12 == 94) goto L78;
        switch(r12) {
            case 11: goto L77;
            case 12: goto L76;
            case 13: goto L75;
            case 14: goto L74;
            case 15: goto L73;
            case 16: goto L72;
            case 17: goto L71;
            case 18: goto L70;
            default: goto L50;
        };
    L50:
        switch(r12) {
            case 21: goto L69;
            case 22: goto L68;
            case 23: goto L67;
            case 24: goto L66;
            default: goto L51;
        };
    L51:
        switch(r12) {
            case 54: goto L65;
            case 55: goto L64;
            case 56: goto L63;
            case 57: goto L62;
            case 58: goto L61;
            case 59: goto L60;
            default: goto L52;
        };
    L52:
        switch(r12) {
            case 82: goto L59;
            case 83: goto L58;
            case 84: goto L57;
            default: goto L53;
        };
    L53:
        switch(r12) {
            case 87: goto L100;
            case 88: goto L56;
            case 89: goto L55;
            default: goto L54;
        };
    L54:
        Log.w("ConstraintSet", "Unknown attribute 0x");
        goto L100
    L55:
        r10.d.f19758m = r13;
        goto L100
    L56:
        r10.d.f19757l = r13;
        goto L100
    L57:
        r10.d.f19755j = r13;
        goto L100
    L58:
        r10.f.f19767i = r13;
        goto L100
    L59:
        r10.d.f19752c = r13;
        goto L100
    L60:
        r10.e.f19721d0 = r13;
        goto L100
    L61:
        r10.e.f19720c0 = r13;
        goto L100
    L62:
        r10.e.f19718b0 = r13;
        goto L100
    L63:
        r10.e.f19716a0 = r13;
        goto L100
    L64:
        r10.e.Z = r13;
        goto L100
    L65:
        r10.e.Y = r13;
        goto L100
    L66:
        r10.e.G = r13;
        goto L100
    L67:
        r10.e.f19719c = r13;
        goto L100
    L68:
        r10.f13064c.f19760b = r13;
        goto L100
    L69:
        r10.e.d = r13;
        goto L100
    L70:
        r10.e.f = r13;
        goto L100
    L71:
        r10.e.e = r13;
        goto L100
    L72:
        r10.e.O = r13;
        goto L100
    L73:
        r10.e.S = r13;
        goto L100
    L74:
        r10.e.P = r13;
        goto L100
    L75:
        r10.e.N = r13;
        goto L100
    L76:
        r10.e.R = r13;
        goto L100
    L77:
        r10.e.Q = r13;
        goto L100
    L78:
        r10.e.T = r13;
        goto L100
    L101:
        int r14 = 0;
    L103:
        if (r14 >= this.f) goto L151;
        int r15 = this.d[r14];
        float r16 = this.e[r14];
        if (r15 != 19) goto L107;
        r10.e.g = r16;
    L150:
        r14 = r14 + 1;
        goto L103
    L107:
        if (r15 != 20) goto L109;
        r10.e.f19746x = r16;
        goto L150
    L109:
        if (r15 != 37) goto L111;
        r10.e.f19747y = r16;
        goto L150
    L111:
        if (r15 != 60) goto L113;
        r10.f.f19764b = r16;
        goto L150
    L113:
        if (r15 != 63) goto L115;
        r10.e.C = r16;
        goto L150
    L115:
        if (r15 != 79) goto L117;
        r10.d.g = r16;
        goto L150
    L117:
        if (r15 == 85) goto L143;
        if (r15 == 87) goto L150;
        if (r15 != 39) goto L122;
        r10.e.V = r16;
        goto L150
    L122:
        if (r15 == 40) goto L141;
        switch(r15) {
            case 43: goto L140;
            case 44: goto L139;
            case 45: goto L138;
            case 46: goto L137;
            case 47: goto L136;
            case 48: goto L135;
            case 49: goto L134;
            case 50: goto L133;
            case 51: goto L132;
            case 52: goto L131;
            case 53: goto L130;
            default: goto L124;
        };
    L124:
        switch(r15) {
            case 67: goto L129;
            case 68: goto L128;
            case 69: goto L127;
            case 70: goto L126;
            default: goto L125;
        };
    L125:
        Log.w("ConstraintSet", "Unknown attribute 0x");
        goto L150
    L126:
        r10.e.f19723f0 = r16;
        goto L150
    L127:
        r10.e.f19722e0 = r16;
        goto L150
    L128:
        r10.f13064c.e = r16;
        goto L150
    L129:
        r10.d.f19753h = r16;
        goto L150
    L130:
        r10.f.f19770l = r16;
        goto L150
    L131:
        r10.f.f19769k = r16;
        goto L150
    L132:
        r10.f.f19768j = r16;
        goto L150
    L133:
        r10.f.f19766h = r16;
        goto L150
    L134:
        r10.f.g = r16;
        goto L150
    L135:
        r10.f.f = r16;
        goto L150
    L136:
        r10.f.e = r16;
        goto L150
    L137:
        r10.f.d = r16;
        goto L150
    L138:
        r10.f.f19765c = r16;
        goto L150
    L139:
        j r17 = r10.f;
        r17.f19772n = r16;
        r17.f19771m = true;
        goto L150
    L140:
        r10.f13064c.d = r16;
        goto L150
    L141:
        r10.e.U = r16;
        goto L150
    L143:
        r10.d.f19754i = r16;
        goto L150
    L151:
        int r18 = 0;
    L153:
        if (r18 >= this.f19710i) goto L173;
        int r19 = this.g[r18];
        String r20 = this.f19709h[r18];
        if (r19 != 5) goto L157;
        r10.e.f19748z = r20;
    L171:
        r18 = r18 + 1;
        goto L153
    L157:
        if (r19 != 65) goto L159;
        r10.d.d = r20;
        goto L171
    L159:
        if (r19 != 74) goto L161;
        g r21 = r10.e;
        r21.f19730k0 = r20;
        r21.f19728j0 = null;
        goto L171
    L161:
        if (r19 == 77) goto L167;
        if (r19 == 87) goto L171;
        if (r19 == 90) goto L166;
        Log.w("ConstraintSet", "Unknown attribute 0x");
        goto L171
    L166:
        r10.d.f19756k = r20;
        goto L171
    L167:
        r10.e.l0 = r20;
    L173:
        if (r5 >= this.f19713l) goto L189;
        int r22 = this.f19711j[r5];
        boolean r23 = this.f19712k[r5];
        if (r22 != 44) goto L177;
        r10.f.f19771m = r23;
    L188:
        r5 = r5 + 1;
        goto L173
    L177:
        if (r22 == 75) goto L186;
        if (r22 == 87) goto L188;
        if (r22 != 80) goto L182;
        r10.e.f19733m0 = r23;
        goto L188
    L182:
        if (r22 == 81) goto L184;
        Log.w("ConstraintSet", "Unknown attribute 0x");
        goto L188
    L184:
        r10.e.f19735n0 = r23;
        goto L188
    L186:
        r10.e.f19737o0 = r23;
        goto L188
    }
}
