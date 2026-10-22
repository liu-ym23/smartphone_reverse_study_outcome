package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.State;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class VerticalChainReference extends ChainReference {

    /* JADX INFO: renamed from: androidx.constraintlayout.core.state.helpers.VerticalChainReference$1, reason: invalid class name */
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

    public VerticalChainReference(State r10) {
        super(r10, State.Helper.VERTICAL_CHAIN);
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        Iterator<Object> r10 = this.mReferences.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        this.mState.constraints(r10.next()).clearVertical();
        goto L4
    L6:
        Iterator<Object> r11 = this.mReferences.iterator();
        ConstraintReference r12 = null;
        ConstraintReference r13 = null;
    L8:
        if (r11.hasNext() == false) goto L23;
        ConstraintReference r14 = this.mState.constraints(r11.next());
        if (r13 != null) goto L20;
        Object r15 = this.mTopToTop;
        if (r15 == null) goto L15;
        ConstraintReference r16 = r14.topToTop(r15);
    L14:
        r16.margin(this.mMarginTop).marginGone(this.mMarginTopGone);
    L19:
        r13 = r14;
        goto L20
    L15:
        Object r17 = this.mTopToBottom;
        if (r17 == null) goto L18;
        r16 = r14.topToBottom(r17);
        goto L14
    L18:
        r14.topToTop(State.PARENT);
    L20:
        if (r12 == null) goto L22;
        r12.bottomToTop(r14.getKey());
        r14.topToBottom(r12.getKey());
    L22:
        r12 = r14;
        goto L8
    L23:
        if (r12 == null) goto L32;
        Object r18 = this.mBottomToTop;
        if (r18 == null) goto L28;
        ConstraintReference r19 = r12.bottomToTop(r18);
    L27:
        r19.margin(this.mMarginBottom).marginGone(this.mMarginBottomGone);
        goto L32
    L28:
        Object r20 = this.mBottomToBottom;
        if (r20 == null) goto L31;
        r19 = r12.bottomToBottom(r20);
        goto L27
    L31:
        r12.bottomToBottom(State.PARENT);
    L32:
        if (r13 != null) goto L34;
        return;
    L34:
        float r21 = this.mBias;
        if (r21 == 0.5f) goto L37;
        r13.verticalBias(r21);
    L37:
        int r22 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$state$State$Chain[this.mStyle.ordinal()];
        if (r22 != 1) goto L40;
        r13.setVerticalChainStyle(0);
        return;
    L40:
        if (r22 != 2) goto L42;
        r13.setVerticalChainStyle(1);
        return;
    L42:
        if (r22 != 3) goto L54;
        r13.setVerticalChainStyle(2);
        return;
    }
}
