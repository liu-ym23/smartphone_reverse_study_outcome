package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;

/* JADX INFO: loaded from: classes.dex */
public class Dimension {
    public static final Object FIXED_DIMENSION = null;
    public static final Object PARENT_DIMENSION = null;
    public static final Object PERCENT_DIMENSION = null;
    public static final Object SPREAD_DIMENSION = null;
    public static final Object WRAP_DIMENSION = null;
    private final int WRAP_CONTENT;
    Object mInitialValue;
    boolean mIsSuggested;
    int mMax;
    int mMin;
    float mPercent;
    float mRatio;
    int mValue;

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type FIXED = null;
        public static final Type MATCH_CONSTRAINT = null;
        public static final Type MATCH_PARENT = null;
        public static final Type WRAP = null;

        static {
            Type r5 = new Type("FIXED", 0);
            FIXED = r5;
            Type r10 = new Type("WRAP", 1);
            WRAP = r10;
            Type r11 = new Type("MATCH_PARENT", 2);
            MATCH_PARENT = r11;
            Type r12 = new Type("MATCH_CONSTRAINT", 3);
            MATCH_CONSTRAINT = r12;
            $VALUES = new Type[]{r5, r10, r11, r12};
        }

        private Type(String r5, int r10) {
            super(r5, r10);
        }

        public static Type valueOf(String r5) {
            return (Type) Enum.valueOf(Type.class, r5);
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
    }

    private Dimension() {
        this.WRAP_CONTENT = -2;
        this.mMin = 0;
        this.mMax = Integer.MAX_VALUE;
        this.mPercent = 1.0f;
        this.mValue = 0;
        this.mRatio = 1.0f;
        this.mInitialValue = WRAP_DIMENSION;
        this.mIsSuggested = false;
    }

    public static Dimension Fixed(int r5) {
        Dimension r10 = new Dimension(FIXED_DIMENSION);
        r10.fixed(r5);
        return r10;
    }

    public static Dimension Parent() {
        return new Dimension(PARENT_DIMENSION);
    }

    public static Dimension Percent(Object r5, float r10) {
        Dimension r11 = new Dimension(PERCENT_DIMENSION);
        r11.percent(r5, r10);
        return r11;
    }

    public static Dimension Spread() {
        return new Dimension(SPREAD_DIMENSION);
    }

    public static Dimension Suggested(int r5) {
        Dimension r10 = new Dimension();
        r10.suggested(r5);
        return r10;
    }

    public static Dimension Wrap() {
        return new Dimension(WRAP_DIMENSION);
    }

    public void apply(State r5, ConstraintWidget r10, int r11) {
        int r12 = 2;
        if (r11 != 0) goto L29;
        if (this.mIsSuggested == false) goto L14;
        r10.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        Object r13 = this.mInitialValue;
        if (r13 != WRAP_DIMENSION) goto L10;
        r12 = 1;
    L13:
        r10.setHorizontalMatchStyle(r12, this.mMin, this.mMax, this.mPercent);
        return;
    L10:
        if (r13 == PERCENT_DIMENSION) goto L13;
        r12 = 0;
        goto L13
    L14:
        int r14 = this.mMin;
        if (r14 <= 0) goto L17;
        r10.setMinWidth(r14);
    L17:
        int r15 = this.mMax;
        if (r15 >= Integer.MAX_VALUE) goto L20;
        r10.setMaxWidth(r15);
    L20:
        Object r16 = this.mInitialValue;
        if (r16 != WRAP_DIMENSION) goto L24;
        r10.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
        return;
    L24:
        if (r16 != PARENT_DIMENSION) goto L26;
        r10.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
        return;
    L26:
        if (r16 != null) goto L56;
        r10.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r10.setWidth(this.mValue);
        return;
    L56:
        return;
    L29:
        if (this.mIsSuggested == false) goto L38;
        r10.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        Object r17 = this.mInitialValue;
        if (r17 != WRAP_DIMENSION) goto L34;
        r12 = 1;
    L37:
        r10.setVerticalMatchStyle(r12, this.mMin, this.mMax, this.mPercent);
        return;
    L34:
        if (r17 == PERCENT_DIMENSION) goto L37;
        r12 = 0;
        goto L37
    L38:
        int r18 = this.mMin;
        if (r18 <= 0) goto L41;
        r10.setMinHeight(r18);
    L41:
        int r19 = this.mMax;
        if (r19 >= Integer.MAX_VALUE) goto L44;
        r10.setMaxHeight(r19);
    L44:
        Object r20 = this.mInitialValue;
        if (r20 != WRAP_DIMENSION) goto L48;
        r10.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
        return;
    L48:
        if (r20 != PARENT_DIMENSION) goto L50;
        r10.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
        return;
    L50:
        if (r20 != null) goto L61;
        r10.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r10.setHeight(this.mValue);
        return;
    }

    public Dimension fixed(Object r5) {
        this.mInitialValue = r5;
        if ((r5 instanceof Integer) == false) goto L5;
        this.mValue = ((Integer) r5).intValue();
        this.mInitialValue = null;
    L5:
        return this;
    }

    public float getRatio() {
        return this.mRatio;
    }

    public int getValue() {
        return this.mValue;
    }

    public Dimension max(int r5) {
        if (this.mMax < 0) goto L5;
        this.mMax = r5;
    L5:
        return this;
    }

    public Dimension min(int r5) {
        if (r5 < 0) goto L4;
        this.mMin = r5;
    L4:
        return this;
    }

    public Dimension percent(Object r5, float r10) {
        this.mPercent = r10;
        return this;
    }

    public Dimension ratio(float r5) {
        return this;
    }

    public void setRatio(float r5) {
        this.mRatio = r5;
    }

    public void setValue(int r5) {
        this.mIsSuggested = false;
        this.mInitialValue = null;
        this.mValue = r5;
    }

    public Dimension suggested(int r5) {
        this.mIsSuggested = true;
        return this;
    }

    public Dimension min(Object r5) {
        if (r5 != WRAP_DIMENSION) goto L5;
        this.mMin = -2;
    L5:
        return this;
    }

    public Dimension suggested(Object r5) {
        this.mInitialValue = r5;
        this.mIsSuggested = true;
        return this;
    }

    public static Dimension Fixed(Object r5) {
        Dimension r10 = new Dimension(FIXED_DIMENSION);
        r10.fixed(r5);
        return r10;
    }

    public static Dimension Suggested(Object r5) {
        Dimension r10 = new Dimension();
        r10.suggested(r5);
        return r10;
    }

    public Dimension max(Object r5) {
        Object r10 = WRAP_DIMENSION;
        if (r5 == r10) goto L5;
    L7:
        return this;
    L5:
        if (this.mIsSuggested == false) goto L7;
        this.mInitialValue = r10;
        this.mMax = Integer.MAX_VALUE;
        goto L7
    }

    public Dimension fixed(int r5) {
        this.mInitialValue = null;
        this.mValue = r5;
        return this;
    }

    private Dimension(Object r5) {
        this.WRAP_CONTENT = -2;
        this.mMin = 0;
        this.mMax = Integer.MAX_VALUE;
        this.mPercent = 1.0f;
        this.mValue = 0;
        this.mRatio = 1.0f;
        this.mIsSuggested = false;
        this.mInitialValue = r5;
    }
}
