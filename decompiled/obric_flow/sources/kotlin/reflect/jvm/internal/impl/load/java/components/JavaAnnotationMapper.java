package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes3.dex */
public final class JavaAnnotationMapper {
    private static final Name DEPRECATED_ANNOTATION_MESSAGE = null;
    public static final JavaAnnotationMapper INSTANCE = null;
    private static final Name RETENTION_ANNOTATION_VALUE = null;
    private static final Name TARGET_ANNOTATION_ALLOWED_TARGETS = null;
    private static final Map<FqName, FqName> kotlinToJavaNameMap = null;

    static {
        INSTANCE = new JavaAnnotationMapper();
        DEPRECATED_ANNOTATION_MESSAGE = Name.identifier("message");
        TARGET_ANNOTATION_ALLOWED_TARGETS = Name.identifier("allowedTargets");
        RETENTION_ANNOTATION_VALUE = Name.identifier("value");
        kotlinToJavaNameMap = MapsKt.mapOf(new Pair[]{TuplesKt.to(StandardNames.FqNames.target, JvmAnnotationNames.TARGET_ANNOTATION), TuplesKt.to(StandardNames.FqNames.retention, JvmAnnotationNames.RETENTION_ANNOTATION), TuplesKt.to(StandardNames.FqNames.mustBeDocumented, JvmAnnotationNames.DOCUMENTED_ANNOTATION)});
    }

    private JavaAnnotationMapper() {
    }

    public static /* synthetic */ AnnotationDescriptor mapOrResolveJavaAnnotation$default(JavaAnnotationMapper r5, JavaAnnotation r10, LazyJavaResolverContext r11, boolean r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r12 = false;
    L6:
        return r5.mapOrResolveJavaAnnotation(r10, r11, r12);
    }

    public final AnnotationDescriptor findMappedJavaAnnotation(FqName r10, JavaAnnotationOwner r11, LazyJavaResolverContext r12) {
        Intrinsics.checkNotNullParameter(r10, "kotlinName");
        Intrinsics.checkNotNullParameter(r11, "annotationOwner");
        Intrinsics.checkNotNullParameter(r12, "c");
        if (Intrinsics.areEqual(r10, StandardNames.FqNames.deprecated) == false) goto L10;
        JavaAnnotation r13 = r11.findAnnotation(JvmAnnotationNames.DEPRECATED_ANNOTATION);
        if (r13 != null) goto L9;
        if (r11.isDeprecatedInJavaDoc() == false) goto L10;
    L9:
        return new JavaDeprecatedAnnotationDescriptor(r13, r12);
    L10:
        FqName r14 = kotlinToJavaNameMap.get(r10);
        if (r14 == null) goto L16;
        JavaAnnotation r5 = r11.findAnnotation(r14);
        if (r5 != null) goto L15;
        return null;
    L15:
        return mapOrResolveJavaAnnotation$default(INSTANCE, r5, r12, false, 4, null);
    L16:
        return null;
    }

    public final Name getDEPRECATED_ANNOTATION_MESSAGE$descriptors_jvm() {
        return DEPRECATED_ANNOTATION_MESSAGE;
    }

    public final Name getRETENTION_ANNOTATION_VALUE$descriptors_jvm() {
        return RETENTION_ANNOTATION_VALUE;
    }

    public final Name getTARGET_ANNOTATION_ALLOWED_TARGETS$descriptors_jvm() {
        return TARGET_ANNOTATION_ALLOWED_TARGETS;
    }

    public final AnnotationDescriptor mapOrResolveJavaAnnotation(JavaAnnotation r5, LazyJavaResolverContext r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        Intrinsics.checkNotNullParameter(r10, "c");
        ClassId r12 = r5.getClassId();
        if (Intrinsics.areEqual(r12, ClassId.topLevel(JvmAnnotationNames.TARGET_ANNOTATION)) == false) goto L6;
        return new JavaTargetAnnotationDescriptor(r5, r10);
    L6:
        if (Intrinsics.areEqual(r12, ClassId.topLevel(JvmAnnotationNames.RETENTION_ANNOTATION)) == false) goto L9;
        return new JavaRetentionAnnotationDescriptor(r5, r10);
    L9:
        if (Intrinsics.areEqual(r12, ClassId.topLevel(JvmAnnotationNames.DOCUMENTED_ANNOTATION)) == false) goto L12;
        return new JavaAnnotationDescriptor(r10, r5, StandardNames.FqNames.mustBeDocumented);
    L12:
        if (Intrinsics.areEqual(r12, ClassId.topLevel(JvmAnnotationNames.DEPRECATED_ANNOTATION)) == false) goto L15;
        return null;
    L15:
        return new LazyJavaAnnotationDescriptor(r10, r5, r11);
    }
}
