package kotlin.reflect.jvm.internal.impl;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nSpecialJvmAnnotations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpecialJvmAnnotations.kt\norg/jetbrains/kotlin/SpecialJvmAnnotations\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,42:1\n1620#2,3:43\n*S KotlinDebug\n*F\n+ 1 SpecialJvmAnnotations.kt\norg/jetbrains/kotlin/SpecialJvmAnnotations\n*L\n22#1:43,3\n*E\n"})
public final class SpecialJvmAnnotations {
    public static final SpecialJvmAnnotations INSTANCE = null;
    private static final ClassId JAVA_LANG_ANNOTATION_REPEATABLE = null;
    private static final Set<ClassId> SPECIAL_ANNOTATIONS = null;

    static {
        INSTANCE = new SpecialJvmAnnotations();
        List r5 = CollectionsKt.listOf(new FqName[]{JvmAnnotationNames.METADATA_FQ_NAME, JvmAnnotationNames.JETBRAINS_NOT_NULL_ANNOTATION, JvmAnnotationNames.JETBRAINS_NULLABLE_ANNOTATION, JvmAnnotationNames.TARGET_ANNOTATION, JvmAnnotationNames.RETENTION_ANNOTATION, JvmAnnotationNames.DOCUMENTED_ANNOTATION});
        LinkedHashSet r10 = new LinkedHashSet();
        Iterator r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(ClassId.topLevel((FqName) r11.next()));
        goto L4
    L6:
        SPECIAL_ANNOTATIONS = r10;
        JAVA_LANG_ANNOTATION_REPEATABLE = ClassId.topLevel(JvmAnnotationNames.REPEATABLE_ANNOTATION);
    }

    private SpecialJvmAnnotations() {
    }

    public final ClassId getJAVA_LANG_ANNOTATION_REPEATABLE() {
        return JAVA_LANG_ANNOTATION_REPEATABLE;
    }

    public final Set<ClassId> getSPECIAL_ANNOTATIONS() {
        return SPECIAL_ANNOTATIONS;
    }

    public final boolean isAnnotatedWithContainerMetaAnnotation(KotlinJvmBinaryClass r5) {
        Intrinsics.checkNotNullParameter(r5, "klass");
        final Ref.BooleanRef r10 = new Ref.BooleanRef();
        r5.loadClassAnnotations(new AnonymousClass1(r10), null);
        return r10.element;
    }
}
