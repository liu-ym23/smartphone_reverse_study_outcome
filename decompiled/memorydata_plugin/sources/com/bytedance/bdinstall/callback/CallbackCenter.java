package com.bytedance.bdinstall.callback;

import android.os.Looper;
import com.bytedance.bdinstall.ExecutorUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class CallbackCenter {
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

        /* synthetic */ ValueHolder(AnonymousClass1 r1) {
            this();
        }

        public boolean isEmpty() {
            return this.callbacks.isEmpty();
        }

        Set<Callback> keySet() {
            return this.callbacks.keySet();
        }

        public void put(Callback r3, Object r4) {
            Callback r5 = (Callback) ZeusTransformUtils.wrapperContextForParams(r3, Callback.class, "com.obric.memorydata.plugin");
            this.callbacks.put(r5, r4);
        }

        void remove(Callback r3) {
            Callback r4 = (Callback) ZeusTransformUtils.wrapperContextForParams(r3, Callback.class, "com.obric.memorydata.plugin");
            this.callbacks.remove(r4);
        }
    }

    public CallbackCenter() {
        this.sLock = new Object();
        this.VALUE = new Object();
        this.OBSERVERS_MAP = new ConcurrentHashMap();
        this.CALLBACK_WRAPPERS = new ConcurrentHashMap();
        this.mAid = null;
    }

    private <EVENT> void callbackWhenRegister(Callback<EVENT> r3, final ValueHolder r4, final Object r5) {
        final Callback r6 = (Callback) ZeusTransformUtils.wrapperContextForParams(r3, Callback.class, "com.obric.memorydata.plugin");
        ExecutorUtil.runOnHandlerThread(this.mAid, new AnonymousClass1(this, r4, r6, r5));
    }

    public void init(String r1) {
        this.mAid = r1;
    }

    public <Event> void postEvent(final Event r5) {
        if (Looper.myLooper() == ExecutorUtil.getLooper(this.mAid)) goto L6;
        ExecutorUtil.runOnHandlerThread(this.mAid, new AnonymousClass2(this, r5));
        return;
    L6:
        Object r0 = this.sLock;
        monitor-enter(r0);
        ValueHolder r1 = (ValueHolder) ZeusTransformUtils.preCheckCast(this.OBSERVERS_MAP.get(r5.getClass()), ValueHolder.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        if (r1 != null) goto L11;
        r1 = new ValueHolder(null);     // Catch: Throwable -> L19
        this.OBSERVERS_MAP.put(r5.getClass(), r1);     // Catch: Throwable -> L19
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L19
        r1.value = r5;
        Iterator<Callback> r4 = r1.keySet().iterator();
    L14:
        if (r4.hasNext() == false) goto L18;
        Callback r2 = (Callback) ZeusTransformUtils.preCheckCast(r4.next(), Callback.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L14;
        r2.onCall(r5);
        goto L14
    L18:
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public <EVENT> void register(Callback<EVENT> r3) {
        register(false, (Callback) ZeusTransformUtils.wrapperContextForParams(r3, Callback.class, "com.obric.memorydata.plugin"));
    }

    public <EVENT> void register(boolean r6, Callback<EVENT> r7) {
        Callback<EVENT> r8 = (Callback) ZeusTransformUtils.wrapperContextForParams(r7, Callback.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L5;
        return;
    L5:
        Type r0 = ((ParameterizedType) ZeusTransformUtils.preCheckCast(r8.getClass().getGenericInterfaces()[0], ParameterizedType.class, "com.obric.memorydata.plugin")).getActualTypeArguments()[0];
        Object r1 = this.sLock;
        monitor-enter(r1);
        ValueHolder r2 = (ValueHolder) ZeusTransformUtils.preCheckCast(this.OBSERVERS_MAP.get(r0), ValueHolder.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        if (r2 != null) goto L10;
        r2 = new ValueHolder(null);     // Catch: Throwable -> L19
        this.OBSERVERS_MAP.put(r0, r2);     // Catch: Throwable -> L19
    L10:
        r2.put(r8, this.VALUE);     // Catch: Throwable -> L19
        if (ZeusTransformUtils.instanceOf(r8, CallbackWrapper.class) == false) goto L13;
        this.CALLBACK_WRAPPERS.put((CallbackWrapper) ZeusTransformUtils.preCheckCast(r8, CallbackWrapper.class, "com.obric.memorydata.plugin"), this.VALUE);     // Catch: Throwable -> L19
    L13:
        if (r6 == true) goto L15;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L19
        return;
    L15:
        if (r2.value == null) goto L17;
        callbackWhenRegister(r8, r2, r2.value);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public <EVENT> void unregister(Callback<EVENT> r5) {
        Callback r6 = (Callback) ZeusTransformUtils.wrapperContextForParams(r5, Callback.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        Type r0 = ((ParameterizedType) ZeusTransformUtils.preCheckCast(r6.getClass().getGenericInterfaces()[0], ParameterizedType.class, "com.obric.memorydata.plugin")).getActualTypeArguments()[0];
        Object r1 = this.sLock;
        monitor-enter(r1);
        ValueHolder r4 = (ValueHolder) ZeusTransformUtils.preCheckCast(this.OBSERVERS_MAP.get(r0), ValueHolder.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r4 == null) goto L10;
        r4.remove(r6);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void unregister(Object r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        Object r0 = this.sLock;
        monitor-enter(r0);
        Object r1 = null;
        Iterator<CallbackWrapper> r2 = this.CALLBACK_WRAPPERS.keySet().iterator();     // Catch: Throwable -> L17
    L9:
        if (r2.hasNext() == false) goto L13;
        CallbackWrapper r3 = (CallbackWrapper) ZeusTransformUtils.preCheckCast(r2.next(), CallbackWrapper.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r3.getListener() != r7) goto L9;
        r1 = r3;
    L13:
        if (r1 == null) goto L15;
        unregister(r1);     // Catch: Throwable -> L17
        this.CALLBACK_WRAPPERS.remove(r1);     // Catch: Throwable -> L17
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }
}
