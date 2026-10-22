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
        AppCompatDrawableManager r10 = INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(AppCompatDrawableManager.class);
        return r10;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int r10, PorterDuff.Mode r11) {
        monitor-enter(AppCompatDrawableManager.class);
        PorterDuffColorFilter r12 = ResourceManagerInternal.getPorterDuffColorFilter(r10, r11);     // Catch: Throwable -> L7
        monitor-exit(AppCompatDrawableManager.class);
        return r12;
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
        AppCompatDrawableManager r10 = new AppCompatDrawableManager();     // Catch: Throwable -> L9
        INSTANCE = r10;     // Catch: Throwable -> L9
        r10.mResourceManager = ResourceManagerInternal.get();     // Catch: Throwable -> L9
        INSTANCE.mResourceManager.setHooks(new AnonymousClass1());     // Catch: Throwable -> L9
    L7:
        monitor-exit(AppCompatDrawableManager.class);
    }

    static void tintDrawable(Drawable r10, TintInfo r11, int[] r12) {
        ResourceManagerInternal.tintDrawable(r10, r11, r12);
    }

    public synchronized Drawable getDrawable(@NonNull Context r10, @DrawableRes int r11) {
        monitor-enter(this);
        Drawable r12 = this.mResourceManager.getDrawable(r10, r11);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r12;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized Drawable getDrawable(@NonNull Context r10, @DrawableRes int r11, boolean r12) {
        monitor-enter(this);
        Drawable r13 = this.mResourceManager.getDrawable(r10, r11, r12);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r13;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized ColorStateList getTintList(@NonNull Context r10, @DrawableRes int r11) {
        monitor-enter(this);
        ColorStateList r12 = this.mResourceManager.getTintList(r10, r11);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r12;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void onConfigurationChanged(@NonNull Context r10) {
        monitor-enter(this);
        this.mResourceManager.onConfigurationChanged(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized Drawable onDrawableLoadedFromResources(@NonNull Context r10, @NonNull VectorEnabledTintResources r11, @DrawableRes int r12) {
        monitor-enter(this);
        Drawable r13 = this.mResourceManager.onDrawableLoadedFromResources(r10, r11, r12);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r13;
    L6:
        th = move-exception;
        throw th;
    }

    boolean tintDrawableUsingColorFilter(@NonNull Context r10, @DrawableRes int r11, @NonNull Drawable r12) {
        return this.mResourceManager.tintDrawableUsingColorFilter(r10, r11, r12);
    }
}
