package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;

/* JADX INFO: loaded from: classes.dex */
public final class o extends MultiAutoCompleteTextView {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f1230n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f1231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f1232b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final k f1233m;

    static {
        f1230n = new int[]{R.attr.popupBackground};
    }

    public o(Context r8, AttributeSet r10) {
        s0.a(r8);
        super(r8, r10, com.obric.cae.R.attr.autoCompleteTextViewStyle);
        q0.a(this, getContext());
        v0 r11 = v0.m(getContext(), r10, f1230n, com.obric.cae.R.attr.autoCompleteTextViewStyle);
        if (r11.l(0) == false) goto L5;
        setDropDownBackgroundDrawable(r11.e(0));
    L5:
        r11.n();
        d r12 = new d(this);
        this.f1231a = r12;
        r12.d(r10, com.obric.cae.R.attr.autoCompleteTextViewStyle);
        w r13 = new w(this);
        this.f1232b = r13;
        r13.f(r10, com.obric.cae.R.attr.autoCompleteTextViewStyle);
        r13.b();
        k r14 = new k(this);
        this.f1233m = r14;
        r14.b(r10, com.obric.cae.R.attr.autoCompleteTextViewStyle);
        KeyListener r15 = getKeyListener();
        if ((!(r15 instanceof NumberKeyListener)) == false) goto L12;
        boolean r16 = isFocusable();
        boolean r17 = isClickable();
        boolean r18 = isLongClickable();
        int r19 = getInputType();
        KeyListener r20 = r14.a(r15);
        if (r20 == r15) goto L13;
        super.setKeyListener(r20);
        setRawInputType(r19);
        setFocusable(r16);
        setClickable(r17);
        setLongClickable(r18);
        return;
    L13:
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        d r8 = this.f1231a;
        if (r8 == null) goto L5;
        r8.a();
    L5:
        w r10 = this.f1232b;
        if (r10 == null) goto L9;
        r10.b();
        return;
    }

    public ColorStateList getSupportBackgroundTintList() {
        d r8 = this.f1231a;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.b();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d r8 = this.f1231a;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.c();
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1232b.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1232b.e();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo r8) {
        InputConnection r10 = super.onCreateInputConnection(r8);
        defpackage.c.V(this, r8, r10);
        return this.f1233m.c(r10, r8);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r8) {
        super.setBackgroundDrawable(r8);
        d r10 = this.f1231a;
        if (r10 == null) goto L6;
        r10.e();
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(int r8) {
        super.setBackgroundResource(r8);
        d r10 = this.f1231a;
        if (r10 == null) goto L6;
        r10.f(r8);
        return;
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable r8, Drawable r10, Drawable r11, Drawable r12) {
        super.setCompoundDrawables(r8, r10, r11, r12);
        w r13 = this.f1232b;
        if (r13 == null) goto L6;
        r13.b();
        return;
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable r8, Drawable r10, Drawable r11, Drawable r12) {
        super.setCompoundDrawablesRelative(r8, r10, r11, r12);
        w r13 = this.f1232b;
        if (r13 == null) goto L6;
        r13.b();
        return;
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int r8) {
        setDropDownBackgroundDrawable(d.a.a(getContext(), r8));
    }

    public void setEmojiCompatEnabled(boolean r8) {
        this.f1233m.d(r8);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener r8) {
        super.setKeyListener(this.f1233m.a(r8));
    }

    public void setSupportBackgroundTintList(ColorStateList r8) {
        d r10 = this.f1231a;
        if (r10 == null) goto L6;
        r10.h(r8);
        return;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode r8) {
        d r10 = this.f1231a;
        if (r10 == null) goto L6;
        r10.i(r8);
        return;
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList r8) {
        w r10 = this.f1232b;
        r10.h(r8);
        r10.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode r8) {
        w r10 = this.f1232b;
        r10.i(r8);
        r10.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context r8, int r10) {
        super.setTextAppearance(r8, r10);
        w r11 = this.f1232b;
        if (r11 == null) goto L6;
        r11.g(r8, r10);
        return;
    }
}
