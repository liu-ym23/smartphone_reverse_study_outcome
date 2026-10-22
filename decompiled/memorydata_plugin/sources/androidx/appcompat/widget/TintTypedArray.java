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
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class TintTypedArray {
    private final Context mContext;
    private TypedValue mTypedValue;
    private final TypedArray mWrapped;

    static class Api21Impl {
        private Api21Impl() {
        }

        static int getChangingConfigurations(TypedArray r0) {
            return r0.getChangingConfigurations();
        }

        static int getType(TypedArray r0, int r1) {
            return r0.getType(r1);
        }
    }

    private TintTypedArray(Context r3, TypedArray r4) {
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.mWrapped = r4;
    }

    public static TintTypedArray obtainStyledAttributes(Context r2, int r3, int[] r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return new TintTypedArray(r5, r5.obtainStyledAttributes(r3, r4));
    }

    public static TintTypedArray obtainStyledAttributes(Context r2, AttributeSet r3, int[] r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return new TintTypedArray(r5, r5.obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"), r4));
    }

    public static TintTypedArray obtainStyledAttributes(Context r2, AttributeSet r3, int[] r4, int r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return new TintTypedArray(r7, r7.obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"), r4, r5, r6));
    }

    public boolean getBoolean(int r1, boolean r2) {
        return this.mWrapped.getBoolean(r1, r2);
    }

    public int getChangingConfigurations() {
        return Api21Impl.getChangingConfigurations(this.mWrapped);
    }

    public int getColor(int r1, int r2) {
        return this.mWrapped.getColor(r1, r2);
    }

    public ColorStateList getColorStateList(int r3) {
        if (this.mWrapped.hasValue(r3) == false) goto L10;
        int r0 = this.mWrapped.getResourceId(r3, 0);
        if (r0 == 0) goto L10;
        ColorStateList r1 = AppCompatResources.getColorStateList(this.mContext, r0);
        if (r1 == null) goto L10;
        return r1;
    L10:
        return this.mWrapped.getColorStateList(r3);
    }

    public float getDimension(int r1, float r2) {
        return this.mWrapped.getDimension(r1, r2);
    }

    public int getDimensionPixelOffset(int r1, int r2) {
        return this.mWrapped.getDimensionPixelOffset(r1, r2);
    }

    public int getDimensionPixelSize(int r1, int r2) {
        return this.mWrapped.getDimensionPixelSize(r1, r2);
    }

    public Drawable getDrawable(int r3) {
        if (this.mWrapped.hasValue(r3) == false) goto L9;
        int r0 = this.mWrapped.getResourceId(r3, 0);
        if (r0 == 0) goto L9;
        return AppCompatResources.getDrawable(this.mContext, r0);
    L9:
        return this.mWrapped.getDrawable(r3);
    }

    public Drawable getDrawableIfKnown(int r3) {
        if (this.mWrapped.hasValue(r3) == false) goto L8;
        int r4 = this.mWrapped.getResourceId(r3, 0);
        if (r4 != 0) goto L7;
        return null;
    L7:
        return AppCompatDrawableManager.get().getDrawable(this.mContext, r4, true);
    L8:
        return null;
    }

    public float getFloat(int r1, float r2) {
        return this.mWrapped.getFloat(r1, r2);
    }

    public Typeface getFont(int r3, int r4, ResourcesCompat.FontCallback r5) {
        int r6 = this.mWrapped.getResourceId(r3, 0);
        if (r6 != 0) goto L7;
        return null;
    L7:
        if (this.mTypedValue != null) goto L10;
        this.mTypedValue = new TypedValue();
    L10:
        return ResourcesCompat.getFont(this.mContext, r6, this.mTypedValue, r4, r5);
    }

    public float getFraction(int r1, int r2, int r3, float r4) {
        return this.mWrapped.getFraction(r1, r2, r3, r4);
    }

    public int getIndex(int r1) {
        return this.mWrapped.getIndex(r1);
    }

    public int getIndexCount() {
        return this.mWrapped.getIndexCount();
    }

    public int getInt(int r1, int r2) {
        return this.mWrapped.getInt(r1, r2);
    }

    public int getInteger(int r1, int r2) {
        return this.mWrapped.getInteger(r1, r2);
    }

    public int getLayoutDimension(int r1, int r2) {
        return this.mWrapped.getLayoutDimension(r1, r2);
    }

    public int getLayoutDimension(int r1, String r2) {
        return this.mWrapped.getLayoutDimension(r1, r2);
    }

    public String getNonResourceString(int r1) {
        return this.mWrapped.getNonResourceString(r1);
    }

    public String getPositionDescription() {
        return this.mWrapped.getPositionDescription();
    }

    public int getResourceId(int r1, int r2) {
        return this.mWrapped.getResourceId(r1, r2);
    }

    public Resources getResources() {
        return ZeusTransformUtils.getResources(this.mWrapped, "com.obric.memorydata.plugin");
    }

    public String getString(int r1) {
        return this.mWrapped.getString(r1);
    }

    public CharSequence getText(int r1) {
        return this.mWrapped.getText(r1);
    }

    public CharSequence[] getTextArray(int r1) {
        return this.mWrapped.getTextArray(r1);
    }

    public int getType(int r3) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getType(this.mWrapped, r3);
    L7:
        if (this.mTypedValue != null) goto L9;
        this.mTypedValue = new TypedValue();
    L9:
        this.mWrapped.getValue(r3, this.mTypedValue);
        return this.mTypedValue.type;
    }

    public boolean getValue(int r1, TypedValue r2) {
        return this.mWrapped.getValue(r1, r2);
    }

    public TypedArray getWrappedTypeArray() {
        return this.mWrapped;
    }

    public boolean hasValue(int r1) {
        return this.mWrapped.hasValue(r1);
    }

    public int length() {
        return this.mWrapped.length();
    }

    public TypedValue peekValue(int r1) {
        return this.mWrapped.peekValue(r1);
    }

    public void recycle() {
        this.mWrapped.recycle();
    }
}
