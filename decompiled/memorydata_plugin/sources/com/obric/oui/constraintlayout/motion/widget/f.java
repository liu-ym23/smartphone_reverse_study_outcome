package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.widget.Key;
import com.obric.memorydata.plugin.R;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class f extends d {
    private String g;
    private int h;
    private int i;
    private String j;
    private float k;
    private float l;
    private float m;
    private float n;
    private int o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;
    private float w;
    private float x;
    private float y;
    private float z;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static SparseIntArray f13688a;

        static {
            SparseIntArray r0 = new SparseIntArray();
            f13688a = r0;
            r0.append(ZeusTransformUtils.mapRes(R.styleable.KeyCycle_motionTarget, "styleable", "KeyCycle_motionTarget"), 1);
            f13688a.append(ZeusTransformUtils.mapRes(R.styleable.KeyCycle_framePosition, "styleable", "KeyCycle_framePosition"), 2);
            f13688a.append(ZeusTransformUtils.mapRes(R.styleable.KeyCycle_transitionEasing, "styleable", "KeyCycle_transitionEasing"), 3);
            f13688a.append(ZeusTransformUtils.mapRes(R.styleable.KeyCycle_curveFit, "styleable", "KeyCycle_curveFit"), 4);
            f13688a.append(ZeusTransformUtils.mapRes(R.styleable.KeyCycle_waveShape, "styleable", "KeyCycle_waveShape"), 5);
            f13688a.append(ZeusTransformUtils.mapRes(R.styleable.KeyCycle_wavePeriod, "styleable", "KeyCycle_wavePeriod"), 6);
            f13688a.append(ZeusTransformUtils.mapRes(R.styleable.KeyCycle_waveOffset, "styleable", "KeyCycle_waveOffset"), 7);
            f13688a.append(ZeusTransformUtils.mapRes(R.styleable.KeyCycle_waveVariesBy, "styleable", "KeyCycle_waveVariesBy"), 8);
            f13688a.append(ZeusTransformUtils.mapRes(R.styleable.KeyCycle_android_alpha, "styleable", "KeyCycle_android_alpha"), 9);
            f13688a.append(ZeusTransformUtils.mapRes(R.styleable.KeyCycle_android_elevation, "styleable", "KeyCycle_android_elevation"), 10);
            f13688a.append(ZeusTransformUtils.mapRes(R.styleable.KeyCycle_android_rotation, "styleable", "KeyCycle_android_rotation"), 11);
            f13688a.append(ZeusTransformUtils.mapRes(R.styleable.KeyCycle_android_rotationX, "styleable", "KeyCycle_android_rotationX"), 12);
            f13688a.append(ZeusTransformUtils.mapRes(R.styleable.KeyCycle_android_rotationY, "styleable", "KeyCycle_android_rotationY"), 13);
            f13688a.append(ZeusTransformUtils.mapRes(R.styleable.KeyCycle_transitionPathRotate, "styleable", "KeyCycle_transitionPathRotate"), 14);
            f13688a.append(ZeusTransformUtils.mapRes(R.styleable.KeyCycle_android_scaleX, "styleable", "KeyCycle_android_scaleX"), 15);
            f13688a.append(ZeusTransformUtils.mapRes(R.styleable.KeyCycle_android_scaleY, "styleable", "KeyCycle_android_scaleY"), 16);
            f13688a.append(ZeusTransformUtils.mapRes(R.styleable.KeyCycle_android_translationX, "styleable", "KeyCycle_android_translationX"), 17);
            f13688a.append(ZeusTransformUtils.mapRes(R.styleable.KeyCycle_android_translationY, "styleable", "KeyCycle_android_translationY"), 18);
            f13688a.append(ZeusTransformUtils.mapRes(R.styleable.KeyCycle_android_translationZ, "styleable", "KeyCycle_android_translationZ"), 19);
            f13688a.append(ZeusTransformUtils.mapRes(R.styleable.KeyCycle_motionProgress, "styleable", "KeyCycle_motionProgress"), 20);
            f13688a.append(ZeusTransformUtils.mapRes(R.styleable.KeyCycle_wavePhase, "styleable", "KeyCycle_wavePhase"), 21);
        }

        static /* synthetic */ void a(f r0, TypedArray r1) {
            b(r0, r1);
        }

        private static void b(f r5, TypedArray r6) {
            int r0 = r6.getIndexCount();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L45;
            int r2 = r6.getIndex(r1);
            switch(f13688a.get(r2)) {
                case 1: goto L36;
                case 2: goto L34;
                case 3: goto L33;
                case 4: goto L32;
                case 5: goto L28;
                case 6: goto L26;
                case 7: goto L22;
                case 8: goto L20;
                case 9: goto L19;
                case 10: goto L18;
                case 11: goto L17;
                case 12: goto L16;
                case 13: goto L15;
                case 14: goto L14;
                case 15: goto L13;
                case 16: goto L12;
                case 17: goto L11;
                case 18: goto L10;
                case 19: goto L9;
                case 20: goto L8;
                case 21: goto L7;
                default: goto L6;
            };
        L6:
            Log.e(TypedValues.CycleType.NAME, "unused attribute 0x" + Integer.toHexString(r2) + "   " + f13688a.get(r2));
        L44:
            r1 = r1 + 1;
            goto L3
        L7:
            f.o(r5, r6.getFloat(r2, f.r(r5)) / 360.0f);
            goto L44
        L8:
            f.n(r5, r6.getFloat(r2, f.q(r5)));
            goto L44
        L9:
            f.m(r5, r6.getDimension(r2, f.p(r5)));
            goto L44
        L10:
            f.l(r5, r6.getDimension(r2, f.o(r5)));
            goto L44
        L11:
            f.k(r5, r6.getDimension(r2, f.n(r5)));
            goto L44
        L12:
            f.j(r5, r6.getFloat(r2, f.m(r5)));
            goto L44
        L13:
            f.i(r5, r6.getFloat(r2, f.l(r5)));
            goto L44
        L14:
            f.h(r5, r6.getFloat(r2, f.k(r5)));
            goto L44
        L15:
            f.g(r5, r6.getFloat(r2, f.j(r5)));
            goto L44
        L16:
            f.f(r5, r6.getFloat(r2, f.i(r5)));
            goto L44
        L17:
            f.e(r5, r6.getFloat(r2, f.h(r5)));
            goto L44
        L18:
            f.d(r5, r6.getDimension(r2, f.g(r5)));
            goto L44
        L19:
            f.c(r5, r6.getFloat(r2, f.f(r5)));
            goto L44
        L20:
            f.c(r5, r6.getInt(r2, f.e(r5)));
            goto L44
        L26:
            f.a(r5, r6.getFloat(r2, f.c(r5)));
            goto L44
        L32:
            f.a(r5, r6.getInteger(r2, f.a(r5)));
            goto L44
        L33:
            f.a(r5, r6.getString(r2));
            goto L44
        L34:
            r5.f13686b = r6.getInt(r2, r5.f13686b);
            goto L44
        L22:
            if (r6.peekValue(r2).type != 5) goto L24;
            float r3 = r6.getDimension(r2, f.d(r5));
        L25:
            f.b(r5, r3);
            goto L44
        L24:
            r3 = r6.getFloat(r2, f.d(r5));
            goto L25
        L28:
            if (r6.peekValue(r2).type != 3) goto L30;
            f.b(r5, r6.getString(r2));
            int r4 = 7;
        L31:
            f.b(r5, r4);
            goto L44
        L30:
            r4 = r6.getInt(r2, f.b(r5));
            goto L31
        L36:
            if (MotionLayout.IS_IN_EDIT_MODE == false) goto L41;
            r5.c = r6.getResourceId(r2, r5.c);
            if (r5.c != (-1)) goto L44;
        L42:
            r5.d = r6.getString(r2);
            goto L44
        L41:
            if (r6.peekValue(r2).type == 3) goto L42;
            r5.c = r6.getResourceId(r2, r5.c);
            goto L44
        }
    }

    public f() {
        this.g = null;
        this.h = 0;
        this.i = -1;
        this.j = null;
        this.k = Float.NaN;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = Float.NaN;
        this.o = -1;
        this.p = Float.NaN;
        this.q = Float.NaN;
        this.r = Float.NaN;
        this.s = Float.NaN;
        this.t = Float.NaN;
        this.u = Float.NaN;
        this.v = Float.NaN;
        this.w = Float.NaN;
        this.x = Float.NaN;
        this.y = Float.NaN;
        this.z = Float.NaN;
        this.e = 4;
        this.f = new HashMap();
    }

    static /* synthetic */ float a(f r0, float r1) {
        r0.k = r1;
        return r1;
    }

    static /* synthetic */ int a(f r0) {
        return r0.h;
    }

    static /* synthetic */ int a(f r0, int r1) {
        r0.h = r1;
        return r1;
    }

    static /* synthetic */ String a(f r0, String r1) {
        r0.g = r1;
        return r1;
    }

    static /* synthetic */ float b(f r0, float r1) {
        r0.l = r1;
        return r1;
    }

    static /* synthetic */ int b(f r0) {
        return r0.i;
    }

    static /* synthetic */ int b(f r0, int r1) {
        r0.i = r1;
        return r1;
    }

    static /* synthetic */ String b(f r0, String r1) {
        r0.j = r1;
        return r1;
    }

    static /* synthetic */ float c(f r0) {
        return r0.k;
    }

    static /* synthetic */ float c(f r0, float r1) {
        r0.p = r1;
        return r1;
    }

    static /* synthetic */ int c(f r0, int r1) {
        r0.o = r1;
        return r1;
    }

    static /* synthetic */ float d(f r0) {
        return r0.l;
    }

    static /* synthetic */ float d(f r0, float r1) {
        r0.q = r1;
        return r1;
    }

    static /* synthetic */ float e(f r0, float r1) {
        r0.r = r1;
        return r1;
    }

    static /* synthetic */ int e(f r0) {
        return r0.o;
    }

    static /* synthetic */ float f(f r0) {
        return r0.p;
    }

    static /* synthetic */ float f(f r0, float r1) {
        r0.t = r1;
        return r1;
    }

    static /* synthetic */ float g(f r0) {
        return r0.q;
    }

    static /* synthetic */ float g(f r0, float r1) {
        r0.u = r1;
        return r1;
    }

    static /* synthetic */ float h(f r0) {
        return r0.r;
    }

    static /* synthetic */ float h(f r0, float r1) {
        r0.s = r1;
        return r1;
    }

    static /* synthetic */ float i(f r0) {
        return r0.t;
    }

    static /* synthetic */ float i(f r0, float r1) {
        r0.v = r1;
        return r1;
    }

    static /* synthetic */ float j(f r0) {
        return r0.u;
    }

    static /* synthetic */ float j(f r0, float r1) {
        r0.w = r1;
        return r1;
    }

    static /* synthetic */ float k(f r0) {
        return r0.s;
    }

    static /* synthetic */ float k(f r0, float r1) {
        r0.x = r1;
        return r1;
    }

    static /* synthetic */ float l(f r0) {
        return r0.v;
    }

    static /* synthetic */ float l(f r0, float r1) {
        r0.y = r1;
        return r1;
    }

    static /* synthetic */ float m(f r0) {
        return r0.w;
    }

    static /* synthetic */ float m(f r0, float r1) {
        r0.z = r1;
        return r1;
    }

    static /* synthetic */ float n(f r0) {
        return r0.x;
    }

    static /* synthetic */ float n(f r0, float r1) {
        r0.n = r1;
        return r1;
    }

    static /* synthetic */ float o(f r0) {
        return r0.y;
    }

    static /* synthetic */ float o(f r0, float r1) {
        r0.m = r1;
        return r1;
    }

    static /* synthetic */ float p(f r0) {
        return r0.z;
    }

    static /* synthetic */ float q(f r0) {
        return r0.n;
    }

    static /* synthetic */ float r(f r0) {
        return r0.m;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public d a() {
        return new f().a(this);
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public d a(d r3) {
        super.a(r3);
        f r4 = (f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.memorydata.plugin");
        this.g = r4.g;
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
        this.x = r4.x;
        this.y = r4.y;
        this.z = r4.z;
        return this;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public void a(Context r3, AttributeSet r4) {
        a.a(this, ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), R.styleable.KeyCycle));
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public void a(HashMap<String, com.obric.oui.constraintlayout.motion.a.d> r7) {
        com.obric.oui.constraintlayout.motion.widget.a.a(TypedValues.CycleType.NAME, "add " + r7.size() + " values", 2);
        Iterator<String> r0 = r7.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L86;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        com.obric.oui.constraintlayout.core.motion.a.j r3 = (com.obric.oui.constraintlayout.core.motion.a.j) ZeusTransformUtils.preCheckCast(r7.get(r1), com.obric.oui.constraintlayout.core.motion.a.j.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L4;
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
            case -40300674: goto L32;
            case -4379043: goto L28;
            case 37232917: goto L24;
            case 92909918: goto L20;
            case 156108012: goto L16;
            case 1530034690: goto L12;
            default: goto L67;
        };
    L67:
        switch(r4) {
            case 0: goto L85;
            case 1: goto L84;
            case 2: goto L83;
            case 3: goto L82;
            case 4: goto L81;
            case 5: goto L80;
            case 6: goto L79;
            case 7: goto L78;
            case 8: goto L77;
            case 9: goto L76;
            case 10: goto L75;
            case 11: goto L73;
            case 12: goto L72;
            case 13: goto L71;
            default: goto L69;
        };
    L71:
        int r2 = this.f13686b;
        float r5 = this.m;
    L74:
        r3.a(r2, r5);
        goto L4
    L72:
        r2 = this.f13686b;
        r5 = this.l;
        goto L74
    L73:
        r2 = this.f13686b;
        r5 = this.p;
        goto L74
    L75:
        r2 = this.f13686b;
        r5 = this.s;
        goto L74
    L76:
        r2 = this.f13686b;
        r5 = this.q;
        goto L74
    L77:
        r2 = this.f13686b;
        r5 = this.r;
        goto L74
    L78:
        r2 = this.f13686b;
        r5 = this.w;
        goto L74
    L79:
        r2 = this.f13686b;
        r5 = this.v;
        goto L74
    L80:
        r2 = this.f13686b;
        r5 = this.n;
        goto L74
    L81:
        r2 = this.f13686b;
        r5 = this.z;
        goto L74
    L82:
        r2 = this.f13686b;
        r5 = this.y;
        goto L74
    L83:
        r2 = this.f13686b;
        r5 = this.x;
        goto L74
    L84:
        r2 = this.f13686b;
        r5 = this.u;
        goto L74
    L85:
        r2 = this.f13686b;
        r5 = this.t;
        goto L74
    L69:
        if (r1.startsWith("CUSTOM") == true) goto L4;
        Log.v("WARNING KeyCycle", "  UNKNOWN  " + r1);
        goto L4
    L12:
        if (r1.equals("wavePhase") == false) goto L67;
        r4 = 13;
        goto L67
    L16:
        if (r1.equals("waveOffset") == false) goto L67;
        r4 = 12;
        goto L67
    L20:
        if (r1.equals("alpha") == false) goto L67;
        r4 = 11;
        goto L67
    L24:
        if (r1.equals("transitionPathRotate") == false) goto L67;
        r4 = 10;
        goto L67
    L28:
        if (r1.equals("elevation") == false) goto L67;
        r4 = 9;
        goto L67
    L32:
        if (r1.equals(Key.ROTATION) == false) goto L67;
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

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public void a(HashSet<String> r4) {
        if (Float.isNaN(this.p) == true) goto L6;
        r4.add("alpha");
    L6:
        if (Float.isNaN(this.q) == true) goto L9;
        r4.add("elevation");
    L9:
        if (Float.isNaN(this.r) == true) goto L12;
        r4.add(Key.ROTATION);
    L12:
        if (Float.isNaN(this.t) == true) goto L15;
        r4.add("rotationX");
    L15:
        if (Float.isNaN(this.u) == true) goto L18;
        r4.add("rotationY");
    L18:
        if (Float.isNaN(this.v) == true) goto L21;
        r4.add("scaleX");
    L21:
        if (Float.isNaN(this.w) == true) goto L24;
        r4.add("scaleY");
    L24:
        if (Float.isNaN(this.s) == true) goto L27;
        r4.add("transitionPathRotate");
    L27:
        if (Float.isNaN(this.x) == true) goto L30;
        r4.add("translationX");
    L30:
        if (Float.isNaN(this.y) == true) goto L33;
        r4.add("translationY");
    L33:
        if (Float.isNaN(this.z) == true) goto L36;
        r4.add("translationZ");
    L36:
        if (this.f.size() <= 0) goto L41;
        Iterator<String> r3 = this.f.keySet().iterator();
    L39:
        if (r3.hasNext() == false) goto L43;
        r4.add("CUSTOM," + ((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin")));
        goto L39
    L43:
        return;
    }

    public float b(String r3) {
        r3.hashCode();
        byte r1 = -1;
        switch(r3.hashCode()) {
            case -1249320806: goto L58;
            case -1249320805: goto L54;
            case -1225497657: goto L50;
            case -1225497656: goto L46;
            case -1225497655: goto L42;
            case -1001078227: goto L38;
            case -908189618: goto L34;
            case -908189617: goto L30;
            case -40300674: goto L26;
            case -4379043: goto L22;
            case 37232917: goto L18;
            case 92909918: goto L14;
            case 156108012: goto L10;
            case 1530034690: goto L6;
            default: goto L61;
        };
    L61:
        switch(r1) {
            case 0: goto L94;
            case 1: goto L92;
            case 2: goto L90;
            case 3: goto L88;
            case 4: goto L86;
            case 5: goto L84;
            case 6: goto L82;
            case 7: goto L80;
            case 8: goto L78;
            case 9: goto L76;
            case 10: goto L74;
            case 11: goto L72;
            case 12: goto L70;
            case 13: goto L68;
            default: goto L63;
        };
    L63:
        if (r3.startsWith("CUSTOM") == true) goto L95;
        Log.v("WARNING! KeyCycle", "  UNKNOWN  " + r3);
        return Float.NaN;
    L95:
        return Float.NaN;
    L68:
        return this.m;
    L70:
        return this.l;
    L72:
        return this.p;
    L74:
        return this.s;
    L76:
        return this.q;
    L78:
        return this.r;
    L80:
        return this.w;
    L82:
        return this.v;
    L84:
        return this.n;
    L86:
        return this.z;
    L88:
        return this.y;
    L90:
        return this.x;
    L92:
        return this.u;
    L94:
        return this.t;
    L6:
        if (r3.equals("wavePhase") == false) goto L61;
        r1 = 13;
        goto L61
    L10:
        if (r3.equals("waveOffset") == false) goto L61;
        r1 = 12;
        goto L61
    L14:
        if (r3.equals("alpha") == false) goto L61;
        r1 = 11;
        goto L61
    L18:
        if (r3.equals("transitionPathRotate") == false) goto L61;
        r1 = 10;
        goto L61
    L22:
        if (r3.equals("elevation") == false) goto L61;
        r1 = 9;
        goto L61
    L26:
        if (r3.equals(Key.ROTATION) == false) goto L61;
        r1 = 8;
        goto L61
    L30:
        if (r3.equals("scaleY") == false) goto L61;
        r1 = 7;
        goto L61
    L34:
        if (r3.equals("scaleX") == false) goto L61;
        r1 = 6;
        goto L61
    L38:
        if (r3.equals("progress") == false) goto L61;
        r1 = 5;
        goto L61
    L42:
        if (r3.equals("translationZ") == false) goto L61;
        r1 = 4;
        goto L61
    L46:
        if (r3.equals("translationY") == false) goto L61;
        r1 = 3;
        goto L61
    L50:
        if (r3.equals("translationX") == false) goto L61;
        r1 = 2;
        goto L61
    L54:
        if (r3.equals("rotationY") == false) goto L61;
        r1 = 1;
        goto L61
    L58:
        if (r3.equals("rotationX") == false) goto L61;
        r1 = 0;
        goto L61
    }

    public void c(HashMap<String, com.obric.oui.constraintlayout.motion.a.c> r26) {
        Iterator<String> r2 = r26.keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L23;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        if (r3.startsWith("CUSTOM") == true) goto L7;
        float r24 = b(r3);
        if (Float.isNaN(r24) == true) goto L4;
        com.obric.oui.constraintlayout.motion.a.c r16 = (com.obric.oui.constraintlayout.motion.a.c) ZeusTransformUtils.preCheckCast(r26.get(r3), com.obric.oui.constraintlayout.motion.a.c.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L4;
        r16.a(this.f13686b, this.i, this.j, this.o, this.k, this.l, this.m, r24);
        goto L4
    L7:
        String r4 = r3.substring(7);
        ConstraintAttribute r15 = (ConstraintAttribute) ZeusTransformUtils.preCheckCast(this.f.get(r4), ConstraintAttribute.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L4;
        if (r15.getType() != ConstraintAttribute.AttributeType.FLOAT_TYPE) goto L4;
        com.obric.oui.constraintlayout.motion.a.c r6 = (com.obric.oui.constraintlayout.motion.a.c) ZeusTransformUtils.preCheckCast(r26.get(r3), com.obric.oui.constraintlayout.motion.a.c.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L4;
        r6.a(this.f13686b, this.i, this.j, this.o, this.k, this.l, this.m, r15.d(), r15);
        goto L4
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public /* synthetic */ Object clone() {
        return a();
    }
}
