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

    public VerticalChainReference(State r2) {
        super(r2, State.Helper.VERTICAL_CHAIN);
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        Iterator<Object> r0 = this.mReferences.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        this.mState.constraints(r0.next()).clearVertical();
        goto L4
    L6:
        Iterator<Object> r1 = this.mReferences.iterator();
        ConstraintReference r2 = null;
        ConstraintReference r3 = null;
    L8:
        if (r1.hasNext() == false) goto L23;
        ConstraintReference r4 = this.mState.constraints(r1.next());
        if (r3 == null) goto L12;
    L20:
        if (r2 == null) goto L22;
        r2.bottomToTop(r4.getKey());
        r4.topToBottom(r2.getKey());
    L22:
        r2 = r4;
        goto L8
    L12:
        if (this.mTopToTop == null) goto L16;
        ConstraintReference r5 = r4.topToTop(this.mTopToTop);
    L14:
        r5.margin(this.mMarginTop).marginGone(this.mMarginTopGone);
    L19:
        r3 = r4;
        goto L20
    L16:
        if (this.mTopToBottom == null) goto L18;
        r5 = r4.topToBottom(this.mTopToBottom);
        goto L14
    L18:
        r4.topToTop(State.PARENT);
        goto L19
    L23:
        if (r2 != null) goto L25;
    L32:
        if (r3 != null) goto L35;
        return;
    L35:
        if (this.mBias == 0.5f) goto L37;
        r3.verticalBias(this.mBias);
    L37:
        int r6 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$state$State$Chain[this.mStyle.ordinal()];
        if (r6 != 1) goto L40;
        r3.setVerticalChainStyle(0);
        return;
    L40:
        if (r6 != 2) goto L42;
        r3.setVerticalChainStyle(1);
        return;
    L42:
        if (r6 != 3) goto L54;
        r3.setVerticalChainStyle(2);
        return;
    L54:
        return;
    L25:
        if (this.mBottomToTop == null) goto L29;
        ConstraintReference r7 = r2.bottomToTop(this.mBottomToTop);
    L27:
        r7.margin(this.mMarginBottom).marginGone(this.mMarginBottomGone);
        goto L32
    L29:
        if (this.mBottomToBottom == null) goto L31;
        r7 = r2.bottomToBottom(this.mBottomToBottom);
        goto L27
    L31:
        r2.bottomToBottom(State.PARENT);
        goto L32
    }
}
