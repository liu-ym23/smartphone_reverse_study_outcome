package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes3.dex */
public final class BinaryClassAnnotationAndConstantLoaderImplKt {
    public static final BinaryClassAnnotationAndConstantLoaderImpl createBinaryClassAnnotationAndConstantLoader(ModuleDescriptor r5, NotFoundClasses r10, StorageManager r11, KotlinClassFinder r12, JvmMetadataVersion r13) {
        Intrinsics.checkNotNullParameter(r5, "module");
        Intrinsics.checkNotNullParameter(r10, "notFoundClasses");
        Intrinsics.checkNotNullParameter(r11, "storageManager");
        Intrinsics.checkNotNullParameter(r12, "kotlinClassFinder");
        Intrinsics.checkNotNullParameter(r13, "jvmMetadataVersion");
        BinaryClassAnnotationAndConstantLoaderImpl r14 = new BinaryClassAnnotationAndConstantLoaderImpl(r5, r10, r11, r12);
        r14.setJvmMetadataVersion(r13);
        return r14;
    }
}
