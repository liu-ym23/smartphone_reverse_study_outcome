package kotlin.reflect.jvm.internal.impl.resolve.constants;

import com.bytedance.crash.entity.EventBody;
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
    public ArrayValue(List<? extends ConstantValue<?>> r10, Function1<? super ModuleDescriptor, ? extends KotlinType> r11) {
        Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
        Intrinsics.checkNotNullParameter(r11, "computeType");
        super(r10);
        this.computeType = r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public KotlinType getType(ModuleDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "module");
        KotlinType r11 = this.computeType.invoke(r10);
        if (KotlinBuiltIns.isArray(r11) == false) goto L5;
    L7:
        return r11;
    L5:
        if (KotlinBuiltIns.isPrimitiveArray(r11) == true) goto L7;
        KotlinBuiltIns.isUnsignedArrayType(r11);
        goto L7
    }
}
