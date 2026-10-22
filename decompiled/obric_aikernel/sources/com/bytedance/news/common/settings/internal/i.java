package com.bytedance.news.common.settings.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.services.apm.api.IEnsure;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<Class<? extends ISettings>, ISettings> f2416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<Class<? extends ISettings>, Object> f2417b;

    public i() {
        this.f2416a = new ConcurrentHashMap();
        this.f2417b = new ConcurrentHashMap();
    }

    private static <T extends ISettings> T a(Class<T> r11, e4.b r12) {
        f4.i r10 = r12.m();
        T r13 = (T) j.a(r11, r10);
        Throwable r14 = null;
        if (r13 == null) goto L105;
        r13.updateSettings(null);
        return r13;
    L105:
        com.bytedance.news.common.settings.api.annotation.a r15 = (com.bytedance.news.common.settings.api.annotation.a) r11.getAnnotation(com.bytedance.news.common.settings.api.annotation.a.class);     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        if (r15 == null) goto L90;
        int r16 = r12.f();     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        boolean r17 = h4.a.c();     // Catch: RuntimeException -> L12 Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
    L15:
        String r18 = "";
        if (r12.t() == false) goto L40;
        SettingsConfigProvider r19 = (SettingsConfigProvider) c4.d.a(SettingsConfigProvider.class);     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        if (r19 != null) goto L20;
    L27:
        if (r16 <= 0) goto L34;
        String r20 = r15.storageKey();     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        if (r20 == null) goto L32;
        r18 = r20;
    L32:
        int r21 = r18.length() & r16;     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        StringBuilder r22 = new StringBuilder();     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        r22.append("app_settings_sp_");     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        r22.append(r21);     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
    L33:
        String r23 = r22.toString();     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
    L58:
        if (r12.u() == false) goto L61;
        f4.h r110 = r10.a(r23, true);     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
    L106:
        return (T) b(r11, r110);
    L61:
        r110 = r10.a(r23, true);     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        T r24 = (T) e4.c.a(r11.getName(), r110);
        if (r24 == null) goto L106;
        r24.updateSettings(null);     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        return r24;
    L34:
        r23 = r15.storageKey();     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        if (r17 == false) goto L58;
        h4.a.j(false);     // Catch: RuntimeException -> L38 Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
    L38:
        e = e;
    L26:
        e.printStackTrace();     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        goto L58
    L20:
        if (r19.getConfig().t() == false) goto L27;
        r23 = "all_app_settings_sp";
        if (r17 == true) goto L58;
        h4.a.j(true);     // Catch: RuntimeException -> L25 Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
    L25:
        e = e;
        goto L26
    L40:
        if (r16 <= 0) goto L51;
        if (r17 == false) goto L103;
    L46:
        String r25 = r15.storageKey();     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        if (r25 == null) goto L50;
        r18 = r25;
    L50:
        int r26 = r18.length() & r16;     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        r22 = new StringBuilder();     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        r22.append("app_settings_sp_");     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        r22.append(r26);     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        goto L33
    L103:
        h4.a.j(true);     // Catch: RuntimeException -> L44 Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
    L44:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        goto L46
    L51:
        r23 = r15.storageKey();     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        if (r17 == false) goto L58;
        h4.a.j(false);     // Catch: RuntimeException -> L55 Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
    L55:
        e = e;
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L66 InvocationTargetException -> L68 InstantiationException -> L73 IllegalAccessException -> L77 NoSuchMethodException -> L81 ClassNotFoundException -> L85
        r17 = false;
    L90:
        if (r14 == null) goto L94;
        throw new IllegalStateException("获取settings实例失败，检查warning日志确认问题", r14);
    L94:
        throw new IllegalStateException("获取settings实例失败，检查warning日志确认问题");
    L85:
        e = move-exception;
        ClassNotFoundException r27 = e;
        r27.printStackTrace();
        IEnsure r111 = (IEnsure) c4.d.a(IEnsure.class);
        r14 = r27;
        if (r111 == null) goto L90;
        String r112 = "获取settings实例失败，ClassNotFoundException";
        Throwable r28 = r27;
        IEnsure r113 = r111;
    L72:
        r113.ensureNotReachHere(r28, r112);
        r14 = r28;
    L77:
        e = move-exception;
        IllegalAccessException r29 = e;
        r29.printStackTrace();
        IEnsure r114 = (IEnsure) c4.d.a(IEnsure.class);
        r14 = r29;
        if (r114 == null) goto L90;
        r112 = "获取settings实例失败，IllegalAccessException";
        r28 = r29;
        r113 = r114;
    L73:
        e = move-exception;
        InstantiationException r30 = e;
        r30.printStackTrace();
        IEnsure r115 = (IEnsure) c4.d.a(IEnsure.class);
        r14 = r30;
        if (r115 == null) goto L90;
        r112 = "获取settings实例失败，InstantiationException";
        r28 = r30;
        r113 = r115;
    L81:
        e = move-exception;
        NoSuchMethodException r31 = e;
        r31.printStackTrace();
        IEnsure r116 = (IEnsure) c4.d.a(IEnsure.class);
        r14 = r31;
        if (r116 == null) goto L90;
        r112 = "获取settings实例失败，NoSuchMethodException";
        r28 = r31;
        r113 = r116;
    L68:
        e = move-exception;
        InvocationTargetException r32 = e;
        r32.printStackTrace();
        IEnsure r117 = (IEnsure) c4.d.a(IEnsure.class);
        r14 = r32;
        if (r117 == null) goto L90;
        r112 = "获取settings实例失败，InvocationTargetException";
        r28 = r32;
        r113 = r117;
    L66:
        th = move-exception;
        throw th;
    }

    private static <T extends ISettings> ISettings b(Class<T> r10, f4.h r11) {
        ISettings r12 = (ISettings) Class.forName(r10.getName() + "$$Impl", true, r10.getClassLoader()).getConstructor(new Class[]{f4.h.class}).newInstance(new Object[]{r11});
        r12.updateSettings(null);
        return r12;
    }

    public <T extends ISettings> T c(Class<T> r10, e4.b r11, String r12) {
        T r13 = (T) this.f2416a.get(r10);
        if (r13 != null) goto L36;
        com.bytedance.news.common.settings.api.annotation.a r14 = (com.bytedance.news.common.settings.api.annotation.a) r10.getAnnotation(com.bytedance.news.common.settings.api.annotation.a.class);
        if (r14 != null) goto L7;
        String r15 = "";
    L9:
        if (r12.equals(r15) == false) goto L34;
        Object r16 = null;
        ConcurrentHashMap<Class<? extends ISettings>, Object> r17 = this.f2417b;
        monitor-enter(r17);
    L30:
        th = move-exception;
        throw th;
    L13:
        if (this.f2417b.containsKey(r10) == false) goto L15;
        r16 = this.f2417b.get(r10);     // Catch: Throwable -> L30
    L15:
        if (r16 != null) goto L17;
        r16 = new Object();     // Catch: Throwable -> L30
        this.f2417b.put(r10, r16);     // Catch: Throwable -> L30
    L17:
        monitor-exit(r17);     // Catch: Throwable -> L30
        monitor-enter(r16);
        r13 = (T) this.f2416a.get(r10);     // Catch: Throwable -> L27
        if (r13 != null) goto L25;
        ISettings r18 = a(r10, r11);     // Catch: Throwable -> L27
        if (r18 == null) goto L24;
        this.f2416a.put(r10, r18);     // Catch: Throwable -> L27
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
        if (this.f2417b.containsKey(r10) == false) goto L38;
        this.f2417b.remove(r10);
        goto L38
    }

    public synchronized void d(@NonNull f4.d r10, @NonNull e4.b r11, boolean r12) {
        monitor-enter(this);
        Iterator<ISettings> r13 = this.f2416a.values().iterator();     // Catch: Throwable -> L10
    L5:
        if (r13.hasNext() == false) goto L7;
        r13.next().updateSettings(r10);     // Catch: Throwable -> L10
        goto L5
    L7:
        Context r14 = b.b();     // Catch: Throwable -> L10
        h.b(r14).h(r10.b(), r11.e());     // Catch: Throwable -> L10
        f.c(r14).h(r10, r11, r12);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
