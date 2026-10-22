package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public class ArrayValue extends ConstantValue<List<? extends ConstantValue<?>>> {
    private final Function1<ModuleDescriptor, KotlinType> computeType;

    /* JADX WARN: Multi-variable type inference failed */
    public ArrayValue(List<? extends ConstantValue<?>> r5, Function1<? super ModuleDescriptor, ? extends KotlinType> r10) {
        Intrinsics.checkNotNullParameter(r5, "value");
        Intrinsics.checkNotNullParameter(r10, "computeType");
        super(r5);
        this.computeType = r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public KotlinType getType(ModuleDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "module");
        KotlinType r10 = this.computeType.invoke(r5);
        if (KotlinBuiltIns.isArray(r10) == false) goto L5;
    L7:
        return r10;
    L5:
        if (KotlinBuiltIns.isPrimitiveArray(r10) == true) goto L7;
        KotlinBuiltIns.isUnsignedArrayType(r10);
        goto L7
    }
}
