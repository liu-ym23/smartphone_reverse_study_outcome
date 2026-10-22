package com.bytedance.android.btm.impl.page.observe;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.android.btm.impl.util.d;
import com.bytedance.android.btm.impl.util.f;
import gd.a;
import gd.b;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AppStatusObserver implements b {
    public static final Set<a> a = null;
    public static int b;
    public static f<Activity> c;
    public static long d;
    public static volatile int e;
    public static final Map<Long, Long> f = null;
    public static final AppStatusObserver g = null;

    public AppStatusObserver() {
    }

    public final void onActivityDestroyed(Activity r1) {
    }

    public final void onActivitySaveInstanceState(Activity r1, Bundle r10) {
    }

    public final void onActivityStarted(Activity r1) {
    }

    static {
        g = new AppStatusObserver();
        a = new LinkedHashSet();
        e = -1;
        f = Collections.synchronizedMap(new AppStatusObserver$switchTimeMap$1());
    }

    public final Activity getTopActivity() {
        f<Activity> r0 = c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    public final Set<Activity> i() {
        return new LinkedHashSet();
    }

    public final boolean isAppBackground() {
        if (e != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void onActivityPaused(Activity r10) {
        if (b != 0) goto L5;
        b = r10.hashCode();
    L5:
        c = null;
    }

    public final void onActivityResumed(Activity r10) {
        e = 1;
        int r1 = b;
        b = r10.hashCode();
        c = new f(r10);
        if (r1 != 0) goto L17;
        e = 1;
        d = System.currentTimeMillis();
        Map<Long, Long> r0 = f;
        monitor-enter(r0);
        d r11 = d.a;     // Catch: Throwable -> L14
        Map.Entry r12 = d.a(r0);     // Catch: Throwable -> L14
        if (r12 == null) goto L9;
        Object r13 = r12.getKey();     // Catch: Throwable -> L14
        Long r14 = (Long) r13;
        r0.put(r14, Long.valueOf(d));     // Catch: Throwable -> L14
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L14
    L9:
        monitor-exit(r0);
        Iterator<T> r16 = a.iterator();
    L12:
        if (r16.hasNext() == false) goto L21;
        ((a) r16.next()).a(r10);
        goto L12
    L21:
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public final void onActivityStopped(Activity r10) {
        if (r10.hashCode() != b) goto L8;
        b = 0;
        e = 0;
        long r0 = System.currentTimeMillis();
        f.put(Long.valueOf(r0), 0L);
        Iterator<T> r1 = a.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((a) r1.next()).b(r10);
        goto L6
    L10:
        return;
    }

    public final void q(a r10) {
        if (r10 == null) goto L5;
        a.add(r10);
        return;
    }

    public final ConcurrentHashMap<Long, Long> l(long r10, long r12) {
        ConcurrentHashMap<Long, Long> r0 = new ConcurrentHashMap();
        Map<Long, Long> r1 = f;
        monitor-enter(r1);
        Iterator<Map.Entry<Long, Long>> r11 = r1.entrySet().iterator();     // Catch: Throwable -> L17
    L6:
        if (r11.hasNext() == false) goto L14;
        Map.Entry<Long, Long> r13 = r11.next();     // Catch: Throwable -> L17
        if (r13.getKey().longValue() <= r10) goto L6;
        if (r13.getKey().longValue() >= r12) goto L6;
        if (r13.getValue().longValue() <= 0) goto L6;
        r0.put(r13.getKey(), r13.getValue());     // Catch: Throwable -> L17
        goto L6
    L14:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r1);
        return r0;
    L17:
        th = move-exception;
        throw th;
    }

    public final void onActivityCreated(Activity r1, Bundle r10) {
        SystemClock.elapsedRealtime();
    }
}
