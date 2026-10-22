package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.util.OperatorChecks;

/* JADX INFO: loaded from: classes3.dex */
public class JavaMethodDescriptor extends SimpleFunctionDescriptorImpl implements JavaCallableMemberDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final CallableDescriptor.UserDataKey<Boolean> HAS_ERASED_VALUE_PARAMETERS = null;
    public static final CallableDescriptor.UserDataKey<ValueParameterDescriptor> ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER = null;
    private final boolean isForRecordComponent;
    private ParameterNamesStatus parameterNamesStatus;

    public static final enum ParameterNamesStatus extends Enum<ParameterNamesStatus> {
        private static final /* synthetic */ ParameterNamesStatus[] $VALUES = null;
        public static final ParameterNamesStatus NON_STABLE_DECLARED = null;
        public static final ParameterNamesStatus NON_STABLE_SYNTHESIZED = null;
        public static final ParameterNamesStatus STABLE_DECLARED = null;
        public static final ParameterNamesStatus STABLE_SYNTHESIZED = null;
        public final boolean isStable;
        public final boolean isSynthesized;

        private static /* synthetic */ void $$$reportNull$$$0(int r5) {
            throw new IllegalStateException("@NotNull method kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor$ParameterNamesStatus.get must not return null");
        }

        static {
            ParameterNamesStatus r5 = new ParameterNamesStatus("NON_STABLE_DECLARED", 0, false, false);
            NON_STABLE_DECLARED = r5;
            ParameterNamesStatus r10 = new ParameterNamesStatus("STABLE_DECLARED", 1, true, false);
            STABLE_DECLARED = r10;
            ParameterNamesStatus r11 = new ParameterNamesStatus("NON_STABLE_SYNTHESIZED", 2, false, true);
            NON_STABLE_SYNTHESIZED = r11;
            ParameterNamesStatus r12 = new ParameterNamesStatus("STABLE_SYNTHESIZED", 3, true, true);
            STABLE_SYNTHESIZED = r12;
            $VALUES = new ParameterNamesStatus[]{r5, r10, r11, r12};
        }

        private ParameterNamesStatus(String r5, int r10, boolean r11, boolean r12) {
            super(r5, r10);
            this.isStable = r11;
            this.isSynthesized = r12;
        }

        public static ParameterNamesStatus get(boolean r5, boolean r10) {
            if (r5 == false) goto L6;
            if (r10 == false) goto L5;
            ParameterNamesStatus r11 = STABLE_SYNTHESIZED;
        L9:
            if (r11 != null) goto L11;
            $$$reportNull$$$0(0);
        L11:
            return r11;
        L5:
            r11 = STABLE_DECLARED;
            goto L9
        L6:
            if (r10 == false) goto L8;
            r11 = NON_STABLE_SYNTHESIZED;
            goto L9
        L8:
            r11 = NON_STABLE_DECLARED;
            goto L9
        }

        public static ParameterNamesStatus valueOf(String r5) {
            return (ParameterNamesStatus) Enum.valueOf(ParameterNamesStatus.class, r5);
        }

        public static ParameterNamesStatus[] values() {
            return (ParameterNamesStatus[]) $VALUES.clone();
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r11) {
        if (r11 == 13) goto L7;
        if (r11 == 18) goto L7;
        if (r11 == 21) goto L7;
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r11 == 13) goto L13;
        if (r11 == 18) goto L13;
        if (r11 == 21) goto L13;
        int r10 = 3;
    L14:
        Object[] r12 = new Object[r10];
        switch(r11) {
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L26;
            case 4: goto L25;
            case 5: goto L16;
            case 6: goto L28;
            case 7: goto L27;
            case 8: goto L25;
            case 9: goto L24;
            case 10: goto L23;
            case 11: goto L22;
            case 12: goto L21;
            case 13: goto L20;
            case 14: goto L19;
            case 15: goto L26;
            case 16: goto L28;
            case 17: goto L25;
            case 18: goto L20;
            case 19: goto L18;
            case 20: goto L17;
            case 21: goto L20;
            default: goto L16;
        };
    L16:
        r12[0] = "containingDeclaration";
    L30:
        if (r11 == 13) goto L36;
        if (r11 == 18) goto L35;
        if (r11 == 21) goto L34;
        r12[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
    L37:
        switch(r11) {
            case 5: goto L42;
            case 6: goto L42;
            case 7: goto L42;
            case 8: goto L42;
            case 9: goto L41;
            case 10: goto L41;
            case 11: goto L41;
            case 12: goto L41;
            case 13: goto L43;
            case 14: goto L40;
            case 15: goto L40;
            case 16: goto L40;
            case 17: goto L40;
            case 18: goto L43;
            case 19: goto L39;
            case 20: goto L39;
            case 21: goto L43;
            default: goto L38;
        };
    L38:
        r12[2] = "<init>";
        goto L43
    L39:
        r12[2] = "enhance";
        goto L43
    L40:
        r12[2] = "createSubstitutedCopy";
        goto L43
    L41:
        r12[2] = "initialize";
        goto L43
    L42:
        r12[2] = "createJavaMethod";
    L43:
        String r13 = String.format(r5, r12);
        if (r11 == 13) goto L49;
        if (r11 == 18) goto L49;
        if (r11 == 21) goto L49;
        throw new IllegalArgumentException(r13);
    L49:
        throw new IllegalStateException(r13);
    L34:
        r12[1] = "enhance";
        goto L37
    L35:
        r12[1] = "createSubstitutedCopy";
        goto L37
    L36:
        r12[1] = "initialize";
        goto L37
    L17:
        r12[0] = "enhancedReturnType";
        goto L30
    L18:
        r12[0] = "enhancedValueParameterTypes";
        goto L30
    L19:
        r12[0] = "newOwner";
        goto L30
    L20:
        r12[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
        goto L30
    L21:
        r12[0] = "visibility";
        goto L30
    L22:
        r12[0] = "unsubstitutedValueParameters";
        goto L30
    L23:
        r12[0] = "typeParameters";
        goto L30
    L24:
        r12[0] = "contextReceiverParameters";
        goto L30
    L25:
        r12[0] = "source";
        goto L30
    L26:
        r12[0] = "kind";
        goto L30
    L27:
        r12[0] = "name";
        goto L30
    L28:
        r12[0] = "annotations";
    L13:
        r10 = 2;
    L7:
        r5 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    static {
        ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER = new AnonymousClass1();
        HAS_ERASED_VALUE_PARAMETERS = new AnonymousClass2();
    }

    public JavaMethodDescriptor(DeclarationDescriptor r5, SimpleFunctionDescriptor r10, Annotations r11, Name r12, CallableMemberDescriptor.Kind r13, SourceElement r14, boolean r15) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r12 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r13 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        if (r14 != null) goto L12;
        $$$reportNull$$$0(4);
    L12:
        super(r5, r10, r11, r12, r13, r14);
        this.parameterNamesStatus = null;
        this.isForRecordComponent = r15;
    }

    public static JavaMethodDescriptor createJavaMethod(DeclarationDescriptor r10, Annotations r11, Name r12, SourceElement r13, boolean r14) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(5);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(6);
    L6:
        if (r12 != null) goto L8;
        $$$reportNull$$$0(7);
    L8:
        if (r13 != null) goto L11;
        $$$reportNull$$$0(8);
    L11:
        return new JavaMethodDescriptor(r10, null, r11, r12, CallableMemberDescriptor.Kind.DECLARATION, r13, r14);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public /* bridge */ /* synthetic */ FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r5, FunctionDescriptor r10, CallableMemberDescriptor.Kind r11, Name r12, Annotations r13, SourceElement r14) {
        return createSubstitutedCopy(r5, r10, r11, r12, r13, r14);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
    public /* bridge */ /* synthetic */ JavaCallableMemberDescriptor enhance(KotlinType r5, List r10, KotlinType r11, Pair r12) {
        return enhance(r5, r10, r11, r12);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public boolean hasStableParameterNames() {
        return this.parameterNamesStatus.isStable;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return this.parameterNamesStatus.isSynthesized;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl
    public SimpleFunctionDescriptorImpl initialize(ReceiverParameterDescriptor r5, ReceiverParameterDescriptor r10, List<ReceiverParameterDescriptor> r11, List<? extends TypeParameterDescriptor> r12, List<ValueParameterDescriptor> r13, KotlinType r14, Modality r15, DescriptorVisibility r16, Map<? extends CallableDescriptor.UserDataKey<?>, ?> r17) {
        if (r11 != null) goto L4;
        $$$reportNull$$$0(9);
    L4:
        if (r12 != null) goto L6;
        $$$reportNull$$$0(10);
    L6:
        if (r13 != null) goto L8;
        $$$reportNull$$$0(11);
    L8:
        if (r16 != null) goto L10;
        $$$reportNull$$$0(12);
    L10:
        SimpleFunctionDescriptorImpl r18 = super.initialize(r5, r10, r11, r12, r13, r14, r15, r16, r17);
        setOperator(OperatorChecks.INSTANCE.check(r18).isSuccess());
        if (r18 != null) goto L13;
        $$$reportNull$$$0(13);
    L13:
        return r18;
    }

    public void setParameterNamesStatus(boolean r5, boolean r10) {
        this.parameterNamesStatus = ParameterNamesStatus.get(r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public JavaMethodDescriptor createSubstitutedCopy(DeclarationDescriptor r10, FunctionDescriptor r11, CallableMemberDescriptor.Kind r12, Name r13, Annotations r14, SourceElement r15) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(14);
    L4:
        if (r12 != null) goto L6;
        $$$reportNull$$$0(15);
    L6:
        if (r14 != null) goto L8;
        $$$reportNull$$$0(16);
    L8:
        if (r15 != null) goto L10;
        $$$reportNull$$$0(17);
    L10:
        SimpleFunctionDescriptor r5 = (SimpleFunctionDescriptor) r11;
        if (r13 == null) goto L13;
    L12:
        Name r16 = r13;
        JavaMethodDescriptor r17 = new JavaMethodDescriptor(r10, r5, r14, r16, r12, r15, this.isForRecordComponent);
        r17.setParameterNamesStatus(hasStableParameterNames(), hasSynthesizedParameterNames());
        return r17;
    L13:
        r13 = getName();
        goto L12
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
    public JavaMethodDescriptor enhance(KotlinType r5, List<KotlinType> r10, KotlinType r11, Pair<CallableDescriptor.UserDataKey<?>, ?> r12) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(19);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(20);
    L6:
        List<ValueParameterDescriptor> r13 = UtilKt.copyValueParameters(r10, getValueParameters(), this);
        if (r5 != null) goto L9;
        ReceiverParameterDescriptor r14 = null;
    L10:
        JavaMethodDescriptor r15 = (JavaMethodDescriptor) newCopyBuilder().setValueParameters(r13).setReturnType(r11).setExtensionReceiverParameter(r14).setDropOriginalInContainingParts().setPreserveSourceElement().build();
        if (r12 == null) goto L13;
        r15.putInUserDataMap(r12.getFirst(), r12.getSecond());
    L13:
        if (r15 != null) goto L15;
        $$$reportNull$$$0(21);
    L15:
        return r15;
    L9:
        r14 = DescriptorFactory.createExtensionReceiverParameterForCallable(this, r5, Annotations.Companion.getEMPTY());
        goto L10
    }
}
