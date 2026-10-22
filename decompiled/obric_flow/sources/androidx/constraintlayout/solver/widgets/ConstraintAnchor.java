package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.analyzer.Grouping;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintAnchor {
    private static final boolean ALLOW_BINARY = false;
    private static final int UNSET_GONE_MARGIN = -1;
    private HashSet<ConstraintAnchor> mDependents;
    private int mFinalValue;
    int mGoneMargin;
    private boolean mHasFinalValue;
    public int mMargin;
    public final ConstraintWidget mOwner;
    SolverVariable mSolverVariable;
    public ConstraintAnchor mTarget;
    public final Type mType;

    /* JADX INFO: renamed from: androidx.constraintlayout.solver.widgets.ConstraintAnchor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = null;

        static {
            int[] r5 = new int[Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = r5;
            r5[Type.CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.LEFT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.TOP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.BOTTOM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.BASELINE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.CENTER_X.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.CENTER_Y.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.NONE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type BASELINE = null;
        public static final Type BOTTOM = null;
        public static final Type CENTER = null;
        public static final Type CENTER_X = null;
        public static final Type CENTER_Y = null;
        public static final Type LEFT = null;
        public static final Type NONE = null;
        public static final Type RIGHT = null;
        public static final Type TOP = null;

        static {
            Type r5 = new Type("NONE", 0);
            NONE = r5;
            Type r10 = new Type("LEFT", 1);
            LEFT = r10;
            Type r11 = new Type("TOP", 2);
            TOP = r11;
            Type r12 = new Type("RIGHT", 3);
            RIGHT = r12;
            Type r13 = new Type("BOTTOM", 4);
            BOTTOM = r13;
            Type r14 = new Type("BASELINE", 5);
            BASELINE = r14;
            Type r15 = new Type("CENTER", 6);
            CENTER = r15;
            Type r16 = new Type("CENTER_X", 7);
            CENTER_X = r16;
            Type r17 = new Type("CENTER_Y", 8);
            CENTER_Y = r17;
            $VALUES = new Type[]{r5, r10, r11, r12, r13, r14, r15, r16, r17};
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

    public ConstraintAnchor(ConstraintWidget r5, Type r10) {
        this.mDependents = null;
        this.mMargin = 0;
        this.mGoneMargin = -1;
        this.mOwner = r5;
        this.mType = r10;
    }

    private boolean isConnectionToMe(ConstraintWidget r10, HashSet<ConstraintWidget> r11) {
        if (r11.contains(r10) == false) goto L5;
        return false;
    L5:
        r11.add(r10);
        if (r10 != getOwner()) goto L8;
        return true;
    L8:
        ArrayList<ConstraintAnchor> r12 = r10.getAnchors();
        int r5 = r12.size();
        int r13 = 0;
    L9:
        if (r13 >= r5) goto L18;
        ConstraintAnchor r14 = r12.get(r13);
        if (r14.isSimilarDimensionConnection(this) == false) goto L17;
        if (r14.isConnected() == false) goto L17;
        if (isConnectionToMe(r14.getTarget().getOwner(), r11) == false) goto L17;
        return true;
    L17:
        r13 = r13 + 1;
        goto L9
    L18:
        return false;
    }

    public boolean connect(ConstraintAnchor r5, int r10, int r11, boolean r12) {
        if (r5 != null) goto L7;
        reset();
        return true;
    L7:
        if (r12 == false) goto L9;
    L11:
        this.mTarget = r5;
        if (r5.mDependents != null) goto L14;
        r5.mDependents = new HashSet();
    L14:
        HashSet<ConstraintAnchor> r13 = this.mTarget.mDependents;
        if (r13 == null) goto L17;
        r13.add(this);
    L17:
        if (r10 <= 0) goto L19;
        this.mMargin = r10;
    L20:
        this.mGoneMargin = r11;
        return true;
    L19:
        this.mMargin = 0;
        goto L20
    L9:
        if (isValidConnection(r5) == true) goto L11;
        return false;
    }

    public void copyFrom(ConstraintAnchor r5, HashMap<ConstraintWidget, ConstraintWidget> r10) {
        ConstraintAnchor r11 = this.mTarget;
        if (r11 == null) goto L7;
        HashSet<ConstraintAnchor> r12 = r11.mDependents;
        if (r12 == null) goto L7;
        r12.remove(this);
    L7:
        ConstraintAnchor r13 = r5.mTarget;
        if (r13 == null) goto L10;
        Type r14 = r13.getType();
        this.mTarget = r10.get(r5.mTarget.mOwner).getAnchor(r14);
    L11:
        ConstraintAnchor r15 = this.mTarget;
        if (r15 != null) goto L14;
    L17:
        this.mMargin = r5.mMargin;
        this.mGoneMargin = r5.mGoneMargin;
        return;
    L14:
        if (r15.mDependents != null) goto L16;
        r15.mDependents = new HashSet();
    L16:
        this.mTarget.mDependents.add(this);
        goto L17
    L10:
        this.mTarget = null;
        goto L11
    }

    public void findDependents(int r5, ArrayList<WidgetGroup> r10, WidgetGroup r11) {
        HashSet<ConstraintAnchor> r12 = this.mDependents;
        if (r12 == null) goto L8;
        Iterator<ConstraintAnchor> r13 = r12.iterator();
    L6:
        if (r13.hasNext() == false) goto L10;
        Grouping.findDependents(r13.next().mOwner, r5, r10, r11);
        goto L6
    L10:
        return;
    }

    public HashSet<ConstraintAnchor> getDependents() {
        return this.mDependents;
    }

    public int getFinalValue() {
        if (this.mHasFinalValue == true) goto L7;
        return 0;
    L7:
        return this.mFinalValue;
    }

    public int getMargin() {
        if (this.mOwner.getVisibility() != 8) goto L7;
        return 0;
    L7:
        if (this.mGoneMargin <= (-1)) goto L15;
        ConstraintAnchor r5 = this.mTarget;
        if (r5 == null) goto L15;
        if (r5.mOwner.getVisibility() != 8) goto L15;
        return this.mGoneMargin;
    L15:
        return this.mMargin;
    }

    public final ConstraintAnchor getOpposite() {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L14;
            case 7: goto L14;
            case 8: goto L14;
            case 9: goto L14;
            default: goto L5;
        };
    L14:
        return null;
    L5:
        throw new AssertionError(this.mType.name());
    L7:
        return this.mOwner.mTop;
    L9:
        return this.mOwner.mBottom;
    L11:
        return this.mOwner.mLeft;
    L13:
        return this.mOwner.mRight;
    }

    public ConstraintWidget getOwner() {
        return this.mOwner;
    }

    public SolverVariable getSolverVariable() {
        return this.mSolverVariable;
    }

    public ConstraintAnchor getTarget() {
        return this.mTarget;
    }

    public Type getType() {
        return this.mType;
    }

    public boolean hasCenteredDependents() {
        HashSet<ConstraintAnchor> r5 = this.mDependents;
        if (r5 != null) goto L5;
        return false;
    L5:
        Iterator<ConstraintAnchor> r10 = r5.iterator();
    L7:
        if (r10.hasNext() == false) goto L12;
        if (r10.next().getOpposite().isConnected() == false) goto L7;
        return true;
    L12:
        return false;
    }

    public boolean hasDependents() {
        HashSet<ConstraintAnchor> r5 = this.mDependents;
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5.size() <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean hasFinalValue() {
        return this.mHasFinalValue;
    }

    public boolean isConnected() {
        if (this.mTarget == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isConnectionAllowed(ConstraintWidget r5, ConstraintAnchor r10) {
        return isConnectionAllowed(r5);
    }

    public boolean isSideAnchor() {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
            case 1: goto L8;
            case 2: goto L6;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L8;
            case 7: goto L8;
            case 8: goto L8;
            case 9: goto L8;
            default: goto L5;
        };
    L6:
        return true;
    L8:
        return false;
    L5:
        throw new AssertionError(this.mType.name());
    }

    public boolean isSimilarDimensionConnection(ConstraintAnchor r5) {
        Type r10 = r5.getType();
        Type r11 = this.mType;
        if (r10 != r11) goto L6;
        return true;
    L6:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[r11.ordinal()]) {
            case 1: goto L31;
            case 2: goto L22;
            case 3: goto L22;
            case 4: goto L11;
            case 5: goto L11;
            case 6: goto L11;
            case 7: goto L22;
            case 8: goto L11;
            case 9: goto L9;
            default: goto L8;
        };
    L9:
        return false;
    L8:
        throw new AssertionError(this.mType.name());
    L11:
        if (r10 != Type.TOP) goto L13;
        return true;
    L13:
        if (r10 != Type.BOTTOM) goto L15;
        return true;
    L15:
        if (r10 != Type.CENTER_Y) goto L17;
        return true;
    L17:
        if (r10 != Type.BASELINE) goto L20;
        return true;
    L20:
        return false;
    L22:
        if (r10 != Type.LEFT) goto L24;
        return true;
    L24:
        if (r10 != Type.RIGHT) goto L26;
        return true;
    L26:
        if (r10 != Type.CENTER_X) goto L29;
        return true;
    L29:
        return false;
    L31:
        if (r10 == Type.BASELINE) goto L34;
        return true;
    L34:
        return false;
    }

    public boolean isValidConnection(ConstraintAnchor r10) {
        boolean r5 = false;
        if (r10 != null) goto L5;
        return false;
    L5:
        Type r11 = r10.getType();
        Type r12 = this.mType;
        if (r11 != r12) goto L16;
        if (r12 == Type.BASELINE) goto L10;
    L14:
        return true;
    L10:
        if (r10.getOwner().hasBaseline() == true) goto L12;
    L13:
        return false;
    L12:
        if (getOwner().hasBaseline() == true) goto L14;
    L16:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[r12.ordinal()]) {
            case 1: goto L51;
            case 2: goto L36;
            case 3: goto L36;
            case 4: goto L21;
            case 5: goto L21;
            case 6: goto L19;
            case 7: goto L19;
            case 8: goto L19;
            case 9: goto L19;
            default: goto L18;
        };
    L19:
        return false;
    L18:
        throw new AssertionError(this.mType.name());
    L21:
        if (r11 != Type.TOP) goto L23;
    L26:
        boolean r13 = true;
    L28:
        if ((r10.getOwner() instanceof Guideline) == false) goto L58;
        if (r13 == false) goto L31;
    L32:
        r5 = true;
    L34:
        return r5;
    L31:
        if (r11 != Type.CENTER_Y) goto L34;
    L58:
        return r13;
    L23:
        if (r11 == Type.BOTTOM) goto L26;
        r13 = false;
        goto L28
    L36:
        if (r11 != Type.LEFT) goto L38;
    L41:
        boolean r14 = true;
    L43:
        if ((r10.getOwner() instanceof Guideline) == false) goto L59;
        if (r14 == false) goto L46;
    L47:
        r5 = true;
    L49:
        return r5;
    L46:
        if (r11 != Type.CENTER_X) goto L49;
    L59:
        return r14;
    L38:
        if (r11 == Type.RIGHT) goto L41;
        r14 = false;
        goto L43
    L51:
        if (r11 != Type.BASELINE) goto L53;
        return false;
    L53:
        if (r11 != Type.CENTER_X) goto L55;
        return false;
    L55:
        if (r11 != Type.CENTER_Y) goto L57;
        return false;
    L57:
        return true;
    }

    public boolean isVerticalAnchor() {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
            case 1: goto L8;
            case 2: goto L8;
            case 3: goto L8;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L6;
            case 7: goto L8;
            case 8: goto L6;
            case 9: goto L6;
            default: goto L5;
        };
    L6:
        return true;
    L8:
        return false;
    L5:
        throw new AssertionError(this.mType.name());
    }

    public void reset() {
        ConstraintAnchor r5 = this.mTarget;
        if (r5 == null) goto L9;
        HashSet<ConstraintAnchor> r10 = r5.mDependents;
        if (r10 == null) goto L9;
        r10.remove(this);
        if (this.mTarget.mDependents.size() != 0) goto L9;
        this.mTarget.mDependents = null;
    L9:
        this.mDependents = null;
        this.mTarget = null;
        this.mMargin = 0;
        this.mGoneMargin = -1;
        this.mHasFinalValue = false;
        this.mFinalValue = 0;
    }

    public void resetFinalResolution() {
        this.mHasFinalValue = false;
        this.mFinalValue = 0;
    }

    public void resetSolverVariable(Cache r5) {
        SolverVariable r10 = this.mSolverVariable;
        if (r10 != null) goto L5;
        this.mSolverVariable = new SolverVariable(SolverVariable.Type.UNRESTRICTED, null);
        return;
    L5:
        r10.reset();
    }

    public void setFinalValue(int r5) {
        this.mFinalValue = r5;
        this.mHasFinalValue = true;
    }

    public void setGoneMargin(int r5) {
        if (isConnected() == false) goto L6;
        this.mGoneMargin = r5;
        return;
    }

    public void setMargin(int r5) {
        if (isConnected() == false) goto L6;
        this.mMargin = r5;
        return;
    }

    public String toString() {
        return this.mOwner.getDebugName() + ":" + this.mType.toString();
    }

    public boolean isConnectionAllowed(ConstraintWidget r5) {
        if (isConnectionToMe(r5, new HashSet()) == false) goto L5;
        return false;
    L5:
        ConstraintWidget r10 = getOwner().getParent();
        if (r10 != r5) goto L9;
        return true;
    L9:
        if (r5.getParent() != r10) goto L11;
        return true;
    L11:
        return false;
    }

    public boolean connect(ConstraintAnchor r5, int r10) {
        return connect(r5, r10, -1, false);
    }
}
