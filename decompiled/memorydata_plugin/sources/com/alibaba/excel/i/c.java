package com.alibaba.excel.i;

import com.alibaba.excel.enums.CacheLocationEnum;
import com.alibaba.excel.exception.ExcelCommonException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.collections4.CollectionUtils;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<b, com.alibaba.excel.metadata.h> f203a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Class<?>, Map<String, com.alibaba.excel.metadata.a.c>> f204b = null;
    public static final ConcurrentHashMap<a, com.alibaba.excel.metadata.a.c> c = null;
    private static final ThreadLocal<Map<b, com.alibaba.excel.metadata.h>> d = null;
    private static final ThreadLocal<Map<Class<?>, Map<String, com.alibaba.excel.metadata.a.c>>> e = null;
    private static final ThreadLocal<Map<a, com.alibaba.excel.metadata.a.c>> f = null;

    /* JADX INFO: renamed from: com.alibaba.excel.i.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f205a = null;

        static {
            int[] r0 = new int[CacheLocationEnum.values().length];
            f205a = r0;
            r0[CacheLocationEnum.THREAD_LOCAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f205a[CacheLocationEnum.MEMORY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f205a[CacheLocationEnum.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Class<?> f206a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Class<?> f207b;
        private String c;

        public a(Class<?> r1, Class<?> r2, String r3) {
            this.f206a = r1;
            this.f207b = r2;
            this.c = r3;
        }

        public Class<?> a() {
            return this.f206a;
        }

        public boolean a(Object r1) {
            return ZeusTransformUtils.instanceOf(r1, a.class);
        }

        public Class<?> b() {
            return this.f207b;
        }

        public String c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (r6.a(this) == true) goto L11;
            return false;
        L11:
            Class<?> r0 = a();
            Class<?> r2 = r6.a();
            if (r0 != null) goto L16;
            if (r2 != null) goto L17;
        L18:
            Class<?> r1 = b();
            Class<?> r3 = r6.b();
            if (r1 != null) goto L23;
            if (r3 != null) goto L24;
        L25:
            String r4 = c();
            String r7 = r6.c();
            if (r4 != null) goto L30;
            if (r7 != null) goto L31;
        L32:
            return true;
        L31:
            return false;
        L30:
            if (r4.equals(r7) == true) goto L32;
        L24:
            return false;
        L23:
            if (r1.equals(r3) == true) goto L25;
        L17:
            return false;
        L16:
            if (r0.equals(r2) == true) goto L18;
            goto L17
        }

        public int hashCode() {
            Class<?> r0 = a();
            int r1 = 43;
            if (r0 != null) goto L5;
            int r2 = 43;
        L6:
            Class<?> r3 = b();
            int r4 = (r2 + 59) * 59;
            if (r3 != null) goto L9;
            int r5 = 43;
        L10:
            String r6 = c();
            int r7 = (r4 + r5) * 59;
            if (r6 == null) goto L15;
            r1 = r6.hashCode();
        L15:
            return r7 + r1;
        L9:
            r5 = r3.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Class<?> f208a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Collection<String> f209b;
        private Collection<Integer> c;
        private Collection<String> d;
        private Collection<Integer> e;

        b(Class<?> r3, com.alibaba.excel.metadata.g r4) {
            com.alibaba.excel.metadata.g r5 = (com.alibaba.excel.metadata.g) ZeusTransformUtils.wrapperContextForParams(r4, com.alibaba.excel.metadata.g.class, "com.obric.memorydata.plugin");
            this.f208a = r3;
            if (ZeusTransformUtils.instanceOf(r5, com.alibaba.excel.j.b.a.b.class) == false) goto L6;
            com.alibaba.excel.j.b.a.b r6 = (com.alibaba.excel.j.b.a.b) ZeusTransformUtils.preCheckCast(r5, com.alibaba.excel.j.b.a.b.class, "com.obric.memorydata.plugin");
            this.f209b = r6.m();
            this.c = r6.l();
            this.d = r6.k();
            this.e = r6.j();
            return;
        }

        public Class<?> a() {
            return this.f208a;
        }

        public boolean a(Object r1) {
            return ZeusTransformUtils.instanceOf(r1, b.class);
        }

        public Collection<String> b() {
            return this.f209b;
        }

        public Collection<Integer> c() {
            return this.c;
        }

        public Collection<String> d() {
            return this.d;
        }

        public Collection<Integer> e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (r6.a(this) == true) goto L11;
            return false;
        L11:
            Class<?> r0 = a();
            Class<?> r2 = r6.a();
            if (r0 != null) goto L16;
            if (r2 != null) goto L17;
        L18:
            Collection<String> r1 = b();
            Collection<String> r3 = r6.b();
            if (r1 != null) goto L23;
            if (r3 != null) goto L24;
        L25:
            Collection<Integer> r4 = c();
            Collection<Integer> r7 = r6.c();
            if (r4 != null) goto L30;
            if (r7 != null) goto L31;
        L32:
            Collection<String> r8 = d();
            Collection<String> r9 = r6.d();
            if (r8 != null) goto L37;
            if (r9 != null) goto L38;
        L39:
            Collection<Integer> r10 = e();
            Collection<Integer> r11 = r6.e();
            if (r10 != null) goto L44;
            if (r11 != null) goto L45;
        L46:
            return true;
        L45:
            return false;
        L44:
            if (r10.equals(r11) == true) goto L46;
        L38:
            return false;
        L37:
            if (r8.equals(r9) == true) goto L39;
        L31:
            return false;
        L30:
            if (r4.equals(r7) == true) goto L32;
        L24:
            return false;
        L23:
            if (r1.equals(r3) == true) goto L25;
        L17:
            return false;
        L16:
            if (r0.equals(r2) == true) goto L18;
            goto L17
        }

        public int hashCode() {
            Class<?> r0 = a();
            int r1 = 43;
            if (r0 != null) goto L5;
            int r2 = 43;
        L6:
            Collection<String> r3 = b();
            int r4 = (r2 + 59) * 59;
            if (r3 != null) goto L9;
            int r5 = 43;
        L10:
            int r6 = r4 + r5;
            Collection<Integer> r7 = c();
            int r8 = r6 * 59;
            if (r7 != null) goto L13;
            int r9 = 43;
        L14:
            int r10 = r8 + r9;
            Collection<String> r11 = d();
            int r12 = r10 * 59;
            if (r11 != null) goto L17;
            int r13 = 43;
        L18:
            Collection<Integer> r14 = e();
            int r15 = (r12 + r13) * 59;
            if (r14 == null) goto L23;
            r1 = r14.hashCode();
        L23:
            return r15 + r1;
        L17:
            r13 = r11.hashCode();
            goto L18
        L13:
            r9 = r7.hashCode();
            goto L14
        L9:
            r5 = r3.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "ClassUtils.FieldCacheKey(clazz=" + a() + ", excludeColumnFieldNames=" + b() + ", excludeColumnIndexes=" + c() + ", includeColumnFieldNames=" + d() + ", includeColumnIndexes=" + e() + ")";
        }
    }

    static {
        f203a = new ConcurrentHashMap();
        d = new ThreadLocal();
        f204b = new ConcurrentHashMap();
        e = new ThreadLocal();
        c = new ConcurrentHashMap();
        f = new ThreadLocal();
    }

    private static a a(Class<?> r1, Class<?> r2, String r3) {
        return new a(r1, r2, r3);
    }

    private static com.alibaba.excel.metadata.a.c a(final Class<?> r4, final Class<?> r5, final String r6, com.alibaba.excel.metadata.g r7) {
        final com.alibaba.excel.metadata.g r8 = (com.alibaba.excel.metadata.g) ZeusTransformUtils.wrapperContextForParams(r7, com.alibaba.excel.metadata.g.class, "com.obric.memorydata.plugin");
        int r0 = AnonymousClass1.f205a[r8.b().e().ordinal()];
        if (r0 != 1) goto L5;
        ThreadLocal<Map<a, com.alibaba.excel.metadata.a.c>> r1 = f;
        Map<a, com.alibaba.excel.metadata.a.c> r2 = (Map) ZeusTransformUtils.preCheckCast(r1.get(), Map.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L18;
        r2 = j.a();
        r1.set(r2);
    L18:
        com.alibaba.excel.metadata.a.c r9 = r2.computeIfAbsent(a(r4, r5, r6), new $$Lambda$c$RWVfORJq5PWoBS8HRbgTIBJJDkU(r4, r5, r6, r8));
    L14:
        return (com.alibaba.excel.metadata.a.c) ZeusTransformUtils.preCheckCast(r9, com.alibaba.excel.metadata.a.c.class, "com.obric.memorydata.plugin");
    L5:
        if (r0 != 2) goto L7;
        r9 = c.computeIfAbsent(a(r4, r5, r6), new $$Lambda$c$94nxmoXow7rlkRevqY89miqufSA(r4, r5, r6, r8));
        goto L14
    L7:
        if (r0 != 3) goto L11;
        return b(r4, r5, r6, r8);
    L11:
        throw new UnsupportedOperationException("unsupported enum");
    }

    private static /* synthetic */ com.alibaba.excel.metadata.a.c a(Class r1, Class r2, String r3, com.alibaba.excel.metadata.g r4, a r5) {
        return b(r1, r2, r3, (com.alibaba.excel.metadata.g) ZeusTransformUtils.wrapperContextForParams(r4, com.alibaba.excel.metadata.g.class, "com.obric.memorydata.plugin"));
    }

    private static /* synthetic */ com.alibaba.excel.metadata.a.c a(String r2, Map r3) {
        return (com.alibaba.excel.metadata.a.c) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin")).get(r2), com.alibaba.excel.metadata.a.c.class, "com.obric.memorydata.plugin");
    }

    public static com.alibaba.excel.metadata.a.c a(Map<?, ?> r2, Class<?> r3, String r4, com.alibaba.excel.metadata.g r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.metadata.g r7 = (com.alibaba.excel.metadata.g) ZeusTransformUtils.wrapperContextForParams(r5, com.alibaba.excel.metadata.g.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, com.alibaba.excel.support.cglib.beans.a.class) == false) goto L7;
        Object r8 = ((com.alibaba.excel.support.cglib.beans.a) ZeusTransformUtils.preCheckCast(r6, com.alibaba.excel.support.cglib.beans.a.class, "com.obric.memorydata.plugin")).a();
        if (r8 == null) goto L7;
        Class<?> r9 = r8.getClass();
    L9:
        return a(r9, r3, r4, r7);
    L7:
        r9 = null;
        goto L9
    }

    public static com.alibaba.excel.metadata.h a(final Class<?> r4, com.alibaba.excel.metadata.g r5) {
        final com.alibaba.excel.metadata.g r6 = (com.alibaba.excel.metadata.g) ZeusTransformUtils.wrapperContextForParams(r5, com.alibaba.excel.metadata.g.class, "com.obric.memorydata.plugin");
        int r0 = AnonymousClass1.f205a[r6.b().e().ordinal()];
        if (r0 != 1) goto L5;
        ThreadLocal<Map<b, com.alibaba.excel.metadata.h>> r1 = d;
        Map<b, com.alibaba.excel.metadata.h> r2 = (Map) ZeusTransformUtils.preCheckCast(r1.get(), Map.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L18;
        r2 = j.a();
        r1.set(r2);
    L18:
        com.alibaba.excel.metadata.h r7 = r2.computeIfAbsent(new b(r4, r6), new $$Lambda$c$IVd2vElhose6845FlUd8zVB_kMc(r4, r6));
    L14:
        return (com.alibaba.excel.metadata.h) ZeusTransformUtils.preCheckCast(r7, com.alibaba.excel.metadata.h.class, "com.obric.memorydata.plugin");
    L5:
        if (r0 != 2) goto L7;
        r7 = f203a.computeIfAbsent(new b(r4, r6), new $$Lambda$c$oGsYQHGw5mzxmPtSE8b0i_WIPRw(r4, r6));
        goto L14
    L7:
        if (r0 != 3) goto L11;
        return c(r4, r6);
    L11:
        throw new UnsupportedOperationException("unsupported enum");
    }

    private static /* synthetic */ com.alibaba.excel.metadata.h a(Class r1, com.alibaba.excel.metadata.g r2, b r3) {
        return c(r1, (com.alibaba.excel.metadata.g) ZeusTransformUtils.wrapperContextForParams(r2, com.alibaba.excel.metadata.g.class, "com.obric.memorydata.plugin"));
    }

    private static /* synthetic */ List a(Integer r0) {
        return i.a();
    }

    private static Map<String, com.alibaba.excel.metadata.a.c> a(Class<?> r9) {
        if (r9 != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        Class<?> r1 = r9;
    L6:
        if (r1 == null) goto L8;
        Collections.addAll(r0, r1.getDeclaredFields());
        r1 = r1.getSuperclass();
        goto L6
    L8:
        com.alibaba.excel.b.b.a.b r2 = (com.alibaba.excel.b.b.a.b) ZeusTransformUtils.preCheckCast(r9.getAnnotation(com.alibaba.excel.b.b.a.b.class), com.alibaba.excel.b.b.a.b.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.b.b.a.a r10 = (com.alibaba.excel.b.b.a.a) ZeusTransformUtils.preCheckCast(r9.getAnnotation(com.alibaba.excel.b.b.a.a.class), com.alibaba.excel.b.b.a.a.class, "com.obric.memorydata.plugin");
        HashMap r3 = j.a(r0.size());
        Iterator r4 = r0.iterator();
    L10:
        if (r4.hasNext() == false) goto L27;
        Field r5 = (Field) ZeusTransformUtils.preCheckCast(r4.next(), Field.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.metadata.a.c r6 = new com.alibaba.excel.metadata.a.c();
        r6.a(r5);
        com.alibaba.excel.b.c r7 = (com.alibaba.excel.b.c) ZeusTransformUtils.preCheckCast(r5.getAnnotation(com.alibaba.excel.b.c.class), com.alibaba.excel.b.c.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L20;
        Class<? extends com.alibaba.excel.f.b<?>> r8 = r7.d();
        if (r8 == com.alibaba.excel.f.a.class) goto L20;
        r6.a((com.alibaba.excel.f.b) ZeusTransformUtils.preCheckCast(r8.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), com.alibaba.excel.f.b.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L18
    L19:
        throw new ExcelCommonException("Can not instance custom converter:" + r8.getName());
    L20:
        com.alibaba.excel.b.b.a.b r11 = (com.alibaba.excel.b.b.a.b) ZeusTransformUtils.preCheckCast(r5.getAnnotation(com.alibaba.excel.b.b.a.b.class), com.alibaba.excel.b.b.a.b.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L23;
        r11 = r2;
    L23:
        r6.a(com.alibaba.excel.metadata.a.j.a(r11));
        com.alibaba.excel.b.b.a.a r12 = (com.alibaba.excel.b.b.a.a) ZeusTransformUtils.preCheckCast(r5.getAnnotation(com.alibaba.excel.b.b.a.a.class), com.alibaba.excel.b.b.a.a.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L26;
        r12 = r10;
    L26:
        r6.a(com.alibaba.excel.metadata.a.e.a(r12));
        r6.a(com.alibaba.excel.metadata.a.b.a((com.alibaba.excel.b.a.a) ZeusTransformUtils.preCheckCast(r5.getAnnotation(com.alibaba.excel.b.a.a.class), com.alibaba.excel.b.a.a.class, "com.obric.memorydata.plugin")));
        r6.a(com.alibaba.excel.metadata.a.g.a((com.alibaba.excel.b.a.b) ZeusTransformUtils.preCheckCast(r5.getAnnotation(com.alibaba.excel.b.a.b.class), com.alibaba.excel.b.a.b.class, "com.obric.memorydata.plugin")));
        r3.put(r5.getName(), r6);
        goto L10
    L27:
        return r3;
    }

    private static /* synthetic */ Map a(Class r0, Class r1) {
        return a(r0);
    }

    private static Map<Integer, com.alibaba.excel.metadata.i> a(Map<Integer, List<com.alibaba.excel.metadata.i>> r7, Map<Integer, com.alibaba.excel.metadata.i> r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        HashMap r0 = new HashMap((((r9.size() + r10.size()) * 4) / 3) + 1);
        HashMap r2 = new HashMap(r10);
        Iterator r11 = r9.values().iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L13;
        Iterator r3 = ((List) ZeusTransformUtils.preCheckCast(r11.next(), List.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r3.hasNext() == false) goto L4;
        com.alibaba.excel.metadata.i r4 = (com.alibaba.excel.metadata.i) ZeusTransformUtils.preCheckCast(r3.next(), com.alibaba.excel.metadata.i.class, "com.obric.memorydata.plugin");
    L10:
        if (r2.containsKey(Integer.valueOf(r12)) == false) goto L12;
        r0.put(Integer.valueOf(r12), r2.get(Integer.valueOf(r12)));
        r2.remove(Integer.valueOf(r12));
        r12 = r12 + 1;
        goto L10
    L12:
        r0.put(Integer.valueOf(r12), r4);
        r12 = r12 + 1;
        goto L7
    L13:
        r0.putAll(r2);
        return r0;
    }

    public static void a() {
        d.remove();
        e.remove();
        f.remove();
    }

    private static void a(com.alibaba.excel.j.b.a.b r6, com.alibaba.excel.metadata.h r7) {
        com.alibaba.excel.j.b.a.b r8 = (com.alibaba.excel.j.b.a.b) ZeusTransformUtils.wrapperContextForParams(r6, com.alibaba.excel.j.b.a.b.class, "com.obric.memorydata.plugin");
        if (r8.i() == true) goto L5;
        return;
    L5:
        final Map<Integer, com.alibaba.excel.metadata.i> r0 = r7.b();
        Collection<String> r2 = r8.k();
        int r4 = 0;
        if (CollectionUtils.isEmpty(r2) == true) goto L13;
        final HashMap r9 = j.a();
        Iterator<String> r3 = r2.iterator();
    L9:
        if (r3.hasNext() == false) goto L11;
        int r5 = r4 + 1;
        r9.put((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin"), Integer.valueOf(r4));
        r4 = r5;
        goto L9
    L11:
        final HashMap r1 = j.a();
        r7.a().forEach(new $$Lambda$c$nhjqAb33UPo4JVlsd4RBKSZLjQ(r9, r1, r0));
        r7.a(r1);
        return;
    L13:
        Collection<Integer> r10 = r8.j();
        if (CollectionUtils.isEmpty(r10) == true) goto L23;
        final HashMap r11 = j.a();
        Iterator<Integer> r12 = r10.iterator();
    L17:
        if (r12.hasNext() == false) goto L19;
        int r13 = r4 + 1;
        r11.put((Integer) ZeusTransformUtils.preCheckCast(r12.next(), Integer.class, "com.obric.memorydata.plugin"), Integer.valueOf(r4));
        r4 = r13;
        goto L17
    L19:
        final HashMap r14 = j.a();
        r7.a().forEach(new $$Lambda$c$cRTY1a900LkMTWgPgewwQj85PjE(r11, r14));
        r7.a(r14);
        return;
    }

    public static void a(com.alibaba.excel.metadata.a.c r1, com.alibaba.excel.metadata.a.c r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.a() == null) goto L8;
        r1.a(r2.a());
    L8:
        if (r2.b() == null) goto L11;
        r1.a(r2.b());
    L11:
        if (r2.c() == null) goto L14;
        r1.a(r2.c());
    L14:
        if (r2.d() == null) goto L17;
        r1.a(r2.d());
    L17:
        if (r2.e() == null) goto L20;
        r1.a(r2.e());
    L20:
        if (r2.f() == null) goto L23;
        r1.a(r2.f());
        return;
    }

    private static void a(Field r6, Map<Integer, List<com.alibaba.excel.metadata.i>> r7, Map<Integer, com.alibaba.excel.metadata.i> r8, Set<String> r9, com.alibaba.excel.b.b r10) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        Set r13 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.b.b r14 = (com.alibaba.excel.b.b) ZeusTransformUtils.wrapperContextForParams(r10, com.alibaba.excel.b.b.class, "com.obric.memorydata.plugin");
        String r0 = f.a(r6);
        com.alibaba.excel.metadata.i r2 = new com.alibaba.excel.metadata.i();
        r2.a(r6);
        r2.a(r0);
        if (((com.alibaba.excel.b.a) ZeusTransformUtils.preCheckCast(r6.getAnnotation(com.alibaba.excel.b.a.class), com.alibaba.excel.b.a.class, "com.obric.memorydata.plugin")) == null) goto L6;
        r13.add(r0);
        return;
    L6:
        com.alibaba.excel.b.c r3 = (com.alibaba.excel.b.c) ZeusTransformUtils.preCheckCast(r6.getAnnotation(com.alibaba.excel.b.c.class), com.alibaba.excel.b.c.class, "com.obric.memorydata.plugin");
        boolean r4 = true;
        if (r3 != null) goto L10;
        if (r14 == null) goto L10;
        boolean r15 = true;
    L11:
        if (r15 == false) goto L15;
        r13.add(r0);
        return;
    L15:
        if (Modifier.isStatic(r6.getModifiers()) == false) goto L19;
        if (Modifier.isFinal(r6.getModifiers()) == false) goto L19;
    L22:
        if (r3 != null) goto L26;
        if (r4 == false) goto L26;
        r13.add(r0);
        return;
    L26:
        if (r3 == null) goto L28;
        r2.a(r3.a());
    L28:
        if (r3 != null) goto L30;
    L37:
        int r16 = Integer.MAX_VALUE;
        if (r3 == null) goto L40;
        r16 = r3.c();
    L40:
        ((List) ZeusTransformUtils.preCheckCast(r11.computeIfAbsent(Integer.valueOf(r16), $$Lambda$c$6VBRp986SE_0ftxWgjS3jLFzipo.INSTANCE), List.class, "com.obric.memorydata.plugin")).add(r2);
        return;
    L30:
        if (r3.b() < 0) goto L37;
        if (r12.containsKey(Integer.valueOf(r3.b())) == true) goto L36;
        r12.put(Integer.valueOf(r3.b()), r2);
        return;
    L36:
        throw new ExcelCommonException("The index of '" + ((com.alibaba.excel.metadata.i) ZeusTransformUtils.preCheckCast(r12.get(Integer.valueOf(r3.b())), com.alibaba.excel.metadata.i.class, "com.obric.memorydata.plugin")).b() + "' and '" + r6.getName() + "' must be inconsistent");
    L19:
        if (Modifier.isTransient(r6.getModifiers()) == true) goto L22;
        r4 = false;
    L10:
        r15 = false;
        goto L11
    }

    private static /* synthetic */ void a(Map r2, Map r3, Integer r4, com.alibaba.excel.metadata.i r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(r6.get(r4), Integer.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L6;
        r7.put(r8, r5);
        return;
    }

    private static /* synthetic */ void a(Map r2, Map r3, Map r4, Integer r5, com.alibaba.excel.metadata.i r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Integer r10 = (Integer) ZeusTransformUtils.preCheckCast(r7.get(r6.b()), Integer.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L8;
        r8.put(r10, r6);
        if (r10.equals(r5) == true) goto L9;
        r9.remove(r5);
        return;
    L9:
        return;
    }

    private static com.alibaba.excel.metadata.a.c b(Class<?> r4, Class<?> r5, final String r6, com.alibaba.excel.metadata.g r7) {
        com.alibaba.excel.metadata.g r8 = (com.alibaba.excel.metadata.g) ZeusTransformUtils.wrapperContextForParams(r7, com.alibaba.excel.metadata.g.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.metadata.a.c r0 = (com.alibaba.excel.metadata.a.c) ZeusTransformUtils.preCheckCast(Optional.ofNullable(b(r4, r8)).map(new $$Lambda$c$nQpUjiPFpzha5_nVQafsgWV2mbU(r6)).orElse(null), com.alibaba.excel.metadata.a.c.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.metadata.a.c r9 = (com.alibaba.excel.metadata.a.c) ZeusTransformUtils.preCheckCast(Optional.ofNullable(b(r5, r8)).map(new $$Lambda$c$rghkHun08u_ILzicucxGUQKFOk(r6)).orElse(null), com.alibaba.excel.metadata.a.c.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.metadata.a.c r10 = new com.alibaba.excel.metadata.a.c();
        a(r10, r9);
        if (r4 == r5) goto L5;
        a(r10, r0);
    L5:
        return r10;
    }

    private static /* synthetic */ com.alibaba.excel.metadata.a.c b(Class r1, Class r2, String r3, com.alibaba.excel.metadata.g r4, a r5) {
        return b(r1, r2, r3, (com.alibaba.excel.metadata.g) ZeusTransformUtils.wrapperContextForParams(r4, com.alibaba.excel.metadata.g.class, "com.obric.memorydata.plugin"));
    }

    private static /* synthetic */ com.alibaba.excel.metadata.a.c b(String r2, Map r3) {
        return (com.alibaba.excel.metadata.a.c) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin")).get(r2), com.alibaba.excel.metadata.a.c.class, "com.obric.memorydata.plugin");
    }

    private static /* synthetic */ com.alibaba.excel.metadata.h b(Class r1, com.alibaba.excel.metadata.g r2, b r3) {
        return c(r1, (com.alibaba.excel.metadata.g) ZeusTransformUtils.wrapperContextForParams(r2, com.alibaba.excel.metadata.g.class, "com.obric.memorydata.plugin"));
    }

    private static Map<String, com.alibaba.excel.metadata.a.c> b(final Class<?> r3, com.alibaba.excel.metadata.g r4) {
        com.alibaba.excel.metadata.g r5 = (com.alibaba.excel.metadata.g) ZeusTransformUtils.wrapperContextForParams(r4, com.alibaba.excel.metadata.g.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        return null;
    L6:
        int r6 = AnonymousClass1.f205a[r5.b().e().ordinal()];
        if (r6 != 1) goto L9;
        ThreadLocal<Map<Class<?>, Map<String, com.alibaba.excel.metadata.a.c>>> r7 = e;
        Map<Class<?>, Map<String, com.alibaba.excel.metadata.a.c>> r0 = (Map) ZeusTransformUtils.preCheckCast(r7.get(), Map.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L22;
        r0 = j.a();
        r7.set(r0);
    L22:
        Map<String, com.alibaba.excel.metadata.a.c> r8 = r0.computeIfAbsent(r3, new $$Lambda$c$9No6gR29JNLAnHtsPMKa6pxD5YA(r3));
    L18:
        return (Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.memorydata.plugin");
    L9:
        if (r6 != 2) goto L11;
        r8 = f204b.computeIfAbsent(r3, new $$Lambda$c$R0gBz4XBjeDewUYJhG1RYFwtkhA(r3));
        goto L18
    L11:
        if (r6 != 3) goto L15;
        return a(r3);
    L15:
        throw new UnsupportedOperationException("unsupported enum");
    }

    private static /* synthetic */ Map b(Class r0, Class r1) {
        return a(r0);
    }

    private static com.alibaba.excel.metadata.h c(Class<?> r11, com.alibaba.excel.metadata.g r12) {
        com.alibaba.excel.metadata.g r13 = (com.alibaba.excel.metadata.g) ZeusTransformUtils.wrapperContextForParams(r12, com.alibaba.excel.metadata.g.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        Class<?> r2 = r11;
    L3:
        if (r2 == null) goto L5;
        Collections.addAll(r0, r2.getDeclaredFields());
        r2 = r2.getSuperclass();
        goto L3
    L5:
        TreeMap r3 = new TreeMap();
        TreeMap r4 = new TreeMap();
        HashSet r5 = new HashSet();
        com.alibaba.excel.b.b r14 = (com.alibaba.excel.b.b) ZeusTransformUtils.preCheckCast(r11.getAnnotation(com.alibaba.excel.b.b.class), com.alibaba.excel.b.b.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        a((Field) ZeusTransformUtils.preCheckCast(r1.next(), Field.class, "com.obric.memorydata.plugin"), r3, r4, r5, r14);
        goto L7
    L9:
        Map<Integer, com.alibaba.excel.metadata.i> r15 = a(r3, r4);
        com.alibaba.excel.metadata.h r6 = new com.alibaba.excel.metadata.h(r15, r4);
        if (ZeusTransformUtils.instanceOf(r13, com.alibaba.excel.j.b.a.b.class) == true) goto L12;
        return r6;
    L12:
        com.alibaba.excel.j.b.a.b r16 = (com.alibaba.excel.j.b.a.b) ZeusTransformUtils.preCheckCast(r13, com.alibaba.excel.j.b.a.b.class, "com.obric.memorydata.plugin");
        int r7 = 0;
        if (CollectionUtils.isEmpty(r16.m()) == true) goto L15;
    L22:
        boolean r8 = true;
    L23:
        if (r8 == true) goto L25;
        return r6;
    L25:
        HashMap r9 = j.a();
        Iterator<Map.Entry<Integer, com.alibaba.excel.metadata.i>> r17 = r15.entrySet().iterator();
    L27:
        if (r17.hasNext() == false) goto L38;
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r17.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Integer r18 = (Integer) ZeusTransformUtils.preCheckCast(r10.getKey(), Integer.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.metadata.i r19 = (com.alibaba.excel.metadata.i) ZeusTransformUtils.preCheckCast(r10.getValue(), com.alibaba.excel.metadata.i.class, "com.obric.memorydata.plugin");
        if (r16.a(r19.b(), (Integer) ZeusTransformUtils.preCheckCast(r10.getKey(), Integer.class, "com.obric.memorydata.plugin")) == true) goto L30;
        if (r4.containsKey(r18) == true) goto L33;
    L35:
        if (r9.containsKey(Integer.valueOf(r7)) == false) goto L37;
        r7 = r7 + 1;
        goto L35
    L37:
        r9.put(Integer.valueOf(r7), r19);
        r7 = r7 + 1;
        goto L27
    L33:
        r9.put(r18, r19);
        goto L27
    L30:
        r5.add(r19.b());
        r4.remove(Integer.valueOf(r7));
        goto L27
    L38:
        r6.a(r9);
        a(r16, r6);
        return r6;
    L15:
        if (CollectionUtils.isEmpty(r16.l()) == false) goto L22;
        if (CollectionUtils.isEmpty(r16.k()) == false) goto L22;
        if (CollectionUtils.isEmpty(r16.j()) == false) goto L22;
        r8 = false;
        goto L23
    }

    public static /* synthetic */ List lambda$6VBRp986SE_0ftxWgjS3jLFzipo(Integer r0) {
        return a(r0);
    }

    public static /* synthetic */ com.alibaba.excel.metadata.a.c lambda$94nxmoXow7rlkRevqY89miqufSA(Class r0, Class r1, String r2, com.alibaba.excel.metadata.g r3, a r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Map lambda$9No6gR29JNLAnHtsPMKa6pxD5YA(Class r0, Class r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ com.alibaba.excel.metadata.h lambda$IVd2vElhose6845FlUd8zVB_kMc(Class r0, com.alibaba.excel.metadata.g r1, b r2) {
        return b(r0, r1, r2);
    }

    public static /* synthetic */ Map lambda$R0gBz4XBjeDewUYJhG1RYFwtkhA(Class r0, Class r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ com.alibaba.excel.metadata.a.c lambda$RWVfORJq5PWoBS8HRbgTIBJJDkU(Class r0, Class r1, String r2, com.alibaba.excel.metadata.g r3, a r4) {
        return b(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void lambda$cRTY1a900LkMTWgPgewwQj85PjE(Map r0, Map r1, Integer r2, com.alibaba.excel.metadata.i r3) {
        a(r0, r1, r2, r3);
    }

    public static /* synthetic */ com.alibaba.excel.metadata.a.c lambda$nQpUjiPFpzha5_nVQafsgWV2mbU(String r0, Map r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$nhjqAb33UPo4JVlsd4RB-KSZLjQ, reason: not valid java name */
    public static /* synthetic */ void m69lambda$nhjqAb33UPo4JVlsd4RBKSZLjQ(Map r0, Map r1, Map r2, Integer r3, com.alibaba.excel.metadata.i r4) {
        a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ com.alibaba.excel.metadata.h lambda$oGsYQHGw5mzxmPtSE8b0i_WIPRw(Class r0, com.alibaba.excel.metadata.g r1, b r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$rgh-kHun08u_ILzicucxGUQKFOk, reason: not valid java name */
    public static /* synthetic */ com.alibaba.excel.metadata.a.c m70lambda$rghkHun08u_ILzicucxGUQKFOk(String r0, Map r1) {
        return a(r0, r1);
    }
}
