package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.analyzer.Grouping;
import androidx.constraintlayout.core.widgets.analyzer.WidgetGroup;
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

    @Override // androidx.constraintlayout.core.widgets.Helper
    public void add(ConstraintWidget r10) {
        if (r10 == this) goto L10;
        if (r10 == null) goto L11;
        int r11 = this.mWidgetsCount + 1;
        ConstraintWidget[] r12 = this.mWidgets;
        if (r11 <= r12.length) goto L8;
        this.mWidgets = (ConstraintWidget[]) Arrays.copyOf(r12, r12.length * 2);
    L8:
        ConstraintWidget[] r13 = this.mWidgets;
        int r14 = this.mWidgetsCount;
        r13[r14] = r10;
        this.mWidgetsCount = r14 + 1;
        return;
    L11:
        return;
    }

    public void addDependents(ArrayList<WidgetGroup> r10, int r11, WidgetGroup r12) {
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r14 >= this.mWidgetsCount) goto L7;
        r12.add(this.mWidgets[r14]);
        r14 = r14 + 1;
    L7:
        if (r13 >= this.mWidgetsCount) goto L9;
        Grouping.findDependents(this.mWidgets[r13], r11, r10, r12);
        r13 = r13 + 1;
        goto L7
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void copy(ConstraintWidget r10, HashMap<ConstraintWidget, ConstraintWidget> r11) {
        super.copy(r10, r11);
        HelperWidget r12 = (HelperWidget) r10;
        int r13 = 0;
        this.mWidgetsCount = 0;
        int r14 = r12.mWidgetsCount;
    L3:
        if (r13 >= r14) goto L5;
        add(r11.get(r12.mWidgets[r13]));
        r13 = r13 + 1;
        goto L3
    }

    public int findGroupInDependents(int r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.mWidgetsCount) goto L16;
        ConstraintWidget r12 = this.mWidgets[r11];
        if (r10 != 0) goto L11;
        int r13 = r12.horizontalGroup;
        if (r13 == (-1)) goto L11;
        return r13;
    L11:
        if (r10 != 1) goto L15;
        int r14 = r12.verticalGroup;
        if (r14 == (-1)) goto L15;
        return r14;
    L15:
        r11 = r11 + 1;
        goto L4
    L16:
        return -1;
    }

    @Override // androidx.constraintlayout.core.widgets.Helper
    public void removeAllIds() {
        this.mWidgetsCount = 0;
        Arrays.fill(this.mWidgets, null);
    }

    @Override // androidx.constraintlayout.core.widgets.Helper
    public void updateConstraints(ConstraintWidgetContainer r10) {
    }
}
