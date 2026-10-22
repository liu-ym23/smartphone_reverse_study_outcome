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
public final class l extends c {
    public int e;
    public float f;
    public float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f12829h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f12830i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f12831j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f12832k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f12833l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f12834m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f12835n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f12836o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f12837p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f12838q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f12839r;
    public float s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f12840t;

    public l() {
        this.e = -1;
        this.f = Float.NaN;
        this.g = Float.NaN;
        this.f12829h = Float.NaN;
        this.f12830i = Float.NaN;
        this.f12831j = Float.NaN;
        this.f12832k = Float.NaN;
        this.f12833l = Float.NaN;
        this.f12834m = Float.NaN;
        this.f12835n = Float.NaN;
        this.f12836o = Float.NaN;
        this.f12837p = Float.NaN;
        this.f12838q = Float.NaN;
        this.f12839r = 0;
        this.s = Float.NaN;
        this.f12840t = 0.0f;
        this.d = new HashMap();
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public final void a(HashMap r5) {
        throw null;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public final c b() {
        l r5 = new l();
        super.c(this);
        r5.e = this.e;
        r5.f12839r = this.f12839r;
        r5.s = this.s;
        r5.f12840t = this.f12840t;
        r5.f12838q = this.f12838q;
        r5.f = this.f;
        r5.g = this.g;
        r5.f12829h = this.f12829h;
        r5.f12832k = this.f12832k;
        r5.f12830i = this.f12830i;
        r5.f12831j = this.f12831j;
        r5.f12833l = this.f12833l;
        r5.f12834m = this.f12834m;
        r5.f12835n = this.f12835n;
        r5.f12836o = this.f12836o;
        r5.f12837p = this.f12837p;
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
        if (Float.isNaN(this.f12829h) == true) goto L12;
        r5.add("rotation");
    L12:
        if (Float.isNaN(this.f12830i) == true) goto L15;
        r5.add("rotationX");
    L15:
        if (Float.isNaN(this.f12831j) == true) goto L18;
        r5.add("rotationY");
    L18:
        if (Float.isNaN(this.f12835n) == true) goto L21;
        r5.add("translationX");
    L21:
        if (Float.isNaN(this.f12836o) == true) goto L24;
        r5.add("translationY");
    L24:
        if (Float.isNaN(this.f12837p) == true) goto L27;
        r5.add("translationZ");
    L27:
        if (Float.isNaN(this.f12832k) == true) goto L30;
        r5.add("transitionPathRotate");
    L30:
        if (Float.isNaN(this.f12833l) == true) goto L33;
        r5.add("scaleX");
    L33:
        if (Float.isNaN(this.f12834m) == true) goto L36;
        r5.add("scaleY");
    L36:
        if (Float.isNaN(this.f12838q) == true) goto L39;
        r5.add(NotificationCompat.CATEGORY_PROGRESS);
    L39:
        if (this.d.size() <= 0) goto L44;
        Iterator r10 = this.d.keySet().iterator();
    L42:
        if (r10.hasNext() == false) goto L46;
        r5.add("CUSTOM," + ((String) r10.next()));
        goto L42
    L46:
        return;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public final void e(Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.KeyTimeCycle);
        SparseIntArray r13 = k.f12828a;
        int r14 = r12.getIndexCount();
        int r5 = 0;
    L3:
        if (r5 >= r14) goto L41;
        int r15 = r12.getIndex(r5);
        SparseIntArray r16 = k.f12828a;
        switch(r16.get(r15)) {
            case 1: goto L39;
            case 2: goto L38;
            case 3: goto L6;
            case 4: goto L37;
            case 5: goto L36;
            case 6: goto L35;
            case 7: goto L34;
            case 8: goto L33;
            case 9: goto L32;
            case 10: goto L24;
            case 11: goto L6;
            case 12: goto L22;
            case 13: goto L21;
            case 14: goto L20;
            case 15: goto L19;
            case 16: goto L18;
            case 17: goto L17;
            case 18: goto L16;
            case 19: goto L13;
            case 20: goto L11;
            case 21: goto L8;
            default: goto L6;
        };
    L6:
        Log.e("KeyTimeCycle", "unused attribute 0x" + Integer.toHexString(r15) + "   " + r16.get(r15));
    L40:
        r5 = r5 + 1;
        goto L3
    L11:
        this.s = r12.getFloat(r15, this.s);
        goto L40
    L16:
        this.f12838q = r12.getFloat(r15, this.f12838q);
        goto L40
    L17:
        this.f12837p = r12.getDimension(r15, this.f12837p);
        goto L40
    L18:
        this.f12836o = r12.getDimension(r15, this.f12836o);
        goto L40
    L19:
        this.f12835n = r12.getDimension(r15, this.f12835n);
        goto L40
    L20:
        this.f12834m = r12.getFloat(r15, this.f12834m);
        goto L40
    L21:
        this.e = r12.getInteger(r15, this.e);
        goto L40
    L22:
        this.f12713a = r12.getInt(r15, this.f12713a);
        goto L40
    L32:
        r12.getString(r15);
        goto L40
    L33:
        this.f12832k = r12.getFloat(r15, this.f12832k);
        goto L40
    L34:
        this.f12833l = r12.getFloat(r15, this.f12833l);
        goto L40
    L35:
        this.f12831j = r12.getFloat(r15, this.f12831j);
        goto L40
    L36:
        this.f12830i = r12.getFloat(r15, this.f12830i);
        goto L40
    L37:
        this.f12829h = r12.getFloat(r15, this.f12829h);
        goto L40
    L38:
        this.g = r12.getDimension(r15, this.g);
        goto L40
    L39:
        this.f = r12.getFloat(r15, this.f);
        goto L40
    L8:
        if (r12.peekValue(r15).type != 5) goto L10;
        this.f12840t = r12.getDimension(r15, this.f12840t);
        goto L40
    L10:
        this.f12840t = r12.getFloat(r15, this.f12840t);
        goto L40
    L13:
        if (r12.peekValue(r15).type != 3) goto L15;
        r12.getString(r15);
        this.f12839r = 7;
        goto L40
    L15:
        this.f12839r = r12.getInt(r15, this.f12839r);
        goto L40
    L24:
        if (MotionLayout.F0 == false) goto L29;
        int r17 = r12.getResourceId(r15, this.f12714b);
        this.f12714b = r17;
        if (r17 != (-1)) goto L40;
        this.f12715c = r12.getString(r15);
        goto L40
    L29:
        if (r12.peekValue(r15).type != 3) goto L31;
        this.f12715c = r12.getString(r15);
        goto L40
    L31:
        this.f12714b = r12.getResourceId(r15, this.f12714b);
        goto L40
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
        if (Float.isNaN(this.f12829h) == true) goto L15;
        r5.put("rotation", Integer.valueOf(this.e));
    L15:
        if (Float.isNaN(this.f12830i) == true) goto L18;
        r5.put("rotationX", Integer.valueOf(this.e));
    L18:
        if (Float.isNaN(this.f12831j) == true) goto L21;
        r5.put("rotationY", Integer.valueOf(this.e));
    L21:
        if (Float.isNaN(this.f12835n) == true) goto L24;
        r5.put("translationX", Integer.valueOf(this.e));
    L24:
        if (Float.isNaN(this.f12836o) == true) goto L27;
        r5.put("translationY", Integer.valueOf(this.e));
    L27:
        if (Float.isNaN(this.f12837p) == true) goto L30;
        r5.put("translationZ", Integer.valueOf(this.e));
    L30:
        if (Float.isNaN(this.f12832k) == true) goto L33;
        r5.put("transitionPathRotate", Integer.valueOf(this.e));
    L33:
        if (Float.isNaN(this.f12833l) == true) goto L36;
        r5.put("scaleX", Integer.valueOf(this.e));
    L36:
        if (Float.isNaN(this.f12833l) == true) goto L39;
        r5.put("scaleY", Integer.valueOf(this.e));
    L39:
        if (Float.isNaN(this.f12838q) == true) goto L42;
        r5.put(NotificationCompat.CATEGORY_PROGRESS, Integer.valueOf(this.e));
    L42:
        if (this.d.size() <= 0) goto L47;
        Iterator r10 = this.d.keySet().iterator();
    L45:
        if (r10.hasNext() == false) goto L49;
        r5.put(ai.j0.C("CUSTOM,", (String) r10.next()), Integer.valueOf(this.e));
        goto L45
    L49:
        return;
    }

    public final void h(HashMap r14) {
        Iterator r5 = r14.keySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L102;
        String r10 = (String) r5.next();
        jr.q r11 = (jr.q) r14.get(r10);
        if (r11 == null) goto L4;
        if (r10.startsWith("CUSTOM") == true) goto L10;
        byte r12 = -1;
        switch(r10.hashCode()) {
            case -1249320806: goto L61;
            case -1249320805: goto L57;
            case -1225497657: goto L53;
            case -1225497656: goto L49;
            case -1225497655: goto L45;
            case -1001078227: goto L41;
            case -908189618: goto L37;
            case -908189617: goto L33;
            case -40300674: goto L29;
            case -4379043: goto L25;
            case 37232917: goto L21;
            case 92909918: goto L17;
            default: goto L64;
        };
    L64:
        switch(r12) {
            case 0: goto L100;
            case 1: goto L97;
            case 2: goto L94;
            case 3: goto L91;
            case 4: goto L88;
            case 5: goto L85;
            case 6: goto L82;
            case 7: goto L79;
            case 8: goto L76;
            case 9: goto L73;
            case 10: goto L70;
            case 11: goto L67;
            default: goto L65;
        };
    L67:
        if (Float.isNaN(this.f) == true) goto L4;
        r11.c(this.f12713a, this.f, this.s, this.f12839r, this.f12840t);
        goto L4
    L70:
        if (Float.isNaN(this.f12832k) == true) goto L4;
        r11.c(this.f12713a, this.f12832k, this.s, this.f12839r, this.f12840t);
        goto L4
    L73:
        if (Float.isNaN(this.g) == true) goto L4;
        r11.c(this.f12713a, this.g, this.s, this.f12839r, this.f12840t);
        goto L4
    L76:
        if (Float.isNaN(this.f12829h) == true) goto L4;
        r11.c(this.f12713a, this.f12829h, this.s, this.f12839r, this.f12840t);
        goto L4
    L79:
        if (Float.isNaN(this.f12834m) == true) goto L4;
        r11.c(this.f12713a, this.f12834m, this.s, this.f12839r, this.f12840t);
        goto L4
    L82:
        if (Float.isNaN(this.f12833l) == true) goto L4;
        r11.c(this.f12713a, this.f12833l, this.s, this.f12839r, this.f12840t);
        goto L4
    L85:
        if (Float.isNaN(this.f12838q) == true) goto L4;
        r11.c(this.f12713a, this.f12838q, this.s, this.f12839r, this.f12840t);
        goto L4
    L88:
        if (Float.isNaN(this.f12837p) == true) goto L4;
        r11.c(this.f12713a, this.f12837p, this.s, this.f12839r, this.f12840t);
        goto L4
    L91:
        if (Float.isNaN(this.f12836o) == true) goto L4;
        r11.c(this.f12713a, this.f12836o, this.s, this.f12839r, this.f12840t);
        goto L4
    L94:
        if (Float.isNaN(this.f12835n) == true) goto L4;
        r11.c(this.f12713a, this.f12835n, this.s, this.f12839r, this.f12840t);
        goto L4
    L97:
        if (Float.isNaN(this.f12831j) == true) goto L4;
        r11.c(this.f12713a, this.f12831j, this.s, this.f12839r, this.f12840t);
        goto L4
    L100:
        if (Float.isNaN(this.f12830i) == true) goto L4;
        r11.c(this.f12713a, this.f12830i, this.s, this.f12839r, this.f12840t);
        goto L4
    L65:
        Log.e("KeyTimeCycles", "UNKNOWN addValues \"" + r10 + "\"");
        goto L4
    L17:
        if (r10.equals("alpha") == false) goto L64;
        r12 = 11;
        goto L64
    L21:
        if (r10.equals("transitionPathRotate") == false) goto L64;
        r12 = 10;
        goto L64
    L25:
        if (r10.equals("elevation") == false) goto L64;
        r12 = 9;
        goto L64
    L29:
        if (r10.equals("rotation") == false) goto L64;
        r12 = 8;
        goto L64
    L33:
        if (r10.equals("scaleY") == false) goto L64;
        r12 = 7;
        goto L64
    L37:
        if (r10.equals("scaleX") == false) goto L64;
        r12 = 6;
        goto L64
    L41:
        if (r10.equals(NotificationCompat.CATEGORY_PROGRESS) == false) goto L64;
        r12 = 5;
        goto L64
    L45:
        if (r10.equals("translationZ") == false) goto L64;
        r12 = 4;
        goto L64
    L49:
        if (r10.equals("translationY") == false) goto L64;
        r12 = 3;
        goto L64
    L53:
        if (r10.equals("translationX") == false) goto L64;
        r12 = 2;
        goto L64
    L57:
        if (r10.equals("rotationY") == false) goto L64;
        r12 = 1;
        goto L64
    L61:
        if (r10.equals("rotationX") == false) goto L64;
        r12 = 0;
        goto L64
    L10:
        lr.b r13 = (lr.b) this.d.get(r10.substring(7));
        if (r13 == null) goto L4;
        jr.n r15 = (jr.n) r11;
        int r16 = this.f12713a;
        float r17 = this.s;
        int r18 = this.f12839r;
        float r19 = this.f12840t;
        r15.f18443l.append(r16, r13);
        r15.f18444m.append(r16, new float[]{r17, r19});
        r15.f18448b = Math.max(r15.f18448b, r18);
        goto L4
    }
}
