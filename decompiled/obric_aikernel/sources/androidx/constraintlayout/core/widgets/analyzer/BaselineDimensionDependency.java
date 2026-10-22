package androidx.constraintlayout.core.widgets.analyzer;

/* JADX INFO: loaded from: classes.dex */
class BaselineDimensionDependency extends DimensionDependency {
    public BaselineDimensionDependency(WidgetRun r10) {
        super(r10);
    }

    public void update(DependencyNode r10) {
        WidgetRun r11 = this.run;
        DependencyNode r12 = ((VerticalWidgetRun) r11).baseline;
        r12.margin = r11.widget.getBaselineDistance();
        this.resolved = true;
    }
}
