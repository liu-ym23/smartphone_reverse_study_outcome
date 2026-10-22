package ai;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Type[] f305a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f306b = 4;

    static {
        f305a = new Type[0];
    }

    public static void b(Object r5, String r10) {
        if (r5 == null) goto L5;
        return;
    L5:
        throw new NullPointerException(r10);
    }

    public static void c(Type r5) {
        if ((r5 instanceof Class) == true) goto L5;
        return;
    L5:
        if (((Class) r5).isPrimitive() == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException();
    }

    public static boolean d(Type r5, Type r10) {
        if (r5 != r10) goto L6;
        return true;
    L6:
        if ((r5 instanceof Class) == false) goto L10;
        return r5.equals(r10);
    L10:
        if ((r5 instanceof ParameterizedType) == false) goto L27;
        if ((r10 instanceof ParameterizedType) == true) goto L14;
        return false;
    L14:
        ParameterizedType r11 = (ParameterizedType) r5;
        ParameterizedType r12 = (ParameterizedType) r10;
        Type r13 = r11.getOwnerType();
        Type r14 = r12.getOwnerType();
        if (r13 == r14) goto L20;
        if (r13 == null) goto L25;
        if (r13.equals(r14) == true) goto L20;
    L25:
        return false;
    L20:
        if (r11.getRawType().equals(r12.getRawType()) == false) goto L25;
        if (Arrays.equals(r11.getActualTypeArguments(), r12.getActualTypeArguments()) == false) goto L25;
        return true;
    L27:
        if ((r5 instanceof GenericArrayType) == false) goto L34;
        if ((r10 instanceof GenericArrayType) == true) goto L32;
        return false;
    L32:
        return d(((GenericArrayType) r5).getGenericComponentType(), ((GenericArrayType) r10).getGenericComponentType());
    L34:
        if ((r5 instanceof WildcardType) == false) goto L46;
        if ((r10 instanceof WildcardType) == true) goto L38;
        return false;
    L38:
        WildcardType r15 = (WildcardType) r5;
        WildcardType r16 = (WildcardType) r10;
        if (Arrays.equals(r15.getUpperBounds(), r16.getUpperBounds()) == false) goto L44;
        if (Arrays.equals(r15.getLowerBounds(), r16.getLowerBounds()) == false) goto L44;
        return true;
    L44:
        return false;
    L46:
        if ((r5 instanceof TypeVariable) == true) goto L48;
        return false;
    L48:
        if ((r10 instanceof TypeVariable) == true) goto L50;
        return false;
    L50:
        TypeVariable r17 = (TypeVariable) r5;
        TypeVariable r18 = (TypeVariable) r10;
        if (r17.getGenericDeclaration() != r18.getGenericDeclaration()) goto L56;
        if (r17.getName().equals(r18.getName()) == false) goto L56;
        return true;
    L56:
        return false;
    }

    public static Type e(Type r5, Class r10, Class r11) {
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
        return e(r10.getGenericInterfaces()[r14], r12[r14], r11);
    L11:
        return r10.getGenericInterfaces()[r14];
    L18:
        if (r10.isInterface() == false) goto L20;
    L30:
        return r11;
    L20:
        if (r10 == Object.class) goto L30;
        Class<?> r16 = r10.getSuperclass();
        if (r16 == r11) goto L24;
        if (r11.isAssignableFrom(r16) == true) goto L28;
        r10 = r16;
        goto L20
    L28:
        return e(r10.getGenericSuperclass(), r16, r11);
    L24:
        return r10.getGenericSuperclass();
    }

    public static Type f(int r5, ParameterizedType r10) {
        Type[] r11 = r10.getActualTypeArguments();
        if (r5 >= 0) goto L5;
    L10:
        StringBuilder r12 = j0.s(r5, "Index ", " not in range [0,");
        r12.append(r11.length);
        r12.append(") for ");
        r12.append(r10);
        throw new IllegalArgumentException(r12.toString());
    L5:
        if (r5 >= r11.length) goto L10;
        Type r13 = r11[r5];
        if ((r13 instanceof WildcardType) == true) goto L9;
        return r13;
    L9:
        return ((WildcardType) r13).getUpperBounds()[0];
    }

    public static Class g(Type r5) {
        if (r5 == null) goto L30;
        if ((r5 instanceof Class) == false) goto L8;
        return (Class) r5;
    L8:
        if ((r5 instanceof ParameterizedType) == false) goto L16;
        Type r10 = ((ParameterizedType) r5).getRawType();
        if ((r10 instanceof Class) == false) goto L14;
        return (Class) r10;
    L14:
        throw new IllegalArgumentException();
    L16:
        if ((r5 instanceof GenericArrayType) == false) goto L20;
        return Array.newInstance(g(((GenericArrayType) r5).getGenericComponentType()), 0).getClass();
    L20:
        if ((r5 instanceof TypeVariable) == false) goto L24;
        return Object.class;
    L24:
        if ((r5 instanceof WildcardType) == false) goto L28;
        return g(((WildcardType) r5).getUpperBounds()[0]);
    L28:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r5 + "> is of type " + r5.getClass().getName());
    L30:
        throw new NullPointerException("type == null");
    }

    public static Type h(Type r5, Class r10, Class r11) {
        if (r11.isAssignableFrom(r10) == false) goto L7;
        return j(r5, r10, e(r5, r10, r11));
    L7:
        throw new IllegalArgumentException();
    }

    public static boolean i(Type r5) {
        if ((r5 instanceof Class) == false) goto L6;
        return false;
    L6:
        if ((r5 instanceof ParameterizedType) == false) goto L15;
        Type[] r10 = ((ParameterizedType) r5).getActualTypeArguments();
        int r11 = r10.length;
        int r12 = 0;
    L8:
        if (r12 >= r11) goto L13;
        if (i(r10[r12]) == true) goto L11;
        r12 = r12 + 1;
        goto L8
    L11:
        return true;
    L13:
        return false;
    L15:
        if ((r5 instanceof GenericArrayType) == false) goto L19;
        return i(((GenericArrayType) r5).getGenericComponentType());
    L19:
        if ((r5 instanceof TypeVariable) == false) goto L22;
        return true;
    L22:
        if ((r5 instanceof WildcardType) == false) goto L24;
        return true;
    L24:
        if (r5 != null) goto L26;
        String r13 = "null";
    L28:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r5 + "> is of type " + r13);
    L26:
        r13 = r5.getClass().getName();
        goto L28
    }

    public static Type j(Type r10, Class r11, Type r12) {
        int r5 = 0;
        Type r13 = r12;
    L4:
        if ((r13 instanceof TypeVariable) == false) goto L26;
        TypeVariable r14 = (TypeVariable) r13;
        GenericDeclaration r15 = r14.getGenericDeclaration();
        if ((r15 instanceof Class) == false) goto L8;
        Class r16 = (Class) r15;
    L9:
        if (r16 != null) goto L11;
    L10:
        Type r17 = r14;
    L22:
        if (r17 == r14) goto L23;
        r13 = r17;
        goto L4
    L23:
        return r17;
    L11:
        Type r18 = e(r10, r11, r16);
        if ((r18 instanceof ParameterizedType) == false) goto L10;
        TypeVariable[] r19 = r16.getTypeParameters();
        int r20 = 0;
    L15:
        if (r20 >= r19.length) goto L21;
        if (r14.equals(r19[r20]) == true) goto L18;
        r20 = r20 + 1;
        goto L15
    L18:
        r17 = ((ParameterizedType) r18).getActualTypeArguments()[r20];
        goto L22
    L21:
        throw new NoSuchElementException();
    L8:
        r16 = null;
        goto L9
    L26:
        if ((r13 instanceof Class) == false) goto L35;
        Class r21 = (Class) r13;
        if (r21.isArray() == false) goto L35;
        Class<?> r110 = r21.getComponentType();
        Type r22 = j(r10, r11, r110);
        if (r110 != r22) goto L33;
        return r21;
    L33:
        return new t0(r22);
    L35:
        if ((r13 instanceof GenericArrayType) == false) goto L42;
        GenericArrayType r111 = (GenericArrayType) r13;
        Type r23 = r111.getGenericComponentType();
        Type r24 = j(r10, r11, r23);
        if (r23 != r24) goto L40;
        return r111;
    L40:
        return new t0(r24);
    L42:
        if ((r13 instanceof ParameterizedType) == false) goto L58;
        ParameterizedType r112 = (ParameterizedType) r13;
        Type r25 = r112.getOwnerType();
        Type r26 = j(r10, r11, r25);
        if (r26 == r25) goto L46;
        boolean r27 = true;
    L47:
        Type[] r28 = r112.getActualTypeArguments();
        int r29 = r28.length;
    L48:
        if (r5 >= r29) goto L55;
        Type r30 = j(r10, r11, r28[r5]);
        if (r30 == r28[r5]) goto L54;
        if (r27 == true) goto L53;
        r28 = (Type[]) r28.clone();
        r27 = true;
    L53:
        r28[r5] = r30;
    L54:
        r5 = r5 + 1;
        goto L48
    L55:
        if (r27 == true) goto L57;
        return r112;
    L57:
        return new u0(r26, r112.getRawType(), r28);
    L46:
        r27 = false;
        goto L47
    L58:
        boolean r31 = r13 instanceof WildcardType;
        Type r113 = r13;
        if (r31 == false) goto L72;
        WildcardType r114 = (WildcardType) r13;
        Type[] r32 = r114.getLowerBounds();
        Type[] r33 = r114.getUpperBounds();
        if (r32.length != 1) goto L66;
        Type r34 = j(r10, r11, r32[0]);
        r113 = r114;
        if (r34 == r32[0]) goto L72;
        return new v0(new Type[]{Object.class}, new Type[]{r34});
    L66:
        r113 = r114;
        if (r33.length != 1) goto L72;
        Type r35 = j(r10, r11, r33[0]);
        r113 = r114;
        if (r35 == r33[0]) goto L72;
        return new v0(new Type[]{r35}, f305a);
    L72:
        return r113;
    }

    public static String k(Type r5) {
        if ((r5 instanceof Class) == false) goto L6;
        return ((Class) r5).getName();
    L6:
        return r5.toString();
    }

    public abstract void a(e0 r5, Object r10);
}
