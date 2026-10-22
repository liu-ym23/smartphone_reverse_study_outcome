package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* JADX INFO: loaded from: classes.dex */
public final class a0 extends ToggleButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f1099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f1100b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public l f1101m;

    public a0(Context r8, AttributeSet r10) {
        super(r8, r10, R.attr.buttonStyleToggle);
        q0.a(this, getContext());
        d r11 = new d(this);
        this.f1099a = r11;
        r11.d(r10, R.attr.buttonStyleToggle);
        w r12 = new w(this);
        this.f1100b = r12;
        r12.f(r10, R.attr.buttonStyleToggle);
        getEmojiTextViewHelper().a(r10, R.attr.buttonStyleToggle);
    }

    private l getEmojiTextViewHelper() {
        if (this.f1101m != null) goto L6;
        this.f1101m = new l(this);
    L6:
        return this.f1101m;
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        d r8 = this.f1099a;
        if (r8 == null) goto L5;
        r8.a();
    L5:
        w r10 = this.f1100b;
        if (r10 == null) goto L9;
        r10.b();
        return;
    }

    public ColorStateList getSupportBackgroundTintList() {
        d r8 = this.f1099a;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.b();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d r8 = this.f1099a;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.c();
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1100b.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1100b.e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean r8) {
        super.setAllCaps(r8);
        getEmojiTextViewHelper().b(r8);
    }

    @Override // android.widget.ToggleButton, android.view.View
    public void setBackgroundDrawable(Drawable r8) {
        super.setBackgroundDrawable(r8);
        d r10 = this.f1099a;
        if (r10 == null) goto L6;
        r10.e();
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(int r8) {
        super.setBackgroundResource(r8);
        d r10 = this.f1099a;
        if (r10 == null) goto L6;
        r10.f(r8);
        return;
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable r8, Drawable r10, Drawable r11, Drawable r12) {
        super.setCompoundDrawables(r8, r10, r11, r12);
        w r13 = this.f1100b;
        if (r13 == null) goto L6;
        r13.b();
        return;
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable r8, Drawable r10, Drawable r11, Drawable r12) {
        super.setCompoundDrawablesRelative(r8, r10, r11, r12);
        w r13 = this.f1100b;
        if (r13 == null) goto L6;
        r13.b();
        return;
    }

    public void setEmojiCompatEnabled(boolean r8) {
        getEmojiTextViewHelper().c(r8);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] r8) {
        super.setFilters(getEmojiTextViewHelper().f1207b.f10113a.a(r8));
    }

    public void setSupportBackgroundTintList(ColorStateList r8) {
        d r10 = this.f1099a;
        if (r10 == null) goto L6;
        r10.h(r8);
        return;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode r8) {
        d r10 = this.f1099a;
        if (r10 == null) goto L6;
        r10.i(r8);
        return;
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList r8) {
        w r10 = this.f1100b;
        r10.h(r8);
        r10.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode r8) {
        w r10 = this.f1100b;
        r10.i(r8);
        r10.b();
    }
}
