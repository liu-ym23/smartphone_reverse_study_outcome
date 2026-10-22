package androidx.constraintlayout.core.widgets.analyzer;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class BaselineDimensionDependency extends DimensionDependency {
    public BaselineDimensionDependency(WidgetRun r1) {
        super(r1);
    }

    public void update(DependencyNode r3) {
        DependencyNode r4 = ((VerticalWidgetRun) ZeusTransformUtils.preCheckCast(this.run, VerticalWidgetRun.class, "com.obric.memorydata.plugin")).baseline;
        r4.margin = this.run.widget.getBaselineDistance();
        this.resolved = true;
    }
}
