package androidx.lifecycle;

import com.qualcomm.qti.qesdk.QesdkUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f2187a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap f2188b = null;

    static {
        f2187a = new HashMap();
        f2188b = new HashMap();
    }

    public static e a(Constructor r8, Object r10) {
        Object r11 = r8.newInstance(new Object[]{r10});     // Catch: InvocationTargetException -> L4 InstantiationException -> L7 IllegalAccessException -> L10
        he.i.e(r11, "{\n            constructo…tance(`object`)\n        }");     // Catch: InvocationTargetException -> L4 InstantiationException -> L7 IllegalAccessException -> L10
        return (e) r11;
    L10:
        e = move-exception;
        throw new RuntimeException(e);
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static final String b(String r8) {
        return ne.g.u0(r8, ".", "_").concat("_LifecycleAdapter");
    }

    public static int c(Class r12) {
        HashMap r8 = f2187a;
        Integer r10 = (Integer) r8.get(r12);
        if (r10 != null) goto L5;
        int r11 = 1;
        if (r12.getCanonicalName() == null) goto L83;
        ArrayList r13 = null;
        Package r14 = r12.getPackage();     // Catch: NoSuchMethodException -> L32 ClassNotFoundException -> L35
        String r15 = r12.getCanonicalName();     // Catch: NoSuchMethodException -> L32 ClassNotFoundException -> L35
        if (r14 == null) goto L13;
        String r16 = r14.getName();     // Catch: NoSuchMethodException -> L32 ClassNotFoundException -> L35
    L14:
        he.i.e(r16, "fullPackage");     // Catch: NoSuchMethodException -> L32 ClassNotFoundException -> L35
        if (r16.length() != 0) goto L17;
        boolean r17 = true;
    L18:
        if (r17 == true) goto L21;
        he.i.e(r15, QesdkUtils.TAGS.JSON_TAG_NAME);     // Catch: NoSuchMethodException -> L32 ClassNotFoundException -> L35
        r15 = r15.substring(r16.length() + 1);     // Catch: NoSuchMethodException -> L32 ClassNotFoundException -> L35
        he.i.e(r15, "this as java.lang.String).substring(startIndex)");     // Catch: NoSuchMethodException -> L32 ClassNotFoundException -> L35
    L21:
        he.i.e(r15, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");     // Catch: NoSuchMethodException -> L32 ClassNotFoundException -> L35
        String r18 = b(r15);     // Catch: NoSuchMethodException -> L32 ClassNotFoundException -> L35
        if (r16.length() != 0) goto L24;
        boolean r19 = true;
    L25:
        if (r19 == true) goto L28;
        r18 = r16 + '.' + r18;     // Catch: NoSuchMethodException -> L32 ClassNotFoundException -> L35
    L28:
        Constructor<?> r20 = Class.forName(r18).getDeclaredConstructor(new Class[]{r12});     // Catch: NoSuchMethodException -> L32 ClassNotFoundException -> L35
        if (r20.isAccessible() == true) goto L36;
        r20.setAccessible(true);     // Catch: NoSuchMethodException -> L32 ClassNotFoundException -> L35
    L36:
        HashMap r21 = f2188b;
        if (r20 == null) goto L39;
        r21.put(r12, l6.a.k0(r20));
    L82:
        r11 = 2;
        goto L83
    L39:
        b r22 = b.f2126c;
        HashMap r23 = r22.f2128b;
        Boolean r24 = (Boolean) r23.get(r12);
        if (r24 == null) goto L88;
        boolean r25 = r24.booleanValue();
    L50:
        if (r25 == true) goto L83;
        Class r26 = r12.getSuperclass();
        if (r26 != null) goto L55;
    L57:
        boolean r27 = false;
    L58:
        if (r27 == false) goto L63;
        he.i.e(r26, "superclass");
        if (c(r26) == 1) goto L83;
        Object r28 = r21.get(r26);
        he.i.c(r28);
        r13 = new ArrayList((Collection) r28);
    L63:
        Class<?>[] r29 = r12.getInterfaces();
        he.i.e(r29, "klass.interfaces");
        int r30 = r29.length;
        int r31 = 0;
    L64:
        if (r31 >= r30) goto L80;
        Class<?> r32 = r29[r31];
        if (r32 != null) goto L68;
    L70:
        boolean r110 = false;
    L71:
        if (r110 == false) goto L79;
        he.i.e(r32, "intrface");
        if (c(r32) == 1) goto L83;
        if (r13 != null) goto L78;
        r13 = new ArrayList();
    L78:
        Object r33 = r21.get(r32);
        he.i.c(r33);
        r13.addAll((Collection) r33);
    L79:
        r31 = r31 + 1;
        goto L64
    L68:
        if (l.class.isAssignableFrom(r32) == false) goto L70;
        r110 = true;
        goto L71
    L80:
        if (r13 == null) goto L83;
        r21.put(r12, r13);
        goto L82
    L55:
        if (l.class.isAssignableFrom(r26) == false) goto L57;
        r27 = true;
        goto L58
    L88:
        Method[] r34 = r12.getDeclaredMethods();     // Catch: NoClassDefFoundError -> L85
        int r35 = r34.length;
        int r36 = 0;
    L44:
        if (r36 >= r35) goto L49;
        if (((v) r34[r36].getAnnotation(v.class)) != null) goto L47;
        r36 = r36 + 1;
        goto L44
    L47:
        r22.a(r12, r34);
        r25 = true;
        goto L50
    L49:
        r23.put(r12, Boolean.FALSE);
        r25 = false;
    L85:
        e = move-exception;
        throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
    L24:
        r19 = false;
        goto L25
    L17:
        r17 = false;
        goto L18
    L13:
        r16 = "";
    L35:
        r20 = null;
    L32:
        e = move-exception;
        throw new RuntimeException(e);
    L83:
        r8.put(r12, Integer.valueOf(r11));
        return r11;
    L5:
        return r10.intValue();
    }
}
