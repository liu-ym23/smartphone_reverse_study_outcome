package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolverImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class DeserializedPackageFragmentImpl extends DeserializedPackageFragment {
    private MemberScope _memberScope;
    private ProtoBuf$PackageFragment _proto;
    private final ProtoBasedClassDataFinder classDataFinder;
    private final DeserializedContainerSource containerSource;
    private final BinaryVersion metadataVersion;
    private final NameResolverImpl nameResolver;

    public static /* synthetic */ SourceElement accessor$DeserializedPackageFragmentImpl$lambda0(DeserializedPackageFragmentImpl r0, ClassId r1) {
        return classDataFinder$lambda$0(r0, r1);
    }

    public static /* synthetic */ Collection accessor$DeserializedPackageFragmentImpl$lambda1(DeserializedPackageFragmentImpl r0) {
        return initialize$lambda$3(r0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    public MemberScope getMemberScope() {
        MemberScope r0 = this._memberScope;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("_memberScope");
        return null;
    L6:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment
    public /* bridge */ /* synthetic */ ClassDataFinder getClassDataFinder() {
        return getClassDataFinder();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment
    public ProtoBasedClassDataFinder getClassDataFinder() {
        return this.classDataFinder;
    }

    private static final Collection initialize$lambda$3(DeserializedPackageFragmentImpl r4) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        Collection<ClassId> r5 = r4.getClassDataFinder().getAllClassIds();
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L13;
        Object r1 = r6.next();
        ClassId r2 = (ClassId) r1;
        if (r2.isNestedClass() == false) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        if (ClassDeserializer.Companion.getBLACK_LIST().contains(r2) == true) goto L10;
        r3 = true;
        goto L11
    L13:
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r8 = r0.iterator();
    L15:
        if (r8.hasNext() == false) goto L17;
        r7.add(((ClassId) r8.next()).getShortClassName());
        goto L15
    L17:
        return r7;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment
    public void initialize(DeserializationComponents r12) {
        Intrinsics.checkNotNullParameter(r12, "components");
        ProtoBuf$PackageFragment r0 = this._proto;
        if (r0 == null) goto L7;
        this._proto = null;
        this._memberScope = new DeserializedPackageMemberScope(this, r0.getPackage(), this.nameResolver, this.metadataVersion, this.containerSource, r12, "scope of " + this, new DeserializedPackageFragmentImpl$$Lambda$1(this));
        return;
    L7:
        throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString());
    }

    private static final SourceElement classDataFinder$lambda$0(DeserializedPackageFragmentImpl r1, ClassId r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "it");
        DeserializedContainerSource r3 = r1.containerSource;
        if (r3 == null) goto L6;
        return r3;
    L6:
        return SourceElement.NO_SOURCE;
    }

    public DeserializedPackageFragmentImpl(FqName r2, StorageManager r3, ModuleDescriptor r4, ProtoBuf$PackageFragment r5, BinaryVersion r6, DeserializedContainerSource r7) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        Intrinsics.checkNotNullParameter(r3, "storageManager");
        Intrinsics.checkNotNullParameter(r4, "module");
        Intrinsics.checkNotNullParameter(r5, "proto");
        Intrinsics.checkNotNullParameter(r6, "metadataVersion");
        super(r2, r3, r4);
        this.metadataVersion = r6;
        this.containerSource = r7;
        NameResolverImpl r8 = new NameResolverImpl(r5.getStrings(), r5.getQualifiedNames());
        this.nameResolver = r8;
        this.classDataFinder = new ProtoBasedClassDataFinder(r5, r8, r6, new DeserializedPackageFragmentImpl$$Lambda$0(this));
        this._proto = r5;
    }
}
