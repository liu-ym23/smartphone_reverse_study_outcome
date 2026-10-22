package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;
import com.obric.cae.R;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class TextInputEditText extends AppCompatEditText {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Rect f4967o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f4968p;

    public TextInputEditText(Context r10, AttributeSet r11) {
        super(ea.a.a(r10, r11, R.attr.editTextStyle, 0), r11, R.attr.editTextStyle);
        this.f4967o = new Rect();
        TypedArray r12 = com.google.android.material.internal.l.d(r10, r11, g9.a.A, R.attr.editTextStyle, R.style.Widget_Design_TextInputEditText, new int[0]);
        setTextInputLayoutFocusedRectEnabled(r12.getBoolean(0, false));
        r12.recycle();
    }

    private CharSequence getHintFromLayout() {
        TextInputLayout r8 = getTextInputLayout();
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.getHint();
    }

    private TextInputLayout getTextInputLayout() {
        ViewParent r8 = getParent();
    L4:
        if ((r8 instanceof View) == false) goto L10;
        if ((r8 instanceof TextInputLayout) == true) goto L8;
        r8 = r8.getParent();
        goto L4
    L8:
        return (TextInputLayout) r8;
    L10:
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void getFocusedRect(Rect r8) {
        super.getFocusedRect(r8);
        TextInputLayout r10 = getTextInputLayout();
        if (r10 != null) goto L5;
    L7:
        boolean r11 = false;
    L8:
        if (r11 == false) goto L12;
        if (r8 == null) goto L13;
        Rect r12 = this.f4967o;
        r10.getFocusedRect(r12);
        r8.bottom = r12.bottom;
        return;
    L13:
        return;
    L12:
        return;
    L5:
        if (this.f4968p == false) goto L7;
        r11 = true;
        goto L8
    }

    @Override // android.view.View
    public final boolean getGlobalVisibleRect(Rect r8, Point r10) {
        TextInputLayout r11 = getTextInputLayout();
        if (r11 != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        if (r12 == false) goto L15;
        boolean r13 = r11.getGlobalVisibleRect(r8, r10);
        if (r13 == false) goto L13;
        if (r10 == null) goto L13;
        r10.offset(-getScrollX(), -getScrollY());
    L13:
        return r13;
    L15:
        return super.getGlobalVisibleRect(r8, r10);
    L5:
        if (this.f4968p == false) goto L7;
        r12 = true;
        goto L8
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout r8 = getTextInputLayout();
        if (r8 == null) goto L9;
        if (r8.O == false) goto L9;
        return r8.getHint();
    L9:
        return super.getHint();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout r8 = getTextInputLayout();
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.O == true) goto L7;
        return;
    L7:
        if (super.getHint() != null) goto L18;
        String r10 = Build.MANUFACTURER;
        if (r10 == null) goto L11;
        String r11 = r10.toLowerCase(Locale.ENGLISH);
    L13:
        if (r11.equals("meizu") == false) goto L19;
        setHint("");
        return;
    L19:
        return;
    L11:
        r11 = "";
        goto L13
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo r8) {
        InputConnection r10 = super.onCreateInputConnection(r8);
        if (r10 != null) goto L5;
    L7:
        return r10;
    L5:
        if (r8.hintText != null) goto L7;
        r8.hintText = getHintFromLayout();
        goto L7
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r8) {
        super.onInitializeAccessibilityNodeInfo(r8);
        getTextInputLayout();
    }

    @Override // android.view.View
    public final boolean requestRectangleOnScreen(Rect r8) {
        TextInputLayout r10 = getTextInputLayout();
        if (r10 != null) goto L5;
    L7:
        boolean r11 = false;
    L8:
        if (r11 == false) goto L13;
        if (r8 == null) goto L13;
        int r12 = r10.getHeight() - getHeight();
        int r13 = r8.left;
        int r14 = r8.top;
        int r15 = r8.right;
        int r16 = r8.bottom + r12;
        Rect r17 = this.f4967o;
        r17.set(r13, r14, r15, r16);
        return super.requestRectangleOnScreen(r17);
    L13:
        return super.requestRectangleOnScreen(r8);
    L5:
        if (this.f4968p == false) goto L7;
        r11 = true;
        goto L8
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean r8) {
        this.f4968p = r8;
    }
}
