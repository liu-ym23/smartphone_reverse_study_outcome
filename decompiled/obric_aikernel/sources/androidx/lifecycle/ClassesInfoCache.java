package androidx.lifecycle;

import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
final class ClassesInfoCache {
    private static final int CALL_TYPE_NO_ARG = 0;
    private static final int CALL_TYPE_PROVIDER = 1;
    private static final int CALL_TYPE_PROVIDER_WITH_EVENT = 2;
    static ClassesInfoCache sInstance;
    private final Map<Class<?>, CallbackInfo> mCallbackMap;
    private final Map<Class<?>, Boolean> mHasLifecycleMethods;

    @Deprecated
    static class CallbackInfo {
        final Map<Lifecycle.Event, List<MethodReference>> mEventToHandlers;
        final Map<MethodReference, Lifecycle.Event> mHandlerToEvent;

        CallbackInfo(Map<MethodReference, Lifecycle.Event> r10) {
            this.mHandlerToEvent = r10;
            this.mEventToHandlers = new HashMap();
            Iterator<Map.Entry<MethodReference, Lifecycle.Event>> r11 = r10.entrySet().iterator();
        L4:
            if (r11.hasNext() == false) goto L9;
            Map.Entry<MethodReference, Lifecycle.Event> r12 = r11.next();
            Lifecycle.Event r13 = r12.getValue();
            List<MethodReference> r14 = this.mEventToHandlers.get(r13);
            if (r14 != null) goto L8;
            r14 = new ArrayList();
            this.mEventToHandlers.put(r13, r14);
        L8:
            r14.add(r12.getKey());
            goto L4
        }

        private static void invokeMethodsForEvent(List<MethodReference> r10, LifecycleOwner r11, Lifecycle.Event r12, Object r13) {
            if (r10 == null) goto L6;
            int r14 = r10.size() - 1;
        L4:
            if (r14 < 0) goto L8;
            r10.get(r14).invokeCallback(r11, r12, r13);
            r14 = r14 - 1;
            goto L4
        L8:
            return;
        }

        void invokeCallbacks(LifecycleOwner r10, Lifecycle.Event r11, Object r12) {
            invokeMethodsForEvent(this.mEventToHandlers.get(r11), r10, r11, r12);
            invokeMethodsForEvent(this.mEventToHandlers.get(Lifecycle.Event.ON_ANY), r10, r11, r12);
        }
    }

    @Deprecated
    static final class MethodReference {
        final int mCallType;
        final Method mMethod;

        MethodReference(int r10, Method r11) {
            this.mCallType = r10;
            this.mMethod = r11;
            r11.setAccessible(true);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof MethodReference) == true) goto L8;
            return false;
        L8:
            MethodReference r11 = (MethodReference) r10;
            if (this.mCallType != r11.mCallType) goto L14;
            if (this.mMethod.getName().equals(r11.mMethod.getName()) == false) goto L14;
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            return (this.mCallType * 31) + this.mMethod.getName().hashCode();
        }

        void invokeCallback(LifecycleOwner r10, Lifecycle.Event r11, Object r12) {
            int r13 = this.mCallType;     // Catch: IllegalAccessException -> L13 InvocationTargetException -> L16
            if (r13 != 0) goto L5;
            this.mMethod.invoke(r12, new Object[0]);     // Catch: IllegalAccessException -> L13 InvocationTargetException -> L16
            return;
        L5:
            if (r13 != 1) goto L7;
            this.mMethod.invoke(r12, new Object[]{r10});     // Catch: IllegalAccessException -> L13 InvocationTargetException -> L16
            return;
        L7:
            if (r13 != 2) goto L20;
            this.mMethod.invoke(r12, new Object[]{r10, r11});     // Catch: IllegalAccessException -> L13 InvocationTargetException -> L16
            return;
        L20:
            return;
        L13:
            e = move-exception;
            throw new RuntimeException(e);
        L16:
            e = move-exception;
            throw new RuntimeException("Failed to call observer method", e.getCause());
        }
    }

    static {
        sInstance = new ClassesInfoCache();
    }

    ClassesInfoCache() {
        this.mCallbackMap = new HashMap();
        this.mHasLifecycleMethods = new HashMap();
    }

    private CallbackInfo createInfo(Class<?> r12, @Nullable Method[] r13) {
        Class<? super Object> r10 = r12.getSuperclass();
        HashMap r11 = new HashMap();
        if (r10 == null) goto L7;
        CallbackInfo r14 = getInfo(r10);
        if (r14 == null) goto L7;
        r11.putAll(r14.mHandlerToEvent);
    L7:
        Class<?>[] r15 = r12.getInterfaces();
        int r16 = r15.length;
        int r17 = 0;
    L8:
        if (r17 >= r16) goto L14;
        Iterator<Map.Entry<MethodReference, Lifecycle.Event>> r18 = getInfo(r15[r17]).mHandlerToEvent.entrySet().iterator();
    L11:
        if (r18.hasNext() == false) goto L13;
        Map.Entry<MethodReference, Lifecycle.Event> r19 = r18.next();
        verifyAndPutHandler(r11, r19.getKey(), r19.getValue(), r12);
        goto L11
    L13:
        r17 = r17 + 1;
        goto L8
    L14:
        if (r13 != null) goto L17;
        r13 = getDeclaredMethods(r12);
    L17:
        int r20 = r13.length;
        int r21 = 0;
        boolean r22 = false;
    L18:
        if (r21 >= r20) goto L47;
        Method r23 = r13[r21];
        OnLifecycleEvent r24 = (OnLifecycleEvent) r23.getAnnotation(OnLifecycleEvent.class);
        if (r24 == null) goto L44;
        Class<?>[] r25 = r23.getParameterTypes();
        if (r25.length > 0) goto L25;
        int r26 = 0;
    L30:
        Lifecycle.Event r27 = r24.value();
        if (r25.length <= 1) goto L42;
        if (Lifecycle.Event.class.isAssignableFrom(r25[1]) == false) goto L40;
        if (r27 != Lifecycle.Event.ON_ANY) goto L38;
        r26 = 2;
        goto L42
    L38:
        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
    L40:
        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
    L42:
        if (r25.length > 2) goto L46;
        verifyAndPutHandler(r11, new MethodReference(r26, r23), r27, r12);
        r22 = true;
        goto L44
    L46:
        throw new IllegalArgumentException("cannot have more than 2 params");
    L25:
        if (LifecycleOwner.class.isAssignableFrom(r25[0]) == false) goto L28;
        r26 = 1;
        goto L30
    L28:
        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
    L44:
        r21 = r21 + 1;
        goto L18
    L47:
        CallbackInfo r110 = new CallbackInfo(r11);
        this.mCallbackMap.put(r12, r110);
        this.mHasLifecycleMethods.put(r12, Boolean.valueOf(r22));
        return r110;
    }

    private Method[] getDeclaredMethods(Class<?> r10) {
        return r10.getDeclaredMethods();
    L4:
        e = move-exception;
        throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
    }

    private void verifyAndPutHandler(Map<MethodReference, Lifecycle.Event> r10, MethodReference r11, Lifecycle.Event r12, Class<?> r13) {
        Lifecycle.Event r14 = r10.get(r11);
        if (r14 == null) goto L8;
        if (r12 == r14) goto L8;
        throw new IllegalArgumentException("Method " + r11.mMethod.getName() + " in " + r13.getName() + " already declared with different @OnLifecycleEvent value: previous value " + r14 + ", new value " + r12);
    L8:
        if (r14 != null) goto L11;
        r10.put(r11, r12);
        return;
    }

    CallbackInfo getInfo(Class<?> r10) {
        CallbackInfo r11 = this.mCallbackMap.get(r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        return createInfo(r10, null);
    }

    boolean hasLifecycleMethods(Class<?> r10) {
        Boolean r11 = this.mHasLifecycleMethods.get(r10);
        if (r11 != null) goto L5;
        Method[] r12 = getDeclaredMethods(r10);
        int r13 = r12.length;
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L13;
        if (((OnLifecycleEvent) r12[r14].getAnnotation(OnLifecycleEvent.class)) != null) goto L10;
        r14 = r14 + 1;
        goto L7
    L10:
        createInfo(r10, r12);
        return true;
    L13:
        this.mHasLifecycleMethods.put(r10, Boolean.FALSE);
        return false;
    L5:
        return r11.booleanValue();
    }
}
