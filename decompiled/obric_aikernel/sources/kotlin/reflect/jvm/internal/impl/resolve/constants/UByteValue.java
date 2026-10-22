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
public final class UByteValue extends UnsignedValueConstant<Byte> {
    public UByteValue(byte r10) {
        super(Byte.valueOf(r10));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public KotlinType getType(ModuleDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "module");
        ClassDescriptor r11 = FindClassInModuleKt.findClassAcrossModuleDependencies(r10, StandardNames.FqNames.uByte);
        if (r11 == null) goto L5;
        SimpleType r12 = r11.getDefaultType();
    L6:
        if (r12 == null) goto L8;
        return r12;
    L8:
        return ErrorUtils.createErrorType(ErrorTypeKind.NOT_FOUND_UNSIGNED_TYPE, new String[]{"UByte"});
    L5:
        r12 = null;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public String toString() {
        return getValue().intValue() + ".toUByte()";
    }
}
