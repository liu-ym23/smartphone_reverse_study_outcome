package androidx.constraintlayout.solver.widgets;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ChainHead {
    private boolean mDefined;
    protected ConstraintWidget mFirst;
    protected ConstraintWidget mFirstMatchConstraintWidget;
    protected ConstraintWidget mFirstVisibleWidget;
    protected boolean mHasComplexMatchWeights;
    protected boolean mHasDefinedWeights;
    protected boolean mHasRatio;
    protected boolean mHasUndefinedWeights;
    protected ConstraintWidget mHead;
    private boolean mIsRtl;
    protected ConstraintWidget mLast;
    protected ConstraintWidget mLastMatchConstraintWidget;
    protected ConstraintWidget mLastVisibleWidget;
    boolean mOptimizable;
    private int mOrientation;
    int mTotalMargins;
    int mTotalSize;
    protected float mTotalWeight;
    int mVisibleWidgets;
    protected ArrayList<ConstraintWidget> mWeightedMatchConstraintsWidgets;
    protected int mWidgetsCount;
    protected int mWidgetsMatchCount;

    public ChainHead(ConstraintWidget r5, int r10, boolean r11) {
        this.mTotalWeight = 0.0f;
        this.mFirst = r5;
        this.mOrientation = r10;
        this.mIsRtl = r11;
    }

    private void defineChainProperties() {
        int r5 = this.mOrientation * 2;
        ConstraintWidget r10 = this.mFirst;
        boolean r11 = true;
        this.mOptimizable = true;
        ConstraintWidget r12 = r10;
        boolean r13 = false;
    L3:
        if (r13 == true) goto L74;
        this.mWidgetsCount++;
        ConstraintWidget[] r14 = r10.mNextChainWidget;
        int r15 = this.mOrientation;
        ConstraintWidget r16 = null;
        r14[r15] = null;
        r10.mListNextMatchConstraintsWidget[r15] = null;
        if (r10.getVisibility() == 8) goto L60;
        this.mVisibleWidgets++;
        ConstraintWidget.DimensionBehaviour r17 = r10.getDimensionBehaviour(this.mOrientation);
        ConstraintWidget.DimensionBehaviour r18 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r17 == r18) goto L9;
        this.mTotalSize = r10.getLength(this.mOrientation) + this.mTotalSize;
    L9:
        int r19 = r10.mListAnchors[r5].getMargin() + this.mTotalSize;
        this.mTotalSize = r19;
        int r110 = r5 + 1;
        this.mTotalSize = r10.mListAnchors[r110].getMargin() + r19;
        int r111 = r10.mListAnchors[r5].getMargin() + this.mTotalMargins;
        this.mTotalMargins = r111;
        this.mTotalMargins = r10.mListAnchors[r110].getMargin() + r111;
        if (this.mFirstVisibleWidget != null) goto L12;
        this.mFirstVisibleWidget = r10;
    L12:
        this.mLastVisibleWidget = r10;
        ConstraintWidget.DimensionBehaviour[] r20 = r10.mListDimensionBehaviors;
        int r112 = this.mOrientation;
        if (r20[r112] != r18) goto L60;
        int r21 = r10.mResolvedMatchConstraintDefault[r112];
        if (r21 != 0) goto L17;
    L19:
        this.mWidgetsMatchCount++;
        float r22 = r10.mWeight[r112];
        if (r22 <= 0.0f) goto L23;
        this.mTotalWeight += r22;
    L23:
        if (isMatchConstraintEqualityCandidate(r10, r112) == false) goto L33;
        if (r22 >= 0.0f) goto L27;
        this.mHasUndefinedWeights = true;
    L29:
        if (this.mWeightedMatchConstraintsWidgets != null) goto L31;
        this.mWeightedMatchConstraintsWidgets = new ArrayList();
    L31:
        this.mWeightedMatchConstraintsWidgets.add(r10);
        goto L33
    L27:
        this.mHasDefinedWeights = true;
    L33:
        if (this.mFirstMatchConstraintWidget != null) goto L35;
        this.mFirstMatchConstraintWidget = r10;
    L35:
        ConstraintWidget r23 = this.mLastMatchConstraintWidget;
        if (r23 == null) goto L38;
        r23.mListNextMatchConstraintsWidget[this.mOrientation] = r10;
    L38:
        this.mLastMatchConstraintWidget = r10;
    L40:
        if (this.mOrientation != 0) goto L50;
        if (r10.mMatchConstraintDefaultWidth == 0) goto L45;
        this.mOptimizable = false;
    L58:
        if (r10.mDimensionRatio == 0.0f) goto L60;
        this.mOptimizable = false;
        this.mHasRatio = true;
        goto L60
    L45:
        if (r10.mMatchConstraintMinWidth == 0) goto L47;
    L48:
        this.mOptimizable = false;
        goto L58
    L47:
        if (r10.mMatchConstraintMaxWidth == 0) goto L58;
    L50:
        if (r10.mMatchConstraintDefaultHeight == 0) goto L53;
        this.mOptimizable = false;
        goto L58
    L53:
        if (r10.mMatchConstraintMinHeight == 0) goto L55;
    L56:
        this.mOptimizable = false;
        goto L58
    L55:
        if (r10.mMatchConstraintMaxHeight == 0) goto L58;
    L17:
        if (r21 == 3) goto L19;
        if (r21 != 2) goto L40;
    L60:
        if (r12 == r10) goto L62;
        r12.mNextChainWidget[this.mOrientation] = r10;
    L62:
        ConstraintAnchor r24 = r10.mListAnchors[r5 + 1].mTarget;
        if (r24 == null) goto L70;
        ConstraintWidget r25 = r24.mOwner;
        ConstraintAnchor r26 = r25.mListAnchors[r5].mTarget;
        if (r26 == null) goto L70;
        if (r26.mOwner != r10) goto L70;
        r16 = r25;
    L70:
        if (r16 != null) goto L73;
        r16 = r10;
        r13 = true;
    L73:
        r12 = r10;
        r10 = r16;
        goto L3
    L74:
        ConstraintWidget r27 = this.mFirstVisibleWidget;
        if (r27 == null) goto L77;
        this.mTotalSize -= r27.mListAnchors[r5].getMargin();
    L77:
        ConstraintWidget r28 = this.mLastVisibleWidget;
        if (r28 == null) goto L80;
        this.mTotalSize -= r28.mListAnchors[r5 + 1].getMargin();
    L80:
        this.mLast = r10;
        if (this.mOrientation == 0) goto L83;
    L85:
        this.mHead = this.mFirst;
    L87:
        if (this.mHasDefinedWeights == true) goto L89;
    L91:
        r11 = false;
    L92:
        this.mHasComplexMatchWeights = r11;
        return;
    L89:
        if (this.mHasUndefinedWeights == false) goto L91;
    L83:
        if (this.mIsRtl == false) goto L85;
        this.mHead = r10;
        goto L87
    }

    private static boolean isMatchConstraintEqualityCandidate(ConstraintWidget r5, int r10) {
        if (r5.getVisibility() != 8) goto L5;
    L11:
        return false;
    L5:
        if (r5.mListDimensionBehaviors[r10] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L11;
        int r11 = r5.mResolvedMatchConstraintDefault[r10];
        if (r11 != 0) goto L9;
    L10:
        return true;
    L9:
        if (r11 != 3) goto L11;
        goto L10
    }

    public void define() {
        if (this.mDefined == true) goto L5;
        defineChainProperties();
    L5:
        this.mDefined = true;
    }

    public ConstraintWidget getFirst() {
        return this.mFirst;
    }

    public ConstraintWidget getFirstMatchConstraintWidget() {
        return this.mFirstMatchConstraintWidget;
    }

    public ConstraintWidget getFirstVisibleWidget() {
        return this.mFirstVisibleWidget;
    }

    public ConstraintWidget getHead() {
        return this.mHead;
    }

    public ConstraintWidget getLast() {
        return this.mLast;
    }

    public ConstraintWidget getLastMatchConstraintWidget() {
        return this.mLastMatchConstraintWidget;
    }

    public ConstraintWidget getLastVisibleWidget() {
        return this.mLastVisibleWidget;
    }

    public float getTotalWeight() {
        return this.mTotalWeight;
    }
}
