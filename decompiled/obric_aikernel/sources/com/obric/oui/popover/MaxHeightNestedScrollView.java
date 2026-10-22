package com.obric.oui.popover;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import u8.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/popover/MaxHeightNestedScrollView;", "Landroidx/core/widget/NestedScrollView;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "maxHeightPx", "I", "bottomPaddingPx", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class MaxHeightNestedScrollView extends NestedScrollView {
    private final int bottomPaddingPx;
    private int maxHeightPx;

    @JvmOverloads
    public MaxHeightNestedScrollView(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public MaxHeightNestedScrollView(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public MaxHeightNestedScrollView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.maxHeightPx = Integer.MAX_VALUE;
        this.bottomPaddingPx = getResources().getDimensionPixelSize(d.oui_p_container_tiny_2) * 2;
        if (r11 == null) goto L6;
        TypedArray r13 = r10.obtainStyledAttributes(r11, new int[]{R.attr.maxHeight});
        Intrinsics.checkNotNullExpressionValue(r13, "context.obtainStyledAttr…ndroid.R.attr.maxHeight))");
        this.maxHeightPx = r13.getDimensionPixelSize(0, Integer.MAX_VALUE);
        r13.recycle();
        return;
    }

    public /* synthetic */ MaxHeightNestedScrollView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        if (this.maxHeightPx == Integer.MAX_VALUE) goto L5;
        r11 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtMost(View.MeasureSpec.getSize(r11), this.maxHeightPx), View.MeasureSpec.getMode(r11));
    L5:
        super.onMeasure(r10, r11);
        int r12 = 0;
        View r13 = getChildAt(0);
        if (r13 == null) goto L8;
        int r14 = r13.getMeasuredHeight();
    L9:
        int r15 = this.maxHeightPx;
        int r16 = this.bottomPaddingPx;
        if (r14 <= (r15 - r16)) goto L12;
        boolean r17 = true;
    L13:
        if (r17 == false) goto L16;
        r12 = Math.min(r16, Math.abs(r14 - r15));
    L16:
        if (getPaddingBottom() == r12) goto L19;
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), r12);
        return;
    L19:
        return;
    L12:
        r17 = false;
        goto L13
    L8:
        r14 = 0;
        goto L9
    }
}
