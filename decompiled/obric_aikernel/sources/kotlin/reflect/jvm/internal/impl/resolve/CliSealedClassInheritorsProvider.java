package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;

/* JADX INFO: loaded from: classes3.dex */
public final class CliSealedClassInheritorsProvider extends SealedClassInheritorsProvider {
    public static final CliSealedClassInheritorsProvider INSTANCE = null;

    static {
        INSTANCE = new CliSealedClassInheritorsProvider();
    }

    private CliSealedClassInheritorsProvider() {
    }

    private static final void computeSealedSubclasses$collectSubclasses(ClassDescriptor r10, LinkedHashSet<ClassDescriptor> r11, MemberScope r12, boolean r13) {
        Iterator r14 = ResolutionScope.DefaultImpls.getContributedDescriptors$default(r12, DescriptorKindFilter.CLASSIFIERS, null, 2, null).iterator();
    L4:
        if (r14.hasNext() == false) goto L23;
        DeclarationDescriptor r15 = (DeclarationDescriptor) r14.next();
        if ((r15 instanceof ClassDescriptor) == false) goto L4;
        ClassDescriptor r16 = (ClassDescriptor) r15;
        if (r16.isExpect() == false) goto L16;
        Name r17 = r16.getName();
        Intrinsics.checkNotNullExpressionValue(r17, "descriptor.name");
        ClassifierDescriptor r18 = r12.mo1325getContributedClassifier(r17, NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
        if ((r18 instanceof ClassDescriptor) == false) goto L13;
        r16 = (ClassDescriptor) r18;
        goto L16
    L13:
        if ((r18 instanceof TypeAliasDescriptor) == false) goto L15;
        r16 = ((TypeAliasDescriptor) r18).getClassDescriptor();
        goto L16
    L15:
        r16 = null;
    L16:
        if (r16 == null) goto L4;
        if (DescriptorUtils.isDirectSubclass(r16, r10) == false) goto L21;
        r11.add(r16);
    L21:
        if (r13 == false) goto L4;
        MemberScope r19 = r16.getUnsubstitutedInnerClassesScope();
        Intrinsics.checkNotNullExpressionValue(r19, "refinedDescriptor.unsubstitutedInnerClassesScope");
        computeSealedSubclasses$collectSubclasses(r10, r11, r19, r13);
        goto L4
    }

    public Collection<ClassDescriptor> computeSealedSubclasses(ClassDescriptor r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "sealedClass");
        if (r10.getModality() != Modality.SEALED) goto L5;
        LinkedHashSet r12 = new LinkedHashSet();
        if (r11 == true) goto L9;
        DeclarationDescriptor r13 = r10.getContainingDeclaration();
    L18:
        if ((r13 instanceof PackageFragmentDescriptor) == false) goto L20;
        computeSealedSubclasses$collectSubclasses(r10, r12, ((PackageFragmentDescriptor) r13).getMemberScope(), r11);
    L20:
        MemberScope r14 = r10.getUnsubstitutedInnerClassesScope();
        Intrinsics.checkNotNullExpressionValue(r14, "sealedClass.unsubstitutedInnerClassesScope");
        computeSealedSubclasses$collectSubclasses(r10, r12, r14, true);
        return CollectionsKt.sortedWith(r12, new CliSealedClassInheritorsProvider$computeSealedSubclasses$$inlined$sortedBy$1());
    L9:
        Iterator<DeclarationDescriptor> r15 = DescriptorUtilsKt.getParents(r10).iterator();
    L11:
        if (r15.hasNext() == false) goto L15;
        DeclarationDescriptor r16 = r15.next();
        if ((r16 instanceof PackageFragmentDescriptor) == false) goto L11;
    L16:
        r13 = r16;
        goto L18
    L15:
        r16 = null;
        goto L16
    L5:
        return CollectionsKt.emptyList();
    }
}
