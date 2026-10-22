package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nSyntheticJavaPartsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SyntheticJavaPartsProvider.kt\norg/jetbrains/kotlin/resolve/jvm/CompositeSyntheticJavaPartsProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,90:1\n1360#2:91\n1446#2,5:92\n1855#2,2:97\n1360#2:99\n1446#2,5:100\n1855#2,2:105\n1855#2,2:107\n1360#2:109\n1446#2,5:110\n1855#2,2:115\n*S KotlinDebug\n*F\n+ 1 SyntheticJavaPartsProvider.kt\norg/jetbrains/kotlin/resolve/jvm/CompositeSyntheticJavaPartsProvider\n*L\n54#1:91\n54#1:92,5\n63#1:97,2\n68#1:99\n68#1:100,5\n72#1:105,2\n77#1:107,2\n82#1:109\n82#1:110,5\n87#1:115,2\n*E\n"})
public final class CompositeSyntheticJavaPartsProvider implements SyntheticJavaPartsProvider {
    private final List<SyntheticJavaPartsProvider> inner;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositeSyntheticJavaPartsProvider(List<? extends SyntheticJavaPartsProvider> r5) {
        Intrinsics.checkNotNullParameter(r5, "inner");
        this.inner = r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateConstructors(LazyJavaResolverContext r5, ClassDescriptor r10, List<ClassConstructorDescriptor> r11) {
        Intrinsics.checkNotNullParameter(r5, "_context_receiver_0");
        Intrinsics.checkNotNullParameter(r10, "thisDescriptor");
        Intrinsics.checkNotNullParameter(r11, "result");
        Iterator<T> r12 = this.inner.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        ((SyntheticJavaPartsProvider) r12.next()).generateConstructors(r5, r10, r11);
        goto L4
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateMethods(LazyJavaResolverContext r5, ClassDescriptor r10, Name r11, Collection<SimpleFunctionDescriptor> r12) {
        Intrinsics.checkNotNullParameter(r5, "_context_receiver_0");
        Intrinsics.checkNotNullParameter(r10, "thisDescriptor");
        Intrinsics.checkNotNullParameter(r11, "name");
        Intrinsics.checkNotNullParameter(r12, "result");
        Iterator<T> r13 = this.inner.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        ((SyntheticJavaPartsProvider) r13.next()).generateMethods(r5, r10, r11, r12);
        goto L4
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateNestedClass(LazyJavaResolverContext r5, ClassDescriptor r10, Name r11, List<ClassDescriptor> r12) {
        Intrinsics.checkNotNullParameter(r5, "_context_receiver_0");
        Intrinsics.checkNotNullParameter(r10, "thisDescriptor");
        Intrinsics.checkNotNullParameter(r11, "name");
        Intrinsics.checkNotNullParameter(r12, "result");
        Iterator<T> r13 = this.inner.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        ((SyntheticJavaPartsProvider) r13.next()).generateNestedClass(r5, r10, r11, r12);
        goto L4
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public void generateStaticFunctions(LazyJavaResolverContext r5, ClassDescriptor r10, Name r11, Collection<SimpleFunctionDescriptor> r12) {
        Intrinsics.checkNotNullParameter(r5, "_context_receiver_0");
        Intrinsics.checkNotNullParameter(r10, "thisDescriptor");
        Intrinsics.checkNotNullParameter(r11, "name");
        Intrinsics.checkNotNullParameter(r12, "result");
        Iterator<T> r13 = this.inner.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        ((SyntheticJavaPartsProvider) r13.next()).generateStaticFunctions(r5, r10, r11, r12);
        goto L4
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public List<Name> getMethodNames(LazyJavaResolverContext r5, ClassDescriptor r10) {
        Intrinsics.checkNotNullParameter(r5, "_context_receiver_0");
        Intrinsics.checkNotNullParameter(r10, "thisDescriptor");
        List<SyntheticJavaPartsProvider> r11 = this.inner;
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        CollectionsKt.a(r12, ((SyntheticJavaPartsProvider) r13.next()).getMethodNames(r5, r10));
        goto L4
    L6:
        return r12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public List<Name> getNestedClassNames(LazyJavaResolverContext r5, ClassDescriptor r10) {
        Intrinsics.checkNotNullParameter(r5, "_context_receiver_0");
        Intrinsics.checkNotNullParameter(r10, "thisDescriptor");
        List<SyntheticJavaPartsProvider> r11 = this.inner;
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        CollectionsKt.a(r12, ((SyntheticJavaPartsProvider) r13.next()).getNestedClassNames(r5, r10));
        goto L4
    L6:
        return r12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider
    public List<Name> getStaticFunctionNames(LazyJavaResolverContext r5, ClassDescriptor r10) {
        Intrinsics.checkNotNullParameter(r5, "_context_receiver_0");
        Intrinsics.checkNotNullParameter(r10, "thisDescriptor");
        List<SyntheticJavaPartsProvider> r11 = this.inner;
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        CollectionsKt.a(r12, ((SyntheticJavaPartsProvider) r13.next()).getStaticFunctionNames(r5, r10));
        goto L4
    L6:
        return r12;
    }
}
