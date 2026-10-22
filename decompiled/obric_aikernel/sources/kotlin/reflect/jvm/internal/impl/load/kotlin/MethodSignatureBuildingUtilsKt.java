package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public final class MethodSignatureBuildingUtilsKt {
    public static final String signature(SignatureBuildingComponents r10, ClassDescriptor r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "classDescriptor");
        Intrinsics.checkNotNullParameter(r12, "jvmDescriptor");
        return r10.signature(MethodSignatureMappingKt.getInternalName(r11), r12);
    }
}
