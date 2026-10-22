package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
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

    public static /* synthetic */ PorterDuff.Mode access$000() {
        return DEFAULT_MODE;
    }

    public static synchronized AppCompatDrawableManager get() {
        monitor-enter(AppCompatDrawableManager.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (INSTANCE != null) goto L9;
        preload();     // Catch: Throwable -> L7
    L9:
        AppCompatDrawableManager r5 = INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(AppCompatDrawableManager.class);
        return r5;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int r5, PorterDuff.Mode r10) {
        monitor-enter(AppCompatDrawableManager.class);
        PorterDuffColorFilter r11 = ResourceManagerInternal.getPorterDuffColorFilter(r5, r10);     // Catch: Throwable -> L7
        monitor-exit(AppCompatDrawableManager.class);
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void preload() {
        monitor-enter(AppCompatDrawableManager.class);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (INSTANCE != null) goto L10;
        AppCompatDrawableManager r5 = new AppCompatDrawableManager();     // Catch: Throwable -> L8
        INSTANCE = r5;     // Catch: Throwable -> L8
        r5.mResourceManager = ResourceManagerInternal.get();     // Catch: Throwable -> L8
        INSTANCE.mResourceManager.setHooks(new AnonymousClass1());     // Catch: Throwable -> L8
    L10:
        monitor-exit(AppCompatDrawableManager.class);
    }

    public static void tintDrawable(Drawable r5, TintInfo r10, int[] r11) {
        ResourceManagerInternal.tintDrawable(r5, r10, r11);
    }

    public synchronized Drawable getDrawable(@NonNull Context r5, @DrawableRes int r10) {
        monitor-enter(this);
        Drawable r11 = this.mResourceManager.getDrawable(r5, r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized ColorStateList getTintList(@NonNull Context r5, @DrawableRes int r10) {
        monitor-enter(this);
        ColorStateList r11 = this.mResourceManager.getTintList(r5, r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void onConfigurationChanged(@NonNull Context r5) {
        monitor-enter(this);
        this.mResourceManager.onConfigurationChanged(r5);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized Drawable onDrawableLoadedFromResources(@NonNull Context r5, @NonNull VectorEnabledTintResources r10, @DrawableRes int r11) {
        monitor-enter(this);
        Drawable r12 = this.mResourceManager.onDrawableLoadedFromResources(r5, r10, r11);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r12;
    L6:
        th = move-exception;
        throw th;
    }

    public boolean tintDrawableUsingColorFilter(@NonNull Context r5, @DrawableRes int r10, @NonNull Drawable r11) {
        return this.mResourceManager.tintDrawableUsingColorFilter(r5, r10, r11);
    }

    public synchronized Drawable getDrawable(@NonNull Context r5, @DrawableRes int r10, boolean r11) {
        monitor-enter(this);
        Drawable r12 = this.mResourceManager.getDrawable(r5, r10, r11);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r12;
    L6:
        th = move-exception;
        throw th;
    }
}
