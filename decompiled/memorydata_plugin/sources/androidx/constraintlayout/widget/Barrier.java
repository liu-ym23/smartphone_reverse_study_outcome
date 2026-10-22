package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.HelperWidget;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

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

    public Barrier(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        super.setVisibility(8);
    }

    public Barrier(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
        super.setVisibility(8);
    }

    public Barrier(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), r5);
        super.setVisibility(8);
    }

    private void updateType(ConstraintWidget r6, int r7, boolean r8) {
        this.mResolvedType = r7;
        if (Build.VERSION.SDK_INT >= 17) goto L9;
        int r9 = this.mIndicatedType;
        if (r9 != 5) goto L7;
    L6:
        this.mResolvedType = 0;
    L20:
        if (ZeusTransformUtils.instanceOf(r6, androidx.constraintlayout.core.widgets.Barrier.class) == false) goto L23;
        ((androidx.constraintlayout.core.widgets.Barrier) ZeusTransformUtils.preCheckCast(r6, androidx.constraintlayout.core.widgets.Barrier.class, "com.obric.memorydata.plugin")).setBarrierType(this.mResolvedType);
        return;
    L23:
        return;
    L7:
        if (r9 != 6) goto L20;
    L12:
        this.mResolvedType = 1;
        goto L20
    L9:
        int r10 = this.mIndicatedType;
        if (r8 == false) goto L15;
        if (r10 == 5) goto L12;
        if (r10 != 6) goto L20;
    L15:
        if (r10 == 5) goto L6;
        if (r10 != 6) goto L20;
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
    public void init(AttributeSet r8) {
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.memorydata.plugin");
        super.init(r9);
        this.mBarrier = new androidx.constraintlayout.core.widgets.Barrier();
        if (r9 == null) goto L17;
        TypedArray r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(r9, R.styleable.ConstraintLayout_Layout);
        int r0 = r10.getIndexCount();
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L16;
        int r3 = r10.getIndex(r2);
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_barrierDirection, "styleable", "ConstraintLayout_Layout_barrierDirection")) goto L10;
        setType(r10.getInt(r3, 0));
    L15:
        r2 = r2 + 1;
        goto L5
    L10:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets, "styleable", "ConstraintLayout_Layout_barrierAllowsGoneWidgets")) goto L13;
        this.mBarrier.setAllowsGoneWidget(r10.getBoolean(r3, true));
        goto L15
    L13:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_barrierMargin, "styleable", "ConstraintLayout_Layout_barrierMargin")) goto L15;
        this.mBarrier.setMargin(r10.getDimensionPixelSize(r3, 0));
        goto L15
    L16:
        r10.recycle();
    L17:
        this.mHelperWidget = this.mBarrier;
        validateParams();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void loadParameters(ConstraintSet.Constraint r2, HelperWidget r3, ConstraintLayout.LayoutParams r4, SparseArray<ConstraintWidget> r5) {
        super.loadParameters(r2, r3, r4, r5);
        if (ZeusTransformUtils.instanceOf(r3, androidx.constraintlayout.core.widgets.Barrier.class) == false) goto L6;
        androidx.constraintlayout.core.widgets.Barrier r6 = (androidx.constraintlayout.core.widgets.Barrier) ZeusTransformUtils.preCheckCast(r3, androidx.constraintlayout.core.widgets.Barrier.class, "com.obric.memorydata.plugin");
        boolean r7 = ((ConstraintWidgetContainer) ZeusTransformUtils.preCheckCast(r3.getParent(), ConstraintWidgetContainer.class, "com.obric.memorydata.plugin")).isRtl();
        updateType(r6, r2.layout.mBarrierDirection, r7);
        r6.setAllowsGoneWidget(r2.layout.mBarrierAllowsGoneWidgets);
        r6.setMargin(r2.layout.mBarrierMargin);
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void resolveRtl(ConstraintWidget r2, boolean r3) {
        updateType(r2, this.mIndicatedType, r3);
    }

    public void setAllowsGoneWidget(boolean r1) {
        this.mBarrier.setAllowsGoneWidget(r1);
    }

    public void setDpMargin(int r2) {
        this.mBarrier.setMargin((int) ((r2 * ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int r1) {
        this.mBarrier.setMargin(r1);
    }

    public void setType(int r1) {
        this.mIndicatedType = r1;
    }
}
