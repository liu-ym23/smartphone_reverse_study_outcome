package com.google.android.material.textfield;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: loaded from: classes2.dex */
abstract class EndIconDelegate {
    final Context context;
    final CheckableImageButton endIconView;
    final EndCompoundLayout endLayout;
    final TextInputLayout textInputLayout;

    public EndIconDelegate(@NonNull EndCompoundLayout r5) {
        this.textInputLayout = r5.textInputLayout;
        this.endLayout = r5;
        this.context = r5.getContext();
        this.endIconView = r5.getEndIconView();
    }

    public void afterEditTextChanged(Editable r5) {
    }

    public void beforeEditTextChanged(CharSequence r5, int r10, int r11, int r12) {
    }

    @StringRes
    public int getIconContentDescriptionResId() {
        return 0;
    }

    @DrawableRes
    public int getIconDrawableResId() {
        return 0;
    }

    public View.OnFocusChangeListener getOnEditTextFocusChangeListener() {
        return null;
    }

    public View.OnClickListener getOnIconClickListener() {
        return null;
    }

    public View.OnFocusChangeListener getOnIconViewFocusChangeListener() {
        return null;
    }

    public AccessibilityManagerCompat.TouchExplorationStateChangeListener getTouchExplorationStateChangeListener() {
        return null;
    }

    public boolean isBoxBackgroundModeSupported(int r5) {
        return true;
    }

    public boolean isIconActivable() {
        return false;
    }

    public boolean isIconActivated() {
        return false;
    }

    public boolean isIconCheckable() {
        return false;
    }

    public boolean isIconChecked() {
        return false;
    }

    public void onEditTextAttached(@Nullable EditText r5) {
    }

    public void onInitializeAccessibilityNodeInfo(View r5, @NonNull AccessibilityNodeInfoCompat r10) {
    }

    public void onPopulateAccessibilityEvent(View r5, @NonNull AccessibilityEvent r10) {
    }

    public void onSuffixVisibilityChanged(boolean r5) {
    }

    public final void refreshIconState() {
        this.endLayout.refreshIconState(false);
    }

    public void setUp() {
    }

    public boolean shouldTintIconOnError() {
        return false;
    }

    public void tearDown() {
    }
}
