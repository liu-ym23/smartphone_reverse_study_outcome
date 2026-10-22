package androidx.constraintlayout.solver.widgets.analyzer;

/* JADX INFO: loaded from: classes.dex */
class BaselineDimensionDependency extends DimensionDependency {
    public BaselineDimensionDependency(WidgetRun r5) {
        super(r5);
    }

    public void update(DependencyNode r5) {
        WidgetRun r10 = this.run;
        DependencyNode r11 = ((VerticalWidgetRun) r10).baseline;
        r11.margin = r10.widget.getBaselineDistance();
        this.resolved = true;
    }
}
