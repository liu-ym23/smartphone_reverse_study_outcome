package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class PackageFragmentProviderImpl implements PackageFragmentProviderOptimized {
    private final Collection<PackageFragmentDescriptor> packageFragments;

    /* JADX WARN: Multi-variable type inference failed */
    public PackageFragmentProviderImpl(Collection<? extends PackageFragmentDescriptor> r10) {
        Intrinsics.checkNotNullParameter(r10, "packageFragments");
        this.packageFragments = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(FqName r10, Collection<PackageFragmentDescriptor> r11) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        Intrinsics.checkNotNullParameter(r11, "packageFragments");
        Iterator<T> r12 = this.packageFragments.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r13 = r12.next();
        if (Intrinsics.areEqual(((PackageFragmentDescriptor) r13).getFqName(), r10) == false) goto L4;
        r11.add(r13);
        goto L4
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    public List<PackageFragmentDescriptor> getPackageFragments(FqName r10) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        Collection<PackageFragmentDescriptor> r11 = this.packageFragments;
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        Object r14 = r13.next();
        if (Intrinsics.areEqual(((PackageFragmentDescriptor) r14).getFqName(), r10) == false) goto L4;
        r12.add(r14);
        goto L4
    L8:
        return r12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public Collection<FqName> getSubPackagesOf(final FqName r10, Function1<? super Name, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        Intrinsics.checkNotNullParameter(r11, "nameFilter");
        return SequencesKt.toList(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(this.packageFragments), AnonymousClass1.INSTANCE), new AnonymousClass2(r10)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public boolean isEmpty(FqName r10) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        Collection<PackageFragmentDescriptor> r11 = this.packageFragments;
        if ((r11 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(((PackageFragmentDescriptor) r12.next()).getFqName(), r10) == false) goto L9;
        return false;
    L18:
        return true;
    L5:
        if (r11.isEmpty() == false) goto L7;
        return true;
    }
}
