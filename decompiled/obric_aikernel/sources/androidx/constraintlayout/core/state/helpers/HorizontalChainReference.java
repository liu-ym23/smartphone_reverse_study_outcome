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
            int[] r10 = new int[State.Chain.values().length];
            $SwitchMap$androidx$constraintlayout$core$state$State$Chain = r10;
            r10[State.Chain.SPREAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$androidx$constraintlayout$core$state$State$Chain[State.Chain.SPREAD_INSIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$androidx$constraintlayout$core$state$State$Chain[State.Chain.PACKED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public HorizontalChainReference(State r10) {
        super(r10, State.Helper.HORIZONTAL_CHAIN);
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        Iterator<Object> r10 = this.mReferences.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        this.mState.constraints(r10.next()).clearHorizontal();
        goto L4
    L6:
        Iterator<Object> r11 = this.mReferences.iterator();
        ConstraintReference r12 = null;
        ConstraintReference r13 = null;
    L8:
        if (r11.hasNext() == false) goto L31;
        ConstraintReference r14 = this.mState.constraints(r11.next());
        if (r13 != null) goto L28;
        Object r15 = this.mStartToStart;
        if (r15 == null) goto L16;
        ConstraintReference r16 = r14.startToStart(r15);
    L14:
        ConstraintReference r17 = r16.margin(this.mMarginStart);
        int r18 = this.mMarginStartGone;
    L15:
        r17.marginGone(r18);
    L27:
        r13 = r14;
        goto L28
    L16:
        Object r19 = this.mStartToEnd;
        if (r19 == null) goto L19;
        r16 = r14.startToEnd(r19);
        goto L14
    L19:
        Object r20 = this.mLeftToLeft;
        if (r20 == null) goto L23;
        ConstraintReference r21 = r14.startToStart(r20);
    L22:
        r17 = r21.margin(this.mMarginLeft);
        r18 = this.mMarginLeftGone;
        goto L15
    L23:
        Object r22 = this.mLeftToRight;
        if (r22 == null) goto L26;
        r21 = r14.startToEnd(r22);
        goto L22
    L26:
        r14.startToStart(State.PARENT);
    L28:
        if (r12 == null) goto L30;
        r12.endToStart(r14.getKey());
        r14.startToEnd(r12.getKey());
    L30:
        r12 = r14;
        goto L8
    L31:
        if (r12 == null) goto L48;
        Object r23 = this.mEndToStart;
        if (r23 == null) goto L37;
        ConstraintReference r24 = r12.endToStart(r23);
    L35:
        ConstraintReference r25 = r24.margin(this.mMarginEnd);
        int r26 = this.mMarginEndGone;
    L36:
        r25.marginGone(r26);
        goto L48
    L37:
        Object r27 = this.mEndToEnd;
        if (r27 == null) goto L40;
        r24 = r12.endToEnd(r27);
        goto L35
    L40:
        Object r28 = this.mRightToLeft;
        if (r28 == null) goto L44;
        ConstraintReference r29 = r12.endToStart(r28);
    L43:
        r25 = r29.margin(this.mMarginRight);
        r26 = this.mMarginRightGone;
        goto L36
    L44:
        Object r30 = this.mRightToRight;
        if (r30 == null) goto L47;
        r29 = r12.endToEnd(r30);
        goto L43
    L47:
        r12.endToEnd(State.PARENT);
    L48:
        if (r13 != null) goto L50;
        return;
    L50:
        float r31 = this.mBias;
        if (r31 == 0.5f) goto L53;
        r13.horizontalBias(r31);
    L53:
        int r32 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$state$State$Chain[this.mStyle.ordinal()];
        if (r32 != 1) goto L56;
        r13.setHorizontalChainStyle(0);
        return;
    L56:
        if (r32 != 2) goto L58;
        r13.setHorizontalChainStyle(1);
        return;
    L58:
        if (r32 != 3) goto L70;
        r13.setHorizontalChainStyle(2);
        return;
    }
}
