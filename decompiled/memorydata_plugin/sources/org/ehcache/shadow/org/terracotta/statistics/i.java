package org.ehcache.shadow.org.terracotta.statistics;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes7.dex */
public class i extends org.ehcache.shadow.org.terracotta.a.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f18155a = null;

    static class a<T> implements Supplier<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<Object> f18156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f18157b;

        a(Object r2, Method r3) {
            this.f18156a = new WeakReference(r2);
            this.f18157b = r3;
        }

        @Override // java.util.function.Supplier
        public T get() {
            return (T) this.f18157b.invoke(this.f18156a.get(), new Object[0]);
        L7:
            e = move-exception;
            throw new RuntimeException(e);
        L4:
            e = move-exception;
            throw new RuntimeException(e.getTargetException());
        }
    }

    static {
        f18155a = Pattern.quote("=");
        org.ehcache.shadow.org.terracotta.a.e.a($$Lambda$i$V8AKLEcNn9OL30pPF9vu6TvaCyQ.INSTANCE);
    }

    public static <T extends Enum<T>> org.ehcache.shadow.org.terracotta.statistics.a.b<T> a(Object r2, String r3, Set<String> r4, Map<String, ? extends Object> r5, Class<T> r6) {
        d r7 = a(r3, (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin"), r6);
        a(r2).a(r7);
        return r7;
    }

    private static <T extends Enum<T>> d<T> a(String r2, Set<String> r3, Map<String, ? extends Object> r4, Class<T> r5) {
        return new c(r2, (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"), r5);
    }

    public static <T extends Serializable> void a(Object r8, String r9, Set<String> r10, Map<String, ? extends Object> r11, l<T> r12) {
        e r13 = new e(r8, r9, (Set) ZeusTransformUtils.wrapperContextForParams(r10, Set.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin"), (l) ZeusTransformUtils.wrapperContextForParams(r12, l.class, "com.obric.memorydata.plugin"));
        a(r8).a(r13);
    }

    public static <T extends Serializable> void a(Object r2, String r3, Set<String> r4, l<T> r5) {
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        l r7 = (l) ZeusTransformUtils.wrapperContextForParams(r5, l.class, "com.obric.memorydata.plugin");
        a(r2, r3, r6, Collections.emptyMap(), r7);
    }

    private static void b(Object r8) {
        Method[] r0 = r8.getClass().getMethods();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L25;
        Method r3 = r0[r2];
        g r4 = (g) ZeusTransformUtils.preCheckCast(r3.getAnnotation(g.class), g.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L24;
        Class<?> r5 = r3.getReturnType();
        if (r3.getParameterTypes().length != 0) goto L23;
        if (Number.class.isAssignableFrom(r5) == true) goto L18;
        if (r3.getReturnType().isPrimitive() == false) goto L16;
        if (r3.getReturnType().equals(Boolean.TYPE) == false) goto L18;
    L16:
        throw new IllegalArgumentException("Statistic methods must return a Number: " + r3);
    L18:
        if (Modifier.isStatic(r3.getModifiers()) == true) goto L21;
        a(r8, r4.a(), new HashSet(Arrays.asList(r4.c())), m.a(r4.b(), new a(r8, r3)));
        goto L24
    L21:
        throw new IllegalArgumentException("Statistic methods must be non-static: " + r3);
    L23:
        throw new IllegalArgumentException("Statistic methods must be no-arg: " + r3);
    L24:
        r2 = r2 + 1;
        goto L3
    }

    public static /* synthetic */ void lambda$V8AKLEcNn9OL30pPF9vu6TvaCyQ(Object r0) {
        b(r0);
    }
}
