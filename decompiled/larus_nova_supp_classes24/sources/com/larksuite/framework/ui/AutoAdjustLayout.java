package com.larksuite.framework.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0014J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larksuite/framework/ui/AutoAdjustLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "maxWidthInPixels", "", "maxHeightInPixels", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onViewAdded", "child", "Landroid/view/View;", "common-ui_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AutoAdjustLayout extends FrameLayout {
    public final int a;
    public final int b;

    public AutoAdjustLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View r3) {
        Intrinsics.checkNotNullParameter(r3, "child");
        if (getChildCount() > 1) goto L7;
        super.onViewAdded(r3);
        return;
    L7:
        throw new IllegalStateException("Maximum 1 child");
    }

    public AutoAdjustLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = 1080;
        this.b = 1280;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r10, int r11) {
        View.MeasureSpec.getMode(r10);
        int r0 = View.MeasureSpec.getSize(r10);
        View.MeasureSpec.getMode(r11);
        int r1 = View.MeasureSpec.getSize(r11);
        if (getChildCount() <= 0) goto L11;
        boolean r2 = false;
        View r4 = getChildAt(0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.view.View");
        int r3 = Math.min(r0, this.a);
        if (r3 >= r0) goto L7;
        r2 = true;
    L7:
        if (r2 == false) goto L9;
        int r5 = Math.min(r1, this.b);
    L10:
        measureChildWithMargins(r4, r10, r0 - r3, r11, r1 - r5);
        goto L11
    L9:
        r5 = r1;
    L11:
        setMeasuredDimension(r0, r1);
    }
}
