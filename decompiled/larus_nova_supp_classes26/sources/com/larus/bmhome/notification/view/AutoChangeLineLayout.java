package com.larus.bmhome.notification.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J0\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nH\u0014J\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/notification/view/AutoChangeLineLayout;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "spacingHorizontal", "", "spacingVertical", "init", "", "onLayout", "changed", "", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoChangeLineLayout extends ViewGroup {
    public float a;
    public float b;

    public AutoChangeLineLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        a(r2, null);
    }

    public AutoChangeLineLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        a(r2, r3);
    }

    public final void a(Context r2, AttributeSet r3) {
        TypedArray r4 = r2.obtainStyledAttributes(r3, new int[]{2130972303, 2130972304});
        this.b = r4.getDimension(1, this.b);
        this.a = r4.getDimension(0, this.a);
        r4.recycle();
    }

    @Override // android.view.View
    public final void onMeasure(int r10, int r11) {
        int r0 = View.MeasureSpec.getSize(r10);
        int r1 = (r0 - getPaddingLeft()) - getPaddingRight();
        int r2 = getChildCount();
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        int r6 = 1;
    L3:
        if (r3 >= r2) goto L9;
        View r7 = getChildAt(r3);
        measureChild(r7, r10, r11);
        int r8 = r7.getMeasuredWidth();
        int r9 = r7.getMeasuredHeight();
        int r12 = r5 + r8;
        if (r12 <= r1) goto L7;
        r6 = r6 + 1;
    L8:
        r5 = ((int) this.a) + r8;
        r4 = (((r9 * r6) + ((r6 - 1) * ((int) this.b))) + getPaddingTop()) + getPaddingBottom();
        r3 = r3 + 1;
        goto L3
    L7:
        r8 = r12;
        goto L8
    L9:
        setMeasuredDimension(r0, r4);
    }

    public AutoChangeLineLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        a(r2, r3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
        int r12 = (r10 - r8) - getPaddingRight();
        int r13 = getPaddingLeft();
        int r14 = getChildCount();
        int r15 = 1;
        int r16 = 0;
    L3:
        if (r16 >= r14) goto L8;
        View r0 = getChildAt(r16);
        int r1 = r0.getMeasuredWidth();
        int r2 = r0.getMeasuredHeight();
        int r17 = r13 + r1;
        if (r17 <= r12) goto L7;
        r17 = getPaddingLeft() + r1;
        r15 = r15 + 1;
    L7:
        int r3 = ((r15 * r2) + ((r15 - 1) * ((int) this.b))) + getPaddingTop();
        r0.layout(r17 - r1, r3 - r2, r17, r3);
        r13 = r17 + ((int) this.a);
        r16 = r16 + 1;
        goto L3
    }
}
