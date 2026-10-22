package kotlin.reflect.jvm.internal.impl.load.kotlin;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nmethodSignatureMapping.kt\nKotlin\n*S Kotlin\n*F\n+ 1 methodSignatureMapping.kt\norg/jetbrains/kotlin/load/kotlin/MethodSignatureMappingKt\n+ 2 SignatureBuildingComponents.kt\norg/jetbrains/kotlin/load/kotlin/SignatureBuildingComponentsKt\n*L\n1#1,184:1\n13#2:185\n*S KotlinDebug\n*F\n+ 1 methodSignatureMapping.kt\norg/jetbrains/kotlin/load/kotlin/MethodSignatureMappingKt\n*L\n65#1:185\n*E\n"})
public final class MethodSignatureMappingKt {
    private static final void appendErasedType(StringBuilder r5, KotlinType r10) {
        r5.append(mapToJvmType(r10));
    }

    public static final String computeJvmDescriptor(FunctionDescriptor r5, boolean r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        StringBuilder r12 = new StringBuilder();
        if (r11 == true) goto L5;
    L9:
        r12.append("(");
        ReceiverParameterDescriptor r13 = r5.getExtensionReceiverParameter();
        if (r13 == null) goto L12;
        appendErasedType(r12, r13.getType());
    L12:
        Iterator<ValueParameterDescriptor> r14 = r5.getValueParameters().iterator();
    L14:
        if (r14.hasNext() == false) goto L16;
        appendErasedType(r12, r14.next().getType());
        goto L14
    L16:
        r12.append(")");
        if (r10 == false) goto L23;
        if (DescriptorBasedTypeSignatureMappingKt.hasVoidReturnType(r5) == false) goto L21;
        r12.append(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        goto L23
    L21:
        KotlinType r15 = r5.getReturnType();
        Intrinsics.checkNotNull(r15);
        appendErasedType(r12, r15);
    L23:
        return r12.toString();
    L5:
        if ((r5 instanceof ConstructorDescriptor) == false) goto L7;
        String r16 = "<init>";
    L8:
        r12.append(r16);
        goto L9
    L7:
        r16 = r5.getName().asString();
        goto L8
    }

    public static /* synthetic */ String computeJvmDescriptor$default(FunctionDescriptor r5, boolean r10, boolean r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = true;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = true;
    L9:
        return computeJvmDescriptor(r5, r10, r11);
    }

    public static final String computeJvmSignature(CallableDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        SignatureBuildingComponents r10 = SignatureBuildingComponents.INSTANCE;
        if (DescriptorUtils.isLocal(r5) == false) goto L5;
        return null;
    L5:
        DeclarationDescriptor r11 = r5.getContainingDeclaration();
        if ((r11 instanceof ClassDescriptor) == false) goto L8;
        ClassDescriptor r12 = (ClassDescriptor) r11;
    L9:
        if (r12 != null) goto L12;
        return null;
    L12:
        if (r12.getName().isSpecial() == false) goto L14;
        return null;
    L14:
        CallableDescriptor r13 = r5.getOriginal();
        if ((r13 instanceof SimpleFunctionDescriptor) == false) goto L17;
        SimpleFunctionDescriptor r14 = (SimpleFunctionDescriptor) r13;
    L18:
        if (r14 != null) goto L21;
        return null;
    L21:
        return MethodSignatureBuildingUtilsKt.signature(r10, r12, computeJvmDescriptor$default(r14, false, false, 3, null));
    L17:
        r14 = null;
        goto L18
    L8:
        r12 = null;
        goto L9
    }

    public static final boolean forceSingleValueParameterBoxing(CallableDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "f");
        if ((r5 instanceof FunctionDescriptor) == true) goto L5;
        return false;
    L5:
        FunctionDescriptor r10 = (FunctionDescriptor) r5;
        if (Intrinsics.areEqual(r10.getName().asString(), "remove") == true) goto L8;
        return false;
    L8:
        if (r10.getValueParameters().size() == 1) goto L10;
        return false;
    L10:
        if (SpecialBuiltinMembers.isFromJavaOrBuiltins((CallableMemberDescriptor) r5) == true) goto L37;
        JvmType r11 = mapToJvmType(((ValueParameterDescriptor) CollectionsKt.single(r10.getOriginal().getValueParameters())).getType());
        JvmPrimitiveType r12 = null;
        if ((r11 instanceof JvmType.Primitive) == false) goto L15;
        JvmType.Primitive r13 = (JvmType.Primitive) r11;
    L16:
        if (r13 == null) goto L19;
        r12 = r13.getJvmPrimitiveType();
    L19:
        if (r12 == JvmPrimitiveType.INT) goto L21;
        return false;
    L21:
        FunctionDescriptor r14 = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(r10);
        if (r14 != null) goto L24;
        return false;
    L24:
        JvmType r15 = mapToJvmType(((ValueParameterDescriptor) CollectionsKt.single(r14.getOriginal().getValueParameters())).getType());
        if (Intrinsics.areEqual(DescriptorUtilsKt.getFqNameUnsafe(r14.getContainingDeclaration()), StandardNames.FqNames.mutableCollection.toUnsafe()) == true) goto L27;
        return false;
    L27:
        if ((r15 instanceof JvmType.Object) == true) goto L29;
        return false;
    L29:
        if (Intrinsics.areEqual(((JvmType.Object) r15).getInternalName(), "java/lang/Object") == true) goto L31;
        return false;
    L31:
        return true;
    L15:
        r13 = null;
        goto L16
    L37:
        return false;
    }

    public static final String getInternalName(ClassDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ClassId r10 = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(DescriptorUtilsKt.getFqNameSafe(r5).toUnsafe());
        if (r10 == null) goto L7;
        return JvmClassName.byClassId(r10).getInternalName();
    L7:
        return DescriptorBasedTypeSignatureMappingKt.computeInternalName$default(r5, null, 2, null);
    }

    public static final JvmType mapToJvmType(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (JvmType) DescriptorBasedTypeSignatureMappingKt.mapType$default(r10, JvmTypeFactoryImpl.INSTANCE, TypeMappingMode.DEFAULT, TypeMappingConfigurationImpl.INSTANCE, null, null, 32, null);
    }
}
