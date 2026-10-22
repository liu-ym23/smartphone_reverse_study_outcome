package com.obric.oui.panel.header;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.obric.oui.divider.ODivider;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.c;
import u8.d;
import u8.e;
import u8.f;
import u8.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/panel/header/OPanelPadHeaderView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/appcompat/widget/AppCompatImageView;", "getCloseIconView", "Landroid/widget/TextView;", "getTitleView", "", "switchToWhiteIconStyle", "switchToBlackIconStyle", "switchToPadIconStyle", "Landroid/widget/ImageView;", "ivBack", "Landroid/widget/ImageView;", "ivClose", "Landroidx/appcompat/widget/AppCompatImageView;", "tvTitle", "Landroid/widget/TextView;", "Lcom/obric/oui/divider/ODivider;", "dividerView", "Lcom/obric/oui/divider/ODivider;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OPanelPadHeaderView extends ConstraintLayout {
    private final ODivider dividerView;
    private final ImageView ivBack;
    private final AppCompatImageView ivClose;
    private final TextView tvTitle;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OPanelPadHeaderView(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public OPanelPadHeaderView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        ViewGroup.inflate(r10, h.o_basic_panel_pad_header, this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, com.obric.oui.common.util.a.f6396a.b(r10, u8.b.oui_PanelDefaultHeaderHeight, d.oui_panel_default_header_height)));
        setBackgroundColor(0);
        View r12 = findViewById(f.iv_close);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.iv_close)");
        this.ivClose = (AppCompatImageView) r12;
        View r13 = findViewById(f.tv_title);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.tv_title)");
        this.tvTitle = (TextView) r13;
        View r14 = findViewById(f.iv_back);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.iv_back)");
        this.ivBack = (ImageView) r14;
        View r15 = findViewById(f.divider);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.divider)");
        this.dividerView = (ODivider) r15;
    }

    public /* synthetic */ OPanelPadHeaderView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public final AppCompatImageView getCloseIconView() {
        return this.ivClose;
    }

    public final TextView getTitleView() {
        return this.tvTitle;
    }

    public final void switchToBlackIconStyle() {
        com.obric.oui.common.util.h r10 = new com.obric.oui.common.util.h(ContextCompat.getColor(getContext(), c.TextReverse));
        Drawable r11 = ContextCompat.getDrawable(getContext(), e.o_basic_panel_normal_header_close_bg_dark);
        this.ivBack.setColorFilter(r10);
        this.ivClose.setColorFilter(r10);
        this.ivBack.setBackground(r11);
        this.ivClose.setBackground(r11);
    }

    public final void switchToPadIconStyle() {
        com.obric.oui.common.util.h r10 = new com.obric.oui.common.util.h(ContextCompat.getColor(getContext(), c.TextReverse));
        this.ivBack.setColorFilter(r10);
        this.ivClose.setColorFilter(r10);
        this.ivBack.setBackground(null);
        this.ivClose.setBackground(null);
    }

    public final void switchToWhiteIconStyle() {
        com.obric.oui.common.util.h r10 = new com.obric.oui.common.util.h(ContextCompat.getColor(getContext(), c.ConstTextInverse));
        Drawable r11 = ContextCompat.getDrawable(getContext(), e.o_basic_panel_normal_header_close_bg_light);
        this.ivBack.setColorFilter(r10);
        this.ivClose.setColorFilter(r10);
        this.ivBack.setBackground(r11);
        this.ivClose.setBackground(r11);
    }
}
