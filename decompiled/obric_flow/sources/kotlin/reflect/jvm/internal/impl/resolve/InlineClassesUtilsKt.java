package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\ninlineClassesUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 inlineClassesUtils.kt\norg/jetbrains/kotlin/resolve/InlineClassesUtilsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,83:1\n1549#2:84\n1620#2,3:85\n1549#2:89\n1620#2,3:90\n1747#2,3:93\n1#3:88\n*S KotlinDebug\n*F\n+ 1 inlineClassesUtils.kt\norg/jetbrains/kotlin/resolve/InlineClassesUtilsKt\n*L\n38#1:84\n38#1:85,3\n53#1:89\n53#1:90,3\n64#1:93,3\n*E\n"})
public final class InlineClassesUtilsKt {
    private static final ClassId JVM_INLINE_ANNOTATION_CLASS_ID = null;
    private static final FqName JVM_INLINE_ANNOTATION_FQ_NAME = null;

    static {
        FqName r5 = new FqName("kotlin.jvm.JvmInline");
        JVM_INLINE_ANNOTATION_FQ_NAME = r5;
        JVM_INLINE_ANNOTATION_CLASS_ID = ClassId.topLevel(r5);
    }

    public static final boolean isGetterOfUnderlyingPropertyOfInlineClass(CallableDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof PropertyGetterDescriptor) == true) goto L5;
    L7:
        return false;
    L5:
        if (isUnderlyingPropertyOfInlineClass(((PropertyGetterDescriptor) r5).getCorrespondingProperty()) == false) goto L7;
        return true;
    }

    public static final boolean isInlineClass(DeclarationDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof ClassDescriptor) == true) goto L5;
    L7:
        return false;
    L5:
        if ((((ClassDescriptor) r5).getValueClassRepresentation() instanceof InlineClassRepresentation) == false) goto L7;
        return true;
    }

    public static final boolean isInlineClassType(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ClassifierDescriptor r10 = r5.getConstructor().mo1402getDeclarationDescriptor();
        if (r10 != null) goto L7;
        return false;
    L7:
        return isInlineClass(r10);
    }

    public static final boolean isMultiFieldValueClass(DeclarationDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof ClassDescriptor) == true) goto L5;
    L7:
        return false;
    L5:
        if ((((ClassDescriptor) r5).getValueClassRepresentation() instanceof MultiFieldValueClassRepresentation) == false) goto L7;
        return true;
    }

    public static final boolean isUnderlyingPropertyOfInlineClass(VariableDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.getExtensionReceiverParameter() != null) goto L15;
        DeclarationDescriptor r10 = r5.getContainingDeclaration();
        Name r11 = null;
        if ((r10 instanceof ClassDescriptor) == false) goto L7;
        ClassDescriptor r12 = (ClassDescriptor) r10;
    L8:
        if (r12 == null) goto L13;
        InlineClassRepresentation<SimpleType> r13 = DescriptorUtilsKt.getInlineClassRepresentation(r12);
        if (r13 == null) goto L13;
        r11 = r13.getUnderlyingPropertyName();
    L13:
        if (Intrinsics.areEqual(r11, r5.getName()) == false) goto L15;
        return true;
    L7:
        r12 = null;
    L15:
        return false;
    }

    public static final boolean isValueClass(DeclarationDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (isInlineClass(r5) == false) goto L5;
    L8:
        return true;
    L5:
        if (isMultiFieldValueClass(r5) == true) goto L8;
        return false;
    }

    public static final KotlinType unsubstitutedUnderlyingType(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ClassifierDescriptor r10 = r5.getConstructor().mo1402getDeclarationDescriptor();
        if ((r10 instanceof ClassDescriptor) == false) goto L5;
        ClassDescriptor r11 = (ClassDescriptor) r10;
    L6:
        if (r11 == null) goto L11;
        InlineClassRepresentation<SimpleType> r12 = DescriptorUtilsKt.getInlineClassRepresentation(r11);
        if (r12 != null) goto L10;
        return null;
    L10:
        return (SimpleType) r12.getUnderlyingType();
    L11:
        return null;
    L5:
        r11 = null;
        goto L6
    }
}
