package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;

/* JADX INFO: loaded from: classes.dex */
public class c extends AutoCompleteTextView {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f1105n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f1106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f1107b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final k f1108m;

    static {
        f1105n = new int[]{R.attr.popupBackground};
    }

    public c(Context r8, AttributeSet r10) {
        this(r8, r10, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        d r8 = this.f1106a;
        if (r8 == null) goto L5;
        r8.a();
    L5:
        w r10 = this.f1107b;
        if (r10 == null) goto L9;
        r10.b();
        return;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        ActionMode.Callback r8 = super.getCustomSelectionActionModeCallback();
        if ((r8 instanceof androidx.core.widget.o) == false) goto L6;
        ((androidx.core.widget.o) r8).getClass();
        return null;
    L6:
        return r8;
    }

    public ColorStateList getSupportBackgroundTintList() {
        d r8 = this.f1106a;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.b();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d r8 = this.f1106a;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.c();
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1107b.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1107b.e();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r8) {
        InputConnection r10 = super.onCreateInputConnection(r8);
        defpackage.c.V(this, r8, r10);
        return this.f1108m.c(r10, r8);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r8) {
        super.setBackgroundDrawable(r8);
        d r10 = this.f1106a;
        if (r10 == null) goto L6;
        r10.e();
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(int r8) {
        super.setBackgroundResource(r8);
        d r10 = this.f1106a;
        if (r10 == null) goto L6;
        r10.f(r8);
        return;
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable r8, Drawable r10, Drawable r11, Drawable r12) {
        super.setCompoundDrawables(r8, r10, r11, r12);
        w r13 = this.f1107b;
        if (r13 == null) goto L6;
        r13.b();
        return;
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable r8, Drawable r10, Drawable r11, Drawable r12) {
        super.setCompoundDrawablesRelative(r8, r10, r11, r12);
        w r13 = this.f1107b;
        if (r13 == null) goto L6;
        r13.b();
        return;
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback r8) {
        super.setCustomSelectionActionModeCallback(r8);
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int r8) {
        setDropDownBackgroundDrawable(d.a.a(getContext(), r8));
    }

    public void setEmojiCompatEnabled(boolean r8) {
        this.f1108m.d(r8);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener r8) {
        super.setKeyListener(this.f1108m.a(r8));
    }

    public void setSupportBackgroundTintList(ColorStateList r8) {
        d r10 = this.f1106a;
        if (r10 == null) goto L6;
        r10.h(r8);
        return;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode r8) {
        d r10 = this.f1106a;
        if (r10 == null) goto L6;
        r10.i(r8);
        return;
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList r8) {
        w r10 = this.f1107b;
        r10.h(r8);
        r10.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode r8) {
        w r10 = this.f1107b;
        r10.i(r8);
        r10.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context r8, int r10) {
        super.setTextAppearance(r8, r10);
        w r11 = this.f1107b;
        if (r11 == null) goto L6;
        r11.g(r8, r10);
        return;
    }

    public c(Context r8, AttributeSet r10, int r11) {
        s0.a(r8);
        super(r8, r10, com.obric.cae.R.attr.autoCompleteTextViewStyle);
        q0.a(this, getContext());
        v0 r12 = v0.m(getContext(), r10, f1105n, com.obric.cae.R.attr.autoCompleteTextViewStyle);
        if (r12.l(0) == false) goto L5;
        setDropDownBackgroundDrawable(r12.e(0));
    L5:
        r12.n();
        d r13 = new d(this);
        this.f1106a = r13;
        r13.d(r10, com.obric.cae.R.attr.autoCompleteTextViewStyle);
        w r14 = new w(this);
        this.f1107b = r14;
        r14.f(r10, com.obric.cae.R.attr.autoCompleteTextViewStyle);
        r14.b();
        k r15 = new k(this);
        this.f1108m = r15;
        r15.b(r10, com.obric.cae.R.attr.autoCompleteTextViewStyle);
        KeyListener r16 = getKeyListener();
        if ((!(r16 instanceof NumberKeyListener)) == false) goto L12;
        boolean r17 = super.isFocusable();
        boolean r18 = super.isClickable();
        boolean r19 = super.isLongClickable();
        int r20 = super.getInputType();
        KeyListener r21 = r15.a(r16);
        if (r21 == r16) goto L13;
        super.setKeyListener(r21);
        super.setRawInputType(r20);
        super.setFocusable(r17);
        super.setClickable(r18);
        super.setLongClickable(r19);
        return;
    L13:
        return;
    }
}
