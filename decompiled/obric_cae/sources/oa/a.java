package oa;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class a<T> {
    private final int hashCode;
    private final Class<? super T> rawType;
    private final Type type;

    public a() {
        Type r8 = getTypeTokenTypeArgument();
        this.type = r8;
        this.rawType = (Class<? super T>) ja.a.e(r8);
        this.hashCode = r8.hashCode();
    }

    private static AssertionError buildUnexpectedTypeError(Type r8, Class<?>... r10) {
        StringBuilder r11 = new StringBuilder("Unexpected type. Expected one of: ");
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
        r11.append(r8.getClass().getName());
        r11.append(", for type token: ");
        r11.append(r8.toString());
        r11.append('.');
        return new AssertionError(r11.toString());
    }

    public static <T> a<T> get(Class<T> r8) {
        return new a(r8);
    }

    public static a<?> getArray(Type r8) {
        return new a(new ja.a.C0103a(r8));
    }

    public static a<?> getParameterized(Type r11, Type... r12) {
        Objects.requireNonNull(r11);
        Objects.requireNonNull(r12);
        if ((r11 instanceof Class) == false) goto L21;
        Class r8 = (Class) r11;
        TypeVariable<Class<T>>[] r10 = r8.getTypeParameters();
        int r13 = r10.length;
        int r14 = r12.length;
        if (r14 != r13) goto L19;
        int r15 = 0;
    L7:
        if (r15 >= r13) goto L17;
        Type r16 = r12[r15];
        Class<?> r17 = ja.a.e(r16);
        TypeVariable<Class<T>> r18 = r10[r15];
        Type[] r19 = r18.getBounds();
        int r20 = r19.length;
        int r21 = 0;
    L9:
        if (r21 >= r20) goto L15;
        if (ja.a.e(r19[r21]).isAssignableFrom(r17) == false) goto L14;
        r21 = r21 + 1;
        goto L9
    L14:
        throw new IllegalArgumentException("Type argument " + r16 + " does not satisfy bounds for type variable " + r18 + " declared by " + r11);
    L15:
        r15 = r15 + 1;
        goto L7
    L17:
        return new a(new ja.a.b(null, r11, r12));
    L19:
        throw new IllegalArgumentException(r8.getName() + " requires " + r13 + " type arguments, but got " + r14);
    L21:
        throw new IllegalArgumentException("rawType must be of type Class, but was " + r11);
    }

    private Type getTypeTokenTypeArgument() {
        Type r8 = getClass().getGenericSuperclass();
        if ((r8 instanceof ParameterizedType) == false) goto L8;
        ParameterizedType r10 = (ParameterizedType) r8;
        if (r10.getRawType() != a.class) goto L12;
        return ja.a.a(r10.getActualTypeArguments()[0]);
    L12:
        throw new IllegalStateException("Must only create direct subclasses of TypeToken");
    L8:
        if (r8 != a.class) goto L12;
        throw new IllegalStateException("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.");
    }

    private static boolean matches(Type r8, Type r10, Map<String, Type> r11) {
        if (r10.equals(r8) == false) goto L5;
    L10:
        return true;
    L5:
        if ((r8 instanceof TypeVariable) == true) goto L7;
    L9:
        return false;
    L7:
        if (r10.equals(r11.get(((TypeVariable) r8).getName())) == false) goto L9;
        goto L9
    }

    private static boolean typeEquals(ParameterizedType r8, ParameterizedType r10, Map<String, Type> r11) {
        if (r8.getRawType().equals(r10.getRawType()) == false) goto L13;
        Type[] r12 = r8.getActualTypeArguments();
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

    public final boolean equals(Object r8) {
        if ((r8 instanceof a) == true) goto L5;
    L7:
        return false;
    L5:
        if (ja.a.c(this.type, ((a) r8).type) == false) goto L7;
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
    public boolean isAssignableFrom(Class<?> r8) {
        return isAssignableFrom(r8);
    }

    public final String toString() {
        return ja.a.h(this.type);
    }

    private a(Type r8) {
        Objects.requireNonNull(r8);
        Type r10 = ja.a.a(r8);
        this.type = r10;
        this.rawType = (Class<? super T>) ja.a.e(r10);
        this.hashCode = r10.hashCode();
    }

    public static a<?> get(Type r8) {
        return new a(r8);
    }

    @Deprecated
    public boolean isAssignableFrom(Type r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if (this.type.equals(r8) == false) goto L8;
        return true;
    L8:
        Type r10 = this.type;
        if ((r10 instanceof Class) == false) goto L13;
        return this.rawType.isAssignableFrom(ja.a.e(r8));
    L13:
        if ((r10 instanceof ParameterizedType) == false) goto L17;
        return isAssignableFrom(r8, (ParameterizedType) r10, new HashMap());
    L17:
        if ((r10 instanceof GenericArrayType) == false) goto L25;
        if (this.rawType.isAssignableFrom(ja.a.e(r8)) == true) goto L21;
        return false;
    L21:
        if (isAssignableFrom(r8, (GenericArrayType) this.type) == true) goto L23;
        return false;
    L23:
        return true;
    L25:
        throw buildUnexpectedTypeError(r10, new Class[]{Class.class, ParameterizedType.class, GenericArrayType.class});
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v9 */
    private static boolean isAssignableFrom(Type r8, GenericArrayType r10) {
        Type r11 = r10.getGenericComponentType();
        if ((r11 instanceof ParameterizedType) == true) goto L5;
        return true;
    L5:
        if ((r8 instanceof GenericArrayType) == false) goto L8;
        r8 = ((GenericArrayType) r8).getGenericComponentType();
    L14:
        return isAssignableFrom(r8, (ParameterizedType) r11, new HashMap());
    L8:
        if ((r8 instanceof Class) == false) goto L14;
        r8 = (Class) r8;
    L11:
        if (r8.isArray() == false) goto L14;
        r8 = r8.getComponentType();
        goto L11
    }

    private static boolean isAssignableFrom(Type r10, ParameterizedType r11, Map<String, Type> r12) {
        int r8 = 0;
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r11.equals(r10) == false) goto L8;
        return true;
    L8:
        Class<?> r13 = ja.a.e(r10);
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
        if (r8 >= r21) goto L31;
        if (isAssignableFrom(r20[r8], r11, new HashMap(r12)) == true) goto L28;
        r8 = r8 + 1;
        goto L25
    L28:
        return true;
    L31:
        return isAssignableFrom(r13.getGenericSuperclass(), r11, new HashMap(r12));
    L11:
        r14 = null;
        goto L12
    }

    @Deprecated
    public boolean isAssignableFrom(a<?> r8) {
        return isAssignableFrom(r8.getType());
    }
}
