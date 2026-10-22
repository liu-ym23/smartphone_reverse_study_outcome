package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ModalityUtilsKt {
    public static final boolean isFinalClass(ClassDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.getModality() == Modality.FINAL) goto L5;
    L7:
        return false;
    L5:
        if (r5.getKind() == ClassKind.ENUM_CLASS) goto L7;
        return true;
    }
}
