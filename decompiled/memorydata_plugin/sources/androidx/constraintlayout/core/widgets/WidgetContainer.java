package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.Cache;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class WidgetContainer extends ConstraintWidget {
    public ArrayList<ConstraintWidget> mChildren;

    public WidgetContainer() {
        this.mChildren = new ArrayList();
    }

    public WidgetContainer(int r1, int r2) {
        super(r1, r2);
        this.mChildren = new ArrayList();
    }

    public WidgetContainer(int r1, int r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        this.mChildren = new ArrayList();
    }

    public void add(ConstraintWidget r4) {
        this.mChildren.add(r4);
        if (r4.getParent() == null) goto L5;
        ((WidgetContainer) ZeusTransformUtils.preCheckCast(r4.getParent(), WidgetContainer.class, "com.obric.memorydata.plugin")).remove(r4);
    L5:
        r4.setParent(this);
    }

    public void add(ConstraintWidget... r4) {
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        add(r4[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public ArrayList<ConstraintWidget> getChildren() {
        return this.mChildren;
    }

    public ConstraintWidgetContainer getRootConstraintContainer() {
        ConstraintWidget r0 = getParent();
        if (ZeusTransformUtils.instanceOf(this, ConstraintWidgetContainer.class) == false) goto L5;
        ConstraintWidgetContainer r4 = (ConstraintWidgetContainer) ZeusTransformUtils.preCheckCast(this, ConstraintWidgetContainer.class, "com.obric.memorydata.plugin");
    L6:
        if (r0 == null) goto L11;
        ConstraintWidget r1 = r0.getParent();
        if (ZeusTransformUtils.instanceOf(r0, ConstraintWidgetContainer.class) == false) goto L10;
        r4 = (ConstraintWidgetContainer) ZeusTransformUtils.preCheckCast(r0, ConstraintWidgetContainer.class, "com.obric.memorydata.plugin");
    L10:
        r0 = r1;
        goto L6
    L11:
        return r4;
    L5:
        r4 = null;
        goto L6
    }

    public void layout() {
        ArrayList<ConstraintWidget> r1 = this.mChildren;
        if (r1 != null) goto L5;
        return;
    L5:
        int r2 = r1.size();
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L11;
        ConstraintWidget r4 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(this.mChildren.get(r3), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, WidgetContainer.class) == false) goto L10;
        ((WidgetContainer) ZeusTransformUtils.preCheckCast(r4, WidgetContainer.class, "com.obric.memorydata.plugin")).layout();
    L10:
        r3 = r3 + 1;
        goto L6
    }

    public void remove(ConstraintWidget r1) {
        this.mChildren.remove(r1);
        r1.reset();
    }

    public void removeAllChildren() {
        this.mChildren.clear();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void reset() {
        this.mChildren.clear();
        super.reset();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void resetSolverVariables(Cache r6) {
        super.resetSolverVariables(r6);
        int r0 = this.mChildren.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((ConstraintWidget) ZeusTransformUtils.preCheckCast(this.mChildren.get(r1), ConstraintWidget.class, "com.obric.memorydata.plugin")).resetSolverVariables(r6);
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void setOffset(int r4, int r5) {
        super.setOffset(r4, r5);
        int r6 = this.mChildren.size();
        int r7 = 0;
    L3:
        if (r7 >= r6) goto L5;
        ((ConstraintWidget) ZeusTransformUtils.preCheckCast(this.mChildren.get(r7), ConstraintWidget.class, "com.obric.memorydata.plugin")).setOffset(getRootX(), getRootY());
        r7 = r7 + 1;
        goto L3
    }
}
