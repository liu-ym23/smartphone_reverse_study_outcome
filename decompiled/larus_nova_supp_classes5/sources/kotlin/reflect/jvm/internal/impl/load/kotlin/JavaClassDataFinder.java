package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;
import kotlin.reflect.jvm.internal.impl.utils.DeserializationHelpersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class JavaClassDataFinder implements ClassDataFinder {
    private final DeserializedDescriptorResolver deserializedDescriptorResolver;
    private final KotlinClassFinder kotlinClassFinder;

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder
    public ClassData findClassData(ClassId r3) {
        Intrinsics.checkNotNullParameter(r3, "classId");
        KotlinJvmBinaryClass r0 = KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, r3, DeserializationHelpersKt.jvmMetadataVersionOrDefault(this.deserializedDescriptorResolver.getComponents().getConfiguration()));
        if (r0 != null) goto L6;
        return null;
    L6:
        Intrinsics.areEqual(r0.getClassId(), r3);
        return this.deserializedDescriptorResolver.readClassData$descriptors_jvm(r0);
    }

    public JavaClassDataFinder(KotlinClassFinder r2, DeserializedDescriptorResolver r3) {
        Intrinsics.checkNotNullParameter(r2, "kotlinClassFinder");
        Intrinsics.checkNotNullParameter(r3, "deserializedDescriptorResolver");
        this.kotlinClassFinder = r2;
        this.deserializedDescriptorResolver = r3;
    }
}
