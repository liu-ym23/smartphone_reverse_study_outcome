package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nAnnotations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Annotations.kt\norg/jetbrains/kotlin/descriptors/annotations/FilteredAnnotations\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,123:1\n766#2:124\n857#2,2:125\n1747#2,3:127\n*S KotlinDebug\n*F\n+ 1 Annotations.kt\norg/jetbrains/kotlin/descriptors/annotations/FilteredAnnotations\n*L\n69#1:124\n69#1:125,2\n72#1:127,3\n*E\n"})
public final class FilteredAnnotations implements Annotations {
    private final Annotations delegate;
    private final Function1<FqName, Boolean> fqNameFilter;
    private final boolean isDefinitelyNewInference;

    /* JADX WARN: Multi-variable type inference failed */
    public FilteredAnnotations(Annotations r5, boolean r10, Function1<? super FqName, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r5, "delegate");
        Intrinsics.checkNotNullParameter(r11, "fqNameFilter");
        this.delegate = r5;
        this.isDefinitelyNewInference = r10;
        this.fqNameFilter = r11;
    }

    private final boolean shouldBeReturned(AnnotationDescriptor r5) {
        FqName r10 = r5.getFqName();
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (this.fqNameFilter.invoke(r10).booleanValue() == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    /* JADX INFO: renamed from: findAnnotation */
    public AnnotationDescriptor mo1397findAnnotation(FqName r5) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        if (this.fqNameFilter.invoke(r5).booleanValue() == true) goto L7;
        return null;
    L7:
        return this.delegate.mo1397findAnnotation(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(FqName r5) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        if (this.fqNameFilter.invoke(r5).booleanValue() == true) goto L7;
        return false;
    L7:
        return this.delegate.hasAnnotation(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        Annotations r5 = this.delegate;
        if ((r5 instanceof Collection) == true) goto L5;
    L7:
        Iterator<AnnotationDescriptor> r10 = r5.iterator();
    L9:
        if (r10.hasNext() == false) goto L6;
        if (shouldBeReturned(r10.next()) == false) goto L9;
        boolean r11 = true;
    L14:
        if (this.isDefinitelyNewInference == false) goto L19;
        if (r11 == true) goto L23;
        return true;
    L23:
        return false;
    L19:
        return r11;
    L6:
        r11 = false;
        goto L14
    L5:
        if (((Collection) r5).isEmpty() == false) goto L7;
        goto L6
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotationDescriptor> iterator() {
        Annotations r5 = this.delegate;
        ArrayList r10 = new ArrayList();
        Iterator<AnnotationDescriptor> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        AnnotationDescriptor r12 = r11.next();
        if (shouldBeReturned(r12) == false) goto L4;
        r10.add(r12);
        goto L4
    L9:
        return r10.iterator();
    }

    public FilteredAnnotations(Annotations r5, Function1<? super FqName, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "delegate");
        Intrinsics.checkNotNullParameter(r10, "fqNameFilter");
        this(r5, false, r10);
    }
}
