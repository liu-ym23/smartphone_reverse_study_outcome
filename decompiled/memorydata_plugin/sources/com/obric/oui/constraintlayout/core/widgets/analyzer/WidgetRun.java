package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public abstract class WidgetRun implements d {
    public int c;
    ConstraintWidget d;
    l e;
    protected ConstraintWidget.DimensionBehaviour f;
    f g;
    public int h;
    boolean i;
    public DependencyNode j;
    public DependencyNode k;
    protected RunType l;

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13614a = null;

        static {
            int[] r0 = new int[ConstraintAnchor.Type.values().length];
            f13614a = r0;
            r0[ConstraintAnchor.Type.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f13614a[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f13614a[ConstraintAnchor.Type.TOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f13614a[ConstraintAnchor.Type.BASELINE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f13614a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static final enum RunType extends Enum<RunType> {
        private static final /* synthetic */ RunType[] $VALUES = null;
        public static final RunType CENTER = null;
        public static final RunType END = null;
        public static final RunType NONE = null;
        public static final RunType START = null;

        static {
            RunType r0 = new RunType("NONE", 0);
            NONE = r0;
            RunType r1 = new RunType("START", 1);
            START = r1;
            RunType r3 = new RunType("END", 2);
            END = r3;
            RunType r5 = new RunType("CENTER", 3);
            CENTER = r5;
            $VALUES = new RunType[]{r0, r1, r3, r5};
        }

        private RunType(String r1, int r2) {
            super(r1, r2);
        }

        public static RunType valueOf(String r2) {
            return (RunType) ZeusTransformUtils.preCheckCast(Enum.valueOf(RunType.class, r2), RunType.class, "com.obric.memorydata.plugin");
        }

        public static RunType[] values() {
            return (RunType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RunType[].class, "com.obric.memorydata.plugin");
        }
    }

    public WidgetRun(ConstraintWidget r2) {
        this.g = new f(this);
        this.h = 0;
        this.i = false;
        this.j = new DependencyNode(this);
        this.k = new DependencyNode(this);
        this.l = RunType.NONE;
        this.d = r2;
    }

    private void b(int r5, int r6) {
        int r0 = this.c;
        if (r0 != 0) goto L5;
    L45:
        this.g.a(a(r6, r5));
        return;
    L5:
        if (r0 != 1) goto L7;
        int r7 = a(this.g.m, r5);
        f r4 = this.g;
        int r8 = Math.min(r7, r6);
    L44:
        r4.a(r8);
        return;
    L7:
        if (r0 != 2) goto L9;
        ConstraintWidget r9 = this.d.A();
        if (r9 == null) goto L48;
        if (r5 != 0) goto L35;
        WidgetRun r10 = r9.f;
    L37:
        if (r10.g.j == false) goto L49;
        ConstraintWidget r1 = this.d;
        if (r5 != 0) goto L41;
        float r2 = r1.s;
    L42:
        r6 = (int) ((r10.g.g * r2) + 0.5f);
        goto L45
    L41:
        r2 = r1.v;
        goto L42
    L49:
        return;
    L35:
        r10 = r9.g;
        goto L37
    L48:
        return;
    L9:
        if (r0 == 3) goto L12;
        return;
    L12:
        if (this.d.f.f == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L14;
    L20:
        ConstraintWidget r11 = this.d;
        if (r5 != 0) goto L23;
        WidgetRun r12 = r11.g;
    L25:
        if (r12.g.j == false) goto L47;
        float r3 = this.d.U();
        if (r5 != 1) goto L29;
        r8 = (int) ((r12.g.g / r3) + 0.5f);
    L30:
        r4 = this.g;
        goto L44
    L29:
        r8 = (int) ((r3 * r12.g.g) + 0.5f);
        goto L30
    L47:
        return;
    L23:
        r12 = r11.f;
        goto L25
    L14:
        if (this.d.f.c != 3) goto L20;
        if (this.d.g.f != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L20;
        if (this.d.g.c != 3) goto L20;
    }

    public final int a(int r1, int r2) {
        if (r2 != 0) goto L8;
        int r3 = this.d.r;
        int r0 = Math.max(this.d.q, r1);
        if (r3 <= 0) goto L6;
        r0 = Math.min(r3, r1);
    L6:
        if (r0 != r1) goto L13;
        return r1;
    L13:
        return r0;
    L8:
        int r4 = this.d.u;
        r0 = Math.max(this.d.t, r1);
        if (r4 <= 0) goto L11;
        r0 = Math.min(r4, r1);
    L11:
        if (r0 != r1) goto L13;
        return r1;
    }

    public final DependencyNode a(ConstraintAnchor r3) {
        if (r3.c != null) goto L5;
        return null;
    L5:
        ConstraintWidget r2 = r3.c.f13603a;
        ConstraintAnchor.Type r4 = r3.c.f13604b;
        int r5 = AnonymousClass1.f13614a[r4.ordinal()];
        if (r5 == 1) goto L21;
        if (r5 == 2) goto L25;
        if (r5 == 3) goto L24;
        if (r5 == 4) goto L23;
        if (r5 == 5) goto L22;
        return null;
    L22:
        return r2.g.k;
    L23:
        return r2.g.f13629a;
    L24:
        return r2.g.j;
    L25:
        return r2.f.k;
    L21:
        return r2.f.j;
    }

    public final DependencyNode a(ConstraintAnchor r2, int r3) {
        if (r2.c != null) goto L5;
        return null;
    L5:
        ConstraintWidget r1 = r2.c.f13603a;
        if (r3 != 0) goto L8;
        WidgetRun r4 = r1.f;
    L9:
        ConstraintAnchor.Type r5 = r2.c.f13604b;
        int r6 = AnonymousClass1.f13614a[r5.ordinal()];
        if (r6 == 1) goto L20;
        if (r6 == 2) goto L21;
        if (r6 == 3) goto L20;
        if (r6 == 5) goto L21;
        return null;
    L21:
        return r4.k;
    L20:
        return r4.j;
    L8:
        r4 = r1.g;
        goto L9
    }

    public final void a(DependencyNode r1, DependencyNode r2, int r3) {
        r1.l.add(r2);
        r1.f = r3;
        r2.k.add(r1);
    }

    public final void a(DependencyNode r2, DependencyNode r3, int r4, f r5) {
        r2.l.add(r3);
        r2.l.add(this.g);
        r2.h = r4;
        r2.i = r5;
        r3.k.add(r2);
        r5.k.add(r2);
    }

    public void a(d r2) {
        d r1 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin");
    }

    public void a(d r5, ConstraintAnchor r6, ConstraintAnchor r7, int r8) {
        d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.memorydata.plugin");
        DependencyNode r10 = a(r6);
        DependencyNode r0 = a(r7);
        if (r10.j == true) goto L5;
        return;
    L5:
        if (r0.j == false) goto L29;
        int r1 = r10.g + r6.i();
        int r11 = r0.g - r7.i();
        int r12 = r11 - r1;
        if (this.g.j == true) goto L13;
        if (this.f != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L13;
        b(r8, r12);
    L13:
        if (this.g.j == true) goto L16;
        return;
    L16:
        if (this.g.g != r12) goto L19;
        this.j.a(r1);
        this.k.a(r11);
        return;
    L19:
        ConstraintWidget r13 = this.d;
        if (r8 != 0) goto L22;
        float r14 = r13.P();
    L24:
        if (r10 != r0) goto L26;
        r1 = r10.g;
        r11 = r0.g;
        r14 = 0.5f;
    L26:
        this.j.a((int) ((r1 + 0.5f) + (((r11 - r1) - this.g.g) * r14)));
        this.k.a(this.j.g + this.g.g);
        return;
    L22:
        r14 = r13.Q();
        goto L24
    }

    abstract boolean a();

    public long b() {
        if (this.g.j == true) goto L5;
        return 0;
    L5:
        return this.g.g;
    }

    public void b(d r2) {
        d r1 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin");
    }

    abstract void c();

    abstract void d();

    abstract void e();

    abstract void f();

    public boolean g() {
        return this.i;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.d
    public void update(d r2) {
        d r1 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin");
    }
}
