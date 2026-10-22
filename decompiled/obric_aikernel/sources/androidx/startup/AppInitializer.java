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

    AppInitializer(@NonNull Context r10) {
        this.mContext = r10.getApplicationContext();
        this.mDiscovered = new HashSet();
        this.mInitialized = new HashMap();
    }

    @NonNull
    private <T> T doInitialize(@NonNull Class<? extends Initializer<?>> r10, @NonNull Set<Class<?>> r11) {
        if (Trace.isEnabled() == false) goto L6;
        Trace.beginSection(r10.getSimpleName());     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        Trace.endSection();
        throw th;
    L6:
        if (r11.contains(r10) == true) goto L27;
        if (this.mInitialized.containsKey(r10) == true) goto L23;
        r11.add(r10);     // Catch: Throwable -> L28
        Initializer<?> r12 = r10.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L20
        List<Class<? extends Initializer<?>>> r13 = r12.dependencies();     // Catch: Throwable -> L20
        if (r13.isEmpty() == true) goto L18;
        Iterator<Class<? extends Initializer<?>>> r14 = r13.iterator();     // Catch: Throwable -> L20
    L14:
        if (r14.hasNext() == false) goto L18;
        Class<? extends Initializer<?>> r15 = r14.next();     // Catch: Throwable -> L20
        if (this.mInitialized.containsKey(r15) == true) goto L14;
        doInitialize(r15, r11);     // Catch: Throwable -> L20
    L18:
        T r16 = (T) r12.create(this.mContext);
        r11.remove(r10);     // Catch: Throwable -> L20
        this.mInitialized.put(r10, r16);     // Catch: Throwable -> L20
    L24:
        Trace.endSection();
        return r16;
    L20:
        th = move-exception;
        throw new StartupException(th);     // Catch: Throwable -> L28
    L23:
        r16 = (T) this.mInitialized.get(r10);
        goto L24
    L27:
        throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", new Object[]{r10.getName()}));     // Catch: Throwable -> L28
    }

    @NonNull
    public static AppInitializer getInstance(@NonNull Context r10) {
        if (sInstance != null) goto L15;
        Object r11 = sLock;
        monitor-enter(r11);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new AppInitializer(r10);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    static void setDelegate(@NonNull AppInitializer r10) {
        Object r11 = sLock;
        monitor-enter(r11);
        sInstance = r10;     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void discoverAndInitialize() {
        Trace.beginSection(SECTION_NAME);     // Catch: Throwable -> L5 PackageManager.NameNotFoundException -> L7
        ComponentName r10 = new ComponentName(this.mContext.getPackageName(), InitializationProvider.class.getName());     // Catch: Throwable -> L5 PackageManager.NameNotFoundException -> L7
        discoverAndInitialize(this.mContext.getPackageManager().getProviderInfo(r10, 128).metaData);     // Catch: Throwable -> L5 PackageManager.NameNotFoundException -> L7
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

    void discoverAndInitialize(@Nullable Bundle r10) {
        String r11 = this.mContext.getString(R.string.androidx_startup);
        if (r10 != null) goto L21;
        return;
    L21:
        HashSet r12 = new HashSet();     // Catch: ClassNotFoundException -> L17
        Iterator<String> r13 = r10.keySet().iterator();     // Catch: ClassNotFoundException -> L17
    L6:
        if (r13.hasNext() == false) goto L12;
        String r14 = r13.next();     // Catch: ClassNotFoundException -> L17
        if (r11.equals(r10.getString(r14, null)) == false) goto L6;
        Class<?> r15 = Class.forName(r14);     // Catch: ClassNotFoundException -> L17
        if (Initializer.class.isAssignableFrom(r15) == false) goto L6;
        this.mDiscovered.add((Class<? extends Initializer<?>>) r15);     // Catch: ClassNotFoundException -> L17
        goto L6
    L12:
        Iterator<Class<? extends Initializer<?>>> r16 = this.mDiscovered.iterator();     // Catch: ClassNotFoundException -> L17
    L13:
        if (r16.hasNext() == false) goto L31;
        doInitialize(r16.next(), r12);     // Catch: ClassNotFoundException -> L17
        goto L13
    L31:
        return;
    L17:
        e = move-exception;
        throw new StartupException(e);
    }

    @NonNull
    <T> T doInitialize(@NonNull Class<? extends Initializer<?>> r10) {
        Object r11 = sLock;
        monitor-enter(r11);
        T r12 = (T) this.mInitialized.get(r10);
        if (r12 != null) goto L7;
        r12 = (T) doInitialize(r10, new HashSet());
    L7:
        monitor-exit(r11);     // Catch: Throwable -> L9
        return r12;
    L9:
        th = move-exception;
        throw th;
    }

    @NonNull
    public <T> T initializeComponent(@NonNull Class<? extends Initializer<T>> r10) {
        return (T) doInitialize(r10);
    }

    public boolean isEagerlyInitialized(@NonNull Class<? extends Initializer<?>> r10) {
        return this.mDiscovered.contains(r10);
    }
}
