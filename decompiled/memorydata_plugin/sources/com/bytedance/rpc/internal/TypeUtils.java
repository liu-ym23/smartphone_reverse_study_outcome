package com.bytedance.rpc.internal;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class TypeUtils {
    private static Map<String, Class<?>> sDetectMap;

    private static final class ParameterizedTypeImpl implements Serializable, ParameterizedType {
        private static final long serialVersionUID = 0;
        private final Type mOwnerType;
        private final Type mRawType;
        private final Type[] mTypeArguments;

        public ParameterizedTypeImpl(Type r3, Type r4, Type... r5) {
            Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin");
            Type r7 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin");
            if (r6 != null) goto L5;
            Type r8 = null;
        L6:
            this.mOwnerType = r8;
            this.mRawType = TypeUtils.normalizeType(r7);
            this.mTypeArguments = (Type[]) ZeusTransformUtils.preCheckCast(r5.clone(), Type[].class, "com.obric.memorydata.plugin");
            int r9 = 0;
        L7:
            Type[] r10 = this.mTypeArguments;
            if (r9 >= r10.length) goto L10;
            r10[r9] = TypeUtils.normalizeType(r10[r9]);
            r9 = r9 + 1;
            goto L7
        L10:
            return;
        L5:
            r8 = TypeUtils.normalizeType(r6);
            goto L6
        }

        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, ParameterizedType.class) == true) goto L5;
        L7:
            return false;
        L5:
            if (TypeUtils.equalType(this, (ParameterizedType) ZeusTransformUtils.preCheckCast(r3, ParameterizedType.class, "com.obric.memorydata.plugin")) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) ZeusTransformUtils.preCheckCast(this.mTypeArguments.clone(), Type[].class, "com.obric.memorydata.plugin");
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.mOwnerType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.mRawType;
        }

        public int hashCode() {
            int r0 = Arrays.hashCode(this.mTypeArguments) ^ this.mRawType.hashCode();
            return Objects.hashCode(this.mOwnerType) ^ r0;
        }

        public String toString() {
            int r2 = 1;
            StringBuilder r0 = new StringBuilder((this.mTypeArguments.length + 1) * 30);
            r0.append(TypeUtils.typeToString(this.mRawType));
            if (this.mTypeArguments.length == 0) goto L5;
            r0.append("<").append(TypeUtils.typeToString(this.mTypeArguments[0]));
        L8:
            if (r2 >= this.mTypeArguments.length) goto L11;
            r0.append(", ").append(TypeUtils.typeToString(this.mTypeArguments[r2]));
            r2 = r2 + 1;
            goto L8
        L11:
            return r0.append(">").toString();
        L5:
            return r0.toString();
        }
    }

    static {
        sDetectMap = new LruMap(8, 16);
    }

    public TypeUtils() {
    }

    public static Class<?> detect(String r4) {
        if (RpcUtils.isVisibleUnNull(r4) == true) goto L5;
        return null;
    L5:
        if (sDetectMap.containsKey(r4) == false) goto L9;
        Class<?> r0 = (Class) ZeusTransformUtils.preCheckCast(sDetectMap.get(r4), Class.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L9;
        return r0;
    L9:
        Map<String, Class<?>> r1 = sDetectMap;
        monitor-enter(r1);
        Class<?> r2 = (Class) ZeusTransformUtils.preCheckCast(sDetectMap.get(r4), Class.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        if (r2 != null) goto L14;
        String r3 = "null";
    L15:
        Log.i("TypeUtils", r3);     // Catch: Throwable -> L26
        if (r2 == null) goto L18;
    L24:
        monitor-exit(r1);     // Catch: Throwable -> L26
        return r2;
    L18:
        if (sDetectMap.containsKey(r4) == true) goto L24;
        r2 = ZeusTransformUtils.forName(r4, "com.obric.memorydata.plugin");     // Catch: ClassNotFoundException -> L21 Throwable -> L26
    L23:
        sDetectMap.put(r4, r2);     // Catch: Throwable -> L26
        goto L24
    L21:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L26
        goto L23
    L14:
        r3 = r2.toString();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    public static Class<?> detect(String r4, boolean r5) {
        if (r5 == false) goto L17;
        Map<String, Class<?>> r6 = sDetectMap;
        monitor-enter(r6);
        Iterator<Map.Entry<String, Class<?>>> r0 = sDetectMap.entrySet().iterator();     // Catch: Throwable -> L13
    L7:
        if (r0.hasNext() == false) goto L11;
        if (((Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue() != null) goto L7;
        r0.remove();     // Catch: Throwable -> L13
        goto L7
    L11:
        monitor-exit(r6);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L17:
        return detect(r4);
    }

    public static boolean detectType(String r2, Class<?> r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        Class<?> r1 = detect(r2);
        if (r1 != null) goto L16;
        if (RpcUtils.isInvisibleOrNull(r2) == false) goto L11;
        return false;
    L11:
        if (r2.equals(r3.toString()) == false) goto L14;
        return true;
    L14:
        return false;
    L16:
        return r1.isAssignableFrom(r3);
    }

    public static boolean equalType(Type r4, Type r5) {
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
        if (Objects.equals(r8.getOwnerType(), r9.getOwnerType()) == false) goto L22;
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
        return equalType(r10.getGenericComponentType(), r11.getGenericComponentType());
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

    public static Class<?> getRawType(Type r4) {
        Type r5 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Class.class) == false) goto L7;
        return (Class) ZeusTransformUtils.preCheckCast(r5, Class.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r5, ParameterizedType.class) == false) goto L13;
        Type r0 = ((ParameterizedType) ZeusTransformUtils.preCheckCast(r5, ParameterizedType.class, "com.obric.memorydata.plugin")).getRawType();
        if (ZeusTransformUtils.instanceOf(r0, Class.class) == true) goto L11;
    L24:
        if (r5 != null) goto L26;
        String r1 = "null";
    L28:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r5 + "> is of type " + r1);
    L26:
        r1 = r5.getClass().getName();
        goto L28
    L11:
        return (Class) ZeusTransformUtils.preCheckCast(r0, Class.class, "com.obric.memorydata.plugin");
    L13:
        if (ZeusTransformUtils.instanceOf(r5, GenericArrayType.class) == false) goto L17;
        return Array.newInstance(getRawType(((GenericArrayType) ZeusTransformUtils.preCheckCast(r5, GenericArrayType.class, "com.obric.memorydata.plugin")).getGenericComponentType()), 0).getClass();
    L17:
        if (ZeusTransformUtils.instanceOf(r5, TypeVariable.class) == false) goto L21;
        return Object.class;
    L21:
        if (ZeusTransformUtils.instanceOf(r5, WildcardType.class) == false) goto L24;
        return getRawType(((WildcardType) ZeusTransformUtils.preCheckCast(r5, WildcardType.class, "com.obric.memorydata.plugin")).getUpperBounds()[0]);
    }

    public static Object instance(Class<?> r1) {
        if (r1 != null) goto L12;
        return null;
    L12:
    L15:
        return r1.newInstance();
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static Object instance(String r0) {
        return instance(detect(r0));
    }

    public static boolean isByteArrayType(Type r3) {
        Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin");
        if (r4 != byte[].class) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, GenericArrayType.class) == true) goto L8;
    L10:
        return false;
    L8:
        if (((GenericArrayType) ZeusTransformUtils.preCheckCast(r4, GenericArrayType.class, "com.obric.memorydata.plugin")).getGenericComponentType() != Byte.TYPE) goto L10;
        return true;
    }

    public static boolean isCollectType(Type r3) {
        Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        Class<?> r5 = null;
    L7:
        if (r5 != null) goto L10;
        return false;
    L10:
        if (Collection.class.isAssignableFrom(r5) == false) goto L13;
        return true;
    L13:
        if (Map.class.isAssignableFrom(r5) == false) goto L15;
        return true;
    L15:
        return false;
    L5:
        r5 = getRawType(r4);
        goto L7
    }

    public static Type normalizeType(Type r3) {
        Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ParameterizedType.class) == true) goto L5;
    L8:
        return r4;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, ParameterizedTypeImpl.class) == true) goto L8;
        ParameterizedType r5 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r4, ParameterizedType.class, "com.obric.memorydata.plugin");
        return new ParameterizedTypeImpl(r5.getOwnerType(), r5.getRawType(), r5.getActualTypeArguments());
    }

    public static String typeToString(Type r2) {
        Type r3 = (Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Class.class) == false) goto L6;
        return ((Class) ZeusTransformUtils.preCheckCast(r3, Class.class, "com.obric.memorydata.plugin")).getName();
    L6:
        return r3.toString();
    }
}
