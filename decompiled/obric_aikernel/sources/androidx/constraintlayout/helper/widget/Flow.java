package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
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
    private androidx.constraintlayout.core.widgets.Flow mFlow;

    public Flow(Context r10) {
        super(r10);
    }

    public Flow(Context r10, AttributeSet r11) {
        super(r10, r11);
    }

    public Flow(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    protected void init(AttributeSet r10) {
        super.init(r10);
        this.mFlow = new androidx.constraintlayout.core.widgets.Flow();
        if (r10 == null) goto L90;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R.styleable.ConstraintLayout_Layout);
        int r12 = r11.getIndexCount();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L89;
        int r14 = r11.getIndex(r13);
        if (r14 != R.styleable.ConstraintLayout_Layout_android_orientation) goto L10;
        this.mFlow.setOrientation(r11.getInt(r14, 0));
    L88:
        r13 = r13 + 1;
        goto L5
    L10:
        if (r14 != R.styleable.ConstraintLayout_Layout_android_padding) goto L13;
        this.mFlow.setPadding(r11.getDimensionPixelSize(r14, 0));
        goto L88
    L13:
        if (r14 != R.styleable.ConstraintLayout_Layout_android_paddingStart) goto L18;
        if (Build.VERSION.SDK_INT < 17) goto L88;
        this.mFlow.setPaddingStart(r11.getDimensionPixelSize(r14, 0));
        goto L88
    L18:
        if (r14 != R.styleable.ConstraintLayout_Layout_android_paddingEnd) goto L23;
        if (Build.VERSION.SDK_INT < 17) goto L88;
        this.mFlow.setPaddingEnd(r11.getDimensionPixelSize(r14, 0));
        goto L88
    L23:
        if (r14 != R.styleable.ConstraintLayout_Layout_android_paddingLeft) goto L26;
        this.mFlow.setPaddingLeft(r11.getDimensionPixelSize(r14, 0));
        goto L88
    L26:
        if (r14 != R.styleable.ConstraintLayout_Layout_android_paddingTop) goto L29;
        this.mFlow.setPaddingTop(r11.getDimensionPixelSize(r14, 0));
        goto L88
    L29:
        if (r14 != R.styleable.ConstraintLayout_Layout_android_paddingRight) goto L32;
        this.mFlow.setPaddingRight(r11.getDimensionPixelSize(r14, 0));
        goto L88
    L32:
        if (r14 != R.styleable.ConstraintLayout_Layout_android_paddingBottom) goto L35;
        this.mFlow.setPaddingBottom(r11.getDimensionPixelSize(r14, 0));
        goto L88
    L35:
        if (r14 != R.styleable.ConstraintLayout_Layout_flow_wrapMode) goto L38;
        this.mFlow.setWrapMode(r11.getInt(r14, 0));
        goto L88
    L38:
        if (r14 != R.styleable.ConstraintLayout_Layout_flow_horizontalStyle) goto L41;
        this.mFlow.setHorizontalStyle(r11.getInt(r14, 0));
        goto L88
    L41:
        if (r14 != R.styleable.ConstraintLayout_Layout_flow_verticalStyle) goto L44;
        this.mFlow.setVerticalStyle(r11.getInt(r14, 0));
        goto L88
    L44:
        if (r14 != R.styleable.ConstraintLayout_Layout_flow_firstHorizontalStyle) goto L47;
        this.mFlow.setFirstHorizontalStyle(r11.getInt(r14, 0));
        goto L88
    L47:
        if (r14 != R.styleable.ConstraintLayout_Layout_flow_lastHorizontalStyle) goto L50;
        this.mFlow.setLastHorizontalStyle(r11.getInt(r14, 0));
        goto L88
    L50:
        if (r14 != R.styleable.ConstraintLayout_Layout_flow_firstVerticalStyle) goto L53;
        this.mFlow.setFirstVerticalStyle(r11.getInt(r14, 0));
        goto L88
    L53:
        if (r14 != R.styleable.ConstraintLayout_Layout_flow_lastVerticalStyle) goto L56;
        this.mFlow.setLastVerticalStyle(r11.getInt(r14, 0));
        goto L88
    L56:
        if (r14 != R.styleable.ConstraintLayout_Layout_flow_horizontalBias) goto L59;
        this.mFlow.setHorizontalBias(r11.getFloat(r14, 0.5f));
        goto L88
    L59:
        if (r14 != R.styleable.ConstraintLayout_Layout_flow_firstHorizontalBias) goto L62;
        this.mFlow.setFirstHorizontalBias(r11.getFloat(r14, 0.5f));
        goto L88
    L62:
        if (r14 != R.styleable.ConstraintLayout_Layout_flow_lastHorizontalBias) goto L65;
        this.mFlow.setLastHorizontalBias(r11.getFloat(r14, 0.5f));
        goto L88
    L65:
        if (r14 != R.styleable.ConstraintLayout_Layout_flow_firstVerticalBias) goto L68;
        this.mFlow.setFirstVerticalBias(r11.getFloat(r14, 0.5f));
        goto L88
    L68:
        if (r14 != R.styleable.ConstraintLayout_Layout_flow_lastVerticalBias) goto L71;
        this.mFlow.setLastVerticalBias(r11.getFloat(r14, 0.5f));
        goto L88
    L71:
        if (r14 != R.styleable.ConstraintLayout_Layout_flow_verticalBias) goto L74;
        this.mFlow.setVerticalBias(r11.getFloat(r14, 0.5f));
        goto L88
    L74:
        if (r14 != R.styleable.ConstraintLayout_Layout_flow_horizontalAlign) goto L77;
        this.mFlow.setHorizontalAlign(r11.getInt(r14, 2));
        goto L88
    L77:
        if (r14 != R.styleable.ConstraintLayout_Layout_flow_verticalAlign) goto L80;
        this.mFlow.setVerticalAlign(r11.getInt(r14, 2));
        goto L88
    L80:
        if (r14 != R.styleable.ConstraintLayout_Layout_flow_horizontalGap) goto L83;
        this.mFlow.setHorizontalGap(r11.getDimensionPixelSize(r14, 0));
        goto L88
    L83:
        if (r14 != R.styleable.ConstraintLayout_Layout_flow_verticalGap) goto L86;
        this.mFlow.setVerticalGap(r11.getDimensionPixelSize(r14, 0));
        goto L88
    L86:
        if (r14 != R.styleable.ConstraintLayout_Layout_flow_maxElementsWrap) goto L88;
        this.mFlow.setMaxElementsWrap(r11.getInt(r14, -1));
        goto L88
    L89:
        r11.recycle();
    L90:
        this.mHelperWidget = this.mFlow;
        validateParams();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void loadParameters(ConstraintSet.Constraint r10, HelperWidget r11, ConstraintLayout.LayoutParams r12, SparseArray<ConstraintWidget> r13) {
        super.loadParameters(r10, r11, r12, r13);
        if ((r11 instanceof androidx.constraintlayout.core.widgets.Flow) == false) goto L8;
        androidx.constraintlayout.core.widgets.Flow r14 = (androidx.constraintlayout.core.widgets.Flow) r11;
        int r15 = r12.orientation;
        if (r15 == (-1)) goto L9;
        r14.setOrientation(r15);
        return;
    L9:
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    @SuppressLint({"WrongCall"})
    protected void onMeasure(int r10, int r11) {
        onMeasure(this.mFlow, r10, r11);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout
    public void onMeasure(androidx.constraintlayout.core.widgets.VirtualLayout r10, int r11, int r12) {
        int r13 = View.MeasureSpec.getMode(r11);
        int r14 = View.MeasureSpec.getSize(r11);
        int r15 = View.MeasureSpec.getMode(r12);
        int r16 = View.MeasureSpec.getSize(r12);
        if (r10 == null) goto L5;
        r10.measure(r13, r14, r15, r16);
        setMeasuredDimension(r10.getMeasuredWidth(), r10.getMeasuredHeight());
        return;
    L5:
        setMeasuredDimension(0, 0);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void resolveRtl(ConstraintWidget r10, boolean r11) {
        this.mFlow.applyRtl(r11);
    }

    public void setFirstHorizontalBias(float r10) {
        this.mFlow.setFirstHorizontalBias(r10);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int r10) {
        this.mFlow.setFirstHorizontalStyle(r10);
        requestLayout();
    }

    public void setFirstVerticalBias(float r10) {
        this.mFlow.setFirstVerticalBias(r10);
        requestLayout();
    }

    public void setFirstVerticalStyle(int r10) {
        this.mFlow.setFirstVerticalStyle(r10);
        requestLayout();
    }

    public void setHorizontalAlign(int r10) {
        this.mFlow.setHorizontalAlign(r10);
        requestLayout();
    }

    public void setHorizontalBias(float r10) {
        this.mFlow.setHorizontalBias(r10);
        requestLayout();
    }

    public void setHorizontalGap(int r10) {
        this.mFlow.setHorizontalGap(r10);
        requestLayout();
    }

    public void setHorizontalStyle(int r10) {
        this.mFlow.setHorizontalStyle(r10);
        requestLayout();
    }

    public void setLastHorizontalBias(float r10) {
        this.mFlow.setLastHorizontalBias(r10);
        requestLayout();
    }

    public void setLastHorizontalStyle(int r10) {
        this.mFlow.setLastHorizontalStyle(r10);
        requestLayout();
    }

    public void setLastVerticalBias(float r10) {
        this.mFlow.setLastVerticalBias(r10);
        requestLayout();
    }

    public void setLastVerticalStyle(int r10) {
        this.mFlow.setLastVerticalStyle(r10);
        requestLayout();
    }

    public void setMaxElementsWrap(int r10) {
        this.mFlow.setMaxElementsWrap(r10);
        requestLayout();
    }

    public void setOrientation(int r10) {
        this.mFlow.setOrientation(r10);
        requestLayout();
    }

    public void setPadding(int r10) {
        this.mFlow.setPadding(r10);
        requestLayout();
    }

    public void setPaddingBottom(int r10) {
        this.mFlow.setPaddingBottom(r10);
        requestLayout();
    }

    public void setPaddingLeft(int r10) {
        this.mFlow.setPaddingLeft(r10);
        requestLayout();
    }

    public void setPaddingRight(int r10) {
        this.mFlow.setPaddingRight(r10);
        requestLayout();
    }

    public void setPaddingTop(int r10) {
        this.mFlow.setPaddingTop(r10);
        requestLayout();
    }

    public void setVerticalAlign(int r10) {
        this.mFlow.setVerticalAlign(r10);
        requestLayout();
    }

    public void setVerticalBias(float r10) {
        this.mFlow.setVerticalBias(r10);
        requestLayout();
    }

    public void setVerticalGap(int r10) {
        this.mFlow.setVerticalGap(r10);
        requestLayout();
    }

    public void setVerticalStyle(int r10) {
        this.mFlow.setVerticalStyle(r10);
        requestLayout();
    }

    public void setWrapMode(int r10) {
        this.mFlow.setWrapMode(r10);
        requestLayout();
    }
}
