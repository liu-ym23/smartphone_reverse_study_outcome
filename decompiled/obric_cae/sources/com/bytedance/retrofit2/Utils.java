package com.bytedance.retrofit2;

import com.bytedance.retrofit2.mime.TypedOutput;
import defpackage.b;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import we.z;

/* JADX INFO: loaded from: classes.dex */
public final class Utils {
    private static final int BUFFER_SIZE = 4096;
    static final Type[] EMPTY_TYPE_ARRAY = null;

    public static final class GenericArrayTypeImpl implements GenericArrayType {
        private final Type componentType;

        public GenericArrayTypeImpl(Type r8) {
            this.componentType = r8;
        }

        public boolean equals(Object r8) {
            if ((r8 instanceof GenericArrayType) == true) goto L5;
        L7:
            return false;
        L5:
            if (Utils.equals(this, (GenericArrayType) r8) == false) goto L7;
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
            return Utils.typeToString(this.componentType) + "[]";
        }
    }

    public static final class ParameterizedTypeImpl implements ParameterizedType {
        private final Type ownerType;
        private final Type rawType;
        private final Type[] typeArguments;

        public ParameterizedTypeImpl(Type r8, Type r10, Type... r11) {
            int r12 = 0;
            if ((r10 instanceof Class) == false) goto L16;
            boolean r13 = true;
            if (r8 != null) goto L7;
            boolean r14 = true;
        L9:
            if (((Class) r10).getEnclosingClass() == null) goto L12;
            r13 = false;
        L12:
            if (r14 == r13) goto L16;
            throw new IllegalArgumentException();
        L7:
            r14 = false;
        L16:
            this.ownerType = r8;
            this.rawType = r10;
            Type[] r15 = (Type[]) r11.clone();
            this.typeArguments = r15;
            int r16 = r15.length;
        L17:
            if (r12 >= r16) goto L23;
            Type r17 = r15[r12];
            if (r17 == null) goto L22;
            Utils.checkNotPrimitive(r17);
            r12 = r12 + 1;
            goto L17
        L22:
            throw null;
        }

        public boolean equals(Object r8) {
            if ((r8 instanceof ParameterizedType) == true) goto L5;
        L7:
            return false;
        L5:
            if (Utils.equals(this, (ParameterizedType) r8) == false) goto L7;
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
            int r8 = Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode();
            return Utils.hashCodeOrZero(this.ownerType) ^ r8;
        }

        public String toString() {
            int r8 = 1;
            StringBuilder r10 = new StringBuilder((this.typeArguments.length + 1) * 30);
            r10.append(Utils.typeToString(this.rawType));
            if (this.typeArguments.length == 0) goto L5;
            r10.append("<");
            r10.append(Utils.typeToString(this.typeArguments[0]));
        L8:
            if (r8 >= this.typeArguments.length) goto L10;
            r10.append(", ");
            r10.append(Utils.typeToString(this.typeArguments[r8]));
            r8 = r8 + 1;
            goto L8
        L10:
            r10.append(">");
            return r10.toString();
        L5:
            return r10.toString();
        }
    }

    public static final class WildcardTypeImpl implements WildcardType {
        private final Type lowerBound;
        private final Type upperBound;

        public WildcardTypeImpl(Type[] r8, Type[] r10) {
            if (r10.length > 1) goto L24;
            if (r8.length != 1) goto L22;
            if (r10.length != 1) goto L16;
            Type r11 = r10[0];
            if (r11 == null) goto L15;
            Utils.checkNotPrimitive(r11);
            if (r8[0] != Object.class) goto L14;
            this.lowerBound = r10[0];
            this.upperBound = Object.class;
            return;
        L14:
            throw new IllegalArgumentException();
        L15:
            throw null;
        L16:
            Type r12 = r8[0];
            if (r12 == null) goto L20;
            Utils.checkNotPrimitive(r12);
            this.lowerBound = null;
            this.upperBound = r8[0];
            return;
        L20:
            throw null;
        L22:
            throw new IllegalArgumentException();
        L24:
            throw new IllegalArgumentException();
        }

        public boolean equals(Object r8) {
            if ((r8 instanceof WildcardType) == true) goto L5;
        L7:
            return false;
        L5:
            if (Utils.equals(this, (WildcardType) r8) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type r8 = this.lowerBound;
            if (r8 == null) goto L6;
            return new Type[]{r8};
        L6:
            return Utils.EMPTY_TYPE_ARRAY;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.upperBound};
        }

        public int hashCode() {
            Type r8 = this.lowerBound;
            if (r8 == null) goto L5;
            int r10 = r8.hashCode() + 31;
        L7:
            return (this.upperBound.hashCode() + 31) ^ r10;
        L5:
            r10 = 1;
            goto L7
        }

        public String toString() {
            if (this.lowerBound == null) goto L8;
            StringBuilder r8 = new StringBuilder("? super ");
            Type r10 = this.lowerBound;
        L5:
            r8.append(Utils.typeToString(r10));
            return r8.toString();
        L8:
            if (this.upperBound != Object.class) goto L11;
            return "?";
        L11:
            r8 = new StringBuilder("? extends ");
            r10 = this.upperBound;
            goto L5
        }
    }

    static {
        EMPTY_TYPE_ARRAY = new Type[0];
    }

    private Utils() {
    }

    public static <T> T checkNotNull(T r8, String r10) {
        if (r8 == null) goto L5;
        return r8;
    L5:
        throw new NullPointerException(r10);
    }

    public static void checkNotPrimitive(Type r8) {
        if ((r8 instanceof Class) == true) goto L5;
        return;
    L5:
        if (((Class) r8).isPrimitive() == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException();
    }

    public static TypedOutput convert(final z r8) {
        return new AnonymousClass1(r8);
    }

    private static Class<?> declaringClassOf(TypeVariable<?> r8) {
        GenericDeclaration r10 = r8.getGenericDeclaration();
        if ((r10 instanceof Class) == true) goto L7;
        return null;
    L7:
        return (Class) r10;
    }

    private static boolean equal(Object r8, Object r10) {
        if (r8 == r10) goto L8;
        if (r8 != null) goto L5;
    L7:
        return false;
    L5:
        if (r8.equals(r10) == false) goto L7;
    L8:
        return true;
    }

    public static boolean equals(Type r8, Type r10) {
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
        if (equal(r11.getOwnerType(), r12.getOwnerType()) == false) goto L22;
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
        return equals(((GenericArrayType) r8).getGenericComponentType(), ((GenericArrayType) r10).getGenericComponentType());
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

    public static Type getCallResponseType(Type r8) {
        if ((r8 instanceof ParameterizedType) == false) goto L7;
        return getParameterUpperBound(0, (ParameterizedType) r8);
    L7:
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }

    public static Type getGenericSupertype(Type r8, Class<?> r10, Class<?> r11) {
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

    public static Type getParameterUpperBound(int r8, ParameterizedType r10) {
        Type[] r11 = r10.getActualTypeArguments();
        if (r8 >= 0) goto L5;
    L10:
        StringBuilder r12 = b.f("Index ", r8, " not in range [0,");
        r12.append(r11.length);
        r12.append(") for ");
        r12.append(r10);
        throw new IllegalArgumentException(r12.toString());
    L5:
        if (r8 >= r11.length) goto L10;
        Type r13 = r11[r8];
        if ((r13 instanceof WildcardType) == true) goto L9;
        return r13;
    L9:
        return ((WildcardType) r13).getUpperBounds()[0];
    }

    public static Class<?> getRawType(Type r8) {
        if (r8 == null) goto L30;
        if ((r8 instanceof Class) == false) goto L8;
        return (Class) r8;
    L8:
        if ((r8 instanceof ParameterizedType) == false) goto L16;
        Type r10 = ((ParameterizedType) r8).getRawType();
        if ((r10 instanceof Class) == false) goto L14;
        return (Class) r10;
    L14:
        throw new IllegalArgumentException();
    L16:
        if ((r8 instanceof GenericArrayType) == false) goto L20;
        return Array.newInstance(getRawType(((GenericArrayType) r8).getGenericComponentType()), 0).getClass();
    L20:
        if ((r8 instanceof TypeVariable) == false) goto L24;
        return Object.class;
    L24:
        if ((r8 instanceof WildcardType) == false) goto L28;
        return getRawType(((WildcardType) r8).getUpperBounds()[0]);
    L28:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r8 + "> is of type " + r8.getClass().getName());
    L30:
        throw new NullPointerException("type == null");
    }

    public static Type getSupertype(Type r8, Class<?> r10, Class<?> r11) {
        if (r11.isAssignableFrom(r10) == false) goto L7;
        return resolve(r8, r10, getGenericSupertype(r8, r10, r11));
    L7:
        throw new IllegalArgumentException();
    }

    public static boolean hasUnresolvableType(Type r8) {
        if ((r8 instanceof Class) == false) goto L6;
        return false;
    L6:
        if ((r8 instanceof ParameterizedType) == false) goto L15;
        Type[] r10 = ((ParameterizedType) r8).getActualTypeArguments();
        int r11 = r10.length;
        int r12 = 0;
    L8:
        if (r12 >= r11) goto L13;
        if (hasUnresolvableType(r10[r12]) == true) goto L11;
        r12 = r12 + 1;
        goto L8
    L11:
        return true;
    L13:
        return false;
    L15:
        if ((r8 instanceof GenericArrayType) == false) goto L19;
        return hasUnresolvableType(((GenericArrayType) r8).getGenericComponentType());
    L19:
        if ((r8 instanceof TypeVariable) == false) goto L22;
        return true;
    L22:
        if ((r8 instanceof WildcardType) == false) goto L24;
        return true;
    L24:
        if (r8 != null) goto L26;
        String r13 = "null";
    L28:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r8 + "> is of type " + r13);
    L26:
        r13 = r8.getClass().getName();
        goto L28
    }

    public static int hashCodeOrZero(Object r8) {
        if (r8 != null) goto L6;
        return 0;
    L6:
        return r8.hashCode();
    }

    private static int indexOf(Object[] r8, Object r10) {
        int r11 = 0;
    L4:
        if (r11 >= r8.length) goto L10;
        if (r10.equals(r8[r11]) == true) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return r11;
    L10:
        throw new NoSuchElementException();
    }

    public static boolean isAnnotationPresent(Annotation[] r8, Class<? extends Annotation> r10) {
        int r11 = r8.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        if (r10.isInstance(r8[r12]) == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static boolean permitsRequestBody(String r8) {
        if (requiresRequestBody(r8) == false) goto L5;
    L16:
        return true;
    L5:
        if (r8.equals(HttpMethodContrants.OPTIONS) == true) goto L16;
        if (r8.equals(HttpMethodContrants.DELETE) == true) goto L16;
        if (r8.equals("PROPFIND") == true) goto L16;
        if (r8.equals("MKCOL") == true) goto L16;
        if (r8.equals("LOCK") == true) goto L16;
        return false;
    }

    public static boolean requiresRequestBody(String r8) {
        if (r8.equals(HttpMethodContrants.POST) == false) goto L5;
    L14:
        return true;
    L5:
        if (r8.equals(HttpMethodContrants.PUT) == true) goto L14;
        if (r8.equals(HttpMethodContrants.PATCH) == true) goto L14;
        if (r8.equals("PROPPATCH") == true) goto L14;
        if (r8.equals("REPORT") == true) goto L14;
        return false;
    }

    public static Type resolve(Type r8, Class<?> r10, Type r11) {
    L3:
        if ((r10 instanceof TypeVariable) == false) goto L9;
        TypeVariable r12 = (TypeVariable) r10;
        Type r13 = resolveTypeVariable(r8, r10, r12);
        if (r13 == r12) goto L6;
        Type r14 = r13;
        goto L3
    L6:
        return r13;
    L9:
        if ((r14 instanceof Class) == false) goto L18;
        Class r15 = (Class) r14;
        if (r15.isArray() == false) goto L18;
        Class<?> r16 = r15.getComponentType();
        Type r17 = resolve(r8, r10, r16);
        if (r16 != r17) goto L16;
        return r15;
    L16:
        return new GenericArrayTypeImpl(r17);
    L18:
        if ((r14 instanceof GenericArrayType) == false) goto L24;
        GenericArrayType r18 = (GenericArrayType) r14;
        Type r19 = r18.getGenericComponentType();
        Type r20 = resolve(r8, r10, r19);
        if (r19 != r20) goto L23;
        return r18;
    L23:
        return new GenericArrayTypeImpl(r20);
    L24:
        int r21 = 0;
        if ((r14 instanceof ParameterizedType) == false) goto L41;
        ParameterizedType r110 = (ParameterizedType) r14;
        Type r22 = r110.getOwnerType();
        Type r23 = resolve(r8, r10, r22);
        if (r23 == r22) goto L29;
        boolean r24 = true;
    L30:
        Type[] r25 = r110.getActualTypeArguments();
        int r26 = r25.length;
    L31:
        if (r21 >= r26) goto L38;
        Type r27 = resolve(r8, r10, r25[r21]);
        if (r27 == r25[r21]) goto L37;
        if (r24 == true) goto L36;
        r25 = (Type[]) r25.clone();
        r24 = true;
    L36:
        r25[r21] = r27;
    L37:
        r21 = r21 + 1;
        goto L31
    L38:
        if (r24 == true) goto L40;
        return r110;
    L40:
        return new ParameterizedTypeImpl(r23, r110.getRawType(), r25);
    L29:
        r24 = false;
        goto L30
    L41:
        boolean r28 = r14 instanceof WildcardType;
        Type r111 = r14;
        if (r28 == false) goto L55;
        WildcardType r112 = (WildcardType) r14;
        Type[] r29 = r112.getLowerBounds();
        Type[] r30 = r112.getUpperBounds();
        if (r29.length != 1) goto L49;
        Type r31 = resolve(r8, r10, r29[0]);
        r111 = r112;
        if (r31 == r29[0]) goto L55;
        return new WildcardTypeImpl(new Type[]{Object.class}, new Type[]{r31});
    L49:
        r111 = r112;
        if (r30.length != 1) goto L55;
        Type r32 = resolve(r8, r10, r30[0]);
        r111 = r112;
        if (r32 == r30[0]) goto L55;
        return new WildcardTypeImpl(new Type[]{r32}, EMPTY_TYPE_ARRAY);
    L55:
        return r111;
    }

    private static Type resolveTypeVariable(Type r8, Class<?> r10, TypeVariable<?> r11) {
        Class<?> r12 = declaringClassOf(r11);
        if (r12 != null) goto L5;
        return r11;
    L5:
        Type r13 = getGenericSupertype(r8, r10, r12);
        if ((r13 instanceof ParameterizedType) == false) goto L9;
        int r14 = indexOf(r12.getTypeParameters(), r11);
        return ((ParameterizedType) r13).getActualTypeArguments()[r14];
    L9:
        return r11;
    }

    public static byte[] streamToBytes(InputStream r8) {
        ByteArrayOutputStream r10 = new ByteArrayOutputStream();
        if (r8 == null) goto L9;
        byte[] r11 = new byte[4096];
    L5:
        int r12 = r8.read(r11);
        if (r12 == (-1)) goto L9;
        r10.write(r11, 0, r12);
    L9:
        return r10.toByteArray();
    }

    public static String typeToString(Type r8) {
        if ((r8 instanceof Class) == false) goto L6;
        return ((Class) r8).getName();
    L6:
        return r8.toString();
    }

    public static <T> void validateServiceInterface(Class<T> r8) {
        if (r8.isInterface() == false) goto L10;
        if (r8.getInterfaces().length > 0) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
    L10:
        throw new IllegalArgumentException("API declarations must be interfaces.");
    }
}
