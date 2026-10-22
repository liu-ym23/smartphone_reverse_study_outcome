package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
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
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.TransientReceiver;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class AbstractReceiverParameterDescriptor extends DeclarationDescriptorImpl implements ReceiverParameterDescriptor {
    private static /* synthetic */ void $$$reportNull$$$0(int r6) {
        switch(r6) {
            case 4: goto L4;
            case 5: goto L4;
            case 6: goto L4;
            case 7: goto L4;
            case 8: goto L4;
            case 9: goto L4;
            case 10: goto L4;
            case 11: goto L4;
            default: goto L3;
        };
    L3:
        String r0 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r6) {
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L8;
            case 8: goto L8;
            case 9: goto L8;
            case 10: goto L8;
            case 11: goto L8;
            default: goto L7;
        };
    L7:
        int r2 = 3;
    L9:
        Object[] r3 = new Object[r2];
        switch(r6) {
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L12;
            case 6: goto L12;
            case 7: goto L12;
            case 8: goto L12;
            case 9: goto L12;
            case 10: goto L12;
            case 11: goto L12;
            default: goto L11;
        };
    L11:
        r3[0] = "annotations";
    L16:
        switch(r6) {
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L22;
            case 8: goto L21;
            case 9: goto L20;
            case 10: goto L19;
            case 11: goto L18;
            default: goto L17;
        };
    L17:
        r3[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
    L26:
        switch(r6) {
            case 3: goto L28;
            case 4: goto L29;
            case 5: goto L29;
            case 6: goto L29;
            case 7: goto L29;
            case 8: goto L29;
            case 9: goto L29;
            case 10: goto L29;
            case 11: goto L29;
            default: goto L27;
        };
    L27:
        r3[2] = "<init>";
        goto L29
    L28:
        r3[2] = "substitute";
    L29:
        String r1 = String.format(r0, r3);
        switch(r6) {
            case 4: goto L33;
            case 5: goto L33;
            case 6: goto L33;
            case 7: goto L33;
            case 8: goto L33;
            case 9: goto L33;
            case 10: goto L33;
            case 11: goto L33;
            default: goto L34;
        };
    L34:
        throw new IllegalArgumentException(r1);
    L33:
        throw new IllegalStateException(r1);
    L18:
        r3[1] = "getSource";
        goto L26
    L19:
        r3[1] = "getOriginal";
        goto L26
    L20:
        r3[1] = "getVisibility";
        goto L26
    L21:
        r3[1] = "getOverriddenDescriptors";
        goto L26
    L22:
        r3[1] = "getValueParameters";
        goto L26
    L23:
        r3[1] = "getType";
        goto L26
    L24:
        r3[1] = "getTypeParameters";
        goto L26
    L25:
        r3[1] = "getContextReceiverParameters";
        goto L26
    L12:
        r3[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
        goto L16
    L13:
        r3[0] = "substitutor";
        goto L16
    L14:
        r3[0] = DBDefinition.NAME;
        goto L16
    L8:
        r2 = 2;
        goto L9
    L4:
        r0 = "@NotNull method %s.%s must not return null";
        goto L6
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
    public ParameterDescriptor getOriginal() {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> r1) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        SourceElement r0 = SourceElement.NO_SOURCE;
        if (r0 != null) goto L5;
        $$$reportNull$$$0(11);
    L5:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility r0 = DescriptorVisibilities.LOCAL;
        if (r0 != null) goto L5;
        $$$reportNull$$$0(9);
    L5:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<ReceiverParameterDescriptor> getContextReceiverParameters() {
        List<ReceiverParameterDescriptor> r0 = Collections.emptyList();
        if (r0 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public Collection<? extends CallableDescriptor> getOverriddenDescriptors() {
        Set r0 = Collections.emptySet();
        if (r0 != null) goto L5;
        $$$reportNull$$$0(8);
    L5:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public KotlinType getReturnType() {
        return getType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueDescriptor
    public KotlinType getType() {
        KotlinType r0 = getValue().getType();
        if (r0 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> r0 = Collections.emptyList();
        if (r0 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<ValueParameterDescriptor> getValueParameters() {
        List<ValueParameterDescriptor> r0 = Collections.emptyList();
        if (r0 != null) goto L5;
        $$$reportNull$$$0(7);
    L5:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    public AbstractReceiverParameterDescriptor(Annotations r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        super(r2, SpecialNames.THIS);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public ReceiverParameterDescriptor substitute(TypeSubstitutor r4) {
        if (r4 != null) goto L5;
        $$$reportNull$$$0(3);
    L5:
        if (r4.isEmpty() == false) goto L8;
        return this;
    L8:
        if ((getContainingDeclaration() instanceof ClassDescriptor) == false) goto L10;
        KotlinType r5 = r4.substitute(getType(), Variance.OUT_VARIANCE);
    L11:
        if (r5 != null) goto L15;
        return null;
    L15:
        if (r5 != getType()) goto L18;
        return this;
    L18:
        return new ReceiverParameterDescriptorImpl(getContainingDeclaration(), new TransientReceiver(r5), getAnnotations());
    L10:
        r5 = r4.substitute(getType(), Variance.INVARIANT);
        goto L11
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor r1) {
        return substitute(r1);
    }

    public AbstractReceiverParameterDescriptor(Annotations r2, Name r3) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(1);
    L4:
        if (r3 != null) goto L6;
        $$$reportNull$$$0(2);
    L6:
        super(r2, r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> r1, D r2) {
        return r1.visitReceiverParameterDescriptor(this, r2);
    }
}
