package com.obric.oui.constraintlayout.core.dsl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes5.dex */
public class Constraint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Constraint f13527a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static int f13528b;
    static Map<ChainMode, String> c;
    private ChainMode A;
    private Behaviour B;
    private Behaviour C;
    private int D;
    private int E;
    private int F;
    private int G;
    private float H;
    private float I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private String[] f13529J;
    private boolean K;
    private boolean L;
    String d;
    String e;
    private final String f;
    private b g;
    private b h;
    private c i;
    private c j;
    private b k;
    private b l;
    private c m;
    private int n;
    private int o;
    private float p;
    private float q;
    private String r;
    private String s;
    private int t;
    private float u;
    private int v;
    private int w;
    private float x;
    private float y;
    private ChainMode z;

    public static final enum Behaviour extends Enum<Behaviour> {
        private static final /* synthetic */ Behaviour[] $VALUES = null;
        public static final Behaviour PERCENT = null;
        public static final Behaviour RATIO = null;
        public static final Behaviour RESOLVED = null;
        public static final Behaviour SPREAD = null;
        public static final Behaviour WRAP = null;

        static {
            Behaviour r0 = new Behaviour("SPREAD", 0);
            SPREAD = r0;
            Behaviour r1 = new Behaviour("WRAP", 1);
            WRAP = r1;
            Behaviour r3 = new Behaviour("PERCENT", 2);
            PERCENT = r3;
            Behaviour r5 = new Behaviour("RATIO", 3);
            RATIO = r5;
            Behaviour r7 = new Behaviour("RESOLVED", 4);
            RESOLVED = r7;
            $VALUES = new Behaviour[]{r0, r1, r3, r5, r7};
        }

        private Behaviour(String r1, int r2) {
            super(r1, r2);
        }

        public static Behaviour valueOf(String r2) {
            return (Behaviour) ZeusTransformUtils.preCheckCast(Enum.valueOf(Behaviour.class, r2), Behaviour.class, "com.obric.memorydata.plugin");
        }

        public static Behaviour[] values() {
            return (Behaviour[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Behaviour[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum ChainMode extends Enum<ChainMode> {
        private static final /* synthetic */ ChainMode[] $VALUES = null;
        public static final ChainMode PACKED = null;
        public static final ChainMode SPREAD = null;
        public static final ChainMode SPREAD_INSIDE = null;

        static {
            ChainMode r0 = new ChainMode("SPREAD", 0);
            SPREAD = r0;
            ChainMode r1 = new ChainMode("SPREAD_INSIDE", 1);
            SPREAD_INSIDE = r1;
            ChainMode r3 = new ChainMode("PACKED", 2);
            PACKED = r3;
            $VALUES = new ChainMode[]{r0, r1, r3};
        }

        private ChainMode(String r1, int r2) {
            super(r1, r2);
        }

        public static ChainMode valueOf(String r2) {
            return (ChainMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(ChainMode.class, r2), ChainMode.class, "com.obric.memorydata.plugin");
        }

        public static ChainMode[] values() {
            return (ChainMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ChainMode[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum HSide extends Enum<HSide> {
        private static final /* synthetic */ HSide[] $VALUES = null;
        public static final HSide END = null;
        public static final HSide LEFT = null;
        public static final HSide RIGHT = null;
        public static final HSide START = null;

        static {
            HSide r0 = new HSide("LEFT", 0);
            LEFT = r0;
            HSide r1 = new HSide("RIGHT", 1);
            RIGHT = r1;
            HSide r3 = new HSide("START", 2);
            START = r3;
            HSide r5 = new HSide("END", 3);
            END = r5;
            $VALUES = new HSide[]{r0, r1, r3, r5};
        }

        private HSide(String r1, int r2) {
            super(r1, r2);
        }

        public static HSide valueOf(String r2) {
            return (HSide) ZeusTransformUtils.preCheckCast(Enum.valueOf(HSide.class, r2), HSide.class, "com.obric.memorydata.plugin");
        }

        public static HSide[] values() {
            return (HSide[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HSide[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum Side extends Enum<Side> {
        private static final /* synthetic */ Side[] $VALUES = null;
        public static final Side BASELINE = null;
        public static final Side BOTTOM = null;
        public static final Side END = null;
        public static final Side LEFT = null;
        public static final Side RIGHT = null;
        public static final Side START = null;
        public static final Side TOP = null;

        static {
            Side r0 = new Side("LEFT", 0);
            LEFT = r0;
            Side r1 = new Side("RIGHT", 1);
            RIGHT = r1;
            Side r3 = new Side("TOP", 2);
            TOP = r3;
            Side r5 = new Side("BOTTOM", 3);
            BOTTOM = r5;
            Side r7 = new Side("START", 4);
            START = r7;
            Side r9 = new Side("END", 5);
            END = r9;
            Side r11 = new Side("BASELINE", 6);
            BASELINE = r11;
            $VALUES = new Side[]{r0, r1, r3, r5, r7, r9, r11};
        }

        private Side(String r1, int r2) {
            super(r1, r2);
        }

        public static Side valueOf(String r2) {
            return (Side) ZeusTransformUtils.preCheckCast(Enum.valueOf(Side.class, r2), Side.class, "com.obric.memorydata.plugin");
        }

        public static Side[] values() {
            return (Side[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Side[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum VSide extends Enum<VSide> {
        private static final /* synthetic */ VSide[] $VALUES = null;
        public static final VSide BASELINE = null;
        public static final VSide BOTTOM = null;
        public static final VSide TOP = null;

        static {
            VSide r0 = new VSide("TOP", 0);
            TOP = r0;
            VSide r1 = new VSide("BOTTOM", 1);
            BOTTOM = r1;
            VSide r3 = new VSide("BASELINE", 2);
            BASELINE = r3;
            $VALUES = new VSide[]{r0, r1, r3};
        }

        private VSide(String r1, int r2) {
            super(r1, r2);
        }

        public static VSide valueOf(String r2) {
            return (VSide) ZeusTransformUtils.preCheckCast(Enum.valueOf(VSide.class, r2), VSide.class, "com.obric.memorydata.plugin");
        }

        public static VSide[] values() {
            return (VSide[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), VSide[].class, "com.obric.memorydata.plugin");
        }
    }

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Side f13530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        a f13531b;
        int c;
        int d;
        final /* synthetic */ Constraint e;

        a(Constraint r1, Side r2) {
            this.e = r1;
            this.f13531b = null;
            this.d = Integer.MIN_VALUE;
            this.f13530a = r2;
        }

        public String a() {
            return Constraint.a(this.e);
        }

        public void a(StringBuilder r2) {
            if (this.f13531b == null) goto L6;
            r2.append(this.f13530a.toString().toLowerCase()).append(ParameterizedMessage.ERROR_MSG_SEPARATOR).append(this).append(",\n");
            return;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("[");
            if (this.f13531b == null) goto L6;
            r0.append("'").append(this.f13531b.a()).append("',").append("'").append(this.f13531b.f13530a.toString().toLowerCase()).append("'");
        L6:
            if (this.c == 0) goto L9;
            r0.append(",").append(this.c);
        L9:
            if (this.d != Integer.MIN_VALUE) goto L11;
        L15:
            r0.append("]");
            return r0.toString();
        L11:
            if (this.c != 0) goto L13;
            StringBuilder r1 = r0.append(",0,");
        L14:
            r1.append(this.d);
            goto L15
        L13:
            r1 = r0.append(",");
            goto L14
        }
    }

    public class b extends a {
        final /* synthetic */ Constraint f;

        b(Constraint r1, HSide r2) {
            this.f = r1;
            super(r1, Side.valueOf(r2.name()));
        }
    }

    public class c extends a {
        final /* synthetic */ Constraint f;

        c(Constraint r1, VSide r2) {
            this.f = r1;
            super(r1, Side.valueOf(r2.name()));
        }
    }

    static {
        f13527a = new Constraint("parent");
        f13528b = Integer.MIN_VALUE;
        HashMap r0 = new HashMap();
        c = r0;
        r0.put(ChainMode.SPREAD, "spread");
        c.put(ChainMode.SPREAD_INSIDE, "spread_inside");
        c.put(ChainMode.PACKED, "packed");
    }

    public Constraint(String r5) {
        this.d = null;
        this.e = null;
        this.g = new b(this, HSide.LEFT);
        this.h = new b(this, HSide.RIGHT);
        this.i = new c(this, VSide.TOP);
        this.j = new c(this, VSide.BOTTOM);
        this.k = new b(this, HSide.START);
        this.l = new b(this, HSide.END);
        this.m = new c(this, VSide.BASELINE);
        int r1 = f13528b;
        this.n = r1;
        this.o = r1;
        this.p = Float.NaN;
        this.q = Float.NaN;
        this.r = null;
        this.s = null;
        this.t = Integer.MIN_VALUE;
        this.u = Float.NaN;
        this.v = Integer.MIN_VALUE;
        this.w = Integer.MIN_VALUE;
        this.x = Float.NaN;
        this.y = Float.NaN;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = r1;
        this.E = r1;
        this.F = r1;
        this.G = r1;
        this.H = Float.NaN;
        this.I = Float.NaN;
        this.f13529J = null;
        this.K = false;
        this.L = false;
        this.f = r5;
    }

    static /* synthetic */ String a(Constraint r0) {
        return r0.f;
    }

    public String a(String[] r4) {
        StringBuilder r3 = new StringBuilder("[");
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L10;
        if (r0 != 0) goto L8;
        String r2 = "'";
    L9:
        r3.append(r2);
        r3.append(r4[r0]);
        r3.append("'");
        r0 = r0 + 1;
        goto L4
    L8:
        r2 = ",'";
        goto L9
    L10:
        r3.append("]");
        return r3.toString();
    }

    public void a(StringBuilder r1, String r2, float r3) {
        if (Float.isNaN(r3) == false) goto L5;
        return;
    L5:
        r1.append(r2);
        r1.append(ParameterizedMessage.ERROR_MSG_SEPARATOR).append(r3).append(",\n");
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(this.f + ":{\n");
        this.g.a(r0);
        this.h.a(r0);
        this.i.a(r0);
        this.j.a(r0);
        this.k.a(r0);
        this.l.a(r0);
        this.m.a(r0);
        if (this.n == f13528b) goto L6;
        r0.append("width:").append(this.n).append(",\n");
    L6:
        if (this.o == f13528b) goto L8;
        r0.append("height:").append(this.o).append(",\n");
    L8:
        a(r0, "horizontalBias", this.p);
        a(r0, "verticalBias", this.q);
        if (this.r == null) goto L12;
        r0.append("dimensionRatio:'").append(this.r).append("',\n");
    L12:
        if (this.s != null) goto L14;
    L28:
        a(r0, "verticalWeight", this.x);
        a(r0, "horizontalWeight", this.y);
        if (this.z == null) goto L32;
        r0.append("horizontalChainStyle:'").append((String) ZeusTransformUtils.preCheckCast(c.get(this.z), String.class, "com.obric.memorydata.plugin")).append("',\n");
    L32:
        if (this.A == null) goto L35;
        r0.append("verticalChainStyle:'").append((String) ZeusTransformUtils.preCheckCast(c.get(this.A), String.class, "com.obric.memorydata.plugin")).append("',\n");
    L35:
        if (this.B == null) goto L49;
        int r1 = this.D;
        int r9 = f13528b;
        if (r1 == r9) goto L39;
    L41:
        r0.append("width:{value:'").append(this.B.toString().toLowerCase()).append("'");
        if (this.D == f13528b) goto L45;
        r0.append(",max:").append(this.D);
    L45:
        if (this.F == f13528b) goto L47;
        r0.append(",min:").append(this.F);
    L47:
        r0.append("},\n");
        goto L49
    L39:
        if (this.F != r9) goto L41;
        r0.append("width:'").append(this.B.toString().toLowerCase()).append("',\n");
    L49:
        if (this.C == null) goto L63;
        int r2 = this.E;
        int r10 = f13528b;
        if (r2 == r10) goto L53;
    L55:
        r0.append("height:{value:'").append(this.C.toString().toLowerCase()).append("'");
        if (this.E == f13528b) goto L59;
        r0.append(",max:").append(this.E);
    L59:
        if (this.G == f13528b) goto L61;
        r0.append(",min:").append(this.G);
    L61:
        r0.append("},\n");
        goto L63
    L53:
        if (this.G != r10) goto L55;
        r0.append("height:'").append(this.C.toString().toLowerCase()).append("',\n");
    L63:
        if (Double.isNaN(this.H) == true) goto L66;
        r0.append("width:'").append((int) this.H).append("%',\n");
    L66:
        if (Double.isNaN(this.I) == true) goto L69;
        r0.append("height:'").append((int) this.I).append("%',\n");
    L69:
        if (this.f13529J == null) goto L72;
        r0.append("referenceIds:").append(a(this.f13529J)).append(",\n");
    L72:
        if (this.K == false) goto L75;
        r0.append("constrainedWidth:").append(this.K).append(",\n");
    L75:
        if (this.L == false) goto L77;
        r0.append("constrainedHeight:").append(this.L).append(",\n");
    L77:
        r0.append("},\n");
        return r0.toString();
    L14:
        if (Float.isNaN(this.u) == true) goto L16;
    L17:
        r0.append("circular:['").append(this.s).append("'");
        if (Float.isNaN(this.u) == true) goto L21;
        r0.append(",").append(this.u);
    L21:
        if (this.t != Integer.MIN_VALUE) goto L23;
    L27:
        r0.append("],\n");
        goto L28
    L23:
        if (Float.isNaN(this.u) == false) goto L25;
        StringBuilder r3 = r0.append(",0,");
    L26:
        r3.append(this.t);
        goto L27
    L25:
        r3 = r0.append(",");
        goto L26
    L16:
        if (this.t == Integer.MIN_VALUE) goto L28;
        goto L17
    }
}
