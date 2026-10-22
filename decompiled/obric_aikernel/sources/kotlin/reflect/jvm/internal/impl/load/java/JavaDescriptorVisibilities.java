package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.HashMap;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;

/* JADX INFO: loaded from: classes3.dex */
public class JavaDescriptorVisibilities {
    public static final DescriptorVisibility PACKAGE_VISIBILITY = null;
    public static final DescriptorVisibility PROTECTED_AND_PACKAGE = null;
    public static final DescriptorVisibility PROTECTED_STATIC_VISIBILITY = null;
    private static final Map<Visibility, DescriptorVisibility> visibilitiesMapping = null;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 5) goto L6;
        if (r10 == 6) goto L6;
        String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r10 == 5) goto L11;
        if (r10 == 6) goto L11;
        int r12 = 3;
    L12:
        Object[] r13 = new Object[r12];
        switch(r10) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L15;
            default: goto L14;
        };
    L14:
        r13[0] = "what";
    L21:
        if (r10 == 5) goto L24;
        if (r10 == 6) goto L24;
        r13[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
    L25:
        if (r10 == 2) goto L33;
        if (r10 == 3) goto L33;
        if (r10 == 4) goto L32;
        if (r10 == 5) goto L34;
        if (r10 == 6) goto L34;
        r13[2] = "isVisibleForProtectedAndPackage";
    L34:
        String r14 = String.format(r11, r13);
        if (r10 == 5) goto L39;
        if (r10 == 6) goto L39;
        throw new IllegalArgumentException(r14);
    L39:
        throw new IllegalStateException(r14);
    L32:
        r13[2] = "toDescriptorVisibility";
    L33:
        r13[2] = "areInSamePackage";
    L24:
        r13[1] = "toDescriptorVisibility";
        goto L25
    L15:
        r13[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
        goto L21
    L16:
        r13[0] = "visibility";
        goto L21
    L17:
        r13[0] = "second";
        goto L21
    L18:
        r13[0] = "first";
        goto L21
    L19:
        r13[0] = "from";
    L11:
        r12 = 2;
    L6:
        r11 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    static {
        final JavaVisibilities.PackageVisibility r10 = JavaVisibilities.PackageVisibility.INSTANCE;
        DelegatedDescriptorVisibility r11 = new AnonymousClass1(r10);
        PACKAGE_VISIBILITY = r11;
        final JavaVisibilities.ProtectedStaticVisibility r12 = JavaVisibilities.ProtectedStaticVisibility.INSTANCE;
        DelegatedDescriptorVisibility r13 = new AnonymousClass2(r12);
        PROTECTED_STATIC_VISIBILITY = r13;
        final JavaVisibilities.ProtectedAndPackage r14 = JavaVisibilities.ProtectedAndPackage.INSTANCE;
        DelegatedDescriptorVisibility r15 = new AnonymousClass3(r14);
        PROTECTED_AND_PACKAGE = r15;
        visibilitiesMapping = new HashMap();
        recordVisibilityMapping(r11);
        recordVisibilityMapping(r13);
        recordVisibilityMapping(r15);
    }

    static /* synthetic */ boolean access$000(DeclarationDescriptor r10, DeclarationDescriptor r11) {
        return areInSamePackage(r10, r11);
    }

    static /* synthetic */ boolean access$100(ReceiverValue r10, DeclarationDescriptorWithVisibility r11, DeclarationDescriptor r12) {
        return isVisibleForProtectedAndPackage(r10, r11, r12);
    }

    private static boolean areInSamePackage(DeclarationDescriptor r10, DeclarationDescriptor r11) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(2);
    L5:
        if (r11 != null) goto L7;
        $$$reportNull$$$0(3);
    L7:
        PackageFragmentDescriptor r12 = (PackageFragmentDescriptor) DescriptorUtils.getParentOfType(r10, PackageFragmentDescriptor.class, false);
        PackageFragmentDescriptor r13 = (PackageFragmentDescriptor) DescriptorUtils.getParentOfType(r11, PackageFragmentDescriptor.class, false);
        if (r13 == null) goto L14;
        if (r12 != null) goto L11;
        return false;
    L11:
        if (r12.getFqName().equals(r13.getFqName()) == false) goto L16;
        return true;
    L16:
        return false;
    L14:
        return false;
    }

    private static boolean isVisibleForProtectedAndPackage(ReceiverValue r10, DeclarationDescriptorWithVisibility r11, DeclarationDescriptor r12) {
        if (r11 != null) goto L6;
        $$$reportNull$$$0(0);
    L6:
        if (r12 != null) goto L9;
        $$$reportNull$$$0(1);
    L9:
        if (areInSamePackage(DescriptorUtils.unwrapFakeOverrideToAnyDeclaration(r11), r12) == false) goto L12;
        return true;
    L12:
        return DescriptorVisibilities.PROTECTED.isVisible(r10, r11, r12, false);
    }

    private static void recordVisibilityMapping(DescriptorVisibility r10) {
        visibilitiesMapping.put(r10.getDelegate(), r10);
    }

    public static DescriptorVisibility toDescriptorVisibility(Visibility r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(4);
    L4:
        DescriptorVisibility r11 = visibilitiesMapping.get(r10);
        if (r11 != null) goto L10;
        DescriptorVisibility r12 = DescriptorVisibilities.toDescriptorVisibility(r10);
        if (r12 != null) goto L9;
        $$$reportNull$$$0(5);
    L9:
        return r12;
    L10:
        return r11;
    }
}
