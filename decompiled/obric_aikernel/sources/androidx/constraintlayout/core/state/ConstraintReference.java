package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.state.helpers.Facade;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintReference implements Reference {
    private Object key;
    float mAlpha;
    Object mBaselineToBaseline;
    Object mBaselineToBottom;
    Object mBaselineToTop;
    protected Object mBottomToBottom;
    protected Object mBottomToTop;
    private float mCircularAngle;
    Object mCircularConstraint;
    private float mCircularDistance;
    private ConstraintWidget mConstraintWidget;
    private HashMap<String, Integer> mCustomColors;
    private HashMap<String, Float> mCustomFloats;
    protected Object mEndToEnd;
    protected Object mEndToStart;
    Facade mFacade;
    float mHorizontalBias;
    int mHorizontalChainStyle;
    float mHorizontalChainWeight;
    Dimension mHorizontalDimension;
    State.Constraint mLast;
    protected Object mLeftToLeft;
    protected Object mLeftToRight;
    int mMarginBaseline;
    int mMarginBaselineGone;
    protected int mMarginBottom;
    protected int mMarginBottomGone;
    protected int mMarginEnd;
    protected int mMarginEndGone;
    protected int mMarginLeft;
    protected int mMarginLeftGone;
    protected int mMarginRight;
    protected int mMarginRightGone;
    protected int mMarginStart;
    protected int mMarginStartGone;
    protected int mMarginTop;
    protected int mMarginTopGone;
    float mPivotX;
    float mPivotY;
    protected Object mRightToLeft;
    protected Object mRightToRight;
    float mRotationX;
    float mRotationY;
    float mRotationZ;
    float mScaleX;
    float mScaleY;
    protected Object mStartToEnd;
    protected Object mStartToStart;
    final State mState;
    String mTag;
    protected Object mTopToBottom;
    protected Object mTopToTop;
    float mTranslationX;
    float mTranslationY;
    float mTranslationZ;
    float mVerticalBias;
    int mVerticalChainStyle;
    float mVerticalChainWeight;
    Dimension mVerticalDimension;
    private Object mView;
    int mVisibility;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.state.ConstraintReference$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$state$State$Constraint = null;

        static {
            int[] r10 = new int[State.Constraint.values().length];
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint = r10;
            r10[State.Constraint.LEFT_TO_LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L62:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.LEFT_TO_RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L46:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.RIGHT_TO_LEFT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L58:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.RIGHT_TO_RIGHT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L64:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.START_TO_START.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L48:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.START_TO_END.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L52:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.END_TO_START.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
        L74:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.END_TO_END.ordinal()] = 8;     // Catch: NoSuchFieldError -> L29
        L42:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.TOP_TO_TOP.ordinal()] = 9;     // Catch: NoSuchFieldError -> L30
        L68:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.TOP_TO_BOTTOM.ordinal()] = 10;     // Catch: NoSuchFieldError -> L31
        L70:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.BOTTOM_TO_TOP.ordinal()] = 11;     // Catch: NoSuchFieldError -> L32
        L54:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.BOTTOM_TO_BOTTOM.ordinal()] = 12;     // Catch: NoSuchFieldError -> L33
        L60:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.BASELINE_TO_BOTTOM.ordinal()] = 13;     // Catch: NoSuchFieldError -> L34
        L44:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.BASELINE_TO_TOP.ordinal()] = 14;     // Catch: NoSuchFieldError -> L35
        L50:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.BASELINE_TO_BASELINE.ordinal()] = 15;     // Catch: NoSuchFieldError -> L36
        L72:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.CIRCULAR_CONSTRAINT.ordinal()] = 16;     // Catch: NoSuchFieldError -> L37
        L40:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.CENTER_HORIZONTALLY.ordinal()] = 17;     // Catch: NoSuchFieldError -> L38
        L66:
            $SwitchMap$androidx$constraintlayout$core$state$State$Constraint[State.Constraint.CENTER_VERTICALLY.ordinal()] = 18;     // Catch: NoSuchFieldError -> L39
            return;
        }
    }

    public interface ConstraintReferenceFactory {
        ConstraintReference create(State r10);
    }

    static class IncorrectConstraintException extends Exception {
        private final ArrayList<String> mErrors;

        public IncorrectConstraintException(ArrayList<String> r10) {
            this.mErrors = r10;
        }

        public ArrayList<String> getErrors() {
            return this.mErrors;
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "IncorrectConstraintException: " + this.mErrors.toString();
        }
    }

    public ConstraintReference(State r10) {
        this.mTag = null;
        this.mFacade = null;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainWeight = -1.0f;
        this.mVerticalChainWeight = -1.0f;
        this.mHorizontalBias = 0.5f;
        this.mVerticalBias = 0.5f;
        this.mMarginLeft = 0;
        this.mMarginRight = 0;
        this.mMarginStart = 0;
        this.mMarginEnd = 0;
        this.mMarginTop = 0;
        this.mMarginBottom = 0;
        this.mMarginLeftGone = 0;
        this.mMarginRightGone = 0;
        this.mMarginStartGone = 0;
        this.mMarginEndGone = 0;
        this.mMarginTopGone = 0;
        this.mMarginBottomGone = 0;
        this.mMarginBaseline = 0;
        this.mMarginBaselineGone = 0;
        this.mPivotX = Float.NaN;
        this.mPivotY = Float.NaN;
        this.mRotationX = Float.NaN;
        this.mRotationY = Float.NaN;
        this.mRotationZ = Float.NaN;
        this.mTranslationX = Float.NaN;
        this.mTranslationY = Float.NaN;
        this.mTranslationZ = Float.NaN;
        this.mAlpha = Float.NaN;
        this.mScaleX = Float.NaN;
        this.mScaleY = Float.NaN;
        this.mVisibility = 0;
        this.mLeftToLeft = null;
        this.mLeftToRight = null;
        this.mRightToLeft = null;
        this.mRightToRight = null;
        this.mStartToStart = null;
        this.mStartToEnd = null;
        this.mEndToStart = null;
        this.mEndToEnd = null;
        this.mTopToTop = null;
        this.mTopToBottom = null;
        this.mBottomToTop = null;
        this.mBottomToBottom = null;
        this.mBaselineToBaseline = null;
        this.mBaselineToTop = null;
        this.mBaselineToBottom = null;
        this.mCircularConstraint = null;
        this.mLast = null;
        Object r11 = Dimension.WRAP_DIMENSION;
        this.mHorizontalDimension = Dimension.Fixed(r11);
        this.mVerticalDimension = Dimension.Fixed(r11);
        this.mCustomColors = new HashMap();
        this.mCustomFloats = new HashMap();
        this.mState = r10;
    }

    private void applyConnection(ConstraintWidget r10, Object r11, State.Constraint r12) {
        ConstraintWidget r13 = getTarget(r11);
        if (r13 != null) goto L5;
        return;
    L5:
        int[] r14 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$state$State$Constraint;
        int r15 = r14[r12.ordinal()];
        switch(r14[r12.ordinal()]) {
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L21;
            case 8: goto L20;
            case 9: goto L18;
            case 10: goto L17;
            case 11: goto L15;
            case 12: goto L14;
            case 13: goto L11;
            case 14: goto L10;
            case 15: goto L9;
            case 16: goto L8;
            default: goto L36;
        };
    L8:
        r10.connectCircularConstraint(r13, this.mCircularAngle, (int) this.mCircularDistance);
        return;
    L9:
        ConstraintAnchor.Type r16 = ConstraintAnchor.Type.BASELINE;
        int r17 = this.mMarginBaseline;
        int r18 = this.mMarginBaselineGone;
        ConstraintAnchor.Type r19 = r16;
    L13:
        r10.immediateConnect(r19, r13, r16, r17, r18);
        return;
    L10:
        r19 = ConstraintAnchor.Type.BASELINE;
        r16 = ConstraintAnchor.Type.TOP;
    L12:
        r17 = this.mMarginBaseline;
        r18 = this.mMarginBaselineGone;
        goto L13
    L11:
        r19 = ConstraintAnchor.Type.BASELINE;
        r16 = ConstraintAnchor.Type.BOTTOM;
        goto L12
    L14:
        ConstraintAnchor.Type r20 = ConstraintAnchor.Type.BOTTOM;
        ConstraintAnchor r21 = r10.getAnchor(r20);
    L16:
        ConstraintAnchor r22 = r13.getAnchor(r20);
        int r23 = this.mMarginBottom;
        int r24 = this.mMarginBottomGone;
    L32:
        r21.connect(r22, r23, r24, false);
        return;
    L15:
        r21 = r10.getAnchor(ConstraintAnchor.Type.BOTTOM);
        r20 = ConstraintAnchor.Type.TOP;
        goto L16
    L17:
        r21 = r10.getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor.Type r25 = ConstraintAnchor.Type.BOTTOM;
    L19:
        r22 = r13.getAnchor(r25);
        r23 = this.mMarginTop;
        r24 = this.mMarginTopGone;
        goto L32
    L18:
        r25 = ConstraintAnchor.Type.TOP;
        r21 = r10.getAnchor(r25);
        goto L19
    L20:
        ConstraintAnchor.Type r26 = ConstraintAnchor.Type.RIGHT;
        r21 = r10.getAnchor(r26);
    L22:
        r22 = r13.getAnchor(r26);
        r23 = this.mMarginEnd;
        r24 = this.mMarginEndGone;
        goto L32
    L21:
        r21 = r10.getAnchor(ConstraintAnchor.Type.RIGHT);
        r26 = ConstraintAnchor.Type.LEFT;
        goto L22
    L23:
        r21 = r10.getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor.Type r27 = ConstraintAnchor.Type.RIGHT;
    L25:
        r22 = r13.getAnchor(r27);
        r23 = this.mMarginStart;
        r24 = this.mMarginStartGone;
        goto L32
    L24:
        r27 = ConstraintAnchor.Type.LEFT;
        r21 = r10.getAnchor(r27);
        goto L25
    L26:
        ConstraintAnchor.Type r28 = ConstraintAnchor.Type.RIGHT;
        r21 = r10.getAnchor(r28);
    L28:
        r22 = r13.getAnchor(r28);
        r23 = this.mMarginRight;
        r24 = this.mMarginRightGone;
        goto L32
    L27:
        r21 = r10.getAnchor(ConstraintAnchor.Type.RIGHT);
        r28 = ConstraintAnchor.Type.LEFT;
        goto L28
    L29:
        r21 = r10.getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor.Type r29 = ConstraintAnchor.Type.RIGHT;
    L31:
        r22 = r13.getAnchor(r29);
        r23 = this.mMarginLeft;
        r24 = this.mMarginLeftGone;
        goto L32
    L30:
        r29 = ConstraintAnchor.Type.LEFT;
        r21 = r10.getAnchor(r29);
        goto L31
    }

    private void dereference() {
        this.mLeftToLeft = get(this.mLeftToLeft);
        this.mLeftToRight = get(this.mLeftToRight);
        this.mRightToLeft = get(this.mRightToLeft);
        this.mRightToRight = get(this.mRightToRight);
        this.mStartToStart = get(this.mStartToStart);
        this.mStartToEnd = get(this.mStartToEnd);
        this.mEndToStart = get(this.mEndToStart);
        this.mEndToEnd = get(this.mEndToEnd);
        this.mTopToTop = get(this.mTopToTop);
        this.mTopToBottom = get(this.mTopToBottom);
        this.mBottomToTop = get(this.mBottomToTop);
        this.mBottomToBottom = get(this.mBottomToBottom);
        this.mBaselineToBaseline = get(this.mBaselineToBaseline);
        this.mBaselineToTop = get(this.mBaselineToTop);
        this.mBaselineToBottom = get(this.mBaselineToBottom);
    }

    private Object get(Object r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof ConstraintReference) == false) goto L8;
        return r10;
    L8:
        return this.mState.reference(r10);
    }

    private ConstraintWidget getTarget(Object r10) {
        if ((r10 instanceof Reference) == true) goto L5;
        return null;
    L5:
        return ((Reference) r10).getConstraintWidget();
    }

    public void addCustomColor(String r10, int r11) {
        this.mCustomColors.put(r10, Integer.valueOf(r11));
    }

    public void addCustomFloat(String r10, float r11) {
        if (this.mCustomFloats != null) goto L5;
        this.mCustomFloats = new HashMap();
    L5:
        this.mCustomFloats.put(r10, Float.valueOf(r11));
    }

    public ConstraintReference alpha(float r10) {
        this.mAlpha = r10;
        return this;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public void apply() {
        if (this.mConstraintWidget != null) goto L5;
        return;
    L5:
        Facade r10 = this.mFacade;
        if (r10 == null) goto L8;
        r10.apply();
    L8:
        this.mHorizontalDimension.apply(this.mState, this.mConstraintWidget, 0);
        this.mVerticalDimension.apply(this.mState, this.mConstraintWidget, 1);
        dereference();
        applyConnection(this.mConstraintWidget, this.mLeftToLeft, State.Constraint.LEFT_TO_LEFT);
        applyConnection(this.mConstraintWidget, this.mLeftToRight, State.Constraint.LEFT_TO_RIGHT);
        applyConnection(this.mConstraintWidget, this.mRightToLeft, State.Constraint.RIGHT_TO_LEFT);
        applyConnection(this.mConstraintWidget, this.mRightToRight, State.Constraint.RIGHT_TO_RIGHT);
        applyConnection(this.mConstraintWidget, this.mStartToStart, State.Constraint.START_TO_START);
        applyConnection(this.mConstraintWidget, this.mStartToEnd, State.Constraint.START_TO_END);
        applyConnection(this.mConstraintWidget, this.mEndToStart, State.Constraint.END_TO_START);
        applyConnection(this.mConstraintWidget, this.mEndToEnd, State.Constraint.END_TO_END);
        applyConnection(this.mConstraintWidget, this.mTopToTop, State.Constraint.TOP_TO_TOP);
        applyConnection(this.mConstraintWidget, this.mTopToBottom, State.Constraint.TOP_TO_BOTTOM);
        applyConnection(this.mConstraintWidget, this.mBottomToTop, State.Constraint.BOTTOM_TO_TOP);
        applyConnection(this.mConstraintWidget, this.mBottomToBottom, State.Constraint.BOTTOM_TO_BOTTOM);
        applyConnection(this.mConstraintWidget, this.mBaselineToBaseline, State.Constraint.BASELINE_TO_BASELINE);
        applyConnection(this.mConstraintWidget, this.mBaselineToTop, State.Constraint.BASELINE_TO_TOP);
        applyConnection(this.mConstraintWidget, this.mBaselineToBottom, State.Constraint.BASELINE_TO_BOTTOM);
        applyConnection(this.mConstraintWidget, this.mCircularConstraint, State.Constraint.CIRCULAR_CONSTRAINT);
        int r11 = this.mHorizontalChainStyle;
        if (r11 == 0) goto L11;
        this.mConstraintWidget.setHorizontalChainStyle(r11);
    L11:
        int r12 = this.mVerticalChainStyle;
        if (r12 == 0) goto L14;
        this.mConstraintWidget.setVerticalChainStyle(r12);
    L14:
        float r13 = this.mHorizontalChainWeight;
        if (r13 == (-1.0f)) goto L17;
        this.mConstraintWidget.setHorizontalWeight(r13);
    L17:
        float r14 = this.mVerticalChainWeight;
        if (r14 == (-1.0f)) goto L20;
        this.mConstraintWidget.setVerticalWeight(r14);
    L20:
        this.mConstraintWidget.setHorizontalBiasPercent(this.mHorizontalBias);
        this.mConstraintWidget.setVerticalBiasPercent(this.mVerticalBias);
        ConstraintWidget r15 = this.mConstraintWidget;
        WidgetFrame r16 = r15.frame;
        r16.pivotX = this.mPivotX;
        r16.pivotY = this.mPivotY;
        r16.rotationX = this.mRotationX;
        r16.rotationY = this.mRotationY;
        r16.rotationZ = this.mRotationZ;
        r16.translationX = this.mTranslationX;
        r16.translationY = this.mTranslationY;
        r16.translationZ = this.mTranslationZ;
        r16.scaleX = this.mScaleX;
        r16.scaleY = this.mScaleY;
        r16.alpha = this.mAlpha;
        int r17 = this.mVisibility;
        r16.visibility = r17;
        r15.setVisibility(r17);
        HashMap<String, Integer> r18 = this.mCustomColors;
        if (r18 == null) goto L26;
        Iterator<String> r19 = r18.keySet().iterator();
    L24:
        if (r19.hasNext() == false) goto L26;
        String r20 = r19.next();
        Integer r21 = this.mCustomColors.get(r20);
        this.mConstraintWidget.frame.setCustomAttribute(r20, TypedValues.Custom.TYPE_COLOR, r21.intValue());
    L26:
        HashMap<String, Float> r22 = this.mCustomFloats;
        if (r22 == null) goto L32;
        Iterator<String> r23 = r22.keySet().iterator();
    L30:
        if (r23.hasNext() == false) goto L35;
        String r24 = r23.next();
        float r25 = this.mCustomFloats.get(r24).floatValue();
        this.mConstraintWidget.frame.setCustomAttribute(r24, TypedValues.Custom.TYPE_FLOAT, r25);
        goto L30
    L35:
        return;
    }

    public ConstraintReference baseline() {
        this.mLast = State.Constraint.BASELINE_TO_BASELINE;
        return this;
    }

    public ConstraintReference baselineToBaseline(Object r10) {
        this.mLast = State.Constraint.BASELINE_TO_BASELINE;
        this.mBaselineToBaseline = r10;
        return this;
    }

    public ConstraintReference baselineToBottom(Object r10) {
        this.mLast = State.Constraint.BASELINE_TO_BOTTOM;
        this.mBaselineToBottom = r10;
        return this;
    }

    public ConstraintReference baselineToTop(Object r10) {
        this.mLast = State.Constraint.BASELINE_TO_TOP;
        this.mBaselineToTop = r10;
        return this;
    }

    public ConstraintReference bias(float r10) {
        State.Constraint r11 = this.mLast;
        if (r11 != null) goto L5;
        return this;
    L5:
        int r12 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$state$State$Constraint[r11.ordinal()];
        if (r12 != 17) goto L8;
    L12:
        this.mHorizontalBias = r10;
    L13:
        return this;
    L8:
        if (r12 == 18) goto L11;
        switch(r12) {
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L12;
            case 4: goto L12;
            case 5: goto L12;
            case 6: goto L12;
            case 7: goto L12;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L11;
            case 11: goto L11;
            case 12: goto L11;
            default: goto L13;
        };
    L11:
        this.mVerticalBias = r10;
        goto L13
    }

    public ConstraintReference bottom() {
        if (this.mBottomToTop == null) goto L5;
        State.Constraint r10 = State.Constraint.BOTTOM_TO_TOP;
    L6:
        this.mLast = r10;
        return this;
    L5:
        r10 = State.Constraint.BOTTOM_TO_BOTTOM;
        goto L6
    }

    public ConstraintReference bottomToBottom(Object r10) {
        this.mLast = State.Constraint.BOTTOM_TO_BOTTOM;
        this.mBottomToBottom = r10;
        return this;
    }

    public ConstraintReference bottomToTop(Object r10) {
        this.mLast = State.Constraint.BOTTOM_TO_TOP;
        this.mBottomToTop = r10;
        return this;
    }

    public ConstraintReference centerHorizontally(Object r10) {
        Object r11 = get(r10);
        this.mStartToStart = r11;
        this.mEndToEnd = r11;
        this.mLast = State.Constraint.CENTER_HORIZONTALLY;
        this.mHorizontalBias = 0.5f;
        return this;
    }

    public ConstraintReference centerVertically(Object r10) {
        Object r11 = get(r10);
        this.mTopToTop = r11;
        this.mBottomToBottom = r11;
        this.mLast = State.Constraint.CENTER_VERTICALLY;
        this.mVerticalBias = 0.5f;
        return this;
    }

    public ConstraintReference circularConstraint(Object r10, float r11, float r12) {
        this.mCircularConstraint = get(r10);
        this.mCircularAngle = r11;
        this.mCircularDistance = r12;
        this.mLast = State.Constraint.CIRCULAR_CONSTRAINT;
        return this;
    }

    public ConstraintReference clear() {
        State.Constraint r10 = this.mLast;
        if (r10 != null) goto L5;
        this.mLeftToLeft = null;
        this.mLeftToRight = null;
        this.mMarginLeft = 0;
        this.mRightToLeft = null;
        this.mRightToRight = null;
        this.mMarginRight = 0;
        this.mStartToStart = null;
        this.mStartToEnd = null;
        this.mMarginStart = 0;
        this.mEndToStart = null;
        this.mEndToEnd = null;
        this.mMarginEnd = 0;
        this.mTopToTop = null;
        this.mTopToBottom = null;
        this.mMarginTop = 0;
        this.mBottomToTop = null;
        this.mBottomToBottom = null;
        this.mMarginBottom = 0;
        this.mBaselineToBaseline = null;
        this.mCircularConstraint = null;
        this.mHorizontalBias = 0.5f;
        this.mVerticalBias = 0.5f;
        this.mMarginLeftGone = 0;
        this.mMarginRightGone = 0;
        this.mMarginStartGone = 0;
        this.mMarginEndGone = 0;
        this.mMarginTopGone = 0;
    L16:
        this.mMarginBottomGone = 0;
    L17:
        return this;
    L5:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$state$State$Constraint[r10.ordinal()]) {
            case 1: goto L14;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L10;
            case 11: goto L9;
            case 12: goto L9;
            case 13: goto L17;
            case 14: goto L17;
            case 15: goto L8;
            case 16: goto L7;
            default: goto L17;
        };
    L7:
        this.mCircularConstraint = null;
        goto L17
    L8:
        this.mBaselineToBaseline = null;
        goto L17
    L9:
        this.mBottomToTop = null;
        this.mBottomToBottom = null;
        this.mMarginBottom = 0;
        goto L16
    L10:
        this.mTopToTop = null;
        this.mTopToBottom = null;
        this.mMarginTop = 0;
        this.mMarginTopGone = 0;
        goto L17
    L11:
        this.mEndToStart = null;
        this.mEndToEnd = null;
        this.mMarginEnd = 0;
        this.mMarginEndGone = 0;
        goto L17
    L12:
        this.mStartToStart = null;
        this.mStartToEnd = null;
        this.mMarginStart = 0;
        this.mMarginStartGone = 0;
        goto L17
    L13:
        this.mRightToLeft = null;
        this.mRightToRight = null;
        this.mMarginRight = 0;
        this.mMarginRightGone = 0;
        goto L17
    L14:
        this.mLeftToLeft = null;
        this.mLeftToRight = null;
        this.mMarginLeft = 0;
        this.mMarginLeftGone = 0;
        goto L17
    }

    public ConstraintReference clearHorizontal() {
        start().clear();
        end().clear();
        left().clear();
        right().clear();
        return this;
    }

    public ConstraintReference clearVertical() {
        top().clear();
        baseline().clear();
        bottom().clear();
        return this;
    }

    public ConstraintWidget createConstraintWidget() {
        return new ConstraintWidget(getWidth().getValue(), getHeight().getValue());
    }

    public ConstraintReference end() {
        if (this.mEndToStart == null) goto L5;
        State.Constraint r10 = State.Constraint.END_TO_START;
    L6:
        this.mLast = r10;
        return this;
    L5:
        r10 = State.Constraint.END_TO_END;
        goto L6
    }

    public ConstraintReference endToEnd(Object r10) {
        this.mLast = State.Constraint.END_TO_END;
        this.mEndToEnd = r10;
        return this;
    }

    public ConstraintReference endToStart(Object r10) {
        this.mLast = State.Constraint.END_TO_START;
        this.mEndToStart = r10;
        return this;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public ConstraintWidget getConstraintWidget() {
        if (this.mConstraintWidget != null) goto L6;
        ConstraintWidget r10 = createConstraintWidget();
        this.mConstraintWidget = r10;
        r10.setCompanionWidget(this.mView);
    L6:
        return this.mConstraintWidget;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public Facade getFacade() {
        return this.mFacade;
    }

    public Dimension getHeight() {
        return this.mVerticalDimension;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public float getHorizontalChainWeight() {
        return this.mHorizontalChainWeight;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public Object getKey() {
        return this.key;
    }

    public float getPivotX() {
        return this.mPivotX;
    }

    public float getPivotY() {
        return this.mPivotY;
    }

    public float getRotationX() {
        return this.mRotationX;
    }

    public float getRotationY() {
        return this.mRotationY;
    }

    public float getRotationZ() {
        return this.mRotationZ;
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public String getTag() {
        return this.mTag;
    }

    public float getTranslationX() {
        return this.mTranslationX;
    }

    public float getTranslationY() {
        return this.mTranslationY;
    }

    public float getTranslationZ() {
        return this.mTranslationZ;
    }

    public int getVerticalChainStyle(int r10) {
        return this.mVerticalChainStyle;
    }

    public float getVerticalChainWeight() {
        return this.mVerticalChainWeight;
    }

    public Object getView() {
        return this.mView;
    }

    public Dimension getWidth() {
        return this.mHorizontalDimension;
    }

    public ConstraintReference height(Dimension r10) {
        return setHeight(r10);
    }

    public ConstraintReference horizontalBias(float r10) {
        this.mHorizontalBias = r10;
        return this;
    }

    public ConstraintReference left() {
        if (this.mLeftToLeft == null) goto L5;
        State.Constraint r10 = State.Constraint.LEFT_TO_LEFT;
    L6:
        this.mLast = r10;
        return this;
    L5:
        r10 = State.Constraint.LEFT_TO_RIGHT;
        goto L6
    }

    public ConstraintReference leftToLeft(Object r10) {
        this.mLast = State.Constraint.LEFT_TO_LEFT;
        this.mLeftToLeft = r10;
        return this;
    }

    public ConstraintReference leftToRight(Object r10) {
        this.mLast = State.Constraint.LEFT_TO_RIGHT;
        this.mLeftToRight = r10;
        return this;
    }

    public ConstraintReference margin(int r10) {
        State.Constraint r11 = this.mLast;
        if (r11 != null) goto L5;
        this.mMarginLeft = r10;
        this.mMarginRight = r10;
        this.mMarginStart = r10;
        this.mMarginEnd = r10;
        this.mMarginTop = r10;
    L15:
        this.mMarginBottom = r10;
    L16:
        return this;
    L5:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$state$State$Constraint[r11.ordinal()]) {
            case 1: goto L13;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L9;
            case 11: goto L15;
            case 12: goto L15;
            case 13: goto L8;
            case 14: goto L8;
            case 15: goto L8;
            case 16: goto L7;
            default: goto L16;
        };
    L7:
        this.mCircularDistance = r10;
        goto L16
    L8:
        this.mMarginBaseline = r10;
        goto L16
    L9:
        this.mMarginTop = r10;
        goto L16
    L10:
        this.mMarginEnd = r10;
        goto L16
    L11:
        this.mMarginStart = r10;
        goto L16
    L12:
        this.mMarginRight = r10;
        goto L16
    L13:
        this.mMarginLeft = r10;
        goto L16
    }

    public ConstraintReference margin(Object r10) {
        return margin(this.mState.convertDimension(r10));
    }

    public ConstraintReference marginGone(int r10) {
        State.Constraint r11 = this.mLast;
        if (r11 != null) goto L5;
        this.mMarginLeftGone = r10;
        this.mMarginRightGone = r10;
        this.mMarginStartGone = r10;
        this.mMarginEndGone = r10;
        this.mMarginTopGone = r10;
    L14:
        this.mMarginBottomGone = r10;
    L15:
        return this;
    L5:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$state$State$Constraint[r11.ordinal()]) {
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L8;
            case 11: goto L14;
            case 12: goto L14;
            case 13: goto L7;
            case 14: goto L7;
            case 15: goto L7;
            default: goto L15;
        };
    L7:
        this.mMarginBaselineGone = r10;
        goto L15
    L8:
        this.mMarginTopGone = r10;
        goto L15
    L9:
        this.mMarginEndGone = r10;
        goto L15
    L10:
        this.mMarginStartGone = r10;
        goto L15
    L11:
        this.mMarginRightGone = r10;
        goto L15
    L12:
        this.mMarginLeftGone = r10;
        goto L15
    }

    public ConstraintReference marginGone(Object r10) {
        return marginGone(this.mState.convertDimension(r10));
    }

    public ConstraintReference pivotX(float r10) {
        this.mPivotX = r10;
        return this;
    }

    public ConstraintReference pivotY(float r10) {
        this.mPivotY = r10;
        return this;
    }

    public ConstraintReference right() {
        if (this.mRightToLeft == null) goto L5;
        State.Constraint r10 = State.Constraint.RIGHT_TO_LEFT;
    L6:
        this.mLast = r10;
        return this;
    L5:
        r10 = State.Constraint.RIGHT_TO_RIGHT;
        goto L6
    }

    public ConstraintReference rightToLeft(Object r10) {
        this.mLast = State.Constraint.RIGHT_TO_LEFT;
        this.mRightToLeft = r10;
        return this;
    }

    public ConstraintReference rightToRight(Object r10) {
        this.mLast = State.Constraint.RIGHT_TO_RIGHT;
        this.mRightToRight = r10;
        return this;
    }

    public ConstraintReference rotationX(float r10) {
        this.mRotationX = r10;
        return this;
    }

    public ConstraintReference rotationY(float r10) {
        this.mRotationY = r10;
        return this;
    }

    public ConstraintReference rotationZ(float r10) {
        this.mRotationZ = r10;
        return this;
    }

    public ConstraintReference scaleX(float r10) {
        this.mScaleX = r10;
        return this;
    }

    public ConstraintReference scaleY(float r10) {
        this.mScaleY = r10;
        return this;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public void setConstraintWidget(ConstraintWidget r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.mConstraintWidget = r10;
        r10.setCompanionWidget(this.mView);
    }

    public void setFacade(Facade r10) {
        this.mFacade = r10;
        if (r10 == null) goto L6;
        setConstraintWidget(r10.getConstraintWidget());
        return;
    }

    public ConstraintReference setHeight(Dimension r10) {
        this.mVerticalDimension = r10;
        return this;
    }

    public void setHorizontalChainStyle(int r10) {
        this.mHorizontalChainStyle = r10;
    }

    public void setHorizontalChainWeight(float r10) {
        this.mHorizontalChainWeight = r10;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public void setKey(Object r10) {
        this.key = r10;
    }

    public void setTag(String r10) {
        this.mTag = r10;
    }

    public void setVerticalChainStyle(int r10) {
        this.mVerticalChainStyle = r10;
    }

    public void setVerticalChainWeight(float r10) {
        this.mVerticalChainWeight = r10;
    }

    public void setView(Object r10) {
        this.mView = r10;
        ConstraintWidget r11 = this.mConstraintWidget;
        if (r11 == null) goto L6;
        r11.setCompanionWidget(r10);
        return;
    }

    public ConstraintReference setWidth(Dimension r10) {
        this.mHorizontalDimension = r10;
        return this;
    }

    public ConstraintReference start() {
        if (this.mStartToStart == null) goto L5;
        State.Constraint r10 = State.Constraint.START_TO_START;
    L6:
        this.mLast = r10;
        return this;
    L5:
        r10 = State.Constraint.START_TO_END;
        goto L6
    }

    public ConstraintReference startToEnd(Object r10) {
        this.mLast = State.Constraint.START_TO_END;
        this.mStartToEnd = r10;
        return this;
    }

    public ConstraintReference startToStart(Object r10) {
        this.mLast = State.Constraint.START_TO_START;
        this.mStartToStart = r10;
        return this;
    }

    public ConstraintReference top() {
        if (this.mTopToTop == null) goto L5;
        State.Constraint r10 = State.Constraint.TOP_TO_TOP;
    L6:
        this.mLast = r10;
        return this;
    L5:
        r10 = State.Constraint.TOP_TO_BOTTOM;
        goto L6
    }

    public ConstraintReference topToBottom(Object r10) {
        this.mLast = State.Constraint.TOP_TO_BOTTOM;
        this.mTopToBottom = r10;
        return this;
    }

    public ConstraintReference topToTop(Object r10) {
        this.mLast = State.Constraint.TOP_TO_TOP;
        this.mTopToTop = r10;
        return this;
    }

    public ConstraintReference translationX(float r10) {
        this.mTranslationX = r10;
        return this;
    }

    public ConstraintReference translationY(float r10) {
        this.mTranslationY = r10;
        return this;
    }

    public ConstraintReference translationZ(float r10) {
        this.mTranslationZ = r10;
        return this;
    }

    public void validate() {
        ArrayList r10 = new ArrayList();
        if (this.mLeftToLeft == null) goto L8;
        if (this.mLeftToRight == null) goto L8;
        r10.add("LeftToLeft and LeftToRight both defined");
    L8:
        if (this.mRightToLeft == null) goto L13;
        if (this.mRightToRight == null) goto L13;
        r10.add("RightToLeft and RightToRight both defined");
    L13:
        if (this.mStartToStart == null) goto L18;
        if (this.mStartToEnd == null) goto L18;
        r10.add("StartToStart and StartToEnd both defined");
    L18:
        if (this.mEndToStart == null) goto L23;
        if (this.mEndToEnd == null) goto L23;
        r10.add("EndToStart and EndToEnd both defined");
    L23:
        if (this.mLeftToLeft != null) goto L31;
        if (this.mLeftToRight != null) goto L31;
        if (this.mRightToLeft != null) goto L31;
        if (this.mRightToRight != null) goto L31;
    L40:
        if (r10.size() > 0) goto L43;
        return;
    L43:
        throw new IncorrectConstraintException(r10);
    L31:
        if (this.mStartToStart == null) goto L33;
    L38:
        r10.add("Both left/right and start/end constraints defined");
        goto L40
    L33:
        if (this.mStartToEnd != null) goto L38;
        if (this.mEndToStart != null) goto L38;
        if (this.mEndToEnd == null) goto L40;
        goto L38
    }

    public ConstraintReference verticalBias(float r10) {
        this.mVerticalBias = r10;
        return this;
    }

    public ConstraintReference visibility(int r10) {
        this.mVisibility = r10;
        return this;
    }

    public ConstraintReference width(Dimension r10) {
        return setWidth(r10);
    }
}
