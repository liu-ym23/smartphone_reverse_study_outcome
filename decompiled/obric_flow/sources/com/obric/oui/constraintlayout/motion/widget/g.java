package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.core.app.NotificationCompat;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute$AttributeType;
import com.obric.oui.constraintlayout.widget.R$styleable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends c {
    public int e;
    public int f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f12758h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f12759i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f12760j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f12761k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f12762l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f12763m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f12764n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f12765o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f12766p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f12767q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f12768r;
    public float s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f12769t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f12770u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f12771v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f12772w;

    public g() {
        this.e = 0;
        this.f = -1;
        this.g = null;
        this.f12758h = Float.NaN;
        this.f12759i = 0.0f;
        this.f12760j = 0.0f;
        this.f12761k = Float.NaN;
        this.f12762l = -1;
        this.f12763m = Float.NaN;
        this.f12764n = Float.NaN;
        this.f12765o = Float.NaN;
        this.f12766p = Float.NaN;
        this.f12767q = Float.NaN;
        this.f12768r = Float.NaN;
        this.s = Float.NaN;
        this.f12769t = Float.NaN;
        this.f12770u = Float.NaN;
        this.f12771v = Float.NaN;
        this.f12772w = Float.NaN;
        this.d = new HashMap();
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public final void a(HashMap r5) {
        throw null;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public final c b() {
        g r5 = new g();
        super.c(this);
        r5.e = this.e;
        r5.f = this.f;
        r5.g = this.g;
        r5.f12758h = this.f12758h;
        r5.f12759i = this.f12759i;
        r5.f12760j = this.f12760j;
        r5.f12761k = this.f12761k;
        r5.f12762l = this.f12762l;
        r5.f12763m = this.f12763m;
        r5.f12764n = this.f12764n;
        r5.f12765o = this.f12765o;
        r5.f12766p = this.f12766p;
        r5.f12767q = this.f12767q;
        r5.f12768r = this.f12768r;
        r5.s = this.s;
        r5.f12769t = this.f12769t;
        r5.f12770u = this.f12770u;
        r5.f12771v = this.f12771v;
        r5.f12772w = this.f12772w;
        return r5;
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return b();
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public final void d(HashSet r5) {
        if (Float.isNaN(this.f12763m) == true) goto L6;
        r5.add("alpha");
    L6:
        if (Float.isNaN(this.f12764n) == true) goto L9;
        r5.add("elevation");
    L9:
        if (Float.isNaN(this.f12765o) == true) goto L12;
        r5.add("rotation");
    L12:
        if (Float.isNaN(this.f12767q) == true) goto L15;
        r5.add("rotationX");
    L15:
        if (Float.isNaN(this.f12768r) == true) goto L18;
        r5.add("rotationY");
    L18:
        if (Float.isNaN(this.s) == true) goto L21;
        r5.add("scaleX");
    L21:
        if (Float.isNaN(this.f12769t) == true) goto L24;
        r5.add("scaleY");
    L24:
        if (Float.isNaN(this.f12766p) == true) goto L27;
        r5.add("transitionPathRotate");
    L27:
        if (Float.isNaN(this.f12770u) == true) goto L30;
        r5.add("translationX");
    L30:
        if (Float.isNaN(this.f12771v) == true) goto L33;
        r5.add("translationY");
    L33:
        if (Float.isNaN(this.f12772w) == true) goto L36;
        r5.add("translationZ");
    L36:
        if (this.d.size() <= 0) goto L41;
        Iterator r10 = this.d.keySet().iterator();
    L39:
        if (r10.hasNext() == false) goto L43;
        r5.add("CUSTOM," + ((String) r10.next()));
        goto L39
    L43:
        return;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public final void e(Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.KeyCycle);
        SparseIntArray r13 = f.f12757a;
        int r14 = r12.getIndexCount();
        int r5 = 0;
    L3:
        if (r5 >= r14) goto L43;
        int r15 = r12.getIndex(r5);
        SparseIntArray r16 = f.f12757a;
        switch(r16.get(r15)) {
            case 1: goto L34;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L30;
            case 5: goto L27;
            case 6: goto L25;
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
        Log.e("KeyCycle", "unused attribute 0x" + Integer.toHexString(r15) + "   " + r16.get(r15));
    L42:
        r5 = r5 + 1;
        goto L3
    L7:
        this.f12760j = r12.getFloat(r15, this.f12760j) / 360.0f;
        goto L42
    L8:
        this.f12761k = r12.getFloat(r15, this.f12761k);
        goto L42
    L9:
        this.f12772w = r12.getDimension(r15, this.f12772w);
        goto L42
    L10:
        this.f12771v = r12.getDimension(r15, this.f12771v);
        goto L42
    L11:
        this.f12770u = r12.getDimension(r15, this.f12770u);
        goto L42
    L12:
        this.f12769t = r12.getFloat(r15, this.f12769t);
        goto L42
    L13:
        this.s = r12.getFloat(r15, this.s);
        goto L42
    L14:
        this.f12766p = r12.getFloat(r15, this.f12766p);
        goto L42
    L15:
        this.f12768r = r12.getFloat(r15, this.f12768r);
        goto L42
    L16:
        this.f12767q = r12.getFloat(r15, this.f12767q);
        goto L42
    L17:
        this.f12765o = r12.getFloat(r15, this.f12765o);
        goto L42
    L18:
        this.f12764n = r12.getDimension(r15, this.f12764n);
        goto L42
    L19:
        this.f12763m = r12.getFloat(r15, this.f12763m);
        goto L42
    L20:
        this.f12762l = r12.getInt(r15, this.f12762l);
        goto L42
    L25:
        this.f12758h = r12.getFloat(r15, this.f12758h);
        goto L42
    L30:
        this.e = r12.getInteger(r15, this.e);
        goto L42
    L31:
        r12.getString(r15);
        goto L42
    L32:
        this.f12713a = r12.getInt(r15, this.f12713a);
        goto L42
    L22:
        if (r12.peekValue(r15).type != 5) goto L24;
        this.f12759i = r12.getDimension(r15, this.f12759i);
        goto L42
    L24:
        this.f12759i = r12.getFloat(r15, this.f12759i);
        goto L42
    L27:
        if (r12.peekValue(r15).type != 3) goto L29;
        this.g = r12.getString(r15);
        this.f = 7;
        goto L42
    L29:
        this.f = r12.getInt(r15, this.f);
        goto L42
    L34:
        if (MotionLayout.F0 == false) goto L39;
        int r17 = r12.getResourceId(r15, this.f12714b);
        this.f12714b = r17;
        if (r17 != (-1)) goto L42;
        this.f12715c = r12.getString(r15);
        goto L42
    L39:
        if (r12.peekValue(r15).type != 3) goto L41;
        this.f12715c = r12.getString(r15);
        goto L42
    L41:
        this.f12714b = r12.getResourceId(r15, this.f12714b);
        goto L42
    }

    public final void h(HashMap r17) {
        int r5 = 7;
        Iterator r10 = r17.keySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L109;
        String r11 = (String) r10.next();
        if (r11.startsWith("CUSTOM") == false) goto L21;
        String r12 = r11.substring(r5);
        lr.b r13 = (lr.b) this.d.get(r12);
        if (r13 == null) goto L4;
        ConstraintAttribute$AttributeType r14 = ConstraintAttribute$AttributeType.FLOAT_TYPE;
        if (r13.f19697c != r14) goto L4;
        jr.g r15 = (jr.g) r17.get(r11);
        if (r15 == null) goto L4;
        int r16 = this.f12713a;
        int r18 = this.f;
        String r19 = this.g;
        int r110 = this.f12762l;
        float r20 = this.f12758h;
        float r111 = this.f12759i;
        float r112 = this.f12760j;
        float r113 = r13.a();
        r15.f.add(new gr.f(r16, r20, r111, r112, r113));
        if (r110 == (-1)) goto L18;
        r15.e = r110;
    L18:
        r15.f18437c = r18;
        r15.d(r13);
        r15.d = r19;
    L19:
        r5 = 7;
        goto L4
    L21:
        switch(r11.hashCode()) {
            case -1249320806: goto L76;
            case -1249320805: goto L72;
            case -1225497657: goto L68;
            case -1225497656: goto L64;
            case -1225497655: goto L60;
            case -1001078227: goto L56;
            case -908189618: goto L52;
            case -908189617: goto L48;
            case -40300674: goto L44;
            case -4379043: goto L40;
            case 37232917: goto L36;
            case 92909918: goto L32;
            case 156108012: goto L28;
            case 1530034690: goto L24;
            default: goto L22;
        };
    L22:
        byte r21 = -1;
    L79:
        switch(r21) {
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
            default: goto L81;
        };
    L85:
        float r22 = this.f12760j;
    L84:
        float r114 = r22;
        if (Float.isNaN(r114) == true) goto L19;
        jr.g r23 = (jr.g) r17.get(r11);
        if (r23 == null) goto L19;
        int r24 = this.f12713a;
        int r25 = this.f;
        String r26 = this.g;
        int r115 = this.f12762l;
        float r27 = this.f12758h;
        float r28 = this.f12759i;
        float r116 = this.f12760j;
        r23.f.add(new gr.f(r24, r27, r28, r116, r114));
        if (r115 == (-1)) goto L108;
        r23.e = r115;
    L108:
        r23.f18437c = r25;
        r23.d = r26;
        goto L19
    L86:
        r22 = this.f12759i;
        goto L84
    L87:
        r22 = this.f12763m;
        goto L84
    L88:
        r22 = this.f12766p;
        goto L84
    L89:
        r22 = this.f12764n;
        goto L84
    L90:
        r22 = this.f12765o;
        goto L84
    L91:
        r22 = this.f12769t;
        goto L84
    L92:
        r22 = this.s;
        goto L84
    L93:
        r22 = this.f12761k;
        goto L84
    L94:
        r22 = this.f12772w;
        goto L84
    L95:
        r22 = this.f12771v;
        goto L84
    L96:
        r22 = this.f12770u;
        goto L84
    L97:
        r22 = this.f12768r;
        goto L84
    L98:
        r22 = this.f12767q;
        goto L84
    L81:
        if (r11.startsWith("CUSTOM") == true) goto L83;
        Log.v("WARNING! KeyCycle", "  UNKNOWN  ".concat(r11));
    L83:
        r22 = Float.NaN;
        goto L84
    L24:
        if (r11.equals("wavePhase") == false) goto L22;
        r21 = 13;
        goto L79
    L28:
        if (r11.equals("waveOffset") == false) goto L22;
        r21 = 12;
        goto L79
    L32:
        if (r11.equals("alpha") == false) goto L22;
        r21 = 11;
        goto L79
    L36:
        if (r11.equals("transitionPathRotate") == false) goto L22;
        r21 = 10;
        goto L79
    L40:
        if (r11.equals("elevation") == false) goto L22;
        r21 = 9;
        goto L79
    L44:
        if (r11.equals("rotation") == false) goto L22;
        r21 = 8;
        goto L79
    L48:
        if (r11.equals("scaleY") == false) goto L22;
        r21 = 7;
        goto L79
    L52:
        if (r11.equals("scaleX") == false) goto L22;
        r21 = 6;
        goto L79
    L56:
        if (r11.equals(NotificationCompat.CATEGORY_PROGRESS) == false) goto L22;
        r21 = 5;
        goto L79
    L60:
        if (r11.equals("translationZ") == false) goto L22;
        r21 = 4;
        goto L79
    L64:
        if (r11.equals("translationY") == false) goto L22;
        r21 = 3;
        goto L79
    L68:
        if (r11.equals("translationX") == false) goto L22;
        r21 = 2;
        goto L79
    L72:
        if (r11.equals("rotationY") == false) goto L22;
        r21 = 1;
        goto L79
    L76:
        if (r11.equals("rotationX") == false) goto L22;
        r21 = 0;
        goto L79
    }
}
