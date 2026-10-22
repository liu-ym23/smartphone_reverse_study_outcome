package g;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import com.obric.cae.R;

/* JADX INFO: loaded from: classes.dex */
public final class d extends ContextWrapper {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Configuration f7437f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Resources.Theme f7439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LayoutInflater f7440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Configuration f7441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Resources f7442e;

    public static class a {
        public static Context a(d r8, Configuration r10) {
            return r8.createConfigurationContext(r10);
        }
    }

    public d() {
        super(null);
    }

    public final void a(Configuration r8) {
        if (this.f7442e != null) goto L11;
        if (this.f7441d != null) goto L9;
        this.f7441d = new Configuration(r8);
        return;
    L9:
        throw new IllegalStateException("Override configuration has already been set");
    L11:
        throw new IllegalStateException("getResources() or getAssets() has already been called");
    }

    @Override // android.content.ContextWrapper
    public final void attachBaseContext(Context r8) {
        super.attachBaseContext(r8);
    }

    public final void b() {
        if (this.f7439b != null) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == false) goto L10;
        this.f7439b = getResources().newTheme();
        Resources.Theme r10 = getBaseContext().getTheme();
        if (r10 == null) goto L10;
        this.f7439b.setTo(r10);
    L10:
        this.f7439b.applyStyle(this.f7438a, true);
        return;
    L5:
        r8 = false;
        goto L6
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        if (this.f7442e != null) goto L16;
        Configuration r8 = this.f7441d;
        if (r8 != null) goto L7;
    L13:
        Resources r10 = super.getResources();
    L14:
        this.f7442e = r10;
        goto L16
    L7:
        if (f7437f != null) goto L10;
        Configuration r11 = new Configuration();
        r11.fontScale = 0.0f;
        f7437f = r11;
    L10:
        if (r8.equals(f7437f) == true) goto L13;
        r10 = a.a(this, this.f7441d).getResources();
    L16:
        return this.f7442e;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String r8) {
        if ("layout_inflater".equals(r8) == false) goto L10;
        if (this.f7440c != null) goto L8;
        this.f7440c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
    L8:
        return this.f7440c;
    L10:
        return getBaseContext().getSystemService(r8);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme r8 = this.f7439b;
        if (r8 == null) goto L6;
        return r8;
    L6:
        if (this.f7438a != 0) goto L8;
        this.f7438a = R.style.Theme_AppCompat_Light;
    L8:
        b();
        return this.f7439b;
    }

    public final int getThemeResId() {
        return this.f7438a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int r8) {
        if (this.f7438a == r8) goto L6;
        this.f7438a = r8;
        b();
        return;
    }

    public d(Context r8, int r10) {
        super(r8);
        this.f7438a = r10;
    }
}
