package com.bytedance.crash.terminate;

import com.bytedance.crash.util.NpthLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class JavaCalls {
    private static final String LOG_TAG = "JavaCalls";
    private static final Map<Class<?>, Class<?>> PRIMITIVE_MAP = null;

    public static class JavaParam<T> {
        final Class<? extends T> clazz;
        final T obj;

        public JavaParam(Class<? extends T> r10, T r11) {
            this.clazz = r10;
            this.obj = r11;
        }
    }

    static {
        HashMap r10 = new HashMap();
        PRIMITIVE_MAP = r10;
        Class r11 = Boolean.TYPE;
        r10.put(Boolean.class, r11);
        r10.put(Byte.class, Byte.TYPE);
        r10.put(Character.class, Character.TYPE);
        r10.put(Short.class, Short.TYPE);
        Class r12 = Integer.TYPE;
        r10.put(Integer.class, r12);
        Class r13 = Float.TYPE;
        r10.put(Float.class, r13);
        Class r14 = Long.TYPE;
        r10.put(Long.class, r14);
        r10.put(Double.class, Double.TYPE);
        r10.put(r11, r11);
        Class r15 = Byte.TYPE;
        r10.put(r15, r15);
        Class r16 = Character.TYPE;
        r10.put(r16, r16);
        Class r17 = Short.TYPE;
        r10.put(r17, r17);
        r10.put(r12, r12);
        r10.put(r13, r13);
        r10.put(r14, r14);
        Class r18 = Double.TYPE;
        r10.put(r18, r18);
    }

    public JavaCalls() {
    }

    public static <T> T callMethod(Object r10, String r11, Object... r12) {
        return (T) callMethodOrThrow(r10, r11, r12);
    L4:
        e = move-exception;
        NpthLog.w(LOG_TAG, "Meet exception when call Method '" + r11 + "' in " + r10, e);
        return null;
    }

    private static <T> T callMethodOrThrow(Object r10, String r11, Object... r12) {
        return (T) getDeclaredMethod(r10.getClass(), r11, getParameterTypes(r12)).invoke(r10, getParameters(r12));
    }

    public static <T> T callStaticMethod(String r10, String r11, Object... r12) {
        return (T) callStaticMethodOrThrow(Class.forName(r10), r11, r12);
    L4:
        e = move-exception;
        NpthLog.w(LOG_TAG, "Meet exception when call Method '" + r11 + "' in " + r10, e);
        return null;
    }

    private static <T> T callStaticMethodOrThrow(Class<?> r10, String r11, Object... r12) {
        return (T) getDeclaredMethod(r10, r11, getParameterTypes(r12)).invoke(null, getParameters(r12));
    }

    public static <T> T callStaticMethodOrThrow(String r10, String r11, Object... r12) {
        return (T) getDeclaredMethod(Class.forName(r10), r11, getParameterTypes(r12)).invoke(null, getParameters(r12));
    }

    private static boolean compareClassLists(Class<?>[] r10, Class<?>[] r11) {
        if (r10 != null) goto L10;
        if (r11 != null) goto L6;
        return true;
    L6:
        if (r11.length != 0) goto L9;
        return true;
    L9:
        return false;
    L10:
        if (r11 != null) goto L17;
        if (r10.length != 0) goto L15;
        return true;
    L15:
        return false;
    L17:
        if (r10.length == r11.length) goto L19;
        return false;
    L19:
        int r12 = 0;
    L21:
        if (r12 >= r10.length) goto L30;
        if (r10[r12].isAssignableFrom(r11[r12]) == true) goto L29;
        Map<Class<?>, Class<?>> r13 = PRIMITIVE_MAP;
        if (r13.containsKey(r10[r12]) == false) goto L28;
        if (r13.get(r10[r12]).equals(r13.get(r11[r12])) == true) goto L29;
    L28:
        return false;
    L29:
        r12 = r12 + 1;
        goto L21
    L30:
        return true;
    }

    private static Method findMethodByName(Method[] r10, String r11, Class<?>[] r12) {
        Objects.requireNonNull(r11, "Method name must not be null.");
        int r13 = r10.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L10;
        Method r15 = r10[r14];
        if (r15.getName().equals(r11) == false) goto L9;
        if (compareClassLists(r15.getParameterTypes(), r12) == false) goto L9;
        return r15;
    L9:
        r14 = r14 + 1;
        goto L3
    L10:
        return null;
    }

    private static Method getDeclaredMethod(Class<?> r10, String r11, Class<?>... r12) {
        Method r13 = r10.getDeclaredMethod(r11, r12);     // Catch: Throwable -> L8 NoSuchMethodException -> L10
        if (r13 == null) goto L7;
        r13.setAccessible(true);
        return r13;
    L7:
        throw new NoSuchMethodException();
    L11:
        if (r10.getSuperclass() == null) goto L15;
        return getDeclaredMethod(r10.getSuperclass(), r11, r12);
    L15:
        throw new NoSuchMethodException();
    L9:
        throw new NoSuchMethodException();
    }

    private static Object getDefaultValue(Class<?> r10) {
        if (Integer.TYPE.equals(r10) == true) goto L44;
        if (Integer.class.equals(r10) == true) goto L44;
        if (Byte.TYPE.equals(r10) == true) goto L44;
        if (Byte.class.equals(r10) == true) goto L44;
        if (Short.TYPE.equals(r10) == true) goto L44;
        if (Short.class.equals(r10) == true) goto L44;
        if (Long.TYPE.equals(r10) == true) goto L44;
        if (Long.class.equals(r10) == true) goto L44;
        if (Double.TYPE.equals(r10) == true) goto L44;
        if (Double.class.equals(r10) == true) goto L44;
        if (Float.TYPE.equals(r10) == true) goto L44;
        if (Float.class.equals(r10) == true) goto L44;
        if (Boolean.TYPE.equals(r10) == true) goto L42;
        if (Boolean.class.equals(r10) == true) goto L42;
        if (Character.TYPE.equals(r10) == true) goto L40;
        if (Character.class.equals(r10) == true) goto L40;
        return null;
    L40:
        return (char) 0;
    L42:
        return Boolean.FALSE;
    L44:
        return 0;
    }

    public static <T> T getField(Object r10, String r11) {
        return (T) getFieldOrThrow(r10, r11);
    L4:
        return null;
    }

    private static <T> T getFieldOrThrow(Object r10, String r11) {
        Class<?> r12 = r10.getClass();
        Field r13 = null;
    L4:
        if (r13 != null) goto L12;
        r13 = r12.getDeclaredField(r11);     // Catch: NoSuchFieldException -> L7
        r13.setAccessible(true);     // Catch: NoSuchFieldException -> L7
    L8:
        if (r12 != null) goto L4;
        throw new NoSuchFieldException();
    L7:
        r12 = r12.getSuperclass();
        goto L8
    L12:
        r13.setAccessible(true);
        return (T) r13.get(r10);
    }

    private static Class<?>[] getParameterTypes(Object... r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.length <= 0) goto L25;
        Class<?>[] r11 = new Class[r10.length];
        int r12 = 0;
    L8:
        if (r12 >= r10.length) goto L20;
        Object r13 = r10[r12];
        if (r13 != null) goto L12;
    L14:
        if (r13 != null) goto L16;
        Class<?> r14 = null;
    L17:
        r11[r12] = r14;
    L18:
        r12 = r12 + 1;
        goto L8
    L16:
        r14 = r13.getClass();
        goto L17
    L12:
        if ((r13 instanceof JavaParam) == false) goto L14;
        r11[r12] = ((JavaParam) r13).clazz;
        goto L18
    L20:
        return r11;
    L25:
        return null;
    }

    private static Object[] getParameters(Object... r10) {
        if (r10 != null) goto L4;
    L15:
        return null;
    L4:
        if (r10.length <= 0) goto L15;
        Object[] r11 = new Object[r10.length];
        int r12 = 0;
    L7:
        if (r12 >= r10.length) goto L20;
        Object r13 = r10[r12];
        if (r13 != null) goto L11;
    L13:
        r11[r12] = r13;
    L14:
        r12 = r12 + 1;
        goto L7
    L11:
        if ((r13 instanceof JavaParam) == false) goto L13;
        r11[r12] = ((JavaParam) r13).obj;
        goto L14
    L20:
        return r11;
    }

    public static <T> T newEmptyInstance(Class<?> r10) {
        return (T) newEmptyInstanceOrThrow(r10);
    L4:
        e = move-exception;
        NpthLog.w(LOG_TAG, "Meet exception when make instance as a " + r10.getSimpleName(), e);
        return null;
    }

    private static <T> T newEmptyInstanceOrThrow(Class<?> r10) {
        Constructor<?>[] r11 = r10.getDeclaredConstructors();
        if (r11 == null) goto L20;
        if (r11.length == 0) goto L20;
        int r12 = 0;
        Constructor<?> r13 = r11[0];
        r13.setAccessible(true);
        Class<?>[] r14 = r13.getParameterTypes();
        if (r14 == null) goto L18;
        if (r14.length == 0) goto L18;
        Object[] r15 = new Object[r14.length];
    L13:
        if (r12 >= r14.length) goto L16;
        r15[r12] = getDefaultValue(r14[r12]);
        r12 = r12 + 1;
        goto L13
    L16:
        return (T) r13.newInstance(r15);
    L18:
        return (T) r13.newInstance(new Object[0]);
    L20:
        throw new IllegalArgumentException("Can't get even one available constructor for " + r10);
    }

    public static <T> T newInstance(Class<?> r10, Object... r11) {
        return (T) newInstanceOrThrow(r10, r11);
    L4:
        e = move-exception;
        NpthLog.w(LOG_TAG, "Meet exception when make instance as a " + r10.getSimpleName(), e);
        return null;
    }

    public static Object newInstance(String r10, Object... r11) {
        return newInstanceOrThrow(r10, r11);
    L4:
        e = move-exception;
        NpthLog.w(LOG_TAG, "Meet exception when make instance as a " + r10, e);
        return null;
    }

    private static <T> T newInstanceOrThrow(Class<?> r10, Object... r11) {
        return (T) r10.getConstructor(getParameterTypes(r11)).newInstance(getParameters(r11));
    }

    private static Object newInstanceOrThrow(String r10, Object... r11) {
        return newInstanceOrThrow(Class.forName(r10), getParameters(r11));
    }

    public static void setField(Object r10, String r11, Object r12) {
        setFieldOrThrow(r10, r11, r12);     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
    L12:
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    private static void setFieldOrThrow(Object r10, String r11, Object r12) {
        Class<?> r13 = r10.getClass();
        Field r14 = null;
    L3:
        if (r14 != null) goto L11;
        r14 = r13.getDeclaredField(r11);     // Catch: NoSuchFieldException -> L6
    L7:
        if (r13 != null) goto L3;
        throw new NoSuchFieldException();
    L6:
        r13 = r13.getSuperclass();
        goto L7
    L11:
        r14.setAccessible(true);
        r14.set(r10, r12);
    }
}
