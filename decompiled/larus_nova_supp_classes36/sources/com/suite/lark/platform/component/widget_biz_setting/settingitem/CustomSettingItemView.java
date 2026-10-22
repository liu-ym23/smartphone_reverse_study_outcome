package com.suite.lark.platform.component.widget_biz_setting.settingitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xbc.b;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001\"B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u001a\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u001a\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u000e\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001f\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010 \u001a\u00020\u00122\b\u0010!\u001a\u0004\u0018\u00010\u0017R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_setting/settingitem/CustomSettingItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mLeftTV", "Landroid/widget/FrameLayout;", "mRightIndicatorIV", "Landroid/widget/ImageView;", "mRightIndicatorTipTV", "Landroid/widget/TextView;", "mRightDrawableIV", "initAttrs", "", "initView", "setText", "textView", "title", "", "setDrawable", "view", "drawable", "Landroid/graphics/drawable/Drawable;", "setContent", "Landroid/view/View;", "setRightDrawable", "setRightIndicatorDrawable", "setRightText", "rightText", "Companion", "widget-biz-setting_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class CustomSettingItemView extends ConstraintLayout {
    public final FrameLayout a;
    public final ImageView b;
    public final TextView c;
    public final ImageView d;

    public static final class a {
    }

    static {
    }

    public CustomSettingItemView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CustomSettingItemView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setContent(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.a.removeAllViews();
        this.a.addView(r2);
    }

    public final void setRightDrawable(Drawable r3) {
        ImageView r0 = this.d;
        if (r3 != null) goto L5;
        int r1 = 8;
    L6:
        r0.setVisibility(r1);
        if (r3 == null) goto L10;
        r0.setImageDrawable(r3);
        return;
    L10:
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public final void setRightIndicatorDrawable(Drawable r3) {
        ImageView r0 = this.b;
        if (r3 != null) goto L5;
        int r1 = 8;
    L6:
        r0.setVisibility(r1);
        if (r3 == null) goto L10;
        r0.setImageDrawable(r3);
        return;
    L10:
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public final void setRightText(String r2) {
        TextView r0 = this.c;
        r0.setText(r2);
        if (TextUtils.isEmpty(r2) == false) goto L5;
        int r3 = 8;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CustomSettingItemView(Context r27, AttributeSet r28, int r29) {
        Intrinsics.checkNotNullParameter(r27, "context");
        super(r27, r28, r29);
        FrameLayout r3 = new FrameLayout(r27);
        r3.setId(2131385993);
        this.a = r3;
        ImageView r5 = new ImageView(r27);
        r5.setId(2131385997);
        r5.setImageTintList(r27.getResources().getColorStateList(2131102420));
        r5.setImageDrawable(UDIconUtils.getIconDrawable(r27, 2131255566, d.c(r27, 2131102420)));
        this.b = r5;
        TextView r7 = new TextView(r27);
        r7.setMaxWidth(UIHelper.dp2px(120.0f));
        r7.setId(2131385999);
        r7.setTextSize(14);
        r7.setTextColor(r27.getResources().getColorStateList(2131106620));
        r7.setLines(1);
        r7.setEllipsize(TextUtils.TruncateAt.END);
        this.c = r7;
        ImageView r9 = new ImageView(r27);
        r9.setId(2131385996);
        this.d = r9;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setMinHeight(UIHelper.dp2px(54.0f));
        ConstraintLayout.LayoutParams r11 = b.b(0.0f, -2.0f, 16, 0, 16, 0);
        r11.topToTop = 0;
        r11.bottomToBottom = 0;
        r11.startToStart = 0;
        r11.endToStart = 2131385996;
        r11.horizontalWeight = 1.0f;
        r11.horizontalChainStyle = 2;
        addView(r3, r11);
        ConstraintLayout.LayoutParams r13 = b.b(-2.0f, -2.0f, 0, 0, 5, 0);
        r13.topToTop = 0;
        r13.bottomToBottom = 0;
        r13.startToEnd = 2131385993;
        r13.endToStart = 2131385999;
        addView(r9, r13);
        ConstraintLayout.LayoutParams r4 = b.b(-2.0f, -2.0f, 0, 0, 5, 0);
        r4.topToTop = 0;
        r4.bottomToBottom = 0;
        r4.startToEnd = 2131385996;
        r4.endToStart = 2131385997;
        addView(r7, r4);
        ConstraintLayout.LayoutParams r6 = b.b(16.0f, 16.0f, 0, 0, 16, 0);
        r6.topToTop = 0;
        r6.bottomToBottom = 0;
        r6.startToEnd = 2131385999;
        r6.endToEnd = 0;
        addView(r5, r6);
        if (r28 == null) goto L6;
        TypedArray r1 = r27.obtainStyledAttributes(r28, new int[]{2130969052, 2130969111, 2130969124, 2130969616, 2130969775, 2130969778, 2130969971, 2130969972, 2130969973, 2130970348, 2130972677, 2130975002});
        setRightIndicatorDrawable(r1.getDrawable(6));
        setRightDrawable(r1.getDrawable(7));
        setRightText(r1.getString(8));
        r1.recycle();
        return;
    }

    public /* synthetic */ CustomSettingItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
