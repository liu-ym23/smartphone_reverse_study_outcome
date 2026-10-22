package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes5.dex */
public class ConstraintAttribute {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f13741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f13742b;
    private boolean c;
    private AttributeType d;
    private int e;
    private float f;
    private String g;
    private int h;

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.widget.ConstraintAttribute$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13743a = null;

        static {
            int[] r0 = new int[AttributeType.values().length];
            f13743a = r0;
            r0[AttributeType.REFERENCE_TYPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            f13743a[AttributeType.BOOLEAN_TYPE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            f13743a[AttributeType.STRING_TYPE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            f13743a[AttributeType.COLOR_TYPE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            f13743a[AttributeType.COLOR_DRAWABLE_TYPE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            f13743a[AttributeType.INT_TYPE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            f13743a[AttributeType.FLOAT_TYPE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            f13743a[AttributeType.DIMENSION_TYPE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    public static final enum AttributeType extends Enum<AttributeType> {
        private static final /* synthetic */ AttributeType[] $VALUES = null;
        public static final AttributeType BOOLEAN_TYPE = null;
        public static final AttributeType COLOR_DRAWABLE_TYPE = null;
        public static final AttributeType COLOR_TYPE = null;
        public static final AttributeType DIMENSION_TYPE = null;
        public static final AttributeType FLOAT_TYPE = null;
        public static final AttributeType INT_TYPE = null;
        public static final AttributeType REFERENCE_TYPE = null;
        public static final AttributeType STRING_TYPE = null;

        static {
            AttributeType r0 = new AttributeType("INT_TYPE", 0);
            INT_TYPE = r0;
            AttributeType r1 = new AttributeType("FLOAT_TYPE", 1);
            FLOAT_TYPE = r1;
            AttributeType r3 = new AttributeType("COLOR_TYPE", 2);
            COLOR_TYPE = r3;
            AttributeType r5 = new AttributeType("COLOR_DRAWABLE_TYPE", 3);
            COLOR_DRAWABLE_TYPE = r5;
            AttributeType r7 = new AttributeType("STRING_TYPE", 4);
            STRING_TYPE = r7;
            AttributeType r9 = new AttributeType("BOOLEAN_TYPE", 5);
            BOOLEAN_TYPE = r9;
            AttributeType r11 = new AttributeType("DIMENSION_TYPE", 6);
            DIMENSION_TYPE = r11;
            AttributeType r13 = new AttributeType("REFERENCE_TYPE", 7);
            REFERENCE_TYPE = r13;
            $VALUES = new AttributeType[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        private AttributeType(String r1, int r2) {
            super(r1, r2);
        }

        public static AttributeType valueOf(String r2) {
            return (AttributeType) ZeusTransformUtils.preCheckCast(Enum.valueOf(AttributeType.class, r2), AttributeType.class, "com.obric.memorydata.plugin");
        }

        public static AttributeType[] values() {
            return (AttributeType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AttributeType[].class, "com.obric.memorydata.plugin");
        }
    }

    public ConstraintAttribute(ConstraintAttribute r2, Object r3) {
        this.c = false;
        this.f13741a = r2.f13741a;
        this.d = r2.d;
        a(r3);
    }

    public ConstraintAttribute(String r2, AttributeType r3, Object r4, boolean r5) {
        this.c = false;
        this.f13741a = r2;
        this.d = r3;
        this.c = r5;
        a(r4);
    }

    public static HashMap<String, ConstraintAttribute> a(HashMap<String, ConstraintAttribute> r11, View r12) {
        HashMap<String, ConstraintAttribute> r3 = new HashMap();
        Class<?> r4 = r12.getClass();
        Iterator<String> r5 = r11.keySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L20;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");
        ConstraintAttribute r7 = (ConstraintAttribute) ZeusTransformUtils.preCheckCast(r11.get(r6), ConstraintAttribute.class, "com.obric.memorydata.plugin");
    L7:
        if (r6.equals("BackgroundColor") == false) goto L10;
        ConstraintAttribute r9 = new ConstraintAttribute(r7, Integer.valueOf(((ColorDrawable) ZeusTransformUtils.preCheckCast(r12.getBackground(), ColorDrawable.class, "com.obric.memorydata.plugin")).getColor()));     // Catch: InvocationTargetException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L17
    L9:
        r3.put(r6, r9);     // Catch: InvocationTargetException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L17
        goto L4
    L10:
        r9 = new ConstraintAttribute(r7, r4.getMethod("getMap" + r6, new Class[0]).invoke(r12, new Object[0]));     // Catch: InvocationTargetException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L17
    L14:
        e = e;
        StringBuilder r8 = new StringBuilder();
    L16:
        StringBuilder r10 = r8.append(" Custom Attribute \"").append(r6).append("\" not found on ").append(r4.getName());
    L19:
        Log.e("TransitionLayout", r10.toString(), e);
    L17:
        e = e;
        r10 = new StringBuilder().append(r4.getName()).append(" must have a method ").append(r6);
    L12:
        e = e;
        r8 = new StringBuilder();
        goto L16
    L20:
        return r3;
    }

    public static void a(Context r16, XmlPullParser r17, HashMap<String, ConstraintAttribute> r18) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r16, Context.class, "com.obric.memorydata.plugin");
        TypedArray r2 = r0.obtainStyledAttributes(Xml.asAttributeSet((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r17, XmlPullParser.class, "com.obric.memorydata.plugin")), R.styleable.CustomAttribute);
        int r3 = r2.getIndexCount();
        String r4 = null;
        Object r6 = null;
        AttributeType r7 = null;
        int r8 = 0;
        boolean r9 = false;
    L3:
        if (r8 >= r3) goto L48;
        int r10 = r2.getIndex(r8);
        if (r10 != ZeusTransformUtils.mapRes(R.styleable.CustomAttribute_attributeName, "styleable", "CustomAttribute_attributeName")) goto L12;
        r4 = r2.getString(r10);
        if (r4 == null) goto L47;
        if (r4.length() <= 0) goto L47;
        r4 = Character.toUpperCase(r4.charAt(0)) + r4.substring(1);
    L47:
        r8 = r8 + 1;
        goto L3
    L12:
        if (r10 != ZeusTransformUtils.mapRes(R.styleable.CustomAttribute_methodName, "styleable", "CustomAttribute_methodName")) goto L15;
        r4 = r2.getString(r10);
        r9 = true;
        goto L47
    L15:
        if (r10 != ZeusTransformUtils.mapRes(R.styleable.CustomAttribute_customBoolean, "styleable", "CustomAttribute_customBoolean")) goto L18;
        r6 = Boolean.valueOf(r2.getBoolean(r10, false));
        r7 = AttributeType.BOOLEAN_TYPE;
        goto L47
    L18:
        if (r10 != ZeusTransformUtils.mapRes(R.styleable.CustomAttribute_customColorValue, "styleable", "CustomAttribute_customColorValue")) goto L24;
        AttributeType r11 = AttributeType.COLOR_TYPE;
    L20:
        int r12 = r2.getColor(r10, 0);
    L21:
        Object r13 = Integer.valueOf(r12);
    L22:
        Object r15 = r13;
        r7 = r11;
        r6 = r15;
        goto L47
    L24:
        if (r10 != ZeusTransformUtils.mapRes(R.styleable.CustomAttribute_customColorDrawableValue, "styleable", "CustomAttribute_customColorDrawableValue")) goto L27;
        r11 = AttributeType.COLOR_DRAWABLE_TYPE;
        goto L20
    L27:
        if (r10 != ZeusTransformUtils.mapRes(R.styleable.CustomAttribute_customPixelDimension, "styleable", "CustomAttribute_customPixelDimension")) goto L31;
        r11 = AttributeType.DIMENSION_TYPE;
        float r14 = TypedValue.applyDimension(1, r2.getDimension(r10, 0.0f), ZeusTransformUtils.getResources(r0, "com.obric.memorydata.plugin").getDisplayMetrics());
    L29:
        r13 = Float.valueOf(r14);
        goto L22
    L31:
        if (r10 != ZeusTransformUtils.mapRes(R.styleable.CustomAttribute_customDimension, "styleable", "CustomAttribute_customDimension")) goto L34;
        r11 = AttributeType.DIMENSION_TYPE;
        r14 = r2.getDimension(r10, 0.0f);
        goto L29
    L34:
        if (r10 != ZeusTransformUtils.mapRes(R.styleable.CustomAttribute_customFloatValue, "styleable", "CustomAttribute_customFloatValue")) goto L37;
        r11 = AttributeType.FLOAT_TYPE;
        r14 = r2.getFloat(r10, Float.NaN);
        goto L29
    L37:
        if (r10 != ZeusTransformUtils.mapRes(R.styleable.CustomAttribute_customIntegerValue, "styleable", "CustomAttribute_customIntegerValue")) goto L40;
        r11 = AttributeType.INT_TYPE;
        r12 = r2.getInteger(r10, -1);
        goto L21
    L40:
        if (r10 != ZeusTransformUtils.mapRes(R.styleable.CustomAttribute_customStringValue, "styleable", "CustomAttribute_customStringValue")) goto L43;
        r11 = AttributeType.STRING_TYPE;
        r13 = r2.getString(r10);
        goto L22
    L43:
        if (r10 != ZeusTransformUtils.mapRes(R.styleable.CustomAttribute_customReference, "styleable", "CustomAttribute_customReference")) goto L47;
        r11 = AttributeType.REFERENCE_TYPE;
        r12 = r2.getResourceId(r10, -1);
        if (r12 != (-1)) goto L21;
        r12 = r2.getInt(r10, -1);
        goto L21
    L48:
        if (r4 == null) goto L51;
        if (r6 == null) goto L51;
        r18.put(r4, new ConstraintAttribute(r4, r7, r6, r9));
    L51:
        r2.recycle();
    }

    public static void a(View r12, HashMap<String, ConstraintAttribute> r13) {
        Class<?> r3 = r12.getClass();
        Iterator<String> r4 = r13.keySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L28;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");
        ConstraintAttribute r6 = (ConstraintAttribute) ZeusTransformUtils.preCheckCast(r13.get(r5), ConstraintAttribute.class, "com.obric.memorydata.plugin");
        if (r6.c == true) goto L8;
        String r7 = "set" + r5;
    L29:
    L10:
        switch(AnonymousClass1.f13743a[r6.d.ordinal()]) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            default: goto L4;
        };     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L26
    L12:
        r3.getMethod(r7, new Class[]{Float.TYPE}).invoke(r12, new Object[]{Float.valueOf(r6.f)});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L26
        goto L4
    L13:
        r3.getMethod(r7, new Class[]{Float.TYPE}).invoke(r12, new Object[]{Float.valueOf(r6.f)});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L26
        goto L4
    L14:
        r3.getMethod(r7, new Class[]{Integer.TYPE}).invoke(r12, new Object[]{Integer.valueOf(r6.e)});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L26
        goto L4
    L15:
        Method r8 = r3.getMethod(r7, new Class[]{Drawable.class});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L26
        ColorDrawable r11 = new ColorDrawable();     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L26
        r11.setColor(r6.h);     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L26
        r8.invoke(r12, new Object[]{r11});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L26
        goto L4
    L16:
        r3.getMethod(r7, new Class[]{Integer.TYPE}).invoke(r12, new Object[]{Integer.valueOf(r6.h)});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L26
        goto L4
    L17:
        r3.getMethod(r7, new Class[]{CharSequence.class}).invoke(r12, new Object[]{r6.g});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L26
        goto L4
    L18:
        r3.getMethod(r7, new Class[]{Boolean.TYPE}).invoke(r12, new Object[]{Boolean.valueOf(r6.f13742b)});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L26
        goto L4
    L19:
        r3.getMethod(r7, new Class[]{Integer.TYPE}).invoke(r12, new Object[]{Integer.valueOf(r6.e)});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L26
    L23:
        e = e;
        StringBuilder r9 = new StringBuilder();
    L25:
        Log.e("TransitionLayout", r9.append(" Custom Attribute \"").append(r5).append("\" not found on ").append(r3.getName()).toString(), e);
    L26:
        e = move-exception;
        Log.e("TransitionLayout", r3.getName() + " must have a method " + r7, e);
    L21:
        e = e;
        r9 = new StringBuilder();
        goto L25
    L8:
        r7 = r5;
        goto L29
    }

    public String a() {
        return this.f13741a;
    }

    public void a(View r11) {
        Class<?> r3 = r11.getClass();
        String r4 = this.f13741a;
        if (this.c == true) goto L5;
        String r5 = "set" + r4;
    L26:
    L19:
        e = e;
        StringBuilder r12 = new StringBuilder();
    L21:
        StringBuilder r13 = r12.append(" Custom Attribute \"").append(r4).append("\" not found on ").append(r3.getName());
    L24:
        Log.e("TransitionLayout", r13.toString(), e);
        return;
    L22:
        e = e;
        r13 = new StringBuilder().append(r3.getName()).append(" must have a method ").append(r5);
    L17:
        e = e;
        r12 = new StringBuilder();
        goto L21
    L7:
        switch(AnonymousClass1.f13743a[this.d.ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L15;
            case 7: goto L10;
            case 8: goto L9;
            default: goto L27;
        };     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L22
    L9:
        r3.getMethod(r5, new Class[]{Float.TYPE}).invoke(r11, new Object[]{Float.valueOf(this.f)});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L22
        return;
    L10:
        r3.getMethod(r5, new Class[]{Float.TYPE}).invoke(r11, new Object[]{Float.valueOf(this.f)});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L22
        return;
    L11:
        Method r6 = r3.getMethod(r5, new Class[]{Drawable.class});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L22
        ColorDrawable r9 = new ColorDrawable();     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L22
        r9.setColor(this.h);     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L22
        r6.invoke(r11, new Object[]{r9});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L22
        return;
    L12:
        r3.getMethod(r5, new Class[]{Integer.TYPE}).invoke(r11, new Object[]{Integer.valueOf(this.h)});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L22
        return;
    L13:
        r3.getMethod(r5, new Class[]{CharSequence.class}).invoke(r11, new Object[]{this.g});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L22
        return;
    L14:
        r3.getMethod(r5, new Class[]{Boolean.TYPE}).invoke(r11, new Object[]{Boolean.valueOf(this.f13742b)});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L22
        return;
    L15:
        r3.getMethod(r5, new Class[]{Integer.TYPE}).invoke(r11, new Object[]{Integer.valueOf(this.e)});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L22
        return;
    L27:
        return;
    L5:
        r5 = r4;
        goto L26
    }

    public void a(Object r3) {
        switch(AnonymousClass1.f13743a[this.d.ordinal()]) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L7;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L9;
            case 7: goto L5;
            case 8: goto L5;
            default: goto L15;
        };
    L5:
        this.f = ((Float) ZeusTransformUtils.preCheckCast(r3, Float.class, "com.obric.memorydata.plugin")).floatValue();
        return;
    L6:
        this.h = ((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin")).intValue();
        return;
    L7:
        this.g = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
        return;
    L8:
        this.f13742b = ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        return;
    L9:
        this.e = ((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin")).intValue();
        return;
    }

    public void a(float[] r10) {
        switch(AnonymousClass1.f13743a[this.d.ordinal()]) {
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
        r10[0] = this.f;
        return;
    L6:
        r10[0] = this.f;
        return;
    L7:
        r10[0] = this.e;
        return;
    L8:
        int r9 = this.h;
        int r0 = (r9 >> 24) & 255;
        float r2 = (float) Math.pow(((r9 >> 16) & 255) / 255.0f, 2.2d);
        float r3 = (float) Math.pow(((r9 >> 8) & 255) / 255.0f, 2.2d);
        float r11 = (float) Math.pow((r9 & 255) / 255.0f, 2.2d);
        r10[0] = r2;
        r10[1] = r3;
        r10[2] = r11;
        r10[3] = r0 / 255.0f;
        return;
    L21:
        return;
    L10:
        throw new RuntimeException("Color does not have a single color to interpolate");
    L12:
        if (this.f13742b == false) goto L14;
        float r12 = 1.0f;
    L15:
        r10[0] = r12;
        return;
    L14:
        r12 = 0.0f;
        goto L15
    }

    public boolean b() {
        int r2 = AnonymousClass1.f13743a[this.d.ordinal()];
        if (r2 != 1) goto L5;
        return false;
    L5:
        if (r2 != 2) goto L7;
        return false;
    L7:
        if (r2 == 3) goto L12;
        return true;
    L12:
        return false;
    }

    public int c() {
        int r2 = AnonymousClass1.f13743a[this.d.ordinal()];
        if (r2 != 4) goto L5;
    L8:
        return 4;
    L5:
        if (r2 == 5) goto L8;
        return 1;
    }

    public float d() {
        switch(AnonymousClass1.f13743a[this.d.ordinal()]) {
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
        return this.f;
    L9:
        return this.e;
    L11:
        throw new RuntimeException("Color does not have a single color to interpolate");
    L13:
        throw new RuntimeException("Cannot interpolate String");
    L15:
        if (this.f13742b == false) goto L17;
        return 1.0f;
    L17:
        return 0.0f;
    }

    public AttributeType getType() {
        return this.d;
    }
}
