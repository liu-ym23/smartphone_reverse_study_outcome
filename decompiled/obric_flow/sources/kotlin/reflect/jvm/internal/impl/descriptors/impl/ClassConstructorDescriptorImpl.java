package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* JADX INFO: loaded from: classes3.dex */
public class ClassConstructorDescriptorImpl extends FunctionDescriptorImpl implements ClassConstructorDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected final boolean isPrimary;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 21) goto L7;
        if (r10 == 27) goto L7;
        switch(r10) {
            case 15: goto L7;
            case 16: goto L7;
            case 17: goto L7;
            case 18: goto L7;
            case 19: goto L7;
            default: goto L6;
        };
    L6:
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r10 == 21) goto L13;
        if (r10 == 27) goto L53;
        switch(r10) {
            case 15: goto L54;
            case 16: goto L54;
            case 17: goto L54;
            case 18: goto L54;
            case 19: goto L54;
            default: goto L12;
        };
    L12:
        int r11 = 3;
    L14:
        Object[] r12 = new Object[r11];
        switch(r10) {
            case 1: goto L26;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L16;
            case 5: goto L26;
            case 6: goto L24;
            case 7: goto L16;
            case 8: goto L26;
            case 9: goto L24;
            case 10: goto L23;
            case 11: goto L22;
            case 12: goto L21;
            case 13: goto L23;
            case 14: goto L22;
            case 15: goto L20;
            case 16: goto L20;
            case 17: goto L20;
            case 18: goto L20;
            case 19: goto L20;
            case 20: goto L19;
            case 21: goto L20;
            case 22: goto L18;
            case 23: goto L17;
            case 24: goto L25;
            case 25: goto L26;
            case 26: goto L24;
            case 27: goto L20;
            default: goto L16;
        };
    L16:
        r12[0] = "containingDeclaration";
    L28:
        if (r10 == 21) goto L37;
        if (r10 == 27) goto L36;
        switch(r10) {
            case 15: goto L35;
            case 16: goto L35;
            case 17: goto L34;
            case 18: goto L33;
            case 19: goto L32;
            default: goto L31;
        };
    L31:
        r12[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl";
    L38:
        switch(r10) {
            case 4: goto L45;
            case 5: goto L45;
            case 6: goto L45;
            case 7: goto L44;
            case 8: goto L44;
            case 9: goto L44;
            case 10: goto L43;
            case 11: goto L43;
            case 12: goto L43;
            case 13: goto L43;
            case 14: goto L43;
            case 15: goto L46;
            case 16: goto L46;
            case 17: goto L46;
            case 18: goto L46;
            case 19: goto L46;
            case 20: goto L42;
            case 21: goto L46;
            case 22: goto L41;
            case 23: goto L40;
            case 24: goto L40;
            case 25: goto L40;
            case 26: goto L40;
            case 27: goto L46;
            default: goto L39;
        };
    L39:
        r12[2] = "<init>";
        goto L46
    L40:
        r12[2] = "createSubstitutedCopy";
        goto L46
    L41:
        r12[2] = "setOverriddenDescriptors";
        goto L46
    L42:
        r12[2] = "substitute";
        goto L46
    L43:
        r12[2] = "initialize";
        goto L46
    L44:
        r12[2] = "createSynthesized";
        goto L46
    L45:
        r12[2] = "create";
    L46:
        String r13 = String.format(r5, r12);
        if (r10 == 21) goto L52;
        if (r10 == 27) goto L52;
        switch(r10) {
            case 15: goto L52;
            case 16: goto L52;
            case 17: goto L52;
            case 18: goto L52;
            case 19: goto L52;
            default: goto L55;
        };
    L55:
        throw new IllegalArgumentException(r13);
    L52:
        throw new IllegalStateException(r13);
    L32:
        r12[1] = "getOriginal";
        goto L38
    L33:
        r12[1] = "getConstructedClass";
        goto L38
    L34:
        r12[1] = "getContainingDeclaration";
        goto L38
    L35:
        r12[1] = "calculateContextReceiverParameters";
        goto L38
    L36:
        r12[1] = "copy";
        goto L38
    L37:
        r12[1] = "getOverriddenDescriptors";
        goto L38
    L17:
        r12[0] = "newOwner";
        goto L28
    L18:
        r12[0] = "overriddenDescriptors";
        goto L28
    L19:
        r12[0] = "originalSubstitutor";
        goto L28
    L20:
        r12[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl";
        goto L28
    L21:
        r12[0] = "typeParameterDescriptors";
        goto L28
    L22:
        r12[0] = "visibility";
        goto L28
    L23:
        r12[0] = "unsubstitutedValueParameters";
        goto L28
    L24:
        r12[0] = "source";
        goto L28
    L25:
        r12[0] = "kind";
        goto L28
    L26:
        r12[0] = "annotations";
        goto L28
    L54:
        r11 = 2;
        goto L14
    L53:
        r11 = 2;
        goto L14
    L13:
        r11 = 2;
    L7:
        r5 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    public ClassConstructorDescriptorImpl(ClassDescriptor r10, ConstructorDescriptor r11, Annotations r12, boolean r13, CallableMemberDescriptor.Kind r14, SourceElement r15) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r12 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r14 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r15 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        super(r10, r11, r12, SpecialNames.INIT, r14, r15);
        this.isPrimary = r13;
    }

    private List<ReceiverParameterDescriptor> calculateContextReceiverParameters() {
        ClassDescriptor r5 = getContainingDeclaration();
        if (r5.getContextReceivers().isEmpty() == true) goto L8;
        List<ReceiverParameterDescriptor> r10 = r5.getContextReceivers();
        if (r10 != null) goto L7;
        $$$reportNull$$$0(15);
    L7:
        return r10;
    L8:
        List<ReceiverParameterDescriptor> r11 = Collections.emptyList();
        if (r11 != null) goto L11;
        $$$reportNull$$$0(16);
    L11:
        return r11;
    }

    public static ClassConstructorDescriptorImpl create(ClassDescriptor r10, Annotations r11, boolean r12, SourceElement r13) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(4);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(5);
    L6:
        if (r13 != null) goto L9;
        $$$reportNull$$$0(6);
    L9:
        return new ClassConstructorDescriptorImpl(r10, null, r11, r12, CallableMemberDescriptor.Kind.DECLARATION, r13);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> r5, D r10) {
        return r5.visitConstructorDescriptor(this, r10);
    }

    public ReceiverParameterDescriptor calculateDispatchReceiverParameter() {
        ClassDescriptor r5 = getContainingDeclaration();
        if (r5.isInner() == false) goto L8;
        DeclarationDescriptor r10 = r5.getContainingDeclaration();
        if ((r10 instanceof ClassDescriptor) == true) goto L7;
        return null;
    L7:
        return ((ClassDescriptor) r10).getThisAsReceiverParameter();
    L8:
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor copy(DeclarationDescriptor r5, Modality r10, DescriptorVisibility r11, CallableMemberDescriptor.Kind r12, boolean r13) {
        return copy(r5, r10, r11, r12, r13);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public /* bridge */ /* synthetic */ FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r5, FunctionDescriptor r10, CallableMemberDescriptor.Kind r11, Name r12, Annotations r13, SourceElement r14) {
        return createSubstitutedCopy(r5, r10, r11, r12, r13, r14);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
    public ClassDescriptor getConstructedClass() {
        ClassDescriptor r5 = getContainingDeclaration();
        if (r5 != null) goto L5;
        $$$reportNull$$$0(18);
    L5:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ ClassifierDescriptorWithTypeParameters getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public Collection<? extends FunctionDescriptor> getOverriddenDescriptors() {
        Set r5 = Collections.emptySet();
        if (r5 != null) goto L5;
        $$$reportNull$$$0(21);
    L5:
        return r5;
    }

    public ClassConstructorDescriptorImpl initialize(List<ValueParameterDescriptor> r11, DescriptorVisibility r12, List<TypeParameterDescriptor> r13) {
        if (r11 != null) goto L4;
        $$$reportNull$$$0(10);
    L4:
        if (r12 != null) goto L6;
        $$$reportNull$$$0(11);
    L6:
        if (r13 != null) goto L8;
        $$$reportNull$$$0(12);
    L8:
        super.initialize(null, calculateDispatchReceiverParameter(), calculateContextReceiverParameters(), r13, r11, null, Modality.FINAL, r12);
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
    public boolean isPrimary() {
        return this.isPrimary;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(22);
        return;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ ConstructorDescriptor substitute(TypeSubstitutor r5) {
        return substitute(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public /* bridge */ /* synthetic */ FunctionDescriptor copy(DeclarationDescriptor r5, Modality r10, DescriptorVisibility r11, CallableMemberDescriptor.Kind r12, boolean r13) {
        return copy(r5, r10, r11, r12, r13);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public ClassConstructorDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r10, FunctionDescriptor r11, CallableMemberDescriptor.Kind r12, Name r13, Annotations r14, SourceElement r15) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(23);
    L4:
        if (r12 != null) goto L6;
        $$$reportNull$$$0(24);
    L6:
        if (r14 != null) goto L8;
        $$$reportNull$$$0(25);
    L8:
        if (r15 != null) goto L10;
        $$$reportNull$$$0(26);
    L10:
        CallableMemberDescriptor.Kind r5 = CallableMemberDescriptor.Kind.DECLARATION;
        if (r12 == r5) goto L18;
        if (r12 == CallableMemberDescriptor.Kind.SYNTHESIZED) goto L18;
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + r10 + "\nkind: " + r12);
    L18:
        return new ClassConstructorDescriptorImpl((ClassDescriptor) r10, this, r14, this.isPrimary, r5, r15);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor r5) {
        return substitute(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public ClassConstructorDescriptor copy(DeclarationDescriptor r5, Modality r10, DescriptorVisibility r11, CallableMemberDescriptor.Kind r12, boolean r13) {
        ClassConstructorDescriptor r14 = (ClassConstructorDescriptor) super.copy(r5, r10, r11, r12, r13);
        if (r14 != null) goto L5;
        $$$reportNull$$$0(27);
    L5:
        return r14;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public ClassDescriptor getContainingDeclaration() {
        ClassDescriptor r5 = (ClassDescriptor) super.getContainingDeclaration();
        if (r5 != null) goto L5;
        $$$reportNull$$$0(17);
    L5:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    public ClassConstructorDescriptorImpl initialize(List<ValueParameterDescriptor> r5, DescriptorVisibility r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(13);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(14);
    L6:
        initialize(r5, r10, getContainingDeclaration().getDeclaredTypeParameters());
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ FunctionDescriptor substitute(TypeSubstitutor r5) {
        return substitute(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptorWithSource getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public ClassConstructorDescriptor substitute(TypeSubstitutor r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(20);
    L5:
        return (ClassConstructorDescriptor) super.substitute(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ FunctionDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public ClassConstructorDescriptor getOriginal() {
        ClassConstructorDescriptor r5 = (ClassConstructorDescriptor) super.getOriginal();
        if (r5 != null) goto L5;
        $$$reportNull$$$0(19);
    L5:
        return r5;
    }
}
