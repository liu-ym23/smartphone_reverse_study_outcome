package androidx.constraintlayout.widget;

import ai.j0;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.motion.widget.Debug;
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
    String mName;
    private String mStringValue;
    private AttributeType mType;

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.ConstraintAttribute$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType = null;

        static {
            int[] r5 = new int[AttributeType.values().length];
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType = r5;
            r5[AttributeType.COLOR_TYPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.COLOR_DRAWABLE_TYPE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.INT_TYPE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.FLOAT_TYPE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.STRING_TYPE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.BOOLEAN_TYPE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.DIMENSION_TYPE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
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
        public static final AttributeType STRING_TYPE = null;

        static {
            AttributeType r5 = new AttributeType("INT_TYPE", 0);
            INT_TYPE = r5;
            AttributeType r10 = new AttributeType("FLOAT_TYPE", 1);
            FLOAT_TYPE = r10;
            AttributeType r11 = new AttributeType("COLOR_TYPE", 2);
            COLOR_TYPE = r11;
            AttributeType r12 = new AttributeType("COLOR_DRAWABLE_TYPE", 3);
            COLOR_DRAWABLE_TYPE = r12;
            AttributeType r13 = new AttributeType("STRING_TYPE", 4);
            STRING_TYPE = r13;
            AttributeType r14 = new AttributeType("BOOLEAN_TYPE", 5);
            BOOLEAN_TYPE = r14;
            AttributeType r15 = new AttributeType("DIMENSION_TYPE", 6);
            DIMENSION_TYPE = r15;
            $VALUES = new AttributeType[]{r5, r10, r11, r12, r13, r14, r15};
        }

        private AttributeType(String r5, int r10) {
            super(r5, r10);
        }

        public static AttributeType valueOf(String r5) {
            return (AttributeType) Enum.valueOf(AttributeType.class, r5);
        }

        public static AttributeType[] values() {
            return (AttributeType[]) $VALUES.clone();
        }
    }

    public ConstraintAttribute(String r5, AttributeType r10) {
        this.mName = r5;
        this.mType = r10;
    }

    private static int clamp(int r5) {
        int r10 = (r5 & (~(r5 >> 31))) - 255;
        return (r10 & (r10 >> 31)) + 255;
    }

    public static HashMap<String, ConstraintAttribute> extractAttributes(HashMap<String, ConstraintAttribute> r10, View r11) {
        HashMap<String, ConstraintAttribute> r5 = new HashMap();
        Class<?> r12 = r11.getClass();
        Iterator<String> r13 = r10.keySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L20;
        String r14 = r13.next();
        ConstraintAttribute r15 = r10.get(r14);
    L7:
        if (r14.equals("BackgroundColor") == true) goto L8;
        r5.put(r14, new ConstraintAttribute(r15, r12.getMethod("getMap" + r14, null).invoke(r11, null)));     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11 NoSuchMethodException -> L13
        goto L4
    L8:
        r5.put(r14, new ConstraintAttribute(r15, Integer.valueOf(((ColorDrawable) r11.getBackground()).getColor())));     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11 NoSuchMethodException -> L13
    L11:
        e = move-exception;
        e.printStackTrace();
    L13:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L20:
        return r5;
    }

    public static void parse(Context r11, XmlPullParser r12, HashMap<String, ConstraintAttribute> r13) {
        TypedArray r14 = r11.obtainStyledAttributes(Xml.asAttributeSet(r12), R.styleable.CustomAttribute);
        int r5 = r14.getIndexCount();
        String r10 = null;
        Object r15 = null;
        AttributeType r16 = null;
        int r17 = 0;
    L3:
        if (r17 >= r5) goto L37;
        int r18 = r14.getIndex(r17);
        if (r18 != R.styleable.CustomAttribute_attributeName) goto L12;
        r10 = r14.getString(r18);
        if (r10 == null) goto L36;
        if (r10.length() <= 0) goto L36;
        r10 = Character.toUpperCase(r10.charAt(0)) + r10.substring(1);
    L36:
        r17 = r17 + 1;
        goto L3
    L12:
        if (r18 != R.styleable.CustomAttribute_customBoolean) goto L15;
        r15 = Boolean.valueOf(r14.getBoolean(r18, false));
        r16 = AttributeType.BOOLEAN_TYPE;
        goto L36
    L15:
        if (r18 != R.styleable.CustomAttribute_customColorValue) goto L19;
        AttributeType r19 = AttributeType.COLOR_TYPE;
        Object r20 = Integer.valueOf(r14.getColor(r18, 0));
    L17:
        Object r110 = r20;
        r16 = r19;
        r15 = r110;
        goto L36
    L19:
        if (r18 != R.styleable.CustomAttribute_customColorDrawableValue) goto L22;
        r19 = AttributeType.COLOR_DRAWABLE_TYPE;
        r20 = Integer.valueOf(r14.getColor(r18, 0));
        goto L17
    L22:
        if (r18 != R.styleable.CustomAttribute_customPixelDimension) goto L25;
        r19 = AttributeType.DIMENSION_TYPE;
        r20 = Float.valueOf(TypedValue.applyDimension(1, r14.getDimension(r18, 0.0f), r11.getResources().getDisplayMetrics()));
        goto L17
    L25:
        if (r18 != R.styleable.CustomAttribute_customDimension) goto L28;
        r19 = AttributeType.DIMENSION_TYPE;
        r20 = Float.valueOf(r14.getDimension(r18, 0.0f));
        goto L17
    L28:
        if (r18 != R.styleable.CustomAttribute_customFloatValue) goto L31;
        r19 = AttributeType.FLOAT_TYPE;
        r20 = Float.valueOf(r14.getFloat(r18, Float.NaN));
        goto L17
    L31:
        if (r18 != R.styleable.CustomAttribute_customIntegerValue) goto L34;
        r19 = AttributeType.INT_TYPE;
        r20 = Integer.valueOf(r14.getInteger(r18, -1));
        goto L17
    L34:
        if (r18 != R.styleable.CustomAttribute_customStringValue) goto L36;
        r19 = AttributeType.STRING_TYPE;
        r20 = r14.getString(r18);
        goto L17
    L37:
        if (r10 == null) goto L40;
        if (r15 == null) goto L40;
        r13.put(r10, new ConstraintAttribute(r10, r16, r15));
    L40:
        r14.recycle();
    }

    public static void setAttributes(View r10, HashMap<String, ConstraintAttribute> r11) {
        Class<?> r5 = r10.getClass();
        Iterator<String> r12 = r11.keySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L26;
        String r13 = r12.next();
        ConstraintAttribute r14 = r11.get(r13);
        String r15 = j0.C("set", r13);
    L7:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[r14.mType.ordinal()]) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L9;
            default: goto L4;
        };     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
    L9:
        r5.getMethod(r15, new Class[]{Float.TYPE}).invoke(r10, new Object[]{Float.valueOf(r14.mFloatValue)});     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        goto L4
    L16:
        r5.getMethod(r15, new Class[]{Boolean.TYPE}).invoke(r10, new Object[]{Boolean.valueOf(r14.mBooleanValue)});     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        goto L4
    L17:
        r5.getMethod(r15, new Class[]{CharSequence.class}).invoke(r10, new Object[]{r14.mStringValue});     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        goto L4
    L18:
        r5.getMethod(r15, new Class[]{Float.TYPE}).invoke(r10, new Object[]{Float.valueOf(r14.mFloatValue)});     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        goto L4
    L19:
        r5.getMethod(r15, new Class[]{Integer.TYPE}).invoke(r10, new Object[]{Integer.valueOf(r14.mIntegerValue)});     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        goto L4
    L20:
        Method r16 = r5.getMethod(r15, new Class[]{Drawable.class});     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        ColorDrawable r17 = new ColorDrawable();     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        r17.setColor(r14.mColorValue);     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        r16.invoke(r10, new Object[]{r17});     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        goto L4
    L21:
        r5.getMethod(r15, new Class[]{Integer.TYPE}).invoke(r10, new Object[]{Integer.valueOf(r14.mColorValue)});     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
    L12:
        e = move-exception;
        StringBuilder r18 = j0.x(" Custom Attribute \"", r13, "\" not found on ");
        r18.append(r5.getName());
        Log.e(TAG, r18.toString());
        e.printStackTrace();
    L14:
        e = move-exception;
        Log.e(TAG, e.getMessage());
        Log.e(TAG, " Custom Attribute \"" + r13 + "\" not found on " + r5.getName());
        Log.e(TAG, r5.getName() + " must have a method " + r15);
    L10:
        e = move-exception;
        StringBuilder r19 = j0.x(" Custom Attribute \"", r13, "\" not found on ");
        r19.append(r5.getName());
        Log.e(TAG, r19.toString());
        e.printStackTrace();
        goto L4
    }

    public boolean diff(ConstraintAttribute r5) {
        if (r5 == null) goto L39;
        AttributeType r10 = this.mType;
        if (r10 == r5.mType) goto L8;
        return false;
    L8:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[r10.ordinal()]) {
            case 1: goto L31;
            case 2: goto L31;
            case 3: goto L27;
            case 4: goto L23;
            case 5: goto L19;
            case 6: goto L15;
            case 7: goto L11;
            default: goto L9;
        };
    L9:
        return false;
    L11:
        if (this.mFloatValue == r5.mFloatValue) goto L13;
        return false;
    L13:
        return true;
    L15:
        if (this.mBooleanValue == r5.mBooleanValue) goto L17;
        return false;
    L17:
        return true;
    L19:
        if (this.mIntegerValue == r5.mIntegerValue) goto L21;
        return false;
    L21:
        return true;
    L23:
        if (this.mFloatValue == r5.mFloatValue) goto L25;
        return false;
    L25:
        return true;
    L27:
        if (this.mIntegerValue == r5.mIntegerValue) goto L29;
        return false;
    L29:
        return true;
    L31:
        if (this.mColorValue == r5.mColorValue) goto L33;
        return false;
    L33:
        return true;
    L39:
        return false;
    }

    public AttributeType getType() {
        return this.mType;
    }

    public float getValueToInterpolate() {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            case 1: goto L20;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L9;
            case 7: goto L7;
            default: goto L4;
        };
    L4:
        return Float.NaN;
    L7:
        return this.mFloatValue;
    L9:
        if (this.mBooleanValue == false) goto L11;
        return 1.0f;
    L11:
        return 0.0f;
    L14:
        throw new RuntimeException("Cannot interpolate String");
    L16:
        return this.mFloatValue;
    L18:
        return this.mIntegerValue;
    L20:
        throw new RuntimeException("Color does not have a single color to interpolate");
    }

    public void getValuesToInterpolate(float[] r10) {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            case 1: goto L15;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L21;
        };
    L5:
        r10[0] = this.mFloatValue;
        return;
    L13:
        r10[0] = this.mFloatValue;
        return;
    L14:
        r10[0] = this.mIntegerValue;
        return;
    L15:
        int r11 = this.mColorValue;
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
    L7:
        if (this.mBooleanValue == false) goto L9;
        float r15 = 1.0f;
    L10:
        r10[0] = r15;
        return;
    L9:
        r15 = 0.0f;
        goto L10
    L12:
        throw new RuntimeException("Color does not have a single color to interpolate");
    }

    public int noOfInterpValues() {
        int r5 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()];
        if (r5 != 1) goto L5;
        return 4;
    L5:
        if (r5 == 2) goto L9;
        return 1;
    L9:
        return 4;
    }

    public void setColorValue(int r5) {
        this.mColorValue = r5;
    }

    public void setFloatValue(float r5) {
        this.mFloatValue = r5;
    }

    public void setIntValue(int r5) {
        this.mIntegerValue = r5;
    }

    public void setInterpolatedValue(View r17, float[] r18) {
        Class<?> r10 = r17.getClass();
        String r11 = "set" + this.mName;
        boolean r12 = true;
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L13;
            case 7: goto L6;
            default: goto L30;
        };     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
    L6:
        r10.getMethod(r11, new Class[]{Float.TYPE}).invoke(r17, new Object[]{Float.valueOf(r18[0])});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        return;
    L13:
        Method r5 = r10.getMethod(r11, new Class[]{Boolean.TYPE});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        if (r18[0] > 0.5f) goto L17;
        r12 = false;
    L17:
        r5.invoke(r17, new Object[]{Boolean.valueOf(r12)});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        return;
    L20:
        r10.getMethod(r11, new Class[]{Float.TYPE}).invoke(r17, new Object[]{Float.valueOf(r18[0])});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        return;
    L21:
        r10.getMethod(r11, new Class[]{Integer.TYPE}).invoke(r17, new Object[]{Integer.valueOf((int) r18[0])});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        return;
    L22:
        Method r13 = r10.getMethod(r11, new Class[]{Drawable.class});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        int r14 = clamp((int) (((float) Math.pow(r18[0], 0.45454545454545453d)) * 255.0f));     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        int r15 = clamp((int) (((float) Math.pow(r18[1], 0.45454545454545453d)) * 255.0f));     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        int r16 = (((r14 << 16) | (clamp((int) (r18[3] * 255.0f)) << 24)) | (r15 << 8)) | clamp((int) (((float) Math.pow(r18[2], 0.45454545454545453d)) * 255.0f));     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        ColorDrawable r19 = new ColorDrawable();     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        r19.setColor(r16);     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        r13.invoke(r17, new Object[]{r19});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        return;
    L23:
        Method r20 = r10.getMethod(r11, new Class[]{Integer.TYPE});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        int r21 = clamp((int) (((float) Math.pow(r18[0], 0.45454545454545453d)) * 255.0f));     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        int r22 = clamp((int) (((float) Math.pow(r18[1], 0.45454545454545453d)) * 255.0f));     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        r20.invoke(r17, new Object[]{Integer.valueOf((((r21 << 16) | (clamp((int) (r18[3] * 255.0f)) << 24)) | (r22 << 8)) | clamp((int) (((float) Math.pow(r18[2], 0.45454545454545453d)) * 255.0f)))});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        return;
    L30:
        return;
    L19:
        throw new RuntimeException("unable to interpolate strings " + this.mName);     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
    L9:
        e = move-exception;
        StringBuilder r23 = j0.x("cannot access method ", r11, "on View \"");
        r23.append(Debug.getName(r17));
        r23.append("\"");
        Log.e(TAG, r23.toString());
        e.printStackTrace();
        return;
    L11:
        e = move-exception;
        StringBuilder r24 = j0.x("no method ", r11, "on View \"");
        r24.append(Debug.getName(r17));
        r24.append("\"");
        Log.e(TAG, r24.toString());
        e.printStackTrace();
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public void setStringValue(String r5) {
        this.mStringValue = r5;
    }

    public void setValue(float[] r10) {
        boolean r5 = false;
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            case 1: goto L14;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L20;
        };
    L5:
        this.mFloatValue = r10[0];
        return;
    L12:
        this.mFloatValue = r10[0];
        return;
    L13:
        this.mIntegerValue = (int) r10[0];
        return;
    L14:
        int r11 = Color.HSVToColor(r10);
        this.mColorValue = r11;
        this.mColorValue = (clamp((int) (r10[3] * 255.0f)) << 24) | (r11 & ViewCompat.MEASURED_SIZE_MASK);
        return;
    L20:
        return;
    L7:
        if (r10[0] <= 0.5d) goto L9;
        r5 = true;
    L9:
        this.mBooleanValue = r5;
        return;
    L11:
        throw new RuntimeException("Color does not have a single color to interpolate");
    }

    public ConstraintAttribute(String r5, AttributeType r10, Object r11) {
        this.mName = r5;
        this.mType = r10;
        setValue(r11);
    }

    public ConstraintAttribute(ConstraintAttribute r5, Object r10) {
        this.mName = r5.mName;
        this.mType = r5.mType;
        setValue(r10);
    }

    public void setValue(Object r5) {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            case 1: goto L10;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L17;
        };
    L5:
        this.mFloatValue = ((Float) r5).floatValue();
        return;
    L6:
        this.mBooleanValue = ((Boolean) r5).booleanValue();
        return;
    L7:
        this.mStringValue = (String) r5;
        return;
    L8:
        this.mFloatValue = ((Float) r5).floatValue();
        return;
    L9:
        this.mIntegerValue = ((Integer) r5).intValue();
        return;
    L10:
        this.mColorValue = ((Integer) r5).intValue();
        return;
    }
}
