package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class CompositeAnnotations implements Annotations {
    private final List<Annotations> delegates;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositeAnnotations(List<? extends Annotations> r10) {
        Intrinsics.checkNotNullParameter(r10, "delegates");
        this.delegates = r10;
    }

    public CompositeAnnotations(Annotations... r10) {
        Intrinsics.checkNotNullParameter(r10, "delegates");
        this(ArraysKt.toList(r10));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    /* JADX INFO: renamed from: findAnnotation */
    public AnnotationDescriptor mo1318findAnnotation(final FqName r10) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        return (AnnotationDescriptor) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.delegates), new AnonymousClass1(r10)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(FqName r10) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        Iterator r11 = CollectionsKt.asSequence(this.delegates).iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        if (((Annotations) r11.next()).hasAnnotation(r10) == false) goto L4;
        return true;
    L8:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        List<Annotations> r10 = this.delegates;
        if ((r10 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L18;
        if (((Annotations) r11.next()).isEmpty() == true) goto L9;
        return false;
    L18:
        return true;
    L5:
        if (r10.isEmpty() == false) goto L7;
        return true;
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotationDescriptor> iterator() {
        return SequencesKt.flatMap(CollectionsKt.asSequence(this.delegates), C04131.INSTANCE).iterator();
    }
}
