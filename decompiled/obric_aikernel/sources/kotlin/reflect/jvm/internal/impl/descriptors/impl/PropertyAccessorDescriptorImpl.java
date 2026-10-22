package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.bytedance.crash.tracker.ActivityLifecycle;
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
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* JADX INFO: loaded from: classes3.dex */
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

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        switch(r10) {
            case 6: goto L4;
            case 7: goto L3;
            case 8: goto L4;
            case 9: goto L4;
            case 10: goto L4;
            case 11: goto L4;
            case 12: goto L4;
            case 13: goto L4;
            case 14: goto L4;
            default: goto L3;
        };
    L3:
        String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r10) {
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L8;
            case 9: goto L8;
            case 10: goto L8;
            case 11: goto L8;
            case 12: goto L8;
            case 13: goto L8;
            case 14: goto L8;
            default: goto L7;
        };
    L7:
        int r12 = 3;
    L9:
        Object[] r13 = new Object[r12];
        switch(r10) {
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
            case 15: goto L12;
            default: goto L11;
        };
    L11:
        r13[0] = "modality";
    L21:
        switch(r10) {
            case 6: goto L30;
            case 7: goto L22;
            case 8: goto L29;
            case 9: goto L28;
            case 10: goto L27;
            case 11: goto L26;
            case 12: goto L25;
            case 13: goto L24;
            case 14: goto L23;
            default: goto L22;
        };
    L22:
        r13[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
    L31:
        switch(r10) {
            case 6: goto L35;
            case 7: goto L34;
            case 8: goto L35;
            case 9: goto L35;
            case 10: goto L35;
            case 11: goto L35;
            case 12: goto L35;
            case 13: goto L35;
            case 14: goto L35;
            case 15: goto L33;
            default: goto L32;
        };
    L32:
        r13[2] = "<init>";
        goto L35
    L33:
        r13[2] = "setOverriddenDescriptors";
        goto L35
    L34:
        r13[2] = "substitute";
    L35:
        String r14 = String.format(r11, r13);
        switch(r10) {
            case 6: goto L39;
            case 7: goto L40;
            case 8: goto L39;
            case 9: goto L39;
            case 10: goto L39;
            case 11: goto L39;
            case 12: goto L39;
            case 13: goto L39;
            case 14: goto L39;
            default: goto L40;
        };
    L40:
        throw new IllegalArgumentException(r14);
    L39:
        throw new IllegalStateException(r14);
    L23:
        r13[1] = "getOverriddenDescriptors";
        goto L31
    L24:
        r13[1] = "getContextReceiverParameters";
        goto L31
    L25:
        r13[1] = "getCorrespondingProperty";
        goto L31
    L26:
        r13[1] = "getCorrespondingVariable";
        goto L31
    L27:
        r13[1] = "getVisibility";
        goto L31
    L28:
        r13[1] = "getModality";
        goto L31
    L29:
        r13[1] = "getTypeParameters";
        goto L31
    L30:
        r13[1] = "getKind";
        goto L31
    L12:
        r13[0] = "overriddenDescriptors";
        goto L21
    L13:
        r13[0] = "substitutor";
        goto L21
    L14:
        r13[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
        goto L21
    L15:
        r13[0] = "source";
        goto L21
    L16:
        r13[0] = ActivityLifecycle.NAME;
        goto L21
    L17:
        r13[0] = "annotations";
        goto L21
    L18:
        r13[0] = "correspondingProperty";
        goto L21
    L19:
        r13[0] = "visibility";
        goto L21
    L8:
        r12 = 2;
        goto L9
    L4:
        r11 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    static {
    }

    public PropertyAccessorDescriptorImpl(Modality r10, DescriptorVisibility r11, PropertyDescriptor r12, Annotations r13, Name r14, boolean r15, boolean r16, boolean r17, CallableMemberDescriptor.Kind r18, SourceElement r19) {
        if (r10 != null) goto L4;
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
        if (r19 != null) goto L14;
        $$$reportNull$$$0(5);
    L14:
        super(r12.getContainingDeclaration(), r13, r14, r19);
        this.initialSignatureDescriptor = null;
        this.modality = r10;
        this.visibility = r11;
        this.correspondingProperty = r12;
        this.isDefault = r15;
        this.isExternal = r16;
        this.isInline = r17;
        this.kind = r18;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor copy(DeclarationDescriptor r10, Modality r11, DescriptorVisibility r12, CallableMemberDescriptor.Kind r13, boolean r14) {
        return copy(r10, r11, r12, r13, r14);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public PropertyAccessorDescriptor copy(DeclarationDescriptor r10, Modality r11, DescriptorVisibility r12, CallableMemberDescriptor.Kind r13, boolean r14) {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<ReceiverParameterDescriptor> getContextReceiverParameters() {
        List<ReceiverParameterDescriptor> r10 = getCorrespondingProperty().getContextReceiverParameters();
        if (r10 != null) goto L5;
        $$$reportNull$$$0(13);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor
    public PropertyDescriptor getCorrespondingProperty() {
        PropertyDescriptor r10 = this.correspondingProperty;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(12);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return getCorrespondingProperty().getDispatchReceiverParameter();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return getCorrespondingProperty().getExtensionReceiverParameter();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public FunctionDescriptor getInitialSignatureDescriptor() {
        return this.initialSignatureDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind r10 = this.kind;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public Modality getModality() {
        Modality r10 = this.modality;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(9);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableDescriptor getOriginal() {
        return getOriginal();
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

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public abstract PropertyAccessorDescriptor getOriginal();

    protected Collection<PropertyAccessorDescriptor> getOverriddenDescriptors(boolean r10) {
        ArrayList r11 = new ArrayList(0);
        Iterator<? extends PropertyDescriptor> r12 = getCorrespondingProperty().getOverriddenDescriptors().iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        PropertyDescriptor r13 = r12.next();
        if (r10 == false) goto L8;
        CallableDescriptor r14 = r13.getGetter();
    L9:
        if (r14 == null) goto L4;
        r11.add(r14);
        goto L4
    L8:
        r14 = r13.getSetter();
        goto L9
    L11:
        return r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> r10 = Collections.emptyList();
        if (r10 != null) goto L5;
        $$$reportNull$$$0(8);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> r10) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility r10 = this.visibility;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(10);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor
    public boolean isDefault() {
        return this.isDefault;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return this.isExternal;
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
    public boolean isInline() {
        return this.isInline;
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

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> newCopyBuilder() {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    public void setDefault(boolean r10) {
        this.isDefault = r10;
    }

    public void setInitialSignatureDescriptor(FunctionDescriptor r10) {
        this.initialSignatureDescriptor = r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(15);
        return;
    }

    public void setVisibility(DescriptorVisibility r10) {
        this.visibility = r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor r10) {
        return substitute(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public FunctionDescriptor substitute(TypeSubstitutor r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(7);
    L5:
        throw new UnsupportedOperationException();
    }
}
