package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
final class IsKPropertyCheck implements Check {
    public static final IsKPropertyCheck INSTANCE = null;
    private static final String description = null;

    static {
        INSTANCE = new IsKPropertyCheck();
        description = "second parameter must be of type KProperty<*> or its supertype";
    }

    private IsKPropertyCheck() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public boolean check(FunctionDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "functionDescriptor");
        ValueParameterDescriptor r11 = r10.getValueParameters().get(1);
        ReflectionTypes.Companion r12 = ReflectionTypes.Companion;
        Intrinsics.checkNotNullExpressionValue(r11, "secondParameter");
        KotlinType r13 = r12.createKPropertyStarType(DescriptorUtilsKt.getModule(r11));
        if (r13 == null) goto L5;
        KotlinType r14 = r11.getType();
        Intrinsics.checkNotNullExpressionValue(r14, "secondParameter.type");
        return TypeUtilsKt.isSubtypeOf(r13, TypeUtilsKt.makeNotNullable(r14));
    L5:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String getDescription() {
        return description;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String invoke(FunctionDescriptor r10) {
        return Check.DefaultImpls.invoke(this, r10);
    }
}
