package androidx.constraintlayout.core.widgets;

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

    public ChainHead(ConstraintWidget r10, int r11, boolean r12) {
        this.mTotalWeight = 0.0f;
        this.mIsRtl = false;
        this.mFirst = r10;
        this.mOrientation = r11;
        this.mIsRtl = r12;
    }

    private void defineChainProperties() {
        int r10 = this.mOrientation * 2;
        ConstraintWidget r11 = this.mFirst;
        boolean r12 = true;
        this.mOptimizable = true;
        ConstraintWidget r13 = r11;
        boolean r14 = false;
    L3:
        if (r14 == true) goto L75;
        this.mWidgetsCount++;
        ConstraintWidget[] r15 = r11.mNextChainWidget;
        int r16 = this.mOrientation;
        ConstraintWidget r17 = null;
        r15[r16] = null;
        r11.mListNextMatchConstraintsWidget[r16] = null;
        if (r11.getVisibility() == 8) goto L61;
        this.mVisibleWidgets++;
        ConstraintWidget.DimensionBehaviour r18 = r11.getDimensionBehaviour(this.mOrientation);
        ConstraintWidget.DimensionBehaviour r19 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r18 == r19) goto L9;
        this.mTotalSize += r11.getLength(this.mOrientation);
    L9:
        int r20 = this.mTotalSize + r11.mListAnchors[r10].getMargin();
        this.mTotalSize = r20;
        int r110 = r10 + 1;
        this.mTotalSize = r20 + r11.mListAnchors[r110].getMargin();
        int r21 = this.mTotalMargins + r11.mListAnchors[r10].getMargin();
        this.mTotalMargins = r21;
        this.mTotalMargins = r21 + r11.mListAnchors[r110].getMargin();
        if (this.mFirstVisibleWidget != null) goto L12;
        this.mFirstVisibleWidget = r11;
    L12:
        this.mLastVisibleWidget = r11;
        ConstraintWidget.DimensionBehaviour[] r22 = r11.mListDimensionBehaviors;
        int r111 = this.mOrientation;
        if (r22[r111] != r19) goto L61;
        int[] r23 = r11.mResolvedMatchConstraintDefault;
        if (r23[r111] != 0) goto L17;
    L20:
        this.mWidgetsMatchCount++;
        float[] r24 = r11.mWeight;
        float r25 = r24[r111];
        if (r25 <= 0.0f) goto L24;
        this.mTotalWeight += r24[r111];
    L24:
        if (isMatchConstraintEqualityCandidate(r11, r111) == false) goto L34;
        if (r25 >= 0.0f) goto L28;
        this.mHasUndefinedWeights = true;
    L30:
        if (this.mWeightedMatchConstraintsWidgets != null) goto L32;
        this.mWeightedMatchConstraintsWidgets = new ArrayList();
    L32:
        this.mWeightedMatchConstraintsWidgets.add(r11);
        goto L34
    L28:
        this.mHasDefinedWeights = true;
    L34:
        if (this.mFirstMatchConstraintWidget != null) goto L36;
        this.mFirstMatchConstraintWidget = r11;
    L36:
        ConstraintWidget r26 = this.mLastMatchConstraintWidget;
        if (r26 == null) goto L39;
        r26.mListNextMatchConstraintsWidget[this.mOrientation] = r11;
    L39:
        this.mLastMatchConstraintWidget = r11;
    L41:
        if (this.mOrientation != 0) goto L51;
        if (r11.mMatchConstraintDefaultWidth == 0) goto L46;
    L52:
        this.mOptimizable = false;
    L59:
        if (r11.mDimensionRatio == 0.0f) goto L61;
        this.mOptimizable = false;
        this.mHasRatio = true;
        goto L61
    L46:
        if (r11.mMatchConstraintMinWidth != 0) goto L52;
        if (r11.mMatchConstraintMaxWidth == 0) goto L59;
    L51:
        if (r11.mMatchConstraintDefaultHeight != 0) goto L52;
        if (r11.mMatchConstraintMinHeight != 0) goto L52;
        if (r11.mMatchConstraintMaxHeight == 0) goto L59;
    L17:
        if (r23[r111] == 3) goto L20;
        if (r23[r111] != 2) goto L41;
    L61:
        if (r13 == r11) goto L63;
        r13.mNextChainWidget[this.mOrientation] = r11;
    L63:
        ConstraintAnchor r27 = r11.mListAnchors[r10 + 1].mTarget;
        if (r27 == null) goto L71;
        ConstraintWidget r28 = r27.mOwner;
        ConstraintAnchor[] r29 = r28.mListAnchors;
        if (r29[r10].mTarget == null) goto L71;
        if (r29[r10].mTarget.mOwner != r11) goto L71;
        r17 = r28;
    L71:
        if (r17 != null) goto L74;
        r17 = r11;
        r14 = true;
    L74:
        r13 = r11;
        r11 = r17;
        goto L3
    L75:
        ConstraintWidget r30 = this.mFirstVisibleWidget;
        if (r30 == null) goto L78;
        this.mTotalSize -= r30.mListAnchors[r10].getMargin();
    L78:
        ConstraintWidget r31 = this.mLastVisibleWidget;
        if (r31 == null) goto L81;
        this.mTotalSize -= r31.mListAnchors[r10 + 1].getMargin();
    L81:
        this.mLast = r11;
        if (this.mOrientation == 0) goto L84;
    L86:
        this.mHead = this.mFirst;
    L88:
        if (this.mHasDefinedWeights == true) goto L90;
    L92:
        r12 = false;
    L93:
        this.mHasComplexMatchWeights = r12;
        return;
    L90:
        if (this.mHasUndefinedWeights == false) goto L92;
    L84:
        if (this.mIsRtl == false) goto L86;
        this.mHead = r11;
        goto L88
    }

    private static boolean isMatchConstraintEqualityCandidate(ConstraintWidget r10, int r11) {
        if (r10.getVisibility() != 8) goto L5;
    L11:
        return false;
    L5:
        if (r10.mListDimensionBehaviors[r11] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L11;
        int[] r12 = r10.mResolvedMatchConstraintDefault;
        if (r12[r11] != 0) goto L9;
    L10:
        return true;
    L9:
        if (r12[r11] != 3) goto L11;
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
