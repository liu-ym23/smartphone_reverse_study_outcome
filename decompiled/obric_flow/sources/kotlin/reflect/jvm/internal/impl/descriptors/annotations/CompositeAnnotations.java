package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nAnnotations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Annotations.kt\norg/jetbrains/kotlin/descriptors/annotations/CompositeAnnotations\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,123:1\n1726#2,3:124\n1360#2:129\n1446#2,5:130\n1229#3,2:127\n*S KotlinDebug\n*F\n+ 1 Annotations.kt\norg/jetbrains/kotlin/descriptors/annotations/CompositeAnnotations\n*L\n105#1:124,3\n112#1:129\n112#1:130,5\n107#1:127,2\n*E\n"})
public final class CompositeAnnotations implements Annotations {
    private final List<Annotations> delegates;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositeAnnotations(List<? extends Annotations> r5) {
        Intrinsics.checkNotNullParameter(r5, "delegates");
        this.delegates = r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    /* JADX INFO: renamed from: findAnnotation */
    public AnnotationDescriptor mo1397findAnnotation(final FqName r5) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        return (AnnotationDescriptor) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.delegates), new AnonymousClass1(r5)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(FqName r5) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        Iterator r10 = CollectionsKt.asSequence(this.delegates).iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        if (((Annotations) r10.next()).hasAnnotation(r5) == false) goto L4;
        return true;
    L8:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        List<Annotations> r5 = this.delegates;
        if (r5 != null) goto L5;
    L7:
        Iterator<T> r10 = r5.iterator();
    L9:
        if (r10.hasNext() == false) goto L18;
        if (((Annotations) r10.next()).isEmpty() == true) goto L9;
        return false;
    L18:
        return true;
    L5:
        if (r5.isEmpty() == false) goto L7;
        return true;
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotationDescriptor> iterator() {
        return SequencesKt.flatMap(CollectionsKt.asSequence(this.delegates), C02241.INSTANCE).iterator();
    }

    public CompositeAnnotations(Annotations... r5) {
        Intrinsics.checkNotNullParameter(r5, "delegates");
        this(ArraysKt.toList(r5));
    }
}
