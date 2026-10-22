package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.State;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class HorizontalChainReference extends ChainReference {
    private Object mEndToEnd;
    private Object mEndToStart;
    private Object mStartToEnd;
    private Object mStartToStart;

    /* JADX INFO: renamed from: androidx.constraintlayout.solver.state.helpers.HorizontalChainReference$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$state$State$Chain = null;

        static {
            int[] r5 = new int[State.Chain.values().length];
            $SwitchMap$androidx$constraintlayout$solver$state$State$Chain = r5;
            r5[State.Chain.SPREAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Chain[State.Chain.SPREAD_INSIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$androidx$constraintlayout$solver$state$State$Chain[State.Chain.PACKED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public HorizontalChainReference(State r5) {
        super(r5, State.Helper.HORIZONTAL_CHAIN);
    }

    @Override // androidx.constraintlayout.solver.state.HelperReference
    public void apply() {
        Iterator<Object> r5 = this.mReferences.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        this.mState.constraints(r5.next()).clearHorizontal();
        goto L4
    L6:
        Iterator<Object> r10 = this.mReferences.iterator();
        ConstraintReference r11 = null;
        ConstraintReference r12 = null;
    L8:
        if (r10.hasNext() == false) goto L22;
        ConstraintReference r13 = this.mState.constraints(r10.next());
        if (r12 != null) goto L19;
        Object r14 = this.mStartToStart;
        if (r14 == null) goto L14;
        r13.startToStart(r14);
    L18:
        r12 = r13;
        goto L19
    L14:
        Object r15 = this.mStartToEnd;
        if (r15 == null) goto L17;
        r13.startToEnd(r15);
        goto L18
    L17:
        r13.startToStart(State.PARENT);
    L19:
        if (r11 == null) goto L21;
        r11.endToStart(r13.getKey());
        r13.startToEnd(r11.getKey());
    L21:
        r11 = r13;
        goto L8
    L22:
        if (r11 == null) goto L30;
        Object r16 = this.mEndToStart;
        if (r16 == null) goto L26;
        r11.endToStart(r16);
        goto L30
    L26:
        Object r17 = this.mEndToEnd;
        if (r17 == null) goto L29;
        r11.endToEnd(r17);
        goto L30
    L29:
        r11.endToEnd(State.PARENT);
    L30:
        if (r12 == null) goto L34;
        float r18 = this.mBias;
        if (r18 == 0.5f) goto L34;
        r12.horizontalBias(r18);
    L34:
        int r19 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Chain[this.mStyle.ordinal()];
        if (r19 != 1) goto L37;
        r12.setHorizontalChainStyle(0);
        return;
    L37:
        if (r19 != 2) goto L39;
        r12.setHorizontalChainStyle(1);
        return;
    L39:
        if (r19 != 3) goto L51;
        r12.setHorizontalChainStyle(2);
        return;
    }

    public void endToEnd(Object r5) {
        this.mEndToEnd = r5;
    }

    public void endToStart(Object r5) {
        this.mEndToStart = r5;
    }

    public void startToEnd(Object r5) {
        this.mStartToEnd = r5;
    }

    public void startToStart(Object r5) {
        this.mStartToStart = r5;
    }
}
