package kotlin.reflect.jvm.internal.impl.descriptors;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProviderKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class FindClassInModuleKt {
    public static final ClassDescriptor findClassAcrossModuleDependencies(ModuleDescriptor r10, ClassId r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "classId");
        ClassifierDescriptor r12 = findClassifierAcrossModuleDependencies(r10, r11);
        if ((r12 instanceof ClassDescriptor) == true) goto L7;
        return null;
    L7:
        return (ClassDescriptor) r12;
    }

    public static final ClassifierDescriptor findClassifierAcrossModuleDependencies(ModuleDescriptor r10, ClassId r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "classId");
        ModuleDescriptor r12 = ResolutionAnchorProviderKt.getResolutionAnchorIfAny(r10);
        if (r12 != null) goto L20;
        FqName r13 = r11.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r13, "classId.packageFqName");
        PackageViewDescriptor r14 = r10.getPackage(r13);
        List<Name> r15 = r11.getRelativeClassName().pathSegments();
        Intrinsics.checkNotNullExpressionValue(r15, "classId.relativeClassName.pathSegments()");
        MemberScope r16 = r14.getMemberScope();
        Object r17 = CollectionsKt.first(r15);
        Intrinsics.checkNotNullExpressionValue(r17, "segments.first()");
        ClassifierDescriptor r18 = r16.mo1325getContributedClassifier((Name) r17, NoLookupLocation.FROM_DESERIALIZATION);
        if (r18 == null) goto L72;
        Iterator<Name> r19 = r15.subList(1, r15.size()).iterator();
    L9:
        if (r19.hasNext() == false) goto L71;
        Name r20 = r19.next();
        if ((r18 instanceof ClassDescriptor) == false) goto L75;
        MemberScope r110 = ((ClassDescriptor) r18).getUnsubstitutedInnerClassesScope();
        Intrinsics.checkNotNullExpressionValue(r20, ActivityLifecycle.NAME);
        ClassifierDescriptor r111 = r110.mo1325getContributedClassifier(r20, NoLookupLocation.FROM_DESERIALIZATION);
        if ((r111 instanceof ClassDescriptor) == false) goto L16;
        r18 = (ClassDescriptor) r111;
    L17:
        if (r18 != null) goto L9;
        return null;
    L16:
        r18 = null;
        goto L17
    L75:
        return null;
    L71:
        return r18;
    L72:
        return null;
    L20:
        FqName r21 = r11.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r21, "classId.packageFqName");
        PackageViewDescriptor r22 = r12.getPackage(r21);
        List<Name> r23 = r11.getRelativeClassName().pathSegments();
        Intrinsics.checkNotNullExpressionValue(r23, "classId.relativeClassName.pathSegments()");
        MemberScope r24 = r22.getMemberScope();
        Object r25 = CollectionsKt.first(r23);
        Intrinsics.checkNotNullExpressionValue(r25, "segments.first()");
        ClassifierDescriptor r26 = r24.mo1325getContributedClassifier((Name) r25, NoLookupLocation.FROM_DESERIALIZATION);
        if (r26 != null) goto L23;
    L22:
        r26 = null;
    L35:
        if (r26 != null) goto L52;
        FqName r27 = r11.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r27, "classId.packageFqName");
        PackageViewDescriptor r112 = r10.getPackage(r27);
        List<Name> r113 = r11.getRelativeClassName().pathSegments();
        Intrinsics.checkNotNullExpressionValue(r113, "classId.relativeClassName.pathSegments()");
        MemberScope r114 = r112.getMemberScope();
        Object r28 = CollectionsKt.first(r113);
        Intrinsics.checkNotNullExpressionValue(r28, "segments.first()");
        r18 = r114.mo1325getContributedClassifier((Name) r28, NoLookupLocation.FROM_DESERIALIZATION);
        if (r18 == null) goto L73;
        Iterator<Name> r115 = r113.subList(1, r113.size()).iterator();
    L41:
        if (r115.hasNext() == false) goto L71;
        Name r29 = r115.next();
        if ((r18 instanceof ClassDescriptor) == false) goto L77;
        MemberScope r116 = ((ClassDescriptor) r18).getUnsubstitutedInnerClassesScope();
        Intrinsics.checkNotNullExpressionValue(r29, ActivityLifecycle.NAME);
        ClassifierDescriptor r117 = r116.mo1325getContributedClassifier(r29, NoLookupLocation.FROM_DESERIALIZATION);
        if ((r117 instanceof ClassDescriptor) == false) goto L48;
        r18 = (ClassDescriptor) r117;
    L49:
        if (r18 != null) goto L41;
        return null;
    L48:
        r18 = null;
        goto L49
    L77:
        return null;
    L73:
        return null;
    L52:
        return r26;
    L23:
        Iterator<Name> r30 = r23.subList(1, r23.size()).iterator();
    L25:
        if (r30.hasNext() == false) goto L35;
        Name r31 = r30.next();
        if ((r26 instanceof ClassDescriptor) == false) goto L22;
        MemberScope r32 = ((ClassDescriptor) r26).getUnsubstitutedInnerClassesScope();
        Intrinsics.checkNotNullExpressionValue(r31, ActivityLifecycle.NAME);
        ClassifierDescriptor r33 = r32.mo1325getContributedClassifier(r31, NoLookupLocation.FROM_DESERIALIZATION);
        if ((r33 instanceof ClassDescriptor) == false) goto L32;
        r26 = (ClassDescriptor) r33;
    L33:
        if (r26 == null) goto L22;
    L32:
        r26 = null;
        goto L33
    }

    public static final ClassDescriptor findNonGenericClassAcrossDependencies(ModuleDescriptor r10, ClassId r11, NotFoundClasses r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "classId");
        Intrinsics.checkNotNullParameter(r12, "notFoundClasses");
        ClassDescriptor r13 = findClassAcrossModuleDependencies(r10, r11);
        if (r13 == null) goto L6;
        return r13;
    L6:
        return r12.getClass(r11, SequencesKt.toList(SequencesKt.map(SequencesKt.generateSequence(r11, FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1.INSTANCE), FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2.INSTANCE)));
    }

    public static final TypeAliasDescriptor findTypeAliasAcrossModuleDependencies(ModuleDescriptor r10, ClassId r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "classId");
        ClassifierDescriptor r12 = findClassifierAcrossModuleDependencies(r10, r11);
        if ((r12 instanceof TypeAliasDescriptor) == true) goto L7;
        return null;
    L7:
        return (TypeAliasDescriptor) r12;
    }
}
