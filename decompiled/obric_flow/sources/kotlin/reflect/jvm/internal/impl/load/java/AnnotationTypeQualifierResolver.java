package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension({"SMAP\nAnnotationTypeQualifierResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnnotationTypeQualifierResolver.kt\norg/jetbrains/kotlin/load/java/AnnotationTypeQualifierResolver\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,54:1\n76#2:55\n96#2,5:56\n1360#3:61\n1446#3,5:62\n*S KotlinDebug\n*F\n+ 1 AnnotationTypeQualifierResolver.kt\norg/jetbrains/kotlin/load/java/AnnotationTypeQualifierResolver\n*L\n40#1:55\n40#1:56,5\n49#1:61\n49#1:62,5\n*E\n"})
public final class AnnotationTypeQualifierResolver extends AbstractAnnotationTypeQualifierResolver<AnnotationDescriptor> {
    public AnnotationTypeQualifierResolver(JavaTypeEnhancementState r5) {
        Intrinsics.checkNotNullParameter(r5, "javaTypeEnhancementState");
        super(r5);
    }

    private final List<String> toEnumNames(ConstantValue<?> r5) {
        if ((r5 instanceof ArrayValue) == false) goto L9;
        List<? extends ConstantValue<?>> r10 = ((ArrayValue) r5).getValue();
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L6:
        if (r12.hasNext() == false) goto L15;
        CollectionsKt.a(r11, toEnumNames((ConstantValue) r12.next()));
        goto L6
    L15:
        return r11;
    L9:
        if ((r5 instanceof EnumValue) == false) goto L12;
        return CollectionsKt.listOf(((EnumValue) r5).getEnumEntryName().getIdentifier());
    L12:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver
    public /* bridge */ /* synthetic */ Iterable enumArguments(AnnotationDescriptor r5, boolean r10) {
        return enumArguments2(r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver
    public /* bridge */ /* synthetic */ FqName getFqName(AnnotationDescriptor r5) {
        return getFqName2(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver
    public /* bridge */ /* synthetic */ Object getKey(AnnotationDescriptor r5) {
        return getKey2(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver
    public /* bridge */ /* synthetic */ Iterable<AnnotationDescriptor> getMetaAnnotations(AnnotationDescriptor r5) {
        return getMetaAnnotations2(r5);
    }

    /* JADX INFO: renamed from: enumArguments, reason: avoid collision after fix types in other method */
    public Iterable<String> enumArguments2(AnnotationDescriptor r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Map<Name, ConstantValue<?>> r11 = r5.getAllValueArguments();
        ArrayList r12 = new ArrayList();
        Iterator<Map.Entry<Name, ConstantValue<?>>> r13 = r11.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L13;
        Map.Entry<Name, ConstantValue<?>> r14 = r13.next();
        Name r15 = r14.getKey();
        ConstantValue<?> r16 = r14.getValue();
        if (r10 == true) goto L8;
    L11:
        List<String> r17 = toEnumNames(r16);
    L12:
        CollectionsKt.a(r12, r17);
        goto L4
    L8:
        if (Intrinsics.areEqual(r15, JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME) == true) goto L11;
        r17 = CollectionsKt.emptyList();
        goto L12
    L13:
        return r12;
    }

    /* JADX INFO: renamed from: getFqName, reason: avoid collision after fix types in other method */
    public FqName getFqName2(AnnotationDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.getFqName();
    }

    /* JADX INFO: renamed from: getKey, reason: avoid collision after fix types in other method */
    public Object getKey2(AnnotationDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ClassDescriptor r10 = DescriptorUtilsKt.getAnnotationClass(r5);
        Intrinsics.checkNotNull(r10);
        return r10;
    }

    /* JADX INFO: renamed from: getMetaAnnotations, reason: avoid collision after fix types in other method */
    public Iterable<AnnotationDescriptor> getMetaAnnotations2(AnnotationDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ClassDescriptor r10 = DescriptorUtilsKt.getAnnotationClass(r5);
        if (r10 == null) goto L8;
        Annotations r11 = r10.getAnnotations();
        if (r11 == null) goto L8;
        return r11;
    L8:
        return CollectionsKt.emptyList();
    }
}
