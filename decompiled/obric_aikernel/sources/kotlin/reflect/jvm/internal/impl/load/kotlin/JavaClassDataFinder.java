package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;

/* JADX INFO: loaded from: classes3.dex */
public final class JavaClassDataFinder implements ClassDataFinder {
    private final DeserializedDescriptorResolver deserializedDescriptorResolver;
    private final KotlinClassFinder kotlinClassFinder;

    public JavaClassDataFinder(KotlinClassFinder r10, DeserializedDescriptorResolver r11) {
        Intrinsics.checkNotNullParameter(r10, "kotlinClassFinder");
        Intrinsics.checkNotNullParameter(r11, "deserializedDescriptorResolver");
        this.kotlinClassFinder = r10;
        this.deserializedDescriptorResolver = r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder
    public ClassData findClassData(ClassId r10) {
        Intrinsics.checkNotNullParameter(r10, "classId");
        KotlinJvmBinaryClass r11 = KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, r10);
        if (r11 != null) goto L6;
        return null;
    L6:
        Intrinsics.areEqual(r11.getClassId(), r10);
        return this.deserializedDescriptorResolver.readClassData$descriptors_jvm(r11);
    }
}
