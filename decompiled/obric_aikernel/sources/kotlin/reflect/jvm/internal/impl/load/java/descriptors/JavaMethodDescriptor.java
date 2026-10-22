package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import com.bytedance.crash.tracker.ActivityLifecycle;
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

    private static final enum ParameterNamesStatus extends Enum<ParameterNamesStatus> {
        private static final /* synthetic */ ParameterNamesStatus[] $VALUES = null;
        public static final ParameterNamesStatus NON_STABLE_DECLARED = null;
        public static final ParameterNamesStatus NON_STABLE_SYNTHESIZED = null;
        public static final ParameterNamesStatus STABLE_DECLARED = null;
        public static final ParameterNamesStatus STABLE_SYNTHESIZED = null;
        public final boolean isStable;
        public final boolean isSynthesized;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor$ParameterNamesStatus", "get"}));
        }

        static {
            ParameterNamesStatus r10 = new ParameterNamesStatus("NON_STABLE_DECLARED", 0, false, false);
            NON_STABLE_DECLARED = r10;
            ParameterNamesStatus r11 = new ParameterNamesStatus("STABLE_DECLARED", 1, true, false);
            STABLE_DECLARED = r11;
            ParameterNamesStatus r12 = new ParameterNamesStatus("NON_STABLE_SYNTHESIZED", 2, false, true);
            NON_STABLE_SYNTHESIZED = r12;
            ParameterNamesStatus r13 = new ParameterNamesStatus("STABLE_SYNTHESIZED", 3, true, true);
            STABLE_SYNTHESIZED = r13;
            $VALUES = new ParameterNamesStatus[]{r10, r11, r12, r13};
        }

        private ParameterNamesStatus(String r10, int r11, boolean r12, boolean r13) {
            super(r10, r11);
            this.isStable = r12;
            this.isSynthesized = r13;
        }

        public static ParameterNamesStatus get(boolean r10, boolean r11) {
            if (r10 == false) goto L6;
            if (r11 == false) goto L5;
            ParameterNamesStatus r12 = STABLE_SYNTHESIZED;
        L9:
            if (r12 != null) goto L11;
            $$$reportNull$$$0(0);
        L11:
            return r12;
        L5:
            r12 = STABLE_DECLARED;
            goto L9
        L6:
            if (r11 == false) goto L8;
            r12 = NON_STABLE_SYNTHESIZED;
            goto L9
        L8:
            r12 = NON_STABLE_DECLARED;
            goto L9
        }

        public static ParameterNamesStatus valueOf(String r10) {
            return (ParameterNamesStatus) Enum.valueOf(ParameterNamesStatus.class, r10);
        }

        public static ParameterNamesStatus[] values() {
            return (ParameterNamesStatus[]) $VALUES.clone();
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r11) {
        if (r11 == 13) goto L7;
        if (r11 == 18) goto L7;
        if (r11 == 21) goto L7;
        String r10 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r11 == 13) goto L13;
        if (r11 == 18) goto L13;
        if (r11 == 21) goto L13;
        int r12 = 3;
    L14:
        Object[] r13 = new Object[r12];
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
        r13[0] = "containingDeclaration";
    L30:
        if (r11 == 13) goto L36;
        if (r11 == 18) goto L35;
        if (r11 == 21) goto L34;
        r13[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
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
        r13[2] = "<init>";
        goto L43
    L39:
        r13[2] = "enhance";
        goto L43
    L40:
        r13[2] = "createSubstitutedCopy";
        goto L43
    L41:
        r13[2] = "initialize";
        goto L43
    L42:
        r13[2] = "createJavaMethod";
    L43:
        String r14 = String.format(r10, r13);
        if (r11 == 13) goto L49;
        if (r11 == 18) goto L49;
        if (r11 == 21) goto L49;
        throw new IllegalArgumentException(r14);
    L49:
        throw new IllegalStateException(r14);
    L34:
        r13[1] = "enhance";
        goto L37
    L35:
        r13[1] = "createSubstitutedCopy";
        goto L37
    L36:
        r13[1] = "initialize";
        goto L37
    L17:
        r13[0] = "enhancedReturnType";
        goto L30
    L18:
        r13[0] = "enhancedValueParameterTypes";
        goto L30
    L19:
        r13[0] = "newOwner";
        goto L30
    L20:
        r13[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
        goto L30
    L21:
        r13[0] = "visibility";
        goto L30
    L22:
        r13[0] = "unsubstitutedValueParameters";
        goto L30
    L23:
        r13[0] = "typeParameters";
        goto L30
    L24:
        r13[0] = "contextReceiverParameters";
        goto L30
    L25:
        r13[0] = "source";
        goto L30
    L26:
        r13[0] = "kind";
        goto L30
    L27:
        r13[0] = ActivityLifecycle.NAME;
        goto L30
    L28:
        r13[0] = "annotations";
    L13:
        r12 = 2;
    L7:
        r10 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    static {
        ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER = new AnonymousClass1();
        HAS_ERASED_VALUE_PARAMETERS = new AnonymousClass2();
    }

    protected JavaMethodDescriptor(DeclarationDescriptor r10, SimpleFunctionDescriptor r11, Annotations r12, Name r13, CallableMemberDescriptor.Kind r14, SourceElement r15, boolean r16) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r12 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r13 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r14 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        if (r15 != null) goto L12;
        $$$reportNull$$$0(4);
    L12:
        super(r10, r11, r12, r13, r14, r15);
        this.parameterNamesStatus = null;
        this.isForRecordComponent = r16;
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
    protected /* bridge */ /* synthetic */ FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r10, FunctionDescriptor r11, CallableMemberDescriptor.Kind r12, Name r13, Annotations r14, SourceElement r15) {
        return createSubstitutedCopy(r10, r11, r12, r13, r14, r15);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    protected JavaMethodDescriptor createSubstitutedCopy(DeclarationDescriptor r10, FunctionDescriptor r11, CallableMemberDescriptor.Kind r12, Name r13, Annotations r14, SourceElement r15) {
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
        SimpleFunctionDescriptor r16 = (SimpleFunctionDescriptor) r11;
        if (r13 != null) goto L14;
        r13 = getName();
    L14:
        JavaMethodDescriptor r17 = new JavaMethodDescriptor(r10, r16, r14, r13, r12, r15, this.isForRecordComponent);
        r17.setParameterNamesStatus(hasStableParameterNames(), hasSynthesizedParameterNames());
        return r17;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
    public /* bridge */ /* synthetic */ JavaCallableMemberDescriptor enhance(KotlinType r10, List r11, KotlinType r12, Pair r13) {
        return enhance(r10, r11, r12, r13);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
    public JavaMethodDescriptor enhance(KotlinType r10, List<KotlinType> r11, KotlinType r12, Pair<CallableDescriptor.UserDataKey<?>, ?> r13) {
        if (r11 != null) goto L4;
        $$$reportNull$$$0(19);
    L4:
        if (r12 != null) goto L6;
        $$$reportNull$$$0(20);
    L6:
        List<ValueParameterDescriptor> r14 = UtilKt.copyValueParameters(r11, getValueParameters(), this);
        if (r10 != null) goto L9;
        ReceiverParameterDescriptor r15 = null;
    L10:
        JavaMethodDescriptor r16 = (JavaMethodDescriptor) newCopyBuilder().setValueParameters(r14).setReturnType(r12).setExtensionReceiverParameter(r15).setDropOriginalInContainingParts().setPreserveSourceElement().build();
        if (r13 == null) goto L13;
        r16.putInUserDataMap(r13.getFirst(), r13.getSecond());
    L13:
        if (r16 != null) goto L15;
        $$$reportNull$$$0(21);
    L15:
        return r16;
    L9:
        r15 = DescriptorFactory.createExtensionReceiverParameterForCallable(this, r10, Annotations.Companion.getEMPTY());
        goto L10
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
    public SimpleFunctionDescriptorImpl initialize(ReceiverParameterDescriptor r10, ReceiverParameterDescriptor r11, List<ReceiverParameterDescriptor> r12, List<? extends TypeParameterDescriptor> r13, List<ValueParameterDescriptor> r14, KotlinType r15, Modality r16, DescriptorVisibility r17, Map<? extends CallableDescriptor.UserDataKey<?>, ?> r18) {
        if (r12 != null) goto L4;
        $$$reportNull$$$0(9);
    L4:
        if (r13 != null) goto L6;
        $$$reportNull$$$0(10);
    L6:
        if (r14 != null) goto L8;
        $$$reportNull$$$0(11);
    L8:
        if (r17 != null) goto L10;
        $$$reportNull$$$0(12);
    L10:
        SimpleFunctionDescriptorImpl r19 = super.initialize(r10, r11, r12, r13, r14, r15, r16, r17, r18);
        setOperator(OperatorChecks.INSTANCE.check(r19).isSuccess());
        if (r19 != null) goto L13;
        $$$reportNull$$$0(13);
    L13:
        return r19;
    }

    public void setParameterNamesStatus(boolean r10, boolean r11) {
        this.parameterNamesStatus = ParameterNamesStatus.get(r10, r11);
    }
}
