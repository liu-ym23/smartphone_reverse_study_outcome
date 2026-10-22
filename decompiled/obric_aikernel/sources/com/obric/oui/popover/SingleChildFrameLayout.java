package com.obric.oui.popover;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.obric.oui.layout.OUIFrameLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/oui/popover/SingleChildFrameLayout;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class SingleChildFrameLayout extends OUIFrameLayout {
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public SingleChildFrameLayout(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public SingleChildFrameLayout(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, 0, null, 12, null);
    }

    public /* synthetic */ SingleChildFrameLayout(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        View r12 = getChildAt(0);
        if (r12 == null) goto L14;
        int r13 = View.MeasureSpec.getMode(r10);
        int r14 = View.MeasureSpec.getSize(r10);
        int r15 = View.MeasureSpec.getMode(r11);
        int r16 = View.MeasureSpec.getSize(r11);
        int r17 = (r12.getMeasuredWidth() + getPaddingLeft()) + getPaddingRight();
        int r18 = (r12.getMeasuredHeight() + getPaddingTop()) + getPaddingBottom();
        if (r13 != Integer.MIN_VALUE) goto L8;
        if (r15 != Integer.MIN_VALUE) goto L8;
        setMeasuredDimension(r17, r18);
        return;
    L8:
        if (r13 != Integer.MIN_VALUE) goto L10;
        setMeasuredDimension(r17, r16);
        return;
    L10:
        if (r15 != Integer.MIN_VALUE) goto L12;
        setMeasuredDimension(r14, r18);
        return;
    L12:
        setMeasuredDimension(r14, r16);
        return;
    }
}
