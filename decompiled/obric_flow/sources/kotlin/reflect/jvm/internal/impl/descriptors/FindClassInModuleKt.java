package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProviderKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nfindClassInModule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 findClassInModule.kt\norg/jetbrains/kotlin/descriptors/FindClassInModuleKt\n*L\n1#1,66:1\n43#1,2:67\n*S KotlinDebug\n*F\n+ 1 findClassInModule.kt\norg/jetbrains/kotlin/descriptors/FindClassInModuleKt\n*L\n23#1:67,2\n*E\n"})
public final class FindClassInModuleKt {
    public static final ClassDescriptor findClassAcrossModuleDependencies(ModuleDescriptor r5, ClassId r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "classId");
        ClassifierDescriptor r11 = findClassifierAcrossModuleDependencies(r5, r10);
        if ((r11 instanceof ClassDescriptor) == true) goto L7;
        return null;
    L7:
        return (ClassDescriptor) r11;
    }

    public static final ClassifierDescriptor findClassifierAcrossModuleDependencies(ModuleDescriptor r10, ClassId r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "classId");
        ModuleDescriptor r5 = ResolutionAnchorProviderKt.getResolutionAnchorIfAny(r10);
        if (r5 != null) goto L20;
        PackageViewDescriptor r12 = r10.getPackage(r11.getPackageFqName());
        List<Name> r13 = r11.getRelativeClassName().pathSegments();
        ClassifierDescriptor r14 = r12.getMemberScope().mo1404getContributedClassifier((Name) CollectionsKt.first(r13), NoLookupLocation.FROM_DESERIALIZATION);
        if (r14 == null) goto L72;
        Iterator<Name> r15 = r13.subList(1, r13.size()).iterator();
    L9:
        if (r15.hasNext() == false) goto L71;
        Name r16 = r15.next();
        if ((r14 instanceof ClassDescriptor) == false) goto L75;
        ClassifierDescriptor r17 = ((ClassDescriptor) r14).getUnsubstitutedInnerClassesScope().mo1404getContributedClassifier(r16, NoLookupLocation.FROM_DESERIALIZATION);
        if ((r17 instanceof ClassDescriptor) == false) goto L16;
        r14 = (ClassDescriptor) r17;
    L17:
        if (r14 != null) goto L9;
        return null;
    L16:
        r14 = null;
        goto L17
    L75:
        return null;
    L71:
        return r14;
    L72:
        return null;
    L20:
        PackageViewDescriptor r18 = r5.getPackage(r11.getPackageFqName());
        List<Name> r19 = r11.getRelativeClassName().pathSegments();
        ClassifierDescriptor r20 = r18.getMemberScope().mo1404getContributedClassifier((Name) CollectionsKt.first(r19), NoLookupLocation.FROM_DESERIALIZATION);
        if (r20 != null) goto L23;
    L22:
        r20 = null;
    L35:
        if (r20 != null) goto L52;
        PackageViewDescriptor r21 = r10.getPackage(r11.getPackageFqName());
        List<Name> r22 = r11.getRelativeClassName().pathSegments();
        r14 = r21.getMemberScope().mo1404getContributedClassifier((Name) CollectionsKt.first(r22), NoLookupLocation.FROM_DESERIALIZATION);
        if (r14 == null) goto L73;
        Iterator<Name> r23 = r22.subList(1, r22.size()).iterator();
    L41:
        if (r23.hasNext() == false) goto L71;
        Name r24 = r23.next();
        if ((r14 instanceof ClassDescriptor) == false) goto L77;
        ClassifierDescriptor r25 = ((ClassDescriptor) r14).getUnsubstitutedInnerClassesScope().mo1404getContributedClassifier(r24, NoLookupLocation.FROM_DESERIALIZATION);
        if ((r25 instanceof ClassDescriptor) == false) goto L48;
        r14 = (ClassDescriptor) r25;
    L49:
        if (r14 != null) goto L41;
        return null;
    L48:
        r14 = null;
        goto L49
    L77:
        return null;
    L73:
        return null;
    L52:
        return r20;
    L23:
        Iterator<Name> r26 = r19.subList(1, r19.size()).iterator();
    L25:
        if (r26.hasNext() == false) goto L35;
        Name r27 = r26.next();
        if ((r20 instanceof ClassDescriptor) == false) goto L22;
        ClassifierDescriptor r28 = ((ClassDescriptor) r20).getUnsubstitutedInnerClassesScope().mo1404getContributedClassifier(r27, NoLookupLocation.FROM_DESERIALIZATION);
        if ((r28 instanceof ClassDescriptor) == false) goto L32;
        r20 = (ClassDescriptor) r28;
    L33:
        if (r20 == null) goto L22;
    L32:
        r20 = null;
        goto L33
    }

    public static final ClassDescriptor findNonGenericClassAcrossDependencies(ModuleDescriptor r5, ClassId r10, NotFoundClasses r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "classId");
        Intrinsics.checkNotNullParameter(r11, "notFoundClasses");
        ClassDescriptor r12 = findClassAcrossModuleDependencies(r5, r10);
        if (r12 == null) goto L6;
        return r12;
    L6:
        return r11.getClass(r10, SequencesKt.toList(SequencesKt.map(SequencesKt.generateSequence(r10, FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1.INSTANCE), FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2.INSTANCE)));
    }

    public static final TypeAliasDescriptor findTypeAliasAcrossModuleDependencies(ModuleDescriptor r5, ClassId r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "classId");
        ClassifierDescriptor r11 = findClassifierAcrossModuleDependencies(r5, r10);
        if ((r11 instanceof TypeAliasDescriptor) == true) goto L7;
        return null;
    L7:
        return (TypeAliasDescriptor) r11;
    }
}
