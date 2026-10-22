package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class AlignHorizontallyReference extends HelperReference {
    private float mBias;

    public AlignHorizontallyReference(State r2) {
        super(r2, State.Helper.ALIGN_VERTICALLY);
        this.mBias = 0.5f;
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        Iterator<Object> r0 = this.mReferences.iterator();
    L4:
        if (r0.hasNext() == false) goto L24;
        Object r1 = r0.next();
        ConstraintReference r2 = this.mState.constraints(r1);
        r2.clearHorizontal();
        if (this.mStartToStart == null) goto L10;
        Object r3 = this.mStartToStart;
    L8:
        r2.startToStart(r3);
    L14:
        if (this.mEndToStart == null) goto L17;
        r2.endToStart(this.mEndToStart);
    L21:
        float r4 = this.mBias;
        if (r4 == 0.5f) goto L4;
        r2.horizontalBias(r4);
        goto L4
    L17:
        if (this.mEndToEnd == null) goto L19;
        Object r5 = this.mEndToEnd;
    L20:
        r2.endToEnd(r5);
        goto L21
    L19:
        r5 = State.PARENT;
        goto L20
    L10:
        if (this.mStartToEnd == null) goto L12;
        r2.startToEnd(this.mStartToEnd);
        goto L14
    L12:
        r3 = State.PARENT;
        goto L8
    }
}
