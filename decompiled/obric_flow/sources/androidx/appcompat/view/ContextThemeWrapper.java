package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes.dex */
public class ContextThemeWrapper extends ContextWrapper {
    private static Configuration sEmptyConfig;
    private LayoutInflater mInflater;
    private Configuration mOverrideConfiguration;
    private Resources mResources;
    private Resources.Theme mTheme;
    private int mThemeResource;

    @RequiresApi(17)
    public static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        public static Context createConfigurationContext(ContextThemeWrapper r5, Configuration r10) {
            return r5.createConfigurationContext(r10);
        }
    }

    public ContextThemeWrapper() {
        super(null);
    }

    private Resources getResourcesInternal() {
        if (this.mResources != null) goto L12;
        Configuration r5 = this.mOverrideConfiguration;
        if (r5 != null) goto L7;
    L10:
        this.mResources = super.getResources();
        goto L12
    L7:
        if (isEmptyConfiguration(r5) == true) goto L10;
        this.mResources = Api17Impl.createConfigurationContext(this, this.mOverrideConfiguration).getResources();
    L12:
        return this.mResources;
    }

    private void initializeTheme() {
        if (this.mTheme != null) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L10;
        this.mTheme = getResources().newTheme();
        Resources.Theme r10 = getBaseContext().getTheme();
        if (r10 == null) goto L10;
        this.mTheme.setTo(r10);
    L10:
        onApplyThemeResource(this.mTheme, this.mThemeResource, r5);
        return;
    L5:
        r5 = false;
        goto L6
    }

    @RequiresApi(26)
    private static boolean isEmptyConfiguration(Configuration r5) {
        if (r5 != null) goto L6;
        return true;
    L6:
        if (sEmptyConfig != null) goto L9;
        Configuration r10 = new Configuration();
        r10.fontScale = 0.0f;
        sEmptyConfig = r10;
    L9:
        return r5.equals(sEmptyConfig);
    }

    public void applyOverrideConfiguration(Configuration r5) {
        if (this.mResources != null) goto L11;
        if (this.mOverrideConfiguration != null) goto L9;
        this.mOverrideConfiguration = new Configuration(r5);
        return;
    L9:
        throw new IllegalStateException("Override configuration has already been set");
    L11:
        throw new IllegalStateException("getResources() or getAssets() has already been called");
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context r5) {
        super.attachBaseContext(r5);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return getResourcesInternal();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String r5) {
        if ("layout_inflater".equals(r5) == false) goto L10;
        if (this.mInflater != null) goto L8;
        this.mInflater = LayoutInflater.from(getBaseContext()).cloneInContext(this);
    L8:
        return this.mInflater;
    L10:
        return getBaseContext().getSystemService(r5);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme r5 = this.mTheme;
        if (r5 == null) goto L6;
        return r5;
    L6:
        if (this.mThemeResource != 0) goto L8;
        this.mThemeResource = R.style.Theme_AppCompat_Light;
    L8:
        initializeTheme();
        return this.mTheme;
    }

    public int getThemeResId() {
        return this.mThemeResource;
    }

    public void onApplyThemeResource(Resources.Theme r5, int r10, boolean r11) {
        r5.applyStyle(r10, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int r5) {
        if (this.mThemeResource == r5) goto L6;
        this.mThemeResource = r5;
        initializeTheme();
        return;
    }

    public ContextThemeWrapper(Context r5, @StyleRes int r10) {
        super(r5);
        this.mThemeResource = r10;
    }

    public ContextThemeWrapper(Context r5, Resources.Theme r10) {
        super(r5);
        this.mTheme = r10;
    }
}
