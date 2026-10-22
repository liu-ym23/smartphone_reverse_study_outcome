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
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
class ResourcesWrapper extends Resources {
    private final Resources mResources;

    public ResourcesWrapper(Resources r5) {
        super(r5.getAssets(), r5.getDisplayMetrics(), r5.getConfiguration());
        this.mResources = r5;
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int r5) throws Resources.NotFoundException {
        return this.mResources.getAnimation(r5);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int r5) throws Resources.NotFoundException {
        return this.mResources.getBoolean(r5);
    }

    @Override // android.content.res.Resources
    public int getColor(int r5) throws Resources.NotFoundException {
        return this.mResources.getColor(r5);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int r5) throws Resources.NotFoundException {
        return this.mResources.getColorStateList(r5);
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.mResources.getConfiguration();
    }

    @Override // android.content.res.Resources
    public float getDimension(int r5) throws Resources.NotFoundException {
        return this.mResources.getDimension(r5);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int r5) throws Resources.NotFoundException {
        return this.mResources.getDimensionPixelOffset(r5);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int r5) throws Resources.NotFoundException {
        return this.mResources.getDimensionPixelSize(r5);
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        return this.mResources.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int r5) throws Resources.NotFoundException {
        return this.mResources.getDrawable(r5);
    }

    public final Drawable getDrawableCanonical(int r5) throws Resources.NotFoundException {
        return super.getDrawable(r5);
    }

    @Override // android.content.res.Resources
    @RequiresApi(15)
    public Drawable getDrawableForDensity(int r5, int r10) throws Resources.NotFoundException {
        return ResourcesCompat.getDrawableForDensity(this.mResources, r5, r10, null);
    }

    @Override // android.content.res.Resources
    public float getFraction(int r5, int r10, int r11) {
        return this.mResources.getFraction(r5, r10, r11);
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String r5, String r10, String r11) {
        return this.mResources.getIdentifier(r5, r10, r11);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int r5) throws Resources.NotFoundException {
        return this.mResources.getIntArray(r5);
    }

    @Override // android.content.res.Resources
    public int getInteger(int r5) throws Resources.NotFoundException {
        return this.mResources.getInteger(r5);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int r5) throws Resources.NotFoundException {
        return this.mResources.getLayout(r5);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int r5) throws Resources.NotFoundException {
        return this.mResources.getMovie(r5);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int r5, int r10, Object... r11) throws Resources.NotFoundException {
        return this.mResources.getQuantityString(r5, r10, r11);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int r5, int r10) throws Resources.NotFoundException {
        return this.mResources.getQuantityText(r5, r10);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int r5) throws Resources.NotFoundException {
        return this.mResources.getResourceEntryName(r5);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int r5) throws Resources.NotFoundException {
        return this.mResources.getResourceName(r5);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int r5) throws Resources.NotFoundException {
        return this.mResources.getResourcePackageName(r5);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int r5) throws Resources.NotFoundException {
        return this.mResources.getResourceTypeName(r5);
    }

    @Override // android.content.res.Resources
    public String getString(int r5) throws Resources.NotFoundException {
        return this.mResources.getString(r5);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int r5) throws Resources.NotFoundException {
        return this.mResources.getStringArray(r5);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int r5) throws Resources.NotFoundException {
        return this.mResources.getText(r5);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int r5) throws Resources.NotFoundException {
        return this.mResources.getTextArray(r5);
    }

    @Override // android.content.res.Resources
    public void getValue(int r5, TypedValue r10, boolean r11) throws Resources.NotFoundException {
        this.mResources.getValue(r5, r10, r11);
    }

    @Override // android.content.res.Resources
    @RequiresApi(15)
    public void getValueForDensity(int r5, int r10, TypedValue r11, boolean r12) throws Resources.NotFoundException {
        Compatibility.Api15Impl.getValueForDensity(this.mResources, r5, r10, r11, r12);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int r5) throws Resources.NotFoundException {
        return this.mResources.getXml(r5);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet r5, int[] r10) {
        return this.mResources.obtainAttributes(r5, r10);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int r5) throws Resources.NotFoundException {
        return this.mResources.obtainTypedArray(r5);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int r5) throws Resources.NotFoundException {
        return this.mResources.openRawResource(r5);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int r5) throws Resources.NotFoundException {
        return this.mResources.openRawResourceFd(r5);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String r5, AttributeSet r10, Bundle r11) throws XmlPullParserException {
        this.mResources.parseBundleExtra(r5, r10, r11);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser r5, Bundle r10) throws XmlPullParserException, IOException {
        this.mResources.parseBundleExtras(r5, r10);
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration r5, DisplayMetrics r10) {
        super.updateConfiguration(r5, r10);
        Resources r11 = this.mResources;
        if (r11 == null) goto L6;
        r11.updateConfiguration(r5, r10);
        return;
    }

    @Override // android.content.res.Resources
    @RequiresApi(21)
    public Drawable getDrawable(int r5, Resources.Theme r10) throws Resources.NotFoundException {
        return ResourcesCompat.getDrawable(this.mResources, r5, r10);
    }

    @Override // android.content.res.Resources
    @RequiresApi(21)
    public Drawable getDrawableForDensity(int r5, int r10, Resources.Theme r11) {
        return ResourcesCompat.getDrawableForDensity(this.mResources, r5, r10, r11);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int r5, int r10) throws Resources.NotFoundException {
        return this.mResources.getQuantityString(r5, r10);
    }

    @Override // android.content.res.Resources
    public String getString(int r5, Object... r10) throws Resources.NotFoundException {
        return this.mResources.getString(r5, r10);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int r5, CharSequence r10) {
        return this.mResources.getText(r5, r10);
    }

    @Override // android.content.res.Resources
    public void getValue(String r5, TypedValue r10, boolean r11) throws Resources.NotFoundException {
        this.mResources.getValue(r5, r10, r11);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int r5, TypedValue r10) throws Resources.NotFoundException {
        return this.mResources.openRawResource(r5, r10);
    }
}
