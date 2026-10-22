package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.Reference;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;

/* JADX INFO: loaded from: classes.dex */
public class GuidelineReference implements Facade, Reference {
    private Object key;
    private int mEnd;
    private Guideline mGuidelineWidget;
    private int mOrientation;
    private float mPercent;
    private int mStart;
    final State mState;

    public GuidelineReference(State r10) {
        this.mStart = -1;
        this.mEnd = -1;
        this.mPercent = 0.0f;
        this.mState = r10;
    }

    @Override // androidx.constraintlayout.core.state.helpers.Facade, androidx.constraintlayout.core.state.Reference
    public void apply() {
        this.mGuidelineWidget.setOrientation(this.mOrientation);
        int r10 = this.mStart;
        if (r10 == (-1)) goto L5;
        this.mGuidelineWidget.setGuideBegin(r10);
        return;
    L5:
        int r11 = this.mEnd;
        if (r11 == (-1)) goto L8;
        this.mGuidelineWidget.setGuideEnd(r11);
        return;
    L8:
        this.mGuidelineWidget.setGuidePercent(this.mPercent);
    }

    public GuidelineReference end(Object r10) {
        this.mStart = -1;
        this.mEnd = this.mState.convertDimension(r10);
        this.mPercent = 0.0f;
        return this;
    }

    @Override // androidx.constraintlayout.core.state.helpers.Facade, androidx.constraintlayout.core.state.Reference
    public ConstraintWidget getConstraintWidget() {
        if (this.mGuidelineWidget != null) goto L6;
        this.mGuidelineWidget = new Guideline();
    L6:
        return this.mGuidelineWidget;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public Facade getFacade() {
        return null;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public Object getKey() {
        return this.key;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public GuidelineReference percent(float r10) {
        this.mStart = -1;
        this.mEnd = -1;
        this.mPercent = r10;
        return this;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public void setConstraintWidget(ConstraintWidget r10) {
        if ((r10 instanceof Guideline) == false) goto L5;
        Guideline r11 = (Guideline) r10;
    L6:
        this.mGuidelineWidget = r11;
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public void setKey(Object r10) {
        this.key = r10;
    }

    public void setOrientation(int r10) {
        this.mOrientation = r10;
    }

    public GuidelineReference start(Object r10) {
        this.mStart = this.mState.convertDimension(r10);
        this.mEnd = -1;
        this.mPercent = 0.0f;
        return this;
    }
}
