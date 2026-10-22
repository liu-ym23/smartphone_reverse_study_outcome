package com.obric.oui.constraintlayout.core.widgets;

import androidx.exifinterface.media.ExifInterface;
import com.obric.oui.constraintlayout.core.SolverVariable;
import com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun;
import com.obric.oui.constraintlayout.core.widgets.analyzer.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class ConstraintWidget {
    public static float aa = 0.5f;
    public float A;
    public ConstraintAnchor B;
    public ConstraintAnchor C;
    public ConstraintAnchor D;
    public ConstraintAnchor E;
    public ConstraintAnchor F;
    ConstraintAnchor G;
    ConstraintAnchor H;
    public ConstraintAnchor I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public ConstraintAnchor[] f13606J;
    protected ArrayList<ConstraintAnchor> K;
    public DimensionBehaviour[] L;
    public ConstraintWidget M;
    int N;
    int O;
    public float P;
    protected int Q;
    protected int R;
    protected int S;
    int T;
    int U;
    protected int V;
    protected int W;
    int X;
    protected int Y;
    protected int Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f13607a;
    private boolean aA;
    private int aB;
    private int aC;
    private boolean aD;
    private boolean aE;
    private boolean aF;
    private boolean aG;
    private int aH;
    private int[] aI;
    private boolean aJ;
    private boolean aK;
    private boolean aL;
    private int aM;
    private int aN;
    private boolean[] aO;
    private Object aP;
    private int aQ;
    private int aR;
    private boolean aS;
    private String aT;
    private String aU;
    float ab;
    float ac;
    int ad;
    int ae;
    int af;
    int ag;
    boolean ah;
    boolean ai;
    boolean aj;
    boolean ak;
    boolean al;
    boolean am;
    boolean an;
    int ao;
    int ap;
    boolean aq;
    boolean ar;
    public float[] as;
    protected ConstraintWidget[] at;
    protected ConstraintWidget[] au;
    ConstraintWidget av;
    ConstraintWidget aw;
    public int ax;
    public int ay;
    private boolean az;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f13608b;
    public WidgetRun[] c;
    public com.obric.oui.constraintlayout.core.widgets.analyzer.c d;
    public com.obric.oui.constraintlayout.core.widgets.analyzer.c e;
    public com.obric.oui.constraintlayout.core.widgets.analyzer.k f;
    public m g;
    public boolean[] h;
    boolean i;
    public com.obric.oui.constraintlayout.core.state.a j;
    public String k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int[] p;
    public int q;
    public int r;
    public float s;
    public int t;
    public int u;
    public float v;
    public boolean w;
    public boolean x;
    int y;
    float z;

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.core.widgets.ConstraintWidget$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13609a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f13610b = null;

        static {
            int[] r0 = new int[DimensionBehaviour.values().length];
            f13610b = r0;
            r0[DimensionBehaviour.FIXED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L36:
            f13610b[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L46:
            f13610b[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L58:
            f13610b[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L10:
            int[] r4 = new int[ConstraintAnchor.Type.values().length];
            f13609a = r4;
            r4[ConstraintAnchor.Type.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L38:
            f13609a[ConstraintAnchor.Type.TOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L44:
            f13609a[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L52:
            f13609a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L34:
            f13609a[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
        L42:
            f13609a[ConstraintAnchor.Type.CENTER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L30
        L56:
            f13609a[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;     // Catch: NoSuchFieldError -> L31
        L40:
            f13609a[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;     // Catch: NoSuchFieldError -> L32
        L48:
            f13609a[ConstraintAnchor.Type.NONE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L33
            return;
        }
    }

    public static final enum DimensionBehaviour extends Enum<DimensionBehaviour> {
        private static final /* synthetic */ DimensionBehaviour[] $VALUES = null;
        public static final DimensionBehaviour FIXED = null;
        public static final DimensionBehaviour MATCH_CONSTRAINT = null;
        public static final DimensionBehaviour MATCH_PARENT = null;
        public static final DimensionBehaviour WRAP_CONTENT = null;

        static {
            DimensionBehaviour r0 = new DimensionBehaviour("FIXED", 0);
            FIXED = r0;
            DimensionBehaviour r1 = new DimensionBehaviour("WRAP_CONTENT", 1);
            WRAP_CONTENT = r1;
            DimensionBehaviour r3 = new DimensionBehaviour("MATCH_CONSTRAINT", 2);
            MATCH_CONSTRAINT = r3;
            DimensionBehaviour r5 = new DimensionBehaviour("MATCH_PARENT", 3);
            MATCH_PARENT = r5;
            $VALUES = new DimensionBehaviour[]{r0, r1, r3, r5};
        }

        private DimensionBehaviour(String r1, int r2) {
            super(r1, r2);
        }

        public static DimensionBehaviour valueOf(String r2) {
            return (DimensionBehaviour) ZeusTransformUtils.preCheckCast(Enum.valueOf(DimensionBehaviour.class, r2), DimensionBehaviour.class, "com.obric.memorydata.plugin");
        }

        public static DimensionBehaviour[] values() {
            return (DimensionBehaviour[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DimensionBehaviour[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
    }

    public ConstraintWidget() {
        this.f13608b = false;
        this.c = new WidgetRun[2];
        this.f = null;
        this.g = null;
        this.h = new boolean[]{true, true};
        this.i = false;
        this.f13607a = true;
        this.az = false;
        this.aA = true;
        this.aB = -1;
        this.aC = -1;
        this.j = new com.obric.oui.constraintlayout.core.state.a(this);
        this.aD = false;
        this.aE = false;
        this.aF = false;
        this.aG = false;
        this.l = -1;
        this.m = -1;
        this.aH = 0;
        this.n = 0;
        this.o = 0;
        this.p = new int[2];
        this.q = 0;
        this.r = 0;
        this.s = 1.0f;
        this.t = 0;
        this.u = 0;
        this.v = 1.0f;
        this.y = -1;
        this.z = 1.0f;
        this.aI = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.A = Float.NaN;
        this.aJ = false;
        this.aL = false;
        this.aM = 0;
        this.aN = 0;
        this.B = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.C = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.D = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.E = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.F = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.G = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.H = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor r5 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.I = r5;
        this.f13606J = new ConstraintAnchor[]{this.B, this.D, this.C, this.E, this.F, r5};
        this.K = new ArrayList();
        this.aO = new boolean[2];
        this.L = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.M = null;
        this.N = 0;
        this.O = 0;
        this.P = 0.0f;
        this.Q = -1;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = 0;
        float r6 = aa;
        this.ab = r6;
        this.ac = r6;
        this.aQ = 0;
        this.aR = 0;
        this.aS = false;
        this.aT = null;
        this.aU = null;
        this.an = false;
        this.ao = 0;
        this.ap = 0;
        this.as = new float[]{-1.0f, -1.0f};
        this.at = new ConstraintWidget[]{null, null};
        this.au = new ConstraintWidget[]{null, null};
        this.av = null;
        this.aw = null;
        this.ax = -1;
        this.ay = -1;
        b();
    }

    private void a(com.obric.oui.constraintlayout.core.d r34, boolean r35, boolean r36, boolean r37, boolean r38, SolverVariable r39, SolverVariable r40, DimensionBehaviour r41, boolean r42, ConstraintAnchor r43, ConstraintAnchor r44, int r45, int r46, int r47, int r48, float r49, boolean r50, boolean r51, boolean r52, boolean r53, boolean r54, int r55, int r56, int r57, int r58, float r59, boolean r60) {
        SolverVariable r9 = r34.a(r43);
        SolverVariable r8 = r34.a(r44);
        SolverVariable r7 = r34.a(r43.j());
        SolverVariable r6 = r34.a(r44.j());
        if (com.obric.oui.constraintlayout.core.d.a() == null) goto L5;
        com.obric.oui.constraintlayout.core.d.a().y++;
    L5:
        boolean r11 = r43.l();
        boolean r12 = r44.l();
        boolean r16 = this.I.l();
        if (r12 == false) goto L8;
        int r5 = (r11 ? 1 : 0) + 1;
    L9:
        if (r16 == false) goto L11;
        r5 = r5 + 1;
    L11:
        if (r50 == false) goto L13;
        int r18 = 3;
    L14:
        int r2 = AnonymousClass1.f13610b[r41.ordinal()];
        if (r2 != 1) goto L17;
    L22:
        int r3 = r18;
    L23:
        boolean r19 = false;
    L27:
        int r14 = this.aB;
        if (r14 == (-1)) goto L31;
        if (r35 == false) goto L31;
        this.aB = -1;
        r19 = false;
    L32:
        int r10 = this.aC;
        if (r10 == (-1)) goto L37;
        if (r35 == true) goto L37;
        this.aC = -1;
        r14 = r10;
        r19 = false;
    L37:
        if (this.aR != 8) goto L39;
        r14 = 0;
        r19 = false;
    L39:
        if (r60 == false) goto L47;
        if (r11 == true) goto L44;
        if (r12 == true) goto L44;
        if (r16 == true) goto L44;
        r34.a(r9, r45);
    L44:
        if (r11 == false) goto L47;
        if (r12 == true) goto L47;
        r34.c(r9, r7, r43.i(), 8);
    L47:
        if (r19 == true) goto L58;
        if (r42 == false) goto L55;
        r34.c(r8, r9, 0, 3);
        if (r47 <= 0) goto L53;
        r34.a(r8, r9, r47, 8);
    L53:
        if (r48 >= Integer.MAX_VALUE) goto L56;
        r34.b(r8, r9, r48, 8);
    L56:
        int r1 = r58;
        int r410 = r5;
        boolean r23 = r19;
        boolean r110 = r38;
        int r21 = r57;
    L111:
        if (r60 == false) goto L353;
        if (r52 == false) goto L114;
        int r4 = 0;
        char r13 = 2;
    L354:
        if (r410 >= r13) goto L386;
        if (r36 == false) goto L387;
        if (r110 == false) goto L388;
        r34.a(r9, r39, r4, 8);
        if (r35 == false) goto L360;
    L363:
        int r15 = 1;
    L364:
        if (r35 == false) goto L366;
    L375:
        int r17 = r15;
    L376:
        if (r17 == 0) goto L389;
        r34.a(r40, r8, r4, 8);
        return;
    L389:
        return;
    L366:
        if (this.F.c == null) goto L375;
        ConstraintWidget r0 = this.F.c.f13603a;
        if (r0.P != 0.0f) goto L370;
    L374:
        r17 = r4;
        goto L376
    L370:
        if (r0.L[r4] != DimensionBehaviour.MATCH_CONSTRAINT) goto L374;
        if (r0.L[1] != DimensionBehaviour.MATCH_CONSTRAINT) goto L374;
        r17 = 1;
        goto L376
    L360:
        if (this.F.c == null) goto L363;
        r15 = r4;
        goto L364
    L388:
        return;
    L387:
        return;
    L386:
        return;
    L114:
        String r32 = "com.obric.memorydata.plugin";
        if (r11 == true) goto L119;
        if (r12 == true) goto L119;
        if (r16 == true) goto L119;
        int r20 = 5;
        int r22 = 0;
    L331:
        boolean r24 = r36;
    L332:
        int r25 = r20;
    L333:
        if (r24 == false) goto L383;
        if (r110 == true) goto L336;
        return;
    L336:
        if (r44.c == null) goto L338;
        int r111 = r44.i();
    L339:
        if (r6 != r40) goto L341;
        return;
    L341:
        if (this.az == true) goto L343;
    L351:
        r34.a(r40, r8, r111, r25);
        return;
    L343:
        if (r8.f == false) goto L351;
        ConstraintWidget r26 = this.M;
        if (r26 == null) goto L351;
        d r27 = (d) ZeusTransformUtils.preCheckCast(r26, d.class, r32);
        if (r35 == false) goto L349;
        r27.d(r44);
        return;
    L349:
        r27.c(r44);
        return;
    L338:
        r111 = r22;
        goto L339
    L383:
        return;
    L119:
        if (r11 == false) goto L129;
        if (r12 == true) goto L129;
        ConstraintWidget r28 = r43.c.f13603a;
        if (r36 == true) goto L124;
    L126:
        int r112 = 5;
    L127:
        r24 = r36;
        r22 = 0;
        r32 = r32;
        r25 = r112;
        r8 = r8;
        goto L333
    L124:
        if (ZeusTransformUtils.instanceOf(r28, a.class) == false) goto L126;
        r112 = 8;
    L129:
        if (r11 == true) goto L145;
        if (r12 == false) goto L145;
        r34.c(r8, r6, -r44.i(), 8);
        if (r36 == true) goto L134;
    L330:
        r22 = 0;
        r20 = 5;
        goto L331
    L134:
        if (this.az == true) goto L136;
    L143:
        r20 = 5;
        r34.a(r9, r39, 0, 5);
        r22 = 0;
        goto L331
    L136:
        if (r9.f == false) goto L143;
        ConstraintWidget r29 = this.M;
        if (r29 == null) goto L143;
        d r30 = (d) ZeusTransformUtils.preCheckCast(r29, d.class, r32);
        if (r35 == false) goto L142;
        r30.b(r43);
        goto L330
    L142:
        r30.a(r43);
    L145:
        if (r11 == false) goto L330;
        if (r12 == false) goto L330;
        ConstraintWidget r113 = r43.c.f13603a;
        ConstraintWidget r31 = r44.c.f13603a;
        ConstraintWidget r33 = A();
        int r114 = 6;
        if (r23 == false) goto L220;
        if (r3 != 0) goto L169;
        if (r1 != 0) goto L159;
        if (r21 != 0) goto L159;
        if (r7.f == true) goto L155;
    L158:
        boolean r210 = false;
        boolean r211 = false;
        int r61 = 8;
        int r115 = 8;
        boolean r212 = true;
    L161:
        if (ZeusTransformUtils.instanceOf(r113, a.class) == false) goto L163;
    L167:
        r40 = r40;
        r3 = r3;
        boolean r213 = r212;
        int r62 = r61;
        r114 = 6;
        boolean r214 = r210;
        int r215 = 4;
    L238:
        if (r211 == false) goto L242;
        if (r7 != r6) goto L242;
        if (r113 == r33) goto L242;
        r211 = false;
        boolean r216 = false;
    L243:
        if (r214 == false) goto L252;
        if (r23 == true) goto L250;
        if (r51 == true) goto L250;
        if (r53 == true) goto L250;
        if (r7 != r39) goto L250;
        if (r6 != r40) goto L250;
        r24 = false;
        int r217 = 8;
        int r218 = 8;
        boolean r219 = false;
    L251:
        ConstraintWidget r411 = r33;
        r34.a(r9, r7, r43.i(), r49, r6, r8, r44.i(), r218);
        r62 = r217;
        r216 = r219;
    L254:
        if (this.aR == 8) goto L256;
    L258:
        if (r211 == false) goto L268;
        if (r24 == false) goto L267;
        if (r7 == r6) goto L267;
        if (r23 == true) goto L267;
        if (ZeusTransformUtils.instanceOf(r113, a.class) == false) goto L265;
    L266:
        r62 = 6;
        goto L267
    L265:
        if (ZeusTransformUtils.instanceOf(r31, a.class) == true) goto L266;
    L267:
        r34.a(r9, r7, r43.i(), r62);
        SolverVariable r63 = r8;
        r34.b(r63, r6, -r44.i(), r62);
    L269:
        if (r24 == false) goto L278;
        if (r54 == false) goto L278;
        if (ZeusTransformUtils.instanceOf(r113, a.class) == true) goto L278;
        if (ZeusTransformUtils.instanceOf(r31, a.class) == true) goto L278;
        ConstraintWidget r64 = r411;
        if (r31 == r64) goto L279;
        r62 = 6;
        int r65 = 6;
        r216 = true;
    L280:
        if (r216 == false) goto L311;
        if (r213 == false) goto L302;
        if (r53 == false) goto L284;
        if (r37 == false) goto L302;
    L284:
        if (r113 == r64) goto L288;
        if (r31 == r64) goto L288;
        int r66 = r65;
    L290:
        if (ZeusTransformUtils.instanceOf(r113, f.class) == false) goto L292;
    L293:
        r66 = 5;
    L295:
        if (ZeusTransformUtils.instanceOf(r113, a.class) == false) goto L297;
    L298:
        r66 = 5;
    L299:
        if (r53 == false) goto L301;
        r66 = 5;
    L301:
        r65 = Math.max(r66, r65);
        goto L302
    L297:
        if (ZeusTransformUtils.instanceOf(r31, a.class) == false) goto L299;
    L292:
        if (ZeusTransformUtils.instanceOf(r31, f.class) == false) goto L295;
    L288:
        r66 = 6;
    L302:
        if (r24 == false) goto L310;
        int r67 = Math.min(r62, r65);
        if (r50 == false) goto L309;
        if (r53 == true) goto L309;
        if (r113 == r64) goto L308;
        if (r31 != r64) goto L309;
    L308:
        r65 = 4;
    L309:
        r65 = r67;
    L310:
        r34.c(r9, r7, r43.i(), r65);
        r34.c(r63, r6, -r44.i(), r65);
    L311:
        if (r24 == true) goto L313;
    L318:
        if (r24 == false) goto L328;
        if (r23 == false) goto L328;
        r8 = r63;
        if (r47 != 0) goto L329;
        if (r21 != 0) goto L329;
        if (r23 == true) goto L325;
    L327:
        r22 = 0;
        r20 = 5;
        r34.a(r8, r9, 0, 5);
        goto L332
    L325:
        if (r3 != 3) goto L327;
        r22 = 0;
        r34.a(r8, r9, 0, 8);
        r20 = 5;
    L329:
        r20 = 5;
        r22 = 0;
    L328:
        r8 = r63;
        goto L329
    L313:
        if (r39 != r7) goto L315;
        int r68 = r43.i();
    L316:
        if (r7 == r39) goto L318;
        r34.a(r9, r39, r68, 5);
        goto L318
    L315:
        r68 = 0;
    L279:
        r65 = r215;
    L278:
        r64 = r411;
        goto L279
    L268:
        r63 = r8;
        goto L269
    L256:
        if (r44.b() == true) goto L258;
        return;
    L250:
        r24 = r36;
        r218 = r114;
        r219 = r216;
        r217 = r62;
        goto L251
    L252:
        r411 = r33;
        r24 = r36;
    L242:
        r216 = true;
        goto L243
    L163:
        if (ZeusTransformUtils.instanceOf(r31, a.class) == true) goto L167;
        r213 = r212;
        r214 = r210;
        r215 = r115;
        r3 = r3;
    L166:
        r62 = r61;
        r114 = 6;
        goto L238
    L155:
        if (r6.f == false) goto L158;
        r34.c(r9, r7, r43.i(), 8);
        r34.c(r8, r6, -r44.i(), 8);
        return;
    L159:
        r212 = false;
        r61 = 5;
        r115 = 5;
        r210 = true;
        r211 = true;
        goto L161
    L169:
        if (r3 != 2) goto L178;
        if (ZeusTransformUtils.instanceOf(r113, a.class) == true) goto L234;
        if (ZeusTransformUtils.instanceOf(r31, a.class) == true) goto L234;
        r40 = r40;
        r3 = r3;
        r114 = 6;
        r62 = 5;
        r215 = 5;
    L236:
        r214 = true;
        r211 = true;
    L237:
        r213 = false;
    L234:
        r62 = 5;
    L235:
        r215 = 4;
        goto L236
    L178:
        if (r3 != 1) goto L181;
        r40 = r40;
        r3 = r3;
        r62 = 8;
        goto L235
    L181:
        if (r3 != 3) goto L218;
        r3 = r3;
        if (this.y == (-1)) goto L185;
        if (r50 == true) goto L195;
        if (r1 <= 0) goto L207;
        r114 = 6;
        r62 = 5;
    L191:
        r215 = 5;
    L192:
        r214 = true;
        r211 = true;
        r213 = true;
        goto L238
    L207:
        if (r1 != 0) goto L216;
        if (r21 != 0) goto L216;
        if (r53 == true) goto L211;
        r40 = r40;
        r114 = 6;
        r62 = 5;
        r215 = 8;
        goto L192
    L211:
        if (r113 == r33) goto L214;
        if (r31 == r33) goto L214;
        int r69 = 4;
    L215:
        r62 = r69;
    L217:
        r215 = 4;
    L214:
        r69 = 5;
    L216:
        r62 = 5;
        goto L217
    L195:
        if (r56 != 2) goto L197;
    L200:
        boolean r70 = true;
    L201:
        if (r70 == true) goto L203;
        r61 = 8;
        int r71 = 5;
    L204:
        r215 = r71;
        r214 = true;
        r211 = true;
        r213 = true;
        goto L166
    L203:
        r61 = 5;
        r71 = 4;
        goto L204
    L197:
        if (r56 == 1) goto L200;
        r70 = false;
        goto L201
    L185:
        if (r53 == false) goto L189;
        if (r36 == false) goto L188;
        r114 = 5;
    L190:
        r62 = 8;
        goto L191
    L188:
        r114 = 4;
        goto L190
    L189:
        r114 = 8;
        goto L190
    L218:
        r3 = r3;
        r40 = r40;
        r114 = 6;
        r62 = 5;
        r215 = 4;
        r214 = false;
        r211 = false;
        goto L237
    L220:
        if (r7.f == false) goto L234;
        if (r6.f == false) goto L234;
        r34.a(r9, r7, r43.i(), r49, r6, r8, r44.i(), 8);
        if (r36 == false) goto L379;
        if (r110 == true) goto L227;
        return;
    L227:
        if (r44.c == null) goto L229;
        int r116 = r44.i();
    L230:
        if (r6 == r40) goto L381;
        r34.a(r40, r8, r116, 5);
        return;
    L381:
        return;
    L229:
        r116 = 0;
        goto L230
    L379:
        return;
    L353:
        r4 = 0;
        r13 = 2;
        goto L354
    L55:
        r34.c(r8, r9, r14, 8);
        goto L56
    L58:
        if (r5 == 2) goto L68;
        if (r50 == true) goto L68;
        if (r3 == 1) goto L63;
        if (r3 != 0) goto L68;
    L63:
        int r72 = Math.max(r57, r14);
        if (r58 <= 0) goto L66;
        r72 = Math.min(r58, r72);
    L66:
        r34.c(r8, r9, r72, 8);
        r110 = r38;
        r1 = r58;
        r410 = r5;
        r23 = false;
        r21 = r57;
    L68:
        if (r57 != (-2)) goto L70;
        int r73 = r14;
    L71:
        if (r58 != (-2)) goto L73;
        r1 = r14;
    L74:
        if (r14 > 0) goto L76;
    L78:
        if (r73 <= 0) goto L80;
        r34.a(r8, r9, r73, 8);
        r14 = Math.max(r14, r73);
    L80:
        if (r1 <= 0) goto L90;
        if (r36 == true) goto L83;
    L85:
        boolean r74 = true;
    L86:
        if (r74 == false) goto L88;
        int r75 = 8;
        r34.b(r8, r9, r1, 8);
    L89:
        r14 = Math.min(r14, r1);
    L92:
        if (r3 != 1) goto L98;
        if (r36 == false) goto L95;
        r34.c(r8, r9, r14, r75);
    L96:
        r410 = r5;
        r23 = r19;
        r110 = r38;
        r21 = r73;
        goto L111
    L95:
        r34.c(r8, r9, r14, 5);
        r34.b(r8, r9, r14, r75);
        goto L96
    L98:
        if (r3 == 2) goto L100;
        r410 = r5;
        r21 = r73;
        r23 = r19;
        r110 = true;
        goto L111
    L100:
        if (r43.getType() != ConstraintAnchor.Type.TOP) goto L102;
    L105:
        SolverVariable r76 = r34.a(this.M.a(ConstraintAnchor.Type.TOP));
        ConstraintWidget r77 = this.M;
        ConstraintAnchor.Type r117 = ConstraintAnchor.Type.BOTTOM;
    L106:
        SolverVariable r78 = r34.a(r77.a(r117));
        SolverVariable r220 = r76;
        com.obric.oui.constraintlayout.core.b r79 = r34.c();
        r410 = r5 == true ? 1 : 0;
        r21 = r73;
        r34.a(r79.a(r8, r9, r78, r220, r59));
        if (r36 == false) goto L109;
        r19 = false;
    L109:
        r23 = r19;
        r110 = r38;
        goto L111
    L102:
        if (r43.getType() == ConstraintAnchor.Type.BOTTOM) goto L105;
        r76 = r34.a(this.M.a(ConstraintAnchor.Type.LEFT));
        r77 = this.M;
        r117 = ConstraintAnchor.Type.RIGHT;
        goto L106
    L88:
        r75 = 8;
        goto L89
    L83:
        if (r3 != 1) goto L85;
        r74 = false;
        goto L86
    L90:
        r75 = 8;
        goto L92
    L76:
        if (r3 == 1) goto L78;
        r14 = 0;
        goto L78
    L73:
        r1 = r58;
        goto L74
    L70:
        r73 = r57;
    L31:
        r14 = r46;
        goto L32
    L17:
        if (r2 == 2) goto L22;
        if (r2 == 3) goto L22;
        if (r2 != 4) goto L22;
        r3 = r18;
        if (r3 == 4) goto L23;
        r19 = true;
        goto L27
    L13:
        r18 = r55;
        goto L14
    L8:
        r5 = r11 ? 1 : 0;
        goto L9
    }

    private void a(StringBuilder r1, String r2, float r3, float r4) {
        if (r3 != r4) goto L5;
        return;
    L5:
        r1.append(r2);
        r1.append(" :   ");
        r1.append(r3);
        r1.append(",\n");
    }

    private void a(StringBuilder r1, String r2, float r3, int r4) {
        if (r3 != 0.0f) goto L5;
        return;
    L5:
        r1.append(r2);
        r1.append(" :  [");
        r1.append(r3);
        r1.append(",");
        r1.append(r4);
        r1.append("");
        r1.append("],\n");
    }

    private void a(StringBuilder r1, String r2, int r3, int r4) {
        if (r3 != r4) goto L4;
        return;
    L4:
        r1.append(r2);
        r1.append(" :   ");
        r1.append(r3);
        r1.append(",\n");
    }

    private void a(StringBuilder r1, String r2, int r3, int r4, int r5, int r6, int r7, int r8, float r9, DimensionBehaviour r10, float r11) {
        r1.append(r2);
        r1.append(" :  {\n");
        a(r1, "      behavior", r10.toString(), DimensionBehaviour.FIXED.toString());
        a(r1, "      size", r3, 0);
        a(r1, "      min", r4, 0);
        a(r1, "      max", r5, Integer.MAX_VALUE);
        a(r1, "      matchMin", r7, 0);
        a(r1, "      matchDef", r8, 0);
        a(r1, "      matchPercent", r9, 1.0f);
        r1.append("    },\n");
    }

    private void a(StringBuilder r2, String r3, ConstraintAnchor r4) {
        if (r4.c != null) goto L5;
        return;
    L5:
        r2.append("    ");
        r2.append(r3);
        r2.append(" : [ '");
        r2.append(r4.c);
        r2.append("'");
        if (r4.e == Integer.MIN_VALUE) goto L8;
    L9:
        r2.append(",");
        r2.append(r4.d);
        if (r4.e == Integer.MIN_VALUE) goto L12;
        r2.append(",");
        r2.append(r4.e);
        r2.append(",");
    L12:
        r2.append(" ] ,\n");
        return;
    L8:
        if (r4.d == 0) goto L12;
        goto L9
    }

    private void a(StringBuilder r1, String r2, String r3, String r4) {
        if (r4.equals(r3) == false) goto L5;
        return;
    L5:
        r1.append(r2);
        r1.append(" :   ");
        r1.append(r3);
        r1.append(",\n");
    }

    private boolean a(int r5) {
        int r6 = r5 * 2;
        if (this.f13606J[r6].c == null) goto L11;
        ConstraintAnchor r0 = this.f13606J[r6].c.c;
        ConstraintAnchor[] r2 = this.f13606J;
        if (r0 == r2[r6]) goto L11;
        int r7 = r6 + 1;
        if (r2[r7].c == null) goto L11;
        if (this.f13606J[r7].c.c != this.f13606J[r7]) goto L11;
        return true;
    L11:
        return false;
    }

    private void b() {
        this.K.add(this.B);
        this.K.add(this.C);
        this.K.add(this.D);
        this.K.add(this.E);
        this.K.add(this.G);
        this.K.add(this.H);
        this.K.add(this.I);
        this.K.add(this.F);
    }

    public ConstraintWidget A() {
        return this.M;
    }

    public int B() {
        return this.aR;
    }

    public String C() {
        return this.aT;
    }

    public int D() {
        ConstraintWidget r0 = this.M;
        if (r0 == null) goto L9;
        if (ZeusTransformUtils.instanceOf(r0, d.class) == false) goto L9;
        return ((d) ZeusTransformUtils.preCheckCast(this.M, d.class, "com.obric.memorydata.plugin")).aD + this.R;
    L9:
        return this.R;
    }

    public int E() {
        ConstraintWidget r0 = this.M;
        if (r0 == null) goto L9;
        if (ZeusTransformUtils.instanceOf(r0, d.class) == false) goto L9;
        return ((d) ZeusTransformUtils.preCheckCast(this.M, d.class, "com.obric.memorydata.plugin")).aE + this.S;
    L9:
        return this.S;
    }

    public int F() {
        if (this.aR != 8) goto L7;
        return 0;
    L7:
        return this.N;
    }

    public int G() {
        if (this.aR != 8) goto L7;
        return 0;
    L7:
        return this.O;
    }

    public int H() {
        return this.Y;
    }

    public int I() {
        return this.Z;
    }

    public int J() {
        return D();
    }

    public int K() {
        return E();
    }

    public int L() {
        return D() + this.N;
    }

    public int M() {
        return E() + this.O;
    }

    public int N() {
        ConstraintAnchor r0 = this.B;
        int r1 = 0;
        if (r0 == null) goto L5;
        r1 = 0 + r0.d;
    L5:
        ConstraintAnchor r2 = this.D;
        if (r2 != null) goto L8;
        return r1;
    L8:
        return r1 + r2.d;
    }

    public int O() {
        int r1 = 0;
        if (this.B == null) goto L6;
        r1 = 0 + this.C.d;
    L6:
        if (this.D != null) goto L8;
        return r1;
    L8:
        return r1 + this.E.d;
    }

    public float P() {
        return this.ab;
    }

    public float Q() {
        return this.ac;
    }

    public boolean R() {
        return this.aJ;
    }

    public int S() {
        return this.X;
    }

    public Object T() {
        return this.aP;
    }

    public float U() {
        return this.P;
    }

    public int V() {
        return this.Q;
    }

    public int W() {
        return this.ao;
    }

    public int X() {
        return this.ap;
    }

    public void Y() {
        Z();
        b(aa);
        a(aa);
    }

    public void Z() {
        ConstraintWidget r0 = A();
        if (r0 != null) goto L5;
    L9:
        int r1 = 0;
        int r2 = this.K.size();
    L10:
        if (r1 >= r2) goto L12;
        ((ConstraintAnchor) ZeusTransformUtils.preCheckCast(this.K.get(r1), ConstraintAnchor.class, "com.obric.memorydata.plugin")).k();
        r1 = r1 + 1;
        goto L10
    L12:
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r0, d.class) == false) goto L9;
        if (((d) ZeusTransformUtils.preCheckCast(A(), d.class, "com.obric.memorydata.plugin")).ai() == false) goto L9;
    }

    public ConstraintAnchor a(ConstraintAnchor.Type r3) {
        switch(AnonymousClass1.f13609a[r3.ordinal()]) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L9;
            case 9: goto L6;
            default: goto L5;
        };
    L6:
        return null;
    L5:
        throw new AssertionError(r3.name());
    L9:
        return this.H;
    L11:
        return this.G;
    L13:
        return this.I;
    L15:
        return this.F;
    L17:
        return this.E;
    L19:
        return this.D;
    L21:
        return this.C;
    L23:
        return this.B;
    }

    public void a(float r1) {
        this.ab = r1;
    }

    public void a(int r2, int r3) {
        if (this.aD == false) goto L5;
        return;
    L5:
        this.B.a(r2);
        this.D.a(r3);
        this.R = r2;
        this.N = r3 - r2;
        this.aD = true;
    }

    public void a(int r1, int r2, int r3, float r4) {
        this.n = r1;
        this.q = r2;
        if (r3 != Integer.MAX_VALUE) goto L5;
        r3 = 0;
    L5:
        this.r = r3;
        this.s = r4;
        if (r4 > 0.0f) goto L8;
        return;
    L8:
        if (r4 >= 1.0f) goto L13;
        if (r1 != 0) goto L14;
        this.n = 2;
        return;
    L14:
        return;
    }

    public void a(int r3, int r4, int r5, int r6) {
        int r7 = r5 - r3;
        int r8 = r6 - r4;
        this.R = r3;
        this.S = r4;
        if (this.aR != 8) goto L7;
        this.N = 0;
        this.O = 0;
        return;
    L7:
        if (this.L[0] != DimensionBehaviour.FIXED) goto L12;
        int r9 = this.N;
        if (r7 >= r9) goto L12;
        r7 = r9;
    L12:
        if (this.L[1] != DimensionBehaviour.FIXED) goto L16;
        int r10 = this.O;
        if (r8 >= r10) goto L16;
        r8 = r10;
    L16:
        this.N = r7;
        this.O = r8;
        int r11 = this.Z;
        if (r8 >= r11) goto L19;
        this.O = r11;
    L19:
        int r12 = this.Y;
        if (r7 >= r12) goto L23;
        this.N = r12;
    L23:
        if (this.r <= 0) goto L28;
        if (this.L[0] != DimensionBehaviour.MATCH_CONSTRAINT) goto L28;
        this.N = Math.min(this.N, this.r);
    L28:
        if (this.u > 0) goto L30;
    L32:
        int r13 = this.N;
        if (r7 == r13) goto L35;
        this.aB = r13;
    L35:
        int r14 = this.O;
        if (r8 == r14) goto L39;
        this.aC = r14;
        return;
    L39:
        return;
    L30:
        if (this.L[1] != DimensionBehaviour.MATCH_CONSTRAINT) goto L32;
        this.O = Math.min(this.O, this.u);
        goto L32
    }

    public void a(int r1, boolean r2) {
        this.aO[r1] = r2;
    }

    public void a(com.obric.oui.constraintlayout.core.c r2) {
        this.B.a(r2);
        this.C.a(r2);
        this.D.a(r2);
        this.E.a(r2);
        this.F.a(r2);
        this.I.a(r2);
        this.G.a(r2);
        this.H.a(r2);
    }

    public void a(com.obric.oui.constraintlayout.core.d r2) {
        r2.a(this.B);
        r2.a(this.C);
        r2.a(this.D);
        r2.a(this.E);
        if (this.X <= 0) goto L6;
        r2.a(this.F);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(com.obric.oui.constraintlayout.core.d r51, boolean r52) {
        SolverVariable r13 = r51.a(this.B);
        SolverVariable r12 = r51.a(this.D);
        SolverVariable r11 = r51.a(this.C);
        SolverVariable r10 = r51.a(this.E);
        SolverVariable r9 = r51.a(this.F);
        ConstraintWidget r0 = this.M;
        if (r0 == null) goto L22;
        if (r0 != null) goto L6;
    L8:
        boolean r1 = false;
    L9:
        ConstraintWidget r2 = this.M;
        if (r2 != null) goto L12;
    L14:
        boolean r3 = false;
    L15:
        int r4 = this.aH;
        if (r4 == 1) goto L21;
        if (r4 == 2) goto L20;
        if (r4 == 3) goto L22;
        boolean r5 = r1;
        boolean r6 = r3;
    L24:
        if (this.aR == 8) goto L26;
    L34:
        boolean r7 = this.aD;
        if (r7 == false) goto L37;
    L38:
        if (r7 == false) goto L48;
        r51.a(r13, this.R);
        r51.a(r12, this.R + this.N);
        if (r5 == false) goto L48;
        ConstraintWidget r8 = this.M;
        if (r8 == null) goto L48;
        if (this.aA == false) goto L46;
        d r14 = (d) ZeusTransformUtils.preCheckCast(r8, d.class, "com.obric.memorydata.plugin");
        r14.b(this.B);
        r14.d(this.D);
        goto L48
    L46:
        r51.a(r51.a(r8.D), r12, 0, 5);
    L48:
        if (this.aE == false) goto L60;
        r51.a(r11, this.S);
        r51.a(r10, this.S + this.O);
        if (this.F.b() == false) goto L52;
        r51.a(r9, this.S + this.X);
    L52:
        if (r6 == false) goto L60;
        ConstraintWidget r15 = this.M;
        if (r15 == null) goto L60;
        if (this.aA == false) goto L58;
        d r16 = (d) ZeusTransformUtils.preCheckCast(r15, d.class, "com.obric.memorydata.plugin");
        r16.a(this.C);
        r16.c(this.E);
        goto L60
    L58:
        r51.a(r51.a(r15.E), r10, 0, 5);
    L60:
        if (this.aD == true) goto L62;
    L66:
        if (com.obric.oui.constraintlayout.core.d.o == null) goto L69;
        com.obric.oui.constraintlayout.core.d.o.A++;
    L69:
        if (r52 == false) goto L100;
        com.obric.oui.constraintlayout.core.widgets.analyzer.k r17 = this.f;
        if (r17 == null) goto L100;
        if (this.g == null) goto L100;
        if (r17.j.j == false) goto L100;
        if (this.f.k.j == false) goto L100;
        if (this.g.j.j == false) goto L100;
        if (this.g.k.j == false) goto L100;
        if (com.obric.oui.constraintlayout.core.d.o == null) goto L85;
        com.obric.oui.constraintlayout.core.d.o.t++;
    L85:
        r51.a(r13, this.f.j.g);
        r51.a(r12, this.f.k.g);
        r51.a(r11, this.g.j.g);
        r51.a(r10, this.g.k.g);
        r51.a(r9, this.g.f13629a.g);
        if (this.M != null) goto L87;
    L63:
        this.aD = false;
        this.aE = false;
        return;
    L87:
        if (r5 == true) goto L89;
    L93:
        if (r6 == false) goto L63;
        if (this.h[1] == false) goto L63;
        if (ad() == true) goto L63;
        r51.a(r51.a(this.M.E), r10, 0, 8);
        goto L63
    L89:
        if (this.h[0] == false) goto L93;
        if (ac() == true) goto L93;
        r51.a(r51.a(this.M.D), r12, 0, 8);
    L100:
        if (com.obric.oui.constraintlayout.core.d.o == null) goto L103;
        com.obric.oui.constraintlayout.core.d.o.u++;
    L103:
        if (this.M != null) goto L105;
        boolean r28 = false;
        boolean r29 = false;
    L134:
        int r18 = this.N;
        int r19 = this.Y;
        if (r18 >= r19) goto L137;
        r18 = r19;
    L137:
        int r20 = this.O;
        int r21 = this.Z;
        if (r20 >= r21) goto L141;
        r20 = r21;
    L141:
        if (this.L[0] == DimensionBehaviour.MATCH_CONSTRAINT) goto L143;
        boolean r22 = true;
    L145:
        if (this.L[1] == DimensionBehaviour.MATCH_CONSTRAINT) goto L147;
        boolean r23 = true;
    L148:
        this.y = this.Q;
        float r24 = this.P;
        this.z = r24;
        int r25 = this.n;
        int r26 = this.o;
        int r27 = r18;
        if (r24 > 0.0f) goto L151;
    L187:
        int r30 = r20;
        int r31 = r26;
        int r32 = r25;
    L188:
        int r33 = r27;
    L189:
        boolean r34 = false;
    L190:
        int[] r35 = this.p;
        r35[0] = r32;
        r35[1] = r31;
        this.i = r34;
        if (r34 == false) goto L196;
        int r36 = this.y;
        int r37 = -1;
        if (r36 == 0) goto L195;
        if (r36 == (-1)) goto L195;
    L197:
        boolean r110 = false;
    L198:
        if (r34 == false) goto L203;
        int r38 = this.y;
        if (r38 == 1) goto L202;
        if (r38 != r37) goto L203;
    L202:
        boolean r39 = true;
    L205:
        if (this.L[0] == DimensionBehaviour.WRAP_CONTENT) goto L207;
    L209:
        boolean r210 = false;
    L210:
        if (r210 == false) goto L212;
        int r211 = 0;
    L213:
        boolean r310 = !this.I.l();
        boolean[] r40 = this.aO;
        boolean r212 = r40[0];
        boolean r311 = r40[1];
        if (this.l == 2) goto L249;
        if (this.aD == true) goto L249;
        if (r52 == false) goto L234;
        com.obric.oui.constraintlayout.core.widgets.analyzer.k r41 = this.f;
        if (r41 == null) goto L234;
        if (r41.j.j == false) goto L234;
        if (this.f.k.j == false) goto L234;
        if (r52 == false) goto L249;
        r51.a(r13, this.f.j.g);
        r51.a(r12, this.f.k.g);
        if (this.M == null) goto L249;
        if (r5 == false) goto L249;
        if (this.h[0] == false) goto L249;
        if (ac() == true) goto L249;
        r51.a(r51.a(this.M.D), r12, 0, 8);
    L234:
        ConstraintWidget r42 = this.M;
        if (r42 == null) goto L237;
        SolverVariable r111 = r51.a(r42.D);
    L238:
        ConstraintWidget r43 = this.M;
        if (r43 == null) goto L241;
        SolverVariable r44 = r51.a(r43.B);
    L242:
        boolean r213 = this.h[0];
        DimensionBehaviour[] r45 = this.L;
        DimensionBehaviour r312 = r45[0];
        ConstraintAnchor r46 = this.B;
        ConstraintAnchor r47 = this.D;
        int r48 = this.R;
        int r49 = this.Y;
        int r410 = this.aI[0];
        float r50 = this.ab;
        if (r45[1] != DimensionBehaviour.MATCH_CONSTRAINT) goto L245;
        boolean r411 = true;
    L246:
        a(r51, true, r5, r6, r213, r44, r111, r312, r210, r46, r47, r48, r211, r49, r410, r50, r110, r411, r29, r28, r212, r32, r31, this.q, this.r, this.s, r310);
        goto L249
    L245:
        r411 = false;
        goto L246
    L241:
        r44 = null;
        goto L242
    L237:
        r111 = null;
    L249:
        if (r52 == false) goto L266;
        m r53 = this.g;
        if (r53 == null) goto L266;
        if (r53.j.j == false) goto L266;
        if (this.g.k.j == false) goto L266;
        com.obric.oui.constraintlayout.core.d r112 = r51;
        SolverVariable r113 = r11;
        r112.a(r113, this.g.j.g);
        SolverVariable r114 = r10;
        r112.a(r114, this.g.k.g);
        SolverVariable r54 = r9;
        r112.a(r54, this.g.f13629a.g);
        ConstraintWidget r55 = this.M;
        if (r55 == null) goto L264;
        if (r28 == true) goto L264;
        if (r6 == false) goto L264;
        char r115 = 1;
        if (this.h[1] == false) goto L263;
        int r56 = 8;
        int r116 = 0;
        r112.a(r112.a(r55.E), r114, 0, 8);
    L265:
        int r57 = r116;
        com.obric.oui.constraintlayout.core.d r117 = r112;
    L268:
        if (this.m != 2) goto L270;
        int r58 = r116;
    L271:
        if (r58 == 0) goto L312;
        if (this.aE == true) goto L312;
        if (this.L[r115] == DimensionBehaviour.WRAP_CONTENT) goto L277;
    L279:
        boolean r59 = r116;
    L280:
        if (r59 == 0) goto L282;
        r30 = r116;
    L282:
        ConstraintWidget r60 = this.M;
        if (r60 == null) goto L285;
        SolverVariable r61 = r117.a(r60.E);
    L286:
        ConstraintWidget r62 = this.M;
        if (r62 == null) goto L289;
        SolverVariable r63 = r117.a(r62.C);
    L291:
        if (this.X > 0) goto L295;
        if (this.aR == r56) goto L295;
    L305:
        boolean r214 = r310;
    L306:
        boolean r64 = this.h[r115];
        DimensionBehaviour[] r65 = this.L;
        DimensionBehaviour r66 = r65[r115];
        ConstraintAnchor r67 = this.C;
        ConstraintAnchor r68 = this.E;
        int r69 = this.S;
        int r70 = this.Z;
        int r118 = this.aI[r115];
        float r119 = this.ac;
        if (r65[0] != DimensionBehaviour.MATCH_CONSTRAINT) goto L309;
        boolean r120 = true;
    L310:
        a(r51, false, r6, r5, r64, r63, r61, r66, r59, r67, r68, r69, r30, r70, r118, r119, r39, r120, r28, r29, r311, r31, r32, this.t, this.u, this.v, r214);
        goto L312
    L309:
        r120 = false;
    L295:
        if (this.F.c == null) goto L301;
        r117.c(r54, r113, S(), r56);
        r117.c(r54, r117.a(this.F.c), this.F.i(), r56);
        if (r6 == 0) goto L299;
        r117.a(r61, r117.a(this.E), r116, 5);
    L299:
        r214 = r116;
        goto L306
    L301:
        if (this.aR != r56) goto L303;
        int r71 = this.F.i();
    L304:
        r117.c(r54, r113, r71, r56);
        goto L305
    L303:
        r71 = S();
        goto L304
    L289:
        r63 = null;
        goto L291
    L285:
        r61 = null;
        goto L286
    L277:
        if (ZeusTransformUtils.instanceOf(this, d.class) == false) goto L279;
        r59 = r115;
    L312:
        if (r34 == false) goto L318;
        int r72 = 8;
        ConstraintWidget r73 = this;
        int r74 = r73.y;
        float r75 = r73.z;
        if (r74 != 1) goto L316;
        SolverVariable r76 = r114;
        SolverVariable r77 = r113;
        SolverVariable r78 = r12;
        SolverVariable r79 = r13;
    L317:
        r51.a(r76, r77, r78, r79, r75, r72);
        ConstraintWidget r80 = r73;
    L320:
        if (r80.I.l() == false) goto L323;
        r51.a(r80, r80.I.j().h(), (float) Math.toRadians(r80.A + 90.0f), r80.I.i());
    L323:
        r80.aD = false;
        r80.aE = false;
        if (com.obric.oui.constraintlayout.core.d.o == null) goto L327;
        com.obric.oui.constraintlayout.core.d.o.N = r51.g();
        com.obric.oui.constraintlayout.core.d.o.O = r51.h();
        return;
    L327:
        return;
    L316:
        r72 = 8;
        r76 = r12;
        r77 = r13;
        r78 = r114;
        r79 = r113;
        goto L317
    L318:
        r80 = this;
        goto L320
    L270:
        r58 = r57;
        goto L271
    L263:
        r56 = 8;
        r116 = 0;
    L264:
        r56 = 8;
        r116 = 0;
        r115 = 1;
    L266:
        r117 = r51;
        r54 = r9;
        r114 = r10;
        r113 = r11;
        r56 = 8;
        r116 = 0;
        r115 = 1;
        r57 = 1;
        goto L268
    L212:
        r211 = r33;
        goto L213
    L207:
        if (ZeusTransformUtils.instanceOf(this, d.class) == false) goto L209;
        r210 = true;
    L203:
        r39 = false;
    L195:
        r110 = true;
        goto L198
    L196:
        r37 = -1;
        goto L197
    L151:
        if (this.aR == 8) goto L187;
        if (this.L[0] != DimensionBehaviour.MATCH_CONSTRAINT) goto L157;
        if (r25 != 0) goto L157;
        r25 = 3;
    L157:
        if (this.L[1] != DimensionBehaviour.MATCH_CONSTRAINT) goto L161;
        if (r26 != 0) goto L161;
        r26 = 3;
    L161:
        if (this.L[0] == DimensionBehaviour.MATCH_CONSTRAINT) goto L163;
    L168:
        int r81 = 3;
    L170:
        if (this.L[0] != DimensionBehaviour.MATCH_CONSTRAINT) goto L177;
        if (r25 != r81) goto L177;
        this.y = 0;
        r33 = (int) (this.z * this.O);
        r30 = r20;
        r31 = r26;
        if (this.L[1] == DimensionBehaviour.MATCH_CONSTRAINT) goto L175;
        r32 = 4;
        goto L189
    L175:
        r32 = r25;
        r34 = true;
    L177:
        if (this.L[1] == DimensionBehaviour.MATCH_CONSTRAINT) goto L179;
    L186:
        r30 = r20;
        r31 = r26;
        r32 = r25;
        r33 = r27;
        r34 = true;
        goto L190
    L179:
        if (r26 != 3) goto L186;
        this.y = 1;
        if (this.Q != (-1)) goto L183;
        this.z = 1.0f / this.z;
    L183:
        r20 = (int) (this.z * this.N);
        if (this.L[0] == DimensionBehaviour.MATCH_CONSTRAINT) goto L186;
        r30 = r20;
        r32 = r25;
        r31 = 4;
        goto L188
    L163:
        if (this.L[1] != DimensionBehaviour.MATCH_CONSTRAINT) goto L168;
        r81 = 3;
        if (r25 != 3) goto L170;
        if (r26 != 3) goto L170;
        a(r5, r6, r22, r23);
        goto L186
    L147:
        r23 = false;
        goto L148
    L143:
        r22 = false;
        goto L145
    L105:
        if (a(0) == false) goto L107;
        ((d) ZeusTransformUtils.preCheckCast(this.M, d.class, "com.obric.memorydata.plugin")).a(this, 0);
        boolean r82 = true;
    L109:
        if (a(1) == false) goto L111;
        ((d) ZeusTransformUtils.preCheckCast(this.M, d.class, r8)).a(this, 1);
        boolean r83 = true;
    L112:
        if (r82 == true) goto L121;
        if (r5 == false) goto L121;
        if (this.aR == 8) goto L121;
        if (this.B.c != null) goto L121;
        if (this.D.c != null) goto L121;
        r51.a(r51.a(this.M.D), r12, 0, 1);
    L121:
        if (r83 == true) goto L132;
        if (r6 == false) goto L132;
        if (this.aR == 8) goto L132;
        if (this.C.c != null) goto L132;
        if (this.E.c != null) goto L132;
        if (this.F != null) goto L132;
        r51.a(r51.a(this.M.E), r10, 0, 1);
    L132:
        r29 = r82;
        r28 = r83;
        goto L134
    L111:
        r83 = ad();
        goto L112
    L107:
        r82 = ac();
        goto L109
    L62:
        if (this.aE == false) goto L66;
    L37:
        if (this.aE == false) goto L66;
    L26:
        if (this.aS == true) goto L34;
        if (o() == true) goto L34;
        boolean[] r84 = this.aO;
        if (r84[0] == true) goto L34;
        if (r84[1] == true) goto L34;
        return;
    L20:
        r6 = r3;
        r5 = false;
        goto L24
    L21:
        r5 = r1;
        r6 = false;
        goto L24
    L12:
        if (r2.L[1] != DimensionBehaviour.WRAP_CONTENT) goto L14;
        r3 = true;
        goto L15
    L6:
        if (r0.L[0] != DimensionBehaviour.WRAP_CONTENT) goto L8;
        r1 = true;
    L22:
        r5 = false;
        r6 = false;
        goto L24
    }

    public void a(ConstraintAnchor.Type r2, ConstraintWidget r3, ConstraintAnchor.Type r4) {
        a(r2, r3, r4, 0);
    }

    public void a(ConstraintAnchor.Type r4, ConstraintWidget r5, ConstraintAnchor.Type r6, int r7) {
        if (r4 != ConstraintAnchor.Type.CENTER) goto L46;
        if (r6 != ConstraintAnchor.Type.CENTER) goto L32;
        ConstraintAnchor r8 = a(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor r9 = a(ConstraintAnchor.Type.RIGHT);
        ConstraintAnchor r10 = a(ConstraintAnchor.Type.TOP);
        ConstraintAnchor r0 = a(ConstraintAnchor.Type.BOTTOM);
        boolean r2 = true;
        if (r8 != null) goto L9;
    L10:
        if (r9 != null) goto L12;
    L14:
        a(ConstraintAnchor.Type.LEFT, r5, ConstraintAnchor.Type.LEFT, 0);
        a(ConstraintAnchor.Type.RIGHT, r5, ConstraintAnchor.Type.RIGHT, 0);
        boolean r11 = true;
    L15:
        if (r10 != null) goto L17;
    L18:
        if (r0 != null) goto L20;
    L22:
        a(ConstraintAnchor.Type.TOP, r5, ConstraintAnchor.Type.TOP, 0);
        a(ConstraintAnchor.Type.BOTTOM, r5, ConstraintAnchor.Type.BOTTOM, 0);
    L23:
        if (r11 == false) goto L26;
        if (r2 == false) goto L26;
        ConstraintAnchor r3 = a(ConstraintAnchor.Type.CENTER);
        ConstraintAnchor.Type r12 = ConstraintAnchor.Type.CENTER;
    L28:
        ConstraintAnchor r13 = r5.a(r12);
    L44:
        r3.a(r13, 0);
        return;
    L26:
        if (r11 == false) goto L29;
        r3 = a(ConstraintAnchor.Type.CENTER_X);
        r12 = ConstraintAnchor.Type.CENTER_X;
        goto L28
    L29:
        if (r2 == false) goto L105;
        r3 = a(ConstraintAnchor.Type.CENTER_Y);
        r12 = ConstraintAnchor.Type.CENTER_Y;
        goto L28
    L105:
        return;
    L20:
        if (r0.l() == false) goto L22;
    L21:
        r2 = false;
        goto L23
    L17:
        if (r10.l() == true) goto L21;
    L12:
        if (r9.l() == false) goto L14;
    L13:
        r11 = false;
        goto L15
    L9:
        if (r8.l() == true) goto L13;
    L32:
        if (r6 != ConstraintAnchor.Type.LEFT) goto L34;
    L41:
        a(ConstraintAnchor.Type.LEFT, r5, r6, 0);
        ConstraintAnchor.Type r14 = ConstraintAnchor.Type.RIGHT;
    L42:
        a(r14, r5, r6, 0);
        ConstraintAnchor.Type r15 = ConstraintAnchor.Type.CENTER;
    L43:
        r3 = a(r15);
        r13 = r5.a(r6);
        goto L44
    L34:
        if (r6 == ConstraintAnchor.Type.RIGHT) goto L41;
        if (r6 != ConstraintAnchor.Type.TOP) goto L39;
    L40:
        a(ConstraintAnchor.Type.TOP, r5, r6, 0);
        r14 = ConstraintAnchor.Type.BOTTOM;
        goto L42
    L39:
        if (r6 == ConstraintAnchor.Type.BOTTOM) goto L40;
        return;
    L46:
        if (r4 != ConstraintAnchor.Type.CENTER_X) goto L53;
        if (r6 != ConstraintAnchor.Type.LEFT) goto L50;
    L51:
        ConstraintAnchor r16 = a(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor r17 = r5.a(r6);
        ConstraintAnchor r18 = a(ConstraintAnchor.Type.RIGHT);
        r16.a(r17, 0);
        r18.a(r17, 0);
        a(ConstraintAnchor.Type.CENTER_X).a(r17, 0);
        return;
    L50:
        if (r6 == ConstraintAnchor.Type.RIGHT) goto L51;
    L53:
        if (r4 != ConstraintAnchor.Type.CENTER_Y) goto L60;
        if (r6 != ConstraintAnchor.Type.TOP) goto L57;
    L58:
        r13 = r5.a(r6);
        a(ConstraintAnchor.Type.TOP).a(r13, 0);
        a(ConstraintAnchor.Type.BOTTOM).a(r13, 0);
        r3 = a(ConstraintAnchor.Type.CENTER_Y);
        goto L44
    L57:
        if (r6 == ConstraintAnchor.Type.BOTTOM) goto L58;
    L60:
        if (r4 != ConstraintAnchor.Type.CENTER_X) goto L65;
        if (r6 != ConstraintAnchor.Type.CENTER_X) goto L65;
        a(ConstraintAnchor.Type.LEFT).a(r5.a(ConstraintAnchor.Type.LEFT), 0);
        a(ConstraintAnchor.Type.RIGHT).a(r5.a(ConstraintAnchor.Type.RIGHT), 0);
        r15 = ConstraintAnchor.Type.CENTER_X;
    L65:
        if (r4 == ConstraintAnchor.Type.CENTER_Y) goto L67;
    L69:
        ConstraintAnchor r1 = a(r4);
        ConstraintAnchor r19 = r5.a(r6);
        if (r1.a(r19) == true) goto L72;
        return;
    L72:
        if (r4 != ConstraintAnchor.Type.BASELINE) goto L79;
        ConstraintAnchor r20 = a(ConstraintAnchor.Type.TOP);
        ConstraintAnchor r21 = a(ConstraintAnchor.Type.BOTTOM);
        if (r20 == null) goto L76;
        r20.k();
    L76:
        if (r21 != null) goto L93;
    L103:
        r1.a(r19, r7);
        return;
    L93:
        r21.k();
        goto L103
    L79:
        if (r4 != ConstraintAnchor.Type.TOP) goto L81;
    L94:
        ConstraintAnchor r22 = a(ConstraintAnchor.Type.BASELINE);
        if (r22 == null) goto L97;
        r22.k();
    L97:
        ConstraintAnchor r23 = a(ConstraintAnchor.Type.CENTER);
        if (r23.j() == r19) goto L100;
        r23.k();
    L100:
        ConstraintAnchor r24 = a(r4).m();
        r21 = a(ConstraintAnchor.Type.CENTER_Y);
        if (r21.l() == false) goto L103;
    L92:
        r24.k();
        goto L93
    L81:
        if (r4 == ConstraintAnchor.Type.BOTTOM) goto L94;
        if (r4 != ConstraintAnchor.Type.LEFT) goto L86;
    L87:
        ConstraintAnchor r25 = a(ConstraintAnchor.Type.CENTER);
        if (r25.j() == r19) goto L90;
        r25.k();
    L90:
        r24 = a(r4).m();
        r21 = a(ConstraintAnchor.Type.CENTER_X);
        if (r21.l() == false) goto L103;
    L86:
        if (r4 != ConstraintAnchor.Type.RIGHT) goto L103;
    L67:
        if (r6 != ConstraintAnchor.Type.CENTER_Y) goto L69;
        a(ConstraintAnchor.Type.TOP).a(r5.a(ConstraintAnchor.Type.TOP), 0);
        a(ConstraintAnchor.Type.BOTTOM).a(r5.a(ConstraintAnchor.Type.BOTTOM), 0);
        r15 = ConstraintAnchor.Type.CENTER_Y;
        goto L43
    }

    public void a(ConstraintAnchor.Type r1, ConstraintWidget r2, ConstraintAnchor.Type r3, int r4, int r5) {
        a(r1).a(r2.a(r3), r4, r5, true);
    }

    public void a(ConstraintAnchor r2, ConstraintAnchor r3, int r4) {
        if (r2.h() != this) goto L6;
        a(r2.getType(), r3.h(), r3.getType(), r4);
        return;
    }

    public void a(DimensionBehaviour r2) {
        this.L[0] = r2;
    }

    public void a(ConstraintWidget r7, float r8, int r9) {
        a(ConstraintAnchor.Type.CENTER, r7, ConstraintAnchor.Type.CENTER, r9, 0);
        this.A = r8;
    }

    public void a(ConstraintWidget r9, HashMap<ConstraintWidget, ConstraintWidget> r10) {
        this.l = r9.l;
        this.m = r9.m;
        this.n = r9.n;
        this.o = r9.o;
        int[] r1 = this.p;
        int[] r2 = r9.p;
        r1[0] = r2[0];
        r1[1] = r2[1];
        this.q = r9.q;
        this.r = r9.r;
        this.t = r9.t;
        this.u = r9.u;
        this.v = r9.v;
        this.w = r9.w;
        this.x = r9.x;
        this.y = r9.y;
        this.z = r9.z;
        int[] r3 = r9.aI;
        this.aI = Arrays.copyOf(r3, r3.length);
        this.A = r9.A;
        this.aJ = r9.aJ;
        this.aK = r9.aK;
        this.B.k();
        this.C.k();
        this.D.k();
        this.E.k();
        this.F.k();
        this.G.k();
        this.H.k();
        this.I.k();
        this.L = (DimensionBehaviour[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(this.L, 2), DimensionBehaviour[].class, "com.obric.memorydata.plugin");
        ConstraintWidget r4 = null;
        if (this.M != null) goto L5;
        ConstraintWidget r5 = null;
    L6:
        this.M = r5;
        this.N = r9.N;
        this.O = r9.O;
        this.P = r9.P;
        this.Q = r9.Q;
        this.R = r9.R;
        this.S = r9.S;
        this.T = r9.T;
        this.U = r9.U;
        this.V = r9.V;
        this.W = r9.W;
        this.X = r9.X;
        this.Y = r9.Y;
        this.Z = r9.Z;
        this.ab = r9.ab;
        this.ac = r9.ac;
        this.aP = r9.aP;
        this.aQ = r9.aQ;
        this.aR = r9.aR;
        this.aS = r9.aS;
        this.aT = r9.aT;
        this.aU = r9.aU;
        this.ad = r9.ad;
        this.ae = r9.ae;
        this.af = r9.af;
        this.ag = r9.ag;
        this.ah = r9.ah;
        this.ai = r9.ai;
        this.aj = r9.aj;
        this.ak = r9.ak;
        this.al = r9.al;
        this.am = r9.am;
        this.ao = r9.ao;
        this.ap = r9.ap;
        this.aq = r9.aq;
        this.ar = r9.ar;
        float[] r6 = this.as;
        float[] r7 = r9.as;
        r6[0] = r7[0];
        r6[1] = r7[1];
        ConstraintWidget[] r8 = this.at;
        ConstraintWidget[] r11 = r9.at;
        r8[0] = r11[0];
        r8[1] = r11[1];
        ConstraintWidget[] r12 = this.au;
        ConstraintWidget[] r13 = r9.au;
        r12[0] = r13[0];
        r12[1] = r13[1];
        ConstraintWidget r14 = r9.av;
        if (r14 != null) goto L9;
        ConstraintWidget r15 = null;
    L10:
        this.av = r15;
        ConstraintWidget r16 = r9.aw;
        if (r16 == null) goto L14;
        r4 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r10.get(r16), ConstraintWidget.class, "com.obric.memorydata.plugin");
    L14:
        this.aw = r4;
        return;
    L9:
        r15 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r10.get(r14), ConstraintWidget.class, "com.obric.memorydata.plugin");
        goto L10
    L5:
        r5 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r10.get(r9.M), ConstraintWidget.class, "com.obric.memorydata.plugin");
        goto L6
    }

    public void a(d r9, com.obric.oui.constraintlayout.core.d r10, HashSet<ConstraintWidget> r11, int r12, boolean r13) {
        if (r13 == false) goto L8;
        if (r11.contains(this) == true) goto L6;
        return;
    L6:
        i.a(r9, r10, this);
        r11.remove(this);
        a(r10, r9.b(64));
    L8:
        if (r12 != 0) goto L21;
        HashSet<ConstraintAnchor> r0 = this.B.a();
        if (r0 == null) goto L15;
        Iterator<ConstraintAnchor> r1 = r0.iterator();
    L13:
        if (r1.hasNext() == false) goto L15;
        ((ConstraintAnchor) ZeusTransformUtils.preCheckCast(r1.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).f13603a.a(r9, r10, r11, r12, true);
    L15:
        HashSet<ConstraintAnchor> r8 = this.D.a();
        if (r8 == null) goto L39;
        Iterator<ConstraintAnchor> r14 = r8.iterator();
    L19:
        if (r14.hasNext() == false) goto L46;
        ((ConstraintAnchor) ZeusTransformUtils.preCheckCast(r14.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).f13603a.a(r9, r10, r11, r12, true);
        goto L19
    L46:
        return;
    L39:
        return;
    L21:
        HashSet<ConstraintAnchor> r2 = this.C.a();
        if (r2 == null) goto L27;
        Iterator<ConstraintAnchor> r3 = r2.iterator();
    L25:
        if (r3.hasNext() == false) goto L27;
        ((ConstraintAnchor) ZeusTransformUtils.preCheckCast(r3.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).f13603a.a(r9, r10, r11, r12, true);
    L27:
        HashSet<ConstraintAnchor> r4 = this.E.a();
        if (r4 == null) goto L33;
        Iterator<ConstraintAnchor> r5 = r4.iterator();
    L31:
        if (r5.hasNext() == false) goto L33;
        ((ConstraintAnchor) ZeusTransformUtils.preCheckCast(r5.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).f13603a.a(r9, r10, r11, r12, true);
    L33:
        HashSet<ConstraintAnchor> r15 = this.F.a();
        if (r15 == null) goto L45;
        Iterator<ConstraintAnchor> r16 = r15.iterator();
    L37:
        if (r16.hasNext() == false) goto L47;
        ((ConstraintAnchor) ZeusTransformUtils.preCheckCast(r16.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).f13603a.a(r9, r10, r11, r12, true);
        goto L37
    L47:
        return;
    }

    public void a(Object r1) {
        this.aP = r1;
    }

    public void a(String r1) {
        this.aT = r1;
    }

    public void a(StringBuilder r16) {
        r16.append("  " + this.k + ":{\n");
        r16.append("    actualWidth:" + this.N);
        r16.append("\n");
        r16.append("    actualHeight:" + this.O);
        r16.append("\n");
        r16.append("    actualLeft:" + this.R);
        r16.append("\n");
        r16.append("    actualTop:" + this.S);
        r16.append("\n");
        a(r16, "left", this.B);
        a(r16, "top", this.C);
        a(r16, "right", this.D);
        a(r16, "bottom", this.E);
        a(r16, "baseline", this.F);
        a(r16, "centerX", this.G);
        a(r16, "centerY", this.H);
        a(r16, "    width", this.N, this.Y, this.aI[0], this.aB, this.q, this.n, this.s, this.L[0], this.as[0]);
        a(r16, "    height", this.O, this.Z, this.aI[1], this.aC, this.t, this.o, this.v, this.L[1], this.as[1]);
        a(r16, "    dimensionRatio", this.P, this.Q);
        a(r16, "    horizontalBias", this.ab, aa);
        a(r16, "    verticalBias", this.ac, aa);
        a(r16, "    horizontalChainStyle", this.ao, 0);
        a(r16, "    verticalChainStyle", this.ap, 0);
        r16.append("  }");
    }

    public void a(boolean r8, boolean r9) {
        boolean r10 = r8 & this.f.g();
        boolean r11 = r9 & this.g.g();
        int r0 = this.f.j.g;
        int r1 = this.g.j.g;
        int r2 = this.f.k.g;
        int r3 = this.g.k.g;
        int r5 = r3 - r1;
        if ((r2 - r0) < 0) goto L15;
        if (r5 < 0) goto L15;
        if (r0 == Integer.MIN_VALUE) goto L15;
        if (r0 == Integer.MAX_VALUE) goto L15;
        if (r1 == Integer.MIN_VALUE) goto L15;
        if (r1 == Integer.MAX_VALUE) goto L15;
        if (r2 == Integer.MIN_VALUE) goto L15;
        if (r2 == Integer.MAX_VALUE) goto L15;
        if (r3 == Integer.MIN_VALUE) goto L15;
        if (r3 == Integer.MAX_VALUE) goto L15;
    L16:
        int r4 = r2 - r0;
        int r6 = r3 - r1;
        if (r10 == false) goto L19;
        this.R = r0;
    L19:
        if (r11 == false) goto L22;
        this.S = r1;
    L22:
        if (this.aR != 8) goto L25;
        this.N = 0;
        this.O = 0;
        return;
    L25:
        if (r10 == true) goto L27;
    L34:
        if (r11 == true) goto L36;
        return;
    L36:
        if (this.L[1] != DimensionBehaviour.FIXED) goto L40;
        int r12 = this.O;
        if (r6 >= r12) goto L40;
        r6 = r12;
    L40:
        this.O = r6;
        int r13 = this.Z;
        if (r6 >= r13) goto L45;
        this.O = r13;
        return;
    L45:
        return;
    L27:
        if (this.L[0] != DimensionBehaviour.FIXED) goto L31;
        int r14 = this.N;
        if (r4 >= r14) goto L31;
        r4 = r14;
    L31:
        this.N = r4;
        int r15 = this.Y;
        if (r4 >= r15) goto L34;
        this.N = r15;
    L15:
        r0 = 0;
        r1 = 0;
        r2 = 0;
        r3 = 0;
        goto L16
    }

    public void a(boolean r4, boolean r5, boolean r6, boolean r7) {
        if (this.y != (-1)) goto L13;
        if (r6 == false) goto L7;
        if (r7 == true) goto L7;
        this.y = 0;
    L7:
        if (r6 == true) goto L13;
        if (r7 == false) goto L13;
        this.y = 1;
        if (this.Q != (-1)) goto L13;
        this.z = 1.0f / this.z;
    L13:
        if (this.y != 0) goto L20;
        if (this.C.l() == true) goto L17;
    L18:
        this.y = 1;
    L27:
        if (this.y != (-1)) goto L47;
        if (this.C.l() == false) goto L37;
        if (this.E.l() == false) goto L37;
        if (this.B.l() == false) goto L37;
        if (this.D.l() == true) goto L47;
    L37:
        if (this.C.l() == false) goto L42;
        if (this.E.l() == false) goto L42;
        this.y = 0;
    L42:
        if (this.B.l() == false) goto L47;
        if (this.D.l() == false) goto L47;
        this.z = 1.0f / this.z;
        this.y = 1;
    L47:
        if (this.y != (-1)) goto L58;
        int r8 = this.q;
        if (r8 > 0) goto L51;
    L53:
        if (r8 == 0) goto L55;
        return;
    L55:
        if (this.t <= 0) goto L61;
        this.z = 1.0f / this.z;
        this.y = 1;
        return;
    L61:
        return;
    L51:
        if (this.t != 0) goto L53;
        this.y = 0;
        return;
    L58:
        return;
    L17:
        if (this.E.l() == false) goto L18;
    L20:
        if (this.y != 1) goto L27;
        if (this.B.l() == true) goto L24;
    L25:
        this.y = 0;
        goto L27
    L24:
        if (this.D.l() == true) goto L27;
        goto L25
    }

    public boolean a() {
        if (this.aR == 8) goto L5;
        return true;
    L5:
        return false;
    }

    public void a_(ConstraintWidget r1) {
        this.M = r1;
    }

    public DimensionBehaviour aa() {
        return this.L[0];
    }

    public DimensionBehaviour ab() {
        return this.L[1];
    }

    public boolean ac() {
        if (this.B.c == null) goto L7;
        if (this.B.c.c != this.B) goto L7;
        return true;
    L7:
        if (this.D.c != null) goto L9;
        return false;
    L9:
        if (this.D.c.c != this.D) goto L15;
        return true;
    L15:
        return false;
    }

    public boolean ad() {
        if (this.C.c == null) goto L7;
        if (this.C.c.c != this.C) goto L7;
        return true;
    L7:
        if (this.E.c != null) goto L9;
        return false;
    L9:
        if (this.E.c.c != this.E) goto L15;
        return true;
    L15:
        return false;
    }

    boolean ae() {
        if (ZeusTransformUtils.instanceOf(this, k.class) == false) goto L5;
    L8:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(this, f.class) == true) goto L8;
        return false;
    }

    public void b(float r1) {
        this.ac = r1;
    }

    public void b(int r2, int r3) {
        if (this.aE == false) goto L5;
        return;
    L5:
        this.C.a(r2);
        this.E.a(r3);
        this.S = r2;
        this.O = r3 - r2;
        if (this.aJ == false) goto L8;
        this.F.a(r2 + this.X);
    L8:
        this.aE = true;
    }

    public void b(int r1, int r2, int r3, float r4) {
        this.o = r1;
        this.t = r2;
        if (r3 != Integer.MAX_VALUE) goto L5;
        r3 = 0;
    L5:
        this.u = r3;
        this.v = r4;
        if (r4 > 0.0f) goto L8;
        return;
    L8:
        if (r4 >= 1.0f) goto L13;
        if (r1 != 0) goto L14;
        this.o = 2;
        return;
    L14:
        return;
    }

    public void b(com.obric.oui.constraintlayout.core.d r6, boolean r7) {
        int r0 = r6.b(this.B);
        int r1 = r6.b(this.C);
        int r2 = r6.b(this.D);
        int r8 = r6.b(this.E);
        if (r7 == false) goto L11;
        com.obric.oui.constraintlayout.core.widgets.analyzer.k r3 = this.f;
        if (r3 == null) goto L11;
        if (r3.j.j == false) goto L11;
        if (this.f.k.j == false) goto L11;
        r0 = this.f.j.g;
        r2 = this.f.k.g;
    L11:
        if (r7 == false) goto L19;
        m r9 = this.g;
        if (r9 == null) goto L19;
        if (r9.j.j == false) goto L19;
        if (this.g.k.j == false) goto L19;
        r1 = this.g.j.g;
        r8 = this.g.k.g;
    L19:
        int r4 = r8 - r1;
        if ((r2 - r0) < 0) goto L32;
        if (r4 < 0) goto L32;
        if (r0 == Integer.MIN_VALUE) goto L32;
        if (r0 == Integer.MAX_VALUE) goto L32;
        if (r1 == Integer.MIN_VALUE) goto L32;
        if (r1 == Integer.MAX_VALUE) goto L32;
        if (r2 == Integer.MIN_VALUE) goto L32;
        if (r2 == Integer.MAX_VALUE) goto L32;
        if (r8 == Integer.MIN_VALUE) goto L32;
        if (r8 == Integer.MAX_VALUE) goto L32;
    L33:
        a(r0, r1, r2, r8);
        return;
    L32:
        r8 = 0;
        r0 = 0;
        r1 = 0;
        r2 = 0;
        goto L33
    }

    public void b(DimensionBehaviour r2) {
        this.L[1] = r2;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0084 -> B:39:0x0085). Please report as a decompilation issue!!! */
    public void b(String r9) {
        int r0 = 0;
        if (r9 != null) goto L5;
    L43:
        this.P = 0.0f;
        return;
    L5:
        if (r9.length() == 0) goto L43;
        int r1 = -1;
        int r2 = r9.length();
        int r3 = r9.indexOf(44);
        int r4 = 0;
        if (r3 > 0) goto L10;
    L18:
        int r5 = r9.indexOf(58);
        if (r5 >= 0) goto L21;
    L34:
        String r10 = r9.substring(r4);
        if (r10.length() <= 0) goto L38;
        float r11 = Float.parseFloat(r10);     // Catch: NumberFormatException -> L45
    L39:
        r0 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1));
        if (r0 <= 0) goto L48;
        this.P = r11;
        this.Q = r1;
        return;
    L48:
        return;
    L21:
        if (r5 >= (r2 - 1)) goto L34;
        String r6 = r9.substring(r4, r5);
        String r12 = r9.substring(r5 + 1);
        if (r6.length() <= 0) goto L38;
        if (r12.length() <= 0) goto L38;
        float r7 = Float.parseFloat(r6);     // Catch: NumberFormatException -> L45
        float r13 = Float.parseFloat(r12);     // Catch: NumberFormatException -> L45
        if (r7 <= 0.0f) goto L38;
        if (r13 <= 0.0f) goto L38;
        if (r1 != 1) goto L32;
        r11 = Math.abs(r13 / r7);     // Catch: NumberFormatException -> L45
        goto L39
    L32:
        r11 = Math.abs(r7 / r13);     // Catch: NumberFormatException -> L45
    L38:
        r11 = r0;
        goto L39
    L10:
        if (r3 >= (r2 - 1)) goto L18;
        String r8 = r9.substring(0, r3);
        if (r8.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST) == false) goto L15;
        r1 = 0;
    L17:
        r4 = r3 + 1;
        goto L18
    L15:
        if (r8.equalsIgnoreCase(com.tom_roush.pdfbox.pdmodel.a.d.i.n) == false) goto L17;
        r1 = 1;
        goto L17
    }

    public void b(boolean r1) {
        this.aL = r1;
    }

    public WidgetRun c(int r2) {
        if (r2 != 0) goto L6;
        return this.f;
    L6:
        if (r2 == 1) goto L8;
        return null;
    L8:
        return this.g;
    }

    public void c(float r2) {
        this.as[0] = r2;
    }

    public void c(boolean r1) {
        this.aJ = r1;
    }

    public boolean c(int r4, int r5) {
        if (r4 != 0) goto L18;
        if (this.B.c != null) goto L7;
    L30:
        return false;
    L7:
        if (this.B.c.f() == false) goto L30;
        if (this.D.c == null) goto L30;
        if (this.D.c.f() == false) goto L30;
        if (((this.D.c.d() - this.D.i()) - (this.B.c.d() + this.B.i())) < r5) goto L16;
        return true;
    L16:
        return false;
    L18:
        if (this.C.c == null) goto L30;
        if (this.C.c.f() == false) goto L30;
        if (this.E.c == null) goto L30;
        if (this.E.c.f() == false) goto L30;
        if (((this.E.c.d() - this.E.i()) - (this.C.c.d() + this.C.i())) < r5) goto L29;
        return true;
    L29:
        return false;
    }

    public void d(float r2) {
        this.as[1] = r2;
    }

    public void d(int r2) {
        this.B.a(r2);
        this.R = r2;
    }

    public void d(int r1, int r2) {
        this.aM = r1;
        this.aN = r2;
        e(false);
    }

    public void d(boolean r1) {
        this.aK = r1;
    }

    public boolean d() {
        if (this.aD == false) goto L5;
    L10:
        return true;
    L5:
        if (this.B.f() == true) goto L7;
    L9:
        return false;
    L7:
        if (this.D.f() == false) goto L9;
        goto L9
    }

    public void e(int r2) {
        this.C.a(r2);
        this.S = r2;
    }

    public void e(int r1, int r2) {
        this.R = r1;
        this.S = r2;
    }

    public void e(boolean r1) {
        this.f13607a = r1;
    }

    public boolean e() {
        if (this.aE == false) goto L5;
    L10:
        return true;
    L5:
        if (this.C.f() == true) goto L7;
    L9:
        return false;
    L7:
        if (this.E.f() == false) goto L9;
        goto L9
    }

    public void f(int r4) {
        if (this.aJ == true) goto L5;
        return;
    L5:
        int r0 = r4 - this.X;
        int r1 = this.O + r0;
        this.S = r0;
        this.C.a(r0);
        this.E.a(r1);
        this.F.a(r4);
        this.aE = true;
    }

    public void f(int r1, int r2) {
        this.R = r1;
        int r3 = r2 - r1;
        this.N = r3;
        int r4 = this.Y;
        if (r3 >= r4) goto L6;
        this.N = r4;
        return;
    }

    public void f(boolean r1) {
        this.aS = r1;
    }

    public void g(int r1, int r2) {
        this.S = r1;
        int r3 = r2 - r1;
        this.O = r3;
        int r4 = this.Z;
        if (r3 >= r4) goto L6;
        this.O = r4;
        return;
    }

    public boolean g(int r5) {
        if (r5 != 0) goto L18;
        if (this.B.c == null) goto L7;
        int r6 = 1;
    L9:
        if (this.D.c == null) goto L11;
        int r4 = 1;
    L13:
        if ((r6 + r4) >= 2) goto L16;
        return true;
    L16:
        return false;
    L11:
        r4 = 0;
        goto L13
    L7:
        r6 = 0;
        goto L9
    L18:
        if (this.C.c == null) goto L20;
        int r7 = 1;
    L22:
        if (this.E.c == null) goto L24;
        int r3 = 1;
    L25:
        int r8 = r7 + r3;
        if (this.F.c == null) goto L28;
        int r9 = 1;
    L30:
        if ((r8 + r9) >= 2) goto L33;
        return true;
    L33:
        return false;
    L28:
        r9 = 0;
        goto L30
    L24:
        r3 = 0;
        goto L25
    L20:
        r7 = 0;
        goto L22
    }

    public String getType() {
        return this.aU;
    }

    public void h(int r2) {
        this.aI[0] = r2;
    }

    public void i(int r2) {
        this.aI[1] = r2;
    }

    public boolean i_() {
        return this.aF;
    }

    public boolean j(int r1) {
        return this.aO[r1];
    }

    public void k(int r2) {
        if (r2 >= 0) goto L4;
        return;
    L4:
        if (r2 > 3) goto L8;
        this.aH = r2;
        return;
    }

    public boolean k() {
        return this.aG;
    }

    public void l() {
        this.aF = true;
    }

    public void l(int r1) {
        this.aR = r1;
    }

    public int m(int r2) {
        if (r2 != 0) goto L6;
        return F();
    L6:
        if (r2 == 1) goto L8;
        return 0;
    L8:
        return G();
    }

    public void m() {
        this.aG = true;
    }

    public float n(int r2) {
        if (r2 != 0) goto L6;
        return this.ab;
    L6:
        if (r2 == 1) goto L8;
        return -1.0f;
    L8:
        return this.ac;
    }

    public void n() {
        int r0 = 0;
        this.aD = false;
        this.aE = false;
        this.aF = false;
        this.aG = false;
        int r1 = this.K.size();
    L3:
        if (r0 >= r1) goto L5;
        ((ConstraintAnchor) ZeusTransformUtils.preCheckCast(this.K.get(r0), ConstraintAnchor.class, "com.obric.memorydata.plugin")).e();
        r0 = r0 + 1;
        goto L3
    }

    public void o(int r1) {
        this.R = r1;
    }

    public boolean o() {
        int r0 = this.K.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (((ConstraintAnchor) ZeusTransformUtils.preCheckCast(this.K.get(r2), ConstraintAnchor.class, "com.obric.memorydata.plugin")).b() == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public void p(int r1) {
        this.S = r1;
    }

    public boolean p() {
        return this.aL;
    }

    public int q() {
        return this.aI[1];
    }

    public void q(int r2) {
        this.N = r2;
        int r0 = this.Y;
        if (r2 >= r0) goto L6;
        this.N = r0;
        return;
    }

    public int r() {
        return this.aI[0];
    }

    public void r(int r2) {
        this.O = r2;
        int r0 = this.Z;
        if (r2 >= r0) goto L6;
        this.O = r0;
        return;
    }

    public void s(int r1) {
        if (r1 >= 0) goto L4;
        r1 = 0;
    L4:
        this.Y = r1;
    }

    public boolean s() {
        return this.aK;
    }

    public void t(int r1) {
        if (r1 >= 0) goto L4;
        r1 = 0;
    L4:
        this.Z = r1;
    }

    public boolean t() {
        if (this.f13607a == true) goto L5;
    L7:
        return false;
    L5:
        if (this.aR == 8) goto L7;
        return true;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        String r3 = "";
        if (this.aU == null) goto L5;
        String r1 = "type: " + this.aU + " ";
    L6:
        StringBuilder r2 = r0.append(r1);
        if (this.aT == null) goto L10;
        r3 = "id: " + this.aT + " ";
    L10:
        return r2.append(r3).append("(").append(this.R).append(", ").append(this.S).append(") - (").append(this.N).append(" x ").append(this.O).append(")").toString();
    L5:
        r1 = "";
        goto L6
    }

    public int u() {
        return this.aM;
    }

    public void u(int r1) {
        this.X = r1;
        if (r1 <= 0) goto L5;
        boolean r2 = true;
    L6:
        this.aJ = r2;
        return;
    L5:
        r2 = false;
        goto L6
    }

    public int v() {
        return this.aN;
    }

    public void v(int r1) {
        this.ao = r1;
    }

    public void w() {
        this.B.k();
        this.C.k();
        this.D.k();
        this.E.k();
        this.F.k();
        this.G.k();
        this.H.k();
        this.I.k();
        this.M = null;
        this.A = Float.NaN;
        this.N = 0;
        this.O = 0;
        this.P = 0.0f;
        this.Q = -1;
        this.R = 0;
        this.S = 0;
        this.V = 0;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        float r3 = aa;
        this.ab = r3;
        this.ac = r3;
        this.L[0] = DimensionBehaviour.FIXED;
        this.L[1] = DimensionBehaviour.FIXED;
        this.aP = null;
        this.aQ = 0;
        this.aR = 0;
        this.aU = null;
        this.al = false;
        this.am = false;
        this.ao = 0;
        this.ap = 0;
        this.aq = false;
        this.ar = false;
        float[] r0 = this.as;
        r0[0] = -1.0f;
        r0[1] = -1.0f;
        this.l = -1;
        this.m = -1;
        int[] r1 = this.aI;
        r1[0] = Integer.MAX_VALUE;
        r1[1] = Integer.MAX_VALUE;
        this.n = 0;
        this.o = 0;
        this.s = 1.0f;
        this.v = 1.0f;
        this.r = Integer.MAX_VALUE;
        this.u = Integer.MAX_VALUE;
        this.q = 0;
        this.t = 0;
        this.i = false;
        this.y = -1;
        this.z = 1.0f;
        this.an = false;
        boolean[] r2 = this.h;
        r2[0] = true;
        r2[1] = true;
        this.aL = false;
        boolean[] r4 = this.aO;
        r4[0] = false;
        r4[1] = false;
        this.f13607a = true;
        int[] r5 = this.p;
        r5[0] = 0;
        r5[1] = 0;
        this.aB = -1;
        this.aC = -1;
    }

    public void w(int r1) {
        this.ap = r1;
    }

    public DimensionBehaviour x(int r2) {
        if (r2 != 0) goto L6;
        return aa();
    L6:
        if (r2 == 1) goto L8;
        return null;
    L8:
        return ab();
    }

    public boolean x() {
        if (this.L[0] == DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        return false;
    L5:
        if (this.L[1] == DimensionBehaviour.MATCH_CONSTRAINT) goto L7;
        return false;
    L7:
        return true;
    }

    public ConstraintWidget y(int r2) {
        if (r2 != 0) goto L10;
        if (this.B.c == null) goto L16;
        ConstraintAnchor r3 = this.B.c.c;
        ConstraintAnchor r1 = this.B;
        if (r3 == r1) goto L8;
        return null;
    L8:
        return r1.c.f13603a;
    L16:
        return null;
    L10:
        if (r2 == 1) goto L12;
        return null;
    L12:
        if (this.C.c == null) goto L20;
        ConstraintAnchor r4 = this.C.c.c;
        r1 = this.C;
        if (r4 == r1) goto L8;
        return null;
    L20:
        return null;
    }

    public boolean y() {
        if (this.aB == (-1)) goto L5;
    L8:
        return true;
    L5:
        if (this.aC != (-1)) goto L8;
        return false;
    }

    public ConstraintWidget z(int r2) {
        if (r2 != 0) goto L10;
        if (this.D.c == null) goto L16;
        ConstraintAnchor r3 = this.D.c.c;
        ConstraintAnchor r1 = this.D;
        if (r3 == r1) goto L8;
        return null;
    L8:
        return r1.c.f13603a;
    L16:
        return null;
    L10:
        if (r2 == 1) goto L12;
        return null;
    L12:
        if (this.E.c == null) goto L20;
        ConstraintAnchor r4 = this.E.c.c;
        r1 = this.E;
        if (r4 == r1) goto L8;
        return null;
    L20:
        return null;
    }

    public void z() {
        if (this.f != null) goto L6;
        this.f = new com.obric.oui.constraintlayout.core.widgets.analyzer.k(this);
    L6:
        if (this.g != null) goto L9;
        this.g = new m(this);
        return;
    }
}
