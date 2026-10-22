package g6;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f8998a = null;

    /* JADX INFO: renamed from: g6.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0174a {
    }

    private static abstract class b {
        private b() {
        }

        /* synthetic */ b(C0174a r10) {
            this();
        }

        public abstract Method a(Class<?> r10, Field r11);

        abstract <T> Constructor<T> b(Class<T> r10);

        abstract String[] c(Class<?> r10);

        abstract boolean d(Class<?> r10);
    }

    private static class c extends b {
        private c() {
            super(null);
        }

        /* synthetic */ c(C0174a r10) {
            this();
        }

        @Override // g6.a.b
        public Method a(Class<?> r10, Field r11) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // g6.a.b
        <T> Constructor<T> b(Class<T> r10) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // g6.a.b
        String[] c(Class<?> r10) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // g6.a.b
        boolean d(Class<?> r10) {
            return false;
        }
    }

    private static class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f8999a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f9000b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Method f9001c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Method f9002d;

        private d() {
            super(null);
            this.f8999a = Class.class.getMethod("isRecord", new Class[0]);
            Method r10 = Class.class.getMethod("getRecordComponents", new Class[0]);
            this.f9000b = r10;
            Class<?> r11 = r10.getReturnType().getComponentType();
            this.f9001c = r11.getMethod("getName", new Class[0]);
            this.f9002d = r11.getMethod("getType", new Class[0]);
        }

        /* synthetic */ d(C0174a r10) {
            this();
        }

        @Override // g6.a.b
        public Method a(Class<?> r10, Field r11) {
            return r10.getMethod(r11.getName(), new Class[0]);
        L4:
            e = move-exception;
            throw a.a(e);
        }

        @Override // g6.a.b
        public <T> Constructor<T> b(Class<T> r10) {
            Object[] r11 = (Object[]) this.f9000b.invoke(r10, new Object[0]);     // Catch: ReflectiveOperationException -> L8
            Class<?>[] r12 = new Class[r11.length];     // Catch: ReflectiveOperationException -> L8
            int r13 = 0;
        L4:
            if (r13 >= r11.length) goto L6;
            r12[r13] = (Class) this.f9002d.invoke(r11[r13], new Object[0]);     // Catch: ReflectiveOperationException -> L8
            r13 = r13 + 1;     // Catch: ReflectiveOperationException -> L8
            goto L4
        L6:
            return r10.getDeclaredConstructor(r12);
        L8:
            e = move-exception;
            throw a.a(e);
        }

        @Override // g6.a.b
        String[] c(Class<?> r10) {
            Object[] r11 = (Object[]) this.f9000b.invoke(r10, new Object[0]);     // Catch: ReflectiveOperationException -> L8
            String[] r12 = new String[r11.length];     // Catch: ReflectiveOperationException -> L8
            int r13 = 0;
        L4:
            if (r13 >= r11.length) goto L7;
            r12[r13] = (String) this.f9001c.invoke(r11[r13], new Object[0]);     // Catch: ReflectiveOperationException -> L8
            r13 = r13 + 1;
            goto L4
        L7:
            return r12;
        L8:
            e = move-exception;
            throw a.a(e);
        }

        @Override // g6.a.b
        boolean d(Class<?> r10) {
            return ((Boolean) this.f8999a.invoke(r10, new Object[0])).booleanValue();
        L4:
            e = move-exception;
            throw a.a(e);
        }
    }

    static {
        C0174a r10 = null;
        b r11 = new d(r10);     // Catch: NoSuchMethodException -> L5
    L6:
        f8998a = r11;
        return;
    L5:
        r11 = new c(r10);
        goto L6
    }

    static /* synthetic */ RuntimeException a(ReflectiveOperationException r10) {
        return d(r10);
    }

    private static void b(AccessibleObject r10, StringBuilder r11) {
        r11.append('(');
        if ((r10 instanceof Method) == false) goto L5;
        Class<?>[] r12 = ((Method) r10).getParameterTypes();
    L6:
        int r13 = 0;
    L8:
        if (r13 >= r12.length) goto L12;
        if (r13 <= 0) goto L11;
        r11.append(", ");
    L11:
        r11.append(r12[r13].getSimpleName());
        r13 = r13 + 1;
        goto L8
    L12:
        r11.append(')');
        return;
    L5:
        r12 = ((Constructor) r10).getParameterTypes();
        goto L6
    }

    public static String c(Constructor<?> r10) {
        StringBuilder r11 = new StringBuilder(r10.getDeclaringClass().getName());
        b(r10, r11);
        return r11.toString();
    }

    private static RuntimeException d(ReflectiveOperationException r10) {
        throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", r10);
    }

    public static RuntimeException e(IllegalAccessException r10) {
        throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", r10);
    }

    public static String f(Field r10) {
        return r10.getDeclaringClass().getName() + "#" + r10.getName();
    }

    public static String g(AccessibleObject r10, boolean r11) {
        if ((r10 instanceof Field) == false) goto L8;
        StringBuilder r12 = new StringBuilder();
        r12.append("field '");
        String r13 = f((Field) r10);
    L5:
        r12.append(r13);
        r12.append("'");
    L6:
        String r14 = r12.toString();
    L14:
        if (r11 == true) goto L16;
        return r14;
    L16:
        if (Character.isLowerCase(r14.charAt(0)) == true) goto L18;
        return r14;
    L18:
        return Character.toUpperCase(r14.charAt(0)) + r14.substring(1);
    L8:
        if ((r10 instanceof Method) == false) goto L11;
        Method r15 = (Method) r10;
        StringBuilder r16 = new StringBuilder(r15.getName());
        b(r15, r16);
        r14 = "method '" + r15.getDeclaringClass().getName() + "#" + r16.toString() + "'";
        goto L14
    L11:
        if ((r10 instanceof Constructor) == false) goto L13;
        r12 = new StringBuilder();
        r12.append("constructor '");
        r13 = c((Constructor) r10);
        goto L5
    L13:
        r12 = new StringBuilder();
        r12.append("<unknown AccessibleObject> ");
        r12.append(r10.toString());
        goto L6
    }

    public static Method h(Class<?> r10, Field r11) {
        return f8998a.a(r10, r11);
    }

    public static <T> Constructor<T> i(Class<T> r10) {
        return f8998a.b(r10);
    }

    public static String[] j(Class<?> r10) {
        return f8998a.c(r10);
    }

    public static boolean k(Class<?> r10) {
        return f8998a.d(r10);
    }

    public static void l(AccessibleObject r10) {
        r10.setAccessible(true);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        throw new JsonIOException("Failed making " + g(r10, false) + " accessible; either increase its visibility or write a custom TypeAdapter for its declaring type.", e);
    }

    public static String m(Constructor<?> r10) {
        r10.setAccessible(true);     // Catch: Exception -> L6
        return null;
    L6:
        e = move-exception;
        return "Failed making constructor '" + c(r10) + "' accessible; either increase its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + e.getMessage();
    }
}
