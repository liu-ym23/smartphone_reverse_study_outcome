package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;

/* JADX INFO: loaded from: classes.dex */
class GuidelineReference extends WidgetRun {
    public GuidelineReference(ConstraintWidget r10) {
        super(r10);
        r10.horizontalRun.clear();
        r10.verticalRun.clear();
        this.orientation = ((Guideline) r10).getOrientation();
    }

    private void addDependency(DependencyNode r10) {
        this.start.dependencies.add(r10);
        r10.targets.add(this.start);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void apply() {
        Guideline r10 = (Guideline) this.widget;
        int r11 = r10.getRelativeBegin();
        int r12 = r10.getRelativeEnd();
        r10.getRelativePercent();
        if (r10.getOrientation() != 1) goto L12;
        DependencyNode r13 = this.start;
        if (r11 == (-1)) goto L8;
        r13.targets.add(this.widget.mParent.horizontalRun.start);
        this.widget.mParent.horizontalRun.start.dependencies.add(this.start);
        DependencyNode r14 = this.start;
    L7:
        r14.margin = r11;
    L11:
        addDependency(this.widget.horizontalRun.start);
        WidgetRun r15 = this.widget.horizontalRun;
    L20:
        addDependency(r15.end);
        return;
    L8:
        if (r12 == (-1)) goto L10;
        r13.targets.add(this.widget.mParent.horizontalRun.end);
        this.widget.mParent.horizontalRun.end.dependencies.add(this.start);
        r14 = this.start;
        r11 = -r12;
        goto L7
    L10:
        r13.delegateToWidgetRun = true;
        r13.targets.add(this.widget.mParent.horizontalRun.end);
        this.widget.mParent.horizontalRun.end.dependencies.add(this.start);
        goto L11
    L12:
        DependencyNode r16 = this.start;
        if (r11 == (-1)) goto L16;
        r16.targets.add(this.widget.mParent.verticalRun.start);
        this.widget.mParent.verticalRun.start.dependencies.add(this.start);
        DependencyNode r17 = this.start;
    L15:
        r17.margin = r11;
    L19:
        addDependency(this.widget.verticalRun.start);
        r15 = this.widget.verticalRun;
        goto L20
    L16:
        if (r12 == (-1)) goto L18;
        r16.targets.add(this.widget.mParent.verticalRun.end);
        this.widget.mParent.verticalRun.end.dependencies.add(this.start);
        r17 = this.start;
        r11 = -r12;
        goto L15
    L18:
        r16.delegateToWidgetRun = true;
        r16.targets.add(this.widget.mParent.verticalRun.end);
        this.widget.mParent.verticalRun.end.dependencies.add(this.start);
        goto L19
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        if (((Guideline) this.widget).getOrientation() != 1) goto L5;
        this.widget.setX(this.start.value);
        return;
    L5:
        this.widget.setY(this.start.value);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void clear() {
        this.start.clear();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean supportsWrapComputation() {
        return false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r10) {
        DependencyNode r11 = this.start;
        if (r11.readyToSolve == true) goto L6;
        return;
    L6:
        if (r11.resolved == false) goto L8;
        return;
    L8:
        this.start.resolve((int) ((r11.targets.get(0).value * ((Guideline) this.widget).getRelativePercent()) + 0.5f));
    }
}
