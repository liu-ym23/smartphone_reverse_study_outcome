package com.google.android.material.datepicker;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.dialog.MaterialDialogs;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.TESTS})
public class MaterialStyledDatePickerDialog extends DatePickerDialog {

    @AttrRes
    private static final int DEF_STYLE_ATTR = 16843612;

    @StyleRes
    private static final int DEF_STYLE_RES = 0;

    @NonNull
    private final Drawable background;

    @NonNull
    private final Rect backgroundInsets;

    static {
        DEF_STYLE_RES = R.style.MaterialAlertDialog_MaterialComponents_Picker_Date_Spinner;
    }

    public MaterialStyledDatePickerDialog(@NonNull Context r5) {
        this(r5, 0);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle r5) {
        super.onCreate(r5);
        getWindow().setBackgroundDrawable(this.background);
        getWindow().getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(this, this.backgroundInsets));
    }

    public MaterialStyledDatePickerDialog(@NonNull Context r10, int r11) {
        this(r10, r11, null, -1, -1, -1);
    }

    public MaterialStyledDatePickerDialog(@NonNull Context r10, @Nullable DatePickerDialog.OnDateSetListener r11, int r12, int r13, int r14) {
        this(r10, 0, r11, r12, r13, r14);
    }

    public MaterialStyledDatePickerDialog(@NonNull Context r5, int r10, @Nullable DatePickerDialog.OnDateSetListener r11, int r12, int r13, int r14) {
        super(r5, r10, r11, r12, r13, r14);
        Context r15 = getContext();
        int r16 = MaterialAttributes.resolveOrThrow(getContext(), R.attr.colorSurface, getClass().getCanonicalName());
        int r17 = DEF_STYLE_RES;
        MaterialShapeDrawable r18 = new MaterialShapeDrawable(r15, null, 16843612, r17);
        r18.setFillColor(ColorStateList.valueOf(r16));
        Rect r19 = MaterialDialogs.getDialogBackgroundInsets(r15, 16843612, r17);
        this.backgroundInsets = r19;
        this.background = MaterialDialogs.insetDrawable(r18, r19);
    }
}
