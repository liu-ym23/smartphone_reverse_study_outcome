package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ReflectJavaType implements JavaType {
    public static final Factory Factory = null;

    public static final class Factory {
        public /* synthetic */ Factory(DefaultConstructorMarker r5) {
            this();
        }

        public final ReflectJavaType create(Type r5) {
            Intrinsics.checkNotNullParameter(r5, "type");
            boolean r10 = r5 instanceof Class;
            if (r10 == false) goto L8;
            Class r11 = (Class) r5;
            if (r11.isPrimitive() == false) goto L8;
            return new ReflectJavaPrimitiveType(r11);
        L8:
            if ((r5 instanceof GenericArrayType) == true) goto L18;
            if (r10 == false) goto L14;
            if (((Class) r5).isArray() == true) goto L18;
        L14:
            if ((r5 instanceof WildcardType) == false) goto L21;
            return new ReflectJavaWildcardType((WildcardType) r5);
        L21:
            return new ReflectJavaClassifierType(r5);
        L18:
            return new ReflectJavaArrayType(r5);
        }

        private Factory() {
        }
    }

    static {
        Factory = new Factory(null);
    }

    public ReflectJavaType() {
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof ReflectJavaType) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(getReflectType(), ((ReflectJavaType) r5).getReflectType()) == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public JavaAnnotation findAnnotation(FqName r5) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        Iterator<T> r10 = getAnnotations().iterator();
    L3:
        Object r11 = null;
        if (r10.hasNext() == false) goto L12;
        Object r12 = r10.next();
        ClassId r13 = ((JavaAnnotation) r12).getClassId();
        if (r13 == null) goto L9;
        r11 = r13.asSingleFqName();
    L9:
        if (Intrinsics.areEqual(r11, r5) == false) goto L3;
        r11 = r12;
    L12:
        return (JavaAnnotation) r11;
    }

    public abstract Type getReflectType();

    public int hashCode() {
        return getReflectType().hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + getReflectType();
    }
}
