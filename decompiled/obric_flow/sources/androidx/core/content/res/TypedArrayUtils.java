package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TypedArrayUtils {
    private static final String NAMESPACE = "http://schemas.android.com/apk/res/android";

    private TypedArrayUtils() {
    }

    public static int getAttr(@NonNull Context r5, int r10, int r11) {
        TypedValue r12 = new TypedValue();
        r5.getTheme().resolveAttribute(r10, r12, true);
        if (r12.resourceId == 0) goto L5;
        return r10;
    L5:
        return r11;
    }

    public static boolean getBoolean(@NonNull TypedArray r5, @StyleableRes int r10, @StyleableRes int r11, boolean r12) {
        return r5.getBoolean(r10, r5.getBoolean(r11, r12));
    }

    @Nullable
    public static Drawable getDrawable(@NonNull TypedArray r5, @StyleableRes int r10, @StyleableRes int r11) {
        Drawable r12 = r5.getDrawable(r10);
        if (r12 == null) goto L5;
        return r12;
    L5:
        return r5.getDrawable(r11);
    }

    public static int getInt(@NonNull TypedArray r5, @StyleableRes int r10, @StyleableRes int r11, int r12) {
        return r5.getInt(r10, r5.getInt(r11, r12));
    }

    public static boolean getNamedBoolean(@NonNull TypedArray r5, @NonNull XmlPullParser r10, @NonNull String r11, @StyleableRes int r12, boolean r13) {
        if (hasAttribute(r10, r11) == true) goto L6;
        return r13;
    L6:
        return r5.getBoolean(r12, r13);
    }

    @ColorInt
    public static int getNamedColor(@NonNull TypedArray r5, @NonNull XmlPullParser r10, @NonNull String r11, @StyleableRes int r12, @ColorInt int r13) {
        if (hasAttribute(r10, r11) == true) goto L6;
        return r13;
    L6:
        return r5.getColor(r12, r13);
    }

    @Nullable
    public static ColorStateList getNamedColorStateList(@NonNull TypedArray r5, @NonNull XmlPullParser r10, @Nullable Resources.Theme r11, @NonNull String r12, @StyleableRes int r13) {
        if (hasAttribute(r10, r12) == false) goto L16;
        TypedValue r14 = new TypedValue();
        r5.getValue(r13, r14);
        int r15 = r14.type;
        if (r15 == 2) goto L15;
        if (r15 < 28) goto L13;
        if (r15 > 31) goto L13;
        return getNamedColorStateListFromInt(r14);
    L13:
        return ColorStateListInflaterCompat.inflate(r5.getResources(), r5.getResourceId(r13, 0), r11);
    L15:
        throw new UnsupportedOperationException("Failed to resolve attribute at index " + r13 + ": " + r14);
    L16:
        return null;
    }

    @NonNull
    private static ColorStateList getNamedColorStateListFromInt(@NonNull TypedValue r5) {
        return ColorStateList.valueOf(r5.data);
    }

    public static ComplexColorCompat getNamedComplexColor(@NonNull TypedArray r5, @NonNull XmlPullParser r10, @Nullable Resources.Theme r11, @NonNull String r12, @StyleableRes int r13, @ColorInt int r14) {
        if (hasAttribute(r10, r12) == false) goto L14;
        TypedValue r15 = new TypedValue();
        r5.getValue(r13, r15);
        int r16 = r15.type;
        if (r16 >= 28) goto L7;
    L10:
        ComplexColorCompat r17 = ComplexColorCompat.inflate(r5.getResources(), r5.getResourceId(r13, 0), r11);
        if (r17 == null) goto L14;
        return r17;
    L7:
        if (r16 > 31) goto L10;
        return ComplexColorCompat.from(r15.data);
    L14:
        return ComplexColorCompat.from(r14);
    }

    public static float getNamedFloat(@NonNull TypedArray r5, @NonNull XmlPullParser r10, @NonNull String r11, @StyleableRes int r12, float r13) {
        if (hasAttribute(r10, r11) == true) goto L6;
        return r13;
    L6:
        return r5.getFloat(r12, r13);
    }

    public static int getNamedInt(@NonNull TypedArray r5, @NonNull XmlPullParser r10, @NonNull String r11, @StyleableRes int r12, int r13) {
        if (hasAttribute(r10, r11) == true) goto L6;
        return r13;
    L6:
        return r5.getInt(r12, r13);
    }

    @AnyRes
    public static int getNamedResourceId(@NonNull TypedArray r5, @NonNull XmlPullParser r10, @NonNull String r11, @StyleableRes int r12, @AnyRes int r13) {
        if (hasAttribute(r10, r11) == true) goto L6;
        return r13;
    L6:
        return r5.getResourceId(r12, r13);
    }

    @Nullable
    public static String getNamedString(@NonNull TypedArray r5, @NonNull XmlPullParser r10, @NonNull String r11, @StyleableRes int r12) {
        if (hasAttribute(r10, r11) == true) goto L7;
        return null;
    L7:
        return r5.getString(r12);
    }

    @AnyRes
    public static int getResourceId(@NonNull TypedArray r5, @StyleableRes int r10, @StyleableRes int r11, @AnyRes int r12) {
        return r5.getResourceId(r10, r5.getResourceId(r11, r12));
    }

    @Nullable
    public static String getString(@NonNull TypedArray r5, @StyleableRes int r10, @StyleableRes int r11) {
        String r12 = r5.getString(r10);
        if (r12 == null) goto L5;
        return r12;
    L5:
        return r5.getString(r11);
    }

    @Nullable
    public static CharSequence getText(@NonNull TypedArray r5, @StyleableRes int r10, @StyleableRes int r11) {
        CharSequence r12 = r5.getText(r10);
        if (r12 == null) goto L5;
        return r12;
    L5:
        return r5.getText(r11);
    }

    @Nullable
    public static CharSequence[] getTextArray(@NonNull TypedArray r5, @StyleableRes int r10, @StyleableRes int r11) {
        CharSequence[] r12 = r5.getTextArray(r10);
        if (r12 == null) goto L5;
        return r12;
    L5:
        return r5.getTextArray(r11);
    }

    public static boolean hasAttribute(@NonNull XmlPullParser r5, @NonNull String r10) {
        if (r5.getAttributeValue(NAMESPACE, r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @NonNull
    public static TypedArray obtainAttributes(@NonNull Resources r5, @Nullable Resources.Theme r10, @NonNull AttributeSet r11, @NonNull int[] r12) {
        if (r10 != null) goto L6;
        return r5.obtainAttributes(r11, r12);
    L6:
        return r10.obtainStyledAttributes(r11, r12, 0, 0);
    }

    @Nullable
    public static TypedValue peekNamedValue(@NonNull TypedArray r5, @NonNull XmlPullParser r10, @NonNull String r11, int r12) {
        if (hasAttribute(r10, r11) == true) goto L7;
        return null;
    L7:
        return r5.peekValue(r12);
    }
}
