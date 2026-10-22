package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.InputStream;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.builtins.ReadPackageFragmentKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes3.dex */
public final class BuiltInsPackageFragmentImpl extends DeserializedPackageFragmentImpl implements BuiltInsPackageFragment {
    public static final Companion Companion = null;
    private final boolean isFallback;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final BuiltInsPackageFragmentImpl create(FqName r10, StorageManager r11, ModuleDescriptor r12, InputStream r13, boolean r14) {
            Intrinsics.checkNotNullParameter(r10, "fqName");
            Intrinsics.checkNotNullParameter(r11, "storageManager");
            Intrinsics.checkNotNullParameter(r12, "module");
            Intrinsics.checkNotNullParameter(r13, "inputStream");
            Pair<ProtoBuf.PackageFragment, BuiltInsBinaryVersion> r15 = ReadPackageFragmentKt.readBuiltinsPackageFragment(r13);
            ProtoBuf.PackageFragment r16 = r15.component1();
            BuiltInsBinaryVersion r17 = r15.component2();
            if (r16 == null) goto L7;
            return new BuiltInsPackageFragmentImpl(r10, r11, r12, r16, r17, r14, null);
        L7:
            throw new UnsupportedOperationException("Kotlin built-in definition format version is not supported: expected " + BuiltInsBinaryVersion.INSTANCE + ", actual " + r17 + ". Please update Kotlin");
        }
    }

    static {
        Companion = new Companion(null);
    }

    private BuiltInsPackageFragmentImpl(FqName r10, StorageManager r11, ModuleDescriptor r12, ProtoBuf.PackageFragment r13, BuiltInsBinaryVersion r14, boolean r15) {
        super(r10, r11, r12, r13, r14, null);
        this.isFallback = r15;
    }

    public /* synthetic */ BuiltInsPackageFragmentImpl(FqName r10, StorageManager r11, ModuleDescriptor r12, ProtoBuf.PackageFragment r13, BuiltInsBinaryVersion r14, boolean r15, DefaultConstructorMarker r16) {
        this(r10, r11, r12, r13, r14, r15);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    public String toString() {
        return "builtins package fragment for " + getFqName() + " from " + DescriptorUtilsKt.getModule(this);
    }
}
