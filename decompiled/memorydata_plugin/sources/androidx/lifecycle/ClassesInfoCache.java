package androidx.lifecycle;

import com.volcengine.zeus.transform.ZeusTransformUtils;
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

        CallbackInfo(Map<MethodReference, Lifecycle.Event> r6) {
            Map<MethodReference, Lifecycle.Event> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
            this.mHandlerToEvent = r7;
            this.mEventToHandlers = new HashMap();
            Iterator<Map.Entry<MethodReference, Lifecycle.Event>> r8 = r7.entrySet().iterator();
        L4:
            if (r8.hasNext() == false) goto L9;
            Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            Lifecycle.Event r2 = (Lifecycle.Event) ZeusTransformUtils.preCheckCast(r0.getValue(), Lifecycle.Event.class, "com.obric.memorydata.plugin");
            List<MethodReference> r3 = (List) ZeusTransformUtils.preCheckCast(this.mEventToHandlers.get(r2), List.class, "com.obric.memorydata.plugin");
            if (r3 != null) goto L8;
            r3 = new ArrayList();
            this.mEventToHandlers.put(r2, r3);
        L8:
            r3.add((MethodReference) ZeusTransformUtils.preCheckCast(r0.getKey(), MethodReference.class, "com.obric.memorydata.plugin"));
            goto L4
        }

        private static void invokeMethodsForEvent(List<MethodReference> r4, LifecycleOwner r5, Lifecycle.Event r6, Object r7) {
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            LifecycleOwner r9 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r5, LifecycleOwner.class, "com.obric.memorydata.plugin");
            if (r8 == null) goto L7;
            int r0 = r8.size() - 1;
        L5:
            if (r0 < 0) goto L9;
            ((MethodReference) ZeusTransformUtils.preCheckCast(r8.get(r0), MethodReference.class, "com.obric.memorydata.plugin")).invokeCallback(r9, r6, r7);
            r0 = r0 - 1;
            goto L5
        L9:
            return;
        }

        void invokeCallbacks(LifecycleOwner r4, Lifecycle.Event r5, Object r6) {
            LifecycleOwner r7 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r4, LifecycleOwner.class, "com.obric.memorydata.plugin");
            invokeMethodsForEvent((List) ZeusTransformUtils.preCheckCast(this.mEventToHandlers.get(r5), List.class, "com.obric.memorydata.plugin"), r7, r5, r6);
            invokeMethodsForEvent((List) ZeusTransformUtils.preCheckCast(this.mEventToHandlers.get(Lifecycle.Event.ON_ANY), List.class, "com.obric.memorydata.plugin"), r7, r5, r6);
        }
    }

    @Deprecated
    static final class MethodReference {
        final int mCallType;
        final Method mMethod;

        MethodReference(int r1, Method r2) {
            this.mCallType = r1;
            this.mMethod = r2;
            r2.setAccessible(true);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, MethodReference.class) == true) goto L8;
            return false;
        L8:
            MethodReference r6 = (MethodReference) ZeusTransformUtils.preCheckCast(r5, MethodReference.class, "com.obric.memorydata.plugin");
            if (this.mCallType != r6.mCallType) goto L14;
            if (this.mMethod.getName().equals(r6.mMethod.getName()) == false) goto L14;
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            return (this.mCallType * 31) + this.mMethod.getName().hashCode();
        }

        void invokeCallback(LifecycleOwner r5, Lifecycle.Event r6, Object r7) {
            LifecycleOwner r8 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r5, LifecycleOwner.class, "com.obric.memorydata.plugin");
            int r0 = this.mCallType;     // Catch: IllegalAccessException -> L14 InvocationTargetException -> L17
            if (r0 != 0) goto L6;
            this.mMethod.invoke(r7, new Object[0]);     // Catch: IllegalAccessException -> L14 InvocationTargetException -> L17
            return;
        L6:
            if (r0 != 1) goto L8;
            this.mMethod.invoke(r7, new Object[]{r8});     // Catch: IllegalAccessException -> L14 InvocationTargetException -> L17
            return;
        L8:
            if (r0 != 2) goto L21;
            this.mMethod.invoke(r7, new Object[]{r8, r6});     // Catch: IllegalAccessException -> L14 InvocationTargetException -> L17
            return;
        L21:
            return;
        L14:
            e = move-exception;
            throw new RuntimeException(e);
        L17:
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

    private CallbackInfo createInfo(Class<?> r13, Method[] r14) {
        Class<? super Object> r0 = r13.getSuperclass();
        HashMap r1 = new HashMap();
        if (r0 == null) goto L7;
        CallbackInfo r2 = getInfo(r0);
        if (r2 == null) goto L7;
        r1.putAll(r2.mHandlerToEvent);
    L7:
        Class<?>[] r3 = r13.getInterfaces();
        int r4 = r3.length;
        int r5 = 0;
    L9:
        if (r5 >= r4) goto L15;
        Iterator<Map.Entry<MethodReference, Lifecycle.Event>> r6 = getInfo(r3[r5]).mHandlerToEvent.entrySet().iterator();
    L12:
        if (r6.hasNext() == false) goto L14;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        verifyAndPutHandler(r1, (MethodReference) ZeusTransformUtils.preCheckCast(r7.getKey(), MethodReference.class, "com.obric.memorydata.plugin"), (Lifecycle.Event) ZeusTransformUtils.preCheckCast(r7.getValue(), Lifecycle.Event.class, "com.obric.memorydata.plugin"), r13);
        goto L12
    L14:
        r5 = r5 + 1;
        goto L9
    L15:
        if (r14 != null) goto L18;
        r14 = getDeclaredMethods(r13);
    L18:
        int r8 = r14.length;
        int r9 = 0;
        boolean r10 = false;
    L19:
        if (r9 >= r8) goto L48;
        Method r11 = r14[r9];
        OnLifecycleEvent r12 = (OnLifecycleEvent) ZeusTransformUtils.preCheckCast(r11.getAnnotation(OnLifecycleEvent.class), OnLifecycleEvent.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L45;
        Class<?>[] r15 = r11.getParameterTypes();
        if (r15.length > 0) goto L26;
        int r16 = 0;
    L31:
        Lifecycle.Event r17 = r12.value();
        if (r15.length <= 1) goto L43;
        if (Lifecycle.Event.class.isAssignableFrom(r15[1]) == false) goto L41;
        if (r17 != Lifecycle.Event.ON_ANY) goto L39;
        r16 = 2;
        goto L43
    L39:
        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
    L41:
        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
    L43:
        if (r15.length > 2) goto L47;
        verifyAndPutHandler(r1, new MethodReference(r16, r11), r17, r13);
        r10 = true;
        goto L45
    L47:
        throw new IllegalArgumentException("cannot have more than 2 params");
    L26:
        if (LifecycleOwner.class.isAssignableFrom(r15[0]) == false) goto L29;
        r16 = 1;
        goto L31
    L29:
        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
    L45:
        r9 = r9 + 1;
        goto L19
    L48:
        CallbackInfo r18 = new CallbackInfo(r1);
        this.mCallbackMap.put(r13, r18);
        this.mHasLifecycleMethods.put(r13, Boolean.valueOf(r10));
        return r18;
    }

    private Method[] getDeclaredMethods(Class<?> r2) {
        return r2.getDeclaredMethods();
    L4:
        e = move-exception;
        throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
    }

    private void verifyAndPutHandler(Map<MethodReference, Lifecycle.Event> r3, MethodReference r4, Lifecycle.Event r5, Class<?> r6) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Lifecycle.Event r7 = (Lifecycle.Event) ZeusTransformUtils.preCheckCast(r2.get(r4), Lifecycle.Event.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L8;
        if (r5 == r7) goto L8;
        throw new IllegalArgumentException("Method " + r4.mMethod.getName() + " in " + r6.getName() + " already declared with different @OnLifecycleEvent value: previous value " + r7 + ", new value " + r5);
    L8:
        if (r7 != null) goto L11;
        r2.put(r4, r5);
        return;
    }

    CallbackInfo getInfo(Class<?> r4) {
        CallbackInfo r0 = (CallbackInfo) ZeusTransformUtils.preCheckCast(this.mCallbackMap.get(r4), CallbackInfo.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        return createInfo(r4, null);
    }

    boolean hasLifecycleMethods(Class<?> r8) {
        Boolean r0 = (Boolean) ZeusTransformUtils.preCheckCast(this.mHasLifecycleMethods.get(r8), Boolean.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        Method[] r1 = getDeclaredMethods(r8);
        int r2 = r1.length;
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L13;
        if (((OnLifecycleEvent) ZeusTransformUtils.preCheckCast(r1[r4].getAnnotation(OnLifecycleEvent.class), OnLifecycleEvent.class, "com.obric.memorydata.plugin")) != null) goto L10;
        r4 = r4 + 1;
        goto L7
    L10:
        createInfo(r8, r1);
        return true;
    L13:
        this.mHasLifecycleMethods.put(r8, false);
        return false;
    L5:
        return r0.booleanValue();
    }
}
