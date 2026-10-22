package com.google.android.material.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.annotation.ArrayRes;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialAlertDialogBuilder extends AlertDialog.Builder {

    @AttrRes
    private static final int DEF_STYLE_ATTR = 0;

    @StyleRes
    private static final int DEF_STYLE_RES = 0;

    @AttrRes
    private static final int MATERIAL_ALERT_DIALOG_THEME_OVERLAY = 0;

    @Nullable
    private Drawable background;

    @NonNull
    private final Rect backgroundInsets;

    static {
        DEF_STYLE_ATTR = R.attr.alertDialogStyle;
        DEF_STYLE_RES = R.style.MaterialAlertDialog_MaterialComponents;
        MATERIAL_ALERT_DIALOG_THEME_OVERLAY = R.attr.materialAlertDialogTheme;
    }

    public MaterialAlertDialogBuilder(@NonNull Context r5) {
        this(r5, 0);
    }

    private static Context createMaterialAlertDialogThemedContext(@NonNull Context r5) {
        int r10 = getMaterialAlertDialogThemeOverlay(r5);
        Context r11 = MaterialThemeOverlay.wrap(r5, null, DEF_STYLE_ATTR, DEF_STYLE_RES);
        if (r10 != 0) goto L6;
        return r11;
    L6:
        return new ContextThemeWrapper(r11, r10);
    }

    private static int getMaterialAlertDialogThemeOverlay(@NonNull Context r5) {
        TypedValue r10 = MaterialAttributes.resolve(r5, MATERIAL_ALERT_DIALOG_THEME_OVERLAY);
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.data;
    }

    private static int getOverridingThemeResId(@NonNull Context r5, int r10) {
        if (r10 == 0) goto L4;
        return r10;
    L4:
        return getMaterialAlertDialogThemeOverlay(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public AlertDialog create() {
        AlertDialog r5 = super.create();
        Window r10 = r5.getWindow();
        View r11 = r10.getDecorView();
        Drawable r12 = this.background;
        if ((r12 instanceof MaterialShapeDrawable) == false) goto L5;
        ((MaterialShapeDrawable) r12).setElevation(ViewCompat.getElevation(r11));
    L5:
        r10.setBackgroundDrawable(MaterialDialogs.insetDrawable(this.background, this.backgroundInsets));
        r11.setOnTouchListener(new InsetDialogOnTouchListener(r5, this.backgroundInsets));
        return r5;
    }

    @Nullable
    public Drawable getBackground() {
        return this.background;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setAdapter(@Nullable ListAdapter r5, @Nullable DialogInterface.OnClickListener r10) {
        return setAdapter(r5, r10);
    }

    @NonNull
    public MaterialAlertDialogBuilder setBackground(@Nullable Drawable r5) {
        this.background = r5;
        return this;
    }

    @NonNull
    public MaterialAlertDialogBuilder setBackgroundInsetBottom(@Px int r5) {
        this.backgroundInsets.bottom = r5;
        return this;
    }

    @NonNull
    public MaterialAlertDialogBuilder setBackgroundInsetEnd(@Px int r5) {
        if (getContext().getResources().getConfiguration().getLayoutDirection() != 1) goto L5;
        this.backgroundInsets.left = r5;
    L6:
        return this;
    L5:
        this.backgroundInsets.right = r5;
        goto L6
    }

    @NonNull
    public MaterialAlertDialogBuilder setBackgroundInsetStart(@Px int r5) {
        if (getContext().getResources().getConfiguration().getLayoutDirection() != 1) goto L5;
        this.backgroundInsets.right = r5;
    L6:
        return this;
    L5:
        this.backgroundInsets.left = r5;
        goto L6
    }

    @NonNull
    public MaterialAlertDialogBuilder setBackgroundInsetTop(@Px int r5) {
        this.backgroundInsets.top = r5;
        return this;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setCancelable(boolean r5) {
        return setCancelable(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setCursor(@Nullable Cursor r5, @Nullable DialogInterface.OnClickListener r10, @NonNull String r11) {
        return setCursor(r5, r10, r11);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setCustomTitle(@Nullable View r5) {
        return setCustomTitle(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setIcon(@DrawableRes int r5) {
        return setIcon(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setIconAttribute(@AttrRes int r5) {
        return setIconAttribute(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setItems(@ArrayRes int r5, @Nullable DialogInterface.OnClickListener r10) {
        return setItems(r5, r10);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setMessage(@StringRes int r5) {
        return setMessage(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setMultiChoiceItems(@ArrayRes int r5, @Nullable boolean[] r10, @Nullable DialogInterface.OnMultiChoiceClickListener r11) {
        return setMultiChoiceItems(r5, r10, r11);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setNegativeButton(@StringRes int r5, @Nullable DialogInterface.OnClickListener r10) {
        return setNegativeButton(r5, r10);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setNegativeButtonIcon(@Nullable Drawable r5) {
        return setNegativeButtonIcon(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setNeutralButton(@StringRes int r5, @Nullable DialogInterface.OnClickListener r10) {
        return setNeutralButton(r5, r10);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setNeutralButtonIcon(@Nullable Drawable r5) {
        return setNeutralButtonIcon(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setOnCancelListener(@Nullable DialogInterface.OnCancelListener r5) {
        return setOnCancelListener(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setOnDismissListener(@Nullable DialogInterface.OnDismissListener r5) {
        return setOnDismissListener(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener r5) {
        return setOnItemSelectedListener(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setOnKeyListener(@Nullable DialogInterface.OnKeyListener r5) {
        return setOnKeyListener(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setPositiveButton(@StringRes int r5, @Nullable DialogInterface.OnClickListener r10) {
        return setPositiveButton(r5, r10);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setPositiveButtonIcon(@Nullable Drawable r5) {
        return setPositiveButtonIcon(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setSingleChoiceItems(@ArrayRes int r5, int r10, @Nullable DialogInterface.OnClickListener r11) {
        return setSingleChoiceItems(r5, r10, r11);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setTitle(@StringRes int r5) {
        return setTitle(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setView(int r5) {
        return setView(r5);
    }

    public MaterialAlertDialogBuilder(@NonNull Context r10, int r11) {
        super(createMaterialAlertDialogThemedContext(r10), getOverridingThemeResId(r10, r11));
        Context r12 = getContext();
        Resources.Theme r13 = r12.getTheme();
        int r5 = DEF_STYLE_ATTR;
        int r14 = DEF_STYLE_RES;
        this.backgroundInsets = MaterialDialogs.getDialogBackgroundInsets(r12, r5, r14);
        int r15 = MaterialColors.getColor(r12, R.attr.colorSurface, getClass().getCanonicalName());
        TypedArray r16 = r12.obtainStyledAttributes(null, R.styleable.MaterialAlertDialog, r5, r14);
        int r17 = r16.getColor(R.styleable.MaterialAlertDialog_backgroundTint, r15);
        r16.recycle();
        MaterialShapeDrawable r18 = new MaterialShapeDrawable(r12, null, r5, r14);
        r18.initializeElevationOverlay(r12);
        r18.setFillColor(ColorStateList.valueOf(r17));
        TypedValue r19 = new TypedValue();
        r13.resolveAttribute(android.R.attr.dialogCornerRadius, r19, true);
        float r20 = r19.getDimension(getContext().getResources().getDisplayMetrics());
        if (r19.type == 5) goto L5;
    L7:
        this.background = r18;
        return;
    L5:
        if (r20 < 0.0f) goto L7;
        r18.setCornerSize(r20);
        goto L7
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setAdapter(@Nullable ListAdapter r5, @Nullable DialogInterface.OnClickListener r10) {
        return (MaterialAlertDialogBuilder) super.setAdapter(r5, r10);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setCancelable(boolean r5) {
        return (MaterialAlertDialogBuilder) super.setCancelable(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setCursor(@Nullable Cursor r5, @Nullable DialogInterface.OnClickListener r10, @NonNull String r11) {
        return (MaterialAlertDialogBuilder) super.setCursor(r5, r10, r11);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setCustomTitle(@Nullable View r5) {
        return (MaterialAlertDialogBuilder) super.setCustomTitle(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setIcon(@Nullable Drawable r5) {
        return setIcon(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setIconAttribute(@AttrRes int r5) {
        return (MaterialAlertDialogBuilder) super.setIconAttribute(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setItems(@Nullable CharSequence[] r5, @Nullable DialogInterface.OnClickListener r10) {
        return setItems(r5, r10);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setMessage(@Nullable CharSequence r5) {
        return setMessage(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setMultiChoiceItems(@Nullable Cursor r5, @NonNull String r10, @NonNull String r11, @Nullable DialogInterface.OnMultiChoiceClickListener r12) {
        return setMultiChoiceItems(r5, r10, r11, r12);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setNegativeButton(@Nullable CharSequence r5, @Nullable DialogInterface.OnClickListener r10) {
        return setNegativeButton(r5, r10);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setNegativeButtonIcon(@Nullable Drawable r5) {
        return (MaterialAlertDialogBuilder) super.setNegativeButtonIcon(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setNeutralButton(@Nullable CharSequence r5, @Nullable DialogInterface.OnClickListener r10) {
        return setNeutralButton(r5, r10);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setNeutralButtonIcon(@Nullable Drawable r5) {
        return (MaterialAlertDialogBuilder) super.setNeutralButtonIcon(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setOnCancelListener(@Nullable DialogInterface.OnCancelListener r5) {
        return (MaterialAlertDialogBuilder) super.setOnCancelListener(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setOnDismissListener(@Nullable DialogInterface.OnDismissListener r5) {
        return (MaterialAlertDialogBuilder) super.setOnDismissListener(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener r5) {
        return (MaterialAlertDialogBuilder) super.setOnItemSelectedListener(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setOnKeyListener(@Nullable DialogInterface.OnKeyListener r5) {
        return (MaterialAlertDialogBuilder) super.setOnKeyListener(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setPositiveButton(@Nullable CharSequence r5, @Nullable DialogInterface.OnClickListener r10) {
        return setPositiveButton(r5, r10);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setPositiveButtonIcon(@Nullable Drawable r5) {
        return (MaterialAlertDialogBuilder) super.setPositiveButtonIcon(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setSingleChoiceItems(@Nullable Cursor r5, int r10, @NonNull String r11, @Nullable DialogInterface.OnClickListener r12) {
        return setSingleChoiceItems(r5, r10, r11, r12);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setTitle(@Nullable CharSequence r5) {
        return setTitle(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setView(@Nullable View r5) {
        return setView(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setIcon(@DrawableRes int r5) {
        return (MaterialAlertDialogBuilder) super.setIcon(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setItems(@ArrayRes int r5, @Nullable DialogInterface.OnClickListener r10) {
        return (MaterialAlertDialogBuilder) super.setItems(r5, r10);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setMessage(@StringRes int r5) {
        return (MaterialAlertDialogBuilder) super.setMessage(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setMultiChoiceItems(@Nullable CharSequence[] r5, @Nullable boolean[] r10, @Nullable DialogInterface.OnMultiChoiceClickListener r11) {
        return setMultiChoiceItems(r5, r10, r11);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setNegativeButton(@StringRes int r5, @Nullable DialogInterface.OnClickListener r10) {
        return (MaterialAlertDialogBuilder) super.setNegativeButton(r5, r10);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setNeutralButton(@StringRes int r5, @Nullable DialogInterface.OnClickListener r10) {
        return (MaterialAlertDialogBuilder) super.setNeutralButton(r5, r10);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setPositiveButton(@StringRes int r5, @Nullable DialogInterface.OnClickListener r10) {
        return (MaterialAlertDialogBuilder) super.setPositiveButton(r5, r10);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setSingleChoiceItems(@Nullable ListAdapter r5, int r10, @Nullable DialogInterface.OnClickListener r11) {
        return setSingleChoiceItems(r5, r10, r11);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setTitle(@StringRes int r5) {
        return (MaterialAlertDialogBuilder) super.setTitle(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setView(int r5) {
        return (MaterialAlertDialogBuilder) super.setView(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setIcon(@Nullable Drawable r5) {
        return (MaterialAlertDialogBuilder) super.setIcon(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setItems(@Nullable CharSequence[] r5, @Nullable DialogInterface.OnClickListener r10) {
        return (MaterialAlertDialogBuilder) super.setItems(r5, r10);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setMessage(@Nullable CharSequence r5) {
        return (MaterialAlertDialogBuilder) super.setMessage(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setMultiChoiceItems(@ArrayRes int r5, @Nullable boolean[] r10, @Nullable DialogInterface.OnMultiChoiceClickListener r11) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(r5, r10, r11);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setNegativeButton(@Nullable CharSequence r5, @Nullable DialogInterface.OnClickListener r10) {
        return (MaterialAlertDialogBuilder) super.setNegativeButton(r5, r10);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setNeutralButton(@Nullable CharSequence r5, @Nullable DialogInterface.OnClickListener r10) {
        return (MaterialAlertDialogBuilder) super.setNeutralButton(r5, r10);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setPositiveButton(@Nullable CharSequence r5, @Nullable DialogInterface.OnClickListener r10) {
        return (MaterialAlertDialogBuilder) super.setPositiveButton(r5, r10);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog.Builder setSingleChoiceItems(@Nullable CharSequence[] r5, int r10, @Nullable DialogInterface.OnClickListener r11) {
        return setSingleChoiceItems(r5, r10, r11);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setTitle(@Nullable CharSequence r5) {
        return (MaterialAlertDialogBuilder) super.setTitle(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setView(@Nullable View r5) {
        return (MaterialAlertDialogBuilder) super.setView(r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setMultiChoiceItems(@Nullable CharSequence[] r5, @Nullable boolean[] r10, @Nullable DialogInterface.OnMultiChoiceClickListener r11) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(r5, r10, r11);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setSingleChoiceItems(@ArrayRes int r5, int r10, @Nullable DialogInterface.OnClickListener r11) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(r5, r10, r11);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setMultiChoiceItems(@Nullable Cursor r5, @NonNull String r10, @NonNull String r11, @Nullable DialogInterface.OnMultiChoiceClickListener r12) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(r5, r10, r11, r12);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setSingleChoiceItems(@Nullable Cursor r5, int r10, @NonNull String r11, @Nullable DialogInterface.OnClickListener r12) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(r5, r10, r11, r12);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setSingleChoiceItems(@Nullable CharSequence[] r5, int r10, @Nullable DialogInterface.OnClickListener r11) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(r5, r10, r11);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @NonNull
    public MaterialAlertDialogBuilder setSingleChoiceItems(@Nullable ListAdapter r5, int r10, @Nullable DialogInterface.OnClickListener r11) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(r5, r10, r11);
    }
}
