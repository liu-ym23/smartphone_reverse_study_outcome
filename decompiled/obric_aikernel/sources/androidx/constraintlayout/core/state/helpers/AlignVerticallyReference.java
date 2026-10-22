package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class AlignVerticallyReference extends HelperReference {
    private float mBias;

    public AlignVerticallyReference(State r10) {
        super(r10, State.Helper.ALIGN_VERTICALLY);
        this.mBias = 0.5f;
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        Iterator<Object> r10 = this.mReferences.iterator();
    L4:
        if (r10.hasNext() == false) goto L23;
        Object r11 = r10.next();
        ConstraintReference r12 = this.mState.constraints(r11);
        r12.clearVertical();
        Object r13 = this.mTopToTop;
        if (r13 == null) goto L8;
    L7:
        r12.topToTop(r13);
    L12:
        Object r14 = this.mBottomToTop;
        if (r14 == null) goto L15;
        r12.bottomToTop(r14);
    L20:
        float r15 = this.mBias;
        if (r15 == 0.5f) goto L4;
        r12.verticalBias(r15);
        goto L4
    L15:
        Object r16 = this.mBottomToBottom;
        if (r16 != null) goto L19;
        r16 = State.PARENT;
    L19:
        r12.bottomToBottom(r16);
        goto L20
    L8:
        Object r17 = this.mTopToBottom;
        if (r17 == null) goto L11;
        r12.topToBottom(r17);
        goto L12
    L11:
        r13 = State.PARENT;
        goto L7
    }
}
