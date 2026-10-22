package x3;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, Method> f13510a;

    static {
        f13510a = new HashMap();
    }

    private static Method a(Method r10) {
        if (e.e(r10) == true) goto L6;
        return null;
    L6:
        Class<?> r11 = r10.getDeclaringClass();
        if (Modifier.isPublic(r11.getModifiers()) == false) goto L9;
        return r10;
    L9:
        String r12 = r10.getName();
        Class<?>[] r13 = r10.getParameterTypes();
        Method r14 = b(r11, r12, r13);
        if (r14 == null) goto L12;
        return r14;
    L12:
        return c(r11, r12, r13);
    }

    private static Method b(Class<?> r10, String r11, Class<?>... r12) {
    L2:
        if (r10 == null) goto L16;
        Class<?>[] r13 = r10.getInterfaces();
        int r14 = 0;
    L5:
        if (r14 >= r13.length) goto L15;
        if (Modifier.isPublic(r13[r14].getModifiers()) == false) goto L14;
        return r13[r14].getDeclaredMethod(r11, r12);
    L11:
        Method r15 = b(r13[r14], r11, r12);
        if (r15 == null) goto L14;
        return r15;
    L14:
        r14 = r14 + 1;
        goto L5
    L15:
        r10 = r10.getSuperclass();
        goto L2
    L16:
        return null;
    }

    private static Method c(Class<?> r10, String r11, Class<?>... r12) {
    L2:
        r10 = r10.getSuperclass();
        if (r10 == null) goto L8;
        if (Modifier.isPublic(r10.getModifiers()) == false) goto L2;
        return r10.getMethod(r11, r12);
    L8:
        return null;
    }

    private static Method d(Class<?> r10, String r11, String r12, Class<?>... r13) {
        Method[] r14 = r10.getMethods();
        int r15 = r14.length;
        Method r16 = null;
        int r17 = 0;
    L3:
        if (r17 >= r15) goto L15;
        Method r18 = r14[r17];
        if (r18.getName().equals(r12) == false) goto L14;
        if (e.h(r13, r18.getParameterTypes(), true) == false) goto L14;
        Method r19 = a(r18);
        if (r19 == null) goto L14;
        if (r16 != null) goto L12;
    L13:
        r16 = r19;
        goto L14
    L12:
        if (e.a(r19.getParameterTypes(), r16.getParameterTypes(), r13) < 0) goto L13;
    L14:
        r17 = r17 + 1;
        goto L3
    L15:
        if (r16 == null) goto L17;
        e.l(r16);
    L17:
        Map<String, Method> r20 = f13510a;
        monitor-enter(r20);
        f13510a.put(r11, r16);     // Catch: Throwable -> L22
        monitor-exit(r20);     // Catch: Throwable -> L22
        return r16;
    L22:
        th = move-exception;
        throw th;
    }

    private static Method e(String r10) {
        Map<String, Method> r11 = f13510a;
        monitor-enter(r11);
        Method r12 = f13510a.get(r10);     // Catch: Throwable -> L13
        monitor-exit(r11);     // Catch: Throwable -> L13
        if (r12 != null) goto L8;
        return null;
    L8:
        if (r12.isAccessible() == true) goto L10;
        r12.setAccessible(true);
    L10:
        return r12;
    L13:
        th = move-exception;
        throw th;
    }

    private static String f(Class<?> r10, String r11, Class<?>... r12) {
        StringBuilder r13 = new StringBuilder();
        r13.append(r10.toString());
        r13.append("#");
        r13.append(r11);
        if (r12 != null) goto L5;
    L9:
        r13.append(Void.class.toString());
    L11:
        return r13.toString();
    L5:
        if (r12.length <= 0) goto L9;
        int r14 = r12.length;
        int r15 = 0;
    L7:
        if (r15 >= r14) goto L11;
        r13.append(r12[r15].toString());
        r13.append("#");
        r15 = r15 + 1;
        goto L7
    }

    private static Method g(Class<?> r10, String r11, Class<?>... r12) {
        String r13 = f(r10, r11, r12);
        Method r14 = e(r13);
        if (r14 == null) goto L15;
        return r14;
    L15:
        Method r15 = r10.getMethod(r11, r12);     // Catch: NoSuchMethodException -> L13
        e.l(r15);     // Catch: NoSuchMethodException -> L13
        Map<String, Method> r16 = f13510a;     // Catch: NoSuchMethodException -> L13
        monitor-enter(r16);     // Catch: NoSuchMethodException -> L13
        f13510a.put(r13, r15);     // Catch: Throwable -> L10
        monitor-exit(r16);     // Catch: Throwable -> L10
        return r15;
    L10:
        th = move-exception;
        throw th;     // Catch: NoSuchMethodException -> L13
    L14:
        return d(r10, r13, r11, r12);
    }

    public static Object h(Class r10, String r11, Object... r12) {
        return i(r10, r11, c.b(r12), c.c(r12));
    }

    public static Object i(Class r10, String r11, Object[] r12, Class<?>[] r13) {
        Method r14 = g(r10, r11, r13);
        if (r14 == null) goto L7;
        return r14.invoke(null, c.b(r12));
    L7:
        throw new NoSuchMethodException("No such accessible method: " + r11 + "() on object: " + r10.getName());
    }
}
