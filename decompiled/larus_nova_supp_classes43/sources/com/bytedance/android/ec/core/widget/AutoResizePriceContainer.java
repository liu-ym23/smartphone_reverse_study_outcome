package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/core/widget/AutoResizePriceContainer;", "Landroid/widget/RelativeLayout;", "", "width", "", "setMaxWidth", "", "enable", "setIsMeasureChildFullWidth", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AutoResizePriceContainer extends RelativeLayout {
    public int a;
    public int b;
    public boolean c;

    public AutoResizePriceContainer(Context r10) {
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public AutoResizePriceContainer(Context r10, AttributeSet r11) {
        this(r10, r11, 4, 0);
    }

    public final void setIsMeasureChildFullWidth(boolean r1) {
        this.c = r1;
    }

    public final void setMaxWidth(int r1) {
        this.a = r1;
        requestLayout();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r17, int r18) {
        if (this.a > 0) goto L5;
    L9:
        super.onMeasure(r17, r18);
    L11:
        if (getChildCount() >= 1) goto L13;
        return;
    L13:
        int r10 = getChildCount();
        int r11 = 0;
        int r12 = 0;
    L14:
        if (r11 >= r10) goto L27;
        View r13 = getChildAt(r11);
        if (r13.getVisibility() != 0) goto L26;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if ((r14 instanceof ViewGroup.MarginLayoutParams) == true) goto L20;
        ViewGroup.LayoutParams r15 = null;
    L21:
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        if (r16 == null) goto L24;
        int r19 = r16.leftMargin + r16.rightMargin;
    L25:
        r12 = r12 + (r13.getMeasuredWidth() + r19);
        goto L26
    L24:
        r19 = 0;
        goto L25
    L20:
        r15 = r14;
    L26:
        r11 = r11 + 1;
        goto L14
    L27:
        int r20 = getMeasuredWidth();
        if (getMeasuredWidth() < r12) goto L31;
        r12 = r20;
    L31:
        int r21 = this.a;
        if (r21 <= 0) goto L87;
        if (1 > r12) goto L35;
        if (r21 < r12) goto L35;
        return;
    L35:
        int r22 = this.b;
        if (1 > r22) goto L40;
        if (r21 < r22) goto L40;
        return;
    L40:
        float r23 = (r21 * 1.0f) / r12;
        int r24 = getChildCount();
        this.b = 0;
        int r25 = 0;
    L41:
        if (r25 >= r24) goto L96;
        View r26 = getChildAt(r25);
        if (r26.getVisibility() != 0) goto L86;
        ViewGroup.LayoutParams r27 = r26.getLayoutParams();
        if (r27.width == (-1)) goto L47;
    L49:
        int r28 = View.MeasureSpec.getMode(r17);
        int r110 = View.MeasureSpec.getSize(r17);
        if (r28 == 1073741824) goto L53;
        r110 = this.a;
    L53:
        setMeasuredDimension(r110, r18);
        boolean r29 = r26 instanceof i;
        if (r29 == true) goto L56;
        Object r111 = null;
    L57:
        i r112 = (i) r111;
        if (r112 == null) goto L60;
        r112.setMaxWidth(r26.getMeasuredWidth() * r23);
    L60:
        boolean r113 = r26 instanceof AutoResizePriceContainer;
        if (r113 == true) goto L63;
        View r114 = null;
    L64:
        AutoResizePriceContainer r115 = (AutoResizePriceContainer) r114;
        if (r115 == null) goto L67;
        r115.setMaxWidth((int) (((AutoResizePriceContainer) r26).getMeasuredWidth() * r23));
    L67:
        ViewGroup.LayoutParams r116 = r26.getLayoutParams();
        if ((r116 instanceof ViewGroup.MarginLayoutParams) == true) goto L70;
        r116 = null;
    L70:
        ViewGroup.MarginLayoutParams r117 = (ViewGroup.MarginLayoutParams) r116;
        if (r117 == null) goto L73;
        r117.leftMargin = (int) (r117.leftMargin * r23);
        r117.rightMargin = (int) (r117.rightMargin * r23);
        r26.setLayoutParams(r117);
    L73:
        r26.setPadding((int) (r26.getPaddingLeft() * r23), r26.getPaddingTop(), (int) (r26.getPaddingRight() * r23), r26.getPaddingBottom());
        int r30 = r27.height;
        if (r30 != (-1)) goto L76;
        int r31 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtLeast(0, getMeasuredHeight()), 1073741824);
    L78:
        if (r27.width != (-1)) goto L80;
        r26.measure(View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtLeast(0, getMeasuredWidth()), 1073741824), r31);
        goto L86
    L80:
        if (r113 == true) goto L84;
        if (r29 == true) goto L84;
        r26.measure(RelativeLayout.getChildMeasureSpec(r17, 0, (int) (r26.getMeasuredWidth() * r23)), r31);
    L84:
        this.b += (int) (r26.getMeasuredWidth() * r23);
        goto L86
    L76:
        r31 = RelativeLayout.getChildMeasureSpec(r18, 0, r30);
        goto L78
    L63:
        r114 = r26;
        goto L64
    L56:
        r111 = r26;
        goto L57
    L47:
        if (r27.height != (-1)) goto L49;
    L86:
        r25 = r25 + 1;
        goto L41
    L96:
        return;
    L87:
        return;
    L5:
        if (this.c == false) goto L9;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE), r18);
        int r32 = View.MeasureSpec.getSize(r17);
        if (getMeasuredWidth() <= r32) goto L11;
        setMeasuredDimension(r32, getMeasuredHeight());
        goto L11
    }

    public AutoResizePriceContainer(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
    }

    public /* synthetic */ AutoResizePriceContainer(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }
}
