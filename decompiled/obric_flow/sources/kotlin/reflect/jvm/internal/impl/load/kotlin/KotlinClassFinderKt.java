package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* JADX INFO: loaded from: classes3.dex */
public final class KotlinClassFinderKt {
    public static final KotlinJvmBinaryClass findKotlinClass(KotlinClassFinder r5, ClassId r10, JvmMetadataVersion r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "classId");
        Intrinsics.checkNotNullParameter(r11, "jvmMetadataVersion");
        KotlinClassFinder.Result r12 = r5.findKotlinClassOrContent(r10, r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return r12.toKotlinJvmBinaryClass();
    }

    public static final KotlinJvmBinaryClass findKotlinClass(KotlinClassFinder r5, JavaClass r10, JvmMetadataVersion r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "javaClass");
        Intrinsics.checkNotNullParameter(r11, "jvmMetadataVersion");
        KotlinClassFinder.Result r12 = r5.findKotlinClassOrContent(r10, r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return r12.toKotlinJvmBinaryClass();
    }
}
