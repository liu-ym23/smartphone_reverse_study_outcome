package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ModalityUtilsKt {
    public static final boolean isFinalClass(ClassDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.getModality() == Modality.FINAL) goto L5;
    L7:
        return false;
    L5:
        if (r10.getKind() == ClassKind.ENUM_CLASS) goto L7;
        return true;
    }
}
