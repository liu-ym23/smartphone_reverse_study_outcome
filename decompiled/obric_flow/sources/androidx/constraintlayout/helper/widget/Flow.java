package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;

/* JADX INFO: loaded from: classes.dex */
public class Flow extends VirtualLayout {
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static final int HORIZONTAL = 0;
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    private static final String TAG = "Flow";
    public static final int VERTICAL = 1;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_NONE = 0;
    private androidx.constraintlayout.solver.widgets.Flow mFlow;

    public Flow(Context r5) {
        super(r5);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet r10) {
        super.init(r10);
        this.mFlow = new androidx.constraintlayout.solver.widgets.Flow();
        if (r10 == null) goto L86;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R.styleable.ConstraintLayout_Layout);
        int r5 = r11.getIndexCount();
        int r12 = 0;
    L5:
        if (r12 >= r5) goto L85;
        int r13 = r11.getIndex(r12);
        if (r13 != R.styleable.ConstraintLayout_Layout_android_orientation) goto L10;
        this.mFlow.setOrientation(r11.getInt(r13, 0));
    L84:
        r12 = r12 + 1;
        goto L5
    L10:
        if (r13 != R.styleable.ConstraintLayout_Layout_android_padding) goto L13;
        this.mFlow.setPadding(r11.getDimensionPixelSize(r13, 0));
        goto L84
    L13:
        if (r13 != R.styleable.ConstraintLayout_Layout_android_paddingStart) goto L16;
        this.mFlow.setPaddingStart(r11.getDimensionPixelSize(r13, 0));
        goto L84
    L16:
        if (r13 != R.styleable.ConstraintLayout_Layout_android_paddingEnd) goto L19;
        this.mFlow.setPaddingEnd(r11.getDimensionPixelSize(r13, 0));
        goto L84
    L19:
        if (r13 != R.styleable.ConstraintLayout_Layout_android_paddingLeft) goto L22;
        this.mFlow.setPaddingLeft(r11.getDimensionPixelSize(r13, 0));
        goto L84
    L22:
        if (r13 != R.styleable.ConstraintLayout_Layout_android_paddingTop) goto L25;
        this.mFlow.setPaddingTop(r11.getDimensionPixelSize(r13, 0));
        goto L84
    L25:
        if (r13 != R.styleable.ConstraintLayout_Layout_android_paddingRight) goto L28;
        this.mFlow.setPaddingRight(r11.getDimensionPixelSize(r13, 0));
        goto L84
    L28:
        if (r13 != R.styleable.ConstraintLayout_Layout_android_paddingBottom) goto L31;
        this.mFlow.setPaddingBottom(r11.getDimensionPixelSize(r13, 0));
        goto L84
    L31:
        if (r13 != R.styleable.ConstraintLayout_Layout_flow_wrapMode) goto L34;
        this.mFlow.setWrapMode(r11.getInt(r13, 0));
        goto L84
    L34:
        if (r13 != R.styleable.ConstraintLayout_Layout_flow_horizontalStyle) goto L37;
        this.mFlow.setHorizontalStyle(r11.getInt(r13, 0));
        goto L84
    L37:
        if (r13 != R.styleable.ConstraintLayout_Layout_flow_verticalStyle) goto L40;
        this.mFlow.setVerticalStyle(r11.getInt(r13, 0));
        goto L84
    L40:
        if (r13 != R.styleable.ConstraintLayout_Layout_flow_firstHorizontalStyle) goto L43;
        this.mFlow.setFirstHorizontalStyle(r11.getInt(r13, 0));
        goto L84
    L43:
        if (r13 != R.styleable.ConstraintLayout_Layout_flow_lastHorizontalStyle) goto L46;
        this.mFlow.setLastHorizontalStyle(r11.getInt(r13, 0));
        goto L84
    L46:
        if (r13 != R.styleable.ConstraintLayout_Layout_flow_firstVerticalStyle) goto L49;
        this.mFlow.setFirstVerticalStyle(r11.getInt(r13, 0));
        goto L84
    L49:
        if (r13 != R.styleable.ConstraintLayout_Layout_flow_lastVerticalStyle) goto L52;
        this.mFlow.setLastVerticalStyle(r11.getInt(r13, 0));
        goto L84
    L52:
        if (r13 != R.styleable.ConstraintLayout_Layout_flow_horizontalBias) goto L55;
        this.mFlow.setHorizontalBias(r11.getFloat(r13, 0.5f));
        goto L84
    L55:
        if (r13 != R.styleable.ConstraintLayout_Layout_flow_firstHorizontalBias) goto L58;
        this.mFlow.setFirstHorizontalBias(r11.getFloat(r13, 0.5f));
        goto L84
    L58:
        if (r13 != R.styleable.ConstraintLayout_Layout_flow_lastHorizontalBias) goto L61;
        this.mFlow.setLastHorizontalBias(r11.getFloat(r13, 0.5f));
        goto L84
    L61:
        if (r13 != R.styleable.ConstraintLayout_Layout_flow_firstVerticalBias) goto L64;
        this.mFlow.setFirstVerticalBias(r11.getFloat(r13, 0.5f));
        goto L84
    L64:
        if (r13 != R.styleable.ConstraintLayout_Layout_flow_lastVerticalBias) goto L67;
        this.mFlow.setLastVerticalBias(r11.getFloat(r13, 0.5f));
        goto L84
    L67:
        if (r13 != R.styleable.ConstraintLayout_Layout_flow_verticalBias) goto L70;
        this.mFlow.setVerticalBias(r11.getFloat(r13, 0.5f));
        goto L84
    L70:
        if (r13 != R.styleable.ConstraintLayout_Layout_flow_horizontalAlign) goto L73;
        this.mFlow.setHorizontalAlign(r11.getInt(r13, 2));
        goto L84
    L73:
        if (r13 != R.styleable.ConstraintLayout_Layout_flow_verticalAlign) goto L76;
        this.mFlow.setVerticalAlign(r11.getInt(r13, 2));
        goto L84
    L76:
        if (r13 != R.styleable.ConstraintLayout_Layout_flow_horizontalGap) goto L79;
        this.mFlow.setHorizontalGap(r11.getDimensionPixelSize(r13, 0));
        goto L84
    L79:
        if (r13 != R.styleable.ConstraintLayout_Layout_flow_verticalGap) goto L82;
        this.mFlow.setVerticalGap(r11.getDimensionPixelSize(r13, 0));
        goto L84
    L82:
        if (r13 != R.styleable.ConstraintLayout_Layout_flow_maxElementsWrap) goto L84;
        this.mFlow.setMaxElementsWrap(r11.getInt(r13, -1));
        goto L84
    L85:
        r11.recycle();
    L86:
        this.mHelperWidget = this.mFlow;
        validateParams();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void loadParameters(ConstraintSet.Constraint r5, HelperWidget r10, ConstraintLayout.LayoutParams r11, SparseArray<ConstraintWidget> r12) {
        super.loadParameters(r5, r10, r11, r12);
        if ((r10 instanceof androidx.constraintlayout.solver.widgets.Flow) == false) goto L8;
        androidx.constraintlayout.solver.widgets.Flow r13 = (androidx.constraintlayout.solver.widgets.Flow) r10;
        int r14 = r11.orientation;
        if (r14 == (-1)) goto L9;
        r13.setOrientation(r14);
        return;
    L9:
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    @SuppressLint({"WrongCall"})
    public void onMeasure(int r5, int r10) {
        onMeasure(this.mFlow, r5, r10);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void resolveRtl(ConstraintWidget r5, boolean r10) {
        this.mFlow.applyRtl(r10);
    }

    public void setFirstHorizontalBias(float r5) {
        this.mFlow.setFirstHorizontalBias(r5);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int r5) {
        this.mFlow.setFirstHorizontalStyle(r5);
        requestLayout();
    }

    public void setFirstVerticalBias(float r5) {
        this.mFlow.setFirstVerticalBias(r5);
        requestLayout();
    }

    public void setFirstVerticalStyle(int r5) {
        this.mFlow.setFirstVerticalStyle(r5);
        requestLayout();
    }

    public void setHorizontalAlign(int r5) {
        this.mFlow.setHorizontalAlign(r5);
        requestLayout();
    }

    public void setHorizontalBias(float r5) {
        this.mFlow.setHorizontalBias(r5);
        requestLayout();
    }

    public void setHorizontalGap(int r5) {
        this.mFlow.setHorizontalGap(r5);
        requestLayout();
    }

    public void setHorizontalStyle(int r5) {
        this.mFlow.setHorizontalStyle(r5);
        requestLayout();
    }

    public void setMaxElementsWrap(int r5) {
        this.mFlow.setMaxElementsWrap(r5);
        requestLayout();
    }

    public void setOrientation(int r5) {
        this.mFlow.setOrientation(r5);
        requestLayout();
    }

    public void setPadding(int r5) {
        this.mFlow.setPadding(r5);
        requestLayout();
    }

    public void setPaddingBottom(int r5) {
        this.mFlow.setPaddingBottom(r5);
        requestLayout();
    }

    public void setPaddingLeft(int r5) {
        this.mFlow.setPaddingLeft(r5);
        requestLayout();
    }

    public void setPaddingRight(int r5) {
        this.mFlow.setPaddingRight(r5);
        requestLayout();
    }

    public void setPaddingTop(int r5) {
        this.mFlow.setPaddingTop(r5);
        requestLayout();
    }

    public void setVerticalAlign(int r5) {
        this.mFlow.setVerticalAlign(r5);
        requestLayout();
    }

    public void setVerticalBias(float r5) {
        this.mFlow.setVerticalBias(r5);
        requestLayout();
    }

    public void setVerticalGap(int r5) {
        this.mFlow.setVerticalGap(r5);
        requestLayout();
    }

    public void setVerticalStyle(int r5) {
        this.mFlow.setVerticalStyle(r5);
        requestLayout();
    }

    public void setWrapMode(int r5) {
        this.mFlow.setWrapMode(r5);
        requestLayout();
    }

    public Flow(Context r5, AttributeSet r10) {
        super(r5, r10);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout
    public void onMeasure(androidx.constraintlayout.solver.widgets.VirtualLayout r5, int r10, int r11) {
        int r12 = View.MeasureSpec.getMode(r10);
        int r13 = View.MeasureSpec.getSize(r10);
        int r14 = View.MeasureSpec.getMode(r11);
        int r15 = View.MeasureSpec.getSize(r11);
        if (r5 == null) goto L5;
        r5.measure(r12, r13, r14, r15);
        setMeasuredDimension(r5.getMeasuredWidth(), r5.getMeasuredHeight());
        return;
    L5:
        setMeasuredDimension(0, 0);
    }

    public Flow(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
    }
}
