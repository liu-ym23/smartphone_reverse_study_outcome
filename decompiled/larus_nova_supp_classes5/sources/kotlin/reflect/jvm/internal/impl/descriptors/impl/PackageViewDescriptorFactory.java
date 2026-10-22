package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface PackageViewDescriptorFactory {
    public static final Companion Companion = null;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final ModuleCapability<PackageViewDescriptorFactory> CAPABILITY = null;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            CAPABILITY = new ModuleCapability("PackageViewDescriptorFactory");
        }

        public final ModuleCapability<PackageViewDescriptorFactory> getCAPABILITY() {
            return CAPABILITY;
        }
    }

    public static final class Default implements PackageViewDescriptorFactory {
        public static final Default INSTANCE = null;

        static {
            INSTANCE = new Default();
        }

        private Default() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory
        public PackageViewDescriptor compute(ModuleDescriptorImpl r2, FqName r3, StorageManager r4) {
            Intrinsics.checkNotNullParameter(r2, "module");
            Intrinsics.checkNotNullParameter(r3, "fqName");
            Intrinsics.checkNotNullParameter(r4, "storageManager");
            return new LazyPackageViewDescriptorImpl(r2, r3, r4);
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    PackageViewDescriptor compute(ModuleDescriptorImpl r1, FqName r2, StorageManager r3);
}
