package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.obric.oui.constraintlayout.widget.R$styleable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends c {
    public float e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12842h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RectF f12843i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RectF f12844j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public HashMap f12845k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f12846l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f12847m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f12848n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f12849o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f12850p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f12851q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f12852r;
    public boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f12853t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f12854u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f12855v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f12856w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f12857x;

    public n() {
        this.e = 0.1f;
        this.f = -1;
        this.g = -1;
        this.f12842h = -1;
        this.f12843i = new RectF();
        this.f12844j = new RectF();
        this.f12845k = new HashMap();
        this.f12846l = null;
        this.f12847m = -1;
        this.f12848n = null;
        this.f12849o = null;
        this.f12850p = -1;
        this.f12851q = -1;
        this.f12852r = null;
        this.s = true;
        this.f12853t = true;
        this.f12854u = true;
        this.f12855v = Float.NaN;
        this.f12857x = false;
        this.d = new HashMap();
    }

    public static void j(RectF r5, View r10, boolean r11) {
        r5.top = r10.getTop();
        r5.bottom = r10.getBottom();
        r5.left = r10.getLeft();
        r5.right = r10.getRight();
        if (r11 == false) goto L6;
        r10.getMatrix().mapRect(r5);
        return;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public final void a(HashMap r5) {
        throw null;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public final c b() {
        n r5 = new n();
        super.c(this);
        r5.f12846l = this.f12846l;
        r5.f12847m = this.f12847m;
        r5.f12848n = this.f12848n;
        r5.f12849o = this.f12849o;
        r5.f12850p = this.f12850p;
        r5.f12851q = this.f12851q;
        r5.f12852r = this.f12852r;
        r5.e = this.e;
        r5.s = this.s;
        r5.f12853t = this.f12853t;
        r5.f12854u = this.f12854u;
        r5.f12855v = this.f12855v;
        r5.f12856w = this.f12856w;
        r5.f12857x = this.f12857x;
        r5.f12843i = this.f12843i;
        r5.f12844j = this.f12844j;
        r5.f12845k = this.f12845k;
        return r5;
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return b();
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public final void d(HashSet r5) {
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public final void e(Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.KeyTrigger);
        SparseIntArray r13 = m.f12841a;
        int r14 = r12.getIndexCount();
        int r5 = 0;
    L3:
        if (r5 >= r14) goto L29;
        int r15 = r12.getIndex(r5);
        SparseIntArray r16 = m.f12841a;
        switch(r16.get(r15)) {
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L6;
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L15;
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L11;
            case 11: goto L10;
            case 12: goto L9;
            case 13: goto L8;
            case 14: goto L7;
            default: goto L6;
        };
    L6:
        Log.e("KeyTrigger", "unused attribute 0x" + Integer.toHexString(r15) + "   " + r16.get(r15));
    L28:
        r5 = r5 + 1;
        goto L3
    L7:
        this.g = r12.getResourceId(r15, this.g);
        goto L28
    L8:
        this.f = r12.getResourceId(r15, this.f);
        goto L28
    L9:
        this.f12842h = r12.getResourceId(r15, this.f12842h);
        goto L28
    L10:
        this.f12847m = r12.getResourceId(r15, this.f12847m);
        goto L28
    L11:
        this.f12857x = r12.getBoolean(r15, this.f12857x);
        goto L28
    L12:
        this.f12851q = r12.getResourceId(r15, this.f12851q);
        goto L28
    L13:
        int r17 = r12.getInteger(r15, this.f12713a);
        this.f12713a = r17;
        this.f12855v = (r17 + 0.5f) / 100.0f;
        goto L28
    L23:
        this.f12850p = r12.getResourceId(r15, this.f12850p);
        goto L28
    L24:
        this.e = r12.getFloat(r15, this.e);
        goto L28
    L25:
        this.f12846l = r12.getString(r15);
        goto L28
    L26:
        this.f12849o = r12.getString(r15);
        goto L28
    L27:
        this.f12848n = r12.getString(r15);
        goto L28
    L15:
        if (MotionLayout.F0 == false) goto L20;
        int r18 = r12.getResourceId(r15, this.f12714b);
        this.f12714b = r18;
        if (r18 != (-1)) goto L28;
        this.f12715c = r12.getString(r15);
        goto L28
    L20:
        if (r12.peekValue(r15).type != 3) goto L22;
        this.f12715c = r12.getString(r15);
        goto L28
    L22:
        this.f12714b = r12.getResourceId(r15, this.f12714b);
        goto L28
    }

    public final void h(float r11, View r12) {
        boolean r5 = true;
        boolean r10 = false;
        if (this.f12851q == (-1)) goto L29;
        if (this.f12852r != null) goto L7;
        this.f12852r = ((ViewGroup) r12.getParent()).findViewById(this.f12851q);
    L7:
        j(this.f12843i, this.f12852r, this.f12857x);
        j(this.f12844j, r12, this.f12857x);
        if (this.f12843i.intersect(this.f12844j) == false) goto L19;
        if (this.s == false) goto L12;
        this.s = false;
        boolean r13 = true;
    L14:
        if (this.f12854u == false) goto L16;
        this.f12854u = false;
        boolean r14 = true;
    L17:
        this.f12853t = true;
    L27:
        r5 = r14;
    L60:
        this.f12856w = r11;
        if (r10 == true) goto L64;
        if (r13 == true) goto L64;
        if (r5 == true) goto L64;
    L71:
        if (this.f12847m != (-1)) goto L73;
        View r15 = r12;
    L74:
        if (r10 == false) goto L81;
        String r16 = this.f12848n;
        if (r16 == null) goto L79;
        i(r15, r16);
    L79:
        if (this.f == (-1)) goto L81;
        ((MotionLayout) r12.getParent()).L(this.f, new View[]{r15});
    L81:
        if (r5 == false) goto L88;
        String r17 = this.f12849o;
        if (r17 == null) goto L86;
        i(r15, r17);
    L86:
        if (this.g == (-1)) goto L88;
        ((MotionLayout) r12.getParent()).L(this.g, new View[]{r15});
    L88:
        if (r13 == false) goto L97;
        String r18 = this.f12846l;
        if (r18 == null) goto L93;
        i(r15, r18);
    L93:
        if (this.f12842h == (-1)) goto L98;
        ((MotionLayout) r12.getParent()).L(this.f12842h, new View[]{r15});
        return;
    L98:
        return;
    L97:
        return;
    L73:
        r15 = ((MotionLayout) r12.getParent()).findViewById(this.f12847m);
    L64:
        MotionLayout r19 = (MotionLayout) r12.getParent();
        z r20 = r19.J;
        CopyOnWriteArrayList r110 = r19.f12667e0;
        if (r110 == null) goto L71;
        Iterator r111 = r110.iterator();
    L68:
        if (r111.hasNext() == false) goto L71;
        ((z) r111.next()).getClass();
        goto L68
    L16:
        r14 = false;
        goto L17
    L12:
        r13 = false;
        goto L14
    L19:
        if (this.s == true) goto L21;
        this.s = true;
        r13 = true;
    L23:
        if (this.f12853t == false) goto L25;
        this.f12853t = false;
        boolean r21 = true;
    L26:
        this.f12854u = true;
        boolean r22 = r21;
        r14 = false;
        r10 = r22;
        goto L27
    L25:
        r21 = false;
        goto L26
    L21:
        r13 = false;
        goto L23
    L29:
        if (this.s == false) goto L34;
        float r23 = this.f12855v;
        if (((this.f12856w - r23) * (r11 - r23)) >= 0.0f) goto L36;
        this.s = false;
        r13 = true;
    L38:
        if (this.f12853t == false) goto L45;
        float r24 = this.f12855v;
        float r25 = r11 - r24;
        if (((this.f12856w - r24) * r25) < 0.0f) goto L42;
    L47:
        boolean r26 = false;
    L49:
        if (this.f12854u == false) goto L57;
        float r27 = this.f12855v;
        float r28 = r11 - r27;
        if (((this.f12856w - r27) * r28) < 0.0f) goto L53;
    L59:
        r5 = false;
    L55:
        r10 = r26;
        goto L60
    L53:
        if (r28 <= 0.0f) goto L59;
        this.f12854u = false;
        goto L55
    L57:
        if (Math.abs(r11 - this.f12855v) <= this.e) goto L59;
        this.f12854u = true;
        goto L59
    L42:
        if (r25 >= 0.0f) goto L47;
        this.f12853t = false;
        r26 = true;
        goto L49
    L45:
        if (Math.abs(r11 - this.f12855v) <= this.e) goto L47;
        this.f12853t = true;
    L36:
        r13 = false;
        goto L38
    L34:
        if (Math.abs(r11 - this.f12855v) <= this.e) goto L36;
        this.s = true;
        goto L36
    }

    public final void i(View r12, String r13) {
        if (r13 != null) goto L5;
        return;
    L5:
        if (r13.startsWith(".") == false) goto L47;
        if (r13.length() != 1) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == true) goto L12;
        r13 = r13.substring(1).toLowerCase(Locale.ROOT);
    L12:
        Iterator r10 = this.d.keySet().iterator();
    L14:
        if (r10.hasNext() == false) goto L45;
        String r11 = (String) r10.next();
        String r14 = r11.toLowerCase(Locale.ROOT);
        if (r5 == true) goto L19;
        if (r14.matches(r13) == false) goto L14;
    L19:
        lr.b r15 = (lr.b) this.d.get(r11);
        if (r15 == null) goto L14;
        Class<?> r16 = r12.getClass();
        boolean r17 = r15.f19695a;
        String r18 = r15.f19696b;
        if (r17 == true) goto L24;
        String r19 = ai.j0.C("set", r18);
    L66:
    L26:
        switch(lr.a.f19694a[r15.f19697c.ordinal()]) {
            case 1: goto L40;
            case 2: goto L39;
            case 3: goto L38;
            case 4: goto L37;
            case 5: goto L36;
            case 6: goto L40;
            case 7: goto L35;
            case 8: goto L28;
            default: goto L14;
        };     // Catch: InvocationTargetException -> L29 IllegalAccessException -> L31 NoSuchMethodException -> L33
    L28:
        r16.getMethod(r19, new Class[]{Float.TYPE}).invoke(r12, new Object[]{Float.valueOf(r15.e)});     // Catch: InvocationTargetException -> L29 IllegalAccessException -> L31 NoSuchMethodException -> L33
        goto L14
    L35:
        r16.getMethod(r19, new Class[]{Float.TYPE}).invoke(r12, new Object[]{Float.valueOf(r15.e)});     // Catch: InvocationTargetException -> L29 IllegalAccessException -> L31 NoSuchMethodException -> L33
        goto L14
    L36:
        Method r20 = r16.getMethod(r19, new Class[]{Drawable.class});     // Catch: InvocationTargetException -> L29 IllegalAccessException -> L31 NoSuchMethodException -> L33
        ColorDrawable r110 = new ColorDrawable();     // Catch: InvocationTargetException -> L29 IllegalAccessException -> L31 NoSuchMethodException -> L33
        r110.setColor(r15.f19698h);     // Catch: InvocationTargetException -> L29 IllegalAccessException -> L31 NoSuchMethodException -> L33
        r20.invoke(r12, new Object[]{r110});     // Catch: InvocationTargetException -> L29 IllegalAccessException -> L31 NoSuchMethodException -> L33
        goto L14
    L37:
        r16.getMethod(r19, new Class[]{Integer.TYPE}).invoke(r12, new Object[]{Integer.valueOf(r15.f19698h)});     // Catch: InvocationTargetException -> L29 IllegalAccessException -> L31 NoSuchMethodException -> L33
        goto L14
    L38:
        r16.getMethod(r19, new Class[]{CharSequence.class}).invoke(r12, new Object[]{r15.f});     // Catch: InvocationTargetException -> L29 IllegalAccessException -> L31 NoSuchMethodException -> L33
        goto L14
    L39:
        r16.getMethod(r19, new Class[]{Boolean.TYPE}).invoke(r12, new Object[]{Boolean.valueOf(r15.g)});     // Catch: InvocationTargetException -> L29 IllegalAccessException -> L31 NoSuchMethodException -> L33
        goto L14
    L40:
        r16.getMethod(r19, new Class[]{Integer.TYPE}).invoke(r12, new Object[]{Integer.valueOf(r15.d)});     // Catch: InvocationTargetException -> L29 IllegalAccessException -> L31 NoSuchMethodException -> L33
    L31:
        e = move-exception;
        StringBuilder r21 = ai.j0.x(" Custom Attribute \"", r18, "\" not found on ");
        r21.append(r16.getName());
        Log.e("TransitionLayout", r21.toString(), e);
    L33:
        e = move-exception;
        Log.e("TransitionLayout", r16.getName() + " must have a method " + r19, e);
    L29:
        e = move-exception;
        StringBuilder r22 = ai.j0.x(" Custom Attribute \"", r18, "\" not found on ");
        r22.append(r16.getName());
        Log.e("TransitionLayout", r22.toString(), e);
        goto L14
    L24:
        r19 = r18;
        goto L66
    L45:
        return;
    L9:
        r5 = false;
        goto L10
    L47:
        if (this.f12845k.containsKey(r13) == false) goto L51;
        Method r23 = (Method) this.f12845k.get(r13);
        if (r23 != null) goto L53;
        return;
    L53:
        if (r23 == null) goto L64;
    L62:
        r23.invoke(r12, null);     // Catch: Exception -> L60
        return;
    L60:
        Log.e("KeyTrigger", "Exception in call \"" + this.f12846l + "\"on class " + r12.getClass().getSimpleName() + " " + ym.k.h(r12));
        return;
    L64:
        r23 = r12.getClass().getMethod(r13, null);     // Catch: NoSuchMethodException -> L56
        this.f12845k.put(r13, r23);     // Catch: NoSuchMethodException -> L56
    L56:
        this.f12845k.put(r13, null);
        Log.e("KeyTrigger", "Could not find method \"" + r13 + "\"on class " + r12.getClass().getSimpleName() + " " + ym.k.h(r12));
        return;
    L51:
        r23 = null;
        goto L53
    }
}
