package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DeclarationDescriptorImpl extends AnnotatedImpl implements DeclarationDescriptor {
    private final Name name;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 2) goto L8;
        if (r10 == 3) goto L8;
        if (r10 == 5) goto L8;
        if (r10 == 6) goto L8;
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r10 == 2) goto L14;
        if (r10 == 3) goto L14;
        if (r10 == 5) goto L14;
        if (r10 == 6) goto L14;
        int r11 = 3;
    L15:
        Object[] r12 = new Object[r11];
        switch(r10) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L19;
            case 6: goto L19;
            default: goto L17;
        };
    L17:
        r12[0] = "annotations";
    L22:
        if (r10 == 2) goto L29;
        if (r10 == 3) goto L28;
        if (r10 == 5) goto L27;
        if (r10 == 6) goto L27;
        r12[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
    L30:
        if (r10 == 2) goto L38;
        if (r10 == 3) goto L38;
        if (r10 == 4) goto L37;
        if (r10 == 5) goto L38;
        if (r10 == 6) goto L38;
        r12[2] = "<init>";
        goto L38
    L37:
        r12[2] = "toString";
    L38:
        String r13 = String.format(r5, r12);
        if (r10 == 2) goto L45;
        if (r10 == 3) goto L45;
        if (r10 == 5) goto L45;
        if (r10 == 6) goto L45;
        throw new IllegalArgumentException(r13);
    L45:
        throw new IllegalStateException(r13);
    L27:
        r12[1] = "toString";
        goto L30
    L28:
        r12[1] = "getOriginal";
        goto L30
    L29:
        r12[1] = "getName";
        goto L30
    L18:
        r12[0] = "descriptor";
        goto L22
    L19:
        r12[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
        goto L22
    L20:
        r12[0] = "name";
    L14:
        r11 = 2;
    L8:
        r5 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    public DeclarationDescriptorImpl(Annotations r5, Name r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        super(r5);
        this.name = r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Named
    public Name getName() {
        Name r5 = this.name;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(2);
    L5:
        return r5;
    }

    public DeclarationDescriptor getOriginal() {
        return this;
    }

    public String toString() {
        return toString(this);
    }

    public static String toString(DeclarationDescriptor r5) {
        if (r5 != null) goto L12;
        $$$reportNull$$$0(4);
    L12:
        String r10 = DescriptorRenderer.DEBUG_TEXT.render(r5) + "[" + r5.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(r5)) + "]";     // Catch: Throwable -> L8
        if (r10 != null) goto L7;
        $$$reportNull$$$0(5);
    L7:
        return r10;
    L8:
        String r11 = r5.getClass().getSimpleName() + " " + r5.getName();
        if (r11 != null) goto L11;
        $$$reportNull$$$0(6);
    L11:
        return r11;
    }
}
