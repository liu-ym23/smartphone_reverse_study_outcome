package com.bytedance.retrofit2;

import com.bytedance.crypto.cloudsync.network.CloudConfig;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Type[] f2494a = null;

    class a implements r4.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ okhttp3.y f2495a;

        a(okhttp3.y r10) {
            this.f2495a = r10;
        }

        @Override // r4.f
        public String a() {
            if (this.f2495a.b() != null) goto L5;
            return "";
        L5:
            return this.f2495a.b().toString();
        }

        @Override // r4.f
        public String b() {
            return null;
        }

        @Override // r4.f
        public String d() {
            return null;
        }

        @Override // r4.f
        public long length() {
            return this.f2495a.a();
        L4:
            th = move-exception;
            th.printStackTrace();
            return -1;
        }

        @Override // r4.f
        public void writeTo(OutputStream r10) {
            okio.e r11 = okio.t.a(okio.t.d(r10));
            this.f2495a.g(r11);
            r11.flush();
            r11.close();
        }
    }

    private static final class b implements GenericArrayType {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Type f2496c;

        public b(Type r10) {
            this.f2496c = r10;
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof GenericArrayType) == true) goto L5;
        L7:
            return false;
        L5:
            if (c0.e(this, (GenericArrayType) r10) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f2496c;
        }

        public int hashCode() {
            return this.f2496c.hashCode();
        }

        public String toString() {
            return c0.w(this.f2496c) + "[]";
        }
    }

    static final class c implements ParameterizedType {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Type f2497c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Type f2498g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Type[] f2499h;

        c(Type r10, Type r11, Type... r12) {
            int r13 = 0;
            if ((r11 instanceof Class) == false) goto L16;
            boolean r14 = true;
            if (r10 != null) goto L7;
            boolean r15 = true;
        L9:
            if (((Class) r11).getEnclosingClass() == null) goto L12;
            r14 = false;
        L12:
            if (r15 == r14) goto L16;
            throw new IllegalArgumentException();
        L7:
            r15 = false;
        L16:
            this.f2497c = r10;
            this.f2498g = r11;
            this.f2499h = (Type[]) r12.clone();
            int r16 = r12.length;
        L17:
            if (r13 >= r16) goto L19;
            Type r17 = r12[r13];
            c0.a(r17, "typeArgument == null");
            c0.b(r17);
            r13 = r13 + 1;
            goto L17
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof ParameterizedType) == true) goto L5;
        L7:
            return false;
        L5:
            if (c0.e(this, (ParameterizedType) r10) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.f2499h.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f2497c;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f2498g;
        }

        public int hashCode() {
            int r10 = Arrays.hashCode(this.f2499h) ^ this.f2498g.hashCode();
            Type r11 = this.f2497c;
            if (r11 == null) goto L5;
            int r12 = r11.hashCode();
        L7:
            return r12 ^ r10;
        L5:
            r12 = 0;
            goto L7
        }

        public String toString() {
            int r10 = 1;
            StringBuilder r11 = new StringBuilder((this.f2499h.length + 1) * 30);
            r11.append(c0.w(this.f2498g));
            if (this.f2499h.length == 0) goto L5;
            r11.append("<");
            r11.append(c0.w(this.f2499h[0]));
        L8:
            if (r10 >= this.f2499h.length) goto L10;
            r11.append(", ");
            r11.append(c0.w(this.f2499h[r10]));
            r10 = r10 + 1;
            goto L8
        L10:
            r11.append(">");
            return r11.toString();
        L5:
            return r11.toString();
        }
    }

    private static final class d implements WildcardType {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Type f2500c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Type f2501g;

        d(Type[] r10, Type[] r11) {
            if (r11.length > 1) goto L18;
            if (r10.length != 1) goto L16;
            if (r11.length != 1) goto L13;
            Objects.requireNonNull(r11[0]);
            c0.b(r11[0]);
            if (r10[0] != Object.class) goto L12;
            this.f2501g = r11[0];
            this.f2500c = Object.class;
            return;
        L12:
            throw new IllegalArgumentException();
        L13:
            Objects.requireNonNull(r10[0]);
            c0.b(r10[0]);
            this.f2501g = null;
            this.f2500c = r10[0];
            return;
        L16:
            throw new IllegalArgumentException();
        L18:
            throw new IllegalArgumentException();
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof WildcardType) == true) goto L5;
        L7:
            return false;
        L5:
            if (c0.e(this, (WildcardType) r10) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type r10 = this.f2501g;
            if (r10 == null) goto L6;
            return new Type[]{r10};
        L6:
            return c0.f2494a;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.f2500c};
        }

        public int hashCode() {
            Type r10 = this.f2501g;
            if (r10 == null) goto L5;
            int r11 = r10.hashCode() + 31;
        L7:
            return (this.f2500c.hashCode() + 31) ^ r11;
        L5:
            r11 = 1;
            goto L7
        }

        public String toString() {
            if (this.f2501g == null) goto L8;
            StringBuilder r10 = new StringBuilder();
            r10.append("? super ");
            Type r11 = this.f2501g;
        L5:
            r10.append(c0.w(r11));
            return r10.toString();
        L8:
            if (this.f2500c != Object.class) goto L11;
            return "?";
        L11:
            r10 = new StringBuilder();
            r10.append("? extends ");
            r11 = this.f2500c;
            goto L5
        }
    }

    static {
        f2494a = new Type[0];
    }

    static <T> T a(T r10, String r11) {
        Objects.requireNonNull(r10, r11);
        return r10;
    }

    static void b(Type r10) {
        if ((r10 instanceof Class) == true) goto L5;
        return;
    L5:
        if (((Class) r10).isPrimitive() == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException();
    }

    public static r4.f c(okhttp3.y r10) {
        return new a(r10);
    }

    private static Class<?> d(TypeVariable<?> r10) {
        GenericDeclaration r11 = r10.getGenericDeclaration();
        if ((r11 instanceof Class) == true) goto L7;
        return null;
    L7:
        return (Class) r11;
    }

    static boolean e(Type r10, Type r11) {
        if (r10 != r11) goto L6;
        return true;
    L6:
        if ((r10 instanceof Class) == false) goto L10;
        return r10.equals(r11);
    L10:
        if ((r10 instanceof ParameterizedType) == false) goto L27;
        if ((r11 instanceof ParameterizedType) == true) goto L14;
        return false;
    L14:
        ParameterizedType r12 = (ParameterizedType) r10;
        ParameterizedType r13 = (ParameterizedType) r11;
        Type r14 = r12.getOwnerType();
        Type r15 = r13.getOwnerType();
        if (r14 == r15) goto L20;
        if (r14 == null) goto L25;
        if (r14.equals(r15) == true) goto L20;
    L25:
        return false;
    L20:
        if (r12.getRawType().equals(r13.getRawType()) == false) goto L25;
        if (Arrays.equals(r12.getActualTypeArguments(), r13.getActualTypeArguments()) == false) goto L25;
        return true;
    L27:
        if ((r10 instanceof GenericArrayType) == false) goto L34;
        if ((r11 instanceof GenericArrayType) == true) goto L32;
        return false;
    L32:
        return e(((GenericArrayType) r10).getGenericComponentType(), ((GenericArrayType) r11).getGenericComponentType());
    L34:
        if ((r10 instanceof WildcardType) == false) goto L46;
        if ((r11 instanceof WildcardType) == true) goto L38;
        return false;
    L38:
        WildcardType r16 = (WildcardType) r10;
        WildcardType r17 = (WildcardType) r11;
        if (Arrays.equals(r16.getUpperBounds(), r17.getUpperBounds()) == false) goto L44;
        if (Arrays.equals(r16.getLowerBounds(), r17.getLowerBounds()) == false) goto L44;
        return true;
    L44:
        return false;
    L46:
        if ((r10 instanceof TypeVariable) == true) goto L48;
        return false;
    L48:
        if ((r11 instanceof TypeVariable) == true) goto L50;
        return false;
    L50:
        TypeVariable r18 = (TypeVariable) r10;
        TypeVariable r19 = (TypeVariable) r11;
        if (r18.getGenericDeclaration() != r19.getGenericDeclaration()) goto L56;
        if (r18.getName().equals(r19.getName()) == false) goto L56;
        return true;
    L56:
        return false;
    }

    static Type f(Type r10) {
        if ((r10 instanceof ParameterizedType) == false) goto L7;
        return i(0, (ParameterizedType) r10);
    L7:
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }

    static Type g(Type r10, Class<?> r11, Class<?> r12) {
        if (r12 != r11) goto L5;
        return r10;
    L5:
        if (r12.isInterface() == false) goto L18;
        Class<?>[] r13 = r11.getInterfaces();
        int r14 = 0;
        int r15 = r13.length;
    L7:
        if (r14 >= r15) goto L18;
        if (r13[r14] == r12) goto L11;
        if (r12.isAssignableFrom(r13[r14]) == true) goto L15;
        r14 = r14 + 1;
        goto L7
    L15:
        return g(r11.getGenericInterfaces()[r14], r13[r14], r12);
    L11:
        return r11.getGenericInterfaces()[r14];
    L18:
        if (r11.isInterface() == false) goto L20;
    L30:
        return r12;
    L20:
        if (r11 == Object.class) goto L30;
        Class<? super Object> r16 = r11.getSuperclass();
        if (r16 == r12) goto L24;
        if (r12.isAssignableFrom(r16) == true) goto L28;
        r11 = r16;
        goto L20
    L28:
        return g(r11.getGenericSuperclass(), r16, r12);
    L24:
        return r11.getGenericSuperclass();
    }

    static Type h(int r10, ParameterizedType r11) {
        Type r12 = r11.getActualTypeArguments()[r10];
        if ((r12 instanceof WildcardType) == true) goto L5;
        return r12;
    L5:
        return ((WildcardType) r12).getLowerBounds()[0];
    }

    static Type i(int r10, ParameterizedType r11) {
        Type[] r12 = r11.getActualTypeArguments();
        if (r10 < 0) goto L11;
        if (r10 >= r12.length) goto L11;
        Type r13 = r12[r10];
        if ((r13 instanceof WildcardType) == true) goto L9;
        return r13;
    L9:
        return ((WildcardType) r13).getUpperBounds()[0];
    L11:
        throw new IllegalArgumentException("Index " + r10 + " not in range [0," + r12.length + ") for " + r11);
    }

    static Class<?> j(Type r10) {
        a(r10, "type == null");
        if ((r10 instanceof Class) == false) goto L7;
        return (Class) r10;
    L7:
        if ((r10 instanceof ParameterizedType) == false) goto L15;
        Type r11 = ((ParameterizedType) r10).getRawType();
        if ((r11 instanceof Class) == false) goto L13;
        return (Class) r11;
    L13:
        throw new IllegalArgumentException();
    L15:
        if ((r10 instanceof GenericArrayType) == false) goto L19;
        return Array.newInstance(j(((GenericArrayType) r10).getGenericComponentType()), 0).getClass();
    L19:
        if ((r10 instanceof TypeVariable) == false) goto L23;
        return Object.class;
    L23:
        if ((r10 instanceof WildcardType) == false) goto L27;
        return j(((WildcardType) r10).getUpperBounds()[0]);
    L27:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r10 + "> is of type " + r10.getClass().getName());
    }

    static Type k(Type r10, Class<?> r11, Class<?> r12) {
        if (r12.isAssignableFrom(r11) == false) goto L7;
        return t(r10, r11, g(r10, r11, r12));
    L7:
        throw new IllegalArgumentException();
    }

    static boolean l(Type r10) {
        if ((r10 instanceof Class) == false) goto L6;
        return false;
    L6:
        if ((r10 instanceof ParameterizedType) == false) goto L15;
        Type[] r11 = ((ParameterizedType) r10).getActualTypeArguments();
        int r12 = r11.length;
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L13;
        if (l(r11[r13]) == true) goto L11;
        r13 = r13 + 1;
        goto L8
    L11:
        return true;
    L13:
        return false;
    L15:
        if ((r10 instanceof GenericArrayType) == false) goto L19;
        return l(((GenericArrayType) r10).getGenericComponentType());
    L19:
        if ((r10 instanceof TypeVariable) == false) goto L22;
        return true;
    L22:
        if ((r10 instanceof WildcardType) == false) goto L24;
        return true;
    L24:
        if (r10 != null) goto L26;
        String r14 = "null";
    L28:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r10 + "> is of type " + r14);
    L26:
        r14 = r10.getClass().getName();
        goto L28
    }

    private static int m(Object[] r10, Object r11) {
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L10;
        if (r11.equals(r10[r12]) == true) goto L7;
        r12 = r12 + 1;
        goto L4
    L7:
        return r12;
    L10:
        throw new NoSuchElementException();
    }

    static boolean n(Annotation[] r10, Class<? extends Annotation> r11) {
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        if (r11.isInstance(r10[r13]) == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    static RuntimeException o(Method r10, String r11, Object... r12) {
        return p(r10, null, r11, r12);
    }

    static RuntimeException p(Method r10, Throwable r11, String r12, Object... r13) {
        return new IllegalArgumentException(String.format(r12, r13) + "\n    for method " + r10.getDeclaringClass().getSimpleName() + "." + r10.getName(), r11);
    }

    static RuntimeException q(Method r10, int r11, String r12, Object... r13) {
        return o(r10, r12 + " (parameter #" + (r11 + 1) + ")", r13);
    }

    static RuntimeException r(Method r10, Throwable r11, int r12, String r13, Object... r14) {
        return p(r10, r11, r13 + " (parameter #" + (r12 + 1) + ")", r14);
    }

    public static boolean s(String r10) {
        if (r10.equals(CloudConfig.REQUEST_TYPE_POST) == false) goto L5;
    L14:
        return true;
    L5:
        if (r10.equals("PUT") == true) goto L14;
        if (r10.equals("PATCH") == true) goto L14;
        if (r10.equals("PROPPATCH") == true) goto L14;
        if (r10.equals("REPORT") == true) goto L14;
        return false;
    }

    static Type t(Type r10, Class<?> r11, Type r12) {
    L3:
        if ((r10 instanceof TypeVariable) == false) goto L9;
        TypeVariable r13 = (TypeVariable) r10;
        Type r14 = u(r10, r11, r13);
        if (r14 == r13) goto L6;
        Type r15 = r14;
        goto L3
    L6:
        return r14;
    L9:
        if ((r15 instanceof Class) == false) goto L18;
        Class r16 = (Class) r15;
        if (r16.isArray() == false) goto L18;
        Class<?> r17 = r16.getComponentType();
        Type r18 = t(r10, r11, r17);
        if (r17 != r18) goto L16;
        return r16;
    L16:
        return new b(r18);
    L18:
        if ((r15 instanceof GenericArrayType) == false) goto L24;
        GenericArrayType r19 = (GenericArrayType) r15;
        Type r20 = r19.getGenericComponentType();
        Type r21 = t(r10, r11, r20);
        if (r20 != r21) goto L23;
        return r19;
    L23:
        return new b(r21);
    L24:
        int r22 = 0;
        if ((r15 instanceof ParameterizedType) == false) goto L41;
        ParameterizedType r110 = (ParameterizedType) r15;
        Type r23 = r110.getOwnerType();
        Type r24 = t(r10, r11, r23);
        if (r24 == r23) goto L29;
        boolean r25 = true;
    L30:
        Type[] r26 = r110.getActualTypeArguments();
        int r27 = r26.length;
    L31:
        if (r22 >= r27) goto L38;
        Type r28 = t(r10, r11, r26[r22]);
        if (r28 == r26[r22]) goto L37;
        if (r25 == true) goto L36;
        r26 = (Type[]) r26.clone();
        r25 = true;
    L36:
        r26[r22] = r28;
    L37:
        r22 = r22 + 1;
        goto L31
    L38:
        if (r25 == true) goto L40;
        return r110;
    L40:
        return new c(r24, r110.getRawType(), r26);
    L29:
        r25 = false;
        goto L30
    L41:
        boolean r29 = r15 instanceof WildcardType;
        Type r111 = r15;
        if (r29 == false) goto L55;
        WildcardType r112 = (WildcardType) r15;
        Type[] r30 = r112.getLowerBounds();
        Type[] r31 = r112.getUpperBounds();
        if (r30.length != 1) goto L49;
        Type r32 = t(r10, r11, r30[0]);
        r111 = r112;
        if (r32 == r30[0]) goto L55;
        return new d(new Type[]{Object.class}, new Type[]{r32});
    L49:
        r111 = r112;
        if (r31.length != 1) goto L55;
        Type r33 = t(r10, r11, r31[0]);
        r111 = r112;
        if (r33 == r31[0]) goto L55;
        return new d(new Type[]{r33}, f2494a);
    L55:
        return r111;
    }

    private static Type u(Type r10, Class<?> r11, TypeVariable<?> r12) {
        Class<?> r13 = d(r12);
        if (r13 != null) goto L5;
        return r12;
    L5:
        Type r14 = g(r10, r11, r13);
        if ((r14 instanceof ParameterizedType) == false) goto L9;
        int r15 = m(r13.getTypeParameters(), r12);
        return ((ParameterizedType) r14).getActualTypeArguments()[r15];
    L9:
        return r12;
    }

    static byte[] v(InputStream r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        if (r10 == null) goto L9;
        byte[] r12 = new byte[4096];
    L5:
        int r13 = r10.read(r12);
        if (r13 == (-1)) goto L9;
        r11.write(r12, 0, r13);
    L9:
        return r11.toByteArray();
    }

    static String w(Type r10) {
        if ((r10 instanceof Class) == false) goto L6;
        return ((Class) r10).getName();
    L6:
        return r10.toString();
    }

    static <T> void x(Class<T> r10) {
        if (r10.isInterface() == false) goto L10;
        if (r10.getInterfaces().length > 0) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
    L10:
        throw new IllegalArgumentException("API declarations must be interfaces.");
    }
}
