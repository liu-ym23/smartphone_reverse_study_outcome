package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class HelperReferences extends WidgetRun {
    public HelperReferences(ConstraintWidget r10) {
        super(r10);
    }

    private void addDependency(DependencyNode r10) {
        this.start.dependencies.add(r10);
        r10.targets.add(this.start);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void apply() {
        ConstraintWidget r10 = this.widget;
        if ((r10 instanceof Barrier) == false) goto L68;
        this.start.delegateToWidgetRun = true;
        Barrier r11 = (Barrier) r10;
        int r12 = r11.getBarrierType();
        boolean r13 = r11.getAllowsGoneWidget();
        int r14 = 0;
        if (r12 == 0) goto L43;
        if (r12 != 1) goto L8;
        DependencyNode r15 = this.start;
        r15.type = DependencyNode.Type.RIGHT;
    L35:
        if (r14 >= r11.mWidgetsCount) goto L53;
        ConstraintWidget r16 = r11.mWidgets[r14];
        if (r13 == false) goto L39;
    L41:
        DependencyNode r17 = r16.horizontalRun.end;
        r17.dependencies.add(this.start);
        this.start.targets.add(r17);
    L42:
        r14 = r14 + 1;
        goto L35
    L39:
        if (r16.getVisibility() != 8) goto L41;
    L53:
        addDependency(this.widget.horizontalRun.start);
        WidgetRun r18 = this.widget.horizontalRun;
    L54:
        addDependency(r18.end);
        return;
    L8:
        if (r12 != 2) goto L10;
        DependencyNode r19 = this.start;
        r19.type = DependencyNode.Type.TOP;
    L24:
        if (r14 >= r11.mWidgetsCount) goto L32;
        ConstraintWidget r20 = r11.mWidgets[r14];
        if (r13 == false) goto L28;
    L30:
        DependencyNode r21 = r20.verticalRun.start;
        r21.dependencies.add(this.start);
        this.start.targets.add(r21);
    L31:
        r14 = r14 + 1;
        goto L24
    L28:
        if (r20.getVisibility() != 8) goto L30;
    L32:
        addDependency(this.widget.verticalRun.start);
        r18 = this.widget.verticalRun;
        goto L54
    L10:
        if (r12 != 3) goto L69;
        DependencyNode r22 = this.start;
        r22.type = DependencyNode.Type.BOTTOM;
    L14:
        if (r14 >= r11.mWidgetsCount) goto L32;
        ConstraintWidget r23 = r11.mWidgets[r14];
        if (r13 == false) goto L18;
    L20:
        DependencyNode r24 = r23.verticalRun.end;
        r24.dependencies.add(this.start);
        this.start.targets.add(r24);
    L21:
        r14 = r14 + 1;
        goto L14
    L18:
        if (r23.getVisibility() != 8) goto L20;
    L69:
        return;
    L43:
        DependencyNode r25 = this.start;
        r25.type = DependencyNode.Type.LEFT;
    L45:
        if (r14 >= r11.mWidgetsCount) goto L53;
        ConstraintWidget r26 = r11.mWidgets[r14];
        if (r13 == false) goto L49;
    L51:
        DependencyNode r27 = r26.horizontalRun.start;
        r27.dependencies.add(this.start);
        this.start.targets.add(r27);
    L52:
        r14 = r14 + 1;
        goto L45
    L49:
        if (r26.getVisibility() != 8) goto L51;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        ConstraintWidget r10 = this.widget;
        if ((r10 instanceof Barrier) == false) goto L12;
        int r11 = ((Barrier) r10).getBarrierType();
        if (r11 != 0) goto L7;
    L10:
        this.widget.setX(this.start.value);
        return;
    L7:
        if (r11 == 1) goto L10;
        this.widget.setY(this.start.value);
        return;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void clear() {
        this.runGroup = null;
        this.start.clear();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void reset() {
        this.start.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean supportsWrapComputation() {
        return false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r10) {
        Barrier r11 = (Barrier) this.widget;
        int r12 = r11.getBarrierType();
        Iterator<DependencyNode> r13 = this.start.targets.iterator();
        int r14 = 0;
        int r15 = -1;
    L4:
        if (r13.hasNext() == false) goto L11;
        int r16 = r13.next().value;
        if (r15 == (-1)) goto L8;
        if (r16 < r15) goto L8;
    L9:
        if (r14 >= r16) goto L4;
        r14 = r16;
    L8:
        r15 = r16;
        goto L9
    L11:
        if (r12 != 0) goto L13;
    L16:
        this.start.resolve(r15 + r11.getMargin());
        return;
    L13:
        if (r12 == 2) goto L16;
        this.start.resolve(r14 + r11.getMargin());
    }
}
