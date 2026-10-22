package e9;

import android.app.ApplicationExitInfo;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f16793a = 0;

    static {
        HashMap r5 = new HashMap();
        Class r10 = Boolean.TYPE;
        r5.put(Boolean.class, r10);
        Class r11 = Byte.TYPE;
        r5.put(Byte.class, r11);
        Class r12 = Character.TYPE;
        r5.put(Character.class, r12);
        Class r13 = Short.TYPE;
        r5.put(Short.class, r13);
        Class r14 = Integer.TYPE;
        r5.put(Integer.class, r14);
        Class r15 = Float.TYPE;
        r5.put(Float.class, r15);
        Class r16 = Long.TYPE;
        r5.put(Long.class, r16);
        Class r17 = Double.TYPE;
        r5.put(Double.class, r17);
        r5.put(r10, r10);
        r5.put(r11, r11);
        r5.put(r12, r12);
        r5.put(r13, r13);
        r5.put(r14, r14);
        r5.put(r15, r15);
        r5.put(r16, r16);
        r5.put(r17, r17);
    }

    public static Object a(ApplicationExitInfo r5, Object... r10) {
        return b(r5.getClass(), "getSubReason", c(r10)).invoke(r5, d(r10));
    L5:
        e = move-exception;
        Log.w("JavaCalls", "Meet exception when call Method 'getSubReason' in " + r5, e);
        return null;
    }

    public static Method b(Class r5, String r10, Class... r11) {
        Method r12 = r5.getDeclaredMethod(r10, r11);     // Catch: Throwable -> L8 NoSuchMethodException -> L10
        if (r12 == null) goto L7;
        r12.setAccessible(true);
        return r12;
    L7:
        throw new NoSuchMethodException();
    L11:
        if (r5.getSuperclass() == null) goto L15;
        return b(r5.getSuperclass(), r10, r11);
    L15:
        throw new NoSuchMethodException();
    L9:
        throw new NoSuchMethodException();
    }

    public static Class[] c(Object... r5) {
        if (r5.length <= 0) goto L18;
        Class[] r10 = new Class[r5.length];
        int r11 = 0;
    L6:
        if (r11 >= r5.length) goto L17;
        Object r12 = r5[r11];
        if (r12 != null) goto L10;
    L12:
        if (r12 != null) goto L14;
        Class<?> r13 = null;
    L15:
        r10[r11] = r13;
    L16:
        r11 = r11 + 1;
        goto L6
    L14:
        r13 = r12.getClass();
        goto L15
    L10:
        if ((r12 instanceof a) == false) goto L12;
        a r14 = (a) r12;
        r10[r11] = Integer.TYPE;
        goto L16
    L17:
        return r10;
    L18:
        return null;
    }

    public static Object[] d(Object... r5) {
        if (r5.length <= 0) goto L15;
        Object[] r10 = new Object[r5.length];
        int r11 = 0;
    L6:
        if (r11 >= r5.length) goto L14;
        Object r12 = r5[r11];
        if (r12 != null) goto L10;
    L12:
        r10[r11] = r12;
    L13:
        r11 = r11 + 1;
        goto L6
    L10:
        if ((r12 instanceof a) == false) goto L12;
        r10[r11] = ((a) r12).f16792a;
        goto L13
    L14:
        return r10;
    L15:
        return null;
    }
}
