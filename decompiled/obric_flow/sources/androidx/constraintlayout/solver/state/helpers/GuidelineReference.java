package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.Reference;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Guideline;

/* JADX INFO: loaded from: classes.dex */
public class GuidelineReference implements Reference {
    private Object key;
    private int mEnd;
    private Guideline mGuidelineWidget;
    private int mOrientation;
    private float mPercent;
    private int mStart;
    final State mState;

    public GuidelineReference(State r5) {
        this.mStart = -1;
        this.mEnd = -1;
        this.mPercent = 0.0f;
        this.mState = r5;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void apply() {
        this.mGuidelineWidget.setOrientation(this.mOrientation);
        int r5 = this.mStart;
        if (r5 == (-1)) goto L5;
        this.mGuidelineWidget.setGuideBegin(r5);
        return;
    L5:
        int r10 = this.mEnd;
        if (r10 == (-1)) goto L8;
        this.mGuidelineWidget.setGuideEnd(r10);
        return;
    L8:
        this.mGuidelineWidget.setGuidePercent(this.mPercent);
    }

    public void end(Object r5) {
        this.mStart = -1;
        this.mEnd = this.mState.convertDimension(r5);
        this.mPercent = 0.0f;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public ConstraintWidget getConstraintWidget() {
        if (this.mGuidelineWidget != null) goto L6;
        this.mGuidelineWidget = new Guideline();
    L6:
        return this.mGuidelineWidget;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public Object getKey() {
        return this.key;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void percent(float r5) {
        this.mStart = -1;
        this.mEnd = -1;
        this.mPercent = r5;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void setConstraintWidget(ConstraintWidget r5) {
        if ((r5 instanceof Guideline) == false) goto L5;
        this.mGuidelineWidget = (Guideline) r5;
        return;
    L5:
        this.mGuidelineWidget = null;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void setKey(Object r5) {
        this.key = r5;
    }

    public void setOrientation(int r5) {
        this.mOrientation = r5;
    }

    public void start(Object r5) {
        this.mStart = this.mState.convertDimension(r5);
        this.mEnd = -1;
        this.mPercent = 0.0f;
    }
}
