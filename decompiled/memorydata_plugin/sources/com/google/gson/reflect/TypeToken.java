package com.google.gson.reflect;

import com.google.gson.internal.C$Gson$Types;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class TypeToken<T> {
    private final int hashCode;
    private final Class<? super T> rawType;
    private final Type type;

    public TypeToken() {
        Type r0 = getTypeTokenTypeArgument();
        this.type = r0;
        this.rawType = (Class<? super T>) C$Gson$Types.getRawType(r0);
        this.hashCode = r0.hashCode();
    }

    private TypeToken(Type r3) {
        Type r4 = C$Gson$Types.canonicalize((Type) ZeusTransformUtils.preCheckCast(Objects.requireNonNull((Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin")), Type.class, "com.obric.memorydata.plugin"));
        this.type = r4;
        this.rawType = (Class<? super T>) C$Gson$Types.getRawType(r4);
        this.hashCode = r4.hashCode();
    }

    private static AssertionError buildUnexpectedTypeError(Type r5, Class<?>... r6) {
        Type r7 = (Type) ZeusTransformUtils.wrapperContextForParams(r5, Type.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder("Unexpected type. Expected one of: ");
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.append(r6[r2].getName()).append(", ");
        r2 = r2 + 1;
        goto L3
    L5:
        r0.append("but got: ").append(r7.getClass().getName()).append(", for type token: ").append(r7.toString()).append('.');
        return new AssertionError(r0.toString());
    }

    public static <T> TypeToken<T> get(Class<T> r1) {
        return new TypeToken(r1);
    }

    public static TypeToken<?> get(Type r2) {
        return new TypeToken((Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin"));
    }

    public static TypeToken<?> getArray(Type r2) {
        return new TypeToken(C$Gson$Types.arrayOf((Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin")));
    }

    public static TypeToken<?> getParameterized(Type r11, Type... r12) {
        Type r13 = (Type) ZeusTransformUtils.wrapperContextForParams(r11, Type.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r13);
        Objects.requireNonNull(r12);
        if (ZeusTransformUtils.instanceOf(r13, Class.class) == false) goto L21;
        Class r0 = (Class) ZeusTransformUtils.preCheckCast(r13, Class.class, "com.obric.memorydata.plugin");
        TypeVariable<Class<T>>[] r1 = r0.getTypeParameters();
        int r2 = r1.length;
        int r3 = r12.length;
        if (r3 != r2) goto L19;
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L17;
        Type r5 = r12[r4];
        Class<?> r6 = C$Gson$Types.getRawType(r5);
        TypeVariable<Class<T>> r7 = r1[r4];
        Type[] r8 = r7.getBounds();
        int r9 = r8.length;
        int r10 = 0;
    L9:
        if (r10 >= r9) goto L15;
        if (C$Gson$Types.getRawType(r8[r10]).isAssignableFrom(r6) == false) goto L14;
        r10 = r10 + 1;
        goto L9
    L14:
        throw new IllegalArgumentException("Type argument " + r5 + " does not satisfy bounds for type variable " + r7 + " declared by " + r13);
    L15:
        r4 = r4 + 1;
        goto L7
    L17:
        return new TypeToken(C$Gson$Types.newParameterizedTypeWithOwner(null, r13, r12));
    L19:
        throw new IllegalArgumentException(r0.getName() + " requires " + r2 + " type arguments, but got " + r3);
    L21:
        throw new IllegalArgumentException("rawType must be of type Class, but was " + r13);
    }

    private Type getTypeTokenTypeArgument() {
        Type r3 = getClass().getGenericSuperclass();
        if (ZeusTransformUtils.instanceOf(r3, ParameterizedType.class) == false) goto L8;
        ParameterizedType r4 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r3, ParameterizedType.class, "com.obric.memorydata.plugin");
        if (r4.getRawType() != TypeToken.class) goto L12;
        return C$Gson$Types.canonicalize(r4.getActualTypeArguments()[0]);
    L12:
        throw new IllegalStateException("Must only create direct subclasses of TypeToken");
    L8:
        if (r3 != TypeToken.class) goto L12;
        throw new IllegalStateException("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.reflect.Type] */
    private static boolean isAssignableFrom(Type r2, GenericArrayType r3) {
        ?? r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin");
        Type r5 = ((GenericArrayType) ZeusTransformUtils.wrapperContextForParams(r3, GenericArrayType.class, "com.obric.memorydata.plugin")).getGenericComponentType();
        if (ZeusTransformUtils.instanceOf(r5, ParameterizedType.class) == true) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, GenericArrayType.class) == false) goto L8;
        r4 = ((GenericArrayType) ZeusTransformUtils.preCheckCast(r4, GenericArrayType.class, "com.obric.memorydata.plugin")).getGenericComponentType();
    L14:
        return isAssignableFrom(r4, (ParameterizedType) ZeusTransformUtils.preCheckCast(r5, ParameterizedType.class, "com.obric.memorydata.plugin"), new HashMap());
    L8:
        if (ZeusTransformUtils.instanceOf(r4, Class.class) == false) goto L14;
        r4 = (Class) ZeusTransformUtils.preCheckCast(r4, Class.class, "com.obric.memorydata.plugin");
    L11:
        if (r4.isArray() == false) goto L14;
        r4 = r4.getComponentType();
        goto L11
    }

    private static boolean isAssignableFrom(Type r10, ParameterizedType r11, Map<String, Type> r12) {
        Type r13 = (Type) ZeusTransformUtils.wrapperContextForParams(r10, Type.class, "com.obric.memorydata.plugin");
        ParameterizedType r14 = (ParameterizedType) ZeusTransformUtils.wrapperContextForParams(r11, ParameterizedType.class, "com.obric.memorydata.plugin");
        Map r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        if (r13 != null) goto L6;
        return false;
    L6:
        if (r14.equals(r13) == false) goto L8;
        return true;
    L8:
        Class<?> r2 = C$Gson$Types.getRawType(r13);
        ParameterizedType r4 = null;
        if (ZeusTransformUtils.instanceOf(r13, ParameterizedType.class) == false) goto L11;
        r4 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r13, ParameterizedType.class, "com.obric.memorydata.plugin");
    L11:
        if (r4 == null) goto L23;
        Type[] r16 = r4.getActualTypeArguments();
        TypeVariable<Class<?>>[] r5 = r2.getTypeParameters();
        int r6 = 0;
    L14:
        if (r6 >= r16.length) goto L21;
        Type r7 = r16[r6];
        TypeVariable<Class<?>> r8 = r5[r6];
    L17:
        if (ZeusTransformUtils.instanceOf(r7, TypeVariable.class) == false) goto L19;
        r7 = (Type) ZeusTransformUtils.preCheckCast(r15.get(((TypeVariable) ZeusTransformUtils.preCheckCast(r7, TypeVariable.class, "com.obric.memorydata.plugin")).getName()), Type.class, "com.obric.memorydata.plugin");
        goto L17
    L19:
        r15.put(r8.getName(), r7);
        r6 = r6 + 1;
        goto L14
    L21:
        if (typeEquals(r4, r14, r15) == false) goto L23;
        return true;
    L23:
        Type[] r17 = r2.getGenericInterfaces();
        int r1 = r17.length;
    L24:
        if (r0 >= r1) goto L30;
        if (isAssignableFrom(r17[r0], r14, new HashMap(r15)) == true) goto L27;
        r0 = r0 + 1;
        goto L24
    L27:
        return true;
    L30:
        return isAssignableFrom(r2.getGenericSuperclass(), r14, new HashMap(r15));
    }

    private static boolean matches(Type r2, Type r3, Map<String, Type> r4) {
        Type r5 = (Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin");
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if (r6.equals(r5) == false) goto L5;
    L10:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, TypeVariable.class) == true) goto L7;
    L9:
        return false;
    L7:
        if (r6.equals(r7.get(((TypeVariable) ZeusTransformUtils.preCheckCast(r5, TypeVariable.class, "com.obric.memorydata.plugin")).getName())) == false) goto L9;
        goto L9
    }

    private static boolean typeEquals(ParameterizedType r4, ParameterizedType r5, Map<String, Type> r6) {
        ParameterizedType r7 = (ParameterizedType) ZeusTransformUtils.wrapperContextForParams(r4, ParameterizedType.class, "com.obric.memorydata.plugin");
        ParameterizedType r8 = (ParameterizedType) ZeusTransformUtils.wrapperContextForParams(r5, ParameterizedType.class, "com.obric.memorydata.plugin");
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        if (r7.getRawType().equals(r8.getRawType()) == false) goto L13;
        Type[] r10 = r7.getActualTypeArguments();
        Type[] r11 = r8.getActualTypeArguments();
        int r0 = 0;
    L6:
        if (r0 >= r10.length) goto L11;
        if (matches(r10[r0], r11[r0], r9) == false) goto L9;
        r0 = r0 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    L13:
        return false;
    }

    public final boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, TypeToken.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (C$Gson$Types.equals(this.type, ((TypeToken) ZeusTransformUtils.preCheckCast(r3, TypeToken.class, "com.obric.memorydata.plugin")).type) == false) goto L7;
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
    public boolean isAssignableFrom(TypeToken<?> r1) {
        return isAssignableFrom(r1.getType());
    }

    @Deprecated
    public boolean isAssignableFrom(Class<?> r1) {
        return isAssignableFrom(r1);
    }

    @Deprecated
    public boolean isAssignableFrom(Type r6) {
        Type r7 = (Type) ZeusTransformUtils.wrapperContextForParams(r6, Type.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L6;
        return false;
    L6:
        if (this.type.equals(r7) == false) goto L9;
        return true;
    L9:
        if (ZeusTransformUtils.instanceOf(this.type, Class.class) == false) goto L13;
        return this.rawType.isAssignableFrom(C$Gson$Types.getRawType(r7));
    L13:
        if (ZeusTransformUtils.instanceOf(this.type, ParameterizedType.class) == false) goto L17;
        return isAssignableFrom(r7, (ParameterizedType) ZeusTransformUtils.preCheckCast(this.type, ParameterizedType.class, "com.obric.memorydata.plugin"), new HashMap());
    L17:
        if (ZeusTransformUtils.instanceOf(this.type, GenericArrayType.class) == false) goto L25;
        if (this.rawType.isAssignableFrom(C$Gson$Types.getRawType(r7)) == true) goto L21;
        return false;
    L21:
        if (isAssignableFrom(r7, (GenericArrayType) ZeusTransformUtils.preCheckCast(this.type, GenericArrayType.class, "com.obric.memorydata.plugin")) == true) goto L23;
        return false;
    L23:
        return true;
    L25:
        throw buildUnexpectedTypeError(this.type, new Class[]{Class.class, ParameterizedType.class, GenericArrayType.class});
    }

    public final String toString() {
        return C$Gson$Types.typeToString(this.type);
    }
}
