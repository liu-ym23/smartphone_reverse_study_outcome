package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintReference implements Reference {
    private Object key;
    Object mBaselineToBaseline;
    Object mBottomToBottom;
    Object mBottomToTop;
    private ConstraintWidget mConstraintWidget;
    Object mEndToEnd;
    Object mEndToStart;
    float mHorizontalBias;
    int mHorizontalChainStyle;
    Dimension mHorizontalDimension;
    State.Constraint mLast;
    Object mLeftToLeft;
    Object mLeftToRight;
    int mMarginBottom;
    int mMarginBottomGone;
    int mMarginEnd;
    int mMarginEndGone;
    int mMarginLeft;
    int mMarginLeftGone;
    int mMarginRight;
    int mMarginRightGone;
    int mMarginStart;
    int mMarginStartGone;
    int mMarginTop;
    int mMarginTopGone;
    Object mRightToLeft;
    Object mRightToRight;
    Object mStartToEnd;
    Object mStartToStart;
    final State mState;
    Object mTopToBottom;
    Object mTopToTop;
    float mVerticalBias;
    int mVerticalChainStyle;
    Dimension mVerticalDimension;
    private Object mView;

    /* JADX INFO: renamed from: androidx.constraintlayout.solver.state.ConstraintReference$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint = null;

        static {
            int[] r5 = new int[State.Constraint.values().length];
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint = r5;
            r5[State.Constraint.LEFT_TO_LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L54:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.LEFT_TO_RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L38:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.RIGHT_TO_LEFT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L50:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.RIGHT_TO_RIGHT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L56:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.START_TO_START.ordinal()] = 5;     // Catch: NoSuchFieldError -> L23
        L40:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.START_TO_END.ordinal()] = 6;     // Catch: NoSuchFieldError -> L24
        L44:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.END_TO_START.ordinal()] = 7;     // Catch: NoSuchFieldError -> L25
        L62:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.END_TO_END.ordinal()] = 8;     // Catch: NoSuchFieldError -> L26
        L34:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.TOP_TO_TOP.ordinal()] = 9;     // Catch: NoSuchFieldError -> L27
        L58:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.TOP_TO_BOTTOM.ordinal()] = 10;     // Catch: NoSuchFieldError -> L28
        L60:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.BOTTOM_TO_TOP.ordinal()] = 11;     // Catch: NoSuchFieldError -> L29
        L46:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.BOTTOM_TO_BOTTOM.ordinal()] = 12;     // Catch: NoSuchFieldError -> L30
        L52:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.BASELINE_TO_BASELINE.ordinal()] = 13;     // Catch: NoSuchFieldError -> L31
        L36:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.CENTER_HORIZONTALLY.ordinal()] = 14;     // Catch: NoSuchFieldError -> L32
        L42:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[State.Constraint.CENTER_VERTICALLY.ordinal()] = 15;     // Catch: NoSuchFieldError -> L33
            return;
        }
    }

    public interface ConstraintReferenceFactory {
        ConstraintReference create(State r5);
    }

    public class IncorrectConstraintException extends Exception {
        private final ArrayList<String> mErrors;
        final /* synthetic */ ConstraintReference this$0;

        public IncorrectConstraintException(ConstraintReference r5, ArrayList<String> r10) {
            this.this$0 = r5;
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

    public ConstraintReference(State r5) {
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
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
        this.mLast = null;
        Object r10 = Dimension.WRAP_DIMENSION;
        this.mHorizontalDimension = Dimension.Fixed(r10);
        this.mVerticalDimension = Dimension.Fixed(r10);
        this.mState = r5;
    }

    private void applyConnection(ConstraintWidget r10, Object r11, State.Constraint r12) {
        ConstraintWidget r5 = getTarget(r11);
        if (r5 != null) goto L5;
        return;
    L5:
        int[] r13 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint;
        int r14 = r13[r12.ordinal()];
        switch(r13[r12.ordinal()]) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L11;
            case 11: goto L10;
            case 12: goto L9;
            case 13: goto L8;
            default: goto L34;
        };
    L8:
        ConstraintAnchor.Type r15 = ConstraintAnchor.Type.BASELINE;
        r10.immediateConnect(r15, r5, r15, 0, 0);
        return;
    L9:
        ConstraintAnchor.Type r16 = ConstraintAnchor.Type.BOTTOM;
        r10.getAnchor(r16).connect(r5.getAnchor(r16), this.mMarginBottom, this.mMarginBottomGone, false);
        return;
    L10:
        r10.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(r5.getAnchor(ConstraintAnchor.Type.TOP), this.mMarginBottom, this.mMarginBottomGone, false);
        return;
    L11:
        r10.getAnchor(ConstraintAnchor.Type.TOP).connect(r5.getAnchor(ConstraintAnchor.Type.BOTTOM), this.mMarginTop, this.mMarginTopGone, false);
        return;
    L12:
        ConstraintAnchor.Type r17 = ConstraintAnchor.Type.TOP;
        r10.getAnchor(r17).connect(r5.getAnchor(r17), this.mMarginTop, this.mMarginTopGone, false);
        return;
    L13:
        ConstraintAnchor.Type r18 = ConstraintAnchor.Type.RIGHT;
        r10.getAnchor(r18).connect(r5.getAnchor(r18), this.mMarginEnd, this.mMarginEndGone, false);
        return;
    L14:
        r10.getAnchor(ConstraintAnchor.Type.RIGHT).connect(r5.getAnchor(ConstraintAnchor.Type.LEFT), this.mMarginEnd, this.mMarginEndGone, false);
        return;
    L15:
        r10.getAnchor(ConstraintAnchor.Type.LEFT).connect(r5.getAnchor(ConstraintAnchor.Type.RIGHT), this.mMarginStart, this.mMarginStartGone, false);
        return;
    L16:
        ConstraintAnchor.Type r19 = ConstraintAnchor.Type.LEFT;
        r10.getAnchor(r19).connect(r5.getAnchor(r19), this.mMarginStart, this.mMarginStartGone, false);
        return;
    L17:
        ConstraintAnchor.Type r20 = ConstraintAnchor.Type.RIGHT;
        r10.getAnchor(r20).connect(r5.getAnchor(r20), this.mMarginRight, this.mMarginRightGone, false);
        return;
    L18:
        r10.getAnchor(ConstraintAnchor.Type.RIGHT).connect(r5.getAnchor(ConstraintAnchor.Type.LEFT), this.mMarginRight, this.mMarginRightGone, false);
        return;
    L19:
        r10.getAnchor(ConstraintAnchor.Type.LEFT).connect(r5.getAnchor(ConstraintAnchor.Type.RIGHT), this.mMarginLeft, this.mMarginLeftGone, false);
        return;
    L20:
        ConstraintAnchor.Type r21 = ConstraintAnchor.Type.LEFT;
        r10.getAnchor(r21).connect(r5.getAnchor(r21), this.mMarginLeft, this.mMarginLeftGone, false);
        return;
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
    }

    private Object get(Object r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if ((r5 instanceof ConstraintReference) == false) goto L8;
        return r5;
    L8:
        return this.mState.reference(r5);
    }

    private ConstraintWidget getTarget(Object r5) {
        if ((r5 instanceof Reference) == true) goto L5;
        return null;
    L5:
        return ((Reference) r5).getConstraintWidget();
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void apply() {
        ConstraintWidget r5 = this.mConstraintWidget;
        if (r5 != null) goto L5;
        return;
    L5:
        this.mHorizontalDimension.apply(this.mState, r5, 0);
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
        int r10 = this.mHorizontalChainStyle;
        if (r10 == 0) goto L8;
        this.mConstraintWidget.setHorizontalChainStyle(r10);
    L8:
        int r11 = this.mVerticalChainStyle;
        if (r11 == 0) goto L11;
        this.mConstraintWidget.setVerticalChainStyle(r11);
    L11:
        this.mConstraintWidget.setHorizontalBiasPercent(this.mHorizontalBias);
        this.mConstraintWidget.setVerticalBiasPercent(this.mVerticalBias);
    }

    public ConstraintReference baseline() {
        this.mLast = State.Constraint.BASELINE_TO_BASELINE;
        return this;
    }

    public ConstraintReference baselineToBaseline(Object r5) {
        this.mLast = State.Constraint.BASELINE_TO_BASELINE;
        this.mBaselineToBaseline = r5;
        return this;
    }

    public ConstraintReference bias(float r5) {
        State.Constraint r10 = this.mLast;
        if (r10 != null) goto L6;
        return this;
    L6:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[r10.ordinal()]) {
            case 1: goto L9;
            case 2: goto L9;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L9;
            case 7: goto L9;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L8;
            case 11: goto L8;
            case 12: goto L8;
            case 13: goto L10;
            case 14: goto L9;
            case 15: goto L8;
            default: goto L10;
        };
    L8:
        this.mVerticalBias = r5;
        goto L10
    L9:
        this.mHorizontalBias = r5;
    L10:
        return this;
    }

    public ConstraintReference bottom() {
        if (this.mBottomToTop == null) goto L5;
        this.mLast = State.Constraint.BOTTOM_TO_TOP;
    L6:
        return this;
    L5:
        this.mLast = State.Constraint.BOTTOM_TO_BOTTOM;
        goto L6
    }

    public ConstraintReference bottomToBottom(Object r5) {
        this.mLast = State.Constraint.BOTTOM_TO_BOTTOM;
        this.mBottomToBottom = r5;
        return this;
    }

    public ConstraintReference bottomToTop(Object r5) {
        this.mLast = State.Constraint.BOTTOM_TO_TOP;
        this.mBottomToTop = r5;
        return this;
    }

    public ConstraintReference centerHorizontally(Object r5) {
        Object r10 = get(r5);
        this.mStartToStart = r10;
        this.mEndToEnd = r10;
        this.mLast = State.Constraint.CENTER_HORIZONTALLY;
        this.mHorizontalBias = 0.5f;
        return this;
    }

    public ConstraintReference centerVertically(Object r5) {
        Object r10 = get(r5);
        this.mTopToTop = r10;
        this.mBottomToBottom = r10;
        this.mLast = State.Constraint.CENTER_VERTICALLY;
        this.mVerticalBias = 0.5f;
        return this;
    }

    public ConstraintReference clear() {
        State.Constraint r5 = this.mLast;
        if (r5 != null) goto L5;
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
        this.mHorizontalBias = 0.5f;
        this.mVerticalBias = 0.5f;
        this.mMarginLeftGone = 0;
        this.mMarginRightGone = 0;
        this.mMarginStartGone = 0;
        this.mMarginEndGone = 0;
        this.mMarginTopGone = 0;
        this.mMarginBottomGone = 0;
    L15:
        return this;
    L5:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[r5.ordinal()]) {
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
            case 11: goto L8;
            case 12: goto L8;
            case 13: goto L7;
            default: goto L15;
        };
    L7:
        this.mBaselineToBaseline = null;
        goto L15
    L8:
        this.mBottomToTop = null;
        this.mBottomToBottom = null;
        this.mMarginBottom = 0;
        this.mMarginBottomGone = 0;
        goto L15
    L9:
        this.mTopToTop = null;
        this.mTopToBottom = null;
        this.mMarginTop = 0;
        this.mMarginTopGone = 0;
        goto L15
    L10:
        this.mEndToStart = null;
        this.mEndToEnd = null;
        this.mMarginEnd = 0;
        this.mMarginEndGone = 0;
        goto L15
    L11:
        this.mStartToStart = null;
        this.mStartToEnd = null;
        this.mMarginStart = 0;
        this.mMarginStartGone = 0;
        goto L15
    L12:
        this.mRightToLeft = null;
        this.mRightToRight = null;
        this.mMarginRight = 0;
        this.mMarginRightGone = 0;
        goto L15
    L13:
        this.mLeftToLeft = null;
        this.mLeftToRight = null;
        this.mMarginLeft = 0;
        this.mMarginLeftGone = 0;
        goto L15
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
        this.mLast = State.Constraint.END_TO_START;
    L6:
        return this;
    L5:
        this.mLast = State.Constraint.END_TO_END;
        goto L6
    }

    public ConstraintReference endToEnd(Object r5) {
        this.mLast = State.Constraint.END_TO_END;
        this.mEndToEnd = r5;
        return this;
    }

    public ConstraintReference endToStart(Object r5) {
        this.mLast = State.Constraint.END_TO_START;
        this.mEndToStart = r5;
        return this;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public ConstraintWidget getConstraintWidget() {
        if (this.mConstraintWidget != null) goto L6;
        ConstraintWidget r5 = createConstraintWidget();
        this.mConstraintWidget = r5;
        r5.setCompanionWidget(this.mView);
    L6:
        return this.mConstraintWidget;
    }

    public Dimension getHeight() {
        return this.mVerticalDimension;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public Object getKey() {
        return this.key;
    }

    public int getVerticalChainStyle(int r5) {
        return this.mVerticalChainStyle;
    }

    public Object getView() {
        return this.mView;
    }

    public Dimension getWidth() {
        return this.mHorizontalDimension;
    }

    public ConstraintReference height(Dimension r5) {
        return setHeight(r5);
    }

    public ConstraintReference horizontalBias(float r5) {
        this.mHorizontalBias = r5;
        return this;
    }

    public ConstraintReference left() {
        if (this.mLeftToLeft == null) goto L5;
        this.mLast = State.Constraint.LEFT_TO_LEFT;
    L6:
        return this;
    L5:
        this.mLast = State.Constraint.LEFT_TO_RIGHT;
        goto L6
    }

    public ConstraintReference leftToLeft(Object r5) {
        this.mLast = State.Constraint.LEFT_TO_LEFT;
        this.mLeftToLeft = r5;
        return this;
    }

    public ConstraintReference leftToRight(Object r5) {
        this.mLast = State.Constraint.LEFT_TO_RIGHT;
        this.mLeftToRight = r5;
        return this;
    }

    public ConstraintReference margin(Object r5) {
        return margin(this.mState.convertDimension(r5));
    }

    public ConstraintReference marginGone(int r5) {
        State.Constraint r10 = this.mLast;
        if (r10 != null) goto L5;
        this.mMarginLeftGone = r5;
        this.mMarginRightGone = r5;
        this.mMarginStartGone = r5;
        this.mMarginEndGone = r5;
        this.mMarginTopGone = r5;
        this.mMarginBottomGone = r5;
    L14:
        return this;
    L5:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[r10.ordinal()]) {
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
            case 11: goto L7;
            case 12: goto L7;
            default: goto L14;
        };
    L7:
        this.mMarginBottomGone = r5;
        goto L14
    L8:
        this.mMarginTopGone = r5;
        goto L14
    L9:
        this.mMarginEndGone = r5;
        goto L14
    L10:
        this.mMarginStartGone = r5;
        goto L14
    L11:
        this.mMarginRightGone = r5;
        goto L14
    L12:
        this.mMarginLeftGone = r5;
        goto L14
    }

    public ConstraintReference right() {
        if (this.mRightToLeft == null) goto L5;
        this.mLast = State.Constraint.RIGHT_TO_LEFT;
    L6:
        return this;
    L5:
        this.mLast = State.Constraint.RIGHT_TO_RIGHT;
        goto L6
    }

    public ConstraintReference rightToLeft(Object r5) {
        this.mLast = State.Constraint.RIGHT_TO_LEFT;
        this.mRightToLeft = r5;
        return this;
    }

    public ConstraintReference rightToRight(Object r5) {
        this.mLast = State.Constraint.RIGHT_TO_RIGHT;
        this.mRightToRight = r5;
        return this;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void setConstraintWidget(ConstraintWidget r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.mConstraintWidget = r5;
        r5.setCompanionWidget(this.mView);
    }

    public ConstraintReference setHeight(Dimension r5) {
        this.mVerticalDimension = r5;
        return this;
    }

    public void setHorizontalChainStyle(int r5) {
        this.mHorizontalChainStyle = r5;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void setKey(Object r5) {
        this.key = r5;
    }

    public void setVerticalChainStyle(int r5) {
        this.mVerticalChainStyle = r5;
    }

    public void setView(Object r5) {
        this.mView = r5;
        ConstraintWidget r10 = this.mConstraintWidget;
        if (r10 == null) goto L6;
        r10.setCompanionWidget(r5);
        return;
    }

    public ConstraintReference setWidth(Dimension r5) {
        this.mHorizontalDimension = r5;
        return this;
    }

    public ConstraintReference start() {
        if (this.mStartToStart == null) goto L5;
        this.mLast = State.Constraint.START_TO_START;
    L6:
        return this;
    L5:
        this.mLast = State.Constraint.START_TO_END;
        goto L6
    }

    public ConstraintReference startToEnd(Object r5) {
        this.mLast = State.Constraint.START_TO_END;
        this.mStartToEnd = r5;
        return this;
    }

    public ConstraintReference startToStart(Object r5) {
        this.mLast = State.Constraint.START_TO_START;
        this.mStartToStart = r5;
        return this;
    }

    public ConstraintReference top() {
        if (this.mTopToTop == null) goto L5;
        this.mLast = State.Constraint.TOP_TO_TOP;
    L6:
        return this;
    L5:
        this.mLast = State.Constraint.TOP_TO_BOTTOM;
        goto L6
    }

    public ConstraintReference topToBottom(Object r5) {
        this.mLast = State.Constraint.TOP_TO_BOTTOM;
        this.mTopToBottom = r5;
        return this;
    }

    public ConstraintReference topToTop(Object r5) {
        this.mLast = State.Constraint.TOP_TO_TOP;
        this.mTopToTop = r5;
        return this;
    }

    public void validate() throws IncorrectConstraintException {
        ArrayList r5 = new ArrayList();
        if (this.mLeftToLeft == null) goto L8;
        if (this.mLeftToRight == null) goto L8;
        r5.add("LeftToLeft and LeftToRight both defined");
    L8:
        if (this.mRightToLeft == null) goto L13;
        if (this.mRightToRight == null) goto L13;
        r5.add("RightToLeft and RightToRight both defined");
    L13:
        if (this.mStartToStart == null) goto L18;
        if (this.mStartToEnd == null) goto L18;
        r5.add("StartToStart and StartToEnd both defined");
    L18:
        if (this.mEndToStart == null) goto L23;
        if (this.mEndToEnd == null) goto L23;
        r5.add("EndToStart and EndToEnd both defined");
    L23:
        if (this.mLeftToLeft != null) goto L31;
        if (this.mLeftToRight != null) goto L31;
        if (this.mRightToLeft != null) goto L31;
        if (this.mRightToRight != null) goto L31;
    L40:
        if (r5.size() > 0) goto L43;
        return;
    L43:
        throw new IncorrectConstraintException(this, r5);
    L31:
        if (this.mStartToStart == null) goto L33;
    L38:
        r5.add("Both left/right and start/end constraints defined");
        goto L40
    L33:
        if (this.mStartToEnd != null) goto L38;
        if (this.mEndToStart != null) goto L38;
        if (this.mEndToEnd == null) goto L40;
        goto L38
    }

    public ConstraintReference verticalBias(float r5) {
        this.mVerticalBias = r5;
        return this;
    }

    public ConstraintReference width(Dimension r5) {
        return setWidth(r5);
    }

    public ConstraintReference margin(int r5) {
        State.Constraint r10 = this.mLast;
        if (r10 != null) goto L5;
        this.mMarginLeft = r5;
        this.mMarginRight = r5;
        this.mMarginStart = r5;
        this.mMarginEnd = r5;
        this.mMarginTop = r5;
        this.mMarginBottom = r5;
    L14:
        return this;
    L5:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[r10.ordinal()]) {
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
            case 11: goto L7;
            case 12: goto L7;
            default: goto L14;
        };
    L7:
        this.mMarginBottom = r5;
        goto L14
    L8:
        this.mMarginTop = r5;
        goto L14
    L9:
        this.mMarginEnd = r5;
        goto L14
    L10:
        this.mMarginStart = r5;
        goto L14
    L11:
        this.mMarginRight = r5;
        goto L14
    L12:
        this.mMarginLeft = r5;
        goto L14
    }
}
