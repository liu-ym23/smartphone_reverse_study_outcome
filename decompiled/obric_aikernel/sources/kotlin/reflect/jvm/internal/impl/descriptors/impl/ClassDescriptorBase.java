package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.bytedance.crash.tracker.ActivityLifecycle;
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
        String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r10 == 4) goto L11;
        if (r10 == 5) goto L11;
        int r12 = 3;
    L12:
        Object[] r13 = new Object[r12];
        if (r10 == 1) goto L22;
        if (r10 == 2) goto L21;
        if (r10 == 3) goto L20;
        if (r10 == 4) goto L19;
        if (r10 == 5) goto L19;
        r13[0] = "storageManager";
    L23:
        if (r10 == 4) goto L27;
        if (r10 == 5) goto L26;
        r13[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
    L28:
        if (r10 == 4) goto L31;
        if (r10 == 5) goto L31;
        r13[2] = "<init>";
    L31:
        String r14 = String.format(r11, r13);
        if (r10 == 4) goto L36;
        if (r10 == 5) goto L36;
        throw new IllegalArgumentException(r14);
    L36:
        throw new IllegalStateException(r14);
    L26:
        r13[1] = "getSource";
        goto L28
    L27:
        r13[1] = "getContainingDeclaration";
    L19:
        r13[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        goto L23
    L20:
        r13[0] = "source";
        goto L23
    L21:
        r13[0] = ActivityLifecycle.NAME;
        goto L23
    L22:
        r13[0] = "containingDeclaration";
    L11:
        r12 = 2;
    L6:
        r11 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    protected ClassDescriptorBase(StorageManager r10, DeclarationDescriptor r11, Name r12, SourceElement r13, boolean r14) {
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
        super(r10, r12);
        this.containingDeclaration = r11;
        this.source = r13;
        this.isExternal = r14;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor r10 = this.containingDeclaration;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        SourceElement r10 = this.source;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return r10;
    }

    public boolean isExternal() {
        return this.isExternal;
    }
}
