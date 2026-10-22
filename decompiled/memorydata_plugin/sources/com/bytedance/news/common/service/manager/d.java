package com.bytedance.news.common.service.manager;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f2906a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f2907b;
    private static final ConcurrentHashMap<Class, Object> c = null;
    private static final ConcurrentHashMap<Class, a<?>> d = null;
    private static final ConcurrentHashMap<Class, c> e = null;

    static {
        c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
        e = new ConcurrentHashMap();
        f2907b = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [T] */
    public static <T> T a(Class<T> r6) {
        ConcurrentHashMap<Class, Object> r0 = c;
        Object r1 = r0.get(r6);
        boolean r2 = true;
        if (r1 != null) goto L5;
    L10:
        boolean r4 = false;
        T r3 = r1;
    L11:
        if (r3 != 0) goto L57;
        monitor-enter(r6);
        T r5 = (T) r0.get(r6);
        if (r5 != null) goto L16;
        r2 = r4;
    L24:
        ConcurrentHashMap<Class, a<?>> r7 = d;     // Catch: Throwable -> L54
        a r8 = (a) ZeusTransformUtils.preCheckCast(r7.get(r6), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        if (r8 == null) goto L59;
        T r9 = (T) r8.create();
        r7.remove(r6);     // Catch: Throwable -> L54
        if (r9 == null) goto L59;
        if (r2 == false) goto L30;
        c(r6);     // Catch: Throwable -> L54
    L30:
        b(r6, r9);     // Catch: Throwable -> L54
        monitor-exit(r6);     // Catch: Throwable -> L54
        return r9;
    L59:
    L43:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L54
    L45:
        r3 = (T) b(r6);
        if (r3 == 0) goto L52;
        if (r2 == false) goto L49;
        c(r6);     // Catch: Throwable -> L54
    L49:
        b(r6, r3);     // Catch: Throwable -> L54
        monitor-exit(r6);     // Catch: Throwable -> L54
        return r3;
    L52:
        monitor-exit(r6);     // Catch: Throwable -> L54
        goto L57
    L34:
        if (f2906a == false) goto L36;
        T r10 = (T) b.b(r6);
    L37:
        if (r10 == null) goto L45;
        if (r2 == false) goto L40;
        c(r6);     // Catch: Exception -> L43 Throwable -> L54
    L40:
        b(r6, r10);     // Catch: Exception -> L43 Throwable -> L54
        monitor-exit(r6);     // Catch: Throwable -> L54
        return r10;
    L36:
        r10 = (T) b.a(r6);
        goto L37
    L16:
        if (r5.getClass() == Object.class) goto L18;
        monitor-exit(r6);     // Catch: Throwable -> L54
        return r5;
    L18:
        if (f2907b == true) goto L24;
        monitor-exit(r6);     // Catch: Throwable -> L54
        return null;
    L54:
        th = move-exception;
        throw th;
    L57:
        return (T) r3;
    L5:
        if (r1.getClass() != Object.class) goto L10;
        if (f2907b == true) goto L9;
        return null;
    L9:
        r4 = true;
        r3 = (T) null;
        goto L11
    }

    public static <T> void a(Class<T> r2, a<T> r3) {
        a<?> r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        d.put(r2, r4);
        ConcurrentHashMap<Class, Object> r5 = c;
        Object r0 = r5.get(r2);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getClass() != Object.class) goto L9;
        r5.remove(r2);
        return;
    }

    public static <T> void a(Class<T> r1, T r2) {
        c.put(r1, r2);
    }

    private static <T> T b(Class<T> r3) {
        Object r4 = ZeusTransformUtils.forName(String.format("%s__ServiceProxy", new Object[]{r3.getName()}), "com.obric.memorydata.plugin").newInstance();     // Catch: Throwable -> L7
        if (ZeusTransformUtils.instanceOf(r4, IServiceProxy.class) == false) goto L13;
        return (T) ((IServiceProxy) ZeusTransformUtils.preCheckCast(r4, IServiceProxy.class, "com.obric.memorydata.plugin")).newInstance();
    L13:
        return null;
    L7:
        th = move-exception;
        Log.e("ServiceManagerError", "tryGetByReflect failed: " + Log.getStackTraceString(th));
        return null;
    }

    private static <T> void b(Class<T> r4, T r5) {
        c.put(r4, r5);
        ConcurrentHashMap<Class, c> r0 = e;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r0.get(r4), c.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        r1.a(r5);
        r0.remove(r4);
        return;
    }

    private static void c(Class<?> r2) {
        final RuntimeException r0 = new RuntimeException(r2.getName() + "已被提前注入空实现，请在ArticleApplication.registerReturnNullService()方法中将提前注入空实现的代码删除，有疑问联系 @zenghongjian.zhj");
        new Thread(new AnonymousClass1(r0)).start();
    }
}
