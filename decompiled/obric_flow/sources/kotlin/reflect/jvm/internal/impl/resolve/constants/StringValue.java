package kotlin.reflect.jvm.internal.impl.resolve.constants;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class StringValue extends ConstantValue<String> {
    public StringValue(String r5) {
        Intrinsics.checkNotNullParameter(r5, "value");
        super(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public /* bridge */ /* synthetic */ KotlinType getType(ModuleDescriptor r5) {
        return getType(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public String toString() {
        return j0.p(new StringBuilder("\""), getValue(), Typography.quote);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public SimpleType getType(ModuleDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "module");
        return r5.getBuiltIns().getStringType();
    }
}
