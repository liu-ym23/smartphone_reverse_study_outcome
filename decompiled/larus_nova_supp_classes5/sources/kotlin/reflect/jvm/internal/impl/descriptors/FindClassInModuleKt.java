package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProviderKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class FindClassInModuleKt {
    public static /* synthetic */ int accessor$FindClassInModuleKt$lambda0(ClassId r0) {
        return findNonGenericClassAcrossDependencies$lambda$1(r0);
    }

    private static final int findNonGenericClassAcrossDependencies$lambda$1(ClassId r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return 0;
    }

    public static final ClassDescriptor findClassAcrossModuleDependencies(ModuleDescriptor r1, ClassId r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "classId");
        ClassifierDescriptor r3 = findClassifierAcrossModuleDependencies(r1, r2);
        if ((r3 instanceof ClassDescriptor) == true) goto L7;
        return null;
    L7:
        return (ClassDescriptor) r3;
    }

    public static final ClassifierDescriptor findClassifierAcrossModuleDependencies(ModuleDescriptor r6, ClassId r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "classId");
        ModuleDescriptor r0 = ResolutionAnchorProviderKt.getResolutionAnchorIfAny(r6);
        if (r0 != null) goto L20;
        PackageViewDescriptor r8 = r6.getPackage(r7.getPackageFqName());
        List<Name> r9 = r7.getRelativeClassName().pathSegments();
        ClassifierDescriptor r10 = r8.getMemberScope().mo383getContributedClassifier((Name) CollectionsKt.first(r9), NoLookupLocation.FROM_DESERIALIZATION);
        if (r10 == null) goto L72;
        Iterator<Name> r11 = r9.subList(1, r9.size()).iterator();
    L9:
        if (r11.hasNext() == false) goto L71;
        Name r1 = r11.next();
        if ((r10 instanceof ClassDescriptor) == false) goto L75;
        MemberScope r12 = ((ClassDescriptor) r10).getUnsubstitutedInnerClassesScope();
        Intrinsics.checkNotNull(r1);
        ClassifierDescriptor r13 = r12.mo383getContributedClassifier(r1, NoLookupLocation.FROM_DESERIALIZATION);
        if ((r13 instanceof ClassDescriptor) == false) goto L16;
        r10 = (ClassDescriptor) r13;
    L17:
        if (r10 != null) goto L9;
        return null;
    L16:
        r10 = null;
        goto L17
    L75:
        return null;
    L71:
        return r10;
    L72:
        return null;
    L20:
        PackageViewDescriptor r2 = r0.getPackage(r7.getPackageFqName());
        List<Name> r3 = r7.getRelativeClassName().pathSegments();
        ClassifierDescriptor r4 = r2.getMemberScope().mo383getContributedClassifier((Name) CollectionsKt.first(r3), NoLookupLocation.FROM_DESERIALIZATION);
        if (r4 != null) goto L23;
    L22:
        r4 = null;
    L35:
        if (r4 != null) goto L52;
        PackageViewDescriptor r14 = r6.getPackage(r7.getPackageFqName());
        List<Name> r15 = r7.getRelativeClassName().pathSegments();
        r10 = r14.getMemberScope().mo383getContributedClassifier((Name) CollectionsKt.first(r15), NoLookupLocation.FROM_DESERIALIZATION);
        if (r10 == null) goto L73;
        Iterator<Name> r16 = r15.subList(1, r15.size()).iterator();
    L41:
        if (r16.hasNext() == false) goto L71;
        Name r5 = r16.next();
        if ((r10 instanceof ClassDescriptor) == false) goto L77;
        MemberScope r17 = ((ClassDescriptor) r10).getUnsubstitutedInnerClassesScope();
        Intrinsics.checkNotNull(r5);
        ClassifierDescriptor r18 = r17.mo383getContributedClassifier(r5, NoLookupLocation.FROM_DESERIALIZATION);
        if ((r18 instanceof ClassDescriptor) == false) goto L48;
        r10 = (ClassDescriptor) r18;
    L49:
        if (r10 != null) goto L41;
        return null;
    L48:
        r10 = null;
        goto L49
    L77:
        return null;
    L73:
        return null;
    L52:
        return r4;
    L23:
        Iterator<Name> r19 = r3.subList(1, r3.size()).iterator();
    L25:
        if (r19.hasNext() == false) goto L35;
        Name r20 = r19.next();
        if ((r4 instanceof ClassDescriptor) == false) goto L22;
        MemberScope r21 = ((ClassDescriptor) r4).getUnsubstitutedInnerClassesScope();
        Intrinsics.checkNotNull(r20);
        ClassifierDescriptor r22 = r21.mo383getContributedClassifier(r20, NoLookupLocation.FROM_DESERIALIZATION);
        if ((r22 instanceof ClassDescriptor) == false) goto L32;
        r4 = (ClassDescriptor) r22;
    L33:
        if (r4 != null) goto L25;
    L32:
        r4 = null;
        goto L33
    }

    public static final TypeAliasDescriptor findTypeAliasAcrossModuleDependencies(ModuleDescriptor r1, ClassId r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "classId");
        ClassifierDescriptor r3 = findClassifierAcrossModuleDependencies(r1, r2);
        if ((r3 instanceof TypeAliasDescriptor) == true) goto L7;
        return null;
    L7:
        return (TypeAliasDescriptor) r3;
    }

    public static final ClassDescriptor findNonGenericClassAcrossDependencies(ModuleDescriptor r1, ClassId r2, NotFoundClasses r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "classId");
        Intrinsics.checkNotNullParameter(r3, "notFoundClasses");
        ClassDescriptor r4 = findClassAcrossModuleDependencies(r1, r2);
        if (r4 == null) goto L6;
        return r4;
    L6:
        return r3.getClass(r2, SequencesKt.toList(SequencesKt.map(SequencesKt.generateSequence(r2, findNonGenericClassAcrossDependencies.typeParametersCount.1.INSTANCE), FindClassInModuleKt$.Lambda.0.INSTANCE)));
    }
}
