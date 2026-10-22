package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
final class EnhancedTypeAnnotations implements Annotations {
    private final FqName fqNameToMatch;

    public EnhancedTypeAnnotations(FqName r5) {
        Intrinsics.checkNotNullParameter(r5, "fqNameToMatch");
        this.fqNameToMatch = r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    /* JADX INFO: renamed from: findAnnotation */
    public /* bridge */ /* synthetic */ AnnotationDescriptor mo1397findAnnotation(FqName r5) {
        return mo1397findAnnotation(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(FqName r5) {
        return Annotations.DefaultImpls.hasAnnotation(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotationDescriptor> iterator() {
        return CollectionsKt.emptyList().iterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    /* JADX INFO: renamed from: findAnnotation */
    public EnhancedTypeAnnotationDescriptor mo1397findAnnotation(FqName r5) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        if (Intrinsics.areEqual(r5, this.fqNameToMatch) == true) goto L7;
        return null;
    L7:
        return EnhancedTypeAnnotationDescriptor.INSTANCE;
    }
}
