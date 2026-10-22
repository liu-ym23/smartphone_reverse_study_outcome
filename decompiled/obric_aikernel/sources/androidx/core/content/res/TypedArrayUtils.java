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

    public static int getAttr(@NonNull Context r10, int r11, int r12) {
        TypedValue r13 = new TypedValue();
        r10.getTheme().resolveAttribute(r11, r13, true);
        if (r13.resourceId == 0) goto L5;
        return r11;
    L5:
        return r12;
    }

    public static boolean getBoolean(@NonNull TypedArray r10, @StyleableRes int r11, @StyleableRes int r12, boolean r13) {
        return r10.getBoolean(r11, r10.getBoolean(r12, r13));
    }

    @Nullable
    public static Drawable getDrawable(@NonNull TypedArray r10, @StyleableRes int r11, @StyleableRes int r12) {
        Drawable r13 = r10.getDrawable(r11);
        if (r13 == null) goto L5;
        return r13;
    L5:
        return r10.getDrawable(r12);
    }

    public static int getInt(@NonNull TypedArray r10, @StyleableRes int r11, @StyleableRes int r12, int r13) {
        return r10.getInt(r11, r10.getInt(r12, r13));
    }

    public static boolean getNamedBoolean(@NonNull TypedArray r10, @NonNull XmlPullParser r11, @NonNull String r12, @StyleableRes int r13, boolean r14) {
        if (hasAttribute(r11, r12) == true) goto L6;
        return r14;
    L6:
        return r10.getBoolean(r13, r14);
    }

    @ColorInt
    public static int getNamedColor(@NonNull TypedArray r10, @NonNull XmlPullParser r11, @NonNull String r12, @StyleableRes int r13, @ColorInt int r14) {
        if (hasAttribute(r11, r12) == true) goto L6;
        return r14;
    L6:
        return r10.getColor(r13, r14);
    }

    @Nullable
    public static ColorStateList getNamedColorStateList(@NonNull TypedArray r10, @NonNull XmlPullParser r11, @Nullable Resources.Theme r12, @NonNull String r13, @StyleableRes int r14) {
        if (hasAttribute(r11, r13) == false) goto L16;
        TypedValue r15 = new TypedValue();
        r10.getValue(r14, r15);
        int r16 = r15.type;
        if (r16 == 2) goto L15;
        if (r16 < 28) goto L13;
        if (r16 > 31) goto L13;
        return getNamedColorStateListFromInt(r15);
    L13:
        return ColorStateListInflaterCompat.inflate(r10.getResources(), r10.getResourceId(r14, 0), r12);
    L15:
        throw new UnsupportedOperationException("Failed to resolve attribute at index " + r14 + ": " + r15);
    L16:
        return null;
    }

    @NonNull
    private static ColorStateList getNamedColorStateListFromInt(@NonNull TypedValue r10) {
        return ColorStateList.valueOf(r10.data);
    }

    public static ComplexColorCompat getNamedComplexColor(@NonNull TypedArray r10, @NonNull XmlPullParser r11, @Nullable Resources.Theme r12, @NonNull String r13, @StyleableRes int r14, @ColorInt int r15) {
        if (hasAttribute(r11, r13) == false) goto L14;
        TypedValue r16 = new TypedValue();
        r10.getValue(r14, r16);
        int r17 = r16.type;
        if (r17 >= 28) goto L7;
    L10:
        ComplexColorCompat r18 = ComplexColorCompat.inflate(r10.getResources(), r10.getResourceId(r14, 0), r12);
        if (r18 == null) goto L14;
        return r18;
    L7:
        if (r17 > 31) goto L10;
        return ComplexColorCompat.from(r16.data);
    L14:
        return ComplexColorCompat.from(r15);
    }

    public static float getNamedFloat(@NonNull TypedArray r10, @NonNull XmlPullParser r11, @NonNull String r12, @StyleableRes int r13, float r14) {
        if (hasAttribute(r11, r12) == true) goto L6;
        return r14;
    L6:
        return r10.getFloat(r13, r14);
    }

    public static int getNamedInt(@NonNull TypedArray r10, @NonNull XmlPullParser r11, @NonNull String r12, @StyleableRes int r13, int r14) {
        if (hasAttribute(r11, r12) == true) goto L6;
        return r14;
    L6:
        return r10.getInt(r13, r14);
    }

    @AnyRes
    public static int getNamedResourceId(@NonNull TypedArray r10, @NonNull XmlPullParser r11, @NonNull String r12, @StyleableRes int r13, @AnyRes int r14) {
        if (hasAttribute(r11, r12) == true) goto L6;
        return r14;
    L6:
        return r10.getResourceId(r13, r14);
    }

    @Nullable
    public static String getNamedString(@NonNull TypedArray r10, @NonNull XmlPullParser r11, @NonNull String r12, @StyleableRes int r13) {
        if (hasAttribute(r11, r12) == true) goto L7;
        return null;
    L7:
        return r10.getString(r13);
    }

    @AnyRes
    public static int getResourceId(@NonNull TypedArray r10, @StyleableRes int r11, @StyleableRes int r12, @AnyRes int r13) {
        return r10.getResourceId(r11, r10.getResourceId(r12, r13));
    }

    @Nullable
    public static String getString(@NonNull TypedArray r10, @StyleableRes int r11, @StyleableRes int r12) {
        String r13 = r10.getString(r11);
        if (r13 == null) goto L5;
        return r13;
    L5:
        return r10.getString(r12);
    }

    @Nullable
    public static CharSequence getText(@NonNull TypedArray r10, @StyleableRes int r11, @StyleableRes int r12) {
        CharSequence r13 = r10.getText(r11);
        if (r13 == null) goto L5;
        return r13;
    L5:
        return r10.getText(r12);
    }

    @Nullable
    public static CharSequence[] getTextArray(@NonNull TypedArray r10, @StyleableRes int r11, @StyleableRes int r12) {
        CharSequence[] r13 = r10.getTextArray(r11);
        if (r13 == null) goto L5;
        return r13;
    L5:
        return r10.getTextArray(r12);
    }

    public static boolean hasAttribute(@NonNull XmlPullParser r10, @NonNull String r11) {
        if (r10.getAttributeValue(NAMESPACE, r11) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @NonNull
    public static TypedArray obtainAttributes(@NonNull Resources r10, @Nullable Resources.Theme r11, @NonNull AttributeSet r12, @NonNull int[] r13) {
        if (r11 != null) goto L6;
        return r10.obtainAttributes(r12, r13);
    L6:
        return r11.obtainStyledAttributes(r12, r13, 0, 0);
    }

    @Nullable
    public static TypedValue peekNamedValue(@NonNull TypedArray r10, @NonNull XmlPullParser r11, @NonNull String r12, int r13) {
        if (hasAttribute(r11, r12) == true) goto L7;
        return null;
    L7:
        return r10.peekValue(r13);
    }
}
