package com.ss.android.ugc.aweme.framework.services;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ConcurrentHashMap<Class<?>, Set<g<?>>> f15748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Map<Class<?>, Map<String, g<?>>> f15749b;
    final Set<String> c;
    public volatile boolean d;
    final Set<Class<?>> e;

    /* JADX INFO: renamed from: com.ss.android.ugc.aweme.framework.services.f$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final f f15750a = null;

        static {
            f15750a = new f(null);
        }

        static /* synthetic */ f a() {
            return f15750a;
        }
    }

    private f() {
        this.f15748a = new ConcurrentHashMap();
        this.f15749b = Collections.synchronizedMap(new HashMap());
        this.c = Collections.synchronizedSet(new HashSet());
        this.d = true;
        this.e = Collections.synchronizedSet(new HashSet());
    }

    /* synthetic */ f(AnonymousClass1 r1) {
        this();
    }

    public static f a() {
        return a.a();
    }

    private void b(Class r1) {
        this.e.add(r1);
    }

    private <T> T c(Class<T> r2) {
        if (this.c.contains(r2.getName()) == true) goto L5;
        return null;
    L5:
        Iterator r1 = b.a(r2);
        if (r1.hasNext() == true) goto L8;
        return null;
    L8:
        return (T) r1.next();
    }

    public <T> com.ss.android.ugc.aweme.framework.services.a a(Class<T> r3, g<T> r4) {
        return new com.ss.android.ugc.aweme.framework.services.a(this, r3, (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin"));
    }

    public <T> T a(Class<T> r2) {
        return (T) a(r2, false);
    }

    public <T> T a(Class<T> r2, boolean r3) {
        return (T) a(r2, r3, this.d);
    }

    public <T> T a(Class<T> r2, boolean r3, boolean r4) {
        return (T) a(r2, r3, r4, false);
    }

    public <T> T a(Class<T> r8, boolean r9, boolean r10, boolean r11) {
        if (r11 == false) goto L5;
    L10:
        boolean r3 = false;
        T r2 = null;
    L11:
        Set r4 = (Set) ZeusTransformUtils.preCheckCast(this.f15748a.get(r8), Set.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L14;
    L19:
        if (r2 == null) goto L22;
        b(r8);
        return r2;
    L22:
        T r12 = (T) i.a().a(r8);
        if (r12 == null) goto L26;
        b(r8);
        return r12;
    L26:
        if (r11 == false) goto L28;
        return null;
    L28:
        T r13 = (T) c(r8);
        if (r13 == null) goto L32;
        b(r8);
        return r13;
    L32:
        if (r3 == true) goto L34;
        r13 = (T) d.a().a(r8);
    L34:
        if (r13 != null) goto L38;
        if (r10 == false) goto L39;
        new e();
        return (T) e.a(r8);
    L39:
        return r13;
    L38:
        return r13;
    L14:
        if (r4.isEmpty() == true) goto L19;
        if (r9 == true) goto L19;
        Object[] r14 = r4.toArray();
        if (r14.length <= 0) goto L19;
        r2 = (T) ((g) ZeusTransformUtils.preCheckCast(r14[0], g.class, "com.obric.memorydata.plugin")).get();
        goto L19
    L5:
        if (d.a().b(r8) == false) goto L10;
        r2 = (T) d.a().a(r8);
        if (r2 == null) goto L9;
        return r2;
    L9:
        r3 = true;
        goto L11
    }
}
