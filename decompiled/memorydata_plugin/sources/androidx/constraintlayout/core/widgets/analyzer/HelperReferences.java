package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class HelperReferences extends WidgetRun {
    public HelperReferences(ConstraintWidget r1) {
        super(r1);
    }

    private void addDependency(DependencyNode r2) {
        this.start.dependencies.add(r2);
        r2.targets.add(this.start);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void apply() {
        if (ZeusTransformUtils.instanceOf(this.widget, Barrier.class) == false) goto L68;
        this.start.delegateToWidgetRun = true;
        Barrier r0 = (Barrier) ZeusTransformUtils.preCheckCast(this.widget, Barrier.class, "com.obric.memorydata.plugin");
        int r2 = r0.getBarrierType();
        boolean r3 = r0.getAllowsGoneWidget();
        int r5 = 0;
        if (r2 == 0) goto L43;
        if (r2 != 1) goto L8;
        DependencyNode r1 = this.start;
        r1.type = DependencyNode.Type.RIGHT;
    L35:
        if (r5 >= r0.mWidgetsCount) goto L53;
        ConstraintWidget r4 = r0.mWidgets[r5];
        if (r3 == false) goto L39;
    L41:
        DependencyNode r6 = r4.horizontalRun.end;
        r6.dependencies.add(this.start);
        this.start.targets.add(r6);
    L42:
        r5 = r5 + 1;
        goto L35
    L39:
        if (r4.getVisibility() != 8) goto L41;
    L53:
        addDependency(this.widget.horizontalRun.start);
        DependencyNode r7 = this.widget.horizontalRun.end;
    L54:
        addDependency(r7);
        return;
    L8:
        if (r2 != 2) goto L10;
        DependencyNode r8 = this.start;
        r8.type = DependencyNode.Type.TOP;
    L24:
        if (r5 >= r0.mWidgetsCount) goto L32;
        ConstraintWidget r9 = r0.mWidgets[r5];
        if (r3 == false) goto L28;
    L30:
        DependencyNode r10 = r9.verticalRun.start;
        r10.dependencies.add(this.start);
        this.start.targets.add(r10);
    L31:
        r5 = r5 + 1;
        goto L24
    L28:
        if (r9.getVisibility() != 8) goto L30;
    L32:
        addDependency(this.widget.verticalRun.start);
        r7 = this.widget.verticalRun.end;
        goto L54
    L10:
        if (r2 != 3) goto L69;
        DependencyNode r11 = this.start;
        r11.type = DependencyNode.Type.BOTTOM;
    L14:
        if (r5 >= r0.mWidgetsCount) goto L32;
        ConstraintWidget r12 = r0.mWidgets[r5];
        if (r3 == false) goto L18;
    L20:
        DependencyNode r13 = r12.verticalRun.end;
        r13.dependencies.add(this.start);
        this.start.targets.add(r13);
    L21:
        r5 = r5 + 1;
        goto L14
    L18:
        if (r12.getVisibility() != 8) goto L20;
    L69:
        return;
    L43:
        DependencyNode r14 = this.start;
        r14.type = DependencyNode.Type.LEFT;
    L45:
        if (r5 >= r0.mWidgetsCount) goto L53;
        ConstraintWidget r15 = r0.mWidgets[r5];
        if (r3 == false) goto L49;
    L51:
        DependencyNode r16 = r15.horizontalRun.start;
        r16.dependencies.add(this.start);
        this.start.targets.add(r16);
    L52:
        r5 = r5 + 1;
        goto L45
    L49:
        if (r15.getVisibility() != 8) goto L51;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        if (ZeusTransformUtils.instanceOf(this.widget, Barrier.class) == false) goto L12;
        int r0 = ((Barrier) ZeusTransformUtils.preCheckCast(this.widget, Barrier.class, "com.obric.memorydata.plugin")).getBarrierType();
        if (r0 != 0) goto L7;
    L10:
        this.widget.setX(this.start.value);
        return;
    L7:
        if (r0 == 1) goto L10;
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
    public void update(Dependency r9) {
        Dependency r10 = (Dependency) ZeusTransformUtils.wrapperContextForParams(r9, Dependency.class, "com.obric.memorydata.plugin");
        Barrier r11 = (Barrier) ZeusTransformUtils.preCheckCast(this.widget, Barrier.class, "com.obric.memorydata.plugin");
        int r0 = r11.getBarrierType();
        Iterator<DependencyNode> r2 = this.start.targets.iterator();
        int r4 = 0;
        int r5 = -1;
    L4:
        if (r2.hasNext() == false) goto L11;
        int r6 = ((DependencyNode) ZeusTransformUtils.preCheckCast(r2.next(), DependencyNode.class, "com.obric.memorydata.plugin")).value;
        if (r5 == (-1)) goto L8;
        if (r6 < r5) goto L8;
    L9:
        if (r4 >= r6) goto L4;
        r4 = r6;
    L8:
        r5 = r6;
        goto L9
    L11:
        if (r0 != 0) goto L13;
    L16:
        this.start.resolve(r5 + r11.getMargin());
        return;
    L13:
        if (r0 == 2) goto L16;
        this.start.resolve(r4 + r11.getMargin());
    }
}
