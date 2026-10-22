package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class AlignHorizontallyReference extends HelperReference {
    private float mBias;
    private Object mEndToEnd;
    private Object mEndToStart;
    private Object mStartToEnd;
    private Object mStartToStart;

    public AlignHorizontallyReference(State r5) {
        super(r5, State.Helper.ALIGN_VERTICALLY);
        this.mBias = 0.5f;
    }

    @Override // androidx.constraintlayout.solver.state.HelperReference
    public void apply() {
        Iterator<Object> r5 = this.mReferences.iterator();
    L4:
        if (r5.hasNext() == false) goto L22;
        Object r10 = r5.next();
        ConstraintReference r11 = this.mState.constraints(r10);
        r11.clearHorizontal();
        Object r12 = this.mStartToStart;
        if (r12 == null) goto L8;
        r11.startToStart(r12);
    L12:
        Object r13 = this.mEndToStart;
        if (r13 == null) goto L15;
        r11.endToStart(r13);
    L19:
        float r14 = this.mBias;
        if (r14 == 0.5f) goto L4;
        r11.horizontalBias(r14);
        goto L4
    L15:
        Object r15 = this.mEndToEnd;
        if (r15 == null) goto L18;
        r11.endToEnd(r15);
        goto L19
    L18:
        r11.endToEnd(State.PARENT);
        goto L19
    L8:
        Object r16 = this.mStartToEnd;
        if (r16 == null) goto L11;
        r11.startToEnd(r16);
        goto L12
    L11:
        r11.startToStart(State.PARENT);
        goto L12
    }

    public void bias(float r5) {
        this.mBias = r5;
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
