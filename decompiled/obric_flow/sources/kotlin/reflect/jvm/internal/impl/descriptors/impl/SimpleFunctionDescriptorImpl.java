package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public class SimpleFunctionDescriptorImpl extends FunctionDescriptorImpl implements SimpleFunctionDescriptor {
    private static /* synthetic */ void $$$reportNull$$$0(int r12) {
        if (r12 == 13) goto L10;
        if (r12 == 18) goto L10;
        if (r12 == 23) goto L10;
        if (r12 == 24) goto L10;
        if (r12 == 29) goto L10;
        if (r12 == 30) goto L10;
        String r10 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L12:
        if (r12 == 13) goto L19;
        if (r12 == 18) goto L19;
        if (r12 == 23) goto L19;
        if (r12 == 24) goto L19;
        if (r12 == 29) goto L19;
        if (r12 == 30) goto L19;
        int r11 = 3;
    L20:
        Object[] r13 = new Object[r11];
        switch(r12) {
            case 1: goto L32;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L29;
            case 5: goto L22;
            case 6: goto L32;
            case 7: goto L31;
            case 8: goto L30;
            case 9: goto L29;
            case 10: goto L28;
            case 11: goto L27;
            case 12: goto L26;
            case 13: goto L25;
            case 14: goto L24;
            case 15: goto L28;
            case 16: goto L27;
            case 17: goto L26;
            case 18: goto L25;
            case 19: goto L24;
            case 20: goto L28;
            case 21: goto L27;
            case 22: goto L26;
            case 23: goto L25;
            case 24: goto L25;
            case 25: goto L23;
            case 26: goto L30;
            case 27: goto L32;
            case 28: goto L29;
            case 29: goto L25;
            case 30: goto L25;
            default: goto L22;
        };
    L22:
        r13[0] = "containingDeclaration";
    L34:
        if (r12 == 13) goto L44;
        if (r12 == 18) goto L44;
        if (r12 == 23) goto L44;
        if (r12 == 24) goto L43;
        if (r12 == 29) goto L42;
        if (r12 == 30) goto L41;
        r13[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
    L45:
        switch(r12) {
            case 5: goto L49;
            case 6: goto L49;
            case 7: goto L49;
            case 8: goto L49;
            case 9: goto L49;
            case 10: goto L48;
            case 11: goto L48;
            case 12: goto L48;
            case 13: goto L50;
            case 14: goto L48;
            case 15: goto L48;
            case 16: goto L48;
            case 17: goto L48;
            case 18: goto L50;
            case 19: goto L48;
            case 20: goto L48;
            case 21: goto L48;
            case 22: goto L48;
            case 23: goto L50;
            case 24: goto L50;
            case 25: goto L47;
            case 26: goto L47;
            case 27: goto L47;
            case 28: goto L47;
            case 29: goto L50;
            case 30: goto L50;
            default: goto L46;
        };
    L46:
        r13[2] = "<init>";
        goto L50
    L47:
        r13[2] = "createSubstitutedCopy";
        goto L50
    L48:
        r13[2] = "initialize";
        goto L50
    L49:
        r13[2] = "create";
    L50:
        String r14 = String.format(r10, r13);
        if (r12 == 13) goto L59;
        if (r12 == 18) goto L59;
        if (r12 == 23) goto L59;
        if (r12 == 24) goto L59;
        if (r12 == 29) goto L59;
        if (r12 == 30) goto L59;
        throw new IllegalArgumentException(r14);
    L59:
        throw new IllegalStateException(r14);
    L41:
        r13[1] = "newCopyBuilder";
        goto L45
    L42:
        r13[1] = "copy";
        goto L45
    L43:
        r13[1] = "getOriginal";
    L44:
        r13[1] = "initialize";
        goto L45
    L23:
        r13[0] = "newOwner";
        goto L34
    L24:
        r13[0] = "contextReceiverParameters";
        goto L34
    L25:
        r13[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
        goto L34
    L26:
        r13[0] = "visibility";
        goto L34
    L27:
        r13[0] = "unsubstitutedValueParameters";
        goto L34
    L28:
        r13[0] = "typeParameters";
        goto L34
    L29:
        r13[0] = "source";
        goto L34
    L30:
        r13[0] = "kind";
        goto L34
    L31:
        r13[0] = "name";
        goto L34
    L32:
        r13[0] = "annotations";
    L19:
        r11 = 2;
    L10:
        r10 = "@NotNull method %s.%s must not return null";
        goto L12
    }

    public SimpleFunctionDescriptorImpl(DeclarationDescriptor r5, SimpleFunctionDescriptor r10, Annotations r11, Name r12, CallableMemberDescriptor.Kind r13, SourceElement r14) {
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
    }

    public static SimpleFunctionDescriptorImpl create(DeclarationDescriptor r10, Annotations r11, Name r12, CallableMemberDescriptor.Kind r13, SourceElement r14) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(5);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(6);
    L6:
        if (r12 != null) goto L8;
        $$$reportNull$$$0(7);
    L8:
        if (r13 != null) goto L10;
        $$$reportNull$$$0(8);
    L10:
        if (r14 != null) goto L13;
        $$$reportNull$$$0(9);
    L13:
        return new SimpleFunctionDescriptorImpl(r10, null, r11, r12, r13, r14);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor copy(DeclarationDescriptor r5, Modality r10, DescriptorVisibility r11, CallableMemberDescriptor.Kind r12, boolean r13) {
        return copy(r5, r10, r11, r12, r13);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r10, FunctionDescriptor r11, CallableMemberDescriptor.Kind r12, Name r13, Annotations r14, SourceElement r15) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(25);
    L4:
        if (r12 != null) goto L6;
        $$$reportNull$$$0(26);
    L6:
        if (r14 != null) goto L8;
        $$$reportNull$$$0(27);
    L8:
        if (r15 != null) goto L10;
        $$$reportNull$$$0(28);
    L10:
        SimpleFunctionDescriptor r5 = (SimpleFunctionDescriptor) r11;
        if (r13 != null) goto L15;
        r13 = getName();
    L15:
        return new SimpleFunctionDescriptorImpl(r10, r5, r14, r13, r12, r15);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public /* bridge */ /* synthetic */ FunctionDescriptorImpl initialize(ReceiverParameterDescriptor r5, ReceiverParameterDescriptor r10, List r11, List r12, List r13, KotlinType r14, Modality r15, DescriptorVisibility r16) {
        return initialize(r5, r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder() {
        FunctionDescriptor.CopyBuilder r5 = super.newCopyBuilder();
        if (r5 != null) goto L5;
        $$$reportNull$$$0(30);
    L5:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public /* bridge */ /* synthetic */ FunctionDescriptor copy(DeclarationDescriptor r5, Modality r10, DescriptorVisibility r11, CallableMemberDescriptor.Kind r12, boolean r13) {
        return copy(r5, r10, r11, r12, r13);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public SimpleFunctionDescriptorImpl initialize(ReceiverParameterDescriptor r11, ReceiverParameterDescriptor r12, List<ReceiverParameterDescriptor> r13, List<? extends TypeParameterDescriptor> r14, List<ValueParameterDescriptor> r15, KotlinType r16, Modality r17, DescriptorVisibility r18) {
        if (r13 != null) goto L4;
        $$$reportNull$$$0(14);
    L4:
        if (r14 != null) goto L6;
        $$$reportNull$$$0(15);
    L6:
        if (r15 != null) goto L8;
        $$$reportNull$$$0(16);
    L8:
        if (r18 != null) goto L10;
        $$$reportNull$$$0(17);
    L10:
        SimpleFunctionDescriptorImpl r5 = initialize(r11, r12, r13, r14, r15, r16, r17, r18, null);
        if (r5 != null) goto L13;
        $$$reportNull$$$0(18);
    L13:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public SimpleFunctionDescriptor copy(DeclarationDescriptor r5, Modality r10, DescriptorVisibility r11, CallableMemberDescriptor.Kind r12, boolean r13) {
        SimpleFunctionDescriptor r14 = (SimpleFunctionDescriptor) super.copy(r5, r10, r11, r12, r13);
        if (r14 != null) goto L5;
        $$$reportNull$$$0(29);
    L5:
        return r14;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    public SimpleFunctionDescriptorImpl initialize(ReceiverParameterDescriptor r5, ReceiverParameterDescriptor r10, List<ReceiverParameterDescriptor> r11, List<? extends TypeParameterDescriptor> r12, List<ValueParameterDescriptor> r13, KotlinType r14, Modality r15, DescriptorVisibility r16, Map<? extends CallableDescriptor.UserDataKey<?>, ?> r17) {
        if (r11 != null) goto L4;
        $$$reportNull$$$0(19);
    L4:
        if (r12 != null) goto L6;
        $$$reportNull$$$0(20);
    L6:
        if (r13 != null) goto L8;
        $$$reportNull$$$0(21);
    L8:
        if (r16 != null) goto L10;
        $$$reportNull$$$0(22);
    L10:
        super.initialize(r5, r10, r11, r12, r13, r14, r15, r16);
        if (r17 != null) goto L13;
    L15:
        return this;
    L13:
        if (r17.isEmpty() == true) goto L15;
        this.userDataMap = new LinkedHashMap(r17);
        goto L15
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptorWithSource getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ FunctionDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public SimpleFunctionDescriptor getOriginal() {
        SimpleFunctionDescriptor r5 = (SimpleFunctionDescriptor) super.getOriginal();
        if (r5 != null) goto L5;
        $$$reportNull$$$0(24);
    L5:
        return r5;
    }
}
