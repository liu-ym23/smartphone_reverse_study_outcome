package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.widgets.HelperWidget;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class HelperReference {
    private HelperWidget mHelperWidget;
    protected ArrayList<Object> mReferences;
    protected final State mState;
    final State.Helper mType;

    public HelperReference(State r5, State.Helper r10) {
        this.mReferences = new ArrayList();
        this.mState = r5;
        this.mType = r10;
    }

    public HelperReference add(Object... r5) {
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        Object r12 = r5[r11];
        this.mReferences.add(r12);
        r11 = r11 + 1;
        goto L3
    L5:
        return this;
    }

    public void apply() {
    }

    public HelperWidget getHelperWidget() {
        return this.mHelperWidget;
    }

    public State.Helper getType() {
        return this.mType;
    }

    public void setHelperWidget(HelperWidget r5) {
        this.mHelperWidget = r5;
    }
}
