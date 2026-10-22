package com.google.android.material.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.view.ViewCompat;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialAlertDialogBuilder extends AlertDialog.Builder {
    private static final int DEF_STYLE_ATTR = 0;
    private static final int DEF_STYLE_RES = 0;
    private static final int MATERIAL_ALERT_DIALOG_THEME_OVERLAY = 0;
    private Drawable background;
    private final Rect backgroundInsets;

    static {
        DEF_STYLE_ATTR = ZeusTransformUtils.mapRes(R.attr.alertDialogStyle, "attr", "alertDialogStyle");
        DEF_STYLE_RES = ZeusTransformUtils.mapRes(R.style.MaterialAlertDialog_MaterialComponents, "style", "MaterialAlertDialog_MaterialComponents");
        MATERIAL_ALERT_DIALOG_THEME_OVERLAY = ZeusTransformUtils.mapRes(R.attr.materialAlertDialogTheme, "attr", "materialAlertDialogTheme");
    }

    public MaterialAlertDialogBuilder(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), 0);
    }

    public MaterialAlertDialogBuilder(Context r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(createMaterialAlertDialogThemedContext(r9), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), getOverridingThemeResId(r9, r8));
        Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Resources.Theme r11 = r10.getTheme();
        int r0 = DEF_STYLE_ATTR;
        int r2 = DEF_STYLE_RES;
        this.backgroundInsets = b.a(r10, r0, r2);
        int r3 = com.google.android.material.c.a.a(r10, ZeusTransformUtils.mapRes(R.attr.colorSurface, "attr", "colorSurface"), getClass().getCanonicalName());
        MaterialShapeDrawable r4 = new MaterialShapeDrawable(r10, null, r0, r2);
        r4.initializeElevationOverlay(r10);
        r4.setFillColor(ColorStateList.valueOf(r3));
        if (Build.VERSION.SDK_INT < 28) goto L9;
        TypedValue r12 = new TypedValue();
        r11.resolveAttribute(android.R.attr.dialogCornerRadius, r12, true);
        float r13 = r12.getDimension(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDisplayMetrics());
        if (r12.type != 5) goto L9;
        if (r13 < 0.0f) goto L9;
        r4.setCornerSize(r13);
    L9:
        this.background = r4;
    }

    private static Context createMaterialAlertDialogThemedContext(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        int r0 = getMaterialAlertDialogThemeOverlay(r6);
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.google.android.material.theme.a.a.a(r6, null, DEF_STYLE_ATTR, DEF_STYLE_RES), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 != 0) goto L6;
        return r7;
    L6:
        return new ContextThemeWrapper(r7, r0);
    }

    private static int getMaterialAlertDialogThemeOverlay(Context r2) {
        TypedValue r3 = com.google.android.material.resources.b.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), MATERIAL_ALERT_DIALOG_THEME_OVERLAY);
        if (r3 != null) goto L7;
        return 0;
    L7:
        return r3.data;
    }

    private static int getOverridingThemeResId(Context r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 == 0) goto L5;
        return r3;
    L5:
        return getMaterialAlertDialogThemeOverlay(r4);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public AlertDialog create() {
        AlertDialog r0 = super.create();
        Window r1 = r0.getWindow();
        View r2 = r1.getDecorView();
        if (ZeusTransformUtils.instanceOf(this.background, MaterialShapeDrawable.class) == false) goto L5;
        ((MaterialShapeDrawable) ZeusTransformUtils.preCheckCast(this.background, MaterialShapeDrawable.class, "com.obric.memorydata.plugin")).setElevation(ViewCompat.getElevation(r2));
    L5:
        r1.setBackgroundDrawable(b.a(this.background, this.backgroundInsets));
        r2.setOnTouchListener(new a(r0, this.backgroundInsets));
        return r0;
    }

    public Drawable getBackground() {
        return this.background;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* synthetic */ AlertDialog.Builder setAdapter(ListAdapter r3, DialogInterface.OnClickListener r4) {
        return setAdapter((ListAdapter) ZeusTransformUtils.wrapperContextForParams(r3, ListAdapter.class, "com.obric.memorydata.plugin"), (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setAdapter(ListAdapter r3, DialogInterface.OnClickListener r4) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setAdapter((ListAdapter) ZeusTransformUtils.wrapperContextForParams(r3, ListAdapter.class, "com.obric.memorydata.plugin"), (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin")), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    public MaterialAlertDialogBuilder setBackground(Drawable r1) {
        this.background = r1;
        return this;
    }

    public MaterialAlertDialogBuilder setBackgroundInsetBottom(int r2) {
        this.backgroundInsets.bottom = r2;
        return this;
    }

    public MaterialAlertDialogBuilder setBackgroundInsetEnd(int r4) {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
    L7:
        this.backgroundInsets.right = r4;
    L8:
        return this;
    L5:
        if (ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getConfiguration().getLayoutDirection() != 1) goto L7;
        this.backgroundInsets.left = r4;
        goto L8
    }

    public MaterialAlertDialogBuilder setBackgroundInsetStart(int r4) {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
    L7:
        this.backgroundInsets.left = r4;
    L8:
        return this;
    L5:
        if (ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getConfiguration().getLayoutDirection() != 1) goto L7;
        this.backgroundInsets.right = r4;
        goto L8
    }

    public MaterialAlertDialogBuilder setBackgroundInsetTop(int r2) {
        this.backgroundInsets.top = r2;
        return this;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* bridge */ /* synthetic */ AlertDialog.Builder setCancelable(boolean r1) {
        return setCancelable(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setCancelable(boolean r2) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setCancelable(r2), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* synthetic */ AlertDialog.Builder setCursor(Cursor r3, DialogInterface.OnClickListener r4, String r5) {
        return setCursor((Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin"), (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin"), r5);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setCursor(Cursor r3, DialogInterface.OnClickListener r4, String r5) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setCursor((Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin"), (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin"), r5), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* bridge */ /* synthetic */ AlertDialog.Builder setCustomTitle(View r1) {
        return setCustomTitle(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setCustomTitle(View r2) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setCustomTitle(r2), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* bridge */ /* synthetic */ AlertDialog.Builder setIcon(int r1) {
        return setIcon(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* bridge */ /* synthetic */ AlertDialog.Builder setIcon(Drawable r1) {
        return setIcon(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setIcon(int r2) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setIcon(r2), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setIcon(Drawable r2) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setIcon(r2), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* bridge */ /* synthetic */ AlertDialog.Builder setIconAttribute(int r1) {
        return setIconAttribute(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setIconAttribute(int r2) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setIconAttribute(r2), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* synthetic */ AlertDialog.Builder setItems(int r3, DialogInterface.OnClickListener r4) {
        return setItems(r3, (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* synthetic */ AlertDialog.Builder setItems(CharSequence[] r3, DialogInterface.OnClickListener r4) {
        return setItems(r3, (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setItems(int r3, DialogInterface.OnClickListener r4) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setItems(r3, (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin")), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setItems(CharSequence[] r3, DialogInterface.OnClickListener r4) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setItems(r3, (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin")), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* bridge */ /* synthetic */ AlertDialog.Builder setMessage(int r1) {
        return setMessage(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* synthetic */ AlertDialog.Builder setMessage(CharSequence r3) {
        return setMessage((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setMessage(int r2) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setMessage(r2), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setMessage(CharSequence r3) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setMessage((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin")), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* synthetic */ AlertDialog.Builder setMultiChoiceItems(int r3, boolean[] r4, DialogInterface.OnMultiChoiceClickListener r5) {
        return setMultiChoiceItems(r3, r4, (DialogInterface.OnMultiChoiceClickListener) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.OnMultiChoiceClickListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* synthetic */ AlertDialog.Builder setMultiChoiceItems(Cursor r3, String r4, String r5, DialogInterface.OnMultiChoiceClickListener r6) {
        return setMultiChoiceItems((Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin"), r4, r5, (DialogInterface.OnMultiChoiceClickListener) ZeusTransformUtils.wrapperContextForParams(r6, DialogInterface.OnMultiChoiceClickListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* synthetic */ AlertDialog.Builder setMultiChoiceItems(CharSequence[] r3, boolean[] r4, DialogInterface.OnMultiChoiceClickListener r5) {
        return setMultiChoiceItems(r3, r4, (DialogInterface.OnMultiChoiceClickListener) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.OnMultiChoiceClickListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setMultiChoiceItems(int r3, boolean[] r4, DialogInterface.OnMultiChoiceClickListener r5) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setMultiChoiceItems(r3, r4, (DialogInterface.OnMultiChoiceClickListener) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.OnMultiChoiceClickListener.class, "com.obric.memorydata.plugin")), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setMultiChoiceItems(Cursor r3, String r4, String r5, DialogInterface.OnMultiChoiceClickListener r6) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setMultiChoiceItems((Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin"), r4, r5, (DialogInterface.OnMultiChoiceClickListener) ZeusTransformUtils.wrapperContextForParams(r6, DialogInterface.OnMultiChoiceClickListener.class, "com.obric.memorydata.plugin")), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setMultiChoiceItems(CharSequence[] r3, boolean[] r4, DialogInterface.OnMultiChoiceClickListener r5) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setMultiChoiceItems(r3, r4, (DialogInterface.OnMultiChoiceClickListener) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.OnMultiChoiceClickListener.class, "com.obric.memorydata.plugin")), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* synthetic */ AlertDialog.Builder setNegativeButton(int r3, DialogInterface.OnClickListener r4) {
        return setNegativeButton(r3, (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* synthetic */ AlertDialog.Builder setNegativeButton(CharSequence r3, DialogInterface.OnClickListener r4) {
        return setNegativeButton((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setNegativeButton(int r3, DialogInterface.OnClickListener r4) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setNegativeButton(r3, (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin")), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setNegativeButton(CharSequence r3, DialogInterface.OnClickListener r4) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setNegativeButton((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin")), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* bridge */ /* synthetic */ AlertDialog.Builder setNegativeButtonIcon(Drawable r1) {
        return setNegativeButtonIcon(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setNegativeButtonIcon(Drawable r2) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setNegativeButtonIcon(r2), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* synthetic */ AlertDialog.Builder setNeutralButton(int r3, DialogInterface.OnClickListener r4) {
        return setNeutralButton(r3, (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* synthetic */ AlertDialog.Builder setNeutralButton(CharSequence r3, DialogInterface.OnClickListener r4) {
        return setNeutralButton((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setNeutralButton(int r3, DialogInterface.OnClickListener r4) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setNeutralButton(r3, (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin")), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setNeutralButton(CharSequence r3, DialogInterface.OnClickListener r4) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setNeutralButton((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin")), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* bridge */ /* synthetic */ AlertDialog.Builder setNeutralButtonIcon(Drawable r1) {
        return setNeutralButtonIcon(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setNeutralButtonIcon(Drawable r2) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setNeutralButtonIcon(r2), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* synthetic */ AlertDialog.Builder setOnCancelListener(DialogInterface.OnCancelListener r3) {
        return setOnCancelListener((DialogInterface.OnCancelListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnCancelListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setOnCancelListener(DialogInterface.OnCancelListener r3) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setOnCancelListener((DialogInterface.OnCancelListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnCancelListener.class, "com.obric.memorydata.plugin")), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* synthetic */ AlertDialog.Builder setOnDismissListener(DialogInterface.OnDismissListener r3) {
        return setOnDismissListener((DialogInterface.OnDismissListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnDismissListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setOnDismissListener(DialogInterface.OnDismissListener r3) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setOnDismissListener((DialogInterface.OnDismissListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnDismissListener.class, "com.obric.memorydata.plugin")), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* synthetic */ AlertDialog.Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener r3) {
        return setOnItemSelectedListener((AdapterView.OnItemSelectedListener) ZeusTransformUtils.wrapperContextForParams(r3, AdapterView.OnItemSelectedListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setOnItemSelectedListener(AdapterView.OnItemSelectedListener r3) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) ZeusTransformUtils.wrapperContextForParams(r3, AdapterView.OnItemSelectedListener.class, "com.obric.memorydata.plugin")), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* synthetic */ AlertDialog.Builder setOnKeyListener(DialogInterface.OnKeyListener r3) {
        return setOnKeyListener((DialogInterface.OnKeyListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnKeyListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setOnKeyListener(DialogInterface.OnKeyListener r3) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setOnKeyListener((DialogInterface.OnKeyListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnKeyListener.class, "com.obric.memorydata.plugin")), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* synthetic */ AlertDialog.Builder setPositiveButton(int r3, DialogInterface.OnClickListener r4) {
        return setPositiveButton(r3, (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* synthetic */ AlertDialog.Builder setPositiveButton(CharSequence r3, DialogInterface.OnClickListener r4) {
        return setPositiveButton((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setPositiveButton(int r3, DialogInterface.OnClickListener r4) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setPositiveButton(r3, (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin")), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setPositiveButton(CharSequence r3, DialogInterface.OnClickListener r4) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setPositiveButton((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin")), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* bridge */ /* synthetic */ AlertDialog.Builder setPositiveButtonIcon(Drawable r1) {
        return setPositiveButtonIcon(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setPositiveButtonIcon(Drawable r2) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setPositiveButtonIcon(r2), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* synthetic */ AlertDialog.Builder setSingleChoiceItems(int r3, int r4, DialogInterface.OnClickListener r5) {
        return setSingleChoiceItems(r3, r4, (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* synthetic */ AlertDialog.Builder setSingleChoiceItems(Cursor r3, int r4, String r5, DialogInterface.OnClickListener r6) {
        return setSingleChoiceItems((Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin"), r4, r5, (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r6, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* synthetic */ AlertDialog.Builder setSingleChoiceItems(ListAdapter r3, int r4, DialogInterface.OnClickListener r5) {
        return setSingleChoiceItems((ListAdapter) ZeusTransformUtils.wrapperContextForParams(r3, ListAdapter.class, "com.obric.memorydata.plugin"), r4, (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* synthetic */ AlertDialog.Builder setSingleChoiceItems(CharSequence[] r3, int r4, DialogInterface.OnClickListener r5) {
        return setSingleChoiceItems(r3, r4, (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setSingleChoiceItems(int r3, int r4, DialogInterface.OnClickListener r5) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setSingleChoiceItems(r3, r4, (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin")), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setSingleChoiceItems(Cursor r3, int r4, String r5, DialogInterface.OnClickListener r6) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setSingleChoiceItems((Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin"), r4, r5, (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r6, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin")), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setSingleChoiceItems(ListAdapter r3, int r4, DialogInterface.OnClickListener r5) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setSingleChoiceItems((ListAdapter) ZeusTransformUtils.wrapperContextForParams(r3, ListAdapter.class, "com.obric.memorydata.plugin"), r4, (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin")), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setSingleChoiceItems(CharSequence[] r3, int r4, DialogInterface.OnClickListener r5) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setSingleChoiceItems(r3, r4, (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin")), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* bridge */ /* synthetic */ AlertDialog.Builder setTitle(int r1) {
        return setTitle(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* synthetic */ AlertDialog.Builder setTitle(CharSequence r3) {
        return setTitle((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setTitle(int r2) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setTitle(r2), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setTitle(CharSequence r3) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setTitle((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin")), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* bridge */ /* synthetic */ AlertDialog.Builder setView(int r1) {
        return setView(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* bridge */ /* synthetic */ AlertDialog.Builder setView(View r1) {
        return setView(r1);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setView(int r2) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setView(r2), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public MaterialAlertDialogBuilder setView(View r2) {
        return (MaterialAlertDialogBuilder) ZeusTransformUtils.preCheckCast(super.setView(r2), MaterialAlertDialogBuilder.class, "com.obric.memorydata.plugin");
    }
}
