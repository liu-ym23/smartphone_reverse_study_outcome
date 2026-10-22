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
    public static class CallbackInfo {
        final Map<Lifecycle.Event, List<MethodReference>> mEventToHandlers;
        final Map<MethodReference, Lifecycle.Event> mHandlerToEvent;

        public CallbackInfo(Map<MethodReference, Lifecycle.Event> r5) {
            this.mHandlerToEvent = r5;
            this.mEventToHandlers = new HashMap();
            Iterator<Map.Entry<MethodReference, Lifecycle.Event>> r10 = r5.entrySet().iterator();
        L4:
            if (r10.hasNext() == false) goto L9;
            Map.Entry<MethodReference, Lifecycle.Event> r11 = r10.next();
            Lifecycle.Event r12 = r11.getValue();
            List<MethodReference> r13 = this.mEventToHandlers.get(r12);
            if (r13 != null) goto L8;
            r13 = new ArrayList();
            this.mEventToHandlers.put(r12, r13);
        L8:
            r13.add(r11.getKey());
            goto L4
        }

        private static void invokeMethodsForEvent(List<MethodReference> r5, LifecycleOwner r10, Lifecycle.Event r11, Object r12) {
            if (r5 == null) goto L6;
            int r13 = r5.size() - 1;
        L4:
            if (r13 < 0) goto L8;
            r5.get(r13).invokeCallback(r10, r11, r12);
            r13 = r13 - 1;
            goto L4
        L8:
            return;
        }

        public void invokeCallbacks(LifecycleOwner r5, Lifecycle.Event r10, Object r11) {
            invokeMethodsForEvent(this.mEventToHandlers.get(r10), r5, r10, r11);
            invokeMethodsForEvent(this.mEventToHandlers.get(Lifecycle.Event.ON_ANY), r5, r10, r11);
        }
    }

    @Deprecated
    public static final class MethodReference {
        final int mCallType;
        final Method mMethod;

        public MethodReference(int r5, Method r10) {
            this.mCallType = r5;
            this.mMethod = r10;
            r10.setAccessible(true);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof MethodReference) == true) goto L8;
            return false;
        L8:
            MethodReference r10 = (MethodReference) r5;
            if (this.mCallType != r10.mCallType) goto L14;
            if (this.mMethod.getName().equals(r10.mMethod.getName()) == false) goto L14;
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            int r5 = this.mCallType * 31;
            return this.mMethod.getName().hashCode() + r5;
        }

        public void invokeCallback(LifecycleOwner r5, Lifecycle.Event r10, Object r11) {
            int r12 = this.mCallType;     // Catch: IllegalAccessException -> L10 InvocationTargetException -> L12
            if (r12 != 0) goto L5;
            this.mMethod.invoke(r11, null);     // Catch: IllegalAccessException -> L10 InvocationTargetException -> L12
            return;
        L5:
            if (r12 != 1) goto L7;
            this.mMethod.invoke(r11, new Object[]{r5});     // Catch: IllegalAccessException -> L10 InvocationTargetException -> L12
            return;
        L7:
            if (r12 != 2) goto L22;
            this.mMethod.invoke(r11, new Object[]{r5, r10});     // Catch: IllegalAccessException -> L10 InvocationTargetException -> L12
            return;
        L22:
            return;
        L10:
            e = move-exception;
            throw new RuntimeException(e);
        L12:
            e = move-exception;
            throw new RuntimeException("Failed to call observer method", e.getCause());
        }
    }

    static {
        sInstance = new ClassesInfoCache();
    }

    public ClassesInfoCache() {
        this.mCallbackMap = new HashMap();
        this.mHasLifecycleMethods = new HashMap();
    }

    private CallbackInfo createInfo(Class<?> r12, @Nullable Method[] r13) {
        Class<?> r5 = r12.getSuperclass();
        HashMap r10 = new HashMap();
        if (r5 == null) goto L7;
        CallbackInfo r11 = getInfo(r5);
        if (r11 == null) goto L7;
        r10.putAll(r11.mHandlerToEvent);
    L7:
        Class<?>[] r14 = r12.getInterfaces();
        int r15 = r14.length;
        int r16 = 0;
    L8:
        if (r16 >= r15) goto L14;
        Iterator<Map.Entry<MethodReference, Lifecycle.Event>> r17 = getInfo(r14[r16]).mHandlerToEvent.entrySet().iterator();
    L11:
        if (r17.hasNext() == false) goto L13;
        Map.Entry<MethodReference, Lifecycle.Event> r18 = r17.next();
        verifyAndPutHandler(r10, r18.getKey(), r18.getValue(), r12);
        goto L11
    L13:
        r16 = r16 + 1;
        goto L8
    L14:
        if (r13 != null) goto L17;
        r13 = getDeclaredMethods(r12);
    L17:
        int r19 = r13.length;
        int r20 = 0;
        boolean r21 = false;
    L18:
        if (r20 >= r19) goto L47;
        Method r22 = r13[r20];
        OnLifecycleEvent r23 = (OnLifecycleEvent) r22.getAnnotation(OnLifecycleEvent.class);
        if (r23 == null) goto L44;
        Class<?>[] r24 = r22.getParameterTypes();
        if (r24.length > 0) goto L25;
        int r25 = 0;
    L30:
        Lifecycle.Event r26 = r23.value();
        if (r24.length <= 1) goto L42;
        if (Lifecycle.Event.class.isAssignableFrom(r24[1]) == false) goto L40;
        if (r26 != Lifecycle.Event.ON_ANY) goto L38;
        r25 = 2;
        goto L42
    L38:
        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
    L40:
        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
    L42:
        if (r24.length > 2) goto L46;
        verifyAndPutHandler(r10, new MethodReference(r25, r22), r26, r12);
        r21 = true;
        goto L44
    L46:
        throw new IllegalArgumentException("cannot have more than 2 params");
    L25:
        if (LifecycleOwner.class.isAssignableFrom(r24[0]) == false) goto L28;
        r25 = 1;
        goto L30
    L28:
        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
    L44:
        r20 = r20 + 1;
        goto L18
    L47:
        CallbackInfo r110 = new CallbackInfo(r10);
        this.mCallbackMap.put(r12, r110);
        this.mHasLifecycleMethods.put(r12, Boolean.valueOf(r21));
        return r110;
    }

    private Method[] getDeclaredMethods(Class<?> r5) {
        return r5.getDeclaredMethods();
    L4:
        e = move-exception;
        throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
    }

    private void verifyAndPutHandler(Map<MethodReference, Lifecycle.Event> r5, MethodReference r10, Lifecycle.Event r11, Class<?> r12) {
        Lifecycle.Event r13 = r5.get(r10);
        if (r13 == null) goto L8;
        if (r11 == r13) goto L8;
        throw new IllegalArgumentException("Method " + r10.mMethod.getName() + " in " + r12.getName() + " already declared with different @OnLifecycleEvent value: previous value " + r13 + ", new value " + r11);
    L8:
        if (r13 != null) goto L11;
        r5.put(r10, r11);
        return;
    }

    public CallbackInfo getInfo(Class<?> r5) {
        CallbackInfo r10 = this.mCallbackMap.get(r5);
        if (r10 == null) goto L6;
        return r10;
    L6:
        return createInfo(r5, null);
    }

    public boolean hasLifecycleMethods(Class<?> r10) {
        Boolean r5 = this.mHasLifecycleMethods.get(r10);
        if (r5 != null) goto L5;
        Method[] r11 = getDeclaredMethods(r10);
        int r12 = r11.length;
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L13;
        if (((OnLifecycleEvent) r11[r13].getAnnotation(OnLifecycleEvent.class)) != null) goto L10;
        r13 = r13 + 1;
        goto L7
    L10:
        createInfo(r10, r11);
        return true;
    L13:
        this.mHasLifecycleMethods.put(r10, Boolean.FALSE);
        return false;
    L5:
        return r5.booleanValue();
    }
}
