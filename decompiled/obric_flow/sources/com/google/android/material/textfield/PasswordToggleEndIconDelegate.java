package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
class PasswordToggleEndIconDelegate extends EndIconDelegate {

    @Nullable
    private EditText editText;
    private int iconResId;
    private final View.OnClickListener onIconClickListener;

    public PasswordToggleEndIconDelegate(@NonNull EndCompoundLayout r5, @DrawableRes int r10) {
        super(r5);
        this.iconResId = R.drawable.design_password_eye;
        this.onIconClickListener = new a(this, 2);
        if (r10 == 0) goto L6;
        this.iconResId = r10;
        return;
    }

    public static /* synthetic */ void a(PasswordToggleEndIconDelegate r5, View r10) {
        r5.lambda$new$0(r10);
    }

    private boolean hasPasswordTransformation() {
        EditText r5 = this.editText;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if ((r5.getTransformationMethod() instanceof PasswordTransformationMethod) == false) goto L7;
        return true;
    }

    private static boolean isInputTypePassword(EditText r5) {
        if (r5 != null) goto L4;
    L12:
        return false;
    L4:
        if (r5.getInputType() != 16) goto L6;
    L11:
        return true;
    L6:
        if (r5.getInputType() == 128) goto L11;
        if (r5.getInputType() == 144) goto L11;
        if (r5.getInputType() != 224) goto L12;
        goto L11
    }

    private /* synthetic */ void lambda$new$0(View r5) {
        EditText r10 = this.editText;
        if (r10 != null) goto L5;
        return;
    L5:
        int r11 = r10.getSelectionEnd();
        if (hasPasswordTransformation() == false) goto L8;
        this.editText.setTransformationMethod(null);
    L9:
        if (r11 < 0) goto L11;
        this.editText.setSelection(r11);
    L11:
        refreshIconState();
        return;
    L8:
        this.editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        goto L9
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void beforeEditTextChanged(CharSequence r5, int r10, int r11, int r12) {
        refreshIconState();
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    @StringRes
    public int getIconContentDescriptionResId() {
        return R.string.password_toggle_content_description;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    @DrawableRes
    public int getIconDrawableResId() {
        return this.iconResId;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public View.OnClickListener getOnIconClickListener() {
        return this.onIconClickListener;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public boolean isIconCheckable() {
        return true;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public boolean isIconChecked() {
        return !hasPasswordTransformation();
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void onEditTextAttached(@Nullable EditText r5) {
        this.editText = r5;
        refreshIconState();
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void setUp() {
        if (isInputTypePassword(this.editText) == false) goto L6;
        this.editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        return;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void tearDown() {
        EditText r5 = this.editText;
        if (r5 == null) goto L6;
        r5.setTransformationMethod(PasswordTransformationMethod.getInstance());
        return;
    }
}
