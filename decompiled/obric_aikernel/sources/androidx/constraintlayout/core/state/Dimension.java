package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* JADX INFO: loaded from: classes.dex */
public class Dimension {
    public static final Object FIXED_DIMENSION = null;
    public static final Object PARENT_DIMENSION = null;
    public static final Object PERCENT_DIMENSION = null;
    public static final Object RATIO_DIMENSION = null;
    public static final Object SPREAD_DIMENSION = null;
    public static final Object WRAP_DIMENSION = null;
    private final int WRAP_CONTENT;
    Object mInitialValue;
    boolean mIsSuggested;
    int mMax;
    int mMin;
    float mPercent;
    String mRatioString;
    int mValue;

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type FIXED = null;
        public static final Type MATCH_CONSTRAINT = null;
        public static final Type MATCH_PARENT = null;
        public static final Type WRAP = null;

        static {
            Type r10 = new Type("FIXED", 0);
            FIXED = r10;
            Type r11 = new Type("WRAP", 1);
            WRAP = r11;
            Type r12 = new Type("MATCH_PARENT", 2);
            MATCH_PARENT = r12;
            Type r13 = new Type("MATCH_CONSTRAINT", 3);
            MATCH_CONSTRAINT = r13;
            $VALUES = new Type[]{r10, r11, r12, r13};
        }

        private Type(String r10, int r11) {
            super(r10, r11);
        }

        public static Type valueOf(String r10) {
            return (Type) Enum.valueOf(Type.class, r10);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    static {
        FIXED_DIMENSION = new Object();
        WRAP_DIMENSION = new Object();
        SPREAD_DIMENSION = new Object();
        PARENT_DIMENSION = new Object();
        PERCENT_DIMENSION = new Object();
        RATIO_DIMENSION = new Object();
    }

    private Dimension() {
        this.WRAP_CONTENT = -2;
        this.mMin = 0;
        this.mMax = Integer.MAX_VALUE;
        this.mPercent = 1.0f;
        this.mValue = 0;
        this.mRatioString = null;
        this.mInitialValue = WRAP_DIMENSION;
        this.mIsSuggested = false;
    }

    private Dimension(Object r10) {
        this.WRAP_CONTENT = -2;
        this.mMin = 0;
        this.mMax = Integer.MAX_VALUE;
        this.mPercent = 1.0f;
        this.mValue = 0;
        this.mRatioString = null;
        this.mInitialValue = WRAP_DIMENSION;
        this.mIsSuggested = false;
        this.mInitialValue = r10;
    }

    public static Dimension Fixed(int r10) {
        Dimension r11 = new Dimension(FIXED_DIMENSION);
        r11.fixed(r10);
        return r11;
    }

    public static Dimension Fixed(Object r10) {
        Dimension r11 = new Dimension(FIXED_DIMENSION);
        r11.fixed(r10);
        return r11;
    }

    public static Dimension Parent() {
        return new Dimension(PARENT_DIMENSION);
    }

    public static Dimension Percent(Object r10, float r11) {
        Dimension r12 = new Dimension(PERCENT_DIMENSION);
        r12.percent(r10, r11);
        return r12;
    }

    public static Dimension Ratio(String r10) {
        Dimension r11 = new Dimension(RATIO_DIMENSION);
        r11.ratio(r10);
        return r11;
    }

    public static Dimension Spread() {
        return new Dimension(SPREAD_DIMENSION);
    }

    public static Dimension Suggested(int r10) {
        Dimension r11 = new Dimension();
        r11.suggested(r10);
        return r11;
    }

    public static Dimension Suggested(Object r10) {
        Dimension r11 = new Dimension();
        r11.suggested(r10);
        return r11;
    }

    public static Dimension Wrap() {
        return new Dimension(WRAP_DIMENSION);
    }

    public void apply(State r10, ConstraintWidget r11, int r12) {
        String r13 = this.mRatioString;
        if (r13 == null) goto L5;
        r11.setDimensionRatio(r13);
    L5:
        int r14 = 2;
        if (r12 != 0) goto L33;
        if (this.mIsSuggested == false) goto L17;
        r11.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        Object r15 = this.mInitialValue;
        if (r15 != WRAP_DIMENSION) goto L13;
        r14 = 1;
    L16:
        r11.setHorizontalMatchStyle(r14, this.mMin, this.mMax, this.mPercent);
        return;
    L13:
        if (r15 == PERCENT_DIMENSION) goto L16;
        r14 = 0;
        goto L16
    L17:
        int r16 = this.mMin;
        if (r16 <= 0) goto L20;
        r11.setMinWidth(r16);
    L20:
        int r17 = this.mMax;
        if (r17 >= Integer.MAX_VALUE) goto L23;
        r11.setMaxWidth(r17);
    L23:
        Object r18 = this.mInitialValue;
        if (r18 != WRAP_DIMENSION) goto L28;
        ConstraintWidget.DimensionBehaviour r19 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
    L26:
        r11.setHorizontalDimensionBehaviour(r19);
        return;
    L28:
        if (r18 != PARENT_DIMENSION) goto L30;
        r19 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        goto L26
    L30:
        if (r18 != null) goto L60;
        r11.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r11.setWidth(this.mValue);
        return;
    L60:
        return;
    L33:
        if (this.mIsSuggested == false) goto L42;
        r11.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        Object r20 = this.mInitialValue;
        if (r20 != WRAP_DIMENSION) goto L38;
        r14 = 1;
    L41:
        r11.setVerticalMatchStyle(r14, this.mMin, this.mMax, this.mPercent);
        return;
    L38:
        if (r20 == PERCENT_DIMENSION) goto L41;
        r14 = 0;
        goto L41
    L42:
        int r21 = this.mMin;
        if (r21 <= 0) goto L45;
        r11.setMinHeight(r21);
    L45:
        int r22 = this.mMax;
        if (r22 >= Integer.MAX_VALUE) goto L48;
        r11.setMaxHeight(r22);
    L48:
        Object r23 = this.mInitialValue;
        if (r23 != WRAP_DIMENSION) goto L53;
        ConstraintWidget.DimensionBehaviour r24 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
    L51:
        r11.setVerticalDimensionBehaviour(r24);
        return;
    L53:
        if (r23 != PARENT_DIMENSION) goto L55;
        r24 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        goto L51
    L55:
        if (r23 != null) goto L64;
        r11.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r11.setHeight(this.mValue);
        return;
    }

    public boolean equalsFixedValue(int r10) {
        if (this.mInitialValue == null) goto L5;
        return false;
    L5:
        if (this.mValue != r10) goto L10;
        return true;
    L10:
        return false;
    }

    public Dimension fixed(int r10) {
        this.mInitialValue = null;
        this.mValue = r10;
        return this;
    }

    public Dimension fixed(Object r10) {
        this.mInitialValue = r10;
        if ((r10 instanceof Integer) == false) goto L5;
        this.mValue = ((Integer) r10).intValue();
        this.mInitialValue = null;
    L5:
        return this;
    }

    int getValue() {
        return this.mValue;
    }

    public Dimension max(int r10) {
        if (this.mMax < 0) goto L5;
        this.mMax = r10;
    L5:
        return this;
    }

    public Dimension max(Object r10) {
        Object r11 = WRAP_DIMENSION;
        if (r10 == r11) goto L5;
    L7:
        return this;
    L5:
        if (this.mIsSuggested == false) goto L7;
        this.mInitialValue = r11;
        this.mMax = Integer.MAX_VALUE;
        goto L7
    }

    public Dimension min(int r10) {
        if (r10 < 0) goto L4;
        this.mMin = r10;
    L4:
        return this;
    }

    public Dimension min(Object r10) {
        if (r10 != WRAP_DIMENSION) goto L5;
        this.mMin = -2;
    L5:
        return this;
    }

    public Dimension percent(Object r10, float r11) {
        this.mPercent = r11;
        return this;
    }

    public Dimension ratio(String r10) {
        this.mRatioString = r10;
        return this;
    }

    void setValue(int r10) {
        this.mIsSuggested = false;
        this.mInitialValue = null;
        this.mValue = r10;
    }

    public Dimension suggested(int r10) {
        this.mIsSuggested = true;
        if (r10 < 0) goto L5;
        this.mMax = r10;
    L5:
        return this;
    }

    public Dimension suggested(Object r10) {
        this.mInitialValue = r10;
        this.mIsSuggested = true;
        return this;
    }
}
