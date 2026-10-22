package com.google.gson.reflect;

import ai.j0;
import com.google.gson.internal.GsonTypes;
import com.google.gson.internal.TroubleshootingGuide;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class TypeToken<T> {
    private final int hashCode;
    private final Class<? super T> rawType;
    private final Type type;

    public TypeToken() {
        Type r5 = getTypeTokenTypeArgument();
        this.type = r5;
        this.rawType = (Class<? super T>) GsonTypes.getRawType(r5);
        this.hashCode = r5.hashCode();
    }

    private static IllegalArgumentException buildUnsupportedTypeException(Type r5, Class<?>... r10) {
        StringBuilder r11 = new StringBuilder("Unsupported type, expected one of: ");
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.append(r10[r13].getName());
        r11.append(", ");
        r13 = r13 + 1;
        goto L3
    L5:
        r11.append("but got: ");
        r11.append(r5.getClass().getName());
        r11.append(", for type token: ");
        r11.append(r5.toString());
        return new IllegalArgumentException(r11.toString());
    }

    public static TypeToken<?> get(Type r5) {
        return new TypeToken(r5);
    }

    public static TypeToken<?> getArray(Type r5) {
        return new TypeToken(GsonTypes.arrayOf(r5));
    }

    public static TypeToken<?> getParameterized(Type r12, Type... r13) {
        Objects.requireNonNull(r12);
        Objects.requireNonNull(r13);
        if ((r12 instanceof Class) == false) goto L29;
        Class r5 = (Class) r12;
        TypeVariable<Class<T>>[] r10 = r5.getTypeParameters();
        int r11 = r10.length;
        int r14 = r13.length;
        if (r14 != r11) goto L27;
        if (r13.length != 0) goto L11;
        return get(r5);
    L11:
        if (GsonTypes.requiresOwnerType(r12) == true) goto L25;
        int r15 = 0;
    L13:
        if (r15 >= r11) goto L23;
        Type r16 = r13[r15];
        Objects.requireNonNull(r16, "Type argument must not be null");
        Type r17 = r16;
        Class<?> r18 = GsonTypes.getRawType(r17);
        TypeVariable<Class<T>> r19 = r10[r15];
        Type[] r20 = r19.getBounds();
        int r21 = r20.length;
        int r110 = 0;
    L15:
        if (r110 >= r21) goto L21;
        if (GsonTypes.getRawType(r20[r110]).isAssignableFrom(r18) == false) goto L20;
        r110 = r110 + 1;
        goto L15
    L20:
        throw new IllegalArgumentException("Type argument " + r17 + " does not satisfy bounds for type variable " + r19 + " declared by " + r12);
    L21:
        r15 = r15 + 1;
        goto L13
    L23:
        return new TypeToken(GsonTypes.newParameterizedTypeWithOwner(null, r5, r13));
    L25:
        throw new IllegalArgumentException("Raw type " + r5.getName() + " is not supported because it requires specifying an owner type");
    L27:
        throw new IllegalArgumentException(r5.getName() + " requires " + r11 + " type arguments, but got " + r14);
    L29:
        throw new IllegalArgumentException(j0.m("rawType must be of type Class, but was ", r12));
    }

    private Type getTypeTokenTypeArgument() {
        Type r5 = getClass().getGenericSuperclass();
        if ((r5 instanceof ParameterizedType) == false) goto L10;
        ParameterizedType r10 = (ParameterizedType) r5;
        if (r10.getRawType() != TypeToken.class) goto L14;
        Type r11 = GsonTypes.canonicalize(r10.getActualTypeArguments()[0]);
        if (isCapturingTypeVariablesForbidden() == false) goto L9;
        verifyNoTypeVariable(r11);
    L9:
        return r11;
    L14:
        throw new IllegalStateException("Must only create direct subclasses of TypeToken");
    L10:
        if (r5 != TypeToken.class) goto L14;
        throw new IllegalStateException("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.\nSee " + TroubleshootingGuide.createUrl("type-token-raw"));
    }

    private static boolean isCapturingTypeVariablesForbidden() {
        return !Objects.equals(System.getProperty("gson.allowCapturingTypeVariables"), "true");
    }

    private static boolean matches(Type r5, Type r10, Map<String, Type> r11) {
        if (r10.equals(r5) == false) goto L5;
    L10:
        return true;
    L5:
        if ((r5 instanceof TypeVariable) == true) goto L7;
    L9:
        return false;
    L7:
        if (r10.equals(r11.get(((TypeVariable) r5).getName())) == false) goto L9;
        goto L9
    }

    private static boolean typeEquals(ParameterizedType r5, ParameterizedType r10, Map<String, Type> r11) {
        if (r5.getRawType().equals(r10.getRawType()) == false) goto L13;
        Type[] r12 = r5.getActualTypeArguments();
        Type[] r13 = r10.getActualTypeArguments();
        int r14 = 0;
    L6:
        if (r14 >= r12.length) goto L11;
        if (matches(r12[r14], r13[r14], r11) == false) goto L9;
        r14 = r14 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    L13:
        return false;
    }

    private static void verifyNoTypeVariable(Type r5) {
        if ((r5 instanceof TypeVariable) == false) goto L5;
        TypeVariable r10 = (TypeVariable) r5;
        throw new IllegalArgumentException("TypeToken type argument must not contain a type variable; captured type variable " + r10.getName() + " declared by " + r10.getGenericDeclaration() + "\nSee " + TroubleshootingGuide.createUrl("typetoken-type-variable"));
    L5:
        if ((r5 instanceof GenericArrayType) == false) goto L7;
        verifyNoTypeVariable(((GenericArrayType) r5).getGenericComponentType());
        return;
    L7:
        int r11 = 0;
        if ((r5 instanceof ParameterizedType) == false) goto L16;
        ParameterizedType r12 = (ParameterizedType) r5;
        Type r13 = r12.getOwnerType();
        if (r13 == null) goto L12;
        verifyNoTypeVariable(r13);
    L12:
        Type[] r14 = r12.getActualTypeArguments();
        int r15 = r14.length;
    L13:
        if (r11 >= r15) goto L33;
        verifyNoTypeVariable(r14[r11]);
        r11 = r11 + 1;
        goto L13
    L33:
        return;
    L16:
        if ((r5 instanceof WildcardType) == false) goto L23;
        WildcardType r16 = (WildcardType) r5;
        Type[] r17 = r16.getLowerBounds();
        int r18 = r17.length;
        int r19 = 0;
    L18:
        if (r19 >= r18) goto L20;
        verifyNoTypeVariable(r17[r19]);
        r19 = r19 + 1;
        goto L18
    L20:
        Type[] r20 = r16.getUpperBounds();
        int r21 = r20.length;
    L21:
        if (r11 >= r21) goto L34;
        verifyNoTypeVariable(r20[r11]);
        r11 = r11 + 1;
        goto L21
    L34:
        return;
    L23:
        if (r5 == null) goto L26;
        return;
    L26:
        throw new IllegalArgumentException("TypeToken captured `null` as type argument; probably a compiler / runtime bug");
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof TypeToken) == true) goto L5;
    L7:
        return false;
    L5:
        if (GsonTypes.equals(this.type, ((TypeToken) r5).type) == false) goto L7;
        return true;
    }

    public final Class<? super T> getRawType() {
        return this.rawType;
    }

    public final Type getType() {
        return this.type;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    @Deprecated
    public boolean isAssignableFrom(Class<?> r5) {
        return isAssignableFrom(r5);
    }

    public final String toString() {
        return GsonTypes.typeToString(this.type);
    }

    public static <T> TypeToken<T> get(Class<T> r5) {
        return new TypeToken(r5);
    }

    @Deprecated
    public boolean isAssignableFrom(Type r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (this.type.equals(r5) == false) goto L8;
        return true;
    L8:
        Type r10 = this.type;
        if ((r10 instanceof Class) == false) goto L13;
        return this.rawType.isAssignableFrom(GsonTypes.getRawType(r5));
    L13:
        if ((r10 instanceof ParameterizedType) == false) goto L17;
        return isAssignableFrom(r5, (ParameterizedType) r10, new HashMap());
    L17:
        if ((r10 instanceof GenericArrayType) == false) goto L25;
        if (this.rawType.isAssignableFrom(GsonTypes.getRawType(r5)) == true) goto L21;
        return false;
    L21:
        if (isAssignableFrom(r5, (GenericArrayType) this.type) == true) goto L23;
        return false;
    L23:
        return true;
    L25:
        throw buildUnsupportedTypeException(r10, new Class[]{Class.class, ParameterizedType.class, GenericArrayType.class});
    }

    private TypeToken(Type r5) {
        Objects.requireNonNull(r5);
        Type r10 = GsonTypes.canonicalize(r5);
        this.type = r10;
        this.rawType = (Class<? super T>) GsonTypes.getRawType(r10);
        this.hashCode = r10.hashCode();
    }

    @Deprecated
    public boolean isAssignableFrom(TypeToken<?> r5) {
        return isAssignableFrom(r5.getType());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v9 */
    private static boolean isAssignableFrom(Type r5, GenericArrayType r10) {
        Type r11 = r10.getGenericComponentType();
        if ((r11 instanceof ParameterizedType) == true) goto L5;
        return true;
    L5:
        if ((r5 instanceof GenericArrayType) == false) goto L8;
        r5 = ((GenericArrayType) r5).getGenericComponentType();
    L14:
        return isAssignableFrom(r5, (ParameterizedType) r11, new HashMap());
    L8:
        if ((r5 instanceof Class) == false) goto L14;
        r5 = (Class) r5;
    L11:
        if (r5.isArray() == false) goto L14;
        r5 = r5.getComponentType();
        goto L11
    }

    private static boolean isAssignableFrom(Type r10, ParameterizedType r11, Map<String, Type> r12) {
        int r5 = 0;
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r11.equals(r10) == false) goto L8;
        return true;
    L8:
        Class<?> r13 = GsonTypes.getRawType(r10);
        if ((r10 instanceof ParameterizedType) == false) goto L11;
        ParameterizedType r14 = (ParameterizedType) r10;
    L12:
        if (r14 == null) goto L24;
        Type[] r15 = r14.getActualTypeArguments();
        TypeVariable<Class<?>>[] r16 = r13.getTypeParameters();
        int r17 = 0;
    L15:
        if (r17 >= r15.length) goto L22;
        Type r18 = r15[r17];
        TypeVariable<Class<?>> r19 = r16[r17];
    L18:
        if ((r18 instanceof TypeVariable) == false) goto L20;
        r18 = r12.get(((TypeVariable) r18).getName());
        goto L18
    L20:
        r12.put(r19.getName(), r18);
        r17 = r17 + 1;
        goto L15
    L22:
        if (typeEquals(r14, r11, r12) == false) goto L24;
        return true;
    L24:
        Type[] r20 = r13.getGenericInterfaces();
        int r21 = r20.length;
    L25:
        if (r5 >= r21) goto L31;
        if (isAssignableFrom(r20[r5], r11, new HashMap(r12)) == true) goto L28;
        r5 = r5 + 1;
        goto L25
    L28:
        return true;
    L31:
        return isAssignableFrom(r13.getGenericSuperclass(), r11, new HashMap(r12));
    L11:
        r14 = null;
        goto L12
    }
}
