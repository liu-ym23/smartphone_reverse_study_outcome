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

        public Cache(Method r10, Method r11, Method r12, Method r13) {
            this.isSealed = r10;
            this.getPermittedSubclasses = r11;
            this.isRecord = r12;
            this.getRecordComponents = r13;
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
        return new Cache(Class.class.getMethod("isSealed", new Class[0]), Class.class.getMethod("getPermittedSubclasses", new Class[0]), Class.class.getMethod("isRecord", new Class[0]), Class.class.getMethod("getRecordComponents", new Class[0]));
    L6:
        return new Cache(null, null, null, null);
    }

    private final Cache initCache() {
        Cache r10 = _cache;
        if (r10 != null) goto L6;
        Cache r11 = buildCache();
        _cache = r11;
        return r11;
    L6:
        return r10;
    }

    public final Class<?>[] loadGetPermittedSubclasses(Class<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        Method r11 = initCache().getGetPermittedSubclasses();
        if (r11 != null) goto L6;
        return null;
    L6:
        Object r12 = r11.invoke(r10, new Object[0]);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Array<java.lang.Class<*>>");
        return (Class[]) r12;
    }

    public final Object[] loadGetRecordComponents(Class<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        Method r11 = initCache().getGetRecordComponents();
        if (r11 != null) goto L7;
        return null;
    L7:
        return (Object[]) r11.invoke(r10, new Object[0]);
    }

    public final Boolean loadIsRecord(Class<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        Method r11 = initCache().isRecord();
        if (r11 != null) goto L6;
        return null;
    L6:
        Object r12 = r11.invoke(r10, new Object[0]);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) r12;
    }

    public final Boolean loadIsSealed(Class<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        Method r11 = initCache().isSealed();
        if (r11 != null) goto L6;
        return null;
    L6:
        Object r12 = r11.invoke(r10, new Object[0]);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) r12;
    }
}
