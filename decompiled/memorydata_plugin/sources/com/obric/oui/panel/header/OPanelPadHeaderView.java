package com.obric.oui.panel.header;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.k;
import com.obric.oui.divider.ODivider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0012R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/panel/header/OPanelPadHeaderView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dividerView", "Lcom/obric/oui/divider/ODivider;", "ivBack", "Landroid/widget/ImageView;", "ivClose", "Landroidx/appcompat/widget/AppCompatImageView;", "tvTitle", "Landroid/widget/TextView;", "getCloseIconView", "getTitleView", "switchToBlackIconStyle", "", "switchToPadIconStyle", "switchToWhiteIconStyle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPanelPadHeaderView extends ConstraintLayout {
    private final ODivider dividerView;
    private final ImageView ivBack;
    private final AppCompatImageView ivClose;
    private final TextView tvTitle;

    /* JADX WARN: Multi-variable type inference failed */
    public OPanelPadHeaderView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public OPanelPadHeaderView(Context r7, AttributeSet r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10);
        ConstraintLayout.inflate(r9, ZeusTransformUtils.mapRes(R.layout.o_basic_panel_pad_header, "layout", "o_basic_panel_pad_header"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
        setLayoutParams(new ViewGroup.LayoutParams(-1, com.obric.oui.common.util.b.f13500a.a(r9, ZeusTransformUtils.mapRes(R.attr.oui_PanelDefaultHeaderHeight, "attr", "oui_PanelDefaultHeaderHeight"), ZeusTransformUtils.mapRes(R.dimen.oui_panel_default_header_height, "dimen", "oui_panel_default_header_height"))));
        setBackgroundColor(0);
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_close, OaidModel.KEY_ID, "iv_close"));
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.iv_close)");
        this.ivClose = (AppCompatImageView) ZeusTransformUtils.preCheckCast(r11, AppCompatImageView.class, "com.obric.memorydata.plugin");
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_title, OaidModel.KEY_ID, "tv_title"));
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.tv_title)");
        this.tvTitle = (TextView) ZeusTransformUtils.preCheckCast(r12, TextView.class, "com.obric.memorydata.plugin");
        View r13 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_back, OaidModel.KEY_ID, "iv_back"));
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.iv_back)");
        this.ivBack = (ImageView) ZeusTransformUtils.preCheckCast(r13, ImageView.class, "com.obric.memorydata.plugin");
        View r14 = findViewById(ZeusTransformUtils.mapRes(R.id.divider, OaidModel.KEY_ID, "divider"));
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.divider)");
        this.dividerView = (ODivider) ZeusTransformUtils.preCheckCast(r14, ODivider.class, "com.obric.memorydata.plugin");
    }

    public /* synthetic */ OPanelPadHeaderView(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public final AppCompatImageView getCloseIconView() {
        return this.ivClose;
    }

    public final TextView getTitleView() {
        return this.tvTitle;
    }

    public final void switchToBlackIconStyle() {
        k r0 = new k(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.TextReverse, TypedValues.Custom.S_COLOR, "TextReverse")));
        Drawable r1 = ContextCompat.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.drawable.o_basic_panel_normal_header_close_bg_dark, "drawable", "o_basic_panel_normal_header_close_bg_dark"));
        this.ivBack.setColorFilter((ColorFilter) ZeusTransformUtils.preCheckCast(r0, ColorFilter.class, "com.obric.memorydata.plugin"));
        this.ivClose.setColorFilter((ColorFilter) ZeusTransformUtils.preCheckCast(r0, ColorFilter.class, "com.obric.memorydata.plugin"));
        this.ivBack.setBackground(r1);
        this.ivClose.setBackground(r1);
    }

    public final void switchToPadIconStyle() {
        k r0 = new k(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.TextReverse, TypedValues.Custom.S_COLOR, "TextReverse")));
        this.ivBack.setColorFilter((ColorFilter) ZeusTransformUtils.preCheckCast(r0, ColorFilter.class, "com.obric.memorydata.plugin"));
        this.ivClose.setColorFilter((ColorFilter) ZeusTransformUtils.preCheckCast(r0, ColorFilter.class, "com.obric.memorydata.plugin"));
        this.ivBack.setBackground((Drawable) ZeusTransformUtils.preCheckCast(null, Drawable.class, "com.obric.memorydata.plugin"));
        this.ivClose.setBackground((Drawable) ZeusTransformUtils.preCheckCast(null, Drawable.class, "com.obric.memorydata.plugin"));
    }

    public final void switchToWhiteIconStyle() {
        k r0 = new k(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.ConstTextInverse, TypedValues.Custom.S_COLOR, "ConstTextInverse")));
        Drawable r1 = ContextCompat.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.drawable.o_basic_panel_normal_header_close_bg_light, "drawable", "o_basic_panel_normal_header_close_bg_light"));
        this.ivBack.setColorFilter((ColorFilter) ZeusTransformUtils.preCheckCast(r0, ColorFilter.class, "com.obric.memorydata.plugin"));
        this.ivClose.setColorFilter((ColorFilter) ZeusTransformUtils.preCheckCast(r0, ColorFilter.class, "com.obric.memorydata.plugin"));
        this.ivBack.setBackground(r1);
        this.ivClose.setBackground(r1);
    }
}
