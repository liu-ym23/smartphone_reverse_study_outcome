package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nSealedClassInheritorsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SealedClassInheritorsProvider.kt\norg/jetbrains/kotlin/resolve/CliSealedClassInheritorsProvider\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,86:1\n179#2,2:87\n1045#3:89\n*S KotlinDebug\n*F\n+ 1 SealedClassInheritorsProvider.kt\norg/jetbrains/kotlin/resolve/CliSealedClassInheritorsProvider\n*L\n73#1:87,2\n82#1:89\n*E\n"})
public final class CliSealedClassInheritorsProvider extends SealedClassInheritorsProvider {
    public static final CliSealedClassInheritorsProvider INSTANCE = null;

    static {
        INSTANCE = new CliSealedClassInheritorsProvider();
    }

    private CliSealedClassInheritorsProvider() {
    }

    private static final void computeSealedSubclasses$collectSubclasses(ClassDescriptor r5, LinkedHashSet<ClassDescriptor> r10, MemberScope r11, boolean r12) {
        Iterator r13 = ResolutionScope.DefaultImpls.getContributedDescriptors$default(r11, DescriptorKindFilter.CLASSIFIERS, null, 2, null).iterator();
    L4:
        if (r13.hasNext() == false) goto L23;
        DeclarationDescriptor r14 = (DeclarationDescriptor) r13.next();
        if ((r14 instanceof ClassDescriptor) == false) goto L4;
        ClassDescriptor r15 = (ClassDescriptor) r14;
        if (r15.isExpect() == false) goto L16;
        ClassifierDescriptor r16 = r11.mo1404getContributedClassifier(r15.getName(), NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
        if ((r16 instanceof ClassDescriptor) == false) goto L13;
        r15 = (ClassDescriptor) r16;
        goto L16
    L13:
        if ((r16 instanceof TypeAliasDescriptor) == false) goto L15;
        r15 = ((TypeAliasDescriptor) r16).getClassDescriptor();
        goto L16
    L15:
        r15 = null;
    L16:
        if (r15 == null) goto L4;
        if (DescriptorUtils.isDirectSubclass(r15, r5) == false) goto L21;
        r10.add(r15);
    L21:
        if (r12 == false) goto L4;
        computeSealedSubclasses$collectSubclasses(r5, r10, r15.getUnsubstitutedInnerClassesScope(), r12);
        goto L4
    }

    public Collection<ClassDescriptor> computeSealedSubclasses(ClassDescriptor r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "sealedClass");
        if (r5.getModality() != Modality.SEALED) goto L5;
        LinkedHashSet r11 = new LinkedHashSet();
        if (r10 == true) goto L9;
        DeclarationDescriptor r12 = r5.getContainingDeclaration();
    L18:
        if ((r12 instanceof PackageFragmentDescriptor) == false) goto L20;
        computeSealedSubclasses$collectSubclasses(r5, r11, ((PackageFragmentDescriptor) r12).getMemberScope(), r10);
    L20:
        computeSealedSubclasses$collectSubclasses(r5, r11, r5.getUnsubstitutedInnerClassesScope(), true);
        return CollectionsKt.sortedWith(r11, new CliSealedClassInheritorsProvider$computeSealedSubclasses$$inlined$sortedBy$1());
    L9:
        Iterator<DeclarationDescriptor> r13 = DescriptorUtilsKt.getParents(r5).iterator();
    L11:
        if (r13.hasNext() == false) goto L15;
        DeclarationDescriptor r14 = r13.next();
        if ((r14 instanceof PackageFragmentDescriptor) == false) goto L11;
    L16:
        r12 = r14;
        goto L18
    L15:
        r14 = null;
        goto L16
    L5:
        return CollectionsKt.emptyList();
    }
}
