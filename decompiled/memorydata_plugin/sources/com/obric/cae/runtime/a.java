package com.obric.cae.runtime;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Class<?>, Object> f7319a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Class<?>, CopyOnWriteArrayList<b<?>>> f7320b = null;

    static {
        f7319a = new ConcurrentHashMap();
        f7320b = new ConcurrentHashMap();
    }

    public static <T> T a(Class<T> r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Object r1 = f7319a.get(r3);
        if (r1 != null) goto L8;
    L12:
        return null;
    L8:
        if (ZeusTransformUtils.instanceOf(r3, r1) == false) goto L12;
        return r3.cast(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(Context r4, Class<T> r5, b<? super T> r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r6, b.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L14;
        if (r5 == null) goto L14;
        if (r8 == 0) goto L14;
        ((CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(f7320b.computeIfAbsent(r5, $$Lambda$CYlrW6fnV7JCPQycLW29X_YDjWY.INSTANCE), CopyOnWriteArrayList.class, "com.obric.memorydata.plugin")).add(r8);
        Object r2 = a(r5);
        if (r2 == null) goto L18;
        r8.onServiceReady((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r2);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        com.obric.cae.log.a.a("CaeRuntime", "listener onServiceReady failed: " + r5, th);
        return;
    L18:
        return;
    L14:
        com.obric.cae.log.a.g("CaeRuntime", "registerServiceReadyListener: invalid args");
    }

    public static <T> void a(Context r6, Class<T> r7, T r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L21;
        if (r7 == null) goto L21;
        if (r8 == null) goto L21;
        f7319a.put(r7, r8);
        CopyOnWriteArrayList r2 = (CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(f7320b.get(r7), CopyOnWriteArrayList.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L10;
        return;
    L10:
        if (r2.isEmpty() == true) goto L29;
        Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Iterator r3 = r2.iterator();
    L14:
        if (r3.hasNext() == false) goto L30;
        ((b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.memorydata.plugin")).onServiceReady(r10, r8);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        com.obric.cae.log.a.a("CaeRuntime", "dispatch onServiceReady failed: " + r7, th);
        goto L14
    L30:
        return;
    L29:
        return;
    L21:
        com.obric.cae.log.a.g("CaeRuntime", "notifyServiceReady: invalid args");
    }

    public static <T> void a(Class<T> r1, T r2) {
        if (r1 == null) goto L7;
        if (r2 == null) goto L8;
        f7319a.remove(r1, r2);
        return;
    L8:
        return;
    }

    public static /* synthetic */ CopyOnWriteArrayList b(Class r0) {
        return new CopyOnWriteArrayList();
    }
}
