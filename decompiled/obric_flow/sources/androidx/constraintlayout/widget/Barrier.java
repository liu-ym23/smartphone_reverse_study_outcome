package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.HelperWidget;

/* JADX INFO: loaded from: classes.dex */
public class Barrier extends ConstraintHelper {
    public static final int BOTTOM = 3;
    public static final int END = 6;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int START = 5;
    public static final int TOP = 2;
    private androidx.constraintlayout.solver.widgets.Barrier mBarrier;
    private int mIndicatedType;
    private int mResolvedType;

    public Barrier(Context r5) {
        super(r5);
        super.setVisibility(8);
    }

    private void updateType(ConstraintWidget r5, int r10, boolean r11) {
        this.mResolvedType = r10;
        if (r11 == false) goto L9;
        int r12 = this.mIndicatedType;
        if (r12 != 5) goto L7;
        this.mResolvedType = 1;
    L15:
        if ((r5 instanceof androidx.constraintlayout.solver.widgets.Barrier) == false) goto L18;
        ((androidx.constraintlayout.solver.widgets.Barrier) r5).setBarrierType(this.mResolvedType);
        return;
    L18:
        return;
    L7:
        if (r12 != 6) goto L15;
        this.mResolvedType = 0;
        goto L15
    L9:
        int r13 = this.mIndicatedType;
        if (r13 != 5) goto L12;
        this.mResolvedType = 0;
        goto L15
    L12:
        if (r13 != 6) goto L15;
        this.mResolvedType = 1;
        goto L15
    }

    public boolean allowsGoneWidget() {
        return this.mBarrier.allowsGoneWidget();
    }

    public int getMargin() {
        return this.mBarrier.getMargin();
    }

    public int getType() {
        return this.mIndicatedType;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet r10) {
        super.init(r10);
        this.mBarrier = new androidx.constraintlayout.solver.widgets.Barrier();
        if (r10 == null) goto L17;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R.styleable.ConstraintLayout_Layout);
        int r5 = r11.getIndexCount();
        int r12 = 0;
    L5:
        if (r12 >= r5) goto L16;
        int r13 = r11.getIndex(r12);
        if (r13 != R.styleable.ConstraintLayout_Layout_barrierDirection) goto L10;
        setType(r11.getInt(r13, 0));
    L15:
        r12 = r12 + 1;
        goto L5
    L10:
        if (r13 != R.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) goto L13;
        this.mBarrier.setAllowsGoneWidget(r11.getBoolean(r13, true));
        goto L15
    L13:
        if (r13 != R.styleable.ConstraintLayout_Layout_barrierMargin) goto L15;
        this.mBarrier.setMargin(r11.getDimensionPixelSize(r13, 0));
        goto L15
    L16:
        r11.recycle();
    L17:
        this.mHelperWidget = this.mBarrier;
        validateParams();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void loadParameters(ConstraintSet.Constraint r5, HelperWidget r10, ConstraintLayout.LayoutParams r11, SparseArray<ConstraintWidget> r12) {
        super.loadParameters(r5, r10, r11, r12);
        if ((r10 instanceof androidx.constraintlayout.solver.widgets.Barrier) == false) goto L6;
        androidx.constraintlayout.solver.widgets.Barrier r13 = (androidx.constraintlayout.solver.widgets.Barrier) r10;
        boolean r14 = ((ConstraintWidgetContainer) r10.getParent()).isRtl();
        updateType(r13, r5.layout.mBarrierDirection, r14);
        r13.setAllowsGoneWidget(r5.layout.mBarrierAllowsGoneWidgets);
        r13.setMargin(r5.layout.mBarrierMargin);
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void resolveRtl(ConstraintWidget r5, boolean r10) {
        updateType(r5, this.mIndicatedType, r10);
    }

    public void setAllowsGoneWidget(boolean r5) {
        this.mBarrier.setAllowsGoneWidget(r5);
    }

    public void setDpMargin(int r5) {
        this.mBarrier.setMargin((int) ((r5 * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int r5) {
        this.mBarrier.setMargin(r5);
    }

    public void setType(int r5) {
        this.mIndicatedType = r5;
    }

    public Barrier(Context r5, AttributeSet r10) {
        super(r5, r10);
        super.setVisibility(8);
    }

    public Barrier(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        super.setVisibility(8);
    }
}
