package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"AppCompatCustomView"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class VisibilityAwareImageButton extends ImageButton {
    private int userSetVisibility;

    public VisibilityAwareImageButton(Context r5) {
        this(r5, null);
    }

    public final int getUserSetVisibility() {
        return this.userSetVisibility;
    }

    public final void internalSetVisibility(int r5, boolean r10) {
        super.setVisibility(r5);
        if (r10 == false) goto L6;
        this.userSetVisibility = r5;
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int r5) {
        internalSetVisibility(r5, true);
    }

    public VisibilityAwareImageButton(Context r5, AttributeSet r10) {
        this(r5, r10, 0);
    }

    public VisibilityAwareImageButton(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.userSetVisibility = getVisibility();
    }
}
