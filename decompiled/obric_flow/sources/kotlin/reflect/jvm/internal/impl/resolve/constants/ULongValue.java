package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ULongValue extends UnsignedValueConstant<Long> {
    public ULongValue(long r5) {
        super(Long.valueOf(r5));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public KotlinType getType(ModuleDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "module");
        ClassDescriptor r10 = FindClassInModuleKt.findClassAcrossModuleDependencies(r5, StandardNames.FqNames.uLong);
        if (r10 == null) goto L5;
        SimpleType r11 = r10.getDefaultType();
    L6:
        if (r11 == null) goto L8;
        return r11;
    L8:
        return ErrorUtils.createErrorType(ErrorTypeKind.NOT_FOUND_UNSIGNED_TYPE, new String[]{"ULong"});
    L5:
        r11 = null;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public String toString() {
        return getValue().longValue() + ".toULong()";
    }
}
