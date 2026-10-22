package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class PropertyAccessorDescriptorImpl extends DeclarationDescriptorNonRootImpl implements PropertyAccessorDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final PropertyDescriptor correspondingProperty;
    private FunctionDescriptor initialSignatureDescriptor;
    private boolean isDefault;
    private final boolean isExternal;
    private final boolean isInline;
    private final CallableMemberDescriptor.Kind kind;
    private final Modality modality;
    private DescriptorVisibility visibility;

    private static /* synthetic */ void $$$reportNull$$$0(int r6) {
        switch(r6) {
            case 6: goto L4;
            case 7: goto L3;
            case 8: goto L4;
            case 9: goto L4;
            case 10: goto L4;
            case 11: goto L4;
            case 12: goto L4;
            case 13: goto L4;
            case 14: goto L4;
            case 15: goto L4;
            default: goto L3;
        };
    L3:
        String r0 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r6) {
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L8;
            case 9: goto L8;
            case 10: goto L8;
            case 11: goto L8;
            case 12: goto L8;
            case 13: goto L8;
            case 14: goto L8;
            case 15: goto L8;
            default: goto L7;
        };
    L7:
        int r2 = 3;
    L9:
        Object[] r3 = new Object[r2];
        switch(r6) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L14;
            case 9: goto L14;
            case 10: goto L14;
            case 11: goto L14;
            case 12: goto L14;
            case 13: goto L14;
            case 14: goto L14;
            case 15: goto L14;
            case 16: goto L12;
            default: goto L11;
        };
    L11:
        r3[0] = "modality";
    L21:
        switch(r6) {
            case 6: goto L31;
            case 7: goto L22;
            case 8: goto L30;
            case 9: goto L29;
            case 10: goto L28;
            case 11: goto L27;
            case 12: goto L26;
            case 13: goto L25;
            case 14: goto L24;
            case 15: goto L23;
            default: goto L22;
        };
    L22:
        r3[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
    L32:
        switch(r6) {
            case 6: goto L36;
            case 7: goto L35;
            case 8: goto L36;
            case 9: goto L36;
            case 10: goto L36;
            case 11: goto L36;
            case 12: goto L36;
            case 13: goto L36;
            case 14: goto L36;
            case 15: goto L36;
            case 16: goto L34;
            default: goto L33;
        };
    L33:
        r3[2] = "<init>";
        goto L36
    L34:
        r3[2] = "setOverriddenDescriptors";
        goto L36
    L35:
        r3[2] = "substitute";
    L36:
        String r1 = String.format(r0, r3);
        switch(r6) {
            case 6: goto L40;
            case 7: goto L41;
            case 8: goto L40;
            case 9: goto L40;
            case 10: goto L40;
            case 11: goto L40;
            case 12: goto L40;
            case 13: goto L40;
            case 14: goto L40;
            case 15: goto L40;
            default: goto L41;
        };
    L41:
        throw new IllegalArgumentException(r1);
    L40:
        throw new IllegalStateException(r1);
    L23:
        r3[1] = "getOverriddenDescriptors";
        goto L32
    L24:
        r3[1] = "getContextReceiverParameters";
        goto L32
    L25:
        r3[1] = "getCorrespondingProperty";
        goto L32
    L26:
        r3[1] = "getCorrespondingVariable";
        goto L32
    L27:
        r3[1] = "getVisibility";
        goto L32
    L28:
        r3[1] = "getModality";
        goto L32
    L29:
        r3[1] = "getTypeParameters";
        goto L32
    L30:
        r3[1] = "substitute";
        goto L32
    L31:
        r3[1] = "getKind";
        goto L32
    L12:
        r3[0] = "overriddenDescriptors";
        goto L21
    L13:
        r3[0] = "substitutor";
        goto L21
    L14:
        r3[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
        goto L21
    L15:
        r3[0] = "source";
        goto L21
    L16:
        r3[0] = DBDefinition.NAME;
        goto L21
    L17:
        r3[0] = "annotations";
        goto L21
    L18:
        r3[0] = "correspondingProperty";
        goto L21
    L19:
        r3[0] = "visibility";
        goto L21
    L8:
        r2 = 2;
        goto L9
    L4:
        r0 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public abstract PropertyAccessorDescriptor getOriginal();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> r1) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isHiddenForResolutionEverywhereBesideSupercalls() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isHiddenToOvercomeSignatureClash() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isInfix() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isOperator() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isSuspend() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isTailrec() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(16);
        return;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public FunctionDescriptor substitute(TypeSubstitutor r1) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(7);
    L4:
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor
    public PropertyDescriptor getCorrespondingProperty() {
        PropertyDescriptor r0 = this.correspondingProperty;
        if (r0 != null) goto L5;
        $$$reportNull$$$0(13);
    L5:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind r0 = this.kind;
        if (r0 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public Modality getModality() {
        Modality r0 = this.modality;
        if (r0 != null) goto L5;
        $$$reportNull$$$0(10);
    L5:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility r0 = this.visibility;
        if (r0 != null) goto L5;
        $$$reportNull$$$0(11);
    L5:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> newCopyBuilder() {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<ReceiverParameterDescriptor> getContextReceiverParameters() {
        List<ReceiverParameterDescriptor> r0 = getCorrespondingProperty().getContextReceiverParameters();
        if (r0 != null) goto L5;
        $$$reportNull$$$0(14);
    L5:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return getCorrespondingProperty().getDispatchReceiverParameter();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return getCorrespondingProperty().getExtensionReceiverParameter();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> r0 = Collections.emptyList();
        if (r0 != null) goto L5;
        $$$reportNull$$$0(9);
    L5:
        return r0;
    }

    static {
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public FunctionDescriptor getInitialSignatureDescriptor() {
        return this.initialSignatureDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor
    public boolean isDefault() {
        return this.isDefault;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return this.isExternal;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isInline() {
        return this.isInline;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptorWithSource getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ FunctionDescriptor getOriginal() {
        return getOriginal();
    }

    public Collection<PropertyAccessorDescriptor> getOverriddenDescriptors(boolean r4) {
        ArrayList r0 = new ArrayList(0);
        Iterator<? extends PropertyDescriptor> r1 = getCorrespondingProperty().getOverriddenDescriptors().iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        PropertyDescriptor r2 = r1.next();
        if (r4 == false) goto L8;
        PropertyGetterDescriptor r3 = r2.getGetter();
    L9:
        if (r3 == null) goto L4;
        r0.add(r3);
        goto L4
    L8:
        r3 = r2.getSetter();
        goto L9
    L11:
        return r0;
    }

    public void setDefault(boolean r1) {
        this.isDefault = r1;
    }

    public void setInitialSignatureDescriptor(FunctionDescriptor r1) {
        this.initialSignatureDescriptor = r1;
    }

    public void setVisibility(DescriptorVisibility r1) {
        this.visibility = r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor r1) {
        return substitute(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public PropertyAccessorDescriptor copy(DeclarationDescriptor r1, Modality r2, DescriptorVisibility r3, CallableMemberDescriptor.Kind r4, boolean r5) {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor copy(DeclarationDescriptor r1, Modality r2, DescriptorVisibility r3, CallableMemberDescriptor.Kind r4, boolean r5) {
        return copy(r1, r2, r3, r4, r5);
    }

    public PropertyAccessorDescriptorImpl(Modality r2, DescriptorVisibility r3, PropertyDescriptor r4, Annotations r5, Name r6, boolean r7, boolean r8, boolean r9, CallableMemberDescriptor.Kind r10, SourceElement r11) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r3 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r4 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r5 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        if (r6 != null) goto L12;
        $$$reportNull$$$0(4);
    L12:
        if (r11 != null) goto L14;
        $$$reportNull$$$0(5);
    L14:
        super(r4.getContainingDeclaration(), r5, r6, r11);
        this.initialSignatureDescriptor = null;
        this.modality = r2;
        this.visibility = r3;
        this.correspondingProperty = r4;
        this.isDefault = r7;
        this.isExternal = r8;
        this.isInline = r9;
        this.kind = r10;
    }
}
