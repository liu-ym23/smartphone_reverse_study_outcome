package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class AppCompatDrawableManager {
    private static final boolean DEBUG = false;
    private static final PorterDuff.Mode DEFAULT_MODE = null;
    private static AppCompatDrawableManager INSTANCE = null;
    private static final String TAG = "AppCompatDrawableManag";
    private ResourceManagerInternal mResourceManager;

    static {
        DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
    }

    public AppCompatDrawableManager() {
    }

    static /* synthetic */ PorterDuff.Mode access$000() {
        return DEFAULT_MODE;
    }

    public static synchronized AppCompatDrawableManager get() {
        monitor-enter(AppCompatDrawableManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (INSTANCE != null) goto L7;
        preload();     // Catch: Throwable -> L10
    L7:
        AppCompatDrawableManager r1 = INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(AppCompatDrawableManager.class);
        return r1;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int r1, PorterDuff.Mode r2) {
        monitor-enter(AppCompatDrawableManager.class);
        PorterDuffColorFilter r3 = ResourceManagerInternal.getPorterDuffColorFilter(r1, r2);     // Catch: Throwable -> L7
        monitor-exit(AppCompatDrawableManager.class);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void preload() {
        monitor-enter(AppCompatDrawableManager.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (INSTANCE != null) goto L7;
        AppCompatDrawableManager r1 = new AppCompatDrawableManager();     // Catch: Throwable -> L9
        INSTANCE = r1;     // Catch: Throwable -> L9
        r1.mResourceManager = ResourceManagerInternal.get();     // Catch: Throwable -> L9
        INSTANCE.mResourceManager.setHooks(new AnonymousClass1());     // Catch: Throwable -> L9
    L7:
        monitor-exit(AppCompatDrawableManager.class);
    }

    static void tintDrawable(Drawable r0, TintInfo r1, int[] r2) {
        ResourceManagerInternal.tintDrawable(r0, r1, r2);
    }

    public synchronized Drawable getDrawable(Context r3, int r4) {
        monitor-enter(this);
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        Drawable r6 = this.mResourceManager.getDrawable(r5, r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r6;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized Drawable getDrawable(Context r3, int r4, boolean r5) {
        monitor-enter(this);
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        Drawable r7 = this.mResourceManager.getDrawable(r6, r4, r5);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r7;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized ColorStateList getTintList(Context r3, int r4) {
        monitor-enter(this);
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        ColorStateList r6 = this.mResourceManager.getTintList(r5, r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r6;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void onConfigurationChanged(Context r3) {
        monitor-enter(this);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        this.mResourceManager.onConfigurationChanged(r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized Drawable onDrawableLoadedFromResources(Context r3, VectorEnabledTintResources r4, int r5) {
        monitor-enter(this);
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        Drawable r7 = this.mResourceManager.onDrawableLoadedFromResources(r6, r4, r5);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r7;
    L6:
        th = move-exception;
        throw th;
    }

    boolean tintDrawableUsingColorFilter(Context r3, int r4, Drawable r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        return this.mResourceManager.tintDrawableUsingColorFilter(r6, r4, r5);
    }
}
