package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.InputStream;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment;
import kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.builtins.ReadPackageFragmentKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class BuiltInsPackageFragmentImpl extends DeserializedPackageFragmentImpl implements BuiltInsPackageFragment {
    public static final Companion Companion = null;
    private final boolean isFallback;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final BuiltInsPackageFragmentImpl create(FqName r10, StorageManager r11, ModuleDescriptor r12, InputStream r13, boolean r14) {
            Intrinsics.checkNotNullParameter(r10, "fqName");
            Intrinsics.checkNotNullParameter(r11, "storageManager");
            Intrinsics.checkNotNullParameter(r12, "module");
            Intrinsics.checkNotNullParameter(r13, "inputStream");
            Pair<ProtoBuf$PackageFragment, BuiltInsBinaryVersion> r15 = ReadPackageFragmentKt.readBuiltinsPackageFragment(r13);
            ProtoBuf$PackageFragment r5 = (ProtoBuf$PackageFragment) r15.component1();
            BuiltInsBinaryVersion r6 = (BuiltInsBinaryVersion) r15.component2();
            if (r5 == null) goto L7;
            return new BuiltInsPackageFragmentImpl(r10, r11, r12, r5, r6, r14, null);
        L7:
            throw new UnsupportedOperationException("Kotlin built-in definition format version is not supported: expected " + BuiltInsBinaryVersion.INSTANCE + ", actual " + r6 + ". Please update Kotlin");
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ BuiltInsPackageFragmentImpl(FqName r1, StorageManager r2, ModuleDescriptor r3, ProtoBuf$PackageFragment r4, BuiltInsBinaryVersion r5, boolean r6, DefaultConstructorMarker r7) {
        this(r1, r2, r3, r4, r5, r6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    public String toString() {
        return "builtins package fragment for " + getFqName() + " from " + DescriptorUtilsKt.getModule(this);
    }

    private BuiltInsPackageFragmentImpl(FqName r8, StorageManager r9, ModuleDescriptor r10, ProtoBuf$PackageFragment r11, BuiltInsBinaryVersion r12, boolean r13) {
        super(r8, r9, r10, r11, r12, null);
        this.isFallback = r13;
    }
}
