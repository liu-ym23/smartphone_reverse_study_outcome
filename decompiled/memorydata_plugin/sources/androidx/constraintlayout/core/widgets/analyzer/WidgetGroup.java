package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.Chain;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import com.tom_roush.pdfbox.pdmodel.a.d.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

        public MeasureResult(WidgetGroup r1, ConstraintWidget r2, LinearSystem r3, int r4) {
            this.this$0 = r1;
            this.widgetRef = new WeakReference(r2);
            this.left = r3.getObjectVariableValue(r2.mLeft);
            this.top = r3.getObjectVariableValue(r2.mTop);
            this.right = r3.getObjectVariableValue(r2.mRight);
            this.bottom = r3.getObjectVariableValue(r2.mBottom);
            this.baseline = r3.getObjectVariableValue(r2.mBaseline);
            this.orientation = r4;
        }

        public void apply() {
            ConstraintWidget r1 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(this.widgetRef.get(), ConstraintWidget.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L6;
            r1.setFinalFrame(this.left, this.top, this.right, this.bottom, this.baseline, this.orientation);
            return;
        }
    }

    static {
    }

    public WidgetGroup(int r3) {
        this.widgets = new ArrayList();
        this.id = -1;
        this.authoritative = false;
        this.orientation = 0;
        this.results = null;
        this.moveTo = -1;
        int r0 = count;
        count = r0 + 1;
        this.id = r0;
        this.orientation = r3;
    }

    private boolean contains(ConstraintWidget r1) {
        return this.widgets.contains(r1);
    }

    private String getOrientationString() {
        int r1 = this.orientation;
        if (r1 != 0) goto L7;
        return "Horizontal";
    L7:
        if (r1 != 1) goto L11;
        return "Vertical";
    L11:
        if (r1 != 2) goto L14;
        return h.g;
    L14:
        return "Unknown";
    }

    private int measureWrap(int r2, ConstraintWidget r3) {
        ConstraintWidget.DimensionBehaviour r1 = r3.getDimensionBehaviour(r2);
        if (r1 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L5;
    L11:
        if (r2 != 0) goto L14;
        return r3.getWidth();
    L14:
        return r3.getHeight();
    L5:
        if (r1 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L11;
        if (r1 == ConstraintWidget.DimensionBehaviour.FIXED) goto L11;
        return -1;
    }

    private int solverMeasure(LinearSystem r7, ArrayList<ConstraintWidget> r8, int r9) {
        int r0 = 0;
        ConstraintWidgetContainer r1 = (ConstraintWidgetContainer) ZeusTransformUtils.preCheckCast(((ConstraintWidget) ZeusTransformUtils.preCheckCast(r8.get(0), ConstraintWidget.class, "com.obric.memorydata.plugin")).getParent(), ConstraintWidgetContainer.class, "com.obric.memorydata.plugin");
        r7.reset();
        r1.addToSolver(r7, false);
        int r2 = 0;
    L4:
        if (r2 >= r8.size()) goto L6;
        ((ConstraintWidget) ZeusTransformUtils.preCheckCast(r8.get(r2), ConstraintWidget.class, "com.obric.memorydata.plugin")).addToSolver(r7, false);
        r2 = r2 + 1;
        goto L4
    L6:
        if (r9 != 0) goto L11;
        if (r1.mHorizontalChainsSize <= 0) goto L11;
        Chain.applyChainConstraints(r1, r7, r8, 0);
    L11:
        if (r9 == 1) goto L13;
    L28:
        r7.minimize();     // Catch: Exception -> L17
    L19:
        this.results = new ArrayList();
    L21:
        if (r0 >= r8.size()) goto L23;
        this.results.add(new MeasureResult(this, (ConstraintWidget) ZeusTransformUtils.preCheckCast(r8.get(r0), ConstraintWidget.class, "com.obric.memorydata.plugin"), r7, r9));
        r0 = r0 + 1;
        goto L21
    L23:
        if (r9 != 0) goto L27;
        int r6 = r7.getObjectVariableValue(r1.mLeft);
        ConstraintAnchor r10 = r1.mRight;
    L25:
        int r11 = r7.getObjectVariableValue(r10);
        r7.reset();
        return r11 - r6;
    L27:
        r6 = r7.getObjectVariableValue(r1.mTop);
        r10 = r1.mBottom;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L13:
        if (r1.mVerticalChainsSize <= 0) goto L28;
        Chain.applyChainConstraints(r1, r7, r8, 1);
        goto L28
    }

    public boolean add(ConstraintWidget r2) {
        if (this.widgets.contains(r2) == false) goto L6;
        return false;
    L6:
        this.widgets.add(r2);
        return true;
    }

    public void apply() {
        if (this.results != null) goto L6;
        return;
    L6:
        if (this.authoritative == true) goto L8;
        return;
    L8:
        int r0 = 0;
    L10:
        if (r0 >= this.results.size()) goto L12;
        ((MeasureResult) ZeusTransformUtils.preCheckCast(this.results.get(r0), MeasureResult.class, "com.obric.memorydata.plugin")).apply();
        r0 = r0 + 1;
        goto L10
    }

    public void cleanup(ArrayList<WidgetGroup> r6) {
        int r0 = this.widgets.size();
        if (this.moveTo == (-1)) goto L12;
        if (r0 <= 0) goto L12;
        int r1 = 0;
    L7:
        if (r1 >= r6.size()) goto L12;
        WidgetGroup r2 = (WidgetGroup) ZeusTransformUtils.preCheckCast(r6.get(r1), WidgetGroup.class, "com.obric.memorydata.plugin");
        if (this.moveTo != r2.id) goto L11;
        moveTo(this.orientation, r2);
    L11:
        r1 = r1 + 1;
    L12:
        if (r0 != 0) goto L18;
        r6.remove(this);
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

    public boolean intersectWith(WidgetGroup r6) {
        int r1 = 0;
    L4:
        if (r1 >= this.widgets.size()) goto L10;
        if (r6.contains((ConstraintWidget) ZeusTransformUtils.preCheckCast(this.widgets.get(r1), ConstraintWidget.class, "com.obric.memorydata.plugin")) == true) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public boolean isAuthoritative() {
        return this.authoritative;
    }

    public int measureWrap(LinearSystem r2, int r3) {
        if (this.widgets.size() != 0) goto L7;
        return 0;
    L7:
        return solverMeasure(r2, this.widgets, r3);
    }

    public void moveTo(int r5, WidgetGroup r6) {
        Iterator<ConstraintWidget> r0 = this.widgets.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        ConstraintWidget r1 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r0.next(), ConstraintWidget.class, "com.obric.memorydata.plugin");
        r6.add(r1);
        int r2 = r6.getId();
        if (r5 == 0) goto L7;
        r1.verticalGroup = r2;
        goto L4
    L7:
        r1.horizontalGroup = r2;
        goto L4
    L9:
        this.moveTo = r6.id;
    }

    public void setAuthoritative(boolean r1) {
        this.authoritative = r1;
    }

    public void setOrientation(int r1) {
        this.orientation = r1;
    }

    public int size() {
        return this.widgets.size();
    }

    public String toString() {
        String r0 = getOrientationString() + " [" + this.id + "] <";
        Iterator<ConstraintWidget> r4 = this.widgets.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        r0 = r0 + " " + ((ConstraintWidget) ZeusTransformUtils.preCheckCast(r4.next(), ConstraintWidget.class, "com.obric.memorydata.plugin")).getDebugName();
        goto L4
    L7:
        return r0 + " >";
    }
}
