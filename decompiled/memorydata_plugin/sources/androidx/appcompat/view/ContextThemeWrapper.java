package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ContextThemeWrapper extends ContextWrapper {
    private static Configuration sEmptyConfig;
    private LayoutInflater mInflater;
    private Configuration mOverrideConfiguration;
    private Resources mResources;
    private Resources.Theme mTheme;
    private int mThemeResource;

    static class Api17Impl {
        private Api17Impl() {
        }

        static Context createConfigurationContext(ContextThemeWrapper r2, Configuration r3) {
            return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextThemeWrapper) ZeusTransformUtils.wrapperContextForParams(r2, ContextThemeWrapper.class, "com.obric.memorydata.plugin")).createConfigurationContext(r3), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        }
    }

    public ContextThemeWrapper() {
        super(null);
    }

    public ContextThemeWrapper(Context r3, int r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        this.mThemeResource = r4;
    }

    public ContextThemeWrapper(Context r3, Resources.Theme r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        this.mTheme = r4;
    }

    private Resources getResourcesInternal() {
        if (this.mResources != null) goto L18;
        if (this.mOverrideConfiguration != null) goto L7;
    L15:
        Resources r0 = super.getResources();
    L16:
        this.mResources = r0;
        goto L18
    L7:
        if (Build.VERSION.SDK_INT < 26) goto L12;
        if (isEmptyConfiguration(this.mOverrideConfiguration) == true) goto L15;
    L12:
        if (Build.VERSION.SDK_INT < 17) goto L14;
        r0 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Api17Impl.createConfigurationContext(this, this.mOverrideConfiguration), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        goto L16
    L14:
        Resources r1 = super.getResources();
        Configuration r2 = new Configuration(r1.getConfiguration());
        r2.updateFrom(this.mOverrideConfiguration);
        this.mResources = new Resources(r1.getAssets(), r1.getDisplayMetrics(), r2);
    L18:
        return this.mResources;
    }

    private void initializeTheme() {
        if (this.mTheme != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        this.mTheme = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").newTheme();
        Resources.Theme r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getBaseContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getTheme();
        if (r1 == null) goto L10;
        this.mTheme.setTo(r1);
    L10:
        onApplyThemeResource(this.mTheme, this.mThemeResource, r0);
        return;
    L5:
        r0 = false;
        goto L6
    }

    private static boolean isEmptyConfiguration(Configuration r2) {
        if (r2 != null) goto L6;
        return true;
    L6:
        if (sEmptyConfig != null) goto L9;
        Configuration r0 = new Configuration();
        r0.fontScale = 0.0f;
        sEmptyConfig = r0;
    L9:
        return r2.equals(sEmptyConfig);
    }

    public void applyOverrideConfiguration(Configuration r2) {
        if (this.mResources != null) goto L11;
        if (this.mOverrideConfiguration != null) goto L9;
        this.mOverrideConfiguration = new Configuration(r2);
        return;
    L9:
        throw new IllegalStateException("Override configuration has already been set");
    L11:
        throw new IllegalStateException("getResources() or getAssets() has already been called");
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context r3) {
        super.attachBaseContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return getResourcesInternal();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String r3) {
        if ("layout_inflater".equals(r3) == false) goto L10;
        if (this.mInflater != null) goto L8;
        this.mInflater = LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getBaseContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).cloneInContext(this);
    L8:
        return this.mInflater;
    L10:
        return ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getBaseContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService(r3);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme r0 = this.mTheme;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.mThemeResource != 0) goto L8;
        this.mThemeResource = ZeusTransformUtils.mapRes(R.style.Theme_AppCompat_Light, "style", "Theme_AppCompat_Light");
    L8:
        initializeTheme();
        return this.mTheme;
    }

    public int getThemeResId() {
        return this.mThemeResource;
    }

    public void onApplyThemeResource(Resources.Theme r1, int r2, boolean r3) {
        r1.applyStyle(r2, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int r2) {
        if (this.mThemeResource == r2) goto L6;
        this.mThemeResource = r2;
        initializeTheme();
        return;
    }
}
