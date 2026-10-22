package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;
import kotlin.reflect.jvm.internal.impl.utils.DeserializationHelpersKt;

/* JADX INFO: loaded from: classes3.dex */
public final class JavaClassDataFinder implements ClassDataFinder {
    private final DeserializedDescriptorResolver deserializedDescriptorResolver;
    private final KotlinClassFinder kotlinClassFinder;

    public JavaClassDataFinder(KotlinClassFinder r5, DeserializedDescriptorResolver r10) {
        Intrinsics.checkNotNullParameter(r5, "kotlinClassFinder");
        Intrinsics.checkNotNullParameter(r10, "deserializedDescriptorResolver");
        this.kotlinClassFinder = r5;
        this.deserializedDescriptorResolver = r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder
    public ClassData findClassData(ClassId r5) {
        Intrinsics.checkNotNullParameter(r5, "classId");
        KotlinJvmBinaryClass r10 = KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, r5, DeserializationHelpersKt.jvmMetadataVersionOrDefault(this.deserializedDescriptorResolver.getComponents().getConfiguration()));
        if (r10 != null) goto L6;
        return null;
    L6:
        Intrinsics.areEqual(r10.getClassId(), r5);
        return this.deserializedDescriptorResolver.readClassData$descriptors_jvm(r10);
    }
}
