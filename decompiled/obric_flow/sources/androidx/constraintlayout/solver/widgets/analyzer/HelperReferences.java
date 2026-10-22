package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class HelperReferences extends WidgetRun {
    public HelperReferences(ConstraintWidget r5) {
        super(r5);
    }

    private void addDependency(DependencyNode r5) {
        this.start.dependencies.add(r5);
        r5.targets.add(this.start);
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void apply() {
        ConstraintWidget r5 = this.widget;
        if ((r5 instanceof Barrier) == false) goto L69;
        this.start.delegateToWidgetRun = true;
        Barrier r10 = (Barrier) r5;
        int r11 = r10.getBarrierType();
        boolean r12 = r10.allowsGoneWidget();
        int r13 = 0;
        if (r11 == 0) goto L45;
        if (r11 != 1) goto L8;
        DependencyNode r14 = this.start;
        r14.type = DependencyNode.Type.RIGHT;
    L36:
        if (r13 >= r10.mWidgetsCount) goto L44;
        ConstraintWidget r15 = r10.mWidgets[r13];
        if (r12 == false) goto L40;
    L42:
        DependencyNode r16 = r15.horizontalRun.end;
        r16.dependencies.add(this.start);
        this.start.targets.add(r16);
    L43:
        r13 = r13 + 1;
        goto L36
    L40:
        if (r15.getVisibility() != 8) goto L42;
    L44:
        addDependency(this.widget.horizontalRun.start);
        addDependency(this.widget.horizontalRun.end);
        return;
    L8:
        if (r11 != 2) goto L10;
        DependencyNode r17 = this.start;
        r17.type = DependencyNode.Type.TOP;
    L25:
        if (r13 >= r10.mWidgetsCount) goto L33;
        ConstraintWidget r18 = r10.mWidgets[r13];
        if (r12 == false) goto L29;
    L31:
        DependencyNode r19 = r18.verticalRun.start;
        r19.dependencies.add(this.start);
        this.start.targets.add(r19);
    L32:
        r13 = r13 + 1;
        goto L25
    L29:
        if (r18.getVisibility() != 8) goto L31;
    L33:
        addDependency(this.widget.verticalRun.start);
        addDependency(this.widget.verticalRun.end);
        return;
    L10:
        if (r11 != 3) goto L73;
        DependencyNode r20 = this.start;
        r20.type = DependencyNode.Type.BOTTOM;
    L14:
        if (r13 >= r10.mWidgetsCount) goto L22;
        ConstraintWidget r21 = r10.mWidgets[r13];
        if (r12 == false) goto L18;
    L20:
        DependencyNode r22 = r21.verticalRun.end;
        r22.dependencies.add(this.start);
        this.start.targets.add(r22);
    L21:
        r13 = r13 + 1;
        goto L14
    L18:
        if (r21.getVisibility() != 8) goto L20;
    L22:
        addDependency(this.widget.verticalRun.start);
        addDependency(this.widget.verticalRun.end);
        return;
    L73:
        return;
    L45:
        DependencyNode r23 = this.start;
        r23.type = DependencyNode.Type.LEFT;
    L47:
        if (r13 >= r10.mWidgetsCount) goto L55;
        ConstraintWidget r24 = r10.mWidgets[r13];
        if (r12 == false) goto L51;
    L53:
        DependencyNode r25 = r24.horizontalRun.start;
        r25.dependencies.add(this.start);
        this.start.targets.add(r25);
    L54:
        r13 = r13 + 1;
        goto L47
    L51:
        if (r24.getVisibility() != 8) goto L53;
    L55:
        addDependency(this.widget.horizontalRun.start);
        addDependency(this.widget.horizontalRun.end);
        return;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        ConstraintWidget r5 = this.widget;
        if ((r5 instanceof Barrier) == false) goto L12;
        int r10 = ((Barrier) r5).getBarrierType();
        if (r10 != 0) goto L7;
    L10:
        this.widget.setX(this.start.value);
        return;
    L7:
        if (r10 == 1) goto L10;
        this.widget.setY(this.start.value);
        return;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void clear() {
        this.runGroup = null;
        this.start.clear();
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void reset() {
        this.start.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        return false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency r10) {
        Barrier r11 = (Barrier) this.widget;
        int r5 = r11.getBarrierType();
        Iterator<DependencyNode> r12 = this.start.targets.iterator();
        int r13 = 0;
        int r14 = -1;
    L4:
        if (r12.hasNext() == false) goto L11;
        int r15 = r12.next().value;
        if (r14 == (-1)) goto L8;
        if (r15 < r14) goto L8;
    L9:
        if (r13 >= r15) goto L4;
        r13 = r15;
    L8:
        r14 = r15;
        goto L9
    L11:
        if (r5 != 0) goto L13;
    L16:
        this.start.resolve(r11.getMargin() + r14);
        return;
    L13:
        if (r5 == 2) goto L16;
        this.start.resolve(r11.getMargin() + r13);
    }
}
