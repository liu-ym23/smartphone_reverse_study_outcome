package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;

/* JADX INFO: loaded from: classes3.dex */
public class ReceiverParameterDescriptorImpl extends AbstractReceiverParameterDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final DeclarationDescriptor containingDeclaration;
    private ReceiverValue value;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 7) goto L6;
        if (r10 == 8) goto L6;
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r10 == 7) goto L11;
        if (r10 == 8) goto L11;
        int r11 = 3;
    L12:
        Object[] r12 = new Object[r11];
        switch(r10) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L14;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            case 8: goto L17;
            case 9: goto L16;
            case 10: goto L15;
            default: goto L14;
        };
    L14:
        r12[0] = "containingDeclaration";
    L22:
        if (r10 == 7) goto L26;
        if (r10 == 8) goto L25;
        r12[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
    L27:
        switch(r10) {
            case 7: goto L31;
            case 8: goto L31;
            case 9: goto L30;
            case 10: goto L29;
            default: goto L28;
        };
    L28:
        r12[2] = "<init>";
        goto L31
    L29:
        r12[2] = "setOutType";
        goto L31
    L30:
        r12[2] = "copy";
    L31:
        String r13 = String.format(r5, r12);
        if (r10 == 7) goto L36;
        if (r10 == 8) goto L36;
        throw new IllegalArgumentException(r13);
    L36:
        throw new IllegalStateException(r13);
    L25:
        r12[1] = "getContainingDeclaration";
        goto L27
    L26:
        r12[1] = "getValue";
        goto L27
    L15:
        r12[0] = "outType";
        goto L22
    L16:
        r12[0] = "newOwner";
        goto L22
    L17:
        r12[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        goto L22
    L18:
        r12[0] = "name";
        goto L22
    L19:
        r12[0] = "annotations";
        goto L22
    L20:
        r12[0] = "value";
    L11:
        r11 = 2;
    L6:
        r5 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    public ReceiverParameterDescriptorImpl(DeclarationDescriptor r5, ReceiverValue r10, Annotations r11) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r11 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        this(r5, r10, r11, SpecialNames.THIS);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor r5 = this.containingDeclaration;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(8);
    L5:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor
    public ReceiverValue getValue() {
        ReceiverValue r5 = this.value;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(7);
    L5:
        return r5;
    }

    public ReceiverParameterDescriptorImpl(DeclarationDescriptor r5, ReceiverValue r10, Annotations r11, Name r12) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(4);
    L6:
        if (r11 != null) goto L8;
        $$$reportNull$$$0(5);
    L8:
        if (r12 != null) goto L10;
        $$$reportNull$$$0(6);
    L10:
        super(r11, r12);
        this.containingDeclaration = r5;
        this.value = r10;
    }
}
