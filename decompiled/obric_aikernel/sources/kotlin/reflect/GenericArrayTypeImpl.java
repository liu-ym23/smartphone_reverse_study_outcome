package kotlin.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.ExperimentalStdlibApi;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@ExperimentalStdlibApi
final class GenericArrayTypeImpl implements GenericArrayType, TypeImpl {
    private final Type elementType;

    public GenericArrayTypeImpl(Type r10) {
        Intrinsics.checkNotNullParameter(r10, "elementType");
        this.elementType = r10;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof GenericArrayType) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(getGenericComponentType(), ((GenericArrayType) r10).getGenericComponentType()) == false) goto L7;
        return true;
    }

    @Override // java.lang.reflect.GenericArrayType
    public Type getGenericComponentType() {
        return this.elementType;
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.TypeImpl
    public String getTypeName() {
        return TypesJVMKt.access$typeToString(this.elementType) + "[]";
    }

    public int hashCode() {
        return getGenericComponentType().hashCode();
    }

    public String toString() {
        return getTypeName();
    }
}
