package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeComponentPositionKt {
    public static final boolean shouldEnhance(TypeComponentPosition r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10 == TypeComponentPosition.INFLEXIBLE) goto L5;
        return true;
    L5:
        return false;
    }
}
