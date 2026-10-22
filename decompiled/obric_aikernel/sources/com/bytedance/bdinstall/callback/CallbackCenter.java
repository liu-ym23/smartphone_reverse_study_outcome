package com.bytedance.bdinstall.callback;

import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import com.bytedance.bdinstall.ExecutorUtil;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class CallbackCenter {

    @VisibleForTesting
    public final ConcurrentHashMap<CallbackWrapper, Object> CALLBACK_WRAPPERS;
    private final ConcurrentHashMap<Type, ValueHolder> OBSERVERS_MAP;
    private final Object VALUE;
    private String mAid;
    private final Object sLock;

    private static class ValueHolder {
        ConcurrentHashMap<Callback, Object> callbacks;
        Object value;

        private ValueHolder() {
            this.callbacks = new ConcurrentHashMap();
        }

        /* synthetic */ ValueHolder(AnonymousClass1 r10) {
            this();
        }

        public boolean isEmpty() {
            return this.callbacks.isEmpty();
        }

        Set<Callback> keySet() {
            return this.callbacks.keySet();
        }

        public void put(Callback r10, Object r11) {
            this.callbacks.put(r10, r11);
        }

        void remove(Callback r10) {
            this.callbacks.remove(r10);
        }
    }

    public CallbackCenter() {
        this.sLock = new Object();
        this.VALUE = new Object();
        this.OBSERVERS_MAP = new ConcurrentHashMap();
        this.CALLBACK_WRAPPERS = new ConcurrentHashMap();
        this.mAid = null;
    }

    private <EVENT> void callbackWhenRegister(final Callback<EVENT> r10, final ValueHolder r11, final Object r12) {
        ExecutorUtil.runOnHandlerThread(this.mAid, new AnonymousClass1(this, r11, r10, r12));
    }

    public void init(String r10) {
        this.mAid = r10;
    }

    @MainThread
    public <Event> void postEvent(final Event r10) {
        if (Looper.myLooper() == ExecutorUtil.getLooper(this.mAid)) goto L6;
        ExecutorUtil.runOnHandlerThread(this.mAid, new AnonymousClass2(this, r10));
        return;
    L6:
        Object r11 = this.sLock;
        monitor-enter(r11);
        ValueHolder r12 = this.OBSERVERS_MAP.get(r10.getClass());     // Catch: Throwable -> L19
        if (r12 != null) goto L11;
        r12 = new ValueHolder(null);     // Catch: Throwable -> L19
        this.OBSERVERS_MAP.put(r10.getClass(), r12);     // Catch: Throwable -> L19
    L11:
        monitor-exit(r11);     // Catch: Throwable -> L19
        r12.value = r10;
        Iterator<Callback> r13 = r12.keySet().iterator();
    L14:
        if (r13.hasNext() == false) goto L18;
        Callback r14 = r13.next();
        if (r14 == null) goto L14;
        r14.onCall(r10);
        goto L14
    L18:
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public <EVENT> void register(Callback<EVENT> r10) {
        register(false, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <EVENT> void register(boolean r10, Callback<EVENT> r11) {
        if (r11 != 0) goto L4;
        return;
    L4:
        Type r12 = ((ParameterizedType) r11.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
        Object r13 = this.sLock;
        monitor-enter(r13);
        ValueHolder r14 = this.OBSERVERS_MAP.get(r12);     // Catch: Throwable -> L18
        if (r14 != null) goto L9;
        r14 = new ValueHolder(null);     // Catch: Throwable -> L18
        this.OBSERVERS_MAP.put(r12, r14);     // Catch: Throwable -> L18
    L9:
        r14.put(r11, this.VALUE);     // Catch: Throwable -> L18
        if ((r11 instanceof CallbackWrapper) == false) goto L12;
        this.CALLBACK_WRAPPERS.put((CallbackWrapper) r11, this.VALUE);     // Catch: Throwable -> L18
    L12:
        if (r10 == false) goto L16;
        Object r15 = r14.value;     // Catch: Throwable -> L18
        if (r15 == null) goto L16;
        callbackWhenRegister(r11, r14, r15);     // Catch: Throwable -> L18
    L16:
        monitor-exit(r13);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    @MainThread
    public <EVENT> void unregister(Callback<EVENT> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Type r11 = ((ParameterizedType) r10.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
        Object r12 = this.sLock;
        monitor-enter(r12);
        ValueHolder r13 = this.OBSERVERS_MAP.get(r11);     // Catch: Throwable -> L11
        if (r13 == null) goto L9;
        r13.remove(r10);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r12);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void unregister(Object r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Object r11 = this.sLock;
        monitor-enter(r11);
        Object r12 = null;
        Iterator<CallbackWrapper> r13 = this.CALLBACK_WRAPPERS.keySet().iterator();     // Catch: Throwable -> L17
    L9:
        if (r13.hasNext() == false) goto L13;
        CallbackWrapper r14 = r13.next();     // Catch: Throwable -> L17
        if (r14.getListener() != r10) goto L9;
        r12 = r14;
    L13:
        if (r12 == null) goto L15;
        unregister(r12);     // Catch: Throwable -> L17
        this.CALLBACK_WRAPPERS.remove(r12);     // Catch: Throwable -> L17
    L15:
        monitor-exit(r11);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }
}
