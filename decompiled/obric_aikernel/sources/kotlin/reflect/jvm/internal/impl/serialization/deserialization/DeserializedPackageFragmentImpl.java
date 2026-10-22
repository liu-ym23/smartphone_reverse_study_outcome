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

    public DeserializedPackageFragmentImpl(FqName r10, StorageManager r11, ModuleDescriptor r12, ProtoBuf.PackageFragment r13, BinaryVersion r14, DeserializedContainerSource r15) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        Intrinsics.checkNotNullParameter(r11, "storageManager");
        Intrinsics.checkNotNullParameter(r12, "module");
        Intrinsics.checkNotNullParameter(r13, "proto");
        Intrinsics.checkNotNullParameter(r14, "metadataVersion");
        super(r10, r11, r12);
        this.metadataVersion = r14;
        this.containerSource = r15;
        ProtoBuf.StringTable r16 = r13.getStrings();
        Intrinsics.checkNotNullExpressionValue(r16, "proto.strings");
        ProtoBuf.QualifiedNameTable r17 = r13.getQualifiedNames();
        Intrinsics.checkNotNullExpressionValue(r17, "proto.qualifiedNames");
        NameResolverImpl r18 = new NameResolverImpl(r16, r17);
        this.nameResolver = r18;
        this.classDataFinder = new ProtoBasedClassDataFinder(r13, r18, r14, new DeserializedPackageFragmentImpl$classDataFinder$1(this));
        this._proto = r13;
    }

    public static final /* synthetic */ DeserializedContainerSource access$getContainerSource$p(DeserializedPackageFragmentImpl r10) {
        return r10.containerSource;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment
    public /* bridge */ /* synthetic */ ClassDataFinder getClassDataFinder() {
        return getClassDataFinder();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment
    public ProtoBasedClassDataFinder getClassDataFinder() {
        return this.classDataFinder;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    public MemberScope getMemberScope() {
        MemberScope r10 = this._memberScope;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("_memberScope");
        return null;
    L6:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment
    public void initialize(DeserializationComponents r12) {
        Intrinsics.checkNotNullParameter(r12, "components");
        ProtoBuf.PackageFragment r10 = this._proto;
        if (r10 == null) goto L7;
        this._proto = null;
        ProtoBuf.Package r11 = r10.getPackage();
        Intrinsics.checkNotNullExpressionValue(r11, "proto.`package`");
        this._memberScope = new DeserializedPackageMemberScope(this, r11, this.nameResolver, this.metadataVersion, this.containerSource, r12, "scope of " + this, new AnonymousClass1(this));
        return;
    L7:
        throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString());
    }
}
