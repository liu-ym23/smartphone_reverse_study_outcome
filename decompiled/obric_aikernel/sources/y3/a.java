package y3;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f13674a = null;

    static {
        HashMap r10 = new HashMap();
        f13674a = r10;
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

    public static <T> T a(String r10, String r11, Object... r12) {
        return (T) d(Class.forName(r10), r11, e(r12)).invoke(null, r12);
    L5:
        return null;
    }

    private static boolean b(Class<?>[] r10, Class<?>[] r11) {
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
        Map<Class<?>, Class<?>> r13 = f13674a;
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

    private static Method c(Method[] r10, String r11, Class<?>[] r12) {
        Objects.requireNonNull(r11, "Method name is null.");
        int r13 = r10.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L10;
        Method r15 = r10[r14];
        if (r15.getName().equals(r11) == false) goto L9;
        if (b(r15.getParameterTypes(), r12) == false) goto L9;
        return r15;
    L9:
        r14 = r14 + 1;
        goto L3
    L10:
        return null;
    }

    private static Method d(Class<?> r10, String r11, Class<?>... r12) {
        Method r13 = c(r10.getDeclaredMethods(), r11, r12);
        if (r13 == null) goto L5;
        r13.setAccessible(true);
        return r13;
    L5:
        if (r10.getSuperclass() == null) goto L9;
        return d(r10.getSuperclass(), r11, r12);
    L9:
        throw new NoSuchMethodException();
    }

    private static Class<?>[] e(Object... r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.length <= 0) goto L20;
        Class<?>[] r11 = new Class[r10.length];
        int r12 = 0;
    L8:
        if (r12 >= r10.length) goto L15;
        Object r13 = r10[r12];
        if (r13 != null) goto L12;
        Class<?> r14 = null;
    L13:
        r11[r12] = r14;
        r12 = r12 + 1;
        goto L8
    L12:
        r14 = r13.getClass();
        goto L13
    L15:
        return r11;
    L20:
        return null;
    }
}
