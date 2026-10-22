package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class LazyPackageViewDescriptorImpl extends DeclarationDescriptorImpl implements PackageViewDescriptor {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final NotNullLazyValue empty$delegate;
    private final FqName fqName;
    private final NotNullLazyValue fragments$delegate;
    private final MemberScope memberScope;
    private final ModuleDescriptorImpl module;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyPackageViewDescriptorImpl.class), "fragments", "getFragments()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyPackageViewDescriptorImpl.class), "empty", "getEmpty()Z"))};
    }

    public static /* synthetic */ List accessor$LazyPackageViewDescriptorImpl$lambda0(LazyPackageViewDescriptorImpl r0) {
        return fragments_delegate$lambda$0(r0);
    }

    public static /* synthetic */ boolean accessor$LazyPackageViewDescriptorImpl$lambda1(LazyPackageViewDescriptorImpl r0) {
        return empty_delegate$lambda$1(r0);
    }

    public static /* synthetic */ MemberScope accessor$LazyPackageViewDescriptorImpl$lambda2(LazyPackageViewDescriptorImpl r0) {
        return memberScope$lambda$3(r0);
    }

    public final boolean getEmpty() {
        return ((Boolean) StorageKt.getValue(this.empty$delegate, this, $$delegatedProperties[1])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    public List<PackageFragmentDescriptor> getFragments() {
        return (List) StorageKt.getValue(this.fragments$delegate, this, $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public PackageViewDescriptor getContainingDeclaration() {
        if (getFqName().isRoot() == false) goto L6;
        return null;
    L6:
        return getModule().getPackage(getFqName().parent());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    public /* bridge */ /* synthetic */ ModuleDescriptor getModule() {
        return getModule();
    }

    public int hashCode() {
        return (getModule().hashCode() * 31) + getFqName().hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    public boolean isEmpty() {
        return getEmpty();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    public FqName getFqName() {
        return this.fqName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    public MemberScope getMemberScope() {
        return this.memberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    public ModuleDescriptorImpl getModule() {
        return this.module;
    }

    private static final boolean empty_delegate$lambda$1(LazyPackageViewDescriptorImpl r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return PackageFragmentProviderKt.isEmpty(r1.getModule().getPackageFragmentProvider(), r1.getFqName());
    }

    private static final List fragments_delegate$lambda$0(LazyPackageViewDescriptorImpl r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return PackageFragmentProviderKt.packageFragments(r1.getModule().getPackageFragmentProvider(), r1.getFqName());
    }

    private static final MemberScope memberScope$lambda$3(LazyPackageViewDescriptorImpl r4) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        if (r4.isEmpty() == true) goto L12;
        List<PackageFragmentDescriptor> r0 = r4.getFragments();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        r1.add(((PackageFragmentDescriptor) r2.next()).getMemberScope());
        goto L7
    L9:
        List r3 = CollectionsKt.plus(r1, new SubpackagesScope(r4.getModule(), r4.getFqName()));
        return ChainedMemberScope.Companion.create("package view scope for " + r4.getFqName() + " in " + r4.getModule().getName(), r3);
    L12:
        return MemberScope.Empty.INSTANCE;
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof PackageViewDescriptor) == false) goto L5;
        PackageViewDescriptor r5 = (PackageViewDescriptor) r4;
    L7:
        if (r5 != null) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(getFqName(), r5.getFqName()) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(getModule(), r5.getModule()) == false) goto L16;
        return true;
    L16:
        return false;
    L5:
        r5 = null;
        goto L7
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> r2, D r3) {
        Intrinsics.checkNotNullParameter(r2, "visitor");
        return r2.visitPackageViewDescriptor(this, r3);
    }

    public LazyPackageViewDescriptorImpl(ModuleDescriptorImpl r3, FqName r4, StorageManager r5) {
        Intrinsics.checkNotNullParameter(r3, "module");
        Intrinsics.checkNotNullParameter(r4, "fqName");
        Intrinsics.checkNotNullParameter(r5, "storageManager");
        super(Annotations.Companion.getEMPTY(), r4.shortNameOrSpecial());
        this.module = r3;
        this.fqName = r4;
        this.fragments$delegate = r5.createLazyValue(new LazyPackageViewDescriptorImpl$$Lambda$0(this));
        this.empty$delegate = r5.createLazyValue(new LazyPackageViewDescriptorImpl$$Lambda$1(this));
        this.memberScope = new LazyScopeAdapter(r5, new LazyPackageViewDescriptorImpl$$Lambda$2(this));
    }
}
