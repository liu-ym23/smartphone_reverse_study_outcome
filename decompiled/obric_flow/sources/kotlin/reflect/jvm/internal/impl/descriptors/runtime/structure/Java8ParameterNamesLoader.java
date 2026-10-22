package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nReflectJavaMember.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJavaMember.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/Java8ParameterNamesLoader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,105:1\n1#2:106\n11335#3:107\n11670#3,3:108\n*S KotlinDebug\n*F\n+ 1 ReflectJavaMember.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/Java8ParameterNamesLoader\n*L\n100#1:107\n100#1:108,3\n*E\n"})
final class Java8ParameterNamesLoader {
    public static final Java8ParameterNamesLoader INSTANCE = null;
    private static Cache cache;

    public static final class Cache {
        private final Method getName;
        private final Method getParameters;

        public Cache(Method r5, Method r10) {
            this.getParameters = r5;
            this.getName = r10;
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

    public final Cache buildCache(Member r5) {
        Intrinsics.checkNotNullParameter(r5, "member");
        Class<?> r10 = r5.getClass();
        Method r11 = r10.getMethod("getParameters", null);     // Catch: NoSuchMethodException -> L6
        return new Cache(r11, ReflectClassUtilKt.getSafeClassLoader(r10).loadClass("java.lang.reflect.Parameter").getMethod("getName", null));
    L7:
        return new Cache(null, null);
    }

    public final List<String> loadParameterNames(Member r10) {
        Intrinsics.checkNotNullParameter(r10, "member");
        Cache r5 = cache;
        if (r5 != null) goto L15;
        monitor-enter(this);
        r5 = cache;     // Catch: Throwable -> L9
        if (r5 != null) goto L11;
        r5 = INSTANCE.buildCache(r10);     // Catch: Throwable -> L9
        cache = r5;     // Catch: Throwable -> L9
    L11:
        monitor-exit(this);
    L9:
        th = move-exception;
        throw th;
    L15:
        Method r11 = r5.getGetParameters();
        if (r11 != null) goto L18;
        return null;
    L18:
        Method r12 = r5.getGetName();
        if (r12 != null) goto L21;
        return null;
    L21:
        Object r13 = r11.invoke(r10, null);
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] r14 = (Object[]) r13;
        ArrayList r15 = new ArrayList(r14.length);
        int r16 = r14.length;
        int r17 = 0;
    L22:
        if (r17 >= r16) goto L24;
        Object r18 = r12.invoke(r14[r17], null);
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type kotlin.String");
        r15.add((String) r18);
        r17 = r17 + 1;
        goto L22
    L24:
        return r15;
    }
}
