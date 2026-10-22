package com.bytedance.news.common.settings.internal;

import com.bytedance.news.common.settings.api.annotation.ILocalSettings;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<Class<? extends ILocalSettings>, ILocalSettings> f2412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<Class<? extends ILocalSettings>, Object> f2413b;

    public g() {
        this.f2412a = new ConcurrentHashMap();
        this.f2413b = new ConcurrentHashMap();
    }

    private <T extends ILocalSettings> T a(Class<T> r10, e4.b r11) {
        f4.i r12 = r11.m();
        T r13 = (T) j.a(r10, r12);
        if (r13 == null) goto L32;
        return r13;
    L32:
        Constructor<?> r14 = Class.forName(r10.getName() + "$$Impl", true, r10.getClassLoader()).getConstructor(new Class[]{f4.h.class});     // Catch: Throwable -> L18 InvocationTargetException -> L20 InstantiationException -> L22 IllegalAccessException -> L24 NoSuchMethodException -> L26 ClassNotFoundException -> L28
        com.bytedance.news.common.settings.api.annotation.a r15 = (com.bytedance.news.common.settings.api.annotation.a) r10.getAnnotation(com.bytedance.news.common.settings.api.annotation.a.class);     // Catch: Throwable -> L18 InvocationTargetException -> L20 InstantiationException -> L22 IllegalAccessException -> L24 NoSuchMethodException -> L26 ClassNotFoundException -> L28
        if (r15 != null) goto L8;
        Throwable r16 = null;
    L31:
        throw new IllegalStateException("获取settings实例失败，检查warning日志确认问题", r16);
    L8:
        if (h4.a.f9169n != null) goto L10;
    L14:
        f4.h r17 = r12.b(r15.storageKey());     // Catch: Throwable -> L18 InvocationTargetException -> L20 InstantiationException -> L22 IllegalAccessException -> L24 NoSuchMethodException -> L26 ClassNotFoundException -> L28
    L15:
        return (T) r14.newInstance(new Object[]{r17});
    L10:
        if (h4.a.f9169n.isDebug().booleanValue() == false) goto L14;
        if (r11.o() == false) goto L14;
        r17 = j4.b.c(r12).b(r15.storageKey());     // Catch: Throwable -> L18 InvocationTargetException -> L20 InstantiationException -> L22 IllegalAccessException -> L24 NoSuchMethodException -> L26 ClassNotFoundException -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
        r16 = e;
    L24:
        e = move-exception;
        e.printStackTrace();
        r16 = e;
    L22:
        e = move-exception;
        e.printStackTrace();
        r16 = e;
    L26:
        e = move-exception;
        e.printStackTrace();
        r16 = e;
    L20:
        e = move-exception;
        e.printStackTrace();
        r16 = e;
    L18:
        th = move-exception;
        throw th;
    }

    public <T extends ILocalSettings> T b(Class<T> r10, e4.b r11, String r12) {
        T r13 = (T) this.f2412a.get(r10);
        if (r13 != null) goto L36;
        com.bytedance.news.common.settings.api.annotation.a r14 = (com.bytedance.news.common.settings.api.annotation.a) r10.getAnnotation(com.bytedance.news.common.settings.api.annotation.a.class);
        if (r14 != null) goto L7;
        String r15 = "";
    L9:
        if (r12.equals(r15) == false) goto L34;
        Object r16 = null;
        ConcurrentHashMap<Class<? extends ILocalSettings>, Object> r17 = this.f2413b;
        monitor-enter(r17);
    L30:
        th = move-exception;
        throw th;
    L13:
        if (this.f2413b.containsKey(r10) == false) goto L15;
        r16 = this.f2413b.get(r10);     // Catch: Throwable -> L30
    L15:
        if (r16 != null) goto L17;
        r16 = new Object();     // Catch: Throwable -> L30
        this.f2413b.put(r10, r16);     // Catch: Throwable -> L30
    L17:
        monitor-exit(r17);     // Catch: Throwable -> L30
        monitor-enter(r16);
        r13 = (T) this.f2412a.get(r10);     // Catch: Throwable -> L27
        if (r13 != null) goto L25;
        ILocalSettings r18 = a(r10, r11);     // Catch: Throwable -> L27
        if (r18 == null) goto L24;
        this.f2412a.put(r10, r18);     // Catch: Throwable -> L27
    L24:
        r13 = (T) r18;
    L25:
        monitor-exit(r16);     // Catch: Throwable -> L27
    L38:
        return r13;
    L27:
        th = move-exception;
        throw th;
    L34:
        throw new IllegalArgumentException("Settings声明id与Manager不匹配：" + r15 + " - ");
    L7:
        r15 = r14.settingsId();
        goto L9
    L36:
        if (this.f2413b.containsKey(r10) == false) goto L38;
        this.f2413b.remove(r10);
        goto L38
    }
}
