package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TintContextWrapper extends ContextWrapper {
    private static final Object CACHE_LOCK = null;
    private static ArrayList<WeakReference<TintContextWrapper>> sCache;
    private final Resources mResources;
    private final Resources.Theme mTheme;

    static {
        CACHE_LOCK = new Object();
    }

    private TintContextWrapper(@NonNull Context r10) {
        super(r10);
        if (VectorEnabledTintResources.shouldBeUsed() == false) goto L5;
        VectorEnabledTintResources r11 = new VectorEnabledTintResources(this, r10.getResources());
        this.mResources = r11;
        Resources.Theme r12 = r11.newTheme();
        this.mTheme = r12;
        r12.setTo(r10.getTheme());
        return;
    L5:
        this.mResources = new TintResources(this, r10.getResources());
        this.mTheme = null;
    }

    private static boolean shouldWrap(@NonNull Context r10) {
        if ((r10 instanceof TintContextWrapper) == false) goto L5;
        return false;
    L5:
        if ((r10.getResources() instanceof TintResources) == false) goto L7;
        return false;
    L7:
        if ((r10.getResources() instanceof VectorEnabledTintResources) == false) goto L10;
        return false;
    L10:
        if (Build.VERSION.SDK_INT >= 21) goto L12;
    L13:
        return true;
    L12:
        if (VectorEnabledTintResources.shouldBeUsed() == true) goto L13;
        return false;
    }

    public static Context wrap(@NonNull Context r10) {
        if (shouldWrap(r10) == false) goto L35;
        Object r11 = CACHE_LOCK;
        monitor-enter(r11);
        ArrayList<WeakReference<TintContextWrapper>> r12 = sCache;     // Catch: Throwable -> L32
        if (r12 != null) goto L9;
        sCache = new ArrayList();     // Catch: Throwable -> L32
    L29:
        TintContextWrapper r13 = new TintContextWrapper(r10);     // Catch: Throwable -> L32
        sCache.add(new WeakReference(r13));     // Catch: Throwable -> L32
        monitor-exit(r11);     // Catch: Throwable -> L32
        return r13;
    L9:
        int r14 = r12.size() - 1;     // Catch: Throwable -> L32
    L10:
        if (r14 < 0) goto L17;
        WeakReference<TintContextWrapper> r15 = sCache.get(r14);     // Catch: Throwable -> L32
        if (r15 != null) goto L14;
    L15:
        sCache.remove(r14);     // Catch: Throwable -> L32
    L16:
        r14 = r14 - 1;     // Catch: Throwable -> L32
        goto L10
    L14:
        if (r15.get() != null) goto L16;
    L17:
        int r16 = sCache.size() - 1;     // Catch: Throwable -> L32
    L18:
        if (r16 < 0) goto L29;
        WeakReference<TintContextWrapper> r17 = sCache.get(r16);     // Catch: Throwable -> L32
        if (r17 == null) goto L22;
        TintContextWrapper r18 = r17.get();     // Catch: Throwable -> L32
    L23:
        if (r18 == null) goto L28;
        if (r18.getBaseContext() != r10) goto L28;
        monitor-exit(r11);     // Catch: Throwable -> L32
        return r18;
    L28:
        r16 = r16 - 1;     // Catch: Throwable -> L32
        goto L18
    L22:
        r18 = null;
    L32:
        th = move-exception;
        throw th;
    L35:
        return r10;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.mResources.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.mResources;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme r10 = this.mTheme;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return super.getTheme();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int r10) {
        Resources.Theme r11 = this.mTheme;
        if (r11 != null) goto L5;
        super.setTheme(r10);
        return;
    L5:
        r11.applyStyle(r10, true);
    }
}
