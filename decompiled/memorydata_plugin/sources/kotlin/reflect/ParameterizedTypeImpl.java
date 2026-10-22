package kotlin.reflect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\u0010\tJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0016¢\u0006\u0002\u0010\u0011J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0019"}, d2 = {"Lkotlin/reflect/ParameterizedTypeImpl;", "Ljava/lang/reflect/ParameterizedType;", "Lkotlin/reflect/TypeImpl;", "rawType", "Ljava/lang/Class;", "ownerType", "Ljava/lang/reflect/Type;", "typeArguments", "", "(Ljava/lang/Class;Ljava/lang/reflect/Type;Ljava/util/List;)V", "", "[Ljava/lang/reflect/Type;", "equals", "", "other", "", "getActualTypeArguments", "()[Ljava/lang/reflect/Type;", "getOwnerType", "getRawType", "getTypeName", "", "hashCode", "", "toString", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class ParameterizedTypeImpl implements ParameterizedType, TypeImpl {
    private final Type ownerType;
    private final Class<?> rawType;
    private final Type[] typeArguments;

    public ParameterizedTypeImpl(Class<?> r3, Type r4, List<? extends Type> r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "rawType");
        Intrinsics.checkNotNullParameter(r7, "typeArguments");
        this.rawType = r3;
        this.ownerType = r6;
        this.typeArguments = (Type[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).toArray(new Type[0]), Type[].class, "com.obric.memorydata.plugin");
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, ParameterizedType.class) == true) goto L5;
    L11:
        return false;
    L5:
        if (Intrinsics.areEqual(this.rawType, ((ParameterizedType) ZeusTransformUtils.preCheckCast(r4, ParameterizedType.class, "com.obric.memorydata.plugin")).getRawType()) == false) goto L11;
        if (Intrinsics.areEqual(this.ownerType, ((ParameterizedType) ZeusTransformUtils.preCheckCast(r4, ParameterizedType.class, "com.obric.memorydata.plugin")).getOwnerType()) == false) goto L11;
        if (Arrays.equals(getActualTypeArguments(), ((ParameterizedType) ZeusTransformUtils.preCheckCast(r4, ParameterizedType.class, "com.obric.memorydata.plugin")).getActualTypeArguments()) == false) goto L11;
        return true;
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
        return (Type) ZeusTransformUtils.preCheckCast(this.rawType, Type.class, "com.obric.memorydata.plugin");
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.TypeImpl
    public String getTypeName() {
        StringBuilder r0 = new StringBuilder();
        Type r1 = this.ownerType;
        if (r1 == null) goto L5;
        r0.append(TypesJVMKt.access$typeToString(r1));
        r0.append("$");
        String r2 = this.rawType.getSimpleName();
    L6:
        r0.append(r2);
        Type[] r3 = this.typeArguments;
        if (r3.length != 0) goto L9;
        boolean r13 = true;
    L11:
        if ((!r13) == false) goto L13;
        ArraysKt.joinTo$default(r3, (Appendable) ZeusTransformUtils.preCheckCast(r0, Appendable.class, "com.obric.memorydata.plugin"), null, (CharSequence) ZeusTransformUtils.preCheckCast("<", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(">", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, (Function1) ZeusTransformUtils.preCheckCast(ParameterizedTypeImpl$getTypeName$1$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), 50, null);
    L13:
        String r14 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r14, "toString(...)");
        return r14;
    L9:
        r13 = false;
        goto L11
    L5:
        r2 = TypesJVMKt.access$typeToString((Type) ZeusTransformUtils.preCheckCast(this.rawType, Type.class, "com.obric.memorydata.plugin"));
        goto L6
    }

    public int hashCode() {
        int r0 = this.rawType.hashCode();
        Type r1 = this.ownerType;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L6:
        int r3 = Arrays.hashCode(getActualTypeArguments());
        return r3 ^ (r0 ^ r2);
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return getTypeName();
    }
}
