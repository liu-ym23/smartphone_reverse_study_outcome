package lr;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import com.obric.oui.constraintlayout.widget.R$styleable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final SparseIntArray f19714q0 = null;
    public int A;
    public int B;
    public float C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public float U;
    public float V;
    public int W;
    public int X;
    public int Y;
    public int Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f19715a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f19716a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f19717b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f19718b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19719c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f19720c0;
    public int d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f19721d0;
    public int e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public float f19722e0;
    public int f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public float f19723f0;
    public float g;
    public int g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f19724h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public int f19725h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f19726i;
    public int i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f19727j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int[] f19728j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f19729k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public String f19730k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f19731l;
    public String l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f19732m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public boolean f19733m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f19734n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public boolean f19735n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f19736o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public boolean f19737o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f19738p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f19739p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f19740q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f19741r;
    public int s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f19742t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f19743u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f19744v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f19745w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f19746x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f19747y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f19748z;

    static {
        SparseIntArray r5 = new SparseIntArray();
        f19714q0 = r5;
        r5.append(R$styleable.Layout_layout_constraintLeft_toLeftOf, 24);
        r5.append(R$styleable.Layout_layout_constraintLeft_toRightOf, 25);
        r5.append(R$styleable.Layout_layout_constraintRight_toLeftOf, 28);
        r5.append(R$styleable.Layout_layout_constraintRight_toRightOf, 29);
        r5.append(R$styleable.Layout_layout_constraintTop_toTopOf, 35);
        r5.append(R$styleable.Layout_layout_constraintTop_toBottomOf, 34);
        r5.append(R$styleable.Layout_layout_constraintBottom_toTopOf, 4);
        r5.append(R$styleable.Layout_layout_constraintBottom_toBottomOf, 3);
        r5.append(R$styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
        r5.append(R$styleable.Layout_layout_editor_absoluteX, 6);
        r5.append(R$styleable.Layout_layout_editor_absoluteY, 7);
        r5.append(R$styleable.Layout_layout_constraintGuide_begin, 17);
        r5.append(R$styleable.Layout_layout_constraintGuide_end, 18);
        r5.append(R$styleable.Layout_layout_constraintGuide_percent, 19);
        r5.append(R$styleable.Layout_guidelineUseRtl, 90);
        r5.append(R$styleable.Layout_android_orientation, 26);
        r5.append(R$styleable.Layout_layout_constraintStart_toEndOf, 31);
        r5.append(R$styleable.Layout_layout_constraintStart_toStartOf, 32);
        r5.append(R$styleable.Layout_layout_constraintEnd_toStartOf, 10);
        r5.append(R$styleable.Layout_layout_constraintEnd_toEndOf, 9);
        r5.append(R$styleable.Layout_layout_goneMarginLeft, 13);
        r5.append(R$styleable.Layout_layout_goneMarginTop, 16);
        r5.append(R$styleable.Layout_layout_goneMarginRight, 14);
        r5.append(R$styleable.Layout_layout_goneMarginBottom, 11);
        r5.append(R$styleable.Layout_layout_goneMarginStart, 15);
        r5.append(R$styleable.Layout_layout_goneMarginEnd, 12);
        r5.append(R$styleable.Layout_layout_constraintVertical_weight, 38);
        r5.append(R$styleable.Layout_layout_constraintHorizontal_weight, 37);
        r5.append(R$styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
        r5.append(R$styleable.Layout_layout_constraintVertical_chainStyle, 40);
        r5.append(R$styleable.Layout_layout_constraintHorizontal_bias, 20);
        r5.append(R$styleable.Layout_layout_constraintVertical_bias, 36);
        r5.append(R$styleable.Layout_layout_constraintDimensionRatio, 5);
        r5.append(R$styleable.Layout_layout_constraintLeft_creator, 91);
        r5.append(R$styleable.Layout_layout_constraintTop_creator, 91);
        r5.append(R$styleable.Layout_layout_constraintRight_creator, 91);
        r5.append(R$styleable.Layout_layout_constraintBottom_creator, 91);
        r5.append(R$styleable.Layout_layout_constraintBaseline_creator, 91);
        r5.append(R$styleable.Layout_android_layout_marginLeft, 23);
        r5.append(R$styleable.Layout_android_layout_marginRight, 27);
        r5.append(R$styleable.Layout_android_layout_marginStart, 30);
        r5.append(R$styleable.Layout_android_layout_marginEnd, 8);
        r5.append(R$styleable.Layout_android_layout_marginTop, 33);
        r5.append(R$styleable.Layout_android_layout_marginBottom, 2);
        r5.append(R$styleable.Layout_android_layout_width, 22);
        r5.append(R$styleable.Layout_android_layout_height, 21);
        r5.append(R$styleable.Layout_layout_constraintWidth, 41);
        r5.append(R$styleable.Layout_layout_constraintHeight, 42);
        r5.append(R$styleable.Layout_layout_constrainedWidth, 87);
        r5.append(R$styleable.Layout_layout_constrainedHeight, 88);
        r5.append(R$styleable.Layout_layout_wrapBehaviorInParent, 76);
        r5.append(R$styleable.Layout_layout_constraintCircle, 61);
        r5.append(R$styleable.Layout_layout_constraintCircleRadius, 62);
        r5.append(R$styleable.Layout_layout_constraintCircleAngle, 63);
        r5.append(R$styleable.Layout_layout_constraintWidth_percent, 69);
        r5.append(R$styleable.Layout_layout_constraintHeight_percent, 70);
        r5.append(R$styleable.Layout_chainUseRtl, 71);
        r5.append(R$styleable.Layout_barrierDirection, 72);
        r5.append(R$styleable.Layout_barrierMargin, 73);
        r5.append(R$styleable.Layout_constraint_referenced_ids, 74);
        r5.append(R$styleable.Layout_barrierAllowsGoneWidgets, 75);
        r5.append(R$styleable.Layout_layout_constraintWidth_max, 84);
        r5.append(R$styleable.Layout_layout_constraintWidth_min, 86);
        r5.append(R$styleable.Layout_layout_constraintWidth_max, 83);
        r5.append(R$styleable.Layout_layout_constraintHeight_min, 85);
        r5.append(R$styleable.Layout_layout_constraintWidth, 87);
        r5.append(R$styleable.Layout_layout_constraintHeight, 88);
        r5.append(R$styleable.ConstraintLayout_Layout_layout_constraintTag, 89);
        r5.append(R$styleable.Layout_guidelineUseRtl, 90);
    }

    public final void a(g r5) {
        this.f19715a = r5.f19715a;
        this.f19719c = r5.f19719c;
        this.f19717b = r5.f19717b;
        this.d = r5.d;
        this.e = r5.e;
        this.f = r5.f;
        this.g = r5.g;
        this.f19724h = r5.f19724h;
        this.f19726i = r5.f19726i;
        this.f19727j = r5.f19727j;
        this.f19729k = r5.f19729k;
        this.f19731l = r5.f19731l;
        this.f19732m = r5.f19732m;
        this.f19734n = r5.f19734n;
        this.f19736o = r5.f19736o;
        this.f19738p = r5.f19738p;
        this.f19740q = r5.f19740q;
        this.f19741r = r5.f19741r;
        this.s = r5.s;
        this.f19742t = r5.f19742t;
        this.f19743u = r5.f19743u;
        this.f19744v = r5.f19744v;
        this.f19745w = r5.f19745w;
        this.f19746x = r5.f19746x;
        this.f19747y = r5.f19747y;
        this.f19748z = r5.f19748z;
        this.A = r5.A;
        this.B = r5.B;
        this.C = r5.C;
        this.D = r5.D;
        this.E = r5.E;
        this.F = r5.F;
        this.G = r5.G;
        this.H = r5.H;
        this.I = r5.I;
        this.J = r5.J;
        this.K = r5.K;
        this.L = r5.L;
        this.M = r5.M;
        this.N = r5.N;
        this.O = r5.O;
        this.P = r5.P;
        this.Q = r5.Q;
        this.R = r5.R;
        this.S = r5.S;
        this.T = r5.T;
        this.U = r5.U;
        this.V = r5.V;
        this.W = r5.W;
        this.X = r5.X;
        this.Y = r5.Y;
        this.Z = r5.Z;
        this.f19716a0 = r5.f19716a0;
        this.f19718b0 = r5.f19718b0;
        this.f19720c0 = r5.f19720c0;
        this.f19721d0 = r5.f19721d0;
        this.f19722e0 = r5.f19722e0;
        this.f19723f0 = r5.f19723f0;
        this.g0 = r5.g0;
        this.f19725h0 = r5.f19725h0;
        this.i0 = r5.i0;
        this.l0 = r5.l0;
        int[] r10 = r5.f19728j0;
        if (r10 != null) goto L5;
    L7:
        this.f19728j0 = null;
    L8:
        this.f19730k0 = r5.f19730k0;
        this.f19733m0 = r5.f19733m0;
        this.f19735n0 = r5.f19735n0;
        this.f19737o0 = r5.f19737o0;
        this.f19739p0 = r5.f19739p0;
        return;
    L5:
        if (r5.f19730k0 != null) goto L7;
        this.f19728j0 = Arrays.copyOf(r10, r10.length);
        goto L8
    }

    public final void b(Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.Layout);
        this.f19717b = true;
        int r5 = r12.getIndexCount();
        int r13 = 0;
    L3:
        if (r13 >= r5) goto L79;
        int r14 = r12.getIndex(r13);
        SparseIntArray r15 = f19714q0;
        int r16 = r15.get(r14);
        switch(r16) {
            case 1: goto L77;
            case 2: goto L76;
            case 3: goto L75;
            case 4: goto L74;
            case 5: goto L73;
            case 6: goto L72;
            case 7: goto L71;
            case 8: goto L70;
            case 9: goto L69;
            case 10: goto L68;
            case 11: goto L67;
            case 12: goto L66;
            case 13: goto L65;
            case 14: goto L64;
            case 15: goto L63;
            case 16: goto L62;
            case 17: goto L61;
            case 18: goto L60;
            case 19: goto L59;
            case 20: goto L58;
            case 21: goto L57;
            case 22: goto L56;
            case 23: goto L55;
            case 24: goto L54;
            case 25: goto L53;
            case 26: goto L52;
            case 27: goto L51;
            case 28: goto L50;
            case 29: goto L49;
            case 30: goto L48;
            case 31: goto L47;
            case 32: goto L46;
            case 33: goto L45;
            case 34: goto L44;
            case 35: goto L43;
            case 36: goto L42;
            case 37: goto L41;
            case 38: goto L40;
            case 39: goto L39;
            case 40: goto L38;
            case 41: goto L37;
            case 42: goto L36;
            default: goto L6;
        };
    L6:
        switch(r16) {
            case 61: goto L35;
            case 62: goto L34;
            case 63: goto L33;
            default: goto L8;
        };
    L33:
        this.C = r12.getFloat(r14, this.C);
    L78:
        r13 = r13 + 1;
        goto L3
    L34:
        this.B = r12.getDimensionPixelSize(r14, this.B);
        goto L78
    L35:
        this.A = com.obric.oui.constraintlayout.widget.d.l(r12, r14, this.A);
        goto L78
    L8:
        switch(r16) {
            case 69: goto L32;
            case 70: goto L31;
            case 71: goto L30;
            case 72: goto L29;
            case 73: goto L28;
            case 74: goto L27;
            case 75: goto L26;
            case 76: goto L25;
            case 77: goto L24;
            case 78: goto L23;
            case 79: goto L22;
            case 80: goto L21;
            case 81: goto L20;
            case 82: goto L19;
            case 83: goto L18;
            case 84: goto L17;
            case 85: goto L16;
            case 86: goto L15;
            case 87: goto L14;
            case 88: goto L13;
            case 89: goto L12;
            case 90: goto L11;
            case 91: goto L10;
            default: goto L9;
        };
    L9:
        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(r14) + "   " + r15.get(r14));
        goto L78
    L10:
        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(r14) + "   " + r15.get(r14));
        goto L78
    L11:
        this.f19724h = r12.getBoolean(r14, this.f19724h);
        goto L78
    L12:
        this.l0 = r12.getString(r14);
        goto L78
    L13:
        this.f19735n0 = r12.getBoolean(r14, this.f19735n0);
        goto L78
    L14:
        this.f19733m0 = r12.getBoolean(r14, this.f19733m0);
        goto L78
    L15:
        this.f19720c0 = r12.getDimensionPixelSize(r14, this.f19720c0);
        goto L78
    L16:
        this.f19721d0 = r12.getDimensionPixelSize(r14, this.f19721d0);
        goto L78
    L17:
        this.f19716a0 = r12.getDimensionPixelSize(r14, this.f19716a0);
        goto L78
    L18:
        this.f19718b0 = r12.getDimensionPixelSize(r14, this.f19718b0);
        goto L78
    L19:
        this.Z = r12.getInt(r14, this.Z);
        goto L78
    L20:
        this.Y = r12.getInt(r14, this.Y);
        goto L78
    L21:
        this.M = r12.getDimensionPixelSize(r14, this.M);
        goto L78
    L22:
        this.T = r12.getDimensionPixelSize(r14, this.T);
        goto L78
    L23:
        this.s = com.obric.oui.constraintlayout.widget.d.l(r12, r14, this.s);
        goto L78
    L24:
        this.f19741r = com.obric.oui.constraintlayout.widget.d.l(r12, r14, this.f19741r);
        goto L78
    L25:
        this.f19739p0 = r12.getInt(r14, this.f19739p0);
        goto L78
    L26:
        this.f19737o0 = r12.getBoolean(r14, this.f19737o0);
        goto L78
    L27:
        this.f19730k0 = r12.getString(r14);
        goto L78
    L28:
        this.f19725h0 = r12.getDimensionPixelSize(r14, this.f19725h0);
        goto L78
    L29:
        this.g0 = r12.getInt(r14, this.g0);
        goto L78
    L30:
        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
        goto L78
    L31:
        this.f19723f0 = r12.getFloat(r14, 1.0f);
        goto L78
    L32:
        this.f19722e0 = r12.getFloat(r14, 1.0f);
        goto L78
    L36:
        com.obric.oui.constraintlayout.widget.d.m(this, r12, r14, 1);
        goto L78
    L37:
        com.obric.oui.constraintlayout.widget.d.m(this, r12, r14, 0);
        goto L78
    L38:
        this.X = r12.getInt(r14, this.X);
        goto L78
    L39:
        this.W = r12.getInt(r14, this.W);
        goto L78
    L40:
        this.U = r12.getFloat(r14, this.U);
        goto L78
    L41:
        this.V = r12.getFloat(r14, this.V);
        goto L78
    L42:
        this.f19747y = r12.getFloat(r14, this.f19747y);
        goto L78
    L43:
        this.f19732m = com.obric.oui.constraintlayout.widget.d.l(r12, r14, this.f19732m);
        goto L78
    L44:
        this.f19734n = com.obric.oui.constraintlayout.widget.d.l(r12, r14, this.f19734n);
        goto L78
    L45:
        this.I = r12.getDimensionPixelSize(r14, this.I);
        goto L78
    L46:
        this.f19743u = com.obric.oui.constraintlayout.widget.d.l(r12, r14, this.f19743u);
        goto L78
    L47:
        this.f19742t = com.obric.oui.constraintlayout.widget.d.l(r12, r14, this.f19742t);
        goto L78
    L48:
        this.L = r12.getDimensionPixelSize(r14, this.L);
        goto L78
    L49:
        this.f19731l = com.obric.oui.constraintlayout.widget.d.l(r12, r14, this.f19731l);
        goto L78
    L50:
        this.f19729k = com.obric.oui.constraintlayout.widget.d.l(r12, r14, this.f19729k);
        goto L78
    L51:
        this.H = r12.getDimensionPixelSize(r14, this.H);
        goto L78
    L52:
        this.F = r12.getInt(r14, this.F);
        goto L78
    L53:
        this.f19727j = com.obric.oui.constraintlayout.widget.d.l(r12, r14, this.f19727j);
        goto L78
    L54:
        this.f19726i = com.obric.oui.constraintlayout.widget.d.l(r12, r14, this.f19726i);
        goto L78
    L55:
        this.G = r12.getDimensionPixelSize(r14, this.G);
        goto L78
    L56:
        this.f19719c = r12.getLayoutDimension(r14, this.f19719c);
        goto L78
    L57:
        this.d = r12.getLayoutDimension(r14, this.d);
        goto L78
    L58:
        this.f19746x = r12.getFloat(r14, this.f19746x);
        goto L78
    L59:
        this.g = r12.getFloat(r14, this.g);
        goto L78
    L60:
        this.f = r12.getDimensionPixelOffset(r14, this.f);
        goto L78
    L61:
        this.e = r12.getDimensionPixelOffset(r14, this.e);
        goto L78
    L62:
        this.O = r12.getDimensionPixelSize(r14, this.O);
        goto L78
    L63:
        this.S = r12.getDimensionPixelSize(r14, this.S);
        goto L78
    L64:
        this.P = r12.getDimensionPixelSize(r14, this.P);
        goto L78
    L65:
        this.N = r12.getDimensionPixelSize(r14, this.N);
        goto L78
    L66:
        this.R = r12.getDimensionPixelSize(r14, this.R);
        goto L78
    L67:
        this.Q = r12.getDimensionPixelSize(r14, this.Q);
        goto L78
    L68:
        this.f19744v = com.obric.oui.constraintlayout.widget.d.l(r12, r14, this.f19744v);
        goto L78
    L69:
        this.f19745w = com.obric.oui.constraintlayout.widget.d.l(r12, r14, this.f19745w);
        goto L78
    L70:
        this.K = r12.getDimensionPixelSize(r14, this.K);
        goto L78
    L71:
        this.E = r12.getDimensionPixelOffset(r14, this.E);
        goto L78
    L72:
        this.D = r12.getDimensionPixelOffset(r14, this.D);
        goto L78
    L73:
        this.f19748z = r12.getString(r14);
        goto L78
    L74:
        this.f19736o = com.obric.oui.constraintlayout.widget.d.l(r12, r14, this.f19736o);
        goto L78
    L75:
        this.f19738p = com.obric.oui.constraintlayout.widget.d.l(r12, r14, this.f19738p);
        goto L78
    L76:
        this.J = r12.getDimensionPixelSize(r14, this.J);
        goto L78
    L77:
        this.f19740q = com.obric.oui.constraintlayout.widget.d.l(r12, r14, this.f19740q);
        goto L78
    L79:
        r12.recycle();
    }
}
