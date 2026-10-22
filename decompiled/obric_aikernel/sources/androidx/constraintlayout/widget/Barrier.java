package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.HelperWidget;

/* JADX INFO: loaded from: classes.dex */
public class Barrier extends ConstraintHelper {
    public static final int BOTTOM = 3;
    public static final int END = 6;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int START = 5;
    public static final int TOP = 2;
    private androidx.constraintlayout.core.widgets.Barrier mBarrier;
    private int mIndicatedType;
    private int mResolvedType;

    public Barrier(Context r10) {
        super(r10);
        super.setVisibility(8);
    }

    public Barrier(Context r10, AttributeSet r11) {
        super(r10, r11);
        super.setVisibility(8);
    }

    public Barrier(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        super.setVisibility(8);
    }

    private void updateType(ConstraintWidget r10, int r11, boolean r12) {
        this.mResolvedType = r11;
        if (Build.VERSION.SDK_INT >= 17) goto L9;
        int r13 = this.mIndicatedType;
        if (r13 != 5) goto L7;
    L6:
        this.mResolvedType = 0;
    L20:
        if ((r10 instanceof androidx.constraintlayout.core.widgets.Barrier) == false) goto L23;
        ((androidx.constraintlayout.core.widgets.Barrier) r10).setBarrierType(this.mResolvedType);
        return;
    L23:
        return;
    L7:
        if (r13 != 6) goto L20;
    L12:
        this.mResolvedType = 1;
        goto L20
    L9:
        int r14 = this.mIndicatedType;
        if (r12 == false) goto L15;
        if (r14 == 5) goto L12;
        if (r14 != 6) goto L20;
    L15:
        if (r14 == 5) goto L6;
        if (r14 != 6) goto L20;
        goto L12
    }

    @Deprecated
    public boolean allowsGoneWidget() {
        return this.mBarrier.getAllowsGoneWidget();
    }

    public boolean getAllowsGoneWidget() {
        return this.mBarrier.getAllowsGoneWidget();
    }

    public int getMargin() {
        return this.mBarrier.getMargin();
    }

    public int getType() {
        return this.mIndicatedType;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void init(AttributeSet r10) {
        super.init(r10);
        this.mBarrier = new androidx.constraintlayout.core.widgets.Barrier();
        if (r10 == null) goto L17;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R.styleable.ConstraintLayout_Layout);
        int r12 = r11.getIndexCount();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L16;
        int r14 = r11.getIndex(r13);
        if (r14 != R.styleable.ConstraintLayout_Layout_barrierDirection) goto L10;
        setType(r11.getInt(r14, 0));
    L15:
        r13 = r13 + 1;
        goto L5
    L10:
        if (r14 != R.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) goto L13;
        this.mBarrier.setAllowsGoneWidget(r11.getBoolean(r14, true));
        goto L15
    L13:
        if (r14 != R.styleable.ConstraintLayout_Layout_barrierMargin) goto L15;
        this.mBarrier.setMargin(r11.getDimensionPixelSize(r14, 0));
        goto L15
    L16:
        r11.recycle();
    L17:
        this.mHelperWidget = this.mBarrier;
        validateParams();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void loadParameters(ConstraintSet.Constraint r10, HelperWidget r11, ConstraintLayout.LayoutParams r12, SparseArray<ConstraintWidget> r13) {
        super.loadParameters(r10, r11, r12, r13);
        if ((r11 instanceof androidx.constraintlayout.core.widgets.Barrier) == false) goto L6;
        androidx.constraintlayout.core.widgets.Barrier r14 = (androidx.constraintlayout.core.widgets.Barrier) r11;
        boolean r15 = ((ConstraintWidgetContainer) r11.getParent()).isRtl();
        updateType(r14, r10.layout.mBarrierDirection, r15);
        r14.setAllowsGoneWidget(r10.layout.mBarrierAllowsGoneWidgets);
        r14.setMargin(r10.layout.mBarrierMargin);
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void resolveRtl(ConstraintWidget r10, boolean r11) {
        updateType(r10, this.mIndicatedType, r11);
    }

    public void setAllowsGoneWidget(boolean r10) {
        this.mBarrier.setAllowsGoneWidget(r10);
    }

    public void setDpMargin(int r10) {
        this.mBarrier.setMargin((int) ((r10 * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int r10) {
        this.mBarrier.setMargin(r10);
    }

    public void setType(int r10) {
        this.mIndicatedType = r10;
    }
}
