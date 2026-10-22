package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class VariableDescriptorImpl extends DeclarationDescriptorNonRootImpl implements VariableDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected KotlinType outType;

    private static /* synthetic */ void $$$reportNull$$$0(int r6) {
        switch(r6) {
            case 4: goto L4;
            case 5: goto L4;
            case 6: goto L4;
            case 7: goto L4;
            case 8: goto L4;
            case 9: goto L4;
            case 10: goto L4;
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
            default: goto L7;
        };
    L7:
        int r2 = 3;
    L9:
        Object[] r3 = new Object[r2];
        switch(r6) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L12;
            case 6: goto L12;
            case 7: goto L12;
            case 8: goto L12;
            case 9: goto L12;
            case 10: goto L12;
            default: goto L11;
        };
    L11:
        r3[0] = "containingDeclaration";
    L17:
        switch(r6) {
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L22;
            case 8: goto L21;
            case 9: goto L20;
            case 10: goto L19;
            default: goto L18;
        };
    L18:
        r3[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
    L26:
        switch(r6) {
            case 4: goto L28;
            case 5: goto L28;
            case 6: goto L28;
            case 7: goto L28;
            case 8: goto L28;
            case 9: goto L28;
            case 10: goto L28;
            default: goto L27;
        };
    L27:
        r3[2] = "<init>";
    L28:
        String r1 = String.format(r0, r3);
        switch(r6) {
            case 4: goto L32;
            case 5: goto L32;
            case 6: goto L32;
            case 7: goto L32;
            case 8: goto L32;
            case 9: goto L32;
            case 10: goto L32;
            default: goto L33;
        };
    L33:
        throw new IllegalArgumentException(r1);
    L32:
        throw new IllegalStateException(r1);
    L19:
        r3[1] = "getReturnType";
        goto L26
    L20:
        r3[1] = "getContextReceiverParameters";
        goto L26
    L21:
        r3[1] = "getTypeParameters";
        goto L26
    L22:
        r3[1] = "getOverriddenDescriptors";
        goto L26
    L23:
        r3[1] = "getValueParameters";
        goto L26
    L24:
        r3[1] = "getOriginal";
        goto L26
    L25:
        r3[1] = "getType";
        goto L26
    L12:
        r3[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
        goto L17
    L13:
        r3[0] = "source";
        goto L17
    L14:
        r3[0] = DBDefinition.NAME;
        goto L17
    L15:
        r3[0] = "annotations";
        goto L17
    L8:
        r2 = 2;
        goto L9
    L4:
        r0 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return null;
    }

    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return null;
    }

    public <V> V getUserData(CallableDescriptor.UserDataKey<V> r1) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    public boolean isConst() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueDescriptor
    public KotlinType getType() {
        KotlinType r0 = this.outType;
        if (r0 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r0;
    }

    public List<ReceiverParameterDescriptor> getContextReceiverParameters() {
        List<ReceiverParameterDescriptor> r0 = Collections.emptyList();
        if (r0 != null) goto L5;
        $$$reportNull$$$0(9);
    L5:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public VariableDescriptor getOriginal() {
        VariableDescriptor r0 = (VariableDescriptor) super.getOriginal();
        if (r0 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return r0;
    }

    public Collection<? extends CallableDescriptor> getOverriddenDescriptors() {
        Set r0 = Collections.emptySet();
        if (r0 != null) goto L5;
        $$$reportNull$$$0(7);
    L5:
        return r0;
    }

    public KotlinType getReturnType() {
        KotlinType r0 = getType();
        if (r0 != null) goto L5;
        $$$reportNull$$$0(10);
    L5:
        return r0;
    }

    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> r0 = Collections.emptyList();
        if (r0 != null) goto L5;
        $$$reportNull$$$0(8);
    L5:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<ValueParameterDescriptor> getValueParameters() {
        List<ValueParameterDescriptor> r0 = Collections.emptyList();
        if (r0 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        return r0;
    }

    static {
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableDescriptor getOriginal() {
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

    public void setOutType(KotlinType r1) {
        this.outType = r1;
    }

    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor r1) {
        return substitute(r1);
    }

    public VariableDescriptorImpl(DeclarationDescriptor r2, Annotations r3, Name r4, KotlinType r5, SourceElement r6) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r3 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r4 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r6 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        super(r2, r3, r4, r6);
        this.outType = r5;
    }
}
