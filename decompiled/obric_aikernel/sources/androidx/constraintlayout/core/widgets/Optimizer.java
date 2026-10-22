package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;

/* JADX INFO: loaded from: classes.dex */
public class Optimizer {
    static final int FLAG_CHAIN_DANGLING = 1;
    static final int FLAG_RECOMPUTE_BOUNDS = 2;
    static final int FLAG_USE_OPTIMIZE = 0;
    public static final int OPTIMIZATION_BARRIER = 2;
    public static final int OPTIMIZATION_CACHE_MEASURES = 256;
    public static final int OPTIMIZATION_CHAIN = 4;
    public static final int OPTIMIZATION_DEPENDENCY_ORDERING = 512;
    public static final int OPTIMIZATION_DIMENSIONS = 8;
    public static final int OPTIMIZATION_DIRECT = 1;
    public static final int OPTIMIZATION_GRAPH = 64;
    public static final int OPTIMIZATION_GRAPH_WRAP = 128;
    public static final int OPTIMIZATION_GROUPING = 1024;
    public static final int OPTIMIZATION_GROUPS = 32;
    public static final int OPTIMIZATION_NONE = 0;
    public static final int OPTIMIZATION_RATIO = 16;
    public static final int OPTIMIZATION_STANDARD = 257;
    static boolean[] flags;

    static {
        flags = new boolean[3];
    }

    public Optimizer() {
    }

    static void checkMatchParent(ConstraintWidgetContainer r10, LinearSystem r11, ConstraintWidget r12) {
        r12.mHorizontalResolution = -1;
        r12.mVerticalResolution = -1;
        ConstraintWidget.DimensionBehaviour r13 = r10.mListDimensionBehaviors[0];
        ConstraintWidget.DimensionBehaviour r14 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r13 == r14) goto L8;
        if (r12.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L8;
        int r15 = r12.mLeft.mMargin;
        int r16 = r10.getWidth() - r12.mRight.mMargin;
        ConstraintAnchor r17 = r12.mLeft;
        r17.mSolverVariable = r11.createObjectVariable(r17);
        ConstraintAnchor r18 = r12.mRight;
        r18.mSolverVariable = r11.createObjectVariable(r18);
        r11.addEquality(r12.mLeft.mSolverVariable, r15);
        r11.addEquality(r12.mRight.mSolverVariable, r16);
        r12.mHorizontalResolution = 2;
        r12.setHorizontalDimension(r15, r16);
    L8:
        if (r10.mListDimensionBehaviors[1] != r14) goto L10;
        return;
    L10:
        if (r12.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L19;
        int r19 = r12.mTop.mMargin;
        int r20 = r10.getHeight() - r12.mBottom.mMargin;
        ConstraintAnchor r21 = r12.mTop;
        r21.mSolverVariable = r11.createObjectVariable(r21);
        ConstraintAnchor r22 = r12.mBottom;
        r22.mSolverVariable = r11.createObjectVariable(r22);
        r11.addEquality(r12.mTop.mSolverVariable, r19);
        r11.addEquality(r12.mBottom.mSolverVariable, r20);
        if (r12.mBaselineDistance <= 0) goto L14;
    L15:
        ConstraintAnchor r23 = r12.mBaseline;
        r23.mSolverVariable = r11.createObjectVariable(r23);
        r11.addEquality(r12.mBaseline.mSolverVariable, r12.mBaselineDistance + r19);
    L16:
        r12.mVerticalResolution = 2;
        r12.setVerticalDimension(r19, r20);
        return;
    L14:
        if (r12.getVisibility() != 8) goto L16;
    }

    public static final boolean enabled(int r10, int r11) {
        if ((r10 & r11) != r11) goto L5;
        return true;
    L5:
        return false;
    }
}
