package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.TransientReceiver;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractReceiverParameterDescriptor extends DeclarationDescriptorImpl implements ReceiverParameterDescriptor {
    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        switch(r10) {
            case 2: goto L4;
            case 3: goto L4;
            case 4: goto L4;
            case 5: goto L4;
            case 6: goto L4;
            case 7: goto L4;
            case 8: goto L4;
            case 9: goto L4;
            default: goto L3;
        };
    L3:
        String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r10) {
            case 2: goto L8;
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L8;
            case 8: goto L8;
            case 9: goto L8;
            default: goto L7;
        };
    L7:
        int r12 = 3;
    L9:
        Object[] r13 = new Object[r12];
        switch(r10) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L12;
            case 4: goto L12;
            case 5: goto L12;
            case 6: goto L12;
            case 7: goto L12;
            case 8: goto L12;
            case 9: goto L12;
            default: goto L11;
        };
    L11:
        r13[0] = "annotations";
    L15:
        switch(r10) {
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L18;
            case 9: goto L17;
            default: goto L16;
        };
    L16:
        r13[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
    L25:
        switch(r10) {
            case 1: goto L27;
            case 2: goto L28;
            case 3: goto L28;
            case 4: goto L28;
            case 5: goto L28;
            case 6: goto L28;
            case 7: goto L28;
            case 8: goto L28;
            case 9: goto L28;
            default: goto L26;
        };
    L26:
        r13[2] = "<init>";
        goto L28
    L27:
        r13[2] = "substitute";
    L28:
        String r14 = String.format(r11, r13);
        switch(r10) {
            case 2: goto L32;
            case 3: goto L32;
            case 4: goto L32;
            case 5: goto L32;
            case 6: goto L32;
            case 7: goto L32;
            case 8: goto L32;
            case 9: goto L32;
            default: goto L33;
        };
    L33:
        throw new IllegalArgumentException(r14);
    L32:
        throw new IllegalStateException(r14);
    L17:
        r13[1] = "getSource";
        goto L25
    L18:
        r13[1] = "getOriginal";
        goto L25
    L19:
        r13[1] = "getVisibility";
        goto L25
    L20:
        r13[1] = "getOverriddenDescriptors";
        goto L25
    L21:
        r13[1] = "getValueParameters";
        goto L25
    L22:
        r13[1] = "getType";
        goto L25
    L23:
        r13[1] = "getTypeParameters";
        goto L25
    L24:
        r13[1] = "getContextReceiverParameters";
        goto L25
    L12:
        r13[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
        goto L15
    L13:
        r13[0] = "substitutor";
        goto L15
    L8:
        r12 = 2;
        goto L9
    L4:
        r11 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    public AbstractReceiverParameterDescriptor(Annotations r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        super(r10, SpecialNames.THIS);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> r10, D r11) {
        return r10.visitReceiverParameterDescriptor(this, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<ReceiverParameterDescriptor> getContextReceiverParameters() {
        List<ReceiverParameterDescriptor> r10 = Collections.emptyList();
        if (r10 != null) goto L5;
        $$$reportNull$$$0(2);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public ParameterDescriptor getOriginal() {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public Collection<? extends CallableDescriptor> getOverriddenDescriptors() {
        Set r10 = Collections.emptySet();
        if (r10 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public KotlinType getReturnType() {
        return getType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        SourceElement r10 = SourceElement.NO_SOURCE;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(9);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueDescriptor
    public KotlinType getType() {
        KotlinType r10 = getValue().getType();
        if (r10 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> r10 = Collections.emptyList();
        if (r10 != null) goto L5;
        $$$reportNull$$$0(3);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> r10) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<ValueParameterDescriptor> getValueParameters() {
        List<ValueParameterDescriptor> r10 = Collections.emptyList();
        if (r10 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility r10 = DescriptorVisibilities.LOCAL;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(7);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor r10) {
        return substitute(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public ReceiverParameterDescriptor substitute(TypeSubstitutor r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(1);
    L5:
        if (r10.isEmpty() == false) goto L8;
        return this;
    L8:
        if ((getContainingDeclaration() instanceof ClassDescriptor) == false) goto L10;
        KotlinType r11 = getType();
        Variance r12 = Variance.OUT_VARIANCE;
    L11:
        KotlinType r13 = r10.substitute(r11, r12);
        if (r13 != null) goto L16;
        return null;
    L16:
        if (r13 != getType()) goto L19;
        return this;
    L19:
        return new ReceiverParameterDescriptorImpl(getContainingDeclaration(), new TransientReceiver(r13), getAnnotations());
    L10:
        r11 = getType();
        r12 = Variance.INVARIANT;
        goto L11
    }
}
