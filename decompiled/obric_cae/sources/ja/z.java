package ja;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f8815a = null;

    static {
        Class<?> r8 = Class.forName("sun.misc.Unsafe");     // Catch: Exception -> L5
        Field r10 = r8.getDeclaredField("theUnsafe");     // Catch: Exception -> L5
        r10.setAccessible(true);     // Catch: Exception -> L5
        z r11 = new v(r10.get(null), r8.getMethod("allocateInstance", new Class[]{Class.class}));     // Catch: Exception -> L5
    L10:
        f8815a = r11;
        return;
    L5:
        Method r12 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});     // Catch: Exception -> L7
        r12.setAccessible(true);     // Catch: Exception -> L7
        int r13 = ((Integer) r12.invoke(null, new Object[]{Object.class})).intValue();     // Catch: Exception -> L7
        Method r14 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Integer.TYPE});     // Catch: Exception -> L7
        r14.setAccessible(true);     // Catch: Exception -> L7
        r11 = new w(r13, r14);     // Catch: Exception -> L7
    L7:
        Method r15 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});     // Catch: Exception -> L9
        r15.setAccessible(true);     // Catch: Exception -> L9
        r11 = new x(r15);     // Catch: Exception -> L9
    L9:
        r11 = new y();
        goto L10
    }

    public static void a(Class r8) {
        String r10 = i.a(r8);
        if (r10 != null) goto L6;
        return;
    L6:
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(r10));
    }

    public abstract <T> T b(Class<T> r8);
}
