package com.obric.oui.common.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\r"}, d2 = {"Lcom/obric/oui/common/widget/MaxHeightNestedScrollView;", "Landroidx/core/widget/NestedScrollView;", "", "maxHeight", "", "setMaxHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class MaxHeightNestedScrollView extends NestedScrollView {
    public int a;

    public MaxHeightNestedScrollView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MaxHeightNestedScrollView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setMaxHeight(int r2) {
        if (this.a != r2) goto L5;
        return;
    L5:
        this.a = r2;
        requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r3, int r4) {
        if (this.a == Integer.MAX_VALUE) goto L5;
        int r0 = View.MeasureSpec.getMode(r4);
        r4 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtMost(View.MeasureSpec.getSize(r4), this.a), r0);
    L5:
        super.onMeasure(r3, r4);
        if (getMeasuredHeight() <= this.a) goto L9;
        setMeasuredDimension(getMeasuredWidth(), this.a);
        return;
    }

    public MaxHeightNestedScrollView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.a = Integer.MAX_VALUE;
        if (r5 == null) goto L6;
        TypedArray r7 = r4.obtainStyledAttributes(r5, new int[]{R.attr.maxHeight});
        this.a = r7.getDimensionPixelSize(0, Integer.MAX_VALUE);
        r7.recycle();
        return;
    }

    public /* synthetic */ MaxHeightNestedScrollView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
