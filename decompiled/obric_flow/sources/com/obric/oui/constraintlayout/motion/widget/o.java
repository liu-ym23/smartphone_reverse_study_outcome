package com.obric.oui.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f12858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12860c;
    public final LinkedHashMap d;
    public float e;
    public float f;
    public float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f12861h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f12862i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f12863j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f12864k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f12865l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f12866m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f12867n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f12868o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f12869p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f12870q;

    public o() {
        this.f12858a = 0.0f;
        this.f12859b = 0;
        this.d = new LinkedHashMap();
        this.e = 1.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.f12861h = 0.0f;
        this.f12862i = 1.0f;
        this.f12863j = 1.0f;
        this.f12864k = Float.NaN;
        this.f12865l = Float.NaN;
        this.f12866m = 0.0f;
        this.f12867n = 0.0f;
        this.f12868o = 0.0f;
        this.f12869p = Float.NaN;
        this.f12870q = Float.NaN;
    }

    public static boolean b(float r5, float r10) {
        if (Float.isNaN(r5) == true) goto L12;
        if (Float.isNaN(r10) == true) goto L12;
        if (Math.abs(r5 - r10) > 1.0E-6f) goto L10;
        return false;
    L10:
        return true;
    L12:
        if (Float.isNaN(r5) != Float.isNaN(r10)) goto L14;
        return false;
    L14:
        return true;
    }

    public final void a(HashMap r10, int r11) {
        Iterator r5 = r10.keySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L147;
        String r12 = (String) r5.next();
        jr.l r13 = (jr.l) r10.get(r12);
        if (r13 == null) goto L4;
        r12.getClass();
        float r14 = 1.0f;
        float r15 = 0.0f;
        byte r16 = -1;
        switch(r12.hashCode()) {
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
        switch(r16) {
            case 0: goto L143;
            case 1: goto L138;
            case 2: goto L133;
            case 3: goto L128;
            case 4: goto L123;
            case 5: goto L118;
            case 6: goto L113;
            case 7: goto L108;
            case 8: goto L103;
            case 9: goto L98;
            case 10: goto L93;
            case 11: goto L88;
            case 12: goto L83;
            case 13: goto L78;
            default: goto L69;
        };
    L78:
        if (Float.isNaN(this.e) == true) goto L81;
        r14 = this.e;
    L81:
        r13.b(r11, r14);
        goto L4
    L83:
        if (Float.isNaN(this.f12869p) == true) goto L86;
        r15 = this.f12869p;
    L86:
        r13.b(r11, r15);
        goto L4
    L88:
        if (Float.isNaN(this.f) == true) goto L91;
        r15 = this.f;
    L91:
        r13.b(r11, r15);
        goto L4
    L93:
        if (Float.isNaN(this.g) == true) goto L96;
        r15 = this.g;
    L96:
        r13.b(r11, r15);
        goto L4
    L98:
        if (Float.isNaN(this.f12865l) == true) goto L101;
        r15 = this.f12865l;
    L101:
        r13.b(r11, r15);
        goto L4
    L103:
        if (Float.isNaN(this.f12864k) == true) goto L106;
        r15 = this.f12864k;
    L106:
        r13.b(r11, r15);
        goto L4
    L108:
        if (Float.isNaN(this.f12863j) == true) goto L111;
        r14 = this.f12863j;
    L111:
        r13.b(r11, r14);
        goto L4
    L113:
        if (Float.isNaN(this.f12862i) == true) goto L116;
        r14 = this.f12862i;
    L116:
        r13.b(r11, r14);
        goto L4
    L118:
        if (Float.isNaN(this.f12870q) == true) goto L121;
        r15 = this.f12870q;
    L121:
        r13.b(r11, r15);
        goto L4
    L123:
        if (Float.isNaN(this.f12868o) == true) goto L126;
        r15 = this.f12868o;
    L126:
        r13.b(r11, r15);
        goto L4
    L128:
        if (Float.isNaN(this.f12867n) == true) goto L131;
        r15 = this.f12867n;
    L131:
        r13.b(r11, r15);
        goto L4
    L133:
        if (Float.isNaN(this.f12866m) == true) goto L136;
        r15 = this.f12866m;
    L136:
        r13.b(r11, r15);
        goto L4
    L138:
        if (Float.isNaN(this.f12858a) == true) goto L141;
        r15 = this.f12858a;
    L141:
        r13.b(r11, r15);
        goto L4
    L143:
        if (Float.isNaN(this.f12861h) == true) goto L146;
        r15 = this.f12861h;
    L146:
        r13.b(r11, r15);
        goto L4
    L69:
        if (r12.startsWith("CUSTOM") == true) goto L70;
        Log.e("MotionPaths", "UNKNOWN spline ".concat(r12));
        goto L4
    L70:
        String r17 = r12.split(",")[1];
        LinkedHashMap r18 = this.d;
        if (r18.containsKey(r17) == false) goto L4;
        lr.b r19 = (lr.b) r18.get(r17);
        if ((r13 instanceof jr.i) == true) goto L74;
        Log.e("MotionPaths", r12 + " ViewSpline not a CustomSet frame = " + r11 + ", value" + r19.a() + r13);
        goto L4
    L74:
        ((jr.i) r13).f.append(r11, r19);
        goto L4
    L12:
        if (r12.equals("alpha") == false) goto L67;
        r16 = 13;
        goto L67
    L16:
        if (r12.equals("transitionPathRotate") == false) goto L67;
        r16 = 12;
        goto L67
    L20:
        if (r12.equals("elevation") == false) goto L67;
        r16 = 11;
        goto L67
    L24:
        if (r12.equals("rotation") == false) goto L67;
        r16 = 10;
        goto L67
    L28:
        if (r12.equals("transformPivotY") == false) goto L67;
        r16 = 9;
        goto L67
    L32:
        if (r12.equals("transformPivotX") == false) goto L67;
        r16 = 8;
        goto L67
    L36:
        if (r12.equals("scaleY") == false) goto L67;
        r16 = 7;
        goto L67
    L40:
        if (r12.equals("scaleX") == false) goto L67;
        r16 = 6;
        goto L67
    L44:
        if (r12.equals(NotificationCompat.CATEGORY_PROGRESS) == false) goto L67;
        r16 = 5;
        goto L67
    L48:
        if (r12.equals("translationZ") == false) goto L67;
        r16 = 4;
        goto L67
    L52:
        if (r12.equals("translationY") == false) goto L67;
        r16 = 3;
        goto L67
    L56:
        if (r12.equals("translationX") == false) goto L67;
        r16 = 2;
        goto L67
    L60:
        if (r12.equals("rotationY") == false) goto L67;
        r16 = 1;
        goto L67
    L64:
        if (r12.equals("rotationX") == false) goto L67;
        r16 = 0;
        goto L67
    }

    public final void c(Rect r10, com.obric.oui.constraintlayout.widget.d r11, int r12, int r13) {
        r10.width();
        r10.height();
        com.obric.oui.constraintlayout.widget.c r14 = r11.h(r13);
        lr.i r15 = r14.f13064c;
        int r16 = r15.f19761c;
        this.f12859b = r16;
        int r5 = r15.f19760b;
        this.f12860c = r5;
        if (r5 == 0) goto L6;
        if (r16 != 0) goto L6;
        float r17 = 0.0f;
    L7:
        this.e = r17;
        lr.j r18 = r14.f;
        boolean r19 = r18.f19771m;
        this.f = r18.f19772n;
        this.g = r18.f19764b;
        this.f12861h = r18.f19765c;
        this.f12858a = r18.d;
        this.f12862i = r18.e;
        this.f12863j = r18.f;
        this.f12864k = r18.g;
        this.f12865l = r18.f19766h;
        this.f12866m = r18.f19768j;
        this.f12867n = r18.f19769k;
        this.f12868o = r18.f19770l;
        lr.h r20 = r14.d;
        gr.e.d(r20.d);
        this.f12869p = r20.f19753h;
        this.f12870q = r14.f13064c.e;
        Iterator r21 = r14.g.keySet().iterator();
    L9:
        if (r21.hasNext() == false) goto L16;
        String r110 = (String) r21.next();
        lr.b r22 = (lr.b) r14.g.get(r110);
        r22.getClass();
        int r23 = lr.a.f19694a[r22.f19697c.ordinal()];
        if (r23 == 1) goto L9;
        if (r23 == 2) goto L9;
        if (r23 == 3) goto L9;
        this.d.put(r110, r22);
        goto L9
    L16:
        if (r12 == 1) goto L25;
        if (r12 == 2) goto L22;
        if (r12 == 3) goto L25;
        if (r12 == 4) goto L22;
        return;
    L22:
        float r24 = this.g + 90.0f;
        this.g = r24;
        if (r24 <= 180.0f) goto L36;
        this.g = r24 - 360.0f;
        return;
    L36:
        return;
    L25:
        this.g -= 90.0f;
        return;
    L6:
        r17 = r15.d;
        goto L7
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object r5) {
        ((o) r5).getClass();
        return Float.compare(0.0f, 0.0f);
    }
}
