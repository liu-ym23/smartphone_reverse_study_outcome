package com.ss.android.lark.flow.feed.component.tag;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u0000 *2\u00020\u0001:\u0001*B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0014J0\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0014J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\u0010\u0010\u001c\u001a\u00020\u00112\b\b\u0001\u0010\u001d\u001a\u00020\u0007J\u000e\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&J\u0010\u0010'\u001a\u00020\u00112\b\b\u0001\u0010\u001d\u001a\u00020\u0007J\u000e\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/ss/android/lark/flow/feed/component/tag/FlowTagView;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgDrawable", "Landroid/graphics/drawable/GradientDrawable;", "iconView", "Landroidx/appcompat/widget/AppCompatImageView;", "textView", "Landroidx/appcompat/widget/AppCompatTextView;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "", "l", "t", "r", "b", "hasIcon", "setTagBackgroundColor", "color", "setIcon", "drawable", "Landroid/graphics/drawable/Drawable;", "setText", "str", "", "setTextSize", "textSize", "", "setTextColor", "setTextStyle", "style", "Companion", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowTagView extends ViewGroup {
    public final GradientDrawable a;
    public final AppCompatImageView b;
    public final AppCompatTextView c;

    public static final class a {
    }

    static {
    }

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
        if (this.b.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L10:
        return false;
    L8:
        if (this.b.getDrawable() == null) goto L10;
        return true;
    L5:
        r0 = false;
        goto L6
    }

    public final void setIcon(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        this.b.setImageDrawable(r2);
        this.b.setVisibility(0);
        requestLayout();
        invalidate();
    }

    public final void setTagBackgroundColor(int r2) {
        this.a.setColor(r2);
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "str");
        this.c.setText(r2);
        requestLayout();
        invalidate();
    }

    public final void setTextColor(int r2) {
        this.c.setTextColor(r2);
    }

    public final void setTextSize(float r3) {
        this.c.setTextSize(2, r3);
        requestLayout();
        invalidate();
    }

    public final void setTextStyle(int r3) {
        this.c.setTypeface(null, r3);
    }

    @Override // android.view.View
    public final void onMeasure(int r5, int r6) {
        if (a() == false) goto L5;
        int r1 = View.MeasureSpec.makeMeasureSpec(UIHelper.dp2px(12.0f), 1073741824);
        int r0 = View.MeasureSpec.makeMeasureSpec(UIHelper.dp2px(12.0f), 1073741824);
        this.b.measure(r1, r0);
    L5:
        int r2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r3 = View.MeasureSpec.makeMeasureSpec(UIHelper.dp2px(22.0f), Target.SIZE_ORIGINAL);
        this.c.measure(r2, r3);
        if (a() == false) goto L8;
        int r4 = (this.b.getMeasuredWidth() + UIHelper.dp2px(2.0f)) + this.c.getMeasuredWidth();
    L9:
        int r7 = r4 + (UIHelper.dp2px(6.0f) * 2);
        int r8 = UIHelper.dp2px(22.0f);
        setMeasuredDimension(ViewGroup.resolveSize(r7, r5), ViewGroup.resolveSize(r8, r6));
        return;
    L8:
        r4 = this.c.getMeasuredWidth();
        goto L9
    }

    public FlowTagView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        GradientDrawable r7 = new GradientDrawable();
        r7.setShape(0);
        r7.setCornerRadius(UIHelper.dp2px(6.0f));
        this.a = r7;
        AppCompatImageView r8 = new AppCompatImageView(r4);
        this.b = r8;
        View r0 = new AppCompatTextView(r4);
        this.c = r0;
        setBackground(r7);
        ViewGroup.LayoutParams r9 = new ViewGroup.LayoutParams(UIHelper.dp2px(12.0f), UIHelper.dp2px(12.0f));
        r8.setVisibility(8);
        addView(r8, r9);
        addView(r0, new ViewGroup.LayoutParams(-2, UIHelper.dp2px(12.0f)));
    }

    public /* synthetic */ FlowTagView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        int r7 = r6 - r4;
        int r8 = UIHelper.dp2px(6.0f);
        if (a() == false) goto L5;
        int r9 = (r7 - this.b.getMeasuredHeight()) / 2;
        int r10 = this.b.getMeasuredHeight() + r9;
        int r11 = this.b.getMeasuredWidth() + r8;
        this.b.layout(r8, r9, r11, r10);
        int r12 = (r7 - this.c.getMeasuredHeight()) / 2;
        int r13 = this.c.getMeasuredHeight() + r12;
        int r14 = (r8 + this.b.getMeasuredWidth()) + UIHelper.dp2px(2.0f);
        int r15 = this.c.getMeasuredWidth() + r14;
        this.c.layout(r14, r12, r15, r13);
        return;
    L5:
        int r16 = (r7 - this.c.getMeasuredHeight()) / 2;
        int r17 = this.c.getMeasuredHeight() + r16;
        int r18 = this.c.getMeasuredWidth() + r8;
        this.c.layout(r8, r16, r18, r17);
    }
}
