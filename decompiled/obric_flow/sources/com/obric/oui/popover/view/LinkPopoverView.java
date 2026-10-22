package com.obric.oui.popover.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import com.lynx.tasm.utils.a;
import com.lynx.tasm.utils.d;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.popover.PopoverLinearLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000b\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\"\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018¨\u0006#"}, d2 = {"Lcom/obric/oui/popover/view/LinkPopoverView;", "Lcom/obric/oui/popover/PopoverLinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "resId", "", "setLeftIcon", "(I)V", "Landroid/graphics/drawable/Drawable;", "drawable", "(Landroid/graphics/drawable/Drawable;)V", "", "charSequence", "setTips", "(Ljava/lang/CharSequence;)V", "Landroid/widget/ImageView;", "a", "Landroid/widget/ImageView;", "getIvIcon", "()Landroid/widget/ImageView;", "ivIcon", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "getTvTips", "()Landroid/widget/TextView;", "tvTips", "c", "getIvArrow", "ivArrow", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class LinkPopoverView extends PopoverLinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f14172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f14173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f14174c;

    @JvmOverloads
    public LinkPopoverView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null);
    }

    public final ImageView getIvArrow() {
        return this.f14174c;
    }

    public final ImageView getIvIcon() {
        return this.f14172a;
    }

    public final TextView getTvTips() {
        return this.f14173b;
    }

    public void setLeftIcon(@DrawableRes int r5) {
        ImageView r10 = this.f14172a;
        r10.setImageResource(r5);
        d.t(r10);
    }

    public final void setTips(CharSequence r5) {
        Intrinsics.checkNotNullParameter(r5, "charSequence");
        this.f14173b.setText(r5);
    }

    @JvmOverloads
    public LinkPopoverView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        View.inflate(r5, R$layout.o_popover_link_view, this);
        setOrientation(0);
        int r11 = a.B(12, this);
        setPadding(r11, r11, r11, r11);
        setBackground(ContextCompat.getDrawable(r5, R$drawable.o_popover_view_bg));
        this.f14172a = (ImageView) findViewById(R$id.iv_icon);
        this.f14173b = (TextView) findViewById(R$id.tv_tips);
        this.f14174c = (ImageView) findViewById(R$id.iv_arrow);
    }

    public void setLeftIcon(Drawable r5) {
        ImageView r10 = this.f14172a;
        r10.setImageDrawable(r5);
        d.t(r10);
    }
}
