package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ClassDescriptorBase extends AbstractClassDescriptor {
    private final DeclarationDescriptor containingDeclaration;
    private final boolean isExternal;
    private final SourceElement source;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 4) goto L6;
        if (r10 == 5) goto L6;
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r10 == 4) goto L11;
        if (r10 == 5) goto L11;
        int r11 = 3;
    L12:
        Object[] r12 = new Object[r11];
        if (r10 == 1) goto L22;
        if (r10 == 2) goto L21;
        if (r10 == 3) goto L20;
        if (r10 == 4) goto L19;
        if (r10 == 5) goto L19;
        r12[0] = "storageManager";
    L23:
        if (r10 == 4) goto L27;
        if (r10 == 5) goto L26;
        r12[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
    L28:
        if (r10 == 4) goto L31;
        if (r10 == 5) goto L31;
        r12[2] = "<init>";
    L31:
        String r13 = String.format(r5, r12);
        if (r10 == 4) goto L36;
        if (r10 == 5) goto L36;
        throw new IllegalArgumentException(r13);
    L36:
        throw new IllegalStateException(r13);
    L26:
        r12[1] = "getSource";
        goto L28
    L27:
        r12[1] = "getContainingDeclaration";
    L19:
        r12[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        goto L23
    L20:
        r12[0] = "source";
        goto L23
    L21:
        r12[0] = "name";
        goto L23
    L22:
        r12[0] = "containingDeclaration";
    L11:
        r11 = 2;
    L6:
        r5 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    public ClassDescriptorBase(StorageManager r5, DeclarationDescriptor r10, Name r11, SourceElement r12, boolean r13) {
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
        super(r5, r11);
        this.containingDeclaration = r10;
        this.source = r12;
        this.isExternal = r13;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor r5 = this.containingDeclaration;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        SourceElement r5 = this.source;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return r5;
    }

    public boolean isExternal() {
        return this.isExternal;
    }
}
