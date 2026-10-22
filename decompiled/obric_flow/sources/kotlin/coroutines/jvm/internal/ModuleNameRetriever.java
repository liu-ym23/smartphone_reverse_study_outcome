package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;", "", "()V", "cache", "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "notOnJava9", "buildCache", "continuation", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getModuleName", "", "Cache", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDebugMetadata.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugMetadata.kt\nkotlin/coroutines/jvm/internal/ModuleNameRetriever\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
final class ModuleNameRetriever {
    public static final ModuleNameRetriever INSTANCE = null;
    private static Cache cache;
    private static final Cache notOnJava9 = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "", "getModuleMethod", "Ljava/lang/reflect/Method;", "getDescriptorMethod", "nameMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Cache {

        @JvmField
        public final Method getDescriptorMethod;

        @JvmField
        public final Method getModuleMethod;

        @JvmField
        public final Method nameMethod;

        public Cache(Method r5, Method r10, Method r11) {
            this.getModuleMethod = r5;
            this.getDescriptorMethod = r10;
            this.nameMethod = r11;
        }
    }

    static {
        INSTANCE = new ModuleNameRetriever();
        notOnJava9 = new Cache(null, null, null);
    }

    private ModuleNameRetriever() {
    }

    private final Cache buildCache(BaseContinuationImpl r5) {
        Cache r10 = new Cache(Class.class.getDeclaredMethod("getModule", null), r5.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), r5.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));     // Catch: Exception -> L4
        cache = r10;     // Catch: Exception -> L4
        return r10;
    L4:
        Cache r11 = notOnJava9;
        cache = r11;
        return r11;
    }

    public final String getModuleName(BaseContinuationImpl r5) {
        Intrinsics.checkNotNullParameter(r5, "continuation");
        Cache r10 = cache;
        if (r10 != null) goto L6;
        r10 = buildCache(r5);
    L6:
        if (r10 != notOnJava9) goto L8;
        return null;
    L8:
        Method r11 = r10.getModuleMethod;
        if (r11 == null) goto L11;
        Object r12 = r11.invoke(r5.getClass(), null);
    L12:
        if (r12 != null) goto L14;
        return null;
    L14:
        Method r13 = r10.getDescriptorMethod;
        if (r13 == null) goto L17;
        Object r14 = r13.invoke(r12, null);
    L18:
        if (r14 != null) goto L20;
        return null;
    L20:
        Method r15 = r10.nameMethod;
        if (r15 == null) goto L23;
        Object r16 = r15.invoke(r14, null);
    L25:
        if ((r16 instanceof String) == true) goto L27;
        return null;
    L27:
        return (String) r16;
    L23:
        r16 = null;
        goto L25
    L17:
        r14 = null;
        goto L18
    L11:
        r12 = null;
        goto L12
    }
}
