package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class KotlinJvmBinarySourceElement implements DeserializedContainerSource {
    private final DeserializedContainerAbiStability abiStability;
    private final KotlinJvmBinaryClass binaryClass;
    private final IncompatibleVersionErrorData<JvmMetadataVersion> incompatibility;
    private final boolean isPreReleaseInvisible;

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource
    public String getPresentableString() {
        return "Class '" + this.binaryClass.getClassId().asSingleFqName().asString() + '\'';
    }

    public String toString() {
        return "KotlinJvmBinarySourceElement: " + this.binaryClass;
    }

    public final KotlinJvmBinaryClass getBinaryClass() {
        return this.binaryClass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
    public SourceFile getContainingFile() {
        return SourceFile.NO_SOURCE_FILE;
    }

    public KotlinJvmBinarySourceElement(KotlinJvmBinaryClass r2, IncompatibleVersionErrorData<JvmMetadataVersion> r3, boolean r4, DeserializedContainerAbiStability r5) {
        Intrinsics.checkNotNullParameter(r2, "binaryClass");
        Intrinsics.checkNotNullParameter(r5, "abiStability");
        this.binaryClass = r2;
        this.incompatibility = r3;
        this.isPreReleaseInvisible = r4;
        this.abiStability = r5;
    }
}
