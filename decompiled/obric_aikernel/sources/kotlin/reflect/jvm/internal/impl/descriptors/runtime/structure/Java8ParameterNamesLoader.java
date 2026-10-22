package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
final class Java8ParameterNamesLoader {
    public static final Java8ParameterNamesLoader INSTANCE = null;
    private static Cache cache;

    public static final class Cache {
        private final Method getName;
        private final Method getParameters;

        public Cache(Method r10, Method r11) {
            this.getParameters = r10;
            this.getName = r11;
        }

        public final Method getGetName() {
            return this.getName;
        }

        public final Method getGetParameters() {
            return this.getParameters;
        }
    }

    static {
        INSTANCE = new Java8ParameterNamesLoader();
    }

    private Java8ParameterNamesLoader() {
    }

    public final Cache buildCache(Member r10) {
        Intrinsics.checkNotNullParameter(r10, "member");
        Class<?> r11 = r10.getClass();
        Method r12 = r11.getMethod("getParameters", new Class[0]);     // Catch: NoSuchMethodException -> L6
        return new Cache(r12, ReflectClassUtilKt.getSafeClassLoader(r11).loadClass("java.lang.reflect.Parameter").getMethod("getName", new Class[0]));
    L7:
        return new Cache(null, null);
    }

    public final List<String> loadParameterNames(Member r10) {
        Intrinsics.checkNotNullParameter(r10, "member");
        Cache r11 = cache;
        if (r11 != null) goto L15;
        monitor-enter(this);
        Java8ParameterNamesLoader r12 = INSTANCE;     // Catch: Throwable -> L12
        Cache r13 = cache;     // Catch: Throwable -> L12
        if (r13 != null) goto L9;
        r11 = r12.buildCache(r10);     // Catch: Throwable -> L12
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
        Method r14 = r11.getGetParameters();
        if (r14 != null) goto L18;
        return null;
    L18:
        Method r15 = r11.getGetName();
        if (r15 != null) goto L21;
        return null;
    L21:
        Object r16 = r14.invoke(r10, new Object[0]);
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] r17 = (Object[]) r16;
        ArrayList r18 = new ArrayList(r17.length);
        int r19 = r17.length;
        int r20 = 0;
    L22:
        if (r20 >= r19) goto L24;
        Object r21 = r15.invoke(r17[r20], new Object[0]);
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type kotlin.String");
        r18.add((String) r21);
        r20 = r20 + 1;
        goto L22
    L24:
        return r18;
    }
}
