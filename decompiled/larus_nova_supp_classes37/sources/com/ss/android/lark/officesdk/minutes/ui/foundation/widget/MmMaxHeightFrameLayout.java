package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0014J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0002R$\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmMaxHeightFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "maxHeightPx", "getMaxHeightPx", "()I", "setMaxHeightPx", "(I)V", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "constrainHeightSpec", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public class MmMaxHeightFrameLayout extends FrameLayout {
    public int a;

    public MmMaxHeightFrameLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MmMaxHeightFrameLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final int getMaxHeightPx() {
        return this.a;
    }

    public final void setMaxHeightPx(int r2) {
        Integer r3 = Integer.valueOf(r2);
        if (r3.intValue() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r3 = null;
    L9:
        if (r3 == null) goto L11;
        int r4 = r3.intValue();
    L13:
        if (this.a != r4) goto L15;
        return;
    L15:
        this.a = r4;
        requestLayout();
        return;
    L11:
        r4 = Integer.MAX_VALUE;
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r4, int r5) {
        if (this.a == Integer.MAX_VALUE) goto L14;
        int r0 = View.MeasureSpec.getMode(r5);
        int r1 = View.MeasureSpec.getSize(r5);
        if (r0 == Integer.MIN_VALUE) goto L13;
        if (r0 != 0) goto L9;
        r5 = View.MeasureSpec.makeMeasureSpec(this.a, Integer.MIN_VALUE);
        goto L14
    L9:
        if (r0 != 1073741824) goto L14;
        r5 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtMost(r1, this.a), 1073741824);
        goto L14
    L13:
        r5 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtMost(r1, this.a), Integer.MIN_VALUE);
    L14:
        super.onMeasure(r4, r5);
    }

    public MmMaxHeightFrameLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = Integer.MAX_VALUE;
    }

    public /* synthetic */ MmMaxHeightFrameLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
