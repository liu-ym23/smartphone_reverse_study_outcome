package com.obric.oui.tab;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.xiphias.browser.scanner.BuildConfig;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated(message = "使用 optimize 包下的 OBottomTabItem")
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006@FX\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001a\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u001b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lcom/obric/oui/tab/OBottomTabItemCustomView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defaultSelectTextColor", "", "defaultTextColor", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "iconContainer", "Landroid/widget/FrameLayout;", "selectedBg", "Landroid/graphics/drawable/Drawable;", EventBody.KEY_VALUE, "selectedBgColor", "getSelectedBgColor$annotations", "()V", "getSelectedBgColor", "()Ljava/lang/Integer;", "setSelectedBgColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "Landroid/content/res/ColorStateList;", "textColor", "getTextColor", "()Landroid/content/res/ColorStateList;", "setTextColor", "(Landroid/content/res/ColorStateList;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setSelected", "", BuildConfig.FLAVOR, "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomTabItemCustomView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Drawable f14522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FrameLayout f14523b;
    private final int c;
    private final int d;
    private final ImageView e;
    private final TextView f;
    private ColorStateList g;
    private Integer h;

    /* JADX WARN: Multi-variable type inference failed */
    public OBottomTabItemCustomView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public OBottomTabItemCustomView(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setClickable(false);
        setFocusable(false);
        ZeusTransformUtils.inflate(LayoutInflater.from(r6), ZeusTransformUtils.mapRes(R.layout.o_tab_bottom_item, "layout", "o_tab_bottom_item"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), true, "com.obric.memorydata.plugin");
        View r8 = findViewById(ZeusTransformUtils.mapRes(R.id.icon_container, OaidModel.KEY_ID, "icon_container"));
        Intrinsics.checkNotNullExpressionValue(r8, "findViewById(R.id.icon_container)");
        this.f14523b = (FrameLayout) ZeusTransformUtils.preCheckCast(r8, FrameLayout.class, "com.obric.memorydata.plugin");
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.icon, OaidModel.KEY_ID, "icon"));
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.icon)");
        this.e = (ImageView) ZeusTransformUtils.preCheckCast(r9, ImageView.class, "com.obric.memorydata.plugin");
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.title, OaidModel.KEY_ID, "title"));
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.title)");
        this.f = (TextView) ZeusTransformUtils.preCheckCast(r10, TextView.class, "com.obric.memorydata.plugin");
        this.c = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_text_3, TypedValues.Custom.S_COLOR, "oui_text_3"));
        this.d = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_accent_fg, TypedValues.Custom.S_COLOR, "oui_accent_fg"));
    }

    public /* synthetic */ OBottomTabItemCustomView(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    @Deprecated(message = "2024.11.4 最新的设计规范移除了选中状态的背景色")
    public static /* synthetic */ void getSelectedBgColor$annotations() {
    }

    public final ImageView getIcon() {
        return this.e;
    }

    public final Integer getSelectedBgColor() {
        return this.h;
    }

    public final ColorStateList getTextColor() {
        return this.g;
    }

    public final TextView getTitle() {
        return this.f;
    }

    @Override // android.view.View
    public void setSelected(boolean r3) {
        super.setSelected(r3);
        Integer r0 = null;
        if (r3 == false) goto L14;
        ColorStateList r4 = this.g;
        if (r4 == null) goto L8;
        r0 = Integer.valueOf(r4.getColorForState(RelativeLayout.SELECTED_STATE_SET, this.d));
    L8:
        if (r0 != null) goto L10;
        int r5 = this.d;
    L11:
        this.f.setTextColor(r5);
        if (this.e.getDrawable() == null) goto L25;
    L23:
        ImageView r2 = this.e;
        Drawable r1 = DrawableCompat.wrap(r2.getDrawable());
        r1.setTint(r5);
        r2.setImageDrawable(r1);
        return;
    L25:
        return;
    L10:
        r5 = r0.intValue();
        goto L11
    L14:
        ColorStateList r6 = this.g;
        if (r6 == null) goto L18;
        r0 = Integer.valueOf(r6.getDefaultColor());
    L18:
        if (r0 != null) goto L20;
        r5 = this.c;
    L21:
        this.f.setTextColor(r5);
        if (this.e.getDrawable() != null) goto L23;
        return;
    L20:
        r5 = r0.intValue();
        goto L21
    }

    public final void setSelectedBgColor(Integer r7) {
        this.h = r7;
        if (r7 != null) goto L5;
        return;
    L5:
        GradientDrawable r0 = new GradientDrawable();
        r0.setShape(0);
        r0.setCornerRadius(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_r_m1, "dimen", "oui_r_m1")));
        r0.setColor(r7.intValue());
        this.f14522a = (Drawable) ZeusTransformUtils.preCheckCast(r0, Drawable.class, "com.obric.memorydata.plugin");
    }

    public final void setTextColor(ColorStateList r3) {
        this.g = r3;
        if (r3 != null) goto L5;
        return;
    L5:
        this.f.setTextColor(r3.getDefaultColor());
        if (this.e.getDrawable() == null) goto L9;
        ImageView r2 = this.e;
        Drawable r0 = DrawableCompat.wrap(r2.getDrawable());
        r0.setTint(r3.getDefaultColor());
        r2.setImageDrawable(r0);
        return;
    }
}
