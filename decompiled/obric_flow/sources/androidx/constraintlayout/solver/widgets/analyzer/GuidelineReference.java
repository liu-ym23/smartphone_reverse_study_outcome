package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Guideline;

/* JADX INFO: loaded from: classes.dex */
class GuidelineReference extends WidgetRun {
    public GuidelineReference(ConstraintWidget r5) {
        super(r5);
        r5.horizontalRun.clear();
        r5.verticalRun.clear();
        this.orientation = ((Guideline) r5).getOrientation();
    }

    private void addDependency(DependencyNode r5) {
        this.start.dependencies.add(r5);
        r5.targets.add(this.start);
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void apply() {
        Guideline r5 = (Guideline) this.widget;
        int r10 = r5.getRelativeBegin();
        int r11 = r5.getRelativeEnd();
        r5.getRelativePercent();
        if (r5.getOrientation() != 1) goto L10;
        if (r10 == (-1)) goto L6;
        this.start.targets.add(this.widget.mParent.horizontalRun.start);
        this.widget.mParent.horizontalRun.start.dependencies.add(this.start);
        this.start.margin = r10;
    L9:
        addDependency(this.widget.horizontalRun.start);
        addDependency(this.widget.horizontalRun.end);
        return;
    L6:
        if (r11 == (-1)) goto L8;
        this.start.targets.add(this.widget.mParent.horizontalRun.end);
        this.widget.mParent.horizontalRun.end.dependencies.add(this.start);
        int r12 = -r11;
        this.start.margin = r12;
        goto L9
    L8:
        DependencyNode r13 = this.start;
        r13.delegateToWidgetRun = true;
        r13.targets.add(this.widget.mParent.horizontalRun.end);
        this.widget.mParent.horizontalRun.end.dependencies.add(this.start);
        goto L9
    L10:
        if (r10 == (-1)) goto L12;
        this.start.targets.add(this.widget.mParent.verticalRun.start);
        this.widget.mParent.verticalRun.start.dependencies.add(this.start);
        this.start.margin = r10;
    L15:
        addDependency(this.widget.verticalRun.start);
        addDependency(this.widget.verticalRun.end);
        return;
    L12:
        if (r11 == (-1)) goto L14;
        this.start.targets.add(this.widget.mParent.verticalRun.end);
        this.widget.mParent.verticalRun.end.dependencies.add(this.start);
        int r14 = -r11;
        this.start.margin = r14;
        goto L15
    L14:
        DependencyNode r15 = this.start;
        r15.delegateToWidgetRun = true;
        r15.targets.add(this.widget.mParent.verticalRun.end);
        this.widget.mParent.verticalRun.end.dependencies.add(this.start);
        goto L15
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        if (((Guideline) this.widget).getOrientation() != 1) goto L5;
        this.widget.setX(this.start.value);
        return;
    L5:
        this.widget.setY(this.start.value);
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void clear() {
        this.start.clear();
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        return false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency r5) {
        DependencyNode r10 = this.start;
        if (r10.readyToSolve == true) goto L6;
        return;
    L6:
        if (r10.resolved == false) goto L8;
        return;
    L8:
        DependencyNode r11 = r10.targets.get(0);
        Guideline r12 = (Guideline) this.widget;
        this.start.resolve((int) ((r12.getRelativePercent() * r11.value) + 0.5f));
    }
}
