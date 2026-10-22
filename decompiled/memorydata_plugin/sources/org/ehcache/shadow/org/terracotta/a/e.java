package org.ehcache.shadow.org.terracotta.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes7.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final org.slf4j.c f18112a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final i<Object, f> f18113b = null;
    private static final Collection<b> c = null;
    private final g d;

    public interface a {
        a a(Object r1);

        a b(Object r1);
    }

    static {
        f18112a = org.slf4j.d.a(e.class);
        f18113b = new i();
        c = new CopyOnWriteArrayList();
    }

    public e() {
        this.d = new g();
    }

    public static a a(final Object r1) {
        return new AnonymousClass1(r1);
    }

    static /* synthetic */ void a(Object r0, Object r1) {
        b(r0, r1);
    }

    public static void a(b r2) {
        b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
        c.add(r3);
    }

    private static f b(Object r4) {
        i<Object, f> r0 = f18113b;
        f r1 = (f) ZeusTransformUtils.preCheckCast(r0.a(r4), f.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L9;
        f r2 = new f(org.ehcache.shadow.org.terracotta.a.b.f.a(r4));
        f r3 = (f) ZeusTransformUtils.preCheckCast(r0.a(r4, r2), f.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L7;
        return r3;
    L7:
        c(r4);
        d(r4);
        return r2;
    L9:
        return r1;
    }

    private static void b(Object r0, Object r1) {
        b(r1).a(b(r0));
    }

    private static void c(Object r8) {
        Class<?> r0 = r8.getClass();
    L3:
        if (r0 == null) goto L28;
        Field[] r1 = r0.getDeclaredFields();
        int r2 = r1.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L27;
        Field r4 = r1[r3];
        if (r4.isAnnotationPresent(org.ehcache.shadow.org.terracotta.a.a.b.class) == false) goto L18;
        r4.setAccessible(true);
        Object r5 = r4.get(r8);     // Catch: IllegalAccessException -> L12 IllegalArgumentException -> L14
        if (r5 == null) goto L18;
        b(r5, r8);
        goto L18
    L14:
        e = move-exception;
        throw new AssertionError(e);
    L12:
        e = move-exception;
        f18112a.warn("Failed to traverse {} due to: {}", r4, e);
    L26:
        r3 = r3 + 1;
    L18:
        if (r4.isAnnotationPresent(org.ehcache.shadow.org.terracotta.a.a.c.class) == false) goto L26;
        r4.setAccessible(true);
        Object r6 = r4.get(r8);     // Catch: IllegalAccessException -> L12 IllegalArgumentException -> L23
        if (r6 == null) goto L26;
        b(r8, r6);
    L23:
        e = move-exception;
        throw new AssertionError(e);
    L27:
        r0 = r0.getSuperclass();
        goto L3
    }

    private static void d(Object r4) {
        Iterator<b> r0 = c.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) ZeusTransformUtils.preCheckCast(r0.next(), b.class, "com.obric.memorydata.plugin")).contextCreated(r4);
        goto L4
    }

    public Set<h> query(org.ehcache.shadow.org.terracotta.a.c.a r3) {
        return ((org.ehcache.shadow.org.terracotta.a.c.a) ZeusTransformUtils.wrapperContextForParams(r3, org.ehcache.shadow.org.terracotta.a.c.a.class, "com.obric.memorydata.plugin")).a(Collections.singleton(this.d));
    }
}
