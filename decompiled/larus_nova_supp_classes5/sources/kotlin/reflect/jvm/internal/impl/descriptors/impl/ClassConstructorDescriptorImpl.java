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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class ClassConstructorDescriptorImpl extends FunctionDescriptorImpl implements ClassConstructorDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected final boolean isPrimary;

    private static /* synthetic */ void $$$reportNull$$$0(int r8) {
        if (r8 == 21) goto L7;
        if (r8 == 27) goto L7;
        switch(r8) {
            case 15: goto L7;
            case 16: goto L7;
            case 17: goto L7;
            case 18: goto L7;
            case 19: goto L7;
            default: goto L6;
        };
    L6:
        String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r8 == 21) goto L13;
        if (r8 == 27) goto L13;
        switch(r8) {
            case 15: goto L13;
            case 16: goto L13;
            case 17: goto L13;
            case 18: goto L13;
            case 19: goto L13;
            default: goto L12;
        };
    L12:
        int r4 = 3;
    L14:
        Object[] r5 = new Object[r4];
        switch(r8) {
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
        r5[0] = "containingDeclaration";
    L28:
        if (r8 == 21) goto L37;
        if (r8 == 27) goto L36;
        switch(r8) {
            case 15: goto L35;
            case 16: goto L35;
            case 17: goto L34;
            case 18: goto L33;
            case 19: goto L32;
            default: goto L31;
        };
    L31:
        r5[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl";
    L38:
        switch(r8) {
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
        r5[2] = "<init>";
        goto L46
    L40:
        r5[2] = "createSubstitutedCopy";
        goto L46
    L41:
        r5[2] = "setOverriddenDescriptors";
        goto L46
    L42:
        r5[2] = "substitute";
        goto L46
    L43:
        r5[2] = "initialize";
        goto L46
    L44:
        r5[2] = "createSynthesized";
        goto L46
    L45:
        r5[2] = "create";
    L46:
        String r3 = String.format(r2, r5);
        if (r8 == 21) goto L52;
        if (r8 == 27) goto L52;
        switch(r8) {
            case 15: goto L52;
            case 16: goto L52;
            case 17: goto L52;
            case 18: goto L52;
            case 19: goto L52;
            default: goto L53;
        };
    L53:
        throw new IllegalArgumentException(r3);
    L52:
        throw new IllegalStateException(r3);
    L32:
        r5[1] = "getOriginal";
        goto L38
    L33:
        r5[1] = "getConstructedClass";
        goto L38
    L34:
        r5[1] = "getContainingDeclaration";
        goto L38
    L35:
        r5[1] = "calculateContextReceiverParameters";
        goto L38
    L36:
        r5[1] = "copy";
        goto L38
    L37:
        r5[1] = "getOverriddenDescriptors";
        goto L38
    L17:
        r5[0] = "newOwner";
        goto L28
    L18:
        r5[0] = "overriddenDescriptors";
        goto L28
    L19:
        r5[0] = "originalSubstitutor";
        goto L28
    L20:
        r5[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl";
        goto L28
    L21:
        r5[0] = "typeParameterDescriptors";
        goto L28
    L22:
        r5[0] = "visibility";
        goto L28
    L23:
        r5[0] = "unsubstitutedValueParameters";
        goto L28
    L24:
        r5[0] = "source";
        goto L28
    L25:
        r5[0] = "kind";
        goto L28
    L26:
        r5[0] = "annotations";
    L13:
        r4 = 2;
    L7:
        r2 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(22);
        return;
    }

    private List<ReceiverParameterDescriptor> calculateContextReceiverParameters() {
        ClassDescriptor r0 = getContainingDeclaration();
        if (r0.getContextReceivers().isEmpty() == true) goto L8;
        List<ReceiverParameterDescriptor> r1 = r0.getContextReceivers();
        if (r1 != null) goto L7;
        $$$reportNull$$$0(15);
    L7:
        return r1;
    L8:
        List<ReceiverParameterDescriptor> r2 = Collections.emptyList();
        if (r2 != null) goto L11;
        $$$reportNull$$$0(16);
    L11:
        return r2;
    }

    public ReceiverParameterDescriptor calculateDispatchReceiverParameter() {
        ClassDescriptor r0 = getContainingDeclaration();
        if (r0.isInner() == false) goto L8;
        DeclarationDescriptor r1 = r0.getContainingDeclaration();
        if ((r1 instanceof ClassDescriptor) == true) goto L7;
        return null;
    L7:
        return ((ClassDescriptor) r1).getThisAsReceiverParameter();
    L8:
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
    public ClassDescriptor getConstructedClass() {
        ClassDescriptor r0 = getContainingDeclaration();
        if (r0 != null) goto L5;
        $$$reportNull$$$0(18);
    L5:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public ClassDescriptor getContainingDeclaration() {
        ClassDescriptor r0 = (ClassDescriptor) super.getContainingDeclaration();
        if (r0 != null) goto L5;
        $$$reportNull$$$0(17);
    L5:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public ClassConstructorDescriptor getOriginal() {
        ClassConstructorDescriptor r0 = (ClassConstructorDescriptor) super.getOriginal();
        if (r0 != null) goto L5;
        $$$reportNull$$$0(19);
    L5:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public Collection<? extends FunctionDescriptor> getOverriddenDescriptors() {
        Set r0 = Collections.emptySet();
        if (r0 != null) goto L5;
        $$$reportNull$$$0(21);
    L5:
        return r0;
    }

    static {
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
    public boolean isPrimary() {
        return this.isPrimary;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ ClassifierDescriptorWithTypeParameters getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor getOriginal() {
        return getOriginal();
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

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public ClassConstructorDescriptor substitute(TypeSubstitutor r2) {
        if (r2 != null) goto L5;
        $$$reportNull$$$0(20);
    L5:
        return (ClassConstructorDescriptor) super.substitute(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ ConstructorDescriptor substitute(TypeSubstitutor r1) {
        return substitute(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor r1) {
        return substitute(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ FunctionDescriptor substitute(TypeSubstitutor r1) {
        return substitute(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> r1, D r2) {
        return r1.visitConstructorDescriptor(this, r2);
    }

    public ClassConstructorDescriptorImpl initialize(List<ValueParameterDescriptor> r2, DescriptorVisibility r3) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(13);
    L4:
        if (r3 != null) goto L6;
        $$$reportNull$$$0(14);
    L6:
        initialize(r2, r3, getContainingDeclaration().getDeclaredTypeParameters());
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

    public static ClassConstructorDescriptorImpl create(ClassDescriptor r8, Annotations r9, boolean r10, SourceElement r11) {
        if (r8 != null) goto L4;
        $$$reportNull$$$0(4);
    L4:
        if (r9 != null) goto L6;
        $$$reportNull$$$0(5);
    L6:
        if (r11 != null) goto L9;
        $$$reportNull$$$0(6);
    L9:
        return new ClassConstructorDescriptorImpl(r8, null, r9, r10, CallableMemberDescriptor.Kind.DECLARATION, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public ClassConstructorDescriptor copy(DeclarationDescriptor r1, Modality r2, DescriptorVisibility r3, CallableMemberDescriptor.Kind r4, boolean r5) {
        ClassConstructorDescriptor r6 = (ClassConstructorDescriptor) super.copy(r1, r2, r3, r4, r5);
        if (r6 != null) goto L5;
        $$$reportNull$$$0(27);
    L5:
        return r6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor copy(DeclarationDescriptor r1, Modality r2, DescriptorVisibility r3, CallableMemberDescriptor.Kind r4, boolean r5) {
        return copy(r1, r2, r3, r4, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public /* bridge */ /* synthetic */ FunctionDescriptor copy(DeclarationDescriptor r1, Modality r2, DescriptorVisibility r3, CallableMemberDescriptor.Kind r4, boolean r5) {
        return copy(r1, r2, r3, r4, r5);
    }

    public ClassConstructorDescriptorImpl(ClassDescriptor r9, ConstructorDescriptor r10, Annotations r11, boolean r12, CallableMemberDescriptor.Kind r13, SourceElement r14) {
        if (r9 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r13 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r14 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        super(r9, r10, r11, SpecialNames.INIT, r13, r14);
        this.isPrimary = r12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public ClassConstructorDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r8, FunctionDescriptor r9, CallableMemberDescriptor.Kind r10, Name r11, Annotations r12, SourceElement r13) {
        if (r8 != null) goto L4;
        $$$reportNull$$$0(23);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(24);
    L6:
        if (r12 != null) goto L8;
        $$$reportNull$$$0(25);
    L8:
        if (r13 != null) goto L10;
        $$$reportNull$$$0(26);
    L10:
        CallableMemberDescriptor.Kind r5 = CallableMemberDescriptor.Kind.DECLARATION;
        if (r10 == r5) goto L18;
        if (r10 == CallableMemberDescriptor.Kind.SYNTHESIZED) goto L18;
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + r8 + "\nkind: " + r10);
    L18:
        return new ClassConstructorDescriptorImpl((ClassDescriptor) r8, this, r12, this.isPrimary, r5, r13);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public /* bridge */ /* synthetic */ FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r1, FunctionDescriptor r2, CallableMemberDescriptor.Kind r3, Name r4, Annotations r5, SourceElement r6) {
        return createSubstitutedCopy(r1, r2, r3, r4, r5, r6);
    }
}
