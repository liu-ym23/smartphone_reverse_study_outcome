package org.ehcache.core.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URL;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.ehcache.core.c.b;
import org.ehcache.core.c.c;

/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ClassLoader f18046a = null;

    /* JADX INFO: renamed from: org.ehcache.core.f.a$a, reason: collision with other inner class name */
    private static class C0894a extends ClassLoader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<Supplier<ClassLoader>> f18047a;

        public C0894a(List<Supplier<ClassLoader>> r3) {
            this.f18047a = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        }

        @Override // java.lang.ClassLoader
        public URL getResource(String r4) {
            Iterator<Supplier<ClassLoader>> r3 = this.f18047a.iterator();
        L4:
            if (r3.hasNext() == false) goto L10;
            ClassLoader r0 = (ClassLoader) ZeusTransformUtils.preCheckCast(((Supplier) ZeusTransformUtils.preCheckCast(r3.next(), Supplier.class, "com.obric.memorydata.plugin")).get(), ClassLoader.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L4;
            URL r1 = r0.getResource(r4);
            if (r1 == null) goto L4;
            return r1;
        L10:
            return null;
        }

        @Override // java.lang.ClassLoader
        public Enumeration<URL> getResources(String r5) {
            ArrayList r0 = new ArrayList();
            Iterator<Supplier<ClassLoader>> r4 = this.f18047a.iterator();
        L4:
            if (r4.hasNext() == false) goto L9;
            ClassLoader r1 = (ClassLoader) ZeusTransformUtils.preCheckCast(((Supplier) ZeusTransformUtils.preCheckCast(r4.next(), Supplier.class, "com.obric.memorydata.plugin")).get(), ClassLoader.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L4;
            r0.addAll(Collections.list(r1.getResources(r5)));
            goto L4
        L9:
            return Collections.enumeration(r0);
        }

        @Override // java.lang.ClassLoader
        public Class<?> loadClass(String r5) {
            ClassNotFoundException e = new ClassNotFoundException(r5);
            Iterator<Supplier<ClassLoader>> r4 = this.f18047a.iterator();
        L4:
            if (r4.hasNext() == false) goto L11;
            ClassLoader r1 = (ClassLoader) ZeusTransformUtils.preCheckCast(((Supplier) ZeusTransformUtils.preCheckCast(r4.next(), Supplier.class, "com.obric.memorydata.plugin")).get(), ClassLoader.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L4;
            return r1.loadClass(r5);
        L9:
            e = e;
            goto L4
        L11:
            throw e;
        }
    }

    static {
        f18046a = a($$Lambda$a$BDZXfBCyCBomoslO2FWDiALj7O0.INSTANCE, new ClassLoader[]{C0894a.class.getClassLoader()});
    }

    public a() {
    }

    public static ClassLoader a() {
        return f18046a;
    }

    public static ClassLoader a(Supplier<ClassLoader> r2, final ClassLoader... r3) {
        final Supplier r4 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r2, Supplier.class, "com.obric.memorydata.plugin");
        return (ClassLoader) ZeusTransformUtils.preCheckCast(AccessController.doPrivileged(new $$Lambda$a$ZwRanbYR2DOQ_h6xlEsOn4t1mIs(r4, r3)), ClassLoader.class, "com.obric.memorydata.plugin");
    }

    public static ClassLoader a(final ClassLoader... r2) {
        return (ClassLoader) ZeusTransformUtils.preCheckCast(AccessController.doPrivileged(new $$Lambda$a$avSFH5VYpvYchn3OuiGFSrF7SM(r2)), ClassLoader.class, "com.obric.memorydata.plugin");
    }

    public static <T> Iterable<T> a(Class<T> r1) {
        if (c.a() == false) goto L7;
        return b.a(r1);
    L7:
        return ServiceLoader.load(r1, a.class.getClassLoader());
    }

    private static /* synthetic */ Supplier a(final ClassLoader r1) {
        return new $$Lambda$a$lipQVaxPb_iq182HTngr26vjVZc(r1);
    }

    private static /* synthetic */ ClassLoader b() {
        return Thread.currentThread().getContextClassLoader();
    }

    private static /* synthetic */ ClassLoader b(ClassLoader r0) {
        return r0;
    }

    private static /* synthetic */ ClassLoader b(Supplier r3, ClassLoader[] r4) {
        return new C0894a((List) ZeusTransformUtils.preCheckCast(Stream.concat(Stream.of((Supplier) ZeusTransformUtils.wrapperContextForParams(r3, Supplier.class, "com.obric.memorydata.plugin")), Stream.of(r4).map($$Lambda$a$EHokt4mvGKPAEZ4CHXWPheyOLEA.INSTANCE)).collect(Collectors.toList()), List.class, "com.obric.memorydata.plugin"));
    }

    private static /* synthetic */ ClassLoader b(ClassLoader[] r3) {
        return new C0894a((List) ZeusTransformUtils.preCheckCast(Stream.of(r3).map($$Lambda$a$BpMFLFXJhzpMUmR_RKL148hwWv0.INSTANCE).collect(Collectors.toList()), List.class, "com.obric.memorydata.plugin"));
    }

    private static /* synthetic */ Supplier c(final ClassLoader r1) {
        return new $$Lambda$a$6ev_Au_hWB5UJx4MOlPx4Rn5mSc(r1);
    }

    private static /* synthetic */ ClassLoader d(ClassLoader r0) {
        return r0;
    }

    public static /* synthetic */ ClassLoader lambda$6ev_Au_hWB5UJx4MOlPx4Rn5mSc(ClassLoader r0) {
        return d(r0);
    }

    public static /* synthetic */ ClassLoader lambda$BDZXfBCyCBomoslO2FWDiALj7O0() {
        return b();
    }

    public static /* synthetic */ Supplier lambda$BpMFLFXJhzpMUmR_RKL148hwWv0(ClassLoader r0) {
        return a(r0);
    }

    public static /* synthetic */ Supplier lambda$EHokt4mvGKPAEZ4CHXWPheyOLEA(ClassLoader r0) {
        return c(r0);
    }

    public static /* synthetic */ ClassLoader lambda$ZwRanbYR2DOQ_h6xlEsOn4t1mIs(Supplier r0, ClassLoader[] r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$avSFH5VYpvYchn3Ou-iGFSrF7SM, reason: not valid java name */
    public static /* synthetic */ ClassLoader m3193lambda$avSFH5VYpvYchn3OuiGFSrF7SM(ClassLoader[] r0) {
        return b(r0);
    }

    public static /* synthetic */ ClassLoader lambda$lipQVaxPb_iq182HTngr26vjVZc(ClassLoader r0) {
        return b(r0);
    }
}
