package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.material.internal.k;
import q5.l;

/* JADX INFO: loaded from: classes.dex */
public class TextInputEditText extends AppCompatEditText {
    private final Rect parentRect;
    private boolean textInputLayoutFocusedRectEnabled;

    public TextInputEditText(@NonNull Context r10) {
        this(r10, null);
    }

    public TextInputEditText(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, q5.b.editTextStyle);
    }

    public TextInputEditText(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(b6.a.c(r10, r11, r12, 0), r11, r12);
        this.parentRect = new Rect();
        TypedArray r13 = k.h(r10, r11, l.TextInputEditText, r12, q5.k.Widget_Design_TextInputEditText, new int[0]);
        setTextInputLayoutFocusedRectEnabled(r13.getBoolean(l.TextInputEditText_textInputLayoutFocusedRectEnabled, false));
        r13.recycle();
    }

    @NonNull
    private String getAccessibilityNodeInfoText(@NonNull TextInputLayout r10) {
        Editable r11 = getText();
        CharSequence r12 = r10.getHint();
        boolean r13 = !TextUtils.isEmpty(r11);
        String r14 = "";
        if ((!TextUtils.isEmpty(r12)) == false) goto L5;
        String r15 = r12.toString();
    L6:
        if (r13 == false) goto L13;
        StringBuilder r16 = new StringBuilder();
        r16.append(r11);
        if (TextUtils.isEmpty(r15) == true) goto L10;
        r14 = ", " + r15;
    L10:
        r16.append(r14);
        return r16.toString();
    L13:
        if (TextUtils.isEmpty(r15) == true) goto L15;
        return r15;
    L15:
        return "";
    L5:
        r15 = "";
        goto L6
    }

    @Nullable
    private CharSequence getHintFromLayout() {
        TextInputLayout r10 = getTextInputLayout();
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getHint();
    }

    @Nullable
    private TextInputLayout getTextInputLayout() {
        ViewParent r10 = getParent();
    L4:
        if ((r10 instanceof View) == false) goto L10;
        if ((r10 instanceof TextInputLayout) == true) goto L8;
        r10 = r10.getParent();
        goto L4
    L8:
        return (TextInputLayout) r10;
    L10:
        return null;
    }

    private boolean shouldUseTextInputLayoutFocusedRect(@Nullable TextInputLayout r10) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (this.textInputLayoutFocusedRectEnabled == false) goto L6;
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(@Nullable Rect r10) {
        super.getFocusedRect(r10);
        TextInputLayout r11 = getTextInputLayout();
        if (shouldUseTextInputLayoutFocusedRect(r11) == false) goto L7;
        if (r10 == null) goto L8;
        r11.getFocusedRect(this.parentRect);
        r10.bottom = this.parentRect.bottom;
        return;
    L8:
        return;
    }

    @Override // android.view.View
    public boolean getGlobalVisibleRect(@Nullable Rect r10, @Nullable Point r11) {
        TextInputLayout r12 = getTextInputLayout();
        if (shouldUseTextInputLayoutFocusedRect(r12) == false) goto L6;
        return r12.getGlobalVisibleRect(r10, r11);
    L6:
        return super.getGlobalVisibleRect(r10, r11);
    }

    @Override // android.widget.TextView
    @Nullable
    public CharSequence getHint() {
        TextInputLayout r10 = getTextInputLayout();
        if (r10 == null) goto L9;
        if (r10.O() == false) goto L9;
        return r10.getHint();
    L9:
        return super.getHint();
    }

    public boolean isTextInputLayoutFocusedRectEnabled() {
        return this.textInputLayoutFocusedRectEnabled;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout r10 = getTextInputLayout();
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.O() == true) goto L7;
        return;
    L7:
        if (super.getHint() == null) goto L9;
        return;
    L9:
        if (com.google.android.material.internal.f.c() == false) goto L15;
        setHint("");
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    @Nullable
    public InputConnection onCreateInputConnection(@NonNull EditorInfo r10) {
        InputConnection r11 = super.onCreateInputConnection(r10);
        if (r11 != null) goto L5;
    L7:
        return r11;
    L5:
        if (r10.hintText != null) goto L7;
        r10.hintText = getHintFromLayout();
        goto L7
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        TextInputLayout r11 = getTextInputLayout();
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        if (r11 == null) goto L8;
        r10.setText(getAccessibilityNodeInfoText(r11));
        return;
    L8:
        return;
    }

    @Override // android.view.View
    public boolean requestRectangleOnScreen(@Nullable Rect r10) {
        TextInputLayout r11 = getTextInputLayout();
        if (shouldUseTextInputLayoutFocusedRect(r11) == false) goto L8;
        if (r10 == null) goto L8;
        int r12 = r11.getHeight() - getHeight();
        this.parentRect.set(r10.left, r10.top, r10.right, r10.bottom + r12);
        return super.requestRectangleOnScreen(this.parentRect);
    L8:
        return super.requestRectangleOnScreen(r10);
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean r10) {
        this.textInputLayoutFocusedRectEnabled = r10;
    }
}
