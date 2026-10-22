package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
public final class FilteredAnnotations implements Annotations {
    private final Annotations delegate;
    private final Function1<FqName, Boolean> fqNameFilter;
    private final boolean isDefinitelyNewInference;

    public FilteredAnnotations(Annotations r10, Function1<? super FqName, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "delegate");
        Intrinsics.checkNotNullParameter(r11, "fqNameFilter");
        this(r10, false, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FilteredAnnotations(Annotations r10, boolean r11, Function1<? super FqName, Boolean> r12) {
        Intrinsics.checkNotNullParameter(r10, "delegate");
        Intrinsics.checkNotNullParameter(r12, "fqNameFilter");
        this.delegate = r10;
        this.isDefinitelyNewInference = r11;
        this.fqNameFilter = r12;
    }

    private final boolean shouldBeReturned(AnnotationDescriptor r10) {
        FqName r11 = r10.getFqName();
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (this.fqNameFilter.invoke(r11).booleanValue() == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    /* JADX INFO: renamed from: findAnnotation */
    public AnnotationDescriptor mo1318findAnnotation(FqName r10) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        if (this.fqNameFilter.invoke(r10).booleanValue() == true) goto L7;
        return null;
    L7:
        return this.delegate.mo1318findAnnotation(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(FqName r10) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        if (this.fqNameFilter.invoke(r10).booleanValue() == true) goto L7;
        return false;
    L7:
        return this.delegate.hasAnnotation(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        Annotations r10 = this.delegate;
        if ((r10 instanceof Collection) == true) goto L5;
    L7:
        Iterator<AnnotationDescriptor> r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L6;
        if (shouldBeReturned(r11.next()) == false) goto L9;
        boolean r12 = true;
    L14:
        if (this.isDefinitelyNewInference == false) goto L19;
        if (r12 == true) goto L23;
        return true;
    L23:
        return false;
    L19:
        return r12;
    L6:
        r12 = false;
        goto L14
    L5:
        if (((Collection) r10).isEmpty() == false) goto L7;
        goto L6
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotationDescriptor> iterator() {
        Annotations r10 = this.delegate;
        ArrayList r11 = new ArrayList();
        Iterator<AnnotationDescriptor> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        AnnotationDescriptor r13 = r12.next();
        if (shouldBeReturned(r13) == false) goto L4;
        r11.add(r13);
        goto L4
    L9:
        return r11.iterator();
    }
}
