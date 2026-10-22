package com.larksuite.framework.callback;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class CallbackManager {
    private List<ICancelableCallback> callBackList;
    private boolean isCanceled;
    private final Object isCanceledLock;

    public static class CallbackInvocationHandler<T extends ICallback> implements InvocationHandler {
        private boolean isICancelableExisted;
        private T realCallback;

        private void cancel() {
            this.realCallback = null;
        }

        private boolean isCanceled() {
            if (this.realCallback != null) goto L5;
            return true;
        L5:
            return false;
        }

        public CallbackInvocationHandler(T r1, boolean r2) {
            this.realCallback = r1;
            this.isICancelableExisted = r2;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r5, Method r6, Object[] r7) throws Throwable {
            boolean r1 = false;
            if (isCanceled() == false) goto L56;
            Class<?> r8 = r6.getReturnType();
            if (r8 != null) goto L8;
            return null;
        L8:
            if (r8 == Boolean.TYPE) goto L54;
            if (r8 == Boolean.class) goto L54;
            if (r8 == Byte.TYPE) goto L87;
            if (r8 == Byte.class) goto L87;
            if (r8 == Character.TYPE) goto L86;
            if (r8 == Character.class) goto L86;
            if (r8 == Short.TYPE) goto L85;
            if (r8 == Short.class) goto L85;
            if (r8 == Integer.TYPE) goto L84;
            if (r8 == Integer.class) goto L84;
            if (r8 == Long.TYPE) goto L83;
            if (r8 == Long.class) goto L83;
            if (r8 == Float.TYPE) goto L82;
            if (r8 == Float.class) goto L82;
            if (r8 == Double.TYPE) goto L81;
            if (r8 == Double.class) goto L81;
            return null;
        L81:
            return Double.valueOf(0.0d);
        L82:
            return Float.valueOf(0.0f);
        L83:
            return 0L;
        L84:
            return 0;
        L85:
            return (short) 0;
        L86:
            return (char) 0;
        L87:
            return (byte) 0;
        L54:
            return Boolean.FALSE;
        L56:
            if (r6.equals(ICancelable.class.getMethod("cancel", new Class[0])) == false) goto L63;
            T r9 = this.realCallback;
            cancel();
            if (this.isICancelableExisted == true) goto L60;
            return null;
        L60:
            return r6.invoke(r9, r7);
        L63:
            if (r6.equals(ICancelable.class.getMethod("isCanceled", new Class[0])) == true) goto L65;
            T r10 = this.realCallback;
            if (r10 != null) goto L78;
            return null;
        L78:
            return r6.invoke(r10, r7);
        L65:
            if (this.isICancelableExisted == false) goto L74;
            if (isCanceled() == false) goto L69;
        L70:
            r1 = true;
        L72:
            return Boolean.valueOf(r1);
        L69:
            if (((Boolean) r6.invoke(this.realCallback, r7)).booleanValue() == false) goto L72;
        L74:
            return Boolean.valueOf(isCanceled());
        }
    }

    public void cancelCallbacks() {
        Object r0 = this.isCanceledLock;
        monitor-enter(r0);
        this.isCanceled = true;     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        Iterator<ICancelableCallback> r1 = this.callBackList.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        ICancelableCallback r2 = r1.next();
        if (r2 == null) goto L9;
        r2.cancel();
        goto L9
    L13:
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public CallbackManager() {
        this.isCanceledLock = new Object();
        this.callBackList = new ArrayList();
    }

    private <Data> UIGetDataCallback<Data> wrapGetDataCallback(IGetDataCallback<Data> r2) {
        return new UIGetDataCallback(r2);
    }

    public <T extends ICancelableCallback> void addCancelableCallback(T r3) {
        Object r0 = this.isCanceledLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.isCanceled == true) goto L7;
        this.callBackList.add(r3);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L7:
        r3.cancel();     // Catch: Throwable -> L10
        goto L8
    }

    public <T extends ICallback> T wrapAndAddCallback(T r2) {
        ICancelableCallback r3 = (T) wrapCallback(r2);
        addCancelableCallback(r3);
        return r3;
    }

    public <Data> UIGetDataCallback<Data> wrapAndAddGetDataCallback(IGetDataCallback<Data> r1) {
        UIGetDataCallback<Data> r2 = wrapGetDataCallback(r1);
        addCancelableCallback(r2);
        return r2;
    }

    public <T extends ICallback> T wrapCallback(T r10) {
        if (r10 != null) goto L23;
        return null;
    L23:
        Class<?> r1 = r10.getClass();     // Catch: Throwable -> L22
        Class<?>[] r2 = r1.getInterfaces();     // Catch: Throwable -> L22
        int r3 = 0;
        boolean r4 = false;
        boolean r5 = false;
    L7:
        if (r3 >= r2.length) goto L12;
        if (ICancelableCallback.class.equals(r2[r3]) == false) goto L11;
        r4 = true;
        r5 = true;
    L11:
        r3 = r3 + 1;     // Catch: Throwable -> L22
        goto L7
    L12:
        if (r4 == false) goto L14;
    L16:
        if (r4 == true) goto L19;
        r2 = (Class[]) Arrays.copyOf(r2, r2.length + 1);     // Catch: Throwable -> L22
        r2[r2.length - 1] = ICancelableCallback.class;     // Catch: Throwable -> L22
    L19:
        return (T) Proxy.newProxyInstance(r1.getClassLoader(), r2, new CallbackInvocationHandler(r10, r5));
    L14:
        if (ICancelable.class.isAssignableFrom(r1) == false) goto L16;
        r5 = true;
    L28:
        return null;
    }
}
