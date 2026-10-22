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

    private Reflect(Class<?> r8) {
        this.object = r8;
        this.isClass = true;
    }

    public static /* synthetic */ Class[] access$000(Object[] r8) {
        return types(r8);
    }

    public static /* synthetic */ Object access$100(Reflect r8) {
        return r8.object;
    }

    public static /* synthetic */ String access$200(String r8) {
        return property(r8);
    }

    public static <T extends AccessibleObject> T accessible(T r8) {
        if (r8 != null) goto L6;
        return null;
    L6:
        if ((r8 instanceof Member) == false) goto L13;
        Member r10 = (Member) r8;
        if (Modifier.isPublic(r10.getModifiers()) == false) goto L13;
        if (Modifier.isPublic(r10.getDeclaringClass().getModifiers()) == false) goto L13;
        return r8;
    L13:
        if (r8.isAccessible() == true) goto L15;
        r8.setAccessible(true);
    L15:
        return r8;
    }

    private Field field0(String r8, Class<?>... r10) {
        Class<?> r11 = type();
        if (r10 != null) goto L5;
    L37:
        return r11.getField(r8);
    L24:
        e = move-exception;
    L35:
        return (Field) accessible(r11.getDeclaredField(r8));
    L27:
        r11 = r11.getSuperclass();
        if (r11 != null) goto L35;
        throw new ReflectException(e);
    L5:
        if (r10.length <= 0) goto L37;
    L33:
        Field[] r12 = r11.getDeclaredFields();     // Catch: Exception -> L32
        int r13 = r12.length;     // Catch: Exception -> L32
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L17;
        Field r15 = r12[r14];     // Catch: Exception -> L32
        Class<?> r16 = r15.getType();     // Catch: Exception -> L32
        if (r16 == null) goto L16;
        if (r16.getName().equals(r10[0].getName()) == false) goto L16;
        if (r15.getName().equals(r8) == false) goto L16;
        return (Field) accessible(r15);
    L16:
        r14 = r14 + 1;
    L17:
        r11 = r11.getSuperclass();
        if (r11 != null) goto L33;
        throw new ReflectException("NoSuchFieldException");
    }

    private static Class<?> forName(String r8) {
        return Class.forName(r8);
    L4:
        e = move-exception;
        throw new ReflectException(e);
    }

    private boolean isSimilarSignature(Method r8, String r10, Class<?>[] r11) {
        if (r8.getName().equals(r10) == true) goto L5;
    L7:
        return false;
    L5:
        if (match(r8.getParameterTypes(), r11) == false) goto L7;
        return true;
    }

    private boolean match(Class<?>[] r8, Class<?>[] r10) {
        if (r8.length != r10.length) goto L16;
        int r11 = 0;
    L6:
        if (r11 >= r10.length) goto L14;
        if (r10[r11] == NULL.class) goto L12;
        if (wrapper(r8[r11]).isAssignableFrom(wrapper(r10[r11])) == true) goto L12;
        return false;
    L12:
        r11 = r11 + 1;
        goto L6
    L14:
        return true;
    L16:
        return false;
    }

    public static Reflect on(Class<?> r8) {
        return new Reflect(r8);
    }

    @SuppressLint({"DefaultLocale"})
    private static String property(String r8) {
        int r10 = r8.length();
        if (r10 != 0) goto L7;
        return "";
    L7:
        if (r10 != 1) goto L11;
        return r8.toLowerCase();
    L11:
        return r8.substring(0, 1).toLowerCase() + r8.substring(1);
    }

    private Method similarMethod(String r8, Class<?>[] r10) {
        Class<?> r11 = type();
        Method[] r12 = r11.getMethods();
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        Method r15 = r12[r14];
        if (isSimilarSignature(r15, r8, r10) == true) goto L6;
        r14 = r14 + 1;
        goto L3
    L6:
        return r15;
    L8:
        Method[] r16 = r11.getDeclaredMethods();
        int r17 = r16.length;
        int r18 = 0;
    L9:
        if (r18 >= r17) goto L14;
        Method r19 = r16[r18];
        if (isSimilarSignature(r19, r8, r10) == true) goto L12;
        r18 = r18 + 1;
        goto L9
    L12:
        return r19;
    L14:
        r11 = r11.getSuperclass();
        if (r11 != null) goto L8;
        StringBuilder r20 = defpackage.b.h("No similar method ", r8, " with params ");
        r20.append(Arrays.toString(r10));
        r20.append(" could be found on type ");
        r20.append(type());
        r20.append(".");
        throw new NoSuchMethodException(r20.toString());
    }

    private static Class<?>[] types(Object... r8) {
        int r10 = 0;
        if (r8 == null) goto L5;
        Class<?>[] r11 = new Class[r8.length];
    L8:
        if (r10 >= r8.length) goto L14;
        Object r12 = r8[r10];
        if (r12 != null) goto L12;
        Class<?> r13 = NULL.class;
    L13:
        r11[r10] = r13;
        r10 = r10 + 1;
        goto L8
    L12:
        r13 = r12.getClass();
        goto L13
    L14:
        return r11;
    L5:
        return new Class[0];
    }

    private static Object unwrap(Object r8) {
        if ((r8 instanceof Reflect) == true) goto L5;
        return r8;
    L5:
        return ((Reflect) r8).get();
    }

    public static Class<?> wrapper(Class<?> r8) {
        if (r8 != null) goto L6;
        return null;
    L6:
        if (r8.isPrimitive() == true) goto L8;
        return r8;
    L8:
        if (Boolean.TYPE != r8) goto L12;
        return Boolean.class;
    L12:
        if (Integer.TYPE != r8) goto L16;
        return Integer.class;
    L16:
        if (Long.TYPE != r8) goto L20;
        return Long.class;
    L20:
        if (Short.TYPE != r8) goto L24;
        return Short.class;
    L24:
        if (Byte.TYPE != r8) goto L28;
        return Byte.class;
    L28:
        if (Double.TYPE != r8) goto L32;
        return Double.class;
    L32:
        if (Float.TYPE != r8) goto L36;
        return Float.class;
    L36:
        if (Character.TYPE != r8) goto L40;
        return Character.class;
    L40:
        if (Void.TYPE != r8) goto L44;
        return Void.class;
    L44:
        return r8;
    }

    public <P> P as(Class<P> r8) {
        final boolean r10 = this.object instanceof Map;
        InvocationHandler r11 = new AnonymousClass1(this, r10);
        return (P) Proxy.newProxyInstance(r8.getClassLoader(), new Class[]{r8}, r11);
    }

    public Reflect call(String r8) {
        return call(r8, null, new Object[0]);
    }

    public Reflect create() {
        return create(new Object[0]);
    }

    public boolean equals(Object r8) {
        if ((r8 instanceof Reflect) == true) goto L5;
        return false;
    L5:
        return this.object.equals(((Reflect) r8).get());
    }

    public Field exactField(String r8, Class<?>... r10) {
        return field0(r8, r10);
    }

    public Method exactMethod(String r13, Class<?>[] r14, Object... r15) {
        Class<?> r16 = type();
        return r16.getMethod(r13, r14);
    L28:
        return r16.getDeclaredMethod(r13, r14);
    L7:
        r16 = r16.getSuperclass();
        if (r16 != null) goto L28;
        Class<?> r12 = this.type();
        Method[] r17 = r12.getMethods();
        int r8 = r17.length;
        int r10 = 0;
    L10:
        if (r10 >= r8) goto L24;
        Method r11 = r17[r10];
        if (r13.equals(r11.getName()) == false) goto L22;
        Class<?>[] r18 = r11.getParameterTypes();
        if (Logger.debug() == false) goto L18;
        int r19 = r18.length;
        int r20 = 0;
        int r21 = 1;
    L16:
        if (r20 >= r19) goto L18;
        Logger.d("Plugin", "Reflect type = " + r12 + " method = " + r13 + " paramTypes " + r21 + " = " + r18[r20].getName());
        r21 = r21 + 1;
        r20 = r20 + 1;
    L18:
        if (r18 == null) goto L22;
        if (r18.length != r14.length) goto L22;
        return r11;
    L22:
        r10 = r10 + 1;
        goto L10
    L24:
        throw new NoSuchMethodException();
    }

    public Reflect field(String r8, Class<?>... r10) {
        return on(field0(r8, r10).get(this.object));
    L4:
        e = move-exception;
        throw new ReflectException(e);
    }

    public Map<String, Reflect> fields() {
        LinkedHashMap r8 = new LinkedHashMap();
        Class<?> r10 = type();
    L3:
        Field[] r11 = r10.getDeclaredFields();
        int r12 = r11.length;
        int r13 = 0;
    L4:
        if (r13 >= r12) goto L11;
        Field r14 = r11[r13];
        if (((!this.isClass) ^ Modifier.isStatic(r14.getModifiers())) == false) goto L10;
        String r15 = r14.getName();
        if (r8.containsKey(r15) == true) goto L10;
        r8.put(r15, field(r15, new Class[0]));
    L10:
        r13 = r13 + 1;
        goto L4
    L11:
        r10 = r10.getSuperclass();
        if (r10 != null) goto L3;
        return r8;
    }

    public <T> T get() {
        return (T) this.object;
    }

    public int hashCode() {
        return this.object.hashCode();
    }

    public Reflect set(String r8, Object r10) {
        field0(r8, new Class[0]).set(this.object, unwrap(r10));     // Catch: Exception -> L5
        return this;
    L5:
        e = move-exception;
        throw new ReflectException(e);
    }

    public String toString() {
        return this.object.toString();
    }

    public Class<?> type() {
        boolean r8 = this.isClass;
        Object r10 = this.object;
        if (r8 == false) goto L7;
        return (Class) r10;
    L7:
        return r10.getClass();
    }

    private Reflect(Object r8) {
        this.object = r8;
        this.isClass = false;
    }

    public static Reflect on(Object r8) {
        return new Reflect(r8);
    }

    public Reflect call(String r8, Class<?>[] r10, Object... r11) {
        return on(exactMethod(r8, r10, r11), this.object, r11);
    L4:
        return on(similarMethod(r8, r10), this.object, r11);
    L6:
        e = move-exception;
        throw new ReflectException(e);
    }

    public Reflect create(Object... r8) {
        Class<?>[] r10 = types(r8);
        return on(type().getDeclaredConstructor(r10), r8);
    L5:
        e = move-exception;
        Constructor<?>[] r11 = type().getDeclaredConstructors();
        int r12 = r11.length;
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L14;
        Constructor<?> r14 = r11[r13];
        if (match(r14.getParameterTypes(), r10) == true) goto L11;
        r13 = r13 + 1;
        goto L7
    L11:
        return on(r14, r8);
    L14:
        throw new ReflectException(e);
    }

    public <T> T get(String r8, Class<?>... r10) {
        return (T) field(r8, r10).get();
    }

    public static Reflect on(String r8) {
        return on(forName(r8));
    }

    private static Reflect on(Constructor<?> r8, Object... r10) {
        return on(((Constructor) accessible(r8)).newInstance(r10));
    L4:
        e = move-exception;
        throw new ReflectException(e);
    }

    private static Reflect on(Method r8, Object r10, Object... r11) {
        accessible(r8);     // Catch: Exception -> L8
        if (r8.getReturnType() != Void.TYPE) goto L7;
        r8.invoke(r10, r11);     // Catch: Exception -> L8
        return on(r10);
    L7:
        return on(r8.invoke(r10, r11));
    L8:
        e = move-exception;
        throw new ReflectException(e);
    }
}
