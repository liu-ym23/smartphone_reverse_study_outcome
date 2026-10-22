package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
class IconHelper {
    private IconHelper() {
    }

    public static void applyIconTint(@NonNull TextInputLayout r5, @NonNull CheckableImageButton r10, ColorStateList r11, PorterDuff.Mode r12) {
        Drawable r13 = r10.getDrawable();
        if (r13 == null) goto L13;
        r13 = DrawableCompat.wrap(r13).mutate();
        if (r11 != null) goto L7;
    L9:
        DrawableCompat.setTintList(r13, r11);
    L10:
        if (r12 == null) goto L13;
        DrawableCompat.setTintMode(r13, r12);
        goto L13
    L7:
        if (r11.isStateful() == false) goto L9;
        DrawableCompat.setTintList(r13, ColorStateList.valueOf(r11.getColorForState(mergeIconState(r5, r10), r11.getDefaultColor())));
    L13:
        if (r10.getDrawable() == r13) goto L16;
        r10.setImageDrawable(r13);
        return;
    }

    public static ImageView.ScaleType convertScaleType(int r5) {
        if (r5 == 0) goto L26;
        if (r5 == 1) goto L24;
        if (r5 == 2) goto L22;
        if (r5 == 3) goto L20;
        if (r5 == 5) goto L18;
        if (r5 == 6) goto L16;
        return ImageView.ScaleType.CENTER;
    L16:
        return ImageView.ScaleType.CENTER_INSIDE;
    L18:
        return ImageView.ScaleType.CENTER_CROP;
    L20:
        return ImageView.ScaleType.FIT_END;
    L22:
        return ImageView.ScaleType.FIT_CENTER;
    L24:
        return ImageView.ScaleType.FIT_START;
    L26:
        return ImageView.ScaleType.FIT_XY;
    }

    private static int[] mergeIconState(@NonNull TextInputLayout r5, @NonNull CheckableImageButton r10) {
        int[] r11 = r5.getDrawableState();
        int[] r12 = r10.getDrawableState();
        int r13 = r11.length;
        int[] r14 = Arrays.copyOf(r11, r11.length + r12.length);
        System.arraycopy(r12, 0, r14, r13, r12.length);
        return r14;
    }

    public static void refreshIconDrawableState(@NonNull TextInputLayout r5, @NonNull CheckableImageButton r10, ColorStateList r11) {
        Drawable r12 = r10.getDrawable();
        if (r10.getDrawable() == null) goto L10;
        if (r11 != null) goto L6;
        return;
    L6:
        if (r11.isStateful() == false) goto L12;
        int r13 = r11.getColorForState(mergeIconState(r5, r10), r11.getDefaultColor());
        Drawable r14 = DrawableCompat.wrap(r12).mutate();
        DrawableCompat.setTintList(r14, ColorStateList.valueOf(r13));
        r10.setImageDrawable(r14);
        return;
    L12:
        return;
    }

    public static void setCompatRippleBackgroundIfNeeded(@NonNull CheckableImageButton r5) {
    }

    private static void setIconClickable(@NonNull CheckableImageButton r5, @Nullable View.OnLongClickListener r10) {
        boolean r11 = ViewCompat.hasOnClickListeners(r5);
        boolean r12 = false;
        int r13 = 1;
        if (r10 == null) goto L5;
        boolean r14 = true;
    L6:
        if (r11 == true) goto L8;
        if (r14 == true) goto L8;
    L9:
        r5.setFocusable(r12);
        r5.setClickable(r11);
        r5.setPressable(r11);
        r5.setLongClickable(r14);
        if (r12 == true) goto L13;
        r13 = 2;
    L13:
        ViewCompat.setImportantForAccessibility(r5, r13);
        return;
    L8:
        r12 = true;
        goto L9
    L5:
        r14 = false;
        goto L6
    }

    public static void setIconMinSize(@NonNull CheckableImageButton r5, @Px int r10) {
        r5.setMinimumWidth(r10);
        r5.setMinimumHeight(r10);
    }

    public static void setIconOnClickListener(@NonNull CheckableImageButton r5, @Nullable View.OnClickListener r10, @Nullable View.OnLongClickListener r11) {
        r5.setOnClickListener(r10);
        setIconClickable(r5, r11);
    }

    public static void setIconOnLongClickListener(@NonNull CheckableImageButton r5, @Nullable View.OnLongClickListener r10) {
        r5.setOnLongClickListener(r10);
        setIconClickable(r5, r10);
    }

    public static void setIconScaleType(@NonNull CheckableImageButton r5, @NonNull ImageView.ScaleType r10) {
        r5.setScaleType(r10);
    }
}
