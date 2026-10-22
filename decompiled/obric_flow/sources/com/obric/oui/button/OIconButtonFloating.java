package com.obric.oui.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.AppCompatImageView;
import com.obric.common.oui.R$styleable;
import com.obric.oui.layout.OUIFrameLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\f¢\u0006\u0004\b\u000b\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/button/OIconButtonFloating;", "Lcom/obric/oui/button/OShadowFrame;", "", "drawableResId", "", "setIcon", "(I)V", "Landroid/graphics/drawable/Drawable;", "drawable", "(Landroid/graphics/drawable/Drawable;)V", "color", "setIconTintColor", "Landroid/content/res/ColorStateList;", "(Landroid/content/res/ColorStateList;)V", "setIconBgColor", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OIconButtonFloating extends OShadowFrame {
    public AppCompatImageView A;

    @JvmOverloads
    public OIconButtonFloating(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        AttributeSet r5 = null;
        int r11 = 14;
        this(r10, r5, 0, r11, 0);
    }

    @Override // com.obric.oui.button.OShadowFrame
    public final void p(Context r10, OUIFrameLayout r11, TypedArray r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "contentView");
        ColorStateList r5 = r12.getColorStateList(R$styleable.OShadowFrame_oui_widgetTintColor);
        Drawable r13 = r12.getDrawable(R$styleable.OShadowFrame_oui_widgetIcon);
        AppCompatImageView r14 = new AppCompatImageView(r10);
        this.A = r14;
        r14.setDuplicateParentStateEnabled(true);
        View r15 = null;
        if (r13 == null) goto L13;
        AppCompatImageView r16 = this.A;
        if (r16 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r16 = null;
    L7:
        r16.setImageDrawable(r13);
        if (r5 == null) goto L13;
        AppCompatImageView r17 = this.A;
        if (r17 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r17 = null;
    L12:
        r17.setImageTintList(r5);
    L13:
        View r18 = this.A;
        if (r18 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L17:
        FrameLayout.LayoutParams r19 = new FrameLayout.LayoutParams(-1, -1);
        r19.gravity = 17;
        Unit r20 = Unit.INSTANCE;
        r11.addView(r15, r19);
        if (getEnableMaterial() == false) goto L21;
        q(r10, r12);
        return;
    L21:
        return;
    L16:
        r15 = r18;
        goto L17
    }

    public final void setIcon(int r5) {
        AppCompatImageView r10 = this.A;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r10 = null;
    L5:
        r10.setImageResource(r5);
    }

    public final void setIconBgColor(@ColorInt int r5) {
        setBgColor(r5);
    }

    public final void setIconTintColor(@ColorInt int r5) {
        AppCompatImageView r10 = this.A;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r10 = null;
    L5:
        r10.setColorFilter(r5);
    }

    @Override // com.obric.oui.button.OShadowFrame
    public final void u(boolean r5) {
        super.u(r5);
        AppCompatImageView r10 = null;
        if (r5 == false) goto L9;
        AppCompatImageView r11 = this.A;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L8:
        r10.setAlpha(1.0f);
        return;
    L7:
        r10 = r11;
        goto L8
    L9:
        AppCompatImageView r12 = this.A;
        if (r12 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L13:
        r10.setAlpha(0.3f);
        return;
    L12:
        r10 = r12;
        goto L13
    }

    @JvmOverloads
    public OIconButtonFloating(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        int r5 = 12;
        this(r10, r11, 0, r5, 0);
    }

    public final void setIcon(Drawable r5) {
        Intrinsics.checkNotNullParameter(r5, "drawable");
        AppCompatImageView r10 = this.A;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r10 = null;
    L5:
        r10.setImageDrawable(r5);
    }

    public final void setIconTintColor(ColorStateList r5) {
        Intrinsics.checkNotNullParameter(r5, "color");
        AppCompatImageView r10 = this.A;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r10 = null;
    L5:
        r10.setImageTintList(r5);
    }

    @JvmOverloads
    public OIconButtonFloating(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, r12, 8, 0);
    }

    public /* synthetic */ OIconButtonFloating(Context r5, AttributeSet r10, int r11, int r12, int r13) {
        if ((r12 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 4) == 0) goto L8;
        r11 = 0;
    L8:
        this(r5, r10, r11, 0);
    }

    public OIconButtonFloating(Context r5, AttributeSet r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11, 0);
    }
}
