package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class JavaIncompatibilityRulesOverridabilityCondition implements ExternalOverridabilityCondition {
    public static final Companion Companion = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        private final boolean isPrimitiveCompareTo(FunctionDescriptor r10) {
            if (r10.getValueParameters().size() == 1) goto L5;
            return false;
        L5:
            DeclarationDescriptor r11 = r10.getContainingDeclaration();
            ClassDescriptor r12 = null;
            if ((r11 instanceof ClassDescriptor) == false) goto L8;
            ClassDescriptor r13 = (ClassDescriptor) r11;
        L9:
            if (r13 != null) goto L11;
            return false;
        L11:
            List<ValueParameterDescriptor> r14 = r10.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(r14, "f.valueParameters");
            ClassifierDescriptor r15 = ((ValueParameterDescriptor) CollectionsKt.single(r14)).getType().getConstructor().mo1323getDeclarationDescriptor();
            if ((r15 instanceof ClassDescriptor) == false) goto L14;
            r12 = (ClassDescriptor) r15;
        L14:
            if (r12 != null) goto L17;
            return false;
        L17:
            if (KotlinBuiltIns.isPrimitiveClass(r13) == false) goto L22;
            if (Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe(r13), DescriptorUtilsKt.getFqNameSafe(r12)) == false) goto L22;
            return true;
        L22:
            return false;
        L8:
            r13 = null;
            goto L9
        }

        private final JvmType mapValueParameterType(FunctionDescriptor r10, ValueParameterDescriptor r11) {
            if (MethodSignatureMappingKt.forceSingleValueParameterBoxing(r10) == false) goto L5;
        L8:
            KotlinType r12 = r11.getType();
            Intrinsics.checkNotNullExpressionValue(r12, "valueParameterDescriptor.type");
            KotlinType r13 = TypeUtilsKt.makeNullable(r12);
        L10:
            return MethodSignatureMappingKt.mapToJvmType(r13);
        L5:
            if (isPrimitiveCompareTo(r10) == true) goto L8;
            r13 = r11.getType();
            Intrinsics.checkNotNullExpressionValue(r13, "valueParameterDescriptor.type");
            goto L10
        }

        public final boolean doesJavaOverrideHaveIncompatibleValueParameterKinds(CallableDescriptor r10, CallableDescriptor r11) {
            Intrinsics.checkNotNullParameter(r10, "superDescriptor");
            Intrinsics.checkNotNullParameter(r11, "subDescriptor");
            if ((r11 instanceof JavaMethodDescriptor) == true) goto L5;
        L14:
            return false;
        L5:
            if ((r10 instanceof FunctionDescriptor) == false) goto L14;
            JavaMethodDescriptor r12 = (JavaMethodDescriptor) r11;
            r12.getValueParameters().size();
            FunctionDescriptor r13 = (FunctionDescriptor) r10;
            r13.getValueParameters().size();
            List<ValueParameterDescriptor> r14 = r12.getOriginal().getValueParameters();
            Intrinsics.checkNotNullExpressionValue(r14, "subDescriptor.original.valueParameters");
            List<ValueParameterDescriptor> r15 = r13.getOriginal().getValueParameters();
            Intrinsics.checkNotNullExpressionValue(r15, "superDescriptor.original.valueParameters");
            Iterator r16 = CollectionsKt.zip(r14, r15).iterator();
        L9:
            if (r16.hasNext() == false) goto L14;
            Pair r17 = (Pair) r16.next();
            ValueParameterDescriptor r18 = (ValueParameterDescriptor) r17.component1();
            ValueParameterDescriptor r19 = (ValueParameterDescriptor) r17.component2();
            Intrinsics.checkNotNullExpressionValue(r18, "subParameter");
            boolean r20 = mapValueParameterType((FunctionDescriptor) r11, r18) instanceof JvmType.Primitive;
            Intrinsics.checkNotNullExpressionValue(r19, "superParameter");
            if (r20 == (mapValueParameterType(r13, r19) instanceof JvmType.Primitive)) goto L9;
            return true;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public JavaIncompatibilityRulesOverridabilityCondition() {
    }

    private final boolean isIncompatibleInAccordanceWithBuiltInOverridabilityRules(CallableDescriptor r10, CallableDescriptor r11, ClassDescriptor r12) {
        if ((r10 instanceof CallableMemberDescriptor) == true) goto L5;
    L48:
        return false;
    L5:
        if ((r11 instanceof FunctionDescriptor) == false) goto L48;
        if (KotlinBuiltIns.isBuiltIn(r11) == true) goto L48;
        BuiltinMethodsWithSpecialGenericSignature r13 = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
        FunctionDescriptor r14 = (FunctionDescriptor) r11;
        Name r15 = r14.getName();
        Intrinsics.checkNotNullExpressionValue(r15, "subDescriptor.name");
        if (r13.getSameAsBuiltinMethodWithErasedValueParameters(r15) == true) goto L14;
        SpecialGenericSignatures.Companion r16 = SpecialGenericSignatures.Companion;
        Name r17 = r14.getName();
        Intrinsics.checkNotNullExpressionValue(r17, "subDescriptor.name");
        if (r16.getSameAsRenamedInJvmBuiltin(r17) == true) goto L14;
        return false;
    L14:
        CallableMemberDescriptor r18 = SpecialBuiltinMembers.getOverriddenSpecialBuiltin((CallableMemberDescriptor) r10);
        boolean r19 = r10 instanceof FunctionDescriptor;
        if (r19 == false) goto L17;
        FunctionDescriptor r20 = (FunctionDescriptor) r10;
    L19:
        if (r20 != null) goto L21;
    L23:
        boolean r21 = false;
    L25:
        if ((!r21) == false) goto L31;
        if (r18 != null) goto L28;
    L29:
        return true;
    L28:
        if (r14.isHiddenToOvercomeSignatureClash() == false) goto L29;
    L31:
        if ((r12 instanceof JavaClassDescriptor) == false) goto L48;
        if (r14.getInitialSignatureDescriptor() != null) goto L48;
        if (r18 == null) goto L48;
        if (SpecialBuiltinMembers.hasRealKotlinSuperClassWithOverrideOf(r12, r18) == true) goto L48;
        if ((r18 instanceof FunctionDescriptor) == false) goto L47;
        if (r19 == false) goto L47;
        if (BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava((FunctionDescriptor) r18) == null) goto L47;
        String r22 = MethodSignatureMappingKt.computeJvmDescriptor$default(r14, false, false, 2, null);
        FunctionDescriptor r23 = ((FunctionDescriptor) r10).getOriginal();
        Intrinsics.checkNotNullExpressionValue(r23, "superDescriptor.original");
        if (Intrinsics.areEqual(r22, MethodSignatureMappingKt.computeJvmDescriptor$default(r23, false, false, 2, null)) == false) goto L47;
        return false;
    L47:
        return true;
    L21:
        if (r14.isHiddenToOvercomeSignatureClash() != r20.isHiddenToOvercomeSignatureClash()) goto L23;
        r21 = true;
        goto L25
    L17:
        r20 = null;
        goto L19
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Contract getContract() {
        return ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Result isOverridable(CallableDescriptor r10, CallableDescriptor r11, ClassDescriptor r12) {
        Intrinsics.checkNotNullParameter(r10, "superDescriptor");
        Intrinsics.checkNotNullParameter(r11, "subDescriptor");
        if (isIncompatibleInAccordanceWithBuiltInOverridabilityRules(r10, r11, r12) == false) goto L7;
        return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
    L7:
        if (Companion.doesJavaOverrideHaveIncompatibleValueParameterKinds(r10, r11) == false) goto L11;
        return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
    L11:
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }
}
