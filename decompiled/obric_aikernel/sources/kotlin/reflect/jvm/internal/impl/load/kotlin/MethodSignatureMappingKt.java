package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public final class MethodSignatureMappingKt {
    private static final void appendErasedType(StringBuilder r10, KotlinType r11) {
        r10.append(mapToJvmType(r11));
    }

    public static final String computeJvmDescriptor(FunctionDescriptor r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        StringBuilder r13 = new StringBuilder();
        if (r12 == true) goto L5;
    L9:
        r13.append("(");
        ReceiverParameterDescriptor r14 = r10.getExtensionReceiverParameter();
        if (r14 == null) goto L12;
        KotlinType r15 = r14.getType();
        Intrinsics.checkNotNullExpressionValue(r15, "it.type");
        appendErasedType(r13, r15);
    L12:
        Iterator<ValueParameterDescriptor> r16 = r10.getValueParameters().iterator();
    L14:
        if (r16.hasNext() == false) goto L16;
        KotlinType r17 = r16.next().getType();
        Intrinsics.checkNotNullExpressionValue(r17, "parameter.type");
        appendErasedType(r13, r17);
        goto L14
    L16:
        r13.append(")");
        if (r11 == true) goto L19;
    L22:
        String r18 = r13.toString();
        Intrinsics.checkNotNullExpressionValue(r18, "StringBuilder().apply(builderAction).toString()");
        return r18;
    L19:
        if (DescriptorBasedTypeSignatureMappingKt.hasVoidReturnType(r10) == false) goto L21;
        r13.append("V");
        goto L22
    L21:
        KotlinType r19 = r10.getReturnType();
        Intrinsics.checkNotNull(r19);
        appendErasedType(r13, r19);
        goto L22
    L5:
        if ((r10 instanceof ConstructorDescriptor) == false) goto L7;
        String r20 = "<init>";
    L8:
        r13.append(r20);
        goto L9
    L7:
        r20 = r10.getName().asString();
        Intrinsics.checkNotNullExpressionValue(r20, "name.asString()");
        goto L8
    }

    public static /* synthetic */ String computeJvmDescriptor$default(FunctionDescriptor r10, boolean r11, boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = true;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = true;
    L9:
        return computeJvmDescriptor(r10, r11, r12);
    }

    public static final String computeJvmSignature(CallableDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        SignatureBuildingComponents r11 = SignatureBuildingComponents.INSTANCE;
        if (DescriptorUtils.isLocal(r10) == false) goto L5;
        return null;
    L5:
        DeclarationDescriptor r12 = r10.getContainingDeclaration();
        if ((r12 instanceof ClassDescriptor) == false) goto L8;
        ClassDescriptor r13 = (ClassDescriptor) r12;
    L9:
        if (r13 != null) goto L12;
        return null;
    L12:
        if (r13.getName().isSpecial() == false) goto L14;
        return null;
    L14:
        CallableDescriptor r14 = r10.getOriginal();
        if ((r14 instanceof SimpleFunctionDescriptor) == false) goto L17;
        SimpleFunctionDescriptor r15 = (SimpleFunctionDescriptor) r14;
    L18:
        if (r15 != null) goto L21;
        return null;
    L21:
        return MethodSignatureBuildingUtilsKt.signature(r11, r13, computeJvmDescriptor$default(r15, false, false, 3, null));
    L17:
        r15 = null;
        goto L18
    L8:
        r13 = null;
        goto L9
    }

    public static final boolean forceSingleValueParameterBoxing(CallableDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "f");
        if ((r10 instanceof FunctionDescriptor) == true) goto L5;
        return false;
    L5:
        FunctionDescriptor r11 = (FunctionDescriptor) r10;
        if (Intrinsics.areEqual(r11.getName().asString(), "remove") == true) goto L8;
        return false;
    L8:
        if (r11.getValueParameters().size() == 1) goto L10;
        return false;
    L10:
        if (SpecialBuiltinMembers.isFromJavaOrBuiltins((CallableMemberDescriptor) r10) == true) goto L37;
        List<ValueParameterDescriptor> r12 = r11.getOriginal().getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r12, "f.original.valueParameters");
        KotlinType r13 = ((ValueParameterDescriptor) CollectionsKt.single(r12)).getType();
        Intrinsics.checkNotNullExpressionValue(r13, "f.original.valueParameters.single().type");
        JvmType r14 = mapToJvmType(r13);
        JvmPrimitiveType r15 = null;
        if ((r14 instanceof JvmType.Primitive) == false) goto L15;
        JvmType.Primitive r16 = (JvmType.Primitive) r14;
    L16:
        if (r16 == null) goto L19;
        r15 = r16.getJvmPrimitiveType();
    L19:
        if (r15 == JvmPrimitiveType.INT) goto L21;
        return false;
    L21:
        FunctionDescriptor r17 = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(r11);
        if (r17 != null) goto L24;
        return false;
    L24:
        List<ValueParameterDescriptor> r18 = r17.getOriginal().getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r18, "overridden.original.valueParameters");
        KotlinType r19 = ((ValueParameterDescriptor) CollectionsKt.single(r18)).getType();
        Intrinsics.checkNotNullExpressionValue(r19, "overridden.original.valueParameters.single().type");
        JvmType r20 = mapToJvmType(r19);
        DeclarationDescriptor r21 = r17.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(r21, "overridden.containingDeclaration");
        if (Intrinsics.areEqual(DescriptorUtilsKt.getFqNameUnsafe(r21), StandardNames.FqNames.mutableCollection.toUnsafe()) == true) goto L27;
        return false;
    L27:
        if ((r20 instanceof JvmType.Object) == true) goto L29;
        return false;
    L29:
        if (Intrinsics.areEqual(((JvmType.Object) r20).getInternalName(), "java/lang/Object") == true) goto L31;
        return false;
    L31:
        return true;
    L15:
        r16 = null;
        goto L16
    L37:
        return false;
    }

    public static final String getInternalName(ClassDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        JavaToKotlinClassMap r11 = JavaToKotlinClassMap.INSTANCE;
        FqNameUnsafe r12 = DescriptorUtilsKt.getFqNameSafe(r10).toUnsafe();
        Intrinsics.checkNotNullExpressionValue(r12, "fqNameSafe.toUnsafe()");
        ClassId r13 = r11.mapKotlinToJava(r12);
        if (r13 == null) goto L7;
        String r14 = JvmClassName.byClassId(r13).getInternalName();
        Intrinsics.checkNotNullExpressionValue(r14, "byClassId(it).internalName");
        return r14;
    L7:
        return DescriptorBasedTypeSignatureMappingKt.computeInternalName$default(r10, null, 2, null);
    }

    public static final JvmType mapToJvmType(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (JvmType) DescriptorBasedTypeSignatureMappingKt.mapType$default(r10, JvmTypeFactoryImpl.INSTANCE, TypeMappingMode.DEFAULT, TypeMappingConfigurationImpl.INSTANCE, null, null, 32, null);
    }
}
