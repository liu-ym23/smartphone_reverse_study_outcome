package kotlin.reflect.full;

import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J \u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000b2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lkotlin/reflect/full/Java8RepeatableContainerLoader;", "", "()V", "cache", "Lkotlin/reflect/full/Java8RepeatableContainerLoader$Cache;", "getCache", "()Lkotlin/reflect/full/Java8RepeatableContainerLoader$Cache;", "setCache", "(Lkotlin/reflect/full/Java8RepeatableContainerLoader$Cache;)V", "buildCache", "loadRepeatableContainer", "Ljava/lang/Class;", "", "klass", "Cache", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nKAnnotatedElements.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KAnnotatedElements.kt\nkotlin/reflect/full/Java8RepeatableContainerLoader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,102:1\n1#2:103\n*E\n"})
final class Java8RepeatableContainerLoader {
    public static final Java8RepeatableContainerLoader INSTANCE = null;
    private static Cache cache;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u001b\u0010\u0002\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlin/reflect/full/Java8RepeatableContainerLoader$Cache;", "", "repeatableClass", "Ljava/lang/Class;", "", "valueMethod", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/lang/reflect/Method;)V", "getRepeatableClass", "()Ljava/lang/Class;", "getValueMethod", "()Ljava/lang/reflect/Method;", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Cache {
        private final Class<? extends Annotation> repeatableClass;
        private final Method valueMethod;

        public Cache(Class<? extends Annotation> r5, Method r10) {
            this.repeatableClass = r5;
            this.valueMethod = r10;
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
        Intrinsics.checkNotNull(Repeatable.class, "null cannot be cast to non-null type java.lang.Class<out kotlin.Annotation>");     // Catch: ClassNotFoundException -> L6
        return new Cache(Repeatable.class, Repeatable.class.getMethod("value", null));
    L7:
        return new Cache(null, null);
    }

    public final Class<? extends Annotation> loadRepeatableContainer(Class<? extends Annotation> r5) {
        Intrinsics.checkNotNullParameter(r5, "klass");
        Cache r10 = cache;
        if (r10 != null) goto L15;
        monitor-enter(this);
        r10 = cache;     // Catch: Throwable -> L9
        if (r10 != null) goto L11;
        r10 = INSTANCE.buildCache();     // Catch: Throwable -> L9
        cache = r10;     // Catch: Throwable -> L9
    L11:
        monitor-exit(this);
    L9:
        th = move-exception;
        throw th;
    L15:
        Class r11 = r10.getRepeatableClass();
        if (r11 != null) goto L18;
        return null;
    L18:
        Annotation r12 = r5.getAnnotation(r11);
        if (r12 != null) goto L21;
        return null;
    L21:
        Method r13 = r10.getValueMethod();
        if (r13 != null) goto L24;
        return null;
    L24:
        Object r14 = r13.invoke(r12, null);
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type java.lang.Class<out kotlin.Annotation>");
        return (Class) r14;
    }
}
