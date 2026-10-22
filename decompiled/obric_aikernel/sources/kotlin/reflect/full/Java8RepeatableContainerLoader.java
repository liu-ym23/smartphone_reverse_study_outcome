package kotlin.reflect.full;

import com.bytedance.crash.entity.EventBody;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
final class Java8RepeatableContainerLoader {
    public static final Java8RepeatableContainerLoader INSTANCE = null;
    private static Cache cache;

    public static final class Cache {
        private final Class<? extends Annotation> repeatableClass;
        private final Method valueMethod;

        public Cache(Class<? extends Annotation> r10, Method r11) {
            this.repeatableClass = r10;
            this.valueMethod = r11;
        }

        public final Class<? extends Annotation> getRepeatableClass() {
            return this.repeatableClass;
        }

        public final Method getValueMethod() {
            return this.valueMethod;
        }
    }

    static {
        INSTANCE = new Java8RepeatableContainerLoader();
    }

    private Java8RepeatableContainerLoader() {
    }

    private final Cache buildCache() {
        Class<?> r10 = Class.forName("java.lang.annotation.Repeatable");     // Catch: ClassNotFoundException -> L5
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.lang.Class<out kotlin.Annotation>");     // Catch: ClassNotFoundException -> L5
        return new Cache(r10, r10.getMethod(EventBody.KEY_VALUE, new Class[0]));
    L6:
        return new Cache(null, null);
    }

    public final Class<? extends Annotation> loadRepeatableContainer(Class<? extends Annotation> r10) {
        Intrinsics.checkNotNullParameter(r10, "klass");
        Cache r11 = cache;
        if (r11 != null) goto L15;
        monitor-enter(this);
        Java8RepeatableContainerLoader r12 = INSTANCE;     // Catch: Throwable -> L12
        Cache r13 = cache;     // Catch: Throwable -> L12
        if (r13 != null) goto L9;
        r11 = r12.buildCache();     // Catch: Throwable -> L12
        cache = r11;     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        goto L15
    L9:
        r11 = r13;
    L12:
        th = move-exception;
        throw th;
    L15:
        Class r14 = r11.getRepeatableClass();
        if (r14 != null) goto L18;
        return null;
    L18:
        Annotation r15 = r10.getAnnotation(r14);
        if (r15 != null) goto L21;
        return null;
    L21:
        Method r16 = r11.getValueMethod();
        if (r16 != null) goto L24;
        return null;
    L24:
        Object r17 = r16.invoke(r15, new Object[0]);
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type java.lang.Class<out kotlin.Annotation>");
        return (Class) r17;
    }
}
