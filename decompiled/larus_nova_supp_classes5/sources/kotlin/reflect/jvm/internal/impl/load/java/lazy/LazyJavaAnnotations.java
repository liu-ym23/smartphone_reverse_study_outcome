package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class LazyJavaAnnotations implements Annotations {
    private final MemoizedFunctionToNullable<JavaAnnotation, AnnotationDescriptor> annotationDescriptors;
    private final JavaAnnotationOwner annotationOwner;
    private final boolean areAnnotationsFreshlySupported;
    private final LazyJavaResolverContext c;

    public static /* synthetic */ AnnotationDescriptor accessor$LazyJavaAnnotations$lambda0(LazyJavaAnnotations r0, JavaAnnotation r1) {
        return annotationDescriptors$lambda$0(r0, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        if (this.annotationOwner.getAnnotations().isEmpty() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.annotationOwner.isDeprecatedInJavaDoc() == true) goto L7;
        return true;
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotationDescriptor> iterator() {
        return SequencesKt.filterNotNull(SequencesKt.plus(SequencesKt.map(CollectionsKt.asSequence(this.annotationOwner.getAnnotations()), this.annotationDescriptors), JavaAnnotationMapper.INSTANCE.findMappedJavaAnnotation(StandardNames.FqNames.deprecated, this.annotationOwner, this.c))).iterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    /* JADX INFO: renamed from: findAnnotation */
    public AnnotationDescriptor mo373findAnnotation(FqName r4) {
        Intrinsics.checkNotNullParameter(r4, "fqName");
        JavaAnnotation r0 = this.annotationOwner.findAnnotation(r4);
        if (r0 == null) goto L7;
        AnnotationDescriptor r1 = (AnnotationDescriptor) this.annotationDescriptors.invoke(r0);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return JavaAnnotationMapper.INSTANCE.findMappedJavaAnnotation(r4, this.annotationOwner, this.c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(FqName r1) {
        return Annotations.DefaultImpls.hasAnnotation(this, r1);
    }

    private static final AnnotationDescriptor annotationDescriptors$lambda$0(LazyJavaAnnotations r2, JavaAnnotation r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "annotation");
        return JavaAnnotationMapper.INSTANCE.mapOrResolveJavaAnnotation(r3, r2.c, r2.areAnnotationsFreshlySupported);
    }

    public LazyJavaAnnotations(LazyJavaResolverContext r2, JavaAnnotationOwner r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "c");
        Intrinsics.checkNotNullParameter(r3, "annotationOwner");
        this.c = r2;
        this.annotationOwner = r3;
        this.areAnnotationsFreshlySupported = r4;
        this.annotationDescriptors = r2.getComponents().getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaAnnotations$$Lambda$0(this));
    }

    public /* synthetic */ LazyJavaAnnotations(LazyJavaResolverContext r1, JavaAnnotationOwner r2, boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        this(r1, r2, r3);
    }
}
