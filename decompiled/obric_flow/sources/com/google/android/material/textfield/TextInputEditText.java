package com.google.android.material.textfield;

import ai.j0;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
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
import com.google.android.material.R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes2.dex */
public class TextInputEditText extends AppCompatEditText {
    private final Rect parentRect;
    private boolean textInputLayoutFocusedRectEnabled;

    public TextInputEditText(@NonNull Context r5) {
        this(r5, null);
    }

    @NonNull
    private String getAccessibilityNodeInfoText(@NonNull TextInputLayout r5) {
        Editable r10 = getText();
        CharSequence r11 = r5.getHint();
        boolean r12 = TextUtils.isEmpty(r10);
        String r13 = "";
        if (TextUtils.isEmpty(r11) == true) goto L5;
        String r14 = r11.toString();
    L6:
        if (r12 == true) goto L13;
        StringBuilder r15 = new StringBuilder();
        r15.append(r10);
        if (TextUtils.isEmpty(r14) == true) goto L10;
        r13 = j0.C(", ", r14);
    L10:
        r15.append(r13);
        return r15.toString();
    L13:
        if (TextUtils.isEmpty(r14) == true) goto L15;
        return r14;
    L15:
        return "";
    L5:
        r14 = "";
        goto L6
    }

    @Nullable
    private CharSequence getHintFromLayout() {
        TextInputLayout r5 = getTextInputLayout();
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getHint();
    }

    @Nullable
    private TextInputLayout getTextInputLayout() {
        ViewParent r5 = getParent();
    L4:
        if ((r5 instanceof View) == false) goto L10;
        if ((r5 instanceof TextInputLayout) == true) goto L8;
        r5 = r5.getParent();
        goto L4
    L8:
        return (TextInputLayout) r5;
    L10:
        return null;
    }

    private boolean shouldUseTextInputLayoutFocusedRect(@Nullable TextInputLayout r5) {
        if (r5 != null) goto L4;
    L6:
        return false;
    L4:
        if (this.textInputLayoutFocusedRectEnabled == false) goto L6;
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(@Nullable Rect r5) {
        super.getFocusedRect(r5);
        TextInputLayout r10 = getTextInputLayout();
        if (shouldUseTextInputLayoutFocusedRect(r10) == false) goto L7;
        if (r5 == null) goto L8;
        r10.getFocusedRect(this.parentRect);
        r5.bottom = this.parentRect.bottom;
        return;
    L8:
        return;
    }

    @Override // android.view.View
    public boolean getGlobalVisibleRect(@Nullable Rect r5, @Nullable Point r10) {
        TextInputLayout r11 = getTextInputLayout();
        if (shouldUseTextInputLayoutFocusedRect(r11) == false) goto L10;
        boolean r12 = r11.getGlobalVisibleRect(r5, r10);
        if (r12 == false) goto L8;
        if (r10 == null) goto L8;
        r10.offset(-getScrollX(), -getScrollY());
    L8:
        return r12;
    L10:
        return super.getGlobalVisibleRect(r5, r10);
    }

    @Override // android.widget.TextView
    @Nullable
    public CharSequence getHint() {
        TextInputLayout r5 = getTextInputLayout();
        if (r5 == null) goto L9;
        if (r5.isProvidingHint() == false) goto L9;
        return r5.getHint();
    L9:
        return super.getHint();
    }

    public boolean isTextInputLayoutFocusedRectEnabled() {
        return this.textInputLayoutFocusedRectEnabled;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout r5 = getTextInputLayout();
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isProvidingHint() == true) goto L7;
        return;
    L7:
        if (super.getHint() == null) goto L9;
        return;
    L9:
        if (ManufacturerUtils.isMeizuDevice() == false) goto L15;
        setHint("");
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    @Nullable
    public InputConnection onCreateInputConnection(@NonNull EditorInfo r5) {
        InputConnection r10 = super.onCreateInputConnection(r5);
        if (r10 != null) goto L5;
    L7:
        return r10;
    L5:
        if (r5.hintText != null) goto L7;
        r5.hintText = getHintFromLayout();
        goto L7
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r5) {
        super.onInitializeAccessibilityNodeInfo(r5);
        getTextInputLayout();
    }

    @Override // android.view.View
    public boolean requestRectangleOnScreen(@Nullable Rect r10) {
        TextInputLayout r5 = getTextInputLayout();
        if (shouldUseTextInputLayoutFocusedRect(r5) == false) goto L8;
        if (r10 == null) goto L8;
        int r11 = r5.getHeight() - getHeight();
        this.parentRect.set(r10.left, r10.top, r10.right, r10.bottom + r11);
        return super.requestRectangleOnScreen(this.parentRect);
    L8:
        return super.requestRectangleOnScreen(r10);
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean r5) {
        this.textInputLayoutFocusedRectEnabled = r5;
    }

    public TextInputEditText(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.editTextStyle);
    }

    public TextInputEditText(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(MaterialThemeOverlay.wrap(r10, r11, r12, 0), r11, r12);
        this.parentRect = new Rect();
        TypedArray r13 = ThemeEnforcement.obtainStyledAttributes(r10, r11, R.styleable.TextInputEditText, r12, R.style.Widget_Design_TextInputEditText, new int[0]);
        setTextInputLayoutFocusedRectEnabled(r13.getBoolean(R.styleable.TextInputEditText_textInputLayoutFocusedRectEnabled, false));
        r13.recycle();
    }
}
