package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
final class Java16SealedRecordLoader {
    public static final Java16SealedRecordLoader INSTANCE = null;
    private static Cache _cache;

    public static final class Cache {
        private final Method getPermittedSubclasses;
        private final Method getRecordComponents;
        private final Method isRecord;
        private final Method isSealed;

        public Cache(Method r5, Method r10, Method r11, Method r12) {
            this.isSealed = r5;
            this.getPermittedSubclasses = r10;
            this.isRecord = r11;
            this.getRecordComponents = r12;
        }

        public final Method getGetPermittedSubclasses() {
            return this.getPermittedSubclasses;
        }

        public final Method getGetRecordComponents() {
            return this.getRecordComponents;
        }

        public final Method isRecord() {
            return this.isRecord;
        }

        public final Method isSealed() {
            return this.isSealed;
        }
    }

    static {
        INSTANCE = new Java16SealedRecordLoader();
    }

    private Java16SealedRecordLoader() {
    }

    private final Cache buildCache() {
        return new Cache(Class.class.getMethod("isSealed", null), Class.class.getMethod("getPermittedSubclasses", null), Class.class.getMethod("isRecord", null), Class.class.getMethod("getRecordComponents", null));
    L6:
        return new Cache(null, null, null, null);
    }

    private final Cache initCache() {
        Cache r5 = _cache;
        if (r5 != null) goto L6;
        Cache r10 = buildCache();
        _cache = r10;
        return r10;
    L6:
        return r5;
    }

    public final Class<?>[] loadGetPermittedSubclasses(Class<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        Method r10 = initCache().getGetPermittedSubclasses();
        if (r10 != null) goto L5;
        return null;
    L5:
        Object r11 = r10.invoke(r5, null);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Array<java.lang.Class<*>>");
        return (Class[]) r11;
    }

    public final Object[] loadGetRecordComponents(Class<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        Method r10 = initCache().getGetRecordComponents();
        if (r10 != null) goto L6;
        return null;
    L6:
        return (Object[]) r10.invoke(r5, null);
    }

    public final Boolean loadIsRecord(Class<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        Method r10 = initCache().isRecord();
        if (r10 != null) goto L5;
        return null;
    L5:
        Object r11 = r10.invoke(r5, null);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) r11;
    }

    public final Boolean loadIsSealed(Class<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        Method r10 = initCache().isSealed();
        if (r10 != null) goto L5;
        return null;
    L5:
        Object r11 = r10.invoke(r5, null);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) r11;
    }
}
