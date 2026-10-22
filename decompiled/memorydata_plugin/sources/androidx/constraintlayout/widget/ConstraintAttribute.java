package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintAttribute {
    private static final String TAG = "TransitionLayout";
    boolean mBooleanValue;
    private int mColorValue;
    private float mFloatValue;
    private int mIntegerValue;
    private boolean mMethod;
    String mName;
    private String mStringValue;
    private AttributeType mType;

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.ConstraintAttribute$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType = null;

        static {
            int[] r0 = new int[AttributeType.values().length];
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType = r0;
            r0[AttributeType.REFERENCE_TYPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.BOOLEAN_TYPE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.STRING_TYPE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.COLOR_TYPE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.COLOR_DRAWABLE_TYPE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.INT_TYPE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.FLOAT_TYPE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.DIMENSION_TYPE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
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

        private static /* synthetic */ AttributeType[] $values() {
            return new AttributeType[]{INT_TYPE, FLOAT_TYPE, COLOR_TYPE, COLOR_DRAWABLE_TYPE, STRING_TYPE, BOOLEAN_TYPE, DIMENSION_TYPE, REFERENCE_TYPE};
        }

        static {
            INT_TYPE = new AttributeType("INT_TYPE", 0);
            FLOAT_TYPE = new AttributeType("FLOAT_TYPE", 1);
            COLOR_TYPE = new AttributeType("COLOR_TYPE", 2);
            COLOR_DRAWABLE_TYPE = new AttributeType("COLOR_DRAWABLE_TYPE", 3);
            STRING_TYPE = new AttributeType("STRING_TYPE", 4);
            BOOLEAN_TYPE = new AttributeType("BOOLEAN_TYPE", 5);
            DIMENSION_TYPE = new AttributeType("DIMENSION_TYPE", 6);
            REFERENCE_TYPE = new AttributeType("REFERENCE_TYPE", 7);
            $VALUES = $values();
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
        this.mMethod = false;
        this.mName = r2.mName;
        this.mType = r2.mType;
        setValue(r3);
    }

    public ConstraintAttribute(String r2, AttributeType r3) {
        this.mMethod = false;
        this.mName = r2;
        this.mType = r3;
    }

    public ConstraintAttribute(String r2, AttributeType r3, Object r4, boolean r5) {
        this.mMethod = false;
        this.mName = r2;
        this.mType = r3;
        this.mMethod = r5;
        setValue(r4);
    }

    private static int clamp(int r1) {
        int r2 = (r1 & (~(r1 >> 31))) - 255;
        return (r2 & (r2 >> 31)) + 255;
    }

    public static HashMap<String, ConstraintAttribute> extractAttributes(HashMap<String, ConstraintAttribute> r8, View r9) {
        HashMap<String, ConstraintAttribute> r0 = new HashMap();
        Class<?> r1 = r9.getClass();
        Iterator<String> r2 = r8.keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L18;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        ConstraintAttribute r4 = (ConstraintAttribute) ZeusTransformUtils.preCheckCast(r8.get(r3), ConstraintAttribute.class, "com.obric.memorydata.plugin");
    L7:
        if (r3.equals("BackgroundColor") == false) goto L10;
        ConstraintAttribute r6 = new ConstraintAttribute(r4, Integer.valueOf(((ColorDrawable) ZeusTransformUtils.preCheckCast(r9.getBackground(), ColorDrawable.class, "com.obric.memorydata.plugin")).getColor()));     // Catch: InvocationTargetException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16
    L9:
        r0.put(r3, r6);     // Catch: InvocationTargetException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16
        goto L4
    L10:
        r6 = new ConstraintAttribute(r4, r1.getMethod("getMap" + r3, new Class[0]).invoke(r9, new Object[0]));     // Catch: InvocationTargetException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16
    L14:
        e = move-exception;
        e.printStackTrace();
    L16:
        e = move-exception;
        e.printStackTrace();
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L18:
        return r0;
    }

    public static void parse(Context r16, XmlPullParser r17, HashMap<String, ConstraintAttribute> r18) {
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

    public static void setAttributes(View r12, HashMap<String, ConstraintAttribute> r13) {
        Class<?> r3 = r12.getClass();
        Iterator<String> r4 = r13.keySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L27;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");
        ConstraintAttribute r6 = (ConstraintAttribute) ZeusTransformUtils.preCheckCast(r13.get(r5), ConstraintAttribute.class, "com.obric.memorydata.plugin");
        if (r6.mMethod == true) goto L8;
        String r7 = "set" + r5;
    L28:
    L10:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[r6.mType.ordinal()]) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            default: goto L4;
        };     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
    L12:
        r3.getMethod(r7, new Class[]{Float.TYPE}).invoke(r12, new Object[]{Float.valueOf(r6.mFloatValue)});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
        goto L4
    L13:
        r3.getMethod(r7, new Class[]{Float.TYPE}).invoke(r12, new Object[]{Float.valueOf(r6.mFloatValue)});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
        goto L4
    L14:
        r3.getMethod(r7, new Class[]{Integer.TYPE}).invoke(r12, new Object[]{Integer.valueOf(r6.mIntegerValue)});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
        goto L4
    L15:
        Method r8 = r3.getMethod(r7, new Class[]{Drawable.class});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
        ColorDrawable r11 = new ColorDrawable();     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
        r11.setColor(r6.mColorValue);     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
        r8.invoke(r12, new Object[]{r11});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
        goto L4
    L16:
        r3.getMethod(r7, new Class[]{Integer.TYPE}).invoke(r12, new Object[]{Integer.valueOf(r6.mColorValue)});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
        goto L4
    L17:
        r3.getMethod(r7, new Class[]{CharSequence.class}).invoke(r12, new Object[]{r6.mStringValue});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
        goto L4
    L18:
        r3.getMethod(r7, new Class[]{Boolean.TYPE}).invoke(r12, new Object[]{Boolean.valueOf(r6.mBooleanValue)});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
        goto L4
    L19:
        r3.getMethod(r7, new Class[]{Integer.TYPE}).invoke(r12, new Object[]{Integer.valueOf(r6.mIntegerValue)});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
    L23:
        e = move-exception;
        Log.e(TAG, " Custom Attribute \"" + r5 + "\" not found on " + r3.getName());
        e.printStackTrace();
    L25:
        e = move-exception;
        Log.e(TAG, e.getMessage());
        Log.e(TAG, " Custom Attribute \"" + r5 + "\" not found on " + r3.getName());
        Log.e(TAG, r3.getName() + " must have a method " + r7);
    L21:
        e = move-exception;
        Log.e(TAG, " Custom Attribute \"" + r5 + "\" not found on " + r3.getName());
        e.printStackTrace();
        goto L4
    L8:
        r7 = r5;
        goto L28
    }

    public void applyCustom(View r11) {
        Class<?> r3 = r11.getClass();
        String r4 = this.mName;
        if (this.mMethod == true) goto L5;
        String r5 = "set" + r4;
    L24:
    L19:
        e = move-exception;
        Log.e(TAG, " Custom Attribute \"" + r4 + "\" not found on " + r3.getName());
        e.printStackTrace();
        return;
    L21:
        e = move-exception;
        Log.e(TAG, e.getMessage());
        Log.e(TAG, " Custom Attribute \"" + r4 + "\" not found on " + r3.getName());
        Log.e(TAG, r3.getName() + " must have a method " + r5);
        return;
    L17:
        e = move-exception;
        Log.e(TAG, " Custom Attribute \"" + r4 + "\" not found on " + r3.getName());
        e.printStackTrace();
        return;
    L7:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L15;
            case 7: goto L10;
            case 8: goto L9;
            default: goto L25;
        };     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
    L9:
        r3.getMethod(r5, new Class[]{Float.TYPE}).invoke(r11, new Object[]{Float.valueOf(this.mFloatValue)});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        return;
    L10:
        r3.getMethod(r5, new Class[]{Float.TYPE}).invoke(r11, new Object[]{Float.valueOf(this.mFloatValue)});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        return;
    L11:
        Method r6 = r3.getMethod(r5, new Class[]{Drawable.class});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        ColorDrawable r9 = new ColorDrawable();     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        r9.setColor(this.mColorValue);     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        r6.invoke(r11, new Object[]{r9});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        return;
    L12:
        r3.getMethod(r5, new Class[]{Integer.TYPE}).invoke(r11, new Object[]{Integer.valueOf(this.mColorValue)});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        return;
    L13:
        r3.getMethod(r5, new Class[]{CharSequence.class}).invoke(r11, new Object[]{this.mStringValue});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        return;
    L14:
        r3.getMethod(r5, new Class[]{Boolean.TYPE}).invoke(r11, new Object[]{Boolean.valueOf(this.mBooleanValue)});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        return;
    L15:
        r3.getMethod(r5, new Class[]{Integer.TYPE}).invoke(r11, new Object[]{Integer.valueOf(this.mIntegerValue)});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        return;
    L25:
        return;
    L5:
        r5 = r4;
        goto L24
    }

    public boolean diff(ConstraintAttribute r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (this.mType == r4.mType) goto L8;
        return false;
    L8:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            case 1: goto L31;
            case 2: goto L27;
            case 3: goto L23;
            case 4: goto L19;
            case 5: goto L19;
            case 6: goto L31;
            case 7: goto L15;
            case 8: goto L11;
            default: goto L9;
        };
    L9:
        return false;
    L11:
        if (this.mFloatValue == r4.mFloatValue) goto L13;
        return false;
    L13:
        return true;
    L15:
        if (this.mFloatValue == r4.mFloatValue) goto L17;
        return false;
    L17:
        return true;
    L19:
        if (this.mColorValue == r4.mColorValue) goto L21;
        return false;
    L21:
        return true;
    L23:
        if (this.mIntegerValue == r4.mIntegerValue) goto L25;
        return false;
    L25:
        return true;
    L27:
        if (this.mBooleanValue == r4.mBooleanValue) goto L29;
        return false;
    L29:
        return true;
    L31:
        if (this.mIntegerValue == r4.mIntegerValue) goto L33;
        return false;
    L33:
        return true;
    }

    public int getColorValue() {
        return this.mColorValue;
    }

    public float getFloatValue() {
        return this.mFloatValue;
    }

    public int getIntegerValue() {
        return this.mIntegerValue;
    }

    public String getName() {
        return this.mName;
    }

    public String getStringValue() {
        return this.mStringValue;
    }

    public AttributeType getType() {
        return this.mType;
    }

    public float getValueToInterpolate() {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L13;
            case 6: goto L11;
            case 7: goto L9;
            case 8: goto L7;
            default: goto L4;
        };
    L4:
        return Float.NaN;
    L7:
        return this.mFloatValue;
    L9:
        return this.mFloatValue;
    L11:
        return this.mIntegerValue;
    L13:
        throw new RuntimeException("Color does not have a single color to interpolate");
    L15:
        throw new RuntimeException("Cannot interpolate String");
    L17:
        if (this.mBooleanValue == false) goto L19;
        return 1.0f;
    L19:
        return 0.0f;
    }

    public void getValuesToInterpolate(float[] r10) {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
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
        r10[0] = this.mFloatValue;
        return;
    L6:
        r10[0] = this.mFloatValue;
        return;
    L7:
        r10[0] = this.mIntegerValue;
        return;
    L8:
        int r9 = this.mColorValue;
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
        if (this.mBooleanValue == false) goto L14;
        float r12 = 1.0f;
    L15:
        r10[0] = r12;
        return;
    L14:
        r12 = 0.0f;
        goto L15
    }

    public boolean isBooleanValue() {
        return this.mBooleanValue;
    }

    public boolean isContinuous() {
        int r2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()];
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

    public boolean isMethod() {
        return this.mMethod;
    }

    public int numberOfInterpolatedValues() {
        int r2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()];
        if (r2 != 4) goto L5;
    L8:
        return 4;
    L5:
        if (r2 == 5) goto L8;
        return 1;
    }

    public void setColorValue(int r1) {
        this.mColorValue = r1;
    }

    public void setFloatValue(float r1) {
        this.mFloatValue = r1;
    }

    public void setIntValue(int r1) {
        this.mIntegerValue = r1;
    }

    public void setStringValue(String r1) {
        this.mStringValue = r1;
    }

    public void setValue(Object r3) {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
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
        this.mFloatValue = ((Float) ZeusTransformUtils.preCheckCast(r3, Float.class, "com.obric.memorydata.plugin")).floatValue();
        return;
    L6:
        this.mColorValue = ((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin")).intValue();
        return;
    L7:
        this.mStringValue = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
        return;
    L8:
        this.mBooleanValue = ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        return;
    L9:
        this.mIntegerValue = ((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin")).intValue();
        return;
    }

    public void setValue(float[] r7) {
        boolean r1 = false;
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            case 1: goto L15;
            case 2: goto L12;
            case 3: goto L10;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L15;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L20;
        };
    L5:
        float r8 = r7[0];
    L7:
        this.mFloatValue = r8;
        return;
    L6:
        r8 = r7[0];
        goto L7
    L8:
        int r0 = Color.HSVToColor(r7);
        this.mColorValue = r0;
        this.mColorValue = (clamp((int) (r7[3] * 255.0f)) << 24) | (r0 & ViewCompat.MEASURED_SIZE_MASK);
        return;
    L15:
        this.mIntegerValue = (int) r7[0];
        return;
    L20:
        return;
    L10:
        throw new RuntimeException("Color does not have a single color to interpolate");
    L12:
        if (r7[0] <= 0.5d) goto L14;
        r1 = true;
    L14:
        this.mBooleanValue = r1;
    }
}
