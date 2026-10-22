package com.ttnet.org.chromium.base;

import android.annotation.SuppressLint;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class Reflect {
    private final boolean isClass;
    private final Object object;

    public static class NULL {
        public NULL() {
        }
    }

    private Reflect(Class<?> r10) {
        this.object = r10;
        this.isClass = true;
    }

    private Reflect(Object r10) {
        this.object = r10;
        this.isClass = false;
    }

    static /* synthetic */ Class[] access$000(Object[] r10) {
        return types(r10);
    }

    static /* synthetic */ Object access$100(Reflect r10) {
        return r10.object;
    }

    static /* synthetic */ String access$200(String r10) {
        return property(r10);
    }

    public static <T extends AccessibleObject> T accessible(T r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof Member) == false) goto L13;
        Member r11 = (Member) r10;
        if (Modifier.isPublic(r11.getModifiers()) == false) goto L13;
        if (Modifier.isPublic(r11.getDeclaringClass().getModifiers()) == false) goto L13;
        return r10;
    L13:
        if (r10.isAccessible() == true) goto L15;
        r10.setAccessible(true);
    L15:
        return r10;
    }

    private Field field0(String r10, Class<?>... r11) {
        Class<?> r12 = type();
        if (r11 != null) goto L5;
    L37:
        return r12.getField(r10);
    L24:
        e = move-exception;
    L35:
        return (Field) accessible(r12.getDeclaredField(r10));
    L27:
        r12 = r12.getSuperclass();
        if (r12 != null) goto L35;
        throw new ReflectException(e);
    L5:
        if (r11.length <= 0) goto L37;
    L33:
        Field[] r13 = r12.getDeclaredFields();     // Catch: Exception -> L32
        int r14 = r13.length;     // Catch: Exception -> L32
        int r15 = 0;
    L7:
        if (r15 >= r14) goto L17;
        Field r16 = r13[r15];     // Catch: Exception -> L32
        Class<?> r17 = r16.getType();     // Catch: Exception -> L32
        if (r17 == null) goto L16;
        if (r17.getName().equals(r11[0].getName()) == false) goto L16;
        if (r16.getName().equals(r10) == false) goto L16;
        return (Field) accessible(r16);
    L16:
        r15 = r15 + 1;
    L17:
        r12 = r12.getSuperclass();
        if (r12 != null) goto L33;
        throw new ReflectException("NoSuchFieldException");
    }

    private static Class<?> forName(String r10) {
        return Class.forName(r10);
    L4:
        e = move-exception;
        throw new ReflectException(e);
    }

    private boolean isSimilarSignature(Method r10, String r11, Class<?>[] r12) {
        if (r10.getName().equals(r11) == true) goto L5;
    L7:
        return false;
    L5:
        if (match(r10.getParameterTypes(), r12) == false) goto L7;
        return true;
    }

    private boolean match(Class<?>[] r10, Class<?>[] r11) {
        if (r10.length != r11.length) goto L16;
        int r12 = 0;
    L6:
        if (r12 >= r11.length) goto L14;
        if (r11[r12] == NULL.class) goto L12;
        if (wrapper(r10[r12]).isAssignableFrom(wrapper(r11[r12])) == true) goto L12;
        return false;
    L12:
        r12 = r12 + 1;
        goto L6
    L14:
        return true;
    L16:
        return false;
    }

    public static Reflect on(Class<?> r10) {
        return new Reflect(r10);
    }

    public static Reflect on(Object r10) {
        return new Reflect(r10);
    }

    public static Reflect on(String r10) {
        return on(forName(r10));
    }

    private static Reflect on(Constructor<?> r10, Object... r11) {
        return on(((Constructor) accessible(r10)).newInstance(r11));
    L4:
        e = move-exception;
        throw new ReflectException(e);
    }

    private static Reflect on(Method r10, Object r11, Object... r12) {
        accessible(r10);     // Catch: Exception -> L8
        if (r10.getReturnType() != Void.TYPE) goto L7;
        r10.invoke(r11, r12);     // Catch: Exception -> L8
        return on(r11);
    L7:
        return on(r10.invoke(r11, r12));
    L8:
        e = move-exception;
        throw new ReflectException(e);
    }

    @SuppressLint({"DefaultLocale"})
    private static String property(String r10) {
        int r11 = r10.length();
        if (r11 != 0) goto L7;
        return "";
    L7:
        if (r11 != 1) goto L11;
        return r10.toLowerCase();
    L11:
        return r10.substring(0, 1).toLowerCase() + r10.substring(1);
    }

    private Method similarMethod(String r10, Class<?>[] r11) {
        Class<?> r12 = type();
        Method[] r13 = r12.getMethods();
        int r14 = r13.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L8;
        Method r16 = r13[r15];
        if (isSimilarSignature(r16, r10, r11) == true) goto L6;
        r15 = r15 + 1;
        goto L3
    L6:
        return r16;
    L8:
        Method[] r17 = r12.getDeclaredMethods();
        int r18 = r17.length;
        int r19 = 0;
    L9:
        if (r19 >= r18) goto L14;
        Method r20 = r17[r19];
        if (isSimilarSignature(r20, r10, r11) == true) goto L12;
        r19 = r19 + 1;
        goto L9
    L12:
        return r20;
    L14:
        r12 = r12.getSuperclass();
        if (r12 != null) goto L8;
        throw new NoSuchMethodException("No similar method " + r10 + " with params " + Arrays.toString(r11) + " could be found on type " + type() + ".");
    }

    private static Class<?>[] types(Object... r10) {
        int r11 = 0;
        if (r10 == null) goto L5;
        Class<?>[] r12 = new Class[r10.length];
    L8:
        if (r11 >= r10.length) goto L14;
        Object r13 = r10[r11];
        if (r13 != null) goto L12;
        Class<?> r14 = NULL.class;
    L13:
        r12[r11] = r14;
        r11 = r11 + 1;
        goto L8
    L12:
        r14 = r13.getClass();
        goto L13
    L14:
        return r12;
    L5:
        return new Class[0];
    }

    private static Object unwrap(Object r10) {
        if ((r10 instanceof Reflect) == true) goto L5;
        return r10;
    L5:
        return ((Reflect) r10).get();
    }

    public static Class<?> wrapper(Class<?> r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.isPrimitive() == true) goto L8;
        return r10;
    L8:
        if (Boolean.TYPE != r10) goto L12;
        return Boolean.class;
    L12:
        if (Integer.TYPE != r10) goto L16;
        return Integer.class;
    L16:
        if (Long.TYPE != r10) goto L20;
        return Long.class;
    L20:
        if (Short.TYPE != r10) goto L24;
        return Short.class;
    L24:
        if (Byte.TYPE != r10) goto L28;
        return Byte.class;
    L28:
        if (Double.TYPE != r10) goto L32;
        return Double.class;
    L32:
        if (Float.TYPE != r10) goto L36;
        return Float.class;
    L36:
        if (Character.TYPE != r10) goto L40;
        return Character.class;
    L40:
        if (Void.TYPE != r10) goto L44;
        return Void.class;
    L44:
        return r10;
    }

    public <P> P as(Class<P> r10) {
        final boolean r11 = this.object instanceof Map;
        InvocationHandler r12 = new AnonymousClass1(this, r11);
        return (P) Proxy.newProxyInstance(r10.getClassLoader(), new Class[]{r10}, r12);
    }

    public Reflect call(String r10) {
        return call(r10, null, new Object[0]);
    }

    public Reflect call(String r10, Class<?>[] r11, Object... r12) {
        return on(exactMethod(r10, r11, r12), this.object, r12);
    L4:
        return on(similarMethod(r10, r11), this.object, r12);
    L6:
        e = move-exception;
        throw new ReflectException(e);
    }

    public Reflect create() {
        return create(new Object[0]);
    }

    public Reflect create(Object... r10) {
        Class<?>[] r11 = types(r10);
        return on(type().getDeclaredConstructor(r11), r10);
    L5:
        e = move-exception;
        Constructor<?>[] r12 = type().getDeclaredConstructors();
        int r13 = r12.length;
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L14;
        Constructor<?> r15 = r12[r14];
        if (match(r15.getParameterTypes(), r11) == true) goto L11;
        r14 = r14 + 1;
        goto L7
    L11:
        return on(r15, r10);
    L14:
        throw new ReflectException(e);
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof Reflect) == true) goto L5;
        return false;
    L5:
        return this.object.equals(((Reflect) r10).get());
    }

    public Field exactField(String r10, Class<?>... r11) {
        return field0(r10, r11);
    }

    public Method exactMethod(String r13, Class<?>[] r14, Object... r15) {
        Class<?> r16 = type();
        return r16.getMethod(r13, r14);
    L25:
        return r16.getDeclaredMethod(r13, r14);
    L7:
        r16 = r16.getSuperclass();
        if (r16 != null) goto L25;
        Class<?> r12 = this.type();
        Method[] r17 = r12.getMethods();
        int r10 = r17.length;
        int r11 = 0;
    L10:
        if (r11 >= r10) goto L21;
        Method r18 = r17[r11];
        if (r13.equals(r18.getName()) == false) goto L19;
        Class<?>[] r19 = r18.getParameterTypes();
        int r20 = r19.length;
        int r21 = 0;
        int r22 = 1;
    L14:
        if (r21 >= r20) goto L17;
        Log.d("Plugin", "Reflect type = " + r12 + " method = " + r13 + " paramTypes " + r22 + " = " + r19[r21].getName(), new Object[0]);
        r22 = r22 + 1;
        r21 = r21 + 1;
        goto L14
    L17:
        if (r19.length != r14.length) goto L19;
        return r18;
    L19:
        r11 = r11 + 1;
        goto L10
    L21:
        throw new NoSuchMethodException();
    }

    public Reflect field(String r10, Class<?>... r11) {
        return on(field0(r10, r11).get(this.object));
    L4:
        e = move-exception;
        throw new ReflectException(e);
    }

    public Map<String, Reflect> fields() {
        LinkedHashMap r10 = new LinkedHashMap();
        Class<?> r11 = type();
    L3:
        Field[] r12 = r11.getDeclaredFields();
        int r13 = r12.length;
        int r14 = 0;
    L4:
        if (r14 >= r13) goto L11;
        Field r15 = r12[r14];
        if (((!this.isClass) ^ Modifier.isStatic(r15.getModifiers())) == false) goto L10;
        String r16 = r15.getName();
        if (r10.containsKey(r16) == true) goto L10;
        r10.put(r16, field(r16, new Class[0]));
    L10:
        r14 = r14 + 1;
        goto L4
    L11:
        r11 = r11.getSuperclass();
        if (r11 != null) goto L3;
        return r10;
    }

    public <T> T get() {
        return (T) this.object;
    }

    public <T> T get(String r10, Class<?>... r11) {
        return (T) field(r10, r11).get();
    }

    public int hashCode() {
        return this.object.hashCode();
    }

    public Reflect set(String r10, Object r11) {
        field0(r10, new Class[0]).set(this.object, unwrap(r11));     // Catch: Exception -> L5
        return this;
    L5:
        e = move-exception;
        throw new ReflectException(e);
    }

    public String toString() {
        return this.object.toString();
    }

    public Class<?> type() {
        boolean r10 = this.isClass;
        Object r11 = this.object;
        if (r10 == false) goto L7;
        return (Class) r11;
    L7:
        return r11.getClass();
    }
}
