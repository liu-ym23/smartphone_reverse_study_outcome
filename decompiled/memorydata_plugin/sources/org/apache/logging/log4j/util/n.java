package org.apache.logging.log4j.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.apache.logging.log4j.status.StatusLogger;

/* JADX INFO: loaded from: classes6.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final MethodType f17933a = null;

    private static class a<S> implements Spliterator<S> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Iterator<S> f17934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final org.apache.logging.log4j.c f17935b;
        private final String c;

        public a(Class<S> r1, MethodHandles.Lookup r2, ClassLoader r3, boolean r4) {
            this.f17934a = n.a(r2, r1, r3, r4).iterator();
            if (r4 == false) goto L5;
            StatusLogger r5 = StatusLogger.getLogger();
        L6:
            this.f17935b = r5;
            this.c = r1.toString();
            return;
        L5:
            r5 = null;
            goto L6
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 1280;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return Long.MAX_VALUE;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super S> r5) {
            Consumer r6 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r5, Consumer.class, "com.obric.memorydata.plugin");
        L4:
            if (this.f17934a.hasNext() == false) goto L12;
            r6.accept(this.f17934a.next());     // Catch: ServiceConfigurationError -> L8
            return true;
        L8:
            e = move-exception;
            org.apache.logging.log4j.c r1 = this.f17935b;
            if (r1 == null) goto L4;
            r1.warn("Unable to load service class for service {}", this.c, e);
            goto L4
        L12:
            return false;
        }

        @Override // java.util.Spliterator
        public Spliterator<S> trySplit() {
            return null;
        }
    }

    static {
        f17933a = MethodType.methodType(ServiceLoader.class, Class.class, new Class[]{ClassLoader.class});
    }

    static <T> Iterable<T> a(MethodHandles.Lookup r3, Class<T> r4, ClassLoader r5, boolean r6) {
        return (ServiceLoader) r3.findStatic(ServiceLoader.class, "load", f17933a).invokeExact(r4, r5);
    L4:
        th = move-exception;
        if (r6 == false) goto L8;
        StatusLogger.getLogger().error("Unable to load services for service {}", r4, th);
    L8:
        return Collections.emptyList();
    }

    static <T> Stream<T> a(Class<T> r1, MethodHandles.Lookup r2, ClassLoader r3, boolean r4) {
        return StreamSupport.stream(new a(r1, r2, r3, r4), false);
    }

    public static <T> Stream<T> a(Class<T> r1, MethodHandles.Lookup r2, boolean r3) {
        return a(r1, r2, r3, true);
    }

    static <T> Stream<T> a(Class<T> r2, MethodHandles.Lookup r3, boolean r4, boolean r5) {
        ClassLoader r0 = r3.lookupClass().getClassLoader();
        Stream r1 = a(r2, r3, r0, r5);
        if (r4 == false) goto L8;
        ClassLoader r6 = g.a();
        if (r6 == r0) goto L8;
        r1 = Stream.concat(r1, a(r2, r3, r6, r5));
    L8:
        if (j.a() == false) goto L10;
        r1 = Stream.concat(r1, j.a(r2, r3, r5));
    L10:
        final HashSet r7 = new HashSet();
        return r1.filter(new $$Lambda$n$95U0VvELb5PA4bnCPQEFH9XuOiw(r7));
    }

    private static /* synthetic */ boolean a(Set r2, Object r3) {
        return ((Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin")).add(r3.getClass());
    }

    public static /* synthetic */ boolean lambda$95U0VvELb5PA4bnCPQEFH9XuOiw(Set r0, Object r1) {
        return a(r0, r1);
    }
}
