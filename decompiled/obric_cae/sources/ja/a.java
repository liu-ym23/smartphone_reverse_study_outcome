package ja;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Type[] f8749a = null;

    /* JADX INFO: renamed from: ja.a$a, reason: collision with other inner class name */
    public static final class C0103a implements GenericArrayType, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f8750a;

        public C0103a(Type r8) {
            Objects.requireNonNull(r8);
            this.f8750a = a.a(r8);
        }

        public final boolean equals(Object r8) {
            if ((r8 instanceof GenericArrayType) == true) goto L5;
        L7:
            return false;
        L5:
            if (a.c(this, (GenericArrayType) r8) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.GenericArrayType
        public final Type getGenericComponentType() {
            return this.f8750a;
        }

        public final int hashCode() {
            return this.f8750a.hashCode();
        }

        public final String toString() {
            return a.h(this.f8750a) + "[]";
        }
    }

    public static final class b implements ParameterizedType, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f8751a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Type f8752b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Type[] f8753m;

        public b(Type r8, Type r10, Type... r11) {
            Objects.requireNonNull(r10);
            int r12 = 0;
            if ((r10 instanceof Class) == false) goto L16;
            Class r13 = (Class) r10;
            boolean r14 = true;
            if (Modifier.isStatic(r13.getModifiers()) == false) goto L7;
        L10:
            boolean r15 = true;
        L11:
            if (r8 != null) goto L15;
            if (r15 == true) goto L15;
            r14 = false;
        L15:
            l6.a.t(r14);
            goto L16
        L7:
            if (r13.getEnclosingClass() == null) goto L10;
            r15 = false;
        L16:
            if (r8 != null) goto L18;
            Type r16 = null;
        L19:
            this.f8751a = r16;
            this.f8752b = a.a(r10);
            Type[] r17 = (Type[]) r11.clone();
            this.f8753m = r17;
            int r18 = r17.length;
        L20:
            if (r12 >= r18) goto L22;
            Objects.requireNonNull(this.f8753m[r12]);
            a.b(this.f8753m[r12]);
            Type[] r19 = this.f8753m;
            r19[r12] = a.a(r19[r12]);
            r12 = r12 + 1;
            goto L20
        L22:
            return;
        L18:
            r16 = a.a(r8);
            goto L19
        }

        public final boolean equals(Object r8) {
            if ((r8 instanceof ParameterizedType) == true) goto L5;
        L7:
            return false;
        L5:
            if (a.c(this, (ParameterizedType) r8) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type[] getActualTypeArguments() {
            return (Type[]) this.f8753m.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type getOwnerType() {
            return this.f8751a;
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type getRawType() {
            return this.f8752b;
        }

        public final int hashCode() {
            int r8 = Arrays.hashCode(this.f8753m) ^ this.f8752b.hashCode();
            Type r10 = this.f8751a;
            if (r10 == null) goto L5;
            int r11 = r10.hashCode();
        L7:
            return r11 ^ r8;
        L5:
            r11 = 0;
            goto L7
        }

        public final String toString() {
            Type[] r8 = this.f8753m;
            int r10 = r8.length;
            Type r11 = this.f8752b;
            if (r10 == 0) goto L5;
            StringBuilder r12 = new StringBuilder((r10 + 1) * 30);
            r12.append(a.h(r11));
            r12.append("<");
            r12.append(a.h(r8[0]));
            int r13 = 1;
        L7:
            if (r13 >= r10) goto L9;
            r12.append(", ");
            r12.append(a.h(r8[r13]));
            r13 = r13 + 1;
            goto L7
        L9:
            r12.append(">");
            return r12.toString();
        L5:
            return a.h(r11);
        }
    }

    public static final class c implements WildcardType, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f8754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Type f8755b;

        public c(Type[] r8, Type[] r10) {
            boolean r11 = true;
            if (r10.length > 1) goto L5;
            boolean r12 = true;
        L6:
            l6.a.t(r12);
            if (r8.length != 1) goto L9;
            boolean r13 = true;
        L10:
            l6.a.t(r13);
            if (r10.length != 1) goto L17;
            Objects.requireNonNull(r10[0]);
            a.b(r10[0]);
            if (r8[0] == Object.class) goto L16;
            r11 = false;
        L16:
            l6.a.t(r11);
            this.f8755b = a.a(r10[0]);
            this.f8754a = Object.class;
            return;
        L17:
            Objects.requireNonNull(r8[0]);
            a.b(r8[0]);
            this.f8755b = null;
            this.f8754a = a.a(r8[0]);
            return;
        L9:
            r13 = false;
            goto L10
        L5:
            r12 = false;
            goto L6
        }

        public final boolean equals(Object r8) {
            if ((r8 instanceof WildcardType) == true) goto L5;
        L7:
            return false;
        L5:
            if (a.c(this, (WildcardType) r8) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.WildcardType
        public final Type[] getLowerBounds() {
            Type r8 = this.f8755b;
            if (r8 == null) goto L6;
            return new Type[]{r8};
        L6:
            return a.f8749a;
        }

        @Override // java.lang.reflect.WildcardType
        public final Type[] getUpperBounds() {
            return new Type[]{this.f8754a};
        }

        public final int hashCode() {
            Type r8 = this.f8755b;
            if (r8 == null) goto L5;
            int r10 = r8.hashCode() + 31;
        L7:
            return (this.f8754a.hashCode() + 31) ^ r10;
        L5:
            r10 = 1;
            goto L7
        }

        public final String toString() {
            Type r8 = this.f8755b;
            if (r8 != null) goto L5;
            Type r10 = this.f8754a;
            if (r10 != Object.class) goto L11;
            return "?";
        L11:
            return "? extends " + a.h(r10);
        L5:
            return "? super " + a.h(r8);
        }
    }

    static {
        f8749a = new Type[0];
    }

    public static Type a(Type r8) {
        if ((r8 instanceof Class) == false) goto L9;
        Class r10 = (Class) r8;
        if (r10.isArray() == true) goto L7;
        return r10;
    L7:
        return new C0103a(a(r10.getComponentType()));
    L9:
        if ((r8 instanceof ParameterizedType) == false) goto L13;
        ParameterizedType r11 = (ParameterizedType) r8;
        return new b(r11.getOwnerType(), r11.getRawType(), r11.getActualTypeArguments());
    L13:
        if ((r8 instanceof GenericArrayType) == false) goto L17;
        return new C0103a(((GenericArrayType) r8).getGenericComponentType());
    L17:
        if ((r8 instanceof WildcardType) == false) goto L20;
        WildcardType r12 = (WildcardType) r8;
        return new c(r12.getUpperBounds(), r12.getLowerBounds());
    L20:
        return r8;
    }

    public static void b(Type r8) {
        if ((r8 instanceof Class) == true) goto L5;
    L8:
        boolean r10 = true;
    L9:
        l6.a.t(r10);
        return;
    L5:
        if (((Class) r8).isPrimitive() == false) goto L8;
        r10 = false;
        goto L9
    }

    public static boolean c(Type r8, Type r10) {
        if (r8 != r10) goto L6;
        return true;
    L6:
        if ((r8 instanceof Class) == false) goto L10;
        return r8.equals(r10);
    L10:
        if ((r8 instanceof ParameterizedType) == false) goto L24;
        if ((r10 instanceof ParameterizedType) == true) goto L14;
        return false;
    L14:
        ParameterizedType r11 = (ParameterizedType) r8;
        ParameterizedType r12 = (ParameterizedType) r10;
        if (Objects.equals(r11.getOwnerType(), r12.getOwnerType()) == false) goto L22;
        if (r11.getRawType().equals(r12.getRawType()) == false) goto L22;
        if (Arrays.equals(r11.getActualTypeArguments(), r12.getActualTypeArguments()) == false) goto L22;
        return true;
    L22:
        return false;
    L24:
        if ((r8 instanceof GenericArrayType) == false) goto L31;
        if ((r10 instanceof GenericArrayType) == true) goto L29;
        return false;
    L29:
        return c(((GenericArrayType) r8).getGenericComponentType(), ((GenericArrayType) r10).getGenericComponentType());
    L31:
        if ((r8 instanceof WildcardType) == false) goto L43;
        if ((r10 instanceof WildcardType) == true) goto L35;
        return false;
    L35:
        WildcardType r13 = (WildcardType) r8;
        WildcardType r14 = (WildcardType) r10;
        if (Arrays.equals(r13.getUpperBounds(), r14.getUpperBounds()) == false) goto L41;
        if (Arrays.equals(r13.getLowerBounds(), r14.getLowerBounds()) == false) goto L41;
        return true;
    L41:
        return false;
    L43:
        if ((r8 instanceof TypeVariable) == true) goto L45;
        return false;
    L45:
        if ((r10 instanceof TypeVariable) == true) goto L47;
        return false;
    L47:
        TypeVariable r15 = (TypeVariable) r8;
        TypeVariable r16 = (TypeVariable) r10;
        if (r15.getGenericDeclaration() != r16.getGenericDeclaration()) goto L53;
        if (r15.getName().equals(r16.getName()) == false) goto L53;
        return true;
    L53:
        return false;
    }

    public static Type d(Type r8, Class<?> r10, Class<?> r11) {
        if (r11 != r10) goto L5;
        return r8;
    L5:
        if (r11.isInterface() == false) goto L18;
        Class<?>[] r12 = r10.getInterfaces();
        int r13 = r12.length;
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L18;
        Class<?> r15 = r12[r14];
        if (r15 == r11) goto L11;
        if (r11.isAssignableFrom(r15) == true) goto L15;
        r14 = r14 + 1;
        goto L7
    L15:
        return d(r10.getGenericInterfaces()[r14], r12[r14], r11);
    L11:
        return r10.getGenericInterfaces()[r14];
    L18:
        if (r10.isInterface() == false) goto L20;
    L30:
        return r11;
    L20:
        if (r10 == Object.class) goto L30;
        Class<? super Object> r16 = r10.getSuperclass();
        if (r16 == r11) goto L24;
        if (r11.isAssignableFrom(r16) == true) goto L28;
        r10 = r16;
        goto L20
    L28:
        return d(r10.getGenericSuperclass(), r16, r11);
    L24:
        return r10.getGenericSuperclass();
    }

    public static Class<?> e(Type r8) {
        if ((r8 instanceof Class) == false) goto L7;
        return (Class) r8;
    L7:
        if ((r8 instanceof ParameterizedType) == false) goto L11;
        Type r10 = ((ParameterizedType) r8).getRawType();
        l6.a.t(r10 instanceof Class);
        return (Class) r10;
    L11:
        if ((r8 instanceof GenericArrayType) == false) goto L15;
        return Array.newInstance(e(((GenericArrayType) r8).getGenericComponentType()), 0).getClass();
    L15:
        if ((r8 instanceof TypeVariable) == false) goto L19;
        return Object.class;
    L19:
        if ((r8 instanceof WildcardType) == true) goto L21;
        if (r8 != null) goto L24;
        String r11 = "null";
    L26:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r8 + "> is of type " + r11);
    L24:
        r11 = r8.getClass().getName();
        goto L26
    L21:
        return e(((WildcardType) r8).getUpperBounds()[0]);
    }

    public static Type f(Type r8, Class<?> r10, Class<?> r11) {
        if ((r8 instanceof WildcardType) == false) goto L5;
        r8 = ((WildcardType) r8).getUpperBounds()[0];
    L5:
        l6.a.t(r11.isAssignableFrom(r10));
        return g(r8, r10, d(r8, r10, r11), new HashMap());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v10, types: [java.lang.Object, java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v19, types: [java.lang.reflect.Type[]] */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v3, types: [ja.a$c] */
    /* JADX WARN: Type inference failed for: r11v4, types: [ja.a$c] */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.lang.reflect.ParameterizedType] */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.reflect.GenericArrayType] */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public static Type g(Type r10, Class r11, Type r12, HashMap r13) {
        TypeVariable r8 = null;
    L3:
        int r14 = 0;
        if ((r12 instanceof TypeVariable) == false) goto L35;
        TypeVariable r15 = (TypeVariable) r12;
        Type r16 = (Type) r13.get(r15);
        if (r16 != null) goto L8;
        r13.put(r15, Void.TYPE);
        if (r8 != null) goto L15;
        r8 = r15;
    L15:
        GenericDeclaration r17 = r15.getGenericDeclaration();
        if ((r17 instanceof Class) == false) goto L18;
        Class r18 = (Class) r17;
    L19:
        if (r18 == null) goto L31;
        Type r19 = d(r10, r11, r18);
        if ((r19 instanceof ParameterizedType) == false) goto L31;
        TypeVariable[] r110 = r18.getTypeParameters();
        int r20 = r110.length;
    L24:
        if (r14 >= r20) goto L30;
        if (r15.equals(r110[r14]) == true) goto L27;
        r14 = r14 + 1;
        goto L24
    L27:
        r12 = ((ParameterizedType) r19).getActualTypeArguments()[r14];
    L32:
        if (r12 != r15) goto L3;
    L81:
        if (r8 == null) goto L83;
        r13.put(r8, r12);
    L83:
        return r12;
    L30:
        throw new NoSuchElementException();
    L31:
        r12 = r15;
        goto L32
    L18:
        r18 = null;
        goto L19
    L8:
        if (r16 != Void.TYPE) goto L11;
        return r12;
    L11:
        return r16;
    L35:
        if ((r12 instanceof Class) == false) goto L43;
        Class r21 = (Class) r12;
        if (r21.isArray() == false) goto L43;
        Class<?> r111 = r21.getComponentType();
        Type r22 = g(r10, r11, r111, r13);
        if (Objects.equals(r111, r22) == false) goto L41;
        r12 = r21;
        goto L81
    L41:
        Type r112 = new C0103a(r22);
    L48:
        r12 = r112;
    L43:
        if ((r12 instanceof GenericArrayType) == false) goto L50;
        r12 = (GenericArrayType) r12;
        Type r23 = r12.getGenericComponentType();
        Type r24 = g(r10, r11, r23, r13);
        if (Objects.equals(r23, r24) == true) goto L81;
        r112 = new C0103a(r24);
        goto L48
    L50:
        if ((r12 instanceof ParameterizedType) == false) goto L62;
        r12 = (ParameterizedType) r12;
        Type r25 = r12.getOwnerType();
        Type r26 = g(r10, r11, r25, r13);
        boolean r27 = !Objects.equals(r26, r25);
        Type[] r28 = r12.getActualTypeArguments();
        int r29 = r28.length;
    L52:
        if (r14 >= r29) goto L59;
        Type r30 = g(r10, r11, r28[r14], r13);
        if (Objects.equals(r30, r28[r14]) == true) goto L58;
        if (r27 == true) goto L57;
        r28 = (Type[]) r28.clone();
        r27 = true;
    L57:
        r28[r14] = r30;
    L58:
        r14 = r14 + 1;
        goto L52
    L59:
        if (r27 == false) goto L81;
        r112 = new b(r26, r12.getRawType(), r28);
        goto L48
    L62:
        if ((r12 instanceof WildcardType) == false) goto L81;
        r12 = (WildcardType) r12;
        Type[] r31 = r12.getLowerBounds();
        Type[] r32 = r12.getUpperBounds();
        if (r31.length != 1) goto L73;
        Type r33 = g(r10, r11, r31[0], r13);
        if (r33 == r31[0]) goto L81;
        if ((r33 instanceof WildcardType) == false) goto L70;
        Type[] r34 = ((WildcardType) r33).getLowerBounds();
    L71:
        r12 = new c(new Type[]{Object.class}, r34);
        goto L81
    L70:
        r34 = new Type[]{r33};
        goto L71
    L73:
        if (r32.length != 1) goto L81;
        Type r35 = g(r10, r11, r32[0], r13);
        if (r35 == r32[0]) goto L81;
        if ((r35 instanceof WildcardType) == false) goto L79;
        Type[] r36 = ((WildcardType) r35).getUpperBounds();
    L80:
        r12 = new c(r36, f8749a);
        goto L81
    L79:
        r36 = new Type[]{r35};
        goto L80
    }

    public static String h(Type r8) {
        if ((r8 instanceof Class) == false) goto L6;
        return ((Class) r8).getName();
    L6:
        return r8.toString();
    }
}
