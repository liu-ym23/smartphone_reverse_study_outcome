package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public final class UtilsKt {
    public static final boolean hasErasedValueParameters(CallableMemberDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "memberDescriptor");
        if ((r10 instanceof FunctionDescriptor) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r10.getUserData(JavaMethodDescriptor.HAS_ERASED_VALUE_PARAMETERS), Boolean.TRUE) == false) goto L7;
        return true;
    }

    public static final boolean isJspecifyEnabledInStrictMode(JavaTypeEnhancementState r10) {
        Intrinsics.checkNotNullParameter(r10, "javaTypeEnhancementState");
        if (r10.getGetReportLevelForAnnotation().invoke(JavaNullabilityAnnotationSettingsKt.getJSPECIFY_ANNOTATIONS_PACKAGE()) != ReportLevel.STRICT) goto L5;
        return true;
    L5:
        return false;
    }

    public static final DescriptorVisibility toDescriptorVisibility(Visibility r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        DescriptorVisibility r11 = JavaDescriptorVisibilities.toDescriptorVisibility(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "toDescriptorVisibility(this)");
        return r11;
    }
}
