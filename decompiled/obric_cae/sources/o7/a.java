package o7;

import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.HashMap;
import t2.b;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f9758a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<Class<?>, Class<?>> f9759b = null;

    static {
        f9758a = new HashMap();
        HashMap<Class<?>, Class<?>> r8 = new HashMap();
        f9759b = r8;
        r8.put(Boolean.TYPE, Boolean.class);
        r8.put(Byte.TYPE, Byte.class);
        r8.put(Character.TYPE, Character.class);
        r8.put(Short.TYPE, Short.class);
        r8.put(Integer.TYPE, Integer.class);
        r8.put(Long.TYPE, Long.class);
        r8.put(Double.TYPE, Double.class);
        r8.put(Float.TYPE, Float.class);
        r8.put(Void.TYPE, Void.class);
    }

    public static void a(Object r17, Object... r18) {
        Object[] r8 = r18;
        if (r8.length != 0) goto L6;
        r8 = b.C;
    L6:
        if (r8.length != 0) goto L8;
        Class<?>[] r10 = b.D;
    L17:
        if (r10.length != 0) goto L20;
        r10 = b.D;
    L20:
        if (r8.length != 0) goto L22;
        r8 = b.C;
    L22:
        Class<?> r11 = r17.getClass();
        boolean r12 = true;
        if ((!TextUtils.isEmpty("connected")) == false) goto L99;
        StringBuilder r13 = new StringBuilder();
        r13.append(r11.toString());
        r13.append("#connected");
        if (r10.length <= 0) goto L29;
        int r14 = r10.length;
        int r15 = 0;
    L27:
        if (r15 >= r14) goto L30;
        r13.append(r10[r15].toString());
        r13.append("#");
        r15 = r15 + 1;
    L30:
        String r16 = r13.toString();
        HashMap r19 = f9758a;
        monitor-enter(r19);
        Method r20 = (Method) r19.get(r16);     // Catch: Throwable -> L95
        monitor-exit(r19);     // Catch: Throwable -> L95
        if (r20 != null) goto L36;
    L39:
        if (r11 == null) goto L91;
        r20 = r11.getDeclaredMethod("connected", r10);     // Catch: NoSuchMethodException -> L100
    L41:
        if (r20 != null) goto L81;
        Method[] r21 = r11.getDeclaredMethods();
        if (r21 == null) goto L81;
        int r110 = r21.length;
        int r111 = 0;
    L45:
        if (r111 >= r110) goto L81;
        Method r112 = r21[r111];
        if (r112 == null) goto L80;
        if (TextUtils.equals(r112.getName(), "connected") == false) goto L80;
        Class<?>[] r113 = r112.getParameterTypes();
        if (r113 == null) goto L80;
        if (r10.length != r113.length) goto L80;
        boolean r114 = r12;
        int r115 = 0;
    L58:
        if (r115 >= r10.length) goto L78;
        Class<?> r22 = r10[r115];
        Class<?> r23 = r113[r115];
        if (r23 != null) goto L62;
        boolean r24 = false;
    L75:
        if (r24 == true) goto L77;
        r114 = false;
    L77:
        r115 = r115 + 1;
        r12 = true;
        goto L58
    L62:
        if (r22 != null) goto L64;
        r24 = r23.isPrimitive() ^ r12;
        goto L75
    L64:
        boolean r116 = r22.isPrimitive();
        HashMap<Class<?>, Class<?>> r25 = f9759b;
        if (r116 == false) goto L70;
        if (r23.isPrimitive() == true) goto L70;
        r22 = r25.get(r22);
    L70:
        if (r23.isPrimitive() == true) goto L72;
    L74:
        r24 = r23.isAssignableFrom(r22);
        goto L75
    L72:
        if (r22.isPrimitive() == true) goto L74;
        r23 = r25.get(r23);
        goto L74
    L78:
        if (r114 == false) goto L80;
        r20 = r112;
    L80:
        r111 = r111 + 1;
        r12 = true;
    L81:
        if (r20 != null) goto L82;
        r11 = r11.getSuperclass();
        r12 = true;
        goto L39
    L82:
        r20.setAccessible(true);
        HashMap r26 = f9758a;
        monitor-enter(r26);
        r26.put(r16, r20);     // Catch: Throwable -> L87
        monitor-exit(r26);     // Catch: Throwable -> L87
    L38:
        Method r27 = r20;
    L92:
        if (r27 == null) goto L123;
        r27.invoke(r17, r8);
        return;
    L123:
        return;
    L87:
        th = move-exception;
        throw th;
    L91:
        r27 = null;
        goto L92
    L36:
        if (r20.isAccessible() == true) goto L38;
        r20.setAccessible(true);
    L95:
        th = move-exception;
        throw th;
    L29:
        r13.append(Void.class.toString());
        goto L30
    L99:
        throw new IllegalArgumentException("The method name must not be blank");
    L8:
        r10 = new Class[r8.length];
        int r28 = 0;
    L10:
        if (r28 >= r8.length) goto L17;
        Object r29 = r8[r28];
        if (r29 != null) goto L14;
        Class<?> r30 = null;
    L15:
        r10[r28] = r30;
        r28 = r28 + 1;
        goto L10
    L14:
        r30 = r29.getClass();
        goto L15
    }
}
