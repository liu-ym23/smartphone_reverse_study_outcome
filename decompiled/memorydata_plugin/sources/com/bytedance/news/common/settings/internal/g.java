package com.bytedance.news.common.settings.internal;

import com.bytedance.news.common.settings.api.annotation.ILocalSettings;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<Class<? extends ILocalSettings>, ILocalSettings> f2959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<Class<? extends ILocalSettings>, Object> f2960b;

    public g() {
        this.f2959a = new ConcurrentHashMap();
        this.f2960b = new ConcurrentHashMap();
    }

    private <T extends ILocalSettings> T a(Class<T> r7, com.bytedance.news.common.settings.b r8) {
        com.bytedance.news.common.settings.api.j r6 = r8.b();
        T r0 = (T) ZeusTransformUtils.preCheckCast(j.a(r7, r6), ILocalSettings.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L32;
        return r0;
    L32:
        Constructor<?> r1 = Class.forName(r7.getName() + "$$Impl", true, r7.getClassLoader()).getConstructor(new Class[]{com.bytedance.news.common.settings.api.i.class});     // Catch: Throwable -> L18 InvocationTargetException -> L20 InstantiationException -> L22 IllegalAccessException -> L24 NoSuchMethodException -> L26 ClassNotFoundException -> L28
        com.bytedance.news.common.settings.api.annotation.a r9 = (com.bytedance.news.common.settings.api.annotation.a) ZeusTransformUtils.preCheckCast(r7.getAnnotation(com.bytedance.news.common.settings.api.annotation.a.class), com.bytedance.news.common.settings.api.annotation.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18 InvocationTargetException -> L20 InstantiationException -> L22 IllegalAccessException -> L24 NoSuchMethodException -> L26 ClassNotFoundException -> L28
        if (r9 != null) goto L8;
        Throwable r10 = null;
    L31:
        throw new IllegalStateException("获取settings实例失败，检查warning日志确认问题", r10);
    L8:
        if (com.bytedance.news.common.settings.api.b.a.f2918a != null) goto L10;
    L14:
        com.bytedance.news.common.settings.api.i r11 = r6.a(r9.a());     // Catch: Throwable -> L18 InvocationTargetException -> L20 InstantiationException -> L22 IllegalAccessException -> L24 NoSuchMethodException -> L26 ClassNotFoundException -> L28
    L15:
        return (T) ZeusTransformUtils.preCheckCast(r1.newInstance(new Object[]{r11}), ILocalSettings.class, "com.obric.memorydata.plugin");
    L10:
        if (com.bytedance.news.common.settings.api.b.a.f2918a.a().booleanValue() == false) goto L14;
        if (r8.p() == false) goto L14;
        r11 = com.bytedance.news.common.settings.a.b.a(r6).a(r9.a());     // Catch: Throwable -> L18 InvocationTargetException -> L20 InstantiationException -> L22 IllegalAccessException -> L24 NoSuchMethodException -> L26 ClassNotFoundException -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
        r10 = e;
    L24:
        e = move-exception;
        e.printStackTrace();
        r10 = e;
    L22:
        e = move-exception;
        e.printStackTrace();
        r10 = e;
    L26:
        e = move-exception;
        e.printStackTrace();
        r10 = e;
    L20:
        e = move-exception;
        e.printStackTrace();
        r10 = e;
    L18:
        th = move-exception;
        throw th;
    }

    public <T extends ILocalSettings> T a(Class<T> r4, com.bytedance.news.common.settings.b r5, String r6) {
        T r0 = (T) ZeusTransformUtils.preCheckCast(this.f2959a.get(r4), ILocalSettings.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L36;
        com.bytedance.news.common.settings.api.annotation.a r1 = (com.bytedance.news.common.settings.api.annotation.a) ZeusTransformUtils.preCheckCast(r4.getAnnotation(com.bytedance.news.common.settings.api.annotation.a.class), com.bytedance.news.common.settings.api.annotation.a.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        String r2 = "";
    L9:
        if (r6.equals(r2) == false) goto L34;
        Object r7 = null;
        ConcurrentHashMap<Class<? extends ILocalSettings>, Object> r3 = this.f2960b;
        monitor-enter(r3);
    L30:
        th = move-exception;
        throw th;
    L13:
        if (this.f2960b.containsKey(r4) == false) goto L15;
        r7 = this.f2960b.get(r4);     // Catch: Throwable -> L30
    L15:
        if (r7 != null) goto L17;
        r7 = new Object();     // Catch: Throwable -> L30
        this.f2960b.put(r4, r7);     // Catch: Throwable -> L30
    L17:
        monitor-exit(r3);     // Catch: Throwable -> L30
        monitor-enter(r7);
        r0 = (T) ZeusTransformUtils.preCheckCast(this.f2959a.get(r4), ILocalSettings.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        if (r0 != null) goto L25;
        ILocalSettings r8 = a(r4, r5);     // Catch: Throwable -> L27
        if (r8 == null) goto L24;
        this.f2959a.put(r4, r8);     // Catch: Throwable -> L27
    L24:
        r0 = (T) r8;
    L25:
        monitor-exit(r7);     // Catch: Throwable -> L27
    L38:
        return r0;
    L27:
        th = move-exception;
        throw th;
    L34:
        throw new IllegalArgumentException("Settings声明id与Manager不匹配：" + r2 + " - ");
    L7:
        r2 = r1.b();
        goto L9
    L36:
        if (this.f2960b.containsKey(r4) == false) goto L38;
        this.f2960b.remove(r4);
        goto L38
    }
}
