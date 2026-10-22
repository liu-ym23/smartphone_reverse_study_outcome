package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.widget.Key;
import com.obric.memorydata.plugin.R;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class e extends d {
    private String g;
    private int h;
    private boolean i;
    private float j;
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
    private float u;
    private float v;
    private float w;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static SparseIntArray f13687a;

        static {
            SparseIntArray r0 = new SparseIntArray();
            f13687a = r0;
            r0.append(ZeusTransformUtils.mapRes(R.styleable.KeyAttribute_android_alpha, "styleable", "KeyAttribute_android_alpha"), 1);
            f13687a.append(ZeusTransformUtils.mapRes(R.styleable.KeyAttribute_android_elevation, "styleable", "KeyAttribute_android_elevation"), 2);
            f13687a.append(ZeusTransformUtils.mapRes(R.styleable.KeyAttribute_android_rotation, "styleable", "KeyAttribute_android_rotation"), 4);
            f13687a.append(ZeusTransformUtils.mapRes(R.styleable.KeyAttribute_android_rotationX, "styleable", "KeyAttribute_android_rotationX"), 5);
            f13687a.append(ZeusTransformUtils.mapRes(R.styleable.KeyAttribute_android_rotationY, "styleable", "KeyAttribute_android_rotationY"), 6);
            f13687a.append(ZeusTransformUtils.mapRes(R.styleable.KeyAttribute_android_transformPivotX, "styleable", "KeyAttribute_android_transformPivotX"), 19);
            f13687a.append(ZeusTransformUtils.mapRes(R.styleable.KeyAttribute_android_transformPivotY, "styleable", "KeyAttribute_android_transformPivotY"), 20);
            f13687a.append(ZeusTransformUtils.mapRes(R.styleable.KeyAttribute_android_scaleX, "styleable", "KeyAttribute_android_scaleX"), 7);
            f13687a.append(ZeusTransformUtils.mapRes(R.styleable.KeyAttribute_transitionPathRotate, "styleable", "KeyAttribute_transitionPathRotate"), 8);
            f13687a.append(ZeusTransformUtils.mapRes(R.styleable.KeyAttribute_transitionEasing, "styleable", "KeyAttribute_transitionEasing"), 9);
            f13687a.append(ZeusTransformUtils.mapRes(R.styleable.KeyAttribute_motionTarget, "styleable", "KeyAttribute_motionTarget"), 10);
            f13687a.append(ZeusTransformUtils.mapRes(R.styleable.KeyAttribute_framePosition, "styleable", "KeyAttribute_framePosition"), 12);
            f13687a.append(ZeusTransformUtils.mapRes(R.styleable.KeyAttribute_curveFit, "styleable", "KeyAttribute_curveFit"), 13);
            f13687a.append(ZeusTransformUtils.mapRes(R.styleable.KeyAttribute_android_scaleY, "styleable", "KeyAttribute_android_scaleY"), 14);
            f13687a.append(ZeusTransformUtils.mapRes(R.styleable.KeyAttribute_android_translationX, "styleable", "KeyAttribute_android_translationX"), 15);
            f13687a.append(ZeusTransformUtils.mapRes(R.styleable.KeyAttribute_android_translationY, "styleable", "KeyAttribute_android_translationY"), 16);
            f13687a.append(ZeusTransformUtils.mapRes(R.styleable.KeyAttribute_android_translationZ, "styleable", "KeyAttribute_android_translationZ"), 17);
            f13687a.append(ZeusTransformUtils.mapRes(R.styleable.KeyAttribute_motionProgress, "styleable", "KeyAttribute_motionProgress"), 18);
        }

        public static void a(e r5, TypedArray r6) {
            int r0 = r6.getIndexCount();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L34;
            int r2 = r6.getIndex(r1);
            switch(f13687a.get(r2)) {
                case 1: goto L32;
                case 2: goto L31;
                case 3: goto L6;
                case 4: goto L30;
                case 5: goto L29;
                case 6: goto L28;
                case 7: goto L27;
                case 8: goto L26;
                case 9: goto L25;
                case 10: goto L17;
                case 11: goto L6;
                case 12: goto L15;
                case 13: goto L14;
                case 14: goto L13;
                case 15: goto L12;
                case 16: goto L11;
                case 17: goto L10;
                case 18: goto L9;
                case 19: goto L8;
                case 20: goto L7;
                default: goto L6;
            };
        L6:
            Log.e("KeyAttribute", "unused attribute 0x" + Integer.toHexString(r2) + "   " + f13687a.get(r2));
        L33:
            r1 = r1 + 1;
            goto L3
        L7:
            e.h(r5, r6.getDimension(r2, e.i(r5)));
            goto L33
        L8:
            e.g(r5, r6.getDimension(r2, e.h(r5)));
            goto L33
        L9:
            e.n(r5, r6.getFloat(r2, e.o(r5)));
            goto L33
        L10:
            e.m(r5, r6.getDimension(r2, e.n(r5)));
            goto L33
        L11:
            e.l(r5, r6.getDimension(r2, e.m(r5)));
            goto L33
        L12:
            e.k(r5, r6.getDimension(r2, e.l(r5)));
            goto L33
        L13:
            e.i(r5, r6.getFloat(r2, e.j(r5)));
            goto L33
        L14:
            e.a(r5, r6.getInteger(r2, e.d(r5)));
            goto L33
        L15:
            r5.f13686b = r6.getInt(r2, r5.f13686b);
            goto L33
        L25:
            e.a(r5, r6.getString(r2));
            goto L33
        L26:
            e.j(r5, r6.getFloat(r2, e.k(r5)));
            goto L33
        L27:
            e.d(r5, r6.getFloat(r2, e.e(r5)));
            goto L33
        L28:
            e.f(r5, r6.getFloat(r2, e.g(r5)));
            goto L33
        L29:
            e.e(r5, r6.getFloat(r2, e.f(r5)));
            goto L33
        L30:
            e.c(r5, r6.getFloat(r2, e.c(r5)));
            goto L33
        L31:
            e.b(r5, r6.getDimension(r2, e.b(r5)));
            goto L33
        L32:
            e.a(r5, r6.getFloat(r2, e.a(r5)));
            goto L33
        L17:
            if (MotionLayout.IS_IN_EDIT_MODE == false) goto L22;
            r5.c = r6.getResourceId(r2, r5.c);
            if (r5.c != (-1)) goto L33;
        L23:
            r5.d = r6.getString(r2);
            goto L33
        L22:
            if (r6.peekValue(r2).type == 3) goto L23;
            r5.c = r6.getResourceId(r2, r5.c);
            goto L33
        }
    }

    public e() {
        this.h = -1;
        this.i = false;
        this.j = Float.NaN;
        this.k = Float.NaN;
        this.l = Float.NaN;
        this.m = Float.NaN;
        this.n = Float.NaN;
        this.o = Float.NaN;
        this.p = Float.NaN;
        this.q = Float.NaN;
        this.r = Float.NaN;
        this.s = Float.NaN;
        this.t = Float.NaN;
        this.u = Float.NaN;
        this.v = Float.NaN;
        this.w = Float.NaN;
        this.e = 1;
        this.f = new HashMap();
    }

    static /* synthetic */ float a(e r0) {
        return r0.j;
    }

    static /* synthetic */ float a(e r0, float r1) {
        r0.j = r1;
        return r1;
    }

    static /* synthetic */ int a(e r0, int r1) {
        r0.h = r1;
        return r1;
    }

    static /* synthetic */ String a(e r0, String r1) {
        r0.g = r1;
        return r1;
    }

    static /* synthetic */ float b(e r0) {
        return r0.k;
    }

    static /* synthetic */ float b(e r0, float r1) {
        r0.k = r1;
        return r1;
    }

    static /* synthetic */ float c(e r0) {
        return r0.l;
    }

    static /* synthetic */ float c(e r0, float r1) {
        r0.l = r1;
        return r1;
    }

    static /* synthetic */ float d(e r0, float r1) {
        r0.r = r1;
        return r1;
    }

    static /* synthetic */ int d(e r0) {
        return r0.h;
    }

    static /* synthetic */ float e(e r0) {
        return r0.r;
    }

    static /* synthetic */ float e(e r0, float r1) {
        r0.m = r1;
        return r1;
    }

    static /* synthetic */ float f(e r0) {
        return r0.m;
    }

    static /* synthetic */ float f(e r0, float r1) {
        r0.n = r1;
        return r1;
    }

    static /* synthetic */ float g(e r0) {
        return r0.n;
    }

    static /* synthetic */ float g(e r0, float r1) {
        r0.o = r1;
        return r1;
    }

    static /* synthetic */ float h(e r0) {
        return r0.o;
    }

    static /* synthetic */ float h(e r0, float r1) {
        r0.p = r1;
        return r1;
    }

    static /* synthetic */ float i(e r0) {
        return r0.p;
    }

    static /* synthetic */ float i(e r0, float r1) {
        r0.s = r1;
        return r1;
    }

    static /* synthetic */ float j(e r0) {
        return r0.s;
    }

    static /* synthetic */ float j(e r0, float r1) {
        r0.q = r1;
        return r1;
    }

    static /* synthetic */ float k(e r0) {
        return r0.q;
    }

    static /* synthetic */ float k(e r0, float r1) {
        r0.t = r1;
        return r1;
    }

    static /* synthetic */ float l(e r0) {
        return r0.t;
    }

    static /* synthetic */ float l(e r0, float r1) {
        r0.u = r1;
        return r1;
    }

    static /* synthetic */ float m(e r0) {
        return r0.u;
    }

    static /* synthetic */ float m(e r0, float r1) {
        r0.v = r1;
        return r1;
    }

    static /* synthetic */ float n(e r0) {
        return r0.v;
    }

    static /* synthetic */ float n(e r0, float r1) {
        r0.w = r1;
        return r1;
    }

    static /* synthetic */ float o(e r0) {
        return r0.w;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public d a() {
        return new e().a(this);
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public d a(d r3) {
        super.a(r3);
        e r4 = (e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.memorydata.plugin");
        this.h = r4.h;
        this.i = r4.i;
        this.j = r4.j;
        this.k = r4.k;
        this.l = r4.l;
        this.m = r4.m;
        this.n = r4.n;
        this.o = r4.o;
        this.p = r4.p;
        this.q = r4.q;
        this.r = r4.r;
        this.s = r4.s;
        this.t = r4.t;
        this.u = r4.u;
        this.v = r4.v;
        this.w = r4.w;
        this.g = r4.g;
        return this;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public void a(Context r3, AttributeSet r4) {
        a.a(this, ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), R.styleable.KeyAttribute));
    }

    public void a(String r3, Object r4) {
        r3.hashCode();
        byte r1 = -1;
        switch(r3.hashCode()) {
            case -1913008125: goto L70;
            case -1812823328: goto L66;
            case -1249320806: goto L62;
            case -1249320805: goto L58;
            case -1225497657: goto L54;
            case -1225497656: goto L50;
            case -1225497655: goto L46;
            case -908189618: goto L42;
            case -908189617: goto L38;
            case -760884510: goto L34;
            case -760884509: goto L30;
            case -40300674: goto L26;
            case -4379043: goto L22;
            case 37232917: goto L18;
            case 92909918: goto L14;
            case 579057826: goto L10;
            case 1941332754: goto L6;
            default: goto L73;
        };
    L73:
        switch(r1) {
            case 0: goto L91;
            case 1: goto L90;
            case 2: goto L89;
            case 3: goto L88;
            case 4: goto L87;
            case 5: goto L86;
            case 6: goto L85;
            case 7: goto L84;
            case 8: goto L83;
            case 9: goto L82;
            case 10: goto L81;
            case 11: goto L80;
            case 12: goto L79;
            case 13: goto L78;
            case 14: goto L77;
            case 15: goto L76;
            case 16: goto L75;
            default: goto L109;
        };
    L75:
        this.i = c(r4);
        return;
    L76:
        this.h = b(r4);
        return;
    L77:
        this.j = a(r4);
        return;
    L78:
        this.q = a(r4);
        return;
    L79:
        this.k = a(r4);
        return;
    L80:
        this.l = a(r4);
        return;
    L81:
        this.p = a(r4);
        return;
    L82:
        this.o = a(r4);
        return;
    L83:
        this.s = a(r4);
        return;
    L84:
        this.r = a(r4);
        return;
    L85:
        this.v = a(r4);
        return;
    L86:
        this.u = a(r4);
        return;
    L87:
        this.t = a(r4);
        return;
    L88:
        this.n = a(r4);
        return;
    L89:
        this.m = a(r4);
        return;
    L90:
        this.g = r4.toString();
        return;
    L91:
        this.w = a(r4);
        return;
    L109:
        return;
    L6:
        if (r3.equals("visibility") == false) goto L73;
        r1 = 16;
        goto L73
    L10:
        if (r3.equals("curveFit") == false) goto L73;
        r1 = 15;
        goto L73
    L14:
        if (r3.equals("alpha") == false) goto L73;
        r1 = 14;
        goto L73
    L18:
        if (r3.equals("transitionPathRotate") == false) goto L73;
        r1 = 13;
        goto L73
    L22:
        if (r3.equals("elevation") == false) goto L73;
        r1 = 12;
        goto L73
    L26:
        if (r3.equals(Key.ROTATION) == false) goto L73;
        r1 = 11;
        goto L73
    L30:
        if (r3.equals(Key.PIVOT_Y) == false) goto L73;
        r1 = 10;
        goto L73
    L34:
        if (r3.equals(Key.PIVOT_X) == false) goto L73;
        r1 = 9;
        goto L73
    L38:
        if (r3.equals("scaleY") == false) goto L73;
        r1 = 8;
        goto L73
    L42:
        if (r3.equals("scaleX") == false) goto L73;
        r1 = 7;
        goto L73
    L46:
        if (r3.equals("translationZ") == false) goto L73;
        r1 = 6;
        goto L73
    L50:
        if (r3.equals("translationY") == false) goto L73;
        r1 = 5;
        goto L73
    L54:
        if (r3.equals("translationX") == false) goto L73;
        r1 = 4;
        goto L73
    L58:
        if (r3.equals("rotationY") == false) goto L73;
        r1 = 3;
        goto L73
    L62:
        if (r3.equals("rotationX") == false) goto L73;
        r1 = 2;
        goto L73
    L66:
        if (r3.equals("transitionEasing") == false) goto L73;
        r1 = 1;
        goto L73
    L70:
        if (r3.equals(Key.MOTIONPROGRESS) == false) goto L73;
        r1 = 0;
        goto L73
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public void a(HashMap<String, com.obric.oui.constraintlayout.motion.a.d> r7) {
        Iterator<String> r0 = r7.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L116;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        com.obric.oui.constraintlayout.core.motion.a.j r2 = (com.obric.oui.constraintlayout.core.motion.a.j) ZeusTransformUtils.preCheckCast(r7.get(r1), com.obric.oui.constraintlayout.core.motion.a.j.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        byte r5 = 7;
        if (r1.startsWith("CUSTOM") == true) goto L10;
        r1.hashCode();
        switch(r1.hashCode()) {
            case -1249320806: goto L68;
            case -1249320805: goto L64;
            case -1225497657: goto L60;
            case -1225497656: goto L56;
            case -1225497655: goto L52;
            case -1001078227: goto L48;
            case -908189618: goto L44;
            case -908189617: goto L41;
            case -760884510: goto L37;
            case -760884509: goto L33;
            case -40300674: goto L29;
            case -4379043: goto L25;
            case 37232917: goto L21;
            case 92909918: goto L17;
            default: goto L15;
        };
    L15:
        r5 = -1;
    L71:
        switch(r5) {
            case 0: goto L114;
            case 1: goto L111;
            case 2: goto L108;
            case 3: goto L105;
            case 4: goto L102;
            case 5: goto L99;
            case 6: goto L96;
            case 7: goto L93;
            case 8: goto L90;
            case 9: goto L87;
            case 10: goto L84;
            case 11: goto L81;
            case 12: goto L78;
            case 13: goto L74;
            default: goto L4;
        };
    L74:
        if (Float.isNaN(this.j) == true) goto L4;
        int r3 = this.f13686b;
        float r4 = this.j;
    L76:
        r2.a(r3, r4);
        goto L4
    L78:
        if (Float.isNaN(this.q) == true) goto L4;
        r3 = this.f13686b;
        r4 = this.q;
        goto L76
    L81:
        if (Float.isNaN(this.k) == true) goto L4;
        r3 = this.f13686b;
        r4 = this.k;
        goto L76
    L84:
        if (Float.isNaN(this.l) == true) goto L4;
        r3 = this.f13686b;
        r4 = this.l;
        goto L76
    L87:
        if (Float.isNaN(this.n) == true) goto L4;
        r3 = this.f13686b;
        r4 = this.p;
        goto L76
    L90:
        if (Float.isNaN(this.m) == true) goto L4;
        r3 = this.f13686b;
        r4 = this.o;
        goto L76
    L93:
        if (Float.isNaN(this.s) == true) goto L4;
        r3 = this.f13686b;
        r4 = this.s;
        goto L76
    L96:
        if (Float.isNaN(this.r) == true) goto L4;
        r3 = this.f13686b;
        r4 = this.r;
        goto L76
    L99:
        if (Float.isNaN(this.w) == true) goto L4;
        r3 = this.f13686b;
        r4 = this.w;
        goto L76
    L102:
        if (Float.isNaN(this.v) == true) goto L4;
        r3 = this.f13686b;
        r4 = this.v;
        goto L76
    L105:
        if (Float.isNaN(this.u) == true) goto L4;
        r3 = this.f13686b;
        r4 = this.u;
        goto L76
    L108:
        if (Float.isNaN(this.t) == true) goto L4;
        r3 = this.f13686b;
        r4 = this.t;
        goto L76
    L111:
        if (Float.isNaN(this.n) == true) goto L4;
        r3 = this.f13686b;
        r4 = this.n;
        goto L76
    L114:
        if (Float.isNaN(this.m) == true) goto L4;
        r3 = this.f13686b;
        r4 = this.m;
        goto L76
    L17:
        if (r1.equals("alpha") == false) goto L170;
        r5 = 13;
        goto L71
    L170:
        r5 = -1;
        goto L71
    L21:
        if (r1.equals("transitionPathRotate") == false) goto L171;
        r5 = 12;
        goto L71
    L171:
        r5 = -1;
        goto L71
    L25:
        if (r1.equals("elevation") == false) goto L172;
        r5 = 11;
        goto L71
    L172:
        r5 = -1;
        goto L71
    L29:
        if (r1.equals(Key.ROTATION) == false) goto L173;
        r5 = 10;
        goto L71
    L173:
        r5 = -1;
        goto L71
    L33:
        if (r1.equals(Key.PIVOT_Y) == false) goto L174;
        r5 = 9;
        goto L71
    L174:
        r5 = -1;
        goto L71
    L37:
        if (r1.equals(Key.PIVOT_X) == false) goto L175;
        r5 = 8;
        goto L71
    L175:
        r5 = -1;
        goto L71
    L41:
        if (r1.equals("scaleY") == true) goto L71;
        r5 = -1;
        goto L71
    L44:
        if (r1.equals("scaleX") == false) goto L177;
        r5 = 6;
        goto L71
    L177:
        r5 = -1;
        goto L71
    L48:
        if (r1.equals("progress") == false) goto L178;
        r5 = 5;
        goto L71
    L178:
        r5 = -1;
        goto L71
    L52:
        if (r1.equals("translationZ") == false) goto L179;
        r5 = 4;
        goto L71
    L179:
        r5 = -1;
        goto L71
    L56:
        if (r1.equals("translationY") == false) goto L180;
        r5 = 3;
        goto L71
    L180:
        r5 = -1;
        goto L71
    L60:
        if (r1.equals("translationX") == false) goto L181;
        r5 = 2;
        goto L71
    L181:
        r5 = -1;
        goto L71
    L64:
        if (r1.equals("rotationY") == false) goto L182;
        r5 = 1;
        goto L71
    L182:
        r5 = -1;
        goto L71
    L68:
        if (r1.equals("rotationX") == false) goto L183;
        r5 = 0;
        goto L71
    L183:
        r5 = -1;
        goto L71
    L10:
        ConstraintAttribute r6 = (ConstraintAttribute) ZeusTransformUtils.preCheckCast(this.f.get(r1.substring(7)), ConstraintAttribute.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L4;
        ((com.obric.oui.constraintlayout.motion.a.d.b) ZeusTransformUtils.preCheckCast(r2, com.obric.oui.constraintlayout.motion.a.d.b.class, "com.obric.memorydata.plugin")).a(this.f13686b, r6);
        goto L4
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public void a(HashSet<String> r4) {
        if (Float.isNaN(this.j) == true) goto L6;
        r4.add("alpha");
    L6:
        if (Float.isNaN(this.k) == true) goto L9;
        r4.add("elevation");
    L9:
        if (Float.isNaN(this.l) == true) goto L12;
        r4.add(Key.ROTATION);
    L12:
        if (Float.isNaN(this.m) == true) goto L15;
        r4.add("rotationX");
    L15:
        if (Float.isNaN(this.n) == true) goto L18;
        r4.add("rotationY");
    L18:
        if (Float.isNaN(this.o) == true) goto L21;
        r4.add(Key.PIVOT_X);
    L21:
        if (Float.isNaN(this.p) == true) goto L24;
        r4.add(Key.PIVOT_Y);
    L24:
        if (Float.isNaN(this.t) == true) goto L27;
        r4.add("translationX");
    L27:
        if (Float.isNaN(this.u) == true) goto L30;
        r4.add("translationY");
    L30:
        if (Float.isNaN(this.v) == true) goto L33;
        r4.add("translationZ");
    L33:
        if (Float.isNaN(this.q) == true) goto L36;
        r4.add("transitionPathRotate");
    L36:
        if (Float.isNaN(this.r) == true) goto L39;
        r4.add("scaleX");
    L39:
        if (Float.isNaN(this.s) == true) goto L42;
        r4.add("scaleY");
    L42:
        if (Float.isNaN(this.w) == true) goto L45;
        r4.add("progress");
    L45:
        if (this.f.size() <= 0) goto L50;
        Iterator<String> r3 = this.f.keySet().iterator();
    L48:
        if (r3.hasNext() == false) goto L52;
        r4.add("CUSTOM," + ((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin")));
        goto L48
    L52:
        return;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public void b(HashMap<String, Integer> r5) {
        if (this.h != (-1)) goto L6;
        return;
    L6:
        if (Float.isNaN(this.j) == true) goto L9;
        r5.put("alpha", Integer.valueOf(this.h));
    L9:
        if (Float.isNaN(this.k) == true) goto L12;
        r5.put("elevation", Integer.valueOf(this.h));
    L12:
        if (Float.isNaN(this.l) == true) goto L15;
        r5.put(Key.ROTATION, Integer.valueOf(this.h));
    L15:
        if (Float.isNaN(this.m) == true) goto L18;
        r5.put("rotationX", Integer.valueOf(this.h));
    L18:
        if (Float.isNaN(this.n) == true) goto L21;
        r5.put("rotationY", Integer.valueOf(this.h));
    L21:
        if (Float.isNaN(this.o) == true) goto L24;
        r5.put(Key.PIVOT_X, Integer.valueOf(this.h));
    L24:
        if (Float.isNaN(this.p) == true) goto L27;
        r5.put(Key.PIVOT_Y, Integer.valueOf(this.h));
    L27:
        if (Float.isNaN(this.t) == true) goto L30;
        r5.put("translationX", Integer.valueOf(this.h));
    L30:
        if (Float.isNaN(this.u) == true) goto L33;
        r5.put("translationY", Integer.valueOf(this.h));
    L33:
        if (Float.isNaN(this.v) == true) goto L36;
        r5.put("translationZ", Integer.valueOf(this.h));
    L36:
        if (Float.isNaN(this.q) == true) goto L39;
        r5.put("transitionPathRotate", Integer.valueOf(this.h));
    L39:
        if (Float.isNaN(this.r) == true) goto L42;
        r5.put("scaleX", Integer.valueOf(this.h));
    L42:
        if (Float.isNaN(this.s) == true) goto L45;
        r5.put("scaleY", Integer.valueOf(this.h));
    L45:
        if (Float.isNaN(this.w) == true) goto L48;
        r5.put("progress", Integer.valueOf(this.h));
    L48:
        if (this.f.size() <= 0) goto L53;
        Iterator<String> r0 = this.f.keySet().iterator();
    L51:
        if (r0.hasNext() == false) goto L55;
        r5.put("CUSTOM," + ((String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin")), Integer.valueOf(this.h));
        goto L51
    L55:
        return;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public /* synthetic */ Object clone() {
        return a();
    }
}
