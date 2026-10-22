package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.RequiresApi;
import androidx.appcompat.resources.Compatibility;
import androidx.core.content.res.ResourcesCompat;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
class ResourcesWrapper extends Resources {
    private final Resources mResources;

    public ResourcesWrapper(Resources r10) {
        super(r10.getAssets(), r10.getDisplayMetrics(), r10.getConfiguration());
        this.mResources = r10;
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int r10) {
        return this.mResources.getAnimation(r10);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int r10) {
        return this.mResources.getBoolean(r10);
    }

    @Override // android.content.res.Resources
    public int getColor(int r10) {
        return this.mResources.getColor(r10);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int r10) {
        return this.mResources.getColorStateList(r10);
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.mResources.getConfiguration();
    }

    @Override // android.content.res.Resources
    public float getDimension(int r10) {
        return this.mResources.getDimension(r10);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int r10) {
        return this.mResources.getDimensionPixelOffset(r10);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int r10) {
        return this.mResources.getDimensionPixelSize(r10);
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        return this.mResources.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int r10) {
        return this.mResources.getDrawable(r10);
    }

    @Override // android.content.res.Resources
    @RequiresApi(21)
    public Drawable getDrawable(int r10, Resources.Theme r11) {
        return ResourcesCompat.getDrawable(this.mResources, r10, r11);
    }

    final Drawable getDrawableCanonical(int r10) {
        return super.getDrawable(r10);
    }

    @Override // android.content.res.Resources
    @RequiresApi(15)
    public Drawable getDrawableForDensity(int r10, int r11) {
        return ResourcesCompat.getDrawableForDensity(this.mResources, r10, r11, null);
    }

    @Override // android.content.res.Resources
    @RequiresApi(21)
    public Drawable getDrawableForDensity(int r10, int r11, Resources.Theme r12) {
        return ResourcesCompat.getDrawableForDensity(this.mResources, r10, r11, r12);
    }

    @Override // android.content.res.Resources
    public float getFraction(int r10, int r11, int r12) {
        return this.mResources.getFraction(r10, r11, r12);
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String r10, String r11, String r12) {
        return this.mResources.getIdentifier(r10, r11, r12);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int r10) {
        return this.mResources.getIntArray(r10);
    }

    @Override // android.content.res.Resources
    public int getInteger(int r10) {
        return this.mResources.getInteger(r10);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int r10) {
        return this.mResources.getLayout(r10);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int r10) {
        return this.mResources.getMovie(r10);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int r10, int r11) {
        return this.mResources.getQuantityString(r10, r11);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int r10, int r11, Object... r12) {
        return this.mResources.getQuantityString(r10, r11, r12);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int r10, int r11) {
        return this.mResources.getQuantityText(r10, r11);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int r10) {
        return this.mResources.getResourceEntryName(r10);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int r10) {
        return this.mResources.getResourceName(r10);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int r10) {
        return this.mResources.getResourcePackageName(r10);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int r10) {
        return this.mResources.getResourceTypeName(r10);
    }

    @Override // android.content.res.Resources
    public String getString(int r10) {
        return this.mResources.getString(r10);
    }

    @Override // android.content.res.Resources
    public String getString(int r10, Object... r11) {
        return this.mResources.getString(r10, r11);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int r10) {
        return this.mResources.getStringArray(r10);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int r10) {
        return this.mResources.getText(r10);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int r10, CharSequence r11) {
        return this.mResources.getText(r10, r11);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int r10) {
        return this.mResources.getTextArray(r10);
    }

    @Override // android.content.res.Resources
    public void getValue(int r10, TypedValue r11, boolean r12) {
        this.mResources.getValue(r10, r11, r12);
    }

    @Override // android.content.res.Resources
    public void getValue(String r10, TypedValue r11, boolean r12) {
        this.mResources.getValue(r10, r11, r12);
    }

    @Override // android.content.res.Resources
    @RequiresApi(15)
    public void getValueForDensity(int r10, int r11, TypedValue r12, boolean r13) {
        Compatibility.Api15Impl.getValueForDensity(this.mResources, r10, r11, r12, r13);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int r10) {
        return this.mResources.getXml(r10);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet r10, int[] r11) {
        return this.mResources.obtainAttributes(r10, r11);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int r10) {
        return this.mResources.obtainTypedArray(r10);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int r10) {
        return this.mResources.openRawResource(r10);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int r10, TypedValue r11) {
        return this.mResources.openRawResource(r10, r11);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int r10) {
        return this.mResources.openRawResourceFd(r10);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String r10, AttributeSet r11, Bundle r12) {
        this.mResources.parseBundleExtra(r10, r11, r12);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser r10, Bundle r11) {
        this.mResources.parseBundleExtras(r10, r11);
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration r10, DisplayMetrics r11) {
        super.updateConfiguration(r10, r11);
        Resources r12 = this.mResources;
        if (r12 == null) goto L6;
        r12.updateConfiguration(r10, r11);
        return;
    }
}
