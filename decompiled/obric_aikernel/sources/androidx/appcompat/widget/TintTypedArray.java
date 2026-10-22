package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TintTypedArray {
    private final Context mContext;
    private TypedValue mTypedValue;
    private final TypedArray mWrapped;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static int getChangingConfigurations(TypedArray r10) {
            return r10.getChangingConfigurations();
        }

        @DoNotInline
        static int getType(TypedArray r10, int r11) {
            return r10.getType(r11);
        }
    }

    private TintTypedArray(Context r10, TypedArray r11) {
        this.mContext = r10;
        this.mWrapped = r11;
    }

    public static TintTypedArray obtainStyledAttributes(Context r10, int r11, int[] r12) {
        return new TintTypedArray(r10, r10.obtainStyledAttributes(r11, r12));
    }

    public static TintTypedArray obtainStyledAttributes(Context r10, AttributeSet r11, int[] r12) {
        return new TintTypedArray(r10, r10.obtainStyledAttributes(r11, r12));
    }

    public static TintTypedArray obtainStyledAttributes(Context r10, AttributeSet r11, int[] r12, int r13, int r14) {
        return new TintTypedArray(r10, r10.obtainStyledAttributes(r11, r12, r13, r14));
    }

    public boolean getBoolean(int r10, boolean r11) {
        return this.mWrapped.getBoolean(r10, r11);
    }

    @RequiresApi(21)
    public int getChangingConfigurations() {
        return Api21Impl.getChangingConfigurations(this.mWrapped);
    }

    public int getColor(int r10, int r11) {
        return this.mWrapped.getColor(r10, r11);
    }

    public ColorStateList getColorStateList(int r10) {
        if (this.mWrapped.hasValue(r10) == false) goto L10;
        int r11 = this.mWrapped.getResourceId(r10, 0);
        if (r11 == 0) goto L10;
        ColorStateList r12 = AppCompatResources.getColorStateList(this.mContext, r11);
        if (r12 == null) goto L10;
        return r12;
    L10:
        return this.mWrapped.getColorStateList(r10);
    }

    public float getDimension(int r10, float r11) {
        return this.mWrapped.getDimension(r10, r11);
    }

    public int getDimensionPixelOffset(int r10, int r11) {
        return this.mWrapped.getDimensionPixelOffset(r10, r11);
    }

    public int getDimensionPixelSize(int r10, int r11) {
        return this.mWrapped.getDimensionPixelSize(r10, r11);
    }

    public Drawable getDrawable(int r10) {
        if (this.mWrapped.hasValue(r10) == false) goto L9;
        int r11 = this.mWrapped.getResourceId(r10, 0);
        if (r11 == 0) goto L9;
        return AppCompatResources.getDrawable(this.mContext, r11);
    L9:
        return this.mWrapped.getDrawable(r10);
    }

    public Drawable getDrawableIfKnown(int r10) {
        if (this.mWrapped.hasValue(r10) == false) goto L8;
        int r11 = this.mWrapped.getResourceId(r10, 0);
        if (r11 != 0) goto L7;
        return null;
    L7:
        return AppCompatDrawableManager.get().getDrawable(this.mContext, r11, true);
    L8:
        return null;
    }

    public float getFloat(int r10, float r11) {
        return this.mWrapped.getFloat(r10, r11);
    }

    @Nullable
    public Typeface getFont(@StyleableRes int r10, int r11, @Nullable ResourcesCompat.FontCallback r12) {
        int r13 = this.mWrapped.getResourceId(r10, 0);
        if (r13 != 0) goto L7;
        return null;
    L7:
        if (this.mTypedValue != null) goto L10;
        this.mTypedValue = new TypedValue();
    L10:
        return ResourcesCompat.getFont(this.mContext, r13, this.mTypedValue, r11, r12);
    }

    public float getFraction(int r10, int r11, int r12, float r13) {
        return this.mWrapped.getFraction(r10, r11, r12, r13);
    }

    public int getIndex(int r10) {
        return this.mWrapped.getIndex(r10);
    }

    public int getIndexCount() {
        return this.mWrapped.getIndexCount();
    }

    public int getInt(int r10, int r11) {
        return this.mWrapped.getInt(r10, r11);
    }

    public int getInteger(int r10, int r11) {
        return this.mWrapped.getInteger(r10, r11);
    }

    public int getLayoutDimension(int r10, int r11) {
        return this.mWrapped.getLayoutDimension(r10, r11);
    }

    public int getLayoutDimension(int r10, String r11) {
        return this.mWrapped.getLayoutDimension(r10, r11);
    }

    public String getNonResourceString(int r10) {
        return this.mWrapped.getNonResourceString(r10);
    }

    public String getPositionDescription() {
        return this.mWrapped.getPositionDescription();
    }

    public int getResourceId(int r10, int r11) {
        return this.mWrapped.getResourceId(r10, r11);
    }

    public Resources getResources() {
        return this.mWrapped.getResources();
    }

    public String getString(int r10) {
        return this.mWrapped.getString(r10);
    }

    public CharSequence getText(int r10) {
        return this.mWrapped.getText(r10);
    }

    public CharSequence[] getTextArray(int r10) {
        return this.mWrapped.getTextArray(r10);
    }

    public int getType(int r10) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getType(this.mWrapped, r10);
    L7:
        if (this.mTypedValue != null) goto L9;
        this.mTypedValue = new TypedValue();
    L9:
        this.mWrapped.getValue(r10, this.mTypedValue);
        return this.mTypedValue.type;
    }

    public boolean getValue(int r10, TypedValue r11) {
        return this.mWrapped.getValue(r10, r11);
    }

    public TypedArray getWrappedTypeArray() {
        return this.mWrapped;
    }

    public boolean hasValue(int r10) {
        return this.mWrapped.hasValue(r10);
    }

    public int length() {
        return this.mWrapped.length();
    }

    public TypedValue peekValue(int r10) {
        return this.mWrapped.peekValue(r10);
    }

    public void recycle() {
        this.mWrapped.recycle();
    }
}
