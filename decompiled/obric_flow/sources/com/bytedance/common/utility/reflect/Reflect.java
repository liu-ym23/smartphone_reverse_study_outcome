package com.bytedance.common.utility.reflect;

import ai.j0;
import android.annotation.SuppressLint;
import com.bytedance.common.utility.Logger;
import f8.a;
import f8.b;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class Reflect {
    private final boolean isClass;
    private final Object object;

    private Reflect(Class<?> r5) {
        this.object = r5;
        this.isClass = true;
    }

    public static /* synthetic */ Class[] access$000(Object[] r5) {
        return types(r5);
    }

    public static /* synthetic */ Object access$100(Reflect r5) {
        return r5.object;
    }

    public static /* synthetic */ String access$200(String r5) {
        return property(r5);
    }

    public static <T extends AccessibleObject> T accessible(T r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if ((r5 instanceof Member) == false) goto L13;
        Member r10 = (Member) r5;
        if (Modifier.isPublic(r10.getModifiers()) == false) goto L13;
        if (Modifier.isPublic(r10.getDeclaringClass().getModifiers()) == false) goto L13;
        return r5;
    L13:
        if (r5.isAccessible() == true) goto L15;
        r5.setAccessible(true);
    L15:
        return r5;
    }

    private Field field0(String r10, Class<?>... r11) throws ReflectException {
        Class<?> r12 = type();
        if (r11 != null) goto L5;
    L36:
        return r12.getField(r10);
    L27:
        e = move-exception;
    L40:
        return (Field) accessible(r12.getDeclaredField(r10));
    L30:
        e = move-exception;
        e.printStackTrace();
        r12 = r12.getSuperclass();
        if (r12 != null) goto L40;
        throw new ReflectException(e);
    L5:
        if (r11.length <= 0) goto L36;
    L38:
        Field[] r5 = r12.getDeclaredFields();     // Catch: Exception -> L16
        int r13 = r5.length;     // Catch: Exception -> L16
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L20;
        Field r15 = r5[r14];     // Catch: Exception -> L16
        Class<?> r16 = r15.getType();     // Catch: Exception -> L16
        if (r16 == null) goto L18;
        if (r16.getName().equals(r11[0].getName()) == false) goto L18;
        if (r15.getName().equals(r10) == false) goto L18;
        return (Field) accessible(r15);
    L18:
        r14 = r14 + 1;
    L20:
        r12 = r12.getSuperclass();
        if (r12 != null) goto L38;
        throw new ReflectException("NoSuchFieldException");
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L20
    }

    private static Class<?> forName(String r5) throws ReflectException {
        return Class.forName(r5);
    L4:
        e = move-exception;
        throw new ReflectException(e);
    }

    private boolean isSimilarSignature(Method r5, String r10, Class<?>[] r11) {
        if (r5.getName().equals(r10) == true) goto L5;
    L7:
        return false;
    L5:
        if (match(r5.getParameterTypes(), r11) == false) goto L7;
        return true;
    }

    private boolean match(Class<?>[] r5, Class<?>[] r10) {
        if (r5.length != r10.length) goto L16;
        int r11 = 0;
    L6:
        if (r11 >= r10.length) goto L14;
        if (r10[r11] == b.class) goto L12;
        if (wrapper(r5[r11]).isAssignableFrom(wrapper(r10[r11])) == true) goto L12;
        return false;
    L12:
        r11 = r11 + 1;
        goto L6
    L14:
        return true;
    L16:
        return false;
    }

    public static Reflect on(String r5) throws ReflectException {
        return on(forName(r5));
    }

    @SuppressLint({"DefaultLocale"})
    private static String property(String r5) {
        int r10 = r5.length();
        if (r10 != 0) goto L7;
        return "";
    L7:
        if (r10 != 1) goto L11;
        return r5.toLowerCase(Locale.getDefault());
    L11:
        return r5.substring(0, 1).toLowerCase(Locale.getDefault()) + r5.substring(1);
    }

    private Method similarMethod(String r10, Class<?>[] r11) throws NoSuchMethodException {
        Class<?> r5 = type();
        Method[] r12 = r5.getMethods();
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        Method r15 = r12[r14];
        if (isSimilarSignature(r15, r10, r11) == true) goto L6;
        r14 = r14 + 1;
        goto L3
    L6:
        return r15;
    L8:
        Method[] r16 = r5.getDeclaredMethods();
        int r17 = r16.length;
        int r18 = 0;
    L9:
        if (r18 >= r17) goto L14;
        Method r19 = r16[r18];
        if (isSimilarSignature(r19, r10, r11) == true) goto L12;
        r18 = r18 + 1;
        goto L9
    L12:
        return r19;
    L14:
        r5 = r5.getSuperclass();
        if (r5 != null) goto L8;
        StringBuilder r20 = j0.x("No similar method ", r10, " with params ");
        r20.append(Arrays.toString(r11));
        r20.append(" could be found on type ");
        r20.append(type());
        r20.append(".");
        throw new NoSuchMethodException(r20.toString());
    }

    private static Class<?>[] types(Object... r5) {
        int r10 = 0;
        if (r5 == null) goto L5;
        Class<?>[] r11 = new Class[r5.length];
    L8:
        if (r10 >= r5.length) goto L14;
        Object r12 = r5[r10];
        if (r12 != null) goto L12;
        Class<?> r13 = b.class;
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

    private static Object unwrap(Object r5) {
        if ((r5 instanceof Reflect) == true) goto L5;
        return r5;
    L5:
        return ((Reflect) r5).get();
    }

    public static Class<?> wrapper(Class<?> r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r5.isPrimitive() == true) goto L8;
        return r5;
    L8:
        if (Boolean.TYPE != r5) goto L12;
        return Boolean.class;
    L12:
        if (Integer.TYPE != r5) goto L16;
        return Integer.class;
    L16:
        if (Long.TYPE != r5) goto L20;
        return Long.class;
    L20:
        if (Short.TYPE != r5) goto L24;
        return Short.class;
    L24:
        if (Byte.TYPE != r5) goto L28;
        return Byte.class;
    L28:
        if (Double.TYPE != r5) goto L32;
        return Double.class;
    L32:
        if (Float.TYPE != r5) goto L36;
        return Float.class;
    L36:
        if (Character.TYPE != r5) goto L40;
        return Character.class;
    L40:
        if (Void.TYPE != r5) goto L44;
        return Void.class;
    L44:
        return r5;
    }

    public <P> P as(Class<P> r5) {
        a r10 = new a(this, this.object instanceof Map);
        return (P) Proxy.newProxyInstance(r5.getClassLoader(), new Class[]{r5}, r10);
    }

    public Reflect call(String r5) throws ReflectException {
        return call(r5, null, new Object[0]);
    }

    public Reflect create() throws ReflectException {
        return create(new Object[0]);
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof Reflect) == true) goto L5;
        return false;
    L5:
        return this.object.equals(((Reflect) r5).get());
    }

    public Field exactField(String r5, Class<?>... r10) throws ReflectException {
        return field0(r5, r10);
    }

    public Method exactMethod(String r13, Class<?>[] r14, Object... r15) throws NoSuchMethodException {
        Class<?> r16 = type();
        return r16.getMethod(r13, r14);
    L29:
        return r16.getDeclaredMethod(r13, r14);
    L7:
        e = move-exception;
        e.printStackTrace();
        r16 = r16.getSuperclass();
        if (r16 != null) goto L29;
        Class<?> r12 = this.type();
        Method[] r17 = r12.getMethods();
        int r5 = r17.length;
        int r10 = 0;
    L11:
        if (r10 >= r5) goto L25;
        Method r11 = r17[r10];
        if (r13.equals(r11.getName()) == false) goto L23;
        Class<?>[] r18 = r11.getParameterTypes();
        if (Logger.debug() == false) goto L19;
        int r19 = r18.length;
        int r20 = 0;
        int r21 = 1;
    L17:
        if (r20 >= r19) goto L19;
        Logger.d("Plugin", "Reflect type = " + r12 + " method = " + r13 + " paramTypes " + r21 + " = " + r18[r20].getName());
        r21 = r21 + 1;
        r20 = r20 + 1;
    L19:
        if (r18 == null) goto L23;
        if (r18.length != r14.length) goto L23;
        return r11;
    L23:
        r10 = r10 + 1;
        goto L11
    L25:
        throw new NoSuchMethodException();
    }

    public Reflect field(String r5, Class<?>... r10) throws ReflectException {
        return on(field0(r5, r10).get(this.object));
    L4:
        e = move-exception;
        throw new ReflectException(e);
    }

    public Map<String, Reflect> fields() {
        LinkedHashMap r5 = new LinkedHashMap();
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
        if (r5.containsKey(r15) == true) goto L10;
        r5.put(r15, field(r15, new Class[0]));
    L10:
        r13 = r13 + 1;
        goto L4
    L11:
        r10 = r10.getSuperclass();
        if (r10 != null) goto L3;
        return r5;
    }

    public <T> T get() {
        return (T) this.object;
    }

    public int hashCode() {
        return this.object.hashCode();
    }

    public Reflect set(String r5, Object r10) throws ReflectException {
        field0(r5, new Class[0]).set(this.object, unwrap(r10));     // Catch: Exception -> L5
        return this;
    L5:
        e = move-exception;
        throw new ReflectException(e);
    }

    public String toString() {
        return this.object.toString();
    }

    public Class<?> type() {
        if (this.isClass == false) goto L7;
        return (Class) this.object;
    L7:
        return this.object.getClass();
    }

    public static Reflect on(Class<?> r5) {
        return new Reflect(r5);
    }

    public Reflect call(String r5, Class<?>[] r10, Object... r11) throws ReflectException {
        return on(exactMethod(r5, r10, r11), this.object, r11);
    L4:
        return on(similarMethod(r5, r10), this.object, r11);
    L6:
        e = move-exception;
        throw new ReflectException(e);
    }

    public Reflect create(Object... r10) throws ReflectException {
        Class<?>[] r5 = types(r10);
        return on(type().getDeclaredConstructor(r5), r10);
    L5:
        e = move-exception;
        Constructor<?>[] r11 = type().getDeclaredConstructors();
        int r12 = r11.length;
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L14;
        Constructor<?> r14 = r11[r13];
        if (match(r14.getParameterTypes(), r5) == true) goto L11;
        r13 = r13 + 1;
        goto L7
    L11:
        return on(r14, r10);
    L14:
        throw new ReflectException(e);
    }

    public <T> T get(String r5, Class<?>... r10) throws ReflectException {
        return (T) field(r5, r10).get();
    }

    public static Reflect on(Object r5) {
        return new Reflect(r5);
    }

    private Reflect(Object r5) {
        this.object = r5;
        this.isClass = false;
    }

    private static Reflect on(Constructor<?> r5, Object... r10) throws ReflectException {
        return on(((Constructor) accessible(r5)).newInstance(r10));
    L4:
        e = move-exception;
        throw new ReflectException(e);
    }

    private static Reflect on(Method r5, Object r10, Object... r11) throws ReflectException {
        accessible(r5);     // Catch: Exception -> L6
        if (r5.getReturnType() != Void.TYPE) goto L9;
        r5.invoke(r10, r11);     // Catch: Exception -> L6
        return on(r10);
    L9:
        return on(r5.invoke(r10, r11));
    L6:
        e = move-exception;
        throw new ReflectException(e);
    }
}
