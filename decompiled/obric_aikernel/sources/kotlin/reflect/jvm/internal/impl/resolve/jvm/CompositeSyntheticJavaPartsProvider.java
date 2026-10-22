package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes3.dex */
public final class CompositeSyntheticJavaPartsProvider implements SyntheticJavaPartsProvider {
    private final List<SyntheticJavaPartsProvider> inner;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositeSyntheticJavaPartsProvider(List<? extends SyntheticJavaPartsProvider> r10) {
        Intrinsics.checkNotNullParameter(r10, "inner");
        this.inner = r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateConstructors(ClassDescriptor r10, List<ClassConstructorDescriptor> r11) {
        Intrinsics.checkNotNullParameter(r10, "thisDescriptor");
        Intrinsics.checkNotNullParameter(r11, "result");
        Iterator<T> r12 = this.inner.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        ((SyntheticJavaPartsProvider) r12.next()).generateConstructors(r10, r11);
        goto L4
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateMethods(ClassDescriptor r10, Name r11, Collection<SimpleFunctionDescriptor> r12) {
        Intrinsics.checkNotNullParameter(r10, "thisDescriptor");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, "result");
        Iterator<T> r13 = this.inner.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        ((SyntheticJavaPartsProvider) r13.next()).generateMethods(r10, r11, r12);
        goto L4
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateStaticFunctions(ClassDescriptor r10, Name r11, Collection<SimpleFunctionDescriptor> r12) {
        Intrinsics.checkNotNullParameter(r10, "thisDescriptor");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, "result");
        Iterator<T> r13 = this.inner.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        ((SyntheticJavaPartsProvider) r13.next()).generateStaticFunctions(r10, r11, r12);
        goto L4
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public List<Name> getMethodNames(ClassDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "thisDescriptor");
        List<SyntheticJavaPartsProvider> r11 = this.inner;
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        CollectionsKt.addAll(r12, ((SyntheticJavaPartsProvider) r13.next()).getMethodNames(r10));
        goto L4
    L6:
        return r12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public List<Name> getStaticFunctionNames(ClassDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "thisDescriptor");
        List<SyntheticJavaPartsProvider> r11 = this.inner;
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        CollectionsKt.addAll(r12, ((SyntheticJavaPartsProvider) r13.next()).getStaticFunctionNames(r10));
        goto L4
    L6:
        return r12;
    }
}
