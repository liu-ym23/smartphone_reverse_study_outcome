package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Iterator;
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
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class JavaIncompatibilityRulesOverridabilityCondition implements ExternalOverridabilityCondition {
    public static final Companion Companion = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private final boolean isPrimitiveCompareTo(FunctionDescriptor r6) {
            if (r6.getValueParameters().size() == 1) goto L5;
            return false;
        L5:
            DeclarationDescriptor r0 = r6.getContainingDeclaration();
            ClassDescriptor r4 = null;
            if ((r0 instanceof ClassDescriptor) == false) goto L8;
            ClassDescriptor r1 = (ClassDescriptor) r0;
        L9:
            if (r1 != null) goto L11;
            return false;
        L11:
            ClassifierDescriptor r7 = ((ValueParameterDescriptor) CollectionsKt.single(r6.getValueParameters())).getType().getConstructor().getDeclarationDescriptor();
            if ((r7 instanceof ClassDescriptor) == false) goto L14;
            r4 = (ClassDescriptor) r7;
        L14:
            if (r4 != null) goto L17;
            return false;
        L17:
            if (KotlinBuiltIns.isPrimitiveClass(r1) == true) goto L19;
            return false;
        L19:
            if (Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe(r1), DescriptorUtilsKt.getFqNameSafe(r4)) == false) goto L23;
            return true;
        L23:
            return false;
        L8:
            r1 = null;
            goto L9
        }

        private final JvmType mapValueParameterType(FunctionDescriptor r2, ValueParameterDescriptor r3) {
            if (MethodSignatureMappingKt.forceSingleValueParameterBoxing(r2) == true) goto L9;
            if (isPrimitiveCompareTo(r2) == true) goto L9;
            return MethodSignatureMappingKt.mapToJvmType(r3.getType());
        L9:
            return MethodSignatureMappingKt.mapToJvmType(TypeUtilsKt.makeNullable(r3.getType()));
        }

        public final boolean doesJavaOverrideHaveIncompatibleValueParameterKinds(CallableDescriptor r6, CallableDescriptor r7) {
            Intrinsics.checkNotNullParameter(r6, "superDescriptor");
            Intrinsics.checkNotNullParameter(r7, "subDescriptor");
            if ((r7 instanceof JavaMethodDescriptor) == true) goto L5;
        L14:
            return false;
        L5:
            if ((r6 instanceof FunctionDescriptor) == false) goto L14;
            JavaMethodDescriptor r0 = (JavaMethodDescriptor) r7;
            r0.getValueParameters().size();
            FunctionDescriptor r8 = (FunctionDescriptor) r6;
            r8.getValueParameters().size();
            Iterator r1 = CollectionsKt.zip(r0.getOriginal().getValueParameters(), r8.getOriginal().getValueParameters()).iterator();
        L9:
            if (r1.hasNext() == false) goto L14;
            Pair r2 = (Pair) r1.next();
            ValueParameterDescriptor r3 = (ValueParameterDescriptor) r2.component1();
            ValueParameterDescriptor r4 = (ValueParameterDescriptor) r2.component2();
            Intrinsics.checkNotNull(r3);
            boolean r5 = mapValueParameterType((FunctionDescriptor) r7, r3) instanceof JvmType.Primitive;
            Intrinsics.checkNotNull(r4);
            if (r5 == (mapValueParameterType(r8, r4) instanceof JvmType.Primitive)) goto L9;
            return true;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public JavaIncompatibilityRulesOverridabilityCondition() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Contract getContract() {
        return ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY;
    }

    private final boolean isIncompatibleInAccordanceWithBuiltInOverridabilityRules(CallableDescriptor r8, CallableDescriptor r9, ClassDescriptor r10) {
        if ((r8 instanceof CallableMemberDescriptor) == true) goto L5;
    L48:
        return false;
    L5:
        if ((r9 instanceof FunctionDescriptor) == false) goto L48;
        if (KotlinBuiltIns.isBuiltIn(r9) == true) goto L48;
        FunctionDescriptor r11 = (FunctionDescriptor) r9;
        if (BuiltinMethodsWithSpecialGenericSignature.INSTANCE.getSameAsBuiltinMethodWithErasedValueParameters(r11.getName()) == false) goto L12;
    L14:
        CallableMemberDescriptor r0 = SpecialBuiltinMembers.getOverriddenSpecialBuiltin((CallableMemberDescriptor) r8);
        boolean r2 = r8 instanceof FunctionDescriptor;
        if (r2 == false) goto L17;
        FunctionDescriptor r4 = (FunctionDescriptor) r8;
    L19:
        if (r4 != null) goto L21;
    L23:
        boolean r5 = false;
    L25:
        if ((!r5) == false) goto L31;
        if (r0 != null) goto L28;
    L29:
        return true;
    L28:
        if (r11.isHiddenToOvercomeSignatureClash() == false) goto L29;
    L31:
        if ((r10 instanceof JavaClassDescriptor) == false) goto L48;
        if (r11.getInitialSignatureDescriptor() != null) goto L48;
        if (r0 == null) goto L48;
        if (SpecialBuiltinMembers.hasRealKotlinSuperClassWithOverrideOf(r10, r0) == true) goto L48;
        if ((r0 instanceof FunctionDescriptor) == false) goto L47;
        if (r2 == false) goto L47;
        if (BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava((FunctionDescriptor) r0) == null) goto L47;
        if (Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmDescriptor$default(r11, false, false, 2, null), MethodSignatureMappingKt.computeJvmDescriptor$default(((FunctionDescriptor) r8).getOriginal(), false, false, 2, null)) == false) goto L47;
        return false;
    L47:
        return true;
    L21:
        if (r11.isHiddenToOvercomeSignatureClash() != r4.isHiddenToOvercomeSignatureClash()) goto L23;
        r5 = true;
        goto L25
    L17:
        r4 = null;
        goto L19
    L12:
        if (SpecialGenericSignatures.Companion.getSameAsRenamedInJvmBuiltin(r11.getName()) == true) goto L14;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Result isOverridable(CallableDescriptor r2, CallableDescriptor r3, ClassDescriptor r4) {
        Intrinsics.checkNotNullParameter(r2, "superDescriptor");
        Intrinsics.checkNotNullParameter(r3, "subDescriptor");
        if (isIncompatibleInAccordanceWithBuiltInOverridabilityRules(r2, r3, r4) == false) goto L7;
        return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
    L7:
        if (Companion.doesJavaOverrideHaveIncompatibleValueParameterKinds(r2, r3) == false) goto L11;
        return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
    L11:
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }
}
