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

/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationTypeQualifierResolver extends AbstractAnnotationTypeQualifierResolver<AnnotationDescriptor> {
    public AnnotationTypeQualifierResolver(JavaTypeEnhancementState r10) {
        Intrinsics.checkNotNullParameter(r10, "javaTypeEnhancementState");
        super(r10);
    }

    private final List<String> toEnumNames(ConstantValue<?> r10) {
        if ((r10 instanceof ArrayValue) == false) goto L9;
        List<? extends ConstantValue<?>> r11 = ((ArrayValue) r10).getValue();
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L6:
        if (r13.hasNext() == false) goto L15;
        CollectionsKt.addAll(r12, toEnumNames((ConstantValue) r13.next()));
        goto L6
    L15:
        return r12;
    L9:
        if ((r10 instanceof EnumValue) == false) goto L12;
        return CollectionsKt.listOf(((EnumValue) r10).getEnumEntryName().getIdentifier());
    L12:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver
    public /* bridge */ /* synthetic */ Iterable enumArguments(AnnotationDescriptor r10, boolean r11) {
        return enumArguments2(r10, r11);
    }

    /* JADX INFO: renamed from: enumArguments, reason: avoid collision after fix types in other method */
    protected Iterable<String> enumArguments2(AnnotationDescriptor r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Map<Name, ConstantValue<?>> r12 = r10.getAllValueArguments();
        ArrayList r13 = new ArrayList();
        Iterator<Map.Entry<Name, ConstantValue<?>>> r14 = r12.entrySet().iterator();
    L4:
        if (r14.hasNext() == false) goto L13;
        Map.Entry<Name, ConstantValue<?>> r15 = r14.next();
        Name r16 = r15.getKey();
        ConstantValue<?> r17 = r15.getValue();
        if (r11 == true) goto L8;
    L11:
        List<String> r18 = toEnumNames(r17);
    L12:
        CollectionsKt.addAll(r13, r18);
        goto L4
    L8:
        if (Intrinsics.areEqual(r16, JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME) == true) goto L11;
        r18 = CollectionsKt.emptyList();
        goto L12
    L13:
        return r13;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver
    public /* bridge */ /* synthetic */ FqName getFqName(AnnotationDescriptor r10) {
        return getFqName2(r10);
    }

    /* JADX INFO: renamed from: getFqName, reason: avoid collision after fix types in other method */
    protected FqName getFqName2(AnnotationDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getFqName();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver
    public /* bridge */ /* synthetic */ Object getKey(AnnotationDescriptor r10) {
        return getKey2(r10);
    }

    /* JADX INFO: renamed from: getKey, reason: avoid collision after fix types in other method */
    protected Object getKey2(AnnotationDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ClassDescriptor r11 = DescriptorUtilsKt.getAnnotationClass(r10);
        Intrinsics.checkNotNull(r11);
        return r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver
    public /* bridge */ /* synthetic */ Iterable<AnnotationDescriptor> getMetaAnnotations(AnnotationDescriptor r10) {
        return getMetaAnnotations2(r10);
    }

    /* JADX INFO: renamed from: getMetaAnnotations, reason: avoid collision after fix types in other method */
    protected Iterable<AnnotationDescriptor> getMetaAnnotations2(AnnotationDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ClassDescriptor r11 = DescriptorUtilsKt.getAnnotationClass(r10);
        if (r11 == null) goto L8;
        Annotations r12 = r11.getAnnotations();
        if (r12 == null) goto L8;
        return r12;
    L8:
        return CollectionsKt.emptyList();
    }
}
