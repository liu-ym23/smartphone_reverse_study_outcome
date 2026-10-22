package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0006H\u0000\u001a\b\u0010\u0007\u001a\u00020\bH\u0000\" \u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"moduleByClassLoader", "Ljava/util/concurrent/ConcurrentMap;", "Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "Ljava/lang/ref/WeakReference;", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "getOrCreateModule", "Ljava/lang/Class;", "clearModuleByClassLoaderCache", "", "kotlin-reflection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ModuleByClassLoaderKt {
    private static final ConcurrentMap<WeakClassLoaderBox, WeakReference<RuntimeModuleData>> moduleByClassLoader = null;

    static {
        moduleByClassLoader = new ConcurrentHashMap();
    }

    public static final void clearModuleByClassLoaderCache() {
        moduleByClassLoader.clear();
    }

    public static final RuntimeModuleData getOrCreateModule(Class<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ClassLoader r6 = ReflectClassUtilKt.getSafeClassLoader(r5);
        WeakClassLoaderBox r0 = new WeakClassLoaderBox(r6);
        ConcurrentMap<WeakClassLoaderBox, WeakReference<RuntimeModuleData>> r1 = moduleByClassLoader;
        WeakReference<RuntimeModuleData> r2 = r1.get(r0);
        if (r2 == null) goto L8;
        RuntimeModuleData r3 = r2.get();
        if (r3 == null) goto L7;
        return r3;
    L7:
        r1.remove(r0, r2);
    L8:
        RuntimeModuleData r7 = RuntimeModuleData.Companion.create(r6);
    L23:
        ConcurrentMap<WeakClassLoaderBox, WeakReference<RuntimeModuleData>> r4 = moduleByClassLoader;     // Catch: Throwable -> L20
        WeakReference<RuntimeModuleData> r8 = r4.putIfAbsent(r0, new WeakReference(r7));     // Catch: Throwable -> L20
        if (r8 == null) goto L12;
        RuntimeModuleData r9 = r8.get();     // Catch: Throwable -> L20
        if (r9 != null) goto L16;
        r4.remove(r0, r8);     // Catch: Throwable -> L20
        goto L23
    L16:
        r0.setTemporaryStrongRef(null);
        return r9;
    L12:
        r0.setTemporaryStrongRef(null);
        return r7;
    L20:
        th = move-exception;
        r0.setTemporaryStrongRef(null);
        throw th;
    }
}
