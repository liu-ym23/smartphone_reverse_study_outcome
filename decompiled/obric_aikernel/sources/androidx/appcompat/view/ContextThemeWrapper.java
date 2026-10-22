package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
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
    static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        static Context createConfigurationContext(ContextThemeWrapper r10, Configuration r11) {
            return r10.createConfigurationContext(r11);
        }
    }

    public ContextThemeWrapper() {
        super(null);
    }

    public ContextThemeWrapper(Context r10, @StyleRes int r11) {
        super(r10);
        this.mThemeResource = r11;
    }

    public ContextThemeWrapper(Context r10, Resources.Theme r11) {
        super(r10);
        this.mTheme = r11;
    }

    private Resources getResourcesInternal() {
        if (this.mResources != null) goto L18;
        Configuration r10 = this.mOverrideConfiguration;
        if (r10 == null) goto L15;
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 26) goto L12;
        if (isEmptyConfiguration(r10) == true) goto L15;
    L12:
        if (r11 < 17) goto L14;
        Resources r12 = Api17Impl.createConfigurationContext(this, this.mOverrideConfiguration).getResources();
    L16:
        this.mResources = r12;
        goto L18
    L14:
        Resources r13 = super.getResources();
        Configuration r14 = new Configuration(r13.getConfiguration());
        r14.updateFrom(this.mOverrideConfiguration);
        this.mResources = new Resources(r13.getAssets(), r13.getDisplayMetrics(), r14);
    L15:
        r12 = super.getResources();
    L18:
        return this.mResources;
    }

    private void initializeTheme() {
        if (this.mTheme != null) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L10;
        this.mTheme = getResources().newTheme();
        Resources.Theme r11 = getBaseContext().getTheme();
        if (r11 == null) goto L10;
        this.mTheme.setTo(r11);
    L10:
        onApplyThemeResource(this.mTheme, this.mThemeResource, r10);
        return;
    L5:
        r10 = false;
        goto L6
    }

    @RequiresApi(26)
    private static boolean isEmptyConfiguration(Configuration r10) {
        if (r10 != null) goto L6;
        return true;
    L6:
        if (sEmptyConfig != null) goto L9;
        Configuration r11 = new Configuration();
        r11.fontScale = 0.0f;
        sEmptyConfig = r11;
    L9:
        return r10.equals(sEmptyConfig);
    }

    public void applyOverrideConfiguration(Configuration r10) {
        if (this.mResources != null) goto L11;
        if (this.mOverrideConfiguration != null) goto L9;
        this.mOverrideConfiguration = new Configuration(r10);
        return;
    L9:
        throw new IllegalStateException("Override configuration has already been set");
    L11:
        throw new IllegalStateException("getResources() or getAssets() has already been called");
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context r10) {
        super.attachBaseContext(r10);
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
    public Object getSystemService(String r10) {
        if ("layout_inflater".equals(r10) == false) goto L10;
        if (this.mInflater != null) goto L8;
        this.mInflater = LayoutInflater.from(getBaseContext()).cloneInContext(this);
    L8:
        return this.mInflater;
    L10:
        return getBaseContext().getSystemService(r10);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme r10 = this.mTheme;
        if (r10 == null) goto L6;
        return r10;
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

    protected void onApplyThemeResource(Resources.Theme r10, int r11, boolean r12) {
        r10.applyStyle(r11, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int r10) {
        if (this.mThemeResource == r10) goto L6;
        this.mThemeResource = r10;
        initializeTheme();
        return;
    }
}
