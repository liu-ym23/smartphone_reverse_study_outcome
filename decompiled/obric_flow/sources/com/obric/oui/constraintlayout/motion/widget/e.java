package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.core.app.NotificationCompat;
import com.obric.oui.constraintlayout.widget.R$styleable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends c {
    public int e;
    public float f;
    public float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f12745h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f12746i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f12747j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f12748k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f12749l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f12750m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f12751n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f12752o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f12753p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f12754q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f12755r;
    public float s;

    public e() {
        this.e = -1;
        this.f = Float.NaN;
        this.g = Float.NaN;
        this.f12745h = Float.NaN;
        this.f12746i = Float.NaN;
        this.f12747j = Float.NaN;
        this.f12748k = Float.NaN;
        this.f12749l = Float.NaN;
        this.f12750m = Float.NaN;
        this.f12751n = Float.NaN;
        this.f12752o = Float.NaN;
        this.f12753p = Float.NaN;
        this.f12754q = Float.NaN;
        this.f12755r = Float.NaN;
        this.s = Float.NaN;
        this.d = new HashMap();
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public final void a(HashMap r10) {
        Iterator r5 = r10.keySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L116;
        String r11 = (String) r5.next();
        jr.l r12 = (jr.l) r10.get(r11);
        if (r12 == null) goto L4;
        if (r11.startsWith("CUSTOM") == true) goto L10;
        byte r13 = -1;
        switch(r11.hashCode()) {
            case -1249320806: goto L69;
            case -1249320805: goto L65;
            case -1225497657: goto L61;
            case -1225497656: goto L57;
            case -1225497655: goto L53;
            case -1001078227: goto L49;
            case -908189618: goto L45;
            case -908189617: goto L41;
            case -760884510: goto L37;
            case -760884509: goto L33;
            case -40300674: goto L29;
            case -4379043: goto L25;
            case 37232917: goto L21;
            case 92909918: goto L17;
            default: goto L72;
        };
    L72:
        switch(r13) {
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
            case 13: goto L75;
            default: goto L4;
        };
    L75:
        if (Float.isNaN(this.f) == true) goto L4;
        r12.b(this.f12713a, this.f);
        goto L4
    L78:
        if (Float.isNaN(this.f12750m) == true) goto L4;
        r12.b(this.f12713a, this.f12750m);
        goto L4
    L81:
        if (Float.isNaN(this.g) == true) goto L4;
        r12.b(this.f12713a, this.g);
        goto L4
    L84:
        if (Float.isNaN(this.f12745h) == true) goto L4;
        r12.b(this.f12713a, this.f12745h);
        goto L4
    L87:
        if (Float.isNaN(this.f12747j) == true) goto L4;
        r12.b(this.f12713a, this.f12749l);
        goto L4
    L90:
        if (Float.isNaN(this.f12746i) == true) goto L4;
        r12.b(this.f12713a, this.f12748k);
        goto L4
    L93:
        if (Float.isNaN(this.f12752o) == true) goto L4;
        r12.b(this.f12713a, this.f12752o);
        goto L4
    L96:
        if (Float.isNaN(this.f12751n) == true) goto L4;
        r12.b(this.f12713a, this.f12751n);
        goto L4
    L99:
        if (Float.isNaN(this.s) == true) goto L4;
        r12.b(this.f12713a, this.s);
        goto L4
    L102:
        if (Float.isNaN(this.f12755r) == true) goto L4;
        r12.b(this.f12713a, this.f12755r);
        goto L4
    L105:
        if (Float.isNaN(this.f12754q) == true) goto L4;
        r12.b(this.f12713a, this.f12754q);
        goto L4
    L108:
        if (Float.isNaN(this.f12753p) == true) goto L4;
        r12.b(this.f12713a, this.f12753p);
        goto L4
    L111:
        if (Float.isNaN(this.f12747j) == true) goto L4;
        r12.b(this.f12713a, this.f12747j);
        goto L4
    L114:
        if (Float.isNaN(this.f12746i) == true) goto L4;
        r12.b(this.f12713a, this.f12746i);
        goto L4
    L17:
        if (r11.equals("alpha") == false) goto L72;
        r13 = 13;
        goto L72
    L21:
        if (r11.equals("transitionPathRotate") == false) goto L72;
        r13 = 12;
        goto L72
    L25:
        if (r11.equals("elevation") == false) goto L72;
        r13 = 11;
        goto L72
    L29:
        if (r11.equals("rotation") == false) goto L72;
        r13 = 10;
        goto L72
    L33:
        if (r11.equals("transformPivotY") == false) goto L72;
        r13 = 9;
        goto L72
    L37:
        if (r11.equals("transformPivotX") == false) goto L72;
        r13 = 8;
        goto L72
    L41:
        if (r11.equals("scaleY") == false) goto L72;
        r13 = 7;
        goto L72
    L45:
        if (r11.equals("scaleX") == false) goto L72;
        r13 = 6;
        goto L72
    L49:
        if (r11.equals(NotificationCompat.CATEGORY_PROGRESS) == false) goto L72;
        r13 = 5;
        goto L72
    L53:
        if (r11.equals("translationZ") == false) goto L72;
        r13 = 4;
        goto L72
    L57:
        if (r11.equals("translationY") == false) goto L72;
        r13 = 3;
        goto L72
    L61:
        if (r11.equals("translationX") == false) goto L72;
        r13 = 2;
        goto L72
    L65:
        if (r11.equals("rotationY") == false) goto L72;
        r13 = 1;
        goto L72
    L69:
        if (r11.equals("rotationX") == false) goto L72;
        r13 = 0;
        goto L72
    L10:
        lr.b r14 = (lr.b) this.d.get(r11.substring(7));
        if (r14 == null) goto L4;
        ((jr.i) r12).f.append(this.f12713a, r14);
        goto L4
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public final c b() {
        e r5 = new e();
        super.c(this);
        r5.e = this.e;
        r5.f = this.f;
        r5.g = this.g;
        r5.f12745h = this.f12745h;
        r5.f12746i = this.f12746i;
        r5.f12747j = this.f12747j;
        r5.f12748k = this.f12748k;
        r5.f12749l = this.f12749l;
        r5.f12750m = this.f12750m;
        r5.f12751n = this.f12751n;
        r5.f12752o = this.f12752o;
        r5.f12753p = this.f12753p;
        r5.f12754q = this.f12754q;
        r5.f12755r = this.f12755r;
        r5.s = this.s;
        return r5;
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return b();
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public final void d(HashSet r5) {
        if (Float.isNaN(this.f) == true) goto L6;
        r5.add("alpha");
    L6:
        if (Float.isNaN(this.g) == true) goto L9;
        r5.add("elevation");
    L9:
        if (Float.isNaN(this.f12745h) == true) goto L12;
        r5.add("rotation");
    L12:
        if (Float.isNaN(this.f12746i) == true) goto L15;
        r5.add("rotationX");
    L15:
        if (Float.isNaN(this.f12747j) == true) goto L18;
        r5.add("rotationY");
    L18:
        if (Float.isNaN(this.f12748k) == true) goto L21;
        r5.add("transformPivotX");
    L21:
        if (Float.isNaN(this.f12749l) == true) goto L24;
        r5.add("transformPivotY");
    L24:
        if (Float.isNaN(this.f12753p) == true) goto L27;
        r5.add("translationX");
    L27:
        if (Float.isNaN(this.f12754q) == true) goto L30;
        r5.add("translationY");
    L30:
        if (Float.isNaN(this.f12755r) == true) goto L33;
        r5.add("translationZ");
    L33:
        if (Float.isNaN(this.f12750m) == true) goto L36;
        r5.add("transitionPathRotate");
    L36:
        if (Float.isNaN(this.f12751n) == true) goto L39;
        r5.add("scaleX");
    L39:
        if (Float.isNaN(this.f12752o) == true) goto L42;
        r5.add("scaleY");
    L42:
        if (Float.isNaN(this.s) == true) goto L45;
        r5.add(NotificationCompat.CATEGORY_PROGRESS);
    L45:
        if (this.d.size() <= 0) goto L50;
        Iterator r10 = this.d.keySet().iterator();
    L48:
        if (r10.hasNext() == false) goto L52;
        r5.add("CUSTOM," + ((String) r10.next()));
        goto L48
    L52:
        return;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public final void e(Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.KeyAttribute);
        SparseIntArray r13 = d.f12730a;
        int r14 = r12.getIndexCount();
        int r5 = 0;
    L3:
        if (r5 >= r14) goto L34;
        int r15 = r12.getIndex(r5);
        SparseIntArray r16 = d.f12730a;
        switch(r16.get(r15)) {
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
        Log.e("KeyAttribute", "unused attribute 0x" + Integer.toHexString(r15) + "   " + r16.get(r15));
    L33:
        r5 = r5 + 1;
        goto L3
    L7:
        this.f12749l = r12.getDimension(r15, this.f12749l);
        goto L33
    L8:
        this.f12748k = r12.getDimension(r15, this.f12748k);
        goto L33
    L9:
        this.s = r12.getFloat(r15, this.s);
        goto L33
    L10:
        this.f12755r = r12.getDimension(r15, this.f12755r);
        goto L33
    L11:
        this.f12754q = r12.getDimension(r15, this.f12754q);
        goto L33
    L12:
        this.f12753p = r12.getDimension(r15, this.f12753p);
        goto L33
    L13:
        this.f12752o = r12.getFloat(r15, this.f12752o);
        goto L33
    L14:
        this.e = r12.getInteger(r15, this.e);
        goto L33
    L15:
        this.f12713a = r12.getInt(r15, this.f12713a);
        goto L33
    L25:
        r12.getString(r15);
        goto L33
    L26:
        this.f12750m = r12.getFloat(r15, this.f12750m);
        goto L33
    L27:
        this.f12751n = r12.getFloat(r15, this.f12751n);
        goto L33
    L28:
        this.f12747j = r12.getFloat(r15, this.f12747j);
        goto L33
    L29:
        this.f12746i = r12.getFloat(r15, this.f12746i);
        goto L33
    L30:
        this.f12745h = r12.getFloat(r15, this.f12745h);
        goto L33
    L31:
        this.g = r12.getDimension(r15, this.g);
        goto L33
    L32:
        this.f = r12.getFloat(r15, this.f);
        goto L33
    L17:
        if (MotionLayout.F0 == false) goto L22;
        int r17 = r12.getResourceId(r15, this.f12714b);
        this.f12714b = r17;
        if (r17 != (-1)) goto L33;
        this.f12715c = r12.getString(r15);
        goto L33
    L22:
        if (r12.peekValue(r15).type != 3) goto L24;
        this.f12715c = r12.getString(r15);
        goto L33
    L24:
        this.f12714b = r12.getResourceId(r15, this.f12714b);
        goto L33
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public final void f(HashMap r5) {
        if (this.e != (-1)) goto L6;
        return;
    L6:
        if (Float.isNaN(this.f) == true) goto L9;
        r5.put("alpha", Integer.valueOf(this.e));
    L9:
        if (Float.isNaN(this.g) == true) goto L12;
        r5.put("elevation", Integer.valueOf(this.e));
    L12:
        if (Float.isNaN(this.f12745h) == true) goto L15;
        r5.put("rotation", Integer.valueOf(this.e));
    L15:
        if (Float.isNaN(this.f12746i) == true) goto L18;
        r5.put("rotationX", Integer.valueOf(this.e));
    L18:
        if (Float.isNaN(this.f12747j) == true) goto L21;
        r5.put("rotationY", Integer.valueOf(this.e));
    L21:
        if (Float.isNaN(this.f12748k) == true) goto L24;
        r5.put("transformPivotX", Integer.valueOf(this.e));
    L24:
        if (Float.isNaN(this.f12749l) == true) goto L27;
        r5.put("transformPivotY", Integer.valueOf(this.e));
    L27:
        if (Float.isNaN(this.f12753p) == true) goto L30;
        r5.put("translationX", Integer.valueOf(this.e));
    L30:
        if (Float.isNaN(this.f12754q) == true) goto L33;
        r5.put("translationY", Integer.valueOf(this.e));
    L33:
        if (Float.isNaN(this.f12755r) == true) goto L36;
        r5.put("translationZ", Integer.valueOf(this.e));
    L36:
        if (Float.isNaN(this.f12750m) == true) goto L39;
        r5.put("transitionPathRotate", Integer.valueOf(this.e));
    L39:
        if (Float.isNaN(this.f12751n) == true) goto L42;
        r5.put("scaleX", Integer.valueOf(this.e));
    L42:
        if (Float.isNaN(this.f12752o) == true) goto L45;
        r5.put("scaleY", Integer.valueOf(this.e));
    L45:
        if (Float.isNaN(this.s) == true) goto L48;
        r5.put(NotificationCompat.CATEGORY_PROGRESS, Integer.valueOf(this.e));
    L48:
        if (this.d.size() <= 0) goto L53;
        Iterator r10 = this.d.keySet().iterator();
    L51:
        if (r10.hasNext() == false) goto L55;
        r5.put(ai.j0.C("CUSTOM,", (String) r10.next()), Integer.valueOf(this.e));
        goto L51
    L55:
        return;
    }

    public final void h(String r5, Object r10) {
        byte r11 = -1;
        switch(r5.hashCode()) {
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
        switch(r11) {
            case 0: goto L98;
            case 1: goto L97;
            case 2: goto L96;
            case 3: goto L95;
            case 4: goto L94;
            case 5: goto L93;
            case 6: goto L92;
            case 7: goto L91;
            case 8: goto L90;
            case 9: goto L89;
            case 10: goto L88;
            case 11: goto L87;
            case 12: goto L86;
            case 13: goto L85;
            case 14: goto L84;
            case 15: goto L79;
            case 16: goto L76;
            default: goto L116;
        };
    L79:
        Number r12 = (Number) r10;
        if ((r12 instanceof Integer) == false) goto L82;
        int r13 = ((Integer) r12).intValue();
    L83:
        this.e = r13;
        return;
    L82:
        r13 = Integer.parseInt(r12.toString());
        goto L83
    L84:
        this.f = c.g((Number) r10);
        return;
    L85:
        this.f12750m = c.g((Number) r10);
        return;
    L86:
        this.g = c.g((Number) r10);
        return;
    L87:
        this.f12745h = c.g((Number) r10);
        return;
    L88:
        this.f12749l = c.g((Number) r10);
        return;
    L89:
        this.f12748k = c.g((Number) r10);
        return;
    L90:
        this.f12752o = c.g((Number) r10);
        return;
    L91:
        this.f12751n = c.g((Number) r10);
        return;
    L92:
        this.f12755r = c.g((Number) r10);
        return;
    L93:
        this.f12754q = c.g((Number) r10);
        return;
    L94:
        this.f12753p = c.g((Number) r10);
        return;
    L95:
        this.f12747j = c.g((Number) r10);
        return;
    L96:
        this.f12746i = c.g((Number) r10);
        return;
    L97:
        r10.toString();
        return;
    L98:
        this.s = c.g((Number) r10);
        return;
    L116:
        return;
    L76:
        if ((r10 instanceof Boolean) == true) goto L117;
        Boolean.parseBoolean(r10.toString());
        return;
    L117:
        return;
    L6:
        if (r5.equals("visibility") == false) goto L73;
        r11 = 16;
        goto L73
    L10:
        if (r5.equals("curveFit") == false) goto L73;
        r11 = 15;
        goto L73
    L14:
        if (r5.equals("alpha") == false) goto L73;
        r11 = 14;
        goto L73
    L18:
        if (r5.equals("transitionPathRotate") == false) goto L73;
        r11 = 13;
        goto L73
    L22:
        if (r5.equals("elevation") == false) goto L73;
        r11 = 12;
        goto L73
    L26:
        if (r5.equals("rotation") == false) goto L73;
        r11 = 11;
        goto L73
    L30:
        if (r5.equals("transformPivotY") == false) goto L73;
        r11 = 10;
        goto L73
    L34:
        if (r5.equals("transformPivotX") == false) goto L73;
        r11 = 9;
        goto L73
    L38:
        if (r5.equals("scaleY") == false) goto L73;
        r11 = 8;
        goto L73
    L42:
        if (r5.equals("scaleX") == false) goto L73;
        r11 = 7;
        goto L73
    L46:
        if (r5.equals("translationZ") == false) goto L73;
        r11 = 6;
        goto L73
    L50:
        if (r5.equals("translationY") == false) goto L73;
        r11 = 5;
        goto L73
    L54:
        if (r5.equals("translationX") == false) goto L73;
        r11 = 4;
        goto L73
    L58:
        if (r5.equals("rotationY") == false) goto L73;
        r11 = 3;
        goto L73
    L62:
        if (r5.equals("rotationX") == false) goto L73;
        r11 = 2;
        goto L73
    L66:
        if (r5.equals("transitionEasing") == false) goto L73;
        r11 = 1;
        goto L73
    L70:
        if (r5.equals("motionProgress") == false) goto L73;
        r11 = 0;
        goto L73
    }
}
