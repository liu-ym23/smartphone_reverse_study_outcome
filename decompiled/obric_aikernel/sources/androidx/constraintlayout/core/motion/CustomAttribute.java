package androidx.constraintlayout.core.motion;

import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class CustomAttribute {
    private static final String TAG = "TransitionLayout";
    boolean mBooleanValue;
    private int mColorValue;
    private float mFloatValue;
    private int mIntegerValue;
    private boolean mMethod;
    String mName;
    private String mStringValue;
    private AttributeType mType;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.motion.CustomAttribute$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType = null;

        static {
            int[] r10 = new int[AttributeType.values().length];
            $SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType = r10;
            r10[AttributeType.REFERENCE_TYPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            $SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[AttributeType.BOOLEAN_TYPE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[AttributeType.STRING_TYPE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            $SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[AttributeType.COLOR_TYPE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            $SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[AttributeType.COLOR_DRAWABLE_TYPE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[AttributeType.INT_TYPE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            $SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[AttributeType.FLOAT_TYPE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            $SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[AttributeType.DIMENSION_TYPE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
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
            AttributeType r10 = new AttributeType("INT_TYPE", 0);
            INT_TYPE = r10;
            AttributeType r11 = new AttributeType("FLOAT_TYPE", 1);
            FLOAT_TYPE = r11;
            AttributeType r12 = new AttributeType("COLOR_TYPE", 2);
            COLOR_TYPE = r12;
            AttributeType r13 = new AttributeType("COLOR_DRAWABLE_TYPE", 3);
            COLOR_DRAWABLE_TYPE = r13;
            AttributeType r14 = new AttributeType("STRING_TYPE", 4);
            STRING_TYPE = r14;
            AttributeType r15 = new AttributeType("BOOLEAN_TYPE", 5);
            BOOLEAN_TYPE = r15;
            AttributeType r16 = new AttributeType("DIMENSION_TYPE", 6);
            DIMENSION_TYPE = r16;
            AttributeType r17 = new AttributeType("REFERENCE_TYPE", 7);
            REFERENCE_TYPE = r17;
            $VALUES = new AttributeType[]{r10, r11, r12, r13, r14, r15, r16, r17};
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

    public CustomAttribute(CustomAttribute r10, Object r11) {
        this.mMethod = false;
        this.mName = r10.mName;
        this.mType = r10.mType;
        setValue(r11);
    }

    public CustomAttribute(String r10, AttributeType r11) {
        this.mMethod = false;
        this.mName = r10;
        this.mType = r11;
    }

    public CustomAttribute(String r10, AttributeType r11, Object r12, boolean r13) {
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

    public static int hsvToRgb(float r10, float r11, float r12) {
        float r13 = r10 * 6.0f;
        int r14 = (int) r13;
        float r15 = r13 - r14;
        float r16 = r12 * 255.0f;
        int r17 = (int) (((1.0f - r11) * r16) + 0.5f);
        int r18 = (int) (((1.0f - (r15 * r11)) * r16) + 0.5f);
        int r19 = (int) (((1.0f - ((1.0f - r15) * r11)) * r16) + 0.5f);
        int r20 = (int) (r16 + 0.5f);
        if (r14 == 0) goto L27;
        if (r14 == 1) goto L25;
        if (r14 == 2) goto L23;
        if (r14 == 3) goto L21;
        if (r14 == 4) goto L19;
        if (r14 == 5) goto L17;
        return 0;
    L17:
        return (((r20 << 16) + (r17 << 8)) + r18) | ViewCompat.MEASURED_STATE_MASK;
    L19:
        return (((r19 << 16) + (r17 << 8)) + r20) | ViewCompat.MEASURED_STATE_MASK;
    L21:
        return (((r17 << 16) + (r18 << 8)) + r20) | ViewCompat.MEASURED_STATE_MASK;
    L23:
        return (((r17 << 16) + (r20 << 8)) + r19) | ViewCompat.MEASURED_STATE_MASK;
    L25:
        return (((r18 << 16) + (r20 << 8)) + r17) | ViewCompat.MEASURED_STATE_MASK;
    L27:
        return (((r20 << 16) + (r19 << 8)) + r17) | ViewCompat.MEASURED_STATE_MASK;
    }

    public boolean diff(CustomAttribute r10) {
        if (r10 == null) goto L39;
        AttributeType r11 = this.mType;
        if (r11 == r10.mType) goto L8;
        return false;
    L8:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[r11.ordinal()]) {
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

    public AttributeType getType() {
        return this.mType;
    }

    public float getValueToInterpolate() {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[this.mType.ordinal()]) {
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
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[this.mType.ordinal()]) {
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

    public boolean isContinuous() {
        int r10 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[this.mType.ordinal()];
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

    public int numberOfInterpolatedValues() {
        int r10 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[this.mType.ordinal()];
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
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[this.mType.ordinal()]) {
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
        boolean r11 = true;
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[this.mType.ordinal()]) {
            case 1: goto L16;
            case 2: goto L12;
            case 3: goto L10;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L16;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L21;
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
        int r13 = hsvToRgb(r10[0], r10[1], r10[2]);
        this.mColorValue = r13;
        this.mColorValue = (clamp((int) (r10[3] * 255.0f)) << 24) | (r13 & ViewCompat.MEASURED_SIZE_MASK);
        return;
    L16:
        this.mIntegerValue = (int) r10[0];
        return;
    L21:
        return;
    L10:
        throw new RuntimeException("Color does not have a single color to interpolate");
    L12:
        if (r10[0] > 0.5d) goto L15;
        r11 = false;
    L15:
        this.mBooleanValue = r11;
    }
}
