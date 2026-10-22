package com.google.gson.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: com.google.gson.internal.$Gson$Types, reason: invalid class name */
/* JADX INFO: loaded from: classes2.dex */
public final class C$Gson$Types {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final Type[] EMPTY_TYPE_ARRAY = null;

    /* JADX INFO: renamed from: com.google.gson.internal.$Gson$Types$GenericArrayTypeImpl */
    private static final class GenericArrayTypeImpl implements Serializable, GenericArrayType {
        private static final long serialVersionUID = 0;
        private final Type componentType;

        public GenericArrayTypeImpl(Type r3) {
            Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin");
            Objects.requireNonNull(r4);
            this.componentType = C$Gson$Types.canonicalize(r4);
        }

        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, GenericArrayType.class) == true) goto L5;
        L7:
            return false;
        L5:
            if (C$Gson$Types.equals(this, (GenericArrayType) ZeusTransformUtils.preCheckCast(r3, GenericArrayType.class, "com.obric.memorydata.plugin")) == false) goto L7;
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
            return C$Gson$Types.typeToString(this.componentType) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.$Gson$Types$ParameterizedTypeImpl */
    private static final class ParameterizedTypeImpl implements Serializable, ParameterizedType {
        private static final long serialVersionUID = 0;
        private final Type ownerType;
        private final Type rawType;
        private final Type[] typeArguments;

        public ParameterizedTypeImpl(Type r6, Type r7, Type... r8) {
            Type r9 = (Type) ZeusTransformUtils.wrapperContextForParams(r6, Type.class, "com.obric.memorydata.plugin");
            Type r10 = (Type) ZeusTransformUtils.wrapperContextForParams(r7, Type.class, "com.obric.memorydata.plugin");
            Objects.requireNonNull(r10);
            int r2 = 0;
            if (ZeusTransformUtils.instanceOf(r10, Class.class) == false) goto L16;
            Class r0 = (Class) ZeusTransformUtils.preCheckCast(r10, Class.class, "com.obric.memorydata.plugin");
            boolean r4 = true;
            if (Modifier.isStatic(r0.getModifiers()) == false) goto L7;
        L10:
            boolean r1 = true;
        L11:
            if (r9 != null) goto L15;
            if (r1 == true) goto L15;
            r4 = false;
        L15:
            C$Gson$Preconditions.checkArgument(r4);
            goto L16
        L7:
            if (r0.getEnclosingClass() == null) goto L10;
            r1 = false;
        L16:
            if (r9 != null) goto L18;
            Type r11 = null;
        L19:
            this.ownerType = r11;
            this.rawType = C$Gson$Types.canonicalize(r10);
            Type[] r12 = (Type[]) ZeusTransformUtils.preCheckCast(r8.clone(), Type[].class, "com.obric.memorydata.plugin");
            this.typeArguments = r12;
            int r13 = r12.length;
        L20:
            if (r2 >= r13) goto L22;
            Objects.requireNonNull(this.typeArguments[r2]);
            C$Gson$Types.checkNotPrimitive(this.typeArguments[r2]);
            Type[] r14 = this.typeArguments;
            r14[r2] = C$Gson$Types.canonicalize(r14[r2]);
            r2 = r2 + 1;
            goto L20
        L22:
            return;
        L18:
            r11 = C$Gson$Types.canonicalize(r9);
            goto L19
        }

        private static int hashCodeOrZero(Object r0) {
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, ParameterizedType.class) == true) goto L5;
        L7:
            return false;
        L5:
            if (C$Gson$Types.equals(this, (ParameterizedType) ZeusTransformUtils.preCheckCast(r3, ParameterizedType.class, "com.obric.memorydata.plugin")) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) ZeusTransformUtils.preCheckCast(this.typeArguments.clone(), Type[].class, "com.obric.memorydata.plugin");
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
            int r0 = Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode();
            return hashCodeOrZero(this.ownerType) ^ r0;
        }

        public String toString() {
            int r0 = this.typeArguments.length;
            if (r0 == 0) goto L5;
            StringBuilder r1 = new StringBuilder((r0 + 1) * 30);
            r1.append(C$Gson$Types.typeToString(this.rawType)).append("<").append(C$Gson$Types.typeToString(this.typeArguments[0]));
            int r2 = 1;
        L7:
            if (r2 >= r0) goto L10;
            r1.append(", ").append(C$Gson$Types.typeToString(this.typeArguments[r2]));
            r2 = r2 + 1;
            goto L7
        L10:
            return r1.append(">").toString();
        L5:
            return C$Gson$Types.typeToString(this.rawType);
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.$Gson$Types$WildcardTypeImpl */
    private static final class WildcardTypeImpl implements Serializable, WildcardType {
        private static final long serialVersionUID = 0;
        private final Type lowerBound;
        private final Type upperBound;

        public WildcardTypeImpl(Type[] r4, Type[] r5) {
            boolean r1 = true;
            if (r5.length > 1) goto L5;
            boolean r0 = true;
        L6:
            C$Gson$Preconditions.checkArgument(r0);
            if (r4.length != 1) goto L9;
            boolean r2 = true;
        L10:
            C$Gson$Preconditions.checkArgument(r2);
            if (r5.length != 1) goto L17;
            Objects.requireNonNull(r5[0]);
            C$Gson$Types.checkNotPrimitive(r5[0]);
            if (r4[0] == Object.class) goto L16;
            r1 = false;
        L16:
            C$Gson$Preconditions.checkArgument(r1);
            this.lowerBound = C$Gson$Types.canonicalize(r5[0]);
            Type r6 = Object.class;
        L18:
            this.upperBound = r6;
            return;
        L17:
            Objects.requireNonNull(r4[0]);
            C$Gson$Types.checkNotPrimitive(r4[0]);
            this.lowerBound = null;
            r6 = C$Gson$Types.canonicalize(r4[0]);
            goto L18
        L9:
            r2 = false;
            goto L10
        L5:
            r0 = false;
            goto L6
        }

        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, WildcardType.class) == true) goto L5;
        L7:
            return false;
        L5:
            if (C$Gson$Types.equals(this, (WildcardType) ZeusTransformUtils.preCheckCast(r3, WildcardType.class, "com.obric.memorydata.plugin")) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type r2 = this.lowerBound;
            if (r2 == null) goto L6;
            return new Type[]{r2};
        L6:
            return C$Gson$Types.EMPTY_TYPE_ARRAY;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.upperBound};
        }

        public int hashCode() {
            Type r0 = this.lowerBound;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode() + 31;
        L7:
            return (this.upperBound.hashCode() + 31) ^ r1;
        L5:
            r1 = 1;
            goto L7
        }

        public String toString() {
            if (this.lowerBound == null) goto L8;
            StringBuilder r0 = new StringBuilder().append("? super ");
            Type r2 = this.lowerBound;
        L6:
            return r0.append(C$Gson$Types.typeToString(r2)).toString();
        L8:
            if (this.upperBound != Object.class) goto L11;
            return "?";
        L11:
            r0 = new StringBuilder().append("? extends ");
            r2 = this.upperBound;
            goto L6
        }
    }

    static {
        EMPTY_TYPE_ARRAY = new Type[0];
    }

    private C$Gson$Types() {
        throw new UnsupportedOperationException();
    }

    public static GenericArrayType arrayOf(Type r2) {
        return new GenericArrayTypeImpl((Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin"));
    }

    public static Type canonicalize(Type r3) {
        Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Class.class) == false) goto L10;
        Class r5 = (Class) ZeusTransformUtils.preCheckCast(r4, Class.class, "com.obric.memorydata.plugin");
        boolean r0 = r5.isArray();
        Object r6 = r5;
        if (r0 == false) goto L8;
        r6 = new GenericArrayTypeImpl(canonicalize(r5.getComponentType()));
    L8:
        return (Type) ZeusTransformUtils.preCheckCast(r6, Type.class, "com.obric.memorydata.plugin");
    L10:
        if (ZeusTransformUtils.instanceOf(r4, ParameterizedType.class) == false) goto L14;
        ParameterizedType r7 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r4, ParameterizedType.class, "com.obric.memorydata.plugin");
        return new ParameterizedTypeImpl(r7.getOwnerType(), r7.getRawType(), r7.getActualTypeArguments());
    L14:
        if (ZeusTransformUtils.instanceOf(r4, GenericArrayType.class) == false) goto L18;
        return new GenericArrayTypeImpl(((GenericArrayType) ZeusTransformUtils.preCheckCast(r4, GenericArrayType.class, "com.obric.memorydata.plugin")).getGenericComponentType());
    L18:
        if (ZeusTransformUtils.instanceOf(r4, WildcardType.class) == false) goto L21;
        WildcardType r8 = (WildcardType) ZeusTransformUtils.preCheckCast(r4, WildcardType.class, "com.obric.memorydata.plugin");
        return new WildcardTypeImpl(r8.getUpperBounds(), r8.getLowerBounds());
    L21:
        return r4;
    }

    static void checkNotPrimitive(Type r2) {
        Type r3 = (Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Class.class) == true) goto L5;
    L8:
        boolean r4 = true;
    L9:
        C$Gson$Preconditions.checkArgument(r4);
        return;
    L5:
        if (((Class) ZeusTransformUtils.preCheckCast(r3, Class.class, "com.obric.memorydata.plugin")).isPrimitive() == false) goto L8;
        r4 = false;
        goto L9
    }

    private static Class<?> declaringClassOf(TypeVariable<?> r2) {
        GenericDeclaration r3 = ((TypeVariable) ZeusTransformUtils.wrapperContextForParams(r2, TypeVariable.class, "com.obric.memorydata.plugin")).getGenericDeclaration();
        if (ZeusTransformUtils.instanceOf(r3, Class.class) == true) goto L7;
        return null;
    L7:
        return (Class) ZeusTransformUtils.preCheckCast(r3, Class.class, "com.obric.memorydata.plugin");
    }

    private static boolean equal(Object r0, Object r1) {
        return Objects.equals(r0, r1);
    }

    public static boolean equals(Type r4, Type r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin");
        Type r7 = (Type) ZeusTransformUtils.wrapperContextForParams(r5, Type.class, "com.obric.memorydata.plugin");
        if (r6 != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, Class.class) == false) goto L10;
        return r6.equals(r7);
    L10:
        if (ZeusTransformUtils.instanceOf(r6, ParameterizedType.class) == false) goto L24;
        if (ZeusTransformUtils.instanceOf(r7, ParameterizedType.class) == true) goto L14;
        return false;
    L14:
        ParameterizedType r8 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r6, ParameterizedType.class, "com.obric.memorydata.plugin");
        ParameterizedType r9 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r7, ParameterizedType.class, "com.obric.memorydata.plugin");
        if (equal(r8.getOwnerType(), r9.getOwnerType()) == false) goto L22;
        if (r8.getRawType().equals(r9.getRawType()) == false) goto L22;
        if (Arrays.equals(r8.getActualTypeArguments(), r9.getActualTypeArguments()) == false) goto L22;
        return true;
    L22:
        return false;
    L24:
        if (ZeusTransformUtils.instanceOf(r6, GenericArrayType.class) == false) goto L31;
        if (ZeusTransformUtils.instanceOf(r7, GenericArrayType.class) == true) goto L28;
        return false;
    L28:
        GenericArrayType r10 = (GenericArrayType) ZeusTransformUtils.preCheckCast(r6, GenericArrayType.class, "com.obric.memorydata.plugin");
        GenericArrayType r11 = (GenericArrayType) ZeusTransformUtils.preCheckCast(r7, GenericArrayType.class, "com.obric.memorydata.plugin");
        return equals(r10.getGenericComponentType(), r11.getGenericComponentType());
    L31:
        if (ZeusTransformUtils.instanceOf(r6, WildcardType.class) == false) goto L43;
        if (ZeusTransformUtils.instanceOf(r7, WildcardType.class) == true) goto L35;
        return false;
    L35:
        WildcardType r12 = (WildcardType) ZeusTransformUtils.preCheckCast(r6, WildcardType.class, "com.obric.memorydata.plugin");
        WildcardType r13 = (WildcardType) ZeusTransformUtils.preCheckCast(r7, WildcardType.class, "com.obric.memorydata.plugin");
        if (Arrays.equals(r12.getUpperBounds(), r13.getUpperBounds()) == false) goto L41;
        if (Arrays.equals(r12.getLowerBounds(), r13.getLowerBounds()) == false) goto L41;
        return true;
    L41:
        return false;
    L43:
        if (ZeusTransformUtils.instanceOf(r6, TypeVariable.class) == true) goto L45;
        return false;
    L45:
        if (ZeusTransformUtils.instanceOf(r7, TypeVariable.class) == true) goto L47;
        return false;
    L47:
        TypeVariable r14 = (TypeVariable) ZeusTransformUtils.preCheckCast(r6, TypeVariable.class, "com.obric.memorydata.plugin");
        TypeVariable r15 = (TypeVariable) ZeusTransformUtils.preCheckCast(r7, TypeVariable.class, "com.obric.memorydata.plugin");
        if (r14.getGenericDeclaration() != r15.getGenericDeclaration()) goto L53;
        if (r14.getName().equals(r15.getName()) == false) goto L53;
        return true;
    L53:
        return false;
    }

    public static Type getArrayComponentType(Type r2) {
        Type r3 = (Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, GenericArrayType.class) == false) goto L6;
        return ((GenericArrayType) ZeusTransformUtils.preCheckCast(r3, GenericArrayType.class, "com.obric.memorydata.plugin")).getGenericComponentType();
    L6:
        return ((Class) ZeusTransformUtils.preCheckCast(r3, Class.class, "com.obric.memorydata.plugin")).getComponentType();
    }

    public static Type getCollectionElementType(Type r2, Class<?> r3) {
        Type r4 = getSupertype((Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin"), r3, Collection.class);
        if (ZeusTransformUtils.instanceOf(r4, ParameterizedType.class) == true) goto L5;
        return Object.class;
    L5:
        return ((ParameterizedType) ZeusTransformUtils.preCheckCast(r4, ParameterizedType.class, "com.obric.memorydata.plugin")).getActualTypeArguments()[0];
    }

    private static Type getGenericSupertype(Type r3, Class<?> r4, Class<?> r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin");
        if (r5 != r4) goto L6;
        return r6;
    L6:
        if (r5.isInterface() == false) goto L19;
        Class<?>[] r7 = r4.getInterfaces();
        int r0 = 0;
        int r1 = r7.length;
    L8:
        if (r0 >= r1) goto L19;
        if (r7[r0] == r5) goto L12;
        if (r5.isAssignableFrom(r7[r0]) == true) goto L16;
        r0 = r0 + 1;
        goto L8
    L16:
        return getGenericSupertype(r4.getGenericInterfaces()[r0], r7[r0], r5);
    L12:
        return r4.getGenericInterfaces()[r0];
    L19:
        if (r4.isInterface() == false) goto L21;
    L31:
        return r5;
    L21:
        if (r4 == Object.class) goto L31;
        Class<? super Object> r8 = r4.getSuperclass();
        if (r8 == r5) goto L25;
        if (r5.isAssignableFrom(r8) == true) goto L29;
        r4 = r8;
        goto L21
    L29:
        return getGenericSupertype(r4.getGenericSuperclass(), r8, r5);
    L25:
        return r4.getGenericSuperclass();
    }

    public static Type[] getMapKeyAndValueTypes(Type r5, Class<?> r6) {
        Type r7 = (Type) ZeusTransformUtils.wrapperContextForParams(r5, Type.class, "com.obric.memorydata.plugin");
        if (r7 == Properties.class) goto L5;
        Type r8 = getSupertype(r7, r6, Map.class);
        if (ZeusTransformUtils.instanceOf(r8, ParameterizedType.class) == false) goto L11;
        return ((ParameterizedType) ZeusTransformUtils.preCheckCast(r8, ParameterizedType.class, "com.obric.memorydata.plugin")).getActualTypeArguments();
    L11:
        return new Type[]{Object.class, Object.class};
    L5:
        return new Type[]{String.class, String.class};
    }

    public static Class<?> getRawType(Type r4) {
        Type r5 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Class.class) == false) goto L7;
        return (Class) ZeusTransformUtils.preCheckCast(r5, Class.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r5, ParameterizedType.class) == false) goto L11;
        Type r6 = ((ParameterizedType) ZeusTransformUtils.preCheckCast(r5, ParameterizedType.class, "com.obric.memorydata.plugin")).getRawType();
        C$Gson$Preconditions.checkArgument(ZeusTransformUtils.instanceOf(r6, Class.class));
        return (Class) ZeusTransformUtils.preCheckCast(r6, Class.class, "com.obric.memorydata.plugin");
    L11:
        if (ZeusTransformUtils.instanceOf(r5, GenericArrayType.class) == false) goto L15;
        return Array.newInstance(getRawType(((GenericArrayType) ZeusTransformUtils.preCheckCast(r5, GenericArrayType.class, "com.obric.memorydata.plugin")).getGenericComponentType()), 0).getClass();
    L15:
        if (ZeusTransformUtils.instanceOf(r5, TypeVariable.class) == false) goto L19;
        return Object.class;
    L19:
        if (ZeusTransformUtils.instanceOf(r5, WildcardType.class) == true) goto L21;
        if (r5 != null) goto L24;
        String r0 = "null";
    L26:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r5 + "> is of type " + r0);
    L24:
        r0 = r5.getClass().getName();
        goto L26
    L21:
        return getRawType(((WildcardType) ZeusTransformUtils.preCheckCast(r5, WildcardType.class, "com.obric.memorydata.plugin")).getUpperBounds()[0]);
    }

    private static Type getSupertype(Type r2, Class<?> r3, Class<?> r4) {
        Type r5 = (Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, WildcardType.class) == false) goto L5;
        r5 = ((WildcardType) ZeusTransformUtils.preCheckCast(r5, WildcardType.class, "com.obric.memorydata.plugin")).getUpperBounds()[0];
    L5:
        C$Gson$Preconditions.checkArgument(r4.isAssignableFrom(r3));
        return resolve(r5, r3, getGenericSupertype(r5, r3, r4));
    }

    private static int indexOf(Object[] r3, Object r4) {
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        if (r4.equals(r3[r1]) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L9:
        throw new NoSuchElementException();
    }

    public static ParameterizedType newParameterizedTypeWithOwner(Type r2, Type r3, Type... r4) {
        return new ParameterizedTypeImpl((Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin"), (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin"), r4);
    }

    public static Type resolve(Type r2, Class<?> r3, Type r4) {
        return resolve((Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin"), r3, (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin"), new HashMap());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v11, types: [java.lang.reflect.GenericArrayType] */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v14, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r12v15, types: [java.lang.Object, java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r12v18, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.Object, java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r12v9, types: [java.lang.reflect.ParameterizedType] */
    private static Type resolve(Type r10, Class<?> r11, Type r12, Map<TypeVariable<?>, Type> r13) {
        Type r14 = (Type) ZeusTransformUtils.wrapperContextForParams(r10, Type.class, "com.obric.memorydata.plugin");
        ?? r15 = (Type) ZeusTransformUtils.wrapperContextForParams(r12, Type.class, "com.obric.memorydata.plugin");
        Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        TypeVariable r0 = null;
    L4:
        if (ZeusTransformUtils.instanceOf(r15, TypeVariable.class) == false) goto L19;
        TypeVariable r2 = (TypeVariable) ZeusTransformUtils.preCheckCast(r15, TypeVariable.class, "com.obric.memorydata.plugin");
        Type r3 = (Type) ZeusTransformUtils.preCheckCast(r16.get(r2), Type.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L8;
        r16.put(r2, Void.TYPE);
        if (r0 != null) goto L15;
        r0 = r2;
    L15:
        r15 = resolveTypeVariable(r14, r11, r2);
        if (r15 != r2) goto L4;
    L56:
        if (r0 == null) goto L58;
        r16.put(r0, r15);
    L58:
        return r15;
    L8:
        if (r3 != Void.TYPE) goto L11;
        return r15;
    L11:
        return r3;
    L19:
        if (ZeusTransformUtils.instanceOf(r15, Class.class) == false) goto L28;
        if (((Class) ZeusTransformUtils.preCheckCast(r15, Class.class, "com.obric.memorydata.plugin")).isArray() == false) goto L28;
        r15 = (Class) ZeusTransformUtils.preCheckCast(r15, Class.class, "com.obric.memorydata.plugin");
        Class<?> r1 = r15.getComponentType();
        Type r17 = resolve(r14, r11, r1, r16);
        if (equal(r1, r17) == true) goto L56;
    L25:
        Type r18 = arrayOf(r17);
    L26:
        r15 = r18;
    L28:
        if (ZeusTransformUtils.instanceOf(r15, GenericArrayType.class) == false) goto L32;
        r15 = (GenericArrayType) ZeusTransformUtils.preCheckCast(r15, GenericArrayType.class, "com.obric.memorydata.plugin");
        Type r4 = r15.getGenericComponentType();
        r17 = resolve(r14, r11, r4, r16);
        if (equal(r4, r17) == false) goto L25;
    L32:
        int r5 = 0;
        if (ZeusTransformUtils.instanceOf(r15, ParameterizedType.class) == false) goto L45;
        r15 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r15, ParameterizedType.class, "com.obric.memorydata.plugin");
        Type r6 = r15.getOwnerType();
        Type r7 = resolve(r14, r11, r6, r16);
        boolean r8 = !equal(r7, r6);
        Type[] r9 = r15.getActualTypeArguments();
        int r19 = r9.length;
    L35:
        if (r5 >= r19) goto L42;
        Type r20 = resolve(r14, r11, r9[r5], r16);
        if (equal(r20, r9[r5]) == true) goto L41;
        if (r8 == true) goto L40;
        r9 = (Type[]) ZeusTransformUtils.preCheckCast(r9.clone(), Type[].class, "com.obric.memorydata.plugin");
        r8 = true;
    L40:
        r9[r5] = r20;
    L41:
        r5 = r5 + 1;
        goto L35
    L42:
        if (r8 == false) goto L56;
        r18 = newParameterizedTypeWithOwner(r7, r15.getRawType(), r9);
        goto L26
    L45:
        if (ZeusTransformUtils.instanceOf(r15, WildcardType.class) == false) goto L56;
        r15 = (WildcardType) ZeusTransformUtils.preCheckCast(r15, WildcardType.class, "com.obric.memorydata.plugin");
        Type[] r21 = r15.getLowerBounds();
        Type[] r22 = r15.getUpperBounds();
        if (r21.length != 1) goto L52;
        Type r110 = resolve(r14, r11, r21[0], r16);
        if (r110 == r21[0]) goto L56;
        r15 = supertypeOf(r110);
        goto L56
    L52:
        if (r22.length != 1) goto L56;
        Type r111 = resolve(r14, r11, r22[0], r16);
        if (r111 == r22[0]) goto L56;
        r15 = subtypeOf(r111);
        goto L56
    }

    private static Type resolveTypeVariable(Type r2, Class<?> r3, TypeVariable<?> r4) {
        Type r5 = (Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin");
        TypeVariable r6 = (TypeVariable) ZeusTransformUtils.wrapperContextForParams(r4, TypeVariable.class, "com.obric.memorydata.plugin");
        Class<?> r0 = declaringClassOf(r6);
        if (r0 != null) goto L5;
        return r6;
    L5:
        Type r7 = getGenericSupertype(r5, r3, r0);
        if (ZeusTransformUtils.instanceOf(r7, ParameterizedType.class) == false) goto L9;
        int r8 = indexOf(r0.getTypeParameters(), r6);
        return ((ParameterizedType) ZeusTransformUtils.preCheckCast(r7, ParameterizedType.class, "com.obric.memorydata.plugin")).getActualTypeArguments()[r8];
    L9:
        return r6;
    }

    public static WildcardType subtypeOf(Type r2) {
        Type r3 = (Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, WildcardType.class) == false) goto L5;
        Type[] r4 = ((WildcardType) ZeusTransformUtils.preCheckCast(r3, WildcardType.class, "com.obric.memorydata.plugin")).getUpperBounds();
    L7:
        return new WildcardTypeImpl(r4, EMPTY_TYPE_ARRAY);
    L5:
        r4 = new Type[]{r3};
        goto L7
    }

    public static WildcardType supertypeOf(Type r4) {
        Type r5 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, WildcardType.class) == false) goto L5;
        Type[] r6 = ((WildcardType) ZeusTransformUtils.preCheckCast(r5, WildcardType.class, "com.obric.memorydata.plugin")).getLowerBounds();
    L7:
        return new WildcardTypeImpl(new Type[]{Object.class}, r6);
    L5:
        r6 = new Type[]{r5};
        goto L7
    }

    public static String typeToString(Type r2) {
        Type r3 = (Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Class.class) == false) goto L6;
        return ((Class) ZeusTransformUtils.preCheckCast(r3, Class.class, "com.obric.memorydata.plugin")).getName();
    L6:
        return r3.toString();
    }
}
