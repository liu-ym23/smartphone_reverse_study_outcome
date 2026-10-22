package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;

/* JADX INFO: loaded from: classes.dex */
public class VirtualLayout extends HelperWidget {
    protected BasicMeasure.Measure mMeasure;
    private int mMeasuredHeight;
    private int mMeasuredWidth;
    BasicMeasure.Measurer mMeasurer;
    private boolean mNeedsCallFromSolver;
    private int mPaddingBottom;
    private int mPaddingEnd;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingStart;
    private int mPaddingTop;
    private int mResolvedPaddingLeft;
    private int mResolvedPaddingRight;

    public VirtualLayout() {
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingStart = 0;
        this.mPaddingEnd = 0;
        this.mResolvedPaddingLeft = 0;
        this.mResolvedPaddingRight = 0;
        this.mNeedsCallFromSolver = false;
        this.mMeasuredWidth = 0;
        this.mMeasuredHeight = 0;
        this.mMeasure = new BasicMeasure.Measure();
        this.mMeasurer = null;
    }

    public void applyRtl(boolean r5) {
        int r10 = this.mPaddingStart;
        if (r10 <= 0) goto L5;
    L6:
        if (r5 == false) goto L8;
        this.mResolvedPaddingLeft = this.mPaddingEnd;
        this.mResolvedPaddingRight = r10;
        return;
    L8:
        this.mResolvedPaddingLeft = r10;
        this.mResolvedPaddingRight = this.mPaddingEnd;
        return;
    L5:
        if (this.mPaddingEnd > 0) goto L6;
    }

    public void captureWidgets() {
        int r5 = 0;
    L4:
        if (r5 >= this.mWidgetsCount) goto L9;
        ConstraintWidget r10 = this.mWidgets[r5];
        if (r10 == null) goto L8;
        r10.setInVirtualLayout(true);
    L8:
        r5 = r5 + 1;
        goto L4
    }

    public int getMeasuredHeight() {
        return this.mMeasuredHeight;
    }

    public int getMeasuredWidth() {
        return this.mMeasuredWidth;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getPaddingLeft() {
        return this.mResolvedPaddingLeft;
    }

    public int getPaddingRight() {
        return this.mResolvedPaddingRight;
    }

    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    public void measure(int r5, int r10, int r11, int r12) {
    }

    public boolean measureChildren() {
        ConstraintWidget r5 = this.mParent;
        if (r5 == null) goto L5;
        BasicMeasure.Measurer r10 = ((ConstraintWidgetContainer) r5).getMeasurer();
    L7:
        if (r10 != null) goto L9;
        return false;
    L9:
        int r11 = 0;
    L11:
        if (r11 >= this.mWidgetsCount) goto L32;
        ConstraintWidget r12 = this.mWidgets[r11];
        if (r12 == null) goto L31;
        if ((r12 instanceof Guideline) == true) goto L31;
        ConstraintWidget.DimensionBehaviour r13 = r12.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour r14 = r12.getDimensionBehaviour(1);
        ConstraintWidget.DimensionBehaviour r15 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r13 == r15) goto L21;
    L26:
        if (r13 != r15) goto L28;
        r13 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
    L28:
        if (r14 != r15) goto L30;
        r14 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
    L30:
        BasicMeasure.Measure r16 = this.mMeasure;
        r16.horizontalBehavior = r13;
        r16.verticalBehavior = r14;
        r16.horizontalDimension = r12.getWidth();
        this.mMeasure.verticalDimension = r12.getHeight();
        r10.measure(r12, this.mMeasure);
        r12.setWidth(this.mMeasure.measuredWidth);
        r12.setHeight(this.mMeasure.measuredHeight);
        r12.setBaselineDistance(this.mMeasure.measuredBaseline);
        goto L31
    L21:
        if (r12.mMatchConstraintDefaultWidth == 1) goto L26;
        if (r14 != r15) goto L26;
        if (r12.mMatchConstraintDefaultHeight == 1) goto L26;
    L31:
        r11 = r11 + 1;
        goto L11
    L32:
        return true;
    L5:
        r10 = null;
        goto L7
    }

    public boolean needSolverPass() {
        return this.mNeedsCallFromSolver;
    }

    public void needsCallbackFromSolver(boolean r5) {
        this.mNeedsCallFromSolver = r5;
    }

    public void setMeasure(int r5, int r10) {
        this.mMeasuredWidth = r5;
        this.mMeasuredHeight = r10;
    }

    public void setPadding(int r5) {
        this.mPaddingLeft = r5;
        this.mPaddingTop = r5;
        this.mPaddingRight = r5;
        this.mPaddingBottom = r5;
        this.mPaddingStart = r5;
        this.mPaddingEnd = r5;
    }

    public void setPaddingBottom(int r5) {
        this.mPaddingBottom = r5;
    }

    public void setPaddingEnd(int r5) {
        this.mPaddingEnd = r5;
    }

    public void setPaddingLeft(int r5) {
        this.mPaddingLeft = r5;
        this.mResolvedPaddingLeft = r5;
    }

    public void setPaddingRight(int r5) {
        this.mPaddingRight = r5;
        this.mResolvedPaddingRight = r5;
    }

    public void setPaddingStart(int r5) {
        this.mPaddingStart = r5;
        this.mResolvedPaddingLeft = r5;
        this.mResolvedPaddingRight = r5;
    }

    public void setPaddingTop(int r5) {
        this.mPaddingTop = r5;
    }

    @Override // androidx.constraintlayout.solver.widgets.HelperWidget, androidx.constraintlayout.solver.widgets.Helper
    public void updateConstraints(ConstraintWidgetContainer r5) {
        captureWidgets();
    }

    public void measure(ConstraintWidget r5, ConstraintWidget.DimensionBehaviour r10, int r11, ConstraintWidget.DimensionBehaviour r12, int r13) {
    L3:
        if (this.mMeasurer != null) goto L7;
        if (getParent() == null) goto L7;
        this.mMeasurer = ((ConstraintWidgetContainer) getParent()).getMeasurer();
    L7:
        BasicMeasure.Measure r14 = this.mMeasure;
        r14.horizontalBehavior = r10;
        r14.verticalBehavior = r12;
        r14.horizontalDimension = r11;
        r14.verticalDimension = r13;
        this.mMeasurer.measure(r5, r14);
        r5.setWidth(this.mMeasure.measuredWidth);
        r5.setHeight(this.mMeasure.measuredHeight);
        r5.setHasBaseline(this.mMeasure.measuredHasBaseline);
        r5.setBaselineDistance(this.mMeasure.measuredBaseline);
    }
}
