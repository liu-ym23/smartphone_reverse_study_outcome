package com.obric.oui.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.obric.oui.layout.OUIFrameLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0002¨\u0006\f"}, d2 = {"Lcom/obric/oui/button/OIconButtonFloating;", "Lcom/obric/oui/button/OShadowFrame;", "", "drawableResId", "", "setIcon", "Landroid/graphics/drawable/Drawable;", "drawable", "color", "setIconTintColor", "Landroid/content/res/ColorStateList;", "setIconBgColor", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OIconButtonFloating extends OShadowFrame {
    public AppCompatImageView D;

    public OIconButtonFloating(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 14, 0);
    }

    public OIconButtonFloating(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 12, 0);
    }

    public OIconButtonFloating(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, r10, 8, 0);
    }

    @Override // com.obric.oui.button.OShadowFrame
    public final void d(int r1) {
        super.d(r1);
    }

    public final void setIcon(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        AppCompatImageView r0 = this.D;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r0 = null;
    L5:
        r0.setImageDrawable(r2);
    }

    public final void setIconBgColor(int r1) {
        setBgColor(r1);
    }

    public final void setIconTintColor(ColorStateList r2) {
        Intrinsics.checkNotNullParameter(r2, "color");
        ImageView r0 = this.D;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r0 = null;
    L5:
        r0.setImageTintList(r2);
    }

    @Override // com.obric.oui.button.OShadowFrame
    public final void t(boolean r3) {
        super.t(r3);
        ImageView r0 = null;
        if (r3 == false) goto L9;
        ImageView r4 = this.D;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L8:
        r0.setAlpha(1.0f);
        return;
    L7:
        r0 = r4;
        goto L8
    L9:
        ImageView r5 = this.D;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L13:
        r0.setAlpha(0.3f);
        return;
    L12:
        r0 = r5;
        goto L13
    }

    public final void setIcon(int r2) {
        AppCompatImageView r0 = this.D;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r0 = null;
    L5:
        r0.setImageResource(r2);
    }

    public final void setIconTintColor(int r2) {
        ImageView r0 = this.D;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r0 = null;
    L5:
        r0.setColorFilter(r2);
    }

    @Override // com.obric.oui.button.OShadowFrame
    public final void k(Context r6, OUIFrameLayout r7, TypedArray r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "contentView");
        ColorStateList r0 = r8.getColorStateList(20);
        Drawable r1 = r8.getDrawable(3);
        AppCompatImageView r2 = new AppCompatImageView(r6);
        this.D = r2;
        r2.setDuplicateParentStateEnabled(true);
        View r3 = null;
        if (r1 == null) goto L13;
        AppCompatImageView r4 = this.D;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r4 = null;
    L7:
        r4.setImageDrawable(r1);
        if (r0 == null) goto L13;
        ImageView r5 = this.D;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r5 = null;
    L12:
        r5.setImageTintList(r0);
    L13:
        View r9 = this.D;
        if (r9 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L17:
        FrameLayout.LayoutParams r10 = new FrameLayout.LayoutParams(-1, -1);
        r10.gravity = 17;
        Unit r11 = Unit.INSTANCE;
        r7.addView(r3, r10);
        if (getEnableMaterial() == false) goto L21;
        l(r6, r8);
        return;
    L21:
        return;
    L16:
        r3 = r9;
        goto L17
    }

    public OIconButtonFloating(Context r1, AttributeSet r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        super(r1, r2, r3, 0);
    }

    public OIconButtonFloating(Context r1, AttributeSet r2, int r3, int r4, int r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r1, "context");
        super(r1, r2, r3, 0);
    }
}
