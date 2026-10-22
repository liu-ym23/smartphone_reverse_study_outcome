package com.ss.android.ugc.aweme.framework.services;

import android.text.TextUtils;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import sk.a;

/* JADX INFO: loaded from: classes3.dex */
public final class ServiceManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f16216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f16217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f16218c;

    public static final class Holder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ServiceManager f16219a = null;

        static {
            f16219a = new ServiceManager();
        }
    }

    public ServiceManager() {
        this.f16216a = Collections.synchronizedSet(new HashSet());
        this.f16217b = true;
        this.f16218c = Collections.synchronizedSet(new HashSet());
    }

    public final Object a(Class r18, boolean r19, boolean r20) {
        if (r20 == true) goto L21;
        DowngradeImplManager r5 = DowngradeImplManager.SingleInstanceHolder.f16213a;
        String r10 = (String) r5.f16212c.get(r18.getName());
        if (TextUtils.isEmpty(r10) == true) goto L7;
        boolean r11 = r5.d.contains(r10);
    L8:
        if (r11 == false) goto L21;
        String r12 = r18.getName();
        ServiceProvider r13 = (ServiceProvider) r5.f16210a.get(r12);
        if (r13 == null) goto L12;
        Object r14 = r13.get();
    L18:
        if (r14 == null) goto L20;
        return r14;
    L20:
        boolean r15 = true;
    L22:
        Set r16 = (Set) DynamicBindServiceManager.f16214a.get(r18);
        if (r16 != null) goto L25;
    L29:
        Object r17 = null;
    L30:
        Map r21 = (Map) DynamicBindServiceManager.f16215b.get(r18);
        if (r17 != null) goto L39;
        if (r21 == null) goto L39;
        Object[] r22 = r21.keySet().toArray();
        int r23 = r22.length;
        int r110 = 0;
    L34:
        if (r110 >= r23) goto L39;
        Object[] r111 = ((Set) r21.get(r22[r110])).toArray();
        if (r111.length > 0) goto L37;
        r110 = r110 + 1;
        goto L34
    L37:
        r17 = ((ServiceProvider) r111[0]).get();
    L39:
        if (r17 == null) goto L42;
        this.f16218c.add(r18);
        return r17;
    L42:
        StaticServiceImplManager r24 = StaticServiceImplManager.SingleInstanceHolder.f16222a;
        r24.getClass();
        String r25 = r18.getName();
        Object r26 = r24.f16220a.get(r25);
        if (r26 == null) goto L45;
    L47:
        if (r26 == null) goto L50;
        this.f16218c.add(r18);
        return r26;
    L50:
        if (r20 == false) goto L53;
        return null;
    L53:
        if (this.f16216a.contains(r18.getName()) == false) goto L111;
        String[] r27 = ConfigLoader.f16202a;
        ClassLoader r28 = r18.getClassLoader();
        Map r29 = ConfigLoader.f16203b;
        monitor-enter(r29);
        List r30 = (List) r29.get(r18.getName());     // Catch: Throwable -> L61
        if (r30 == null) goto L63;
        monitor-exit(r29);     // Catch: Throwable -> L61
    L108:
        ConfigLoader.ConfigIterator r31 = new ConfigLoader.ConfigIterator(r30, r18, r28);
        if (r31.hasNext() == false) goto L111;
        Object r32 = r31.next();
    L112:
        if (r32 == null) goto L115;
        this.f16218c.add(r18);
        return r32;
    L115:
        if (r15 == true) goto L125;
        DowngradeImplManager r33 = DowngradeImplManager.SingleInstanceHolder.f16213a;
        r33.getClass();
        String r34 = r18.getName();
        ServiceProvider r35 = (ServiceProvider) r33.f16210a.get(r34);
        if (r35 == null) goto L119;
        r32 = r35.get();
        goto L125
    L119:
        Object r36 = r33.f16211b.get(r34);
        if (r36 == null) goto L122;
    L124:
        r32 = r36;
        goto L125
    L122:
        if (r33.e.contains(r34) == true) goto L124;
        r33.e.add(r18.getName());
        r32 = null;
    L125:
        if (r32 != null) goto L132;
        if (r19 == false) goto L132;
        if (r18.isInterface() == true) goto L160;
        return null;
    L160:
        return Proxy.newProxyInstance(r18.getClassLoader(), new Class[]{r18}, new DynamicProxy$1());
    L132:
        return r32;
    L63:
        monitor-exit(r29);     // Catch: Throwable -> L61
        LinkedList r37 = new LinkedList();
        String[] r112 = ConfigLoader.f16202a;
        int r113 = 0;
    L66:
        if (r113 >= 13) goto L99;
        StringBuilder r38 = a.a(r112[r113]);
        r38.append(r18.getName());
        String r39 = r38.toString();
        if (r28 != null) goto L141;
        Enumeration<URL> r40 = ClassLoader.getSystemResources(r39);     // Catch: IOException -> L71
    L75:
        Enumeration<URL> r114 = r40;
    L78:
        if (r114 == null) goto L98;
        if (r114.hasMoreElements() == false) goto L98;
        URL r115 = r114.nextElement();
        int r116 = 0;
    L83:
        if (r116 >= 3) goto L96;
        LinkedList r41 = ConfigLoader.a(r115);     // Catch: ConcurrentModificationException -> L86
    L97:
        r37.addAll(r41);
    L86:
        e = move-exception;
        if (r116 >= 2) goto L95;
        Thread.sleep(2);     // Catch: InterruptedException -> L92
    L94:
        r116 = r116 + 1;
    L92:
        e = move-exception;
        e.printStackTrace();
        goto L94
    L95:
        throw e;
    L96:
        r41 = new LinkedList();
    L98:
        r113 = r113 + 1;
    L71:
        e = move-exception;
        e.printStackTrace();
    L73:
        r114 = null;
        goto L78
    L141:
        r40 = r28.getResources(r39);     // Catch: IOException -> L76
    L76:
        e = move-exception;
        e.printStackTrace();
        goto L73
    L99:
        Map r42 = ConfigLoader.f16203b;
        monitor-enter(r42);
    L104:
        th = move-exception;
        throw th;
    L102:
        if (r42.containsKey(r18.getName()) == true) goto L106;
        r42.put(r18.getName(), r37);     // Catch: Throwable -> L104
        r30 = r37;
    L107:
        monitor-exit(r42);     // Catch: Throwable -> L104
        goto L108
    L106:
        r30 = (List) r42.get(r18.getName());     // Catch: Throwable -> L104
    L61:
        th = move-exception;
        throw th;
    L111:
        r32 = null;
        goto L112
    L45:
        if (r24.f16221b.contains(r25) == true) goto L47;
        r24.f16221b.add(r18.getName());
        r26 = null;
        goto L47
    L25:
        if (r16.isEmpty() == true) goto L29;
        Object[] r43 = r16.toArray();
        if (r43.length <= 0) goto L29;
        r17 = ((ServiceProvider) r43[0]).get();
        goto L30
    L12:
        Object r44 = r5.f16211b.get(r12);
        if (r44 == null) goto L15;
    L17:
        r14 = r44;
        goto L18
    L15:
        if (r5.e.contains(r12) == true) goto L17;
        r5.e.add(r18.getName());
        r14 = null;
        goto L18
    L7:
        r11 = false;
    L21:
        r15 = false;
        goto L22
    }

    public final Object a(Class r5) {
        return a(r5, this.f16217b, false);
    }

    public static ServiceManager a() {
        return Holder.f16219a;
    }
}
