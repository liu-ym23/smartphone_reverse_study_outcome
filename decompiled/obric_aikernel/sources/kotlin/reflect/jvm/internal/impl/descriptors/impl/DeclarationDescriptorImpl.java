package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.bytedance.crash.tracker.ActivityLifecycle;
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
        String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r10 == 2) goto L14;
        if (r10 == 3) goto L14;
        if (r10 == 5) goto L14;
        if (r10 == 6) goto L14;
        int r12 = 3;
    L15:
        Object[] r13 = new Object[r12];
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
        r13[0] = "annotations";
    L22:
        if (r10 == 2) goto L29;
        if (r10 == 3) goto L28;
        if (r10 == 5) goto L27;
        if (r10 == 6) goto L27;
        r13[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
    L30:
        if (r10 == 2) goto L38;
        if (r10 == 3) goto L38;
        if (r10 == 4) goto L37;
        if (r10 == 5) goto L38;
        if (r10 == 6) goto L38;
        r13[2] = "<init>";
        goto L38
    L37:
        r13[2] = "toString";
    L38:
        String r14 = String.format(r11, r13);
        if (r10 == 2) goto L45;
        if (r10 == 3) goto L45;
        if (r10 == 5) goto L45;
        if (r10 == 6) goto L45;
        throw new IllegalArgumentException(r14);
    L45:
        throw new IllegalStateException(r14);
    L27:
        r13[1] = "toString";
        goto L30
    L28:
        r13[1] = "getOriginal";
        goto L30
    L29:
        r13[1] = "getName";
        goto L30
    L18:
        r13[0] = "descriptor";
        goto L22
    L19:
        r13[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
        goto L22
    L20:
        r13[0] = ActivityLifecycle.NAME;
    L14:
        r12 = 2;
    L8:
        r11 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    public DeclarationDescriptorImpl(Annotations r10, Name r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        super(r10);
        this.name = r11;
    }

    public static String toString(DeclarationDescriptor r10) {
        if (r10 != null) goto L12;
        $$$reportNull$$$0(4);
    L12:
        String r11 = DescriptorRenderer.DEBUG_TEXT.render(r10) + "[" + r10.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(r10)) + "]";     // Catch: Throwable -> L8
        if (r11 != null) goto L7;
        $$$reportNull$$$0(5);
    L7:
        return r11;
    L8:
        String r12 = r10.getClass().getSimpleName() + " " + r10.getName();
        if (r12 != null) goto L11;
        $$$reportNull$$$0(6);
    L11:
        return r12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Named
    public Name getName() {
        Name r10 = this.name;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(2);
    L5:
        return r10;
    }

    public DeclarationDescriptor getOriginal() {
        return this;
    }

    public String toString() {
        return toString(this);
    }
}
