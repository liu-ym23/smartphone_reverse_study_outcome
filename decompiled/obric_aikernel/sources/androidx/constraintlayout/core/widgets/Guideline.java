package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class Guideline extends ConstraintWidget {
    public static final int HORIZONTAL = 0;
    public static final int RELATIVE_BEGIN = 1;
    public static final int RELATIVE_END = 2;
    public static final int RELATIVE_PERCENT = 0;
    public static final int RELATIVE_UNKNOWN = -1;
    public static final int VERTICAL = 1;
    protected boolean guidelineUseRtl;
    private ConstraintAnchor mAnchor;
    private int mMinimumPosition;
    private int mOrientation;
    protected int mRelativeBegin;
    protected int mRelativeEnd;
    protected float mRelativePercent;
    private boolean resolved;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.widgets.Guideline$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type = null;

        static {
            int[] r10 = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type = r10;
            r10[ConstraintAnchor.Type.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.NONE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    public Guideline() {
        this.mRelativePercent = -1.0f;
        this.mRelativeBegin = -1;
        this.mRelativeEnd = -1;
        this.guidelineUseRtl = true;
        this.mAnchor = this.mTop;
        int r10 = 0;
        this.mOrientation = 0;
        this.mMinimumPosition = 0;
        this.mAnchors.clear();
        this.mAnchors.add(this.mAnchor);
        int r11 = this.mListAnchors.length;
    L3:
        if (r10 >= r11) goto L5;
        this.mListAnchors[r10] = this.mAnchor;
        r10 = r10 + 1;
        goto L3
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem r10, boolean r11) {
        ConstraintWidgetContainer r12 = (ConstraintWidgetContainer) getParent();
        if (r12 != null) goto L5;
        return;
    L5:
        ConstraintAnchor r13 = r12.getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor r14 = r12.getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintWidget r15 = this.mParent;
        boolean r16 = true;
        if (r15 != null) goto L8;
    L10:
        boolean r17 = false;
    L12:
        if (this.mOrientation != 0) goto L21;
        r13 = r12.getAnchor(ConstraintAnchor.Type.TOP);
        r14 = r12.getAnchor(ConstraintAnchor.Type.BOTTOM);
        ConstraintWidget r18 = this.mParent;
        if (r18 != null) goto L16;
    L18:
        r16 = false;
    L19:
        r17 = r16;
        goto L21
    L16:
        if (r18.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L18;
    L21:
        if (this.resolved == false) goto L35;
        if (this.mAnchor.hasFinalValue() == false) goto L35;
        SolverVariable r19 = r10.createObjectVariable(this.mAnchor);
        r10.addEquality(r19, this.mAnchor.getFinalValue());
        if (this.mRelativeBegin == (-1)) goto L29;
        if (r17 == false) goto L32;
        r10.addGreaterThan(r10.createObjectVariable(r14), r19, 0, 5);
    L32:
        this.resolved = false;
        return;
    L29:
        if (this.mRelativeEnd == (-1)) goto L32;
        if (r17 == false) goto L32;
        SolverVariable r20 = r10.createObjectVariable(r14);
        r10.addGreaterThan(r19, r10.createObjectVariable(r13), 0, 5);
        r10.addGreaterThan(r20, r19, 0, 5);
    L35:
        if (this.mRelativeBegin == (-1)) goto L40;
        SolverVariable r21 = r10.createObjectVariable(this.mAnchor);
        r10.addEquality(r21, r10.createObjectVariable(r13), this.mRelativeBegin, 8);
        if (r17 == false) goto L48;
        r10.addGreaterThan(r10.createObjectVariable(r14), r21, 0, 5);
        return;
    L48:
        return;
    L40:
        if (this.mRelativeEnd == (-1)) goto L45;
        SolverVariable r22 = r10.createObjectVariable(this.mAnchor);
        SolverVariable r23 = r10.createObjectVariable(r14);
        r10.addEquality(r22, r23, -this.mRelativeEnd, 8);
        if (r17 == false) goto L50;
        r10.addGreaterThan(r22, r10.createObjectVariable(r13), 0, 5);
        r10.addGreaterThan(r23, r22, 0, 5);
        return;
    L50:
        return;
    L45:
        if (this.mRelativePercent == (-1.0f)) goto L52;
        r10.addConstraint(LinearSystem.createRowDimensionPercent(r10, r10.createObjectVariable(this.mAnchor), r10.createObjectVariable(r14), this.mRelativePercent));
        return;
    L52:
        return;
    L8:
        if (r15.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L10;
        r17 = true;
        goto L12
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void copy(ConstraintWidget r10, HashMap<ConstraintWidget, ConstraintWidget> r11) {
        super.copy(r10, r11);
        Guideline r12 = (Guideline) r10;
        this.mRelativePercent = r12.mRelativePercent;
        this.mRelativeBegin = r12.mRelativeBegin;
        this.mRelativeEnd = r12.mRelativeEnd;
        this.guidelineUseRtl = r12.guidelineUseRtl;
        setOrientation(r12.mOrientation);
    }

    public void cyclePosition() {
        if (this.mRelativeBegin == (-1)) goto L6;
        inferRelativePercentPosition();
        return;
    L6:
        if (this.mRelativePercent == (-1.0f)) goto L9;
        inferRelativeEndPosition();
        return;
    L9:
        if (this.mRelativeEnd == (-1)) goto L14;
        inferRelativeBeginPosition();
        return;
    }

    public ConstraintAnchor getAnchor() {
        return this.mAnchor;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public ConstraintAnchor getAnchor(ConstraintAnchor.Type r10) {
        int r11 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[r10.ordinal()];
        if (r11 == 1) goto L16;
        if (r11 == 2) goto L16;
        if (r11 == 3) goto L12;
        if (r11 == 4) goto L12;
        return null;
    L12:
        if (this.mOrientation == 0) goto L14;
        return null;
    L14:
        return this.mAnchor;
    L16:
        if (this.mOrientation == 1) goto L18;
        return null;
    L18:
        return this.mAnchor;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getRelativeBegin() {
        return this.mRelativeBegin;
    }

    public int getRelativeBehaviour() {
        if (this.mRelativePercent == (-1.0f)) goto L7;
        return 0;
    L7:
        if (this.mRelativeBegin == (-1)) goto L11;
        return 1;
    L11:
        if (this.mRelativeEnd == (-1)) goto L14;
        return 2;
    L14:
        return -1;
    }

    public int getRelativeEnd() {
        return this.mRelativeEnd;
    }

    public float getRelativePercent() {
        return this.mRelativePercent;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public String getType() {
        return "Guideline";
    }

    void inferRelativeBeginPosition() {
        int r10 = getX();
        if (this.mOrientation != 0) goto L5;
        r10 = getY();
    L5:
        setGuideBegin(r10);
    }

    void inferRelativeEndPosition() {
        int r10 = getParent().getWidth() - getX();
        if (this.mOrientation != 0) goto L5;
        r10 = getParent().getHeight() - getY();
    L5:
        setGuideEnd(r10);
    }

    void inferRelativePercentPosition() {
        float r10 = getX() / getParent().getWidth();
        if (this.mOrientation != 0) goto L5;
        r10 = getY() / getParent().getHeight();
    L5:
        setGuidePercent(r10);
    }

    public boolean isPercent() {
        if (this.mRelativePercent != (-1.0f)) goto L5;
    L9:
        return false;
    L5:
        if (this.mRelativeBegin != (-1)) goto L9;
        if (this.mRelativeEnd != (-1)) goto L9;
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean isResolvedHorizontally() {
        return this.resolved;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean isResolvedVertically() {
        return this.resolved;
    }

    public void setFinalValue(int r10) {
        this.mAnchor.setFinalValue(r10);
        this.resolved = true;
    }

    public void setGuideBegin(int r10) {
        if (r10 <= (-1)) goto L6;
        this.mRelativePercent = -1.0f;
        this.mRelativeBegin = r10;
        this.mRelativeEnd = -1;
        return;
    }

    public void setGuideEnd(int r10) {
        if (r10 <= (-1)) goto L6;
        this.mRelativePercent = -1.0f;
        this.mRelativeBegin = -1;
        this.mRelativeEnd = r10;
        return;
    }

    public void setGuidePercent(float r10) {
        if (r10 <= (-1.0f)) goto L6;
        this.mRelativePercent = r10;
        this.mRelativeBegin = -1;
        this.mRelativeEnd = -1;
        return;
    }

    public void setGuidePercent(int r10) {
        setGuidePercent(r10 / 100.0f);
    }

    public void setMinimumPosition(int r10) {
        this.mMinimumPosition = r10;
    }

    public void setOrientation(int r10) {
        if (this.mOrientation != r10) goto L5;
        return;
    L5:
        this.mOrientation = r10;
        this.mAnchors.clear();
        if (this.mOrientation != 1) goto L8;
        ConstraintAnchor r11 = this.mLeft;
    L9:
        this.mAnchor = r11;
        this.mAnchors.add(this.mAnchor);
        int r12 = this.mListAnchors.length;
        int r13 = 0;
    L10:
        if (r13 >= r12) goto L12;
        this.mListAnchors[r13] = this.mAnchor;
        r13 = r13 + 1;
        goto L10
    L12:
        return;
    L8:
        r11 = this.mTop;
        goto L9
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void updateFromSolver(LinearSystem r10, boolean r11) {
        if (getParent() != null) goto L5;
        return;
    L5:
        int r12 = r10.getObjectVariableValue(this.mAnchor);
        if (this.mOrientation != 1) goto L8;
        setX(r12);
        setY(0);
        setHeight(getParent().getHeight());
        setWidth(0);
        return;
    L8:
        setX(0);
        setY(r12);
        setWidth(getParent().getWidth());
        setHeight(0);
    }
}
