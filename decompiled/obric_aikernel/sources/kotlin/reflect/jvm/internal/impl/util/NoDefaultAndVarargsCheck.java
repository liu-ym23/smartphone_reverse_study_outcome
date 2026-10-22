package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
final class NoDefaultAndVarargsCheck implements Check {
    public static final NoDefaultAndVarargsCheck INSTANCE = null;
    private static final String description = null;

    static {
        INSTANCE = new NoDefaultAndVarargsCheck();
        description = "should not have varargs or parameters with default values";
    }

    private NoDefaultAndVarargsCheck() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public boolean check(FunctionDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "functionDescriptor");
        List<ValueParameterDescriptor> r11 = r10.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r11, "functionDescriptor.valueParameters");
        if ((r11 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L17;
        ValueParameterDescriptor r13 = (ValueParameterDescriptor) r12.next();
        Intrinsics.checkNotNullExpressionValue(r13, "it");
        if (DescriptorUtilsKt.declaresOrInheritsDefaultValue(r13) == false) goto L13;
    L15:
        boolean r14 = false;
    L16:
        if (r14 == true) goto L9;
        return false;
    L13:
        if (r13.getVarargElementType() != null) goto L15;
        r14 = true;
    L17:
        return true;
    L5:
        if (r11.isEmpty() == false) goto L7;
        goto L7
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
