package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.tracing.Trace;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class AppInitializer {
    private static final String SECTION_NAME = "Startup";
    private static volatile AppInitializer sInstance;
    private static final Object sLock = null;

    @NonNull
    final Context mContext;

    @NonNull
    final Set<Class<? extends Initializer<?>>> mDiscovered;

    @NonNull
    final Map<Class<?>, Object> mInitialized;

    static {
        sLock = new Object();
    }

    public AppInitializer(@NonNull Context r5) {
        this.mContext = r5.getApplicationContext();
        this.mDiscovered = new HashSet();
        this.mInitialized = new HashMap();
    }

    @NonNull
    public static AppInitializer getInstance(@NonNull Context r5) {
        if (sInstance != null) goto L16;
        Object r10 = sLock;
        monitor-enter(r10);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new AppInitializer(r5);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    public static void setDelegate(@NonNull AppInitializer r5) {
        Object r10 = sLock;
        monitor-enter(r10);
        sInstance = r5;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void discoverAndInitialize() {
        Trace.beginSection(SECTION_NAME);     // Catch: Throwable -> L5 PackageManager.NameNotFoundException -> L7
        ComponentName r5 = new ComponentName(this.mContext.getPackageName(), InitializationProvider.class.getName());     // Catch: Throwable -> L5 PackageManager.NameNotFoundException -> L7
        discoverAndInitialize(this.mContext.getPackageManager().getProviderInfo(r5, 128).metaData);     // Catch: Throwable -> L5 PackageManager.NameNotFoundException -> L7
        Trace.endSection();
        return;
    L5:
        th = move-exception;
        Trace.endSection();
        throw th;
    L7:
        e = move-exception;
        throw new StartupException(e);     // Catch: Throwable -> L5
    }

    @NonNull
    public <T> T doInitialize(@NonNull Class<? extends Initializer<?>> r5) {
        Object r10 = sLock;
        monitor-enter(r10);
        T r11 = (T) this.mInitialized.get(r5);
        if (r11 != null) goto L9;
        r11 = (T) doInitialize(r5, new HashSet());
    L9:
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @NonNull
    public <T> T initializeComponent(@NonNull Class<? extends Initializer<T>> r5) {
        return (T) doInitialize(r5);
    }

    public boolean isEagerlyInitialized(@NonNull Class<? extends Initializer<?>> r5) {
        return this.mDiscovered.contains(r5);
    }

    @NonNull
    private <T> T doInitialize(@NonNull Class<? extends Initializer<?>> r5, @NonNull Set<Class<?>> r10) {
        if (Trace.isEnabled() == false) goto L8;
        Trace.beginSection(r5.getSimpleName());     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        Trace.endSection();
        throw th;
    L8:
        if (r10.contains(r5) == true) goto L31;
        if (this.mInitialized.containsKey(r5) == true) goto L27;
        r10.add(r5);     // Catch: Throwable -> L5
        Initializer<?> r11 = r5.getDeclaredConstructor(null).newInstance(null);     // Catch: Throwable -> L21
        List<Class<? extends Initializer<?>>> r12 = r11.dependencies();     // Catch: Throwable -> L21
        if (r12.isEmpty() == true) goto L23;
        Iterator<Class<? extends Initializer<?>>> r13 = r12.iterator();     // Catch: Throwable -> L21
    L17:
        if (r13.hasNext() == false) goto L23;
        Class<? extends Initializer<?>> r14 = r13.next();     // Catch: Throwable -> L21
        if (this.mInitialized.containsKey(r14) == true) goto L17;
        doInitialize(r14, r10);     // Catch: Throwable -> L21
    L23:
        T r15 = (T) r11.create(this.mContext);
        r10.remove(r5);     // Catch: Throwable -> L21
        this.mInitialized.put(r5, r15);     // Catch: Throwable -> L21
    L28:
        Trace.endSection();
        return r15;
    L21:
        th = move-exception;
        throw new StartupException(th);     // Catch: Throwable -> L5
    L27:
        r15 = (T) this.mInitialized.get(r5);
        goto L28
    L31:
        throw new IllegalStateException("Cannot initialize " + r5.getName() + ". Cycle detected.");     // Catch: Throwable -> L5
    }

    public void discoverAndInitialize(@Nullable Bundle r10) {
        String r5 = this.mContext.getString(R.string.androidx_startup);
        if (r10 != null) goto L22;
        return;
    L22:
        HashSet r11 = new HashSet();     // Catch: ClassNotFoundException -> L12
        Iterator<String> r12 = r10.keySet().iterator();     // Catch: ClassNotFoundException -> L12
    L6:
        if (r12.hasNext() == false) goto L14;
        String r13 = r12.next();     // Catch: ClassNotFoundException -> L12
        if (r5.equals(r10.getString(r13, null)) == false) goto L6;
        Class<?> r14 = Class.forName(r13);     // Catch: ClassNotFoundException -> L12
        if (Initializer.class.isAssignableFrom(r14) == false) goto L6;
        this.mDiscovered.add((Class<? extends Initializer<?>>) r14);     // Catch: ClassNotFoundException -> L12
        goto L6
    L14:
        Iterator<Class<? extends Initializer<?>>> r15 = this.mDiscovered.iterator();     // Catch: ClassNotFoundException -> L12
    L15:
        if (r15.hasNext() == false) goto L32;
        doInitialize(r15.next(), r11);     // Catch: ClassNotFoundException -> L12
        goto L15
    L32:
        return;
    L12:
        e = move-exception;
        throw new StartupException(e);
    }
}
