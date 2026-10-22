package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public class PropertyGetterDescriptorImpl extends PropertyAccessorDescriptorImpl implements PropertyGetterDescriptor {
    private final PropertyGetterDescriptor original;
    private KotlinType returnType;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 6) goto L7;
        if (r10 == 7) goto L7;
        if (r10 == 8) goto L7;
        String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r10 == 6) goto L13;
        if (r10 == 7) goto L13;
        if (r10 == 8) goto L13;
        int r12 = 3;
    L14:
        Object[] r13 = new Object[r12];
        switch(r10) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L17;
            case 8: goto L17;
            default: goto L16;
        };
    L16:
        r13[0] = "correspondingProperty";
    L24:
        if (r10 == 6) goto L30;
        if (r10 == 7) goto L29;
        if (r10 == 8) goto L28;
        r13[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
    L31:
        if (r10 == 6) goto L35;
        if (r10 == 7) goto L35;
        if (r10 == 8) goto L35;
        r13[2] = "<init>";
    L35:
        String r14 = String.format(r11, r13);
        if (r10 == 6) goto L41;
        if (r10 == 7) goto L41;
        if (r10 == 8) goto L41;
        throw new IllegalArgumentException(r14);
    L41:
        throw new IllegalStateException(r14);
    L28:
        r13[1] = "getOriginal";
        goto L31
    L29:
        r13[1] = "getValueParameters";
        goto L31
    L30:
        r13[1] = "getOverriddenDescriptors";
        goto L31
    L17:
        r13[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
        goto L24
    L18:
        r13[0] = "source";
        goto L24
    L19:
        r13[0] = "kind";
        goto L24
    L20:
        r13[0] = "visibility";
        goto L24
    L21:
        r13[0] = "modality";
        goto L24
    L22:
        r13[0] = "annotations";
    L13:
        r12 = 2;
    L7:
        r11 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PropertyGetterDescriptorImpl(PropertyDescriptor r12, Annotations r13, Modality r14, DescriptorVisibility r15, boolean r16, boolean r17, boolean r18, CallableMemberDescriptor.Kind r19, PropertyGetterDescriptor r20, SourceElement r21) {
        if (r12 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r13 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r14 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r15 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        if (r19 != null) goto L12;
        $$$reportNull$$$0(4);
    L12:
        if (r21 != null) goto L14;
        $$$reportNull$$$0(5);
    L14:
        super(r14, r15, r12, r13, Name.special("<get-" + r12.getName() + ">"), r16, r17, r18, r19, r21);
        if (r20 == null) goto L17;
        PropertyGetterDescriptorImpl r10 = this;
        PropertyGetterDescriptor r11 = r20;
    L18:
        r10.original = r11;
        return;
    L17:
        r11 = this;
        r10 = r11;
        goto L18
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> r10, D r11) {
        return r10.visitPropertyGetterDescriptor(this, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyAccessorDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyAccessorDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyAccessorDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyAccessorDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptorWithSource getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyAccessorDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ FunctionDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyAccessorDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ PropertyAccessorDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyAccessorDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public PropertyGetterDescriptor getOriginal() {
        PropertyGetterDescriptor r10 = this.original;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(8);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public Collection<? extends PropertyGetterDescriptor> getOverriddenDescriptors() {
        Collection<PropertyAccessorDescriptor> r10 = super.getOverriddenDescriptors(true);
        if (r10 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public KotlinType getReturnType() {
        return this.returnType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<ValueParameterDescriptor> getValueParameters() {
        List<ValueParameterDescriptor> r10 = Collections.emptyList();
        if (r10 != null) goto L5;
        $$$reportNull$$$0(7);
    L5:
        return r10;
    }

    public void initialize(KotlinType r10) {
        if (r10 != null) goto L4;
        r10 = getCorrespondingProperty().getType();
    L4:
        this.returnType = r10;
    }
}
