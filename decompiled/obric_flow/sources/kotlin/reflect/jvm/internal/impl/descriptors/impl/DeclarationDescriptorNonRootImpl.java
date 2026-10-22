package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DeclarationDescriptorNonRootImpl extends DeclarationDescriptorImpl implements DeclarationDescriptorNonRoot {
    private final DeclarationDescriptor containingDeclaration;
    private final SourceElement source;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 4) goto L7;
        if (r10 == 5) goto L7;
        if (r10 == 6) goto L7;
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r10 == 4) goto L13;
        if (r10 == 5) goto L13;
        if (r10 == 6) goto L13;
        int r11 = 3;
    L14:
        Object[] r12 = new Object[r11];
        switch(r10) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L17;
            case 6: goto L17;
            default: goto L16;
        };
    L16:
        r12[0] = "containingDeclaration";
    L22:
        if (r10 == 4) goto L28;
        if (r10 == 5) goto L27;
        if (r10 == 6) goto L26;
        r12[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
    L29:
        if (r10 == 4) goto L33;
        if (r10 == 5) goto L33;
        if (r10 == 6) goto L33;
        r12[2] = "<init>";
    L33:
        String r13 = String.format(r5, r12);
        if (r10 == 4) goto L39;
        if (r10 == 5) goto L39;
        if (r10 == 6) goto L39;
        throw new IllegalArgumentException(r13);
    L39:
        throw new IllegalStateException(r13);
    L26:
        r12[1] = "getSource";
        goto L29
    L27:
        r12[1] = "getContainingDeclaration";
        goto L29
    L28:
        r12[1] = "getOriginal";
        goto L29
    L17:
        r12[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
        goto L22
    L18:
        r12[0] = "source";
        goto L22
    L19:
        r12[0] = "name";
        goto L22
    L20:
        r12[0] = "annotations";
    L13:
        r11 = 2;
    L7:
        r5 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    public DeclarationDescriptorNonRootImpl(DeclarationDescriptor r5, Annotations r10, Name r11, SourceElement r12) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r11 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r12 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        super(r10, r11);
        this.containingDeclaration = r5;
        this.source = r12;
    }

    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor r5 = this.containingDeclaration;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        SourceElement r5 = this.source;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public DeclarationDescriptorWithSource getOriginal() {
        DeclarationDescriptorWithSource r5 = (DeclarationDescriptorWithSource) super.getOriginal();
        if (r5 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r5;
    }
}
