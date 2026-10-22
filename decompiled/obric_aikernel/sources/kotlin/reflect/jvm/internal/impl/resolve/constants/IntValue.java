package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: loaded from: classes3.dex */
public final class IntValue extends IntegerValueConstant<Integer> {
    public IntValue(int r10) {
        super(Integer.valueOf(r10));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public /* bridge */ /* synthetic */ KotlinType getType(ModuleDescriptor r10) {
        return getType(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public SimpleType getType(ModuleDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "module");
        SimpleType r11 = r10.getBuiltIns().getIntType();
        Intrinsics.checkNotNullExpressionValue(r11, "module.builtIns.intType");
        return r11;
    }
}
