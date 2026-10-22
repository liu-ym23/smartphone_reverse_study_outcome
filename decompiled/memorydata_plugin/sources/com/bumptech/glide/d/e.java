package com.bumptech.glide.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<String> f540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, List<a<?, ?>>> f541b;

    private static class a<T, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Class<R> f542a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final com.bumptech.glide.load.f<T, R> f543b;
        private final Class<T> c;

        public a(Class<T> r3, Class<R> r4, com.bumptech.glide.load.f<T, R> r5) {
            com.bumptech.glide.load.f<T, R> r6 = (com.bumptech.glide.load.f) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.f.class, "com.obric.memorydata.plugin");
            this.c = r3;
            this.f542a = r4;
            this.f543b = r6;
        }

        public boolean a(Class<?> r2, Class<?> r3) {
            if (this.c.isAssignableFrom(r2) == true) goto L5;
        L7:
            return false;
        L5:
            if (r3.isAssignableFrom(this.f542a) == false) goto L7;
            return true;
        }
    }

    public e() {
        this.f540a = new ArrayList();
        this.f541b = new HashMap();
    }

    private synchronized List<a<?, ?>> a(String r4) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f540a.contains(r4) == true) goto L6;
        this.f540a.add(r4);     // Catch: Throwable -> L11
    L6:
        List<a<?, ?>> r0 = (List) ZeusTransformUtils.preCheckCast(this.f541b.get(r4), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        r0 = new ArrayList();     // Catch: Throwable -> L11
        this.f541b.put(r4, r0);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return r0;
    }

    public synchronized <T, R> List<com.bumptech.glide.load.f<T, R>> a(Class<T> r7, Class<R> r8) {
        monitor-enter(this);
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L18
        Iterator<String> r1 = this.f540a.iterator();     // Catch: Throwable -> L18
    L5:
        if (r1.hasNext() == false) goto L16;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        List r3 = (List) ZeusTransformUtils.preCheckCast(this.f541b.get(r2), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r3 == null) goto L5;
        Iterator r4 = r3.iterator();     // Catch: Throwable -> L18
    L11:
        if (r4.hasNext() == false) goto L5;
        a r5 = (a) ZeusTransformUtils.preCheckCast(r4.next(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r5.a(r7, r8) == false) goto L11;
        r0.add(r5.f543b);     // Catch: Throwable -> L18
        goto L11
    L16:
        monitor-exit(this);
        return r0;
    L18:
        th = move-exception;
        throw th;
    }

    public synchronized <T, R> void a(String r3, com.bumptech.glide.load.f<T, R> r4, Class<T> r5, Class<R> r6) {
        monitor-enter(this);
        com.bumptech.glide.load.f r7 = (com.bumptech.glide.load.f) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        a(r3).add(new a(r5, r6, r7));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void a(List<String> r6) {
        monitor-enter(this);
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        ArrayList r0 = new ArrayList(this.f540a);     // Catch: Throwable -> L16
        this.f540a.clear();     // Catch: Throwable -> L16
        Iterator r1 = r7.iterator();     // Catch: Throwable -> L16
    L5:
        if (r1.hasNext() == false) goto L7;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        this.f540a.add(r2);     // Catch: Throwable -> L16
        goto L5
    L7:
        Iterator r3 = r0.iterator();     // Catch: Throwable -> L16
    L8:
        if (r3.hasNext() == false) goto L14;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        if (r7.contains(r4) == true) goto L8;
        this.f540a.add(r4);     // Catch: Throwable -> L16
        goto L8
    L14:
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public synchronized <T, R> List<Class<R>> b(Class<T> r7, Class<R> r8) {
        monitor-enter(this);
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L20
        Iterator<String> r1 = this.f540a.iterator();     // Catch: Throwable -> L20
    L5:
        if (r1.hasNext() == false) goto L18;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        List r3 = (List) ZeusTransformUtils.preCheckCast(this.f541b.get(r2), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (r3 == null) goto L5;
        Iterator r4 = r3.iterator();     // Catch: Throwable -> L20
    L11:
        if (r4.hasNext() == false) goto L5;
        a r5 = (a) ZeusTransformUtils.preCheckCast(r4.next(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (r5.a(r7, r8) == false) goto L11;
        if (r0.contains(r5.f542a) == true) goto L11;
        r0.add(r5.f542a);     // Catch: Throwable -> L20
        goto L11
    L18:
        monitor-exit(this);
        return r0;
    L20:
        th = move-exception;
        throw th;
    }
}
