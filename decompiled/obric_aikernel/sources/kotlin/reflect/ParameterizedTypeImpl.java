package kotlin.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@ExperimentalStdlibApi
@SourceDebugExtension({"SMAP\nTypesJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/ParameterizedTypeImpl\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,230:1\n37#2,2:231\n*S KotlinDebug\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/ParameterizedTypeImpl\n*L\n190#1:231,2\n*E\n"})
final class ParameterizedTypeImpl implements ParameterizedType, TypeImpl {
    private final Type ownerType;
    private final Class<?> rawType;
    private final Type[] typeArguments;

    public ParameterizedTypeImpl(Class<?> r10, Type r11, List<? extends Type> r12) {
        Intrinsics.checkNotNullParameter(r10, "rawType");
        Intrinsics.checkNotNullParameter(r12, "typeArguments");
        this.rawType = r10;
        this.ownerType = r11;
        this.typeArguments = (Type[]) r12.toArray(new Type[0]);
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof ParameterizedType) == false) goto L11;
        ParameterizedType r11 = (ParameterizedType) r10;
        if (Intrinsics.areEqual(this.rawType, r11.getRawType()) == false) goto L11;
        if (Intrinsics.areEqual(this.ownerType, r11.getOwnerType()) == false) goto L11;
        if (Arrays.equals(getActualTypeArguments(), r11.getActualTypeArguments()) == false) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.typeArguments;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.ownerType;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.rawType;
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.TypeImpl
    public String getTypeName() {
        StringBuilder r10 = new StringBuilder();
        Type r11 = this.ownerType;
        if (r11 == null) goto L5;
        r10.append(TypesJVMKt.access$typeToString(r11));
        r10.append("$");
        String r12 = this.rawType.getSimpleName();
    L6:
        r10.append(r12);
        Type[] r13 = this.typeArguments;
        if (r13.length != 0) goto L9;
        boolean r14 = true;
    L11:
        if ((!r14) == false) goto L13;
        ArraysKt.joinTo$default(r13, r10, null, "<", ">", 0, null, ParameterizedTypeImpl$getTypeName$1$1.INSTANCE, 50, null);
    L13:
        String r15 = r10.toString();
        Intrinsics.checkNotNullExpressionValue(r15, "StringBuilder().apply(builderAction).toString()");
        return r15;
    L9:
        r14 = false;
        goto L11
    L5:
        r12 = TypesJVMKt.access$typeToString(this.rawType);
        goto L6
    }

    public int hashCode() {
        int r10 = this.rawType.hashCode();
        Type r11 = this.ownerType;
        if (r11 == null) goto L5;
        int r12 = r11.hashCode();
    L6:
        int r13 = Arrays.hashCode(getActualTypeArguments());
        return r13 ^ (r10 ^ r12);
    L5:
        r12 = 0;
        goto L6
    }

    public String toString() {
        return getTypeName();
    }
}
