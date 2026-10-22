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

/* JADX INFO: loaded from: classes3.dex */
public final class JavaIncompatibilityRulesOverridabilityCondition implements ExternalOverridabilityCondition {
    public static final Companion Companion = null;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private final boolean isPrimitiveCompareTo(FunctionDescriptor r5) {
            if (r5.getValueParameters().size() == 1) goto L5;
            return false;
        L5:
            DeclarationDescriptor r10 = r5.getContainingDeclaration();
            ClassDescriptor r11 = null;
            if ((r10 instanceof ClassDescriptor) == false) goto L8;
            ClassDescriptor r12 = (ClassDescriptor) r10;
        L9:
            if (r12 != null) goto L11;
            return false;
        L11:
            ClassifierDescriptor r13 = ((ValueParameterDescriptor) CollectionsKt.single(r5.getValueParameters())).getType().getConstructor().mo1402getDeclarationDescriptor();
            if ((r13 instanceof ClassDescriptor) == false) goto L14;
            r11 = (ClassDescriptor) r13;
        L14:
            if (r11 != null) goto L17;
            return false;
        L17:
            if (KotlinBuiltIns.isPrimitiveClass(r12) == true) goto L19;
            return false;
        L19:
            if (Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe(r12), DescriptorUtilsKt.getFqNameSafe(r11)) == true) goto L21;
            return false;
        L21:
            return true;
        L8:
            r12 = null;
            goto L9
        }

        private final JvmType mapValueParameterType(FunctionDescriptor r5, ValueParameterDescriptor r10) {
            if (MethodSignatureMappingKt.forceSingleValueParameterBoxing(r5) == true) goto L9;
            if (isPrimitiveCompareTo(r5) == true) goto L9;
            return MethodSignatureMappingKt.mapToJvmType(r10.getType());
        L9:
            return MethodSignatureMappingKt.mapToJvmType(TypeUtilsKt.makeNullable(r10.getType()));
        }

        public final boolean doesJavaOverrideHaveIncompatibleValueParameterKinds(CallableDescriptor r10, CallableDescriptor r11) {
            Intrinsics.checkNotNullParameter(r10, "superDescriptor");
            Intrinsics.checkNotNullParameter(r11, "subDescriptor");
            if ((r11 instanceof JavaMethodDescriptor) == true) goto L5;
        L14:
            return false;
        L5:
            if ((r10 instanceof FunctionDescriptor) == false) goto L14;
            JavaMethodDescriptor r5 = (JavaMethodDescriptor) r11;
            r5.getValueParameters().size();
            FunctionDescriptor r12 = (FunctionDescriptor) r10;
            r12.getValueParameters().size();
            Iterator r13 = CollectionsKt.zip(r5.getOriginal().getValueParameters(), r12.getOriginal().getValueParameters()).iterator();
        L9:
            if (r13.hasNext() == false) goto L14;
            Pair r14 = (Pair) r13.next();
            ValueParameterDescriptor r15 = (ValueParameterDescriptor) r14.component1();
            ValueParameterDescriptor r16 = (ValueParameterDescriptor) r14.component2();
            if ((mapValueParameterType((FunctionDescriptor) r11, r15) instanceof JvmType.Primitive) == (mapValueParameterType(r12, r16) instanceof JvmType.Primitive)) goto L9;
            return true;
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public JavaIncompatibilityRulesOverridabilityCondition() {
    }

    private final boolean isIncompatibleInAccordanceWithBuiltInOverridabilityRules(CallableDescriptor r10, CallableDescriptor r11, ClassDescriptor r12) {
        if ((r10 instanceof CallableMemberDescriptor) == true) goto L5;
    L47:
        return false;
    L5:
        if ((r11 instanceof FunctionDescriptor) == false) goto L47;
        if (KotlinBuiltIns.isBuiltIn(r11) == true) goto L47;
        FunctionDescriptor r13 = (FunctionDescriptor) r11;
        if (BuiltinMethodsWithSpecialGenericSignature.INSTANCE.getSameAsBuiltinMethodWithErasedValueParameters(r13.getName()) == false) goto L12;
    L14:
        CallableMemberDescriptor r14 = SpecialBuiltinMembers.getOverriddenSpecialBuiltin((CallableMemberDescriptor) r10);
        boolean r5 = r10 instanceof FunctionDescriptor;
        if (r5 == false) goto L17;
        FunctionDescriptor r15 = (FunctionDescriptor) r10;
    L19:
        if (r15 != null) goto L21;
    L23:
        boolean r16 = false;
    L24:
        if (r16 == true) goto L30;
        if (r14 != null) goto L27;
    L28:
        return true;
    L27:
        if (r13.isHiddenToOvercomeSignatureClash() == false) goto L28;
    L30:
        if ((r12 instanceof JavaClassDescriptor) == false) goto L47;
        if (r13.getInitialSignatureDescriptor() != null) goto L47;
        if (r14 == null) goto L47;
        if (SpecialBuiltinMembers.hasRealKotlinSuperClassWithOverrideOf(r12, r14) == true) goto L47;
        if ((r14 instanceof FunctionDescriptor) == false) goto L46;
        if (r5 == false) goto L46;
        if (BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava((FunctionDescriptor) r14) == null) goto L46;
        if (Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmDescriptor$default(r13, false, false, 2, null), MethodSignatureMappingKt.computeJvmDescriptor$default(((FunctionDescriptor) r10).getOriginal(), false, false, 2, null)) == false) goto L46;
        return false;
    L46:
        return true;
    L21:
        if (r13.isHiddenToOvercomeSignatureClash() != r15.isHiddenToOvercomeSignatureClash()) goto L23;
        r16 = true;
        goto L24
    L17:
        r15 = null;
        goto L19
    L12:
        if (SpecialGenericSignatures.Companion.getSameAsRenamedInJvmBuiltin(r13.getName()) == true) goto L14;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Contract getContract() {
        return ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Result isOverridable(CallableDescriptor r5, CallableDescriptor r10, ClassDescriptor r11) {
        Intrinsics.checkNotNullParameter(r5, "superDescriptor");
        Intrinsics.checkNotNullParameter(r10, "subDescriptor");
        if (isIncompatibleInAccordanceWithBuiltInOverridabilityRules(r5, r10, r11) == false) goto L7;
        return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
    L7:
        if (Companion.doesJavaOverrideHaveIncompatibleValueParameterKinds(r5, r10) == false) goto L11;
        return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
    L11:
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }
}
