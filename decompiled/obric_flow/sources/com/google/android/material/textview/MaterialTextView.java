package com.google.android.material.textview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(@NonNull Context r5) {
        this(r5, null);
    }

    private void applyLineHeightFromViewAppearance(@NonNull Resources.Theme r5, int r10) {
        TypedArray r11 = r5.obtainStyledAttributes(r10, R.styleable.MaterialTextAppearance);
        int r12 = readFirstAvailableDimension(getContext(), r11, new int[]{R.styleable.MaterialTextAppearance_android_lineHeight, R.styleable.MaterialTextAppearance_lineHeight});
        r11.recycle();
        if (r12 < 0) goto L6;
        setLineHeight(r12);
        return;
    }

    private static boolean canApplyTextAppearanceLineHeight(Context r5) {
        return MaterialAttributes.resolveBoolean(r5, R.attr.textAppearanceLineHeightEnabled, true);
    }

    private static int findViewAppearanceResourceId(@NonNull Resources.Theme r5, @Nullable AttributeSet r10, int r11, int r12) {
        TypedArray r13 = r5.obtainStyledAttributes(r10, R.styleable.MaterialTextView, r11, r12);
        int r14 = r13.getResourceId(R.styleable.MaterialTextView_android_textAppearance, -1);
        r13.recycle();
        return r14;
    }

    private void initialize(@Nullable AttributeSet r5, int r10, int r11) {
        Context r12 = getContext();
        if (canApplyTextAppearanceLineHeight(r12) == false) goto L10;
        Resources.Theme r13 = r12.getTheme();
        if (viewAttrsHasLineHeight(r12, r13, r5, r10, r11) == true) goto L11;
        int r14 = findViewAppearanceResourceId(r13, r5, r10, r11);
        if (r14 == (-1)) goto L12;
        applyLineHeightFromViewAppearance(r13, r14);
        return;
    L12:
        return;
    L11:
        return;
    }

    private static int readFirstAvailableDimension(@NonNull Context r5, @NonNull TypedArray r10, @NonNull @StyleableRes int... r11) {
        int r12 = 0;
        int r13 = -1;
    L4:
        if (r12 >= r11.length) goto L7;
        if (r13 >= 0) goto L7;
        r13 = MaterialResources.getDimensionPixelSize(r5, r10, r11[r12], -1);
        r12 = r12 + 1;
    L7:
        return r13;
    }

    private static boolean viewAttrsHasLineHeight(@NonNull Context r5, @NonNull Resources.Theme r10, @Nullable AttributeSet r11, int r12, int r13) {
        TypedArray r14 = r10.obtainStyledAttributes(r11, R.styleable.MaterialTextView, r12, r13);
        int r15 = readFirstAvailableDimension(r5, r14, new int[]{R.styleable.MaterialTextView_android_lineHeight, R.styleable.MaterialTextView_lineHeight});
        r14.recycle();
        if (r15 == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(@NonNull Context r5, int r10) {
        super.setTextAppearance(r5, r10);
        if (canApplyTextAppearanceLineHeight(r5) == false) goto L6;
        applyLineHeightFromViewAppearance(r5.getTheme(), r10);
        return;
    }

    public MaterialTextView(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, android.R.attr.textViewStyle);
    }

    public MaterialTextView(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        super(MaterialThemeOverlay.wrap(r5, r10, r11, 0), r10, r11);
        initialize(r10, r11, 0);
    }

    @Deprecated
    public MaterialTextView(@NonNull Context r5, @Nullable AttributeSet r10, int r11, int r12) {
        super(MaterialThemeOverlay.wrap(r5, r10, r11, r12), r10, r11);
        initialize(r10, r11, r12);
    }
}
