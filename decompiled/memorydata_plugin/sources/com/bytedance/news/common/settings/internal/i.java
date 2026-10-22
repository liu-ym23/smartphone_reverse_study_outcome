package com.bytedance.news.common.settings.internal;

import android.content.Context;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.services.apm.api.IEnsure;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<Class<? extends ISettings>, ISettings> f2963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<Class<? extends ISettings>, Object> f2964b;

    public i() {
        this.f2963a = new ConcurrentHashMap();
        this.f2964b = new ConcurrentHashMap();
    }

    private static <T extends ISettings> ISettings a(Class<T> r5, com.bytedance.news.common.settings.api.i r6) {
        ISettings r7 = (ISettings) ZeusTransformUtils.preCheckCast(Class.forName(r5.getName() + "$$Impl", true, r5.getClassLoader()).getConstructor(new Class[]{com.bytedance.news.common.settings.api.i.class}).newInstance(new Object[]{(com.bytedance.news.common.settings.api.i) ZeusTransformUtils.wrapperContextForParams(r6, com.bytedance.news.common.settings.api.i.class, "com.obric.memorydata.plugin")}), ISettings.class, "com.obric.memorydata.plugin");
        r7.updateSettings(null);
        return r7;
    }

    private static <T extends ISettings> T a(Class<T> r12, com.bytedance.news.common.settings.b r13) {
        com.bytedance.news.common.settings.api.j r0 = r13.b();
        T r1 = (T) ZeusTransformUtils.preCheckCast(j.a(r12, r0), ISettings.class, "com.obric.memorydata.plugin");
        Throwable r2 = null;
        if (r1 == null) goto L105;
        r1.updateSettings(null);
        return r1;
    L105:
        com.bytedance.news.common.settings.api.annotation.a r3 = (com.bytedance.news.common.settings.api.annotation.a) ZeusTransformUtils.preCheckCast(r12.getAnnotation(com.bytedance.news.common.settings.api.annotation.a.class), com.bytedance.news.common.settings.api.annotation.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        if (r3 == null) goto L90;
        int r4 = r13.k();     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        boolean r6 = com.bytedance.news.common.settings.api.b.a.b();     // Catch: RuntimeException -> L12 Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
    L15:
        String r9 = "";
        if (r13.i() == false) goto L40;
        SettingsConfigProvider r7 = (SettingsConfigProvider) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(SettingsConfigProvider.class), SettingsConfigProvider.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        if (r7 != null) goto L20;
    L27:
        if (r4 <= 0) goto L34;
        String r5 = r3.a();     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        if (r5 == null) goto L32;
        r9 = r5;
    L32:
        StringBuilder r8 = new StringBuilder().append("app_settings_sp_").append(r9.length() & r4);     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
    L33:
        String r10 = r8.toString();     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
    L58:
        if (r13.h() == false) goto L61;
        com.bytedance.news.common.settings.api.i r14 = r0.a(r10, true);     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
    L106:
        return (T) a(r12, r14);
    L61:
        r14 = r0.a(r10, true);     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        T r11 = (T) com.bytedance.news.common.settings.c.a(r12.getName(), r14);
        if (r11 == null) goto L106;
        r11.updateSettings(null);     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        return r11;
    L34:
        r10 = r3.a();     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        if (r6 == false) goto L58;
        com.bytedance.news.common.settings.api.b.a.a(false);     // Catch: RuntimeException -> L38 Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
    L38:
        e = e;
    L26:
        e.printStackTrace();     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        goto L58
    L20:
        if (r7.getConfig().i() == false) goto L27;
        r10 = "all_app_settings_sp";
        if (r6 == true) goto L58;
        com.bytedance.news.common.settings.api.b.a.a(true);     // Catch: RuntimeException -> L25 Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
    L25:
        e = e;
        goto L26
    L40:
        if (r4 <= 0) goto L51;
        if (r6 == false) goto L99;
    L46:
        String r15 = r3.a();     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        if (r15 == null) goto L50;
        r9 = r15;
    L50:
        r8 = new StringBuilder().append("app_settings_sp_").append(r9.length() & r4);     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        goto L33
    L99:
        com.bytedance.news.common.settings.api.b.a.a(true);     // Catch: RuntimeException -> L44 Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
    L44:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        goto L46
    L51:
        r10 = r3.a();     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        if (r6 == false) goto L58;
        com.bytedance.news.common.settings.api.b.a.a(false);     // Catch: RuntimeException -> L55 Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
    L55:
        e = e;
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        r6 = false;
    L90:
        if (r2 == null) goto L94;
        throw new IllegalStateException("获取settings实例失败，检查warning日志确认问题", r2);
    L94:
        throw new IllegalStateException("获取settings实例失败，检查warning日志确认问题");
    L85:
        e = move-exception;
        ClassNotFoundException r16 = e;
        r16.printStackTrace();
        IEnsure r17 = (IEnsure) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IEnsure.class), IEnsure.class, "com.obric.memorydata.plugin");
        r2 = r16;
        if (r17 == null) goto L90;
        String r18 = "获取settings实例失败，ClassNotFoundException";
        Throwable r19 = r16;
        IEnsure r110 = r17;
    L72:
        r110.ensureNotReachHere(r19, r18);
        r2 = r19;
    L77:
        e = move-exception;
        IllegalAccessException r20 = e;
        r20.printStackTrace();
        IEnsure r111 = (IEnsure) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IEnsure.class), IEnsure.class, "com.obric.memorydata.plugin");
        r2 = r20;
        if (r111 == null) goto L90;
        r18 = "获取settings实例失败，IllegalAccessException";
        r19 = r20;
        r110 = r111;
    L73:
        e = move-exception;
        InstantiationException r21 = e;
        r21.printStackTrace();
        IEnsure r112 = (IEnsure) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IEnsure.class), IEnsure.class, "com.obric.memorydata.plugin");
        r2 = r21;
        if (r112 == null) goto L90;
        r18 = "获取settings实例失败，InstantiationException";
        r19 = r21;
        r110 = r112;
    L81:
        e = move-exception;
        NoSuchMethodException r22 = e;
        r22.printStackTrace();
        IEnsure r113 = (IEnsure) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IEnsure.class), IEnsure.class, "com.obric.memorydata.plugin");
        r2 = r22;
        if (r113 == null) goto L90;
        r18 = "获取settings实例失败，NoSuchMethodException";
        r19 = r22;
        r110 = r113;
    L68:
        e = move-exception;
        InvocationTargetException r23 = e;
        r23.printStackTrace();
        IEnsure r114 = (IEnsure) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IEnsure.class), IEnsure.class, "com.obric.memorydata.plugin");
        r2 = r23;
        if (r114 == null) goto L90;
        r18 = "获取settings实例失败，InvocationTargetException";
        r19 = r23;
        r110 = r114;
    L66:
        th = move-exception;
        throw th;
    }

    public <T extends ISettings> T a(Class<T> r4, com.bytedance.news.common.settings.b r5, String r6) {
        T r0 = (T) ZeusTransformUtils.preCheckCast(this.f2963a.get(r4), ISettings.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L36;
        com.bytedance.news.common.settings.api.annotation.a r1 = (com.bytedance.news.common.settings.api.annotation.a) ZeusTransformUtils.preCheckCast(r4.getAnnotation(com.bytedance.news.common.settings.api.annotation.a.class), com.bytedance.news.common.settings.api.annotation.a.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        String r2 = "";
    L9:
        if (r6.equals(r2) == false) goto L34;
        Object r7 = null;
        ConcurrentHashMap<Class<? extends ISettings>, Object> r3 = this.f2964b;
        monitor-enter(r3);
    L30:
        th = move-exception;
        throw th;
    L13:
        if (this.f2964b.containsKey(r4) == false) goto L15;
        r7 = this.f2964b.get(r4);     // Catch: Throwable -> L30
    L15:
        if (r7 != null) goto L17;
        r7 = new Object();     // Catch: Throwable -> L30
        this.f2964b.put(r4, r7);     // Catch: Throwable -> L30
    L17:
        monitor-exit(r3);     // Catch: Throwable -> L30
        monitor-enter(r7);
        r0 = (T) ZeusTransformUtils.preCheckCast(this.f2963a.get(r4), ISettings.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        if (r0 != null) goto L25;
        ISettings r8 = a(r4, r5);     // Catch: Throwable -> L27
        if (r8 == null) goto L24;
        this.f2963a.put(r4, r8);     // Catch: Throwable -> L27
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
        if (this.f2964b.containsKey(r4) == false) goto L38;
        this.f2964b.remove(r4);
        goto L38
    }

    public synchronized void a(com.bytedance.news.common.settings.api.e r5, com.bytedance.news.common.settings.b r6, boolean r7) {
        monitor-enter(this);
        Iterator<ISettings> r0 = this.f2963a.values().iterator();     // Catch: Throwable -> L10
    L5:
        if (r0.hasNext() == false) goto L7;
        ((ISettings) ZeusTransformUtils.preCheckCast(r0.next(), ISettings.class, "com.obric.memorydata.plugin")).updateSettings(r5);     // Catch: Throwable -> L10
        goto L5
    L7:
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        h.a(r1).a(r5.c(), r6.s());     // Catch: Throwable -> L10
        f.a(r1).a(r5, r6, r7);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
