package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import com.bytedance.common.wschannel.WsConstants;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ReflectJavaType implements JavaType {
    public static final Factory Factory = null;

    public static final class Factory {
        private Factory() {
        }

        public /* synthetic */ Factory(DefaultConstructorMarker r10) {
            this();
        }

        public final ReflectJavaType create(Type r10) {
            Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
            boolean r11 = r10 instanceof Class;
            if (r11 == false) goto L8;
            Class r12 = (Class) r10;
            if (r12.isPrimitive() == false) goto L8;
            return new ReflectJavaPrimitiveType(r12);
        L8:
            if ((r10 instanceof GenericArrayType) == true) goto L18;
            if (r11 == false) goto L14;
            if (((Class) r10).isArray() == true) goto L18;
        L14:
            if ((r10 instanceof WildcardType) == false) goto L21;
            return new ReflectJavaWildcardType((WildcardType) r10);
        L21:
            return new ReflectJavaClassifierType(r10);
        L18:
            return new ReflectJavaArrayType(r10);
        }
    }

    static {
        Factory = new Factory(null);
    }

    public ReflectJavaType() {
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof ReflectJavaType) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(getReflectType(), ((ReflectJavaType) r10).getReflectType()) == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public JavaAnnotation findAnnotation(FqName r10) {
        return JavaType.DefaultImpls.findAnnotation(this, r10);
    }

    protected abstract Type getReflectType();

    public int hashCode() {
        return getReflectType().hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + getReflectType();
    }
}
