package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.bytedance.common.wschannel.WsConstants;
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
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: loaded from: classes3.dex */
public class PropertySetterDescriptorImpl extends PropertyAccessorDescriptorImpl implements PropertySetterDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final PropertySetterDescriptor original;
    private ValueParameterDescriptor parameter;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        switch(r10) {
            case 10: goto L4;
            case 11: goto L4;
            case 12: goto L4;
            case 13: goto L4;
            default: goto L3;
        };
    L3:
        String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r10) {
            case 10: goto L8;
            case 11: goto L8;
            case 12: goto L8;
            case 13: goto L8;
            default: goto L7;
        };
    L7:
        int r12 = 3;
    L9:
        Object[] r13 = new Object[r12];
        switch(r10) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L20;
            case 10: goto L12;
            case 11: goto L12;
            case 12: goto L12;
            case 13: goto L12;
            default: goto L11;
        };
    L11:
        r13[0] = "correspondingProperty";
    L22:
        switch(r10) {
            case 10: goto L27;
            case 11: goto L26;
            case 12: goto L25;
            case 13: goto L24;
            default: goto L23;
        };
    L23:
        r13[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
    L28:
        switch(r10) {
            case 6: goto L31;
            case 7: goto L30;
            case 8: goto L30;
            case 9: goto L30;
            case 10: goto L32;
            case 11: goto L32;
            case 12: goto L32;
            case 13: goto L32;
            default: goto L29;
        };
    L29:
        r13[2] = "<init>";
        goto L32
    L30:
        r13[2] = "createSetterParameter";
        goto L32
    L31:
        r13[2] = "initialize";
    L32:
        String r14 = String.format(r11, r13);
        switch(r10) {
            case 10: goto L36;
            case 11: goto L36;
            case 12: goto L36;
            case 13: goto L36;
            default: goto L37;
        };
    L37:
        throw new IllegalArgumentException(r14);
    L36:
        throw new IllegalStateException(r14);
    L24:
        r13[1] = "getOriginal";
        goto L28
    L25:
        r13[1] = "getReturnType";
        goto L28
    L26:
        r13[1] = "getValueParameters";
        goto L28
    L27:
        r13[1] = "getOverriddenDescriptors";
        goto L28
    L12:
        r13[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
        goto L22
    L13:
        r13[0] = WsConstants.KEY_CONNECTION_TYPE;
        goto L22
    L14:
        r13[0] = "setterDescriptor";
        goto L22
    L15:
        r13[0] = "parameter";
        goto L22
    L16:
        r13[0] = "source";
        goto L22
    L17:
        r13[0] = "kind";
        goto L22
    L18:
        r13[0] = "visibility";
        goto L22
    L19:
        r13[0] = "modality";
        goto L22
    L20:
        r13[0] = "annotations";
        goto L22
    L8:
        r12 = 2;
        goto L9
    L4:
        r11 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PropertySetterDescriptorImpl(PropertyDescriptor r12, Annotations r13, Modality r14, DescriptorVisibility r15, boolean r16, boolean r17, boolean r18, CallableMemberDescriptor.Kind r19, PropertySetterDescriptor r20, SourceElement r21) {
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
        super(r14, r15, r12, r13, Name.special("<set-" + r12.getName() + ">"), r16, r17, r18, r19, r21);
        if (r20 == null) goto L17;
        PropertySetterDescriptorImpl r10 = this;
        PropertySetterDescriptor r11 = r20;
    L18:
        r10.original = r11;
        return;
    L17:
        r11 = this;
        r10 = r11;
        goto L18
    }

    public static ValueParameterDescriptorImpl createSetterParameter(PropertySetterDescriptor r13, KotlinType r14, Annotations r15) {
        if (r13 != null) goto L4;
        $$$reportNull$$$0(7);
    L4:
        if (r14 != null) goto L6;
        $$$reportNull$$$0(8);
    L6:
        if (r15 != null) goto L9;
        $$$reportNull$$$0(9);
    L9:
        return new ValueParameterDescriptorImpl(r13, null, 0, r15, SpecialNames.IMPLICIT_SET_PARAMETER, r14, false, false, false, null, SourceElement.NO_SOURCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> r10, D r11) {
        return r10.visitPropertySetterDescriptor(this, r11);
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
    public PropertySetterDescriptor getOriginal() {
        PropertySetterDescriptor r10 = this.original;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(13);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public Collection<? extends PropertySetterDescriptor> getOverriddenDescriptors() {
        Collection<PropertyAccessorDescriptor> r10 = super.getOverriddenDescriptors(false);
        if (r10 != null) goto L5;
        $$$reportNull$$$0(10);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public KotlinType getReturnType() {
        SimpleType r10 = DescriptorUtilsKt.getBuiltIns(this).getUnitType();
        if (r10 != null) goto L5;
        $$$reportNull$$$0(12);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<ValueParameterDescriptor> getValueParameters() {
        ValueParameterDescriptor r10 = this.parameter;
        if (r10 == null) goto L9;
        List<ValueParameterDescriptor> r11 = Collections.singletonList(r10);
        if (r11 != null) goto L7;
        $$$reportNull$$$0(11);
    L7:
        return r11;
    L9:
        throw new IllegalStateException();
    }

    public void initialize(ValueParameterDescriptor r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(6);
    L4:
        this.parameter = r10;
    }
}
