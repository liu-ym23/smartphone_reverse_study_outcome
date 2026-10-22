package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
final class Java16RecordComponentsLoader {
    public static final Java16RecordComponentsLoader INSTANCE = null;
    private static Cache _cache;

    public static final class Cache {
        private final Method getAccessor;
        private final Method getType;

        public Cache(Method r10, Method r11) {
            this.getType = r10;
            this.getAccessor = r11;
        }

        public final Method getGetAccessor() {
            return this.getAccessor;
        }

        public final Method getGetType() {
            return this.getType;
        }
    }

    static {
        INSTANCE = new Java16RecordComponentsLoader();
    }

    private Java16RecordComponentsLoader() {
    }

    private final Cache buildCache(Object r10) {
        Class<?> r11 = r10.getClass();
        return new Cache(r11.getMethod("getType", new Class[0]), r11.getMethod("getAccessor", new Class[0]));
    L6:
        return new Cache(null, null);
    }

    private final Cache initCache(Object r10) {
        Cache r11 = _cache;
        if (r11 != null) goto L6;
        Cache r12 = buildCache(r10);
        _cache = r12;
        return r12;
    L6:
        return r11;
    }

    public final Method loadGetAccessor(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "recordComponent");
        Method r11 = initCache(r10).getGetAccessor();
        if (r11 != null) goto L6;
        return null;
    L6:
        Object r12 = r11.invoke(r10, new Object[0]);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type java.lang.reflect.Method");
        return (Method) r12;
    }

    public final Class<?> loadGetType(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "recordComponent");
        Method r11 = initCache(r10).getGetType();
        if (r11 != null) goto L6;
        return null;
    L6:
        Object r12 = r11.invoke(r10, new Object[0]);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type java.lang.Class<*>");
        return (Class) r12;
    }
}
