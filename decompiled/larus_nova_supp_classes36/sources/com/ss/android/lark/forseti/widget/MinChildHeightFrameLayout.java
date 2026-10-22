package com.ss.android.lark.forseti.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0014¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/forseti/widget/MinChildHeightFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class MinChildHeightFrameLayout extends FrameLayout {
    public MinChildHeightFrameLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public MinChildHeightFrameLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r4, int r5) {
        super.onMeasure(r4, r5);
        if (getChildCount() < 2) goto L10;
        View r6 = getChildAt(getChildCount() - 1);
        int r7 = getChildCount() - 1;
        int r0 = 0;
        int r1 = 0;
    L5:
        if (r0 >= r7) goto L7;
        r1 = Math.max(r1, getChildAt(r0).getMeasuredHeight());
        r0 = r0 + 1;
        goto L5
    L7:
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight() - (r1 - r6.getMeasuredHeight()));
        return;
    }
}
