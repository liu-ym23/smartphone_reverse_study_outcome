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
        String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
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
        int r12 = 3;
    L14:
        Object[] r13 = new Object[r12];
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
        r13[0] = "containingDeclaration";
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
        r13[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl";
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
        r13[2] = "<init>";
        goto L46
    L40:
        r13[2] = "createSubstitutedCopy";
        goto L46
    L41:
        r13[2] = "setOverriddenDescriptors";
        goto L46
    L42:
        r13[2] = "substitute";
        goto L46
    L43:
        r13[2] = "initialize";
        goto L46
    L44:
        r13[2] = "createSynthesized";
        goto L46
    L45:
        r13[2] = "create";
    L46:
        String r14 = String.format(r11, r13);
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
        throw new IllegalArgumentException(r14);
    L52:
        throw new IllegalStateException(r14);
    L32:
        r13[1] = "getOriginal";
        goto L38
    L33:
        r13[1] = "getConstructedClass";
        goto L38
    L34:
        r13[1] = "getContainingDeclaration";
        goto L38
    L35:
        r13[1] = "calculateContextReceiverParameters";
        goto L38
    L36:
        r13[1] = "copy";
        goto L38
    L37:
        r13[1] = "getOverriddenDescriptors";
        goto L38
    L17:
        r13[0] = "newOwner";
        goto L28
    L18:
        r13[0] = "overriddenDescriptors";
        goto L28
    L19:
        r13[0] = "originalSubstitutor";
        goto L28
    L20:
        r13[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl";
        goto L28
    L21:
        r13[0] = "typeParameterDescriptors";
        goto L28
    L22:
        r13[0] = "visibility";
        goto L28
    L23:
        r13[0] = "unsubstitutedValueParameters";
        goto L28
    L24:
        r13[0] = "source";
        goto L28
    L25:
        r13[0] = "kind";
        goto L28
    L26:
        r13[0] = "annotations";
        goto L28
    L54:
        r12 = 2;
        goto L14
    L53:
        r12 = 2;
        goto L14
    L13:
        r12 = 2;
    L7:
        r11 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    static {
    }

    protected ClassConstructorDescriptorImpl(ClassDescriptor r10, ConstructorDescriptor r11, Annotations r12, boolean r13, CallableMemberDescriptor.Kind r14, SourceElement r15) {
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
        ClassDescriptor r10 = getContainingDeclaration();
        if (r10.getContextReceivers().isEmpty() == true) goto L8;
        List<ReceiverParameterDescriptor> r11 = r10.getContextReceivers();
        if (r11 != null) goto L7;
        $$$reportNull$$$0(15);
    L7:
        return r11;
    L8:
        List<ReceiverParameterDescriptor> r12 = Collections.emptyList();
        if (r12 != null) goto L11;
        $$$reportNull$$$0(16);
    L11:
        return r12;
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
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> r10, D r11) {
        return r10.visitConstructorDescriptor(this, r11);
    }

    public ReceiverParameterDescriptor calculateDispatchReceiverParameter() {
        ClassDescriptor r10 = getContainingDeclaration();
        if (r10.isInner() == false) goto L8;
        DeclarationDescriptor r11 = r10.getContainingDeclaration();
        if ((r11 instanceof ClassDescriptor) == true) goto L7;
        return null;
    L7:
        return ((ClassDescriptor) r11).getThisAsReceiverParameter();
    L8:
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor copy(DeclarationDescriptor r10, Modality r11, DescriptorVisibility r12, CallableMemberDescriptor.Kind r13, boolean r14) {
        return copy(r10, r11, r12, r13, r14);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public ClassConstructorDescriptor copy(DeclarationDescriptor r10, Modality r11, DescriptorVisibility r12, CallableMemberDescriptor.Kind r13, boolean r14) {
        ClassConstructorDescriptor r15 = (ClassConstructorDescriptor) super.copy(r10, r11, r12, r13, r14);
        if (r15 != null) goto L5;
        $$$reportNull$$$0(27);
    L5:
        return r15;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public /* bridge */ /* synthetic */ FunctionDescriptor copy(DeclarationDescriptor r10, Modality r11, DescriptorVisibility r12, CallableMemberDescriptor.Kind r13, boolean r14) {
        return copy(r10, r11, r12, r13, r14);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    protected ClassConstructorDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r10, FunctionDescriptor r11, CallableMemberDescriptor.Kind r12, Name r13, Annotations r14, SourceElement r15) {
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
        CallableMemberDescriptor.Kind r16 = CallableMemberDescriptor.Kind.DECLARATION;
        if (r12 == r16) goto L18;
        if (r12 == CallableMemberDescriptor.Kind.SYNTHESIZED) goto L18;
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + r10 + "\nkind: " + r12);
    L18:
        return new ClassConstructorDescriptorImpl((ClassDescriptor) r10, this, r14, this.isPrimary, r16, r15);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    protected /* bridge */ /* synthetic */ FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r10, FunctionDescriptor r11, CallableMemberDescriptor.Kind r12, Name r13, Annotations r14, SourceElement r15) {
        return createSubstitutedCopy(r10, r11, r12, r13, r14, r15);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
    public ClassDescriptor getConstructedClass() {
        ClassDescriptor r10 = getContainingDeclaration();
        if (r10 != null) goto L5;
        $$$reportNull$$$0(18);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public ClassDescriptor getContainingDeclaration() {
        ClassDescriptor r10 = (ClassDescriptor) super.getContainingDeclaration();
        if (r10 != null) goto L5;
        $$$reportNull$$$0(17);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ ClassifierDescriptorWithTypeParameters getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public ClassConstructorDescriptor getOriginal() {
        ClassConstructorDescriptor r10 = (ClassConstructorDescriptor) super.getOriginal();
        if (r10 != null) goto L5;
        $$$reportNull$$$0(19);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptorWithSource getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ FunctionDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public Collection<? extends FunctionDescriptor> getOverriddenDescriptors() {
        Set r10 = Collections.emptySet();
        if (r10 != null) goto L5;
        $$$reportNull$$$0(21);
    L5:
        return r10;
    }

    public ClassConstructorDescriptorImpl initialize(List<ValueParameterDescriptor> r10, DescriptorVisibility r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(13);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(14);
    L6:
        initialize(r10, r11, getContainingDeclaration().getDeclaredTypeParameters());
        return this;
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
    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(22);
        return;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public ClassConstructorDescriptor substitute(TypeSubstitutor r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(20);
    L5:
        return (ClassConstructorDescriptor) super.substitute(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ ConstructorDescriptor substitute(TypeSubstitutor r10) {
        return substitute(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor r10) {
        return substitute(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ FunctionDescriptor substitute(TypeSubstitutor r10) {
        return substitute(r10);
    }
}
