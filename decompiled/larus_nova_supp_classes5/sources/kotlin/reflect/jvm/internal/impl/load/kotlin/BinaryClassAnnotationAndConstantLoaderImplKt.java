package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class BinaryClassAnnotationAndConstantLoaderImplKt {
    public static final BinaryClassAnnotationAndConstantLoaderImpl createBinaryClassAnnotationAndConstantLoader(ModuleDescriptor r1, NotFoundClasses r2, StorageManager r3, KotlinClassFinder r4, JvmMetadataVersion r5) {
        Intrinsics.checkNotNullParameter(r1, "module");
        Intrinsics.checkNotNullParameter(r2, "notFoundClasses");
        Intrinsics.checkNotNullParameter(r3, "storageManager");
        Intrinsics.checkNotNullParameter(r4, "kotlinClassFinder");
        Intrinsics.checkNotNullParameter(r5, "jvmMetadataVersion");
        BinaryClassAnnotationAndConstantLoaderImpl r0 = new BinaryClassAnnotationAndConstantLoaderImpl(r1, r2, r3, r4);
        r0.setJvmMetadataVersion(r5);
        return r0;
    }
}
