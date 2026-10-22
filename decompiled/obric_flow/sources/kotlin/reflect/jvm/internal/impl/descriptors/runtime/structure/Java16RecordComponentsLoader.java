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

        public Cache(Method r5, Method r10) {
            this.getType = r5;
            this.getAccessor = r10;
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

    private final Cache buildCache(Object r5) {
        Class<?> r10 = r5.getClass();
        return new Cache(r10.getMethod("getType", null), r10.getMethod("getAccessor", null));
    L6:
        return new Cache(null, null);
    }

    private final Cache initCache(Object r5) {
        Cache r10 = _cache;
        if (r10 != null) goto L6;
        Cache r11 = buildCache(r5);
        _cache = r11;
        return r11;
    L6:
        return r10;
    }

    public final Method loadGetAccessor(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "recordComponent");
        Method r10 = initCache(r5).getGetAccessor();
        if (r10 != null) goto L5;
        return null;
    L5:
        Object r11 = r10.invoke(r5, null);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type java.lang.reflect.Method");
        return (Method) r11;
    }

    public final Class<?> loadGetType(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "recordComponent");
        Method r10 = initCache(r5).getGetType();
        if (r10 != null) goto L5;
        return null;
    L5:
        Object r11 = r10.invoke(r5, null);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type java.lang.Class<*>");
        return (Class) r11;
    }
}
