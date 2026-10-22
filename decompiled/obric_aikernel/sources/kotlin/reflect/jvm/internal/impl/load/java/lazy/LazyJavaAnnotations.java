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

/* JADX INFO: loaded from: classes3.dex */
public final class LazyJavaAnnotations implements Annotations {
    private final MemoizedFunctionToNullable<JavaAnnotation, AnnotationDescriptor> annotationDescriptors;
    private final JavaAnnotationOwner annotationOwner;
    private final boolean areAnnotationsFreshlySupported;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LazyJavaResolverContext f10206c;

    public LazyJavaAnnotations(LazyJavaResolverContext r10, JavaAnnotationOwner r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "c");
        Intrinsics.checkNotNullParameter(r11, "annotationOwner");
        this.f10206c = r10;
        this.annotationOwner = r11;
        this.areAnnotationsFreshlySupported = r12;
        this.annotationDescriptors = r10.getComponents().getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaAnnotations$annotationDescriptors$1(this));
    }

    public /* synthetic */ LazyJavaAnnotations(LazyJavaResolverContext r10, JavaAnnotationOwner r11, boolean r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = false;
    L5:
        this(r10, r11, r12);
    }

    public static final /* synthetic */ boolean access$getAreAnnotationsFreshlySupported$p(LazyJavaAnnotations r10) {
        return r10.areAnnotationsFreshlySupported;
    }

    public static final /* synthetic */ LazyJavaResolverContext access$getC$p(LazyJavaAnnotations r10) {
        return r10.f10206c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    /* JADX INFO: renamed from: findAnnotation */
    public AnnotationDescriptor mo1318findAnnotation(FqName r10) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        JavaAnnotation r11 = this.annotationOwner.findAnnotation(r10);
        if (r11 == null) goto L7;
        AnnotationDescriptor r12 = this.annotationDescriptors.invoke(r11);
        if (r12 == null) goto L7;
        return r12;
    L7:
        return JavaAnnotationMapper.INSTANCE.findMappedJavaAnnotation(r10, this.annotationOwner, this.f10206c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(FqName r10) {
        return Annotations.DefaultImpls.hasAnnotation(this, r10);
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
        return SequencesKt.filterNotNull(SequencesKt.plus(SequencesKt.map(CollectionsKt.asSequence(this.annotationOwner.getAnnotations()), this.annotationDescriptors), JavaAnnotationMapper.INSTANCE.findMappedJavaAnnotation(StandardNames.FqNames.deprecated, this.annotationOwner, this.f10206c))).iterator();
    }
}
