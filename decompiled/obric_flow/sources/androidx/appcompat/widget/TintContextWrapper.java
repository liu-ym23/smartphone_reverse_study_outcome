package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
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

    private TintContextWrapper(@NonNull Context r5) {
        super(r5);
        if (VectorEnabledTintResources.shouldBeUsed() == false) goto L5;
        VectorEnabledTintResources r10 = new VectorEnabledTintResources(this, r5.getResources());
        this.mResources = r10;
        Resources.Theme r11 = r10.newTheme();
        this.mTheme = r11;
        r11.setTo(r5.getTheme());
        return;
    L5:
        this.mResources = new TintResources(this, r5.getResources());
        this.mTheme = null;
    }

    private static boolean shouldWrap(@NonNull Context r5) {
        if ((r5 instanceof TintContextWrapper) == false) goto L5;
        return false;
    L5:
        if ((r5.getResources() instanceof TintResources) == false) goto L7;
        return false;
    L7:
        if ((r5.getResources() instanceof VectorEnabledTintResources) == false) goto L10;
        return false;
    L10:
        return VectorEnabledTintResources.shouldBeUsed();
    }

    public static Context wrap(@NonNull Context r5) {
        if (shouldWrap(r5) == false) goto L36;
        Object r10 = CACHE_LOCK;
        monitor-enter(r10);
        ArrayList<WeakReference<TintContextWrapper>> r11 = sCache;     // Catch: Throwable -> L9
        if (r11 != null) goto L11;
        sCache = new ArrayList();     // Catch: Throwable -> L9
    L31:
        TintContextWrapper r12 = new TintContextWrapper(r5);     // Catch: Throwable -> L9
        sCache.add(new WeakReference(r12));     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        return r12;
    L11:
        int r13 = r11.size() - 1;     // Catch: Throwable -> L9
    L12:
        if (r13 < 0) goto L19;
        WeakReference<TintContextWrapper> r14 = sCache.get(r13);     // Catch: Throwable -> L9
        if (r14 != null) goto L16;
    L17:
        sCache.remove(r13);     // Catch: Throwable -> L9
    L18:
        r13 = r13 - 1;     // Catch: Throwable -> L9
        goto L12
    L16:
        if (r14.get() != null) goto L18;
    L19:
        int r15 = sCache.size() - 1;     // Catch: Throwable -> L9
    L20:
        if (r15 < 0) goto L31;
        WeakReference<TintContextWrapper> r16 = sCache.get(r15);     // Catch: Throwable -> L9
        if (r16 == null) goto L24;
        TintContextWrapper r17 = r16.get();     // Catch: Throwable -> L9
    L25:
        if (r17 == null) goto L30;
        if (r17.getBaseContext() != r5) goto L30;
        monitor-exit(r10);     // Catch: Throwable -> L9
        return r17;
    L30:
        r15 = r15 - 1;     // Catch: Throwable -> L9
        goto L20
    L24:
        r17 = null;
    L9:
        th = move-exception;
        throw th;
    L36:
        return r5;
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
        Resources.Theme r5 = this.mTheme;
        if (r5 == null) goto L5;
        return r5;
    L5:
        return super.getTheme();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int r5) {
        Resources.Theme r10 = this.mTheme;
        if (r10 != null) goto L5;
        super.setTheme(r5);
        return;
    L5:
        r10.applyStyle(r5, true);
    }
}
