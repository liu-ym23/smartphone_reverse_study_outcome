package com.google.gson.internal;

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

/* JADX INFO: loaded from: classes2.dex */
public final class GsonTypes {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final Type[] EMPTY_TYPE_ARRAY = null;

    public static final class GenericArrayTypeImpl implements GenericArrayType {
        private final Type componentType;

        public GenericArrayTypeImpl(Type r5) {
            Objects.requireNonNull(r5);
            this.componentType = GsonTypes.canonicalize(r5);
        }

        public boolean equals(Object r5) {
            if ((r5 instanceof GenericArrayType) == true) goto L5;
        L7:
            return false;
        L5:
            if (GsonTypes.equals(this, (GenericArrayType) r5) == false) goto L7;
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
            return GsonTypes.typeToString(this.componentType) + "[]";
        }
    }

    public static final class ParameterizedTypeImpl implements ParameterizedType {
        private final Type ownerType;
        private final Type rawType;
        private final Type[] typeArguments;

        public ParameterizedTypeImpl(Type r5, Class<?> r10, Type... r11) {
            Objects.requireNonNull(r10);
            if (r5 == null) goto L5;
        L9:
            if (r5 != null) goto L11;
            Type r12 = null;
        L12:
            this.ownerType = r12;
            this.rawType = GsonTypes.canonicalize(r10);
            Type[] r13 = (Type[]) r11.clone();
            this.typeArguments = r13;
            int r14 = r13.length;
            int r15 = 0;
        L13:
            if (r15 >= r14) goto L15;
            Objects.requireNonNull(this.typeArguments[r15]);
            GsonTypes.checkNotPrimitive(this.typeArguments[r15]);
            Type[] r16 = this.typeArguments;
            r16[r15] = GsonTypes.canonicalize(r16[r15]);
            r15 = r15 + 1;
            goto L13
        L15:
            return;
        L11:
            r12 = GsonTypes.canonicalize(r5);
            goto L12
        L5:
            if (GsonTypes.requiresOwnerType(r10) == false) goto L9;
            throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.l(r10, "Must specify owner type for "));
        }

        private static int hashCodeOrZero(Object r5) {
            if (r5 != null) goto L6;
            return 0;
        L6:
            return r5.hashCode();
        }

        public boolean equals(Object r5) {
            if ((r5 instanceof ParameterizedType) == true) goto L5;
        L7:
            return false;
        L5:
            if (GsonTypes.equals(this, (ParameterizedType) r5) == false) goto L7;
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
            int r5 = Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode();
            return hashCodeOrZero(this.ownerType) ^ r5;
        }

        public String toString() {
            int r5 = this.typeArguments.length;
            if (r5 == 0) goto L5;
            StringBuilder r10 = new StringBuilder((r5 + 1) * 30);
            r10.append(GsonTypes.typeToString(this.rawType));
            r10.append("<");
            r10.append(GsonTypes.typeToString(this.typeArguments[0]));
            int r11 = 1;
        L7:
            if (r11 >= r5) goto L9;
            r10.append(", ");
            r10.append(GsonTypes.typeToString(this.typeArguments[r11]));
            r11 = r11 + 1;
            goto L7
        L9:
            r10.append(">");
            return r10.toString();
        L5:
            return GsonTypes.typeToString(this.rawType);
        }
    }

    public static final class WildcardTypeImpl implements WildcardType {
        private final Type lowerBound;
        private final Type upperBound;

        public WildcardTypeImpl(Type[] r5, Type[] r10) {
            if (r10.length > 1) goto L18;
            if (r5.length != 1) goto L16;
            if (r10.length != 1) goto L13;
            Objects.requireNonNull(r10[0]);
            GsonTypes.checkNotPrimitive(r10[0]);
            if (r5[0] != Object.class) goto L12;
            this.lowerBound = GsonTypes.canonicalize(r10[0]);
            this.upperBound = Object.class;
            return;
        L12:
            throw new IllegalArgumentException("When lower bound is specified, upper bound must be Object");
        L13:
            Objects.requireNonNull(r5[0]);
            GsonTypes.checkNotPrimitive(r5[0]);
            this.lowerBound = null;
            this.upperBound = GsonTypes.canonicalize(r5[0]);
            return;
        L16:
            throw new IllegalArgumentException("Exactly one upper bound must be specified");
        L18:
            throw new IllegalArgumentException("At most one lower bound is supported");
        }

        public boolean equals(Object r5) {
            if ((r5 instanceof WildcardType) == true) goto L5;
        L7:
            return false;
        L5:
            if (GsonTypes.equals(this, (WildcardType) r5) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type r5 = this.lowerBound;
            if (r5 == null) goto L6;
            return new Type[]{r5};
        L6:
            return GsonTypes.EMPTY_TYPE_ARRAY;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.upperBound};
        }

        public int hashCode() {
            Type r5 = this.lowerBound;
            if (r5 == null) goto L5;
            int r10 = r5.hashCode() + 31;
        L7:
            return (this.upperBound.hashCode() + 31) ^ r10;
        L5:
            r10 = 1;
            goto L7
        }

        public String toString() {
            if (this.lowerBound == null) goto L7;
            return "? super " + GsonTypes.typeToString(this.lowerBound);
        L7:
            if (this.upperBound != Object.class) goto L11;
            return "?";
        L11:
            return "? extends " + GsonTypes.typeToString(this.upperBound);
        }
    }

    static {
        EMPTY_TYPE_ARRAY = new Type[0];
    }

    private GsonTypes() {
        throw new UnsupportedOperationException();
    }

    public static GenericArrayType arrayOf(Type r5) {
        return new GenericArrayTypeImpl(r5);
    }

    public static Type canonicalize(Type r5) {
        if ((r5 instanceof Class) == false) goto L9;
        Class r10 = (Class) r5;
        if (r10.isArray() == true) goto L7;
        return r10;
    L7:
        return new GenericArrayTypeImpl(canonicalize(r10.getComponentType()));
    L9:
        if ((r5 instanceof ParameterizedType) == false) goto L13;
        ParameterizedType r11 = (ParameterizedType) r5;
        return new ParameterizedTypeImpl(r11.getOwnerType(), (Class) r11.getRawType(), r11.getActualTypeArguments());
    L13:
        if ((r5 instanceof GenericArrayType) == false) goto L17;
        return new GenericArrayTypeImpl(((GenericArrayType) r5).getGenericComponentType());
    L17:
        if ((r5 instanceof WildcardType) == false) goto L20;
        WildcardType r12 = (WildcardType) r5;
        return new WildcardTypeImpl(r12.getUpperBounds(), r12.getLowerBounds());
    L20:
        return r5;
    }

    public static void checkNotPrimitive(Type r5) {
        if ((r5 instanceof Class) == true) goto L5;
        return;
    L5:
        if (((Class) r5).isPrimitive() == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("Primitive type is not allowed");
    }

    private static Class<?> declaringClassOf(TypeVariable<?> r5) {
        GenericDeclaration r10 = r5.getGenericDeclaration();
        if ((r10 instanceof Class) == true) goto L7;
        return null;
    L7:
        return (Class) r10;
    }

    private static boolean equal(Object r5, Object r10) {
        return Objects.equals(r5, r10);
    }

    public static boolean equals(Type r5, Type r10) {
        if (r5 != r10) goto L6;
        return true;
    L6:
        if ((r5 instanceof Class) == false) goto L10;
        return r5.equals(r10);
    L10:
        if ((r5 instanceof ParameterizedType) == false) goto L24;
        if ((r10 instanceof ParameterizedType) == true) goto L14;
        return false;
    L14:
        ParameterizedType r11 = (ParameterizedType) r5;
        ParameterizedType r12 = (ParameterizedType) r10;
        if (equal(r11.getOwnerType(), r12.getOwnerType()) == false) goto L22;
        if (r11.getRawType().equals(r12.getRawType()) == false) goto L22;
        if (Arrays.equals(r11.getActualTypeArguments(), r12.getActualTypeArguments()) == false) goto L22;
        return true;
    L22:
        return false;
    L24:
        if ((r5 instanceof GenericArrayType) == false) goto L31;
        if ((r10 instanceof GenericArrayType) == true) goto L29;
        return false;
    L29:
        return equals(((GenericArrayType) r5).getGenericComponentType(), ((GenericArrayType) r10).getGenericComponentType());
    L31:
        if ((r5 instanceof WildcardType) == false) goto L43;
        if ((r10 instanceof WildcardType) == true) goto L35;
        return false;
    L35:
        WildcardType r13 = (WildcardType) r5;
        WildcardType r14 = (WildcardType) r10;
        if (Arrays.equals(r13.getUpperBounds(), r14.getUpperBounds()) == false) goto L41;
        if (Arrays.equals(r13.getLowerBounds(), r14.getLowerBounds()) == false) goto L41;
        return true;
    L41:
        return false;
    L43:
        if ((r5 instanceof TypeVariable) == true) goto L45;
        return false;
    L45:
        if ((r10 instanceof TypeVariable) == true) goto L47;
        return false;
    L47:
        TypeVariable r15 = (TypeVariable) r5;
        TypeVariable r16 = (TypeVariable) r10;
        if (Objects.equals(r15.getGenericDeclaration(), r16.getGenericDeclaration()) == false) goto L53;
        if (r15.getName().equals(r16.getName()) == false) goto L53;
        return true;
    L53:
        return false;
    }

    public static Type getArrayComponentType(Type r5) {
        if ((r5 instanceof GenericArrayType) == false) goto L6;
        return ((GenericArrayType) r5).getGenericComponentType();
    L6:
        return ((Class) r5).getComponentType();
    }

    public static Type getCollectionElementType(Type r5, Class<?> r10) {
        Type r11 = getSupertype(r5, r10, Collection.class);
        if ((r11 instanceof ParameterizedType) == true) goto L5;
        return Object.class;
    L5:
        return ((ParameterizedType) r11).getActualTypeArguments()[0];
    }

    private static Type getGenericSupertype(Type r5, Class<?> r10, Class<?> r11) {
        if (r11 != r10) goto L5;
        return r5;
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
        return getGenericSupertype(r10.getGenericInterfaces()[r14], r12[r14], r11);
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
        return getGenericSupertype(r10.getGenericSuperclass(), r16, r11);
    L24:
        return r10.getGenericSuperclass();
    }

    public static Type[] getMapKeyAndValueTypes(Type r5, Class<?> r10) {
        if (Properties.class.isAssignableFrom(r10) == true) goto L5;
        Type r11 = getSupertype(r5, r10, Map.class);
        if ((r11 instanceof ParameterizedType) == false) goto L11;
        return ((ParameterizedType) r11).getActualTypeArguments();
    L11:
        return new Type[]{Object.class, Object.class};
    L5:
        return new Type[]{String.class, String.class};
    }

    public static Class<?> getRawType(Type r5) {
        if ((r5 instanceof Class) == false) goto L7;
        return (Class) r5;
    L7:
        if ((r5 instanceof ParameterizedType) == false) goto L11;
        return (Class) ((ParameterizedType) r5).getRawType();
    L11:
        if ((r5 instanceof GenericArrayType) == false) goto L15;
        return Array.newInstance(getRawType(((GenericArrayType) r5).getGenericComponentType()), 0).getClass();
    L15:
        if ((r5 instanceof TypeVariable) == false) goto L19;
        return Object.class;
    L19:
        if ((r5 instanceof WildcardType) == true) goto L21;
        if (r5 != null) goto L24;
        String r10 = "null";
    L26:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r5 + "> is of type " + r10);
    L24:
        r10 = r5.getClass().getName();
        goto L26
    L21:
        return getRawType(((WildcardType) r5).getUpperBounds()[0]);
    }

    private static Type getSupertype(Type r5, Class<?> r10, Class<?> r11) {
        if ((r5 instanceof WildcardType) == false) goto L6;
        r5 = ((WildcardType) r5).getUpperBounds()[0];
    L6:
        if (r11.isAssignableFrom(r10) == false) goto L10;
        return resolve(r5, r10, getGenericSupertype(r5, r10, r11));
    L10:
        throw new IllegalArgumentException(r10 + " is not the same as or a subtype of " + r11);
    }

    private static int indexOf(Object[] r5, Object r10) {
        int r11 = r5.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        if (r10.equals(r5[r12]) == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return r12;
    L9:
        throw new NoSuchElementException();
    }

    public static ParameterizedType newParameterizedTypeWithOwner(Type r5, Class<?> r10, Type... r11) {
        return new ParameterizedTypeImpl(r5, r10, r11);
    }

    public static boolean requiresOwnerType(Type r5) {
        if ((r5 instanceof Class) == false) goto L10;
        Class r10 = (Class) r5;
        if (Modifier.isStatic(r10.getModifiers()) == false) goto L7;
        return false;
    L7:
        if (r10.getDeclaringClass() == null) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public static Type resolve(Type r5, Class<?> r10, Type r11) {
        return resolve(r5, r10, r11, new HashMap());
    }

    private static Type resolveTypeVariable(Type r5, Class<?> r10, TypeVariable<?> r11) {
        Class<?> r12 = declaringClassOf(r11);
        if (r12 != null) goto L5;
        return r11;
    L5:
        Type r13 = getGenericSupertype(r5, r10, r12);
        if ((r13 instanceof ParameterizedType) == false) goto L9;
        int r14 = indexOf(r12.getTypeParameters(), r11);
        return ((ParameterizedType) r13).getActualTypeArguments()[r14];
    L9:
        return r11;
    }

    public static WildcardType subtypeOf(Type r5) {
        if ((r5 instanceof WildcardType) == false) goto L5;
        Type[] r10 = ((WildcardType) r5).getUpperBounds();
    L7:
        return new WildcardTypeImpl(r10, EMPTY_TYPE_ARRAY);
    L5:
        r10 = new Type[]{r5};
        goto L7
    }

    public static WildcardType supertypeOf(Type r5) {
        if ((r5 instanceof WildcardType) == false) goto L5;
        Type[] r10 = ((WildcardType) r5).getLowerBounds();
    L7:
        return new WildcardTypeImpl(new Type[]{Object.class}, r10);
    L5:
        r10 = new Type[]{r5};
        goto L7
    }

    public static String typeToString(Type r5) {
        if ((r5 instanceof Class) == false) goto L6;
        return ((Class) r5).getName();
    L6:
        return r5.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r12v10, types: [java.lang.Object, java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r12v13, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.lang.reflect.ParameterizedType] */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.reflect.GenericArrayType] */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.util.Map, java.util.Map<java.lang.reflect.TypeVariable<?>, java.lang.reflect.Type>] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v13 */
    private static Type resolve(Type r10, Class<?> r11, Type r12, Map<TypeVariable<?>, Type> r13) {
        TypeVariable r5 = null;
    L4:
        if ((r12 instanceof TypeVariable) == false) goto L19;
        TypeVariable r14 = (TypeVariable) r12;
        Type r15 = (Type) r13.get(r14);
        if (r15 != null) goto L8;
        r13.put(r14, Void.TYPE);
        if (r5 != null) goto L15;
        r5 = r14;
    L15:
        r12 = resolveTypeVariable(r10, r11, r14);
        if (r12 != r14) goto L4;
    L58:
        if (r5 == null) goto L60;
        r13.put(r5, r12);
    L60:
        return r12;
    L8:
        if (r15 != Void.TYPE) goto L11;
        return r12;
    L11:
        return r15;
    L19:
        if ((r12 instanceof Class) == false) goto L28;
        Class r16 = (Class) r12;
        if (r16.isArray() == false) goto L28;
        Class<?> r17 = r16.getComponentType();
        Type r18 = resolve(r10, r11, r17, r13);
        if (equal(r17, r18) == false) goto L25;
        r12 = r16;
        goto L58
    L25:
        Type r19 = arrayOf(r18);
    L26:
        r12 = r19;
    L28:
        if ((r12 instanceof GenericArrayType) == false) goto L33;
        r12 = (GenericArrayType) r12;
        Type r20 = r12.getGenericComponentType();
        Type r110 = resolve(r10, r11, r20, r13);
        if (equal(r20, r110) == true) goto L58;
        r19 = arrayOf(r110);
        goto L26
    L33:
        int r21 = 0;
        if ((r12 instanceof ParameterizedType) == false) goto L47;
        r12 = (ParameterizedType) r12;
        Type r22 = r12.getOwnerType();
        Type r23 = resolve(r10, r11, r22, r13);
        boolean r24 = equal(r23, r22);
        Type[] r25 = r12.getActualTypeArguments();
        int r26 = r25.length;
        Type[] r27 = r25;
        boolean r28 = false;
    L36:
        if (r21 >= r26) goto L43;
        Type r29 = resolve(r10, r11, r27[r21], r13);
        if (equal(r29, r27[r21]) == true) goto L42;
        if (r28 == true) goto L41;
        r27 = (Type[]) r27.clone();
        r28 = true;
    L41:
        r27[r21] = r29;
    L42:
        r21 = r21 + 1;
        goto L36
    L43:
        if (r24 == false) goto L45;
        if (r28 == false) goto L58;
    L45:
        r19 = newParameterizedTypeWithOwner(r23, (Class) r12.getRawType(), r27);
        goto L26
    L47:
        if ((r12 instanceof WildcardType) == false) goto L58;
        r12 = (WildcardType) r12;
        Type[] r30 = r12.getLowerBounds();
        Type[] r31 = r12.getUpperBounds();
        if (r30.length != 1) goto L54;
        Type r111 = resolve(r10, r11, r30[0], r13);
        if (r111 == r30[0]) goto L58;
        r12 = supertypeOf(r111);
        goto L58
    L54:
        if (r31.length != 1) goto L58;
        Type r112 = resolve(r10, r11, r31[0], r13);
        if (r112 == r31[0]) goto L58;
        r12 = subtypeOf(r112);
        goto L58
    }
}
