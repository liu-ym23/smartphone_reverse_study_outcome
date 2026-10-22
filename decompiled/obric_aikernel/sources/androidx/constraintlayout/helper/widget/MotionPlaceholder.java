package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.Placeholder;
import androidx.constraintlayout.widget.VirtualLayout;

/* JADX INFO: loaded from: classes.dex */
public class MotionPlaceholder extends VirtualLayout {
    private static final String TAG = "MotionPlaceholder";
    Placeholder mPlaceholder;

    public MotionPlaceholder(Context r10) {
        super(r10);
    }

    public MotionPlaceholder(Context r10, AttributeSet r11) {
        super(r10, r11);
    }

    public MotionPlaceholder(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
    }

    public MotionPlaceholder(Context r10, AttributeSet r11, int r12, int r13) {
        super(r10, r11, r12);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    protected void init(AttributeSet r10) {
        super.init(r10);
        this.mHelperWidget = new Placeholder();
        validateParams();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    @SuppressLint({"WrongCall"})
    protected void onMeasure(int r10, int r11) {
        onMeasure(this.mPlaceholder, r10, r11);
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
    public void updatePreLayout(ConstraintWidgetContainer r10, Helper r11, SparseArray<ConstraintWidget> r12) {
    }
}
