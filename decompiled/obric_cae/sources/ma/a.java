package ma;

import ha.q;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AbstractC0115a f9316a = null;

    /* JADX INFO: renamed from: ma.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0115a {
        public abstract Method a(Class<?> r8, Field r10);

        public abstract <T> Constructor<T> b(Class<T> r8);

        public abstract String[] c(Class<?> r8);

        public abstract boolean d(Class<?> r8);
    }

    public static class b extends AbstractC0115a {
        @Override // ma.a.AbstractC0115a
        public final Method a(Class<?> r8, Field r10) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // ma.a.AbstractC0115a
        public final <T> Constructor<T> b(Class<T> r8) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // ma.a.AbstractC0115a
        public final String[] c(Class<?> r8) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // ma.a.AbstractC0115a
        public final boolean d(Class<?> r8) {
            return false;
        }
    }

    public static class c extends AbstractC0115a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f9317a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f9318b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Method f9319c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Method f9320d;

        public c() {
            this.f9317a = Class.class.getMethod("isRecord", new Class[0]);
            Method r8 = Class.class.getMethod("getRecordComponents", new Class[0]);
            this.f9318b = r8;
            Class<?> r10 = r8.getReturnType().getComponentType();
            this.f9319c = r10.getMethod("getName", new Class[0]);
            this.f9320d = r10.getMethod("getType", new Class[0]);
        }

        @Override // ma.a.AbstractC0115a
        public final Method a(Class<?> r8, Field r10) {
            return r8.getMethod(r10.getName(), new Class[0]);
        L4:
            e = move-exception;
            throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e);
        }

        @Override // ma.a.AbstractC0115a
        public final <T> Constructor<T> b(Class<T> r8) {
            Object[] r10 = (Object[]) this.f9318b.invoke(r8, new Object[0]);     // Catch: ReflectiveOperationException -> L8
            Class<?>[] r11 = new Class[r10.length];     // Catch: ReflectiveOperationException -> L8
            int r12 = 0;
        L4:
            if (r12 >= r10.length) goto L6;
            r11[r12] = (Class) this.f9320d.invoke(r10[r12], new Object[0]);     // Catch: ReflectiveOperationException -> L8
            r12 = r12 + 1;     // Catch: ReflectiveOperationException -> L8
            goto L4
        L6:
            return r8.getDeclaredConstructor(r11);
        L8:
            e = move-exception;
            throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e);
        }

        @Override // ma.a.AbstractC0115a
        public final String[] c(Class<?> r8) {
            Object[] r10 = (Object[]) this.f9318b.invoke(r8, new Object[0]);     // Catch: ReflectiveOperationException -> L8
            String[] r11 = new String[r10.length];     // Catch: ReflectiveOperationException -> L8
            int r12 = 0;
        L4:
            if (r12 >= r10.length) goto L7;
            r11[r12] = (String) this.f9319c.invoke(r10[r12], new Object[0]);     // Catch: ReflectiveOperationException -> L8
            r12 = r12 + 1;
            goto L4
        L7:
            return r11;
        L8:
            e = move-exception;
            throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e);
        }

        @Override // ma.a.AbstractC0115a
        public final boolean d(Class<?> r8) {
            return ((Boolean) this.f9317a.invoke(r8, new Object[0])).booleanValue();
        L4:
            e = move-exception;
            throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e);
        }
    }

    static {
        AbstractC0115a r8 = new c();     // Catch: NoSuchMethodException -> L4
    L5:
        f9316a = r8;
        return;
    L4:
        r8 = new b();
        goto L5
    }

    public static void a(AccessibleObject r8, StringBuilder r10) {
        r10.append('(');
        if ((r8 instanceof Method) == false) goto L5;
        Class<?>[] r11 = ((Method) r8).getParameterTypes();
    L6:
        int r12 = 0;
    L8:
        if (r12 >= r11.length) goto L12;
        if (r12 <= 0) goto L11;
        r10.append(", ");
    L11:
        r10.append(r11[r12].getSimpleName());
        r12 = r12 + 1;
        goto L8
    L12:
        r10.append(')');
        return;
    L5:
        r11 = ((Constructor) r8).getParameterTypes();
        goto L6
    }

    public static String b(Constructor<?> r8) {
        StringBuilder r10 = new StringBuilder(r8.getDeclaringClass().getName());
        a(r8, r10);
        return r10.toString();
    }

    public static String c(Field r8) {
        return r8.getDeclaringClass().getName() + "#" + r8.getName();
    }

    public static String d(AccessibleObject r8, boolean r10) {
        if ((r8 instanceof Field) == false) goto L6;
        StringBuilder r11 = new StringBuilder("field '");
        String r12 = c((Field) r8);
    L11:
        r11.append(r12);
        r11.append("'");
    L13:
        String r13 = r11.toString();
    L14:
        if (r10 == true) goto L16;
        return r13;
    L16:
        if (Character.isLowerCase(r13.charAt(0)) == true) goto L18;
        return r13;
    L18:
        return Character.toUpperCase(r13.charAt(0)) + r13.substring(1);
    L6:
        if ((r8 instanceof Method) == false) goto L9;
        Method r14 = (Method) r8;
        StringBuilder r15 = new StringBuilder(r14.getName());
        a(r14, r15);
        r13 = "method '" + r14.getDeclaringClass().getName() + "#" + r15.toString() + "'";
        goto L14
    L9:
        if ((r8 instanceof Constructor) == false) goto L12;
        r11 = new StringBuilder("constructor '");
        r12 = b((Constructor) r8);
        goto L11
    L12:
        r11 = new StringBuilder("<unknown AccessibleObject> ");
        r11.append(r8.toString());
        goto L13
    }

    public static void e(AccessibleObject r8) {
        r8.setAccessible(true);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        throw new q(defpackage.b.d("Failed making ", d(r8, false), " accessible; either increase its visibility or write a custom TypeAdapter for its declaring type."), e);
    }
}
