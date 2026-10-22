package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.Chain;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class WidgetGroup {
    private static final boolean DEBUG = false;
    static int count;
    boolean authoritative;
    int id;
    private int moveTo;
    int orientation;
    ArrayList<MeasureResult> results;
    ArrayList<ConstraintWidget> widgets;

    class MeasureResult {
        int baseline;
        int bottom;
        int left;
        int orientation;
        int right;
        final /* synthetic */ WidgetGroup this$0;
        int top;
        WeakReference<ConstraintWidget> widgetRef;

        public MeasureResult(WidgetGroup r10, ConstraintWidget r11, LinearSystem r12, int r13) {
            this.this$0 = r10;
            this.widgetRef = new WeakReference(r11);
            this.left = r12.getObjectVariableValue(r11.mLeft);
            this.top = r12.getObjectVariableValue(r11.mTop);
            this.right = r12.getObjectVariableValue(r11.mRight);
            this.bottom = r12.getObjectVariableValue(r11.mBottom);
            this.baseline = r12.getObjectVariableValue(r11.mBaseline);
            this.orientation = r13;
        }

        public void apply() {
            ConstraintWidget r10 = this.widgetRef.get();
            if (r10 == null) goto L6;
            r10.setFinalFrame(this.left, this.top, this.right, this.bottom, this.baseline, this.orientation);
            return;
        }
    }

    static {
    }

    public WidgetGroup(int r10) {
        this.widgets = new ArrayList();
        this.id = -1;
        this.authoritative = false;
        this.orientation = 0;
        this.results = null;
        this.moveTo = -1;
        int r11 = count;
        count = r11 + 1;
        this.id = r11;
        this.orientation = r10;
    }

    private boolean contains(ConstraintWidget r10) {
        return this.widgets.contains(r10);
    }

    private String getOrientationString() {
        int r10 = this.orientation;
        if (r10 != 0) goto L7;
        return "Horizontal";
    L7:
        if (r10 != 1) goto L11;
        return "Vertical";
    L11:
        if (r10 != 2) goto L14;
        return "Both";
    L14:
        return "Unknown";
    }

    private int measureWrap(int r10, ConstraintWidget r11) {
        ConstraintWidget.DimensionBehaviour r12 = r11.getDimensionBehaviour(r10);
        if (r12 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L5;
    L11:
        if (r10 != 0) goto L14;
        return r11.getWidth();
    L14:
        return r11.getHeight();
    L5:
        if (r12 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L11;
        if (r12 == ConstraintWidget.DimensionBehaviour.FIXED) goto L11;
        return -1;
    }

    private int solverMeasure(LinearSystem r10, ArrayList<ConstraintWidget> r11, int r12) {
        int r13 = 0;
        ConstraintWidgetContainer r14 = (ConstraintWidgetContainer) r11.get(0).getParent();
        r10.reset();
        r14.addToSolver(r10, false);
        int r15 = 0;
    L4:
        if (r15 >= r11.size()) goto L6;
        r11.get(r15).addToSolver(r10, false);
        r15 = r15 + 1;
        goto L4
    L6:
        if (r12 != 0) goto L11;
        if (r14.mHorizontalChainsSize <= 0) goto L11;
        Chain.applyChainConstraints(r14, r10, r11, 0);
    L11:
        if (r12 == 1) goto L13;
    L28:
        r10.minimize();     // Catch: Exception -> L17
    L19:
        this.results = new ArrayList();
    L21:
        if (r13 >= r11.size()) goto L23;
        this.results.add(new MeasureResult(this, r11.get(r13), r10, r12));
        r13 = r13 + 1;
        goto L21
    L23:
        if (r12 != 0) goto L27;
        int r16 = r10.getObjectVariableValue(r14.mLeft);
        ConstraintAnchor r17 = r14.mRight;
    L25:
        int r18 = r10.getObjectVariableValue(r17);
        r10.reset();
        return r18 - r16;
    L27:
        r16 = r10.getObjectVariableValue(r14.mTop);
        r17 = r14.mBottom;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L13:
        if (r14.mVerticalChainsSize <= 0) goto L28;
        Chain.applyChainConstraints(r14, r10, r11, 1);
        goto L28
    }

    public boolean add(ConstraintWidget r10) {
        if (this.widgets.contains(r10) == false) goto L6;
        return false;
    L6:
        this.widgets.add(r10);
        return true;
    }

    public void apply() {
        if (this.results != null) goto L6;
        return;
    L6:
        if (this.authoritative == true) goto L8;
        return;
    L8:
        int r10 = 0;
    L10:
        if (r10 >= this.results.size()) goto L12;
        this.results.get(r10).apply();
        r10 = r10 + 1;
        goto L10
    }

    public void cleanup(ArrayList<WidgetGroup> r10) {
        int r11 = this.widgets.size();
        if (this.moveTo == (-1)) goto L12;
        if (r11 <= 0) goto L12;
        int r12 = 0;
    L7:
        if (r12 >= r10.size()) goto L12;
        WidgetGroup r13 = r10.get(r12);
        if (this.moveTo != r13.id) goto L11;
        moveTo(this.orientation, r13);
    L11:
        r12 = r12 + 1;
    L12:
        if (r11 != 0) goto L18;
        r10.remove(this);
        return;
    }

    public void clear() {
        this.widgets.clear();
    }

    public int getId() {
        return this.id;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public boolean intersectWith(WidgetGroup r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.widgets.size()) goto L10;
        if (r10.contains(this.widgets.get(r11)) == true) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public boolean isAuthoritative() {
        return this.authoritative;
    }

    public int measureWrap(LinearSystem r10, int r11) {
        if (this.widgets.size() != 0) goto L7;
        return 0;
    L7:
        return solverMeasure(r10, this.widgets, r11);
    }

    public void moveTo(int r10, WidgetGroup r11) {
        Iterator<ConstraintWidget> r12 = this.widgets.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        ConstraintWidget r13 = r12.next();
        r11.add(r13);
        int r14 = r11.getId();
        if (r10 == 0) goto L7;
        r13.verticalGroup = r14;
        goto L4
    L7:
        r13.horizontalGroup = r14;
        goto L4
    L9:
        this.moveTo = r11.id;
    }

    public void setAuthoritative(boolean r10) {
        this.authoritative = r10;
    }

    public void setOrientation(int r10) {
        this.orientation = r10;
    }

    public int size() {
        return this.widgets.size();
    }

    public String toString() {
        String r10 = getOrientationString() + " [" + this.id + "] <";
        Iterator<ConstraintWidget> r11 = this.widgets.iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        r10 = r10 + " " + r11.next().getDebugName();
        goto L4
    L7:
        return r10 + " >";
    }
}
