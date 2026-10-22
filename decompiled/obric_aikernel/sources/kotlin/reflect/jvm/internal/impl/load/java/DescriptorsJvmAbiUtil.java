package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMappingUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class DescriptorsJvmAbiUtil {
    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        Object[] r11 = new Object[3];
        if (r10 == 1) goto L8;
        if (r10 == 2) goto L8;
        if (r10 == 3) goto L7;
        r11[0] = "propertyDescriptor";
    L9:
        r11[1] = "kotlin/reflect/jvm/internal/impl/load/java/DescriptorsJvmAbiUtil";
        if (r10 == 1) goto L16;
        if (r10 == 2) goto L15;
        if (r10 == 3) goto L14;
        r11[2] = "isPropertyWithBackingFieldInOuterClass";
    L18:
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r11));
    L14:
        r11[2] = "hasJvmFieldAnnotation";
        goto L18
    L15:
        r11[2] = "isMappedIntrinsicCompanionObject";
        goto L18
    L16:
        r11[2] = "isClassCompanionObjectWithBackingFieldsInOuter";
        goto L18
    L7:
        r11[0] = "memberDescriptor";
    L8:
        r11[0] = "companionObject";
        goto L9
    }

    public static boolean hasJvmFieldAnnotation(CallableMemberDescriptor r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(3);
    L5:
        if ((r10 instanceof PropertyDescriptor) == false) goto L13;
        FieldDescriptor r11 = ((PropertyDescriptor) r10).getBackingField();
        if (r11 == null) goto L13;
        if (r11.getAnnotations().hasAnnotation(JvmAbi.JVM_FIELD_ANNOTATION_FQ_NAME) == false) goto L13;
        return true;
    L13:
        return r10.getAnnotations().hasAnnotation(JvmAbi.JVM_FIELD_ANNOTATION_FQ_NAME);
    }

    public static boolean isClassCompanionObjectWithBackingFieldsInOuter(DeclarationDescriptor r10) {
        if (r10 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (DescriptorUtils.isCompanionObject(r10) == true) goto L8;
    L12:
        return false;
    L8:
        if (DescriptorUtils.isClassOrEnumClass(r10.getContainingDeclaration()) == false) goto L12;
        if (isMappedIntrinsicCompanionObject((ClassDescriptor) r10) == true) goto L12;
        return true;
    }

    public static boolean isMappedIntrinsicCompanionObject(ClassDescriptor r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(2);
    L5:
        return CompanionObjectMappingUtilsKt.isMappedIntrinsicCompanionObject(CompanionObjectMapping.INSTANCE, r10);
    }

    public static boolean isPropertyWithBackingFieldInOuterClass(PropertyDescriptor r10) {
        if (r10 != null) goto L6;
        $$$reportNull$$$0(0);
    L6:
        if (r10.getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) goto L9;
        return false;
    L9:
        if (isClassCompanionObjectWithBackingFieldsInOuter(r10.getContainingDeclaration()) == false) goto L12;
        return true;
    L12:
        if (DescriptorUtils.isCompanionObject(r10.getContainingDeclaration()) == true) goto L14;
        return false;
    L14:
        if (hasJvmFieldAnnotation(r10) == true) goto L16;
        return false;
    L16:
        return true;
    }
}
