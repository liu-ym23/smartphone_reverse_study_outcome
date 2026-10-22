package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeComponentPositionKt {
    public static final boolean shouldEnhance(TypeComponentPosition r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5 == TypeComponentPosition.INFLEXIBLE) goto L5;
        return true;
    L5:
        return false;
    }
}
