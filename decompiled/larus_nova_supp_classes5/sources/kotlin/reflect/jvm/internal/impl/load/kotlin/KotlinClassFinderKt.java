package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class KotlinClassFinderKt {
    public static final KotlinJvmBinaryClass findKotlinClass(KotlinClassFinder r1, JavaClass r2, JvmMetadataVersion r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "javaClass");
        Intrinsics.checkNotNullParameter(r3, "jvmMetadataVersion");
        KotlinClassFinder.Result r4 = r1.findKotlinClassOrContent(r2, r3);
        if (r4 != null) goto L7;
        return null;
    L7:
        return r4.toKotlinJvmBinaryClass();
    }

    public static final KotlinJvmBinaryClass findKotlinClass(KotlinClassFinder r1, ClassId r2, JvmMetadataVersion r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "classId");
        Intrinsics.checkNotNullParameter(r3, "jvmMetadataVersion");
        KotlinClassFinder.Result r4 = r1.findKotlinClassOrContent(r2, r3);
        if (r4 != null) goto L7;
        return null;
    L7:
        return r4.toKotlinJvmBinaryClass();
    }
}
