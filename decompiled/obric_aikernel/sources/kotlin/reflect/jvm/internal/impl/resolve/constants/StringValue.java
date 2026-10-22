package kotlin.reflect.jvm.internal.impl.resolve.constants;

import com.bytedance.crash.entity.EventBody;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class StringValue extends ConstantValue<String> {
    public StringValue(String r10) {
        Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
        super(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public /* bridge */ /* synthetic */ KotlinType getType(ModuleDescriptor r10) {
        return getType(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public SimpleType getType(ModuleDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "module");
        SimpleType r11 = r10.getBuiltIns().getStringType();
        Intrinsics.checkNotNullExpressionValue(r11, "module.builtIns.stringType");
        return r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public String toString() {
        return Typography.quote + getValue() + Typography.quote;
    }
}
