package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
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
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static int getChangingConfigurations(TypedArray r5) {
            return r5.getChangingConfigurations();
        }

        @DoNotInline
        public static int getType(TypedArray r5, int r10) {
            return r5.getType(r10);
        }
    }

    private TintTypedArray(Context r5, TypedArray r10) {
        this.mContext = r5;
        this.mWrapped = r10;
    }

    public static TintTypedArray obtainStyledAttributes(Context r5, AttributeSet r10, int[] r11) {
        return new TintTypedArray(r5, r5.obtainStyledAttributes(r10, r11));
    }

    public boolean getBoolean(int r5, boolean r10) {
        return this.mWrapped.getBoolean(r5, r10);
    }

    @RequiresApi(21)
    public int getChangingConfigurations() {
        return Api21Impl.getChangingConfigurations(this.mWrapped);
    }

    public int getColor(int r5, int r10) {
        return this.mWrapped.getColor(r5, r10);
    }

    public ColorStateList getColorStateList(int r5) {
        if (this.mWrapped.hasValue(r5) == false) goto L10;
        int r10 = this.mWrapped.getResourceId(r5, 0);
        if (r10 == 0) goto L10;
        ColorStateList r11 = AppCompatResources.getColorStateList(this.mContext, r10);
        if (r11 == null) goto L10;
        return r11;
    L10:
        return this.mWrapped.getColorStateList(r5);
    }

    public float getDimension(int r5, float r10) {
        return this.mWrapped.getDimension(r5, r10);
    }

    public int getDimensionPixelOffset(int r5, int r10) {
        return this.mWrapped.getDimensionPixelOffset(r5, r10);
    }

    public int getDimensionPixelSize(int r5, int r10) {
        return this.mWrapped.getDimensionPixelSize(r5, r10);
    }

    public Drawable getDrawable(int r5) {
        if (this.mWrapped.hasValue(r5) == false) goto L9;
        int r10 = this.mWrapped.getResourceId(r5, 0);
        if (r10 == 0) goto L9;
        return AppCompatResources.getDrawable(this.mContext, r10);
    L9:
        return this.mWrapped.getDrawable(r5);
    }

    public Drawable getDrawableIfKnown(int r5) {
        if (this.mWrapped.hasValue(r5) == false) goto L8;
        int r10 = this.mWrapped.getResourceId(r5, 0);
        if (r10 != 0) goto L7;
        return null;
    L7:
        return AppCompatDrawableManager.get().getDrawable(this.mContext, r10, true);
    L8:
        return null;
    }

    public float getFloat(int r5, float r10) {
        return this.mWrapped.getFloat(r5, r10);
    }

    @Nullable
    public Typeface getFont(@StyleableRes int r5, int r10, @Nullable ResourcesCompat.FontCallback r11) {
        int r12 = this.mWrapped.getResourceId(r5, 0);
        if (r12 != 0) goto L7;
        return null;
    L7:
        if (this.mTypedValue != null) goto L10;
        this.mTypedValue = new TypedValue();
    L10:
        return ResourcesCompat.getFont(this.mContext, r12, this.mTypedValue, r10, r11);
    }

    public float getFraction(int r5, int r10, int r11, float r12) {
        return this.mWrapped.getFraction(r5, r10, r11, r12);
    }

    public int getIndex(int r5) {
        return this.mWrapped.getIndex(r5);
    }

    public int getIndexCount() {
        return this.mWrapped.getIndexCount();
    }

    public int getInt(int r5, int r10) {
        return this.mWrapped.getInt(r5, r10);
    }

    public int getInteger(int r5, int r10) {
        return this.mWrapped.getInteger(r5, r10);
    }

    public int getLayoutDimension(int r5, String r10) {
        return this.mWrapped.getLayoutDimension(r5, r10);
    }

    public String getNonResourceString(int r5) {
        return this.mWrapped.getNonResourceString(r5);
    }

    public String getPositionDescription() {
        return this.mWrapped.getPositionDescription();
    }

    public int getResourceId(int r5, int r10) {
        return this.mWrapped.getResourceId(r5, r10);
    }

    public Resources getResources() {
        return this.mWrapped.getResources();
    }

    public String getString(int r5) {
        return this.mWrapped.getString(r5);
    }

    public CharSequence getText(int r5) {
        return this.mWrapped.getText(r5);
    }

    public CharSequence[] getTextArray(int r5) {
        return this.mWrapped.getTextArray(r5);
    }

    public int getType(int r5) {
        return Api21Impl.getType(this.mWrapped, r5);
    }

    public boolean getValue(int r5, TypedValue r10) {
        return this.mWrapped.getValue(r5, r10);
    }

    public TypedArray getWrappedTypeArray() {
        return this.mWrapped;
    }

    public boolean hasValue(int r5) {
        return this.mWrapped.hasValue(r5);
    }

    public int length() {
        return this.mWrapped.length();
    }

    public TypedValue peekValue(int r5) {
        return this.mWrapped.peekValue(r5);
    }

    public void recycle() {
        this.mWrapped.recycle();
    }

    public static TintTypedArray obtainStyledAttributes(Context r5, AttributeSet r10, int[] r11, int r12, int r13) {
        return new TintTypedArray(r5, r5.obtainStyledAttributes(r10, r11, r12, r13));
    }

    public int getLayoutDimension(int r5, int r10) {
        return this.mWrapped.getLayoutDimension(r5, r10);
    }

    public static TintTypedArray obtainStyledAttributes(Context r5, int r10, int[] r11) {
        return new TintTypedArray(r5, r5.obtainStyledAttributes(r10, r11));
    }
}
