package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* JADX INFO: loaded from: classes3.dex */
public final class ModuleByClassLoaderKt {
    private static final ConcurrentMap<WeakClassLoaderBox, WeakReference<RuntimeModuleData>> moduleByClassLoader = null;

    static {
        moduleByClassLoader = new ConcurrentHashMap();
    }

    public static final void clearModuleByClassLoaderCache() {
        moduleByClassLoader.clear();
    }

    public static final RuntimeModuleData getOrCreateModule(Class<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ClassLoader r11 = ReflectClassUtilKt.getSafeClassLoader(r10);
        WeakClassLoaderBox r12 = new WeakClassLoaderBox(r11);
        ConcurrentMap<WeakClassLoaderBox, WeakReference<RuntimeModuleData>> r13 = moduleByClassLoader;
        WeakReference<RuntimeModuleData> r14 = r13.get(r12);
        if (r14 == null) goto L8;
        RuntimeModuleData r15 = r14.get();
        if (r15 == null) goto L7;
        return r15;
    L7:
        r13.remove(r12, r14);
    L8:
        RuntimeModuleData r16 = RuntimeModuleData.Companion.create(r11);
    L23:
        ConcurrentMap<WeakClassLoaderBox, WeakReference<RuntimeModuleData>> r17 = moduleByClassLoader;     // Catch: Throwable -> L20
        WeakReference<RuntimeModuleData> r18 = r17.putIfAbsent(r12, new WeakReference(r16));     // Catch: Throwable -> L20
        if (r18 == null) goto L12;
        RuntimeModuleData r19 = r18.get();     // Catch: Throwable -> L20
        if (r19 != null) goto L16;
        r17.remove(r12, r18);     // Catch: Throwable -> L20
        goto L23
    L16:
        r12.setTemporaryStrongRef(null);
        return r19;
    L12:
        r12.setTemporaryStrongRef(null);
        return r16;
    L20:
        th = move-exception;
        r12.setTemporaryStrongRef(null);
        throw th;
    }
}
