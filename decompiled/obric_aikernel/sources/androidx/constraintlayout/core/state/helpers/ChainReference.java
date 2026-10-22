package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;

/* JADX INFO: loaded from: classes.dex */
public class ChainReference extends HelperReference {
    protected float mBias;
    protected State.Chain mStyle;

    public ChainReference(State r10, State.Helper r11) {
        super(r10, r11);
        this.mBias = 0.5f;
        this.mStyle = State.Chain.SPREAD;
    }

    @Override // androidx.constraintlayout.core.state.ConstraintReference
    public /* bridge */ /* synthetic */ ConstraintReference bias(float r10) {
        return bias(r10);
    }

    @Override // androidx.constraintlayout.core.state.ConstraintReference
    public ChainReference bias(float r10) {
        this.mBias = r10;
        return this;
    }

    public float getBias() {
        return this.mBias;
    }

    public State.Chain getStyle() {
        return State.Chain.SPREAD;
    }

    public ChainReference style(State.Chain r10) {
        this.mStyle = r10;
        return this;
    }
}
