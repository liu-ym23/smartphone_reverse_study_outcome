package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TextAppearance {
    private static final String TAG = "TextAppearance";
    private static final int TYPEFACE_MONOSPACE = 3;
    private static final int TYPEFACE_SANS = 1;
    private static final int TYPEFACE_SERIF = 2;
    private Typeface font;

    @Nullable
    public final String fontFamily;

    @FontRes
    private final int fontFamilyResourceId;
    private boolean fontResolved;
    public final boolean hasLetterSpacing;
    public final float letterSpacing;

    @Nullable
    public final ColorStateList shadowColor;
    public final float shadowDx;
    public final float shadowDy;
    public final float shadowRadius;
    public final boolean textAllCaps;

    @Nullable
    private ColorStateList textColor;

    @Nullable
    public final ColorStateList textColorHint;

    @Nullable
    public final ColorStateList textColorLink;
    private float textSize;
    public final int textStyle;
    public final int typeface;

    public TextAppearance(@NonNull Context r10, @StyleRes int r11) {
        this.fontResolved = false;
        TypedArray r5 = r10.obtainStyledAttributes(r11, R.styleable.TextAppearance);
        setTextSize(r5.getDimension(R.styleable.TextAppearance_android_textSize, 0.0f));
        setTextColor(MaterialResources.getColorStateList(r10, r5, R.styleable.TextAppearance_android_textColor));
        this.textColorHint = MaterialResources.getColorStateList(r10, r5, R.styleable.TextAppearance_android_textColorHint);
        this.textColorLink = MaterialResources.getColorStateList(r10, r5, R.styleable.TextAppearance_android_textColorLink);
        this.textStyle = r5.getInt(R.styleable.TextAppearance_android_textStyle, 0);
        this.typeface = r5.getInt(R.styleable.TextAppearance_android_typeface, 1);
        int r12 = MaterialResources.getIndexWithValue(r5, R.styleable.TextAppearance_fontFamily, R.styleable.TextAppearance_android_fontFamily);
        this.fontFamilyResourceId = r5.getResourceId(r12, 0);
        this.fontFamily = r5.getString(r12);
        this.textAllCaps = r5.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        this.shadowColor = MaterialResources.getColorStateList(r10, r5, R.styleable.TextAppearance_android_shadowColor);
        this.shadowDx = r5.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.shadowDy = r5.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.shadowRadius = r5.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        r5.recycle();
        TypedArray r13 = r10.obtainStyledAttributes(r11, R.styleable.MaterialTextAppearance);
        this.hasLetterSpacing = r13.hasValue(R.styleable.MaterialTextAppearance_android_letterSpacing);
        this.letterSpacing = r13.getFloat(R.styleable.MaterialTextAppearance_android_letterSpacing, 0.0f);
        r13.recycle();
    }

    public static /* synthetic */ Typeface access$000(TextAppearance r5) {
        return r5.font;
    }

    public static /* synthetic */ Typeface access$002(TextAppearance r5, Typeface r10) {
        r5.font = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$102(TextAppearance r5, boolean r10) {
        r5.fontResolved = r10;
        return r10;
    }

    private void createFallbackFont() {
        if (this.font != null) goto L8;
        String r5 = this.fontFamily;
        if (r5 == null) goto L8;
        this.font = Typeface.create(r5, this.textStyle);
    L8:
        if (this.font != null) goto L21;
        int r10 = this.typeface;
        if (r10 != 1) goto L12;
        this.font = Typeface.SANS_SERIF;
    L19:
        this.font = Typeface.create(this.font, this.textStyle);
        return;
    L12:
        if (r10 != 2) goto L14;
        this.font = Typeface.SERIF;
        goto L19
    L14:
        if (r10 == 3) goto L16;
        this.font = Typeface.DEFAULT;
        goto L19
    L16:
        this.font = Typeface.MONOSPACE;
        goto L19
    }

    private boolean shouldLoadFontSynchronously(Context r5) {
        if (TextAppearanceConfig.shouldLoadFontSynchronously() == false) goto L5;
        return true;
    L5:
        int r10 = this.fontFamilyResourceId;
        if (r10 == 0) goto L8;
        Typeface r11 = ResourcesCompat.getCachedFont(r5, r10);
    L9:
        if (r11 != null) goto L13;
        return false;
    L13:
        return true;
    L8:
        r11 = null;
        goto L9
    }

    public Typeface getFallbackFont() {
        createFallbackFont();
        return this.font;
    }

    @NonNull
    @VisibleForTesting
    public Typeface getFont(@NonNull Context r5) {
        if (this.fontResolved == false) goto L7;
        return this.font;
    L7:
        if (r5.isRestricted() == false) goto L17;
    L14:
        createFallbackFont();
        this.fontResolved = true;
        return this.font;
    L17:
        Typeface r10 = ResourcesCompat.getFont(r5, this.fontFamilyResourceId);     // Catch: Exception -> L12 Throwable -> L16
        this.font = r10;     // Catch: Exception -> L12 Throwable -> L16
        if (r10 == null) goto L14;
        this.font = Typeface.create(r10, this.textStyle);     // Catch: Exception -> L12 Throwable -> L16
    L12:
        e = move-exception;
        Log.d(TAG, "Error loading font " + this.fontFamily, e);
        goto L14
    }

    public void getFontAsync(@NonNull Context r5, @NonNull final TextAppearanceFontCallback r10) {
        if (shouldLoadFontSynchronously(r5) == false) goto L5;
        getFont(r5);
    L6:
        int r11 = this.fontFamilyResourceId;
        if (r11 != 0) goto L10;
        this.fontResolved = true;
    L10:
        if (this.fontResolved == false) goto L19;
        r10.onFontRetrieved(this.font, true);
        return;
    L19:
        ResourcesCompat.getFont(r5, r11, new AnonymousClass1(this, r10), null);     // Catch: Exception -> L15 Resources.NotFoundException -> L17
    L22:
        return;
    L17:
        this.fontResolved = true;
        r10.onFontRetrievalFailed(1);
        return;
    L15:
        e = move-exception;
        Log.d(TAG, "Error loading font " + this.fontFamily, e);
        this.fontResolved = true;
        r10.onFontRetrievalFailed(-3);
        return;
    L5:
        createFallbackFont();
        goto L6
    }

    @Nullable
    public ColorStateList getTextColor() {
        return this.textColor;
    }

    public float getTextSize() {
        return this.textSize;
    }

    public void setTextColor(@Nullable ColorStateList r5) {
        this.textColor = r5;
    }

    public void setTextSize(float r5) {
        this.textSize = r5;
    }

    public void updateDrawState(@NonNull Context r5, @NonNull TextPaint r10, @NonNull TextAppearanceFontCallback r11) {
        updateMeasureState(r5, r10, r11);
        ColorStateList r12 = this.textColor;
        if (r12 == null) goto L5;
        int r13 = r12.getColorForState(r10.drawableState, r12.getDefaultColor());
    L6:
        r10.setColor(r13);
        float r14 = this.shadowRadius;
        float r15 = this.shadowDx;
        float r16 = this.shadowDy;
        ColorStateList r17 = this.shadowColor;
        if (r17 == null) goto L9;
        int r18 = r17.getColorForState(r10.drawableState, r17.getDefaultColor());
    L10:
        r10.setShadowLayer(r14, r15, r16, r18);
        return;
    L9:
        r18 = 0;
        goto L10
    L5:
        r13 = ViewCompat.MEASURED_STATE_MASK;
        goto L6
    }

    public void updateMeasureState(@NonNull Context r5, @NonNull TextPaint r10, @NonNull TextAppearanceFontCallback r11) {
        if (shouldLoadFontSynchronously(r5) == false) goto L5;
        updateTextPaintMeasureState(r5, r10, getFont(r5));
        return;
    L5:
        getFontAsync(r5, r10, r11);
    }

    public void updateTextPaintMeasureState(@NonNull Context r5, @NonNull TextPaint r10, @NonNull Typeface r11) {
        Typeface r12 = TypefaceUtils.maybeCopyWithFontWeightAdjustment(r5, r11);
        if (r12 == null) goto L5;
        r11 = r12;
    L5:
        r10.setTypeface(r11);
        int r13 = this.textStyle & (~r11.getStyle());
        if ((r13 & 1) == 0) goto L8;
        boolean r14 = true;
    L9:
        r10.setFakeBoldText(r14);
        if ((r13 & 2) == 0) goto L12;
        float r15 = -0.25f;
    L13:
        r10.setTextSkewX(r15);
        r10.setTextSize(this.textSize);
        if (this.hasLetterSpacing == false) goto L17;
        r10.setLetterSpacing(this.letterSpacing);
        return;
    L17:
        return;
    L12:
        r15 = 0.0f;
        goto L13
    L8:
        r14 = false;
        goto L9
    }

    public void getFontAsync(@NonNull final Context r5, @NonNull final TextPaint r10, @NonNull final TextAppearanceFontCallback r11) {
        updateTextPaintMeasureState(r5, r10, getFallbackFont());
        getFontAsync(r5, new AnonymousClass2(this, r5, r10, r11));
    }
}
