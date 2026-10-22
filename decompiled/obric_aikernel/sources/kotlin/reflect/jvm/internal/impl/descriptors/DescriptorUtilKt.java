package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* JADX INFO: loaded from: classes3.dex */
public final class DescriptorUtilKt {
    public static final ClassifierDescriptor getTopLevelContainingClassifier(DeclarationDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        DeclarationDescriptor r11 = r10.getContainingDeclaration();
        if (r11 != null) goto L5;
        return null;
    L5:
        if ((r10 instanceof PackageFragmentDescriptor) == false) goto L8;
        return null;
    L8:
        if (isTopLevelInPackage(r11) == true) goto L11;
        return getTopLevelContainingClassifier(r11);
    L11:
        if ((r11 instanceof ClassifierDescriptor) == true) goto L13;
        return null;
    L13:
        return (ClassifierDescriptor) r11;
    }

    public static final boolean isTopLevelInPackage(DeclarationDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getContainingDeclaration() instanceof PackageFragmentDescriptor;
    }

    public static final ClassDescriptor resolveClassByFqName(ModuleDescriptor r10, FqName r11, LookupLocation r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "fqName");
        Intrinsics.checkNotNullParameter(r12, "lookupLocation");
        if (r11.isRoot() == false) goto L5;
        return null;
    L5:
        FqName r13 = r11.parent();
        Intrinsics.checkNotNullExpressionValue(r13, "fqName.parent()");
        MemberScope r14 = r10.getPackage(r13).getMemberScope();
        Name r15 = r11.shortName();
        Intrinsics.checkNotNullExpressionValue(r15, "fqName.shortName()");
        ClassifierDescriptor r16 = r14.mo1325getContributedClassifier(r15, r12);
        if ((r16 instanceof ClassDescriptor) == false) goto L8;
        ClassDescriptor r17 = (ClassDescriptor) r16;
    L9:
        if (r17 == null) goto L11;
        return r17;
    L11:
        FqName r18 = r11.parent();
        Intrinsics.checkNotNullExpressionValue(r18, "fqName.parent()");
        ClassDescriptor r19 = resolveClassByFqName(r10, r18, r12);
        if (r19 == null) goto L16;
        MemberScope r20 = r19.getUnsubstitutedInnerClassesScope();
        if (r20 == null) goto L16;
        Name r21 = r11.shortName();
        Intrinsics.checkNotNullExpressionValue(r21, "fqName.shortName()");
        ClassifierDescriptor r22 = r20.mo1325getContributedClassifier(r21, r12);
    L18:
        if ((r22 instanceof ClassDescriptor) == true) goto L20;
        return null;
    L20:
        return (ClassDescriptor) r22;
    L16:
        r22 = null;
        goto L18
    L8:
        r17 = null;
        goto L9
    }
}
