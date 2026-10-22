package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.tracing.Trace;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
    final Context mContext;
    final Set<Class<? extends Initializer<?>>> mDiscovered;
    final Map<Class<?>, Object> mInitialized;

    static {
        sLock = new Object();
    }

    AppInitializer(Context r3) {
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.mDiscovered = new HashSet();
        this.mInitialized = new HashMap();
    }

    private <T> T doInitialize(Class<? extends Initializer<?>> r6, Set<Class<?>> r7) {
        Set<Class<?>> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        if (Trace.isEnabled() == false) goto L6;
        Trace.beginSection(r6.getSimpleName());     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        Trace.endSection();
        throw th;
    L6:
        if (r8.contains(r6) == true) goto L27;
        if (this.mInitialized.containsKey(r6) == true) goto L23;
        r8.add(r6);     // Catch: Throwable -> L28
        Initializer r0 = (Initializer) ZeusTransformUtils.preCheckCast(r6.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), Initializer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        List<Class<? extends Initializer<?>>> r2 = r0.dependencies();     // Catch: Throwable -> L20
        if (r2.isEmpty() == true) goto L18;
        Iterator<Class<? extends Initializer<?>>> r3 = r2.iterator();     // Catch: Throwable -> L20
    L14:
        if (r3.hasNext() == false) goto L18;
        Class<? extends Initializer<?>> r4 = (Class) ZeusTransformUtils.preCheckCast(r3.next(), Class.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (this.mInitialized.containsKey(r4) == true) goto L14;
        doInitialize(r4, r8);     // Catch: Throwable -> L20
    L18:
        T r1 = (T) r0.create(this.mContext);
        r8.remove(r6);     // Catch: Throwable -> L20
        this.mInitialized.put(r6, r1);     // Catch: Throwable -> L20
    L24:
        Trace.endSection();
        return r1;
    L20:
        th = move-exception;
        throw new StartupException(th);     // Catch: Throwable -> L28
    L23:
        r1 = (T) this.mInitialized.get(r6);
        goto L24
    L27:
        throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", new Object[]{r6.getName()}));     // Catch: Throwable -> L28
    }

    public static AppInitializer getInstance(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (sInstance != null) goto L15;
        Object r0 = sLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new AppInitializer(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    static void setDelegate(AppInitializer r1) {
        Object r0 = sLock;
        monitor-enter(r0);
        sInstance = r1;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void discoverAndInitialize() {
        Trace.beginSection(SECTION_NAME);     // Catch: Throwable -> L5 PackageManager.NameNotFoundException -> L7
        ComponentName r0 = new ComponentName(this.mContext.getPackageName(), InitializationProvider.class.getName());     // Catch: Throwable -> L5 PackageManager.NameNotFoundException -> L7
        discoverAndInitialize(this.mContext.getPackageManager().getProviderInfo(r0, 128).metaData);     // Catch: Throwable -> L5 PackageManager.NameNotFoundException -> L7
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

    void discoverAndInitialize(Bundle r7) {
        String r0 = this.mContext.getString(ZeusTransformUtils.mapRes(R.string.androidx_startup, TypedValues.Custom.S_STRING, "androidx_startup"));
        if (r7 != null) goto L22;
        return;
    L22:
        HashSet r1 = new HashSet();     // Catch: ClassNotFoundException -> L18
        Iterator<String> r2 = r7.keySet().iterator();     // Catch: ClassNotFoundException -> L18
    L7:
        if (r2.hasNext() == false) goto L13;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");     // Catch: ClassNotFoundException -> L18
        if (r0.equals(r7.getString(r3, null)) == false) goto L7;
        Class<? extends Initializer<?>> r4 = ZeusTransformUtils.forName(r3, "com.obric.memorydata.plugin");     // Catch: ClassNotFoundException -> L18
        if (Initializer.class.isAssignableFrom(r4) == false) goto L7;
        this.mDiscovered.add(r4);     // Catch: ClassNotFoundException -> L18
        goto L7
    L13:
        Iterator<Class<? extends Initializer<?>>> r8 = this.mDiscovered.iterator();     // Catch: ClassNotFoundException -> L18
    L14:
        if (r8.hasNext() == false) goto L32;
        doInitialize((Class) ZeusTransformUtils.preCheckCast(r8.next(), Class.class, "com.obric.memorydata.plugin"), r1);     // Catch: ClassNotFoundException -> L18
        goto L14
    L32:
        return;
    L18:
        e = move-exception;
        throw new StartupException(e);
    }

    <T> T doInitialize(Class<? extends Initializer<?>> r3) {
        Object r0 = sLock;
        monitor-enter(r0);
        T r1 = (T) this.mInitialized.get(r3);
        if (r1 != null) goto L7;
        r1 = (T) doInitialize(r3, new HashSet());
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    }

    public <T> T initializeComponent(Class<? extends Initializer<T>> r1) {
        return (T) doInitialize(r1);
    }

    public boolean isEagerlyInitialized(Class<? extends Initializer<?>> r1) {
        return this.mDiscovered.contains(r1);
    }
}
