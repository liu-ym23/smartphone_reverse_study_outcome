package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.bytedance.crash.entity.EventBody;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;

/* JADX INFO: loaded from: classes3.dex */
public class ReceiverParameterDescriptorImpl extends AbstractReceiverParameterDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final DeclarationDescriptor containingDeclaration;
    private ReceiverValue value;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 3) goto L6;
        if (r10 == 4) goto L6;
        String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r10 == 3) goto L11;
        if (r10 == 4) goto L11;
        int r12 = 3;
    L12:
        Object[] r13 = new Object[r12];
        switch(r10) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            default: goto L14;
        };
    L14:
        r13[0] = "containingDeclaration";
    L21:
        if (r10 == 3) goto L25;
        if (r10 == 4) goto L24;
        r13[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
    L26:
        if (r10 == 3) goto L35;
        if (r10 == 4) goto L35;
        if (r10 != 5) goto L31;
        r13[2] = "copy";
        goto L35
    L31:
        if (r10 == 6) goto L33;
        r13[2] = "<init>";
        goto L35
    L33:
        r13[2] = "setOutType";
    L35:
        String r14 = String.format(r11, r13);
        if (r10 == 3) goto L40;
        if (r10 == 4) goto L40;
        throw new IllegalArgumentException(r14);
    L40:
        throw new IllegalStateException(r14);
    L24:
        r13[1] = "getContainingDeclaration";
        goto L26
    L25:
        r13[1] = "getValue";
        goto L26
    L15:
        r13[0] = "outType";
        goto L21
    L16:
        r13[0] = "newOwner";
        goto L21
    L17:
        r13[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        goto L21
    L18:
        r13[0] = "annotations";
        goto L21
    L19:
        r13[0] = EventBody.KEY_VALUE;
    L11:
        r12 = 2;
    L6:
        r11 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    static {
    }

    public ReceiverParameterDescriptorImpl(DeclarationDescriptor r10, ReceiverValue r11, Annotations r12) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r12 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        super(r12);
        this.containingDeclaration = r10;
        this.value = r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor r10 = this.containingDeclaration;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor
    public ReceiverValue getValue() {
        ReceiverValue r10 = this.value;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(3);
    L5:
        return r10;
    }
}
