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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0002¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/button/OIconButtonFloating;", "Lcom/obric/oui/button/OShadowFrame;", "", "drawableResId", "", "setIcon", "Landroid/graphics/drawable/Drawable;", "drawable", TypedValues.Custom.S_COLOR, "setIconTintColor", "Landroid/content/res/ColorStateList;", "setIconBgColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class OIconButtonFloating extends OShadowFrame {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private AppCompatImageView f6269w;

    @JvmOverloads
    public OIconButtonFloating(Context r10) {
        this(r10, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public OIconButtonFloating(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 0, 12, null);
    }

    @JvmOverloads
    public OIconButtonFloating(Context r10, AttributeSet r11, int r12) {
        this(r10, r11, r12, 0, 8, null);
    }

    @JvmOverloads
    public OIconButtonFloating(Context r10, AttributeSet r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12, r13);
    }

    public /* synthetic */ OIconButtonFloating(Context r10, AttributeSet r11, int r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = 0;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = 0;
    L11:
        this(r10, r11, r12, r13);
    }

    @Override // com.obric.oui.button.OShadowFrame
    public void j(Context r10, FrameLayout r11, AttributeSet r12, TypedArray r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "contentView");
        if (r13 != null) goto L5;
        return;
    L5:
        ColorStateList r14 = r13.getColorStateList(l.OShadowFrame_oui_widgetTintColor);
        Drawable r15 = r13.getDrawable(l.OShadowFrame_oui_widgetIcon);
        AppCompatImageView r16 = new AppCompatImageView(r10);
        this.f6269w = r16;
        r16.setDuplicateParentStateEnabled(true);
        if (r15 == null) goto L16;
        AppCompatImageView r17 = this.f6269w;
        if (r17 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L10:
        r17.setImageDrawable(r15);
        if (r14 == null) goto L16;
        AppCompatImageView r18 = this.f6269w;
        if (r18 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L15:
        r18.setImageTintList(r14);
    L16:
        View r19 = this.f6269w;
        if (r19 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L19:
        FrameLayout.LayoutParams r20 = new FrameLayout.LayoutParams(-1, -1);
        r20.gravity = 17;
        Unit r21 = Unit.INSTANCE;
        r11.addView(r19, r20);
    }

    @Override // com.obric.oui.button.OShadowFrame
    protected void n(boolean r10) {
        super.n(r10);
        AppCompatImageView r11 = this.f6269w;
        if (r10 == false) goto L7;
        if (r11 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L6:
        float r12 = 1.0f;
    L10:
        r11.setAlpha(r12);
        return;
    L7:
        if (r11 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L9:
        r12 = 0.3f;
        goto L10
    }

    public final void setIcon(int r10) {
        AppCompatImageView r11 = this.f6269w;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L5:
        r11.setImageResource(r10);
    }

    public final void setIcon(Drawable r10) {
        Intrinsics.checkNotNullParameter(r10, "drawable");
        AppCompatImageView r11 = this.f6269w;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L5:
        r11.setImageDrawable(r10);
    }

    public final void setIconBgColor(@ColorInt int r10) {
        setBgColor(r10);
    }

    public final void setIconTintColor(@ColorInt int r10) {
        AppCompatImageView r11 = this.f6269w;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L5:
        r11.setColorFilter(r10);
    }

    public final void setIconTintColor(ColorStateList r10) {
        Intrinsics.checkNotNullParameter(r10, TypedValues.Custom.S_COLOR);
        AppCompatImageView r11 = this.f6269w;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L5:
        r11.setImageTintList(r10);
    }
}
