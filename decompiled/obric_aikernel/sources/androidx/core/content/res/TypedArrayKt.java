package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class TypedArrayKt {
    private static final void checkAttribute(TypedArray r10, @StyleableRes int r11) {
        if (r10.hasValue(r11) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Attribute not defined in set.");
    }

    public static final boolean getBooleanOrThrow(TypedArray r10, @StyleableRes int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        checkAttribute(r10, r11);
        return r10.getBoolean(r11, false);
    }

    @ColorInt
    public static final int getColorOrThrow(TypedArray r10, @StyleableRes int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        checkAttribute(r10, r11);
        return r10.getColor(r11, 0);
    }

    public static final ColorStateList getColorStateListOrThrow(TypedArray r10, @StyleableRes int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        checkAttribute(r10, r11);
        ColorStateList r12 = r10.getColorStateList(r11);
        if (r12 == null) goto L6;
        return r12;
    L6:
        throw new IllegalStateException("Attribute value was not a color or color state list.".toString());
    }

    public static final float getDimensionOrThrow(TypedArray r10, @StyleableRes int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        checkAttribute(r10, r11);
        return r10.getDimension(r11, 0.0f);
    }

    @Dimension
    public static final int getDimensionPixelOffsetOrThrow(TypedArray r10, @StyleableRes int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        checkAttribute(r10, r11);
        return r10.getDimensionPixelOffset(r11, 0);
    }

    @Dimension
    public static final int getDimensionPixelSizeOrThrow(TypedArray r10, @StyleableRes int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        checkAttribute(r10, r11);
        return r10.getDimensionPixelSize(r11, 0);
    }

    public static final Drawable getDrawableOrThrow(TypedArray r10, @StyleableRes int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        checkAttribute(r10, r11);
        Drawable r12 = r10.getDrawable(r11);
        Intrinsics.checkNotNull(r12);
        return r12;
    }

    public static final float getFloatOrThrow(TypedArray r10, @StyleableRes int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        checkAttribute(r10, r11);
        return r10.getFloat(r11, 0.0f);
    }

    @RequiresApi(26)
    public static final Typeface getFontOrThrow(TypedArray r10, @StyleableRes int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        checkAttribute(r10, r11);
        return TypedArrayApi26ImplKt.getFont(r10, r11);
    }

    public static final int getIntOrThrow(TypedArray r10, @StyleableRes int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        checkAttribute(r10, r11);
        return r10.getInt(r11, 0);
    }

    public static final int getIntegerOrThrow(TypedArray r10, @StyleableRes int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        checkAttribute(r10, r11);
        return r10.getInteger(r11, 0);
    }

    @AnyRes
    public static final int getResourceIdOrThrow(TypedArray r10, @StyleableRes int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        checkAttribute(r10, r11);
        return r10.getResourceId(r11, 0);
    }

    public static final String getStringOrThrow(TypedArray r10, @StyleableRes int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        checkAttribute(r10, r11);
        String r12 = r10.getString(r11);
        if (r12 == null) goto L6;
        return r12;
    L6:
        throw new IllegalStateException("Attribute value could not be coerced to String.".toString());
    }

    public static final CharSequence[] getTextArrayOrThrow(TypedArray r10, @StyleableRes int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        checkAttribute(r10, r11);
        CharSequence[] r12 = r10.getTextArray(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "getTextArray(index)");
        return r12;
    }

    public static final CharSequence getTextOrThrow(TypedArray r10, @StyleableRes int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        checkAttribute(r10, r11);
        CharSequence r12 = r10.getText(r11);
        if (r12 == null) goto L6;
        return r12;
    L6:
        throw new IllegalStateException("Attribute value could not be coerced to CharSequence.".toString());
    }

    public static final <R> R use(TypedArray r10, Function1<? super TypedArray, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "block");
        R r12 = r11.invoke(r10);
        r10.recycle();
        return r12;
    }
}
