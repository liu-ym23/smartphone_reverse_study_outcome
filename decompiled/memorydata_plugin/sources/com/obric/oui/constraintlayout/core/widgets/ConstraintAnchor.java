package com.obric.oui.constraintlayout.core.widgets;

import com.obric.oui.constraintlayout.core.SolverVariable;
import com.obric.oui.constraintlayout.core.widgets.analyzer.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes5.dex */
public class ConstraintAnchor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintWidget f13603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f13604b;
    public ConstraintAnchor c;
    public int d;
    int e;
    SolverVariable f;
    private HashSet<ConstraintAnchor> g;
    private int h;
    private boolean i;

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13605a = null;

        static {
            int[] r0 = new int[Type.values().length];
            f13605a = r0;
            r0[Type.CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            f13605a[Type.LEFT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            f13605a[Type.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            f13605a[Type.TOP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            f13605a[Type.BOTTOM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            f13605a[Type.BASELINE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            f13605a[Type.CENTER_X.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            f13605a[Type.CENTER_Y.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            f13605a[Type.NONE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type BASELINE = null;
        public static final Type BOTTOM = null;
        public static final Type CENTER = null;
        public static final Type CENTER_X = null;
        public static final Type CENTER_Y = null;
        public static final Type LEFT = null;
        public static final Type NONE = null;
        public static final Type RIGHT = null;
        public static final Type TOP = null;

        static {
            Type r0 = new Type("NONE", 0);
            NONE = r0;
            Type r1 = new Type("LEFT", 1);
            LEFT = r1;
            Type r3 = new Type("TOP", 2);
            TOP = r3;
            Type r5 = new Type("RIGHT", 3);
            RIGHT = r5;
            Type r7 = new Type("BOTTOM", 4);
            BOTTOM = r7;
            Type r9 = new Type("BASELINE", 5);
            BASELINE = r9;
            Type r11 = new Type("CENTER", 6);
            CENTER = r11;
            Type r13 = new Type("CENTER_X", 7);
            CENTER_X = r13;
            Type r15 = new Type("CENTER_Y", 8);
            CENTER_Y = r15;
            $VALUES = new Type[]{r0, r1, r3, r5, r7, r9, r11, r13, r15};
        }

        private Type(String r1, int r2) {
            super(r1, r2);
        }

        public static Type valueOf(String r2) {
            return (Type) ZeusTransformUtils.preCheckCast(Enum.valueOf(Type.class, r2), Type.class, "com.obric.memorydata.plugin");
        }

        public static Type[] values() {
            return (Type[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Type[].class, "com.obric.memorydata.plugin");
        }
    }

    public ConstraintAnchor(ConstraintWidget r2, Type r3) {
        this.g = null;
        this.d = 0;
        this.e = Integer.MIN_VALUE;
        this.f13603a = r2;
        this.f13604b = r3;
    }

    public HashSet<ConstraintAnchor> a() {
        return this.g;
    }

    public void a(int r1) {
        this.h = r1;
        this.i = true;
    }

    public void a(int r4, ArrayList<n> r5, n r6) {
        HashSet<ConstraintAnchor> r3 = this.g;
        if (r3 == null) goto L8;
        Iterator<ConstraintAnchor> r7 = r3.iterator();
    L6:
        if (r7.hasNext() == false) goto L10;
        com.obric.oui.constraintlayout.core.widgets.analyzer.h.a(((ConstraintAnchor) ZeusTransformUtils.preCheckCast(r7.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).f13603a, r4, r5, r6);
        goto L6
    L10:
        return;
    }

    public void a(com.obric.oui.constraintlayout.core.c r3) {
        SolverVariable r4 = this.f;
        if (r4 != null) goto L5;
        this.f = new SolverVariable(SolverVariable.Type.UNRESTRICTED, null);
        return;
    L5:
        r4.b();
    }

    public boolean a(ConstraintAnchor r6) {
        boolean r0 = false;
        if (r6 != null) goto L5;
        return false;
    L5:
        Type r1 = r6.getType();
        Type r2 = this.f13604b;
        if (r1 != r2) goto L16;
        if (r2 == Type.BASELINE) goto L10;
    L14:
        return true;
    L10:
        if (r6.h().R() == true) goto L12;
    L13:
        return false;
    L12:
        if (h().R() == true) goto L14;
    L16:
        switch(AnonymousClass1.f13605a[this.f13604b.ordinal()]) {
            case 1: goto L58;
            case 2: goto L43;
            case 3: goto L43;
            case 4: goto L28;
            case 5: goto L28;
            case 6: goto L21;
            case 7: goto L19;
            case 8: goto L19;
            case 9: goto L19;
            default: goto L18;
        };
    L19:
        return false;
    L18:
        throw new AssertionError(this.f13604b.name());
    L21:
        if (r1 != Type.LEFT) goto L23;
    L26:
        return false;
    L23:
        if (r1 == Type.RIGHT) goto L26;
        return true;
    L28:
        if (r1 != Type.TOP) goto L30;
    L33:
        boolean r5 = true;
    L35:
        if (ZeusTransformUtils.instanceOf(r6.h(), f.class) == false) goto L65;
        if (r5 == false) goto L38;
    L39:
        r0 = true;
    L41:
        return r0;
    L38:
        if (r1 != Type.CENTER_Y) goto L41;
    L65:
        return r5;
    L30:
        if (r1 == Type.BOTTOM) goto L33;
        r5 = false;
        goto L35
    L43:
        if (r1 != Type.LEFT) goto L45;
    L48:
        boolean r7 = true;
    L50:
        if (ZeusTransformUtils.instanceOf(r6.h(), f.class) == false) goto L66;
        if (r7 == false) goto L53;
    L54:
        r0 = true;
    L56:
        return r0;
    L53:
        if (r1 != Type.CENTER_X) goto L56;
    L66:
        return r7;
    L45:
        if (r1 == Type.RIGHT) goto L48;
        r7 = false;
        goto L50
    L58:
        if (r1 != Type.BASELINE) goto L60;
        return false;
    L60:
        if (r1 != Type.CENTER_X) goto L62;
        return false;
    L62:
        if (r1 != Type.CENTER_Y) goto L64;
        return false;
    L64:
        return true;
    }

    public boolean a(ConstraintAnchor r3, int r4) {
        return a(r3, r4, Integer.MIN_VALUE, false);
    }

    public boolean a(ConstraintAnchor r2, int r3, int r4, boolean r5) {
        if (r2 != null) goto L6;
        k();
        return true;
    L6:
        if (r5 == false) goto L8;
    L11:
        this.c = r2;
        if (r2.g != null) goto L14;
        r2.g = new HashSet();
    L14:
        HashSet<ConstraintAnchor> r6 = this.c.g;
        if (r6 == null) goto L17;
        r6.add(this);
    L17:
        this.d = r3;
        this.e = r4;
        return true;
    L8:
        if (a(r2) == true) goto L11;
        return false;
    }

    public void b(int r2) {
        if (l() == false) goto L6;
        this.e = r2;
        return;
    }

    public boolean b() {
        HashSet<ConstraintAnchor> r1 = this.g;
        if (r1 != null) goto L6;
        return false;
    L6:
        if (r1.size() <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean c() {
        HashSet<ConstraintAnchor> r4 = this.g;
        if (r4 != null) goto L5;
        return false;
    L5:
        Iterator<ConstraintAnchor> r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L12;
        if (((ConstraintAnchor) ZeusTransformUtils.preCheckCast(r5.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).m().l() == false) goto L7;
        return true;
    L12:
        return false;
    }

    public int d() {
        if (this.i == true) goto L7;
        return 0;
    L7:
        return this.h;
    }

    public void e() {
        this.i = false;
        this.h = 0;
    }

    public boolean f() {
        return this.i;
    }

    public SolverVariable g() {
        return this.f;
    }

    public Type getType() {
        return this.f13604b;
    }

    public ConstraintWidget h() {
        return this.f13603a;
    }

    public int i() {
        if (this.f13603a.B() != 8) goto L7;
        return 0;
    L7:
        if (this.e == Integer.MIN_VALUE) goto L15;
        ConstraintAnchor r0 = this.c;
        if (r0 == null) goto L15;
        if (r0.f13603a.B() != 8) goto L15;
        return this.e;
    L15:
        return this.d;
    }

    public ConstraintAnchor j() {
        return this.c;
    }

    public void k() {
        ConstraintAnchor r0 = this.c;
        if (r0 == null) goto L9;
        HashSet<ConstraintAnchor> r1 = r0.g;
        if (r1 == null) goto L9;
        r1.remove(this);
        if (this.c.g.size() != 0) goto L9;
        this.c.g = null;
    L9:
        this.g = null;
        this.c = null;
        this.d = 0;
        this.e = Integer.MIN_VALUE;
        this.i = false;
        this.h = 0;
    }

    public boolean l() {
        if (this.c == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final ConstraintAnchor m() {
        switch(AnonymousClass1.f13605a[this.f13604b.ordinal()]) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L14;
            case 7: goto L14;
            case 8: goto L14;
            case 9: goto L14;
            default: goto L5;
        };
    L14:
        return null;
    L5:
        throw new AssertionError(this.f13604b.name());
    L7:
        return this.f13603a.C;
    L9:
        return this.f13603a.E;
    L11:
        return this.f13603a.B;
    L13:
        return this.f13603a.D;
    }

    public String toString() {
        return this.f13603a.C() + ParameterizedMessage.ERROR_MSG_SEPARATOR + this.f13604b.toString();
    }
}
