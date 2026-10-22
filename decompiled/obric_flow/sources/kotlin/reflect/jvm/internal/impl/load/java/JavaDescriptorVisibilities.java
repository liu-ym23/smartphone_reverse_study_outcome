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
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r10 == 5) goto L11;
        if (r10 == 6) goto L11;
        int r11 = 3;
    L12:
        Object[] r12 = new Object[r11];
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
        r12[0] = "what";
    L21:
        if (r10 == 5) goto L24;
        if (r10 == 6) goto L24;
        r12[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
    L25:
        if (r10 == 2) goto L33;
        if (r10 == 3) goto L33;
        if (r10 == 4) goto L32;
        if (r10 == 5) goto L34;
        if (r10 == 6) goto L34;
        r12[2] = "isVisibleForProtectedAndPackage";
    L34:
        String r13 = String.format(r5, r12);
        if (r10 == 5) goto L39;
        if (r10 == 6) goto L39;
        throw new IllegalArgumentException(r13);
    L39:
        throw new IllegalStateException(r13);
    L32:
        r12[2] = "toDescriptorVisibility";
    L33:
        r12[2] = "areInSamePackage";
    L24:
        r12[1] = "toDescriptorVisibility";
        goto L25
    L15:
        r12[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
        goto L21
    L16:
        r12[0] = "visibility";
        goto L21
    L17:
        r12[0] = "second";
        goto L21
    L18:
        r12[0] = "first";
        goto L21
    L19:
        r12[0] = "from";
    L11:
        r11 = 2;
    L6:
        r5 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    static {
        final JavaVisibilities.PackageVisibility r5 = JavaVisibilities.PackageVisibility.INSTANCE;
        DelegatedDescriptorVisibility r10 = new AnonymousClass1(r5);
        PACKAGE_VISIBILITY = r10;
        final JavaVisibilities.ProtectedStaticVisibility r11 = JavaVisibilities.ProtectedStaticVisibility.INSTANCE;
        DelegatedDescriptorVisibility r12 = new AnonymousClass2(r11);
        PROTECTED_STATIC_VISIBILITY = r12;
        final JavaVisibilities.ProtectedAndPackage r13 = JavaVisibilities.ProtectedAndPackage.INSTANCE;
        DelegatedDescriptorVisibility r14 = new AnonymousClass3(r13);
        PROTECTED_AND_PACKAGE = r14;
        visibilitiesMapping = new HashMap();
        recordVisibilityMapping(r10);
        recordVisibilityMapping(r12);
        recordVisibilityMapping(r14);
    }

    public static /* synthetic */ boolean access$000(DeclarationDescriptor r5, DeclarationDescriptor r10) {
        return areInSamePackage(r5, r10);
    }

    public static /* synthetic */ boolean access$100(ReceiverValue r5, DeclarationDescriptorWithVisibility r10, DeclarationDescriptor r11) {
        return isVisibleForProtectedAndPackage(r5, r10, r11);
    }

    private static boolean areInSamePackage(DeclarationDescriptor r5, DeclarationDescriptor r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(2);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(3);
    L6:
        PackageFragmentDescriptor r11 = (PackageFragmentDescriptor) DescriptorUtils.getParentOfType(r5, PackageFragmentDescriptor.class, false);
        PackageFragmentDescriptor r12 = (PackageFragmentDescriptor) DescriptorUtils.getParentOfType(r10, PackageFragmentDescriptor.class, false);
        if (r12 == null) goto L13;
        if (r11 != null) goto L10;
        return false;
    L10:
        if (r11.getFqName().equals(r12.getFqName()) == false) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    }

    private static boolean isVisibleForProtectedAndPackage(ReceiverValue r5, DeclarationDescriptorWithVisibility r10, DeclarationDescriptor r11) {
        if (r10 != null) goto L6;
        $$$reportNull$$$0(0);
    L6:
        if (r11 != null) goto L9;
        $$$reportNull$$$0(1);
    L9:
        if (areInSamePackage(DescriptorUtils.unwrapFakeOverrideToAnyDeclaration(r10), r11) == false) goto L12;
        return true;
    L12:
        return DescriptorVisibilities.PROTECTED.isVisible(r5, r10, r11, false);
    }

    private static void recordVisibilityMapping(DescriptorVisibility r5) {
        visibilitiesMapping.put(r5.getDelegate(), r5);
    }

    public static DescriptorVisibility toDescriptorVisibility(Visibility r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(4);
    L4:
        DescriptorVisibility r10 = visibilitiesMapping.get(r5);
        if (r10 != null) goto L10;
        DescriptorVisibility r11 = DescriptorVisibilities.toDescriptorVisibility(r5);
        if (r11 != null) goto L9;
        $$$reportNull$$$0(5);
    L9:
        return r11;
    L10:
        return r10;
    }
}
