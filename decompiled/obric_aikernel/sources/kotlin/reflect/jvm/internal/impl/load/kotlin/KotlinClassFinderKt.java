package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* JADX INFO: loaded from: classes3.dex */
public final class KotlinClassFinderKt {
    public static final KotlinJvmBinaryClass findKotlinClass(KotlinClassFinder r10, JavaClass r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "javaClass");
        KotlinClassFinder.Result r12 = r10.findKotlinClassOrContent(r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return r12.toKotlinJvmBinaryClass();
    }

    public static final KotlinJvmBinaryClass findKotlinClass(KotlinClassFinder r10, ClassId r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "classId");
        KotlinClassFinder.Result r12 = r10.findKotlinClassOrContent(r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return r12.toKotlinJvmBinaryClass();
    }
}
