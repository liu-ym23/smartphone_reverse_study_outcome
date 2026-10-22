package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f1415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f1417e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f1418f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1419g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1420h;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f1421a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f1422b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final a f1423m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final a f1424n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final a f1425o = null;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final a f1426p = null;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final a f1427q = null;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final a f1428r = null;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final /* synthetic */ a[] f1429s = null;

        static {
            a r8 = new a("INT_TYPE", 0);
            f1421a = r8;
            a r10 = new a("FLOAT_TYPE", 1);
            f1422b = r10;
            a r11 = new a("COLOR_TYPE", 2);
            f1423m = r11;
            a r12 = new a("COLOR_DRAWABLE_TYPE", 3);
            f1424n = r12;
            a r13 = new a("STRING_TYPE", 4);
            f1425o = r13;
            a r14 = new a("BOOLEAN_TYPE", 5);
            f1426p = r14;
            a r15 = new a("DIMENSION_TYPE", 6);
            f1427q = r15;
            a r16 = new a("REFERENCE_TYPE", 7);
            f1428r = r16;
            f1429s = new a[]{r8, r10, r11, r12, r13, r14, r15, r16};
        }

        public a(String r8, int r10) {
            super(r8, r10);
        }

        public static a valueOf(String r8) {
            return (a) Enum.valueOf(a.class, r8);
        }

        public static a[] values() {
            return (a[]) f1429s.clone();
        }
    }

    public b(b r8, Object r10) {
        this.f1413a = false;
        this.f1414b = r8.f1414b;
        this.f1415c = r8.f1415c;
        c(r10);
    }

    public static void a(Context r12, XmlResourceParser r13, HashMap r14) {
        TypedArray r15 = r12.obtainStyledAttributes(Xml.asAttributeSet(r13), v.d.f12659e);
        int r8 = r15.getIndexCount();
        String r10 = null;
        Object r11 = null;
        a r16 = null;
        int r17 = 0;
        boolean r18 = false;
    L3:
        if (r17 >= r8) goto L47;
        int r19 = r15.getIndex(r17);
        if (r19 != 0) goto L12;
        r10 = r15.getString(r19);
        if (r10 == null) goto L46;
        if (r10.length() <= 0) goto L46;
        r10 = Character.toUpperCase(r10.charAt(0)) + r10.substring(1);
    L46:
        r17 = r17 + 1;
        goto L3
    L12:
        if (r19 != 10) goto L14;
        r10 = r15.getString(r19);
        r18 = true;
        goto L46
    L14:
        if (r19 != 1) goto L17;
        r11 = Boolean.valueOf(r15.getBoolean(r19, false));
        r16 = a.f1426p;
        goto L46
    L17:
        if (r19 != 3) goto L20;
        a r20 = a.f1423m;
    L22:
        int r21 = r15.getColor(r19, 0);
    L44:
        Object r22 = Integer.valueOf(r21);
    L45:
        Object r110 = r22;
        r16 = r20;
        r11 = r110;
        goto L46
    L20:
        if (r19 != 2) goto L24;
        r20 = a.f1424n;
        goto L22
    L24:
        if (r19 != 7) goto L27;
        r20 = a.f1427q;
        float r23 = TypedValue.applyDimension(1, r15.getDimension(r19, 0.0f), r12.getResources().getDisplayMetrics());
    L32:
        r22 = Float.valueOf(r23);
        goto L45
    L27:
        if (r19 != 4) goto L30;
        r20 = a.f1427q;
        r23 = r15.getDimension(r19, 0.0f);
        goto L32
    L30:
        if (r19 != 5) goto L34;
        r20 = a.f1422b;
        r23 = r15.getFloat(r19, Float.NaN);
        goto L32
    L34:
        if (r19 != 6) goto L37;
        r20 = a.f1421a;
        r21 = r15.getInteger(r19, -1);
        goto L44
    L37:
        if (r19 != 9) goto L40;
        r20 = a.f1425o;
        r22 = r15.getString(r19);
        goto L45
    L40:
        if (r19 != 8) goto L46;
        r20 = a.f1428r;
        r21 = r15.getResourceId(r19, -1);
        if (r21 != (-1)) goto L44;
        r21 = r15.getInt(r19, -1);
        goto L44
    L47:
        if (r10 == null) goto L50;
        if (r11 == null) goto L50;
        r14.put(r10, new b(r10, r16, r11, r18));
    L50:
        r15.recycle();
    }

    public static void b(View r11, HashMap<String, b> r12) {
        Class<?> r8 = r11.getClass();
        Iterator<String> r10 = r12.keySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L28;
        String r13 = r10.next();
        b r14 = r12.get(r13);
        if (r14.f1413a == true) goto L8;
        String r15 = defpackage.b.c("set", r13);
    L29:
    L10:
        switch(r14.f1415c.ordinal()) {
            case 0: goto L19;
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            default: goto L4;
        };     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L26
    L12:
        r8.getMethod(r15, new Class[]{Integer.TYPE}).invoke(r11, new Object[]{Integer.valueOf(r14.f1416d)});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L26
        goto L4
    L13:
        r8.getMethod(r15, new Class[]{Float.TYPE}).invoke(r11, new Object[]{Float.valueOf(r14.f1417e)});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L26
        goto L4
    L14:
        r8.getMethod(r15, new Class[]{Boolean.TYPE}).invoke(r11, new Object[]{Boolean.valueOf(r14.f1419g)});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L26
        goto L4
    L15:
        r8.getMethod(r15, new Class[]{CharSequence.class}).invoke(r11, new Object[]{r14.f1418f});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L26
        goto L4
    L16:
        Method r16 = r8.getMethod(r15, new Class[]{Drawable.class});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L26
        ColorDrawable r17 = new ColorDrawable();     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L26
        r17.setColor(r14.f1420h);     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L26
        r16.invoke(r11, new Object[]{r17});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L26
        goto L4
    L17:
        r8.getMethod(r15, new Class[]{Integer.TYPE}).invoke(r11, new Object[]{Integer.valueOf(r14.f1420h)});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L26
        goto L4
    L18:
        r8.getMethod(r15, new Class[]{Float.TYPE}).invoke(r11, new Object[]{Float.valueOf(r14.f1417e)});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L26
        goto L4
    L19:
        r8.getMethod(r15, new Class[]{Integer.TYPE}).invoke(r11, new Object[]{Integer.valueOf(r14.f1416d)});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L26
    L23:
        e = e;
        StringBuilder r18 = new StringBuilder(" Custom Attribute \"");
    L25:
        r18.append(r13);
        r18.append("\" not found on ");
        r18.append(r8.getName());
        Log.e("TransitionLayout", r18.toString(), e);
    L26:
        e = move-exception;
        Log.e("TransitionLayout", r8.getName() + " must have a method " + r15, e);
    L21:
        e = e;
        r18 = new StringBuilder(" Custom Attribute \"");
        goto L25
    L8:
        r15 = r13;
        goto L29
    }

    public final void c(Object r8) {
        switch(this.f1415c.ordinal()) {
            case 0: goto L9;
            case 1: goto L8;
            case 2: goto L7;
            case 3: goto L7;
            case 4: goto L6;
            case 5: goto L5;
            case 6: goto L8;
            case 7: goto L9;
            default: goto L15;
        };
    L5:
        this.f1419g = ((Boolean) r8).booleanValue();
        return;
    L6:
        this.f1418f = (String) r8;
        return;
    L7:
        this.f1420h = ((Integer) r8).intValue();
        return;
    L8:
        this.f1417e = ((Float) r8).floatValue();
        return;
    L9:
        this.f1416d = ((Integer) r8).intValue();
        return;
    }

    public b(String r8, a r10, Object r11, boolean r12) {
        this.f1413a = false;
        this.f1414b = r8;
        this.f1415c = r10;
        this.f1413a = r12;
        c(r11);
    }
}
