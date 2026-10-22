package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolverImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DeserializedPackageFragmentImpl extends DeserializedPackageFragment {
    private MemberScope _memberScope;
    private ProtoBuf.PackageFragment _proto;
    private final ProtoBasedClassDataFinder classDataFinder;
    private final DeserializedContainerSource containerSource;
    private final BinaryVersion metadataVersion;
    private final NameResolverImpl nameResolver;

    public DeserializedPackageFragmentImpl(FqName r5, StorageManager r10, ModuleDescriptor r11, ProtoBuf.PackageFragment r12, BinaryVersion r13, DeserializedContainerSource r14) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        Intrinsics.checkNotNullParameter(r10, "storageManager");
        Intrinsics.checkNotNullParameter(r11, "module");
        Intrinsics.checkNotNullParameter(r12, "proto");
        Intrinsics.checkNotNullParameter(r13, "metadataVersion");
        super(r5, r10, r11);
        this.metadataVersion = r13;
        this.containerSource = r14;
        NameResolverImpl r15 = new NameResolverImpl(r12.getStrings(), r12.getQualifiedNames());
        this.nameResolver = r15;
        this.classDataFinder = new ProtoBasedClassDataFinder(r12, r15, r13, new DeserializedPackageFragmentImpl$classDataFinder$1(this));
        this._proto = r12;
    }

    public static final /* synthetic */ DeserializedContainerSource access$getContainerSource$p(DeserializedPackageFragmentImpl r5) {
        return r5.containerSource;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment
    public /* bridge */ /* synthetic */ ClassDataFinder getClassDataFinder() {
        return getClassDataFinder();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    public MemberScope getMemberScope() {
        MemberScope r5 = this._memberScope;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("_memberScope");
        return null;
    L6:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment
    public void initialize(DeserializationComponents r12) {
        Intrinsics.checkNotNullParameter(r12, "components");
        ProtoBuf.PackageFragment r5 = this._proto;
        if (r5 == null) goto L7;
        this._proto = null;
        this._memberScope = new DeserializedPackageMemberScope(this, r5.getPackage(), this.nameResolver, this.metadataVersion, this.containerSource, r12, "scope of " + this, new AnonymousClass1(this));
        return;
    L7:
        throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize");
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment
    public ProtoBasedClassDataFinder getClassDataFinder() {
        return this.classDataFinder;
    }
}
