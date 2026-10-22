package com.obric.cae.runtime;

import android.content.Context;
import com.google.protobuf.d;
import com.obric.cae.log.CommSenseLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class CaeRuntime {
    private static final ConcurrentHashMap<Class<?>, CopyOnWriteArrayList<ServiceReadyListener<?>>> READY_LISTENERS = null;
    private static final ConcurrentHashMap<Class<?>, Object> SERVICE_INSTANCES = null;
    private static final String TAG = "CaeRuntime";

    static {
        SERVICE_INSTANCES = new ConcurrentHashMap();
        READY_LISTENERS = new ConcurrentHashMap();
    }

    private CaeRuntime() {
    }

    public static /* synthetic */ CopyOnWriteArrayList a(Class r8) {
        return lambda$registerServiceReadyListener$0(r8);
    }

    public static <T> T getService(Class<T> r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        Object r10 = SERVICE_INSTANCES.get(r8);
        if (r10 != null) goto L8;
    L12:
        return null;
    L8:
        if (r8.isInstance(r10) == false) goto L12;
        return r8.cast(r10);
    }

    private static /* synthetic */ CopyOnWriteArrayList lambda$registerServiceReadyListener$0(Class r8) {
        return new CopyOnWriteArrayList();
    }

    public static <T> void notifyServiceReady(Context r8, Class<T> r10, T r11) {
        if (r8 == null) goto L21;
        if (r10 == null) goto L21;
        if (r11 == null) goto L21;
        SERVICE_INSTANCES.put(r10, r11);
        CopyOnWriteArrayList<ServiceReadyListener<?>> r12 = READY_LISTENERS.get(r10);
        if (r12 != null) goto L10;
        return;
    L10:
        if (r12.isEmpty() == true) goto L29;
        Context r13 = r8.getApplicationContext();
        Iterator<ServiceReadyListener<?>> r14 = r12.iterator();
    L14:
        if (r14.hasNext() == false) goto L30;
        r14.next().onServiceReady(r13, r11);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CommSenseLog.e(TAG, "dispatch onServiceReady failed: " + r10, th);
        goto L14
    L30:
        return;
    L29:
        return;
    L21:
        CommSenseLog.w(TAG, "notifyServiceReady: invalid args");
    }

    public static <T> void registerServiceReadyListener(Context r8, Class<T> r10, ServiceReadyListener<? super T> r11) {
        if (r8 == null) goto L14;
        if (r10 == null) goto L14;
        if (r11 == null) goto L14;
        READY_LISTENERS.computeIfAbsent(r10, new d(10)).add(r11);
        a0.d r12 = (Object) getService(r10);
        if (r12 == null) goto L18;
        r11.onServiceReady(r8.getApplicationContext(), r12);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        CommSenseLog.e(TAG, "listener onServiceReady failed: " + r10, th);
        return;
    L18:
        return;
    L14:
        CommSenseLog.w(TAG, "registerServiceReadyListener: invalid args");
    }

    public static <T> void unregisterService(Class<T> r8, T r10) {
        if (r8 == null) goto L7;
        if (r10 == null) goto L8;
        SERVICE_INSTANCES.remove(r8, r10);
        return;
    L8:
        return;
    }

    public static <T> void unregisterServiceReadyListener(Class<T> r8, ServiceReadyListener<? super T> r10) {
        if (r8 == null) goto L9;
        if (r10 == null) goto L11;
        CopyOnWriteArrayList<ServiceReadyListener<?>> r11 = READY_LISTENERS.get(r8);
        if (r11 == null) goto L10;
        r11.remove(r10);
        return;
    L10:
        return;
    L11:
        return;
    }
}
