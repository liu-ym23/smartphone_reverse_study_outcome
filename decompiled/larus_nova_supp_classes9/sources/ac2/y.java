package ac2;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y {
    public static final Type[] a = null;

    public static final class a implements GenericArrayType {
        public final Type a;

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return y.h(this.a) + "[]";
        }

        @Override // java.lang.reflect.GenericArrayType
        public final Type getGenericComponentType() {
            return this.a;
        }

        public a(Type r1) {
            this.a = r1;
        }

        public final boolean equals(Object r2) {
            if ((r2 instanceof GenericArrayType) == true) goto L5;
        L7:
            return false;
        L5:
            if (y.b(this, (GenericArrayType) r2) == false) goto L7;
            return true;
        }
    }

    public static final class b implements ParameterizedType {
        public final Type a;
        public final Type b;
        public final Type[] c;

        @Override // java.lang.reflect.ParameterizedType
        public final Type[] getActualTypeArguments() {
            return (Type[]) this.c.clone();
        }

        public final int hashCode() {
            int r0 = Arrays.hashCode(this.c) ^ this.b.hashCode();
            Type r1 = this.a;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return r0 ^ r2;
        L5:
            r2 = 0;
            goto L7
        }

        public final String toString() {
            int r2 = 1;
            StringBuilder r0 = new StringBuilder((this.c.length + 1) * 30);
            r0.append(y.h(this.b));
            if (this.c.length == 0) goto L5;
            r0.append("<");
            r0.append(y.h(this.c[0]));
        L8:
            if (r2 >= this.c.length) goto L10;
            r0.append(", ");
            r0.append(y.h(this.c[r2]));
            r2 = r2 + 1;
            goto L8
        L10:
            r0.append(">");
            return r0.toString();
        L5:
            return r0.toString();
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type getOwnerType() {
            return this.a;
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type getRawType() {
            return this.b;
        }

        public final boolean equals(Object r2) {
            if ((r2 instanceof ParameterizedType) == true) goto L5;
        L7:
            return false;
        L5:
            if (y.b(this, (ParameterizedType) r2) == false) goto L7;
            return true;
        }

        public b(Type r5, Type r6, Type... r7) {
            int r1 = 0;
            if ((r6 instanceof Class) == false) goto L16;
            boolean r0 = true;
            if (r5 != null) goto L7;
            boolean r2 = true;
        L9:
            if (((Class) r6).getEnclosingClass() == null) goto L12;
            r0 = false;
        L12:
            if (r2 == r0) goto L16;
            throw new IllegalArgumentException();
        L7:
            r2 = false;
        L16:
            this.a = r5;
            this.b = r6;
            Type[] r8 = (Type[]) r7.clone();
            this.c = r8;
            int r9 = r8.length;
        L17:
            if (r1 >= r9) goto L19;
            Type r10 = r8[r1];
            r10.getClass();
            y.a(r10);
            r1 = r1 + 1;
            goto L17
        }
    }

    public static final class c implements WildcardType {
        public final Type a;
        public final Type b;

        @Override // java.lang.reflect.WildcardType
        public final Type[] getUpperBounds() {
            return new Type[]{this.a};
        }

        @Override // java.lang.reflect.WildcardType
        public final Type[] getLowerBounds() {
            Type r0 = this.b;
            if (r0 == null) goto L6;
            return new Type[]{r0};
        L6:
            return y.a;
        }

        public final int hashCode() {
            Type r0 = this.b;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode() + 31;
        L7:
            return r1 ^ (this.a.hashCode() + 31);
        L5:
            r1 = 1;
            goto L7
        }

        public final String toString() {
            if (this.b == null) goto L7;
            return "? super " + y.h(this.b);
        L7:
            if (this.a != Object.class) goto L11;
            return "?";
        L11:
            return "? extends " + y.h(this.a);
        }

        public final boolean equals(Object r2) {
            if ((r2 instanceof WildcardType) == true) goto L5;
        L7:
            return false;
        L5:
            if (y.b(this, (WildcardType) r2) == false) goto L7;
            return true;
        }

        public c(Type[] r4, Type[] r5) {
            if (r5.length > 1) goto L18;
            if (r4.length != 1) goto L16;
            if (r5.length != 1) goto L13;
            Type r0 = r5[0];
            r0.getClass();
            y.a(r0);
            if (r4[0] != Object.class) goto L12;
            this.b = r5[0];
            this.a = Object.class;
            return;
        L12:
            throw new IllegalArgumentException();
        L13:
            Type r6 = r4[0];
            r6.getClass();
            y.a(r6);
            this.b = null;
            this.a = r4[0];
            return;
        L16:
            throw new IllegalArgumentException();
        L18:
            throw new IllegalArgumentException();
        }
    }

    static {
        a = new Type[0];
    }

    public static void a(Type r1) {
        if ((r1 instanceof Class) == true) goto L5;
        return;
    L5:
        if (((Class) r1).isPrimitive() == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException();
    }

    public static Class<?> e(Type r3) {
        if (r3 == null) goto L30;
        if ((r3 instanceof Class) == false) goto L8;
        return (Class) r3;
    L8:
        if ((r3 instanceof ParameterizedType) == false) goto L16;
        Type r4 = ((ParameterizedType) r3).getRawType();
        if ((r4 instanceof Class) == false) goto L14;
        return (Class) r4;
    L14:
        throw new IllegalArgumentException();
    L16:
        if ((r3 instanceof GenericArrayType) == false) goto L20;
        return Array.newInstance(e(((GenericArrayType) r3).getGenericComponentType()), 0).getClass();
    L20:
        if ((r3 instanceof TypeVariable) == false) goto L24;
        return Object.class;
    L24:
        if ((r3 instanceof WildcardType) == false) goto L28;
        return e(((WildcardType) r3).getUpperBounds()[0]);
    L28:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r3 + "> is of type " + r3.getClass().getName());
    L30:
        throw new NullPointerException("type == null");
    }

    public static boolean f(Type r5) {
        if ((r5 instanceof Class) == false) goto L6;
        return false;
    L6:
        if ((r5 instanceof ParameterizedType) == false) goto L15;
        Type[] r6 = ((ParameterizedType) r5).getActualTypeArguments();
        int r0 = r6.length;
        int r3 = 0;
    L8:
        if (r3 >= r0) goto L13;
        if (f(r6[r3]) == true) goto L11;
        r3 = r3 + 1;
        goto L8
    L11:
        return true;
    L13:
        return false;
    L15:
        if ((r5 instanceof GenericArrayType) == false) goto L19;
        return f(((GenericArrayType) r5).getGenericComponentType());
    L19:
        if ((r5 instanceof TypeVariable) == false) goto L22;
        return true;
    L22:
        if ((r5 instanceof WildcardType) == false) goto L24;
        return true;
    L24:
        if (r5 != null) goto L26;
        String r1 = "null";
    L28:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r5 + "> is of type " + r1);
    L26:
        r1 = r5.getClass().getName();
        goto L28
    }

    public static String h(Type r1) {
        if ((r1 instanceof Class) == false) goto L6;
        return ((Class) r1).getName();
    L6:
        return r1.toString();
    }

    public static <T> void i(Class<T> r1) {
        if (r1.isInterface() == false) goto L10;
        if (r1.getInterfaces().length > 0) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
    L10:
        throw new IllegalArgumentException("API declarations must be interfaces.");
    }

    public static boolean b(Type r4, Type r5) {
        if (r4 != r5) goto L6;
        return true;
    L6:
        if ((r4 instanceof Class) == false) goto L10;
        return r4.equals(r5);
    L10:
        if ((r4 instanceof ParameterizedType) == false) goto L31;
        if ((r5 instanceof ParameterizedType) == true) goto L14;
        return false;
    L14:
        ParameterizedType r6 = (ParameterizedType) r4;
        ParameterizedType r7 = (ParameterizedType) r5;
        Type r1 = r6.getOwnerType();
        Type r3 = r7.getOwnerType();
        if (r1 == r3) goto L21;
        if (r1 != null) goto L18;
    L20:
        boolean r2 = false;
    L22:
        if (r2 == true) goto L24;
    L28:
        return false;
    L24:
        if (r6.getRawType().equals(r7.getRawType()) == false) goto L28;
        if (Arrays.equals(r6.getActualTypeArguments(), r7.getActualTypeArguments()) == false) goto L28;
        return true;
    L18:
        if (r1.equals(r3) == false) goto L20;
    L21:
        r2 = true;
        goto L22
    L31:
        if ((r4 instanceof GenericArrayType) == false) goto L38;
        if ((r5 instanceof GenericArrayType) == true) goto L36;
        return false;
    L36:
        return b(((GenericArrayType) r4).getGenericComponentType(), ((GenericArrayType) r5).getGenericComponentType());
    L38:
        if ((r4 instanceof WildcardType) == false) goto L50;
        if ((r5 instanceof WildcardType) == true) goto L42;
        return false;
    L42:
        WildcardType r8 = (WildcardType) r4;
        WildcardType r9 = (WildcardType) r5;
        if (Arrays.equals(r8.getUpperBounds(), r9.getUpperBounds()) == true) goto L45;
    L47:
        return false;
    L45:
        if (Arrays.equals(r8.getLowerBounds(), r9.getLowerBounds()) == false) goto L47;
        return true;
    L50:
        if ((r4 instanceof TypeVariable) == true) goto L52;
        return false;
    L52:
        if ((r5 instanceof TypeVariable) == true) goto L54;
        return false;
    L54:
        TypeVariable r10 = (TypeVariable) r4;
        TypeVariable r11 = (TypeVariable) r5;
        if (r10.getGenericDeclaration() == r11.getGenericDeclaration()) goto L57;
    L59:
        return false;
    L57:
        if (r10.getName().equals(r11.getName()) == false) goto L59;
        return true;
    }

    public static Type d(int r4, ParameterizedType r5) {
        Type[] r0 = r5.getActualTypeArguments();
        if (r4 < 0) goto L11;
        if (r4 >= r0.length) goto L11;
        Type r6 = r0[r4];
        if ((r6 instanceof WildcardType) == true) goto L9;
        return r6;
    L9:
        return ((WildcardType) r6).getUpperBounds()[0];
    L11:
        throw new IllegalArgumentException("Index " + r4 + " not in range [0," + r0.length + ") for " + r5);
    }

    public static Type c(Type r3, Class<?> r4, Class<?> r5) {
        if (r5 != r4) goto L5;
        return r3;
    L5:
        if (r5.isInterface() == false) goto L18;
        Class<?>[] r6 = r4.getInterfaces();
        int r0 = r6.length;
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L18;
        Class<?> r2 = r6[r1];
        if (r2 == r5) goto L11;
        if (r5.isAssignableFrom(r2) == true) goto L15;
        r1 = r1 + 1;
        goto L7
    L15:
        return c(r4.getGenericInterfaces()[r1], r6[r1], r5);
    L11:
        return r4.getGenericInterfaces()[r1];
    L18:
        if (r4.isInterface() == false) goto L20;
    L30:
        return r5;
    L20:
        if (r4 == Object.class) goto L30;
        Class<? super Object> r7 = r4.getSuperclass();
        if (r7 == r5) goto L24;
        if (r5.isAssignableFrom(r7) == true) goto L28;
        r4 = r7;
        goto L20
    L28:
        return c(r4.getGenericSuperclass(), r7, r5);
    L24:
        return r4.getGenericSuperclass();
    }

    public static Type g(Type r8, Class<?> r9, Type r10) {
    L2:
        int r1 = 0;
        if ((r10 instanceof TypeVariable) == false) goto L26;
        TypeVariable r11 = (TypeVariable) r10;
        GenericDeclaration r0 = r11.getGenericDeclaration();
        if ((r0 instanceof Class) == false) goto L7;
        Class r2 = (Class) r0;
    L8:
        if (r2 == null) goto L21;
        Type r3 = c(r8, r9, r2);
        if ((r3 instanceof ParameterizedType) == false) goto L21;
        TypeVariable[] r4 = r2.getTypeParameters();
    L14:
        if (r1 >= r4.length) goto L20;
        if (r11.equals(r4[r1]) == true) goto L17;
        r1 = r1 + 1;
        goto L14
    L17:
        Type r5 = ((ParameterizedType) r3).getActualTypeArguments()[r1];
    L22:
        if (r5 == r11) goto L23;
        Type r13 = r5;
        goto L2
    L23:
        return r5;
    L20:
        throw new NoSuchElementException();
    L21:
        r5 = r11;
        goto L22
    L7:
        r2 = null;
        goto L8
    L26:
        if ((r13 instanceof Class) == false) goto L35;
        Class r6 = (Class) r13;
        if (r6.isArray() == false) goto L35;
        Class<?> r14 = r6.getComponentType();
        Type r15 = g(r8, r9, r14);
        if (r14 != r15) goto L33;
        return r6;
    L33:
        return new a(r15);
    L35:
        if ((r13 instanceof GenericArrayType) == false) goto L42;
        GenericArrayType r16 = (GenericArrayType) r13;
        Type r7 = r16.getGenericComponentType();
        Type r17 = g(r8, r9, r7);
        if (r7 != r17) goto L40;
        return r16;
    L40:
        return new a(r17);
    L42:
        if ((r13 instanceof ParameterizedType) == false) goto L58;
        ParameterizedType r18 = (ParameterizedType) r13;
        Type r19 = r18.getOwnerType();
        Type r20 = g(r8, r9, r19);
        if (r20 == r19) goto L46;
        boolean r21 = true;
    L47:
        Type[] r23 = r18.getActualTypeArguments();
        int r24 = r23.length;
    L48:
        if (r1 >= r24) goto L55;
        Type r25 = g(r8, r9, r23[r1]);
        if (r25 == r23[r1]) goto L54;
        if (r21 == true) goto L53;
        r23 = (Type[]) r23.clone();
        r21 = true;
    L53:
        r23[r1] = r25;
    L54:
        r1 = r1 + 1;
        goto L48
    L55:
        if (r21 == true) goto L57;
        return r18;
    L57:
        return new b(r20, r18.getRawType(), r23);
    L46:
        r21 = false;
        goto L47
    L58:
        boolean r26 = r13 instanceof WildcardType;
        Type r110 = r13;
        if (r26 == false) goto L76;
        WildcardType r111 = (WildcardType) r13;
        Type[] r27 = r111.getLowerBounds();
        Type[] r28 = r111.getUpperBounds();
        if (r27.length != 1) goto L66;
        Type r29 = g(r8, r9, r27[0]);
        r110 = r111;
        if (r29 == r27[0]) goto L76;
        return new c(new Type[]{Object.class}, new Type[]{r29});
    L66:
        r110 = r111;
        if (r28.length != 1) goto L76;
        Type r30 = g(r8, r9, r28[0]);     // Catch: Throwable -> L74
        r110 = r111;
        if (r30 == r28[0]) goto L76;
        return new c(new Type[]{r30}, a);
    L74:
        th = move-exception;
        throw th;
    L76:
        return r110;
    }
}
