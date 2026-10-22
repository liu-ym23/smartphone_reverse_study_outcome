package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.State;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class HorizontalChainReference extends ChainReference {

    /* JADX INFO: renamed from: androidx.constraintlayout.core.state.helpers.HorizontalChainReference$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$state$State$Chain = null;

        static {
            int[] r0 = new int[State.Chain.values().length];
            $SwitchMap$androidx$constraintlayout$core$state$State$Chain = r0;
            r0[State.Chain.SPREAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$androidx$constraintlayout$core$state$State$Chain[State.Chain.SPREAD_INSIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$androidx$constraintlayout$core$state$State$Chain[State.Chain.PACKED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public HorizontalChainReference(State r2) {
        super(r2, State.Helper.HORIZONTAL_CHAIN);
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        Iterator<Object> r0 = this.mReferences.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        this.mState.constraints(r0.next()).clearHorizontal();
        goto L4
    L6:
        Iterator<Object> r1 = this.mReferences.iterator();
        ConstraintReference r2 = null;
        ConstraintReference r3 = null;
    L8:
        if (r1.hasNext() == false) goto L31;
        ConstraintReference r4 = this.mState.constraints(r1.next());
        if (r3 == null) goto L12;
    L28:
        if (r2 == null) goto L30;
        r2.endToStart(r4.getKey());
        r4.startToEnd(r2.getKey());
    L30:
        r2 = r4;
        goto L8
    L12:
        if (this.mStartToStart == null) goto L17;
        ConstraintReference r5 = r4.startToStart(this.mStartToStart);
    L14:
        ConstraintReference r6 = r5.margin(this.mMarginStart);
        int r7 = this.mMarginStartGone;
    L15:
        r6.marginGone(r7);
    L27:
        r3 = r4;
        goto L28
    L17:
        if (this.mStartToEnd == null) goto L20;
        r5 = r4.startToEnd(this.mStartToEnd);
        goto L14
    L20:
        if (this.mLeftToLeft == null) goto L24;
        ConstraintReference r8 = r4.startToStart(this.mLeftToLeft);
    L22:
        r6 = r8.margin(this.mMarginLeft);
        r7 = this.mMarginLeftGone;
        goto L15
    L24:
        if (this.mLeftToRight == null) goto L26;
        r8 = r4.startToEnd(this.mLeftToRight);
        goto L22
    L26:
        r4.startToStart(State.PARENT);
        goto L27
    L31:
        if (r2 != null) goto L33;
    L48:
        if (r3 != null) goto L51;
        return;
    L51:
        if (this.mBias == 0.5f) goto L53;
        r3.horizontalBias(this.mBias);
    L53:
        int r9 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$state$State$Chain[this.mStyle.ordinal()];
        if (r9 != 1) goto L56;
        r3.setHorizontalChainStyle(0);
        return;
    L56:
        if (r9 != 2) goto L58;
        r3.setHorizontalChainStyle(1);
        return;
    L58:
        if (r9 != 3) goto L70;
        r3.setHorizontalChainStyle(2);
        return;
    L70:
        return;
    L33:
        if (this.mEndToStart == null) goto L38;
        ConstraintReference r10 = r2.endToStart(this.mEndToStart);
    L35:
        ConstraintReference r11 = r10.margin(this.mMarginEnd);
        int r12 = this.mMarginEndGone;
    L36:
        r11.marginGone(r12);
        goto L48
    L38:
        if (this.mEndToEnd == null) goto L41;
        r10 = r2.endToEnd(this.mEndToEnd);
        goto L35
    L41:
        if (this.mRightToLeft == null) goto L45;
        ConstraintReference r13 = r2.endToStart(this.mRightToLeft);
    L43:
        r11 = r13.margin(this.mMarginRight);
        r12 = this.mMarginRightGone;
        goto L36
    L45:
        if (this.mRightToRight == null) goto L47;
        r13 = r2.endToEnd(this.mRightToRight);
        goto L43
    L47:
        r2.endToEnd(State.PARENT);
        goto L48
    }
}
