package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class CompositeSyntheticJavaPartsProvider implements SyntheticJavaPartsProvider {
    private final List<SyntheticJavaPartsProvider> inner;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositeSyntheticJavaPartsProvider(List<? extends SyntheticJavaPartsProvider> r2) {
        Intrinsics.checkNotNullParameter(r2, "inner");
        this.inner = r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public List<Name> getMethodNames(ClassDescriptor r4, LazyJavaResolverContext r5) {
        Intrinsics.checkNotNullParameter(r4, "thisDescriptor");
        Intrinsics.checkNotNullParameter(r5, "c");
        List<SyntheticJavaPartsProvider> r0 = this.inner;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        CollectionsKt.addAll(r1, ((SyntheticJavaPartsProvider) r2.next()).getMethodNames(r4, r5));
        goto L4
    L6:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public List<Name> getNestedClassNames(ClassDescriptor r4, LazyJavaResolverContext r5) {
        Intrinsics.checkNotNullParameter(r4, "thisDescriptor");
        Intrinsics.checkNotNullParameter(r5, "c");
        List<SyntheticJavaPartsProvider> r0 = this.inner;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        CollectionsKt.addAll(r1, ((SyntheticJavaPartsProvider) r2.next()).getNestedClassNames(r4, r5));
        goto L4
    L6:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public List<Name> getStaticFunctionNames(ClassDescriptor r4, LazyJavaResolverContext r5) {
        Intrinsics.checkNotNullParameter(r4, "thisDescriptor");
        Intrinsics.checkNotNullParameter(r5, "c");
        List<SyntheticJavaPartsProvider> r0 = this.inner;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        CollectionsKt.addAll(r1, ((SyntheticJavaPartsProvider) r2.next()).getStaticFunctionNames(r4, r5));
        goto L4
    L6:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateConstructors(ClassDescriptor r3, List<ClassConstructorDescriptor> r4, LazyJavaResolverContext r5) {
        Intrinsics.checkNotNullParameter(r3, "thisDescriptor");
        Intrinsics.checkNotNullParameter(r4, "result");
        Intrinsics.checkNotNullParameter(r5, "c");
        Iterator<T> r0 = this.inner.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((SyntheticJavaPartsProvider) r0.next()).generateConstructors(r3, r4, r5);
        goto L4
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public PropertyDescriptorImpl modifyField(ClassDescriptor r3, PropertyDescriptorImpl r4, LazyJavaResolverContext r5) {
        Intrinsics.checkNotNullParameter(r3, "thisDescriptor");
        Intrinsics.checkNotNullParameter(r4, "propertyDescriptor");
        Intrinsics.checkNotNullParameter(r5, "c");
        Iterator<T> r0 = this.inner.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r4 = ((SyntheticJavaPartsProvider) r0.next()).modifyField(r3, r4, r5);
        goto L4
    L6:
        return r4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateMethods(ClassDescriptor r3, Name r4, Collection<SimpleFunctionDescriptor> r5, LazyJavaResolverContext r6) {
        Intrinsics.checkNotNullParameter(r3, "thisDescriptor");
        Intrinsics.checkNotNullParameter(r4, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r5, "result");
        Intrinsics.checkNotNullParameter(r6, "c");
        Iterator<T> r0 = this.inner.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((SyntheticJavaPartsProvider) r0.next()).generateMethods(r3, r4, r5, r6);
        goto L4
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateNestedClass(ClassDescriptor r3, Name r4, List<ClassDescriptor> r5, LazyJavaResolverContext r6) {
        Intrinsics.checkNotNullParameter(r3, "thisDescriptor");
        Intrinsics.checkNotNullParameter(r4, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r5, "result");
        Intrinsics.checkNotNullParameter(r6, "c");
        Iterator<T> r0 = this.inner.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((SyntheticJavaPartsProvider) r0.next()).generateNestedClass(r3, r4, r5, r6);
        goto L4
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateStaticFunctions(ClassDescriptor r3, Name r4, Collection<SimpleFunctionDescriptor> r5, LazyJavaResolverContext r6) {
        Intrinsics.checkNotNullParameter(r3, "thisDescriptor");
        Intrinsics.checkNotNullParameter(r4, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r5, "result");
        Intrinsics.checkNotNullParameter(r6, "c");
        Iterator<T> r0 = this.inner.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((SyntheticJavaPartsProvider) r0.next()).generateStaticFunctions(r3, r4, r5, r6);
        goto L4
    }
}
