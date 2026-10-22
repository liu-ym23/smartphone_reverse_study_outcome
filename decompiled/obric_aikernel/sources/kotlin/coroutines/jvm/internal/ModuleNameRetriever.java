package kotlin.coroutines.jvm.internal;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.lang.reflect.Method;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nDebugMetadata.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugMetadata.kt\nkotlin/coroutines/jvm/internal/ModuleNameRetriever\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
final class ModuleNameRetriever {
    public static final ModuleNameRetriever INSTANCE = null;
    private static Cache cache;
    private static final Cache notOnJava9 = null;

    private static final class Cache {

        @JvmField
        public final Method getDescriptorMethod;

        @JvmField
        public final Method getModuleMethod;

        @JvmField
        public final Method nameMethod;

        public Cache(Method r10, Method r11, Method r12) {
            this.getModuleMethod = r10;
            this.getDescriptorMethod = r11;
            this.nameMethod = r12;
        }
    }

    static {
        INSTANCE = new ModuleNameRetriever();
        notOnJava9 = new Cache(null, null, null);
    }

    private ModuleNameRetriever() {
    }

    private final Cache buildCache(BaseContinuationImpl r10) {
        Cache r11 = new Cache(Class.class.getDeclaredMethod("getModule", new Class[0]), r10.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), r10.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod(ActivityLifecycle.NAME, new Class[0]));     // Catch: Exception -> L4
        cache = r11;     // Catch: Exception -> L4
        return r11;
    L4:
        Cache r12 = notOnJava9;
        cache = r12;
        return r12;
    }

    public final String getModuleName(BaseContinuationImpl r10) {
        Intrinsics.checkNotNullParameter(r10, "continuation");
        Cache r11 = cache;
        if (r11 != null) goto L6;
        r11 = buildCache(r10);
    L6:
        if (r11 != notOnJava9) goto L8;
        return null;
    L8:
        Method r12 = r11.getModuleMethod;
        if (r12 == null) goto L11;
        Object r13 = r12.invoke(r10.getClass(), new Object[0]);
    L12:
        if (r13 != null) goto L14;
        return null;
    L14:
        Method r14 = r11.getDescriptorMethod;
        if (r14 == null) goto L17;
        Object r15 = r14.invoke(r13, new Object[0]);
    L18:
        if (r15 != null) goto L20;
        return null;
    L20:
        Method r16 = r11.nameMethod;
        if (r16 == null) goto L23;
        Object r17 = r16.invoke(r15, new Object[0]);
    L25:
        if ((r17 instanceof String) == true) goto L27;
        return null;
    L27:
        return (String) r17;
    L23:
        r17 = null;
        goto L25
    L17:
        r15 = null;
        goto L18
    L11:
        r13 = null;
        goto L12
    }
}
