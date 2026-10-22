package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes3.dex */
public interface PackageViewDescriptorFactory {
    public static final Companion Companion = null;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final ModuleCapability<PackageViewDescriptorFactory> CAPABILITY = null;

        static {
            $$INSTANCE = new Companion();
            CAPABILITY = new ModuleCapability("PackageViewDescriptorFactory");
        }

        private Companion() {
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
        public PackageViewDescriptor compute(ModuleDescriptorImpl r5, FqName r10, StorageManager r11) {
            Intrinsics.checkNotNullParameter(r5, "module");
            Intrinsics.checkNotNullParameter(r10, "fqName");
            Intrinsics.checkNotNullParameter(r11, "storageManager");
            return new LazyPackageViewDescriptorImpl(r5, r10, r11);
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    PackageViewDescriptor compute(ModuleDescriptorImpl r5, FqName r10, StorageManager r11);
}
