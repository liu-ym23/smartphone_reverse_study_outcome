package com.obric.oui.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.obric.oui.layout.OUIFrameLayout;
import he.i;
import wb.a;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
public class OIconButtonFloating extends a {
    public AppCompatImageView A;

    public OIconButtonFloating(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        super(r8, r10, 0);
    }

    @Override // wb.a
    public final void i(Context r8, OUIFrameLayout r10, TypedArray r11) {
        i.f(r8, "context");
        i.f(r10, "contentView");
        ColorStateList r12 = r11.getColorStateList(15);
        Drawable r13 = r11.getDrawable(2);
        AppCompatImageView r14 = new AppCompatImageView(r8, null);
        this.A = r14;
        r14.setDuplicateParentStateEnabled(true);
        if (r13 == null) goto L15;
        AppCompatImageView r15 = this.A;
        if (r15 == null) goto L13;
        r15.setImageDrawable(r13);
        if (r12 == null) goto L15;
        AppCompatImageView r16 = this.A;
        if (r16 == null) goto L11;
        r16.setImageTintList(r12);
        goto L15
    L11:
        i.j("iconView");
        throw null;
    L13:
        i.j("iconView");
        throw null;
    L15:
        View r17 = this.A;
        if (r17 == null) goto L19;
        FrameLayout.LayoutParams r18 = new FrameLayout.LayoutParams(-1, -1);
        r18.gravity = 17;
        j r19 = j.f13877a;
        r10.addView(r17, r18);
        return;
    L19:
        i.j("iconView");
        throw null;
    }

    @Override // wb.a
    public final void j(boolean r8) {
        super.j(r8);
        AppCompatImageView r10 = this.A;
        if (r8 == false) goto L8;
        if (r10 == null) goto L6;
        float r11 = 1.0f;
    L10:
        r10.setAlpha(r11);
        return;
    L6:
        i.j("iconView");
        throw null;
    L8:
        if (r10 == null) goto L12;
        r11 = 0.3f;
        goto L10
    L12:
        i.j("iconView");
        throw null;
    }

    public final void setIcon(int r8) {
        AppCompatImageView r10 = this.A;
        if (r10 == null) goto L6;
        r10.setImageResource(r8);
        return;
    L6:
        i.j("iconView");
        throw null;
    }

    public final void setIconBgColor(int r8) {
        setBgColor(r8);
    }

    public final void setIconTintColor(int r8) {
        AppCompatImageView r10 = this.A;
        if (r10 == null) goto L6;
        r10.setColorFilter(r8);
        return;
    L6:
        i.j("iconView");
        throw null;
    }

    public final void setIcon(Drawable r8) {
        i.f(r8, "drawable");
        AppCompatImageView r10 = this.A;
        if (r10 == null) goto L6;
        r10.setImageDrawable(r8);
        return;
    L6:
        i.j("iconView");
        throw null;
    }

    public final void setIconTintColor(ColorStateList r8) {
        i.f(r8, "color");
        AppCompatImageView r10 = this.A;
        if (r10 == null) goto L6;
        r10.setImageTintList(r8);
        return;
    L6:
        i.j("iconView");
        throw null;
    }
}
