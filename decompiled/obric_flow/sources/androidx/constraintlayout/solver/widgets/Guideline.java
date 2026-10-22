package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class Guideline extends ConstraintWidget {
    public static final int HORIZONTAL = 0;
    public static final int RELATIVE_BEGIN = 1;
    public static final int RELATIVE_END = 2;
    public static final int RELATIVE_PERCENT = 0;
    public static final int RELATIVE_UNKNWON = -1;
    public static final int VERTICAL = 1;
    private ConstraintAnchor mAnchor;
    private int mMinimumPosition;
    private int mOrientation;
    protected int mRelativeBegin;
    protected int mRelativeEnd;
    protected float mRelativePercent;
    private boolean resolved;

    /* JADX INFO: renamed from: androidx.constraintlayout.solver.widgets.Guideline$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = null;

        static {
            int[] r5 = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = r5;
            r5[ConstraintAnchor.Type.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.NONE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    public Guideline() {
        this.mRelativePercent = -1.0f;
        this.mRelativeBegin = -1;
        this.mRelativeEnd = -1;
        this.mAnchor = this.mTop;
        int r5 = 0;
        this.mOrientation = 0;
        this.mMinimumPosition = 0;
        this.mAnchors.clear();
        this.mAnchors.add(this.mAnchor);
        int r10 = this.mListAnchors.length;
    L3:
        if (r5 >= r10) goto L5;
        this.mListAnchors[r5] = this.mAnchor;
        r5 = r5 + 1;
        goto L3
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem r10, boolean r11) {
        ConstraintWidgetContainer r12 = (ConstraintWidgetContainer) getParent();
        if (r12 != null) goto L5;
        return;
    L5:
        ConstraintAnchor r5 = r12.getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor r13 = r12.getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintWidget r14 = this.mParent;
        boolean r15 = true;
        if (r14 != null) goto L8;
    L10:
        boolean r16 = false;
    L12:
        if (this.mOrientation != 0) goto L21;
        r5 = r12.getAnchor(ConstraintAnchor.Type.TOP);
        r13 = r12.getAnchor(ConstraintAnchor.Type.BOTTOM);
        ConstraintWidget r17 = this.mParent;
        if (r17 != null) goto L16;
    L18:
        r15 = false;
    L19:
        r16 = r15;
        goto L21
    L16:
        if (r17.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L18;
    L21:
        if (this.resolved == false) goto L35;
        if (this.mAnchor.hasFinalValue() == false) goto L35;
        SolverVariable r18 = r10.createObjectVariable(this.mAnchor);
        r10.addEquality(r18, this.mAnchor.getFinalValue());
        if (this.mRelativeBegin == (-1)) goto L29;
        if (r16 == false) goto L32;
        r10.addGreaterThan(r10.createObjectVariable(r13), r18, 0, 5);
    L32:
        this.resolved = false;
        return;
    L29:
        if (this.mRelativeEnd == (-1)) goto L32;
        if (r16 == false) goto L32;
        SolverVariable r19 = r10.createObjectVariable(r13);
        r10.addGreaterThan(r18, r10.createObjectVariable(r5), 0, 5);
        r10.addGreaterThan(r19, r18, 0, 5);
    L35:
        if (this.mRelativeBegin == (-1)) goto L40;
        SolverVariable r20 = r10.createObjectVariable(this.mAnchor);
        r10.addEquality(r20, r10.createObjectVariable(r5), this.mRelativeBegin, 8);
        if (r16 == false) goto L48;
        r10.addGreaterThan(r10.createObjectVariable(r13), r20, 0, 5);
        return;
    L48:
        return;
    L40:
        if (this.mRelativeEnd == (-1)) goto L45;
        SolverVariable r21 = r10.createObjectVariable(this.mAnchor);
        SolverVariable r22 = r10.createObjectVariable(r13);
        r10.addEquality(r21, r22, -this.mRelativeEnd, 8);
        if (r16 == false) goto L50;
        r10.addGreaterThan(r21, r10.createObjectVariable(r5), 0, 5);
        r10.addGreaterThan(r22, r21, 0, 5);
        return;
    L50:
        return;
    L45:
        if (this.mRelativePercent == (-1.0f)) goto L52;
        r10.addConstraint(LinearSystem.createRowDimensionPercent(r10, r10.createObjectVariable(this.mAnchor), r10.createObjectVariable(r13), this.mRelativePercent));
        return;
    L52:
        return;
    L8:
        if (r14.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L10;
        r16 = true;
        goto L12
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        return true;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void copy(ConstraintWidget r5, HashMap<ConstraintWidget, ConstraintWidget> r10) {
        super.copy(r5, r10);
        Guideline r11 = (Guideline) r5;
        this.mRelativePercent = r11.mRelativePercent;
        this.mRelativeBegin = r11.mRelativeBegin;
        this.mRelativeEnd = r11.mRelativeEnd;
        setOrientation(r11.mOrientation);
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

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public String getType() {
        return "Guideline";
    }

    public void inferRelativeBeginPosition() {
        int r5 = getX();
        if (this.mOrientation != 0) goto L5;
        r5 = getY();
    L5:
        setGuideBegin(r5);
    }

    public void inferRelativeEndPosition() {
        int r5 = getParent().getWidth() - getX();
        if (this.mOrientation != 0) goto L5;
        r5 = getParent().getHeight() - getY();
    L5:
        setGuideEnd(r5);
    }

    public void inferRelativePercentPosition() {
        float r5 = getX() / getParent().getWidth();
        if (this.mOrientation != 0) goto L5;
        r5 = getY() / getParent().getHeight();
    L5:
        setGuidePercent(r5);
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

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean isResolvedHorizontally() {
        return this.resolved;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean isResolvedVertically() {
        return this.resolved;
    }

    public void setFinalValue(int r5) {
        this.mAnchor.setFinalValue(r5);
        this.resolved = true;
    }

    public void setGuideBegin(int r5) {
        if (r5 <= (-1)) goto L6;
        this.mRelativePercent = -1.0f;
        this.mRelativeBegin = r5;
        this.mRelativeEnd = -1;
        return;
    }

    public void setGuideEnd(int r5) {
        if (r5 <= (-1)) goto L6;
        this.mRelativePercent = -1.0f;
        this.mRelativeBegin = -1;
        this.mRelativeEnd = r5;
        return;
    }

    public void setGuidePercent(int r5) {
        setGuidePercent(r5 / 100.0f);
    }

    public void setMinimumPosition(int r5) {
        this.mMinimumPosition = r5;
    }

    public void setOrientation(int r5) {
        if (this.mOrientation != r5) goto L5;
        return;
    L5:
        this.mOrientation = r5;
        this.mAnchors.clear();
        if (this.mOrientation != 1) goto L8;
        this.mAnchor = this.mLeft;
    L9:
        this.mAnchors.add(this.mAnchor);
        int r10 = this.mListAnchors.length;
        int r11 = 0;
    L10:
        if (r11 >= r10) goto L12;
        this.mListAnchors[r11] = this.mAnchor;
        r11 = r11 + 1;
        goto L10
    L12:
        return;
    L8:
        this.mAnchor = this.mTop;
        goto L9
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void updateFromSolver(LinearSystem r5, boolean r10) {
        if (getParent() != null) goto L5;
        return;
    L5:
        int r11 = r5.getObjectVariableValue(this.mAnchor);
        if (this.mOrientation != 1) goto L8;
        setX(r11);
        setY(0);
        setHeight(getParent().getHeight());
        setWidth(0);
        return;
    L8:
        setX(0);
        setY(r11);
        setWidth(getParent().getWidth());
        setHeight(0);
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public ConstraintAnchor getAnchor(ConstraintAnchor.Type r5) {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[r5.ordinal()]) {
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L5;
            case 6: goto L5;
            case 7: goto L5;
            case 8: goto L5;
            case 9: goto L5;
            default: goto L16;
        };
    L5:
        return null;
    L8:
        if (this.mOrientation != 0) goto L16;
        return this.mAnchor;
    L12:
        if (this.mOrientation != 1) goto L16;
        return this.mAnchor;
    L16:
        throw new AssertionError(r5.name());
    }

    public void setGuidePercent(float r5) {
        if (r5 <= (-1.0f)) goto L6;
        this.mRelativePercent = r5;
        this.mRelativeBegin = -1;
        this.mRelativeEnd = -1;
        return;
    }
}
