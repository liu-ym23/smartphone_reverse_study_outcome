package com.obric.oui.common.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/common/widget/MaxHeightNestedScrollView;", "Landroidx/core/widget/NestedScrollView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "maxHeight", "", "setMaxHeight", "(I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MaxHeightNestedScrollView extends NestedScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12523a;

    @JvmOverloads
    public MaxHeightNestedScrollView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r5, int r10) {
        if (this.f12523a == Integer.MAX_VALUE) goto L5;
        int r11 = View.MeasureSpec.getMode(r10);
        r10 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtMost(View.MeasureSpec.getSize(r10), this.f12523a), r11);
    L5:
        super.onMeasure(r5, r10);
        if (getMeasuredHeight() <= this.f12523a) goto L9;
        setMeasuredDimension(getMeasuredWidth(), this.f12523a);
        return;
    }

    public final void setMaxHeight(int r5) {
        if (this.f12523a != r5) goto L5;
        return;
    L5:
        this.f12523a = r5;
        requestLayout();
    }

    @JvmOverloads
    public MaxHeightNestedScrollView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ MaxHeightNestedScrollView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public MaxHeightNestedScrollView(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.f12523a = Integer.MAX_VALUE;
        if (r10 == null) goto L6;
        TypedArray r12 = r5.obtainStyledAttributes(r10, new int[]{R.attr.maxHeight});
        this.f12523a = r12.getDimensionPixelSize(0, Integer.MAX_VALUE);
        r12.recycle();
        return;
    }
}
