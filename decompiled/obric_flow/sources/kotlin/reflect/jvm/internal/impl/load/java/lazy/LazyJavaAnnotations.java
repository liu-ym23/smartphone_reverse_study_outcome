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
    private final LazyJavaResolverContext f18742c;

    public LazyJavaAnnotations(LazyJavaResolverContext r5, JavaAnnotationOwner r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "c");
        Intrinsics.checkNotNullParameter(r10, "annotationOwner");
        this.f18742c = r5;
        this.annotationOwner = r10;
        this.areAnnotationsFreshlySupported = r11;
        this.annotationDescriptors = r5.getComponents().getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaAnnotations$annotationDescriptors$1(this));
    }

    public static final /* synthetic */ boolean access$getAreAnnotationsFreshlySupported$p(LazyJavaAnnotations r5) {
        return r5.areAnnotationsFreshlySupported;
    }

    public static final /* synthetic */ LazyJavaResolverContext access$getC$p(LazyJavaAnnotations r5) {
        return r5.f18742c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    /* JADX INFO: renamed from: findAnnotation */
    public AnnotationDescriptor mo1397findAnnotation(FqName r5) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        JavaAnnotation r10 = this.annotationOwner.findAnnotation(r5);
        if (r10 == null) goto L7;
        AnnotationDescriptor r11 = this.annotationDescriptors.invoke(r10);
        if (r11 == null) goto L7;
        return r11;
    L7:
        return JavaAnnotationMapper.INSTANCE.findMappedJavaAnnotation(r5, this.annotationOwner, this.f18742c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(FqName r5) {
        return Annotations.DefaultImpls.hasAnnotation(this, r5);
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
        return SequencesKt.filterNotNull(SequencesKt.plus(SequencesKt.map(CollectionsKt.asSequence(this.annotationOwner.getAnnotations()), this.annotationDescriptors), JavaAnnotationMapper.INSTANCE.findMappedJavaAnnotation(StandardNames.FqNames.deprecated, this.annotationOwner, this.f18742c))).iterator();
    }

    public /* synthetic */ LazyJavaAnnotations(LazyJavaResolverContext r5, JavaAnnotationOwner r10, boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r11 = false;
    L5:
        this(r5, r10, r11);
    }
}
