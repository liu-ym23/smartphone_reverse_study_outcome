package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f2126c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f2127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f2128b;

    @Deprecated
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashMap f2129a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<C0015b, h.a> f2130b;

        public a(HashMap r8) {
            this.f2130b = r8;
            this.f2129a = new HashMap();
            Iterator r10 = r8.entrySet().iterator();
        L4:
            if (r10.hasNext() == false) goto L9;
            Map.Entry r11 = (Map.Entry) r10.next();
            h.a r12 = (h.a) r11.getValue();
            List r13 = (List) this.f2129a.get(r12);
            if (r13 != null) goto L8;
            r13 = new ArrayList();
            this.f2129a.put(r12, r13);
        L8:
            r13.add((C0015b) r11.getKey());
            goto L4
        }

        public static void a(List<C0015b> r8, m r10, h.a r11, Object r12) {
            if (r8 == null) goto L23;
            int r13 = r8.size() - 1;
        L4:
            if (r13 < 0) goto L31;
            C0015b r14 = r8.get(r13);
            r14.getClass();
            int r15 = r14.f2131a;     // Catch: IllegalAccessException -> L17 InvocationTargetException -> L20
            Method r16 = r14.f2132b;
            if (r15 == 0) goto L15;
            if (r15 != 1) goto L11;
            r16.invoke(r12, new Object[]{r10});     // Catch: IllegalAccessException -> L17 InvocationTargetException -> L20
        L16:
            r13 = r13 - 1;
            goto L4
        L11:
            if (r15 != 2) goto L16;
            r16.invoke(r12, new Object[]{r10, r11});     // Catch: IllegalAccessException -> L17 InvocationTargetException -> L20
            goto L16
        L15:
            r16.invoke(r12, new Object[0]);     // Catch: IllegalAccessException -> L17 InvocationTargetException -> L20
            goto L16
        L17:
            e = move-exception;
            throw new RuntimeException(e);
        L20:
            e = move-exception;
            throw new RuntimeException("Failed to call observer method", e.getCause());
        L31:
            return;
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.b$b, reason: collision with other inner class name */
    @Deprecated
    public static final class C0015b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f2131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f2132b;

        public C0015b(int r8, Method r10) {
            this.f2131a = r8;
            this.f2132b = r10;
            r10.setAccessible(true);
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof C0015b) == true) goto L8;
            return false;
        L8:
            C0015b r10 = (C0015b) r8;
            int r11 = r10.f2131a;
            if (this.f2131a != r11) goto L14;
            if (this.f2132b.getName().equals(r10.f2132b.getName()) == false) goto L14;
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            int r8 = this.f2131a * 31;
            return this.f2132b.getName().hashCode() + r8;
        }
    }

    static {
        f2126c = new b();
    }

    public b() {
        this.f2127a = new HashMap();
        this.f2128b = new HashMap();
    }

    public static void c(HashMap r8, C0015b r10, h.a r11, Class r12) {
        h.a r13 = (h.a) r8.get(r10);
        if (r13 == null) goto L8;
        if (r11 == r13) goto L8;
        throw new IllegalArgumentException("Method " + r10.f2132b.getName() + " in " + r12.getName() + " already declared with different @OnLifecycleEvent value: previous value " + r13 + ", new value " + r11);
    L8:
        if (r13 != null) goto L11;
        r8.put(r10, r11);
        return;
    }

    public final a a(Class<?> r12, Method[] r13) {
        Class<? super Object> r8 = r12.getSuperclass();
        HashMap r10 = new HashMap();
        if (r8 == null) goto L5;
        r10.putAll(b(r8).f2130b);
    L5:
        Class<?>[] r11 = r12.getInterfaces();
        int r14 = r11.length;
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L12;
        Iterator<Map.Entry<C0015b, h.a>> r16 = b(r11[r15]).f2130b.entrySet().iterator();
    L9:
        if (r16.hasNext() == false) goto L11;
        Map.Entry<C0015b, h.a> r17 = r16.next();
        c(r10, r17.getKey(), r17.getValue(), r12);
        goto L9
    L11:
        r15 = r15 + 1;
        goto L6
    L12:
        if (r13 == null) goto L50;
    L15:
        int r18 = r13.length;
        int r19 = 0;
        boolean r20 = false;
    L16:
        if (r19 >= r18) goto L45;
        Method r21 = r13[r19];
        v r22 = (v) r21.getAnnotation(v.class);
        if (r22 == null) goto L42;
        Class<?>[] r23 = r21.getParameterTypes();
        if (r23.length > 0) goto L23;
        int r24 = 0;
    L28:
        h.a r25 = r22.value();
        if (r23.length <= 1) goto L40;
        if (h.a.class.isAssignableFrom(r23[1]) == false) goto L38;
        if (r25 != h.a.ON_ANY) goto L36;
        r24 = 2;
        goto L40
    L36:
        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
    L38:
        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
    L40:
        if (r23.length > 2) goto L44;
        c(r10, new C0015b(r24, r21), r25, r12);
        r20 = true;
        goto L42
    L44:
        throw new IllegalArgumentException("cannot have more than 2 params");
    L23:
        if (m.class.isAssignableFrom(r23[0]) == false) goto L26;
        r24 = 1;
        goto L28
    L26:
        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
    L42:
        r19 = r19 + 1;
        goto L16
    L45:
        a r110 = new a(r10);
        this.f2127a.put(r12, r110);
        this.f2128b.put(r12, Boolean.valueOf(r20));
        return r110;
    L50:
        r13 = r12.getDeclaredMethods();     // Catch: NoClassDefFoundError -> L47
    L47:
        e = move-exception;
        throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
    }

    public final a b(Class<?> r8) {
        a r10 = (a) this.f2127a.get(r8);
        if (r10 == null) goto L6;
        return r10;
    L6:
        return a(r8, null);
    }
}
