package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\bH\u0000\" \u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"moduleByClassLoader", "Ljava/util/concurrent/ConcurrentMap;", "Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "Ljava/lang/ref/WeakReference;", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "clearModuleByClassLoaderCache", "", "getOrCreateModule", "Ljava/lang/Class;", "kotlin-reflection"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nmoduleByClassLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 moduleByClassLoader.kt\nkotlin/reflect/jvm/internal/ModuleByClassLoaderKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,75:1\n1#2:76\n*E\n"})
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
        ClassLoader r10 = ReflectClassUtilKt.getSafeClassLoader(r5);
        WeakClassLoaderBox r11 = new WeakClassLoaderBox(r10);
        ConcurrentMap<WeakClassLoaderBox, WeakReference<RuntimeModuleData>> r12 = moduleByClassLoader;
        WeakReference<RuntimeModuleData> r13 = r12.get(r11);
        if (r13 == null) goto L8;
        RuntimeModuleData r14 = r13.get();
        if (r14 == null) goto L7;
        return r14;
    L7:
        r12.remove(r11, r13);
    L8:
        RuntimeModuleData r15 = RuntimeModuleData.Companion.create(r10);
    L23:
        ConcurrentMap<WeakClassLoaderBox, WeakReference<RuntimeModuleData>> r16 = moduleByClassLoader;     // Catch: Throwable -> L20
        WeakReference<RuntimeModuleData> r17 = r16.putIfAbsent(r11, new WeakReference(r15));     // Catch: Throwable -> L20
        if (r17 == null) goto L12;
        RuntimeModuleData r18 = r17.get();     // Catch: Throwable -> L20
        if (r18 != null) goto L16;
        r16.remove(r11, r17);     // Catch: Throwable -> L20
        goto L23
    L16:
        r11.setTemporaryStrongRef(null);
        return r18;
    L12:
        r11.setTemporaryStrongRef(null);
        return r15;
    L20:
        th = move-exception;
        r11.setTemporaryStrongRef(null);
        throw th;
    }
}
