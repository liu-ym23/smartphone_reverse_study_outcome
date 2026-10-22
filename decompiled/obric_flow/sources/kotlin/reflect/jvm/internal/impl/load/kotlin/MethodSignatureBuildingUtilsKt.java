package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public final class MethodSignatureBuildingUtilsKt {
    public static final String signature(SignatureBuildingComponents r5, ClassDescriptor r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "classDescriptor");
        Intrinsics.checkNotNullParameter(r11, "jvmDescriptor");
        return r5.signature(MethodSignatureMappingKt.getInternalName(r10), r11);
    }
}
