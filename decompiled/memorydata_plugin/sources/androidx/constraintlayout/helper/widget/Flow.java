package androidx.constraintlayout.helper.widget;

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
import androidx.constraintlayout.widget.VirtualLayout;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

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

    public Flow(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    public Flow(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    public Flow(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), r5);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet r9) {
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.memorydata.plugin");
        super.init(r10);
        this.mFlow = new androidx.constraintlayout.core.widgets.Flow();
        if (r10 == null) goto L90;
        TypedArray r11 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(r10, R.styleable.ConstraintLayout_Layout);
        int r0 = r11.getIndexCount();
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L89;
        int r3 = r11.getIndex(r2);
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_orientation, "styleable", "ConstraintLayout_Layout_android_orientation")) goto L10;
        this.mFlow.setOrientation(r11.getInt(r3, 0));
    L88:
        r2 = r2 + 1;
        goto L5
    L10:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_padding, "styleable", "ConstraintLayout_Layout_android_padding")) goto L13;
        this.mFlow.setPadding(r11.getDimensionPixelSize(r3, 0));
        goto L88
    L13:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_paddingStart, "styleable", "ConstraintLayout_Layout_android_paddingStart")) goto L18;
        if (Build.VERSION.SDK_INT < 17) goto L88;
        this.mFlow.setPaddingStart(r11.getDimensionPixelSize(r3, 0));
        goto L88
    L18:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_paddingEnd, "styleable", "ConstraintLayout_Layout_android_paddingEnd")) goto L23;
        if (Build.VERSION.SDK_INT < 17) goto L88;
        this.mFlow.setPaddingEnd(r11.getDimensionPixelSize(r3, 0));
        goto L88
    L23:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_paddingLeft, "styleable", "ConstraintLayout_Layout_android_paddingLeft")) goto L26;
        this.mFlow.setPaddingLeft(r11.getDimensionPixelSize(r3, 0));
        goto L88
    L26:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_paddingTop, "styleable", "ConstraintLayout_Layout_android_paddingTop")) goto L29;
        this.mFlow.setPaddingTop(r11.getDimensionPixelSize(r3, 0));
        goto L88
    L29:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_paddingRight, "styleable", "ConstraintLayout_Layout_android_paddingRight")) goto L32;
        this.mFlow.setPaddingRight(r11.getDimensionPixelSize(r3, 0));
        goto L88
    L32:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_paddingBottom, "styleable", "ConstraintLayout_Layout_android_paddingBottom")) goto L35;
        this.mFlow.setPaddingBottom(r11.getDimensionPixelSize(r3, 0));
        goto L88
    L35:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_wrapMode, "styleable", "ConstraintLayout_Layout_flow_wrapMode")) goto L38;
        this.mFlow.setWrapMode(r11.getInt(r3, 0));
        goto L88
    L38:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_horizontalStyle, "styleable", "ConstraintLayout_Layout_flow_horizontalStyle")) goto L41;
        this.mFlow.setHorizontalStyle(r11.getInt(r3, 0));
        goto L88
    L41:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_verticalStyle, "styleable", "ConstraintLayout_Layout_flow_verticalStyle")) goto L44;
        this.mFlow.setVerticalStyle(r11.getInt(r3, 0));
        goto L88
    L44:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_firstHorizontalStyle, "styleable", "ConstraintLayout_Layout_flow_firstHorizontalStyle")) goto L47;
        this.mFlow.setFirstHorizontalStyle(r11.getInt(r3, 0));
        goto L88
    L47:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_lastHorizontalStyle, "styleable", "ConstraintLayout_Layout_flow_lastHorizontalStyle")) goto L50;
        this.mFlow.setLastHorizontalStyle(r11.getInt(r3, 0));
        goto L88
    L50:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_firstVerticalStyle, "styleable", "ConstraintLayout_Layout_flow_firstVerticalStyle")) goto L53;
        this.mFlow.setFirstVerticalStyle(r11.getInt(r3, 0));
        goto L88
    L53:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_lastVerticalStyle, "styleable", "ConstraintLayout_Layout_flow_lastVerticalStyle")) goto L56;
        this.mFlow.setLastVerticalStyle(r11.getInt(r3, 0));
        goto L88
    L56:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_horizontalBias, "styleable", "ConstraintLayout_Layout_flow_horizontalBias")) goto L59;
        this.mFlow.setHorizontalBias(r11.getFloat(r3, 0.5f));
        goto L88
    L59:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_firstHorizontalBias, "styleable", "ConstraintLayout_Layout_flow_firstHorizontalBias")) goto L62;
        this.mFlow.setFirstHorizontalBias(r11.getFloat(r3, 0.5f));
        goto L88
    L62:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_lastHorizontalBias, "styleable", "ConstraintLayout_Layout_flow_lastHorizontalBias")) goto L65;
        this.mFlow.setLastHorizontalBias(r11.getFloat(r3, 0.5f));
        goto L88
    L65:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_firstVerticalBias, "styleable", "ConstraintLayout_Layout_flow_firstVerticalBias")) goto L68;
        this.mFlow.setFirstVerticalBias(r11.getFloat(r3, 0.5f));
        goto L88
    L68:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_lastVerticalBias, "styleable", "ConstraintLayout_Layout_flow_lastVerticalBias")) goto L71;
        this.mFlow.setLastVerticalBias(r11.getFloat(r3, 0.5f));
        goto L88
    L71:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_verticalBias, "styleable", "ConstraintLayout_Layout_flow_verticalBias")) goto L74;
        this.mFlow.setVerticalBias(r11.getFloat(r3, 0.5f));
        goto L88
    L74:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_horizontalAlign, "styleable", "ConstraintLayout_Layout_flow_horizontalAlign")) goto L77;
        this.mFlow.setHorizontalAlign(r11.getInt(r3, 2));
        goto L88
    L77:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_verticalAlign, "styleable", "ConstraintLayout_Layout_flow_verticalAlign")) goto L80;
        this.mFlow.setVerticalAlign(r11.getInt(r3, 2));
        goto L88
    L80:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_horizontalGap, "styleable", "ConstraintLayout_Layout_flow_horizontalGap")) goto L83;
        this.mFlow.setHorizontalGap(r11.getDimensionPixelSize(r3, 0));
        goto L88
    L83:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_verticalGap, "styleable", "ConstraintLayout_Layout_flow_verticalGap")) goto L86;
        this.mFlow.setVerticalGap(r11.getDimensionPixelSize(r3, 0));
        goto L88
    L86:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_flow_maxElementsWrap, "styleable", "ConstraintLayout_Layout_flow_maxElementsWrap")) goto L88;
        this.mFlow.setMaxElementsWrap(r11.getInt(r3, -1));
        goto L88
    L89:
        r11.recycle();
    L90:
        this.mHelperWidget = this.mFlow;
        validateParams();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void loadParameters(ConstraintSet.Constraint r1, HelperWidget r2, ConstraintLayout.LayoutParams r3, SparseArray<ConstraintWidget> r4) {
        super.loadParameters(r1, r2, r3, r4);
        if (ZeusTransformUtils.instanceOf(r2, androidx.constraintlayout.core.widgets.Flow.class) == false) goto L8;
        androidx.constraintlayout.core.widgets.Flow r0 = (androidx.constraintlayout.core.widgets.Flow) ZeusTransformUtils.preCheckCast(r2, androidx.constraintlayout.core.widgets.Flow.class, "com.obric.memorydata.plugin");
        if (r3.orientation == (-1)) goto L9;
        r0.setOrientation(r3.orientation);
        return;
    L9:
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onMeasure(int r2, int r3) {
        onMeasure(this.mFlow, r2, r3);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout
    public void onMeasure(androidx.constraintlayout.core.widgets.VirtualLayout r3, int r4, int r5) {
        int r0 = View.MeasureSpec.getMode(r4);
        int r6 = View.MeasureSpec.getSize(r4);
        int r1 = View.MeasureSpec.getMode(r5);
        int r7 = View.MeasureSpec.getSize(r5);
        if (r3 == null) goto L5;
        r3.measure(r0, r6, r1, r7);
        setMeasuredDimension(r3.getMeasuredWidth(), r3.getMeasuredHeight());
        return;
    L5:
        setMeasuredDimension(0, 0);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void resolveRtl(ConstraintWidget r1, boolean r2) {
        this.mFlow.applyRtl(r2);
    }

    public void setFirstHorizontalBias(float r2) {
        this.mFlow.setFirstHorizontalBias(r2);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int r2) {
        this.mFlow.setFirstHorizontalStyle(r2);
        requestLayout();
    }

    public void setFirstVerticalBias(float r2) {
        this.mFlow.setFirstVerticalBias(r2);
        requestLayout();
    }

    public void setFirstVerticalStyle(int r2) {
        this.mFlow.setFirstVerticalStyle(r2);
        requestLayout();
    }

    public void setHorizontalAlign(int r2) {
        this.mFlow.setHorizontalAlign(r2);
        requestLayout();
    }

    public void setHorizontalBias(float r2) {
        this.mFlow.setHorizontalBias(r2);
        requestLayout();
    }

    public void setHorizontalGap(int r2) {
        this.mFlow.setHorizontalGap(r2);
        requestLayout();
    }

    public void setHorizontalStyle(int r2) {
        this.mFlow.setHorizontalStyle(r2);
        requestLayout();
    }

    public void setLastHorizontalBias(float r2) {
        this.mFlow.setLastHorizontalBias(r2);
        requestLayout();
    }

    public void setLastHorizontalStyle(int r2) {
        this.mFlow.setLastHorizontalStyle(r2);
        requestLayout();
    }

    public void setLastVerticalBias(float r2) {
        this.mFlow.setLastVerticalBias(r2);
        requestLayout();
    }

    public void setLastVerticalStyle(int r2) {
        this.mFlow.setLastVerticalStyle(r2);
        requestLayout();
    }

    public void setMaxElementsWrap(int r2) {
        this.mFlow.setMaxElementsWrap(r2);
        requestLayout();
    }

    public void setOrientation(int r2) {
        this.mFlow.setOrientation(r2);
        requestLayout();
    }

    public void setPadding(int r2) {
        this.mFlow.setPadding(r2);
        requestLayout();
    }

    public void setPaddingBottom(int r2) {
        this.mFlow.setPaddingBottom(r2);
        requestLayout();
    }

    public void setPaddingLeft(int r2) {
        this.mFlow.setPaddingLeft(r2);
        requestLayout();
    }

    public void setPaddingRight(int r2) {
        this.mFlow.setPaddingRight(r2);
        requestLayout();
    }

    public void setPaddingTop(int r2) {
        this.mFlow.setPaddingTop(r2);
        requestLayout();
    }

    public void setVerticalAlign(int r2) {
        this.mFlow.setVerticalAlign(r2);
        requestLayout();
    }

    public void setVerticalBias(float r2) {
        this.mFlow.setVerticalBias(r2);
        requestLayout();
    }

    public void setVerticalGap(int r2) {
        this.mFlow.setVerticalGap(r2);
        requestLayout();
    }

    public void setVerticalStyle(int r2) {
        this.mFlow.setVerticalStyle(r2);
        requestLayout();
    }

    public void setWrapMode(int r2) {
        this.mFlow.setWrapMode(r2);
        requestLayout();
    }
}
