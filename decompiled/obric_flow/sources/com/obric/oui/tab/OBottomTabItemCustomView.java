package com.obric.oui.tab;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import cn.nubia.neopush.commons.Constant;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "使用 optimize 包下的 OBottomTabItem")
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R.\u0010!\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R4\u0010+\u001a\u0004\u0018\u00010\"2\b\u0010\u001a\u001a\u0004\u0018\u00010\"8\u0006@FX\u0087\u000e¢\u0006\u0018\n\u0004\b#\u0010$\u0012\u0004\b)\u0010*\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/obric/oui/tab/OBottomTabItemCustomView;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "selected", "", "setSelected", "(Z)V", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "icon", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", Constant.TITLE, "Landroid/content/res/ColorStateList;", "value", "f", "Landroid/content/res/ColorStateList;", "getTextColor", "()Landroid/content/res/ColorStateList;", "setTextColor", "(Landroid/content/res/ColorStateList;)V", "textColor", "", "g", "Ljava/lang/Integer;", "getSelectedBgColor", "()Ljava/lang/Integer;", "setSelectedBgColor", "(Ljava/lang/Integer;)V", "getSelectedBgColor$annotations", "()V", "selectedBgColor", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomTabItemCustomView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f14640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14642c;
    public final ImageView d;
    public final TextView e;
    public ColorStateList f;
    public Integer g;

    @JvmOverloads
    public OBottomTabItemCustomView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null);
    }

    @Deprecated(message = "2024.11.4 最新的设计规范移除了选中状态的背景色")
    public static /* synthetic */ void getSelectedBgColor$annotations() {
    }

    public final ImageView getIcon() {
        return this.d;
    }

    public final Integer getSelectedBgColor() {
        return this.g;
    }

    public final ColorStateList getTextColor() {
        return this.f;
    }

    public final TextView getTitle() {
        return this.e;
    }

    @Override // android.view.View
    public void setSelected(boolean r5) {
        super.setSelected(r5);
        TextView r10 = this.e;
        Integer r11 = null;
        ImageView r12 = this.d;
        if (r5 == false) goto L14;
        ColorStateList r13 = this.f;
        int r14 = this.f14642c;
        if (r13 == null) goto L8;
        r11 = Integer.valueOf(r13.getColorForState(RelativeLayout.SELECTED_STATE_SET, r14));
    L8:
        if (r11 == null) goto L11;
        r14 = r11.intValue();
    L11:
        r10.setTextColor(r14);
        if (r12.getDrawable() == null) goto L25;
        Drawable r15 = DrawableCompat.wrap(r12.getDrawable());
        r15.setTint(r14);
        r12.setImageDrawable(r15);
        return;
    L25:
        return;
    L14:
        ColorStateList r16 = this.f;
        if (r16 == null) goto L18;
        r11 = Integer.valueOf(r16.getDefaultColor());
    L18:
        if (r11 != null) goto L20;
        int r17 = this.f14641b;
    L21:
        r10.setTextColor(r17);
        if (r12.getDrawable() == null) goto L27;
        Drawable r18 = DrawableCompat.wrap(r12.getDrawable());
        r18.setTint(r17);
        r12.setImageDrawable(r18);
        return;
    L27:
        return;
    L20:
        r17 = r11.intValue();
        goto L21
    }

    public final void setSelectedBgColor(Integer r5) {
        this.g = r5;
        if (r5 != null) goto L5;
        return;
    L5:
        GradientDrawable r10 = new GradientDrawable();
        r10.setShape(0);
        r10.setCornerRadius(getResources().getDimension(R$dimen.oui_r_m1));
        r10.setColor(r5.intValue());
    }

    public final void setTextColor(ColorStateList r5) {
        this.f = r5;
        if (r5 != null) goto L5;
        return;
    L5:
        this.e.setTextColor(r5.getDefaultColor());
        ImageView r10 = this.d;
        if (r10.getDrawable() == null) goto L9;
        Drawable r11 = DrawableCompat.wrap(r10.getDrawable());
        r11.setTint(r5.getDefaultColor());
        r10.setImageDrawable(r11);
        return;
    }

    @JvmOverloads
    public OBottomTabItemCustomView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setClickable(false);
        setFocusable(false);
        LayoutInflater.from(r5).inflate(R$layout.o_tab_bottom_item, this, true);
        this.f14640a = (FrameLayout) findViewById(R$id.icon_container);
        this.d = (ImageView) findViewById(R$id.icon);
        this.e = (TextView) findViewById(R$id.title);
        this.f14641b = ContextCompat.getColor(getContext(), R$color.oui_text_3);
        this.f14642c = ContextCompat.getColor(getContext(), R$color.oui_accent_fg);
    }
}
