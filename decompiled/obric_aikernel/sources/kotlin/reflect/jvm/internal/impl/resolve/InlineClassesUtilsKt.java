package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: loaded from: classes3.dex */
public final class InlineClassesUtilsKt {
    private static final ClassId JVM_INLINE_ANNOTATION_CLASS_ID = null;
    private static final FqName JVM_INLINE_ANNOTATION_FQ_NAME = null;

    static {
        FqName r10 = new FqName("kotlin.jvm.JvmInline");
        JVM_INLINE_ANNOTATION_FQ_NAME = r10;
        ClassId r11 = ClassId.topLevel(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "topLevel(JVM_INLINE_ANNOTATION_FQ_NAME)");
        JVM_INLINE_ANNOTATION_CLASS_ID = r11;
    }

    public static final boolean isGetterOfUnderlyingPropertyOfInlineClass(CallableDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof PropertyGetterDescriptor) == false) goto L7;
        PropertyDescriptor r11 = ((PropertyGetterDescriptor) r10).getCorrespondingProperty();
        Intrinsics.checkNotNullExpressionValue(r11, "correspondingProperty");
        if (isUnderlyingPropertyOfInlineClass(r11) == false) goto L7;
        return true;
    L7:
        return false;
    }

    public static final boolean isInlineClass(DeclarationDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof ClassDescriptor) == true) goto L5;
    L7:
        return false;
    L5:
        if ((((ClassDescriptor) r10).getValueClassRepresentation() instanceof InlineClassRepresentation) == false) goto L7;
        return true;
    }

    public static final boolean isInlineClassType(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ClassifierDescriptor r11 = r10.getConstructor().mo1323getDeclarationDescriptor();
        if (r11 != null) goto L7;
        return false;
    L7:
        return isInlineClass(r11);
    }

    public static final boolean isUnderlyingPropertyOfInlineClass(VariableDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.getExtensionReceiverParameter() != null) goto L15;
        DeclarationDescriptor r11 = r10.getContainingDeclaration();
        Name r12 = null;
        if ((r11 instanceof ClassDescriptor) == false) goto L7;
        ClassDescriptor r13 = (ClassDescriptor) r11;
    L8:
        if (r13 == null) goto L13;
        InlineClassRepresentation<SimpleType> r14 = DescriptorUtilsKt.getInlineClassRepresentation(r13);
        if (r14 == null) goto L13;
        r12 = r14.getUnderlyingPropertyName();
    L13:
        if (Intrinsics.areEqual(r12, r10.getName()) == false) goto L15;
        return true;
    L7:
        r13 = null;
    L15:
        return false;
    }

    public static final KotlinType unsubstitutedUnderlyingType(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ClassifierDescriptor r11 = r10.getConstructor().mo1323getDeclarationDescriptor();
        if ((r11 instanceof ClassDescriptor) == true) goto L5;
        r11 = null;
    L5:
        ClassDescriptor r12 = (ClassDescriptor) r11;
        if (r12 == null) goto L11;
        InlineClassRepresentation<SimpleType> r13 = DescriptorUtilsKt.getInlineClassRepresentation(r12);
        if (r13 != null) goto L10;
        return null;
    L10:
        return (SimpleType) r13.getUnderlyingType();
    L11:
        return null;
    }
}
