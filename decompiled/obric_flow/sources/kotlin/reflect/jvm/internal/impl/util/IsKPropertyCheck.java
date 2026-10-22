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
    public boolean check(FunctionDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "functionDescriptor");
        ValueParameterDescriptor r10 = r5.getValueParameters().get(1);
        KotlinType r11 = ReflectionTypes.Companion.createKPropertyStarType(DescriptorUtilsKt.getModule(r10));
        if (r11 != null) goto L7;
        return false;
    L7:
        return TypeUtilsKt.isSubtypeOf(r11, TypeUtilsKt.makeNotNullable(r10.getType()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String getDescription() {
        return description;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String invoke(FunctionDescriptor r5) {
        return Check.DefaultImpls.invoke(this, r5);
    }
}
