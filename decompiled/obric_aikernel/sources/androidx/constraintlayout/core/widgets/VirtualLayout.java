package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.HashSet;

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

    public void applyRtl(boolean r10) {
        int r11 = this.mPaddingStart;
        if (r11 <= 0) goto L5;
    L6:
        if (r10 == false) goto L8;
        this.mResolvedPaddingLeft = this.mPaddingEnd;
        this.mResolvedPaddingRight = r11;
        return;
    L8:
        this.mResolvedPaddingLeft = r11;
        this.mResolvedPaddingRight = this.mPaddingEnd;
        return;
    L5:
        if (this.mPaddingEnd > 0) goto L6;
    }

    public void captureWidgets() {
        int r10 = 0;
    L4:
        if (r10 >= this.mWidgetsCount) goto L9;
        ConstraintWidget r11 = this.mWidgets[r10];
        if (r11 == null) goto L8;
        r11.setInVirtualLayout(true);
    L8:
        r10 = r10 + 1;
        goto L4
    }

    public boolean contains(HashSet<ConstraintWidget> r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.mWidgetsCount) goto L10;
        if (r10.contains(this.mWidgets[r11]) == true) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
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

    public void measure(int r10, int r11, int r12, int r13) {
    }

    protected void measure(ConstraintWidget r10, ConstraintWidget.DimensionBehaviour r11, int r12, ConstraintWidget.DimensionBehaviour r13, int r14) {
    L3:
        if (this.mMeasurer != null) goto L7;
        if (getParent() == null) goto L7;
        this.mMeasurer = ((ConstraintWidgetContainer) getParent()).getMeasurer();
    L7:
        BasicMeasure.Measure r15 = this.mMeasure;
        r15.horizontalBehavior = r11;
        r15.verticalBehavior = r13;
        r15.horizontalDimension = r12;
        r15.verticalDimension = r14;
        this.mMeasurer.measure(r10, r15);
        r10.setWidth(this.mMeasure.measuredWidth);
        r10.setHeight(this.mMeasure.measuredHeight);
        r10.setHasBaseline(this.mMeasure.measuredHasBaseline);
        r10.setBaselineDistance(this.mMeasure.measuredBaseline);
    }

    protected boolean measureChildren() {
        ConstraintWidget r10 = this.mParent;
        if (r10 == null) goto L5;
        BasicMeasure.Measurer r11 = ((ConstraintWidgetContainer) r10).getMeasurer();
    L7:
        if (r11 != null) goto L9;
        return false;
    L9:
        int r12 = 0;
    L10:
        boolean r13 = true;
        if (r12 >= this.mWidgetsCount) goto L35;
        ConstraintWidget r14 = this.mWidgets[r12];
        if (r14 == null) goto L34;
        if ((r14 instanceof Guideline) == true) goto L34;
        ConstraintWidget.DimensionBehaviour r15 = r14.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour r16 = r14.getDimensionBehaviour(1);
        ConstraintWidget.DimensionBehaviour r17 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r15 == r17) goto L21;
    L26:
        r13 = false;
    L27:
        if (r13 == true) goto L34;
        if (r15 != r17) goto L31;
        r15 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
    L31:
        if (r16 != r17) goto L33;
        r16 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
    L33:
        BasicMeasure.Measure r18 = this.mMeasure;
        r18.horizontalBehavior = r15;
        r18.verticalBehavior = r16;
        r18.horizontalDimension = r14.getWidth();
        this.mMeasure.verticalDimension = r14.getHeight();
        r11.measure(r14, this.mMeasure);
        r14.setWidth(this.mMeasure.measuredWidth);
        r14.setHeight(this.mMeasure.measuredHeight);
        r14.setBaselineDistance(this.mMeasure.measuredBaseline);
        goto L34
    L21:
        if (r14.mMatchConstraintDefaultWidth == 1) goto L26;
        if (r16 != r17) goto L26;
        if (r14.mMatchConstraintDefaultHeight == 1) goto L26;
    L34:
        r12 = r12 + 1;
        goto L10
    L35:
        return true;
    L5:
        r11 = null;
        goto L7
    }

    public boolean needSolverPass() {
        return this.mNeedsCallFromSolver;
    }

    protected void needsCallbackFromSolver(boolean r10) {
        this.mNeedsCallFromSolver = r10;
    }

    public void setMeasure(int r10, int r11) {
        this.mMeasuredWidth = r10;
        this.mMeasuredHeight = r11;
    }

    public void setPadding(int r10) {
        this.mPaddingLeft = r10;
        this.mPaddingTop = r10;
        this.mPaddingRight = r10;
        this.mPaddingBottom = r10;
        this.mPaddingStart = r10;
        this.mPaddingEnd = r10;
    }

    public void setPaddingBottom(int r10) {
        this.mPaddingBottom = r10;
    }

    public void setPaddingEnd(int r10) {
        this.mPaddingEnd = r10;
    }

    public void setPaddingLeft(int r10) {
        this.mPaddingLeft = r10;
        this.mResolvedPaddingLeft = r10;
    }

    public void setPaddingRight(int r10) {
        this.mPaddingRight = r10;
        this.mResolvedPaddingRight = r10;
    }

    public void setPaddingStart(int r10) {
        this.mPaddingStart = r10;
        this.mResolvedPaddingLeft = r10;
        this.mResolvedPaddingRight = r10;
    }

    public void setPaddingTop(int r10) {
        this.mPaddingTop = r10;
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.Helper
    public void updateConstraints(ConstraintWidgetContainer r10) {
        captureWidgets();
    }
}
