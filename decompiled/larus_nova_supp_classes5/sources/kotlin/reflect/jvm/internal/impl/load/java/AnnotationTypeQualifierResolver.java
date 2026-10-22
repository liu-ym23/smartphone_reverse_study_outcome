package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class AnnotationTypeQualifierResolver extends AbstractAnnotationTypeQualifierResolver<AnnotationDescriptor> {
    public AnnotationTypeQualifierResolver(JavaTypeEnhancementState r2) {
        Intrinsics.checkNotNullParameter(r2, "javaTypeEnhancementState");
        super(r2);
    }

    private final List<String> toEnumNames(ConstantValue<?> r3) {
        if ((r3 instanceof ArrayValue) == false) goto L9;
        Iterable r4 = (Iterable) ((ArrayValue) r3).getValue();
        ArrayList r0 = new ArrayList();
        Iterator r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L15;
        CollectionsKt.addAll(r0, toEnumNames((ConstantValue) r5.next()));
        goto L6
    L15:
        return r0;
    L9:
        if ((r3 instanceof EnumValue) == false) goto L12;
        return CollectionsKt.listOf(((EnumValue) r3).getEnumEntryName().getIdentifier());
    L12:
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: renamed from: getFqName, reason: avoid collision after fix types in other method */
    public FqName getFqName2(AnnotationDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return r2.getFqName();
    }

    /* JADX INFO: renamed from: getKey, reason: avoid collision after fix types in other method */
    public Object getKey2(AnnotationDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ClassDescriptor r3 = DescriptorUtilsKt.getAnnotationClass(r2);
        Intrinsics.checkNotNull(r3);
        return r3;
    }

    /* JADX INFO: renamed from: getMetaAnnotations, reason: avoid collision after fix types in other method */
    public Iterable<AnnotationDescriptor> getMetaAnnotations2(AnnotationDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ClassDescriptor r3 = DescriptorUtilsKt.getAnnotationClass(r2);
        if (r3 == null) goto L8;
        Annotations r4 = r3.getAnnotations();
        if (r4 == null) goto L8;
        return r4;
    L8:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver
    public /* bridge */ /* synthetic */ FqName getFqName(AnnotationDescriptor r1) {
        return getFqName2(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver
    public /* bridge */ /* synthetic */ Object getKey(AnnotationDescriptor r1) {
        return getKey2(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver
    public /* bridge */ /* synthetic */ Iterable<AnnotationDescriptor> getMetaAnnotations(AnnotationDescriptor r1) {
        return getMetaAnnotations2(r1);
    }

    /* JADX INFO: renamed from: enumArguments, reason: avoid collision after fix types in other method */
    public Iterable<String> enumArguments2(AnnotationDescriptor r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Map r7 = r5.getAllValueArguments();
        ArrayList r0 = new ArrayList();
        Iterator r8 = r7.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L13;
        Map.Entry r1 = (Map.Entry) r8.next();
        Name r2 = (Name) r1.getKey();
        ConstantValue<?> r3 = (ConstantValue) r1.getValue();
        if (r6 == true) goto L8;
    L11:
        List<String> r4 = toEnumNames(r3);
    L12:
        CollectionsKt.addAll(r0, r4);
        goto L4
    L8:
        if (Intrinsics.areEqual(r2, JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME) == true) goto L11;
        r4 = CollectionsKt.emptyList();
        goto L12
    L13:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver
    public /* bridge */ /* synthetic */ Iterable enumArguments(AnnotationDescriptor r1, boolean r2) {
        return enumArguments2(r1, r2);
    }
}
