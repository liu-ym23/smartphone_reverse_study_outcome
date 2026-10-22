package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.analyzer.Grouping;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class HelperWidget extends ConstraintWidget implements Helper {
    public ConstraintWidget[] mWidgets;
    public int mWidgetsCount;

    public HelperWidget() {
        this.mWidgets = new ConstraintWidget[4];
        this.mWidgetsCount = 0;
    }

    @Override // androidx.constraintlayout.solver.widgets.Helper
    public void add(ConstraintWidget r5) {
        if (r5 == this) goto L10;
        if (r5 == null) goto L11;
        int r10 = this.mWidgetsCount + 1;
        ConstraintWidget[] r11 = this.mWidgets;
        if (r10 <= r11.length) goto L8;
        this.mWidgets = (ConstraintWidget[]) Arrays.copyOf(r11, r11.length * 2);
    L8:
        ConstraintWidget[] r12 = this.mWidgets;
        int r13 = this.mWidgetsCount;
        r12[r13] = r5;
        this.mWidgetsCount = r13 + 1;
        return;
    L11:
        return;
    }

    public void addDependents(ArrayList<WidgetGroup> r5, int r10, WidgetGroup r11) {
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r13 >= this.mWidgetsCount) goto L7;
        r11.add(this.mWidgets[r13]);
        r13 = r13 + 1;
    L7:
        if (r12 >= this.mWidgetsCount) goto L9;
        Grouping.findDependents(this.mWidgets[r12], r10, r5, r11);
        r12 = r12 + 1;
        goto L7
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void copy(ConstraintWidget r5, HashMap<ConstraintWidget, ConstraintWidget> r10) {
        super.copy(r5, r10);
        HelperWidget r11 = (HelperWidget) r5;
        int r12 = 0;
        this.mWidgetsCount = 0;
        int r13 = r11.mWidgetsCount;
    L3:
        if (r12 >= r13) goto L5;
        add(r10.get(r11.mWidgets[r12]));
        r12 = r12 + 1;
        goto L3
    }

    public int findGroupInDependents(int r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.mWidgetsCount) goto L16;
        ConstraintWidget r11 = this.mWidgets[r10];
        if (r5 != 0) goto L11;
        int r12 = r11.horizontalGroup;
        if (r12 == (-1)) goto L11;
        return r12;
    L11:
        if (r5 != 1) goto L15;
        int r13 = r11.verticalGroup;
        if (r13 == (-1)) goto L15;
        return r13;
    L15:
        r10 = r10 + 1;
        goto L4
    L16:
        return -1;
    }

    @Override // androidx.constraintlayout.solver.widgets.Helper
    public void removeAllIds() {
        this.mWidgetsCount = 0;
        Arrays.fill(this.mWidgets, null);
    }

    @Override // androidx.constraintlayout.solver.widgets.Helper
    public void updateConstraints(ConstraintWidgetContainer r5) {
    }
}
