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
            int[] r10 = new int[AttributeType.values().length];
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType = r10;
            r10[AttributeType.REFERENCE_TYPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
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

        private AttributeType(String r10, int r11) {
            super(r10, r11);
        }

        public static AttributeType valueOf(String r10) {
            return (AttributeType) Enum.valueOf(AttributeType.class, r10);
        }

        public static AttributeType[] values() {
            return (AttributeType[]) $VALUES.clone();
        }
    }

    public ConstraintAttribute(ConstraintAttribute r10, Object r11) {
        this.mMethod = false;
        this.mName = r10.mName;
        this.mType = r10.mType;
        setValue(r11);
    }

    public ConstraintAttribute(String r10, AttributeType r11) {
        this.mMethod = false;
        this.mName = r10;
        this.mType = r11;
    }

    public ConstraintAttribute(String r10, AttributeType r11, Object r12, boolean r13) {
        this.mMethod = false;
        this.mName = r10;
        this.mType = r11;
        this.mMethod = r13;
        setValue(r12);
    }

    private static int clamp(int r10) {
        int r11 = (r10 & (~(r10 >> 31))) - 255;
        return (r11 & (r11 >> 31)) + 255;
    }

    public static HashMap<String, ConstraintAttribute> extractAttributes(HashMap<String, ConstraintAttribute> r10, View r11) {
        HashMap<String, ConstraintAttribute> r12 = new HashMap();
        Class<?> r13 = r11.getClass();
        Iterator<String> r14 = r10.keySet().iterator();
    L4:
        if (r14.hasNext() == false) goto L18;
        String r15 = r14.next();
        ConstraintAttribute r16 = r10.get(r15);
    L7:
        if (r15.equals("BackgroundColor") == false) goto L10;
        ConstraintAttribute r17 = new ConstraintAttribute(r16, Integer.valueOf(((ColorDrawable) r11.getBackground()).getColor()));     // Catch: InvocationTargetException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16
    L9:
        r12.put(r15, r17);     // Catch: InvocationTargetException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16
        goto L4
    L10:
        r17 = new ConstraintAttribute(r16, r13.getMethod("getMap" + r15, new Class[0]).invoke(r11, new Object[0]));     // Catch: InvocationTargetException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16
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
        return r12;
    }

    public static void parse(Context r12, XmlPullParser r13, HashMap<String, ConstraintAttribute> r14) {
        TypedArray r15 = r12.obtainStyledAttributes(Xml.asAttributeSet(r13), R.styleable.CustomAttribute);
        int r10 = r15.getIndexCount();
        String r11 = null;
        Object r16 = null;
        AttributeType r17 = null;
        int r18 = 0;
        boolean r19 = false;
    L3:
        if (r18 >= r10) goto L48;
        int r20 = r15.getIndex(r18);
        if (r20 != R.styleable.CustomAttribute_attributeName) goto L12;
        r11 = r15.getString(r20);
        if (r11 == null) goto L47;
        if (r11.length() <= 0) goto L47;
        r11 = Character.toUpperCase(r11.charAt(0)) + r11.substring(1);
    L47:
        r18 = r18 + 1;
        goto L3
    L12:
        if (r20 != R.styleable.CustomAttribute_methodName) goto L15;
        r11 = r15.getString(r20);
        r19 = true;
        goto L47
    L15:
        if (r20 != R.styleable.CustomAttribute_customBoolean) goto L18;
        r16 = Boolean.valueOf(r15.getBoolean(r20, false));
        r17 = AttributeType.BOOLEAN_TYPE;
        goto L47
    L18:
        if (r20 != R.styleable.CustomAttribute_customColorValue) goto L24;
        AttributeType r21 = AttributeType.COLOR_TYPE;
    L20:
        int r22 = r15.getColor(r20, 0);
    L21:
        Object r23 = Integer.valueOf(r22);
    L22:
        Object r110 = r23;
        r17 = r21;
        r16 = r110;
        goto L47
    L24:
        if (r20 != R.styleable.CustomAttribute_customColorDrawableValue) goto L27;
        r21 = AttributeType.COLOR_DRAWABLE_TYPE;
        goto L20
    L27:
        if (r20 != R.styleable.CustomAttribute_customPixelDimension) goto L31;
        r21 = AttributeType.DIMENSION_TYPE;
        float r24 = TypedValue.applyDimension(1, r15.getDimension(r20, 0.0f), r12.getResources().getDisplayMetrics());
    L29:
        r23 = Float.valueOf(r24);
        goto L22
    L31:
        if (r20 != R.styleable.CustomAttribute_customDimension) goto L34;
        r21 = AttributeType.DIMENSION_TYPE;
        r24 = r15.getDimension(r20, 0.0f);
        goto L29
    L34:
        if (r20 != R.styleable.CustomAttribute_customFloatValue) goto L37;
        r21 = AttributeType.FLOAT_TYPE;
        r24 = r15.getFloat(r20, Float.NaN);
        goto L29
    L37:
        if (r20 != R.styleable.CustomAttribute_customIntegerValue) goto L40;
        r21 = AttributeType.INT_TYPE;
        r22 = r15.getInteger(r20, -1);
        goto L21
    L40:
        if (r20 != R.styleable.CustomAttribute_customStringValue) goto L43;
        r21 = AttributeType.STRING_TYPE;
        r23 = r15.getString(r20);
        goto L22
    L43:
        if (r20 != R.styleable.CustomAttribute_customReference) goto L47;
        r21 = AttributeType.REFERENCE_TYPE;
        r22 = r15.getResourceId(r20, -1);
        if (r22 != (-1)) goto L21;
        r22 = r15.getInt(r20, -1);
        goto L21
    L48:
        if (r11 == null) goto L51;
        if (r16 == null) goto L51;
        r14.put(r11, new ConstraintAttribute(r11, r17, r16, r19));
    L51:
        r15.recycle();
    }

    public static void setAttributes(View r12, HashMap<String, ConstraintAttribute> r13) {
        Class<?> r10 = r12.getClass();
        Iterator<String> r11 = r13.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L27;
        String r14 = r11.next();
        ConstraintAttribute r15 = r13.get(r14);
        if (r15.mMethod == true) goto L8;
        String r16 = "set" + r14;
    L28:
    L10:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[r15.mType.ordinal()]) {
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
        r10.getMethod(r16, new Class[]{Float.TYPE}).invoke(r12, new Object[]{Float.valueOf(r15.mFloatValue)});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
        goto L4
    L13:
        r10.getMethod(r16, new Class[]{Float.TYPE}).invoke(r12, new Object[]{Float.valueOf(r15.mFloatValue)});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
        goto L4
    L14:
        r10.getMethod(r16, new Class[]{Integer.TYPE}).invoke(r12, new Object[]{Integer.valueOf(r15.mIntegerValue)});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
        goto L4
    L15:
        Method r17 = r10.getMethod(r16, new Class[]{Drawable.class});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
        ColorDrawable r18 = new ColorDrawable();     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
        r18.setColor(r15.mColorValue);     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
        r17.invoke(r12, new Object[]{r18});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
        goto L4
    L16:
        r10.getMethod(r16, new Class[]{Integer.TYPE}).invoke(r12, new Object[]{Integer.valueOf(r15.mColorValue)});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
        goto L4
    L17:
        r10.getMethod(r16, new Class[]{CharSequence.class}).invoke(r12, new Object[]{r15.mStringValue});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
        goto L4
    L18:
        r10.getMethod(r16, new Class[]{Boolean.TYPE}).invoke(r12, new Object[]{Boolean.valueOf(r15.mBooleanValue)});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
        goto L4
    L19:
        r10.getMethod(r16, new Class[]{Integer.TYPE}).invoke(r12, new Object[]{Integer.valueOf(r15.mIntegerValue)});     // Catch: InvocationTargetException -> L21 IllegalAccessException -> L23 NoSuchMethodException -> L25
    L23:
        e = move-exception;
        Log.e(TAG, " Custom Attribute \"" + r14 + "\" not found on " + r10.getName());
        e.printStackTrace();
    L25:
        e = move-exception;
        Log.e(TAG, e.getMessage());
        Log.e(TAG, " Custom Attribute \"" + r14 + "\" not found on " + r10.getName());
        StringBuilder r19 = new StringBuilder();
        r19.append(r10.getName());
        r19.append(" must have a method ");
        r19.append(r16);
        Log.e(TAG, r19.toString());
    L21:
        e = move-exception;
        Log.e(TAG, " Custom Attribute \"" + r14 + "\" not found on " + r10.getName());
        e.printStackTrace();
        goto L4
    L8:
        r16 = r14;
        goto L28
    }

    public void applyCustom(View r11) {
        Class<?> r10 = r11.getClass();
        String r12 = this.mName;
        if (this.mMethod == true) goto L5;
        String r13 = "set" + r12;
    L24:
    L19:
        e = move-exception;
        Log.e(TAG, " Custom Attribute \"" + r12 + "\" not found on " + r10.getName());
        e.printStackTrace();
        return;
    L21:
        e = move-exception;
        Log.e(TAG, e.getMessage());
        Log.e(TAG, " Custom Attribute \"" + r12 + "\" not found on " + r10.getName());
        StringBuilder r14 = new StringBuilder();
        r14.append(r10.getName());
        r14.append(" must have a method ");
        r14.append(r13);
        Log.e(TAG, r14.toString());
        return;
    L17:
        e = move-exception;
        Log.e(TAG, " Custom Attribute \"" + r12 + "\" not found on " + r10.getName());
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
        r10.getMethod(r13, new Class[]{Float.TYPE}).invoke(r11, new Object[]{Float.valueOf(this.mFloatValue)});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        return;
    L10:
        r10.getMethod(r13, new Class[]{Float.TYPE}).invoke(r11, new Object[]{Float.valueOf(this.mFloatValue)});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        return;
    L11:
        Method r15 = r10.getMethod(r13, new Class[]{Drawable.class});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        ColorDrawable r16 = new ColorDrawable();     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        r16.setColor(this.mColorValue);     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        r15.invoke(r11, new Object[]{r16});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        return;
    L12:
        r10.getMethod(r13, new Class[]{Integer.TYPE}).invoke(r11, new Object[]{Integer.valueOf(this.mColorValue)});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        return;
    L13:
        r10.getMethod(r13, new Class[]{CharSequence.class}).invoke(r11, new Object[]{this.mStringValue});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        return;
    L14:
        r10.getMethod(r13, new Class[]{Boolean.TYPE}).invoke(r11, new Object[]{Boolean.valueOf(this.mBooleanValue)});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        return;
    L15:
        r10.getMethod(r13, new Class[]{Integer.TYPE}).invoke(r11, new Object[]{Integer.valueOf(this.mIntegerValue)});     // Catch: InvocationTargetException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21
        return;
    L25:
        return;
    L5:
        r13 = r12;
        goto L24
    }

    public boolean diff(ConstraintAttribute r10) {
        if (r10 == null) goto L39;
        AttributeType r11 = this.mType;
        if (r11 == r10.mType) goto L8;
        return false;
    L8:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[r11.ordinal()]) {
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
        if (this.mFloatValue == r10.mFloatValue) goto L13;
        return false;
    L13:
        return true;
    L15:
        if (this.mFloatValue == r10.mFloatValue) goto L17;
        return false;
    L17:
        return true;
    L19:
        if (this.mColorValue == r10.mColorValue) goto L21;
        return false;
    L21:
        return true;
    L23:
        if (this.mIntegerValue == r10.mIntegerValue) goto L25;
        return false;
    L25:
        return true;
    L27:
        if (this.mBooleanValue == r10.mBooleanValue) goto L29;
        return false;
    L29:
        return true;
    L31:
        if (this.mIntegerValue == r10.mIntegerValue) goto L33;
        return false;
    L33:
        return true;
    L39:
        return false;
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
        int r11 = this.mColorValue;
        int r12 = (r11 >> 24) & 255;
        float r13 = (float) Math.pow(((r11 >> 16) & 255) / 255.0f, 2.2d);
        float r14 = (float) Math.pow(((r11 >> 8) & 255) / 255.0f, 2.2d);
        float r15 = (float) Math.pow((r11 & 255) / 255.0f, 2.2d);
        r10[0] = r13;
        r10[1] = r14;
        r10[2] = r15;
        r10[3] = r12 / 255.0f;
        return;
    L21:
        return;
    L10:
        throw new RuntimeException("Color does not have a single color to interpolate");
    L12:
        if (this.mBooleanValue == false) goto L14;
        float r16 = 1.0f;
    L15:
        r10[0] = r16;
        return;
    L14:
        r16 = 0.0f;
        goto L15
    }

    public boolean isBooleanValue() {
        return this.mBooleanValue;
    }

    public boolean isContinuous() {
        int r10 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()];
        if (r10 != 1) goto L5;
        return false;
    L5:
        if (r10 != 2) goto L7;
        return false;
    L7:
        if (r10 == 3) goto L12;
        return true;
    L12:
        return false;
    }

    public boolean isMethod() {
        return this.mMethod;
    }

    public int numberOfInterpolatedValues() {
        int r10 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()];
        if (r10 != 4) goto L5;
    L8:
        return 4;
    L5:
        if (r10 == 5) goto L8;
        return 1;
    }

    public void setColorValue(int r10) {
        this.mColorValue = r10;
    }

    public void setFloatValue(float r10) {
        this.mFloatValue = r10;
    }

    public void setIntValue(int r10) {
        this.mIntegerValue = r10;
    }

    public void setStringValue(String r10) {
        this.mStringValue = r10;
    }

    public void setValue(Object r10) {
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
        this.mFloatValue = ((Float) r10).floatValue();
        return;
    L6:
        this.mColorValue = ((Integer) r10).intValue();
        return;
    L7:
        this.mStringValue = (String) r10;
        return;
    L8:
        this.mBooleanValue = ((Boolean) r10).booleanValue();
        return;
    L9:
        this.mIntegerValue = ((Integer) r10).intValue();
        return;
    }

    public void setValue(float[] r10) {
        boolean r11 = false;
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
        float r12 = r10[0];
    L7:
        this.mFloatValue = r12;
        return;
    L6:
        r12 = r10[0];
        goto L7
    L8:
        int r13 = Color.HSVToColor(r10);
        this.mColorValue = r13;
        this.mColorValue = (clamp((int) (r10[3] * 255.0f)) << 24) | (r13 & ViewCompat.MEASURED_SIZE_MASK);
        return;
    L15:
        this.mIntegerValue = (int) r10[0];
        return;
    L20:
        return;
    L10:
        throw new RuntimeException("Color does not have a single color to interpolate");
    L12:
        if (r10[0] <= 0.5d) goto L14;
        r11 = true;
    L14:
        this.mBooleanValue = r11;
    }
}
