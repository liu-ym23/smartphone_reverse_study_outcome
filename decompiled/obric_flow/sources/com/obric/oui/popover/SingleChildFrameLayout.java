package com.obric.oui.popover;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.obric.oui.layout.OUIFrameLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/oui/popover/SingleChildFrameLayout;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SingleChildFrameLayout extends OUIFrameLayout {
    @JvmOverloads
    public SingleChildFrameLayout(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        View r5 = getChildAt(0);
        if (r5 != null) goto L5;
        return;
    L5:
        int r12 = View.MeasureSpec.getMode(r10);
        int r13 = View.MeasureSpec.getSize(r10);
        int r14 = View.MeasureSpec.getMode(r11);
        int r15 = View.MeasureSpec.getSize(r11);
        int r16 = r5.getMeasuredWidth();
        int r17 = getPaddingLeft() + r16;
        int r18 = getPaddingRight() + r17;
        int r19 = r5.getMeasuredHeight();
        int r20 = getPaddingTop() + r19;
        int r21 = getPaddingBottom() + r20;
        if (r12 != Integer.MIN_VALUE) goto L9;
        if (r14 != Integer.MIN_VALUE) goto L9;
        setMeasuredDimension(r18, r21);
        return;
    L9:
        if (r12 != Integer.MIN_VALUE) goto L11;
        setMeasuredDimension(r18, r15);
        return;
    L11:
        if (r14 != Integer.MIN_VALUE) goto L13;
        setMeasuredDimension(r13, r21);
        return;
    L13:
        setMeasuredDimension(r13, r15);
    }

    @JvmOverloads
    public SingleChildFrameLayout(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, 0, 12);
    }
}
