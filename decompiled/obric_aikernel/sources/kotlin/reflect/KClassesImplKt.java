package kotlin.reflect;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class KClassesImplKt {
    public static final String getQualifiedOrSimpleName(KClass<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getQualifiedName();
    }
}
