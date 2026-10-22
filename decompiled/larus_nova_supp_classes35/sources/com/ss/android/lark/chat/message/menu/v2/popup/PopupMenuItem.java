package com.ss.android.lark.chat.message.menu.v2.popup;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH\u0014J0\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bH\u0014J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\bH\u0016J\u0012\u0010$\u001a\u00020\u001a2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*H\u0016J\u000e\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u001fJ\u000e\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\bJ\u0010\u0010/\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\bH\u0016J\u0010\u00100\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\bH\u0016J\u0010\u00101\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\bH\u0016R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0017\u0010\u000e¨\u00062"}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuItem;", "Landroid/view/ViewGroup;", "Lcom/ss/android/lark/chat/message/menu/v2/popup/IPopupMenuItemView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "iconView", "Landroid/widget/ImageView;", "getIconView", "()Landroid/widget/ImageView;", "iconView$delegate", "Lkotlin/Lazy;", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "textView$delegate", "arrowView", "getArrowView", "arrowView$delegate", "onMeasure", BuildConfig.FLAVOR, "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", BuildConfig.FLAVOR, "l", "t", "r", "b", "setIcon", "resId", "drawable", "Landroid/graphics/drawable/Drawable;", "setText", "text", BuildConfig.FLAVOR, "showArrow", "show", "setArrowTint", "color", "setIconTint", "setTextColor", "setBgColor", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopupMenuItem extends ViewGroup implements b {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;

    public PopupMenuItem(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PopupMenuItem(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final ImageView getArrowView() {
        return (ImageView) this.c.getValue();
    }

    private final ImageView getIconView() {
        return (ImageView) this.a.getValue();
    }

    private final TextView getTextView() {
        return (TextView) this.b.getValue();
    }

    public final void a(boolean r2) {
        ImageView r0 = getArrowView();
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setArrowTint(int r2) {
        getArrowView().setImageTintList(ColorStateList.valueOf(r2));
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.popup.b
    public void setBgColor(int r1) {
        setBackgroundResource(r1);
    }

    public void setIcon(Drawable r2) {
        if (r2 == null) goto L4;
        getIconView().setImageDrawable(r2);
        getIconView().setVisibility(0);
        return;
    L4:
        getIconView().setVisibility(8);
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.popup.b
    public void setIconTint(int r2) {
        getIconView().setImageTintList(ColorStateList.valueOf(r2));
    }

    public void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        getTextView().setText(r2);
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.popup.b
    public void setTextColor(int r2) {
        getTextView().setTextColor(r2);
    }

    public void setIcon(int r2) {
        getIconView().setImageResource(r2);
        getIconView().setVisibility(0);
    }

    @Override // android.view.View
    public final void onMeasure(int r8, int r9) {
        int r10 = View.MeasureSpec.getMode(r8);
        int r0 = View.MeasureSpec.getSize(r8);
        int r1 = UIUtils.dp2px(getContext(), 48.0f);
        int r3 = View.MeasureSpec.makeMeasureSpec(r1, PluginList.LEVEL_NOT_SET);
        measureChild(getIconView(), r8, r3);
        measureChild(getArrowView(), r8, r3);
        int r11 = UIUtils.dp2px(getContext(), 16.0f);
        int r4 = UIUtils.dp2px(getContext(), 12.0f);
        int r12 = r11 * 2;
        if (getIconView().getVisibility() == 8) goto L6;
        r12 = r12 + (getIconView().getMeasuredWidth() + r4);
    L6:
        if (getArrowView().getVisibility() == 8) goto L9;
        r12 = r12 + (getArrowView().getMeasuredWidth() + r4);
    L9:
        if (r10 == Integer.MIN_VALUE) goto L12;
        if (r10 == 1073741824) goto L12;
        int r5 = Integer.MAX_VALUE;
    L13:
        getTextView().measure(View.MeasureSpec.makeMeasureSpec(r5, PluginList.LEVEL_NOT_SET), r3);
        if (r10 == 1073741824) goto L17;
        r0 = r12 + getTextView().getMeasuredWidth();
    L17:
        setMeasuredDimension(r0, r1);
        return;
    L12:
        r5 = RangesKt.coerceAtLeast(r0 - r12, 0);
        goto L13
    }

    public PopupMenuItem(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new PopupMenuItem$iconView$2(r2));
        this.b = LazyKt.lazy(new PopupMenuItem$textView$2(r2));
        this.c = LazyKt.lazy(new PopupMenuItem$arrowView$2(r2));
        addView(getIconView());
        addView(getTextView());
        addView(getArrowView());
    }

    public /* synthetic */ PopupMenuItem(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r6, int r7, int r8, int r9, int r10) {
        int r11 = r10 - r8;
        int r12 = UIUtils.dp2px(getContext(), 16.0f);
        int r13 = UIUtils.dp2px(getContext(), 12.0f);
        if (getIconView().getVisibility() == 8) goto L5;
        int r0 = (r11 - getIconView().getMeasuredHeight()) / 2;
        getIconView().layout(r12, r0, getIconView().getMeasuredWidth() + r12, getIconView().getMeasuredHeight() + r0);
        int r1 = (getIconView().getMeasuredWidth() + r13) + r12;
    L7:
        if (getTextView().getVisibility() == 8) goto L10;
        int r14 = (r11 - getTextView().getMeasuredHeight()) / 2;
        getTextView().layout(r1, r14, getTextView().getMeasuredWidth() + r1, getTextView().getMeasuredHeight() + r14);
    L10:
        if (getArrowView().getVisibility() == 8) goto L13;
        int r15 = (r9 - r7) - r12;
        int r16 = r15 - getArrowView().getMeasuredWidth();
        int r17 = (r11 - getArrowView().getMeasuredHeight()) / 2;
        getArrowView().layout(r16, r17, r15, getArrowView().getMeasuredHeight() + r17);
        return;
    L13:
        return;
    L5:
        r1 = r12;
        goto L7
    }
}
