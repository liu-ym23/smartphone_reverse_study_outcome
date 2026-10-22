package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.RadioButton;
import com.obric.cae.R;

/* JADX INFO: loaded from: classes.dex */
public class r extends RadioButton implements androidx.core.widget.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f1255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f1256b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final w f1257m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public l f1258n;

    public r(Context r8, AttributeSet r10) {
        this(r8, r10, R.attr.radioButtonStyle);
    }

    private l getEmojiTextViewHelper() {
        if (this.f1258n != null) goto L6;
        this.f1258n = new l(this);
    L6:
        return this.f1258n;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        d r8 = this.f1256b;
        if (r8 == null) goto L5;
        r8.a();
    L5:
        w r10 = this.f1257m;
        if (r10 == null) goto L9;
        r10.b();
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int r8 = super.getCompoundPaddingLeft();
        i r10 = this.f1255a;
        if (r10 == null) goto L5;
        r10.getClass();
    L5:
        return r8;
    }

    public ColorStateList getSupportBackgroundTintList() {
        d r8 = this.f1256b;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.b();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d r8 = this.f1256b;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.c();
    }

    @Override // androidx.core.widget.p
    public ColorStateList getSupportButtonTintList() {
        i r8 = this.f1255a;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.f1165b;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        i r8 = this.f1255a;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.f1166c;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1257m.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1257m.e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean r8) {
        super.setAllCaps(r8);
        getEmojiTextViewHelper().b(r8);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r8) {
        super.setBackgroundDrawable(r8);
        d r10 = this.f1256b;
        if (r10 == null) goto L6;
        r10.e();
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(int r8) {
        super.setBackgroundResource(r8);
        d r10 = this.f1256b;
        if (r10 == null) goto L6;
        r10.f(r8);
        return;
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int r8) {
        setButtonDrawable(d.a.a(getContext(), r8));
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable r8, Drawable r10, Drawable r11, Drawable r12) {
        super.setCompoundDrawables(r8, r10, r11, r12);
        w r13 = this.f1257m;
        if (r13 == null) goto L6;
        r13.b();
        return;
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable r8, Drawable r10, Drawable r11, Drawable r12) {
        super.setCompoundDrawablesRelative(r8, r10, r11, r12);
        w r13 = this.f1257m;
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
        d r10 = this.f1256b;
        if (r10 == null) goto L6;
        r10.h(r8);
        return;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode r8) {
        d r10 = this.f1256b;
        if (r10 == null) goto L6;
        r10.i(r8);
        return;
    }

    @Override // androidx.core.widget.p
    public void setSupportButtonTintList(ColorStateList r8) {
        i r10 = this.f1255a;
        if (r10 == null) goto L6;
        r10.f1165b = r8;
        r10.f1167d = true;
        r10.a();
        return;
    }

    @Override // androidx.core.widget.p
    public void setSupportButtonTintMode(PorterDuff.Mode r8) {
        i r10 = this.f1255a;
        if (r10 == null) goto L6;
        r10.f1166c = r8;
        r10.f1168e = true;
        r10.a();
        return;
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList r8) {
        w r10 = this.f1257m;
        r10.h(r8);
        r10.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode r8) {
        w r10 = this.f1257m;
        r10.i(r8);
        r10.b();
    }

    public r(Context r8, AttributeSet r10, int r11) {
        s0.a(r8);
        super(r8, r10, r11);
        q0.a(this, getContext());
        i r12 = new i(this);
        this.f1255a = r12;
        r12.b(r10, r11);
        d r13 = new d(this);
        this.f1256b = r13;
        r13.d(r10, r11);
        w r14 = new w(this);
        this.f1257m = r14;
        r14.f(r10, r11);
        getEmojiTextViewHelper().a(r10, r11);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable r8) {
        super.setButtonDrawable(r8);
        i r10 = this.f1255a;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.f1169f == false) goto L7;
        r10.f1169f = false;
        return;
    L7:
        r10.f1169f = true;
        r10.a();
    }
}
