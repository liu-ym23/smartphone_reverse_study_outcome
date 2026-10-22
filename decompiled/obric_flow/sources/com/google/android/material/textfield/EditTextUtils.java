package com.google.android.material.textfield;

import android.widget.EditText;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
class EditTextUtils {
    private EditTextUtils() {
    }

    public static boolean isEditable(@NonNull EditText r5) {
        if (r5.getInputType() == 0) goto L5;
        return true;
    L5:
        return false;
    }
}
