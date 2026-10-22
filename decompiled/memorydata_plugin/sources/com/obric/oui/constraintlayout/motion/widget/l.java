package com.obric.oui.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes5.dex */
class l implements Comparable<l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String[] f13694a;
    private float A;
    private float B;
    private float C;
    private int D;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f13695b;
    int c;
    int d;
    LinkedHashMap<String, ConstraintAttribute> e;
    int f;
    double[] g;
    double[] h;
    private float i;
    private boolean j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private com.obric.oui.constraintlayout.core.motion.a.c u;
    private int v;
    private float w;
    private float x;
    private float y;
    private float z;

    static {
        f13694a = new String[]{"position", "x", "y", "width", "height", "pathRotate"};
    }

    l() {
        this.f13695b = 0.0f;
        this.c = 0;
        this.e = new LinkedHashMap();
        this.f = 0;
        this.g = new double[18];
        this.h = new double[18];
        this.i = 1.0f;
        this.j = false;
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = 1.0f;
        this.o = 1.0f;
        this.p = Float.NaN;
        this.q = Float.NaN;
        this.r = 0.0f;
        this.s = 0.0f;
        this.t = 0.0f;
        this.v = 0;
        this.B = Float.NaN;
        this.C = Float.NaN;
        this.D = -1;
    }

    private boolean a(float r3, float r4) {
        if (Float.isNaN(r3) == true) goto L13;
        if (Float.isNaN(r4) == true) goto L13;
        if (Math.abs(r3 - r4) <= 1.0E-6f) goto L11;
        return true;
    L11:
        return false;
    L13:
        if (Float.isNaN(r3) == Float.isNaN(r4)) goto L16;
        return true;
    L16:
        return false;
    }

    public int a(l r1) {
        return Float.compare(this.w, r1.w);
    }

    void a(float r1, float r2, float r3, float r4) {
        this.x = r1;
        this.y = r2;
        this.z = r3;
        this.A = r4;
    }

    public void a(Rect r4, View r5, int r6, float r7) {
        a(r4.left, r4.top, r4.width(), r4.height());
        a(r5);
        this.p = Float.NaN;
        this.q = Float.NaN;
        if (r6 != 1) goto L5;
        float r8 = r7 - 90.0f;
    L9:
        this.l = r8;
        return;
    L5:
        if (r6 != 2) goto L11;
        r8 = r7 + 90.0f;
        goto L9
    }

    public void a(Rect r4, com.obric.oui.constraintlayout.widget.b r5, int r6, int r7) {
        a(r4.left, r4.top, r4.width(), r4.height());
        a(r5.a(r7));
        float r8 = 90.0f;
        if (r6 != 1) goto L5;
    L14:
        float r9 = this.l;
    L15:
        this.l = r9 - r8;
        return;
    L5:
        if (r6 != 2) goto L7;
    L11:
        r9 = this.l + 90.0f;
        this.l = r9;
        if (r9 <= 180.0f) goto L17;
        r8 = 360.0f;
        goto L15
    L17:
        return;
    L7:
        if (r6 == 3) goto L14;
        if (r6 == 4) goto L11;
    }

    public void a(View r2) {
        this.d = r2.getVisibility();
        if (r2.getVisibility() == 0) goto L5;
        float r0 = 0.0f;
    L6:
        this.i = r0;
        this.j = false;
        this.k = r2.getElevation();
        this.l = r2.getRotation();
        this.m = r2.getRotationX();
        this.f13695b = r2.getRotationY();
        this.n = r2.getScaleX();
        this.o = r2.getScaleY();
        this.p = r2.getPivotX();
        this.q = r2.getPivotY();
        this.r = r2.getTranslationX();
        this.s = r2.getTranslationY();
        this.t = r2.getTranslationZ();
        return;
    L5:
        r0 = r2.getAlpha();
        goto L6
    }

    void a(l r5, HashSet<String> r6) {
        if (a(this.i, r5.i) == false) goto L6;
        r6.add("alpha");
    L6:
        if (a(this.k, r5.k) == false) goto L8;
        r6.add("elevation");
    L8:
        int r0 = this.d;
        int r2 = r5.d;
        if (r0 == r2) goto L16;
        if (this.c != 0) goto L16;
        if (r0 == 0) goto L14;
        if (r2 != 0) goto L16;
    L14:
        r6.add("alpha");
    L16:
        if (a(this.l, r5.l) == false) goto L19;
        r6.add(Key.ROTATION);
    L19:
        if (Float.isNaN(this.B) == true) goto L21;
    L22:
        r6.add("transitionPathRotate");
    L24:
        if (Float.isNaN(this.C) == true) goto L26;
    L27:
        r6.add("progress");
    L29:
        if (a(this.m, r5.m) == false) goto L32;
        r6.add("rotationX");
    L32:
        if (a(this.f13695b, r5.f13695b) == false) goto L35;
        r6.add("rotationY");
    L35:
        if (a(this.p, r5.p) == false) goto L38;
        r6.add(Key.PIVOT_X);
    L38:
        if (a(this.q, r5.q) == false) goto L41;
        r6.add(Key.PIVOT_Y);
    L41:
        if (a(this.n, r5.n) == false) goto L44;
        r6.add("scaleX");
    L44:
        if (a(this.o, r5.o) == false) goto L47;
        r6.add("scaleY");
    L47:
        if (a(this.r, r5.r) == false) goto L50;
        r6.add("translationX");
    L50:
        if (a(this.s, r5.s) == false) goto L53;
        r6.add("translationY");
    L53:
        if (a(this.t, r5.t) == false) goto L56;
        r6.add("translationZ");
        return;
    L56:
        return;
    L26:
        if (Float.isNaN(r5.C) == true) goto L29;
    L21:
        if (Float.isNaN(r5.B) == true) goto L24;
        goto L22
    }

    public void a(com.obric.oui.constraintlayout.widget.b.a r6) {
        this.c = r6.c.c;
        this.d = r6.c.f13778b;
        if (r6.c.f13778b != 0) goto L5;
    L7:
        float r0 = r6.c.d;
    L8:
        this.i = r0;
        this.j = r6.f.m;
        this.k = r6.f.n;
        this.l = r6.f.f13780b;
        this.m = r6.f.c;
        this.f13695b = r6.f.d;
        this.n = r6.f.e;
        this.o = r6.f.f;
        this.p = r6.f.g;
        this.q = r6.f.h;
        this.r = r6.f.j;
        this.s = r6.f.k;
        this.t = r6.f.l;
        this.u = com.obric.oui.constraintlayout.core.motion.a.c.a(r6.d.d);
        this.B = r6.d.i;
        this.v = r6.d.f;
        this.D = r6.d.f13776b;
        this.C = r6.c.e;
        Iterator<String> r1 = r6.g.keySet().iterator();
    L10:
        if (r1.hasNext() == false) goto L14;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        ConstraintAttribute r3 = (ConstraintAttribute) ZeusTransformUtils.preCheckCast(r6.g.get(r2), ConstraintAttribute.class, "com.obric.memorydata.plugin");
        if (r3.b() == false) goto L10;
        this.e.put(r2, r3);
        goto L10
    L14:
        return;
    L5:
        if (this.c != 0) goto L7;
        r0 = 0.0f;
        goto L8
    }

    public void a(HashMap<String, com.obric.oui.constraintlayout.motion.a.d> r9, int r10) {
        Iterator<String> r0 = r9.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L137;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        com.obric.oui.constraintlayout.motion.a.d r2 = (com.obric.oui.constraintlayout.motion.a.d) ZeusTransformUtils.preCheckCast(r9.get(r1), com.obric.oui.constraintlayout.motion.a.d.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        r1.hashCode();
        byte r4 = -1;
        switch(r1.hashCode()) {
            case -1249320806: goto L64;
            case -1249320805: goto L60;
            case -1225497657: goto L56;
            case -1225497656: goto L52;
            case -1225497655: goto L48;
            case -1001078227: goto L44;
            case -908189618: goto L40;
            case -908189617: goto L36;
            case -760884510: goto L32;
            case -760884509: goto L28;
            case -40300674: goto L24;
            case -4379043: goto L20;
            case 37232917: goto L16;
            case 92909918: goto L12;
            default: goto L67;
        };
    L67:
        float r5 = 1.0f;
        float r7 = 0.0f;
        switch(r4) {
            case 0: goto L134;
            case 1: goto L130;
            case 2: goto L126;
            case 3: goto L122;
            case 4: goto L118;
            case 5: goto L114;
            case 6: goto L110;
            case 7: goto L106;
            case 8: goto L102;
            case 9: goto L98;
            case 10: goto L94;
            case 11: goto L89;
            case 12: goto L85;
            case 13: goto L80;
            default: goto L70;
        };
    L80:
        if (Float.isNaN(this.i) == true) goto L83;
        r5 = this.i;
    L83:
        r2.a(r10, r5);
        goto L4
    L85:
        if (Float.isNaN(this.B) == true) goto L92;
        r7 = this.B;
    L92:
        r2.a(r10, r7);
        goto L4
    L89:
        if (Float.isNaN(this.k) == true) goto L92;
        r7 = this.k;
        goto L92
    L94:
        if (Float.isNaN(this.l) == true) goto L92;
        r7 = this.l;
        goto L92
    L98:
        if (Float.isNaN(this.q) == true) goto L92;
        r7 = this.q;
        goto L92
    L102:
        if (Float.isNaN(this.p) == true) goto L92;
        r7 = this.p;
        goto L92
    L106:
        if (Float.isNaN(this.o) == true) goto L83;
        r5 = this.o;
        goto L83
    L110:
        if (Float.isNaN(this.n) == true) goto L83;
        r5 = this.n;
        goto L83
    L114:
        if (Float.isNaN(this.C) == true) goto L92;
        r7 = this.C;
        goto L92
    L118:
        if (Float.isNaN(this.t) == true) goto L92;
        r7 = this.t;
        goto L92
    L122:
        if (Float.isNaN(this.s) == true) goto L92;
        r7 = this.s;
        goto L92
    L126:
        if (Float.isNaN(this.r) == true) goto L92;
        r7 = this.r;
        goto L92
    L130:
        if (Float.isNaN(this.f13695b) == true) goto L92;
        r7 = this.f13695b;
        goto L92
    L134:
        if (Float.isNaN(this.m) == true) goto L92;
        r7 = this.m;
        goto L92
    L70:
        if (r1.startsWith("CUSTOM") == false) goto L78;
        String r6 = r1.split(",")[1];
        if (this.e.containsKey(r6) == false) goto L4;
        ConstraintAttribute r8 = (ConstraintAttribute) ZeusTransformUtils.preCheckCast(this.e.get(r6), ConstraintAttribute.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, com.obric.oui.constraintlayout.motion.a.d.b.class) == true) goto L75;
        StringBuilder r3 = new StringBuilder().append(r1).append(" ViewSpline not a CustomSet frame = ").append(r10).append(", value").append(r8.d()).append(r2);
    L77:
        Log.e("MotionPaths", r3.toString());
        goto L4
    L75:
        ((com.obric.oui.constraintlayout.motion.a.d.b) ZeusTransformUtils.preCheckCast(r2, com.obric.oui.constraintlayout.motion.a.d.b.class, "com.obric.memorydata.plugin")).a(r10, r8);
        goto L4
    L78:
        r3 = new StringBuilder().append("UNKNOWN spline ").append(r1);
        goto L77
    L12:
        if (r1.equals("alpha") == false) goto L67;
        r4 = 13;
        goto L67
    L16:
        if (r1.equals("transitionPathRotate") == false) goto L67;
        r4 = 12;
        goto L67
    L20:
        if (r1.equals("elevation") == false) goto L67;
        r4 = 11;
        goto L67
    L24:
        if (r1.equals(Key.ROTATION) == false) goto L67;
        r4 = 10;
        goto L67
    L28:
        if (r1.equals(Key.PIVOT_Y) == false) goto L67;
        r4 = 9;
        goto L67
    L32:
        if (r1.equals(Key.PIVOT_X) == false) goto L67;
        r4 = 8;
        goto L67
    L36:
        if (r1.equals("scaleY") == false) goto L67;
        r4 = 7;
        goto L67
    L40:
        if (r1.equals("scaleX") == false) goto L67;
        r4 = 6;
        goto L67
    L44:
        if (r1.equals("progress") == false) goto L67;
        r4 = 5;
        goto L67
    L48:
        if (r1.equals("translationZ") == false) goto L67;
        r4 = 4;
        goto L67
    L52:
        if (r1.equals("translationY") == false) goto L67;
        r4 = 3;
        goto L67
    L56:
        if (r1.equals("translationX") == false) goto L67;
        r4 = 2;
        goto L67
    L60:
        if (r1.equals("rotationY") == false) goto L67;
        r4 = 1;
        goto L67
    L64:
        if (r1.equals("rotationX") == false) goto L67;
        r4 = 0;
        goto L67
    }

    public void b(View r5) {
        a(r5.getX(), r5.getY(), r5.getWidth(), r5.getHeight());
        a(r5);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(l r3) {
        return a((l) ZeusTransformUtils.preCheckCast(r3, l.class, "com.obric.memorydata.plugin"));
    }
}
