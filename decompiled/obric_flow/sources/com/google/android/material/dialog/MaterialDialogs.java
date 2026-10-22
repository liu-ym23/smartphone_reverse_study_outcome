package com.google.android.material.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialDialogs {
    private MaterialDialogs() {
    }

    @NonNull
    public static Rect getDialogBackgroundInsets(@NonNull Context r10, @AttrRes int r11, int r12) {
        TypedArray r13 = ThemeEnforcement.obtainStyledAttributes(r10, null, R.styleable.MaterialAlertDialog, r11, r12, new int[0]);
        int r14 = r13.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetStart, r10.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_start));
        int r5 = r13.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetTop, r10.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_top));
        int r15 = r13.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetEnd, r10.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_end));
        int r16 = r13.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetBottom, r10.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_bottom));
        r13.recycle();
        if (r10.getResources().getConfiguration().getLayoutDirection() != 1) goto L6;
        r15 = r14;
        r14 = r15;
    L6:
        return new Rect(r14, r5, r15, r16);
    }

    @NonNull
    public static InsetDrawable insetDrawable(@Nullable Drawable r10, @NonNull Rect r11) {
        return new InsetDrawable(r10, r11.left, r11.top, r11.right, r11.bottom);
    }
}
