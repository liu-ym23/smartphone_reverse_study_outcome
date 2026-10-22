package com.bytedance.android.monitorV2.lynx.impl;

import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.services.apm.api.IEnsure;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f3652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f3653b;

    public a() {
        this.f3652a = new ConcurrentHashMap();
        this.f3653b = new ConcurrentHashMap();
    }

    public static ISettings a(Class r5, pg.d r10) {
        vg.a r11 = (vg.a) r10.f21352c.f5321c;
        rg.a r12 = (rg.a) r5.getAnnotation(rg.a.class);     // Catch: Throwable -> L8 InvocationTargetException -> L10 InstantiationException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16 ClassNotFoundException -> L18
        Throwable r13 = null;
        if (r12 == null) goto L50;
        tg.a r14 = tg.a.f22131a;     // Catch: Throwable -> L8 InvocationTargetException -> L10 InstantiationException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16 ClassNotFoundException -> L18 RuntimeException -> L20
    L22:
        String r15 = r12.storageKey();     // Catch: Throwable -> L8 InvocationTargetException -> L10 InstantiationException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16 ClassNotFoundException -> L18
        r11.getClass();     // Catch: Throwable -> L8 InvocationTargetException -> L10 InstantiationException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16 ClassNotFoundException -> L18
        ConcurrentHashMap r16 = vg.a.f22577a;     // Catch: Throwable -> L8 InvocationTargetException -> L10 InstantiationException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16 ClassNotFoundException -> L18
        vg.b r17 = (vg.b) r16.get(r15);     // Catch: Throwable -> L8 InvocationTargetException -> L10 InstantiationException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16 ClassNotFoundException -> L18
        if (r17 != null) goto L26;
        r17 = new vg.b(ug.a.b(), r15);     // Catch: Throwable -> L8 InvocationTargetException -> L10 InstantiationException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16 ClassNotFoundException -> L18
        r16.put(r15, r17);     // Catch: Throwable -> L8 InvocationTargetException -> L10 InstantiationException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16 ClassNotFoundException -> L18
    L26:
        ISettings r18 = (ISettings) Class.forName(r5.getName().concat("$$Impl"), true, r5.getClassLoader()).getConstructor(new Class[]{qg.d.class}).newInstance(new Object[]{r17});     // Catch: Throwable -> L8 InvocationTargetException -> L10 InstantiationException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16 ClassNotFoundException -> L18
        r18.updateSettings(null);     // Catch: Throwable -> L8 InvocationTargetException -> L10 InstantiationException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16 ClassNotFoundException -> L18
        return r18;
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8 InvocationTargetException -> L10 InstantiationException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16 ClassNotFoundException -> L18
    L50:
        if (r13 == null) goto L54;
        throw new IllegalStateException("获取settings实例失败，检查warning日志确认问题", r13);
    L54:
        throw new IllegalStateException("获取settings实例失败，检查warning日志确认问题");
    L18:
        e = move-exception;
        r13 = e;
        r13.printStackTrace();
        IEnsure r19 = (IEnsure) og.a.a(IEnsure.class);
        if (r19 == null) goto L50;
        r19.ensureNotReachHere(r13, "获取settings实例失败，ClassNotFoundException");
    L14:
        e = move-exception;
        r13 = e;
        r13.printStackTrace();
        IEnsure r20 = (IEnsure) og.a.a(IEnsure.class);
        if (r20 == null) goto L50;
        r20.ensureNotReachHere(r13, "获取settings实例失败，IllegalAccessException");
    L12:
        e = move-exception;
        r13 = e;
        r13.printStackTrace();
        IEnsure r21 = (IEnsure) og.a.a(IEnsure.class);
        if (r21 == null) goto L50;
        r21.ensureNotReachHere(r13, "获取settings实例失败，InstantiationException");
    L16:
        e = move-exception;
        r13 = e;
        r13.printStackTrace();
        IEnsure r22 = (IEnsure) og.a.a(IEnsure.class);
        if (r22 == null) goto L50;
        r22.ensureNotReachHere(r13, "获取settings实例失败，NoSuchMethodException");
    L10:
        e = move-exception;
        r13 = e;
        r13.printStackTrace();
        IEnsure r23 = (IEnsure) og.a.a(IEnsure.class);
        if (r23 == null) goto L50;
        r23.ensureNotReachHere(r13, "获取settings实例失败，InvocationTargetException");
    L8:
        th = move-exception;
        throw th;
    }

    public a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "monitorId");
        this.f3652a = j5.b.c(r5);
        this.f3653b = j5.b.h(r5);
    }
}
