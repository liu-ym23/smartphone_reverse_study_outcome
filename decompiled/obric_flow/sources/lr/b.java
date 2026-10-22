package lr;

import ai.j0;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute$AttributeType;
import com.obric.oui.constraintlayout.widget.R$styleable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f19695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f19696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ConstraintAttribute$AttributeType f19697c;
    public int d;
    public float e;
    public String f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f19698h;

    public b(b r5, Object r10) {
        this.f19695a = false;
        this.f19696b = r5.f19696b;
        this.f19697c = r5.f19697c;
        f(r10);
    }

    public static void d(Context r12, XmlResourceParser r13, HashMap r14) {
        TypedArray r15 = r12.obtainStyledAttributes(Xml.asAttributeSet(r13), R$styleable.CustomAttribute);
        int r5 = r15.getIndexCount();
        String r10 = null;
        Object r11 = null;
        ConstraintAttribute$AttributeType r16 = null;
        int r17 = 0;
        boolean r18 = false;
    L3:
        if (r17 >= r5) goto L46;
        int r19 = r15.getIndex(r17);
        if (r19 != R$styleable.CustomAttribute_attributeName) goto L12;
        r10 = r15.getString(r19);
        if (r10 == null) goto L45;
        if (r10.length() <= 0) goto L45;
        r10 = Character.toUpperCase(r10.charAt(0)) + r10.substring(1);
    L45:
        r17 = r17 + 1;
        goto L3
    L12:
        if (r19 != R$styleable.CustomAttribute_methodName) goto L15;
        r10 = r15.getString(r19);
        r18 = true;
        goto L45
    L15:
        if (r19 != R$styleable.CustomAttribute_customBoolean) goto L18;
        r11 = Boolean.valueOf(r15.getBoolean(r19, false));
        r16 = ConstraintAttribute$AttributeType.BOOLEAN_TYPE;
        goto L45
    L18:
        if (r19 != R$styleable.CustomAttribute_customColorValue) goto L22;
        ConstraintAttribute$AttributeType r20 = ConstraintAttribute$AttributeType.COLOR_TYPE;
        Object r21 = Integer.valueOf(r15.getColor(r19, 0));
    L20:
        Object r110 = r21;
        r16 = r20;
        r11 = r110;
        goto L45
    L22:
        if (r19 != R$styleable.CustomAttribute_customColorDrawableValue) goto L25;
        r20 = ConstraintAttribute$AttributeType.COLOR_DRAWABLE_TYPE;
        r21 = Integer.valueOf(r15.getColor(r19, 0));
        goto L20
    L25:
        if (r19 != R$styleable.CustomAttribute_customPixelDimension) goto L28;
        r20 = ConstraintAttribute$AttributeType.DIMENSION_TYPE;
        r21 = Float.valueOf(TypedValue.applyDimension(1, r15.getDimension(r19, 0.0f), r12.getResources().getDisplayMetrics()));
        goto L20
    L28:
        if (r19 != R$styleable.CustomAttribute_customDimension) goto L31;
        r20 = ConstraintAttribute$AttributeType.DIMENSION_TYPE;
        r21 = Float.valueOf(r15.getDimension(r19, 0.0f));
        goto L20
    L31:
        if (r19 != R$styleable.CustomAttribute_customFloatValue) goto L34;
        r20 = ConstraintAttribute$AttributeType.FLOAT_TYPE;
        r21 = Float.valueOf(r15.getFloat(r19, Float.NaN));
        goto L20
    L34:
        if (r19 != R$styleable.CustomAttribute_customIntegerValue) goto L37;
        r20 = ConstraintAttribute$AttributeType.INT_TYPE;
        r21 = Integer.valueOf(r15.getInteger(r19, -1));
        goto L20
    L37:
        if (r19 != R$styleable.CustomAttribute_customStringValue) goto L40;
        r20 = ConstraintAttribute$AttributeType.STRING_TYPE;
        r21 = r15.getString(r19);
        goto L20
    L40:
        if (r19 != R$styleable.CustomAttribute_customReference) goto L45;
        r20 = ConstraintAttribute$AttributeType.REFERENCE_TYPE;
        int r22 = r15.getResourceId(r19, -1);
        if (r22 != (-1)) goto L44;
        r22 = r15.getInt(r19, -1);
    L44:
        r21 = Integer.valueOf(r22);
        goto L20
    L46:
        if (r10 == null) goto L49;
        if (r11 == null) goto L49;
        b r111 = new b();
        r111.f19696b = r10;
        r111.f19697c = r16;
        r111.f19695a = r18;
        r111.f(r11);
        r14.put(r10, r111);
    L49:
        r15.recycle();
    }

    public static void e(View r10, HashMap r11) {
        Class<?> r5 = r10.getClass();
        Iterator r12 = r11.keySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L30;
        String r13 = (String) r12.next();
        b r14 = (b) r11.get(r13);
        if (r14.f19695a == true) goto L8;
        String r15 = j0.C("set", r13);
    L31:
    L10:
        switch(a.f19694a[r14.f19697c.ordinal()]) {
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L12;
            default: goto L4;
        };     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
    L12:
        r5.getMethod(r15, new Class[]{Float.TYPE}).invoke(r10, new Object[]{Float.valueOf(r14.e)});     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
        goto L4
    L19:
        r5.getMethod(r15, new Class[]{Float.TYPE}).invoke(r10, new Object[]{Float.valueOf(r14.e)});     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
        goto L4
    L20:
        r5.getMethod(r15, new Class[]{Integer.TYPE}).invoke(r10, new Object[]{Integer.valueOf(r14.d)});     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
        goto L4
    L21:
        Method r16 = r5.getMethod(r15, new Class[]{Drawable.class});     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
        ColorDrawable r17 = new ColorDrawable();     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
        r17.setColor(r14.f19698h);     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
        r16.invoke(r10, new Object[]{r17});     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
        goto L4
    L22:
        r5.getMethod(r15, new Class[]{Integer.TYPE}).invoke(r10, new Object[]{Integer.valueOf(r14.f19698h)});     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
        goto L4
    L23:
        r5.getMethod(r15, new Class[]{CharSequence.class}).invoke(r10, new Object[]{r14.f});     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
        goto L4
    L24:
        r5.getMethod(r15, new Class[]{Boolean.TYPE}).invoke(r10, new Object[]{Boolean.valueOf(r14.g)});     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
        goto L4
    L25:
        r5.getMethod(r15, new Class[]{Integer.TYPE}).invoke(r10, new Object[]{Integer.valueOf(r14.d)});     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15 NoSuchMethodException -> L17
    L15:
        e = move-exception;
        StringBuilder r18 = j0.x(" Custom Attribute \"", r13, "\" not found on ");
        r18.append(r5.getName());
        Log.e("TransitionLayout", r18.toString(), e);
    L17:
        e = move-exception;
        Log.e("TransitionLayout", r5.getName() + " must have a method " + r15, e);
    L13:
        e = move-exception;
        StringBuilder r19 = j0.x(" Custom Attribute \"", r13, "\" not found on ");
        r19.append(r5.getName());
        Log.e("TransitionLayout", r19.toString(), e);
        goto L4
    L8:
        r15 = r13;
        goto L31
    }

    public final float a() {
        switch(a.f19694a[this.f19697c.ordinal()]) {
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L11;
            case 6: goto L9;
            case 7: goto L7;
            case 8: goto L7;
            default: goto L4;
        };
    L4:
        return Float.NaN;
    L7:
        return this.e;
    L9:
        return this.d;
    L11:
        throw new RuntimeException("Color does not have a single color to interpolate");
    L13:
        throw new RuntimeException("Cannot interpolate String");
    L15:
        if (this.g == false) goto L17;
        return 1.0f;
    L17:
        return 0.0f;
    }

    public final void b(float[] r10) {
        switch(a.f19694a[this.f19697c.ordinal()]) {
            case 2: goto L12;
            case 3: goto L10;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L21;
        };
    L5:
        r10[0] = this.e;
        return;
    L6:
        r10[0] = this.e;
        return;
    L7:
        r10[0] = this.d;
        return;
    L8:
        int r11 = this.f19698h;
        int r5 = (r11 >> 24) & 255;
        float r12 = (float) Math.pow(((r11 >> 16) & 255) / 255.0f, 2.2d);
        float r13 = (float) Math.pow(((r11 >> 8) & 255) / 255.0f, 2.2d);
        float r14 = (float) Math.pow((r11 & 255) / 255.0f, 2.2d);
        r10[0] = r12;
        r10[1] = r13;
        r10[2] = r14;
        r10[3] = r5 / 255.0f;
        return;
    L21:
        return;
    L10:
        throw new RuntimeException("Color does not have a single color to interpolate");
    L12:
        if (this.g == false) goto L14;
        float r15 = 1.0f;
    L15:
        r10[0] = r15;
        return;
    L14:
        r15 = 0.0f;
        goto L15
    }

    public final int c() {
        int r5 = a.f19694a[this.f19697c.ordinal()];
        if (r5 != 4) goto L5;
    L8:
        return 4;
    L5:
        if (r5 == 5) goto L8;
        return 1;
    }

    public final void f(Object r5) {
        switch(a.f19694a[this.f19697c.ordinal()]) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L10;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L17;
        };
    L5:
        this.e = ((Float) r5).floatValue();
        return;
    L6:
        this.e = ((Float) r5).floatValue();
        return;
    L7:
        this.f19698h = ((Integer) r5).intValue();
        return;
    L8:
        this.f = (String) r5;
        return;
    L9:
        this.g = ((Boolean) r5).booleanValue();
        return;
    L10:
        this.d = ((Integer) r5).intValue();
        return;
    }
}
