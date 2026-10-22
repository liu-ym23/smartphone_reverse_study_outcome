package com.google.gson.internal;

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
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Properties;

/* JADX INFO: renamed from: com.google.gson.internal.$Gson$Types, reason: invalid class name */
/* JADX INFO: loaded from: classes2.dex */
public final class C$Gson$Types {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Type[] f4214a = null;

    /* JADX INFO: renamed from: com.google.gson.internal.$Gson$Types$GenericArrayTypeImpl */
    private static final class GenericArrayTypeImpl implements GenericArrayType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type componentType;

        public GenericArrayTypeImpl(Type r10) {
            Objects.requireNonNull(r10);
            this.componentType = C$Gson$Types.b(r10);
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof GenericArrayType) == true) goto L5;
        L7:
            return false;
        L5:
            if (C$Gson$Types.f(this, (GenericArrayType) r10) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.componentType;
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return C$Gson$Types.t(this.componentType) + "[]";
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.$Gson$Types$ParameterizedTypeImpl */
    private static final class ParameterizedTypeImpl implements ParameterizedType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type ownerType;
        private final Type rawType;
        private final Type[] typeArguments;

        public ParameterizedTypeImpl(Type r10, Type r11, Type... r12) {
            Objects.requireNonNull(r11);
            int r13 = 0;
            if ((r11 instanceof Class) == false) goto L16;
            Class r14 = (Class) r11;
            boolean r15 = true;
            if (Modifier.isStatic(r14.getModifiers()) == false) goto L7;
        L10:
            boolean r16 = true;
        L11:
            if (r10 != null) goto L15;
            if (r16 == true) goto L15;
            r15 = false;
        L15:
            a.a(r15);
            goto L16
        L7:
            if (r14.getEnclosingClass() == null) goto L10;
            r16 = false;
        L16:
            if (r10 != null) goto L18;
            Type r17 = null;
        L19:
            this.ownerType = r17;
            this.rawType = C$Gson$Types.b(r11);
            Type[] r18 = (Type[]) r12.clone();
            this.typeArguments = r18;
            int r19 = r18.length;
        L20:
            if (r13 >= r19) goto L22;
            Objects.requireNonNull(this.typeArguments[r13]);
            C$Gson$Types.c(this.typeArguments[r13]);
            Type[] r20 = this.typeArguments;
            r20[r13] = C$Gson$Types.b(r20[r13]);
            r13 = r13 + 1;
            goto L20
        L22:
            return;
        L18:
            r17 = C$Gson$Types.b(r10);
            goto L19
        }

        private static int hashCodeOrZero(Object r10) {
            if (r10 != null) goto L6;
            return 0;
        L6:
            return r10.hashCode();
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof ParameterizedType) == true) goto L5;
        L7:
            return false;
        L5:
            if (C$Gson$Types.f(this, (ParameterizedType) r10) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.typeArguments.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.ownerType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.rawType;
        }

        public int hashCode() {
            int r10 = Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode();
            return hashCodeOrZero(this.ownerType) ^ r10;
        }

        public String toString() {
            int r10 = this.typeArguments.length;
            if (r10 == 0) goto L5;
            StringBuilder r11 = new StringBuilder((r10 + 1) * 30);
            r11.append(C$Gson$Types.t(this.rawType));
            r11.append("<");
            r11.append(C$Gson$Types.t(this.typeArguments[0]));
            int r12 = 1;
        L7:
            if (r12 >= r10) goto L9;
            r11.append(", ");
            r11.append(C$Gson$Types.t(this.typeArguments[r12]));
            r12 = r12 + 1;
            goto L7
        L9:
            r11.append(">");
            return r11.toString();
        L5:
            return C$Gson$Types.t(this.rawType);
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.$Gson$Types$WildcardTypeImpl */
    private static final class WildcardTypeImpl implements WildcardType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type lowerBound;
        private final Type upperBound;

        public WildcardTypeImpl(Type[] r10, Type[] r11) {
            boolean r12 = true;
            if (r11.length > 1) goto L5;
            boolean r13 = true;
        L6:
            a.a(r13);
            if (r10.length != 1) goto L9;
            boolean r14 = true;
        L10:
            a.a(r14);
            if (r11.length != 1) goto L17;
            Objects.requireNonNull(r11[0]);
            C$Gson$Types.c(r11[0]);
            if (r10[0] == Object.class) goto L16;
            r12 = false;
        L16:
            a.a(r12);
            this.lowerBound = C$Gson$Types.b(r11[0]);
            this.upperBound = Object.class;
            return;
        L17:
            Objects.requireNonNull(r10[0]);
            C$Gson$Types.c(r10[0]);
            this.lowerBound = null;
            this.upperBound = C$Gson$Types.b(r10[0]);
            return;
        L9:
            r14 = false;
            goto L10
        L5:
            r13 = false;
            goto L6
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof WildcardType) == true) goto L5;
        L7:
            return false;
        L5:
            if (C$Gson$Types.f(this, (WildcardType) r10) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type r10 = this.lowerBound;
            if (r10 == null) goto L6;
            return new Type[]{r10};
        L6:
            return C$Gson$Types.f4214a;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.upperBound};
        }

        public int hashCode() {
            Type r10 = this.lowerBound;
            if (r10 == null) goto L5;
            int r11 = r10.hashCode() + 31;
        L7:
            return (this.upperBound.hashCode() + 31) ^ r11;
        L5:
            r11 = 1;
            goto L7
        }

        public String toString() {
            if (this.lowerBound == null) goto L8;
            StringBuilder r10 = new StringBuilder();
            r10.append("? super ");
            Type r11 = this.lowerBound;
        L5:
            r10.append(C$Gson$Types.t(r11));
            return r10.toString();
        L8:
            if (this.upperBound != Object.class) goto L11;
            return "?";
        L11:
            r10 = new StringBuilder();
            r10.append("? extends ");
            r11 = this.upperBound;
            goto L5
        }
    }

    static {
        f4214a = new Type[0];
    }

    public static GenericArrayType a(Type r10) {
        return new GenericArrayTypeImpl(r10);
    }

    public static Type b(Type r10) {
        if ((r10 instanceof Class) == false) goto L9;
        Class r11 = (Class) r10;
        if (r11.isArray() == true) goto L7;
        return r11;
    L7:
        return new GenericArrayTypeImpl(b(r11.getComponentType()));
    L9:
        if ((r10 instanceof ParameterizedType) == false) goto L13;
        ParameterizedType r12 = (ParameterizedType) r10;
        return new ParameterizedTypeImpl(r12.getOwnerType(), r12.getRawType(), r12.getActualTypeArguments());
    L13:
        if ((r10 instanceof GenericArrayType) == false) goto L17;
        return new GenericArrayTypeImpl(((GenericArrayType) r10).getGenericComponentType());
    L17:
        if ((r10 instanceof WildcardType) == false) goto L20;
        WildcardType r13 = (WildcardType) r10;
        return new WildcardTypeImpl(r13.getUpperBounds(), r13.getLowerBounds());
    L20:
        return r10;
    }

    static void c(Type r10) {
        if ((r10 instanceof Class) == true) goto L5;
    L8:
        boolean r11 = true;
    L9:
        a.a(r11);
        return;
    L5:
        if (((Class) r10).isPrimitive() == false) goto L8;
        r11 = false;
        goto L9
    }

    private static Class<?> d(TypeVariable<?> r10) {
        GenericDeclaration r11 = r10.getGenericDeclaration();
        if ((r11 instanceof Class) == true) goto L7;
        return null;
    L7:
        return (Class) r11;
    }

    private static boolean e(Object r10, Object r11) {
        return Objects.equals(r10, r11);
    }

    public static boolean f(Type r10, Type r11) {
        if (r10 != r11) goto L6;
        return true;
    L6:
        if ((r10 instanceof Class) == false) goto L10;
        return r10.equals(r11);
    L10:
        if ((r10 instanceof ParameterizedType) == false) goto L24;
        if ((r11 instanceof ParameterizedType) == true) goto L14;
        return false;
    L14:
        ParameterizedType r12 = (ParameterizedType) r10;
        ParameterizedType r13 = (ParameterizedType) r11;
        if (e(r12.getOwnerType(), r13.getOwnerType()) == false) goto L22;
        if (r12.getRawType().equals(r13.getRawType()) == false) goto L22;
        if (Arrays.equals(r12.getActualTypeArguments(), r13.getActualTypeArguments()) == false) goto L22;
        return true;
    L22:
        return false;
    L24:
        if ((r10 instanceof GenericArrayType) == false) goto L31;
        if ((r11 instanceof GenericArrayType) == true) goto L29;
        return false;
    L29:
        return f(((GenericArrayType) r10).getGenericComponentType(), ((GenericArrayType) r11).getGenericComponentType());
    L31:
        if ((r10 instanceof WildcardType) == false) goto L43;
        if ((r11 instanceof WildcardType) == true) goto L35;
        return false;
    L35:
        WildcardType r14 = (WildcardType) r10;
        WildcardType r15 = (WildcardType) r11;
        if (Arrays.equals(r14.getUpperBounds(), r15.getUpperBounds()) == false) goto L41;
        if (Arrays.equals(r14.getLowerBounds(), r15.getLowerBounds()) == false) goto L41;
        return true;
    L41:
        return false;
    L43:
        if ((r10 instanceof TypeVariable) == true) goto L45;
        return false;
    L45:
        if ((r11 instanceof TypeVariable) == true) goto L47;
        return false;
    L47:
        TypeVariable r16 = (TypeVariable) r10;
        TypeVariable r17 = (TypeVariable) r11;
        if (r16.getGenericDeclaration() != r17.getGenericDeclaration()) goto L53;
        if (r16.getName().equals(r17.getName()) == false) goto L53;
        return true;
    L53:
        return false;
    }

    public static Type g(Type r10) {
        if ((r10 instanceof GenericArrayType) == false) goto L6;
        return ((GenericArrayType) r10).getGenericComponentType();
    L6:
        return ((Class) r10).getComponentType();
    }

    public static Type h(Type r10, Class<?> r11) {
        Type r12 = l(r10, r11, Collection.class);
        if ((r12 instanceof ParameterizedType) == true) goto L5;
        return Object.class;
    L5:
        return ((ParameterizedType) r12).getActualTypeArguments()[0];
    }

    private static Type i(Type r10, Class<?> r11, Class<?> r12) {
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
        return i(r11.getGenericInterfaces()[r14], r13[r14], r12);
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
        return i(r11.getGenericSuperclass(), r16, r12);
    L24:
        return r11.getGenericSuperclass();
    }

    public static Type[] j(Type r10, Class<?> r11) {
        if (r10 == Properties.class) goto L5;
        Type r12 = l(r10, r11, Map.class);
        if ((r12 instanceof ParameterizedType) == false) goto L11;
        return ((ParameterizedType) r12).getActualTypeArguments();
    L11:
        return new Type[]{Object.class, Object.class};
    L5:
        return new Type[]{String.class, String.class};
    }

    public static Class<?> k(Type r10) {
        if ((r10 instanceof Class) == false) goto L7;
        return (Class) r10;
    L7:
        if ((r10 instanceof ParameterizedType) == false) goto L11;
        Type r11 = ((ParameterizedType) r10).getRawType();
        a.a(r11 instanceof Class);
        return (Class) r11;
    L11:
        if ((r10 instanceof GenericArrayType) == false) goto L15;
        return Array.newInstance(k(((GenericArrayType) r10).getGenericComponentType()), 0).getClass();
    L15:
        if ((r10 instanceof TypeVariable) == false) goto L19;
        return Object.class;
    L19:
        if ((r10 instanceof WildcardType) == true) goto L21;
        if (r10 != null) goto L24;
        String r12 = "null";
    L26:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r10 + "> is of type " + r12);
    L24:
        r12 = r10.getClass().getName();
        goto L26
    L21:
        return k(((WildcardType) r10).getUpperBounds()[0]);
    }

    private static Type l(Type r10, Class<?> r11, Class<?> r12) {
        if ((r10 instanceof WildcardType) == false) goto L5;
        r10 = ((WildcardType) r10).getUpperBounds()[0];
    L5:
        a.a(r12.isAssignableFrom(r11));
        return o(r10, r11, i(r10, r11, r12));
    }

    private static int m(Object[] r10, Object r11) {
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        if (r11.equals(r10[r13]) == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return r13;
    L9:
        throw new NoSuchElementException();
    }

    public static ParameterizedType n(Type r10, Type r11, Type... r12) {
        return new ParameterizedTypeImpl(r10, r11, r12);
    }

    public static Type o(Type r10, Class<?> r11, Type r12) {
        return p(r10, r11, r12, new HashMap());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v10, types: [java.lang.Object, java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v13, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.lang.reflect.ParameterizedType] */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.reflect.GenericArrayType] */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.util.Map, java.util.Map<java.lang.reflect.TypeVariable<?>, java.lang.reflect.Type>] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v19 */
    private static Type p(Type r10, Class<?> r11, Type r12, Map<TypeVariable<?>, Type> r13) {
        TypeVariable r14 = null;
    L4:
        if ((r12 instanceof TypeVariable) == false) goto L19;
        TypeVariable r15 = (TypeVariable) r12;
        Type r16 = (Type) r13.get(r15);
        if (r16 != null) goto L8;
        r13.put(r15, Void.TYPE);
        if (r14 != null) goto L15;
        r14 = r15;
    L15:
        r12 = q(r10, r11, r15);
        if (r12 != r15) goto L4;
    L56:
        if (r14 == null) goto L58;
        r13.put(r14, r12);
    L58:
        return r12;
    L8:
        if (r16 != Void.TYPE) goto L11;
        return r12;
    L11:
        return r16;
    L19:
        if ((r12 instanceof Class) == false) goto L28;
        Class r17 = (Class) r12;
        if (r17.isArray() == false) goto L28;
        Class<?> r18 = r17.getComponentType();
        Type r19 = p(r10, r11, r18, r13);
        if (e(r18, r19) == false) goto L25;
        r12 = r17;
    L25:
        Type r20 = a(r19);
    L26:
        r12 = r20;
    L28:
        if ((r12 instanceof GenericArrayType) == false) goto L32;
        r12 = (GenericArrayType) r12;
        Type r21 = r12.getGenericComponentType();
        r19 = p(r10, r11, r21, r13);
        if (e(r21, r19) == false) goto L25;
    L32:
        int r22 = 0;
        if ((r12 instanceof ParameterizedType) == false) goto L45;
        r12 = (ParameterizedType) r12;
        Type r23 = r12.getOwnerType();
        Type r24 = p(r10, r11, r23, r13);
        boolean r25 = !e(r24, r23);
        Type[] r26 = r12.getActualTypeArguments();
        int r27 = r26.length;
    L35:
        if (r22 >= r27) goto L42;
        Type r28 = p(r10, r11, r26[r22], r13);
        if (e(r28, r26[r22]) == true) goto L41;
        if (r25 == true) goto L40;
        r26 = (Type[]) r26.clone();
        r25 = true;
    L40:
        r26[r22] = r28;
    L41:
        r22 = r22 + 1;
        goto L35
    L42:
        if (r25 == false) goto L56;
        r20 = n(r24, r12.getRawType(), r26);
        goto L26
    L45:
        if ((r12 instanceof WildcardType) == false) goto L56;
        r12 = (WildcardType) r12;
        Type[] r29 = r12.getLowerBounds();
        Type[] r30 = r12.getUpperBounds();
        if (r29.length != 1) goto L52;
        Type r31 = p(r10, r11, r29[0], r13);
        if (r31 == r29[0]) goto L56;
        r12 = s(r31);
        goto L56
    L52:
        if (r30.length != 1) goto L56;
        Type r32 = p(r10, r11, r30[0], r13);
        if (r32 == r30[0]) goto L56;
        r12 = r(r32);
        goto L56
    }

    private static Type q(Type r10, Class<?> r11, TypeVariable<?> r12) {
        Class<?> r13 = d(r12);
        if (r13 != null) goto L5;
        return r12;
    L5:
        Type r14 = i(r10, r11, r13);
        if ((r14 instanceof ParameterizedType) == false) goto L9;
        int r15 = m(r13.getTypeParameters(), r12);
        return ((ParameterizedType) r14).getActualTypeArguments()[r15];
    L9:
        return r12;
    }

    public static WildcardType r(Type r10) {
        if ((r10 instanceof WildcardType) == false) goto L5;
        Type[] r11 = ((WildcardType) r10).getUpperBounds();
    L7:
        return new WildcardTypeImpl(r11, f4214a);
    L5:
        r11 = new Type[]{r10};
        goto L7
    }

    public static WildcardType s(Type r10) {
        if ((r10 instanceof WildcardType) == false) goto L5;
        Type[] r11 = ((WildcardType) r10).getLowerBounds();
    L7:
        return new WildcardTypeImpl(new Type[]{Object.class}, r11);
    L5:
        r11 = new Type[]{r10};
        goto L7
    }

    public static String t(Type r10) {
        if ((r10 instanceof Class) == false) goto L6;
        return ((Class) r10).getName();
    L6:
        return r10.toString();
    }
}
