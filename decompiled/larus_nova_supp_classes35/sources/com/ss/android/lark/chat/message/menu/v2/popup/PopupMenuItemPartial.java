package com.ss.android.lark.chat.message.menu.v2.popup;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larksuite.framework.utils.UIUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bH\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\bH\u0016J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\bH\u0016J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bH\u0016R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuItemPartial;", "Landroid/widget/LinearLayout;", "Lcom/ss/android/lark/chat/message/menu/v2/popup/IPopupMenuItemView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "iconView", "Landroid/widget/ImageView;", "getIconView", "()Landroid/widget/ImageView;", "iconView$delegate", "Lkotlin/Lazy;", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "textView$delegate", "setIcon", BuildConfig.FLAVOR, "resId", "drawable", "Landroid/graphics/drawable/Drawable;", "setText", "text", BuildConfig.FLAVOR, "setIconTint", "color", "setTextColor", "setBgColor", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopupMenuItemPartial extends LinearLayout implements b {
    public final Lazy a;
    public final Lazy b;

    public PopupMenuItemPartial(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PopupMenuItemPartial(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final ImageView getIconView() {
        return (ImageView) this.a.getValue();
    }

    private final TextView getTextView() {
        return (TextView) this.b.getValue();
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

    public PopupMenuItemPartial(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new PopupMenuItemPartial$iconView$2(r2));
        this.b = LazyKt.lazy(new PopupMenuItemPartial$textView$2(r2));
        setOrientation(1);
        setGravity(1);
        addView(getIconView());
        addView(getTextView());
        setMinimumWidth(UIUtils.dp2px(r2, 60.0f));
        setPadding(0, UIUtils.dp2px(r2, 2.0f), 0, UIUtils.dp2px(r2, 6.0f));
    }

    public /* synthetic */ PopupMenuItemPartial(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
