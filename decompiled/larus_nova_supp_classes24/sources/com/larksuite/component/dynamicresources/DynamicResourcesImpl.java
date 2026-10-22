package com.larksuite.component.dynamicresources;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.util.TypedValue;
import com.larksuite.framework.utils.Reflect;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class DynamicResourcesImpl extends Resources {
    public static final int ID_CACHE_SIZE = 3000;
    private static final String TAG = "DynamicResources";
    private static LruCache<Integer, Integer> sIdCache;
    private final c mCharSequenceResourcesRetriever;
    private final d mColorResourcesRetriever;
    private final e mColorStateListResourcesRetriever;
    private final f mDrawableResourcesRetriever;
    private final Resources mDynamicResources;
    private final String mDynamicResourcesPkgName;
    boolean mInited;
    private final g mStringResourcesRetriever;
    private final Resources mSysResources;

    public abstract class a {
        public int getResources(int r4) {
            com.larksuite.component.dynamicresources.a.a.getClass();
            throw null;     // Catch: Exception -> L4
        L4:
            e = move-exception;
            Log.e(DynamicResourcesImpl.TAG, "null error : " + e);
            int r0 = DynamicResourcesImpl.ID_CACHE_SIZE;
            throw null;
        }

        public int getResources(int r3, Resources.Theme r4) {
            com.larksuite.component.dynamicresources.a.a.getClass();
            throw null;     // Catch: Exception -> L4
        L4:
            e = move-exception;
            Log.e(DynamicResourcesImpl.TAG, "null error : " + e);
            int r5 = DynamicResourcesImpl.ID_CACHE_SIZE;
            throw null;
        }
    }

    public abstract class b<T> {
        public T getResources(int r5) {
            com.larksuite.component.dynamicresources.a.a.getClass();
            throw null;     // Catch: Exception -> L4
        L4:
            e = move-exception;
            Log.w(DynamicResourcesImpl.TAG, "null error, fallback to system resources: " + e);
            int r0 = DynamicResourcesImpl.ID_CACHE_SIZE;     // Catch: Resources.NotFoundException -> L8
            throw null;     // Catch: Resources.NotFoundException -> L8
        L8:
            e = move-exception;
            Log.e(DynamicResourcesImpl.TAG, "null also not found in system resources: " + e);
            com.larksuite.component.dynamicresources.a.a.getClass();
            return null;
        }

        public T getResources(int r4, Resources.Theme r5) {
            com.larksuite.component.dynamicresources.a.a.getClass();
            throw null;     // Catch: Exception -> L4
        L4:
            e = move-exception;
            Log.w(DynamicResourcesImpl.TAG, "null error, fallback to system resources: " + e);
            int r6 = DynamicResourcesImpl.ID_CACHE_SIZE;     // Catch: Resources.NotFoundException -> L8
            throw null;     // Catch: Resources.NotFoundException -> L8
        L8:
            e = move-exception;
            Log.e(DynamicResourcesImpl.TAG, "null also not found in system resources: " + e);
            com.larksuite.component.dynamicresources.a.a.getClass();
            return null;
        }
    }

    public class c extends b<CharSequence> {
    }

    public class d extends a {
    }

    public class e extends b<ColorStateList> {
    }

    public class f extends b<Drawable> {
    }

    public class g extends b<String> {
    }

    @Override // android.content.res.Resources
    public final Configuration getConfiguration() {
        if (this.mInited == true) goto L7;
        return super.getConfiguration();
    L7:
        return this.mSysResources.getConfiguration();
    }

    @Override // android.content.res.Resources
    public final DisplayMetrics getDisplayMetrics() {
        if (this.mInited == false) goto L5;
        Resources r0 = this.mSysResources;
        return WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics());
    L5:
        return WindowDisplayMetricsOverride.apply(this, super.getDisplayMetrics());
    }

    @Override // android.content.res.Resources
    public final XmlResourceParser getAnimation(int r2) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getAnimation(r2);
    L7:
        return this.mSysResources.getAnimation(r2);
    }

    @Override // android.content.res.Resources
    public final boolean getBoolean(int r2) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getBoolean(r2);
    L7:
        return this.mSysResources.getBoolean(r2);
    }

    @Override // android.content.res.Resources
    public final int getColor(int r2) {
        if (this.mInited == true) goto L7;
        return super.getColor(r2);
    L7:
        return this.mColorResourcesRetriever.getResources(r2);
    }

    @Override // android.content.res.Resources
    public final ColorStateList getColorStateList(int r2) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getColorStateList(r2);
    L7:
        return this.mColorStateListResourcesRetriever.getResources(r2);
    }

    @Override // android.content.res.Resources
    public final float getDimension(int r2) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getDimension(r2);
    L7:
        return this.mSysResources.getDimension(r2);
    }

    @Override // android.content.res.Resources
    public final int getDimensionPixelOffset(int r2) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getDimensionPixelOffset(r2);
    L7:
        return this.mSysResources.getDimensionPixelOffset(r2);
    }

    @Override // android.content.res.Resources
    public final int getDimensionPixelSize(int r2) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getDimensionPixelSize(r2);
    L7:
        return this.mSysResources.getDimensionPixelSize(r2);
    }

    @Override // android.content.res.Resources
    public final Drawable getDrawable(int r2) {
        if (this.mInited == true) goto L7;
        return super.getDrawable(r2);
    L7:
        return this.mDrawableResourcesRetriever.getResources(r2);
    }

    @Override // android.content.res.Resources
    public final float getFloat(int r2) {
        if (this.mInited == true) goto L7;
        return super.getFloat(r2);
    L7:
        return this.mSysResources.getFloat(r2);
    }

    @Override // android.content.res.Resources
    public final Typeface getFont(int r2) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getFont(r2);
    L7:
        return this.mSysResources.getFont(r2);
    }

    @Override // android.content.res.Resources
    public final int[] getIntArray(int r2) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getIntArray(r2);
    L7:
        return this.mSysResources.getIntArray(r2);
    }

    @Override // android.content.res.Resources
    public final int getInteger(int r9) throws Resources.NotFoundException {
    L8:
        th = move-exception;
        String r1 = th.getMessage();
        if (r1 != null) goto L12;
    L47:
        throw th;
    L12:
        if (r1.contains("#0x20") == false) goto L47;
        boolean r0 = com.larksuite.component.dynamicresources.b.a;
        if (Build.VERSION.SDK_INT >= 33) goto L18;
    L25:
        boolean r2 = false;
    L27:
        if (r2 == false) goto L46;
        Context r3 = (Context) new Reflect(Reflect.a("android.webkit.WebViewFactory")).call("getWebViewContextAndSetProvider").a;     // Catch: Throwable -> L34
    L35:
        if (r3 == null) goto L46;
        int r4 = r3.getResources().getConfiguration().uiMode;     // Catch: Throwable -> L48
        new Reflect(new Reflect(Reflect.a("android.webkit.WebViewDelegate")).c().a).call("addWebViewAssetPath", new Class[]{Context.class}, new Object[]{LarkContext.getApplication()});     // Catch: Throwable -> L48
        Arrays.toString(LarkContext.getApplication().getApplicationInfo().sharedLibraryFiles);     // Catch: Throwable -> L48
        Configuration r5 = r3.getResources().getConfiguration();     // Catch: Throwable -> L48
        Objects.toString(r5);     // Catch: Throwable -> L48
        if (r4 == r5.uiMode) goto L46;
        r5.uiMode = r4;     // Catch: Throwable -> L48
        Resources r6 = r3.getResources();     // Catch: Throwable -> L48
        Resources r7 = r3.getResources();     // Catch: Throwable -> L48
        r6.updateConfiguration(r5, WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics()));     // Catch: Throwable -> L48
        Objects.toString(r3.getResources().getConfiguration());     // Catch: Throwable -> L48
        goto L46
    L42:
        e = move-exception;
        throw new Reflect.ReflectException(e);     // Catch: Throwable -> L48
    L31:
        e = move-exception;
        throw new Reflect.ReflectException(e);     // Catch: Throwable -> L34
    L34:
        r3 = null;
        goto L35
    L18:
        if (com.larksuite.component.dynamicresources.b.a == false) goto L25;
        ResourceConfig r8 = (ResourceConfig) SettingManager.getInstance().get(ResourceConfig.class);     // Catch: Throwable -> L48
        if (r8 == null) goto L25;
        if (r8.enableFixResource() == false) goto L25;
        r2 = true;
    L46:
        return this.mSysResources.getInteger(r9);
    L3:
        if (this.mInited == true) goto L7;
        return super.getInteger(r9);
    L7:
        return this.mSysResources.getInteger(r9);
    }

    @Override // android.content.res.Resources
    public final XmlResourceParser getLayout(int r2) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getLayout(r2);
    L7:
        return this.mSysResources.getLayout(r2);
    }

    @Override // android.content.res.Resources
    public final Movie getMovie(int r2) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getMovie(r2);
    L7:
        return this.mSysResources.getMovie(r2);
    }

    @Override // android.content.res.Resources
    public final String getResourceEntryName(int r2) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getResourceEntryName(r2);
    L7:
        return this.mSysResources.getResourceEntryName(r2);
    }

    @Override // android.content.res.Resources
    public final String getResourceName(int r2) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getResourceName(r2);
    L7:
        return this.mSysResources.getResourceName(r2);
    }

    @Override // android.content.res.Resources
    public final String getResourcePackageName(int r2) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getResourcePackageName(r2);
    L7:
        return this.mSysResources.getResourcePackageName(r2);
    }

    @Override // android.content.res.Resources
    public final String getResourceTypeName(int r2) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getResourceTypeName(r2);
    L7:
        return this.mSysResources.getResourceTypeName(r2);
    }

    @Override // android.content.res.Resources
    public final String getString(int r2) {
        if (this.mInited == true) goto L7;
        return super.getString(r2);
    L7:
        return this.mStringResourcesRetriever.getResources(r2);
    }

    @Override // android.content.res.Resources
    public final String[] getStringArray(int r2) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getStringArray(r2);
    L7:
        return this.mSysResources.getStringArray(r2);
    }

    @Override // android.content.res.Resources
    public final CharSequence getText(int r2) {
        if (this.mInited == true) goto L7;
        return super.getText(r2);
    L7:
        return this.mCharSequenceResourcesRetriever.getResources(r2);
    }

    @Override // android.content.res.Resources
    public final CharSequence[] getTextArray(int r2) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getTextArray(r2);
    L7:
        return this.mSysResources.getTextArray(r2);
    }

    @Override // android.content.res.Resources
    public final XmlResourceParser getXml(int r2) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getXml(r2);
    L7:
        return this.mSysResources.getXml(r2);
    }

    @Override // android.content.res.Resources
    public final TypedArray obtainTypedArray(int r2) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.obtainTypedArray(r2);
    L7:
        return this.mSysResources.obtainTypedArray(r2);
    }

    @Override // android.content.res.Resources
    public final InputStream openRawResource(int r2) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.openRawResource(r2);
    L7:
        return this.mSysResources.openRawResource(r2);
    }

    @Override // android.content.res.Resources
    public final AssetFileDescriptor openRawResourceFd(int r2) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.openRawResourceFd(r2);
    L7:
        return this.mSysResources.openRawResourceFd(r2);
    }

    @Override // android.content.res.Resources
    public final int getColor(int r2, Resources.Theme r3) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getColor(r2, r3);
    L7:
        return this.mColorResourcesRetriever.getResources(r2, r3);
    }

    @Override // android.content.res.Resources
    public final ColorStateList getColorStateList(int r2, Resources.Theme r3) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getColorStateList(r2, r3);
    L7:
        return this.mColorStateListResourcesRetriever.getResources(r2, r3);
    }

    @Override // android.content.res.Resources
    public final Drawable getDrawable(int r2, Resources.Theme r3) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getDrawable(r2, r3);
    L7:
        return this.mDrawableResourcesRetriever.getResources(r2, r3);
    }

    @Override // android.content.res.Resources
    public final Drawable getDrawableForDensity(int r2, int r3) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getDrawableForDensity(r2, r3);
    L7:
        return this.mSysResources.getDrawableForDensity(r2, r3);
    }

    @Override // android.content.res.Resources
    public final String getQuantityString(int r2, int r3) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getQuantityString(r2, r3);
    L7:
        return this.mSysResources.getQuantityString(r2, r3);
    }

    @Override // android.content.res.Resources
    public final CharSequence getQuantityText(int r2, int r3) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getQuantityText(r2, r3);
    L7:
        return this.mSysResources.getQuantityText(r2, r3);
    }

    @Override // android.content.res.Resources
    public final String getString(int r2, Object... r3) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getString(r2, r3);
    L7:
        return this.mSysResources.getString(r2, r3);
    }

    @Override // android.content.res.Resources
    public final CharSequence getText(int r2, CharSequence r3) {
        if (this.mInited == true) goto L7;
        return super.getText(r2, r3);
    L7:
        return this.mSysResources.getText(r2, r3);
    }

    @Override // android.content.res.Resources
    public final TypedArray obtainAttributes(AttributeSet r2, int[] r3) {
        if (this.mInited == true) goto L7;
        return obtainAttributes(r2, r3);
    L7:
        return this.mSysResources.obtainAttributes(r2, r3);
    }

    @Override // android.content.res.Resources
    public final InputStream openRawResource(int r2, TypedValue r3) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.openRawResource(r2, r3);
    L7:
        return this.mSysResources.openRawResource(r2, r3);
    }

    @Override // android.content.res.Resources
    public final void parseBundleExtras(XmlResourceParser r2, Bundle r3) throws IOException, XmlPullParserException {
        if (this.mInited == true) goto L6;
        super.parseBundleExtras(r2, r3);
        return;
    L6:
        this.mSysResources.parseBundleExtras(r2, r3);
    }

    @Override // android.content.res.Resources
    public final void updateConfiguration(Configuration r2, DisplayMetrics r3) {
        if (this.mInited == true) goto L6;
        super.updateConfiguration(r2, r3);
        return;
    L6:
        this.mSysResources.updateConfiguration(r2, r3);
        this.mDynamicResources.updateConfiguration(r2, r3);
    }

    @Override // android.content.res.Resources
    public final Drawable getDrawableForDensity(int r2, int r3, Resources.Theme r4) {
        if (this.mInited == true) goto L7;
        return super.getDrawableForDensity(r2, r3, r4);
    L7:
        return this.mSysResources.getDrawableForDensity(r2, r3, r4);
    }

    @Override // android.content.res.Resources
    public final float getFraction(int r2, int r3, int r4) {
        if (this.mInited == true) goto L7;
        return super.getFraction(r2, r3, r4);
    L7:
        return this.mSysResources.getFraction(r2, r3, r4);
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String r2, String r3, String r4) {
        if (this.mInited == true) goto L7;
        return super.getIdentifier(r2, r3, r4);
    L7:
        return this.mSysResources.getIdentifier(r2, r3, r4);
    }

    @Override // android.content.res.Resources
    public final String getQuantityString(int r2, int r3, Object... r4) throws Resources.NotFoundException {
        if (this.mInited == true) goto L7;
        return super.getQuantityString(r2, r3, r4);
    L7:
        return this.mSysResources.getQuantityString(r2, r3, r4);
    }

    @Override // android.content.res.Resources
    public final void getValue(int r2, TypedValue r3, boolean r4) throws Resources.NotFoundException {
        if (this.mInited == true) goto L6;
        super.getValue(r2, r3, r4);
        return;
    L6:
        this.mSysResources.getValue(r2, r3, r4);
    }

    @Override // android.content.res.Resources
    public final void parseBundleExtra(String r2, AttributeSet r3, Bundle r4) throws XmlPullParserException {
        if (this.mInited == true) goto L6;
        super.parseBundleExtra(r2, r3, r4);
        return;
    L6:
        this.mSysResources.parseBundleExtra(r2, r3, r4);
    }

    @Override // android.content.res.Resources
    public final void getValue(String r2, TypedValue r3, boolean r4) throws Resources.NotFoundException {
        if (this.mInited == true) goto L6;
        super.getValue(r2, r3, r4);
        return;
    L6:
        this.mSysResources.getValue(r2, r3, r4);
    }

    @Override // android.content.res.Resources
    public final void getValueForDensity(int r2, int r3, TypedValue r4, boolean r5) throws Resources.NotFoundException {
        if (this.mInited == true) goto L6;
        super.getValueForDensity(r2, r3, r4, r5);
        return;
    L6:
        this.mSysResources.getValueForDensity(r2, r3, r4, r5);
    }
}
