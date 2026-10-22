package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class GuidelineReference extends WidgetRun {
    public GuidelineReference(ConstraintWidget r3) {
        super(r3);
        r3.horizontalRun.clear();
        r3.verticalRun.clear();
        this.orientation = ((Guideline) ZeusTransformUtils.preCheckCast(r3, Guideline.class, "com.obric.memorydata.plugin")).getOrientation();
    }

    private void addDependency(DependencyNode r2) {
        this.start.dependencies.add(r2);
        r2.targets.add(this.start);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void apply() {
        Guideline r0 = (Guideline) ZeusTransformUtils.preCheckCast(this.widget, Guideline.class, "com.obric.memorydata.plugin");
        int r1 = r0.getRelativeBegin();
        int r2 = r0.getRelativeEnd();
        r0.getRelativePercent();
        if (r0.getOrientation() != 1) goto L12;
        DependencyNode r3 = this.start;
        if (r1 == (-1)) goto L8;
        r3.targets.add(this.widget.mParent.horizontalRun.start);
        this.widget.mParent.horizontalRun.start.dependencies.add(this.start);
        DependencyNode r4 = this.start;
    L7:
        r4.margin = r1;
    L11:
        addDependency(this.widget.horizontalRun.start);
        DependencyNode r5 = this.widget.horizontalRun.end;
    L20:
        addDependency(r5);
        return;
    L8:
        if (r2 == (-1)) goto L10;
        r3.targets.add(this.widget.mParent.horizontalRun.end);
        this.widget.mParent.horizontalRun.end.dependencies.add(this.start);
        r4 = this.start;
        r1 = -r2;
        goto L7
    L10:
        r3.delegateToWidgetRun = true;
        this.start.targets.add(this.widget.mParent.horizontalRun.end);
        this.widget.mParent.horizontalRun.end.dependencies.add(this.start);
        goto L11
    L12:
        DependencyNode r6 = this.start;
        if (r1 == (-1)) goto L16;
        r6.targets.add(this.widget.mParent.verticalRun.start);
        this.widget.mParent.verticalRun.start.dependencies.add(this.start);
        DependencyNode r7 = this.start;
    L15:
        r7.margin = r1;
    L19:
        addDependency(this.widget.verticalRun.start);
        r5 = this.widget.verticalRun.end;
        goto L20
    L16:
        if (r2 == (-1)) goto L18;
        r6.targets.add(this.widget.mParent.verticalRun.end);
        this.widget.mParent.verticalRun.end.dependencies.add(this.start);
        r7 = this.start;
        r1 = -r2;
        goto L15
    L18:
        r6.delegateToWidgetRun = true;
        this.start.targets.add(this.widget.mParent.verticalRun.end);
        this.widget.mParent.verticalRun.end.dependencies.add(this.start);
        goto L19
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        if (((Guideline) ZeusTransformUtils.preCheckCast(this.widget, Guideline.class, "com.obric.memorydata.plugin")).getOrientation() != 1) goto L5;
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
    public void update(Dependency r4) {
        Dependency r5 = (Dependency) ZeusTransformUtils.wrapperContextForParams(r4, Dependency.class, "com.obric.memorydata.plugin");
        if (this.start.readyToSolve == true) goto L6;
        return;
    L6:
        if (this.start.resolved == false) goto L8;
        return;
    L8:
        this.start.resolve((int) ((((DependencyNode) ZeusTransformUtils.preCheckCast(this.start.targets.get(0), DependencyNode.class, "com.obric.memorydata.plugin")).value * ((Guideline) ZeusTransformUtils.preCheckCast(this.widget, Guideline.class, "com.obric.memorydata.plugin")).getRelativePercent()) + 0.5f));
    }
}
