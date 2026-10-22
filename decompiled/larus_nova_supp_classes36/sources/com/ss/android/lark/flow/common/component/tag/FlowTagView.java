package com.ss.android.lark.flow.common.component.tag;

import ahb.a;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0014J0\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0014J\b\u0010\u001d\u001a\u00020\u0018H\u0002J\u0010\u0010\u001e\u001a\u00020\u00132\b\b\u0001\u0010\u001f\u001a\u00020\u0007J\u000e\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u000bJ\u000e\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*J\u0010\u0010+\u001a\u00020\u00132\b\b\u0001\u0010\u001f\u001a\u00020\u0007J\u000e\u0010,\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/ss/android/lark/flow/common/component/tag/FlowTagView;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tagStyle", "Lcom/ss/android/lark/flow/common/component/tag/FlowTagStyle;", "bgDrawable", "Landroid/graphics/drawable/GradientDrawable;", "iconView", "Landroidx/appcompat/widget/AppCompatImageView;", "textView", "Landroidx/appcompat/widget/AppCompatTextView;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "", "l", "t", "r", "b", "hasIcon", "setTagBackgroundColor", "color", "setTagStyle", "style", "setIcon", "drawable", "Landroid/graphics/drawable/Drawable;", "setText", "str", "", "setTextSize", "textSize", "", "setTextColor", "setTextStyle", "flow-common_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowTagView extends ViewGroup {
    public a a;
    public final GradientDrawable b;
    public final AppCompatImageView c;
    public final AppCompatTextView d;

    public FlowTagView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FlowTagView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final boolean a() {
        if (this.c.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L10:
        return false;
    L8:
        if (this.c.getDrawable() == null) goto L10;
        return true;
    L5:
        r0 = false;
        goto L6
    }

    public final void setIcon(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        this.c.setImageDrawable(r2);
        this.c.setVisibility(0);
        requestLayout();
        invalidate();
    }

    public final void setTagBackgroundColor(int r2) {
        this.b.setColor(r2);
    }

    public final void setTagStyle(a r4) {
        Intrinsics.checkNotNullParameter(r4, "style");
        this.a = r4;
        this.d.setTextSize(2, r4.a);
        int r0 = UIUtils.dp2px(getContext(), r4.b);
        setPaddingRelative(r0, getPaddingTop(), r0, getPaddingBottom());
        this.b.setCornerRadius(UIUtils.dp2px(getContext(), r4.d));
        requestLayout();
        invalidate();
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "str");
        this.d.setText(r2);
        requestLayout();
        invalidate();
    }

    public final void setTextColor(int r2) {
        this.d.setTextColor(r2);
    }

    public final void setTextSize(float r3) {
        this.d.setTextSize(2, r3);
        requestLayout();
        invalidate();
    }

    public final void setTextStyle(int r3) {
        this.d.setTypeface(null, r3);
    }

    @Override // android.view.View
    public final void onMeasure(int r7, int r8) {
        int r0 = UIUtils.dp2px(getContext(), this.a.e);
        int r1 = UIUtils.dp2px(getContext(), this.a.c);
        int r2 = UIUtils.dp2px(getContext(), this.a.f);
        if (a() == false) goto L5;
        int r4 = View.MeasureSpec.makeMeasureSpec(r0, 1073741824);
        int r3 = View.MeasureSpec.makeMeasureSpec(r0, 1073741824);
        this.c.measure(r4, r3);
    L5:
        int r5 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r6 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtLeast((r1 - getPaddingTop()) - getPaddingBottom(), 0), Target.SIZE_ORIGINAL);
        this.d.measure(r5, r6);
        if (a() == false) goto L8;
        int r9 = (this.c.getMeasuredWidth() + r2) + this.d.getMeasuredWidth();
    L9:
        setMeasuredDimension(ViewGroup.resolveSize((getPaddingLeft() + r9) + getPaddingRight(), r7), ViewGroup.resolveSize(r1, r8));
        return;
    L8:
        r9 = this.d.getMeasuredWidth();
        goto L9
    }

    public FlowTagView(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10);
        this.a = new a(0.0f, 0.0f, 0.0f, 0.0f, 63);
        GradientDrawable r11 = new GradientDrawable();
        r11.setShape(0);
        this.b = r11;
        AppCompatImageView r12 = new AppCompatImageView(r8);
        this.c = r12;
        View r0 = new AppCompatTextView(r8);
        this.d = r0;
        setBackground(r11);
        ViewGroup.LayoutParams r13 = new ViewGroup.LayoutParams(-2, -2);
        r12.setVisibility(8);
        addView(r12, r13);
        addView(r0, new ViewGroup.LayoutParams(-2, -2));
        setTagStyle(this.a);
    }

    public /* synthetic */ FlowTagView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        int r8 = getPaddingLeft();
        int r9 = getPaddingTop() + ((((r7 - r5) - getPaddingTop()) - getPaddingBottom()) / 2);
        int r10 = UIUtils.dp2px(getContext(), this.a.f);
        if (a() == false) goto L5;
        int r11 = r9 - (this.c.getMeasuredHeight() / 2);
        int r12 = this.c.getMeasuredHeight() + r11;
        int r0 = this.c.getMeasuredWidth() + r8;
        this.c.layout(r8, r11, r0, r12);
        int r13 = r9 - (this.d.getMeasuredHeight() / 2);
        int r14 = this.d.getMeasuredHeight() + r13;
        int r15 = (r8 + this.c.getMeasuredWidth()) + r10;
        int r16 = this.d.getMeasuredWidth() + r15;
        this.d.layout(r15, r13, r16, r14);
        return;
    L5:
        int r17 = r9 - (this.d.getMeasuredHeight() / 2);
        int r18 = this.d.getMeasuredHeight() + r17;
        int r19 = this.d.getMeasuredWidth() + r8;
        this.d.layout(r8, r17, r19, r18);
    }
}
