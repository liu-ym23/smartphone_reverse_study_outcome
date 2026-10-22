package androidx.constraintlayout.solver.widgets.analyzer;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.Chain;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class WidgetGroup {
    private static final boolean DEBUG = false;
    static int count;
    boolean authoritative;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    int f440id;
    private int moveTo;
    int orientation;
    ArrayList<MeasureResult> results;
    ArrayList<ConstraintWidget> widgets;

    public class MeasureResult {
        int baseline;
        int bottom;
        int left;
        int orientation;
        int right;
        final /* synthetic */ WidgetGroup this$0;
        int top;
        WeakReference<ConstraintWidget> widgetRef;

        public MeasureResult(WidgetGroup r5, ConstraintWidget r10, LinearSystem r11, int r12) {
            this.this$0 = r5;
            this.widgetRef = new WeakReference(r10);
            this.left = r11.getObjectVariableValue(r10.mLeft);
            this.top = r11.getObjectVariableValue(r10.mTop);
            this.right = r11.getObjectVariableValue(r10.mRight);
            this.bottom = r11.getObjectVariableValue(r10.mBottom);
            this.baseline = r11.getObjectVariableValue(r10.mBaseline);
            this.orientation = r12;
        }

        public void apply() {
            ConstraintWidget r5 = this.widgetRef.get();
            if (r5 == null) goto L6;
            r5.setFinalFrame(this.left, this.top, this.right, this.bottom, this.baseline, this.orientation);
            return;
        }
    }

    public WidgetGroup(int r5) {
        this.widgets = new ArrayList();
        this.authoritative = false;
        this.results = null;
        this.moveTo = -1;
        int r10 = count;
        count = r10 + 1;
        this.f440id = r10;
        this.orientation = r5;
    }

    private boolean contains(ConstraintWidget r5) {
        return this.widgets.contains(r5);
    }

    private String getOrientationString() {
        int r5 = this.orientation;
        if (r5 != 0) goto L7;
        return "Horizontal";
    L7:
        if (r5 != 1) goto L11;
        return "Vertical";
    L11:
        if (r5 != 2) goto L14;
        return "Both";
    L14:
        return "Unknown";
    }

    private int measureWrap(int r5, ConstraintWidget r10) {
        ConstraintWidget.DimensionBehaviour r11 = r10.getDimensionBehaviour(r5);
        if (r11 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L5;
    L11:
        if (r5 != 0) goto L14;
        return r10.getWidth();
    L14:
        return r10.getHeight();
    L5:
        if (r11 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L11;
        if (r11 == ConstraintWidget.DimensionBehaviour.FIXED) goto L11;
        return -1;
    }

    private int solverMeasure(LinearSystem r5, ArrayList<ConstraintWidget> r10, int r11) {
        int r12 = 0;
        ConstraintWidgetContainer r13 = (ConstraintWidgetContainer) r10.get(0).getParent();
        r5.reset();
        r13.addToSolver(r5, false);
        int r14 = 0;
    L4:
        if (r14 >= r10.size()) goto L6;
        r10.get(r14).addToSolver(r5, false);
        r14 = r14 + 1;
        goto L4
    L6:
        if (r11 != 0) goto L11;
        if (r13.mHorizontalChainsSize <= 0) goto L11;
        Chain.applyChainConstraints(r13, r5, r10, 0);
    L11:
        if (r11 == 1) goto L13;
    L28:
        r5.minimize();     // Catch: Exception -> L17
    L19:
        this.results = new ArrayList();
    L21:
        if (r12 >= r10.size()) goto L23;
        this.results.add(new MeasureResult(this, r10.get(r12), r5, r11));
        r12 = r12 + 1;
        goto L21
    L23:
        if (r11 != 0) goto L27;
        int r15 = r5.getObjectVariableValue(r13.mLeft);
        int r16 = r5.getObjectVariableValue(r13.mRight);
        r5.reset();
    L26:
        return r16 - r15;
    L27:
        r15 = r5.getObjectVariableValue(r13.mTop);
        r16 = r5.getObjectVariableValue(r13.mBottom);
        r5.reset();
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L13:
        if (r13.mVerticalChainsSize <= 0) goto L28;
        Chain.applyChainConstraints(r13, r5, r10, 1);
        goto L28
    }

    public boolean add(ConstraintWidget r5) {
        if (this.widgets.contains(r5) == false) goto L6;
        return false;
    L6:
        this.widgets.add(r5);
        return true;
    }

    public void apply() {
        if (this.results != null) goto L6;
        return;
    L6:
        if (this.authoritative == true) goto L8;
        return;
    L8:
        int r5 = 0;
    L10:
        if (r5 >= this.results.size()) goto L12;
        this.results.get(r5).apply();
        r5 = r5 + 1;
        goto L10
    }

    public void cleanup(ArrayList<WidgetGroup> r10) {
        int r5 = this.widgets.size();
        if (this.moveTo == (-1)) goto L12;
        if (r5 <= 0) goto L12;
        int r11 = 0;
    L7:
        if (r11 >= r10.size()) goto L12;
        WidgetGroup r12 = r10.get(r11);
        if (this.moveTo != r12.f440id) goto L11;
        moveTo(this.orientation, r12);
    L11:
        r11 = r11 + 1;
    L12:
        if (r5 != 0) goto L18;
        r10.remove(this);
        return;
    }

    public void clear() {
        this.widgets.clear();
    }

    public int getId() {
        return this.f440id;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public boolean intersectWith(WidgetGroup r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.widgets.size()) goto L10;
        if (r5.contains(this.widgets.get(r10)) == true) goto L7;
        r10 = r10 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public boolean isAuthoritative() {
        return this.authoritative;
    }

    public void moveTo(int r5, WidgetGroup r10) {
        Iterator<ConstraintWidget> r11 = this.widgets.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        ConstraintWidget r12 = r11.next();
        r10.add(r12);
        if (r5 == 0) goto L7;
        r12.verticalGroup = r10.getId();
        goto L4
    L7:
        r12.horizontalGroup = r10.getId();
        goto L4
    L9:
        this.moveTo = r10.f440id;
    }

    public void setAuthoritative(boolean r5) {
        this.authoritative = r5;
    }

    public void setOrientation(int r5) {
        this.orientation = r5;
    }

    public int size() {
        return this.widgets.size();
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(getOrientationString());
        r5.append(" [");
        String r10 = a.s(r5, this.f440id, "] <");
        Iterator<ConstraintWidget> r11 = this.widgets.iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        ConstraintWidget r12 = r11.next();
        StringBuilder r13 = j0.w(r10, " ");
        r13.append(r12.getDebugName());
        r10 = r13.toString();
        goto L4
    L7:
        return j0.j(r10, " >");
    }

    public int measureWrap(LinearSystem r5, int r10) {
        if (this.widgets.size() != 0) goto L7;
        return 0;
    L7:
        return solverMeasure(r5, this.widgets, r10);
    }
}
