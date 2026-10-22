package org.ehcache.core.spi;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.ehcache.spi.service.c;
import org.ehcache.spi.service.e;
import org.ehcache.spi.service.f;
import org.ehcache.spi.service.g;
import org.slf4j.d;

/* JADX INFO: loaded from: classes7.dex */
public final class ServiceLocator implements g<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final org.slf4j.c f18055a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f18056b;
    private final ReadWriteLock c;
    private final AtomicBoolean d;

    /* JADX INFO: renamed from: org.ehcache.core.spi.ServiceLocator$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class DependencyException extends Exception {
        private static final long serialVersionUID = -5269926129639323941L;

        public DependencyException(String r1) {
            super(r1);
        }
    }

    public static class a implements org.ehcache.config.a<ServiceLocator> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Iterable<org.ehcache.core.spi.a.c<?>> f18057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b f18058b;
        private final Set<Class<? extends c>> c;
        private boolean d;

        public a() {
            this.f18057a = org.ehcache.core.f.a.a(org.ehcache.core.spi.a.c.class);
            this.f18058b = new b();
            this.c = new HashSet();
            this.d = true;
        }

        private /* synthetic */ void a(e r3, org.ehcache.core.spi.a.c r4) {
            e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
            a(((org.ehcache.core.spi.a.c) ZeusTransformUtils.wrapperContextForParams(r4, org.ehcache.core.spi.a.c.class, "com.obric.memorydata.plugin")).a(r5));
        }

        private static /* synthetic */ boolean a(Class r2, org.ehcache.core.spi.a.c r3) {
            return r2.isAssignableFrom(((org.ehcache.core.spi.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.ehcache.core.spi.a.c.class, "com.obric.memorydata.plugin")).c());
        }

        private static /* synthetic */ boolean a(OptionalInt r2, org.ehcache.core.spi.a.c r3) {
            org.ehcache.core.spi.a.c r4 = (org.ehcache.core.spi.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.ehcache.core.spi.a.c.class, "com.obric.memorydata.plugin");
            if (r2.getAsInt() != r4.b()) goto L5;
            return true;
        L5:
            return false;
        }

        private static /* synthetic */ boolean a(b r2, org.ehcache.core.spi.a.c r3) {
            return !r2.b(((org.ehcache.core.spi.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.ehcache.core.spi.a.c.class, "com.obric.memorydata.plugin")).c());
        }

        private /* synthetic */ boolean a(org.ehcache.core.spi.a.c r3) {
            return !this.f18058b.b(((org.ehcache.core.spi.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.ehcache.core.spi.a.c.class, "com.obric.memorydata.plugin")).c());
        }

        private <T extends c> b b(b r6, Class<T> r7) {
            if (r6.b(r7) == true) goto L5;
        L7:
            b r8 = new b(r6).a(this.f18058b.a(r7));
            if (r8.b(r7) == true) goto L10;
        L12:
            Collection r0 = c(r8, r7);
            if (r0.size() > 1) goto L15;
        L19:
            Iterator r1 = r0.iterator();
        L21:
            if (r1.hasNext() == false) goto L27;
            org.ehcache.core.spi.a.c r2 = (org.ehcache.core.spi.a.c) ZeusTransformUtils.preCheckCast(r1.next(), org.ehcache.core.spi.a.c.class, "com.obric.memorydata.plugin");
            if (r8.b(r2.c()) == true) goto L21;
            b r9 = a(r8, r2.c());     // Catch: DependencyException -> L31
            r8 = new b(r9).a(r2.a(null));
            goto L21
        L27:
            if (r8.b(r7) == false) goto L30;
            return r8;
        L30:
            throw new DependencyException("Failed to find provider with satisfied dependency set for " + r7 + " [candidates " + r0 + "]");
        L15:
            if (r7.isAnnotationPresent(org.ehcache.spi.service.b.class) == true) goto L19;
            throw new DependencyException("Multiple factories for non-plural service");
        L10:
            if (r7.isAnnotationPresent(org.ehcache.spi.service.b.class) == true) goto L12;
            return r8;
        L5:
            if (r7.isAnnotationPresent(org.ehcache.spi.service.b.class) == true) goto L7;
            return r6;
        }

        private static /* synthetic */ boolean b(Class r2, org.ehcache.core.spi.a.c r3) {
            return r2.isAssignableFrom(((org.ehcache.core.spi.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.ehcache.core.spi.a.c.class, "com.obric.memorydata.plugin")).c());
        }

        private static /* synthetic */ boolean b(OptionalInt r2, org.ehcache.core.spi.a.c r3) {
            org.ehcache.core.spi.a.c r4 = (org.ehcache.core.spi.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.ehcache.core.spi.a.c.class, "com.obric.memorydata.plugin");
            if (r2.getAsInt() != r4.b()) goto L5;
            return true;
        L5:
            return false;
        }

        private static /* synthetic */ boolean b(org.ehcache.core.spi.a.c r2) {
            return !((org.ehcache.core.spi.a.c) ZeusTransformUtils.wrapperContextForParams(r2, org.ehcache.core.spi.a.c.class, "com.obric.memorydata.plugin")).getClass().isAnnotationPresent(org.ehcache.core.spi.a.c.a.class);
        }

        private <T, V> Collection<org.ehcache.core.spi.a.c<? extends T>> c(final b r3, final Class<T> r4) {
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(StreamSupport.stream(this.f18057a.spliterator(), false).filter(new $$Lambda$ServiceLocator$a$fK9oqnSK6iF07lT76lT4aUn9vWA(r4)).map($$Lambda$ServiceLocator$a$EnH23z1q7Lk3SJ7hjhdNtVOymYU.INSTANCE).filter($$Lambda$ServiceLocator$a$mWh79VtQlnja_xCCSY0dacZavA.INSTANCE).filter(new $$Lambda$ServiceLocator$a$SV9yBpYj6Eh9sGroQHl3Kd8Cc(this)).filter(new $$Lambda$ServiceLocator$a$w0AiVLyMo5K3ElHMfZA6DKjnXNE(r3)).collect(Collectors.toList()), Collection.class, "com.obric.memorydata.plugin");
            final OptionalInt r5 = r2.stream().mapToInt($$Lambda$tjqmgabOU_9vRXbSLIZurlBUV94.INSTANCE).max();
            if (r5.isPresent() == false) goto L7;
            return (Collection) ZeusTransformUtils.preCheckCast(r2.stream().filter(new $$Lambda$ServiceLocator$a$b9fK8UrETRmI0aRZFpwD6_FiM8(r5)).collect(Collectors.toList()), Collection.class, "com.obric.memorydata.plugin");
        L7:
            return Collections.emptyList();
        }

        private static /* synthetic */ org.ehcache.core.spi.a.c c(org.ehcache.core.spi.a.c r2) {
            return (org.ehcache.core.spi.a.c) ZeusTransformUtils.wrapperContextForParams(r2, org.ehcache.core.spi.a.c.class, "com.obric.memorydata.plugin");
        }

        private static /* synthetic */ boolean c(OptionalInt r2, org.ehcache.core.spi.a.c r3) {
            org.ehcache.core.spi.a.c r4 = (org.ehcache.core.spi.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.ehcache.core.spi.a.c.class, "com.obric.memorydata.plugin");
            if (r2.getAsInt() != r4.b()) goto L5;
            return true;
        L5:
            return false;
        }

        private static /* synthetic */ org.ehcache.core.spi.a.c d(org.ehcache.core.spi.a.c r2) {
            return (org.ehcache.core.spi.a.c) ZeusTransformUtils.wrapperContextForParams(r2, org.ehcache.core.spi.a.c.class, "com.obric.memorydata.plugin");
        }

        public static /* synthetic */ org.ehcache.core.spi.a.c lambda$3NVq3ECSEC1lIy8rs7gA_g4rakk(org.ehcache.core.spi.a.c r0) {
            return d(r0);
        }

        /* JADX INFO: renamed from: lambda$5ONICO7l5twNySmF9pGgJk-3fWQ, reason: not valid java name */
        public static /* synthetic */ boolean m3195lambda$5ONICO7l5twNySmF9pGgJk3fWQ(OptionalInt r0, org.ehcache.core.spi.a.c r1) {
            return b(r0, r1);
        }

        public static /* synthetic */ void lambda$9jmc7yYVuM2Ch9sW_bCSrB2UwA0(a r0, e r1, org.ehcache.core.spi.a.c r2) {
            r0.a(r1, r2);
        }

        public static /* synthetic */ org.ehcache.core.spi.a.c lambda$EnH23z1q7Lk3SJ7hjhdNtVOymYU(org.ehcache.core.spi.a.c r0) {
            return c(r0);
        }

        /* JADX INFO: renamed from: lambda$SV9yBpYj6-Eh9sGroQHl3-Kd8Cc, reason: not valid java name */
        public static /* synthetic */ boolean m3196lambda$SV9yBpYj6Eh9sGroQHl3Kd8Cc(a r0, org.ehcache.core.spi.a.c r1) {
            return r0.a(r1);
        }

        /* JADX INFO: renamed from: lambda$b9-fK8UrETRmI0aRZFpwD6_FiM8, reason: not valid java name */
        public static /* synthetic */ boolean m3197lambda$b9fK8UrETRmI0aRZFpwD6_FiM8(OptionalInt r0, org.ehcache.core.spi.a.c r1) {
            return a(r0, r1);
        }

        public static /* synthetic */ boolean lambda$fK9oqnSK6iF07lT76lT4aUn9vWA(Class r0, org.ehcache.core.spi.a.c r1) {
            return a(r0, r1);
        }

        /* JADX INFO: renamed from: lambda$mWh79VtQlnja_xCCSY0dacZ-avA, reason: not valid java name */
        public static /* synthetic */ boolean m3198lambda$mWh79VtQlnja_xCCSY0dacZavA(org.ehcache.core.spi.a.c r0) {
            return b(r0);
        }

        /* JADX INFO: renamed from: lambda$nxPfpR1fFJojzN-poWAOP2QAufM, reason: not valid java name */
        public static /* synthetic */ boolean m3199lambda$nxPfpR1fFJojzNpoWAOP2QAufM(Class r0, org.ehcache.core.spi.a.c r1) {
            return b(r0, r1);
        }

        public static /* synthetic */ boolean lambda$w0AiVLyMo5K3ElHMfZA6DKjnXNE(b r0, org.ehcache.core.spi.a.c r1) {
            return a(r0, r1);
        }

        public static /* synthetic */ boolean lambda$xJrS88bSSxc7vKfpOEyR4A9HiwI(OptionalInt r0, org.ehcache.core.spi.a.c r1) {
            return c(r0, r1);
        }

        @Override // org.ehcache.config.a
        public /* synthetic */ ServiceLocator a() {
            return b();
        }

        public a a(Class<? extends c> r2) {
            this.c.add(r2);
            return this;
        }

        public a a(Iterable<? extends c> r4) {
            Iterator r5 = ((Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            a((c) ZeusTransformUtils.preCheckCast(r5.next(), c.class, "com.obric.memorydata.plugin"));
            goto L4
        L6:
            return this;
        }

        public a a(c r3) {
            c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            this.f18058b.a(r4);
            return this;
        }

        public <T extends c> a a(e<T, ?> r5) {
            final e r6 = (e) ZeusTransformUtils.wrapperContextForParams(r5, e.class, "com.obric.memorydata.plugin");
            final Class<T> r0 = r6.a();
            if (this.f18058b.b(r0) == true) goto L5;
        L7:
            Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(StreamSupport.stream(this.f18057a.spliterator(), false).filter(new $$Lambda$ServiceLocator$a$nxPfpR1fFJojzNpoWAOP2QAufM(r0)).map($$Lambda$ServiceLocator$a$3NVq3ECSEC1lIy8rs7gA_g4rakk.INSTANCE).collect(Collectors.toList()), Collection.class, "com.obric.memorydata.plugin");
            final OptionalInt r2 = r1.stream().mapToInt($$Lambda$tjqmgabOU_9vRXbSLIZurlBUV94.INSTANCE).max();
            if (r2.isPresent() == false) goto L12;
            r1.stream().filter(new $$Lambda$ServiceLocator$a$xJrS88bSSxc7vKfpOEyR4A9HiwI(r2)).forEach(new $$Lambda$ServiceLocator$a$9jmc7yYVuM2Ch9sW_bCSrB2UwA0(this, r6));
            return this;
        L12:
            throw new IllegalStateException("No factories exist for " + r0);
        L5:
            if (r0.isAnnotationPresent(org.ehcache.spi.service.b.class) == true) goto L7;
            return this;
        }

        b a(b r7, Class<? extends c> r8) {
            Iterator r0 = ServiceLocator.c(r8).iterator();
        L4:
            if (r0.hasNext() == false) goto L15;
            Class r1 = (Class) ZeusTransformUtils.preCheckCast(r0.next(), Class.class, "com.obric.memorydata.plugin");
            r7 = b(r7, r1);     // Catch: DependencyException -> L8
        L8:
            e = move-exception;
            org.ehcache.spi.service.a r3 = (org.ehcache.spi.service.a) ZeusTransformUtils.preCheckCast(r8.getAnnotation(org.ehcache.spi.service.a.class), org.ehcache.spi.service.a.class, "com.obric.memorydata.plugin");
            if (r3 == null) goto L14;
            if (Arrays.asList(r3.a()).contains(r1.getName()) == false) goto L14;
            ServiceLocator.d().debug("Skipping optional dependency of {} that cannot be looked up: {}", r8, r1);
        L14:
            throw e;
        L15:
            return r7;
        }

        public ServiceLocator b() {
            b r0 = new b();     // Catch: DependencyException -> L37
            Iterator<c> r1 = this.f18058b.a().iterator();     // Catch: DependencyException -> L37
        L5:
            if (r1.hasNext() == false) goto L7;
            c r2 = (c) ZeusTransformUtils.preCheckCast(r1.next(), c.class, "com.obric.memorydata.plugin");     // Catch: DependencyException -> L37
            r0 = a(r0, r2.getClass()).a(r2);     // Catch: DependencyException -> L37
            goto L5
        L7:
            Iterator<Class<? extends c>> r3 = this.c.iterator();     // Catch: DependencyException -> L37
        L9:
            if (r3.hasNext() == false) goto L22;
            Class<? extends c> r4 = (Class) ZeusTransformUtils.preCheckCast(r3.next(), Class.class, "com.obric.memorydata.plugin");     // Catch: DependencyException -> L37
            if (r4.isAnnotationPresent(org.ehcache.spi.service.b.class) == false) goto L20;
            r0 = b(r0, r4);     // Catch: DependencyException -> L14
        L14:
            e = move-exception;
            if (r0.b(r4) == true) goto L9;
            throw e;     // Catch: DependencyException -> L37
        L20:
            if (r0.b(r4) == true) goto L9;
            r0 = b(r0, r4);     // Catch: DependencyException -> L37
            goto L9
        L22:
            AnonymousClass1 r5 = null;
            if (this.d == false) goto L36;
            Iterator r6 = ((Map) ZeusTransformUtils.preCheckCast(StreamSupport.stream(this.f18057a.spliterator(), false).collect(Collectors.groupingBy($$Lambda$KJnhd0P5nXfWdY2x_n5HkncjHY.INSTANCE)), Map.class, "com.obric.memorydata.plugin")).values().iterator();     // Catch: DependencyException -> L37
        L26:
            if (r6.hasNext() == false) goto L36;
            List r7 = (List) ZeusTransformUtils.preCheckCast(r6.next(), List.class, "com.obric.memorydata.plugin");     // Catch: DependencyException -> L37
            final OptionalInt r8 = r7.stream().mapToInt($$Lambda$tjqmgabOU_9vRXbSLIZurlBUV94.INSTANCE).max();     // Catch: DependencyException -> L37
            if (r8.isPresent() == false) goto L26;
            Iterator r9 = ((List) ZeusTransformUtils.preCheckCast(r7.stream().filter($$Lambda$nRW76cJkVPBL5U7xadR7KLpyHnE.INSTANCE).filter(new $$Lambda$ServiceLocator$a$5ONICO7l5twNySmF9pGgJk3fWQ(r8)).collect(Collectors.toList()), List.class, "com.obric.memorydata.plugin")).iterator();     // Catch: DependencyException -> L37
        L31:
            if (r9.hasNext() == false) goto L26;
            org.ehcache.core.spi.a.c r10 = (org.ehcache.core.spi.a.c) ZeusTransformUtils.preCheckCast(r9.next(), org.ehcache.core.spi.a.c.class, "com.obric.memorydata.plugin");     // Catch: DependencyException -> L37
            if (r0.b(r10.c()) == true) goto L31;
            c r11 = r10.a(null);     // Catch: DependencyException -> L37
            r0 = a(r0, r11.getClass()).a(r11);     // Catch: DependencyException -> L37
        L36:
            return new ServiceLocator(r0, r5);
        L37:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        public boolean b(Class<? extends c> r1) {
            return this.f18058b.b(r1);
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<Class<? extends c>, Set<c>> f18059a;

        public b() {
            this.f18059a = new HashMap();
        }

        public b(b r6) {
            this.f18059a = new HashMap();
            Iterator<Map.Entry<Class<? extends c>, Set<c>>> r7 = r6.f18059a.entrySet().iterator();
        L4:
            if (r7.hasNext() == false) goto L6;
            Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            Set<c> r1 = Collections.newSetFromMap(new IdentityHashMap());
            r1.addAll((Collection) ZeusTransformUtils.preCheckCast(r0.getValue(), Collection.class, "com.obric.memorydata.plugin"));
            this.f18059a.put((Class<? extends c>) r0.getKey(), r1);
            goto L4
        }

        public Set<c> a() {
            Set r0 = Collections.newSetFromMap(new IdentityHashMap());
            Iterator<Set<c>> r4 = this.f18059a.values().iterator();
        L4:
            if (r4.hasNext() == false) goto L7;
            r0.addAll((Set) ZeusTransformUtils.preCheckCast(r4.next(), Set.class, "com.obric.memorydata.plugin"));
            goto L4
        L7:
            return Collections.unmodifiableSet(r0);
        }

        public <T extends c> Set<T> a(Class<T> r2) {
            Set r1 = (Set) ZeusTransformUtils.preCheckCast(this.f18059a.get(r2), Set.class, "com.obric.memorydata.plugin");
            if (r1 != null) goto L7;
            return Collections.emptySet();
        L7:
            return Collections.unmodifiableSet(r1);
        }

        public b a(Iterable<? extends c> r4) {
            Iterator r5 = ((Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            a((c) ZeusTransformUtils.preCheckCast(r5.next(), c.class, "com.obric.memorydata.plugin"));
            goto L4
        L6:
            return this;
        }

        public b a(c r7) {
            c r8 = (c) ZeusTransformUtils.wrapperContextForParams(r7, c.class, "com.obric.memorydata.plugin");
            HashSet r0 = new HashSet();
            r0.add(r8.getClass());
            Iterator r2 = ServiceLocator.d(r8.getClass()).iterator();
        L4:
            if (r2.hasNext() == false) goto L10;
            Class r3 = (Class) ZeusTransformUtils.preCheckCast(r2.next(), Class.class, "com.obric.memorydata.plugin");
            if (c.class == r3) goto L4;
            if (c.class.isAssignableFrom(r3) == false) goto L4;
            r0.add(r3);
            goto L4
        L10:
            Iterator r4 = r0.iterator();
        L12:
            if (r4.hasNext() == false) goto L40;
            Class<? extends c> r5 = (Class) ZeusTransformUtils.preCheckCast(r4.next(), Class.class, "com.obric.memorydata.plugin");
            if (r5.isAnnotationPresent(org.ehcache.spi.service.b.class) == true) goto L15;
            Set r6 = (Set) ZeusTransformUtils.preCheckCast(this.f18059a.get(r5), Set.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L39;
            if (r6.isEmpty() == true) goto L39;
            if (r6.contains(r8) == true) goto L12;
            StringBuilder r9 = new StringBuilder("Duplicate service implementation(s) found for ").append(r8.getClass());
            Iterator r1 = r0.iterator();
        L28:
            if (r1.hasNext() == false) goto L38;
            Class r10 = (Class) ZeusTransformUtils.preCheckCast(r1.next(), Class.class, "com.obric.memorydata.plugin");
            if (r10.isAnnotationPresent(org.ehcache.spi.service.b.class) == true) goto L28;
            Set r11 = (Set) ZeusTransformUtils.preCheckCast(this.f18059a.get(r10), Set.class, "com.obric.memorydata.plugin");
            if (r11 != null) goto L34;
            c r12 = null;
        L35:
            if (r12 == null) goto L28;
            r9.append("\n\t\t- ").append(r10).append(" already has ").append(r12.getClass());
            goto L28
        L34:
            r12 = (c) ZeusTransformUtils.preCheckCast(r11.iterator().next(), c.class, "com.obric.memorydata.plugin");
            goto L35
        L38:
            throw new IllegalStateException(r9.toString());
        L39:
            this.f18059a.put(r5, Collections.singleton(r8));
            goto L12
        L15:
            Set<c> r13 = (Set) ZeusTransformUtils.preCheckCast(this.f18059a.get(r5), Set.class, "com.obric.memorydata.plugin");
            if (r13 != null) goto L18;
            r13 = new LinkedHashSet();
            this.f18059a.put(r5, r13);
        L18:
            r13.add(r8);
            goto L12
        L40:
            return this;
        }

        public boolean b(Class<? extends c> r1) {
            return this.f18059a.containsKey(r1);
        }
    }

    static {
        f18055a = d.a(ServiceLocator.class);
    }

    private ServiceLocator(b r3) {
        this.c = new ReentrantReadWriteLock();
        this.d = new AtomicBoolean(false);
        this.f18056b = r3;
    }

    /* synthetic */ ServiceLocator(b r1, AnonymousClass1 r2) {
        this(r1);
    }

    public static a a() {
        return new a();
    }

    private boolean a(c r5, Iterable<c> r6) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.memorydata.plugin");
        Iterable r7 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r6, Iterable.class, "com.obric.memorydata.plugin");
        Iterator<Class<? extends c>> r8 = g(r4.getClass()).iterator();
    L4:
        if (r8.hasNext() == false) goto L12;
        Class r9 = (Class) ZeusTransformUtils.preCheckCast(r8.next(), Class.class, "com.obric.memorydata.plugin");
        Iterator r1 = r7.iterator();
    L7:
        if (r1.hasNext() == false) goto L4;
        if (ZeusTransformUtils.instanceOf(r9, (c) ZeusTransformUtils.preCheckCast(r1.next(), c.class, "com.obric.memorydata.plugin")) == false) goto L7;
        return true;
    L12:
        return false;
    }

    private boolean b(c r4, Iterable<c> r5) {
        c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
        Iterator r6 = ((Iterable) ZeusTransformUtils.wrapperContextForParams(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L12;
        Iterator<Class<? extends c>> r7 = g(((c) ZeusTransformUtils.preCheckCast(r6.next(), c.class, "com.obric.memorydata.plugin")).getClass()).iterator();
    L7:
        if (r7.hasNext() == false) goto L4;
        if (ZeusTransformUtils.instanceOf((Class) ZeusTransformUtils.preCheckCast(r7.next(), Class.class, "com.obric.memorydata.plugin"), r3) == false) goto L7;
        return true;
    L12:
        return false;
    }

    static /* synthetic */ Set c(Class r0) {
        return f(r0);
    }

    static /* synthetic */ Collection d(Class r0) {
        return e(r0);
    }

    static /* synthetic */ org.slf4j.c d() {
        return f18055a;
    }

    private static Collection<Class<?>> e(Class<?> r5) {
        ArrayList r0 = new ArrayList();
    L3:
        if (r5 == null) goto L8;
        Class<?>[] r1 = r5.getInterfaces();
        int r2 = r1.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L7;
        Class<?> r4 = r1[r3];
        r0.add(r4);
        r0.addAll(e(r4));
        r3 = r3 + 1;
        goto L5
    L7:
        r5 = r5.getSuperclass();
        goto L3
    L8:
        return r0;
    }

    private static Set<Class<? extends c>> f(Class<?> r12) {
        if (r12 == null) goto L4;
        HashSet r0 = new HashSet();
        f r1 = (f) ZeusTransformUtils.preCheckCast(r12.getAnnotation(f.class), f.class, "com.obric.memorydata.plugin");
        int r5 = 0;
        if (r1 == null) goto L14;
        Class<? extends c>[] r2 = r1.a();
        int r6 = r2.length;
        int r7 = 0;
    L8:
        if (r7 >= r6) goto L14;
        Class<? extends c> r8 = r2[r7];
        if (c.class.isAssignableFrom(r8) == false) goto L13;
        r0.add(r8);
        r7 = r7 + 1;
        goto L8
    L13:
        throw new IllegalStateException("Service dependency declared by " + r12.getName() + " is not a Service: " + r8.getName());
    L14:
        org.ehcache.spi.service.a r3 = (org.ehcache.spi.service.a) ZeusTransformUtils.preCheckCast(r12.getAnnotation(org.ehcache.spi.service.a.class), org.ehcache.spi.service.a.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L25;
        String[] r4 = r3.a();
        int r9 = r4.length;
        int r10 = 0;
    L17:
        if (r10 >= r9) goto L25;
        String r11 = r4[r10];
        Class<?> r13 = org.ehcache.core.f.a.a(new ClassLoader[]{org.ehcache.core.f.a.a(), r12.getClassLoader()}).loadClass(r11);     // Catch: ClassNotFoundException -> L33
        if (c.class.isAssignableFrom(r13) == false) goto L23;
        r0.add(r13);     // Catch: ClassNotFoundException -> L33
        goto L24
    L23:
        throw new IllegalStateException("Service dependency declared by " + r11 + " is not a Service: " + r13.getName());     // Catch: ClassNotFoundException -> L33
    L24:
        r10 = r10 + 1;
    L25:
        Class<?>[] r14 = r12.getInterfaces();
        int r15 = r14.length;
    L26:
        if (r5 >= r15) goto L31;
        Class<?> r16 = r14[r5];
        if (c.class.isAssignableFrom(r16) == false) goto L30;
        r0.addAll(f((Class) ZeusTransformUtils.preCheckCast(c.class.getClass().cast(r16), Class.class, "com.obric.memorydata.plugin")));
    L30:
        r5 = r5 + 1;
        goto L26
    L31:
        r0.addAll(f(r12.getSuperclass()));
        return r0;
    L4:
        return Collections.emptySet();
    }

    private static Set<Class<? extends c>> g(Class<?> r7) {
        Set<Class<? extends c>> r0 = f(r7);
        Iterator<Class<? extends c>> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        if (((Class) ZeusTransformUtils.preCheckCast(r1.next(), Class.class, "com.obric.memorydata.plugin")) != r7) goto L4;
        throw new IllegalStateException("Circular dependency found. Service " + r7.getName() + " cannot depend on itself.");
    L10:
        HashSet r2 = new HashSet(r0.size() * 3);
        r2.addAll(r0);
        Iterator<Class<? extends c>> r3 = r0.iterator();
    L12:
        if (r3.hasNext() == false) goto L22;
        Set<Class<? extends c>> r4 = g((Class) ZeusTransformUtils.preCheckCast(r3.next(), Class.class, "com.obric.memorydata.plugin"));
        Iterator<Class<? extends c>> r5 = r4.iterator();
    L15:
        if (r5.hasNext() == false) goto L21;
        if (((Class) ZeusTransformUtils.preCheckCast(r5.next(), Class.class, "com.obric.memorydata.plugin")) != r7) goto L15;
        throw new IllegalStateException("Circular dependency found. A dependency of service " + r7.getName() + " depends on it.");
    L21:
        r2.addAll(r4);
        goto L12
    L22:
        return r2;
    }

    public <T extends c> T a(Class<T> r3) {
        if (r3.isAnnotationPresent(org.ehcache.spi.service.b.class) == true) goto L14;
        Collection<T> r2 = b(r3);
        if (r2.size() > 1) goto L12;
        if (r2.isEmpty() == false) goto L10;
        return null;
    L10:
        return (T) ZeusTransformUtils.preCheckCast(r2.iterator().next(), c.class, "com.obric.memorydata.plugin");
    L12:
        throw new AssertionError("The non-PluralService type" + r3.getName() + " has more than one service registered");
    L14:
        throw new IllegalArgumentException(r3.getName() + " is marked as a PluralService");
    }

    public boolean a(org.ehcache.spi.service.d<?, ?> r3) {
        org.ehcache.spi.service.d r4 = (org.ehcache.spi.service.d) ZeusTransformUtils.wrapperContextForParams(r3, org.ehcache.spi.service.d.class, "com.obric.memorydata.plugin");
        return this.f18056b.b(r4.b());
    }

    @Override // org.ehcache.spi.service.g
    public <T extends c> Collection<T> b(Class<T> r1) {
        return this.f18056b.a(r1);
    }

    public void b() {
        LinkedList r1 = new LinkedList();
        Lock r2 = this.c.writeLock();
        r2.lock();
    L24:
        th = move-exception;
        r2.unlock();
        throw th;
    L26:
        e = move-exception;
    L28:
        if (r1.isEmpty() == true) goto L34;
        ((c) ZeusTransformUtils.preCheckCast(r1.pop(), c.class, "com.obric.memorydata.plugin")).a();     // Catch: Throwable -> L24 Exception -> L32
    L32:
        e = move-exception;
        f18055a.error("Stopping Service failed due to ", e);     // Catch: Throwable -> L24
        goto L28
    L34:
        throw e;     // Catch: Throwable -> L24
    L4:
        if (this.d.compareAndSet(false, true) == false) goto L23;
        LinkedList r3 = new LinkedList(this.f18056b.a());     // Catch: Throwable -> L24 Exception -> L26
        int r6 = r3.size();     // Catch: Throwable -> L24 Exception -> L26
        long r7 = System.currentTimeMillis();     // Catch: Throwable -> L24 Exception -> L26
        f18055a.debug("Starting {} Services...", Integer.valueOf(r6));     // Catch: Throwable -> L24 Exception -> L26
    L7:
        if (r3.isEmpty() == true) goto L19;
        Iterator r9 = r3.iterator();     // Catch: Throwable -> L24 Exception -> L26
        boolean r10 = false;
    L10:
        if (r9.hasNext() == false) goto L15;
        c r11 = (c) ZeusTransformUtils.preCheckCast(r9.next(), c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24 Exception -> L26
        if (a(r11, r3) == true) goto L13;
        f18055a.trace("Starting {}", r11);     // Catch: Throwable -> L24 Exception -> L26
        r11.a(this);     // Catch: Throwable -> L24 Exception -> L26
        r1.push(r11);     // Catch: Throwable -> L24 Exception -> L26
        r9.remove();     // Catch: Throwable -> L24 Exception -> L26
        r10 = true;
        goto L10
    L13:
        f18055a.trace("Delaying starting {}", r11);     // Catch: Throwable -> L24 Exception -> L26
        goto L10
    L15:
        if (r10 == false) goto L18;
        f18055a.trace("Cycle complete: " + r3.size() + " Services remaining");     // Catch: Throwable -> L24 Exception -> L26
        goto L7
    L18:
        throw new IllegalStateException("Cyclic dependency in Service set: " + r3);     // Catch: Throwable -> L24 Exception -> L26
    L19:
        f18055a.debug("All Services successfully started, {} Services in {}ms", Integer.valueOf(r6), Long.valueOf(System.currentTimeMillis() - r7));     // Catch: Throwable -> L24 Exception -> L26
        r2.unlock();
        return;
    L23:
        throw new IllegalStateException("Already started!");     // Catch: Throwable -> L24 Exception -> L26
    }

    public void c() {
        Lock r0 = this.c.writeLock();
        r0.lock();
    L33:
        th = move-exception;
        r0.unlock();
        throw th;
    L4:
        if (this.d.compareAndSet(true, false) == false) goto L32;
        LinkedList r1 = new LinkedList(this.f18056b.a());     // Catch: Throwable -> L33
        int r4 = r1.size();     // Catch: Throwable -> L33
        long r5 = System.currentTimeMillis();     // Catch: Throwable -> L33
        f18055a.debug("Stopping {} Services...", Integer.valueOf(r4));     // Catch: Throwable -> L33
        Exception r7 = null;
    L7:
        if (r1.isEmpty() == true) goto L26;
        Iterator r8 = r1.iterator();     // Catch: Throwable -> L33
        boolean r9 = false;
    L10:
        if (r8.hasNext() == false) goto L22;
        c r10 = (c) ZeusTransformUtils.preCheckCast(r8.next(), c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        if (b(r10, r1) == true) goto L13;
        f18055a.trace("Stopping {}", r10);     // Catch: Throwable -> L33
        r10.a();     // Catch: Exception -> L17 Throwable -> L33
    L21:
        r8.remove();     // Catch: Throwable -> L33
        r9 = true;
        goto L10
    L17:
        e = move-exception;
        if (r7 != null) goto L20;
        r7 = e;
        goto L21
    L20:
        f18055a.error("Stopping Service failed due to ", e);     // Catch: Throwable -> L33
        goto L21
    L13:
        f18055a.trace("Delaying stopping {}", r10);     // Catch: Throwable -> L33
        goto L10
    L22:
        if (r9 == false) goto L25;
        f18055a.trace("Cycle complete: " + r1.size() + " Services remaining");     // Catch: Throwable -> L33
        goto L7
    L25:
        throw new AssertionError("Cyclic dependency in Service set: " + r1);     // Catch: Throwable -> L33
    L26:
        f18055a.debug("All Services successfully stopped, {} Services in {}ms", Integer.valueOf(r4), Long.valueOf(System.currentTimeMillis() - r5));     // Catch: Throwable -> L33
        r0.unlock();
        if (r7 != null) goto L30;
        return;
    L30:
        throw r7;
    L32:
        throw new IllegalStateException("Already stopped!");     // Catch: Throwable -> L33
    }
}
