package x3;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Field> f13504a = null;

    static {
        f13504a = new HashMap();
    }

    public static Field a(Class<?> r10, String r11) {
        String r12 = b(r10, r11);
        Map<String, Field> r13 = f13504a;
        monitor-enter(r13);
        Field r14 = r13.get(r12);     // Catch: Throwable -> L27
        monitor-exit(r13);     // Catch: Throwable -> L27
        if (r14 != null) goto L9;
    L12:
        if (r10 == null) goto L25;
        Field r15 = r10.getDeclaredField(r11);     // Catch: NoSuchFieldException -> L24
        if (r15.isAccessible() == true) goto L16;
        r15.setAccessible(true);     // Catch: NoSuchFieldException -> L24
    L16:
        Map<String, Field> r16 = f13504a;     // Catch: NoSuchFieldException -> L24
        monitor-enter(r16);     // Catch: NoSuchFieldException -> L24
        r16.put(r12, r15);     // Catch: Throwable -> L21
        monitor-exit(r16);     // Catch: Throwable -> L21
    L20:
        return r15;
    L21:
        th = move-exception;
        throw th;     // Catch: NoSuchFieldException -> L24
    L24:
        r10 = r10.getSuperclass();
        goto L12
    L25:
        return null;
    L9:
        if (r14.isAccessible() == true) goto L11;
        r14.setAccessible(true);
    L11:
        return r14;
    L27:
        th = move-exception;
        throw th;
    }

    private static String b(Class<?> r10, String r11) {
        return r10.toString() + "#" + r11;
    }

    public static Object c(Object r10, String r11) {
        Field r12 = a(r10.getClass(), r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return d(r12, r10);
    }

    public static Object d(Field r10, Object r11) {
        if (r10.isAccessible() == true) goto L6;
        r10.setAccessible(true);
    L6:
        return r10.get(r11);
    }
}
