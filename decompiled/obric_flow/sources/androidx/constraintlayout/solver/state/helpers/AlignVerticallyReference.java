package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class AlignVerticallyReference extends HelperReference {
    private float mBias;
    private Object mBottomToBottom;
    private Object mBottomToTop;
    private Object mTopToBottom;
    private Object mTopToTop;

    public AlignVerticallyReference(State r5) {
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
        r11.clearVertical();
        Object r12 = this.mTopToTop;
        if (r12 == null) goto L8;
        r11.topToTop(r12);
    L12:
        Object r13 = this.mBottomToTop;
        if (r13 == null) goto L15;
        r11.bottomToTop(r13);
    L19:
        float r14 = this.mBias;
        if (r14 == 0.5f) goto L4;
        r11.verticalBias(r14);
        goto L4
    L15:
        Object r15 = this.mBottomToBottom;
        if (r15 == null) goto L18;
        r11.bottomToBottom(r15);
        goto L19
    L18:
        r11.bottomToBottom(State.PARENT);
        goto L19
    L8:
        Object r16 = this.mTopToBottom;
        if (r16 == null) goto L11;
        r11.topToBottom(r16);
        goto L12
    L11:
        r11.topToTop(State.PARENT);
        goto L12
    }

    public void bias(float r5) {
        this.mBias = r5;
    }

    public void bottomToBottom(Object r5) {
        this.mBottomToBottom = r5;
    }

    public void bottomToTop(Object r5) {
        this.mBottomToTop = r5;
    }

    public void topToBottom(Object r5) {
        this.mTopToBottom = r5;
    }

    public void topToTop(Object r5) {
        this.mTopToTop = r5;
    }
}
