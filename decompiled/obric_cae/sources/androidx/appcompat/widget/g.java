package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import com.obric.cae.R;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class g extends CheckedTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f1142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f1143b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final w f1144m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public l f1145n;

    public g(Context r10, AttributeSet r11) {
        s0.a(r10);
        super(r10, r11, R.attr.checkedTextViewStyle);
        q0.a(this, getContext());
        w r12 = new w(this);
        this.f1144m = r12;
        r12.f(r11, R.attr.checkedTextViewStyle);
        r12.b();
        d r13 = new d(this);
        this.f1143b = r13;
        r13.d(r11, R.attr.checkedTextViewStyle);
        this.f1142a = new h(this);
        Context r14 = getContext();
        int[] r8 = c.a.f3226l;
        v0 r15 = v0.m(r14, r11, r8, R.attr.checkedTextViewStyle);
        Context r16 = getContext();
        TypedArray r17 = r15.f1275b;
        WeakHashMap<View, j0.h0> r18 = j0.w.f8437a;
        j0.w.m.c(this, r16, r8, r11, r17, R.attr.checkedTextViewStyle, 0);
        boolean r19 = true;
    L24:
        th = move-exception;
        r15.n();
        throw th;
    L4:
        if (r15.l(1) == false) goto L9;
        int r20 = r15.i(1, 0);     // Catch: Throwable -> L24
        if (r20 == 0) goto L9;
        setCheckMarkDrawable(d.a.a(getContext(), r20));     // Catch: Resources.NotFoundException -> L27 Throwable -> L24
    L10:
        if (r19 == true) goto L17;
        if (r15.l(0) == false) goto L17;
        int r21 = r15.i(0, 0);     // Catch: Throwable -> L24
        if (r21 == 0) goto L17;
        setCheckMarkDrawable(d.a.a(getContext(), r21));     // Catch: Throwable -> L24
    L17:
        if (r15.l(2) == false) goto L20;
        setCheckMarkTintList(r15.b(2));     // Catch: Throwable -> L24
    L20:
        if (r15.l(3) == false) goto L22;
        setCheckMarkTintMode(d0.b(r15.h(3, -1), null));     // Catch: Throwable -> L24
    L22:
        r15.n();
        getEmojiTextViewHelper().a(r11, R.attr.checkedTextViewStyle);
        return;
    L9:
        r19 = false;
        goto L10
    }

    private l getEmojiTextViewHelper() {
        if (this.f1145n != null) goto L6;
        this.f1145n = new l(this);
    L6:
        return this.f1145n;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        w r8 = this.f1144m;
        if (r8 == null) goto L5;
        r8.b();
    L5:
        d r10 = this.f1143b;
        if (r10 == null) goto L8;
        r10.a();
    L8:
        h r11 = this.f1142a;
        if (r11 == null) goto L12;
        r11.a();
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
        d r8 = this.f1143b;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.b();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d r8 = this.f1143b;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.c();
    }

    public ColorStateList getSupportCheckMarkTintList() {
        h r8 = this.f1142a;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.f1158b;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        h r8 = this.f1142a;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.f1159c;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1144m.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1144m.e();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo r8) {
        InputConnection r10 = super.onCreateInputConnection(r8);
        defpackage.c.V(this, r8, r10);
        return r10;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean r8) {
        super.setAllCaps(r8);
        getEmojiTextViewHelper().b(r8);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r8) {
        super.setBackgroundDrawable(r8);
        d r10 = this.f1143b;
        if (r10 == null) goto L6;
        r10.e();
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(int r8) {
        super.setBackgroundResource(r8);
        d r10 = this.f1143b;
        if (r10 == null) goto L6;
        r10.f(r8);
        return;
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int r8) {
        setCheckMarkDrawable(d.a.a(getContext(), r8));
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable r8, Drawable r10, Drawable r11, Drawable r12) {
        super.setCompoundDrawables(r8, r10, r11, r12);
        w r13 = this.f1144m;
        if (r13 == null) goto L6;
        r13.b();
        return;
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable r8, Drawable r10, Drawable r11, Drawable r12) {
        super.setCompoundDrawablesRelative(r8, r10, r11, r12);
        w r13 = this.f1144m;
        if (r13 == null) goto L6;
        r13.b();
        return;
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback r8) {
        super.setCustomSelectionActionModeCallback(r8);
    }

    public void setEmojiCompatEnabled(boolean r8) {
        getEmojiTextViewHelper().c(r8);
    }

    public void setSupportBackgroundTintList(ColorStateList r8) {
        d r10 = this.f1143b;
        if (r10 == null) goto L6;
        r10.h(r8);
        return;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode r8) {
        d r10 = this.f1143b;
        if (r10 == null) goto L6;
        r10.i(r8);
        return;
    }

    public void setSupportCheckMarkTintList(ColorStateList r8) {
        h r10 = this.f1142a;
        if (r10 == null) goto L6;
        r10.f1158b = r8;
        r10.f1160d = true;
        r10.a();
        return;
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode r8) {
        h r10 = this.f1142a;
        if (r10 == null) goto L6;
        r10.f1159c = r8;
        r10.f1161e = true;
        r10.a();
        return;
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList r8) {
        w r10 = this.f1144m;
        r10.h(r8);
        r10.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode r8) {
        w r10 = this.f1144m;
        r10.i(r8);
        r10.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context r8, int r10) {
        super.setTextAppearance(r8, r10);
        w r11 = this.f1144m;
        if (r11 == null) goto L6;
        r11.g(r8, r10);
        return;
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable r8) {
        super.setCheckMarkDrawable(r8);
        h r10 = this.f1142a;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.f1162f == false) goto L7;
        r10.f1162f = false;
        return;
    L7:
        r10.f1162f = true;
        r10.a();
    }
}
