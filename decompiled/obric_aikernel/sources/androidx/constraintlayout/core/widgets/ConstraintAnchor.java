package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.Cache;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.analyzer.Grouping;
import androidx.constraintlayout.core.widgets.analyzer.WidgetGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintAnchor {
    private static final boolean ALLOW_BINARY = false;
    private static final int UNSET_GONE_MARGIN = Integer.MIN_VALUE;
    private HashSet<ConstraintAnchor> mDependents;
    private int mFinalValue;
    int mGoneMargin;
    private boolean mHasFinalValue;
    public int mMargin;
    public final ConstraintWidget mOwner;
    SolverVariable mSolverVariable;
    public ConstraintAnchor mTarget;
    public final Type mType;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.widgets.ConstraintAnchor$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type = null;

        static {
            int[] r10 = new int[Type.values().length];
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type = r10;
            r10[Type.CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[Type.LEFT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[Type.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[Type.TOP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[Type.BOTTOM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[Type.BASELINE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[Type.CENTER_X.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[Type.CENTER_Y.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[Type.NONE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
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
            Type r10 = new Type("NONE", 0);
            NONE = r10;
            Type r11 = new Type("LEFT", 1);
            LEFT = r11;
            Type r12 = new Type("TOP", 2);
            TOP = r12;
            Type r13 = new Type("RIGHT", 3);
            RIGHT = r13;
            Type r14 = new Type("BOTTOM", 4);
            BOTTOM = r14;
            Type r15 = new Type("BASELINE", 5);
            BASELINE = r15;
            Type r16 = new Type("CENTER", 6);
            CENTER = r16;
            Type r17 = new Type("CENTER_X", 7);
            CENTER_X = r17;
            Type r18 = new Type("CENTER_Y", 8);
            CENTER_Y = r18;
            $VALUES = new Type[]{r10, r11, r12, r13, r14, r15, r16, r17, r18};
        }

        private Type(String r10, int r11) {
            super(r10, r11);
        }

        public static Type valueOf(String r10) {
            return (Type) Enum.valueOf(Type.class, r10);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    public ConstraintAnchor(ConstraintWidget r10, Type r11) {
        this.mDependents = null;
        this.mMargin = 0;
        this.mGoneMargin = Integer.MIN_VALUE;
        this.mOwner = r10;
        this.mType = r11;
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
        int r13 = r12.size();
        int r14 = 0;
    L9:
        if (r14 >= r13) goto L18;
        ConstraintAnchor r15 = r12.get(r14);
        if (r15.isSimilarDimensionConnection(this) == false) goto L17;
        if (r15.isConnected() == false) goto L17;
        if (isConnectionToMe(r15.getTarget().getOwner(), r11) == false) goto L17;
        return true;
    L17:
        r14 = r14 + 1;
        goto L9
    L18:
        return false;
    }

    public boolean connect(ConstraintAnchor r10, int r11) {
        return connect(r10, r11, Integer.MIN_VALUE, false);
    }

    public boolean connect(ConstraintAnchor r10, int r11, int r12, boolean r13) {
        if (r10 != null) goto L6;
        reset();
        return true;
    L6:
        if (r13 == false) goto L8;
    L11:
        this.mTarget = r10;
        if (r10.mDependents != null) goto L14;
        r10.mDependents = new HashSet();
    L14:
        HashSet<ConstraintAnchor> r14 = this.mTarget.mDependents;
        if (r14 == null) goto L17;
        r14.add(this);
    L17:
        this.mMargin = r11;
        this.mGoneMargin = r12;
        return true;
    L8:
        if (isValidConnection(r10) == true) goto L11;
        return false;
    }

    public void copyFrom(ConstraintAnchor r10, HashMap<ConstraintWidget, ConstraintWidget> r11) {
        ConstraintAnchor r12 = this.mTarget;
        if (r12 == null) goto L7;
        HashSet<ConstraintAnchor> r13 = r12.mDependents;
        if (r13 == null) goto L7;
        r13.remove(this);
    L7:
        ConstraintAnchor r14 = r10.mTarget;
        if (r14 == null) goto L10;
        Type r15 = r14.getType();
        ConstraintAnchor r16 = r11.get(r10.mTarget.mOwner).getAnchor(r15);
    L11:
        this.mTarget = r16;
        ConstraintAnchor r17 = this.mTarget;
        if (r17 != null) goto L14;
    L17:
        this.mMargin = r10.mMargin;
        this.mGoneMargin = r10.mGoneMargin;
        return;
    L14:
        if (r17.mDependents != null) goto L16;
        r17.mDependents = new HashSet();
    L16:
        this.mTarget.mDependents.add(this);
        goto L17
    L10:
        r16 = null;
        goto L11
    }

    public void findDependents(int r10, ArrayList<WidgetGroup> r11, WidgetGroup r12) {
        HashSet<ConstraintAnchor> r13 = this.mDependents;
        if (r13 == null) goto L8;
        Iterator<ConstraintAnchor> r14 = r13.iterator();
    L6:
        if (r14.hasNext() == false) goto L10;
        Grouping.findDependents(r14.next().mOwner, r10, r11, r12);
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
        if (this.mGoneMargin == Integer.MIN_VALUE) goto L15;
        ConstraintAnchor r10 = this.mTarget;
        if (r10 == null) goto L15;
        if (r10.mOwner.getVisibility() != 8) goto L15;
        return this.mGoneMargin;
    L15:
        return this.mMargin;
    }

    public final ConstraintAnchor getOpposite() {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
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
        HashSet<ConstraintAnchor> r10 = this.mDependents;
        if (r10 != null) goto L5;
        return false;
    L5:
        Iterator<ConstraintAnchor> r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L12;
        if (r11.next().getOpposite().isConnected() == false) goto L7;
        return true;
    L12:
        return false;
    }

    public boolean hasDependents() {
        HashSet<ConstraintAnchor> r10 = this.mDependents;
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r10.size() <= 0) goto L9;
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

    public boolean isConnectionAllowed(ConstraintWidget r10) {
        if (isConnectionToMe(r10, new HashSet()) == false) goto L5;
        return false;
    L5:
        ConstraintWidget r11 = getOwner().getParent();
        if (r11 != r10) goto L9;
        return true;
    L9:
        if (r10.getParent() != r11) goto L11;
        return true;
    L11:
        return false;
    }

    public boolean isConnectionAllowed(ConstraintWidget r10, ConstraintAnchor r11) {
        return isConnectionAllowed(r10);
    }

    public boolean isSideAnchor() {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
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

    public boolean isSimilarDimensionConnection(ConstraintAnchor r10) {
        Type r11 = r10.getType();
        Type r12 = this.mType;
        if (r11 != r12) goto L6;
        return true;
    L6:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[r12.ordinal()]) {
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
        if (r11 != Type.TOP) goto L13;
        return true;
    L13:
        if (r11 != Type.BOTTOM) goto L15;
        return true;
    L15:
        if (r11 != Type.CENTER_Y) goto L17;
        return true;
    L17:
        if (r11 != Type.BASELINE) goto L20;
        return true;
    L20:
        return false;
    L22:
        if (r11 != Type.LEFT) goto L24;
        return true;
    L24:
        if (r11 != Type.RIGHT) goto L26;
        return true;
    L26:
        if (r11 != Type.CENTER_X) goto L29;
        return true;
    L29:
        return false;
    L31:
        if (r11 == Type.BASELINE) goto L34;
        return true;
    L34:
        return false;
    }

    public boolean isValidConnection(ConstraintAnchor r10) {
        boolean r11 = false;
        if (r10 != null) goto L5;
        return false;
    L5:
        Type r12 = r10.getType();
        Type r13 = this.mType;
        if (r12 != r13) goto L16;
        if (r13 == Type.BASELINE) goto L10;
    L14:
        return true;
    L10:
        if (r10.getOwner().hasBaseline() == true) goto L12;
    L13:
        return false;
    L12:
        if (getOwner().hasBaseline() == true) goto L14;
    L16:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[r13.ordinal()]) {
            case 1: goto L58;
            case 2: goto L43;
            case 3: goto L43;
            case 4: goto L28;
            case 5: goto L28;
            case 6: goto L21;
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
        if (r12 != Type.LEFT) goto L23;
    L26:
        return false;
    L23:
        if (r12 == Type.RIGHT) goto L26;
        return true;
    L28:
        if (r12 != Type.TOP) goto L30;
    L33:
        boolean r14 = true;
    L35:
        if ((r10.getOwner() instanceof Guideline) == false) goto L65;
        if (r14 == false) goto L38;
    L39:
        r11 = true;
    L41:
        return r11;
    L38:
        if (r12 != Type.CENTER_Y) goto L41;
    L65:
        return r14;
    L30:
        if (r12 == Type.BOTTOM) goto L33;
        r14 = false;
        goto L35
    L43:
        if (r12 != Type.LEFT) goto L45;
    L48:
        boolean r15 = true;
    L50:
        if ((r10.getOwner() instanceof Guideline) == false) goto L66;
        if (r15 == false) goto L53;
    L54:
        r11 = true;
    L56:
        return r11;
    L53:
        if (r12 != Type.CENTER_X) goto L56;
    L66:
        return r15;
    L45:
        if (r12 == Type.RIGHT) goto L48;
        r15 = false;
        goto L50
    L58:
        if (r12 != Type.BASELINE) goto L60;
        return false;
    L60:
        if (r12 != Type.CENTER_X) goto L62;
        return false;
    L62:
        if (r12 != Type.CENTER_Y) goto L64;
        return false;
    L64:
        return true;
    }

    public boolean isVerticalAnchor() {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
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
        ConstraintAnchor r10 = this.mTarget;
        if (r10 == null) goto L9;
        HashSet<ConstraintAnchor> r11 = r10.mDependents;
        if (r11 == null) goto L9;
        r11.remove(this);
        if (this.mTarget.mDependents.size() != 0) goto L9;
        this.mTarget.mDependents = null;
    L9:
        this.mDependents = null;
        this.mTarget = null;
        this.mMargin = 0;
        this.mGoneMargin = Integer.MIN_VALUE;
        this.mHasFinalValue = false;
        this.mFinalValue = 0;
    }

    public void resetFinalResolution() {
        this.mHasFinalValue = false;
        this.mFinalValue = 0;
    }

    public void resetSolverVariable(Cache r10) {
        SolverVariable r11 = this.mSolverVariable;
        if (r11 != null) goto L5;
        this.mSolverVariable = new SolverVariable(SolverVariable.Type.UNRESTRICTED, null);
        return;
    L5:
        r11.reset();
    }

    public void setFinalValue(int r10) {
        this.mFinalValue = r10;
        this.mHasFinalValue = true;
    }

    public void setGoneMargin(int r10) {
        if (isConnected() == false) goto L6;
        this.mGoneMargin = r10;
        return;
    }

    public void setMargin(int r10) {
        if (isConnected() == false) goto L6;
        this.mMargin = r10;
        return;
    }

    public String toString() {
        return this.mOwner.getDebugName() + ":" + this.mType.toString();
    }
}
